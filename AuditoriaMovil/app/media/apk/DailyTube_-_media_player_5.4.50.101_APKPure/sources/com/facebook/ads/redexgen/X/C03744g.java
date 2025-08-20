package com.facebook.ads.redexgen.X;

import android.util.Log;
import com.uv.v7.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* renamed from: com.facebook.ads.redexgen.X.4g  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C03744g extends C8 {
    public static byte[] A05;
    public static String[] A06 = {"qvo0GMLMlCI9r2KvubgW", "xANfLU", "vfLxBByg2WxKhxozFOdEyd4oNWbI2yKZ", "M6AXkYe8VdVGq", "jqpt9kLQVEpjtzmdo0kCC28NolZOOofM", "wQfQ1ikODVE5", "8nxGlLt3aQnzE5X", "LzSrLgRmD2ZM4QoK2ANM"};
    public static final Pattern A07;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public final boolean A04;

    public static String A02(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 52);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A05 = new byte[]{7, 81, 70, 67, 81, 37, 29, 82, 80, 67, 80, 70, 81, 37, 29, 82, 80, 67, 81, 37, 29, 82, 80, 81, 70, 67, 67, 5, 37, 87, 80, 81, 37, 29, 82, 80, 49, 108, 65, 73, 68, 71, 79, 93, 77, 18, 8, 67, 106, 119, 104, 100, 113, 63, 37, 76, 116, 118, 111, 111, 118, 113, 120, 63, 123, 118, 126, 115, 112, 120, 106, 122, 63, 115, 118, 113, 122, 63, 125, 122, 121, 112, 109, 122, 63, 124, 112, 114, 111, 115, 122, 107, 122, 63, 121, 112, 109, 114, 126, 107, 37, 63, 32, 24, 26, 3, 3, 26, 29, 20, 83, 23, 26, 18, 31, 28, 20, 6, 22, 83, 31, 26, 29, 22, 83, 4, 26, 7, 27, 83, 21, 22, 4, 22, 1, 83, 16, 28, 31, 6, 30, 29, 0, 83, 7, 27, 18, 29, 83, 21, 28, 1, 30, 18, 7, 73, 83, 8, 48, 50, 43, 43, 50, 53, 60, 123, 50, 53, 45, 58, 55, 50, 63, 123, 47, 50, 54, 50, 53, 60, 97, 123, 65, 97, 115, 86, 119, 113, 125, 118, 119, 96, 26, 4, 55, 36, 47, 53, 50, 28, 70, 70, 84, 90, 90, 104, 85, 114, 39, 35, 54, 85, 116, 110, 101, 111, 102, 97, 116, 103, 97, 18, 3, 30, 18};
    }

    static {
        A03();
        A07 = Pattern.compile(A02(1, 35, 77));
    }

    public C03744g() {
        this(null);
    }

    public C03744g(List<byte[]> list) {
        super(A02(182, 10, 38));
        if (list != null && !list.isEmpty()) {
            this.A04 = true;
            String A0Q = IF.A0Q(list.get(0));
            String formatLine = A02(47, 8, 49);
            AbstractC0672Ha.A03(A0Q.startsWith(formatLine));
            A06(A0Q);
            A04(new C0697Hz(list.get(1)));
            return;
        }
        this.A04 = false;
    }

    public static long A00(String str) {
        Matcher matcher = A07.matcher(str);
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        return (Long.parseLong(matcher.group(1)) * 60 * 60 * 1000000) + (Long.parseLong(matcher.group(2)) * 60 * 1000000) + (Long.parseLong(matcher.group(3)) * 1000000) + (Long.parseLong(matcher.group(4)) * 10000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C8
    /* renamed from: A01 */
    public final WF A0b(byte[] bArr, int i, boolean z2) {
        ArrayList arrayList = new ArrayList();
        C0687Hp c0687Hp = new C0687Hp();
        C0697Hz c0697Hz = new C0697Hz(bArr, i);
        if (!this.A04) {
            A04(c0697Hz);
        }
        A05(c0697Hz, arrayList, c0687Hp);
        C0635Fn[] c0635FnArr = new C0635Fn[arrayList.size()];
        arrayList.toArray(c0635FnArr);
        return new WF(c0635FnArr, c0687Hp.A05());
    }

    private void A04(C0697Hz c0697Hz) {
        String A0P;
        do {
            A0P = c0697Hz.A0P();
            if (A0P == null) {
                return;
            }
        } while (!A0P.startsWith(A02(192, 8, 117)));
    }

    private void A05(C0697Hz c0697Hz, List<C0635Fn> list, C0687Hp c0687Hp) {
        while (true) {
            String A0P = c0697Hz.A0P();
            if (A0P != null) {
                if (!this.A04 && A0P.startsWith(A02(47, 8, 49))) {
                    A06(A0P);
                } else if (A0P.startsWith(A02(37, 10, 28))) {
                    A07(A0P, list, c0687Hp);
                }
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x005d, code lost:
        if (r6.equals(A02(216, 5, 33)) != false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void A06(java.lang.String r9) {
        /*
            r8 = this;
            r2 = 47
            r1 = 8
            r0 = 49
            java.lang.String r0 = A02(r2, r1, r0)
            int r0 = r0.length()
            java.lang.String r3 = r9.substring(r0)
            r2 = 36
            r1 = 1
            r0 = 41
            java.lang.String r0 = A02(r2, r1, r0)
            java.lang.String[] r5 = android.text.TextUtils.split(r3, r0)
            int r0 = r5.length
            r8.A01 = r0
            r3 = -1
            r8.A02 = r3
            r8.A00 = r3
            r8.A03 = r3
            r4 = 0
        L2a:
            int r0 = r8.A01
            r7 = 0
            if (r4 >= r0) goto L82
            r0 = r5[r4]
            java.lang.String r0 = r0.trim()
            java.lang.String r6 = com.facebook.ads.redexgen.X.IF.A0M(r0)
            int r0 = r6.hashCode()
            switch(r0) {
                case 100571: goto L71;
                case 3556653: goto L60;
                case 109757538: goto L50;
                default: goto L40;
            }
        L40:
            r7 = -1
        L41:
            switch(r7) {
                case 0: goto L4d;
                case 1: goto L4a;
                case 2: goto L47;
                default: goto L44;
            }
        L44:
            int r4 = r4 + 1
            goto L2a
        L47:
            r8.A03 = r4
            goto L44
        L4a:
            r8.A00 = r4
            goto L44
        L4d:
            r8.A02 = r4
            goto L44
        L50:
            r2 = 216(0xd8, float:3.03E-43)
            r1 = 5
            r0 = 33
            java.lang.String r0 = A02(r2, r1, r0)
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L40
            goto L41
        L60:
            r2 = 221(0xdd, float:3.1E-43)
            r1 = 4
            r0 = 82
            java.lang.String r0 = A02(r2, r1, r0)
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L40
            r7 = 2
            goto L41
        L71:
            r2 = 213(0xd5, float:2.98E-43)
            r1 = 3
            r0 = 63
            java.lang.String r0 = A02(r2, r1, r0)
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L40
            r7 = 1
            goto L41
        L82:
            int r0 = r8.A02
            if (r0 == r3) goto L8e
            int r0 = r8.A00
            if (r0 == r3) goto L8e
            int r0 = r8.A03
            if (r0 != r3) goto L90
        L8e:
            r8.A01 = r7
        L90:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C03744g.A06(java.lang.String):void");
    }

    private void A07(String str, List<C0635Fn> list, C0687Hp c0687Hp) {
        int i = this.A01;
        String A02 = A02(182, 10, 38);
        if (i == 0) {
            Log.w(A02, A02(55, 47, 43) + str);
            return;
        }
        String[] split = str.substring(A02(37, 10, 28).length()).split(A02(36, 1, 41), this.A01);
        if (split.length != this.A01) {
            Log.w(A02, A02(102, 55, 71) + str);
            return;
        }
        long startTimeUs = A00(split[this.A02]);
        String A022 = A02(157, 25, R.styleable.AppCompatTheme_textColorSearchUrl);
        if (startTimeUs == -9223372036854775807L) {
            Log.w(A02, A022 + str);
            return;
        }
        long j2 = -9223372036854775807L;
        String str2 = split[this.A00];
        if (!str2.trim().isEmpty()) {
            j2 = A00(str2);
            if (j2 == -9223372036854775807L) {
                Log.w(A02, A022 + str);
                return;
            }
        }
        String endTimeString = split[this.A03].replaceAll(A02(206, 7, 61), A02(0, 0, 97));
        String A023 = A02(200, 3, 46);
        String A024 = A02(0, 1, 57);
        list.add(new C0635Fn(endTimeString.replaceAll(A023, A024).replaceAll(A02(203, 3, 50), A024)));
        c0687Hp.A04(startTimeUs);
        if (j2 != -9223372036854775807L) {
            list.add(null);
            String[] strArr = A06;
            if (strArr[3].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[3] = "QluocDWeuHRDa";
            strArr2[6] = "JZgOBObbaiMn4tK";
            c0687Hp.A04(j2);
        }
    }
}
