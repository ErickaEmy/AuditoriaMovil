package e4;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Arrays;
import m1.m;
/* loaded from: classes.dex */
public interface ta {

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: gv  reason: collision with root package name */
        public final int f7513gv;

        /* renamed from: n3  reason: collision with root package name */
        public final byte[] f7514n3;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f7515zn;

        public y(int i, byte[] bArr, int i5, int i6) {
            this.y = i;
            this.f7514n3 = bArr;
            this.f7515zn = i5;
            this.f7513gv = i6;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || y.class != obj.getClass()) {
                return false;
            }
            y yVar = (y) obj;
            if (this.y == yVar.y && this.f7515zn == yVar.f7515zn && this.f7513gv == yVar.f7513gv && Arrays.equals(this.f7514n3, yVar.f7514n3)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.y * 31) + Arrays.hashCode(this.f7514n3)) * 31) + this.f7515zn) * 31) + this.f7513gv;
        }
    }

    void a(v5.rz rzVar, int i, int i5);

    void gv(long j2, int i, int i5, int i6, @Nullable y yVar);

    int n3(kx.c5 c5Var, int i, boolean z2) throws IOException;

    void v(m mVar);

    int y(kx.c5 c5Var, int i, boolean z2, int i5) throws IOException;

    void zn(v5.rz rzVar, int i);
}
