package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import com.uv.v7.R;
import java.util.ArrayList;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Hs  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC0690Hs {
    public static byte[] A00;
    public static String[] A01 = {"ieRwpCtuK3Uo85cjZEKrdCd37bpimhtY", "SWj8fz5xlO0E25uIaEG5QR97PjyPRjqc", "qo9VJyE5iR063JUt4OVQofS18tUFAamR", "Gteq1bVQSr5XKs4A7OlOChfT", "PlUSU1U83lKSeB2O5clYiMU4GGCz", "temwCY24a07Ffi16KYvyo8ZHegbdFSBA", "rqFjIUeqZXsH", "sifdD3H0nhYqlD5Nup1ZT"};
    public static final ArrayList<C0689Hr> A02;

    public static String A04(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        int i8 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A01[4].length() == 2) {
                throw new RuntimeException();
            }
            A01[6] = "B0XYBYFpMcx2";
            if (i8 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 15);
            i8++;
        }
    }

    public static void A08() {
        A00 = new byte[]{92, -127, -119, 116, Byte.MAX_VALUE, 124, 119, 51, Byte.MIN_VALUE, 124, Byte.MIN_VALUE, 120, 51, -121, -116, -125, 120, 77, 51, -56, -54, -108, -102, -32, -17, -17, -21, -24, -30, -32, -13, -24, -18, -19, -82, -30, -28, -32, -84, -75, -81, -73, -89, -74, -74, -78, -81, -87, -89, -70, -81, -75, -76, 117, -87, -85, -89, 115, 125, 118, 126, -55, -40, -40, -44, -47, -53, -55, -36, -47, -41, -42, -105, -52, -34, -54, -37, -35, -54, -37, -101, -86, -86, -90, -93, -99, -101, -82, -93, -87, -88, 105, -93, -98, 109, -81, -66, -66, -70, -73, -79, -81, -62, -73, -67, -68, 125, -66, -75, -63, -85, -70, -70, -74, -77, -83, -85, -66, -77, -71, -72, 121, -66, -66, -73, -74, 117, -62, -73, -74, -127, -112, -112, -116, -119, -125, -127, -108, -119, -113, -114, 79, -106, -113, -126, -109, -107, -126, -96, -81, -81, -85, -88, -94, -96, -77, -88, -82, -83, 110, -73, 108, -94, -96, -84, -92, -79, -96, 108, -84, -82, -77, -88, -82, -83, -40, -25, -25, -29, -32, -38, -40, -21, -32, -26, -27, -90, -17, -92, -36, -28, -22, -34, -18, -3, -3, -7, -10, -16, -18, 1, -10, -4, -5, -68, 5, -70, -6, -3, -63, -70, -16, -14, -18, -70, -61, -67, -59, -70, -55, -55, -59, -62, -68, -70, -51, -62, -56, -57, -120, -47, -122, -58, -55, -115, -122, -49, -51, -51, -100, -85, -85, -89, -92, -98, -100, -81, -92, -86, -87, 106, -77, 104, -84, -80, -92, -98, -90, -81, -92, -88, -96, 104, -81, -77, 110, -94, -93, -78, -78, -82, -85, -91, -93, -74, -85, -79, -80, 113, -70, 111, -76, -93, -71, -91, -91, 119, -122, -122, -126, Byte.MAX_VALUE, 121, 119, -118, Byte.MAX_VALUE, -123, -124, 69, -114, 67, -119, 121, -118, 123, 73, 75, 124, -117, -117, -121, -124, 126, 124, -113, -124, -118, -119, 74, -109, 72, -114, -112, 125, -115, -124, -117, -42, -22, -39, -34, -28, -59, -39, -56, -51, -45, -109, -59, -57, -105, -113, -93, -110, -105, -99, 93, -109, -113, -111, 97, -125, -105, -122, -117, -111, 81, -121, -125, -123, 85, 79, -116, -111, -123, 116, -120, 119, 124, -126, 66, Byte.MIN_VALUE, -125, 71, 116, 64, Byte.MAX_VALUE, 116, -121, Byte.MIN_VALUE, -62, -42, -59, -54, -48, -112, -50, -47, -58, -56, Byte.MIN_VALUE, -108, -125, -120, -114, 78, -114, -113, -108, -110, -105, -85, -102, -97, -91, 101, -86, -88, -85, -101, 99, -98, -102, -109, -89, -106, -101, -95, 97, -88, -96, -106, 96, -106, -90, -91, -52, -32, -49, -44, -38, -102, -31, -39, -49, -103, -49, -33, -34, -103, -45, -49, -61, -41, -58, -53, -47, -111, -40, -47, -44, -60, -53, -43, -88, -67, -86, 120, -23, -2, -21, -69, -35, -23, -34, -33, -35, -54, -20, -33, -32, -29, -14, -115, -118, -116, 92, -27, -26, -28, -76, -26, -10, -11, -27, -99, -83, -84, -98, 122, -118, -119, 126, -54, -38, -39, -46, -36, -38, -94, -86, -124, -126, 76, 82, -126, Byte.MAX_VALUE, -112, 75, -59, -45, -64, -114, -39, -43, -39, -47, -64, -27, -36, -47, -60, -57, -117, -72, -102, -99, 97, -114, 91, -87, -86, -81, -83, -14, -29, -10, -14, -42, -55, -60, -59, -49, -97, -110, -115, -114, -104, 88, -118, -97, -116, -41, -54, -59, -58, -48, -112, -55, -58, -41, -60, -116, Byte.MAX_VALUE, 122, 123, -123, 69, -125, -122, 74, -116, 67, 123, -119, -109, -122, -127, -126, -116, 76, -118, -115, -126, -124, -45, -58, -63, -62, -52, -116, -54, -51, -62, -60, -113, -18, -31, -36, -35, -25, -89, -17, -18, -37, -87, -31, -44, -49, -48, -38, -102, -29, -104, -31, -39, -49, -103, -38, -39, -99, -103, -31, -37, -93, -23, -36, -41, -40, -30, -94, -21, -96, -23, -31, -41, -95, -30, -31, -91, -95, -23, -29, -84, -33, -40, -37, -53, -46, -36, -10, -16, -80, -72, -53, -59, -123, -114, -12, -18, -74, -15, -21, -76};
    }

    static {
        A08();
        A02 = new ArrayList<>();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int A00(String str) {
        char c2;
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals(A04(350, 14, 19))) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -1095064472:
                if (str.equals(A04(412, 13, 35))) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 187078296:
                if (str.equals(A04(331, 9, 85))) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 1504578661:
                if (str.equals(A04(340, 10, 31))) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 1505942594:
                if (str.equals(A04(425, 16, 92))) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 1556697186:
                if (str.equals(A04(399, 13, 39))) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                return 5;
            case 1:
            case 2:
                return 6;
            case 3:
                return 7;
            case 4:
                return 8;
            case 5:
                if (A01[0].charAt(10) != 'U') {
                    throw new RuntimeException();
                }
                A01[4] = "";
                return 14;
            default:
                return 0;
        }
    }

    public static int A01(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (A09(str)) {
            return 1;
        }
        if (A0B(str)) {
            return 2;
        }
        if (A0A(str) || A04(23, 19, R.styleable.AppCompatTheme_toolbarNavigationButtonStyle).equals(str)) {
            return 3;
        }
        if (A01[3].length() != 9) {
            String[] strArr = A01;
            strArr[1] = "LJhw0AyNjlY1daGtGtEMPB4ZWI4lLjxq";
            strArr[2] = "Jpqt6rhjDWOI2VL5M75U9AGCLzRFcI9K";
            if (A04(42, 19, 55).equals(str) || A04(193, 25, 126).equals(str) || A04(306, 20, 12).equals(str) || A04(R.styleable.AppCompatTheme_textColorAlertDialogListItem, 20, 59).equals(str) || A04(239, 28, 44).equals(str) || A04(218, 21, 74).equals(str) || A04(267, 19, 51).equals(str) || A04(130, 18, 17).equals(str) || A04(95, 15, 63).equals(str) || A04(61, 19, 89).equals(str)) {
                return 3;
            }
            if (!A04(80, 15, 43).equals(str)) {
                if (A01[6].length() != 12) {
                    A01[5] = "rwbag1QSJlT1yZsbEhClTGvMhp5yspb0";
                    if (A04(175, 5, 84).equals(str)) {
                        return 4;
                    }
                } else {
                    String[] strArr2 = A01;
                    strArr2[1] = "oiEUm8Pa8xqbloGyO2Igjyb7THZFd6q8";
                    strArr2[2] = "XLA61hR1gHB686GQiHbqHMaGrNzQ5Lyu";
                    if (A04(175, 18, 104).equals(str)) {
                        return 4;
                    }
                }
                if (!A04(286, 20, 7).equals(str)) {
                    boolean equals = A04(148, 27, 48).equals(str);
                    if (A01[0].charAt(10) != 'U') {
                        throw new RuntimeException();
                    }
                    A01[4] = "H9g3dImLmMl";
                    if (equals) {
                        return 4;
                    }
                    return A02(str);
                }
                return 4;
            }
            return 4;
        }
        throw new RuntimeException();
    }

    public static int A02(String str) {
        int customMimeTypeCount = A02.size();
        if (0 < customMimeTypeCount) {
            A02.get(0);
            throw new NullPointerException(A04(512, 8, 93));
        }
        return -1;
    }

    public static String A03(int i) {
        switch (i) {
            case 32:
                return A04(561, 13, 7);
            case 33:
                return A04(542, 9, 26);
            case 35:
                return A04(551, 10, 82);
            case 64:
            case 102:
            case 103:
            case 104:
                return A04(364, 15, 4);
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
                return A04(584, 11, 78);
            case 105:
            case 107:
                return A04(379, 10, 82);
            case R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /* 106 */:
                return A04(574, 10, 14);
            case 163:
                return A04(595, 10, 105);
            case 165:
                return A04(331, 9, 85);
            case 166:
                return A04(340, 10, 31);
            case 169:
            case 172:
                return A04(412, 13, 35);
            case 170:
            case 171:
                return A04(425, 16, 92);
            case 173:
                return A04(389, 10, 16);
            case 177:
                return A04(624, 19, 100);
            default:
                return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ff, code lost:
        if (r3.startsWith(r0) != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x011e, code lost:
        if (r3.startsWith(r0) != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String A05(java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 600
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC0690Hs.A05(java.lang.String):java.lang.String");
    }

    public static String A06(String str) {
        int customMimeTypeCount = A02.size();
        if (0 < customMimeTypeCount) {
            A02.get(0);
            throw new NullPointerException(A04(461, 11, 107));
        }
        return null;
    }

    public static String A07(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(47);
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        throw new IllegalArgumentException(A04(0, 19, 4) + str);
    }

    public static boolean A09(String str) {
        return A04(326, 5, 102).equals(A07(str));
    }

    public static boolean A0A(String str) {
        return A04(533, 4, R.styleable.AppCompatTheme_textColorSearchUrl).equals(A07(str));
    }

    public static boolean A0B(String str) {
        return A04(537, 5, 81).equals(A07(str));
    }
}
