package com.facebook.ads.redexgen.X;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import com.uv.v7.R;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: assets/audience_network.dex */
public final class GR {
    public static byte[] A01;
    public static String[] A02 = {"JYYG6mQudNNGYNEgDR02nAMcKzDjIK4P", "2FeNcZ4AMvklOu4dQ", "gTW6toOfk8MVsyPSs", "RutE2HgswW2Ba8ERBuDpKSxIcN55U9", "rp2dSjsGIei", "VbvhM5GUqSDZ5Gwz8nmiFAQ41xb0JLlL", "3r4p5hSJjLrlxa79edZPjpayqJig4NbN", "nYAJe"};
    public static final Pattern A03;
    public static final Pattern A04;
    public final StringBuilder A00 = new StringBuilder();

    public static String A03(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 77);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A01 = new byte[]{39, 124, 71, 101, 17, 30, 102, 114, 100, 119, 101, 17, 30, 102, 100, 100, 94, 66, 56, 31, 7, 16, 29, 24, 21, 81, 16, 29, 24, 22, 31, 28, 20, 31, 5, 81, 7, 16, 29, 4, 20, 75, 81, 25, 62, 38, 49, 60, 57, 52, 112, 49, 62, 51, 56, 63, 34, 112, 38, 49, 60, 37, 53, 106, 112, 81, 105, 107, 114, 114, 107, 108, 101, 34, 96, 99, 102, 34, 97, 119, 103, 34, 113, 103, 118, 118, 107, 108, 101, 56, 34, 105, 81, 83, 74, 74, 83, 84, 93, 26, 89, 79, 95, 26, 77, 83, 78, 82, 26, 88, 91, 94, 26, 82, 95, 91, 94, 95, 72, 0, 26, 15, 52, 49, 52, 53, 45, 52, 122, 57, 47, 63, 122, 41, 63, 46, 46, 51, 52, 61, 122, 21, 39, 32, 52, 54, 54, 1, 55, 39, 18, 35, 48, 49, 39, 48, 58, 65, 61, 79, 60, 88, 46, 90, 85, 45, 47, 90, 117, 45, 43, 43, 56, 90, 117, 45, 46, 90, 85, 45, 47, 46, 40, 44, 47, 57, 34, 106, 103, 98, 108, 101, 48, 60, 33, 109, 36, 76, 74, 65, 91, 74, 93, 24, 19, 25, 20, 7, 66, 99, 109, 100, 101, 120, 99, 100, 109, 42, Byte.MAX_VALUE, 100, 121, Byte.MAX_VALUE, 122, 122, 101, 120, 126, 111, 110, 42, 111, 100, 126, 99, 126, 115, 48, 42, 45, 44, 53, 56, 55, 62, 9, 0, 3, 17, 114, 119, 112, 123, 84, 76, 24, 28, 17, 17, 25, 16, 87, 91, 74, 73, 79, 80, 76, 86, 75, 86, 80, 81, 34, 57, 55, 56, 36, 58, 32, 51, 44, 29, 26, 15, 28, 26, 111, 74};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static void A0C(String str, String str2, GO go, List<GM> list) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < str2.length()) {
            char charAt = str2.charAt(i);
            switch (charAt) {
                case '&':
                    int indexOf = str2.indexOf(59, i + 1);
                    int indexOf2 = str2.indexOf(32, i + 1);
                    if (indexOf == -1) {
                        indexOf = indexOf2;
                    } else if (indexOf2 != -1) {
                        indexOf = Math.min(indexOf, indexOf2);
                    }
                    if (indexOf == -1) {
                        spannableStringBuilder.append(charAt);
                        i++;
                        break;
                    } else {
                        A07(str2.substring(i + 1, indexOf), spannableStringBuilder);
                        if (indexOf == indexOf2) {
                            spannableStringBuilder.append((CharSequence) A03(1, 1, 17));
                        }
                        i = indexOf + 1;
                        break;
                    }
                case '<':
                    if (i + 1 < str2.length()) {
                        int i5 = i;
                        boolean z2 = str2.charAt(i5 + 1) == '/';
                        i = A01(str2, i5 + 1);
                        boolean z3 = str2.charAt(i + (-2)) == '/';
                        String substring = str2.substring((z2 ? 2 : 1) + i5, z3 ? i - 2 : i - 1);
                        String A042 = A04(substring);
                        if (A042 != null && A0E(A042)) {
                            if (!z2) {
                                if (!z3) {
                                    arrayDeque.push(GP.A01(substring, spannableStringBuilder.length()));
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                while (!arrayDeque.isEmpty()) {
                                    GP gp = (GP) arrayDeque.pop();
                                    A0B(str, gp, spannableStringBuilder, list, arrayList);
                                    if (gp.A01.equals(A042)) {
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                    } else {
                        i++;
                        break;
                    }
                    break;
                default:
                    spannableStringBuilder.append(charAt);
                    if (A02[6].charAt(12) == 'U') {
                        throw new RuntimeException();
                    }
                    String[] strArr = A02;
                    strArr[0] = "1EgemSjEd6OX6IjZrpNfGkrOscE7SpVJ";
                    strArr[5] = "BPkE8PNmcvUgQGAm1QCgLjutlWPlJ3J2";
                    i++;
                    break;
            }
        }
        while (!arrayDeque.isEmpty()) {
            A0B(str, (GP) arrayDeque.pop(), spannableStringBuilder, list, arrayList);
        }
        A0B(str, GP.A00(), spannableStringBuilder, list, arrayList);
        go.A0C(spannableStringBuilder);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final boolean A0G(C0697Hz c0697Hz, GO go, List<GM> list) {
        String A0P = c0697Hz.A0P();
        if (A0P == null) {
            return false;
        }
        Pattern pattern = A03;
        Matcher matcher = pattern.matcher(A0P);
        if (matcher.matches()) {
            return A0F(null, matcher, c0697Hz, go, this.A00, list);
        }
        String A0P2 = c0697Hz.A0P();
        if (A0P2 == null) {
            return false;
        }
        Matcher matcher2 = pattern.matcher(A0P2);
        if (matcher2.matches()) {
            return A0F(A0P.trim(), matcher2, c0697Hz, go, this.A00, list);
        }
        return false;
    }

    static {
        A05();
        A03 = Pattern.compile(A03(161, 26, 75));
        A04 = Pattern.compile(A03(3, 12, 0));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a2, code lost:
        if (r3 != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a4, code lost:
        r0 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00b3, code lost:
        if (r3 != false) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int A00(java.lang.String r7) {
        /*
            int r0 = r7.hashCode()
            r6 = 2
            r5 = 1
            r4 = 0
            switch(r0) {
                case -1364013995: goto L82;
                case -1074341483: goto L71;
                case 100571: goto L4a;
                case 109757538: goto L39;
                default: goto La;
            }
        La:
            r0 = -1
        Lb:
            switch(r0) {
                case 0: goto Lb8;
                case 1: goto Lb7;
                case 2: goto Lb7;
                case 3: goto Lb6;
                default: goto Le;
            }
        Le:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r2 = 43
            r1 = 22
            r0 = 29
            java.lang.String r0 = A03(r2, r1, r0)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.StringBuilder r0 = r0.append(r7)
            java.lang.String r3 = r0.toString()
            r2 = 141(0x8d, float:1.98E-43)
            r1 = 15
            r0 = 15
            java.lang.String r0 = A03(r2, r1, r0)
            android.util.Log.w(r0, r3)
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            return r0
        L39:
            r2 = 281(0x119, float:3.94E-43)
            r1 = 5
            r0 = 35
            java.lang.String r0 = A03(r2, r1, r0)
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto La
            r0 = 0
            goto Lb
        L4a:
            r3 = 203(0xcb, float:2.84E-43)
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.GR.A02
            r0 = 6
            r1 = r1[r0]
            r0 = 12
            char r1 = r1.charAt(r0)
            r0 = 85
            if (r1 == r0) goto Lb9
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.GR.A02
            java.lang.String r1 = "1rUDZc1zpmKXAlK5wqzuXN7L1n8yuk"
            r0 = 4
            r2[r0] = r1
            r1 = 3
            r0 = 48
            java.lang.String r0 = A03(r3, r1, r0)
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto La
            r0 = 3
            goto Lb
        L71:
            r2 = 254(0xfe, float:3.56E-43)
            r1 = 6
            r0 = 56
            java.lang.String r0 = A03(r2, r1, r0)
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto La
            r0 = 2
            goto Lb
        L82:
            r2 = 197(0xc5, float:2.76E-43)
            r1 = 6
            r0 = 98
            java.lang.String r0 = A03(r2, r1, r0)
            boolean r3 = r7.equals(r0)
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.GR.A02
            r0 = 7
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 5
            if (r1 == r0) goto La7
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.GR.A02
            java.lang.String r1 = "DMfdGkOFUxynodxW9z1tlml8oHZW88"
            r0 = 4
            r2[r0] = r1
            if (r3 == 0) goto La
        La4:
            r0 = 1
            goto Lb
        La7:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.GR.A02
            java.lang.String r1 = "ZWUMzT4FbwhCC9zvg"
            r0 = 2
            r2[r0] = r1
            java.lang.String r1 = "lQdDUKdfIZs4MkB9q"
            r0 = 1
            r2[r0] = r1
            if (r3 == 0) goto La
            goto La4
        Lb6:
            return r6
        Lb7:
            return r5
        Lb8:
            return r4
        Lb9:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.GR.A00(java.lang.String):int");
    }

    public static int A01(String str, int i) {
        int indexOf = str.indexOf(62, i);
        if (indexOf == -1) {
            int index = str.length();
            return index;
        }
        int index2 = indexOf + 1;
        return index2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static Layout.Alignment A02(String str) {
        char c2;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals(A03(197, 6, 98))) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -1074341483:
                if (str.equals(A03(254, 6, 56))) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 100571:
                if (str.equals(A03(203, 3, 48))) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 3317767:
                if (str.equals(A03(244, 4, 40))) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 108511772:
                if (str.equals(A03(272, 5, 29))) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case 109757538:
                if (str.equals(A03(281, 5, 35))) {
                    c2 = 0;
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
            case 1:
                return Layout.Alignment.ALIGN_NORMAL;
            case 2:
            case 3:
                return Layout.Alignment.ALIGN_CENTER;
            case 4:
            case 5:
                return Layout.Alignment.ALIGN_OPPOSITE;
            default:
                Log.w(A03(141, 15, 15), A03(18, 25, 60) + str);
                return null;
        }
    }

    public static String A04(String str) {
        String trim = str.trim();
        if (trim.isEmpty()) {
            if (A02[4].length() != 19) {
                A02[3] = "n2qP40ip31gyFkT4bwxWbWgEBn8x5R";
                return null;
            }
            throw new RuntimeException();
        }
        return IF.A0m(trim, A03(156, 5, 44))[0];
    }

    public static void A06(SpannableStringBuilder spannableStringBuilder, GM gm, int i, int i5) {
        if (gm == null) {
            return;
        }
        if (gm.A08() != -1) {
            spannableStringBuilder.setSpan(new StyleSpan(gm.A08()), i, i5, 33);
        }
        if (gm.A0O()) {
            spannableStringBuilder.setSpan(new StrikethroughSpan(), i, i5, 33);
        }
        if (gm.A0P()) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i, i5, 33);
        }
        if (gm.A0N()) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(gm.A06()), i, i5, 33);
        }
        if (gm.A0M()) {
            spannableStringBuilder.setSpan(new BackgroundColorSpan(gm.A05()), i, i5, 33);
        }
        String A0H = gm.A0H();
        if (A02[6].charAt(12) != 'U') {
            A02[6] = "tzfwj6Yb5L7snAfsv0bj9UNvpNFUfxvv";
            if (A0H != null) {
                spannableStringBuilder.setSpan(new TypefaceSpan(gm.A0H()), i, i5, 33);
            }
            if (gm.A0A() != null) {
                spannableStringBuilder.setSpan(new AlignmentSpan.Standard(gm.A0A()), i, i5, 33);
            }
            switch (gm.A07()) {
                case 1:
                    spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) gm.A04(), true), i, i5, 33);
                    return;
                case 2:
                    spannableStringBuilder.setSpan(new RelativeSizeSpan(gm.A04()), i, i5, 33);
                    return;
                case 3:
                    spannableStringBuilder.setSpan(new RelativeSizeSpan(gm.A04() / 100.0f), i, i5, 33);
                    return;
                default:
                    return;
            }
        }
        throw new RuntimeException();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void A07(String str, SpannableStringBuilder spannableStringBuilder) {
        char c2;
        switch (str.hashCode()) {
            case 3309:
                if (str.equals(A03(206, 2, 62))) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 3464:
                if (str.equals(A03(252, 2, 117))) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 96708:
                if (str.equals(A03(192, 3, 28))) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 3374865:
                if (str.equals(A03(260, 4, 116))) {
                    c2 = 2;
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
                spannableStringBuilder.append('<');
                return;
            case 1:
                spannableStringBuilder.append('>');
                return;
            case 2:
                spannableStringBuilder.append(' ');
                return;
            case 3:
                if (A02[7].length() != 5) {
                    throw new RuntimeException();
                }
                A02[7] = "j55CB";
                spannableStringBuilder.append('&');
                return;
            default:
                Log.w(A03(141, 15, 15), A03(209, 31, 71) + str + A03(16, 2, 40));
                return;
        }
    }

    public static void A08(String str, GO go) {
        String value = A03(141, 15, 15);
        Matcher matcher = A04.matcher(str);
        while (true) {
            boolean find = matcher.find();
            if (A02[7].length() != 5) {
                throw new RuntimeException();
            }
            A02[7] = "ISZNO";
            if (find) {
                String group = matcher.group(1);
                String group2 = matcher.group(2);
                try {
                    if (A03(248, 4, 83).equals(group)) {
                        A09(group2, go);
                    } else if (A03(187, 5, 70).equals(group)) {
                        go.A0B(A02(group2));
                    } else if (A03(264, 8, R.styleable.AppCompatTheme_tooltipForegroundColor).equals(group)) {
                        A0A(group2, go);
                    } else if (A03(277, 4, 4).equals(group)) {
                        go.A05(GS.A00(group2));
                    } else {
                        Log.w(value, A03(121, 20, 23) + group + A03(15, 1, 19) + group2);
                    }
                } catch (NumberFormatException unused) {
                    Log.w(value, A03(65, 26, 79) + matcher.group());
                }
            } else {
                return;
            }
        }
    }

    public static void A09(String str, GO go) throws NumberFormatException {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            go.A06(A00(str.substring(indexOf + 1)));
            str = str.substring(0, indexOf);
        } else {
            go.A06(Integer.MIN_VALUE);
        }
        if (str.endsWith(A03(2, 1, 47))) {
            go.A03(GS.A00(str)).A07(0);
            return;
        }
        int commaIndex = Integer.parseInt(str);
        if (commaIndex < 0) {
            commaIndex--;
        }
        go.A03(commaIndex).A07(1);
    }

    public static void A0A(String str, GO go) throws NumberFormatException {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            int commaIndex = indexOf + 1;
            go.A08(A00(str.substring(commaIndex)));
            str = str.substring(0, indexOf);
        } else {
            go.A08(Integer.MIN_VALUE);
        }
        go.A04(GS.A00(str));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void A0B(String str, GP gp, SpannableStringBuilder spannableStringBuilder, List<GM> list, List<GQ> list2) {
        char c2;
        int i = gp.A00;
        int i5 = spannableStringBuilder.length();
        String str2 = gp.A01;
        int start = str2.hashCode();
        switch (start) {
            case 0:
                if (str2.equals(A03(0, 0, 94))) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case 98:
                if (str2.equals(A03(195, 1, 66))) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 99:
                if (str2.equals(A03(196, 1, 10))) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 105:
                if (str2.equals(A03(208, 1, 102))) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 117:
                if (str2.equals(A03(286, 1, 87))) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 118:
                if (str2.equals(A03(287, 1, R.styleable.AppCompatTheme_toolbarStyle))) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case 3314158:
                if (str2.equals(A03(240, 4, 20))) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        String[] strArr = A02;
        String str3 = strArr[2];
        String str4 = strArr[1];
        int end = str3.length();
        int start2 = str4.length();
        if (end != start2) {
            throw new RuntimeException();
        }
        A02[4] = "fbk5bLqQNEDh8uMBzoI0ZNvOUZBwB";
        switch (c2) {
            case 0:
                spannableStringBuilder.setSpan(new StyleSpan(1), i, i5, 33);
                break;
            case 1:
                spannableStringBuilder.setSpan(new StyleSpan(2), i, i5, 33);
                break;
            case 2:
                spannableStringBuilder.setSpan(new UnderlineSpan(), i, i5, 33);
                break;
            case 3:
            case 4:
            case 5:
            case 6:
                break;
            default:
                return;
        }
        list2.clear();
        A0D(list, str, gp, list2);
        int styleMatchesCount = list2.size();
        for (int end2 = 0; end2 < styleMatchesCount; end2++) {
            A06(spannableStringBuilder, list2.get(end2).A01, i, i5);
        }
    }

    public static void A0D(List<GM> list, String str, GP gp, List<GQ> list2) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            GM gm = list.get(i);
            String str2 = gp.A01;
            String[] strArr = gp.A03;
            String str3 = gp.A02;
            int i5 = A02[3].length();
            if (i5 == 7) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[0] = "AMyBO4NnCnMpgJ1A04yWFmVBrU3uxkkG";
            strArr2[5] = "4pWDMPx0mcGHcptb8cUlFxOOK6mkNbT4";
            int styleCount = gm.A09(str, str2, strArr, str3);
            if (styleCount > 0) {
                list2.add(new GQ(styleCount, gm));
            }
        }
        Collections.sort(list2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static boolean A0E(String str) {
        char c2;
        switch (str.hashCode()) {
            case 98:
                if (str.equals(A03(195, 1, 66))) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 99:
                if (str.equals(A03(196, 1, 10))) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 105:
                if (str.equals(A03(208, 1, 102))) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 117:
                if (str.equals(A03(286, 1, 87))) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 118:
                if (str.equals(A03(287, 1, R.styleable.AppCompatTheme_toolbarStyle))) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case 3314158:
                if (str.equals(A03(240, 4, 20))) {
                    c2 = 3;
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
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return true;
            default:
                return false;
        }
    }

    public static boolean A0F(String str, Matcher matcher, C0697Hz c0697Hz, GO go, StringBuilder sb, List<GM> list) {
        try {
            go.A0A(GS.A01(matcher.group(1))).A09(GS.A01(matcher.group(2)));
            A08(matcher.group(3), go);
            sb.setLength(0);
            while (true) {
                String A0P = c0697Hz.A0P();
                if (!TextUtils.isEmpty(A0P)) {
                    if (sb.length() > 0) {
                        sb.append(A03(0, 1, 96));
                    }
                    sb.append(A0P.trim());
                } else {
                    A0C(str, sb.toString(), go, list);
                    return true;
                }
            }
        } catch (NumberFormatException unused) {
            Log.w(A03(141, 15, 15), A03(91, 30, 119) + matcher.group());
            return false;
        }
    }
}
