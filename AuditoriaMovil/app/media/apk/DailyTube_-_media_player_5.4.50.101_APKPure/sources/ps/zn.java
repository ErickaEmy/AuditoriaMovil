package ps;

import android.graphics.Color;
import android.graphics.PointF;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import d1.a;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import v5.j5;
import v5.r;
/* loaded from: classes.dex */
public final class zn {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f12614a;

    /* renamed from: c5  reason: collision with root package name */
    public final boolean f12615c5;

    /* renamed from: fb  reason: collision with root package name */
    public final boolean f12616fb;
    @Nullable

    /* renamed from: gv  reason: collision with root package name */
    public final Integer f12617gv;

    /* renamed from: i9  reason: collision with root package name */
    public final int f12618i9;

    /* renamed from: n3  reason: collision with root package name */
    public final int f12619n3;

    /* renamed from: s  reason: collision with root package name */
    public final boolean f12620s;

    /* renamed from: v  reason: collision with root package name */
    public final float f12621v;
    public final String y;
    @Nullable

    /* renamed from: zn  reason: collision with root package name */
    public final Integer f12622zn;

    /* loaded from: classes.dex */
    public static final class n3 {
        @Nullable

        /* renamed from: n3  reason: collision with root package name */
        public final PointF f12627n3;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public static final Pattern f12626zn = Pattern.compile("\\{([^}]*)\\}");

        /* renamed from: gv  reason: collision with root package name */
        public static final Pattern f12624gv = Pattern.compile(j5.rz("\\\\pos\\((%1$s),(%1$s)\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));

        /* renamed from: v  reason: collision with root package name */
        public static final Pattern f12625v = Pattern.compile(j5.rz("\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));

        /* renamed from: a  reason: collision with root package name */
        public static final Pattern f12623a = Pattern.compile("\\\\an(\\d+)");

        public n3(int i, @Nullable PointF pointF) {
            this.y = i;
            this.f12627n3 = pointF;
        }

        public static String gv(String str) {
            return f12626zn.matcher(str).replaceAll("");
        }

        public static n3 n3(String str) {
            Matcher matcher = f12626zn.matcher(str);
            PointF pointF = null;
            int i = -1;
            while (matcher.find()) {
                String str2 = (String) v5.y.v(matcher.group(1));
                try {
                    PointF zn2 = zn(str2);
                    if (zn2 != null) {
                        pointF = zn2;
                    }
                } catch (RuntimeException unused) {
                }
                try {
                    int y = y(str2);
                    if (y != -1) {
                        i = y;
                    }
                } catch (RuntimeException unused2) {
                }
            }
            return new n3(i, pointF);
        }

        public static int y(String str) {
            Matcher matcher = f12623a.matcher(str);
            if (matcher.find()) {
                return zn.v((String) v5.y.v(matcher.group(1)));
            }
            return -1;
        }

        @Nullable
        public static PointF zn(String str) {
            String group;
            String group2;
            Matcher matcher = f12624gv.matcher(str);
            Matcher matcher2 = f12625v.matcher(str);
            boolean find = matcher.find();
            boolean find2 = matcher2.find();
            if (find) {
                if (find2) {
                    r.a("SsaStyle.Overrides", "Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='" + str + "'");
                }
                group = matcher.group(1);
                group2 = matcher.group(2);
            } else if (find2) {
                group = matcher2.group(1);
                group2 = matcher2.group(2);
            } else {
                return null;
            }
            return new PointF(Float.parseFloat(((String) v5.y.v(group)).trim()), Float.parseFloat(((String) v5.y.v(group2)).trim()));
        }
    }

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: a  reason: collision with root package name */
        public final int f12628a;

        /* renamed from: c5  reason: collision with root package name */
        public final int f12629c5;

        /* renamed from: f  reason: collision with root package name */
        public final int f12630f;

        /* renamed from: fb  reason: collision with root package name */
        public final int f12631fb;

        /* renamed from: gv  reason: collision with root package name */
        public final int f12632gv;

        /* renamed from: i9  reason: collision with root package name */
        public final int f12633i9;

        /* renamed from: n3  reason: collision with root package name */
        public final int f12634n3;

        /* renamed from: s  reason: collision with root package name */
        public final int f12635s;

        /* renamed from: v  reason: collision with root package name */
        public final int f12636v;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f12637zn;

        public y(int i, int i5, int i6, int i8, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
            this.y = i;
            this.f12634n3 = i5;
            this.f12637zn = i6;
            this.f12632gv = i8;
            this.f12636v = i10;
            this.f12628a = i11;
            this.f12631fb = i12;
            this.f12635s = i13;
            this.f12629c5 = i14;
            this.f12633i9 = i15;
            this.f12630f = i16;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Nullable
        public static y y(String str) {
            char c2;
            String[] split = TextUtils.split(str.substring(7), ",");
            int i = -1;
            int i5 = -1;
            int i6 = -1;
            int i8 = -1;
            int i10 = -1;
            int i11 = -1;
            int i12 = -1;
            int i13 = -1;
            int i14 = -1;
            int i15 = -1;
            for (int i16 = 0; i16 < split.length; i16++) {
                String v2 = w0.zn.v(split[i16].trim());
                v2.hashCode();
                switch (v2.hashCode()) {
                    case -1178781136:
                        if (v2.equals("italic")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1026963764:
                        if (v2.equals("underline")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -192095652:
                        if (v2.equals("strikeout")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -70925746:
                        if (v2.equals("primarycolour")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 3029637:
                        if (v2.equals("bold")) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 3373707:
                        if (v2.equals("name")) {
                            c2 = 5;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 366554320:
                        if (v2.equals("fontsize")) {
                            c2 = 6;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 767321349:
                        if (v2.equals("borderstyle")) {
                            c2 = 7;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1767875043:
                        if (v2.equals("alignment")) {
                            c2 = '\b';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1988365454:
                        if (v2.equals("outlinecolour")) {
                            c2 = '\t';
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
                        i12 = i16;
                        break;
                    case 1:
                        i13 = i16;
                        break;
                    case 2:
                        i14 = i16;
                        break;
                    case 3:
                        i6 = i16;
                        break;
                    case 4:
                        i11 = i16;
                        break;
                    case 5:
                        i = i16;
                        break;
                    case 6:
                        i10 = i16;
                        break;
                    case 7:
                        i15 = i16;
                        break;
                    case '\b':
                        i5 = i16;
                        break;
                    case '\t':
                        i8 = i16;
                        break;
                }
            }
            if (i != -1) {
                return new y(i, i5, i6, i8, i10, i11, i12, i13, i14, i15, split.length);
            }
            return null;
        }
    }

    public zn(String str, int i, @Nullable Integer num, @Nullable Integer num2, float f4, boolean z2, boolean z3, boolean z4, boolean z5, int i5) {
        this.y = str;
        this.f12619n3 = i;
        this.f12622zn = num;
        this.f12617gv = num2;
        this.f12621v = f4;
        this.f12614a = z2;
        this.f12616fb = z3;
        this.f12620s = z4;
        this.f12615c5 = z5;
        this.f12618i9 = i5;
    }

    public static boolean a(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            if (parseInt != 1 && parseInt != -1) {
                return false;
            }
            return true;
        } catch (NumberFormatException e2) {
            r.i9("SsaStyle", "Failed to parse boolean value: '" + str + "'", e2);
            return false;
        }
    }

    public static float c5(String str) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e2) {
            r.i9("SsaStyle", "Failed to parse font size: '" + str + "'", e2);
            return -3.4028235E38f;
        }
    }

    public static int fb(String str) {
        try {
            int parseInt = Integer.parseInt(str.trim());
            if (gv(parseInt)) {
                return parseInt;
            }
        } catch (NumberFormatException unused) {
        }
        r.c5("SsaStyle", "Ignoring unknown BorderStyle: " + str);
        return -1;
    }

    public static boolean gv(int i) {
        if (i == 1 || i == 3) {
            return true;
        }
        return false;
    }

    @Nullable
    public static zn n3(String str, y yVar) {
        int i;
        Integer num;
        Integer num2;
        float f4;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i5;
        v5.y.y(str.startsWith("Style:"));
        String[] split = TextUtils.split(str.substring(6), ",");
        int length = split.length;
        int i6 = yVar.f12630f;
        if (length != i6) {
            r.c5("SsaStyle", j5.rz("Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", Integer.valueOf(i6), Integer.valueOf(split.length), str));
            return null;
        }
        try {
            String trim = split[yVar.y].trim();
            int i8 = yVar.f12634n3;
            if (i8 != -1) {
                i = v(split[i8].trim());
            } else {
                i = -1;
            }
            int i10 = yVar.f12637zn;
            if (i10 != -1) {
                num = s(split[i10].trim());
            } else {
                num = null;
            }
            int i11 = yVar.f12632gv;
            if (i11 != -1) {
                num2 = s(split[i11].trim());
            } else {
                num2 = null;
            }
            int i12 = yVar.f12636v;
            if (i12 != -1) {
                f4 = c5(split[i12].trim());
            } else {
                f4 = -3.4028235E38f;
            }
            int i13 = yVar.f12628a;
            if (i13 != -1 && a(split[i13].trim())) {
                z2 = true;
            } else {
                z2 = false;
            }
            int i14 = yVar.f12631fb;
            if (i14 != -1 && a(split[i14].trim())) {
                z3 = true;
            } else {
                z3 = false;
            }
            int i15 = yVar.f12635s;
            if (i15 != -1 && a(split[i15].trim())) {
                z4 = true;
            } else {
                z4 = false;
            }
            int i16 = yVar.f12629c5;
            if (i16 != -1 && a(split[i16].trim())) {
                z5 = true;
            } else {
                z5 = false;
            }
            int i17 = yVar.f12633i9;
            if (i17 != -1) {
                i5 = fb(split[i17].trim());
            } else {
                i5 = -1;
            }
            return new zn(trim, i, num, num2, f4, z2, z3, z4, z5, i5);
        } catch (RuntimeException e2) {
            r.i9("SsaStyle", "Skipping malformed 'Style:' line: '" + str + "'", e2);
            return null;
        }
    }

    @Nullable
    public static Integer s(String str) {
        long parseLong;
        boolean z2;
        try {
            if (str.startsWith("&H")) {
                parseLong = Long.parseLong(str.substring(2), 16);
            } else {
                parseLong = Long.parseLong(str);
            }
            if (parseLong <= 4294967295L) {
                z2 = true;
            } else {
                z2 = false;
            }
            v5.y.y(z2);
            int gv2 = a.gv(((parseLong >> 24) & 255) ^ 255);
            int gv3 = a.gv((parseLong >> 16) & 255);
            return Integer.valueOf(Color.argb(gv2, a.gv(parseLong & 255), a.gv((parseLong >> 8) & 255), gv3));
        } catch (IllegalArgumentException e2) {
            r.i9("SsaStyle", "Failed to parse color expression: '" + str + "'", e2);
            return null;
        }
    }

    public static int v(String str) {
        try {
            int parseInt = Integer.parseInt(str.trim());
            if (zn(parseInt)) {
                return parseInt;
            }
        } catch (NumberFormatException unused) {
        }
        r.c5("SsaStyle", "Ignoring unknown alignment: " + str);
        return -1;
    }

    public static boolean zn(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return true;
            default:
                return false;
        }
    }
}
