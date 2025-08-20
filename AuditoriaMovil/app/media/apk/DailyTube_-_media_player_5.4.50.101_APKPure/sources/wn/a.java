package wn;

import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import m1.ne;
import v5.c;
import v5.rz;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final int f14551a;
    @Nullable

    /* renamed from: c5  reason: collision with root package name */
    public final String f14552c5;

    /* renamed from: fb  reason: collision with root package name */
    public final int f14553fb;

    /* renamed from: gv  reason: collision with root package name */
    public final int f14554gv;

    /* renamed from: n3  reason: collision with root package name */
    public final int f14555n3;

    /* renamed from: s  reason: collision with root package name */
    public final int f14556s;

    /* renamed from: v  reason: collision with root package name */
    public final float f14557v;
    public final List<byte[]> y;

    /* renamed from: zn  reason: collision with root package name */
    public final int f14558zn;

    public a(List<byte[]> list, int i, int i5, int i6, float f4, @Nullable String str, int i8, int i10, int i11) {
        this.y = list;
        this.f14555n3 = i;
        this.f14558zn = i5;
        this.f14554gv = i6;
        this.f14557v = f4;
        this.f14552c5 = str;
        this.f14551a = i8;
        this.f14553fb = i10;
        this.f14556s = i11;
    }

    public static a y(rz rzVar) throws ne {
        List singletonList;
        int i;
        int i5;
        try {
            rzVar.ut(21);
            int ej2 = rzVar.ej() & 3;
            int ej3 = rzVar.ej();
            int a2 = rzVar.a();
            int i6 = 0;
            int i8 = 0;
            for (int i10 = 0; i10 < ej3; i10++) {
                rzVar.ut(1);
                int yt2 = rzVar.yt();
                for (int i11 = 0; i11 < yt2; i11++) {
                    int yt3 = rzVar.yt();
                    i8 += yt3 + 4;
                    rzVar.ut(yt3);
                }
            }
            rzVar.oz(a2);
            byte[] bArr = new byte[i8];
            String str = null;
            int i12 = 0;
            int i13 = 0;
            int i14 = -1;
            int i15 = -1;
            float f4 = 1.0f;
            int i16 = -1;
            int i17 = -1;
            int i18 = -1;
            while (i12 < ej3) {
                int ej4 = rzVar.ej() & 63;
                int yt4 = rzVar.yt();
                int i19 = 0;
                while (i19 < yt4) {
                    int yt5 = rzVar.yt();
                    byte[] bArr2 = v5.c.y;
                    int i20 = ej3;
                    System.arraycopy(bArr2, i6, bArr, i13, bArr2.length);
                    int length = i13 + bArr2.length;
                    System.arraycopy(rzVar.v(), rzVar.a(), bArr, length, yt5);
                    if (ej4 == 33 && i19 == 0) {
                        c.y s2 = v5.c.s(bArr, length, length + yt5);
                        int i21 = s2.f14319s;
                        i15 = s2.f14313c5;
                        int i22 = s2.f14314f;
                        int i23 = s2.f14320t;
                        int i24 = s2.f14321tl;
                        float f6 = s2.f14317i9;
                        i = ej4;
                        i5 = yt4;
                        i14 = i21;
                        i18 = i24;
                        str = v5.a.zn(s2.y, s2.f14318n3, s2.f14323zn, s2.f14316gv, s2.f14322v, s2.f14312a);
                        i17 = i23;
                        f4 = f6;
                        i16 = i22;
                    } else {
                        i = ej4;
                        i5 = yt4;
                    }
                    i13 = length + yt5;
                    rzVar.ut(yt5);
                    i19++;
                    ej3 = i20;
                    ej4 = i;
                    yt4 = i5;
                    i6 = 0;
                }
                i12++;
                i6 = 0;
            }
            if (i8 == 0) {
                singletonList = Collections.emptyList();
            } else {
                singletonList = Collections.singletonList(bArr);
            }
            return new a(singletonList, ej2 + 1, i14, i15, f4, str, i16, i17, i18);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw ne.y("Error parsing HEVC config", e2);
        }
    }
}
