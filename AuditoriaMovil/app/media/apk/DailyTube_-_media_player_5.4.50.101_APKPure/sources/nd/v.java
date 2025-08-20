package nd;

import androidx.annotation.Nullable;
import bv.i9;
import java.util.List;
import java.util.Locale;
import q.f;
import q.t;
/* loaded from: classes.dex */
public class v {

    /* renamed from: a  reason: collision with root package name */
    public final long f11979a;

    /* renamed from: c5  reason: collision with root package name */
    public final t f11980c5;
    @Nullable

    /* renamed from: co  reason: collision with root package name */
    public final q.n3 f11981co;

    /* renamed from: f  reason: collision with root package name */
    public final int f11982f;
    @Nullable

    /* renamed from: f3  reason: collision with root package name */
    public final i9 f11983f3;
    @Nullable

    /* renamed from: fb  reason: collision with root package name */
    public final String f11984fb;

    /* renamed from: gv  reason: collision with root package name */
    public final long f11985gv;
    @Nullable

    /* renamed from: i4  reason: collision with root package name */
    public final wm.y f11986i4;

    /* renamed from: i9  reason: collision with root package name */
    public final int f11987i9;
    @Nullable

    /* renamed from: mt  reason: collision with root package name */
    public final f f11988mt;

    /* renamed from: n3  reason: collision with root package name */
    public final yk.s f11989n3;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    public final q.i9 f11990p;

    /* renamed from: r  reason: collision with root package name */
    public final n3 f11991r;

    /* renamed from: s  reason: collision with root package name */
    public final List<wm.s> f11992s;

    /* renamed from: t  reason: collision with root package name */
    public final int f11993t;

    /* renamed from: tl  reason: collision with root package name */
    public final float f11994tl;

    /* renamed from: v  reason: collision with root package name */
    public final y f11995v;

    /* renamed from: w  reason: collision with root package name */
    public final float f11996w;

    /* renamed from: wz  reason: collision with root package name */
    public final float f11997wz;

    /* renamed from: x4  reason: collision with root package name */
    public final boolean f11998x4;

    /* renamed from: xc  reason: collision with root package name */
    public final float f11999xc;
    public final List<wm.zn> y;

    /* renamed from: z  reason: collision with root package name */
    public final List<uo.y<Float>> f12000z;

    /* renamed from: zn  reason: collision with root package name */
    public final String f12001zn;

    /* loaded from: classes.dex */
    public enum n3 {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    /* loaded from: classes.dex */
    public enum y {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    public v(List<wm.zn> list, yk.s sVar, String str, long j2, y yVar, long j4, @Nullable String str2, List<wm.s> list2, t tVar, int i, int i5, int i6, float f4, float f6, float f9, float f10, @Nullable q.i9 i9Var, @Nullable f fVar, List<uo.y<Float>> list3, n3 n3Var, @Nullable q.n3 n3Var2, boolean z2, @Nullable wm.y yVar2, @Nullable i9 i9Var2) {
        this.y = list;
        this.f11989n3 = sVar;
        this.f12001zn = str;
        this.f11985gv = j2;
        this.f11995v = yVar;
        this.f11979a = j4;
        this.f11984fb = str2;
        this.f11992s = list2;
        this.f11980c5 = tVar;
        this.f11987i9 = i;
        this.f11982f = i5;
        this.f11993t = i6;
        this.f11994tl = f4;
        this.f11997wz = f6;
        this.f11999xc = f9;
        this.f11996w = f10;
        this.f11990p = i9Var;
        this.f11988mt = fVar;
        this.f12000z = list3;
        this.f11991r = n3Var;
        this.f11981co = n3Var2;
        this.f11998x4 = z2;
        this.f11986i4 = yVar2;
        this.f11983f3 = i9Var2;
    }

    public y a() {
        return this.f11995v;
    }

    public String c5() {
        return this.f12001zn;
    }

    @Nullable
    public q.i9 co() {
        return this.f11990p;
    }

    public float f() {
        return this.f11996w;
    }

    public boolean f3() {
        return this.f11998x4;
    }

    public List<wm.s> fb() {
        return this.f11992s;
    }

    public long gv() {
        return this.f11985gv;
    }

    public t i4() {
        return this.f11980c5;
    }

    public long i9() {
        return this.f11979a;
    }

    public float mt() {
        return this.f11997wz / this.f11989n3.v();
    }

    public String n(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(c5());
        sb.append("\n");
        v z2 = this.f11989n3.z(i9());
        if (z2 != null) {
            sb.append("\t\tParents: ");
            sb.append(z2.c5());
            v z3 = this.f11989n3.z(z2.i9());
            while (z3 != null) {
                sb.append("->");
                sb.append(z3.c5());
                z3 = this.f11989n3.z(z3.i9());
            }
            sb.append(str);
            sb.append("\n");
        }
        if (!fb().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(fb().size());
            sb.append("\n");
        }
        if (p() != 0 && w() != 0) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(p()), Integer.valueOf(w()), Integer.valueOf(xc())));
        }
        if (!this.y.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (wm.zn znVar : this.y) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(znVar);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public yk.s n3() {
        return this.f11989n3;
    }

    public int p() {
        return this.f11987i9;
    }

    @Nullable
    public q.n3 r() {
        return this.f11981co;
    }

    public n3 s() {
        return this.f11991r;
    }

    public float t() {
        return this.f11999xc;
    }

    @Nullable
    public String tl() {
        return this.f11984fb;
    }

    public String toString() {
        return n("");
    }

    public List<uo.y<Float>> v() {
        return this.f12000z;
    }

    public int w() {
        return this.f11982f;
    }

    public List<wm.zn> wz() {
        return this.y;
    }

    public float x4() {
        return this.f11994tl;
    }

    public int xc() {
        return this.f11993t;
    }

    @Nullable
    public wm.y y() {
        return this.f11986i4;
    }

    @Nullable
    public f z() {
        return this.f11988mt;
    }

    @Nullable
    public i9 zn() {
        return this.f11983f3;
    }
}
