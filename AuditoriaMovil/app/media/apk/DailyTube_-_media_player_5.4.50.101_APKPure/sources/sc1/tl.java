package sc1;

import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class tl {

    /* renamed from: zn  reason: collision with root package name */
    public static final y f13838zn = new y(null);

    /* renamed from: n3  reason: collision with root package name */
    public final int[] f13839n3 = new int[10];
    public int y;

    /* loaded from: classes.dex */
    public static final class y {
        public y() {
        }

        public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final boolean a(int i) {
        if (((1 << i) & this.y) != 0) {
            return true;
        }
        return false;
    }

    public final int c5() {
        return Integer.bitCount(this.y);
    }

    public final void fb(tl other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (int i = 0; i < 10; i++) {
            if (other.a(i)) {
                s(i, other.y(i));
            }
        }
    }

    public final int gv() {
        if ((this.y & 16) != 0) {
            return this.f13839n3[4];
        }
        return Integer.MAX_VALUE;
    }

    public final int n3() {
        if ((this.y & 2) != 0) {
            return this.f13839n3[1];
        }
        return -1;
    }

    public final tl s(int i, int i5) {
        if (i >= 0) {
            int[] iArr = this.f13839n3;
            if (i < iArr.length) {
                this.y = (1 << i) | this.y;
                iArr[i] = i5;
            }
        }
        return this;
    }

    public final int v(int i) {
        if ((this.y & 32) != 0) {
            return this.f13839n3[5];
        }
        return i;
    }

    public final int y(int i) {
        return this.f13839n3[i];
    }

    public final int zn() {
        if ((this.y & NotificationCompat.FLAG_HIGH_PRIORITY) != 0) {
            return this.f13839n3[7];
        }
        return 65535;
    }
}
