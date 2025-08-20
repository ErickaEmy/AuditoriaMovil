package r;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public abstract class y<V> implements f1.zn<V> {

    /* renamed from: t  reason: collision with root package name */
    public static final n3 f13022t;

    /* renamed from: w  reason: collision with root package name */
    public static final Object f13023w;
    @Nullable

    /* renamed from: fb  reason: collision with root package name */
    public volatile c5 f13024fb;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public volatile v f13025v;
    @Nullable
    public volatile Object y;

    /* renamed from: s  reason: collision with root package name */
    public static final boolean f13021s = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: f  reason: collision with root package name */
    public static final Logger f13020f = Logger.getLogger(y.class.getName());

    /* loaded from: classes.dex */
    public static final class a extends n3 {

        /* renamed from: gv  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<y, v> f13026gv;

        /* renamed from: n3  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<c5, c5> f13027n3;

        /* renamed from: v  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<y, Object> f13028v;
        public final AtomicReferenceFieldUpdater<c5, Thread> y;

        /* renamed from: zn  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<y, c5> f13029zn;

        public a(AtomicReferenceFieldUpdater<c5, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<c5, c5> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<y, c5> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<y, v> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<y, Object> atomicReferenceFieldUpdater5) {
            super();
            this.y = atomicReferenceFieldUpdater;
            this.f13027n3 = atomicReferenceFieldUpdater2;
            this.f13029zn = atomicReferenceFieldUpdater3;
            this.f13026gv = atomicReferenceFieldUpdater4;
            this.f13028v = atomicReferenceFieldUpdater5;
        }

        @Override // r.y.n3
        public void gv(c5 c5Var, c5 c5Var2) {
            this.f13027n3.lazySet(c5Var, c5Var2);
        }

        @Override // r.y.n3
        public boolean n3(y<?> yVar, Object obj, Object obj2) {
            return r.n3.y(this.f13028v, yVar, obj, obj2);
        }

        @Override // r.y.n3
        public void v(c5 c5Var, Thread thread) {
            this.y.lazySet(c5Var, thread);
        }

        @Override // r.y.n3
        public boolean y(y<?> yVar, v vVar, v vVar2) {
            return r.n3.y(this.f13026gv, yVar, vVar, vVar2);
        }

        @Override // r.y.n3
        public boolean zn(y<?> yVar, c5 c5Var, c5 c5Var2) {
            return r.n3.y(this.f13029zn, yVar, c5Var, c5Var2);
        }
    }

    /* loaded from: classes.dex */
    public static final class c5 {

        /* renamed from: zn  reason: collision with root package name */
        public static final c5 f13030zn = new c5(false);
        @Nullable

        /* renamed from: n3  reason: collision with root package name */
        public volatile c5 f13031n3;
        @Nullable
        public volatile Thread y;

        public c5(boolean z2) {
        }

        public void n3() {
            Thread thread = this.y;
            if (thread != null) {
                this.y = null;
                LockSupport.unpark(thread);
            }
        }

        public void y(c5 c5Var) {
            y.f13022t.gv(this, c5Var);
        }

        public c5() {
            y.f13022t.v(this, Thread.currentThread());
        }
    }

    /* loaded from: classes.dex */
    public static final class fb<V> implements Runnable {

        /* renamed from: v  reason: collision with root package name */
        public final f1.zn<? extends V> f13032v;
        public final y<V> y;

        @Override // java.lang.Runnable
        public void run() {
            if (this.y.y != this) {
                return;
            }
            if (y.f13022t.n3(this.y, this, y.c5(this.f13032v))) {
                y.a(this.y);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class gv {

        /* renamed from: n3  reason: collision with root package name */
        public static final gv f13033n3 = new gv(new C0190y("Failure occurred while trying to finish a future."));
        public final Throwable y;

        /* renamed from: r.y$gv$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0190y extends Throwable {
            public C0190y(String str) {
                super(str);
            }

            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        public gv(Throwable th) {
            this.y = (Throwable) y.gv(th);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class n3 {
        public n3() {
        }

        public abstract void gv(c5 c5Var, c5 c5Var2);

        public abstract boolean n3(y<?> yVar, Object obj, Object obj2);

        public abstract void v(c5 c5Var, Thread thread);

        public abstract boolean y(y<?> yVar, v vVar, v vVar2);

        public abstract boolean zn(y<?> yVar, c5 c5Var, c5 c5Var2);
    }

    /* loaded from: classes.dex */
    public static final class s extends n3 {
        public s() {
            super();
        }

        @Override // r.y.n3
        public void gv(c5 c5Var, c5 c5Var2) {
            c5Var.f13031n3 = c5Var2;
        }

        @Override // r.y.n3
        public boolean n3(y<?> yVar, Object obj, Object obj2) {
            synchronized (yVar) {
                try {
                    if (yVar.y == obj) {
                        yVar.y = obj2;
                        return true;
                    }
                    return false;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // r.y.n3
        public void v(c5 c5Var, Thread thread) {
            c5Var.y = thread;
        }

        @Override // r.y.n3
        public boolean y(y<?> yVar, v vVar, v vVar2) {
            synchronized (yVar) {
                try {
                    if (yVar.f13025v == vVar) {
                        yVar.f13025v = vVar2;
                        return true;
                    }
                    return false;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // r.y.n3
        public boolean zn(y<?> yVar, c5 c5Var, c5 c5Var2) {
            synchronized (yVar) {
                try {
                    if (yVar.f13024fb == c5Var) {
                        yVar.f13024fb = c5Var2;
                        return true;
                    }
                    return false;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class v {

        /* renamed from: gv  reason: collision with root package name */
        public static final v f13034gv = new v(null, null);

        /* renamed from: n3  reason: collision with root package name */
        public final Executor f13035n3;
        public final Runnable y;
        @Nullable

        /* renamed from: zn  reason: collision with root package name */
        public v f13036zn;

        public v(Runnable runnable, Executor executor) {
            this.y = runnable;
            this.f13035n3 = executor;
        }
    }

    /* loaded from: classes.dex */
    public static final class zn {

        /* renamed from: gv  reason: collision with root package name */
        public static final zn f13037gv;

        /* renamed from: zn  reason: collision with root package name */
        public static final zn f13038zn;
        @Nullable

        /* renamed from: n3  reason: collision with root package name */
        public final Throwable f13039n3;
        public final boolean y;

        static {
            if (y.f13021s) {
                f13037gv = null;
                f13038zn = null;
                return;
            }
            f13037gv = new zn(false, null);
            f13038zn = new zn(true, null);
        }

        public zn(boolean z2, @Nullable Throwable th) {
            this.y = z2;
            this.f13039n3 = th;
        }
    }

    static {
        n3 sVar;
        try {
            sVar = new a(AtomicReferenceFieldUpdater.newUpdater(c5.class, Thread.class, "y"), AtomicReferenceFieldUpdater.newUpdater(c5.class, c5.class, "n3"), AtomicReferenceFieldUpdater.newUpdater(y.class, c5.class, hx.fb.f9032o), AtomicReferenceFieldUpdater.newUpdater(y.class, v.class, "v"), AtomicReferenceFieldUpdater.newUpdater(y.class, Object.class, "y"));
            th = null;
        } catch (Throwable th) {
            th = th;
            sVar = new s();
        }
        f13022t = sVar;
        if (th != null) {
            f13020f.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f13023w = new Object();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [r.y$n3] */
    /* JADX WARN: Type inference failed for: r4v0, types: [r.y<?>] */
    /* JADX WARN: Type inference failed for: r4v1, types: [r.y] */
    /* JADX WARN: Type inference failed for: r4v6, types: [r.y<V>, r.y] */
    public static void a(y<?> yVar) {
        v vVar = null;
        while (true) {
            yVar.tl();
            yVar.n3();
            v v2 = yVar.v(vVar);
            while (v2 != null) {
                vVar = v2.f13036zn;
                Runnable runnable = v2.y;
                if (runnable instanceof fb) {
                    fb fbVar = (fb) runnable;
                    yVar = fbVar.y;
                    if (yVar.y == fbVar) {
                        if (f13022t.n3(yVar, fbVar, c5(fbVar.f13032v))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    fb(runnable, v2.f13035n3);
                }
                v2 = vVar;
            }
            return;
        }
    }

    public static Object c5(f1.zn<?> znVar) {
        if (znVar instanceof y) {
            Object obj = ((y) znVar).y;
            if (obj instanceof zn) {
                zn znVar2 = (zn) obj;
                if (znVar2.y) {
                    if (znVar2.f13039n3 != null) {
                        return new zn(false, znVar2.f13039n3);
                    }
                    return zn.f13037gv;
                }
                return obj;
            }
            return obj;
        }
        boolean isCancelled = znVar.isCancelled();
        if ((!f13021s) & isCancelled) {
            return zn.f13037gv;
        }
        try {
            Object i92 = i9(znVar);
            if (i92 == null) {
                return f13023w;
            }
            return i92;
        } catch (CancellationException e2) {
            if (!isCancelled) {
                return new gv(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + znVar, e2));
            }
            return new zn(false, e2);
        } catch (ExecutionException e3) {
            return new gv(e3.getCause());
        } catch (Throwable th) {
            return new gv(th);
        }
    }

    private static void fb(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = f13020f;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    @NonNull
    public static <T> T gv(@Nullable T t2) {
        t2.getClass();
        return t2;
    }

    public static <V> V i9(Future<V> future) throws ExecutionException {
        V v2;
        boolean z2 = false;
        while (true) {
            try {
                v2 = future.get();
                break;
            } catch (InterruptedException unused) {
                z2 = true;
            } catch (Throwable th) {
                if (z2) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        return v2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private V s(Object obj) throws ExecutionException {
        if (!(obj instanceof zn)) {
            if (!(obj instanceof gv)) {
                if (obj == f13023w) {
                    return null;
                }
                return obj;
            }
            throw new ExecutionException(((gv) obj).y);
        }
        throw zn("Task was cancelled.", ((zn) obj).f13039n3);
    }

    private void tl() {
        c5 c5Var;
        do {
            c5Var = this.f13024fb;
        } while (!f13022t.zn(this, c5Var, c5.f13030zn));
        while (c5Var != null) {
            c5Var.n3();
            c5Var = c5Var.f13031n3;
        }
    }

    private void y(StringBuilder sb) {
        try {
            Object i92 = i9(this);
            sb.append("SUCCESS, result=[");
            sb.append(p(i92));
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e3) {
            sb.append("FAILURE, cause=[");
            sb.append(e3.getCause());
            sb.append("]");
        }
    }

    private static CancellationException zn(@Nullable String str, @Nullable Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    @Override // f1.zn
    public final void addListener(Runnable runnable, Executor executor) {
        gv(runnable);
        gv(executor);
        v vVar = this.f13025v;
        if (vVar != v.f13034gv) {
            v vVar2 = new v(runnable, executor);
            do {
                vVar2.f13036zn = vVar;
                if (f13022t.y(this, vVar, vVar2)) {
                    return;
                }
                vVar = this.f13025v;
            } while (vVar != v.f13034gv);
            fb(runnable, executor);
        }
        fb(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z2) {
        boolean z3;
        zn znVar;
        boolean z4;
        Object obj = this.y;
        if (obj == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3 | (obj instanceof fb)) {
            if (f13021s) {
                znVar = new zn(z2, new CancellationException("Future.cancel() was called."));
            } else if (z2) {
                znVar = zn.f13038zn;
            } else {
                znVar = zn.f13037gv;
            }
            boolean z5 = false;
            y<V> yVar = this;
            while (true) {
                if (f13022t.n3(yVar, obj, znVar)) {
                    if (z2) {
                        yVar.f();
                    }
                    a(yVar);
                    if (!(obj instanceof fb)) {
                        return true;
                    }
                    f1.zn<? extends V> znVar2 = ((fb) obj).f13032v;
                    if (znVar2 instanceof y) {
                        yVar = (y) znVar2;
                        obj = yVar.y;
                        if (obj == null) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (!(z4 | (obj instanceof fb))) {
                            return true;
                        }
                        z5 = true;
                    } else {
                        znVar2.cancel(z2);
                        return true;
                    }
                } else {
                    obj = yVar.y;
                    if (!(obj instanceof fb)) {
                        return z5;
                    }
                }
            }
        } else {
            return false;
        }
    }

    @Override // java.util.concurrent.Future
    public final V get(long j2, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        Locale locale;
        long nanos = timeUnit.toNanos(j2);
        if (!Thread.interrupted()) {
            Object obj = this.y;
            if ((obj != null) & (!(obj instanceof fb))) {
                return s(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                c5 c5Var = this.f13024fb;
                if (c5Var != c5.f13030zn) {
                    c5 c5Var2 = new c5();
                    do {
                        c5Var2.y(c5Var);
                        if (f13022t.zn(this, c5Var, c5Var2)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.y;
                                    if ((obj2 != null) & (!(obj2 instanceof fb))) {
                                        return s(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    wz(c5Var2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            wz(c5Var2);
                        } else {
                            c5Var = this.f13024fb;
                        }
                    } while (c5Var != c5.f13030zn);
                    return s(this.y);
                }
                return s(this.y);
            }
            while (nanos > 0) {
                Object obj3 = this.y;
                if ((obj3 != null) & (!(obj3 instanceof fb))) {
                    return s(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String yVar = toString();
            String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
            String str = "Waited " + j2 + " " + timeUnit.toString().toLowerCase(locale);
            if (nanos + 1000 < 0) {
                String str2 = str + " (plus ";
                long j4 = -nanos;
                long convert = timeUnit.convert(j4, TimeUnit.NANOSECONDS);
                long nanos2 = j4 - timeUnit.toNanos(convert);
                int i = (convert > 0L ? 1 : (convert == 0L ? 0 : -1));
                boolean z2 = i == 0 || nanos2 > 1000;
                if (i > 0) {
                    String str3 = str2 + convert + " " + lowerCase;
                    if (z2) {
                        str3 = str3 + ",";
                    }
                    str2 = str3 + " ";
                }
                if (z2) {
                    str2 = str2 + nanos2 + " nanoseconds ";
                }
                str = str2 + "delay)";
            }
            if (isDone()) {
                throw new TimeoutException(str + " but future completed as timeout expired");
            }
            throw new TimeoutException(str + " for " + yVar);
        }
        throw new InterruptedException();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.y instanceof zn;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        boolean z2;
        Object obj = this.y;
        if (obj != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        return (!(obj instanceof fb)) & z2;
    }

    public final String p(Object obj) {
        if (obj == this) {
            return "this future";
        }
        return String.valueOf(obj);
    }

    @Nullable
    public String t() {
        Object obj = this.y;
        if (obj instanceof fb) {
            return "setFuture=[" + p(((fb) obj).f13032v) + "]";
        } else if (this instanceof ScheduledFuture) {
            return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        } else {
            return null;
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            y(sb);
        } else {
            try {
                str = t();
            } catch (RuntimeException e2) {
                str = "Exception thrown from implementation: " + e2.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(str);
                sb.append("]");
            } else if (isDone()) {
                y(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public final v v(v vVar) {
        v vVar2;
        do {
            vVar2 = this.f13025v;
        } while (!f13022t.y(this, vVar2, v.f13034gv));
        v vVar3 = vVar;
        v vVar4 = vVar2;
        while (vVar4 != null) {
            v vVar5 = vVar4.f13036zn;
            vVar4.f13036zn = vVar3;
            vVar3 = vVar4;
            vVar4 = vVar5;
        }
        return vVar3;
    }

    public boolean w(Throwable th) {
        if (f13022t.n3(this, null, new gv((Throwable) gv(th)))) {
            a(this);
            return true;
        }
        return false;
    }

    public final void wz(c5 c5Var) {
        c5Var.y = null;
        while (true) {
            c5 c5Var2 = this.f13024fb;
            if (c5Var2 == c5.f13030zn) {
                return;
            }
            c5 c5Var3 = null;
            while (c5Var2 != null) {
                c5 c5Var4 = c5Var2.f13031n3;
                if (c5Var2.y != null) {
                    c5Var3 = c5Var2;
                } else if (c5Var3 != null) {
                    c5Var3.f13031n3 = c5Var4;
                    if (c5Var3.y == null) {
                        break;
                    }
                } else if (!f13022t.zn(this, c5Var2, c5Var4)) {
                    break;
                }
                c5Var2 = c5Var4;
            }
            return;
        }
    }

    public boolean xc(@Nullable V v2) {
        if (v2 == null) {
            v2 = (V) f13023w;
        }
        if (f13022t.n3(this, null, v2)) {
            a(this);
            return true;
        }
        return false;
    }

    public void f() {
    }

    public void n3() {
    }

    @Override // java.util.concurrent.Future
    public final V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.y;
            if ((obj2 != null) & (!(obj2 instanceof fb))) {
                return s(obj2);
            }
            c5 c5Var = this.f13024fb;
            if (c5Var != c5.f13030zn) {
                c5 c5Var2 = new c5();
                do {
                    c5Var2.y(c5Var);
                    if (f13022t.zn(this, c5Var, c5Var2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.y;
                            } else {
                                wz(c5Var2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof fb))));
                        return s(obj);
                    }
                    c5Var = this.f13024fb;
                } while (c5Var != c5.f13030zn);
                return s(this.y);
            }
            return s(this.y);
        }
        throw new InterruptedException();
    }
}
