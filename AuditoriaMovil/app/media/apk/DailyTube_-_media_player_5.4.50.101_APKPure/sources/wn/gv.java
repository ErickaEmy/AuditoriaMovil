package wn;

import androidx.annotation.Nullable;
import v5.rz;
/* loaded from: classes.dex */
public final class gv {

    /* renamed from: n3  reason: collision with root package name */
    public final int f14585n3;
    public final int y;

    /* renamed from: zn  reason: collision with root package name */
    public final String f14586zn;

    public gv(int i, int i5, String str) {
        this.y = i;
        this.f14585n3 = i5;
        this.f14586zn = str;
    }

    @Nullable
    public static gv y(rz rzVar) {
        String str;
        rzVar.ut(2);
        int ej2 = rzVar.ej();
        int i = ej2 >> 1;
        int ej3 = ((rzVar.ej() >> 3) & 31) | ((ej2 & 1) << 5);
        if (i != 4 && i != 5 && i != 7) {
            if (i == 8) {
                str = "hev1";
            } else if (i == 9) {
                str = "avc3";
            } else {
                return null;
            }
        } else {
            str = "dvhe";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String str2 = ".0";
        sb.append(".0");
        sb.append(i);
        if (ej3 >= 10) {
            str2 = ".";
        }
        sb.append(str2);
        sb.append(ej3);
        return new gv(i, ej3, sb.toString());
    }
}
