package wn;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.video.PlaceholderSurface;
import v5.j5;
/* loaded from: classes.dex */
public final class tl {

    /* renamed from: a  reason: collision with root package name */
    public float f14609a;

    /* renamed from: c5  reason: collision with root package name */
    public float f14610c5;

    /* renamed from: f  reason: collision with root package name */
    public long f14611f;

    /* renamed from: fb  reason: collision with root package name */
    public float f14612fb;

    /* renamed from: gv  reason: collision with root package name */
    public boolean f14613gv;

    /* renamed from: i9  reason: collision with root package name */
    public int f14614i9;
    @Nullable

    /* renamed from: n3  reason: collision with root package name */
    public final n3 f14615n3;

    /* renamed from: p  reason: collision with root package name */
    public long f14616p;

    /* renamed from: s  reason: collision with root package name */
    public float f14617s;

    /* renamed from: t  reason: collision with root package name */
    public long f14618t;

    /* renamed from: tl  reason: collision with root package name */
    public long f14619tl;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public Surface f14620v;

    /* renamed from: w  reason: collision with root package name */
    public long f14621w;

    /* renamed from: wz  reason: collision with root package name */
    public long f14622wz;

    /* renamed from: xc  reason: collision with root package name */
    public long f14623xc;
    public final wn.v y = new wn.v();
    @Nullable

    /* renamed from: zn  reason: collision with root package name */
    public final v f14624zn;

    /* loaded from: classes.dex */
    public interface n3 {

        /* loaded from: classes.dex */
        public interface y {
            void onDefaultDisplayChanged(@Nullable Display display);
        }

        void unregister();

        void y(y yVar);
    }

    /* loaded from: classes.dex */
    public static final class v implements Choreographer.FrameCallback, Handler.Callback {

        /* renamed from: t  reason: collision with root package name */
        public static final v f14626t = new v();

        /* renamed from: f  reason: collision with root package name */
        public int f14627f;

        /* renamed from: fb  reason: collision with root package name */
        public final HandlerThread f14628fb;

        /* renamed from: s  reason: collision with root package name */
        public Choreographer f14629s;

        /* renamed from: v  reason: collision with root package name */
        public final Handler f14630v;
        public volatile long y = -9223372036854775807L;

        public v() {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
            this.f14628fb = handlerThread;
            handlerThread.start();
            Handler x42 = j5.x4(handlerThread.getLooper(), this);
            this.f14630v = x42;
            x42.sendEmptyMessage(0);
        }

        public static v gv() {
            return f14626t;
        }

        public final void a() {
            Choreographer choreographer = this.f14629s;
            if (choreographer != null) {
                int i = this.f14627f - 1;
                this.f14627f = i;
                if (i == 0) {
                    choreographer.removeFrameCallback(this);
                    this.y = -9223372036854775807L;
                }
            }
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j2) {
            this.y = j2;
            ((Choreographer) v5.y.v(this.f14629s)).postFrameCallbackDelayed(this, 500L);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return false;
                    }
                    a();
                    return true;
                }
                n3();
                return true;
            }
            zn();
            return true;
        }

        public final void n3() {
            Choreographer choreographer = this.f14629s;
            if (choreographer != null) {
                int i = this.f14627f + 1;
                this.f14627f = i;
                if (i == 1) {
                    choreographer.postFrameCallback(this);
                }
            }
        }

        public void v() {
            this.f14630v.sendEmptyMessage(2);
        }

        public void y() {
            this.f14630v.sendEmptyMessage(1);
        }

        public final void zn() {
            try {
                this.f14629s = Choreographer.getInstance();
            } catch (RuntimeException e2) {
                v5.r.i9("VideoFrameReleaseHelper", "Vsync sampling disabled due to platform error", e2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class y {
        public static void y(Surface surface, float f4) {
            int i;
            if (f4 == 0.0f) {
                i = 0;
            } else {
                i = 1;
            }
            try {
                surface.setFrameRate(f4, i);
            } catch (IllegalStateException e2) {
                v5.r.gv("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", e2);
            }
        }
    }

    public tl(@Nullable Context context) {
        v vVar;
        n3 a2 = a(context);
        this.f14615n3 = a2;
        if (a2 != null) {
            vVar = v.gv();
        } else {
            vVar = null;
        }
        this.f14624zn = vVar;
        this.f14611f = -9223372036854775807L;
        this.f14618t = -9223372036854775807L;
        this.f14609a = -1.0f;
        this.f14610c5 = 1.0f;
        this.f14614i9 = 0;
    }

    @Nullable
    public static n3 a(@Nullable Context context) {
        n3 n3Var = null;
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        if (j5.y >= 17) {
            n3Var = gv.zn(applicationContext);
        }
        if (n3Var == null) {
            return zn.n3(applicationContext);
        }
        return n3Var;
    }

    public static long v(long j2, long j4, long j6) {
        long j7;
        long j8 = j4 + (((j2 - j4) / j6) * j6);
        if (j2 <= j8) {
            j7 = j8 - j6;
        } else {
            j8 = j6 + j8;
            j7 = j8;
        }
        if (j8 - j2 >= j2 - j7) {
            return j7;
        }
        return j8;
    }

    public static boolean zn(long j2, long j4) {
        if (Math.abs(j2 - j4) <= 20000000) {
            return true;
        }
        return false;
    }

    public void c5(float f4) {
        this.f14610c5 = f4;
        wz();
        mt(false);
    }

    public void f() {
        this.f14613gv = true;
        wz();
        if (this.f14615n3 != null) {
            ((v) v5.y.v(this.f14624zn)).y();
            this.f14615n3.y(new n3.y() { // from class: wn.t
                @Override // wn.tl.n3.y
                public final void onDefaultDisplayChanged(Display display) {
                    tl.this.w(display);
                }
            });
        }
        mt(false);
    }

    public void fb(float f4) {
        this.f14609a = f4;
        this.y.fb();
        p();
    }

    public final void gv() {
        Surface surface;
        if (j5.y >= 30 && (surface = this.f14620v) != null && this.f14614i9 != Integer.MIN_VALUE && this.f14617s != 0.0f) {
            this.f14617s = 0.0f;
            y.y(surface, 0.0f);
        }
    }

    public void i9() {
        wz();
    }

    public final void mt(boolean z2) {
        Surface surface;
        float f4;
        if (j5.y >= 30 && (surface = this.f14620v) != null && this.f14614i9 != Integer.MIN_VALUE) {
            if (this.f14613gv) {
                float f6 = this.f14612fb;
                if (f6 != -1.0f) {
                    f4 = f6 * this.f14610c5;
                    if (z2 && this.f14617s == f4) {
                        return;
                    }
                    this.f14617s = f4;
                    y.y(surface, f4);
                }
            }
            f4 = 0.0f;
            if (z2) {
            }
            this.f14617s = f4;
            y.y(surface, f4);
        }
    }

    public long n3(long j2) {
        long j4;
        v vVar;
        if (this.f14621w != -1 && this.y.v()) {
            long y2 = this.f14616p + (((float) (this.y.y() * (this.f14619tl - this.f14621w))) / this.f14610c5);
            if (zn(j2, y2)) {
                j4 = y2;
                this.f14622wz = this.f14619tl;
                this.f14623xc = j4;
                vVar = this.f14624zn;
                if (vVar == null && this.f14611f != -9223372036854775807L) {
                    long j6 = vVar.y;
                    if (j6 == -9223372036854775807L) {
                        return j4;
                    }
                    return v(j4, j6, this.f14611f) - this.f14618t;
                }
                return j4;
            }
            wz();
        }
        j4 = j2;
        this.f14622wz = this.f14619tl;
        this.f14623xc = j4;
        vVar = this.f14624zn;
        if (vVar == null) {
        }
        return j4;
    }

    public final void p() {
        float f4;
        float f6;
        if (j5.y >= 30 && this.f14620v != null) {
            if (this.y.v()) {
                f4 = this.y.n3();
            } else {
                f4 = this.f14609a;
            }
            float f9 = this.f14612fb;
            if (f4 == f9) {
                return;
            }
            int i = (f4 > (-1.0f) ? 1 : (f4 == (-1.0f) ? 0 : -1));
            if (i != 0 && f9 != -1.0f) {
                if (this.y.v() && this.y.gv() >= 5000000000L) {
                    f6 = 0.02f;
                } else {
                    f6 = 1.0f;
                }
                if (Math.abs(f4 - this.f14612fb) < f6) {
                    return;
                }
            } else if (i == 0 && this.y.zn() < 30) {
                return;
            }
            this.f14612fb = f4;
            mt(false);
        }
    }

    public void s(long j2) {
        long j4 = this.f14622wz;
        if (j4 != -1) {
            this.f14621w = j4;
            this.f14616p = this.f14623xc;
        }
        this.f14619tl++;
        this.y.a(j2 * 1000);
        p();
    }

    public void t() {
        this.f14613gv = false;
        n3 n3Var = this.f14615n3;
        if (n3Var != null) {
            n3Var.unregister();
            ((v) v5.y.v(this.f14624zn)).v();
        }
        gv();
    }

    public void tl(@Nullable Surface surface) {
        if (surface instanceof PlaceholderSurface) {
            surface = null;
        }
        if (this.f14620v == surface) {
            return;
        }
        gv();
        this.f14620v = surface;
        mt(true);
    }

    public final void w(@Nullable Display display) {
        if (display != null) {
            long refreshRate = (long) (1.0E9d / display.getRefreshRate());
            this.f14611f = refreshRate;
            this.f14618t = (refreshRate * 80) / 100;
            return;
        }
        v5.r.c5("VideoFrameReleaseHelper", "Unable to query display refresh rate");
        this.f14611f = -9223372036854775807L;
        this.f14618t = -9223372036854775807L;
    }

    public final void wz() {
        this.f14619tl = 0L;
        this.f14621w = -1L;
        this.f14622wz = -1L;
    }

    public void xc(int i) {
        if (this.f14614i9 == i) {
            return;
        }
        this.f14614i9 = i;
        mt(true);
    }

    /* loaded from: classes.dex */
    public static final class zn implements n3 {
        public final WindowManager y;

        public zn(WindowManager windowManager) {
            this.y = windowManager;
        }

        @Nullable
        public static n3 n3(Context context) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                return new zn(windowManager);
            }
            return null;
        }

        @Override // wn.tl.n3
        public void y(n3.y yVar) {
            yVar.onDefaultDisplayChanged(this.y.getDefaultDisplay());
        }

        @Override // wn.tl.n3
        public void unregister() {
        }
    }

    /* loaded from: classes.dex */
    public static final class gv implements n3, DisplayManager.DisplayListener {
        @Nullable

        /* renamed from: n3  reason: collision with root package name */
        public n3.y f14625n3;
        public final DisplayManager y;

        public gv(DisplayManager displayManager) {
            this.y = displayManager;
        }

        @Nullable
        public static n3 zn(Context context) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
            if (displayManager != null) {
                return new gv(displayManager);
            }
            return null;
        }

        public final Display n3() {
            return this.y.getDisplay(0);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i) {
            n3.y yVar = this.f14625n3;
            if (yVar != null && i == 0) {
                yVar.onDefaultDisplayChanged(n3());
            }
        }

        @Override // wn.tl.n3
        public void unregister() {
            this.y.unregisterDisplayListener(this);
            this.f14625n3 = null;
        }

        @Override // wn.tl.n3
        public void y(n3.y yVar) {
            this.f14625n3 = yVar;
            this.y.registerDisplayListener(this, j5.i4());
            yVar.onDefaultDisplayChanged(n3());
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i) {
        }
    }
}
