package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.Logger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class BlockingAnalyticsEventLogger implements AnalyticsEventReceiver, AnalyticsEventLogger {
    private final CrashlyticsOriginAnalyticsEventLogger baseAnalyticsEventLogger;
    private CountDownLatch eventLatch;
    private final TimeUnit timeUnit;
    private final int timeout;
    private final Object latchLock = new Object();
    private boolean callbackReceived = false;

    public BlockingAnalyticsEventLogger(@NonNull CrashlyticsOriginAnalyticsEventLogger crashlyticsOriginAnalyticsEventLogger, int i, TimeUnit timeUnit) {
        this.baseAnalyticsEventLogger = crashlyticsOriginAnalyticsEventLogger;
        this.timeout = i;
        this.timeUnit = timeUnit;
    }

    public boolean isCallbackReceived() {
        return this.callbackReceived;
    }

    @Override // com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger
    public void logEvent(@NonNull String str, @Nullable Bundle bundle) {
        synchronized (this.latchLock) {
            try {
                Logger.getLogger().d("Logging Crashlytics event to Firebase");
                this.eventLatch = new CountDownLatch(1);
                this.callbackReceived = false;
                this.baseAnalyticsEventLogger.logEvent(str, bundle);
                Logger.getLogger().d("Awaiting app exception callback from FA...");
                try {
                    if (this.eventLatch.await(this.timeout, this.timeUnit)) {
                        this.callbackReceived = true;
                        Logger.getLogger().d("App exception callback received from FA listener.");
                    } else {
                        Logger.getLogger().d("Timeout exceeded while awaiting app exception callback from FA listener.");
                    }
                } catch (InterruptedException unused) {
                    Logger.getLogger().d("Interrupted while awaiting app exception callback from FA listener.");
                }
                this.eventLatch = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver
    public void onEvent(@NonNull String str, @NonNull Bundle bundle) {
        CountDownLatch countDownLatch = this.eventLatch;
        if (countDownLatch != null && "_ae".equals(str)) {
            countDownLatch.countDown();
        }
    }
}
