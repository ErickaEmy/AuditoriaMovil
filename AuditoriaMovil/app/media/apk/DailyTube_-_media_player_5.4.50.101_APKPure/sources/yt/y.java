package yt;

import android.text.SpannableStringBuilder;
import java.util.Locale;
/* loaded from: classes.dex */
public final class y {

    /* renamed from: a  reason: collision with root package name */
    public static final String f15486a;

    /* renamed from: fb  reason: collision with root package name */
    public static final y f15487fb;

    /* renamed from: gv  reason: collision with root package name */
    public static final gv f15488gv;

    /* renamed from: s  reason: collision with root package name */
    public static final y f15489s;

    /* renamed from: v  reason: collision with root package name */
    public static final String f15490v;

    /* renamed from: n3  reason: collision with root package name */
    public final int f15491n3;
    public final boolean y;

    /* renamed from: zn  reason: collision with root package name */
    public final gv f15492zn;

    /* loaded from: classes.dex */
    public static class n3 {

        /* renamed from: a  reason: collision with root package name */
        public static final byte[] f15493a = new byte[1792];

        /* renamed from: gv  reason: collision with root package name */
        public int f15494gv;

        /* renamed from: n3  reason: collision with root package name */
        public final boolean f15495n3;

        /* renamed from: v  reason: collision with root package name */
        public char f15496v;
        public final CharSequence y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f15497zn;

        static {
            for (int i = 0; i < 1792; i++) {
                f15493a[i] = Character.getDirectionality(i);
            }
        }

        public n3(CharSequence charSequence, boolean z2) {
            this.y = charSequence;
            this.f15495n3 = z2;
            this.f15497zn = charSequence.length();
        }

        public static byte zn(char c2) {
            if (c2 < 1792) {
                return f15493a[c2];
            }
            return Character.getDirectionality(c2);
        }

        public final byte a() {
            char charAt;
            int i = this.f15494gv;
            do {
                int i5 = this.f15494gv;
                if (i5 <= 0) {
                    break;
                }
                CharSequence charSequence = this.y;
                int i6 = i5 - 1;
                this.f15494gv = i6;
                charAt = charSequence.charAt(i6);
                this.f15496v = charAt;
                if (charAt == '&') {
                    return (byte) 12;
                }
            } while (charAt != ';');
            this.f15494gv = i;
            this.f15496v = ';';
            return (byte) 13;
        }

        public final byte c5() {
            char charAt;
            int i = this.f15494gv;
            while (true) {
                int i5 = this.f15494gv;
                if (i5 < this.f15497zn) {
                    CharSequence charSequence = this.y;
                    this.f15494gv = i5 + 1;
                    char charAt2 = charSequence.charAt(i5);
                    this.f15496v = charAt2;
                    if (charAt2 == '>') {
                        return (byte) 12;
                    }
                    if (charAt2 == '\"' || charAt2 == '\'') {
                        do {
                            int i6 = this.f15494gv;
                            if (i6 < this.f15497zn) {
                                CharSequence charSequence2 = this.y;
                                this.f15494gv = i6 + 1;
                                charAt = charSequence2.charAt(i6);
                                this.f15496v = charAt;
                            }
                        } while (charAt != charAt2);
                    }
                } else {
                    this.f15494gv = i;
                    this.f15496v = '<';
                    return (byte) 13;
                }
            }
        }

        public final byte fb() {
            char charAt;
            do {
                int i = this.f15494gv;
                if (i < this.f15497zn) {
                    CharSequence charSequence = this.y;
                    this.f15494gv = i + 1;
                    charAt = charSequence.charAt(i);
                    this.f15496v = charAt;
                } else {
                    return (byte) 12;
                }
            } while (charAt != ';');
            return (byte) 12;
        }

        public int gv() {
            this.f15494gv = 0;
            int i = 0;
            int i5 = 0;
            int i6 = 0;
            while (this.f15494gv < this.f15497zn && i == 0) {
                byte n32 = n3();
                if (n32 != 0) {
                    if (n32 != 1 && n32 != 2) {
                        if (n32 != 9) {
                            switch (n32) {
                                case 14:
                                case 15:
                                    i6++;
                                    i5 = -1;
                                    break;
                                case 16:
                                case 17:
                                    i6++;
                                    i5 = 1;
                                    break;
                                case 18:
                                    i6--;
                                    i5 = 0;
                                    break;
                            }
                        }
                    } else if (i6 == 0) {
                        return 1;
                    }
                } else if (i6 == 0) {
                    return -1;
                }
                i = i6;
            }
            if (i == 0) {
                return 0;
            }
            if (i5 != 0) {
                return i5;
            }
            while (this.f15494gv > 0) {
                switch (y()) {
                    case 14:
                    case 15:
                        if (i == i6) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i == i6) {
                            return 1;
                        }
                        break;
                    case 18:
                        i6++;
                        continue;
                }
                i6--;
            }
            return 0;
        }

        public byte n3() {
            char charAt = this.y.charAt(this.f15494gv);
            this.f15496v = charAt;
            if (Character.isHighSurrogate(charAt)) {
                int codePointAt = Character.codePointAt(this.y, this.f15494gv);
                this.f15494gv += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.f15494gv++;
            byte zn2 = zn(this.f15496v);
            if (this.f15495n3) {
                char c2 = this.f15496v;
                if (c2 == '<') {
                    return c5();
                }
                if (c2 == '&') {
                    return fb();
                }
                return zn2;
            }
            return zn2;
        }

        public final byte s() {
            char charAt;
            int i = this.f15494gv;
            while (true) {
                int i5 = this.f15494gv;
                if (i5 <= 0) {
                    break;
                }
                CharSequence charSequence = this.y;
                int i6 = i5 - 1;
                this.f15494gv = i6;
                char charAt2 = charSequence.charAt(i6);
                this.f15496v = charAt2;
                if (charAt2 == '<') {
                    return (byte) 12;
                }
                if (charAt2 == '>') {
                    break;
                } else if (charAt2 == '\"' || charAt2 == '\'') {
                    do {
                        int i8 = this.f15494gv;
                        if (i8 > 0) {
                            CharSequence charSequence2 = this.y;
                            int i10 = i8 - 1;
                            this.f15494gv = i10;
                            charAt = charSequence2.charAt(i10);
                            this.f15496v = charAt;
                        }
                    } while (charAt != charAt2);
                }
            }
            this.f15494gv = i;
            this.f15496v = '>';
            return (byte) 13;
        }

        public int v() {
            this.f15494gv = this.f15497zn;
            int i = 0;
            int i5 = 0;
            while (this.f15494gv > 0) {
                byte y = y();
                if (y != 0) {
                    if (y != 1 && y != 2) {
                        if (y != 9) {
                            switch (y) {
                                case 14:
                                case 15:
                                    if (i5 == i) {
                                        return -1;
                                    }
                                    i--;
                                    break;
                                case 16:
                                case 17:
                                    if (i5 == i) {
                                        return 1;
                                    }
                                    i--;
                                    break;
                                case 18:
                                    i++;
                                    break;
                                default:
                                    if (i5 != 0) {
                                        break;
                                    } else {
                                        i5 = i;
                                        break;
                                    }
                            }
                        } else {
                            continue;
                        }
                    } else if (i == 0) {
                        return 1;
                    } else {
                        if (i5 == 0) {
                            i5 = i;
                        }
                    }
                } else if (i == 0) {
                    return -1;
                } else {
                    if (i5 == 0) {
                        i5 = i;
                    }
                }
            }
            return 0;
        }

        public byte y() {
            char charAt = this.y.charAt(this.f15494gv - 1);
            this.f15496v = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.y, this.f15494gv);
                this.f15494gv -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.f15494gv--;
            byte zn2 = zn(this.f15496v);
            if (this.f15495n3) {
                char c2 = this.f15496v;
                if (c2 == '>') {
                    return s();
                }
                if (c2 == ';') {
                    return a();
                }
                return zn2;
            }
            return zn2;
        }
    }

    /* renamed from: yt.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0257y {

        /* renamed from: n3  reason: collision with root package name */
        public int f15498n3;
        public boolean y;

        /* renamed from: zn  reason: collision with root package name */
        public gv f15499zn;

        public C0257y() {
            zn(y.v(Locale.getDefault()));
        }

        public static y n3(boolean z2) {
            if (z2) {
                return y.f15489s;
            }
            return y.f15487fb;
        }

        public y y() {
            if (this.f15498n3 == 2 && this.f15499zn == y.f15488gv) {
                return n3(this.y);
            }
            return new y(this.y, this.f15498n3, this.f15499zn);
        }

        public final void zn(boolean z2) {
            this.y = z2;
            this.f15499zn = y.f15488gv;
            this.f15498n3 = 2;
        }
    }

    static {
        gv gvVar = v.f15482zn;
        f15488gv = gvVar;
        f15490v = Character.toString((char) 8206);
        f15486a = Character.toString((char) 8207);
        f15487fb = new y(false, 2, gvVar);
        f15489s = new y(true, 2, gvVar);
    }

    public y(boolean z2, int i, gv gvVar) {
        this.y = z2;
        this.f15491n3 = i;
        this.f15492zn = gvVar;
    }

    public static int n3(CharSequence charSequence) {
        return new n3(charSequence, false).v();
    }

    public static boolean v(Locale locale) {
        if (a.y(locale) == 1) {
            return true;
        }
        return false;
    }

    public static int y(CharSequence charSequence) {
        return new n3(charSequence, false).gv();
    }

    public static y zn() {
        return new C0257y().y();
    }

    public final String a(CharSequence charSequence, gv gvVar) {
        boolean y = gvVar.y(charSequence, 0, charSequence.length());
        if (!this.y && (y || n3(charSequence) == 1)) {
            return f15490v;
        }
        if (this.y) {
            if (!y || n3(charSequence) == -1) {
                return f15486a;
            }
            return "";
        }
        return "";
    }

    public CharSequence c5(CharSequence charSequence, gv gvVar, boolean z2) {
        gv gvVar2;
        char c2;
        gv gvVar3;
        if (charSequence == null) {
            return null;
        }
        boolean y = gvVar.y(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (gv() && z2) {
            if (y) {
                gvVar3 = v.f15480n3;
            } else {
                gvVar3 = v.y;
            }
            spannableStringBuilder.append((CharSequence) fb(charSequence, gvVar3));
        }
        if (y != this.y) {
            if (y) {
                c2 = 8235;
            } else {
                c2 = 8234;
            }
            spannableStringBuilder.append(c2);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z2) {
            if (y) {
                gvVar2 = v.f15480n3;
            } else {
                gvVar2 = v.y;
            }
            spannableStringBuilder.append((CharSequence) a(charSequence, gvVar2));
        }
        return spannableStringBuilder;
    }

    public String f(String str, gv gvVar, boolean z2) {
        if (str == null) {
            return null;
        }
        return c5(str, gvVar, z2).toString();
    }

    public final String fb(CharSequence charSequence, gv gvVar) {
        boolean y = gvVar.y(charSequence, 0, charSequence.length());
        if (!this.y && (y || y(charSequence) == 1)) {
            return f15490v;
        }
        if (this.y) {
            if (!y || y(charSequence) == -1) {
                return f15486a;
            }
            return "";
        }
        return "";
    }

    public boolean gv() {
        if ((this.f15491n3 & 2) != 0) {
            return true;
        }
        return false;
    }

    public String i9(String str) {
        return f(str, this.f15492zn, true);
    }

    public CharSequence s(CharSequence charSequence) {
        return c5(charSequence, this.f15492zn, true);
    }
}
