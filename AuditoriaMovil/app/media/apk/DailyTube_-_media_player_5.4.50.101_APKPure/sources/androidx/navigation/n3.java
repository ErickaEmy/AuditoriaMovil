package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import lc.f;
/* loaded from: classes.dex */
public final class n3 {
    @Nullable

    /* renamed from: gv  reason: collision with root package name */
    public final Object f2826gv;

    /* renamed from: n3  reason: collision with root package name */
    public final boolean f2827n3;
    @NonNull
    public final f y;

    /* renamed from: zn  reason: collision with root package name */
    public final boolean f2828zn;

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: gv  reason: collision with root package name */
        public boolean f2829gv;

        /* renamed from: n3  reason: collision with root package name */
        public boolean f2830n3;
        @Nullable
        public f<?> y;
        @Nullable

        /* renamed from: zn  reason: collision with root package name */
        public Object f2831zn;

        @NonNull
        public y gv(@NonNull f<?> fVar) {
            this.y = fVar;
            return this;
        }

        @NonNull
        public y n3(@Nullable Object obj) {
            this.f2831zn = obj;
            this.f2829gv = true;
            return this;
        }

        @NonNull
        public n3 y() {
            if (this.y == null) {
                this.y = f.v(this.f2831zn);
            }
            return new n3(this.y, this.f2830n3, this.f2831zn, this.f2829gv);
        }

        @NonNull
        public y zn(boolean z2) {
            this.f2830n3 = z2;
            return this;
        }
    }

    public n3(@NonNull f<?> fVar, boolean z2, @Nullable Object obj, boolean z3) {
        if (!fVar.a() && z2) {
            throw new IllegalArgumentException(fVar.zn() + " does not allow nullable values");
        } else if (!z2 && z3 && obj == null) {
            throw new IllegalArgumentException("Argument with type " + fVar.zn() + " has null value but is not nullable.");
        } else {
            this.y = fVar;
            this.f2827n3 = z2;
            this.f2826gv = obj;
            this.f2828zn = z3;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n3.class != obj.getClass()) {
            return false;
        }
        n3 n3Var = (n3) obj;
        if (this.f2827n3 != n3Var.f2827n3 || this.f2828zn != n3Var.f2828zn || !this.y.equals(n3Var.y)) {
            return false;
        }
        Object obj2 = this.f2826gv;
        if (obj2 != null) {
            return obj2.equals(n3Var.f2826gv);
        }
        if (n3Var.f2826gv == null) {
            return true;
        }
        return false;
    }

    public boolean gv(@NonNull String str, @NonNull Bundle bundle) {
        if (!this.f2827n3 && bundle.containsKey(str) && bundle.get(str) == null) {
            return false;
        }
        try {
            this.y.n3(bundle, str);
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public int hashCode() {
        int i;
        int hashCode = ((((this.y.hashCode() * 31) + (this.f2827n3 ? 1 : 0)) * 31) + (this.f2828zn ? 1 : 0)) * 31;
        Object obj = this.f2826gv;
        if (obj != null) {
            i = obj.hashCode();
        } else {
            i = 0;
        }
        return hashCode + i;
    }

    public boolean n3() {
        return this.f2828zn;
    }

    @NonNull
    public f<?> y() {
        return this.y;
    }

    public void zn(@NonNull String str, @NonNull Bundle bundle) {
        if (this.f2828zn) {
            this.y.c5(bundle, str, this.f2826gv);
        }
    }
}
