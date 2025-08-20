package ps;

import android.graphics.PointF;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ps.zn;
import qh.c5;
import qh.n3;
import qh.s;
import v5.j5;
import v5.r;
import v5.rz;
import w0.v;
/* loaded from: classes.dex */
public final class y extends s {

    /* renamed from: z  reason: collision with root package name */
    public static final Pattern f12608z = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");

    /* renamed from: co  reason: collision with root package name */
    public float f12609co;

    /* renamed from: mt  reason: collision with root package name */
    public float f12610mt;

    /* renamed from: p  reason: collision with root package name */
    public Map<String, zn> f12611p;
    @Nullable

    /* renamed from: w  reason: collision with root package name */
    public final n3 f12612w;

    /* renamed from: xc  reason: collision with root package name */
    public final boolean f12613xc;

    public y(@Nullable List<byte[]> list) {
        super("SsaDecoder");
        this.f12610mt = -3.4028235E38f;
        this.f12609co = -3.4028235E38f;
        if (list != null && !list.isEmpty()) {
            this.f12613xc = true;
            String mg2 = j5.mg(list.get(0));
            v5.y.y(mg2.startsWith("Format:"));
            this.f12612w = (n3) v5.y.v(n3.y(mg2));
            ej(new rz(list.get(1)), v.f14523zn);
            return;
        }
        this.f12613xc = false;
        this.f12612w = null;
    }

    public static Map<String, zn> a8(rz rzVar, Charset charset) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        zn.y yVar = null;
        while (true) {
            String z2 = rzVar.z(charset);
            if (z2 == null || (rzVar.y() != 0 && rzVar.s(charset) == '[')) {
                break;
            } else if (z2.startsWith("Format:")) {
                yVar = zn.y.y(z2);
            } else if (z2.startsWith("Style:")) {
                if (yVar == null) {
                    r.c5("SsaDecoder", "Skipping 'Style:' line before 'Format:' line: " + z2);
                } else {
                    zn n32 = zn.n3(z2, yVar);
                    if (n32 != null) {
                        linkedHashMap.put(n32.y, n32);
                    }
                }
            }
        }
        return linkedHashMap;
    }

    public static int b(int i) {
        switch (i) {
            case -1:
                return Integer.MIN_VALUE;
            case 0:
            default:
                r.c5("SsaDecoder", "Unknown alignment: " + i);
                return Integer.MIN_VALUE;
            case 1:
            case 2:
            case 3:
                return 2;
            case 4:
            case 5:
            case 6:
                return 1;
            case 7:
            case 8:
            case 9:
                return 0;
        }
    }

    public static int fh(long j2, List<Long> list, List<List<qh.n3>> list2) {
        int i;
        ArrayList arrayList;
        int size = list.size() - 1;
        while (true) {
            if (size >= 0) {
                if (list.get(size).longValue() == j2) {
                    return size;
                }
                if (list.get(size).longValue() < j2) {
                    i = size + 1;
                    break;
                }
                size--;
            } else {
                i = 0;
                break;
            }
        }
        list.add(i, Long.valueOf(j2));
        if (i == 0) {
            arrayList = new ArrayList();
        } else {
            arrayList = new ArrayList(list2.get(i - 1));
        }
        list2.add(i, arrayList);
        return i;
    }

    public static int k5(int i) {
        switch (i) {
            case -1:
                return Integer.MIN_VALUE;
            case 0:
            default:
                r.c5("SsaDecoder", "Unknown alignment: " + i);
                return Integer.MIN_VALUE;
            case 1:
            case 4:
            case 7:
                return 0;
            case 2:
            case 5:
            case 8:
                return 1;
            case 3:
            case 6:
            case 9:
                return 2;
        }
    }

    public static qh.n3 mg(String str, @Nullable zn znVar, zn.n3 n3Var, float f4, float f6) {
        SpannableString spannableString = new SpannableString(str);
        n3.C0187n3 xc2 = new n3.C0187n3().xc(spannableString);
        if (znVar != null) {
            if (znVar.f12622zn != null) {
                spannableString.setSpan(new ForegroundColorSpan(znVar.f12622zn.intValue()), 0, spannableString.length(), 33);
            }
            if (znVar.f12618i9 == 3 && znVar.f12617gv != null) {
                spannableString.setSpan(new BackgroundColorSpan(znVar.f12617gv.intValue()), 0, spannableString.length(), 33);
            }
            float f9 = znVar.f12621v;
            if (f9 != -3.4028235E38f && f6 != -3.4028235E38f) {
                xc2.p(f9 / f6, 1);
            }
            boolean z2 = znVar.f12614a;
            if (z2 && znVar.f12616fb) {
                spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
            } else if (z2) {
                spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
            } else if (znVar.f12616fb) {
                spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
            }
            if (znVar.f12620s) {
                spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 33);
            }
            if (znVar.f12615c5) {
                spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
            }
        }
        int i = n3Var.y;
        if (i == -1) {
            if (znVar != null) {
                i = znVar.f12619n3;
            } else {
                i = -1;
            }
        }
        xc2.w(yt(i)).t(k5(i)).c5(b(i));
        PointF pointF = n3Var.f12627n3;
        if (pointF != null && f6 != -3.4028235E38f && f4 != -3.4028235E38f) {
            xc2.f(pointF.x / f4);
            xc2.s(n3Var.f12627n3.y / f6, 0);
        } else {
            xc2.f(rz(xc2.gv()));
            xc2.s(rz(xc2.zn()), 0);
        }
        return xc2.y();
    }

    public static float rz(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return -3.4028235E38f;
                }
                return 0.95f;
            }
            return 0.5f;
        }
        return 0.05f;
    }

    public static long x(String str) {
        Matcher matcher = f12608z.matcher(str.trim());
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        return (Long.parseLong((String) j5.i9(matcher.group(1))) * 3600000000L) + (Long.parseLong((String) j5.i9(matcher.group(2))) * 60000000) + (Long.parseLong((String) j5.i9(matcher.group(3))) * 1000000) + (Long.parseLong((String) j5.i9(matcher.group(4))) * 10000);
    }

    @Nullable
    public static Layout.Alignment yt(int i) {
        switch (i) {
            case -1:
                return null;
            case 0:
            default:
                r.c5("SsaDecoder", "Unknown alignment: " + i);
                return null;
            case 1:
            case 4:
            case 7:
                return Layout.Alignment.ALIGN_NORMAL;
            case 2:
            case 5:
            case 8:
                return Layout.Alignment.ALIGN_CENTER;
            case 3:
            case 6:
            case 9:
                return Layout.Alignment.ALIGN_OPPOSITE;
        }
    }

    @Override // qh.s
    public c5 c(byte[] bArr, int i, boolean z2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        rz rzVar = new rz(bArr, i);
        Charset ta2 = ta(rzVar);
        if (!this.f12613xc) {
            ej(rzVar, ta2);
        }
        z6(rzVar, arrayList, arrayList2, ta2);
        return new gv(arrayList, arrayList2);
    }

    public final void d(String str, n3 n3Var, List<List<qh.n3>> list, List<Long> list2) {
        zn znVar;
        int i;
        v5.y.y(str.startsWith("Dialogue:"));
        String[] split = str.substring(9).split(",", n3Var.f12606v);
        if (split.length != n3Var.f12606v) {
            r.c5("SsaDecoder", "Skipping dialogue line with fewer columns than format: " + str);
            return;
        }
        long x2 = x(split[n3Var.y]);
        if (x2 == -9223372036854775807L) {
            r.c5("SsaDecoder", "Skipping invalid timing: " + str);
            return;
        }
        long x3 = x(split[n3Var.f12605n3]);
        if (x3 == -9223372036854775807L) {
            r.c5("SsaDecoder", "Skipping invalid timing: " + str);
            return;
        }
        Map<String, zn> map = this.f12611p;
        if (map != null && (i = n3Var.f12607zn) != -1) {
            znVar = map.get(split[i].trim());
        } else {
            znVar = null;
        }
        String str2 = split[n3Var.f12604gv];
        qh.n3 mg2 = mg(zn.n3.gv(str2).replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " "), znVar, zn.n3.n3(str2), this.f12610mt, this.f12609co);
        int fh2 = fh(x3, list2, list);
        for (int fh3 = fh(x2, list2, list); fh3 < fh2; fh3++) {
            list.get(fh3).add(mg2);
        }
    }

    public final void ej(rz rzVar, Charset charset) {
        while (true) {
            String z2 = rzVar.z(charset);
            if (z2 != null) {
                if ("[Script Info]".equalsIgnoreCase(z2)) {
                    ud(rzVar, charset);
                } else if ("[V4+ Styles]".equalsIgnoreCase(z2)) {
                    this.f12611p = a8(rzVar, charset);
                } else if ("[V4 Styles]".equalsIgnoreCase(z2)) {
                    r.a("SsaDecoder", "[V4 Styles] are not supported");
                } else if ("[Events]".equalsIgnoreCase(z2)) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final Charset ta(rz rzVar) {
        Charset hw2 = rzVar.hw();
        if (hw2 == null) {
            return v.f14523zn;
        }
        return hw2;
    }

    public final void ud(rz rzVar, Charset charset) {
        while (true) {
            String z2 = rzVar.z(charset);
            if (z2 != null) {
                if (rzVar.y() == 0 || rzVar.s(charset) != '[') {
                    String[] split = z2.split(":");
                    if (split.length == 2) {
                        String v2 = w0.zn.v(split[0].trim());
                        v2.hashCode();
                        if (!v2.equals("playresx")) {
                            if (v2.equals("playresy")) {
                                try {
                                    this.f12609co = Float.parseFloat(split[1].trim());
                                } catch (NumberFormatException unused) {
                                }
                            }
                        } else {
                            this.f12610mt = Float.parseFloat(split[1].trim());
                        }
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final void z6(rz rzVar, List<List<qh.n3>> list, List<Long> list2, Charset charset) {
        n3 n3Var;
        if (this.f12613xc) {
            n3Var = this.f12612w;
        } else {
            n3Var = null;
        }
        while (true) {
            String z2 = rzVar.z(charset);
            if (z2 != null) {
                if (z2.startsWith("Format:")) {
                    n3Var = n3.y(z2);
                } else if (z2.startsWith("Dialogue:")) {
                    if (n3Var == null) {
                        r.c5("SsaDecoder", "Skipping dialogue line before complete format: " + z2);
                    } else {
                        d(z2, n3Var, list, list2);
                    }
                }
            } else {
                return;
            }
        }
    }
}
