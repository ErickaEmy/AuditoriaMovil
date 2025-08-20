package com.facebook.ads.redexgen.X;

import androidx.core.app.NotificationCompat;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.facebook.ads.internal.exoplayer2.thirdparty.drm.DrmInitData;
import com.uv.v7.R;
import java.nio.ByteBuffer;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public abstract class AQ {
    public static byte[] A00;
    public static String[] A01 = {"sCxx5L5gWudXPe4xp1ThsNryHSmynjHF", "9Nf9uybzHO2S6jQpjiGasa9ZwcLHyUhN", "2aneS77IEDbgq", "fX6HyBPcmxgssJA51nXZ3qA", "", "AlikR2RGcjs8IOnjMv6bsO9qZZebDHqD", "DHEXyDlkH8L0aTNQHdBgfWGXbAOYtdTx", "PJLs5pK7Ccf4tt9LWMwQ38VoV6l96kFD"};
    public static final int[] A02;
    public static final int[] A03;
    public static final int[] A04;
    public static final int[] A05;
    public static final int[] A06;
    public static final int[] A07;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static Format A07(C0697Hz c0697Hz, String str, String str2, DrmInitData drmInitData) {
        int i = A05[(c0697Hz.A0E() & 192) >> 6];
        int A0E = c0697Hz.A0E();
        int i5 = A04[(A0E & 56) >> 3];
        if ((A0E & 4) != 0) {
            i5++;
        }
        return Format.A07(str, A0A(0, 9, 26), null, -1, -1, i5, i, null, drmInitData, 0, str2);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static Format A08(C0697Hz c0697Hz, String str, String str2, DrmInitData drmInitData) {
        c0697Hz.A0Z(2);
        int i = A05[(c0697Hz.A0E() & 192) >> 6];
        int A0E = c0697Hz.A0E();
        int i5 = A04[(A0E & 14) >> 1];
        if ((A0E & 1) != 0) {
            i5++;
        }
        if (((c0697Hz.A0E() & 30) >> 1) > 0 && (c0697Hz.A0E() & 2) != 0) {
            i5 += 2;
        }
        String A0A = A0A(9, 10, 48);
        if (c0697Hz.A04() > 0 && (c0697Hz.A0E() & 1) != 0) {
            A0A = A0A(19, 14, 124);
        }
        return Format.A07(str, A0A, null, -1, -1, i5, i, null, drmInitData, 0, str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:132:0x0205, code lost:
        if (r6 != false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0207, code lost:
        r18.A08(4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x020e, code lost:
        if (r18.A0F() == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0210, code lost:
        r18.A08(4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0217, code lost:
        if (r18.A0F() == false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0219, code lost:
        r18.A08(4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0220, code lost:
        if (r18.A0F() == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0222, code lost:
        r18.A08(4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0229, code lost:
        if (r18.A0F() == false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x022b, code lost:
        r18.A08(4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0232, code lost:
        if (r18.A0F() == false) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0238, code lost:
        if (r18.A0F() == false) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x023a, code lost:
        r18.A08(4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0241, code lost:
        if (r18.A0F() == false) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0243, code lost:
        r18.A08(4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0271, code lost:
        if (r18.A0F() != false) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x0273, code lost:
        r18.A08(7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x027b, code lost:
        if (r18.A0F() == false) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x028c, code lost:
        if (com.facebook.ads.redexgen.X.AQ.A01[6].charAt(31) == 'Q') goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x028e, code lost:
        r6 = com.facebook.ads.redexgen.X.AQ.A01;
        r6[3] = "efqTs5tkRdGBLzL99Y2zBy0";
        r6[4] = "";
        r18.A08(8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x02a9, code lost:
        r18.A08(8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x02b1, code lost:
        if (r18.A0F() != false) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x02bb, code lost:
        if (r6 != false) goto L91;
     */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.facebook.ads.redexgen.X.AP A09(com.facebook.ads.redexgen.X.C0696Hy r18) {
        /*
            Method dump skipped, instructions count: 900
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AQ.A09(com.facebook.ads.redexgen.X.Hy):com.facebook.ads.redexgen.X.AP");
    }

    public static String A0A(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 64);
        }
        return new String(copyOfRange);
    }

    public static void A0B() {
        A00 = new byte[]{-69, -49, -66, -61, -55, -119, -69, -67, -115, -47, -27, -44, -39, -33, -97, -43, -47, -45, -93, 29, 49, 32, 37, 43, -21, 33, 29, 31, -17, -23, 38, 43, 31};
    }

    static {
        A0B();
        A03 = new int[]{1, 2, 3, 6};
        A05 = new int[]{48000, 44100, 32000};
        A06 = new int[]{24000, 22050, 16000};
        A04 = new int[]{2, 1, 2, 3, 3, 4, 4, 5};
        A02 = new int[]{32, 40, 48, 56, 64, 80, 96, R.styleable.AppCompatTheme_toolbarNavigationButtonStyle, NotificationCompat.FLAG_HIGH_PRIORITY, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};
        A07 = new int[]{69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};
    }

    public static int A00() {
        return 1536;
    }

    public static int A01(int i, int i5) {
        int i6 = i5 / 2;
        if (i >= 0) {
            int[] iArr = A05;
            int halfFrmsizecod = iArr.length;
            if (i >= halfFrmsizecod || i5 < 0) {
                return -1;
            }
            int[] iArr2 = A07;
            int halfFrmsizecod2 = iArr2.length;
            if (i6 >= halfFrmsizecod2) {
                return -1;
            }
            int bitrate = iArr[i];
            if (bitrate == 44100) {
                int halfFrmsizecod3 = i5 % 2;
                return (iArr2[i6] + halfFrmsizecod3) * 2;
            }
            int sampleRate = A02[i6];
            if (bitrate == 32000) {
                int i8 = sampleRate * 6;
                if (A01[6].charAt(31) != 81) {
                    String[] strArr = A01;
                    strArr[3] = "qimZQilZsB2lt3Dt1pYE9Xl";
                    strArr[4] = "";
                    return i8;
                }
                throw new RuntimeException();
            }
            int halfFrmsizecod4 = sampleRate * 4;
            return halfFrmsizecod4;
        }
        return -1;
    }

    public static int A02(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int startIndex = byteBuffer.limit();
        int i = startIndex - 10;
        for (int i5 = position; i5 <= i; i5++) {
            int startIndex2 = i5 + 4;
            int endIndex = byteBuffer.getInt(startIndex2);
            if ((endIndex & (-16777217)) == -1167101192) {
                return i5 - position;
            }
        }
        String[] strArr = A01;
        String str = strArr[7];
        String str2 = strArr[5];
        int endIndex2 = str.charAt(29);
        int startIndex3 = str2.charAt(29);
        if (endIndex2 != startIndex3) {
            A01[2] = "FkGXqBuH9rf";
            return -1;
        }
        throw new RuntimeException();
    }

    public static int A03(ByteBuffer byteBuffer) {
        int i = 6;
        if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3) {
            int[] iArr = A03;
            int fscod = byteBuffer.position();
            i = iArr[(byteBuffer.get(fscod + 4) & 48) >> 4];
        }
        int fscod2 = i * 256;
        return fscod2;
    }

    public static int A04(ByteBuffer byteBuffer, int i) {
        boolean isMlp = (byteBuffer.get((byteBuffer.position() + i) + 7) & 255) == 187;
        return 40 << ((byteBuffer.get((byteBuffer.position() + i) + (isMlp ? 9 : 8)) >> 4) & 7);
    }

    public static int A05(byte[] bArr) {
        if (bArr.length < 5) {
            return -1;
        }
        int fscod = (bArr[4] & 192) >> 6;
        int frmsizecod = bArr[4] & 63;
        return A01(fscod, frmsizecod);
    }

    public static int A06(byte[] bArr) {
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111 && (bArr[7] & 254) == 186) {
            boolean isMlp = (bArr[7] & 255) == 187;
            byte b2 = bArr[isMlp ? '\t' : '\b'];
            String[] strArr = A01;
            if (strArr[3].length() != strArr[4].length()) {
                String[] strArr2 = A01;
                strArr2[1] = "Qkic1459317rghhXW1uTsPZAwlwTKIiV";
                strArr2[0] = "TPYz26W0Cq4ZALktt0QhsmVlkvC9xybr";
                return 40 << ((b2 >> 4) & 7);
            }
            throw new RuntimeException();
        }
        return 0;
    }
}
