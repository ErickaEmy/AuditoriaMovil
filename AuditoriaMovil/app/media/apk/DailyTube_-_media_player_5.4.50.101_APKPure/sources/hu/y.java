package hu;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import qh.c5;
import qh.n3;
import qh.s;
import v5.r;
import v5.rz;
import v5.x4;
import w0.v;
/* loaded from: classes.dex */
public final class y extends s {

    /* renamed from: w  reason: collision with root package name */
    public final ArrayList<String> f8930w;

    /* renamed from: xc  reason: collision with root package name */
    public final StringBuilder f8931xc;

    /* renamed from: p  reason: collision with root package name */
    public static final Pattern f8929p = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");

    /* renamed from: mt  reason: collision with root package name */
    public static final Pattern f8928mt = Pattern.compile("\\{\\\\.*?\\}");

    public y() {
        super("SubripDecoder");
        this.f8931xc = new StringBuilder();
        this.f8930w = new ArrayList<>();
    }

    public static float mg(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    return 0.92f;
                }
                throw new IllegalArgumentException();
            }
            return 0.5f;
        }
        return 0.08f;
    }

    private Charset rz(rz rzVar) {
        Charset hw2 = rzVar.hw();
        if (hw2 == null) {
            return v.f14523zn;
        }
        return hw2;
    }

    public static long ta(Matcher matcher, int i) {
        long j2;
        String group = matcher.group(i + 1);
        if (group != null) {
            j2 = Long.parseLong(group) * 3600000;
        } else {
            j2 = 0;
        }
        long parseLong = j2 + (Long.parseLong((String) v5.y.v(matcher.group(i + 2))) * 60000) + (Long.parseLong((String) v5.y.v(matcher.group(i + 3))) * 1000);
        String group2 = matcher.group(i + 4);
        if (group2 != null) {
            parseLong += Long.parseLong(group2);
        }
        return parseLong * 1000;
    }

    @Override // qh.s
    public c5 c(byte[] bArr, int i, boolean z2) {
        String str;
        ArrayList arrayList = new ArrayList();
        x4 x4Var = new x4();
        rz rzVar = new rz(bArr, i);
        Charset rz2 = rz(rzVar);
        while (true) {
            String z3 = rzVar.z(rz2);
            int i5 = 0;
            if (z3 == null) {
                break;
            } else if (z3.length() != 0) {
                try {
                    Integer.parseInt(z3);
                    String z4 = rzVar.z(rz2);
                    if (z4 == null) {
                        r.c5("SubripDecoder", "Unexpected end");
                        break;
                    }
                    Matcher matcher = f8929p.matcher(z4);
                    if (matcher.matches()) {
                        x4Var.y(ta(matcher, 1));
                        x4Var.y(ta(matcher, 6));
                        this.f8931xc.setLength(0);
                        this.f8930w.clear();
                        for (String z5 = rzVar.z(rz2); !TextUtils.isEmpty(z5); z5 = rzVar.z(rz2)) {
                            if (this.f8931xc.length() > 0) {
                                this.f8931xc.append("<br>");
                            }
                            this.f8931xc.append(d(z5, this.f8930w));
                        }
                        Spanned fromHtml = Html.fromHtml(this.f8931xc.toString());
                        while (true) {
                            if (i5 < this.f8930w.size()) {
                                str = this.f8930w.get(i5);
                                if (str.matches("\\{\\\\an[1-9]\\}")) {
                                    break;
                                }
                                i5++;
                            } else {
                                str = null;
                                break;
                            }
                        }
                        arrayList.add(fh(fromHtml, str));
                        arrayList.add(qh.n3.f12847ej);
                    } else {
                        r.c5("SubripDecoder", "Skipping invalid timing: " + z4);
                    }
                } catch (NumberFormatException unused) {
                    r.c5("SubripDecoder", "Skipping invalid index: " + z3);
                }
            }
        }
        return new n3((qh.n3[]) arrayList.toArray(new qh.n3[0]), x4Var.gv());
    }

    public final String d(String str, ArrayList<String> arrayList) {
        String trim = str.trim();
        StringBuilder sb = new StringBuilder(trim);
        Matcher matcher = f8928mt.matcher(trim);
        int i = 0;
        while (matcher.find()) {
            String group = matcher.group();
            arrayList.add(group);
            int start = matcher.start() - i;
            int length = group.length();
            sb.replace(start, start + length, "");
            i += length;
        }
        return sb.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final qh.n3 fh(Spanned spanned, @Nullable String str) {
        char c2;
        char c4;
        n3.C0187n3 xc2 = new n3.C0187n3().xc(spanned);
        if (str == null) {
            return xc2.y();
        }
        switch (str.hashCode()) {
            case -685620710:
                if (str.equals("{\\an1}")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -685620679:
                if (str.equals("{\\an2}")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case -685620648:
                if (str.equals("{\\an3}")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case -685620617:
                if (str.equals("{\\an4}")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case -685620586:
                if (str.equals("{\\an5}")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case -685620555:
                if (str.equals("{\\an6}")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case -685620524:
                if (str.equals("{\\an7}")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -685620493:
                if (str.equals("{\\an8}")) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case -685620462:
                if (str.equals("{\\an9}")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 != 0 && c2 != 1 && c2 != 2) {
            if (c2 != 3 && c2 != 4 && c2 != 5) {
                xc2.t(1);
            } else {
                xc2.t(2);
            }
        } else {
            xc2.t(0);
        }
        switch (str.hashCode()) {
            case -685620710:
                if (str.equals("{\\an1}")) {
                    c4 = 0;
                    break;
                }
                c4 = 65535;
                break;
            case -685620679:
                if (str.equals("{\\an2}")) {
                    c4 = 1;
                    break;
                }
                c4 = 65535;
                break;
            case -685620648:
                if (str.equals("{\\an3}")) {
                    c4 = 2;
                    break;
                }
                c4 = 65535;
                break;
            case -685620617:
                if (str.equals("{\\an4}")) {
                    c4 = 6;
                    break;
                }
                c4 = 65535;
                break;
            case -685620586:
                if (str.equals("{\\an5}")) {
                    c4 = 7;
                    break;
                }
                c4 = 65535;
                break;
            case -685620555:
                if (str.equals("{\\an6}")) {
                    c4 = '\b';
                    break;
                }
                c4 = 65535;
                break;
            case -685620524:
                if (str.equals("{\\an7}")) {
                    c4 = 3;
                    break;
                }
                c4 = 65535;
                break;
            case -685620493:
                if (str.equals("{\\an8}")) {
                    c4 = 4;
                    break;
                }
                c4 = 65535;
                break;
            case -685620462:
                if (str.equals("{\\an9}")) {
                    c4 = 5;
                    break;
                }
                c4 = 65535;
                break;
            default:
                c4 = 65535;
                break;
        }
        if (c4 != 0 && c4 != 1 && c4 != 2) {
            if (c4 != 3 && c4 != 4 && c4 != 5) {
                xc2.c5(1);
            } else {
                xc2.c5(0);
            }
        } else {
            xc2.c5(2);
        }
        return xc2.f(mg(xc2.gv())).s(mg(xc2.zn()), 0).y();
    }
}
