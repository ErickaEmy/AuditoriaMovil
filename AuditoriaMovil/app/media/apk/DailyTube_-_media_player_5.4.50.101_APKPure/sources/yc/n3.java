package yc;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class n3 {

    /* renamed from: n3  reason: collision with root package name */
    public final boolean f15329n3;
    public final String y;

    /* loaded from: classes.dex */
    public static final class y {
        public String y = "";

        /* renamed from: n3  reason: collision with root package name */
        public boolean f15330n3 = true;

        public final y n3(String adsSdkName) {
            Intrinsics.checkNotNullParameter(adsSdkName, "adsSdkName");
            this.y = adsSdkName;
            return this;
        }

        public final n3 y() {
            if (this.y.length() > 0) {
                return new n3(this.y, this.f15330n3);
            }
            throw new IllegalStateException("adsSdkName must be set");
        }

        public final y zn(boolean z2) {
            this.f15330n3 = z2;
            return this;
        }
    }

    public n3() {
        this(null, false, 3, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n3)) {
            return false;
        }
        n3 n3Var = (n3) obj;
        if (Intrinsics.areEqual(this.y, n3Var.y) && this.f15329n3 == n3Var.f15329n3) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.y.hashCode() * 31) + yc.y.y(this.f15329n3);
    }

    public final boolean n3() {
        return this.f15329n3;
    }

    public String toString() {
        return "GetTopicsRequest: adsSdkName=" + this.y + ", shouldRecordObservation=" + this.f15329n3;
    }

    public final String y() {
        return this.y;
    }

    public n3(String adsSdkName, boolean z2) {
        Intrinsics.checkNotNullParameter(adsSdkName, "adsSdkName");
        this.y = adsSdkName;
        this.f15329n3 = z2;
    }

    public /* synthetic */ n3(String str, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? false : z2);
    }
}
