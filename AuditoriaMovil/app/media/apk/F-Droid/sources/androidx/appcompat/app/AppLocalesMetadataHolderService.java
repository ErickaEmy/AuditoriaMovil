package androidx.appcompat.app;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ServiceInfo;
import android.os.Build;
/* loaded from: classes.dex */
public abstract class AppLocalesMetadataHolderService extends Service {

    /* loaded from: classes.dex */
    private static class Api24Impl {
        static int getDisabledComponentFlag() {
            return 512;
        }
    }

    public static ServiceInfo getServiceInfo(Context context) {
        return context.getPackageManager().getServiceInfo(new ComponentName(context, AppLocalesMetadataHolderService.class), Build.VERSION.SDK_INT >= 24 ? Api24Impl.getDisabledComponentFlag() | 128 : 640);
    }
}
