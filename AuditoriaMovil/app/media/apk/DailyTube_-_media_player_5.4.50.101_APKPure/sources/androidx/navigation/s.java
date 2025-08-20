package androidx.navigation;

import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a  reason: collision with root package name */
    public int f2832a;

    /* renamed from: fb  reason: collision with root package name */
    public int f2833fb;

    /* renamed from: gv  reason: collision with root package name */
    public int f2834gv;

    /* renamed from: n3  reason: collision with root package name */
    public int f2835n3;

    /* renamed from: v  reason: collision with root package name */
    public int f2836v;
    public boolean y;

    /* renamed from: zn  reason: collision with root package name */
    public boolean f2837zn;

    /* loaded from: classes.dex */
    public static final class y {
        public boolean y;

        /* renamed from: zn  reason: collision with root package name */
        public boolean f2843zn;

        /* renamed from: n3  reason: collision with root package name */
        public int f2841n3 = -1;

        /* renamed from: gv  reason: collision with root package name */
        public int f2840gv = -1;

        /* renamed from: v  reason: collision with root package name */
        public int f2842v = -1;

        /* renamed from: a  reason: collision with root package name */
        public int f2838a = -1;

        /* renamed from: fb  reason: collision with root package name */
        public int f2839fb = -1;

        @NonNull
        public y a(int i) {
            this.f2839fb = i;
            return this;
        }

        @NonNull
        public y fb(int i, boolean z2) {
            this.f2841n3 = i;
            this.f2843zn = z2;
            return this;
        }

        @NonNull
        public y gv(boolean z2) {
            this.y = z2;
            return this;
        }

        @NonNull
        public y n3(int i) {
            this.f2840gv = i;
            return this;
        }

        @NonNull
        public y v(int i) {
            this.f2838a = i;
            return this;
        }

        @NonNull
        public s y() {
            return new s(this.y, this.f2841n3, this.f2843zn, this.f2840gv, this.f2842v, this.f2838a, this.f2839fb);
        }

        @NonNull
        public y zn(int i) {
            this.f2842v = i;
            return this;
        }
    }

    public s(boolean z2, int i, boolean z3, int i5, int i6, int i8, int i10) {
        this.y = z2;
        this.f2835n3 = i;
        this.f2837zn = z3;
        this.f2834gv = i5;
        this.f2836v = i6;
        this.f2832a = i8;
        this.f2833fb = i10;
    }

    public boolean a() {
        return this.f2837zn;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || s.class != obj.getClass()) {
            return false;
        }
        s sVar = (s) obj;
        if (this.y == sVar.y && this.f2835n3 == sVar.f2835n3 && this.f2837zn == sVar.f2837zn && this.f2834gv == sVar.f2834gv && this.f2836v == sVar.f2836v && this.f2832a == sVar.f2832a && this.f2833fb == sVar.f2833fb) {
            return true;
        }
        return false;
    }

    public boolean fb() {
        return this.y;
    }

    public int gv() {
        return this.f2833fb;
    }

    public int hashCode() {
        return ((((((((((((fb() ? 1 : 0) * 31) + v()) * 31) + (a() ? 1 : 0)) * 31) + y()) * 31) + n3()) * 31) + zn()) * 31) + gv();
    }

    public int n3() {
        return this.f2836v;
    }

    public int v() {
        return this.f2835n3;
    }

    public int y() {
        return this.f2834gv;
    }

    public int zn() {
        return this.f2832a;
    }
}
