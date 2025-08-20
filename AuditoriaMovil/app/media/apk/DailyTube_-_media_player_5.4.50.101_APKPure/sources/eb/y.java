package eb;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import android.view.KeyEvent;
import java.util.List;
/* loaded from: classes.dex */
public class y extends BroadcastReceiver {

    /* renamed from: eb.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0090y extends MediaBrowserCompat.zn {

        /* renamed from: a  reason: collision with root package name */
        public MediaBrowserCompat f7590a;

        /* renamed from: gv  reason: collision with root package name */
        public final Intent f7591gv;

        /* renamed from: v  reason: collision with root package name */
        public final BroadcastReceiver.PendingResult f7592v;

        /* renamed from: zn  reason: collision with root package name */
        public final Context f7593zn;

        public C0090y(Context context, Intent intent, BroadcastReceiver.PendingResult pendingResult) {
            this.f7593zn = context;
            this.f7591gv = intent;
            this.f7592v = pendingResult;
        }

        public void a(MediaBrowserCompat mediaBrowserCompat) {
            this.f7590a = mediaBrowserCompat;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.zn
        public void n3() {
            v();
        }

        public final void v() {
            this.f7590a.n3();
            this.f7592v.finish();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.zn
        public void y() {
            new MediaControllerCompat(this.f7593zn, this.f7590a.zn()).y((KeyEvent) this.f7591gv.getParcelableExtra("android.intent.extra.KEY_EVENT"));
            v();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.zn
        public void zn() {
            v();
        }
    }

    public static ComponentName n3(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices.size() == 1) {
            ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
            return new ComponentName(serviceInfo.packageName, serviceInfo.name);
        } else if (queryIntentServices.isEmpty()) {
            return null;
        } else {
            throw new IllegalStateException("Expected 1 service that handles " + str + ", found " + queryIntentServices.size());
        }
    }

    public static ComponentName y(Context context) {
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers.size() == 1) {
            ActivityInfo activityInfo = queryBroadcastReceivers.get(0).activityInfo;
            return new ComponentName(activityInfo.packageName, activityInfo.name);
        } else if (queryBroadcastReceivers.size() > 1) {
            Log.w("MediaButtonReceiver", "More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, returning null.");
            return null;
        } else {
            return null;
        }
    }

    public static KeyEvent zn(MediaSessionCompat mediaSessionCompat, Intent intent) {
        if (mediaSessionCompat != null && intent != null && "android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) && intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            KeyEvent keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
            mediaSessionCompat.n3().y(keyEvent);
            return keyEvent;
        }
        return null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && "android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) && intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            ComponentName n32 = n3(context, "android.intent.action.MEDIA_BUTTON");
            if (n32 != null) {
                intent.setComponent(n32);
                mg.y.w(context, intent);
                return;
            }
            ComponentName n33 = n3(context, "android.media.browse.MediaBrowserService");
            if (n33 != null) {
                BroadcastReceiver.PendingResult goAsync = goAsync();
                Context applicationContext = context.getApplicationContext();
                C0090y c0090y = new C0090y(applicationContext, intent, goAsync);
                MediaBrowserCompat mediaBrowserCompat = new MediaBrowserCompat(applicationContext, n33, c0090y, null);
                c0090y.a(mediaBrowserCompat);
                mediaBrowserCompat.y();
                return;
            }
            throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
        }
    }
}
