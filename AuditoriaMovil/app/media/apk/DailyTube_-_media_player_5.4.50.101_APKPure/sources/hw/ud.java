package hw;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public final class ud {
    public final v y;

    /* loaded from: classes.dex */
    public static class n3 extends y {
        public n3(@NonNull Window window, @NonNull r rVar) {
            super(window, rVar);
        }

        @Override // hw.ud.v
        public void n3(boolean z2) {
            if (z2) {
                a(67108864);
                gv(Integer.MIN_VALUE);
                zn(8192);
                return;
            }
            v(8192);
        }
    }

    /* loaded from: classes.dex */
    public static class y extends v {
        @NonNull

        /* renamed from: n3  reason: collision with root package name */
        public final r f8996n3;
        @NonNull
        public final Window y;

        public y(@NonNull Window window, @NonNull r rVar) {
            this.y = window;
            this.f8996n3 = rVar;
        }

        public void a(int i) {
            this.y.clearFlags(i);
        }

        public void gv(int i) {
            this.y.addFlags(i);
        }

        public void v(int i) {
            View decorView = this.y.getDecorView();
            decorView.setSystemUiVisibility((~i) & decorView.getSystemUiVisibility());
        }

        public void zn(int i) {
            View decorView = this.y.getDecorView();
            decorView.setSystemUiVisibility(i | decorView.getSystemUiVisibility());
        }
    }

    /* loaded from: classes.dex */
    public static class zn extends n3 {
        public zn(@NonNull Window window, @NonNull r rVar) {
            super(window, rVar);
        }

        @Override // hw.ud.v
        public void y(boolean z2) {
            if (z2) {
                a(134217728);
                gv(Integer.MIN_VALUE);
                zn(16);
                return;
            }
            v(16);
        }
    }

    public ud(@NonNull Window window, @NonNull View view) {
        r rVar = new r(view);
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            this.y = new gv(window, this, rVar);
        } else if (i >= 26) {
            this.y = new zn(window, rVar);
        } else if (i >= 23) {
            this.y = new n3(window, rVar);
        } else {
            this.y = new y(window, rVar);
        }
    }

    public void n3(boolean z2) {
        this.y.n3(z2);
    }

    public void y(boolean z2) {
        this.y.y(z2);
    }

    /* loaded from: classes.dex */
    public static class gv extends v {

        /* renamed from: gv  reason: collision with root package name */
        public final z.s<Object, WindowInsetsController.OnControllableInsetsChangedListener> f8992gv;

        /* renamed from: n3  reason: collision with root package name */
        public final WindowInsetsController f8993n3;

        /* renamed from: v  reason: collision with root package name */
        public Window f8994v;
        public final ud y;

        /* renamed from: zn  reason: collision with root package name */
        public final r f8995zn;

        public gv(@NonNull Window window, @NonNull ud udVar, @NonNull r rVar) {
            this(window.getInsetsController(), udVar, rVar);
            this.f8994v = window;
        }

        public void gv(int i) {
            View decorView = this.f8994v.getDecorView();
            decorView.setSystemUiVisibility((~i) & decorView.getSystemUiVisibility());
        }

        @Override // hw.ud.v
        public void n3(boolean z2) {
            if (z2) {
                if (this.f8994v != null) {
                    zn(8192);
                }
                this.f8993n3.setSystemBarsAppearance(8, 8);
                return;
            }
            if (this.f8994v != null) {
                gv(8192);
            }
            this.f8993n3.setSystemBarsAppearance(0, 8);
        }

        @Override // hw.ud.v
        public void y(boolean z2) {
            if (z2) {
                if (this.f8994v != null) {
                    zn(16);
                }
                this.f8993n3.setSystemBarsAppearance(16, 16);
                return;
            }
            if (this.f8994v != null) {
                gv(16);
            }
            this.f8993n3.setSystemBarsAppearance(0, 16);
        }

        public void zn(int i) {
            View decorView = this.f8994v.getDecorView();
            decorView.setSystemUiVisibility(i | decorView.getSystemUiVisibility());
        }

        public gv(@NonNull WindowInsetsController windowInsetsController, @NonNull ud udVar, @NonNull r rVar) {
            this.f8992gv = new z.s<>();
            this.f8993n3 = windowInsetsController;
            this.y = udVar;
            this.f8995zn = rVar;
        }
    }

    /* loaded from: classes.dex */
    public static class v {
        public void n3(boolean z2) {
        }

        public void y(boolean z2) {
        }
    }
}
