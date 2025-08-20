package com.facebook.ads.redexgen.X;

import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.ArrayList;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Wp  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1066Wp implements D6 {
    public static String[] A05 = {"ZoOhGYHP8SNfCMTpI8hB8esJvCxQNk4a", "iCY0vtQk2BMTn8YKksXnllwhxYcEMWPa", "FRJmrfeKqiG8dvU06WzW6", "wyGcQq4l", "", "l2", "ODNaIWitniiqKmZchEPotBtPtmPon6SS", "r1S7VBlY5d2QYAsiLWImTDUS2fBhu4wR"};
    public final int A00;
    public final /* synthetic */ C1065Wo A04;
    public final C0696Hy A03 = new C0696Hy(new byte[5]);
    public final SparseArray<DD> A01 = new SparseArray<>();
    public final SparseIntArray A02 = new SparseIntArray();

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x015c A[SYNTHETIC] */
    @Override // com.facebook.ads.redexgen.X.D6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A4R(com.facebook.ads.redexgen.X.C0697Hz r14) {
        /*
            Method dump skipped, instructions count: 548
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1066Wp.A4R(com.facebook.ads.redexgen.X.Hz):void");
    }

    public C1066Wp(C1065Wo c1065Wo, int i) {
        this.A04 = c1065Wo;
        this.A00 = i;
    }

    private DA A00(C0697Hz c0697Hz, int i) {
        long j2;
        long formatIdentifier;
        long j4;
        int A06 = c0697Hz.A06();
        int i5 = A06 + i;
        int i6 = -1;
        String language = null;
        ArrayList arrayList = null;
        while (c0697Hz.A06() < i5) {
            int descriptorsStartPosition = c0697Hz.A0E();
            int positionOfNextDescriptor = c0697Hz.A06() + c0697Hz.A0E();
            if (descriptorsStartPosition == 5) {
                long A0M = c0697Hz.A0M();
                j2 = C1065Wo.A0F;
                if (A0M != j2) {
                    formatIdentifier = C1065Wo.A0G;
                    if (A05[0].charAt(13) == 108) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A05;
                    strArr[5] = "OX";
                    strArr[4] = "";
                    if (A0M != formatIdentifier) {
                        j4 = C1065Wo.A0H;
                        if (A0M == j4) {
                            i6 = 36;
                        }
                    } else {
                        i6 = 135;
                    }
                } else {
                    i6 = 129;
                }
            } else if (descriptorsStartPosition == 106) {
                i6 = 129;
            } else if (descriptorsStartPosition == 122) {
                i6 = 135;
            } else if (descriptorsStartPosition == 123) {
                i6 = 138;
            } else if (descriptorsStartPosition == 10) {
                language = c0697Hz.A0S(3).trim();
            } else if (descriptorsStartPosition == 89) {
                i6 = 89;
                arrayList = new ArrayList();
                while (c0697Hz.A06() < positionOfNextDescriptor) {
                    String trim = c0697Hz.A0S(3).trim();
                    int A0E = c0697Hz.A0E();
                    byte[] bArr = new byte[4];
                    c0697Hz.A0c(bArr, 0, 4);
                    arrayList.add(new D9(trim, A0E, bArr));
                }
            }
            c0697Hz.A0Z(positionOfNextDescriptor - c0697Hz.A06());
        }
        c0697Hz.A0Y(i5);
        return new DA(i6, language, arrayList, Arrays.copyOfRange(c0697Hz.A00, A06, i5));
    }

    @Override // com.facebook.ads.redexgen.X.D6
    public final void A8q(IB ib, InterfaceC0556Bu interfaceC0556Bu, DC dc) {
    }
}
