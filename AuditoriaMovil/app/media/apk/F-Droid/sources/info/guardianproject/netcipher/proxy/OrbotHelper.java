package info.guardianproject.netcipher.proxy;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
/* loaded from: classes.dex */
public abstract class OrbotHelper {
    public static boolean isOrbotInstalled(Context context) {
        return isAppInstalled(context, "org.torproject.android");
    }

    public static boolean isTorServicesInstalled(Context context) {
        return isAppInstalled(context, "org.torproject.torservices");
    }

    private static boolean isAppInstalled(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean requestStartTor(final Context context) {
        Intent torStartIntent = getTorStartIntent(context);
        String str = torStartIntent.getPackage();
        if (str == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 26) {
            context.sendBroadcast(torStartIntent);
        } else if ("org.torproject.torservices".equals(str)) {
            torStartIntent.setComponent(new ComponentName("org.torproject.torservices", "org.torproject.torservices.WakeUpService"));
            context.bindService(torStartIntent, new ServiceConnection() { // from class: info.guardianproject.netcipher.proxy.OrbotHelper.1
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    Context context2 = context;
                    context2.sendBroadcast(OrbotHelper.getTorStartIntent(context2));
                    context.unbindService(this);
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    Context context2 = context;
                    context2.sendBroadcast(OrbotHelper.getTorStartIntent(context2));
                }
            }, 1);
        } else if (!"org.torproject.android".equals(str)) {
            return false;
        } else {
            context.sendBroadcast(torStartIntent);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.content.Intent getOrbotInstallIntent(android.content.Context r4) {
        /*
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "android.intent.action.VIEW"
            r0.<init>(r1)
            java.lang.String r1 = "market://details?id=org.torproject.android"
            android.net.Uri r1 = android.net.Uri.parse(r1)
            r0.setData(r1)
            android.content.pm.PackageManager r4 = r4.getPackageManager()
            r1 = 0
            java.util.List r4 = r4.queryIntentActivities(r0, r1)
            java.util.Iterator r4 = r4.iterator()
        L1d:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L60
            java.lang.Object r1 = r4.next()
            android.content.pm.ResolveInfo r1 = (android.content.pm.ResolveInfo) r1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "market: "
            r2.append(r3)
            android.content.pm.ActivityInfo r3 = r1.activityInfo
            java.lang.String r3 = r3.packageName
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "OrbotHelper"
            android.util.Log.i(r3, r2)
            android.content.pm.ActivityInfo r2 = r1.activityInfo
            java.lang.String r2 = r2.packageName
            java.lang.String r3 = "org.fdroid.fdroid"
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 != 0) goto L5b
            android.content.pm.ActivityInfo r2 = r1.activityInfo
            java.lang.String r2 = r2.packageName
            java.lang.String r3 = "com.android.vending"
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L1d
        L5b:
            android.content.pm.ActivityInfo r4 = r1.activityInfo
            java.lang.String r4 = r4.packageName
            goto L61
        L60:
            r4 = 0
        L61:
            if (r4 != 0) goto L6d
            java.lang.String r4 = "https://f-droid.org/repository/browse/?fdid=org.torproject.android"
            android.net.Uri r4 = android.net.Uri.parse(r4)
            r0.setData(r4)
            goto L70
        L6d:
            r0.setPackage(r4)
        L70:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: info.guardianproject.netcipher.proxy.OrbotHelper.getOrbotInstallIntent(android.content.Context):android.content.Intent");
    }

    public static Intent getTorStartIntent(Context context) {
        Intent intent = new Intent("org.torproject.android.intent.action.START");
        intent.putExtra("org.torproject.android.intent.extra.PACKAGE_NAME", context.getPackageName());
        if (isTorServicesInstalled(context)) {
            intent.setPackage("org.torproject.torservices");
        } else if (isOrbotInstalled(context)) {
            intent.setPackage("org.torproject.android");
        }
        return intent;
    }
}
