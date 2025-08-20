package com.google.firebase.crashlytics.internal.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.internal.Logger;
/* loaded from: classes.dex */
public class DataCollectionArbiter {
    @Nullable
    private Boolean crashlyticsDataCollectionEnabled;
    TaskCompletionSource<Void> dataCollectionEnabledTask;
    private TaskCompletionSource<Void> dataCollectionExplicitlyApproved;
    private final FirebaseApp firebaseApp;
    private boolean setInManifest;
    private final SharedPreferences sharedPreferences;
    private final Object taskLock;
    boolean taskResolved;

    public DataCollectionArbiter(FirebaseApp firebaseApp) {
        Object obj = new Object();
        this.taskLock = obj;
        this.dataCollectionEnabledTask = new TaskCompletionSource<>();
        this.taskResolved = false;
        this.setInManifest = false;
        this.dataCollectionExplicitlyApproved = new TaskCompletionSource<>();
        Context applicationContext = firebaseApp.getApplicationContext();
        this.firebaseApp = firebaseApp;
        this.sharedPreferences = CommonUtils.getSharedPrefs(applicationContext);
        Boolean dataCollectionValueFromSharedPreferences = getDataCollectionValueFromSharedPreferences();
        this.crashlyticsDataCollectionEnabled = dataCollectionValueFromSharedPreferences == null ? getDataCollectionValueFromManifest(applicationContext) : dataCollectionValueFromSharedPreferences;
        synchronized (obj) {
            try {
                if (isAutomaticDataCollectionEnabled()) {
                    this.dataCollectionEnabledTask.trySetResult(null);
                    this.taskResolved = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    private Boolean getDataCollectionValueFromManifest(Context context) {
        Boolean readCrashlyticsDataCollectionEnabledFromManifest = readCrashlyticsDataCollectionEnabledFromManifest(context);
        if (readCrashlyticsDataCollectionEnabledFromManifest == null) {
            this.setInManifest = false;
            return null;
        }
        this.setInManifest = true;
        return Boolean.valueOf(Boolean.TRUE.equals(readCrashlyticsDataCollectionEnabledFromManifest));
    }

    @Nullable
    private Boolean getDataCollectionValueFromSharedPreferences() {
        if (this.sharedPreferences.contains("firebase_crashlytics_collection_enabled")) {
            this.setInManifest = false;
            return Boolean.valueOf(this.sharedPreferences.getBoolean("firebase_crashlytics_collection_enabled", true));
        }
        return null;
    }

    private void logDataCollectionState(boolean z2) {
        String str;
        String str2;
        if (z2) {
            str = "ENABLED";
        } else {
            str = "DISABLED";
        }
        if (this.crashlyticsDataCollectionEnabled == null) {
            str2 = "global Firebase setting";
        } else if (this.setInManifest) {
            str2 = "firebase_crashlytics_collection_enabled manifest flag";
        } else {
            str2 = "API";
        }
        Logger.getLogger().d(String.format("Crashlytics automatic data collection %s by %s.", str, str2));
    }

    @Nullable
    private static Boolean readCrashlyticsDataCollectionEnabledFromManifest(Context context) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), NotificationCompat.FLAG_HIGH_PRIORITY)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("firebase_crashlytics_collection_enabled")) {
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_crashlytics_collection_enabled"));
            }
            return null;
        } catch (PackageManager.NameNotFoundException e2) {
            Logger.getLogger().d("Unable to get PackageManager. Falling through", e2);
            return null;
        }
    }

    @SuppressLint({"ApplySharedPref"})
    private static void storeDataCollectionValueInSharedPreferences(SharedPreferences sharedPreferences, Boolean bool) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (bool != null) {
            edit.putBoolean("firebase_crashlytics_collection_enabled", bool.booleanValue());
        } else {
            edit.remove("firebase_crashlytics_collection_enabled");
        }
        edit.commit();
    }

    public void grantDataCollectionPermission(boolean z2) {
        if (z2) {
            this.dataCollectionExplicitlyApproved.trySetResult(null);
            return;
        }
        throw new IllegalStateException("An invalid data collection token was used.");
    }

    public synchronized boolean isAutomaticDataCollectionEnabled() {
        boolean isDataCollectionDefaultEnabled;
        try {
            Boolean bool = this.crashlyticsDataCollectionEnabled;
            if (bool != null) {
                isDataCollectionDefaultEnabled = bool.booleanValue();
            } else {
                isDataCollectionDefaultEnabled = this.firebaseApp.isDataCollectionDefaultEnabled();
            }
            logDataCollectionState(isDataCollectionDefaultEnabled);
        } catch (Throwable th) {
            throw th;
        }
        return isDataCollectionDefaultEnabled;
    }

    public synchronized void setCrashlyticsDataCollectionEnabled(@Nullable Boolean bool) {
        Boolean dataCollectionValueFromManifest;
        if (bool != null) {
            try {
                this.setInManifest = false;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (bool != null) {
            dataCollectionValueFromManifest = bool;
        } else {
            dataCollectionValueFromManifest = getDataCollectionValueFromManifest(this.firebaseApp.getApplicationContext());
        }
        this.crashlyticsDataCollectionEnabled = dataCollectionValueFromManifest;
        storeDataCollectionValueInSharedPreferences(this.sharedPreferences, bool);
        synchronized (this.taskLock) {
            if (isAutomaticDataCollectionEnabled()) {
                if (!this.taskResolved) {
                    this.dataCollectionEnabledTask.trySetResult(null);
                    this.taskResolved = true;
                }
            } else if (this.taskResolved) {
                this.dataCollectionEnabledTask = new TaskCompletionSource<>();
                this.taskResolved = false;
            }
        }
    }

    public Task<Void> waitForAutomaticDataCollectionEnabled() {
        Task<Void> task;
        synchronized (this.taskLock) {
            task = this.dataCollectionEnabledTask.getTask();
        }
        return task;
    }

    public Task<Void> waitForDataCollectionPermission() {
        return Utils.race(this.dataCollectionExplicitlyApproved.getTask(), waitForAutomaticDataCollectionEnabled());
    }
}
