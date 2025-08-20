package e4;

import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public interface fh {

    /* loaded from: classes.dex */
    public static class n3 implements fh {

        /* renamed from: n3  reason: collision with root package name */
        public final y f7503n3;
        public final long y;

        public n3(long j2) {
            this(j2, 0L);
        }

        @Override // e4.fh
        public long c5() {
            return this.y;
        }

        @Override // e4.fh
        public y gv(long j2) {
            return this.f7503n3;
        }

        @Override // e4.fh
        public boolean s() {
            return false;
        }

        public n3(long j2, long j4) {
            this.y = j2;
            this.f7503n3 = new y(j4 == 0 ? rz.f7511zn : new rz(0L, j4));
        }
    }

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: n3  reason: collision with root package name */
        public final rz f7504n3;
        public final rz y;

        public y(rz rzVar) {
            this(rzVar, rzVar);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || y.class != obj.getClass()) {
                return false;
            }
            y yVar = (y) obj;
            if (this.y.equals(yVar.y) && this.f7504n3.equals(yVar.f7504n3)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.y.hashCode() * 31) + this.f7504n3.hashCode();
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(this.y);
            if (this.y.equals(this.f7504n3)) {
                str = "";
            } else {
                str = ", " + this.f7504n3;
            }
            sb.append(str);
            sb.append("]");
            return sb.toString();
        }

        public y(rz rzVar, rz rzVar2) {
            this.y = (rz) v5.y.v(rzVar);
            this.f7504n3 = (rz) v5.y.v(rzVar2);
        }
    }

    long c5();

    y gv(long j2);

    boolean s();
}
