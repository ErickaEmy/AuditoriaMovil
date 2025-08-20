package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class y {

    /* renamed from: v  reason: collision with root package name */
    public static y f5870v;
    @Nullable

    /* renamed from: gv  reason: collision with root package name */
    public zn f5871gv;
    @Nullable

    /* renamed from: zn  reason: collision with root package name */
    public zn f5873zn;
    @NonNull
    public final Object y = new Object();
    @NonNull

    /* renamed from: n3  reason: collision with root package name */
    public final Handler f5872n3 = new Handler(Looper.getMainLooper(), new C0064y());

    /* loaded from: classes.dex */
    public interface n3 {
        void show();

        void y(int i);
    }

    /* renamed from: com.google.android.material.snackbar.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0064y implements Handler.Callback {
        public C0064y() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            if (message.what != 0) {
                return false;
            }
            y.this.gv((zn) message.obj);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class zn {

        /* renamed from: n3  reason: collision with root package name */
        public int f5874n3;
        @NonNull
        public final WeakReference<n3> y;

        /* renamed from: zn  reason: collision with root package name */
        public boolean f5875zn;

        public zn(int i, n3 n3Var) {
            this.y = new WeakReference<>(n3Var);
            this.f5874n3 = i;
        }

        public boolean y(@Nullable n3 n3Var) {
            if (n3Var != null && this.y.get() == n3Var) {
                return true;
            }
            return false;
        }
    }

    public static y zn() {
        if (f5870v == null) {
            f5870v = new y();
        }
        return f5870v;
    }

    public final boolean a(n3 n3Var) {
        zn znVar = this.f5873zn;
        if (znVar != null && znVar.y(n3Var)) {
            return true;
        }
        return false;
    }

    public void c5(n3 n3Var) {
        synchronized (this.y) {
            try {
                if (a(n3Var)) {
                    t(this.f5873zn);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void f(n3 n3Var) {
        synchronized (this.y) {
            try {
                if (a(n3Var)) {
                    zn znVar = this.f5873zn;
                    if (znVar.f5875zn) {
                        znVar.f5875zn = false;
                        t(znVar);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean fb(n3 n3Var) {
        zn znVar = this.f5871gv;
        if (znVar != null && znVar.y(n3Var)) {
            return true;
        }
        return false;
    }

    public void gv(@NonNull zn znVar) {
        synchronized (this.y) {
            try {
                if (this.f5873zn != znVar) {
                    if (this.f5871gv == znVar) {
                    }
                }
                y(znVar, 2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void i9(n3 n3Var) {
        synchronized (this.y) {
            try {
                if (a(n3Var)) {
                    zn znVar = this.f5873zn;
                    if (!znVar.f5875zn) {
                        znVar.f5875zn = true;
                        this.f5872n3.removeCallbacksAndMessages(znVar);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void n3(n3 n3Var, int i) {
        synchronized (this.y) {
            try {
                if (a(n3Var)) {
                    y(this.f5873zn, i);
                } else if (fb(n3Var)) {
                    y(this.f5871gv, i);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void s(n3 n3Var) {
        synchronized (this.y) {
            try {
                if (a(n3Var)) {
                    this.f5873zn = null;
                    if (this.f5871gv != null) {
                        wz();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void t(@NonNull zn znVar) {
        int i = znVar.f5874n3;
        if (i == -2) {
            return;
        }
        if (i <= 0) {
            if (i == -1) {
                i = ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED;
            } else {
                i = 2750;
            }
        }
        this.f5872n3.removeCallbacksAndMessages(znVar);
        Handler handler = this.f5872n3;
        handler.sendMessageDelayed(Message.obtain(handler, 0, znVar), i);
    }

    public void tl(int i, n3 n3Var) {
        synchronized (this.y) {
            try {
                if (a(n3Var)) {
                    zn znVar = this.f5873zn;
                    znVar.f5874n3 = i;
                    this.f5872n3.removeCallbacksAndMessages(znVar);
                    t(this.f5873zn);
                    return;
                }
                if (fb(n3Var)) {
                    this.f5871gv.f5874n3 = i;
                } else {
                    this.f5871gv = new zn(i, n3Var);
                }
                zn znVar2 = this.f5873zn;
                if (znVar2 != null && y(znVar2, 4)) {
                    return;
                }
                this.f5873zn = null;
                wz();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean v(n3 n3Var) {
        boolean z2;
        synchronized (this.y) {
            try {
                if (!a(n3Var) && !fb(n3Var)) {
                    z2 = false;
                }
                z2 = true;
            } finally {
            }
        }
        return z2;
    }

    public final void wz() {
        zn znVar = this.f5871gv;
        if (znVar != null) {
            this.f5873zn = znVar;
            this.f5871gv = null;
            n3 n3Var = znVar.y.get();
            if (n3Var != null) {
                n3Var.show();
            } else {
                this.f5873zn = null;
            }
        }
    }

    public final boolean y(@NonNull zn znVar, int i) {
        n3 n3Var = znVar.y.get();
        if (n3Var != null) {
            this.f5872n3.removeCallbacksAndMessages(znVar);
            n3Var.y(i);
            return true;
        }
        return false;
    }
}
