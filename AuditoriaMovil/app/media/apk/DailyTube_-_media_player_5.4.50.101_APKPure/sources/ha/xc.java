package ha;

import androidx.annotation.Nullable;
import m1.m;
/* loaded from: classes.dex */
public final class xc {

    /* renamed from: a  reason: collision with root package name */
    public final m f8904a;
    @Nullable

    /* renamed from: c5  reason: collision with root package name */
    public final long[] f8905c5;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final w[] f8906f;

    /* renamed from: fb  reason: collision with root package name */
    public final int f8907fb;

    /* renamed from: gv  reason: collision with root package name */
    public final long f8908gv;

    /* renamed from: i9  reason: collision with root package name */
    public final int f8909i9;

    /* renamed from: n3  reason: collision with root package name */
    public final int f8910n3;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    public final long[] f8911s;

    /* renamed from: v  reason: collision with root package name */
    public final long f8912v;
    public final int y;

    /* renamed from: zn  reason: collision with root package name */
    public final long f8913zn;

    public xc(int i, int i5, long j2, long j4, long j6, m mVar, int i6, @Nullable w[] wVarArr, int i8, @Nullable long[] jArr, @Nullable long[] jArr2) {
        this.y = i;
        this.f8910n3 = i5;
        this.f8913zn = j2;
        this.f8908gv = j4;
        this.f8912v = j6;
        this.f8904a = mVar;
        this.f8907fb = i6;
        this.f8906f = wVarArr;
        this.f8909i9 = i8;
        this.f8911s = jArr;
        this.f8905c5 = jArr2;
    }

    @Nullable
    public w y(int i) {
        w[] wVarArr = this.f8906f;
        if (wVarArr == null) {
            return null;
        }
        return wVarArr[i];
    }
}
