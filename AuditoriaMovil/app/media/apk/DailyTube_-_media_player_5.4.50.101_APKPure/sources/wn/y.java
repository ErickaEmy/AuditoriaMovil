package wn;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import m1.ne;
import v5.c;
import v5.rz;
/* loaded from: classes.dex */
public final class y {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final String f14647a;

    /* renamed from: gv  reason: collision with root package name */
    public final int f14648gv;

    /* renamed from: n3  reason: collision with root package name */
    public final int f14649n3;

    /* renamed from: v  reason: collision with root package name */
    public final float f14650v;
    public final List<byte[]> y;

    /* renamed from: zn  reason: collision with root package name */
    public final int f14651zn;

    public y(List<byte[]> list, int i, int i5, int i6, float f4, @Nullable String str) {
        this.y = list;
        this.f14649n3 = i;
        this.f14651zn = i5;
        this.f14648gv = i6;
        this.f14650v = f4;
        this.f14647a = str;
    }

    public static y n3(rz rzVar) throws ne {
        String str;
        int i;
        int i5;
        float f4;
        try {
            rzVar.ut(4);
            int ej2 = (rzVar.ej() & 3) + 1;
            if (ej2 != 3) {
                ArrayList arrayList = new ArrayList();
                int ej3 = rzVar.ej() & 31;
                for (int i6 = 0; i6 < ej3; i6++) {
                    arrayList.add(y(rzVar));
                }
                int ej4 = rzVar.ej();
                for (int i8 = 0; i8 < ej4; i8++) {
                    arrayList.add(y(rzVar));
                }
                if (ej3 > 0) {
                    c.zn t2 = v5.c.t((byte[]) arrayList.get(0), ej2, ((byte[]) arrayList.get(0)).length);
                    int i10 = t2.f14324a;
                    int i11 = t2.f14327fb;
                    float f6 = t2.f14331s;
                    str = v5.a.y(t2.y, t2.f14330n3, t2.f14336zn);
                    i = i10;
                    i5 = i11;
                    f4 = f6;
                } else {
                    str = null;
                    i = -1;
                    i5 = -1;
                    f4 = 1.0f;
                }
                return new y(arrayList, ej2, i, i5, f4, str);
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw ne.y("Error parsing AVC config", e2);
        }
    }

    public static byte[] y(rz rzVar) {
        int yt2 = rzVar.yt();
        int a2 = rzVar.a();
        rzVar.ut(yt2);
        return v5.a.gv(rzVar.v(), a2, yt2);
    }
}
