package com.google.firebase.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.events.Event;
import com.google.firebase.events.Publisher;
import mg.y;
/* loaded from: classes.dex */
public class DataCollectionConfigStorage {
    private boolean dataCollectionDefaultEnabled;
    private final Context deviceProtectedContext;
    private final Publisher publisher;
    private final SharedPreferences sharedPreferences;

    public DataCollectionConfigStorage(Context context, String str, Publisher publisher) {
        Context directBootSafe = directBootSafe(context);
        this.deviceProtectedContext = directBootSafe;
        this.sharedPreferences = directBootSafe.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
        this.publisher = publisher;
        this.dataCollectionDefaultEnabled = readAutoDataCollectionEnabled();
    }

    private static Context directBootSafe(Context context) {
        if (Build.VERSION.SDK_INT < 24) {
            return context;
        }
        return y.n3(context);
    }

    private boolean readAutoDataCollectionEnabled() {
        if (this.sharedPreferences.contains("firebase_data_collection_default_enabled")) {
            return this.sharedPreferences.getBoolean("firebase_data_collection_default_enabled", true);
        }
        return readManifestDataCollectionEnabled();
    }

    private boolean readManifestDataCollectionEnabled() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = this.deviceProtectedContext.getPackageManager();
            if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(this.deviceProtectedContext.getPackageName(), NotificationCompat.FLAG_HIGH_PRIORITY)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("firebase_data_collection_default_enabled")) {
                return applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }

    private synchronized void updateDataCollectionDefaultEnabled(boolean z2) {
        if (this.dataCollectionDefaultEnabled != z2) {
            this.dataCollectionDefaultEnabled = z2;
            this.publisher.publish(new Event<>(DataCollectionDefaultChange.class, new DataCollectionDefaultChange(z2)));
        }
    }

    public synchronized boolean isEnabled() {
        return this.dataCollectionDefaultEnabled;
    }

    public synchronized void setEnabled(Boolean bool) {
        try {
            if (bool == null) {
                this.sharedPreferences.edit().remove("firebase_data_collection_default_enabled").apply();
                updateDataCollectionDefaultEnabled(readManifestDataCollectionEnabled());
            } else {
                boolean equals = Boolean.TRUE.equals(bool);
                this.sharedPreferences.edit().putBoolean("firebase_data_collection_default_enabled", equals).apply();
                updateDataCollectionDefaultEnabled(equals);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
