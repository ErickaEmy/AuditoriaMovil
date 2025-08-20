package kx;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
/* loaded from: classes.dex */
public final class ta implements d {
    @Nullable

    /* renamed from: n3  reason: collision with root package name */
    public gv<? extends v> f10112n3;
    public final ExecutorService y;
    @Nullable

    /* renamed from: zn  reason: collision with root package name */
    public IOException f10113zn;

    /* renamed from: gv  reason: collision with root package name */
    public static final zn f10110gv = s(false, -9223372036854775807L);

    /* renamed from: v  reason: collision with root package name */
    public static final zn f10111v = s(true, -9223372036854775807L);

    /* renamed from: a  reason: collision with root package name */
    public static final zn f10108a = new zn(2, -9223372036854775807L);

    /* renamed from: fb  reason: collision with root package name */
    public static final zn f10109fb = new zn(3, -9223372036854775807L);

    /* loaded from: classes.dex */
    public interface a {
        void tl();
    }

    /* loaded from: classes.dex */
    public static final class fb implements Runnable {
        public final a y;

        public fb(a aVar) {
            this.y = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.y.tl();
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes.dex */
    public final class gv<T extends v> extends Handler implements Runnable {

        /* renamed from: co  reason: collision with root package name */
        public volatile boolean f10114co;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        public IOException f10115f;

        /* renamed from: fb  reason: collision with root package name */
        public final long f10116fb;

        /* renamed from: p  reason: collision with root package name */
        public boolean f10117p;
        @Nullable

        /* renamed from: s  reason: collision with root package name */
        public n3<T> f10118s;

        /* renamed from: t  reason: collision with root package name */
        public int f10119t;

        /* renamed from: v  reason: collision with root package name */
        public final T f10120v;
        @Nullable

        /* renamed from: w  reason: collision with root package name */
        public Thread f10121w;
        public final int y;

        public gv(Looper looper, T t2, n3<T> n3Var, int i, long j2) {
            super(looper);
            this.f10120v = t2;
            this.f10118s = n3Var;
            this.y = i;
            this.f10116fb = j2;
        }

        public void a(long j2) {
            boolean z2;
            if (ta.this.f10112n3 == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            v5.y.fb(z2);
            ta.this.f10112n3 = this;
            if (j2 > 0) {
                sendEmptyMessageDelayed(0, j2);
            } else {
                n3();
            }
        }

        public final long gv() {
            return Math.min((this.f10119t - 1) * 1000, 5000);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            long gv2;
            if (this.f10114co) {
                return;
            }
            int i = message.what;
            if (i == 0) {
                n3();
            } else if (i != 3) {
                zn();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j2 = elapsedRealtime - this.f10116fb;
                n3 n3Var = (n3) v5.y.v(this.f10118s);
                if (this.f10117p) {
                    n3Var.ud(this.f10120v, elapsedRealtime, j2, false);
                    return;
                }
                int i5 = message.what;
                if (i5 != 1) {
                    if (i5 == 2) {
                        IOException iOException = (IOException) message.obj;
                        this.f10115f = iOException;
                        int i6 = this.f10119t + 1;
                        this.f10119t = i6;
                        zn oz2 = n3Var.oz(this.f10120v, elapsedRealtime, j2, iOException, i6);
                        if (oz2.y == 3) {
                            ta.this.f10113zn = this.f10115f;
                            return;
                        } else if (oz2.y != 2) {
                            if (oz2.y == 1) {
                                this.f10119t = 1;
                            }
                            if (oz2.f10123n3 != -9223372036854775807L) {
                                gv2 = oz2.f10123n3;
                            } else {
                                gv2 = gv();
                            }
                            a(gv2);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                try {
                    n3Var.ta(this.f10120v, elapsedRealtime, j2);
                } catch (RuntimeException e2) {
                    v5.r.gv("LoadTask", "Unexpected exception handling load completed", e2);
                    ta.this.f10113zn = new s(e2);
                }
            } else {
                throw ((Error) message.obj);
            }
        }

        public final void n3() {
            this.f10115f = null;
            ta.this.y.execute((Runnable) v5.y.v(ta.this.f10112n3));
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z2;
            try {
                synchronized (this) {
                    z2 = this.f10117p;
                    this.f10121w = Thread.currentThread();
                }
                if (!z2) {
                    v5.yt.y("load:" + this.f10120v.getClass().getSimpleName());
                    try {
                        this.f10120v.load();
                        v5.yt.zn();
                    } catch (Throwable th) {
                        v5.yt.zn();
                        throw th;
                    }
                }
                synchronized (this) {
                    this.f10121w = null;
                    Thread.interrupted();
                }
                if (!this.f10114co) {
                    sendEmptyMessage(1);
                }
            } catch (IOException e2) {
                if (!this.f10114co) {
                    obtainMessage(2, e2).sendToTarget();
                }
            } catch (Error e3) {
                if (!this.f10114co) {
                    v5.r.gv("LoadTask", "Unexpected error loading stream", e3);
                    obtainMessage(3, e3).sendToTarget();
                }
                throw e3;
            } catch (Exception e5) {
                if (!this.f10114co) {
                    v5.r.gv("LoadTask", "Unexpected exception loading stream", e5);
                    obtainMessage(2, new s(e5)).sendToTarget();
                }
            } catch (OutOfMemoryError e6) {
                if (!this.f10114co) {
                    v5.r.gv("LoadTask", "OutOfMemory error loading stream", e6);
                    obtainMessage(2, new s(e6)).sendToTarget();
                }
            }
        }

        public void v(int i) throws IOException {
            IOException iOException = this.f10115f;
            if (iOException != null && this.f10119t > i) {
                throw iOException;
            }
        }

        public void y(boolean z2) {
            this.f10114co = z2;
            this.f10115f = null;
            if (hasMessages(0)) {
                this.f10117p = true;
                removeMessages(0);
                if (!z2) {
                    sendEmptyMessage(1);
                }
            } else {
                synchronized (this) {
                    try {
                        this.f10117p = true;
                        this.f10120v.n3();
                        Thread thread = this.f10121w;
                        if (thread != null) {
                            thread.interrupt();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            if (z2) {
                zn();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                ((n3) v5.y.v(this.f10118s)).ud(this.f10120v, elapsedRealtime, elapsedRealtime - this.f10116fb, true);
                this.f10118s = null;
            }
        }

        public final void zn() {
            ta.this.f10112n3 = null;
        }
    }

    /* loaded from: classes.dex */
    public interface n3<T extends v> {
        zn oz(T t2, long j2, long j4, IOException iOException, int i);

        void ta(T t2, long j2, long j4);

        void ud(T t2, long j2, long j4, boolean z2);
    }

    /* loaded from: classes.dex */
    public static final class s extends IOException {
        public s(Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
        }
    }

    /* loaded from: classes.dex */
    public interface v {
        void load() throws IOException;

        void n3();
    }

    /* loaded from: classes.dex */
    public static final class zn {

        /* renamed from: n3  reason: collision with root package name */
        public final long f10123n3;
        public final int y;

        public boolean zn() {
            int i = this.y;
            if (i == 0 || i == 1) {
                return true;
            }
            return false;
        }

        public zn(int i, long j2) {
            this.y = i;
            this.f10123n3 = j2;
        }
    }

    public ta(String str) {
        this.y = v5.j5.wf("ExoPlayer:Loader:" + str);
    }

    public static zn s(boolean z2, long j2) {
        return new zn(z2 ? 1 : 0, j2);
    }

    public void a() {
        ((gv) v5.y.c5(this.f10112n3)).y(false);
    }

    public boolean c5() {
        if (this.f10113zn != null) {
            return true;
        }
        return false;
    }

    public void f(int i) throws IOException {
        IOException iOException = this.f10113zn;
        if (iOException == null) {
            gv<? extends v> gvVar = this.f10112n3;
            if (gvVar != null) {
                if (i == Integer.MIN_VALUE) {
                    i = gvVar.y;
                }
                gvVar.v(i);
                return;
            }
            return;
        }
        throw iOException;
    }

    public void fb() {
        this.f10113zn = null;
    }

    public boolean i9() {
        if (this.f10112n3 != null) {
            return true;
        }
        return false;
    }

    @Override // kx.d
    public void n3() throws IOException {
        f(Integer.MIN_VALUE);
    }

    public void t() {
        tl(null);
    }

    public void tl(@Nullable a aVar) {
        gv<? extends v> gvVar = this.f10112n3;
        if (gvVar != null) {
            gvVar.y(true);
        }
        if (aVar != null) {
            this.y.execute(new fb(aVar));
        }
        this.y.shutdown();
    }

    public <T extends v> long wz(T t2, n3<T> n3Var, int i) {
        this.f10113zn = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new gv((Looper) v5.y.c5(Looper.myLooper()), t2, n3Var, i, elapsedRealtime).a(0L);
        return elapsedRealtime;
    }
}
