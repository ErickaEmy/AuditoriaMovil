package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.util.Log;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.Arrays;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.Fc  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0626Fc extends AbstractC0998Tv {
    public static byte[] A02;
    public static String[] A03 = {"RkD1OJxt7Cm", "85G", "rOg3VWXB3SEY3xQpEJ0sm9sa", "k8A4i4hEDbRwTbJ7ZqirbVmRMdyhqYao", "w8o7PtZgo3USKQqv4zP9Jz4sqmraE2my", "KkDuTncCOt8", "W5AvxWS2W", "p0drNpcb1k1QxXuNf36gE6"};
    public final /* synthetic */ C1237bN A00;
    public final /* synthetic */ C1227bD A01;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 74);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{-113, -68, -68, -71, -68, 106, -81, -62, -81, -83, -65, -66, -77, -72, -79, 106, -85, -83, -66, -77, -71, -72, -1, -3, 8, 8, 1, 14, -16, 21, 12, 1, -25, -29, -30, -27, 17, 20, 23, 31, 16, 29, 16, 15, 10, 14, 23, 20, 14, 22, 10, 15, 16, 23, 12, 36, 10, 24, 30, 15, 25, 5, 9, 24, 11, 7, 26, 15, 28, 11, 5, 7, 25, 5, 9, 26, 7, 5, 28, -40, -60, -67, -72, -64, -60, -76, -104, -77};
    }

    static {
        A01();
    }

    public C0626Fc(C1237bN c1237bN, C1227bD c1227bD) {
        this.A00 = c1237bN;
        this.A01 = c1227bD;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0822Nb
    public final void AAn() {
        boolean z2;
        this.A00.A0F = true;
        z2 = this.A00.A0G;
        if (!z2) {
            return;
        }
        this.A00.A0A();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0998Tv, com.facebook.ads.redexgen.X.InterfaceC0822Nb
    public final void AB4(String str, Map<String, String> map) {
        EQ eq;
        String str2;
        FV fv;
        EQ eq2;
        J2 j2;
        FV fv2;
        FV fv3;
        C1U A0y;
        String str3;
        EQ eq3;
        EQ eq4;
        boolean z2;
        InterfaceC02880x interfaceC02880x;
        InterfaceC02880x interfaceC02880x2;
        InterfaceC02880x interfaceC02880x3;
        FV fv4;
        FV fv5;
        eq = this.A00.A04;
        eq.A0E().A3j();
        Uri A00 = AbstractC0767Ky.A00(str);
        map.put(A00(22, 10, 82), AdPlacementType.BANNER.name());
        str2 = this.A00.A0H;
        map.put(A00(80, 8, 5), str2);
        fv = this.A00.A03;
        if (fv != null) {
            fv4 = this.A00.A03;
            map.put(A00(59, 21, 92), String.valueOf(fv4.A0l()));
            fv5 = this.A00.A03;
            map.put(A00(36, 23, 97), String.valueOf(fv5.A0H()));
        }
        eq2 = this.A00.A04;
        j2 = this.A00.A05;
        String A6T = this.A01.A6T();
        fv2 = this.A00.A03;
        if (fv2 == null) {
            A0y = null;
        } else {
            fv3 = this.A00.A03;
            A0y = fv3.A0y();
        }
        AbstractC02730h A002 = C02740i.A00(eq2, j2, A6T, A00, map, A0y);
        EnumC02720g enumC02720g = EnumC02720g.A08;
        if (A002 != null) {
            try {
                eq3 = this.A00.A04;
                eq3.A0E().A3g();
                enumC02720g = A002.A0C();
            } catch (Exception e2) {
                str3 = C1237bN.A0K;
                Log.e(str3, A00(0, 22, 0), e2);
            }
        }
        boolean z3 = A002 instanceof C0628Fe;
        String[] strArr = A03;
        if (strArr[0].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A03;
        strArr2[1] = "yKt";
        strArr2[2] = "O3cmN93hsB9jwoMarcV7SE5e";
        if (z3 || (A002 instanceof C0630Fg)) {
            eq4 = this.A00.A04;
            if (AbstractC0783Lo.A0e(eq4, enumC02720g, map)) {
                z2 = true;
                if (A00(32, 4, 55).equals(A00.getScheme()) || !C02740i.A04(A00.getAuthority())) {
                }
                C1237bN c1237bN = this.A00;
                String[] strArr3 = A03;
                if (strArr3[1].length() != strArr3[2].length()) {
                    String[] strArr4 = A03;
                    strArr4[3] = "M83eNTNa8vARqiZhiytfGHWaWQaZAWG6";
                    strArr4[4] = "l8FjrIknJvxUrl7LWCsoLe7lR5i3NNwU";
                    interfaceC02880x3 = c1237bN.A00;
                    if (interfaceC02880x3 == null) {
                        return;
                    }
                } else {
                    String[] strArr5 = A03;
                    strArr5[0] = "riyOH90vrbS";
                    strArr5[5] = "IRnMxNmFGTn";
                    interfaceC02880x = c1237bN.A00;
                    if (interfaceC02880x == null) {
                        return;
                    }
                }
                if (z2 || enumC02720g == EnumC02720g.A05) {
                    return;
                }
                interfaceC02880x2 = this.A00.A00;
                interfaceC02880x2.AAx(this.A00);
                return;
            }
        }
        z2 = false;
        if (A00(32, 4, 55).equals(A00.getScheme())) {
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0822Nb
    public final void ABj() {
        EQ eq;
        C1225bB c1225bB;
        C1225bB c1225bB2;
        C1225bB c1225bB3;
        eq = this.A00.A04;
        InterfaceC1256bg A0E = eq.A0E();
        c1225bB = this.A00.A02;
        A0E.A3k(c1225bB != null);
        c1225bB2 = this.A00.A02;
        if (c1225bB2 == null) {
            return;
        }
        c1225bB3 = this.A00.A02;
        c1225bB3.A02();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0998Tv, com.facebook.ads.redexgen.X.InterfaceC0822Nb
    public final void ACU() {
        EQ eq;
        C1225bB c1225bB;
        eq = this.A00.A04;
        eq.A0E().A3m();
        c1225bB = this.A00.A02;
        c1225bB.A07();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0822Nb
    public final void ADj() {
    }
}
