package gq;

import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import gq.i9;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import l.f;
/* loaded from: classes.dex */
public class gv implements n3, mp.y {

    /* renamed from: f3  reason: collision with root package name */
    public static final String f8366f3 = f.a("Processor");

    /* renamed from: f  reason: collision with root package name */
    public WorkDatabase f8368f;

    /* renamed from: fb  reason: collision with root package name */
    public androidx.work.y f8369fb;

    /* renamed from: p  reason: collision with root package name */
    public List<v> f8370p;

    /* renamed from: s  reason: collision with root package name */
    public ix.y f8372s;

    /* renamed from: v  reason: collision with root package name */
    public Context f8374v;

    /* renamed from: w  reason: collision with root package name */
    public Map<String, i9> f8375w = new HashMap();

    /* renamed from: t  reason: collision with root package name */
    public Map<String, i9> f8373t = new HashMap();

    /* renamed from: co  reason: collision with root package name */
    public Set<String> f8367co = new HashSet();

    /* renamed from: z  reason: collision with root package name */
    public final List<n3> f8376z = new ArrayList();
    @Nullable
    public PowerManager.WakeLock y = null;

    /* renamed from: r  reason: collision with root package name */
    public final Object f8371r = new Object();

    /* loaded from: classes.dex */
    public static class y implements Runnable {
        @NonNull

        /* renamed from: fb  reason: collision with root package name */
        public f1.zn<Boolean> f8377fb;
        @NonNull

        /* renamed from: v  reason: collision with root package name */
        public String f8378v;
        @NonNull
        public n3 y;

        public y(@NonNull n3 n3Var, @NonNull String str, @NonNull f1.zn<Boolean> znVar) {
            this.y = n3Var;
            this.f8378v = str;
            this.f8377fb = znVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z2;
            try {
                z2 = this.f8377fb.get().booleanValue();
            } catch (InterruptedException | ExecutionException unused) {
                z2 = true;
            }
            this.y.gv(this.f8378v, z2);
        }
    }

    public gv(@NonNull Context context, @NonNull androidx.work.y yVar, @NonNull ix.y yVar2, @NonNull WorkDatabase workDatabase, @NonNull List<v> list) {
        this.f8374v = context;
        this.f8369fb = yVar;
        this.f8372s = yVar2;
        this.f8368f = workDatabase;
        this.f8370p = list;
    }

    public static boolean v(@NonNull String str, @Nullable i9 i9Var) {
        if (i9Var != null) {
            i9Var.gv();
            f.zn().y(f8366f3, String.format("WorkerWrapper interrupted for %s", str), new Throwable[0]);
            return true;
        }
        f.zn().y(f8366f3, String.format("WorkerWrapper could not be found for %s", str), new Throwable[0]);
        return false;
    }

    public boolean a(@NonNull String str) {
        boolean contains;
        synchronized (this.f8371r) {
            contains = this.f8367co.contains(str);
        }
        return contains;
    }

    public void c5(@NonNull n3 n3Var) {
        synchronized (this.f8371r) {
            this.f8376z.remove(n3Var);
        }
    }

    public boolean f(@NonNull String str, @Nullable WorkerParameters.y yVar) {
        synchronized (this.f8371r) {
            try {
                if (fb(str)) {
                    f.zn().y(f8366f3, String.format("Work %s is already enqueued for processing", str), new Throwable[0]);
                    return false;
                }
                i9 y2 = new i9.zn(this.f8374v, this.f8369fb, this.f8372s, this, this.f8368f, str).zn(this.f8370p).n3(yVar).y();
                f1.zn<Boolean> n32 = y2.n3();
                n32.addListener(new y(this, str, n32), this.f8372s.y());
                this.f8375w.put(str, y2);
                this.f8372s.getBackgroundExecutor().execute(y2);
                f.zn().y(f8366f3, String.format("%s: processing %s", getClass().getSimpleName(), str), new Throwable[0]);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean fb(@NonNull String str) {
        boolean z2;
        synchronized (this.f8371r) {
            try {
                if (!this.f8375w.containsKey(str) && !this.f8373t.containsKey(str)) {
                    z2 = false;
                }
                z2 = true;
            } finally {
            }
        }
        return z2;
    }

    @Override // gq.n3
    public void gv(@NonNull String str, boolean z2) {
        synchronized (this.f8371r) {
            try {
                this.f8375w.remove(str);
                f.zn().y(f8366f3, String.format("%s %s executed; reschedule = %s", getClass().getSimpleName(), str, Boolean.valueOf(z2)), new Throwable[0]);
                for (n3 n3Var : this.f8376z) {
                    n3Var.gv(str, z2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean i9(@NonNull String str) {
        return f(str, null);
    }

    @Override // mp.y
    public void n3(@NonNull String str, @NonNull l.a aVar) {
        synchronized (this.f8371r) {
            try {
                f.zn().gv(f8366f3, String.format("Moving WorkSpec (%s) to the foreground", str), new Throwable[0]);
                i9 remove = this.f8375w.remove(str);
                if (remove != null) {
                    if (this.y == null) {
                        PowerManager.WakeLock n32 = cs.i9.n3(this.f8374v, "ProcessorForegroundLck");
                        this.y = n32;
                        n32.acquire();
                    }
                    this.f8373t.put(str, remove);
                    mg.y.w(this.f8374v, androidx.work.impl.foreground.y.zn(this.f8374v, str, aVar));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean s(@NonNull String str) {
        boolean containsKey;
        synchronized (this.f8371r) {
            containsKey = this.f8373t.containsKey(str);
        }
        return containsKey;
    }

    public boolean t(@NonNull String str) {
        boolean v2;
        boolean z2 = false;
        synchronized (this.f8371r) {
            try {
                f.zn().y(f8366f3, String.format("Processor cancelling %s", str), new Throwable[0]);
                this.f8367co.add(str);
                i9 remove = this.f8373t.remove(str);
                if (remove != null) {
                    z2 = true;
                }
                if (remove == null) {
                    remove = this.f8375w.remove(str);
                }
                v2 = v(str, remove);
                if (z2) {
                    tl();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return v2;
    }

    public final void tl() {
        synchronized (this.f8371r) {
            try {
                if (this.f8373t.isEmpty()) {
                    this.f8374v.startService(androidx.work.impl.foreground.y.a(this.f8374v));
                    PowerManager.WakeLock wakeLock = this.y;
                    if (wakeLock != null) {
                        wakeLock.release();
                        this.y = null;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean wz(@NonNull String str) {
        boolean v2;
        synchronized (this.f8371r) {
            f.zn().y(f8366f3, String.format("Processor stopping foreground work %s", str), new Throwable[0]);
            v2 = v(str, this.f8373t.remove(str));
        }
        return v2;
    }

    public boolean xc(@NonNull String str) {
        boolean v2;
        synchronized (this.f8371r) {
            f.zn().y(f8366f3, String.format("Processor stopping background work %s", str), new Throwable[0]);
            v2 = v(str, this.f8375w.remove(str));
        }
        return v2;
    }

    @Override // mp.y
    public void y(@NonNull String str) {
        synchronized (this.f8371r) {
            this.f8373t.remove(str);
            tl();
        }
    }

    public void zn(@NonNull n3 n3Var) {
        synchronized (this.f8371r) {
            this.f8376z.add(n3Var);
        }
    }
}
