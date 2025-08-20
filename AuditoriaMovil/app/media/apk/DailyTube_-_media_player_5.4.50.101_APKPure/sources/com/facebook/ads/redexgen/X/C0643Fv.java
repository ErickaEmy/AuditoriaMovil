package com.facebook.ads.redexgen.X;

import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.Fv  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0643Fv {
    public static byte[] A0M;
    public static String[] A0N = {"bEAjJCvVtkePzUcw9rvynCWhWZ7YtTC", "sFv5If9m5Sphdt63zNjPhUbGsirLMRkb", "dm26J1OSzusJji0dpgrnr09k5LC689lq", "Nx5OZNPL7zWyatFSZAWV1dERcLRuFkfb", "8nXEVS4hfg5ng3YQnnC7NT8u0hAmIJYk", "i1gAYPXKkwHe1sE5BOr5igG8IxAvgiYs", "Y1prefJax7dGS9GUqUH50jWlMMgJtsPr", "K9Y4TfEKpnP3QqzXtNTgN9rOyJLVMPLw"};
    public static final int A0O;
    public static final int A0P;
    public static final int A0Q;
    public static final int[] A0R;
    public static final int[] A0S;
    public static final int[] A0T;
    public static final int[] A0U;
    public static final int[] A0V;
    public static final int[] A0W;
    public static final int[] A0X;
    public static final boolean[] A0Y;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public int A09;
    public int A0A;
    public int A0B;
    public int A0C;
    public int A0D;
    public int A0E;
    public int A0F;
    public boolean A0G;
    public boolean A0H;
    public boolean A0I;
    public boolean A0J;
    public final List<SpannableString> A0L = new ArrayList();
    public final SpannableStringBuilder A0K = new SpannableStringBuilder();

    public static String A03(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0M, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 93);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A0M = new byte[]{81, 106, 97, 124, 116, 97, 103, 112, 97, 96, 36, 110, 113, 119, 112, 109, 98, 109, 103, 101, 112, 109, 107, 106, 36, 114, 101, 104, 113, 97, 62, 36};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final WJ A05() {
        Layout.Alignment alignment;
        float f4;
        float f6;
        if (A0H()) {
            if (A0N[3].charAt(10) != 'W') {
                throw new RuntimeException();
            }
            A0N[6] = "XXMrNDw86HMhGPknailYt8C4YmEezPlD";
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i < this.A0L.size(); i++) {
            spannableStringBuilder.append((CharSequence) this.A0L.get(i));
            spannableStringBuilder.append('\n');
        }
        spannableStringBuilder.append((CharSequence) A02());
        switch (this.A07) {
            case 0:
            case 3:
                alignment = Layout.Alignment.ALIGN_NORMAL;
                break;
            case 1:
                alignment = Layout.Alignment.ALIGN_OPPOSITE;
                if (A0N[3].charAt(10) != 'W') {
                    A0N[1] = "GUzkX8UKOS2SBWNLmpbuPvYZfRUrk3bC";
                    break;
                } else {
                    A0N[1] = "qTQORRfF62rpJvlAVACWybIcEIDyrroZ";
                    break;
                }
            case 2:
                alignment = Layout.Alignment.ALIGN_CENTER;
                break;
            default:
                throw new IllegalArgumentException(A03(0, 32, 89) + this.A07);
        }
        if (this.A0H) {
            f4 = this.A05 / 99.0f;
            f6 = this.A0D / 99.0f;
        } else {
            f4 = this.A05 / 209.0f;
            f6 = this.A0D / 74.0f;
        }
        float f9 = (f4 * 0.9f) + 0.05f;
        float f10 = (0.9f * f6) + 0.05f;
        int i5 = this.A00;
        int i6 = i5 % 3 == 0 ? 0 : i5 % 3 == 1 ? 1 : 2;
        int i8 = i5 / 3 == 0 ? 0 : i5 / 3 == 1 ? 1 : 2;
        int i10 = this.A0E;
        return new WJ(spannableStringBuilder, alignment, f10, 0, i6, f9, i8, Float.MIN_VALUE, i10 != A0O, i10, this.A09);
    }

    static {
        A04();
        A0P = A01(2, 2, 2, 0);
        int A01 = A01(0, 0, 0, 0);
        A0O = A01;
        int A012 = A01(0, 0, 0, 3);
        A0Q = A012;
        A0V = new int[]{0, 0, 0, 0, 0, 2, 0};
        A0W = new int[]{0, 0, 0, 0, 0, 0, 2};
        A0X = new int[]{3, 3, 3, 3, 3, 3, 1};
        A0Y = new boolean[]{false, false, false, true, true, true, false};
        A0U = new int[]{A01, A012, A01, A01, A012, A01, A01};
        A0T = new int[]{0, 1, 2, 3, 4, 3, 4};
        A0S = new int[]{0, 0, 0, 0, 0, 3, 3};
        A0R = new int[]{A01, A01, A01, A01, A01, A012, A012};
    }

    public C0643Fv() {
        A08();
    }

    public static int A00(int i, int i5, int i6) {
        return A01(i, i5, i6, 0);
    }

    public static int A01(int i, int i5, int i6, int i8) {
        int i10;
        AbstractC0672Ha.A00(i, 0, 4);
        AbstractC0672Ha.A00(i5, 0, 4);
        AbstractC0672Ha.A00(i6, 0, 4);
        AbstractC0672Ha.A00(i8, 0, 4);
        switch (i8) {
            case 0:
            case 1:
                i10 = 255;
                break;
            case 2:
                i10 = 127;
                break;
            case 3:
                i10 = 0;
                break;
            default:
                i10 = 255;
                break;
        }
        int alpha = i > 1 ? 255 : 0;
        return Color.argb(i10, alpha, i5 > 1 ? 255 : 0, i6 > 1 ? 255 : 0);
    }

    private final SpannableString A02() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.A0K);
        int length = spannableStringBuilder.length();
        if (length > 0) {
            if (this.A06 != -1) {
                spannableStringBuilder.setSpan(new StyleSpan(2), this.A06, length, 33);
            }
            if (this.A0C != -1) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), this.A0C, length, 33);
            }
            int i = this.A04;
            int length2 = A0N[0].length();
            if (length2 != 31) {
                throw new RuntimeException();
            }
            A0N[4] = "UcnYu1PwHAGC3vbuX83YmC5zO9IPxpwr";
            if (i != -1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.A03), this.A04, length, 33);
            }
            if (this.A02 != -1) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(this.A01), this.A02, length, 33);
            }
        }
        return new SpannableString(spannableStringBuilder);
    }

    public final void A06() {
        int length = this.A0K.length();
        if (length > 0) {
            int length2 = length - 1;
            this.A0K.delete(length2, length);
        }
    }

    public final void A07() {
        this.A0L.clear();
        this.A0K.clear();
        this.A06 = -1;
        this.A0C = -1;
        this.A04 = -1;
        this.A02 = -1;
        this.A0A = 0;
    }

    public final void A08() {
        A07();
        this.A0G = false;
        this.A0J = false;
        this.A09 = 4;
        this.A0H = false;
        this.A0D = 0;
        this.A05 = 0;
        this.A00 = 0;
        this.A0B = 15;
        this.A0I = true;
        this.A07 = 0;
        this.A0F = 0;
        this.A08 = 0;
        int i = A0O;
        this.A0E = i;
        this.A03 = A0P;
        this.A01 = i;
    }

    public final void A09(char c2) {
        if (c2 == '\n') {
            this.A0L.add(A02());
            this.A0K.clear();
            if (this.A06 != -1) {
                this.A06 = 0;
            }
            if (this.A0C != -1) {
                this.A0C = 0;
            }
            if (this.A04 != -1) {
                this.A04 = 0;
            }
            if (this.A02 != -1) {
                this.A02 = 0;
            }
            while (true) {
                if (this.A0I) {
                    int size = this.A0L.size();
                    int i = this.A0B;
                    if (A0N[3].charAt(10) != 'W') {
                        throw new RuntimeException();
                    }
                    A0N[0] = "z94yFfaTy8Odmt8n2fLZMjDbCxUThPz";
                    if (size >= i) {
                        continue;
                        this.A0L.remove(0);
                    }
                }
                if (this.A0L.size() >= 15) {
                    this.A0L.remove(0);
                } else {
                    return;
                }
            }
        } else {
            this.A0K.append(c2);
        }
    }

    public final void A0A(int i, int i5) {
        if (this.A0A != i) {
            A09('\n');
        }
        this.A0A = i;
    }

    public final void A0B(int i, int i5, int i6) {
        if (this.A04 != -1 && this.A03 != i) {
            this.A0K.setSpan(new ForegroundColorSpan(this.A03), this.A04, this.A0K.length(), 33);
        }
        if (i != A0P) {
            this.A04 = this.A0K.length();
            this.A03 = i;
        }
        if (this.A02 != -1 && this.A01 != i5) {
            this.A0K.setSpan(new BackgroundColorSpan(this.A01), this.A02, this.A0K.length(), 33);
        }
        if (i5 != A0O) {
            this.A02 = this.A0K.length();
            this.A01 = i5;
        }
    }

    public final void A0C(int i, int i5, int i6, boolean z2, boolean z3, int i8, int i10) {
        if (this.A06 != -1) {
            if (!z2) {
                this.A0K.setSpan(new StyleSpan(2), this.A06, this.A0K.length(), 33);
                this.A06 = -1;
            }
        } else if (z2) {
            this.A06 = this.A0K.length();
        }
        int i11 = this.A0C;
        if (A0N[3].charAt(10) != 'W') {
            throw new RuntimeException();
        }
        A0N[3] = "GaQXCBjIxpWixMOvnA1JS7CVs7IBjZSt";
        if (i11 != -1) {
            if (!z3) {
                this.A0K.setSpan(new UnderlineSpan(), this.A0C, this.A0K.length(), 33);
                this.A0C = -1;
            }
        } else if (!z3) {
        } else {
            this.A0C = this.A0K.length();
        }
    }

    public final void A0D(int i, int i5, boolean z2, int i6, int i8, int i10, int i11) {
        this.A0E = i;
        this.A07 = i11;
    }

    public final void A0E(boolean z2) {
        this.A0J = z2;
    }

    public final void A0F(boolean z2, boolean z3, boolean z4, int i, boolean z5, int i5, int i6, int i8, int i10, int i11, int i12, int i13) {
        this.A0G = true;
        this.A0J = z2;
        this.A0I = z3;
        this.A09 = i;
        this.A0H = z5;
        this.A0D = i5;
        this.A05 = i6;
        this.A00 = i11;
        if (this.A0B != i8 + 1) {
            int i14 = i8 + 1;
            if (A0N[1].charAt(10) == 's') {
                throw new RuntimeException();
            }
            A0N[5] = "GL1AptVbsbHBPnQiC9PDsuTMTdKpKMZ4";
            this.A0B = i14;
            while (true) {
                if ((!z3 || this.A0L.size() < this.A0B) && this.A0L.size() < 15) {
                    break;
                }
                this.A0L.remove(0);
            }
        }
        if (i12 != 0 && this.A0F != i12) {
            this.A0F = i12;
            int i15 = i12 - 1;
            A0D(A0U[i15], A0Q, A0Y[i15], 0, A0W[i15], A0X[i15], A0V[i15]);
        }
        if (i13 != 0 && this.A08 != i13) {
            this.A08 = i13;
            int i16 = i13 - 1;
            A0C(0, 1, 1, false, false, A0S[i16], A0T[i16]);
            A0B(A0P, A0R[i16], A0O);
        }
    }

    public final boolean A0G() {
        return this.A0G;
    }

    public final boolean A0H() {
        return !A0G() || (this.A0L.isEmpty() && this.A0K.length() == 0);
    }

    public final boolean A0I() {
        return this.A0J;
    }
}
