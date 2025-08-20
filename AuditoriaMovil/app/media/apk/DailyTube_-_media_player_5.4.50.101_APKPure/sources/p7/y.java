package p7;

import androidx.annotation.Nullable;
import kx.p;
import m1.m;
/* loaded from: classes.dex */
public abstract class y extends wz {

    /* renamed from: f  reason: collision with root package name */
    public final long f12512f;

    /* renamed from: t  reason: collision with root package name */
    public final long f12513t;

    /* renamed from: tl  reason: collision with root package name */
    public zn f12514tl;

    /* renamed from: wz  reason: collision with root package name */
    public int[] f12515wz;

    public y(kx.tl tlVar, p pVar, m mVar, int i, @Nullable Object obj, long j2, long j4, long j6, long j7, long j8) {
        super(tlVar, pVar, mVar, i, obj, j2, j4, j8);
        this.f12512f = j6;
        this.f12513t = j7;
    }

    public final zn c5() {
        return (zn) v5.y.c5(this.f12514tl);
    }

    public void i9(zn znVar) {
        this.f12514tl = znVar;
        this.f12515wz = znVar.y();
    }

    public final int s(int i) {
        return ((int[]) v5.y.c5(this.f12515wz))[i];
    }
}
