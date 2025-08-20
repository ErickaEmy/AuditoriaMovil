package ha;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import v5.rz;
/* loaded from: classes.dex */
public abstract class y {
    public final int y;

    /* loaded from: classes.dex */
    public static final class n3 extends y {

        /* renamed from: n3  reason: collision with root package name */
        public final rz f8914n3;

        public n3(int i, rz rzVar) {
            super(i);
            this.f8914n3 = rzVar;
        }
    }

    /* renamed from: ha.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0106y extends y {

        /* renamed from: gv  reason: collision with root package name */
        public final List<C0106y> f8915gv;

        /* renamed from: n3  reason: collision with root package name */
        public final long f8916n3;

        /* renamed from: zn  reason: collision with root package name */
        public final List<n3> f8917zn;

        public C0106y(int i, long j2) {
            super(i);
            this.f8916n3 = j2;
            this.f8917zn = new ArrayList();
            this.f8915gv = new ArrayList();
        }

        @Nullable
        public C0106y a(int i) {
            int size = this.f8915gv.size();
            for (int i5 = 0; i5 < size; i5++) {
                C0106y c0106y = this.f8915gv.get(i5);
                if (c0106y.y == i) {
                    return c0106y;
                }
            }
            return null;
        }

        @Nullable
        public n3 fb(int i) {
            int size = this.f8917zn.size();
            for (int i5 = 0; i5 < size; i5++) {
                n3 n3Var = this.f8917zn.get(i5);
                if (n3Var.y == i) {
                    return n3Var;
                }
            }
            return null;
        }

        public void gv(C0106y c0106y) {
            this.f8915gv.add(c0106y);
        }

        @Override // ha.y
        public String toString() {
            return y.y(this.y) + " leaves: " + Arrays.toString(this.f8917zn.toArray()) + " containers: " + Arrays.toString(this.f8915gv.toArray());
        }

        public void v(n3 n3Var) {
            this.f8917zn.add(n3Var);
        }
    }

    public y(int i) {
        this.y = i;
    }

    public static int n3(int i) {
        return i & 16777215;
    }

    public static String y(int i) {
        return "" + ((char) ((i >> 24) & 255)) + ((char) ((i >> 16) & 255)) + ((char) ((i >> 8) & 255)) + ((char) (i & 255));
    }

    public static int zn(int i) {
        return (i >> 24) & 255;
    }

    public String toString() {
        return y(this.y);
    }
}
