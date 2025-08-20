package zo;

import af.mg;
import af.rs;
import androidx.annotation.Nullable;
import java.util.List;
import m1.hy;
import m1.m;
/* loaded from: classes.dex */
public interface co extends x4 {

    /* loaded from: classes.dex */
    public interface n3 {
        co[] y(y[] yVarArr, kx.a aVar, mg.n3 n3Var, hy hyVar);
    }

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: n3  reason: collision with root package name */
        public final int[] f15756n3;
        public final rs y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f15757zn;

        public y(rs rsVar, int... iArr) {
            this(rsVar, iArr, 0);
        }

        public y(rs rsVar, int[] iArr, int i) {
            if (iArr.length == 0) {
                v5.r.gv("ETSDefinition", "Empty tracks are not allowed", new IllegalArgumentException());
            }
            this.y = rsVar;
            this.f15756n3 = iArr;
            this.f15757zn = i;
        }
    }

    boolean c5(long j2, p7.a aVar, List<? extends p7.wz> list);

    m co();

    @Nullable
    Object f();

    void fb();

    boolean gv(int i, long j2);

    void i9(float f4);

    int mt();

    void n3(long j2, long j4, long j6, List<? extends p7.wz> list, p7.xc[] xcVarArr);

    int p(long j2, List<? extends p7.wz> list);

    void r();

    void t();

    boolean v(int i, long j2);

    void w(boolean z2);

    void y();

    int z();

    int zn();
}
