package l9;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import java.nio.charset.Charset;
import java.util.List;
import qh.c5;
import qh.f;
import qh.n3;
import qh.s;
import v5.j5;
import v5.r;
import v5.rz;
import w0.v;
/* loaded from: classes.dex */
public final class y extends s {

    /* renamed from: co  reason: collision with root package name */
    public final String f10261co;

    /* renamed from: mt  reason: collision with root package name */
    public final int f10262mt;

    /* renamed from: p  reason: collision with root package name */
    public final int f10263p;

    /* renamed from: r  reason: collision with root package name */
    public final int f10264r;

    /* renamed from: w  reason: collision with root package name */
    public final boolean f10265w;

    /* renamed from: xc  reason: collision with root package name */
    public final rz f10266xc;

    /* renamed from: z  reason: collision with root package name */
    public final float f10267z;

    public y(List<byte[]> list) {
        super("Tx3gDecoder");
        this.f10266xc = new rz();
        if (list.size() == 1 && (list.get(0).length == 48 || list.get(0).length == 53)) {
            byte[] bArr = list.get(0);
            this.f10263p = bArr[24];
            this.f10262mt = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
            this.f10261co = "Serif".equals(j5.ta(bArr, 43, bArr.length - 43)) ? "serif" : "sans-serif";
            int i = bArr[25] * 20;
            this.f10264r = i;
            boolean z2 = (bArr[0] & 32) != 0;
            this.f10265w = z2;
            if (z2) {
                this.f10267z = j5.w(((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i, 0.0f, 0.95f);
                return;
            } else {
                this.f10267z = 0.85f;
                return;
            }
        }
        this.f10263p = 0;
        this.f10262mt = -1;
        this.f10261co = "sans-serif";
        this.f10265w = false;
        this.f10267z = 0.85f;
        this.f10264r = -1;
    }

    public static void d(SpannableStringBuilder spannableStringBuilder, String str, int i, int i5) {
        if (str != "sans-serif") {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), i, i5, 16711713);
        }
    }

    public static void mg(SpannableStringBuilder spannableStringBuilder, int i, int i5, int i6, int i8, int i10) {
        if (i != i5) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i >>> 8) | ((i & 255) << 24)), i6, i8, i10 | 33);
        }
    }

    public static void rz(boolean z2) throws f {
        if (z2) {
            return;
        }
        throw new f("Unexpected subtitle format.");
    }

    public static void ta(SpannableStringBuilder spannableStringBuilder, int i, int i5, int i6, int i8, int i10) {
        boolean z2;
        boolean z3;
        if (i != i5) {
            int i11 = i10 | 33;
            boolean z4 = true;
            if ((i & 1) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if ((i & 2) != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z2) {
                if (z3) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i6, i8, i11);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i6, i8, i11);
                }
            } else if (z3) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i6, i8, i11);
            }
            if ((i & 4) == 0) {
                z4 = false;
            }
            if (z4) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i6, i8, i11);
            }
            if (!z4 && !z2 && !z3) {
                spannableStringBuilder.setSpan(new StyleSpan(0), i6, i8, i11);
            }
        }
    }

    public static String z6(rz rzVar) throws f {
        boolean z2;
        if (rzVar.y() >= 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        rz(z2);
        int yt2 = rzVar.yt();
        if (yt2 == 0) {
            return "";
        }
        int a2 = rzVar.a();
        Charset hw2 = rzVar.hw();
        int a3 = yt2 - (rzVar.a() - a2);
        if (hw2 == null) {
            hw2 = v.f14523zn;
        }
        return rzVar.d(a3, hw2);
    }

    @Override // qh.s
    public c5 c(byte[] bArr, int i, boolean z2) throws f {
        this.f10266xc.o(bArr, i);
        String z62 = z6(this.f10266xc);
        if (z62.isEmpty()) {
            return n3.f10260v;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(z62);
        ta(spannableStringBuilder, this.f10263p, 0, 0, spannableStringBuilder.length(), 16711680);
        mg(spannableStringBuilder, this.f10262mt, -1, 0, spannableStringBuilder.length(), 16711680);
        d(spannableStringBuilder, this.f10261co, 0, spannableStringBuilder.length());
        float f4 = this.f10267z;
        while (this.f10266xc.y() >= 8) {
            int a2 = this.f10266xc.a();
            int p2 = this.f10266xc.p();
            int p3 = this.f10266xc.p();
            boolean z3 = true;
            if (p3 == 1937013100) {
                if (this.f10266xc.y() < 2) {
                    z3 = false;
                }
                rz(z3);
                int yt2 = this.f10266xc.yt();
                for (int i5 = 0; i5 < yt2; i5++) {
                    fh(this.f10266xc, spannableStringBuilder);
                }
            } else if (p3 == 1952608120 && this.f10265w) {
                if (this.f10266xc.y() < 2) {
                    z3 = false;
                }
                rz(z3);
                f4 = j5.w(this.f10266xc.yt() / this.f10264r, 0.0f, 0.95f);
            }
            this.f10266xc.oz(a2 + p2);
        }
        return new n3(new n3.C0187n3().xc(spannableStringBuilder).s(f4, 0).c5(0).y());
    }

    public final void fh(rz rzVar, SpannableStringBuilder spannableStringBuilder) throws f {
        boolean z2;
        if (rzVar.y() >= 12) {
            z2 = true;
        } else {
            z2 = false;
        }
        rz(z2);
        int yt2 = rzVar.yt();
        int yt3 = rzVar.yt();
        rzVar.ut(2);
        int ej2 = rzVar.ej();
        rzVar.ut(1);
        int p2 = rzVar.p();
        if (yt3 > spannableStringBuilder.length()) {
            r.c5("Tx3gDecoder", "Truncating styl end (" + yt3 + ") to cueText.length() (" + spannableStringBuilder.length() + ").");
            yt3 = spannableStringBuilder.length();
        }
        if (yt2 >= yt3) {
            r.c5("Tx3gDecoder", "Ignoring styl with start (" + yt2 + ") >= end (" + yt3 + ").");
            return;
        }
        int i = yt3;
        ta(spannableStringBuilder, ej2, this.f10263p, yt2, i, 0);
        mg(spannableStringBuilder, p2, this.f10262mt, yt2, i, 0);
    }
}
