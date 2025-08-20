package oh;

import android.text.Layout;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public final class fb {

    /* renamed from: f  reason: collision with root package name */
    public float f12272f;

    /* renamed from: gv  reason: collision with root package name */
    public int f12274gv;
    @Nullable

    /* renamed from: mt  reason: collision with root package name */
    public n3 f12276mt;

    /* renamed from: n3  reason: collision with root package name */
    public int f12277n3;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    public String f12280t;

    /* renamed from: v  reason: collision with root package name */
    public boolean f12282v;
    @Nullable

    /* renamed from: w  reason: collision with root package name */
    public Layout.Alignment f12283w;
    @Nullable

    /* renamed from: xc  reason: collision with root package name */
    public Layout.Alignment f12285xc;
    @Nullable
    public String y;

    /* renamed from: zn  reason: collision with root package name */
    public boolean f12286zn;

    /* renamed from: a  reason: collision with root package name */
    public int f12269a = -1;

    /* renamed from: fb  reason: collision with root package name */
    public int f12273fb = -1;

    /* renamed from: s  reason: collision with root package name */
    public int f12279s = -1;

    /* renamed from: c5  reason: collision with root package name */
    public int f12270c5 = -1;

    /* renamed from: i9  reason: collision with root package name */
    public int f12275i9 = -1;

    /* renamed from: tl  reason: collision with root package name */
    public int f12281tl = -1;

    /* renamed from: wz  reason: collision with root package name */
    public int f12284wz = -1;

    /* renamed from: p  reason: collision with root package name */
    public int f12278p = -1;

    /* renamed from: co  reason: collision with root package name */
    public float f12271co = Float.MAX_VALUE;

    public int a() {
        return this.f12275i9;
    }

    public fb a8(@Nullable n3 n3Var) {
        this.f12276mt = n3Var;
        return this;
    }

    public fb c(int i) {
        this.f12275i9 = i;
        return this;
    }

    public int c5() {
        return this.f12284wz;
    }

    public boolean co() {
        if (this.f12269a == 1) {
            return true;
        }
        return false;
    }

    public fb d(int i) {
        this.f12281tl = i;
        return this;
    }

    public fb d0(@Nullable String str) {
        this.f12280t = str;
        return this;
    }

    public fb ej(@Nullable Layout.Alignment alignment) {
        this.f12285xc = alignment;
        return this;
    }

    public float f() {
        return this.f12271co;
    }

    public fb f3(@Nullable String str) {
        this.y = str;
        return this;
    }

    @Nullable
    public String fb() {
        return this.f12280t;
    }

    public fb fh(boolean z2) {
        this.f12270c5 = z2 ? 1 : 0;
        return this;
    }

    @Nullable
    public String gv() {
        return this.y;
    }

    public fb i4(int i) {
        this.f12277n3 = i;
        this.f12286zn = true;
        return this;
    }

    public int i9() {
        return this.f12281tl;
    }

    public fb mg(@Nullable Layout.Alignment alignment) {
        this.f12283w = alignment;
        return this;
    }

    public final fb mt(@Nullable fb fbVar, boolean z2) {
        int i;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        String str;
        if (fbVar != null) {
            if (!this.f12286zn && fbVar.f12286zn) {
                i4(fbVar.f12277n3);
            }
            if (this.f12279s == -1) {
                this.f12279s = fbVar.f12279s;
            }
            if (this.f12270c5 == -1) {
                this.f12270c5 = fbVar.f12270c5;
            }
            if (this.y == null && (str = fbVar.y) != null) {
                this.y = str;
            }
            if (this.f12269a == -1) {
                this.f12269a = fbVar.f12269a;
            }
            if (this.f12273fb == -1) {
                this.f12273fb = fbVar.f12273fb;
            }
            if (this.f12284wz == -1) {
                this.f12284wz = fbVar.f12284wz;
            }
            if (this.f12285xc == null && (alignment2 = fbVar.f12285xc) != null) {
                this.f12285xc = alignment2;
            }
            if (this.f12283w == null && (alignment = fbVar.f12283w) != null) {
                this.f12283w = alignment;
            }
            if (this.f12278p == -1) {
                this.f12278p = fbVar.f12278p;
            }
            if (this.f12275i9 == -1) {
                this.f12275i9 = fbVar.f12275i9;
                this.f12272f = fbVar.f12272f;
            }
            if (this.f12276mt == null) {
                this.f12276mt = fbVar.f12276mt;
            }
            if (this.f12271co == Float.MAX_VALUE) {
                this.f12271co = fbVar.f12271co;
            }
            if (z2 && !this.f12282v && fbVar.f12282v) {
                r(fbVar.f12274gv);
            }
            if (z2 && this.f12281tl == -1 && (i = fbVar.f12281tl) != -1) {
                this.f12281tl = i;
            }
        }
        return this;
    }

    public fb n(float f4) {
        this.f12272f = f4;
        return this;
    }

    public int n3() {
        if (this.f12282v) {
            return this.f12274gv;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public boolean p() {
        return this.f12286zn;
    }

    public fb r(int i) {
        this.f12274gv = i;
        this.f12282v = true;
        return this;
    }

    public fb rz(boolean z2) {
        this.f12269a = z2 ? 1 : 0;
        return this;
    }

    @Nullable
    public Layout.Alignment s() {
        return this.f12283w;
    }

    public int t() {
        int i;
        int i5 = this.f12279s;
        if (i5 == -1 && this.f12270c5 == -1) {
            return -1;
        }
        int i6 = 0;
        if (i5 == 1) {
            i = 1;
        } else {
            i = 0;
        }
        if (this.f12270c5 == 1) {
            i6 = 2;
        }
        return i | i6;
    }

    public fb ta(int i) {
        this.f12284wz = i;
        return this;
    }

    @Nullable
    public Layout.Alignment tl() {
        return this.f12285xc;
    }

    public fb ud(boolean z2) {
        this.f12278p = z2 ? 1 : 0;
        return this;
    }

    public float v() {
        return this.f12272f;
    }

    public boolean w() {
        return this.f12282v;
    }

    public boolean wz() {
        if (this.f12278p == 1) {
            return true;
        }
        return false;
    }

    public fb x(boolean z2) {
        this.f12273fb = z2 ? 1 : 0;
        return this;
    }

    public fb x4(boolean z2) {
        this.f12279s = z2 ? 1 : 0;
        return this;
    }

    @Nullable
    public n3 xc() {
        return this.f12276mt;
    }

    public fb y(@Nullable fb fbVar) {
        return mt(fbVar, true);
    }

    public boolean z() {
        if (this.f12273fb == 1) {
            return true;
        }
        return false;
    }

    public fb z6(float f4) {
        this.f12271co = f4;
        return this;
    }

    public int zn() {
        if (this.f12286zn) {
            return this.f12277n3;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }
}
