package com.facebook.ads.redexgen.X;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.internal.api.AudienceNetworkRemoteServiceApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.settings.MultithreadedBundleWrapper;
import com.facebook.ads.internal.util.process.ProcessUtils;
/* renamed from: com.facebook.ads.redexgen.X.Iw  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0718Iw implements AudienceNetworkRemoteServiceApi {
    public Messenger A00;
    public final Service A01;

    public C0718Iw(Service service) {
        this.A01 = service;
    }

    public final IBinder onBind(Intent intent) {
        Messenger messenger = this.A00;
        if (messenger == null) {
            return null;
        }
        return messenger.getBinder();
    }

    public final void onCreate() {
        ProcessUtils.setRemoteRenderingProcess(true);
        DynamicLoaderFactory.makeLoader(this.A01).getInitApi().initialize(this.A01, (MultithreadedBundleWrapper) null, (AudienceNetworkAds.InitListener) null, 2);
        this.A00 = new Messenger(new HandlerC0719Ix(this.A01.getApplicationContext()));
    }

    public final void onDestroy() {
        VW.A00().A06();
    }
}
