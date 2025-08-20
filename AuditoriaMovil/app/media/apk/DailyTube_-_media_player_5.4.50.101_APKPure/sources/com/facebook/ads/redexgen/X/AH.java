package com.facebook.ads.redexgen.X;

import android.util.Pair;
/* loaded from: assets/audience_network.dex */
public abstract class AH {
    public static String[] A00 = {"PM7DSx0y0lrec1UT4WPnkT9xVE7xO4Q3", "BEgdeY8scYjWDgLVGs4ZUut3Hirr2MX3", "ZAPPhI63uMybzXuqxrZ5dKdt3S18BPE9", "MM2rXOZDxF7k2VlV9Dcr24aSmfbMyxXV", "eywYp4IUfN7s09w4sjk3CdaIEMxiykZ2", "eISkZjTp9yJ8vcJJgc2cD29HnvZjEHrc", "bxIeMq2jLgGDMU", "MX4WpiU2EnoJ87vmil9r758WOfjNIsLN"};
    public static final AH A01 = new Y3();

    public abstract int A00();

    public abstract int A01();

    public abstract int A04(Object obj);

    public abstract AF A0A(int i, AF af2, boolean z2);

    public abstract AG A0D(int i, AG ag, boolean z2, long j2);

    public int A02(int i, int i5, boolean z2) {
        switch (i5) {
            case 0:
                if (i == A06(z2)) {
                    return -1;
                }
                return i + 1;
            case 1:
                return i;
            case 2:
                if (i == A06(z2)) {
                    return A05(z2);
                }
                return i + 1;
            default:
                throw new IllegalStateException();
        }
    }

    public final int A03(int i, AF af2, AG ag, int i5, boolean z2) {
        int i6 = A09(i, af2).A00;
        int windowIndex = A0B(i6, ag).A01;
        if (windowIndex == i) {
            int A02 = A02(i6, i5, z2);
            if (A00[1].charAt(27) != 'r') {
                throw new RuntimeException();
            }
            A00[5] = "vHlQRfGLACzPc9SqhGGMQS9yx8mDrtQw";
            if (A02 == -1) {
                return -1;
            }
            AG A0B = A0B(A02, ag);
            int nextWindowIndex = A00[6].length();
            if (nextWindowIndex == 14) {
                A00[5] = "g3EvwHO3x67yk3ScCmOHXM9FC4inpbOU";
                int windowIndex2 = A0B.A00;
                return windowIndex2;
            }
            String[] strArr = A00;
            strArr[4] = "oJT8BcC7iC9ashzghnGVZpN5rOviRVye";
            strArr[3] = "BXJ5tQfk704SS2XTm0iOlKfvNFhc4WVf";
            int windowIndex3 = A0B.A00;
            return windowIndex3;
        }
        int windowIndex4 = i + 1;
        return windowIndex4;
    }

    public int A05(boolean z2) {
        return A0E() ? -1 : 0;
    }

    public int A06(boolean z2) {
        if (A0E()) {
            return -1;
        }
        return A01() - 1;
    }

    public final Pair<Integer, Long> A07(AG ag, AF af2, int i, long j2) {
        return A08(ag, af2, i, j2, 0L);
    }

    public final Pair<Integer, Long> A08(AG ag, AF af2, int i, long j2, long j4) {
        AbstractC0672Ha.A00(i, 0, A01());
        A0D(i, ag, false, j4);
        if (j2 == -9223372036854775807L) {
            j2 = ag.A01();
            if (A00[5].charAt(22) != '9') {
                throw new RuntimeException();
            }
            A00[0] = "jYNh2aRlntxjcST03zipQODHWrcZ3Q9N";
            if (j2 == -9223372036854775807L) {
                return null;
            }
        }
        int i5 = ag.A00;
        long A03 = ag.A03() + j2;
        long A07 = A09(i5, af2).A07();
        while (A07 != -9223372036854775807L && A03 >= A07) {
            int i6 = ag.A01;
            if (A00[1].charAt(27) == 'r') {
                String[] strArr = A00;
                strArr[7] = "IuvzXoPM3cIs3JU7ThgGmV6LQ39mYtz4";
                strArr[2] = "DGRaGmTIVAXEwTC12jYPgBDTgoVWDlIc";
                if (i5 >= i6) {
                    break;
                }
                A03 -= A07;
                i5++;
                A07 = A09(i5, af2).A07();
            } else {
                throw new RuntimeException();
            }
        }
        return Pair.create(Integer.valueOf(i5), Long.valueOf(A03));
    }

    public final AF A09(int i, AF af2) {
        return A0A(i, af2, false);
    }

    public final AG A0B(int i, AG ag) {
        return A0C(i, ag, false);
    }

    public final AG A0C(int i, AG ag, boolean z2) {
        return A0D(i, ag, z2, 0L);
    }

    public final boolean A0E() {
        return A01() == 0;
    }

    public final boolean A0F(int i, AF af2, AG ag, int i5, boolean z2) {
        return A03(i, af2, ag, i5, z2) == -1;
    }
}
