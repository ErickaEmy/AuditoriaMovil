package com.facebook.ads.redexgen.X;

import android.util.SparseBooleanArray;
import android.view.ViewGroup;
import java.util.List;
/* loaded from: assets/audience_network.dex */
public final class ST extends AbstractC03704c<SN> {
    public static String[] A0H = {"U2dBX20JaeRgS8KUkn4U", "4wbYdEjd6EY1wYpAHERmBQ5UbLFk3rIE", "poCzv8x7tLJqIV5ZIWq", "9iyDRDGf0xWQ70I4mtfqA0IQycZfZ47C", "v2glKkwlOEfR0MfsI3TqmdNecXONmhZ3", "6XdF3RdtkhprEZiVEVCq65KOMzsBziM7", "2OiOSmaAlP7OTnmHwLOjTjXlL7jeDPuL", "nkMLdycTxYcJ5galJfvG8bjM9rVBse8i"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public MB A04;
    public MC A05;
    public String A06;
    public List<C0888Pp> A07;
    public boolean A08;
    public final SparseBooleanArray A09 = new SparseBooleanArray();
    public final AbstractC1219b5 A0A;
    public final C04216c A0B;
    public final C1116Yn A0C;
    public final J2 A0D;
    public final C0775Lg A0E;
    public final C0952Sb A0F;
    public final RE A0G;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public ST(C1116Yn c1116Yn, List<C0888Pp> list, AbstractC1219b5 abstractC1219b5, J2 j2, C04216c c04216c, RE re, C0775Lg c0775Lg, MC mc2, String str, int i, int i5, int i6, int i8, C0952Sb c0952Sb, MB mb) {
        this.A0C = c1116Yn;
        this.A0D = j2;
        this.A0B = c04216c;
        this.A0G = re;
        this.A0E = c0775Lg;
        this.A05 = mc2;
        this.A0A = abstractC1219b5;
        this.A07 = list;
        this.A00 = i;
        this.A03 = i8;
        this.A06 = str;
        this.A01 = i6;
        this.A02 = i5;
        this.A0F = c0952Sb;
        this.A04 = mb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AbstractC03704c
    /* renamed from: A01 */
    public final SN A0C(ViewGroup viewGroup, int i) {
        return new SN(AbstractC0870Ox.A00(new OO(this.A0C, this.A0D, this.A05, this.A0A, null, this.A0G, this.A0E).A0H(this.A04).A0K(), this.A03, this.A06, this.A0F), this.A09, this.A0G, this.A00, this.A01, this.A02, this.A07.size(), this.A0C, this.A0A.A0y());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AbstractC03704c
    /* renamed from: A02 */
    public final void A0D(SN sn, int i) {
        sn.A0j(this.A07.get(i), this.A0D, this.A0B, this.A0E, this.A06);
        if (!this.A08 && i == 0) {
            sn.AFr();
            String[] strArr = A0H;
            if (strArr[3].charAt(29) == strArr[6].charAt(29)) {
                throw new RuntimeException();
            }
            A0H[1] = "f5MkbcX2dFxcVTBDK6f4VKhLC7wzzoeI";
            this.A08 = true;
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC03704c
    public final int A0E() {
        return this.A07.size();
    }
}
