package com.google.android.exoplayer2.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import androidx.annotation.Nullable;
import v5.f;
import v5.r;
import v5.w;
/* loaded from: classes.dex */
public final class PlaceholderSurface extends Surface {

    /* renamed from: f  reason: collision with root package name */
    public static boolean f4937f;

    /* renamed from: s  reason: collision with root package name */
    public static int f4938s;

    /* renamed from: fb  reason: collision with root package name */
    public boolean f4939fb;

    /* renamed from: v  reason: collision with root package name */
    public final n3 f4940v;
    public final boolean y;

    /* loaded from: classes.dex */
    public static class n3 extends HandlerThread implements Handler.Callback {
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        public PlaceholderSurface f4941f;
        @Nullable

        /* renamed from: fb  reason: collision with root package name */
        public Error f4942fb;
        @Nullable

        /* renamed from: s  reason: collision with root package name */
        public RuntimeException f4943s;

        /* renamed from: v  reason: collision with root package name */
        public Handler f4944v;
        public f y;

        public n3() {
            super("ExoPlayer:PlaceholderSurface");
        }

        public final void gv() {
            v5.y.v(this.y);
            this.y.c5();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            try {
                if (i != 1) {
                    if (i != 2) {
                        return true;
                    }
                    try {
                        gv();
                    } finally {
                        try {
                            return true;
                        } finally {
                        }
                    }
                    return true;
                }
                try {
                    n3(message.arg1);
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e2) {
                    r.gv("PlaceholderSurface", "Failed to initialize placeholder surface", e2);
                    this.f4942fb = e2;
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e3) {
                    r.gv("PlaceholderSurface", "Failed to initialize placeholder surface", e3);
                    this.f4943s = e3;
                    synchronized (this) {
                        notify();
                    }
                } catch (w.y e5) {
                    r.gv("PlaceholderSurface", "Failed to initialize placeholder surface", e5);
                    this.f4943s = new IllegalStateException(e5);
                    synchronized (this) {
                        notify();
                    }
                }
                return true;
            } catch (Throwable th) {
                synchronized (this) {
                    notify();
                    throw th;
                }
            }
        }

        public final void n3(int i) throws w.y {
            boolean z2;
            v5.y.v(this.y);
            this.y.s(i);
            SurfaceTexture fb2 = this.y.fb();
            if (i != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f4941f = new PlaceholderSurface(this, fb2, z2);
        }

        public PlaceholderSurface y(int i) {
            boolean z2;
            start();
            this.f4944v = new Handler(getLooper(), this);
            this.y = new f(this.f4944v);
            synchronized (this) {
                z2 = false;
                this.f4944v.obtainMessage(1, i, 0).sendToTarget();
                while (this.f4941f == null && this.f4943s == null && this.f4942fb == null) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z2 = true;
                    }
                }
            }
            if (z2) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException = this.f4943s;
            if (runtimeException == null) {
                Error error = this.f4942fb;
                if (error == null) {
                    return (PlaceholderSurface) v5.y.v(this.f4941f);
                }
                throw error;
            }
            throw runtimeException;
        }

        public void zn() {
            v5.y.v(this.f4944v);
            this.f4944v.sendEmptyMessage(2);
        }
    }

    public static synchronized boolean n3(Context context) {
        boolean z2;
        synchronized (PlaceholderSurface.class) {
            try {
                z2 = true;
                if (!f4937f) {
                    f4938s = y(context);
                    f4937f = true;
                }
                if (f4938s == 0) {
                    z2 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z2;
    }

    public static int y(Context context) {
        if (w.s(context)) {
            if (w.c5()) {
                return 1;
            }
            return 2;
        }
        return 0;
    }

    public static PlaceholderSurface zn(Context context, boolean z2) {
        boolean z3;
        int i = 0;
        if (z2 && !n3(context)) {
            z3 = false;
        } else {
            z3 = true;
        }
        v5.y.fb(z3);
        n3 n3Var = new n3();
        if (z2) {
            i = f4938s;
        }
        return n3Var.y(i);
    }

    @Override // android.view.Surface
    public void release() {
        super.release();
        synchronized (this.f4940v) {
            try {
                if (!this.f4939fb) {
                    this.f4940v.zn();
                    this.f4939fb = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public PlaceholderSurface(n3 n3Var, SurfaceTexture surfaceTexture, boolean z2) {
        super(surfaceTexture);
        this.f4940v = n3Var;
        this.y = z2;
    }
}
