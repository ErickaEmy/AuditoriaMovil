package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public class UE implements InterfaceC0897Py {
    public static byte[] A01;
    public final /* synthetic */ UD A00;

    static {
        A01();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 95);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{29, 27, 13, 26, 11, 4, 1, 11, 3};
    }

    public UE(UD ud2) {
        this.A00 = ud2;
    }

    public /* synthetic */ UE(UD ud2, UK uk) {
        this(ud2);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0897Py
    public final void ABD() {
        this.A00.A0U(true, A00(0, 9, 55));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0897Py
    public final void ABj() {
        AbstractC1219b5 abstractC1219b5;
        MC mc2;
        InterfaceC0804Mj interfaceC0804Mj;
        J2 j2;
        AbstractC1219b5 abstractC1219b52;
        Q0 q0;
        Q0 q02;
        AbstractC1219b5 abstractC1219b53;
        C1116Yn c1116Yn;
        AbstractC1219b5 abstractC1219b54;
        C1116Yn c1116Yn2;
        abstractC1219b5 = this.A00.A0F;
        if (!TextUtils.isEmpty(abstractC1219b5.A12())) {
            j2 = this.A00.A0J;
            abstractC1219b52 = this.A00.A0F;
            String A12 = abstractC1219b52.A12();
            C0829Ni c0829Ni = new C0829Ni();
            q0 = this.A00.A07;
            C0829Ni A03 = c0829Ni.A03(q0.getViewabilityChecker());
            q02 = this.A00.A07;
            j2.A9g(A12, A03.A02(q02.getTouchDataRecorder()).A05());
            abstractC1219b53 = this.A00.A0F;
            C1U A0y = abstractC1219b53.A0y();
            c1116Yn = this.A00.A0I;
            C1U.A07(A0y, c1116Yn);
            abstractC1219b54 = this.A00.A0F;
            C2O.A00(abstractC1219b54.A0N());
            c1116Yn2 = this.A00.A0I;
            c1116Yn2.A0E().A2k();
        }
        mc2 = this.A00.A0N;
        interfaceC0804Mj = this.A00.A0O;
        mc2.A43(interfaceC0804Mj.A7B());
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0897Py
    public final void AC4() {
        MC mc2;
        InterfaceC0804Mj interfaceC0804Mj;
        mc2 = this.A00.A0N;
        interfaceC0804Mj = this.A00.A0O;
        mc2.A43(interfaceC0804Mj.A6y());
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0897Py
    public final void ADj() {
        MC mc2;
        mc2 = this.A00.A0N;
        mc2.AB0(15);
    }
}
