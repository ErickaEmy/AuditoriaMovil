package androidx.work.impl.foreground;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.impl.WorkDatabase;
import gq.c5;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import l.a;
import l.f;
import le.w;
import w2.gv;
import w2.zn;
/* loaded from: classes.dex */
public class y implements zn, gq.n3 {

    /* renamed from: r  reason: collision with root package name */
    public static final String f3744r = f.a("SystemFgDispatcher");

    /* renamed from: co  reason: collision with root package name */
    public final gv f3745co;

    /* renamed from: f  reason: collision with root package name */
    public String f3746f;

    /* renamed from: fb  reason: collision with root package name */
    public final ix.y f3747fb;

    /* renamed from: p  reason: collision with root package name */
    public final Set<w> f3748p;

    /* renamed from: s  reason: collision with root package name */
    public final Object f3749s = new Object();

    /* renamed from: t  reason: collision with root package name */
    public final Map<String, a> f3750t;

    /* renamed from: v  reason: collision with root package name */
    public c5 f3751v;

    /* renamed from: w  reason: collision with root package name */
    public final Map<String, w> f3752w;
    public Context y;
    @Nullable

    /* renamed from: z  reason: collision with root package name */
    public n3 f3753z;

    /* loaded from: classes.dex */
    public interface n3 {
        void gv(int i);

        void stop();

        void y(int i, @NonNull Notification notification);

        void zn(int i, int i5, @NonNull Notification notification);
    }

    /* renamed from: androidx.work.impl.foreground.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0030y implements Runnable {

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ String f3755v;
        public final /* synthetic */ WorkDatabase y;

        public RunnableC0030y(WorkDatabase workDatabase, String str) {
            this.y = workDatabase;
            this.f3755v = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            w a2 = this.y.f().a(this.f3755v);
            if (a2 != null && a2.n3()) {
                synchronized (y.this.f3749s) {
                    y.this.f3752w.put(this.f3755v, a2);
                    y.this.f3748p.add(a2);
                    y yVar = y.this;
                    yVar.f3745co.gv(yVar.f3748p);
                }
            }
        }
    }

    public y(@NonNull Context context) {
        this.y = context;
        c5 xc2 = c5.xc(context);
        this.f3751v = xc2;
        ix.y z2 = xc2.z();
        this.f3747fb = z2;
        this.f3746f = null;
        this.f3750t = new LinkedHashMap();
        this.f3748p = new HashSet();
        this.f3752w = new HashMap();
        this.f3745co = new gv(this.y, z2, this);
        this.f3751v.p().zn(this);
    }

    @NonNull
    public static Intent a(@NonNull Context context) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_STOP_FOREGROUND");
        return intent;
    }

    @NonNull
    public static Intent y(@NonNull Context context, @NonNull String str, @NonNull a aVar) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_NOTIFY");
        intent.putExtra("KEY_NOTIFICATION_ID", aVar.zn());
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", aVar.y());
        intent.putExtra("KEY_NOTIFICATION", aVar.n3());
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    @NonNull
    public static Intent zn(@NonNull Context context, @NonNull String str, @NonNull a aVar) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_START_FOREGROUND");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NOTIFICATION_ID", aVar.zn());
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", aVar.y());
        intent.putExtra("KEY_NOTIFICATION", aVar.n3());
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public final void c5(@NonNull Intent intent) {
        f.zn().gv(f3744r, String.format("Started foreground service %s", intent), new Throwable[0]);
        this.f3747fb.n3(new RunnableC0030y(this.f3751v.co(), intent.getStringExtra("KEY_WORKSPEC_ID")));
    }

    public void f() {
        this.f3753z = null;
        synchronized (this.f3749s) {
            this.f3745co.v();
        }
        this.f3751v.p().c5(this);
    }

    public final void fb(@NonNull Intent intent) {
        f.zn().gv(f3744r, String.format("Stopping foreground work for %s", intent), new Throwable[0]);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        if (stringExtra != null && !TextUtils.isEmpty(stringExtra)) {
            this.f3751v.c5(UUID.fromString(stringExtra));
        }
    }

    @Override // gq.n3
    public void gv(@NonNull String str, boolean z2) {
        boolean z3;
        Map.Entry<String, a> entry;
        synchronized (this.f3749s) {
            try {
                w remove = this.f3752w.remove(str);
                if (remove != null) {
                    z3 = this.f3748p.remove(remove);
                } else {
                    z3 = false;
                }
                if (z3) {
                    this.f3745co.gv(this.f3748p);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        a remove2 = this.f3750t.remove(str);
        if (str.equals(this.f3746f) && this.f3750t.size() > 0) {
            Iterator<Map.Entry<String, a>> it = this.f3750t.entrySet().iterator();
            Map.Entry<String, a> next = it.next();
            while (true) {
                entry = next;
                if (!it.hasNext()) {
                    break;
                }
                next = it.next();
            }
            this.f3746f = entry.getKey();
            if (this.f3753z != null) {
                a value = entry.getValue();
                this.f3753z.zn(value.zn(), value.y(), value.n3());
                this.f3753z.gv(value.zn());
            }
        }
        n3 n3Var = this.f3753z;
        if (remove2 != null && n3Var != null) {
            f.zn().y(f3744r, String.format("Removing Notification (id: %s, workSpecId: %s ,notificationType: %s)", Integer.valueOf(remove2.zn()), str, Integer.valueOf(remove2.y())), new Throwable[0]);
            n3Var.gv(remove2.zn());
        }
    }

    public void i9(@NonNull Intent intent) {
        f.zn().gv(f3744r, "Stopping foreground service", new Throwable[0]);
        n3 n3Var = this.f3753z;
        if (n3Var != null) {
            n3Var.stop();
        }
    }

    @Override // w2.zn
    public void n3(@NonNull List<String> list) {
        if (!list.isEmpty()) {
            for (String str : list) {
                f.zn().y(f3744r, String.format("Constraints unmet for WorkSpec %s", str), new Throwable[0]);
                this.f3751v.d0(str);
            }
        }
    }

    public final void s(@NonNull Intent intent) {
        int i = 0;
        int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        f.zn().y(f3744r, String.format("Notifying with (id: %s, workSpecId: %s, notificationType: %s)", Integer.valueOf(intExtra), stringExtra, Integer.valueOf(intExtra2)), new Throwable[0]);
        if (notification != null && this.f3753z != null) {
            this.f3750t.put(stringExtra, new a(intExtra, notification, intExtra2));
            if (TextUtils.isEmpty(this.f3746f)) {
                this.f3746f = stringExtra;
                this.f3753z.zn(intExtra, intExtra2, notification);
                return;
            }
            this.f3753z.y(intExtra, notification);
            if (intExtra2 != 0 && Build.VERSION.SDK_INT >= 29) {
                for (Map.Entry<String, a> entry : this.f3750t.entrySet()) {
                    i |= entry.getValue().y();
                }
                a aVar = this.f3750t.get(this.f3746f);
                if (aVar != null) {
                    this.f3753z.zn(aVar.zn(), i, aVar.n3());
                }
            }
        }
    }

    public void t(@NonNull Intent intent) {
        String action = intent.getAction();
        if ("ACTION_START_FOREGROUND".equals(action)) {
            c5(intent);
            s(intent);
        } else if ("ACTION_NOTIFY".equals(action)) {
            s(intent);
        } else if ("ACTION_CANCEL_WORK".equals(action)) {
            fb(intent);
        } else if ("ACTION_STOP_FOREGROUND".equals(action)) {
            i9(intent);
        }
    }

    public void tl(@NonNull n3 n3Var) {
        if (this.f3753z != null) {
            f.zn().n3(f3744r, "A callback already exists.", new Throwable[0]);
        } else {
            this.f3753z = n3Var;
        }
    }

    @Override // w2.zn
    public void v(@NonNull List<String> list) {
    }
}
