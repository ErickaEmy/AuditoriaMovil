package l;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public final class n3 {

    /* renamed from: c5  reason: collision with root package name */
    public static final n3 f10204c5 = new y().y();

    /* renamed from: a  reason: collision with root package name */
    public long f10205a;

    /* renamed from: fb  reason: collision with root package name */
    public long f10206fb;

    /* renamed from: gv  reason: collision with root package name */
    public boolean f10207gv;

    /* renamed from: n3  reason: collision with root package name */
    public boolean f10208n3;

    /* renamed from: s  reason: collision with root package name */
    public zn f10209s;

    /* renamed from: v  reason: collision with root package name */
    public boolean f10210v;
    public t y;

    /* renamed from: zn  reason: collision with root package name */
    public boolean f10211zn;

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: gv  reason: collision with root package name */
        public boolean f10214gv;

        /* renamed from: n3  reason: collision with root package name */
        public boolean f10215n3;

        /* renamed from: v  reason: collision with root package name */
        public boolean f10217v;
        public boolean y;

        /* renamed from: zn  reason: collision with root package name */
        public t f10218zn = t.NOT_REQUIRED;

        /* renamed from: a  reason: collision with root package name */
        public long f10212a = -1;

        /* renamed from: fb  reason: collision with root package name */
        public long f10213fb = -1;

        /* renamed from: s  reason: collision with root package name */
        public zn f10216s = new zn();

        @NonNull
        public y n3(@NonNull t tVar) {
            this.f10218zn = tVar;
            return this;
        }

        @NonNull
        public n3 y() {
            return new n3(this);
        }
    }

    public n3() {
        this.y = t.NOT_REQUIRED;
        this.f10205a = -1L;
        this.f10206fb = -1L;
        this.f10209s = new zn();
    }

    public boolean a() {
        return this.f10207gv;
    }

    public boolean c5() {
        return this.f10210v;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n3.class != obj.getClass()) {
            return false;
        }
        n3 n3Var = (n3) obj;
        if (this.f10208n3 != n3Var.f10208n3 || this.f10211zn != n3Var.f10211zn || this.f10207gv != n3Var.f10207gv || this.f10210v != n3Var.f10210v || this.f10205a != n3Var.f10205a || this.f10206fb != n3Var.f10206fb || this.y != n3Var.y) {
            return false;
        }
        return this.f10209s.equals(n3Var.f10209s);
    }

    public void f(@NonNull t tVar) {
        this.y = tVar;
    }

    public boolean fb() {
        return this.f10208n3;
    }

    public long gv() {
        return this.f10206fb;
    }

    public int hashCode() {
        long j2 = this.f10205a;
        long j4 = this.f10206fb;
        return (((((((((((((this.y.hashCode() * 31) + (this.f10208n3 ? 1 : 0)) * 31) + (this.f10211zn ? 1 : 0)) * 31) + (this.f10207gv ? 1 : 0)) * 31) + (this.f10210v ? 1 : 0)) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + this.f10209s.hashCode();
    }

    public void i9(@Nullable zn znVar) {
        this.f10209s = znVar;
    }

    @NonNull
    public t n3() {
        return this.y;
    }

    public void p(long j2) {
        this.f10206fb = j2;
    }

    public boolean s() {
        return this.f10211zn;
    }

    public void t(boolean z2) {
        this.f10207gv = z2;
    }

    public void tl(boolean z2) {
        this.f10208n3 = z2;
    }

    public boolean v() {
        if (this.f10209s.zn() > 0) {
            return true;
        }
        return false;
    }

    public void w(long j2) {
        this.f10205a = j2;
    }

    public void wz(boolean z2) {
        this.f10211zn = z2;
    }

    public void xc(boolean z2) {
        this.f10210v = z2;
    }

    @NonNull
    public zn y() {
        return this.f10209s;
    }

    public long zn() {
        return this.f10205a;
    }

    public n3(y yVar) {
        this.y = t.NOT_REQUIRED;
        this.f10205a = -1L;
        this.f10206fb = -1L;
        this.f10209s = new zn();
        this.f10208n3 = yVar.y;
        int i = Build.VERSION.SDK_INT;
        this.f10211zn = i >= 23 && yVar.f10215n3;
        this.y = yVar.f10218zn;
        this.f10207gv = yVar.f10214gv;
        this.f10210v = yVar.f10217v;
        if (i >= 24) {
            this.f10209s = yVar.f10216s;
            this.f10205a = yVar.f10212a;
            this.f10206fb = yVar.f10213fb;
        }
    }

    public n3(@NonNull n3 n3Var) {
        this.y = t.NOT_REQUIRED;
        this.f10205a = -1L;
        this.f10206fb = -1L;
        this.f10209s = new zn();
        this.f10208n3 = n3Var.f10208n3;
        this.f10211zn = n3Var.f10211zn;
        this.y = n3Var.y;
        this.f10207gv = n3Var.f10207gv;
        this.f10210v = n3Var.f10210v;
        this.f10209s = n3Var.f10209s;
    }
}
