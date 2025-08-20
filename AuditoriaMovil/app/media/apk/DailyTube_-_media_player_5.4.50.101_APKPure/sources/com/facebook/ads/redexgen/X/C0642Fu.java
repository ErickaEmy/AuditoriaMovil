package com.facebook.ads.redexgen.X;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.Fu  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0642Fu {
    public static String[] A08 = {"XC7eQ7mnDigGIQL7dx0KfLpc2FT", "IUrjEkKy3b2jJtDJZ33sGt", "", "4VXLd4NK2UMSrr9tKiehY90A", "S2gwvpBwwRoio7AP3LwECfAaRkk6O4ZY", "9TUF7Ks7YtQxur", "s5iWH5PZ", "Ea283cgdBM89En3yGupwQHUZzzjf5u4Q"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public final List<C0641Ft> A06 = new ArrayList();
    public final List<SpannableString> A07 = new ArrayList();
    public final StringBuilder A05 = new StringBuilder();

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final C0635Fn A05() {
        float f4;
        int i;
        int i5;
        int i6;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i8 = 0; i8 < this.A07.size(); i8++) {
            spannableStringBuilder.append((CharSequence) this.A07.get(i8));
            spannableStringBuilder.append('\n');
        }
        spannableStringBuilder.append((CharSequence) A00());
        if (A08[2].length() != 4) {
            A08[4] = "XUGi3jQBIuRQftqARNMB36bn2TyuzRos";
            if (spannableStringBuilder.length() == 0) {
                if (A08[1].length() != 22) {
                    A08[1] = "sMaadG1MTySiyP3TGzo1T4";
                    return null;
                }
                A08[1] = "nS4SC9sWxiUu8g9Arai4ZN";
                return null;
            }
            int i10 = this.A02;
            int i11 = this.A04;
            if (A08[7].charAt(3) != 'N') {
                A08[4] = "yDKFp8g0FkQkvFDtr9inWFZi093Wo6Xo";
                int i12 = i10 + i11;
                int length = (32 - i12) - spannableStringBuilder.length();
                int i13 = i12 - length;
                if (this.A00 == 2 && (Math.abs(i13) < 3 || length < 0)) {
                    f4 = 0.5f;
                    i = 1;
                } else if (this.A00 != 2 || i13 <= 0) {
                    f4 = (0.8f * (i12 / 32.0f)) + 0.1f;
                    i = 0;
                } else {
                    int i14 = 32 - length;
                    if (A08[4].charAt(13) == 'W') {
                        throw new RuntimeException();
                    }
                    A08[2] = "dWj1xsuyJgYxC";
                    f4 = (0.8f * (i14 / 32.0f)) + 0.1f;
                    i = 2;
                }
                if (this.A00 == 1 || this.A03 > 7) {
                    i5 = 2;
                    i6 = (this.A03 - 15) - 2;
                } else {
                    i5 = 0;
                    i6 = this.A03;
                }
                return new C0635Fn(spannableStringBuilder, Layout.Alignment.ALIGN_NORMAL, i6, 1, i5, f4, i, Float.MIN_VALUE);
            }
        }
        throw new RuntimeException();
    }

    public C0642Fu(int i, int i5) {
        A09(i);
        A0A(i5);
    }

    private final SpannableString A00() {
        int i;
        int[] iArr;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.A05);
        int length = spannableStringBuilder.length();
        int i5 = -1;
        int nextColor = -1;
        int i6 = 0;
        int color = -1;
        boolean z2 = false;
        int colorStartPosition = -1;
        for (int italicStartPosition = 0; italicStartPosition < this.A06.size(); italicStartPosition++) {
            C0641Ft c0641Ft = this.A06.get(italicStartPosition);
            boolean z3 = c0641Ft.A02;
            int i8 = c0641Ft.A01;
            if (i8 != 8) {
                z2 = i8 == 7;
                if (i8 != 7) {
                    iArr = C5A.A0K;
                    colorStartPosition = iArr[i8];
                }
            }
            int length2 = c0641Ft.A00;
            if (A08[1].length() != 22) {
                throw new RuntimeException();
            }
            String[] strArr = A08;
            strArr[6] = "A7DJ6NHY";
            strArr[5] = "4roHVg72rzpV8d";
            if (italicStartPosition + 1 < this.A06.size()) {
                i = this.A06.get(italicStartPosition + 1).A00;
            } else {
                i = length;
            }
            if (length2 != i) {
                if (i5 != -1 && !z3) {
                    A02(spannableStringBuilder, i5, length2);
                    i5 = -1;
                } else if (i5 == -1 && z3) {
                    i5 = length2;
                }
                if (nextColor != -1 && !z2) {
                    A01(spannableStringBuilder, nextColor, length2);
                    nextColor = -1;
                } else if (nextColor == -1 && z2) {
                    nextColor = length2;
                }
                if (colorStartPosition != color) {
                    A03(spannableStringBuilder, i6, length2, color);
                    color = colorStartPosition;
                    i6 = length2;
                }
            }
        }
        if (i5 != -1 && i5 != length) {
            A02(spannableStringBuilder, i5, length);
        }
        if (nextColor != -1 && nextColor != length) {
            A01(spannableStringBuilder, nextColor, length);
        }
        if (i6 != length) {
            A03(spannableStringBuilder, i6, length, color);
        }
        return new SpannableString(spannableStringBuilder);
    }

    public static void A01(SpannableStringBuilder spannableStringBuilder, int i, int i5) {
        spannableStringBuilder.setSpan(new StyleSpan(2), i, i5, 33);
    }

    public static void A02(SpannableStringBuilder spannableStringBuilder, int i, int i5) {
        spannableStringBuilder.setSpan(new UnderlineSpan(), i, i5, 33);
    }

    public static void A03(SpannableStringBuilder spannableStringBuilder, int i, int i5, int i6) {
        if (i6 == -1) {
            return;
        }
        spannableStringBuilder.setSpan(new ForegroundColorSpan(i6), i, i5, 33);
    }

    public final int A04() {
        return this.A03;
    }

    public final void A06() {
        int length = this.A05.length();
        if (length > 0) {
            int length2 = length - 1;
            this.A05.delete(length2, length);
            int length3 = this.A06.size();
            for (int i = length3 - 1; i >= 0; i--) {
                C0641Ft c0641Ft = this.A06.get(i);
                int length4 = c0641Ft.A00;
                if (length4 == length) {
                    int length5 = c0641Ft.A00;
                    c0641Ft.A00 = length5 - 1;
                } else {
                    return;
                }
            }
        }
    }

    public final void A07() {
        this.A07.add(A00());
        this.A05.setLength(0);
        this.A06.clear();
        int min = Math.min(this.A01, this.A03);
        while (true) {
            int size = this.A07.size();
            String[] strArr = A08;
            String str = strArr[6];
            String str2 = strArr[5];
            int length = str.length();
            int numRows = str2.length();
            if (length == numRows) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[6] = "4Kk3waKD";
            strArr2[5] = "8nOP5N7C4Kf2hN";
            if (size >= min) {
                this.A07.remove(0);
            } else {
                return;
            }
        }
    }

    public final void A08(char c2) {
        this.A05.append(c2);
    }

    public final void A09(int i) {
        this.A00 = i;
        this.A06.clear();
        this.A07.clear();
        this.A05.setLength(0);
        this.A03 = 15;
        this.A02 = 0;
        this.A04 = 0;
    }

    public final void A0A(int i) {
        this.A01 = i;
    }

    public final void A0B(int i) {
        this.A02 = i;
    }

    public final void A0C(int i) {
        this.A03 = i;
    }

    public final void A0D(int i) {
        this.A04 = i;
    }

    public final void A0E(int i, boolean z2) {
        this.A06.add(new C0641Ft(i, z2, this.A05.length()));
    }

    public final boolean A0F() {
        return this.A06.isEmpty() && this.A07.isEmpty() && this.A05.length() == 0;
    }

    public final String toString() {
        return this.A05.toString();
    }
}
