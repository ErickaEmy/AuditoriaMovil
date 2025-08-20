package androidx.recyclerview.widget;

import android.view.View;
import com.uv.v7.R;
/* loaded from: classes.dex */
public class p {

    /* renamed from: n3  reason: collision with root package name */
    public y f3266n3 = new y();
    public final n3 y;

    /* loaded from: classes.dex */
    public interface n3 {
        int gv();

        int n3(View view);

        int v(View view);

        View y(int i);

        int zn();
    }

    /* loaded from: classes.dex */
    public static class y {

        /* renamed from: gv  reason: collision with root package name */
        public int f3267gv;

        /* renamed from: n3  reason: collision with root package name */
        public int f3268n3;

        /* renamed from: v  reason: collision with root package name */
        public int f3269v;
        public int y;

        /* renamed from: zn  reason: collision with root package name */
        public int f3270zn;

        public void gv() {
            this.y = 0;
        }

        public boolean n3() {
            int i = this.y;
            if ((i & 7) != 0 && (i & zn(this.f3267gv, this.f3268n3)) == 0) {
                return false;
            }
            int i5 = this.y;
            if ((i5 & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) != 0 && (i5 & (zn(this.f3267gv, this.f3270zn) << 4)) == 0) {
                return false;
            }
            int i6 = this.y;
            if ((i6 & 1792) != 0 && (i6 & (zn(this.f3269v, this.f3268n3) << 8)) == 0) {
                return false;
            }
            int i8 = this.y;
            if ((i8 & 28672) != 0 && (i8 & (zn(this.f3269v, this.f3270zn) << 12)) == 0) {
                return false;
            }
            return true;
        }

        public void v(int i, int i5, int i6, int i8) {
            this.f3268n3 = i;
            this.f3270zn = i5;
            this.f3267gv = i6;
            this.f3269v = i8;
        }

        public void y(int i) {
            this.y = i | this.y;
        }

        public int zn(int i, int i5) {
            if (i > i5) {
                return 1;
            }
            return i == i5 ? 2 : 4;
        }
    }

    public p(n3 n3Var) {
        this.y = n3Var;
    }

    public boolean n3(View view, int i) {
        this.f3266n3.v(this.y.zn(), this.y.gv(), this.y.n3(view), this.y.v(view));
        if (i != 0) {
            this.f3266n3.gv();
            this.f3266n3.y(i);
            return this.f3266n3.n3();
        }
        return false;
    }

    public View y(int i, int i5, int i6, int i8) {
        int i10;
        int zn2 = this.y.zn();
        int gv2 = this.y.gv();
        if (i5 > i) {
            i10 = 1;
        } else {
            i10 = -1;
        }
        View view = null;
        while (i != i5) {
            View y2 = this.y.y(i);
            this.f3266n3.v(zn2, gv2, this.y.n3(y2), this.y.v(y2));
            if (i6 != 0) {
                this.f3266n3.gv();
                this.f3266n3.y(i6);
                if (this.f3266n3.n3()) {
                    return y2;
                }
            }
            if (i8 != 0) {
                this.f3266n3.gv();
                this.f3266n3.y(i8);
                if (this.f3266n3.n3()) {
                    view = y2;
                }
            }
            i += i10;
        }
        return view;
    }
}
