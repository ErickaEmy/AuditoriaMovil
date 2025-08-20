package com.facebook.ads.redexgen.X;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Log;
import android.util.Pair;
import com.uv.v7.R;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class DG {
    public static byte[] A07;
    public static String[] A08 = {"l47F2JAJicAi7iJT7Ur8ZlCw", "pcnHbOoGzPExKCHxm2AK1l1xVYlhX3pn", "L7qDH0sZJIKjQPetVGF", "mKMCCcAhi76NHeIY7m5kov", "q39HFngYrns05eD5pjaqNYndLlzCP1N1", "S0mWvWCgmnvtEg9hs9CnV7qg", "HTiL2pHQ4MkdfTxzAGhBA6OvrbDKlrFs", "nbOKc9xHpWJnEmTOZOJWDKzO97xo4CwF"};
    public final MediaCodecInfo.CodecCapabilities A00;
    public final String A01;
    public final String A02;
    public final boolean A03;
    public final boolean A04;
    public final boolean A05;
    public final boolean A06;

    public static String A03(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 121);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A07 = new byte[]{-54, 30, 25, -54, 29, 17, -39, -51, 8, 52, 102, 102, 104, 96, 88, 87, 64, 84, 107, 54, 91, 84, 97, 97, 88, 95, 52, 87, 93, 104, 102, 103, 96, 88, 97, 103, 45, 19, 56, 106, 106, 108, 100, 92, 91, 74, 108, 103, 103, 102, 105, 107, 23, 82, 53, 77, 76, 81, 73, 43, 87, 76, 77, 75, 49, 86, 78, 87, 4, 37, 9, 43, 38, 38, 37, 40, 42, -42, 17, 77, 58, -3, 56, 36, 39, 36, 51, 55, 44, 57, 40, -16, 51, 47, 36, 60, 37, 36, 38, 46, 28, 39, 36, 34, 41, -23, 30, 28, 43, 46, -31, -20, -23, -25, -18, -82, -10, -61, -31, -16, -13, 58, 78, 61, 66, 72, 8, 12, 64, 73, 73, 6, 26, 9, 14, 20, -44, 6, 8, -40, 59, 79, 62, 67, 73, 9, 59, 71, 76, 7, 81, 60, 20, 40, 23, 28, 34, -30, 24, 20, 22, -26, 68, 88, 71, 76, 82, 18, 73, 79, 68, 70, 24, 44, 27, 32, 38, -26, 30, -18, -24, -24, -28, 24, 35, 24, 46, -25, -5, -22, -17, -11, -75, -19, -67, -73, -73, -77, -13, -14, -25, -3, 36, 56, 39, 44, 50, -14, 42, 54, 48, -3, 17, 0, 5, 11, -53, 9, 12, -48, -3, -55, 8, -3, 16, 9, 7, 27, 10, 15, 21, -43, 19, 22, 11, 13, 54, 74, 57, 62, 68, 4, 68, 69, 74, 72, 63, 83, 66, 71, 77, 13, 80, 63, 85, 39, 59, 42, 47, 53, -11, 60, 53, 56, 40, 47, 57, 14, 19, 12, 25, 25, 16, 23, -18, 26, 32, 25, 31, -39, 12, -18, 12, 27, 30, 5, 10, 3, 16, 16, 7, 14, -27, 17, 23, 16, 22, -48, 5, 3, 18, 21, 44, 49, 42, 55, 55, 46, 53, 12, 56, 62, 55, 61, -9, 60, 62, 57, 57, 56, 59, 61, -11, -23, -17, -5, -16, -15, -17, -70, -7, -11, -7, -15, -84, 87, 99, 88, 89, 87, 34, 100, 102, 99, 90, 93, 96, 89, 64, 89, 106, 89, 96, 32, 20, 16, -2, 10, 13, 9, 2, -17, -2, 17, 2, -53, -2, -32, -2, 13, 16, 87, 69, 81, 84, 80, 73, 54, 69, 88, 73, 18, 71, 69, 84, 87, 46, 28, 40, 43, 39, 32, 13, 28, 47, 32, -23, 46, 48, 43, 43, 42, 45, 47, -25, -37, 20, 6, 4, 22, 19, 6, -50, 17, 13, 2, 26, 3, 2, 4, 12, 81, 71, 88, 67, 31, 76, 66, 48, 63, 82, 67, 12, 65, 63, 78, 81, 9, -1, 16, -5, -41, 4, -6, -24, -9, 10, -5, -60, 8, 5, 10, -9, 10, -5, -6, -62, -74, 80, 70, 87, 66, 30, 75, 65, 47, 62, 81, 66, 11, 80, 82, 77, 77, 76, 79, 81, 9, -3, 40, 30, 47, 26, -10, 35, 25, 7, 22, 41, 26, -29, 43, -8, 22, 37, 40, 30, 31, 24, 24, 15, 22, 15, 14, -41, 26, 22, 11, 35, 12, 11, 13, 21, 58};
    }

    static {
        A04();
    }

    public DG(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z2, boolean z3, boolean z4) {
        this.A02 = (String) AbstractC0672Ha.A01(str);
        this.A01 = str2;
        this.A00 = codecCapabilities;
        this.A04 = z2;
        boolean z5 = true;
        this.A03 = (z3 || codecCapabilities == null || !A07(codecCapabilities)) ? false : true;
        this.A06 = codecCapabilities != null && A0B(codecCapabilities);
        if (!z4 && (codecCapabilities == null || !A09(codecCapabilities))) {
            z5 = false;
        }
        this.A05 = z5;
    }

    public static int A00(String str, String str2, int i) {
        int i5;
        if (i > 1 || (IF.A02 >= 26 && i > 0)) {
            return i;
        }
        if (A03(226, 10, 45).equals(str2) || A03(121, 10, 96).equals(str2) || A03(140, 12, 97).equals(str2) || A03(211, 15, 35).equals(str2) || A03(255, 12, 77).equals(str2) || A03(236, 10, 92).equals(str2) || A03(246, 9, 101).equals(str2) || A03(162, 10, R.styleable.AppCompatTheme_textAppearancePopupMenuHeader).equals(str2) || A03(172, 15, 62).equals(str2) || A03(187, 15, 13).equals(str2) || A03(202, 9, 74).equals(str2)) {
            return i;
        }
        if (A03(131, 9, 44).equals(str2)) {
            i5 = 6;
        } else {
            String A03 = A03(152, 10, 58);
            if (A08[4].charAt(25) == 'Z') {
                throw new RuntimeException();
            }
            A08[4] = "P3Nhh7RBH5ErFPjvJQxGDiPekJNUcZJn";
            if (A03.equals(str2)) {
                i5 = 16;
            } else {
                i5 = 30;
            }
        }
        Log.w(A03(54, 14, R.styleable.AppCompatTheme_textColorSearchUrl), A03(9, 29, 122) + str + A03(6, 3, 52) + i + A03(0, 4, 49) + i5 + A03(79, 1, 119));
        return i5;
    }

    public static DG A01(String str) {
        return new DG(str, null, null, true, false, false);
    }

    public static DG A02(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z2, boolean z3) {
        return new DG(str, str2, codecCapabilities, false, z2, z3);
    }

    private void A05(String str) {
        StringBuilder append = new StringBuilder().append(A03(38, 16, 126)).append(str);
        String A03 = A03(80, 3, 100);
        append.append(A03).append(this.A02).append(A03(4, 2, 120)).append(this.A01).append(A03).append(IF.A04).append(A03(79, 1, 119)).toString();
    }

    private void A06(String str) {
        StringBuilder append = new StringBuilder().append(A03(68, 11, 61)).append(str);
        String A03 = A03(80, 3, 100);
        append.append(A03).append(this.A02).append(A03(4, 2, 120)).append(this.A01).append(A03).append(IF.A04).append(A03(79, 1, 119)).toString();
    }

    public static boolean A07(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return IF.A02 >= 19 && A08(codecCapabilities);
    }

    public static boolean A08(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(A03(83, 17, 74));
    }

    public static boolean A09(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return IF.A02 >= 21 && A0A(codecCapabilities);
    }

    public static boolean A0A(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(A03(406, 15, 40));
    }

    public static boolean A0B(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return IF.A02 >= 21 && A0C(codecCapabilities);
    }

    public static boolean A0C(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(A03(496, 17, 49));
    }

    public static boolean A0D(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i5, double d2) {
        if (d2 == -1.0d || d2 <= 0.0d) {
            return videoCapabilities.isSizeSupported(i, i5);
        }
        return videoCapabilities.areSizeAndRateSupported(i, i5, d2);
    }

    public final Point A0E(int i, int i5) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.A00;
        if (codecCapabilities == null) {
            A06(A03(100, 10, 66));
            return null;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            A06(A03(R.styleable.AppCompatTheme_textColorAlertDialogListItem, 11, 7));
            return null;
        }
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        int heightAlignment2 = IF.A04(i, widthAlignment);
        return new Point(heightAlignment2 * widthAlignment, IF.A04(i5, heightAlignment) * heightAlignment);
    }

    public final boolean A0F(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.A00;
        if (codecCapabilities == null) {
            A06(A03(285, 17, 41));
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            A06(A03(267, 18, 50));
            return false;
        } else if (A00(this.A02, this.A01, audioCapabilities.getMaxInputChannelCount()) < i) {
            A06(A03(302, 22, 80) + i);
            return false;
        } else {
            return true;
        }
    }

    public final boolean A0G(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.A00;
        if (codecCapabilities == null) {
            String A03 = A03(371, 15, 107);
            String[] strArr = A08;
            if (strArr[7].charAt(27) != strArr[1].charAt(27)) {
                A08[4] = "1TDMmIQfG5hcmUgl4hLs4ptEQsykv9BZ";
                A06(A03);
                return false;
            }
            throw new RuntimeException();
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            A06(A03(355, 16, 36));
            return false;
        } else if (!audioCapabilities.isSampleRateSupported(i)) {
            A06(A03(386, 20, 66) + i);
            return false;
        } else {
            return true;
        }
    }

    public final boolean A0H(int i, int i5, double d2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.A00;
        if (codecCapabilities == null) {
            A06(A03(421, 16, 101));
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            A06(A03(479, 17, 60));
            return false;
        } else if (!A0D(videoCapabilities, i, i5, d2)) {
            String A03 = A03(513, 1, 73);
            if (i >= i5 || !A0D(videoCapabilities, i5, i, d2)) {
                A06(A03(458, 21, 100) + i + A03 + i5 + A03 + d2);
                return false;
            }
            A05(A03(437, 21, 29) + i + A03 + i5 + A03 + d2);
            return true;
        } else {
            return true;
        }
    }

    public final boolean A0I(String str) {
        MediaCodecInfo.CodecProfileLevel[] A0J;
        if (str == null || this.A01 == null) {
            return true;
        }
        String A05 = AbstractC0690Hs.A05(str);
        if (A08[4].charAt(25) != 'Z') {
            String[] strArr = A08;
            strArr[7] = "DCoMJKO3SQRZ9AZ8Punft1OMrNVoZ9FQ";
            strArr[1] = "kGwQMpRYxL2xz4mLYOs80Kob4iU3fTuT";
            if (A05 == null) {
                return true;
            }
            boolean equals = this.A01.equals(A05);
            String A03 = A03(4, 2, 120);
            String codecMimeType = A08[6];
            if (codecMimeType.charAt(14) != 'p') {
                A08[6] = "vbTHdtkviQLZpSNmsPVzchXkRABJSF9Q";
                if (!equals) {
                    A06(A03(324, 11, 19) + str + A03 + A05);
                    return false;
                }
                Pair<Integer, Integer> A02 = DR.A02(str);
                if (A02 == null) {
                    return true;
                }
                for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : A0J()) {
                    if (codecProfileLevel.profile == ((Integer) A02.first).intValue() && codecProfileLevel.level >= ((Integer) A02.second).intValue()) {
                        return true;
                    }
                }
                A06(A03(335, 20, 123) + str + A03 + A05);
                return false;
            }
        }
        throw new RuntimeException();
    }

    public final MediaCodecInfo.CodecProfileLevel[] A0J() {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.A00;
        if (codecCapabilities == null || codecCapabilities.profileLevels == null) {
            return new MediaCodecInfo.CodecProfileLevel[0];
        }
        return this.A00.profileLevels;
    }
}
