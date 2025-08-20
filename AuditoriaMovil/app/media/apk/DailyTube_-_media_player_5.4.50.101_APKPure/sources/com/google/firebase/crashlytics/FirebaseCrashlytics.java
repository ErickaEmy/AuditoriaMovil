package com.google.firebase.crashlytics;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.MissingNativeComponent;
import com.google.firebase.crashlytics.internal.Onboarding;
import com.google.firebase.crashlytics.internal.analytics.BlockingAnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.analytics.BreadcrumbAnalyticsEventReceiver;
import com.google.firebase.crashlytics.internal.analytics.CrashlyticsOriginAnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.analytics.UnavailableAnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.breadcrumbs.DisabledBreadcrumbSource;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.common.ExecutorUtils;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.settings.SettingsController;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class FirebaseCrashlytics {
    private final CrashlyticsCore core;

    private FirebaseCrashlytics(@NonNull CrashlyticsCore crashlyticsCore) {
        this.core = crashlyticsCore;
    }

    @NonNull
    public static FirebaseCrashlytics getInstance() {
        FirebaseCrashlytics firebaseCrashlytics = (FirebaseCrashlytics) FirebaseApp.getInstance().get(FirebaseCrashlytics.class);
        if (firebaseCrashlytics != null) {
            return firebaseCrashlytics;
        }
        throw new NullPointerException("FirebaseCrashlytics component is not present.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver, com.google.firebase.crashlytics.internal.analytics.BreadcrumbAnalyticsEventReceiver] */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.google.firebase.crashlytics.internal.analytics.CrashlyticsOriginAnalyticsEventLogger] */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.google.firebase.crashlytics.CrashlyticsAnalyticsListener] */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver, com.google.firebase.crashlytics.internal.analytics.BlockingAnalyticsEventLogger] */
    @Nullable
    public static FirebaseCrashlytics init(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseInstallationsApi firebaseInstallationsApi, @Nullable CrashlyticsNativeComponent crashlyticsNativeComponent, @Nullable AnalyticsConnector analyticsConnector) {
        MissingNativeComponent missingNativeComponent;
        UnavailableAnalyticsEventLogger unavailableAnalyticsEventLogger;
        DisabledBreadcrumbSource disabledBreadcrumbSource;
        Context applicationContext = firebaseApp.getApplicationContext();
        IdManager idManager = new IdManager(applicationContext, applicationContext.getPackageName(), firebaseInstallationsApi);
        DataCollectionArbiter dataCollectionArbiter = new DataCollectionArbiter(firebaseApp);
        if (crashlyticsNativeComponent == null) {
            missingNativeComponent = new MissingNativeComponent();
        } else {
            missingNativeComponent = crashlyticsNativeComponent;
        }
        final Onboarding onboarding = new Onboarding(firebaseApp, applicationContext, idManager, dataCollectionArbiter);
        if (analyticsConnector != null) {
            Logger.getLogger().d("Firebase Analytics is available.");
            ?? crashlyticsOriginAnalyticsEventLogger = new CrashlyticsOriginAnalyticsEventLogger(analyticsConnector);
            ?? crashlyticsAnalyticsListener = new CrashlyticsAnalyticsListener();
            if (subscribeToAnalyticsEvents(analyticsConnector, crashlyticsAnalyticsListener) != null) {
                Logger.getLogger().d("Firebase Analytics listener registered successfully.");
                ?? breadcrumbAnalyticsEventReceiver = new BreadcrumbAnalyticsEventReceiver();
                ?? blockingAnalyticsEventLogger = new BlockingAnalyticsEventLogger(crashlyticsOriginAnalyticsEventLogger, 500, TimeUnit.MILLISECONDS);
                crashlyticsAnalyticsListener.setBreadcrumbEventReceiver(breadcrumbAnalyticsEventReceiver);
                crashlyticsAnalyticsListener.setCrashlyticsOriginEventReceiver(blockingAnalyticsEventLogger);
                unavailableAnalyticsEventLogger = blockingAnalyticsEventLogger;
                disabledBreadcrumbSource = breadcrumbAnalyticsEventReceiver;
            } else {
                Logger.getLogger().d("Firebase Analytics listener registration failed.");
                disabledBreadcrumbSource = new DisabledBreadcrumbSource();
                unavailableAnalyticsEventLogger = crashlyticsOriginAnalyticsEventLogger;
            }
        } else {
            Logger.getLogger().d("Firebase Analytics is unavailable.");
            disabledBreadcrumbSource = new DisabledBreadcrumbSource();
            unavailableAnalyticsEventLogger = new UnavailableAnalyticsEventLogger();
        }
        final CrashlyticsCore crashlyticsCore = new CrashlyticsCore(firebaseApp, idManager, missingNativeComponent, dataCollectionArbiter, disabledBreadcrumbSource, unavailableAnalyticsEventLogger, ExecutorUtils.buildSingleThreadExecutorService("Crashlytics Exception Handler"));
        if (!onboarding.onPreExecute()) {
            Logger.getLogger().e("Unable to start Crashlytics.");
            return null;
        }
        final ExecutorService buildSingleThreadExecutorService = ExecutorUtils.buildSingleThreadExecutorService("com.google.firebase.crashlytics.startup");
        final SettingsController retrieveSettingsData = onboarding.retrieveSettingsData(applicationContext, firebaseApp, buildSingleThreadExecutorService);
        final boolean onPreExecute = crashlyticsCore.onPreExecute(retrieveSettingsData);
        Tasks.call(buildSingleThreadExecutorService, new Callable<Void>() { // from class: com.google.firebase.crashlytics.FirebaseCrashlytics.1
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                Onboarding.this.doOnboarding(buildSingleThreadExecutorService, retrieveSettingsData);
                if (onPreExecute) {
                    crashlyticsCore.doBackgroundInitializationAsync(retrieveSettingsData);
                    return null;
                }
                return null;
            }
        });
        return new FirebaseCrashlytics(crashlyticsCore);
    }

    private static AnalyticsConnector.AnalyticsConnectorHandle subscribeToAnalyticsEvents(@NonNull AnalyticsConnector analyticsConnector, @NonNull CrashlyticsAnalyticsListener crashlyticsAnalyticsListener) {
        AnalyticsConnector.AnalyticsConnectorHandle registerAnalyticsConnectorListener = analyticsConnector.registerAnalyticsConnectorListener("clx", crashlyticsAnalyticsListener);
        if (registerAnalyticsConnectorListener == null) {
            Logger.getLogger().d("Could not register AnalyticsConnectorListener with Crashlytics origin.");
            registerAnalyticsConnectorListener = analyticsConnector.registerAnalyticsConnectorListener("crash", crashlyticsAnalyticsListener);
            if (registerAnalyticsConnectorListener != null) {
                Logger.getLogger().w("A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.");
            }
        }
        return registerAnalyticsConnectorListener;
    }

    @NonNull
    public Task<Boolean> checkForUnsentReports() {
        return this.core.checkForUnsentReports();
    }

    public void deleteUnsentReports() {
        this.core.deleteUnsentReports();
    }

    public boolean didCrashOnPreviousExecution() {
        return this.core.didCrashOnPreviousExecution();
    }

    public void log(@NonNull String str) {
        this.core.log(str);
    }

    public void recordException(@NonNull Throwable th) {
        if (th == null) {
            Logger.getLogger().w("Crashlytics is ignoring a request to log a null exception.");
        } else {
            this.core.logException(th);
        }
    }

    public void sendUnsentReports() {
        this.core.sendUnsentReports();
    }

    public void setCrashlyticsCollectionEnabled(boolean z2) {
        this.core.setCrashlyticsCollectionEnabled(Boolean.valueOf(z2));
    }

    public void setCustomKey(@NonNull String str, boolean z2) {
        this.core.setCustomKey(str, Boolean.toString(z2));
    }

    public void setUserId(@NonNull String str) {
        this.core.setUserId(str);
    }

    public void setCrashlyticsCollectionEnabled(@Nullable Boolean bool) {
        this.core.setCrashlyticsCollectionEnabled(bool);
    }

    public void setCustomKey(@NonNull String str, double d2) {
        this.core.setCustomKey(str, Double.toString(d2));
    }

    public void setCustomKey(@NonNull String str, float f4) {
        this.core.setCustomKey(str, Float.toString(f4));
    }

    public void setCustomKey(@NonNull String str, int i) {
        this.core.setCustomKey(str, Integer.toString(i));
    }

    public void setCustomKey(@NonNull String str, long j2) {
        this.core.setCustomKey(str, Long.toString(j2));
    }

    public void setCustomKey(@NonNull String str, @NonNull String str2) {
        this.core.setCustomKey(str, str2);
    }
}
