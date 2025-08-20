package com.facebook.ads.redexgen.X;

import android.view.View;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.ca  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1300ca<ModelType, StateType> {
    public static byte[] A06;
    public static String[] A07 = {"K3IBH5IY5D9A1s0otTNJJ1EDvo1qLs", "HR7iyfZ1MOS5huP42RSdRpCkeBunQMOf", "", "bEqFTGguyIKgMYqaAFudqvCpFKGvMgpm", "3wGEEC73gwsSkVWXWqLxZk", "wIAJ3aMEmj6qTKsV0aDgjtipvoJzkW0C", "SCvpsyQDnQo4JnEbtI83SB", "GSqpB1BwT3x"};
    public static final C1300ca A08;
    public boolean A00;
    public final C1300ca A01;
    public final ModelType A02;
    public final StateType A03;
    public final String A04;
    public final List<InterfaceC1303cd<ModelType, StateType>> A05;

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 113);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A06 = new byte[]{66, 85, 81, 99, 92, 91, 85, 90, 96, 48, 77, 96, 77, 12, 95, 84, 91, 97, 88, 80, 12, 90, 91, 96, 12, 79, 91, 90, 96, 77, 85, 90, 12, 77, 12, 98, 85, 81, 99, 12, 77, 95, 12, 89, 91, 80, 81, 88, 0, 8, 11, 15, 20};
    }

    static {
        A02();
        A08 = new C1300ca(null, null, A01(48, 5, 42), Collections.emptyList(), A08);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.ca != com.instagram.common.viewpoint.core.ViewpointData<ModelType, StateType> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.cb != com.instagram.common.viewpoint.core.ViewpointData$Builder<ModelType, StateType> */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C1300ca(com.facebook.ads.redexgen.X.C1301cb<ModelType, StateType> r7) {
        /*
            r6 = this;
            java.lang.Object r1 = com.facebook.ads.redexgen.X.C1301cb.A01(r7)
            java.lang.Object r2 = com.facebook.ads.redexgen.X.C1301cb.A02(r7)
            java.lang.String r3 = com.facebook.ads.redexgen.X.C1301cb.A03(r7)
            java.util.List r0 = com.facebook.ads.redexgen.X.C1301cb.A04(r7)
            if (r0 != 0) goto L1f
            java.util.List r4 = java.util.Collections.emptyList()
        L16:
            com.facebook.ads.redexgen.X.ca r5 = com.facebook.ads.redexgen.X.C1301cb.A00(r7)
            r0 = r6
            r0.<init>(r1, r2, r3, r4, r5)
            return
        L1f:
            java.util.List r4 = com.facebook.ads.redexgen.X.C1301cb.A04(r7)
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1300ca.<init>(com.facebook.ads.redexgen.X.cb):void");
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.ca != com.instagram.common.viewpoint.core.ViewpointData<ModelType, StateType> */
    public C1300ca(ModelType modeltype, StateType statetype, String str, List<InterfaceC1303cd<ModelType, StateType>> list, C1300ca c1300ca) {
        if (!(modeltype instanceof View)) {
            this.A02 = modeltype;
            this.A03 = statetype;
            this.A04 = str;
            this.A01 = c1300ca;
            this.A00 = false;
            this.A05 = list;
            return;
        }
        throw new IllegalArgumentException(A01(0, 48, 123));
    }

    public static <ModelType, StateType> C1301cb<ModelType, StateType> A00(ModelType model, StateType state, String str) {
        return new C1301cb<>(model, state, str);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.ca != com.instagram.common.viewpoint.core.ViewpointData<ModelType, StateType> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.cd != com.instagram.common.viewpoint.core.ViewpointAction<ModelType, StateType> */
    public final void A03(InterfaceC1290cP interfaceC1290cP) {
        for (InterfaceC1303cd<ModelType, StateType> interfaceC1303cd : this.A05) {
            interfaceC1303cd.A5c(this, interfaceC1290cP);
        }
        EnumC1291cQ A8J = interfaceC1290cP.A8J(this);
        String[] strArr = A07;
        if (strArr[1].charAt(23) == strArr[3].charAt(23)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A07;
        strArr2[7] = "xMDdEaQw2xH";
        strArr2[2] = "";
        if (A8J == EnumC1291cQ.A02) {
            this.A00 = true;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.ca != com.instagram.common.viewpoint.core.ViewpointData<ModelType, StateType> */
    public final boolean A04() {
        return this.A00;
    }
}
