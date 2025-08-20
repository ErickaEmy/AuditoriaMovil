package com.facebook.ads.redexgen.X;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.TreeSet;
/* loaded from: assets/audience_network.dex */
public final class HR {
    public static byte[] A05;
    public static String[] A06 = {"j9EfDvchdu1KqySqOAnBSG3JWHZdS12U", "q23SQ5AypNqS8oaKOX4z", "zGl30nZzPzoLIdVG6oXXe73jwI6SvYzS", "XO0PMOb8qpQh9emdWW7Vnqfuo5cp8yJy", "hg0Ynef21ksm7drJYvbGXc6C6VdsLqYq", "sq8Z8cDX36Rb5yN4ZHuInHWL1DTNPmF7", "lpBmIRRiri9NKyd9o68rlNPCbyzvIw2I", "eicGPlwUgu"};
    public boolean A01;
    public final int A02;
    public final String A03;
    public C1035Vh A00 = C1035Vh.A04;
    public final TreeSet<C1033Vf> A04 = new TreeSet<>();

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i5);
        int i8 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A06[6].charAt(21) != 'N') {
                throw new RuntimeException();
            }
            A06[6] = "ipIPz5SC6v0GmkIAozZhwN70MrudeMSU";
            if (i8 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 100);
            i8++;
        }
    }

    public static void A02() {
        byte[] bArr = {-79, -9, -14, -6, -3, -10, -11, -65, -77, 7, 2, -77, 42, 61, 70, 57, 69, 65, 70, 63, -8, 71, 62, -8};
        String[] strArr = A06;
        if (strArr[4].charAt(2) != strArr[3].charAt(2)) {
            throw new RuntimeException();
        }
        A06[5] = "8leR2nWms8A7PmFgrtQ6nLfJYqb68GHr";
        A05 = bArr;
    }

    static {
        A02();
    }

    public HR(int i, String str) {
        this.A02 = i;
        this.A03 = str;
    }

    public static HR A00(int i, DataInputStream dataInputStream) throws IOException {
        HR hr = new HR(dataInputStream.readInt(), dataInputStream.readUTF());
        if (i < 2) {
            long readLong = dataInputStream.readLong();
            HW hw2 = new HW();
            HV.A05(hw2, readLong);
            hr.A0F(hw2);
        } else {
            hr.A00 = C1035Vh.A00(dataInputStream);
        }
        return hr;
    }

    public final int A03(int i) {
        int result = this.A02;
        int i5 = result * 31;
        int result2 = this.A03.hashCode();
        int result3 = i5 + result2;
        if (i < 2) {
            long A00 = HV.A00(this.A00);
            return (result3 * 31) + ((int) ((A00 >>> 32) ^ A00));
        }
        return (result3 * 31) + this.A00.hashCode();
    }

    public final long A04(long j2, long j4) {
        C1033Vf A062 = A06(j2);
        if (A062.A01()) {
            return -Math.min(A062.A02() ? Long.MAX_VALUE : A062.A01, j4);
        }
        long j6 = j2 + j4;
        long j7 = A062.A02 + A062.A01;
        if (j7 < j6) {
            TreeSet<C1033Vf> treeSet = this.A04;
            if (A06[1].length() != 20) {
                throw new RuntimeException();
            }
            A06[1] = "RgZ5bXDLk5KqdLdfFSHI";
            for (C1033Vf c1033Vf : treeSet.tailSet(A062, false)) {
                if (c1033Vf.A02 > j7) {
                    break;
                }
                j7 = Math.max(j7, c1033Vf.A02 + c1033Vf.A01);
                if (j7 >= j6) {
                    break;
                }
            }
        }
        return Math.min(j7 - j2, j4);
    }

    public final C1035Vh A05() {
        return this.A00;
    }

    public final C1033Vf A06(long j2) {
        C1033Vf A01 = C1033Vf.A01(this.A03, j2);
        C1033Vf floor = this.A04.floor(A01);
        if (floor != null && floor.A02 + floor.A01 > j2) {
            return floor;
        }
        TreeSet<C1033Vf> treeSet = this.A04;
        String[] strArr = A06;
        if (strArr[2].charAt(22) != strArr[0].charAt(22)) {
            throw new RuntimeException();
        }
        A06[6] = "nd2bgBSeUAsM9albd5et6NmdTACtd3AP";
        C1033Vf lookupSpan = treeSet.ceiling(A01);
        if (lookupSpan == null) {
            return C1033Vf.A02(this.A03, j2);
        }
        return C1033Vf.A03(this.A03, j2, lookupSpan.A02 - j2);
    }

    public final C1033Vf A07(C1033Vf c1033Vf) throws HI {
        AbstractC0672Ha.A04(this.A04.remove(c1033Vf));
        C1033Vf A08 = c1033Vf.A08(this.A02);
        if (c1033Vf.A03.renameTo(A08.A03)) {
            this.A04.add(A08);
            return A08;
        }
        throw new HI(A01(12, 12, 116) + c1033Vf.A03 + A01(8, 4, 47) + A08.A03 + A01(0, 8, 45));
    }

    public final TreeSet<C1033Vf> A08() {
        return this.A04;
    }

    public final void A09(C1033Vf c1033Vf) {
        this.A04.add(c1033Vf);
    }

    public final void A0A(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.A02);
        dataOutputStream.writeUTF(this.A03);
        this.A00.A09(dataOutputStream);
    }

    public final void A0B(boolean z2) {
        this.A01 = z2;
    }

    public final boolean A0C() {
        return this.A04.isEmpty();
    }

    public final boolean A0D() {
        return this.A01;
    }

    public final boolean A0E(HO ho2) {
        if (this.A04.remove(ho2)) {
            ho2.A03.delete();
            return true;
        }
        return false;
    }

    public final boolean A0F(HW hw2) {
        C1035Vh c1035Vh = this.A00;
        C1035Vh oldMetadata = this.A00.A08(hw2);
        this.A00 = oldMetadata;
        return !oldMetadata.equals(c1035Vh);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HR hr = (HR) obj;
        if (this.A02 == hr.A02 && this.A03.equals(hr.A03) && this.A04.equals(hr.A04) && this.A00.equals(hr.A00)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int result = A03(Integer.MAX_VALUE);
        int i = result * 31;
        int result2 = this.A04.hashCode();
        return i + result2;
    }
}
