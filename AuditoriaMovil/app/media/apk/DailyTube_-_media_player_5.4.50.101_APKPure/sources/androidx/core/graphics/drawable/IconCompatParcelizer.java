package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import xb.n3;
/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(n3 n3Var) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.y = n3Var.w(iconCompat.y, 1);
        iconCompat.f2337zn = n3Var.i9(iconCompat.f2337zn, 2);
        iconCompat.f2332gv = n3Var.mt(iconCompat.f2332gv, 3);
        iconCompat.f2336v = n3Var.w(iconCompat.f2336v, 4);
        iconCompat.f2329a = n3Var.w(iconCompat.f2329a, 5);
        iconCompat.f2331fb = (ColorStateList) n3Var.mt(iconCompat.f2331fb, 6);
        iconCompat.f2330c5 = n3Var.z(iconCompat.f2330c5, 7);
        iconCompat.f2333i9 = n3Var.z(iconCompat.f2333i9, 8);
        iconCompat.mt();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, n3 n3Var) {
        n3Var.f3(true, true);
        iconCompat.co(n3Var.a());
        int i = iconCompat.y;
        if (-1 != i) {
            n3Var.d(i, 1);
        }
        byte[] bArr = iconCompat.f2337zn;
        if (bArr != null) {
            n3Var.fh(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f2332gv;
        if (parcelable != null) {
            n3Var.ej(parcelable, 3);
        }
        int i5 = iconCompat.f2336v;
        if (i5 != 0) {
            n3Var.d(i5, 4);
        }
        int i6 = iconCompat.f2329a;
        if (i6 != 0) {
            n3Var.d(i6, 5);
        }
        ColorStateList colorStateList = iconCompat.f2331fb;
        if (colorStateList != null) {
            n3Var.ej(colorStateList, 6);
        }
        String str = iconCompat.f2330c5;
        if (str != null) {
            n3Var.a8(str, 7);
        }
        String str2 = iconCompat.f2333i9;
        if (str2 != null) {
            n3Var.a8(str2, 8);
        }
    }
}
