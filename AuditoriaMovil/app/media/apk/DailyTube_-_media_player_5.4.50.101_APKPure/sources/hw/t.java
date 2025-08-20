package hw;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class t {

    /* renamed from: gv  reason: collision with root package name */
    public boolean f8988gv;

    /* renamed from: n3  reason: collision with root package name */
    public ViewParent f8989n3;

    /* renamed from: v  reason: collision with root package name */
    public int[] f8990v;
    public ViewParent y;

    /* renamed from: zn  reason: collision with root package name */
    public final View f8991zn;

    public t(@NonNull View view) {
        this.f8991zn = view;
    }

    public boolean a(int i, int i5, int i6, int i8, @Nullable int[] iArr) {
        return s(i, i5, i6, i8, iArr, 0, null);
    }

    public final ViewParent c5(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return this.f8989n3;
        }
        return this.y;
    }

    public void co(int i) {
        ViewParent c52 = c5(i);
        if (c52 != null) {
            fh.fb(c52, this.f8991zn, i);
            xc(i, null);
        }
    }

    public boolean f() {
        return t(0);
    }

    public boolean fb(int i, int i5, int i6, int i8, @Nullable int[] iArr, int i10) {
        return s(i, i5, i6, i8, iArr, i10, null);
    }

    public boolean gv(int i, int i5, @Nullable int[] iArr, @Nullable int[] iArr2, int i6) {
        ViewParent c52;
        int i8;
        int i10;
        if (!tl() || (c52 = c5(i6)) == null) {
            return false;
        }
        if (i == 0 && i5 == 0) {
            if (iArr2 == null) {
                return false;
            }
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
        if (iArr2 != null) {
            this.f8991zn.getLocationInWindow(iArr2);
            i8 = iArr2[0];
            i10 = iArr2[1];
        } else {
            i8 = 0;
            i10 = 0;
        }
        if (iArr == null) {
            iArr = i9();
        }
        iArr[0] = 0;
        iArr[1] = 0;
        fh.zn(c52, this.f8991zn, i, i5, iArr, i6);
        if (iArr2 != null) {
            this.f8991zn.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i8;
            iArr2[1] = iArr2[1] - i10;
        }
        if (iArr[0] == 0 && iArr[1] == 0) {
            return false;
        }
        return true;
    }

    public final int[] i9() {
        if (this.f8990v == null) {
            this.f8990v = new int[2];
        }
        return this.f8990v;
    }

    public void mt() {
        co(0);
    }

    public boolean n3(float f4, float f6) {
        ViewParent c52;
        if (!tl() || (c52 = c5(0)) == null) {
            return false;
        }
        return fh.n3(c52, this.f8991zn, f4, f6);
    }

    public boolean p(int i, int i5) {
        if (t(i5)) {
            return true;
        }
        if (tl()) {
            View view = this.f8991zn;
            for (ViewParent parent = this.f8991zn.getParent(); parent != null; parent = parent.getParent()) {
                if (fh.a(parent, view, this.f8991zn, i, i5)) {
                    xc(i5, parent);
                    fh.v(parent, view, this.f8991zn, i, i5);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
            return false;
        }
        return false;
    }

    public final boolean s(int i, int i5, int i6, int i8, @Nullable int[] iArr, int i10, @Nullable int[] iArr2) {
        ViewParent c52;
        int i11;
        int i12;
        int[] iArr3;
        if (!tl() || (c52 = c5(i10)) == null) {
            return false;
        }
        if (i == 0 && i5 == 0 && i6 == 0 && i8 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.f8991zn.getLocationInWindow(iArr);
            i11 = iArr[0];
            i12 = iArr[1];
        } else {
            i11 = 0;
            i12 = 0;
        }
        if (iArr2 == null) {
            int[] i92 = i9();
            i92[0] = 0;
            i92[1] = 0;
            iArr3 = i92;
        } else {
            iArr3 = iArr2;
        }
        fh.gv(c52, this.f8991zn, i, i5, i6, i8, i10, iArr3);
        if (iArr != null) {
            this.f8991zn.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i11;
            iArr[1] = iArr[1] - i12;
        }
        return true;
    }

    public boolean t(int i) {
        if (c5(i) != null) {
            return true;
        }
        return false;
    }

    public boolean tl() {
        return this.f8988gv;
    }

    public void v(int i, int i5, int i6, int i8, @Nullable int[] iArr, int i10, @Nullable int[] iArr2) {
        s(i, i5, i6, i8, iArr, i10, iArr2);
    }

    public boolean w(int i) {
        return p(i, 0);
    }

    public void wz(boolean z2) {
        if (this.f8988gv) {
            i4.w2(this.f8991zn);
        }
        this.f8988gv = z2;
    }

    public final void xc(int i, ViewParent viewParent) {
        if (i != 0) {
            if (i == 1) {
                this.f8989n3 = viewParent;
                return;
            }
            return;
        }
        this.y = viewParent;
    }

    public boolean y(float f4, float f6, boolean z2) {
        ViewParent c52;
        if (!tl() || (c52 = c5(0)) == null) {
            return false;
        }
        return fh.y(c52, this.f8991zn, f4, f6, z2);
    }

    public boolean zn(int i, int i5, @Nullable int[] iArr, @Nullable int[] iArr2) {
        return gv(i, i5, iArr, iArr2, 0);
    }
}
