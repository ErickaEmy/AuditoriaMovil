package zo;

import af.rs;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import m1.m;
import v5.j5;
/* loaded from: classes.dex */
public abstract class zn implements co {

    /* renamed from: a  reason: collision with root package name */
    public final long[] f15915a;

    /* renamed from: fb  reason: collision with root package name */
    public int f15916fb;

    /* renamed from: gv  reason: collision with root package name */
    public final int f15917gv;

    /* renamed from: n3  reason: collision with root package name */
    public final int f15918n3;

    /* renamed from: v  reason: collision with root package name */
    public final m[] f15919v;
    public final rs y;

    /* renamed from: zn  reason: collision with root package name */
    public final int[] f15920zn;

    public zn(rs rsVar, int... iArr) {
        this(rsVar, iArr, 0);
    }

    public static /* synthetic */ int i4(m mVar, m mVar2) {
        return mVar2.f10959p - mVar.f10959p;
    }

    @Override // zo.x4
    public final m a(int i) {
        return this.f15919v[i];
    }

    @Override // zo.co
    public /* synthetic */ boolean c5(long j2, p7.a aVar, List list) {
        return mt.gv(this, j2, aVar, list);
    }

    @Override // zo.co
    public final m co() {
        return this.f15919v[zn()];
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zn znVar = (zn) obj;
        if (this.y == znVar.y && Arrays.equals(this.f15920zn, znVar.f15920zn)) {
            return true;
        }
        return false;
    }

    @Override // zo.co
    public boolean gv(int i, long j2) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean v2 = v(i, elapsedRealtime);
        for (int i5 = 0; i5 < this.f15918n3 && !v2; i5++) {
            if (i5 != i && !v(i5, elapsedRealtime)) {
                v2 = true;
            } else {
                v2 = false;
            }
        }
        if (!v2) {
            return false;
        }
        long[] jArr = this.f15915a;
        jArr[i] = Math.max(jArr[i], j5.n3(elapsedRealtime, j2, Long.MAX_VALUE));
        return true;
    }

    public int hashCode() {
        if (this.f15916fb == 0) {
            this.f15916fb = (System.identityHashCode(this.y) * 31) + Arrays.hashCode(this.f15920zn);
        }
        return this.f15916fb;
    }

    @Override // zo.x4
    public final int length() {
        return this.f15920zn.length;
    }

    @Override // zo.co
    public final int mt() {
        return this.f15920zn[zn()];
    }

    @Override // zo.co
    public int p(long j2, List<? extends p7.wz> list) {
        return list.size();
    }

    @Override // zo.co
    public /* synthetic */ void r() {
        mt.zn(this);
    }

    @Override // zo.x4
    public final int s(int i) {
        return this.f15920zn[i];
    }

    @Override // zo.co
    public /* synthetic */ void t() {
        mt.y(this);
    }

    @Override // zo.x4
    public final int tl(int i) {
        for (int i5 = 0; i5 < this.f15918n3; i5++) {
            if (this.f15920zn[i5] == i) {
                return i5;
            }
        }
        return -1;
    }

    @Override // zo.co
    public boolean v(int i, long j2) {
        if (this.f15915a[i] > j2) {
            return true;
        }
        return false;
    }

    @Override // zo.co
    public /* synthetic */ void w(boolean z2) {
        mt.n3(this, z2);
    }

    @Override // zo.x4
    public final int wz(m mVar) {
        for (int i = 0; i < this.f15918n3; i++) {
            if (this.f15919v[i] == mVar) {
                return i;
            }
        }
        return -1;
    }

    @Override // zo.x4
    public final rs xc() {
        return this.y;
    }

    public zn(rs rsVar, int[] iArr, int i) {
        int i5 = 0;
        v5.y.fb(iArr.length > 0);
        this.f15917gv = i;
        this.y = (rs) v5.y.v(rsVar);
        int length = iArr.length;
        this.f15918n3 = length;
        this.f15919v = new m[length];
        for (int i6 = 0; i6 < iArr.length; i6++) {
            this.f15919v[i6] = rsVar.zn(iArr[i6]);
        }
        Arrays.sort(this.f15919v, new Comparator() { // from class: zo.n3
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int i42;
                i42 = zn.i4((m) obj, (m) obj2);
                return i42;
            }
        });
        this.f15920zn = new int[this.f15918n3];
        while (true) {
            int i8 = this.f15918n3;
            if (i5 < i8) {
                this.f15920zn[i5] = rsVar.gv(this.f15919v[i5]);
                i5++;
            } else {
                this.f15915a = new long[i8];
                return;
            }
        }
    }

    @Override // zo.co
    public void fb() {
    }

    @Override // zo.co
    public void y() {
    }

    @Override // zo.co
    public void i9(float f4) {
    }
}
