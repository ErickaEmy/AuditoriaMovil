package org.acra.sender;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;
import org.acra.config.CoreConfiguration;
import org.acra.util.IOUtils;
/* compiled from: LegacySenderService.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¨\u0006\f"}, d2 = {"Lorg/acra/sender/LegacySenderService;", "Landroid/app/Service;", "()V", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onStartCommand", "", "flags", "startId", "Companion", "acra-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LegacySenderService extends Service {
    public static final Companion Companion = new Companion(null);

    /* compiled from: LegacySenderService.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, int i, int i2) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (!intent.hasExtra("acraConfig")) {
            if (ACRA.DEV_LOGGING) {
                ACRA.log.d(ACRA.LOG_TAG, "SenderService was started but no valid intent was delivered, will now quit");
                return 3;
            }
            return 3;
        }
        final CoreConfiguration coreConfiguration = (CoreConfiguration) IOUtils.INSTANCE.deserialize(CoreConfiguration.class, intent.getStringExtra("acraConfig"));
        if (coreConfiguration != null) {
            new Thread(new Runnable() { // from class: org.acra.sender.LegacySenderService$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    LegacySenderService.onStartCommand$lambda$0(LegacySenderService.this, coreConfiguration, intent);
                }
            }).start();
            return 3;
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStartCommand$lambda$0(LegacySenderService this$0, CoreConfiguration coreConfiguration, Intent intent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(intent, "$intent");
        SendingConductor sendingConductor = new SendingConductor(this$0, coreConfiguration);
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        sendingConductor.sendReports(false, extras);
        this$0.stopSelf();
    }
}
