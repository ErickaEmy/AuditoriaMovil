package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public final class AF {
    public static String[] A06 = {"WwB4b7", "9U9mb9jKte7kllJhP3clLvI5b73", "TDqEL0AoY", "4IvfGYKFDovhkqqhRuF", "llxeZdB1AGHDFzy1eOGJjj7vjbGoDyRo", "wyDFlV", "VELYNO0Lyu3d7b6TF4mD3ooMbXgWeIiM", "iuggwru9v4rPlYsWAIf5ZcemLGs"};
    public int A00;
    public long A01;
    public Object A02;
    public Object A03;
    public long A04;
    public FP A05;

    public final int A00() {
        return this.A05.A00;
    }

    public final int A01(int i) {
        return this.A05.A04[i].A00;
    }

    public final int A02(int i) {
        return this.A05.A04[i].A00();
    }

    public final int A03(int i, int i5) {
        return this.A05.A04[i].A01(i5);
    }

    public final int A04(long j2) {
        return this.A05.A00(j2);
    }

    public final int A05(long j2) {
        return this.A05.A01(j2);
    }

    public final long A06() {
        return this.A05.A01;
    }

    public final long A07() {
        return this.A01;
    }

    public final long A08() {
        return C9W.A01(this.A04);
    }

    public final long A09(int i) {
        return this.A05.A03[i];
    }

    public final long A0A(int i, int i5) {
        FN fn = this.A05.A04[i];
        if (fn.A00 != -1) {
            long[] jArr = fn.A02;
            if (A06[2].length() != 9) {
                throw new RuntimeException();
            }
            A06[2] = "IGBMGqW3m";
            return jArr[i5];
        }
        return -9223372036854775807L;
    }

    public final AF A0B(Object obj, Object obj2, int i, long j2, long j4) {
        return A0C(obj, obj2, i, j2, j4, FP.A06);
    }

    public final AF A0C(Object obj, Object obj2, int i, long j2, long j4, FP fp) {
        this.A02 = obj;
        this.A03 = obj2;
        this.A00 = i;
        this.A01 = j2;
        this.A04 = j4;
        this.A05 = fp;
        return this;
    }

    public final boolean A0D(int i) {
        return !this.A05.A04[i].A02();
    }

    public final boolean A0E(int i, int i5) {
        FN fn = this.A05.A04[i];
        return (fn.A00 == -1 || fn.A01[i5] == 0) ? false : true;
    }
}
