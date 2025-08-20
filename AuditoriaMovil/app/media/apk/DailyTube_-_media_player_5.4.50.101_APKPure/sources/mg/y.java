package mg;

import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.AppOpsManager;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.app.UiModeManager;
import android.app.WallpaperManager;
import android.app.admin.DevicePolicyManager;
import android.app.job.JobScheduler;
import android.app.usage.UsageStatsManager;
import android.appwidget.AppWidgetManager;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.RestrictionsManager;
import android.content.pm.LauncherApps;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.hardware.ConsumerIrManager;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraManager;
import android.hardware.display.DisplayManager;
import android.hardware.input.InputManager;
import android.hardware.usb.UsbManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaRouter;
import android.media.projection.MediaProjectionManager;
import android.media.session.MediaSessionManager;
import android.media.tv.TvInputManager;
import android.net.ConnectivityManager;
import android.net.nsd.NsdManager;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.NfcManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.os.Handler;
import android.os.PowerManager;
import android.os.Process;
import android.os.UserManager;
import android.os.Vibrator;
import android.os.storage.StorageManager;
import android.print.PrintManager;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.CaptioningManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationManagerCompat;
import com.hjq.permissions.Permission;
import java.io.File;
import java.util.HashMap;
@SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: classes.dex */
public class y {
    public static final Object y = new Object();

    /* renamed from: n3  reason: collision with root package name */
    public static final Object f11473n3 = new Object();

    /* loaded from: classes.dex */
    public static class a {
        public static ComponentName n3(Context context, Intent intent) {
            return context.startForegroundService(intent);
        }

        public static Intent y(Context context, @Nullable BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i) {
            if ((i & 4) != 0 && str == null) {
                return context.registerReceiver(broadcastReceiver, intentFilter, y.f(context), handler);
            }
            return context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i & 1);
        }
    }

    /* loaded from: classes.dex */
    public static class fb {
        public static Intent y(Context context, @Nullable BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i) {
            return context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i);
        }
    }

    /* loaded from: classes.dex */
    public static class gv {
        public static <T> T n3(Context context, Class<T> cls) {
            return (T) context.getSystemService(cls);
        }

        public static int y(Context context, int i) {
            return context.getColor(i);
        }

        public static String zn(Context context, Class<?> cls) {
            return context.getSystemServiceName(cls);
        }
    }

    /* loaded from: classes.dex */
    public static class n3 {
        public static File[] n3(Context context, String str) {
            return context.getExternalFilesDirs(str);
        }

        public static File[] y(Context context) {
            return context.getExternalCacheDirs();
        }

        public static File[] zn(Context context) {
            return context.getObbDirs();
        }
    }

    /* loaded from: classes.dex */
    public static final class s {
        public static final HashMap<Class<?>, String> y;

        static {
            HashMap<Class<?>, String> hashMap = new HashMap<>();
            y = hashMap;
            if (Build.VERSION.SDK_INT >= 22) {
                hashMap.put(SubscriptionManager.class, "telephony_subscription_service");
                hashMap.put(UsageStatsManager.class, "usagestats");
            }
            hashMap.put(AppWidgetManager.class, "appwidget");
            hashMap.put(BatteryManager.class, "batterymanager");
            hashMap.put(CameraManager.class, "camera");
            hashMap.put(JobScheduler.class, "jobscheduler");
            hashMap.put(LauncherApps.class, "launcherapps");
            hashMap.put(MediaProjectionManager.class, "media_projection");
            hashMap.put(MediaSessionManager.class, "media_session");
            hashMap.put(RestrictionsManager.class, "restrictions");
            hashMap.put(TelecomManager.class, "telecom");
            hashMap.put(TvInputManager.class, "tv_input");
            hashMap.put(AppOpsManager.class, "appops");
            hashMap.put(CaptioningManager.class, "captioning");
            hashMap.put(ConsumerIrManager.class, "consumer_ir");
            hashMap.put(PrintManager.class, "print");
            hashMap.put(BluetoothManager.class, "bluetooth");
            hashMap.put(DisplayManager.class, "display");
            hashMap.put(UserManager.class, "user");
            hashMap.put(InputManager.class, "input");
            hashMap.put(MediaRouter.class, "media_router");
            hashMap.put(NsdManager.class, "servicediscovery");
            hashMap.put(AccessibilityManager.class, "accessibility");
            hashMap.put(AccountManager.class, "account");
            hashMap.put(ActivityManager.class, "activity");
            hashMap.put(AlarmManager.class, "alarm");
            hashMap.put(AudioManager.class, "audio");
            hashMap.put(ClipboardManager.class, "clipboard");
            hashMap.put(ConnectivityManager.class, "connectivity");
            hashMap.put(DevicePolicyManager.class, "device_policy");
            hashMap.put(DownloadManager.class, "download");
            hashMap.put(DropBoxManager.class, "dropbox");
            hashMap.put(InputMethodManager.class, "input_method");
            hashMap.put(KeyguardManager.class, "keyguard");
            hashMap.put(LayoutInflater.class, "layout_inflater");
            hashMap.put(LocationManager.class, "location");
            hashMap.put(NfcManager.class, "nfc");
            hashMap.put(NotificationManager.class, "notification");
            hashMap.put(PowerManager.class, "power");
            hashMap.put(SearchManager.class, "search");
            hashMap.put(SensorManager.class, "sensor");
            hashMap.put(StorageManager.class, "storage");
            hashMap.put(TelephonyManager.class, "phone");
            hashMap.put(TextServicesManager.class, "textservices");
            hashMap.put(UiModeManager.class, "uimode");
            hashMap.put(UsbManager.class, "usb");
            hashMap.put(Vibrator.class, "vibrator");
            hashMap.put(WallpaperManager.class, "wallpaper");
            hashMap.put(WifiP2pManager.class, "wifip2p");
            hashMap.put(WifiManager.class, "wifi");
            hashMap.put(WindowManager.class, "window");
        }
    }

    /* loaded from: classes.dex */
    public static class v {
        public static File n3(Context context) {
            return context.getDataDir();
        }

        public static Context y(Context context) {
            return context.createDeviceProtectedStorageContext();
        }

        public static boolean zn(Context context) {
            return context.isDeviceProtectedStorage();
        }
    }

    /* renamed from: mg.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0154y {
        public static void n3(Context context, Intent intent, Bundle bundle) {
            context.startActivity(intent, bundle);
        }

        public static void y(Context context, Intent[] intentArr, Bundle bundle) {
            context.startActivities(intentArr, bundle);
        }
    }

    /* loaded from: classes.dex */
    public static class zn {
        public static Drawable n3(Context context, int i) {
            return context.getDrawable(i);
        }

        public static File y(Context context) {
            return context.getCodeCacheDir();
        }

        public static File zn(Context context) {
            return context.getNoBackupFilesDir();
        }
    }

    @NonNull
    public static File[] a(@NonNull Context context) {
        return n3.y(context);
    }

    @Nullable
    public static <T> T c5(@NonNull Context context, @NonNull Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 23) {
            return (T) gv.n3(context, cls);
        }
        String i92 = i9(context, cls);
        if (i92 != null) {
            return (T) context.getSystemService(i92);
        }
        return null;
    }

    public static String f(Context context) {
        String str = context.getPackageName() + ".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION";
        if (mg.zn.zn(context, str) == 0) {
            return str;
        }
        throw new RuntimeException("Permission " + str + " is required by your application to receive broadcasts, please add it to your manifest");
    }

    @NonNull
    public static File[] fb(@NonNull Context context, @Nullable String str) {
        return n3.n3(context, str);
    }

    @Nullable
    public static ColorStateList gv(@NonNull Context context, int i) {
        return d.s.gv(context.getResources(), i, context.getTheme());
    }

    @Nullable
    public static String i9(@NonNull Context context, @NonNull Class<?> cls) {
        if (Build.VERSION.SDK_INT >= 23) {
            return gv.zn(context, cls);
        }
        return s.y.get(cls);
    }

    @Nullable
    public static Context n3(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return v.y(context);
        }
        return null;
    }

    @Nullable
    public static File s(@NonNull Context context) {
        return zn.zn(context);
    }

    @Nullable
    public static Intent t(@NonNull Context context, @Nullable BroadcastReceiver broadcastReceiver, @NonNull IntentFilter intentFilter, int i) {
        return tl(context, broadcastReceiver, intentFilter, null, null, i);
    }

    @Nullable
    public static Intent tl(@NonNull Context context, @Nullable BroadcastReceiver broadcastReceiver, @NonNull IntentFilter intentFilter, @Nullable String str, @Nullable Handler handler, int i) {
        int i5 = i & 1;
        if (i5 != 0 && (i & 4) != 0) {
            throw new IllegalArgumentException("Cannot specify both RECEIVER_VISIBLE_TO_INSTANT_APPS and RECEIVER_NOT_EXPORTED");
        }
        if (i5 != 0) {
            i |= 2;
        }
        int i6 = i;
        int i8 = i6 & 2;
        if (i8 == 0 && (i6 & 4) == 0) {
            throw new IllegalArgumentException("One of either RECEIVER_EXPORTED or RECEIVER_NOT_EXPORTED is required");
        }
        if (i8 != 0 && (i6 & 4) != 0) {
            throw new IllegalArgumentException("Cannot specify both RECEIVER_EXPORTED and RECEIVER_NOT_EXPORTED");
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 33) {
            return fb.y(context, broadcastReceiver, intentFilter, str, handler, i6);
        }
        if (i10 >= 26) {
            return a.y(context, broadcastReceiver, intentFilter, str, handler, i6);
        }
        if ((i6 & 4) != 0 && str == null) {
            return context.registerReceiver(broadcastReceiver, intentFilter, f(context), handler);
        }
        return context.registerReceiver(broadcastReceiver, intentFilter, str, handler);
    }

    @Nullable
    public static Drawable v(@NonNull Context context, int i) {
        return zn.n3(context, i);
    }

    public static void w(@NonNull Context context, @NonNull Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            a.n3(context, intent);
        } else {
            context.startService(intent);
        }
    }

    public static boolean wz(@NonNull Context context, @NonNull Intent[] intentArr, @Nullable Bundle bundle) {
        C0154y.y(context, intentArr, bundle);
        return true;
    }

    public static void xc(@NonNull Context context, @NonNull Intent intent, @Nullable Bundle bundle) {
        C0154y.n3(context, intent, bundle);
    }

    public static int y(@NonNull Context context, @NonNull String str) {
        vl.zn.gv(str, "permission must be non-null");
        if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(Permission.POST_NOTIFICATIONS, str)) {
            if (NotificationManagerCompat.from(context).areNotificationsEnabled()) {
                return 0;
            }
            return -1;
        }
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    public static int zn(@NonNull Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return gv.y(context, i);
        }
        return context.getResources().getColor(i);
    }
}
