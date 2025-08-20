package us;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import com.uv.v7.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import qh.c5;
import qh.f;
import qh.n3;
import qh.wz;
import qh.xc;
import v5.j5;
import v5.r;
import v5.rz;
/* loaded from: classes.dex */
public final class y extends v {

    /* renamed from: c5  reason: collision with root package name */
    public final int f14187c5;

    /* renamed from: co  reason: collision with root package name */
    public boolean f14188co;

    /* renamed from: f  reason: collision with root package name */
    public final long f14189f;

    /* renamed from: f3  reason: collision with root package name */
    public long f14190f3;

    /* renamed from: i4  reason: collision with root package name */
    public boolean f14192i4;

    /* renamed from: i9  reason: collision with root package name */
    public final int f14193i9;

    /* renamed from: mt  reason: collision with root package name */
    public boolean f14194mt;

    /* renamed from: p  reason: collision with root package name */
    public int f14195p;

    /* renamed from: r  reason: collision with root package name */
    public byte f14196r;

    /* renamed from: s  reason: collision with root package name */
    public final int f14197s;

    /* renamed from: w  reason: collision with root package name */
    public int f14200w;
    @Nullable

    /* renamed from: wz  reason: collision with root package name */
    public List<qh.n3> f14201wz;
    @Nullable

    /* renamed from: xc  reason: collision with root package name */
    public List<qh.n3> f14203xc;

    /* renamed from: z  reason: collision with root package name */
    public byte f14204z;

    /* renamed from: n  reason: collision with root package name */
    public static final int[] f14184n = {11, 1, 3, 12, 14, 5, 7, 9};

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f14179c = {0, 4, 8, 12, 16, 20, 24, 28};

    /* renamed from: d0  reason: collision with root package name */
    public static final int[] f14181d0 = {-1, -16711936, -16776961, -16711681, -65536, -256, -65281};

    /* renamed from: fh  reason: collision with root package name */
    public static final int[] f14182fh = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, R.styleable.AppCompatTheme_textAppearancePopupMenuHeader, 107, 108, 109, R.styleable.AppCompatTheme_textColorAlertDialogListItem, R.styleable.AppCompatTheme_textColorSearchUrl, R.styleable.AppCompatTheme_toolbarNavigationButtonStyle, R.styleable.AppCompatTheme_toolbarStyle, R.styleable.AppCompatTheme_tooltipForegroundColor, R.styleable.AppCompatTheme_tooltipFrameBackground, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632};

    /* renamed from: rz  reason: collision with root package name */
    public static final int[] f14185rz = {174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};

    /* renamed from: mg  reason: collision with root package name */
    public static final int[] f14183mg = {193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187};

    /* renamed from: ta  reason: collision with root package name */
    public static final int[] f14186ta = {195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};

    /* renamed from: d  reason: collision with root package name */
    public static final boolean[] f14180d = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};

    /* renamed from: fb  reason: collision with root package name */
    public final rz f14191fb = new rz();

    /* renamed from: t  reason: collision with root package name */
    public final ArrayList<C0230y> f14198t = new ArrayList<>();

    /* renamed from: tl  reason: collision with root package name */
    public C0230y f14199tl = new C0230y(0, 4);

    /* renamed from: x4  reason: collision with root package name */
    public int f14202x4 = 0;

    /* renamed from: us.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0230y {

        /* renamed from: a  reason: collision with root package name */
        public int f14205a;

        /* renamed from: fb  reason: collision with root package name */
        public int f14206fb;

        /* renamed from: gv  reason: collision with root package name */
        public int f14207gv;

        /* renamed from: s  reason: collision with root package name */
        public int f14209s;

        /* renamed from: v  reason: collision with root package name */
        public int f14210v;
        public final List<C0231y> y = new ArrayList();

        /* renamed from: n3  reason: collision with root package name */
        public final List<SpannableString> f14208n3 = new ArrayList();

        /* renamed from: zn  reason: collision with root package name */
        public final StringBuilder f14211zn = new StringBuilder();

        /* renamed from: us.y$y$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0231y {

            /* renamed from: n3  reason: collision with root package name */
            public final boolean f14212n3;
            public final int y;

            /* renamed from: zn  reason: collision with root package name */
            public int f14213zn;

            public C0231y(int i, boolean z2, int i5) {
                this.y = i;
                this.f14212n3 = z2;
                this.f14213zn = i5;
            }
        }

        public C0230y(int i, int i5) {
            i9(i);
            this.f14209s = i5;
        }

        public static void p(SpannableStringBuilder spannableStringBuilder, int i, int i5) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i, i5, 33);
        }

        public static void wz(SpannableStringBuilder spannableStringBuilder, int i, int i5, int i6) {
            if (i6 == -1) {
                return;
            }
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i6), i, i5, 33);
        }

        public static void xc(SpannableStringBuilder spannableStringBuilder, int i, int i5) {
            spannableStringBuilder.setSpan(new StyleSpan(2), i, i5, 33);
        }

        public void a() {
            int length = this.f14211zn.length();
            if (length > 0) {
                this.f14211zn.delete(length - 1, length);
                for (int size = this.y.size() - 1; size >= 0; size--) {
                    C0231y c0231y = this.y.get(size);
                    int i = c0231y.f14213zn;
                    if (i == length) {
                        c0231y.f14213zn = i - 1;
                    } else {
                        return;
                    }
                }
            }
        }

        public boolean c5() {
            if (this.y.isEmpty() && this.f14208n3.isEmpty() && this.f14211zn.length() == 0) {
                return true;
            }
            return false;
        }

        public void f() {
            this.f14208n3.add(s());
            this.f14211zn.setLength(0);
            this.y.clear();
            int min = Math.min(this.f14209s, this.f14207gv);
            while (this.f14208n3.size() >= min) {
                this.f14208n3.remove(0);
            }
        }

        @Nullable
        public qh.n3 fb(int i) {
            float f4;
            int i5 = this.f14210v + this.f14205a;
            int i6 = 32 - i5;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i8 = 0; i8 < this.f14208n3.size(); i8++) {
                spannableStringBuilder.append(j5.wm(this.f14208n3.get(i8), i6));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append(j5.wm(s(), i6));
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int length = i6 - spannableStringBuilder.length();
            int i10 = i5 - length;
            if (i == Integer.MIN_VALUE) {
                if (this.f14206fb == 2 && (Math.abs(i10) < 3 || length < 0)) {
                    i = 1;
                } else if (this.f14206fb == 2 && i10 > 0) {
                    i = 2;
                } else {
                    i = 0;
                }
            }
            if (i != 1) {
                if (i == 2) {
                    i5 = 32 - length;
                }
                f4 = ((i5 / 32.0f) * 0.8f) + 0.1f;
            } else {
                f4 = 0.5f;
            }
            int i11 = this.f14207gv;
            if (i11 > 7) {
                i11 -= 17;
            } else if (this.f14206fb == 1) {
                i11 -= this.f14209s - 1;
            }
            return new n3.C0187n3().xc(spannableStringBuilder).w(Layout.Alignment.ALIGN_NORMAL).s(i11, 1).f(f4).t(i).y();
        }

        public void i9(int i) {
            this.f14206fb = i;
            this.y.clear();
            this.f14208n3.clear();
            this.f14211zn.setLength(0);
            this.f14207gv = 15;
            this.f14210v = 0;
            this.f14205a = 0;
        }

        public final SpannableString s() {
            int i;
            boolean z2;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f14211zn);
            int length = spannableStringBuilder.length();
            int i5 = 0;
            int i6 = -1;
            int i8 = -1;
            int i10 = 0;
            int i11 = -1;
            int i12 = -1;
            boolean z3 = false;
            while (i5 < this.y.size()) {
                C0231y c0231y = this.y.get(i5);
                boolean z4 = c0231y.f14212n3;
                int i13 = c0231y.y;
                if (i13 != 8) {
                    if (i13 == 7) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (i13 != 7) {
                        i12 = y.f14181d0[i13];
                    }
                    z3 = z2;
                }
                int i14 = c0231y.f14213zn;
                i5++;
                if (i5 < this.y.size()) {
                    i = this.y.get(i5).f14213zn;
                } else {
                    i = length;
                }
                if (i14 != i) {
                    if (i6 != -1 && !z4) {
                        p(spannableStringBuilder, i6, i14);
                        i6 = -1;
                    } else if (i6 == -1 && z4) {
                        i6 = i14;
                    }
                    if (i8 != -1 && !z3) {
                        xc(spannableStringBuilder, i8, i14);
                        i8 = -1;
                    } else if (i8 == -1 && z3) {
                        i8 = i14;
                    }
                    if (i12 != i11) {
                        wz(spannableStringBuilder, i10, i14, i11);
                        i11 = i12;
                        i10 = i14;
                    }
                }
            }
            if (i6 != -1 && i6 != length) {
                p(spannableStringBuilder, i6, length);
            }
            if (i8 != -1 && i8 != length) {
                xc(spannableStringBuilder, i8, length);
            }
            if (i10 != length) {
                wz(spannableStringBuilder, i10, length, i11);
            }
            return new SpannableString(spannableStringBuilder);
        }

        public void t(int i) {
            this.f14206fb = i;
        }

        public void tl(int i) {
            this.f14209s = i;
        }

        public void v(char c2) {
            if (this.f14211zn.length() < 32) {
                this.f14211zn.append(c2);
            }
        }

        public void w(int i, boolean z2) {
            this.y.add(new C0231y(i, z2, this.f14211zn.length()));
        }
    }

    public y(String str, int i, long j2) {
        long j4;
        int i5;
        if (j2 > 0) {
            j4 = j2 * 1000;
        } else {
            j4 = -9223372036854775807L;
        }
        this.f14189f = j4;
        if ("application/x-mp4-cea-608".equals(str)) {
            i5 = 2;
        } else {
            i5 = 3;
        }
        this.f14197s = i5;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        r.c5("Cea608Decoder", "Invalid channel. Defaulting to CC1.");
                        this.f14193i9 = 0;
                        this.f14187c5 = 0;
                    } else {
                        this.f14193i9 = 1;
                        this.f14187c5 = 1;
                    }
                } else {
                    this.f14193i9 = 0;
                    this.f14187c5 = 1;
                }
            } else {
                this.f14193i9 = 1;
                this.f14187c5 = 0;
            }
        } else {
            this.f14193i9 = 0;
            this.f14187c5 = 0;
        }
        k5(0);
        b();
        this.f14192i4 = true;
        this.f14190f3 = -9223372036854775807L;
    }

    public static boolean a8(byte b2) {
        if (1 <= b2 && b2 <= 15) {
            return true;
        }
        return false;
    }

    public static boolean c(byte b2) {
        if ((b2 & 224) == 0) {
            return true;
        }
        return false;
    }

    public static char co(byte b2) {
        return (char) f14183mg[b2 & 31];
    }

    public static boolean d0(byte b2, byte b3) {
        if ((b2 & 246) == 18 && (b3 & 224) == 32) {
            return true;
        }
        return false;
    }

    public static boolean ej(byte b2, byte b3) {
        if ((b2 & 247) == 17 && (b3 & 240) == 48) {
            return true;
        }
        return false;
    }

    public static boolean fh(byte b2, byte b3) {
        if ((b2 & 247) == 17 && (b3 & 240) == 32) {
            return true;
        }
        return false;
    }

    public static boolean mg(byte b2, byte b3) {
        if ((b2 & 240) == 16 && (b3 & 192) == 64) {
            return true;
        }
        return false;
    }

    public static int p(byte b2) {
        return (b2 >> 3) & 1;
    }

    public static char r(byte b2, byte b3) {
        if ((b2 & 1) == 0) {
            return co(b3);
        }
        return z(b3);
    }

    public static boolean rz(byte b2, byte b3) {
        if ((b2 & 246) == 20 && (b3 & 240) == 32) {
            return true;
        }
        return false;
    }

    public static boolean ta(byte b2) {
        if ((b2 & 240) == 16) {
            return true;
        }
        return false;
    }

    public static boolean ud(byte b2, byte b3) {
        if ((b2 & 247) == 23 && b3 >= 33 && b3 <= 35) {
            return true;
        }
        return false;
    }

    public static char w(byte b2) {
        return (char) f14182fh[(b2 & Byte.MAX_VALUE) - 32];
    }

    public static char x4(byte b2) {
        return (char) f14185rz[b2 & 15];
    }

    public static char z(byte b2) {
        return (char) f14186ta[b2 & 31];
    }

    public static boolean z6(byte b2) {
        if ((b2 & 246) == 20) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x006d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0017 A[SYNTHETIC] */
    @Override // us.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(qh.wz r10) {
        /*
            Method dump skipped, instructions count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.y.a(qh.wz):void");
    }

    public final void b() {
        this.f14199tl.i9(this.f14200w);
        this.f14198t.clear();
        this.f14198t.add(this.f14199tl);
    }

    public final boolean d(boolean z2, byte b2, byte b3) {
        if (z2 && ta(b2)) {
            if (this.f14188co && this.f14204z == b2 && this.f14196r == b3) {
                this.f14188co = false;
                return true;
            }
            this.f14188co = true;
            this.f14204z = b2;
            this.f14196r = b3;
        } else {
            this.f14188co = false;
        }
        return false;
    }

    @Override // us.v
    public boolean f() {
        if (this.f14201wz != this.f14203xc) {
            return true;
        }
        return false;
    }

    public final void f3(byte b2) {
        if (b2 != 32) {
            if (b2 != 41) {
                switch (b2) {
                    case 37:
                        k5(1);
                        yt(2);
                        return;
                    case 38:
                        k5(1);
                        yt(3);
                        return;
                    case 39:
                        k5(1);
                        yt(4);
                        return;
                    default:
                        int i = this.f14200w;
                        if (i == 0) {
                            return;
                        }
                        if (b2 != 33) {
                            switch (b2) {
                                case 44:
                                    this.f14201wz = Collections.emptyList();
                                    int i5 = this.f14200w;
                                    if (i5 == 1 || i5 == 3) {
                                        b();
                                        return;
                                    }
                                    return;
                                case 45:
                                    if (i == 1 && !this.f14199tl.c5()) {
                                        this.f14199tl.f();
                                        return;
                                    }
                                    return;
                                case 46:
                                    b();
                                    return;
                                case 47:
                                    this.f14201wz = mt();
                                    b();
                                    return;
                                default:
                                    return;
                            }
                        }
                        this.f14199tl.a();
                        return;
                }
            }
            k5(3);
            return;
        }
        k5(2);
    }

    @Override // us.v
    @Nullable
    public /* bridge */ /* synthetic */ wz fb() throws f {
        return super.gv();
    }

    @Override // us.v, a9.gv
    public void flush() {
        super.flush();
        this.f14201wz = null;
        this.f14203xc = null;
        k5(0);
        yt(4);
        b();
        this.f14194mt = false;
        this.f14188co = false;
        this.f14204z = (byte) 0;
        this.f14196r = (byte) 0;
        this.f14202x4 = 0;
        this.f14192i4 = true;
        this.f14190f3 = -9223372036854775807L;
    }

    public final boolean hw(byte b2) {
        if (c(b2)) {
            this.f14202x4 = p(b2);
        }
        if (this.f14202x4 == this.f14193i9) {
            return true;
        }
        return false;
    }

    public final void i4(byte b2) {
        boolean z2;
        this.f14199tl.v(' ');
        if ((b2 & 1) == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f14199tl.w((b2 >> 1) & 7, z2);
    }

    public final void k5(int i) {
        int i5 = this.f14200w;
        if (i5 == i) {
            return;
        }
        this.f14200w = i;
        if (i == 3) {
            for (int i6 = 0; i6 < this.f14198t.size(); i6++) {
                this.f14198t.get(i6).t(i);
            }
            return;
        }
        b();
        if (i5 == 3 || i == 1 || i == 0) {
            this.f14201wz = Collections.emptyList();
        }
    }

    public final List<qh.n3> mt() {
        int size = this.f14198t.size();
        ArrayList arrayList = new ArrayList(size);
        int i = 2;
        for (int i5 = 0; i5 < size; i5++) {
            qh.n3 fb2 = this.f14198t.get(i5).fb(Integer.MIN_VALUE);
            arrayList.add(fb2);
            if (fb2 != null) {
                i = Math.min(i, fb2.f12864co);
            }
        }
        ArrayList arrayList2 = new ArrayList(size);
        for (int i6 = 0; i6 < size; i6++) {
            qh.n3 n3Var = (qh.n3) arrayList.get(i6);
            if (n3Var != null) {
                if (n3Var.f12864co != i) {
                    n3Var = (qh.n3) v5.y.v(this.f14198t.get(i6).fb(i));
                }
                arrayList2.add(n3Var);
            }
        }
        return arrayList2;
    }

    public final void n(byte b2, byte b3) {
        boolean z2;
        int i;
        int i5 = f14184n[b2 & 7];
        if ((b3 & 32) != 0) {
            i5++;
        }
        if (i5 != this.f14199tl.f14207gv) {
            if (this.f14200w != 1 && !this.f14199tl.c5()) {
                C0230y c0230y = new C0230y(this.f14200w, this.f14195p);
                this.f14199tl = c0230y;
                this.f14198t.add(c0230y);
            }
            this.f14199tl.f14207gv = i5;
        }
        boolean z3 = false;
        if ((b3 & 16) == 16) {
            z2 = true;
        } else {
            z2 = false;
        }
        if ((b3 & 1) == 1) {
            z3 = true;
        }
        int i6 = (b3 >> 1) & 7;
        C0230y c0230y2 = this.f14199tl;
        if (z2) {
            i = 8;
        } else {
            i = i6;
        }
        c0230y2.w(i, z3);
        if (z2) {
            this.f14199tl.f14210v = f14179c[i6];
        }
    }

    @Override // us.v, a9.gv
    @Nullable
    /* renamed from: s */
    public xc n3() throws f {
        xc c52;
        xc n32 = super.n3();
        if (n32 != null) {
            return n32;
        }
        if (vl() && (c52 = c5()) != null) {
            this.f14201wz = Collections.emptyList();
            this.f14190f3 = -9223372036854775807L;
            c52.mt(i9(), v(), Long.MAX_VALUE);
            return c52;
        }
        return null;
    }

    @Override // us.v
    public /* bridge */ /* synthetic */ void t(wz wzVar) throws f {
        super.zn(wzVar);
    }

    @Override // us.v
    public c5 v() {
        List<qh.n3> list = this.f14201wz;
        this.f14203xc = list;
        return new a((List) v5.y.v(list));
    }

    public final boolean vl() {
        if (this.f14189f == -9223372036854775807L || this.f14190f3 == -9223372036854775807L || i9() - this.f14190f3 < this.f14189f) {
            return false;
        }
        return true;
    }

    public final void x(byte b2, byte b3) {
        if (a8(b2)) {
            this.f14192i4 = false;
        } else if (z6(b2)) {
            if (b3 != 32 && b3 != 47) {
                switch (b3) {
                    case 37:
                    case 38:
                    case 39:
                        break;
                    default:
                        switch (b3) {
                            case 41:
                                break;
                            case 42:
                            case 43:
                                this.f14192i4 = false;
                                return;
                            default:
                                return;
                        }
                }
            }
            this.f14192i4 = true;
        }
    }

    @Override // us.v, qh.i9
    public /* bridge */ /* synthetic */ void y(long j2) {
        super.y(j2);
    }

    public final void yt(int i) {
        this.f14195p = i;
        this.f14199tl.tl(i);
    }

    @Override // us.v, a9.gv
    public void release() {
    }
}
