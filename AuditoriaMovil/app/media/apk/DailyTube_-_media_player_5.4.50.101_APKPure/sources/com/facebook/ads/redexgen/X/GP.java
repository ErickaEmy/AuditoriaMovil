package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class GP {
    public static byte[] A04;
    public static String[] A05 = {"tfY6MbCXKCMIEBFaz5DTNSwQjeQlsdhW", "1UTUottnLG4Bc2erVSXZ5CquC0lsHmD9", "WRMBQ6uqQ67Iv9A4m1bVrpx6x8KF8zD0", "GdVDnzSaJp111GE95ChA", "h9KCnpbAgc3gR8", "h9vqZVyAxwthOkAWolCZS7P8JeHRRya", "xZHasxsAmMNy85vBb9toR", "aWQTkv"};
    public static final String[] A06;
    public final int A00;
    public final String A01;
    public final String A02;
    public final String[] A03;

    public static String A02(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 39);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A04 = new byte[]{-102, -51, -97};
    }

    static {
        A03();
        A06 = new String[0];
    }

    public GP(String str, int i, String str2, String[] strArr) {
        this.A00 = i;
        this.A01 = str;
        this.A02 = str2;
        this.A03 = strArr;
    }

    public static GP A00() {
        String A02 = A02(0, 0, 73);
        return new GP(A02, 0, A02, new String[0]);
    }

    public static GP A01(String str, int i) {
        String trim;
        String[] strArr;
        String trim2 = str.trim();
        if (trim2.isEmpty()) {
            if (A05[5].length() != 31) {
                throw new RuntimeException();
            }
            String[] strArr2 = A05;
            strArr2[4] = "p9dgK4HsNp7ZHS";
            strArr2[3] = "rCFBFYq0pHxXM20TKPTK";
            return null;
        } else if (A05[1].charAt(25) != '0') {
            throw new RuntimeException();
        } else {
            String[] strArr3 = A05;
            strArr3[4] = "ihPGMeIk0rsbhx";
            strArr3[3] = "BIjif2bQ9kjhGmUX3ymE";
            int indexOf = trim2.indexOf(A02(0, 1, 83));
            if (indexOf == -1) {
                trim = A02(0, 0, 73);
            } else {
                String voice = trim2.substring(indexOf);
                trim = voice.trim();
                trim2 = trim2.substring(0, indexOf);
            }
            String voice2 = A02(1, 2, 74);
            String[] nameAndClasses = IF.A0l(trim2, voice2);
            String name = nameAndClasses[0];
            int voiceStartIndex = nameAndClasses.length;
            if (voiceStartIndex > 1) {
                int voiceStartIndex2 = nameAndClasses.length;
                strArr = (String[]) Arrays.copyOfRange(nameAndClasses, 1, voiceStartIndex2);
            } else {
                strArr = A06;
            }
            return new GP(name, i, trim, strArr);
        }
    }
}
