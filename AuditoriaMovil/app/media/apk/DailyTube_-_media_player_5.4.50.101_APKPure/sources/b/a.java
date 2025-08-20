package b;

import android.os.CancellationSignal;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: gv  reason: collision with root package name */
    public boolean f3815gv;

    /* renamed from: n3  reason: collision with root package name */
    public n3 f3816n3;
    public boolean y;

    /* renamed from: zn  reason: collision with root package name */
    public Object f3817zn;

    /* loaded from: classes.dex */
    public interface n3 {
        void onCancel();
    }

    /* loaded from: classes.dex */
    public static class y {
        public static CancellationSignal n3() {
            return new CancellationSignal();
        }

        public static void y(Object obj) {
            ((CancellationSignal) obj).cancel();
        }
    }

    public final void gv() {
        while (this.f3815gv) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    public boolean n3() {
        boolean z2;
        synchronized (this) {
            z2 = this.y;
        }
        return z2;
    }

    public void y() {
        synchronized (this) {
            try {
                if (this.y) {
                    return;
                }
                this.y = true;
                this.f3815gv = true;
                n3 n3Var = this.f3816n3;
                Object obj = this.f3817zn;
                if (n3Var != null) {
                    try {
                        n3Var.onCancel();
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.f3815gv = false;
                            notifyAll();
                            throw th;
                        }
                    }
                }
                if (obj != null) {
                    y.y(obj);
                }
                synchronized (this) {
                    this.f3815gv = false;
                    notifyAll();
                }
            } finally {
            }
        }
    }

    public void zn(@Nullable n3 n3Var) {
        synchronized (this) {
            try {
                gv();
                if (this.f3816n3 == n3Var) {
                    return;
                }
                this.f3816n3 = n3Var;
                if (this.y && n3Var != null) {
                    n3Var.onCancel();
                }
            } finally {
            }
        }
    }
}
