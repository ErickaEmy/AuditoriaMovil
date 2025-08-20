package f1;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.Objects;
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
import sun.misc.Unsafe;
import w0.co;
import w0.r;
import w0.xc;
/* loaded from: classes.dex */
public abstract class y<V> extends g1.y implements f1.zn<V> {

    /* renamed from: f  reason: collision with root package name */
    public static final Logger f7745f;

    /* renamed from: s  reason: collision with root package name */
    public static final boolean f7746s;

    /* renamed from: t  reason: collision with root package name */
    public static final n3 f7747t;

    /* renamed from: w  reason: collision with root package name */
    public static final Object f7748w;

    /* renamed from: fb  reason: collision with root package name */
    public volatile t f7749fb;

    /* renamed from: v  reason: collision with root package name */
    public volatile v f7750v;
    public volatile Object y;

    /* loaded from: classes.dex */
    public static final class a extends n3 {

        /* renamed from: gv  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<y, v> f7751gv;

        /* renamed from: n3  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<t, t> f7752n3;

        /* renamed from: v  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<y, Object> f7753v;
        public final AtomicReferenceFieldUpdater<t, Thread> y;

        /* renamed from: zn  reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<y, t> f7754zn;

        public a(AtomicReferenceFieldUpdater<t, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<t, t> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<y, t> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<y, v> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<y, Object> atomicReferenceFieldUpdater5) {
            super();
            this.y = atomicReferenceFieldUpdater;
            this.f7752n3 = atomicReferenceFieldUpdater2;
            this.f7754zn = atomicReferenceFieldUpdater3;
            this.f7751gv = atomicReferenceFieldUpdater4;
            this.f7753v = atomicReferenceFieldUpdater5;
        }

        @Override // f1.y.n3
        public void gv(t tVar, t tVar2) {
            this.f7752n3.lazySet(tVar, tVar2);
        }

        @Override // f1.y.n3
        public boolean n3(y<?> yVar, Object obj, Object obj2) {
            return r.n3.y(this.f7753v, yVar, obj, obj2);
        }

        @Override // f1.y.n3
        public void v(t tVar, Thread thread) {
            this.y.lazySet(tVar, thread);
        }

        @Override // f1.y.n3
        public boolean y(y<?> yVar, v vVar, v vVar2) {
            return r.n3.y(this.f7751gv, yVar, vVar, vVar2);
        }

        @Override // f1.y.n3
        public boolean zn(y<?> yVar, t tVar, t tVar2) {
            return r.n3.y(this.f7754zn, yVar, tVar, tVar2);
        }
    }

    /* loaded from: classes.dex */
    public interface c5<V> extends f1.zn<V> {
    }

    /* loaded from: classes.dex */
    public static final class f extends n3 {

        /* renamed from: a  reason: collision with root package name */
        public static final long f7755a;

        /* renamed from: gv  reason: collision with root package name */
        public static final long f7756gv;

        /* renamed from: n3  reason: collision with root package name */
        public static final long f7757n3;

        /* renamed from: v  reason: collision with root package name */
        public static final long f7758v;
        public static final Unsafe y;

        /* renamed from: zn  reason: collision with root package name */
        public static final long f7759zn;

        /* renamed from: f1.y$f$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0094y implements PrivilegedExceptionAction<Unsafe> {
            @Override // java.security.PrivilegedExceptionAction
            /* renamed from: y */
            public Unsafe run() throws Exception {
                Field[] declaredFields;
                for (Field field : Unsafe.class.getDeclaredFields()) {
                    field.setAccessible(true);
                    Object obj = field.get(null);
                    if (Unsafe.class.isInstance(obj)) {
                        return (Unsafe) Unsafe.class.cast(obj);
                    }
                }
                throw new NoSuchFieldError("the Unsafe");
            }
        }

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (PrivilegedActionException e2) {
                    throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
                }
            } catch (SecurityException unused) {
                unsafe = (Unsafe) AccessController.doPrivileged(new C0094y());
            }
            try {
                f7759zn = unsafe.objectFieldOffset(y.class.getDeclaredField(hx.fb.f9032o));
                f7757n3 = unsafe.objectFieldOffset(y.class.getDeclaredField("v"));
                f7756gv = unsafe.objectFieldOffset(y.class.getDeclaredField("y"));
                f7758v = unsafe.objectFieldOffset(t.class.getDeclaredField("y"));
                f7755a = unsafe.objectFieldOffset(t.class.getDeclaredField("n3"));
                y = unsafe;
            } catch (Exception e3) {
                r.v(e3);
                throw new RuntimeException(e3);
            }
        }

        public f() {
            super();
        }

        @Override // f1.y.n3
        public void gv(t tVar, t tVar2) {
            y.putObject(tVar, f7755a, tVar2);
        }

        @Override // f1.y.n3
        public boolean n3(y<?> yVar, Object obj, Object obj2) {
            return ua.y.y(y, yVar, f7756gv, obj, obj2);
        }

        @Override // f1.y.n3
        public void v(t tVar, Thread thread) {
            y.putObject(tVar, f7758v, thread);
        }

        @Override // f1.y.n3
        public boolean y(y<?> yVar, v vVar, v vVar2) {
            return ua.y.y(y, yVar, f7757n3, vVar, vVar2);
        }

        @Override // f1.y.n3
        public boolean zn(y<?> yVar, t tVar, t tVar2) {
            return ua.y.y(y, yVar, f7759zn, tVar, tVar2);
        }
    }

    /* loaded from: classes.dex */
    public static final class fb<V> implements Runnable {

        /* renamed from: v  reason: collision with root package name */
        public final f1.zn<? extends V> f7760v;
        public final y<V> y;

        @Override // java.lang.Runnable
        public void run() {
            if (this.y.y == this) {
                if (y.f7747t.n3(this.y, this, y.x4(this.f7760v))) {
                    y.co(this.y);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class gv {

        /* renamed from: n3  reason: collision with root package name */
        public static final gv f7761n3 = new gv(new C0095y("Failure occurred while trying to finish a future."));
        public final Throwable y;

        /* renamed from: f1.y$gv$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0095y extends Throwable {
            public C0095y(String str) {
                super(str);
            }

            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        public gv(Throwable th) {
            this.y = (Throwable) xc.wz(th);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class i9<V> extends y<V> implements c5<V> {
        @Override // f1.y, f1.zn
        public final void addListener(Runnable runnable, Executor executor) {
            super.addListener(runnable, executor);
        }

        @Override // f1.y, java.util.concurrent.Future
        public final boolean cancel(boolean z2) {
            return super.cancel(z2);
        }

        @Override // f1.y, java.util.concurrent.Future
        public V get() throws InterruptedException, ExecutionException {
            return (V) super.get();
        }

        @Override // f1.y, java.util.concurrent.Future
        public final boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // f1.y, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }

        @Override // f1.y, java.util.concurrent.Future
        public final V get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return (V) super.get(j2, timeUnit);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class n3 {
        public n3() {
        }

        public abstract void gv(t tVar, t tVar2);

        public abstract boolean n3(y<?> yVar, Object obj, Object obj2);

        public abstract void v(t tVar, Thread thread);

        public abstract boolean y(y<?> yVar, v vVar, v vVar2);

        public abstract boolean zn(y<?> yVar, t tVar, t tVar2);
    }

    /* loaded from: classes.dex */
    public static final class s extends n3 {
        public s() {
            super();
        }

        @Override // f1.y.n3
        public void gv(t tVar, t tVar2) {
            tVar.f7763n3 = tVar2;
        }

        @Override // f1.y.n3
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

        @Override // f1.y.n3
        public void v(t tVar, Thread thread) {
            tVar.y = thread;
        }

        @Override // f1.y.n3
        public boolean y(y<?> yVar, v vVar, v vVar2) {
            synchronized (yVar) {
                try {
                    if (yVar.f7750v == vVar) {
                        yVar.f7750v = vVar2;
                        return true;
                    }
                    return false;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // f1.y.n3
        public boolean zn(y<?> yVar, t tVar, t tVar2) {
            synchronized (yVar) {
                try {
                    if (yVar.f7749fb == tVar) {
                        yVar.f7749fb = tVar2;
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
    public static final class t {

        /* renamed from: zn  reason: collision with root package name */
        public static final t f7762zn = new t(false);

        /* renamed from: n3  reason: collision with root package name */
        public volatile t f7763n3;
        public volatile Thread y;

        public t(boolean z2) {
        }

        public void n3() {
            Thread thread = this.y;
            if (thread != null) {
                this.y = null;
                LockSupport.unpark(thread);
            }
        }

        public void y(t tVar) {
            y.f7747t.gv(this, tVar);
        }

        public t() {
            y.f7747t.v(this, Thread.currentThread());
        }
    }

    /* loaded from: classes.dex */
    public static final class zn {

        /* renamed from: gv  reason: collision with root package name */
        public static final zn f7767gv;

        /* renamed from: zn  reason: collision with root package name */
        public static final zn f7768zn;

        /* renamed from: n3  reason: collision with root package name */
        public final Throwable f7769n3;
        public final boolean y;

        static {
            if (y.f7746s) {
                f7767gv = null;
                f7768zn = null;
                return;
            }
            f7767gv = new zn(false, null);
            f7768zn = new zn(true, null);
        }

        public zn(boolean z2, Throwable th) {
            this.y = z2;
            this.f7769n3 = th;
        }
    }

    static {
        boolean z2;
        n3 sVar;
        try {
            z2 = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z2 = false;
        }
        f7746s = z2;
        f7745f = Logger.getLogger(y.class.getName());
        Throwable th = null;
        try {
            sVar = new f();
            th = null;
        } catch (Throwable th2) {
            th = th2;
            try {
                sVar = new a(AtomicReferenceFieldUpdater.newUpdater(t.class, Thread.class, "y"), AtomicReferenceFieldUpdater.newUpdater(t.class, t.class, "n3"), AtomicReferenceFieldUpdater.newUpdater(y.class, t.class, hx.fb.f9032o), AtomicReferenceFieldUpdater.newUpdater(y.class, v.class, "v"), AtomicReferenceFieldUpdater.newUpdater(y.class, Object.class, "y"));
            } catch (Throwable th3) {
                sVar = new s();
                th = th3;
            }
        }
        f7747t = sVar;
        if (th != null) {
            Logger logger = f7745f;
            Level level = Level.SEVERE;
            logger.log(level, "UnsafeAtomicHelper is broken!", th);
            logger.log(level, "SafeAtomicHelper is broken!", th);
        }
        f7748w = new Object();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [f1.y$n3] */
    /* JADX WARN: Type inference failed for: r4v0, types: [f1.y<?>] */
    /* JADX WARN: Type inference failed for: r4v1, types: [f1.y] */
    /* JADX WARN: Type inference failed for: r4v7, types: [f1.y, f1.y<V>] */
    public static void co(y<?> yVar) {
        v vVar = null;
        while (true) {
            yVar.c();
            yVar.wz();
            v mt2 = yVar.mt(vVar);
            while (mt2 != null) {
                vVar = mt2.f7766zn;
                Runnable runnable = mt2.y;
                Objects.requireNonNull(runnable);
                Runnable runnable2 = runnable;
                if (runnable2 instanceof fb) {
                    fb fbVar = (fb) runnable2;
                    yVar = fbVar.y;
                    if (yVar.y == fbVar) {
                        if (f7747t.n3(yVar, fbVar, x4(fbVar.f7760v))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    Executor executor = mt2.f7765n3;
                    Objects.requireNonNull(executor);
                    z(runnable2, executor);
                }
                mt2 = vVar;
            }
            return;
        }
    }

    private static <V> V i4(Future<V> future) throws ExecutionException {
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

    public static CancellationException p(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object x4(f1.zn<?> znVar) {
        Throwable y;
        if (znVar instanceof c5) {
            Object obj = ((y) znVar).y;
            if (obj instanceof zn) {
                zn znVar2 = (zn) obj;
                if (znVar2.y) {
                    obj = znVar2.f7769n3 != null ? new zn(false, znVar2.f7769n3) : zn.f7767gv;
                }
            }
            Objects.requireNonNull(obj);
            return obj;
        } else if ((znVar instanceof g1.y) && (y = g1.n3.y((g1.y) znVar)) != null) {
            return new gv(y);
        } else {
            boolean isCancelled = znVar.isCancelled();
            if ((!f7746s) & isCancelled) {
                zn znVar3 = zn.f7767gv;
                Objects.requireNonNull(znVar3);
                return znVar3;
            }
            try {
                Object i42 = i4(znVar);
                if (isCancelled) {
                    String valueOf = String.valueOf(znVar);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 84);
                    sb.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
                    sb.append(valueOf);
                    return new zn(false, new IllegalArgumentException(sb.toString()));
                } else if (i42 == null) {
                    return f7748w;
                } else {
                    return i42;
                }
            } catch (CancellationException e2) {
                if (!isCancelled) {
                    String valueOf2 = String.valueOf(znVar);
                    StringBuilder sb2 = new StringBuilder(valueOf2.length() + 77);
                    sb2.append("get() threw CancellationException, despite reporting isCancelled() == false: ");
                    sb2.append(valueOf2);
                    return new gv(new IllegalArgumentException(sb2.toString(), e2));
                }
                return new zn(false, e2);
            } catch (ExecutionException e3) {
                if (isCancelled) {
                    String valueOf3 = String.valueOf(znVar);
                    StringBuilder sb3 = new StringBuilder(valueOf3.length() + 84);
                    sb3.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
                    sb3.append(valueOf3);
                    return new zn(false, new IllegalArgumentException(sb3.toString(), e3));
                }
                return new gv(e3.getCause());
            } catch (Throwable th) {
                return new gv(th);
            }
        }
    }

    public static void z(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = f7745f;
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            StringBuilder sb = new StringBuilder(valueOf.length() + 57 + valueOf2.length());
            sb.append("RuntimeException while executing runnable ");
            sb.append(valueOf);
            sb.append(" with executor ");
            sb.append(valueOf2);
            logger.log(level, sb.toString(), (Throwable) e2);
        }
    }

    @Override // f1.zn
    public void addListener(Runnable runnable, Executor executor) {
        v vVar;
        xc.xc(runnable, "Runnable was null.");
        xc.xc(executor, "Executor was null.");
        if (!isDone() && (vVar = this.f7750v) != v.f7764gv) {
            v vVar2 = new v(runnable, executor);
            do {
                vVar2.f7766zn = vVar;
                if (f7747t.y(this, vVar, vVar2)) {
                    return;
                }
                vVar = this.f7750v;
            } while (vVar != v.f7764gv);
            z(runnable, executor);
        }
        z(runnable, executor);
    }

    public final void c() {
        t tVar;
        do {
            tVar = this.f7749fb;
        } while (!f7747t.zn(this, tVar, t.f7762zn));
        while (tVar != null) {
            tVar.n3();
            tVar = tVar.f7763n3;
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z2) {
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
            if (f7746s) {
                znVar = new zn(z2, new CancellationException("Future.cancel() was called."));
            } else {
                if (z2) {
                    znVar = zn.f7768zn;
                } else {
                    znVar = zn.f7767gv;
                }
                Objects.requireNonNull(znVar);
            }
            boolean z5 = false;
            y<V> yVar = this;
            while (true) {
                if (f7747t.n3(yVar, obj, znVar)) {
                    if (z2) {
                        yVar.f3();
                    }
                    co(yVar);
                    if (!(obj instanceof fb)) {
                        return true;
                    }
                    f1.zn<? extends V> znVar2 = ((fb) obj).f7760v;
                    if (znVar2 instanceof c5) {
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

    public final void d0(t tVar) {
        tVar.y = null;
        while (true) {
            t tVar2 = this.f7749fb;
            if (tVar2 == t.f7762zn) {
                return;
            }
            t tVar3 = null;
            while (tVar2 != null) {
                t tVar4 = tVar2.f7763n3;
                if (tVar2.y != null) {
                    tVar3 = tVar2;
                } else if (tVar3 != null) {
                    tVar3.f7763n3 = tVar4;
                    if (tVar3.y == null) {
                        break;
                    }
                } else if (!f7747t.zn(this, tVar2, tVar4)) {
                    break;
                }
                tVar2 = tVar4;
            }
            return;
        }
    }

    public boolean fh(V v2) {
        if (v2 == null) {
            v2 = (V) f7748w;
        }
        if (f7747t.n3(this, null, v2)) {
            co(this);
            return true;
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public V get(long j2, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long nanos = timeUnit.toNanos(j2);
        if (!Thread.interrupted()) {
            Object obj = this.y;
            if ((obj != null) & (!(obj instanceof fb))) {
                return r(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                t tVar = this.f7749fb;
                if (tVar != t.f7762zn) {
                    t tVar2 = new t();
                    do {
                        tVar2.y(tVar);
                        if (f7747t.zn(this, tVar, tVar2)) {
                            do {
                                f1.v.y(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.y;
                                    if ((obj2 != null) & (!(obj2 instanceof fb))) {
                                        return r(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    d0(tVar2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            d0(tVar2);
                        } else {
                            tVar = this.f7749fb;
                        }
                    } while (tVar != t.f7762zn);
                    Object obj3 = this.y;
                    Objects.requireNonNull(obj3);
                    return r(obj3);
                }
                Object obj32 = this.y;
                Objects.requireNonNull(obj32);
                return r(obj32);
            }
            while (nanos > 0) {
                Object obj4 = this.y;
                if ((obj4 != null) & (!(obj4 instanceof fb))) {
                    return r(obj4);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String yVar = toString();
            String obj5 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = obj5.toLowerCase(locale);
            String lowerCase2 = timeUnit.toString().toLowerCase(locale);
            StringBuilder sb = new StringBuilder(String.valueOf(lowerCase2).length() + 28);
            sb.append("Waited ");
            sb.append(j2);
            sb.append(" ");
            sb.append(lowerCase2);
            String sb2 = sb.toString();
            if (nanos + 1000 < 0) {
                String concat = String.valueOf(sb2).concat(" (plus ");
                long j4 = -nanos;
                long convert = timeUnit.convert(j4, TimeUnit.NANOSECONDS);
                long nanos2 = j4 - timeUnit.toNanos(convert);
                int i = (convert > 0L ? 1 : (convert == 0L ? 0 : -1));
                boolean z2 = i == 0 || nanos2 > 1000;
                if (i > 0) {
                    String valueOf = String.valueOf(concat);
                    StringBuilder sb3 = new StringBuilder(valueOf.length() + 21 + String.valueOf(lowerCase).length());
                    sb3.append(valueOf);
                    sb3.append(convert);
                    sb3.append(" ");
                    sb3.append(lowerCase);
                    String sb4 = sb3.toString();
                    if (z2) {
                        sb4 = String.valueOf(sb4).concat(",");
                    }
                    concat = String.valueOf(sb4).concat(" ");
                }
                if (z2) {
                    String valueOf2 = String.valueOf(concat);
                    StringBuilder sb5 = new StringBuilder(valueOf2.length() + 33);
                    sb5.append(valueOf2);
                    sb5.append(nanos2);
                    sb5.append(" nanoseconds ");
                    concat = sb5.toString();
                }
                sb2 = String.valueOf(concat).concat("delay)");
            }
            if (isDone()) {
                throw new TimeoutException(String.valueOf(sb2).concat(" but future completed as timeout expired"));
            }
            StringBuilder sb6 = new StringBuilder(String.valueOf(sb2).length() + 5 + String.valueOf(yVar).length());
            sb6.append(sb2);
            sb6.append(" for ");
            sb6.append(yVar);
            throw new TimeoutException(sb6.toString());
        }
        throw new InterruptedException();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.y instanceof zn;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        boolean z2;
        Object obj = this.y;
        if (obj != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        return (!(obj instanceof fb)) & z2;
    }

    public final v mt(v vVar) {
        v vVar2;
        do {
            vVar2 = this.f7750v;
        } while (!f7747t.y(this, vVar2, v.f7764gv));
        v vVar3 = vVar;
        v vVar4 = vVar2;
        while (vVar4 != null) {
            v vVar5 = vVar4.f7766zn;
            vVar4.f7766zn = vVar3;
            vVar3 = vVar4;
            vVar4 = vVar5;
        }
        return vVar3;
    }

    public String n() {
        if (this instanceof ScheduledFuture) {
            long delay = ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS);
            StringBuilder sb = new StringBuilder(41);
            sb.append("remaining delay=[");
            sb.append(delay);
            sb.append(" ms]");
            return sb.toString();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V r(Object obj) throws ExecutionException {
        if (!(obj instanceof zn)) {
            if (!(obj instanceof gv)) {
                if (obj == f7748w) {
                    return (V) f1.gv.y();
                }
                return obj;
            }
            throw new ExecutionException(((gv) obj).y);
        }
        throw p("Task was cancelled.", ((zn) obj).f7769n3);
    }

    public boolean rz(Throwable th) {
        if (f7747t.n3(this, null, new gv((Throwable) xc.wz(th)))) {
            co(this);
            return true;
        }
        return false;
    }

    public final void t(StringBuilder sb) {
        try {
            Object i42 = i4(this);
            sb.append("SUCCESS, result=[");
            xc(sb, i42);
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

    public final void tl(StringBuilder sb) {
        String sb2;
        int length = sb.length();
        sb.append("PENDING");
        Object obj = this.y;
        if (obj instanceof fb) {
            sb.append(", setFuture=[");
            w(sb, ((fb) obj).f7760v);
            sb.append("]");
        } else {
            try {
                sb2 = co.y(n());
            } catch (RuntimeException | StackOverflowError e2) {
                String valueOf = String.valueOf(e2.getClass());
                StringBuilder sb3 = new StringBuilder(valueOf.length() + 38);
                sb3.append("Exception thrown from implementation: ");
                sb3.append(valueOf);
                sb2 = sb3.toString();
            }
            if (sb2 != null) {
                sb.append(", info=[");
                sb.append(sb2);
                sb.append("]");
            }
        }
        if (isDone()) {
            sb.delete(length, sb.length());
            t(sb);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            t(sb);
        } else {
            tl(sb);
        }
        sb.append("]");
        return sb.toString();
    }

    public final void w(StringBuilder sb, Object obj) {
        try {
            if (obj == this) {
                sb.append("this future");
            } else {
                sb.append(obj);
            }
        } catch (RuntimeException e2) {
            e = e2;
            sb.append("Exception thrown from implementation: ");
            sb.append(e.getClass());
        } catch (StackOverflowError e3) {
            e = e3;
            sb.append("Exception thrown from implementation: ");
            sb.append(e.getClass());
        }
    }

    public final void xc(StringBuilder sb, Object obj) {
        if (obj == null) {
            sb.append("null");
        } else if (obj == this) {
            sb.append("this future");
        } else {
            sb.append(obj.getClass().getName());
            sb.append("@");
            sb.append(Integer.toHexString(System.identityHashCode(obj)));
        }
    }

    @Override // g1.y
    public final Throwable y() {
        if (this instanceof c5) {
            Object obj = this.y;
            if (obj instanceof gv) {
                return ((gv) obj).y;
            }
            return null;
        }
        return null;
    }

    /* loaded from: classes.dex */
    public static final class v {

        /* renamed from: gv  reason: collision with root package name */
        public static final v f7764gv = new v();

        /* renamed from: n3  reason: collision with root package name */
        public final Executor f7765n3;
        public final Runnable y;

        /* renamed from: zn  reason: collision with root package name */
        public v f7766zn;

        public v(Runnable runnable, Executor executor) {
            this.y = runnable;
            this.f7765n3 = executor;
        }

        public v() {
        }
    }

    public void f3() {
    }

    public void wz() {
    }

    @Override // java.util.concurrent.Future
    public V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.y;
            if ((obj2 != null) & (!(obj2 instanceof fb))) {
                return r(obj2);
            }
            t tVar = this.f7749fb;
            if (tVar != t.f7762zn) {
                t tVar2 = new t();
                do {
                    tVar2.y(tVar);
                    if (f7747t.zn(this, tVar, tVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.y;
                            } else {
                                d0(tVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof fb))));
                        return r(obj);
                    }
                    tVar = this.f7749fb;
                } while (tVar != t.f7762zn);
                Object obj3 = this.y;
                Objects.requireNonNull(obj3);
                return r(obj3);
            }
            Object obj32 = this.y;
            Objects.requireNonNull(obj32);
            return r(obj32);
        }
        throw new InterruptedException();
    }
}
