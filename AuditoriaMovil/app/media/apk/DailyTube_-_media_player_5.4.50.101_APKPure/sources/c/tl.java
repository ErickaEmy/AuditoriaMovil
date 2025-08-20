package c;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class tl {

    /* renamed from: fb  reason: collision with root package name */
    public static int f3926fb;

    /* renamed from: a  reason: collision with root package name */
    public int f3927a;

    /* renamed from: gv  reason: collision with root package name */
    public ArrayList<w> f3928gv = new ArrayList<>();

    /* renamed from: n3  reason: collision with root package name */
    public w f3929n3;

    /* renamed from: v  reason: collision with root package name */
    public int f3930v;
    public boolean y;

    /* renamed from: zn  reason: collision with root package name */
    public w f3931zn;

    public tl(w wVar, int i) {
        int i5 = f3926fb;
        this.f3930v = i5;
        f3926fb = i5 + 1;
        this.f3929n3 = wVar;
        this.f3931zn = wVar;
        this.f3927a = i;
    }

    public final long gv(a aVar, long j2) {
        w wVar = aVar.f3895gv;
        if (wVar instanceof f) {
            return j2;
        }
        int size = aVar.f3893f.size();
        long j4 = j2;
        for (int i = 0; i < size; i++) {
            gv gvVar = aVar.f3893f.get(i);
            if (gvVar instanceof a) {
                a aVar2 = (a) gvVar;
                if (aVar2.f3895gv != wVar) {
                    j4 = Math.max(j4, gv(aVar2, aVar2.f3891a + j2));
                }
            }
        }
        if (aVar == wVar.f3946s) {
            long i92 = j2 + wVar.i9();
            return Math.max(Math.max(j4, gv(wVar.f3941c5, i92)), i92 - wVar.f3941c5.f3891a);
        }
        return j4;
    }

    public long n3(n.a aVar, int i) {
        w wVar;
        w wVar2;
        w wVar3;
        long i92;
        int i5;
        a aVar2;
        a aVar3;
        w wVar4;
        w wVar5 = this.f3929n3;
        long j2 = 0;
        if (wVar5 instanceof zn) {
            if (((zn) wVar5).f3940a != i) {
                return 0L;
            }
        } else if (i == 0) {
            if (!(wVar5 instanceof t)) {
                return 0L;
            }
        } else if (!(wVar5 instanceof wz)) {
            return 0L;
        }
        if (i == 0) {
            wVar = aVar.f11749v;
        } else {
            wVar = aVar.f11686a;
        }
        a aVar4 = wVar.f3946s;
        if (i == 0) {
            wVar2 = aVar.f11749v;
        } else {
            wVar2 = aVar.f11686a;
        }
        a aVar5 = wVar2.f3941c5;
        boolean contains = wVar5.f3946s.f3899t.contains(aVar4);
        boolean contains2 = this.f3929n3.f3941c5.f3899t.contains(aVar5);
        long i93 = this.f3929n3.i9();
        if (contains && contains2) {
            long gv2 = gv(this.f3929n3.f3946s, 0L);
            long zn2 = zn(this.f3929n3.f3941c5, 0L);
            long j4 = gv2 - i93;
            w wVar6 = this.f3929n3;
            int i6 = wVar6.f3941c5.f3891a;
            if (j4 >= (-i6)) {
                j4 += i6;
            }
            int i8 = wVar6.f3946s.f3891a;
            long j6 = ((-zn2) - i93) - i8;
            if (j6 >= i8) {
                j6 -= i8;
            }
            float xc2 = wVar6.f3945n3.xc(i);
            if (xc2 > 0.0f) {
                j2 = (((float) j6) / xc2) + (((float) j4) / (1.0f - xc2));
            }
            float f4 = (float) j2;
            long j7 = (f4 * xc2) + 0.5f + i93 + (f4 * (1.0f - xc2)) + 0.5f;
            i92 = wVar4.f3946s.f3891a + j7;
            i5 = this.f3929n3.f3941c5.f3891a;
        } else if (contains) {
            return Math.max(gv(this.f3929n3.f3946s, aVar3.f3891a), this.f3929n3.f3946s.f3891a + i93);
        } else if (contains2) {
            return Math.max(-zn(this.f3929n3.f3941c5, aVar2.f3891a), (-this.f3929n3.f3941c5.f3891a) + i93);
        } else {
            i92 = wVar3.f3946s.f3891a + this.f3929n3.i9();
            i5 = this.f3929n3.f3941c5.f3891a;
        }
        return i92 - i5;
    }

    public void y(w wVar) {
        this.f3928gv.add(wVar);
        this.f3931zn = wVar;
    }

    public final long zn(a aVar, long j2) {
        w wVar = aVar.f3895gv;
        if (wVar instanceof f) {
            return j2;
        }
        int size = aVar.f3893f.size();
        long j4 = j2;
        for (int i = 0; i < size; i++) {
            gv gvVar = aVar.f3893f.get(i);
            if (gvVar instanceof a) {
                a aVar2 = (a) gvVar;
                if (aVar2.f3895gv != wVar) {
                    j4 = Math.min(j4, zn(aVar2, aVar2.f3891a + j2));
                }
            }
        }
        if (aVar == wVar.f3941c5) {
            long i92 = j2 - wVar.i9();
            return Math.min(Math.min(j4, zn(wVar.f3946s, i92)), i92 - wVar.f3946s.f3891a);
        }
        return j4;
    }
}
