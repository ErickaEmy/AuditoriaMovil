package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public class VM extends KT {
    public static byte[] A07;
    public static String[] A08 = {"ht2nqOphSkGWhcwEDJi", "8e", "VxeFEfzR5TcwmAdrX4F41ND1Y53QMf69", "I5e6pVtTI36knP1S0AklK89IwpeF3gSj", "5FC5pgnei71RKYYZI1kA418znceUrhge", "dl", "F6vYuzA0zSJD8ZvCMyLH6KoHAiWxL7nL", "PkmJbNAHESzTXEgw33lH9qLKsuvyCSGl"};
    public final /* synthetic */ long A00;
    public final /* synthetic */ VL A01;
    public final /* synthetic */ String A02;
    public final /* synthetic */ String A03;
    public final /* synthetic */ String A04;
    public final /* synthetic */ boolean A05;
    public final /* synthetic */ boolean A06;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 121);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        byte[] bArr = {32, 44, 42, -21, 35, 30, 32, 34, 31, 44, 44, 40, -21, 40, 30, 49, 30, 43, 30, -21, 45, 47, 44, 51, 38, 33, 34, 47, -21, 6, 43, 48, 49, 30, 41, 41, 15, 34, 35, 34, 47, 47, 34, 47, 13, 47, 44, 51, 38, 33, 34, 47, 63, 75, 73, 10, 69, 74, 79, 80, 61, 67, 78, 61, 73, 10, 63, 75, 74, 80, 65, 74, 80, 76, 78, 75, 82, 69, 64, 65, 78, 10, 37, 74, 79, 80, 61, 72, 72, 46, 65, 66, 65, 78, 78, 65, 78, 44, 78, 75, 82, 69, 64, 65, 78};
        String[] strArr = A08;
        if (strArr[3].charAt(3) == strArr[2].charAt(3)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A08;
        strArr2[3] = "job85majakbps8FhelyinU82maIeQz0H";
        strArr2[2] = "0P3hhYaEnra7OBRV2NrCSNwBS2Mryfib";
        A07 = bArr;
    }

    static {
        A02();
    }

    public VM(VL vl2, boolean z2, String str, String str2, String str3, long j2, boolean z3) {
        this.A01 = vl2;
        this.A06 = z2;
        this.A02 = str;
        this.A04 = str2;
        this.A03 = str3;
        this.A00 = j2;
        this.A05 = z3;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A06() {
        boolean fb4aResult;
        fb4aResult = this.A01.A03(A00(0, 52, 68), this.A06, this.A02, this.A04, this.A03, this.A00);
        if (fb4aResult) {
            return;
        }
        boolean z2 = this.A05;
        if (A08[6].charAt(24) != 'A') {
            throw new RuntimeException();
        }
        String[] strArr = A08;
        strArr[7] = "GmAnNaRAfSv06BrkDtZAG9sQeFqlxU8t";
        strArr[4] = "5Bqyb5CroUXq2Cw8MdPdD4b1bkEXmmNN";
        if (z2) {
            this.A01.A03(A00(52, 53, 99), this.A06, this.A02, this.A04, this.A03, this.A00);
        }
    }
}
