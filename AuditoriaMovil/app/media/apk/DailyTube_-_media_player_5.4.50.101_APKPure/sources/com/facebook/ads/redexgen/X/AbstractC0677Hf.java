package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import com.uv.v7.R;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* renamed from: com.facebook.ads.redexgen.X.Hf  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC0677Hf {
    public static byte[] A00;
    public static String[] A01 = {"3j0XXMYozRpWsnvXKe1rzXWQBbAaitYs", "8SAd0IdLQ7uQDdeC35vGRPUD6WycKYQb", "pFVfrq6ZdYGU2Sk0mTFIkzSVISEtluF6", "aeeNQeRMWMsVQnESIW3prswcM5JkPPDK", "8OlZzMNt6Sq3j3NkBjOsUWsxO1CiKbb5", "QbqlUKfhYTMEZPCzY0htOzlsZIGpouDB", "eT7qhIkRVUWXszR1s3Q0sjBVPFWX6e2G", "mgn0vhuvylH2MB6kvEUvurVpynuJMPiJ"};
    public static final Map<String, Integer> A02;
    public static final Pattern A03;
    public static final Pattern A04;
    public static final Pattern A05;

    public static String A05(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 59);
        }
        return new String(copyOfRange);
    }

    public static void A06() {
        A00 = new byte[]{-59, -70, -50, -61, -66, -72, -124, -124, -72, -64, -41, -115, -120, -113, -39, -123, -120, -124, -72, -64, -41, -115, -120, -113, -39, -123, -120, -124, -72, -64, -41, -115, -120, -113, -39, -123, -72, -123, Byte.MIN_VALUE, -23, -3, -14, -19, -20, -25, -77, -77, -25, -17, 6, -68, -73, -66, 8, -76, -73, -77, -25, -17, 6, -68, -73, -66, 8, -76, -73, -77, -25, -17, 6, -68, -73, -66, 8, -76, -73, -77, -25, -17, -75, -25, -71, -54, -25, -17, -75, -54, -76, -25, -76, -81, -31, -11, -22, -27, -28, -33, -85, -85, -33, -25, -2, -76, -81, -74, 0, -84, -81, -85, -33, -25, -2, -76, -81, -74, 0, -84, -81, -85, -33, -25, -2, -76, -81, -74, 0, -84, -81, -85, -33, -25, -2, -76, -81, -74, 0, -84, -33, -84, -89, 18, 29, 26, 20, 22, 19, 29, 38, 22, -49, -36, -30, -41, -33, -29, -45, -27, -42, -41, -30, -45, -39, -23, -19, -39, -2, 14, 18, -2, 10, -2, 15, 6, 11, 2, -81, -56, -61, -64, -77, -12, -9, -5, -7, -9, 14, 21, 31, 29, 33, 17, -33, -23, -34, -32, -24, -78, -68, -79, -66, -77, -72, -75, -76, -79, -68, -67, -65, -66, -76, -52, -42, -33, -49, 7, 17, 26, 10, 27, 14, 20, 17, 10, 25, -31, -15, -18, -10, -19, -79, -60, -63, -69, -56, -58, -66, -66, -77, -61, -63, -60, -59, -44, -62, -52, -43, -59, -28, -23, -30, -13, -11, -13, -26, -10, -12, -26, 14, 19, 26, 14, 26, 23, 12, 31, 16, 2, 14, 17, 0, 11, 13, 25, 28, 24, 16, 22, 25, 33, 15, 28, 12, 22, 31, 15, -24, -12, -9, -13, -8, -18, -15, -16, -15, 0, -9, -5, 1, -3, -4, -16, 6, -18, -5, -48, -51, -34, -41, -50, -40, -31, -47, -43, -46, -29, -36, -44, -22, -46, -33, -15, -18, -1, -8, -12, -4, -7, -15, -14, -5, -1, -4, -15, -41, -44, -27, -34, -38, -27, -44, -20, -50, -53, -36, -43, -47, -36, -49, -49, -40, -31, -34, -17, -24, -28, -17, -30, -10, -50, -53, -36, -43, -43, -46, -53, -43, -45, 16, 13, 30, 23, 25, 13, 19, 17, 26, 32, 13, -32, -35, -18, -25, -21, -24, -27, -14, -31, -29, -18, -31, -31, -22, -44, -47, -30, -37, -33, -30, -47, -34, -41, -43, 5, 2, 19, 12, 16, 19, 4, 9, 10, 5, -67, -70, -53, -60, -53, -66, -67, -39, -42, -25, -32, -24, -42, -31, -30, -28, -29, -59, -62, -45, -52, -44, -58, -62, -56, -45, -58, -58, -49, -30, -33, -16, -23, -15, -22, -33, -14, -29, -32, -22, -13, -29, -90, -93, -76, -83, -75, -82, -93, -74, -89, -87, -76, -93, -69, 10, 7, 24, 17, 25, 18, 7, 26, 11, 13, 24, 11, 31, 14, 11, 28, 21, 30, 31, 28, 27, 31, 25, 19, 29, 15, 15, 12, 29, 22, 33, 20, 26, 23, 16, 31, 24, 25, 25, 36, 36, 29, 34, 31, -18, -17, -17, -6, -3, -11, 3, -20, -10, -1, -17, -52, -47, -43, -49, -38, -55, -31, -86, -81, -77, -83, -72, -85, -65, -56, -45, -56, -53, -55, -42, -58, -48, -39, -55, 0, 3, 12, -1, -4, 12, 3, -3, 5, -42, -36, -33, -30, -47, -36, -25, -40, -39, -28, -43, -36, -27, -24, -37, -23, -22, -35, -24, -37, -37, -28, -68, -53, -71, -66, -55, -65, -73, -51, -57, -49, -44, -39, -56, -43, -40, -43, 5, 6, 13, 17, 18, 21, 6, 7, 18, 3, -6, 2, -1, -9, 7, 15, 12, 4, 5, 14, 18, 15, 4, -93, -82, -99, -75, 24, 35, 22, 22, 31, -4, 7, -6, -6, 3, 14, -6, 1, 1, 4, 12, 22, 33, 20, 40, 25, 32, 31, 22, 42, 21, 22, 40, 32, 39, 44, 40, 33, 38, 35, 6, 11, 1, 6, -2, 11, 15, 2, 1, -57, -52, -62, -57, -59, -51, -86, -73, -80, -77, -70, -45, -48, -55, -45, -47, -67, -78, -57, -74, -65, -75, -74, -61, -76, -87, -66, -83, -74, -84, -83, -70, -86, -76, -67, -69, -80, 7, -4, 18, 9, 2, 13, 0, 0, 9, 29, 22, 30, 32, 31, 20, 25, 26, 23, 23, 32, 31, -60, -63, -65, -64, -52, -70, -60, -51, -67, -26, -29, -31, -30, -18, -35, -23, -20, -37, -26, 28, 25, 23, 24, 36, 19, 41, 17, 30, 28, 25, 23, 24, 36, 23, 31, 28, 20, 21, 30, 34, 31, 20, 41, 21, 28, 28, 31, 39, 22, 19, 17, 18, 30, 17, 28, 11, 35, -25, -28, -30, -29, -17, -30, -19, -32, -32, -23, 17, 14, 12, 13, 25, 12, 23, 10, 30, 35, 32, 30, 31, 43, 39, 32, 37, 34, 13, 10, 8, 9, 21, 20, 2, 13, 14, 16, 15, 26, 23, 21, 22, 34, 33, 19, 15, 21, 32, 19, 19, 28, -49, -52, -54, -53, -41, -42, -50, -36, -59, -49, -40, -56, -44, -47, -49, -48, -36, -37, -44, -55, -36, -51, -49, -38, -55, -31, -77, -80, -82, -81, -69, -70, -77, -88, -69, -84, -82, -71, -84, -64, 2, -1, -3, -2, 10, 9, 10, -5, -5, 2, -8, 2, 11, -5, -49, -52, -54, -53, -41, -36, -56, -49, -49, -46, -38, 18, 15, 19, 11, -57, -60, -56, -64, -62, -51, -64, -64, -55, -25, -28, -23, -32, -23, -3, -15, -9, -11, -2, 4, -15, -53, -65, -48, -51, -51, -52, 21, 13, 12, 17, 29, 21, 9, 25, 29, 9, 21, 9, 26, 17, 22, 13, -75, -83, -84, -79, -67, -75, -86, -76, -67, -83, -16, -24, -25, -20, -8, -16, -14, -11, -26, -21, -20, -25, -7, -15, -16, -11, 1, -7, -4, 1, -2, -4, -8, -15, -18, -26, -27, -22, -10, -18, -12, -26, -30, -24, -13, -26, -26, -17, -54, -62, -63, -58, -46, -54, -48, -55, -66, 
        -47, -62, -65, -55, -46, -62, -25, -33, -34, -29, -17, -25, -19, -22, -20, -29, -24, -31, -31, -20, -33, -33, -24, -84, -92, -93, -88, -76, -84, -77, -76, -79, -80, -76, -82, -88, -78, -92, -30, -38, -39, -34, -22, -30, -21, -34, -28, -31, -38, -23, -25, -38, -39, 7, 3, -2, 8, 3, 1, 2, 14, -4, 6, 15, -1, -88, -92, -87, -81, -98, -83, -96, -100, -88, 12, 8, 18, 19, 24, 17, 14, 18, 4, -27, -25, -37, -37, -39, -21, -31, -26, -55, -68, -47, -68, -59, -54, -46, -61, -60, -49, -64, -49, -62, -41, -38, 9, 6, -2, 6, -5, -3, -1, 40, 37, 34, 47, 30, -27, -30, -33, -20, -37, -38, -24, -41, -40, -22, -19, -36, -23, -30, -32, -49, -46, -63, -50, -57, -59, -46, -59, -60, -28, -25, -40, -35, -34, -39, -55, -70, -59, -66, -64, -56, -59, -67, -66, -57, -53, -56, -67, 28, 13, 24, 17, 19, 30, 17, 17, 26, 12, -3, 8, 1, 16, 17, 14, 13, 17, 11, 5, 15, 1, 30, 15, 26, 19, 36, 23, 29, 26, 19, 34, 32, 19, 18, -53, -68, -53, -68, -44, -68, -46, -61, -60, -53, -73, -84, -88, -86, -81, -73, -68, -83, -83, 26, 15, 28, 31, -67, -74, -69, -72, -35, -39, -30, -38, 13, 12, 20, 1, 2, 15, -1, 9, 18, 2, -12, -7, -10, -12, -16, -23, 42, 29, 26, 29, 27, 27, 25, 40, 45, 42, 40, 36, 29, -3, -16, -17, -35, -46, -51, 32, 21, 16, 15, -70, -73, -69, -63, -86, -70, -73, -65, -74, -25, -28, -18, -42, -31, -41, -31, -22, -38, 25, 7, 10, 10, 18, 11, 8, 24, 21, 29, 20, -76, -94, -83, -82, -80, -81, 11, -7, 6, -4, 17, -6, 10, 7, 15, 6, -76, -90, -94, -88, -77, -90, -90, -81, -33, -47, -51, -33, -44, -47, -40, -40, 13, 3, -1, 8, 8, -5, -59, -69, -66, -56, -73, -60, 12, 4, 18, -5, 5, 14, -2, -31, -38, -49, -30, -45, -48, -38, -29, -45, 29, 22, 11, 30, 15, 17, 28, 11, 35, -19, -26, -37, -18, -33, -31, -20, -33, -13, -15, -20, -19, -11, 29, 26, 28, 19, 24, 17, 17, 28, 15, 15, 24, 41, 42, 27, 27, 34, 24, 34, 43, 27, -31, -50, -37, -79, -94, -98, -87, -56, -68, -67, -57, -56, -64, -71, 11, 6, 4, -8, 11, 6, -38, -40, -57, -44, -39, -42, -57, -40, -53, -44, -38, -4, -3, -6, -7, -3, -9, -15, -5, -19, -3, -16, -10, -13, -20, -5, -68, -83, -86, -90, -71, -72, -87, -86, -75, -90, 15, 0, 1, 12, -3, 11, 5, 7, 3, -3, -75, -95, -88, -88, -85, -77, -8, -28, -21, -21, -18, -10, -26, -15, -28, -28, -19};
    }

    static {
        A06();
        A05 = Pattern.compile(A05(1, 38, 33));
        A04 = Pattern.compile(A05(91, 49, 72));
        A03 = Pattern.compile(A05(39, 52, 80));
        HashMap hashMap = new HashMap();
        A02 = hashMap;
        hashMap.put(A05(140, 9, 118), -984833);
        hashMap.put(A05(149, 12, 51), -332841);
        hashMap.put(A05(161, 4, 61), -16711681);
        hashMap.put(A05(165, 10, 98), -8388652);
        hashMap.put(A05(175, 5, 19), -983041);
        hashMap.put(A05(180, 5, 87), -657956);
        hashMap.put(A05(185, 6, R.styleable.AppCompatTheme_toolbarStyle), -6972);
        hashMap.put(A05(191, 5, 66), -16777216);
        hashMap.put(A05(196, 14, 21), -5171);
        hashMap.put(A05(210, 4, 47), -16776961);
        hashMap.put(A05(214, 10, R.styleable.AppCompatTheme_textAppearancePopupMenuHeader), -7722014);
        hashMap.put(A05(224, 5, 68), -5952982);
        hashMap.put(A05(229, 9, 20), -2180985);
        hashMap.put(A05(238, 9, 37), -10510688);
        hashMap.put(A05(247, 10, 70), -8388864);
        hashMap.put(A05(257, 9, R.styleable.AppCompatTheme_toolbarNavigationButtonStyle), -2987746);
        hashMap.put(A05(266, 5, 100), -32944);
        hashMap.put(A05(271, 14, R.styleable.AppCompatTheme_textColorSearchUrl), -10185235);
        hashMap.put(A05(285, 8, 74), -1828);
        hashMap.put(A05(293, 7, 83), -2354116);
        hashMap.put(A05(300, 4, 82), -16711681);
        hashMap.put(A05(304, 8, 49), -16777077);
        hashMap.put(A05(312, 8, 54), -16741493);
        hashMap.put(A05(320, 13, 82), -4684277);
        hashMap.put(A05(333, 8, 56), -5658199);
        hashMap.put(A05(341, 9, 47), -16751616);
        hashMap.put(A05(350, 8, 66), -5658199);
        hashMap.put(A05(358, 9, 47), -4343957);
        hashMap.put(A05(367, 11, R.styleable.AppCompatTheme_toolbarStyle), -7667573);
        hashMap.put(A05(378, 14, 65), -11179217);
        hashMap.put(A05(392, 10, 53), -29696);
        hashMap.put(A05(402, 10, 102), -6737204);
        hashMap.put(A05(412, 7, 30), -7667712);
        hashMap.put(A05(419, 10, 58), -1468806);
        hashMap.put(A05(429, 12, 38), -7357297);
        hashMap.put(A05(441, 13, 67), -12042869);
        hashMap.put(A05(454, 13, 7), -13676721);
        hashMap.put(A05(467, 13, 107), -13676721);
        hashMap.put(A05(480, 13, R.styleable.AppCompatTheme_textColorSearchUrl), -16724271);
        hashMap.put(A05(493, 10, R.styleable.AppCompatTheme_toolbarNavigationButtonStyle), -7077677);
        hashMap.put(A05(503, 8, 121), -60269);
        hashMap.put(A05(511, 11, 79), -16728065);
        hashMap.put(A05(522, 7, 45), -9868951);
        hashMap.put(A05(529, 7, 11), -9868951);
        hashMap.put(A05(536, 10, 41), -14774017);
        hashMap.put(A05(546, 9, 95), -5103070);
        hashMap.put(A05(555, 11, 53), -1296);
        hashMap.put(A05(566, 11, 59), -14513374);
        hashMap.put(A05(577, 7, 27), -65281);
        hashMap.put(A05(584, 9, 43), -2302756);
        hashMap.put(A05(593, 10, 99), -460545);
        hashMap.put(A05(603, 4, 88), -10496);
        hashMap.put(A05(607, 9, 101), -2448096);
        hashMap.put(A05(616, 4, 1), -8355712);
        hashMap.put(A05(620, 5, 118), -16744448);
        hashMap.put(A05(625, 11, 90), -5374161);
        hashMap.put(A05(636, 4, 116), -8355712);
        hashMap.put(A05(640, 8, 118), -983056);
        hashMap.put(A05(648, 7, 125), -38476);
        hashMap.put(A05(655, 9, 98), -3318692);
        hashMap.put(A05(664, 6, 35), -11861886);
        hashMap.put(A05(670, 5, 6), -16);
        hashMap.put(A05(675, 5, 45), -989556);
        hashMap.put(A05(680, 8, 22), -1644806);
        hashMap.put(A05(688, 13, 13), -3851);
        hashMap.put(A05(701, 9, 96), -8586240);
        hashMap.put(A05(710, 12, 118), -1331);
        hashMap.put(A05(722, 9, 29), -5383962);
        hashMap.put(A05(731, 10, 63), -1015680);
        hashMap.put(A05(741, 9, 117), -2031617);
        hashMap.put(A05(750, 20, 117), -329006);
        hashMap.put(A05(770, 9, R.styleable.AppCompatTheme_textColorSearchUrl), -2894893);
        hashMap.put(A05(779, 10, 64), -7278960);
        hashMap.put(A05(789, 9, R.styleable.AppCompatTheme_textAppearancePopupMenuHeader), -2894893);
        hashMap.put(A05(798, 9, 124), -18751);
        hashMap.put(A05(807, 11, 102), -24454);
        hashMap.put(A05(818, 13, R.styleable.AppCompatTheme_tooltipFrameBackground), -14634326);
        hashMap.put(A05(831, 12, 40), -7876870);
        hashMap.put(A05(843, 14, 45), -8943463);
        hashMap.put(A05(857, 14, 12), -8943463);
        hashMap.put(A05(871, 14, 91), -5192482);
        hashMap.put(A05(885, 11, 40), -32);
        hashMap.put(A05(896, 4, 107), -16711936);
        hashMap.put(A05(900, 9, 32), -13447886);
        hashMap.put(A05(909, 5, 64), -331546);
        hashMap.put(A05(914, 7, 85), -65281);
        hashMap.put(A05(921, 6, 35), -8388608);
        hashMap.put(A05(927, 16, 109), -10039894);
        hashMap.put(A05(943, 10, 13), -16777011);
        hashMap.put(A05(953, 12, 72), -4565549);
        hashMap.put(A05(965, 12, 81), -7114533);
        hashMap.put(A05(977, 14, 70), -12799119);
        hashMap.put(A05(991, 15, 34), -8689426);
        hashMap.put(A05(1006, 17, 63), -16713062);
        hashMap.put(A05(1023, 15, 4), -12004916);
        hashMap.put(A05(1038, 15, 58), -3730043);
        hashMap.put(A05(1053, 12, 95), -15132304);
        hashMap.put(A05(1065, 9, 0), -655366);
        hashMap.put(A05(1074, 9, 100), -6943);
        hashMap.put(A05(1083, 8, 61), -6987);
        hashMap.put(A05(1091, 11, 32), -8531);
        hashMap.put(A05(1102, 4, 38), -16777088);
        hashMap.put(A05(1106, 7, 95), -133658);
        hashMap.put(A05(1113, 5, 126), -8355840);
        hashMap.put(A05(1118, 9, 59), -9728477);
        hashMap.put(A05(1127, 6, 64), -23296);
        hashMap.put(A05(1133, 9, 37), -47872);
        hashMap.put(A05(1142, 6, 58), -2461482);
        hashMap.put(A05(1148, 13, 30), -1120086);
        hashMap.put(A05(1161, 9, R.styleable.AppCompatTheme_toolbarStyle), -6751336);
        hashMap.put(A05(1170, 13, 97), -5247250);
        hashMap.put(A05(1183, 13, R.styleable.AppCompatTheme_tooltipFrameBackground), -2396013);
        hashMap.put(A05(1196, 10, 32), -4139);
        hashMap.put(A05(1206, 9, 12), -9543);
        hashMap.put(A05(1215, 4, R.styleable.AppCompatTheme_textColorSearchUrl), -3308225);
        hashMap.put(A05(1219, 4, 18), -16181);
        hashMap.put(A05(1223, 4, 50), -2252579);
        hashMap.put(A05(1227, 10, 98), -5185306);
        hashMap.put(A05(1237, 6, 73), -8388480);
        hashMap.put(A05(1243, 13, 125), -10079335);
        hashMap.put(A05(1256, 3, 80), -65536);
        hashMap.put(A05(1266, 9, 13), -4419697);
        hashMap.put(A05(1275, 9, 58), -12490271);
        hashMap.put(A05(1284, 11, 107), -7650029);
        hashMap.put(A05(1295, 6, 6), -360334);
        hashMap.put(A05(1301, 10, 93), -744352);
        hashMap.put(A05(1311, 8, 6), -13726889);
        hashMap.put(A05(1319, 8, 49), -2578);
        hashMap.put(A05(1327, 6, 95), -6270419);
        hashMap.put(A05(1333, 6, 23), -4144960);
        hashMap.put(A05(1339, 7, 94), -7876885);
        hashMap.put(A05(1346, 9, 51), -9807155);
        hashMap.put(A05(1355, 9, R.styleable.AppCompatTheme_textColorSearchUrl), -9404272);
        hashMap.put(A05(1364, 9, 63), -9404272);
        hashMap.put(A05(1373, 4, 67), -1286);
        hashMap.put(A05(1377, 11, R.styleable.AppCompatTheme_textColorSearchUrl), -16711809);
        hashMap.put(A05(1388, 9, 123), -12156236);
        hashMap.put(A05(1397, 3, 50), -2968436);
        hashMap.put(A05(1400, 4, 2), -16744320);
        hashMap.put(A05(1404, 7, 25), -2572328);
        hashMap.put(A05(1411, 6, 92), -40121);
        hashMap.put(A05(1417, 11, 43), 0);
        hashMap.put(A05(1428, 9, 77), -12525360);
        hashMap.put(A05(1437, 6, 76), -1146130);
        hashMap.put(A05(1443, 5, 10), -663885);
        hashMap.put(A05(1448, 5, 6), -1);
        hashMap.put(A05(1453, 10, 93), -657931);
        hashMap.put(A05(1463, 6, 1), -256);
        hashMap.put(A05(1469, 11, 68), -6632142);
    }

    public static int A00(int i, int i5, int i6) {
        return A01(255, i, i5, i6);
    }

    public static int A01(int i, int i5, int i6, int i8) {
        return (i << 24) | (i5 << 16) | (i6 << 8) | i8;
    }

    public static int A02(String str) {
        return A04(str, true);
    }

    public static int A03(String str) {
        return A04(str, false);
    }

    public static int A04(String str, boolean z2) {
        int parseInt;
        AbstractC0672Ha.A03(!TextUtils.isEmpty(str));
        String replace = str.replace(A05(0, 1, R.styleable.AppCompatTheme_textAppearancePopupMenuHeader), A05(0, 0, 12));
        if (replace.charAt(0) == '#') {
            int parseLong = (int) Long.parseLong(replace.substring(1), 16);
            if (replace.length() == 7) {
                return (-16777216) | parseLong;
            }
            if (replace.length() == 9) {
                return ((parseLong & 255) << 24) | (parseLong >>> 8);
            }
            throw new IllegalArgumentException();
        }
        if (replace.startsWith(A05(1262, 4, R.styleable.AppCompatTheme_tooltipFrameBackground))) {
            Matcher matcher = (z2 ? A03 : A04).matcher(replace);
            if (matcher.matches()) {
                if (z2) {
                    parseInt = (int) (Float.parseFloat(matcher.group(4)) * 255.0f);
                } else {
                    parseInt = Integer.parseInt(matcher.group(4), 10);
                }
                int parseInt2 = Integer.parseInt(matcher.group(1), 10);
                int parseInt3 = Integer.parseInt(matcher.group(2), 10);
                String[] strArr = A01;
                if (strArr[4].charAt(5) != strArr[0].charAt(5)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A01;
                strArr2[1] = "i1bnGI2WXKaVYJXfMn7YRL5gejl76mTS";
                strArr2[6] = "Q8iEyI0G3jyYp4xQrSuJe5dBbsFXiWU7";
                return A01(parseInt, parseInt2, parseInt3, Integer.parseInt(matcher.group(3), 10));
            }
        } else if (replace.startsWith(A05(1259, 3, 48))) {
            Matcher matcher2 = A05.matcher(replace);
            if (matcher2.matches()) {
                int parseInt4 = Integer.parseInt(matcher2.group(1), 10);
                int parseInt5 = Integer.parseInt(matcher2.group(2), 10);
                String[] strArr3 = A01;
                if (strArr3[1].charAt(5) != strArr3[6].charAt(5)) {
                    throw new RuntimeException();
                }
                String[] strArr4 = A01;
                strArr4[1] = "ezVgRIoabJhxBCI2cvdFE20BeIZAp1Xu";
                strArr4[6] = "DgnKHI2mL4GHRbLV9UvsFWuJtUmEL3Fc";
                return A00(parseInt4, parseInt5, Integer.parseInt(matcher2.group(3), 10));
            }
        } else {
            Integer color = A02.get(IF.A0M(replace));
            if (color != null) {
                return color.intValue();
            }
        }
        throw new IllegalArgumentException();
    }
}
