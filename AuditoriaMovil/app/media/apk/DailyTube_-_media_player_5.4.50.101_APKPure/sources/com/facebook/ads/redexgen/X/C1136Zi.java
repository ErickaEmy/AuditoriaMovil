package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Zi  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1136Zi implements AnonymousClass48 {
    public static byte[] A01;
    public static String[] A02 = {"46YXIWmMPzvDd0obWRnJ4BqqVPRLtWBw", "gh8OkU42ZlKkobP3JZNpp9ULZO5A8ZhR", "pYzKTcWKS", "s80LPKQojprV6sWgUGQ2HgvoHgQNhHA6", "mXkvahQSLAFHEVEVhsUobK6", "jBm2h6b3G4Mz5Atqbj4RgeaplM7i81Ud", "dS7v9a2czFlDs6aC1vqF8J", "Ti7FTP9Lv4Lzv8sgvsknxkrAm3hOTwvH"};
    public final /* synthetic */ C0599Eb A00;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            int i10 = (copyOfRange[i8] - i6) - 124;
            if (A02[6].length() != 22) {
                throw new RuntimeException();
            }
            A02[2] = "fZFgh8O1A";
            copyOfRange[i8] = (byte) i10;
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{48, 58, 49};
    }

    static {
        A01();
    }

    public C1136Zi(C0599Eb c0599Eb) {
        this.A00 = c0599Eb;
    }

    private final void A02(AnonymousClass49 anonymousClass49) {
        throw new NullPointerException(A00(0, 3, 81));
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass48
    public final void ABK(AnonymousClass49 anonymousClass49) {
        A02(anonymousClass49);
        throw null;
    }
}
