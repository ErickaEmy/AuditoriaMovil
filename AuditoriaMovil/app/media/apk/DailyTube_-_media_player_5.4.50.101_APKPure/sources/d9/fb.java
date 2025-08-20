package d9;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import v5.j5;
/* loaded from: classes.dex */
public interface fb {
    public static final ByteBuffer y = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    /* loaded from: classes.dex */
    public static final class n3 extends Exception {
        public n3(y yVar) {
            super("Unhandled format: " + yVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: v  reason: collision with root package name */
        public static final y f7036v = new y(-1, -1, -1);

        /* renamed from: gv  reason: collision with root package name */
        public final int f7037gv;

        /* renamed from: n3  reason: collision with root package name */
        public final int f7038n3;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f7039zn;

        public y(int i, int i5, int i6) {
            int i8;
            this.y = i;
            this.f7038n3 = i5;
            this.f7039zn = i6;
            if (j5.u0(i6)) {
                i8 = j5.ct(i6, i5);
            } else {
                i8 = -1;
            }
            this.f7037gv = i8;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof y)) {
                return false;
            }
            y yVar = (y) obj;
            if (this.y == yVar.y && this.f7038n3 == yVar.f7038n3 && this.f7039zn == yVar.f7039zn) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return w0.f.n3(Integer.valueOf(this.y), Integer.valueOf(this.f7038n3), Integer.valueOf(this.f7039zn));
        }

        public String toString() {
            return "AudioFormat[sampleRate=" + this.y + ", channelCount=" + this.f7038n3 + ", encoding=" + this.f7039zn + ']';
        }
    }

    boolean a();

    void c5(ByteBuffer byteBuffer);

    ByteBuffer fb();

    void flush();

    void i9();

    boolean isActive();

    y s(y yVar) throws n3;

    void y();
}
