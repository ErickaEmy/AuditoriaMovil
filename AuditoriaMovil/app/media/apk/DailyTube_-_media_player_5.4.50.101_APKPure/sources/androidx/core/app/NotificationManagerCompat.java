package androidx.core.app;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import zn.y;
/* loaded from: classes.dex */
public final class NotificationManagerCompat {

    /* renamed from: fb  reason: collision with root package name */
    public static gv f2286fb;

    /* renamed from: gv  reason: collision with root package name */
    public static String f2287gv;

    /* renamed from: n3  reason: collision with root package name */
    public final NotificationManager f2290n3;
    public final Context y;

    /* renamed from: zn  reason: collision with root package name */
    public static final Object f2289zn = new Object();

    /* renamed from: v  reason: collision with root package name */
    public static Set<String> f2288v = new HashSet();

    /* renamed from: a  reason: collision with root package name */
    public static final Object f2285a = new Object();

    /* loaded from: classes.dex */
    public static class gv implements Handler.Callback, ServiceConnection {

        /* renamed from: fb  reason: collision with root package name */
        public final Handler f2292fb;

        /* renamed from: v  reason: collision with root package name */
        public final HandlerThread f2294v;
        public final Context y;

        /* renamed from: s  reason: collision with root package name */
        public final Map<ComponentName, y> f2293s = new HashMap();

        /* renamed from: f  reason: collision with root package name */
        public Set<String> f2291f = new HashSet();

        /* loaded from: classes.dex */
        public static class y {

            /* renamed from: n3  reason: collision with root package name */
            public boolean f2296n3;
            public final ComponentName y;

            /* renamed from: zn  reason: collision with root package name */
            public zn.y f2298zn;

            /* renamed from: gv  reason: collision with root package name */
            public ArrayDeque<v> f2295gv = new ArrayDeque<>();

            /* renamed from: v  reason: collision with root package name */
            public int f2297v = 0;

            public y(ComponentName componentName) {
                this.y = componentName;
            }
        }

        public gv(Context context) {
            this.y = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.f2294v = handlerThread;
            handlerThread.start();
            this.f2292fb = new Handler(handlerThread.getLooper(), this);
        }

        public final void a(ComponentName componentName) {
            y yVar = this.f2293s.get(componentName);
            if (yVar != null) {
                n3(yVar);
            }
        }

        public final void c5(y yVar) {
            if (this.f2292fb.hasMessages(3, yVar.y)) {
                return;
            }
            int i = yVar.f2297v;
            int i5 = i + 1;
            yVar.f2297v = i5;
            if (i5 > 6) {
                Log.w("NotifManCompat", "Giving up on delivering " + yVar.f2295gv.size() + " tasks to " + yVar.y + " after " + yVar.f2297v + " retries");
                yVar.f2295gv.clear();
                return;
            }
            Log.isLoggable("NotifManCompat", 3);
            this.f2292fb.sendMessageDelayed(this.f2292fb.obtainMessage(3, yVar.y), (1 << i) * 1000);
        }

        public final void fb(y yVar) {
            Log.isLoggable("NotifManCompat", 3);
            if (yVar.f2295gv.isEmpty()) {
                return;
            }
            if (y(yVar) && yVar.f2298zn != null) {
                while (true) {
                    v peek = yVar.f2295gv.peek();
                    if (peek == null) {
                        break;
                    }
                    try {
                        Log.isLoggable("NotifManCompat", 3);
                        peek.y(yVar.f2298zn);
                        yVar.f2295gv.remove();
                    } catch (DeadObjectException unused) {
                        Log.isLoggable("NotifManCompat", 3);
                    } catch (RemoteException e2) {
                        Log.w("NotifManCompat", "RemoteException communicating with " + yVar.y, e2);
                    }
                }
                if (!yVar.f2295gv.isEmpty()) {
                    c5(yVar);
                    return;
                }
                return;
            }
            c5(yVar);
        }

        public final void gv(ComponentName componentName) {
            y yVar = this.f2293s.get(componentName);
            if (yVar != null) {
                fb(yVar);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return false;
                        }
                        gv((ComponentName) message.obj);
                        return true;
                    }
                    a((ComponentName) message.obj);
                    return true;
                }
                zn znVar = (zn) message.obj;
                v(znVar.y, znVar.f2302n3);
                return true;
            }
            zn((v) message.obj);
            return true;
        }

        public final void i9() {
            Set<String> zn2 = NotificationManagerCompat.zn(this.y);
            if (zn2.equals(this.f2291f)) {
                return;
            }
            this.f2291f = zn2;
            List<ResolveInfo> queryIntentServices = this.y.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
            HashSet<ComponentName> hashSet = new HashSet();
            for (ResolveInfo resolveInfo : queryIntentServices) {
                if (zn2.contains(resolveInfo.serviceInfo.packageName)) {
                    ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                    ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                    if (resolveInfo.serviceInfo.permission != null) {
                        Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                    } else {
                        hashSet.add(componentName);
                    }
                }
            }
            for (ComponentName componentName2 : hashSet) {
                if (!this.f2293s.containsKey(componentName2)) {
                    Log.isLoggable("NotifManCompat", 3);
                    this.f2293s.put(componentName2, new y(componentName2));
                }
            }
            Iterator<Map.Entry<ComponentName, y>> it = this.f2293s.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<ComponentName, y> next = it.next();
                if (!hashSet.contains(next.getKey())) {
                    Log.isLoggable("NotifManCompat", 3);
                    n3(next.getValue());
                    it.remove();
                }
            }
        }

        public final void n3(y yVar) {
            if (yVar.f2296n3) {
                this.y.unbindService(this);
                yVar.f2296n3 = false;
            }
            yVar.f2298zn = null;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.isLoggable("NotifManCompat", 3);
            this.f2292fb.obtainMessage(1, new zn(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.isLoggable("NotifManCompat", 3);
            this.f2292fb.obtainMessage(2, componentName).sendToTarget();
        }

        public void s(v vVar) {
            this.f2292fb.obtainMessage(0, vVar).sendToTarget();
        }

        public final void v(ComponentName componentName, IBinder iBinder) {
            y yVar = this.f2293s.get(componentName);
            if (yVar != null) {
                yVar.f2298zn = y.AbstractBinderC0263y.mt(iBinder);
                yVar.f2297v = 0;
                fb(yVar);
            }
        }

        public final boolean y(y yVar) {
            if (yVar.f2296n3) {
                return true;
            }
            boolean bindService = this.y.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(yVar.y), this, 33);
            yVar.f2296n3 = bindService;
            if (bindService) {
                yVar.f2297v = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + yVar.y);
                this.y.unbindService(this);
            }
            return yVar.f2296n3;
        }

        public final void zn(v vVar) {
            i9();
            for (y yVar : this.f2293s.values()) {
                yVar.f2295gv.add(vVar);
                fb(yVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class n3 implements v {

        /* renamed from: gv  reason: collision with root package name */
        public final Notification f2299gv;

        /* renamed from: n3  reason: collision with root package name */
        public final int f2300n3;
        public final String y;

        /* renamed from: zn  reason: collision with root package name */
        public final String f2301zn;

        public n3(String str, int i, String str2, Notification notification) {
            this.y = str;
            this.f2300n3 = i;
            this.f2301zn = str2;
            this.f2299gv = notification;
        }

        @NonNull
        public String toString() {
            return "NotifyTask[packageName:" + this.y + ", id:" + this.f2300n3 + ", tag:" + this.f2301zn + "]";
        }

        @Override // androidx.core.app.NotificationManagerCompat.v
        public void y(zn.y yVar) throws RemoteException {
            yVar.ro(this.y, this.f2300n3, this.f2301zn, this.f2299gv);
        }
    }

    /* loaded from: classes.dex */
    public interface v {
        void y(zn.y yVar) throws RemoteException;
    }

    /* loaded from: classes.dex */
    public static class y {
        public static int n3(NotificationManager notificationManager) {
            return notificationManager.getImportance();
        }

        public static boolean y(NotificationManager notificationManager) {
            return notificationManager.areNotificationsEnabled();
        }
    }

    /* loaded from: classes.dex */
    public static class zn {

        /* renamed from: n3  reason: collision with root package name */
        public final IBinder f2302n3;
        public final ComponentName y;

        public zn(ComponentName componentName, IBinder iBinder) {
            this.y = componentName;
            this.f2302n3 = iBinder;
        }
    }

    public NotificationManagerCompat(Context context) {
        this.y = context;
        this.f2290n3 = (NotificationManager) context.getSystemService("notification");
    }

    public static boolean fb(Notification notification) {
        Bundle extras = NotificationCompat.getExtras(notification);
        if (extras != null && extras.getBoolean("android.support.useSideChannel")) {
            return true;
        }
        return false;
    }

    @NonNull
    public static NotificationManagerCompat from(@NonNull Context context) {
        return new NotificationManagerCompat(context);
    }

    @NonNull
    public static Set<String> zn(@NonNull Context context) {
        Set<String> set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (f2289zn) {
            if (string != null) {
                try {
                    if (!string.equals(f2287gv)) {
                        String[] split = string.split(":", -1);
                        HashSet hashSet = new HashSet(split.length);
                        for (String str : split) {
                            ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
                            if (unflattenFromString != null) {
                                hashSet.add(unflattenFromString.getPackageName());
                            }
                        }
                        f2288v = hashSet;
                        f2287gv = string;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            set = f2288v;
        }
        return set;
    }

    public final void a(v vVar) {
        synchronized (f2285a) {
            try {
                if (f2286fb == null) {
                    f2286fb = new gv(this.y.getApplicationContext());
                }
                f2286fb.s(vVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean areNotificationsEnabled() {
        if (Build.VERSION.SDK_INT >= 24) {
            return y.y(this.f2290n3);
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.y.getSystemService("appops");
        ApplicationInfo applicationInfo = this.y.getApplicationInfo();
        String packageName = this.y.getApplicationContext().getPackageName();
        int i = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            Method method = cls.getMethod("checkOpNoThrow", cls2, cls2, String.class);
            Integer num = (Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class);
            num.intValue();
            if (((Integer) method.invoke(appOpsManager, num, Integer.valueOf(i), packageName)).intValue() != 0) {
                return false;
            }
            return true;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }

    public void gv(int i, @NonNull Notification notification) {
        v(null, i, notification);
    }

    public void n3(@Nullable String str, int i) {
        this.f2290n3.cancel(str, i);
    }

    public void v(@Nullable String str, int i, @NonNull Notification notification) {
        if (fb(notification)) {
            a(new n3(this.y.getPackageName(), i, str, notification));
            this.f2290n3.cancel(str, i);
            return;
        }
        this.f2290n3.notify(str, i, notification);
    }

    public void y(int i) {
        n3(null, i);
    }
}
