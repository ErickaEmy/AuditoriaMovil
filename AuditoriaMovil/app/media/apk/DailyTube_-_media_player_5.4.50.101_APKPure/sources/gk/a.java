package gk;

import androidx.annotation.Nullable;
import gk.v;
import java.util.ArrayList;
import java.util.zip.Inflater;
import v5.fh;
import v5.j5;
import v5.rz;
/* loaded from: classes.dex */
public final class a {
    @Nullable
    public static ArrayList<v.y> a(rz rzVar) {
        int p2;
        rzVar.ut(8);
        int a2 = rzVar.a();
        int fb2 = rzVar.fb();
        while (a2 < fb2 && (p2 = rzVar.p() + a2) > a2 && p2 <= fb2) {
            int p3 = rzVar.p();
            if (p3 != 2037673328 && p3 != 1836279920) {
                rzVar.oz(p2);
                a2 = p2;
            } else {
                rzVar.j(p2);
                return v(rzVar);
            }
        }
        return null;
    }

    @Nullable
    public static ArrayList<v.y> fb(rz rzVar) {
        ArrayList<v.y> arrayList = new ArrayList<>();
        int a2 = rzVar.a();
        int fb2 = rzVar.fb();
        while (a2 < fb2) {
            int p2 = rzVar.p() + a2;
            if (p2 <= a2 || p2 > fb2) {
                return null;
            }
            if (rzVar.p() == 1835365224) {
                v.y gv2 = gv(rzVar);
                if (gv2 == null) {
                    return null;
                }
                arrayList.add(gv2);
            }
            rzVar.oz(p2);
            a2 = p2;
        }
        return arrayList;
    }

    @Nullable
    public static v.y gv(rz rzVar) {
        int p2 = rzVar.p();
        if (p2 > 10000) {
            return null;
        }
        float[] fArr = new float[p2];
        for (int i = 0; i < p2; i++) {
            fArr[i] = rzVar.w();
        }
        int p3 = rzVar.p();
        if (p3 > 32000) {
            return null;
        }
        double d2 = 2.0d;
        double log = Math.log(2.0d);
        int ceil = (int) Math.ceil(Math.log(p2 * 2.0d) / log);
        fh fhVar = new fh(rzVar.v());
        int i5 = 8;
        fhVar.w(rzVar.a() * 8);
        float[] fArr2 = new float[p3 * 5];
        int i6 = 5;
        int[] iArr = new int[5];
        int i8 = 0;
        int i10 = 0;
        while (i8 < p3) {
            int i11 = 0;
            while (i11 < i6) {
                int n32 = iArr[i11] + n3(fhVar.s(ceil));
                if (n32 >= p2 || n32 < 0) {
                    return null;
                }
                fArr2[i10] = fArr[n32];
                iArr[i11] = n32;
                i11++;
                i10++;
                i6 = 5;
            }
            i8++;
            i6 = 5;
        }
        fhVar.w((fhVar.v() + 7) & (-8));
        int i12 = 32;
        int s2 = fhVar.s(32);
        v.n3[] n3VarArr = new v.n3[s2];
        int i13 = 0;
        while (i13 < s2) {
            int s3 = fhVar.s(i5);
            int s4 = fhVar.s(i5);
            int s5 = fhVar.s(i12);
            if (s5 > 128000) {
                return null;
            }
            int ceil2 = (int) Math.ceil(Math.log(p3 * d2) / log);
            float[] fArr3 = new float[s5 * 3];
            float[] fArr4 = new float[s5 * 2];
            int i14 = 0;
            for (int i15 = 0; i15 < s5; i15++) {
                i14 += n3(fhVar.s(ceil2));
                if (i14 < 0 || i14 >= p3) {
                    return null;
                }
                int i16 = i15 * 3;
                int i17 = i14 * 5;
                fArr3[i16] = fArr2[i17];
                fArr3[i16 + 1] = fArr2[i17 + 1];
                fArr3[i16 + 2] = fArr2[i17 + 2];
                int i18 = i15 * 2;
                fArr4[i18] = fArr2[i17 + 3];
                fArr4[i18 + 1] = fArr2[i17 + 4];
            }
            n3VarArr[i13] = new v.n3(s3, fArr3, fArr4, s4);
            i13++;
            i12 = 32;
            d2 = 2.0d;
            i5 = 8;
        }
        return new v.y(n3VarArr);
    }

    public static int n3(int i) {
        return (-(i & 1)) ^ (i >> 1);
    }

    @Nullable
    public static ArrayList<v.y> v(rz rzVar) {
        if (rzVar.ej() != 0) {
            return null;
        }
        rzVar.ut(7);
        int p2 = rzVar.p();
        if (p2 == 1684433976) {
            rz rzVar2 = new rz();
            Inflater inflater = new Inflater(true);
            try {
                if (!j5.rb(rzVar, rzVar2, inflater)) {
                    return null;
                }
                inflater.end();
                rzVar = rzVar2;
            } finally {
                inflater.end();
            }
        } else if (p2 != 1918990112) {
            return null;
        }
        return fb(rzVar);
    }

    @Nullable
    public static v y(byte[] bArr, int i) {
        ArrayList<v.y> arrayList;
        rz rzVar = new rz(bArr);
        try {
            if (zn(rzVar)) {
                arrayList = a(rzVar);
            } else {
                arrayList = v(rzVar);
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            arrayList = null;
        }
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        if (size != 1) {
            if (size != 2) {
                return null;
            }
            return new v(arrayList.get(0), arrayList.get(1), i);
        }
        return new v(arrayList.get(0), i);
    }

    public static boolean zn(rz rzVar) {
        rzVar.ut(4);
        int p2 = rzVar.p();
        rzVar.oz(0);
        if (p2 != 1886547818) {
            return false;
        }
        return true;
    }
}
