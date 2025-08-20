package kc1;

import androidx.core.app.NotificationCompat;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a  reason: collision with root package name */
    public final int f9870a;

    /* renamed from: c5  reason: collision with root package name */
    public final String f9871c5;

    /* renamed from: fb  reason: collision with root package name */
    public final List<String> f9872fb;

    /* renamed from: gv  reason: collision with root package name */
    public final String f9873gv;

    /* renamed from: i9  reason: collision with root package name */
    public final String f9874i9;

    /* renamed from: n3  reason: collision with root package name */
    public final String f9875n3;

    /* renamed from: s  reason: collision with root package name */
    public final List<String> f9876s;

    /* renamed from: v  reason: collision with root package name */
    public final String f9877v;
    public final boolean y;

    /* renamed from: zn  reason: collision with root package name */
    public final String f9878zn;

    /* renamed from: t  reason: collision with root package name */
    public static final n3 f9869t = new n3(null);

    /* renamed from: f  reason: collision with root package name */
    public static final char[] f9868f = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* loaded from: classes.dex */
    public static final class n3 {
        public n3() {
        }

        public static /* synthetic */ String n3(n3 n3Var, String str, int i, int i5, String str2, boolean z2, boolean z3, boolean z4, boolean z5, Charset charset, int i6, Object obj) {
            int i8;
            int i10;
            boolean z7;
            boolean z8;
            boolean z9;
            boolean z10;
            Charset charset2;
            if ((i6 & 1) != 0) {
                i8 = 0;
            } else {
                i8 = i;
            }
            if ((i6 & 2) != 0) {
                i10 = str.length();
            } else {
                i10 = i5;
            }
            if ((i6 & 8) != 0) {
                z7 = false;
            } else {
                z7 = z2;
            }
            if ((i6 & 16) != 0) {
                z8 = false;
            } else {
                z8 = z3;
            }
            if ((i6 & 32) != 0) {
                z9 = false;
            } else {
                z9 = z4;
            }
            if ((i6 & 64) != 0) {
                z10 = false;
            } else {
                z10 = z5;
            }
            if ((i6 & NotificationCompat.FLAG_HIGH_PRIORITY) != 0) {
                charset2 = null;
            } else {
                charset2 = charset;
            }
            return n3Var.y(str, i8, i10, str2, z7, z8, z9, z10, charset2);
        }

        public static /* synthetic */ String s(n3 n3Var, String str, int i, int i5, boolean z2, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                i = 0;
            }
            if ((i6 & 2) != 0) {
                i5 = str.length();
            }
            if ((i6 & 4) != 0) {
                z2 = false;
            }
            return n3Var.fb(str, i, i5, z2);
        }

        public final r a(String toHttpUrlOrNull) {
            Intrinsics.checkNotNullParameter(toHttpUrlOrNull, "$this$toHttpUrlOrNull");
            try {
                return gv(toHttpUrlOrNull);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public final void c5(List<String> toPathString, StringBuilder out) {
            Intrinsics.checkNotNullParameter(toPathString, "$this$toPathString");
            Intrinsics.checkNotNullParameter(out, "out");
            int size = toPathString.size();
            for (int i = 0; i < size; i++) {
                out.append('/');
                out.append(toPathString.get(i));
            }
        }

        public final void f(List<String> toQueryString, StringBuilder out) {
            Intrinsics.checkNotNullParameter(toQueryString, "$this$toQueryString");
            Intrinsics.checkNotNullParameter(out, "out");
            IntProgression step = RangesKt.step(RangesKt.until(0, toQueryString.size()), 2);
            int first = step.getFirst();
            int last = step.getLast();
            int step2 = step.getStep();
            if (step2 >= 0) {
                if (first > last) {
                    return;
                }
            } else if (first < last) {
                return;
            }
            while (true) {
                String str = toQueryString.get(first);
                String str2 = toQueryString.get(first + 1);
                if (first > 0) {
                    out.append('&');
                }
                out.append(str);
                if (str2 != null) {
                    out.append('=');
                    out.append(str2);
                }
                if (first != last) {
                    first += step2;
                } else {
                    return;
                }
            }
        }

        public final String fb(String percentDecode, int i, int i5, boolean z2) {
            Intrinsics.checkNotNullParameter(percentDecode, "$this$percentDecode");
            for (int i6 = i; i6 < i5; i6++) {
                char charAt = percentDecode.charAt(i6);
                if (charAt == '%' || (charAt == '+' && z2)) {
                    zc1.v vVar = new zc1.v();
                    vVar.q(percentDecode, i, i6);
                    tl(vVar, percentDecode, i6, i5, z2);
                    return vVar.wf();
                }
            }
            String substring = percentDecode.substring(i, i5);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }

        public final r gv(String toHttpUrl) {
            Intrinsics.checkNotNullParameter(toHttpUrl, "$this$toHttpUrl");
            return new y().tl(null, toHttpUrl).gv();
        }

        public final List<String> i9(String toQueryNamesAndValues) {
            Intrinsics.checkNotNullParameter(toQueryNamesAndValues, "$this$toQueryNamesAndValues");
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i <= toQueryNamesAndValues.length()) {
                int indexOf$default = StringsKt.indexOf$default((CharSequence) toQueryNamesAndValues, '&', i, false, 4, (Object) null);
                if (indexOf$default == -1) {
                    indexOf$default = toQueryNamesAndValues.length();
                }
                int i5 = indexOf$default;
                int indexOf$default2 = StringsKt.indexOf$default((CharSequence) toQueryNamesAndValues, '=', i, false, 4, (Object) null);
                if (indexOf$default2 != -1 && indexOf$default2 <= i5) {
                    String substring = toQueryNamesAndValues.substring(i, indexOf$default2);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(substring);
                    String substring2 = toQueryNamesAndValues.substring(indexOf$default2 + 1, i5);
                    Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(substring2);
                } else {
                    String substring3 = toQueryNamesAndValues.substring(i, i5);
                    Intrinsics.checkNotNullExpressionValue(substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(substring3);
                    arrayList.add(null);
                }
                i = i5 + 1;
            }
            return arrayList;
        }

        /* JADX WARN: Code restructure failed: missing block: B:39:0x0067, code lost:
            if (v(r16, r5, r18) == false) goto L40;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void t(zc1.v r15, java.lang.String r16, int r17, int r18, java.lang.String r19, boolean r20, boolean r21, boolean r22, boolean r23, java.nio.charset.Charset r24) {
            /*
                Method dump skipped, instructions count: 202
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: kc1.r.n3.t(zc1.v, java.lang.String, int, int, java.lang.String, boolean, boolean, boolean, boolean, java.nio.charset.Charset):void");
        }

        public final void tl(zc1.v vVar, String str, int i, int i5, boolean z2) {
            int i6;
            while (i < i5) {
                if (str != null) {
                    int codePointAt = str.codePointAt(i);
                    if (codePointAt == 37 && (i6 = i + 2) < i5) {
                        int d2 = lc1.n3.d(str.charAt(i + 1));
                        int d3 = lc1.n3.d(str.charAt(i6));
                        if (d2 != -1 && d3 != -1) {
                            vVar.w2((d2 << 4) + d3);
                            i = Character.charCount(codePointAt) + i6;
                        }
                        vVar.wm(codePointAt);
                        i += Character.charCount(codePointAt);
                    } else {
                        if (codePointAt == 43 && z2) {
                            vVar.w2(32);
                            i++;
                        }
                        vVar.wm(codePointAt);
                        i += Character.charCount(codePointAt);
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            }
        }

        public final boolean v(String str, int i, int i5) {
            int i6 = i + 2;
            if (i6 < i5 && str.charAt(i) == '%' && lc1.n3.d(str.charAt(i + 1)) != -1 && lc1.n3.d(str.charAt(i6)) != -1) {
                return true;
            }
            return false;
        }

        public final String y(String canonicalize, int i, int i5, String encodeSet, boolean z2, boolean z3, boolean z4, boolean z5, Charset charset) {
            Intrinsics.checkNotNullParameter(canonicalize, "$this$canonicalize");
            Intrinsics.checkNotNullParameter(encodeSet, "encodeSet");
            int i6 = i;
            while (i6 < i5) {
                int codePointAt = canonicalize.codePointAt(i6);
                if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || z5) && !StringsKt.contains$default((CharSequence) encodeSet, (char) codePointAt, false, 2, (Object) null))) {
                    if (codePointAt == 37) {
                        if (z2) {
                            if (z3) {
                                if (!v(canonicalize, i6, i5)) {
                                    zc1.v vVar = new zc1.v();
                                    vVar.q(canonicalize, i, i6);
                                    t(vVar, canonicalize, i6, i5, encodeSet, z2, z3, z4, z5, charset);
                                    return vVar.wf();
                                }
                                if (codePointAt == 43 || !z4) {
                                    i6 += Character.charCount(codePointAt);
                                } else {
                                    zc1.v vVar2 = new zc1.v();
                                    vVar2.q(canonicalize, i, i6);
                                    t(vVar2, canonicalize, i6, i5, encodeSet, z2, z3, z4, z5, charset);
                                    return vVar2.wf();
                                }
                            }
                        }
                    }
                    if (codePointAt == 43) {
                    }
                    i6 += Character.charCount(codePointAt);
                }
                zc1.v vVar22 = new zc1.v();
                vVar22.q(canonicalize, i, i6);
                t(vVar22, canonicalize, i6, i5, encodeSet, z2, z3, z4, z5, charset);
                return vVar22.wf();
            }
            String substring = canonicalize.substring(i, i5);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }

        public final int zn(String scheme) {
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            int hashCode = scheme.hashCode();
            if (hashCode != 3213448) {
                if (hashCode == 99617003 && scheme.equals("https")) {
                    return 443;
                }
            } else if (scheme.equals("http")) {
                return 80;
            }
            return -1;
        }

        public /* synthetic */ n3(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: c5  reason: collision with root package name */
        public static final C0135y f9879c5 = new C0135y(null);

        /* renamed from: a  reason: collision with root package name */
        public final List<String> f9880a;

        /* renamed from: fb  reason: collision with root package name */
        public List<String> f9881fb;

        /* renamed from: gv  reason: collision with root package name */
        public String f9882gv;

        /* renamed from: s  reason: collision with root package name */
        public String f9884s;
        public String y;

        /* renamed from: n3  reason: collision with root package name */
        public String f9883n3 = "";

        /* renamed from: zn  reason: collision with root package name */
        public String f9886zn = "";

        /* renamed from: v  reason: collision with root package name */
        public int f9885v = -1;

        /* renamed from: kc1.r$y$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0135y {
            public C0135y() {
            }

            public final int a(String str, int i, int i5) {
                while (i < i5) {
                    char charAt = str.charAt(i);
                    if (charAt != ':') {
                        if (charAt == '[') {
                            do {
                                i++;
                                if (i < i5) {
                                }
                            } while (str.charAt(i) != ']');
                        }
                        i++;
                    } else {
                        return i;
                    }
                }
                return i5;
            }

            public final int fb(String str, int i, int i5) {
                if (i5 - i < 2) {
                    return -1;
                }
                char charAt = str.charAt(i);
                if ((Intrinsics.compare((int) charAt, 97) < 0 || Intrinsics.compare((int) charAt, 122) > 0) && (Intrinsics.compare((int) charAt, 65) < 0 || Intrinsics.compare((int) charAt, 90) > 0)) {
                    return -1;
                }
                while (true) {
                    i++;
                    if (i >= i5) {
                        return -1;
                    }
                    char charAt2 = str.charAt(i);
                    if ('a' > charAt2 || 'z' < charAt2) {
                        if ('A' > charAt2 || 'Z' < charAt2) {
                            if ('0' > charAt2 || '9' < charAt2) {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 != ':') {
                                        return -1;
                                    }
                                    return i;
                                }
                            }
                        }
                    }
                }
            }

            public final int s(String str, int i, int i5) {
                int i6 = 0;
                while (i < i5) {
                    char charAt = str.charAt(i);
                    if (charAt != '\\' && charAt != '/') {
                        break;
                    }
                    i6++;
                    i++;
                }
                return i6;
            }

            public final int v(String str, int i, int i5) {
                try {
                    int parseInt = Integer.parseInt(n3.n3(r.f9869t, str, i, i5, "", false, false, false, false, null, 248, null));
                    if (1 > parseInt || 65535 < parseInt) {
                        return -1;
                    }
                    return parseInt;
                } catch (NumberFormatException unused) {
                    return -1;
                }
            }

            public /* synthetic */ C0135y(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public y() {
            ArrayList arrayList = new ArrayList();
            this.f9880a = arrayList;
            arrayList.add("");
        }

        public final y a(String encodedPath) {
            Intrinsics.checkNotNullParameter(encodedPath, "encodedPath");
            if (StringsKt.startsWith$default(encodedPath, "/", false, 2, (Object) null)) {
                z(encodedPath, 0, encodedPath.length());
                return this;
            }
            throw new IllegalArgumentException(("unexpected encodedPath: " + encodedPath).toString());
        }

        public final void c(int i) {
            this.f9885v = i;
        }

        public final List<String> c5() {
            return this.f9880a;
        }

        public final y co(int i) {
            this.f9880a.remove(i);
            if (this.f9880a.isEmpty()) {
                this.f9880a.add("");
            }
            return this;
        }

        public final void d0(String str) {
            this.y = str;
        }

        public final boolean f(String str) {
            if (Intrinsics.areEqual(str, ".") || StringsKt.equals(str, "%2e", true)) {
                return true;
            }
            return false;
        }

        public final void f3(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.f9883n3 = str;
        }

        public final y fb(String str) {
            List<String> list;
            if (str != null) {
                n3 n3Var = r.f9869t;
                String n32 = n3.n3(n3Var, str, 0, 0, " \"'<>#", true, false, true, false, null, 211, null);
                if (n32 != null) {
                    list = n3Var.i9(n32);
                    this.f9881fb = list;
                    return this;
                }
            }
            list = null;
            this.f9881fb = list;
            return this;
        }

        public final y fh(String username) {
            Intrinsics.checkNotNullParameter(username, "username");
            this.f9883n3 = n3.n3(r.f9869t, username, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }

        public final r gv() {
            ArrayList arrayList;
            String str;
            String str2;
            String str3 = this.y;
            if (str3 != null) {
                n3 n3Var = r.f9869t;
                String s2 = n3.s(n3Var, this.f9883n3, 0, 0, false, 7, null);
                String s3 = n3.s(n3Var, this.f9886zn, 0, 0, false, 7, null);
                String str4 = this.f9882gv;
                if (str4 != null) {
                    int v2 = v();
                    List<String> list = this.f9880a;
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    for (String str5 : list) {
                        arrayList2.add(n3.s(r.f9869t, str5, 0, 0, false, 7, null));
                    }
                    List<String> list2 = this.f9881fb;
                    if (list2 != null) {
                        List<String> list3 = list2;
                        arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                        for (String str6 : list3) {
                            if (str6 != null) {
                                str2 = n3.s(r.f9869t, str6, 0, 0, true, 3, null);
                            } else {
                                str2 = null;
                            }
                            arrayList.add(str2);
                        }
                    } else {
                        arrayList = null;
                    }
                    String str7 = this.f9884s;
                    if (str7 != null) {
                        str = n3.s(r.f9869t, str7, 0, 0, false, 7, null);
                    } else {
                        str = null;
                    }
                    return new r(str3, s2, s3, str4, v2, arrayList2, arrayList, str, toString());
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        public final void i4(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.f9886zn = str;
        }

        public final y i9(String host) {
            Intrinsics.checkNotNullParameter(host, "host");
            String v2 = lc1.y.v(n3.s(r.f9869t, host, 0, 0, false, 7, null));
            if (v2 != null) {
                this.f9882gv = v2;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + host);
        }

        public final y mt() {
            String str;
            String str2;
            String str3 = this.f9882gv;
            String str4 = null;
            if (str3 != null) {
                str = new Regex("[\"<>^`{|}]").replace(str3, "");
            } else {
                str = null;
            }
            this.f9882gv = str;
            int size = this.f9880a.size();
            for (int i = 0; i < size; i++) {
                List<String> list = this.f9880a;
                list.set(i, n3.n3(r.f9869t, list.get(i), 0, 0, "[]", true, true, false, false, null, 227, null));
            }
            List<String> list2 = this.f9881fb;
            if (list2 != null) {
                int size2 = list2.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    String str5 = list2.get(i5);
                    if (str5 != null) {
                        str2 = n3.n3(r.f9869t, str5, 0, 0, "\\^`{|}", true, true, true, false, null, 195, null);
                    } else {
                        str2 = null;
                    }
                    list2.set(i5, str2);
                }
            }
            String str6 = this.f9884s;
            if (str6 != null) {
                str4 = n3.n3(r.f9869t, str6, 0, 0, " \"#<>\\^`{|}", true, true, false, true, null, 163, null);
            }
            this.f9884s = str4;
            return this;
        }

        public final void n(String str) {
            this.f9882gv = str;
        }

        public final y n3(String encodedName, String str) {
            String str2;
            Intrinsics.checkNotNullParameter(encodedName, "encodedName");
            if (this.f9881fb == null) {
                this.f9881fb = new ArrayList();
            }
            List<String> list = this.f9881fb;
            Intrinsics.checkNotNull(list);
            n3 n3Var = r.f9869t;
            list.add(n3.n3(n3Var, encodedName, 0, 0, " \"'<>#&=", true, false, true, false, null, 211, null));
            List<String> list2 = this.f9881fb;
            Intrinsics.checkNotNull(list2);
            if (str != null) {
                str2 = n3.n3(n3Var, str, 0, 0, " \"'<>#&=", true, false, true, false, null, 211, null);
            } else {
                str2 = null;
            }
            list2.add(str2);
            return this;
        }

        public final void p(String str, int i, int i5, boolean z2, boolean z3) {
            String n32 = n3.n3(r.f9869t, str, i, i5, " \"<>^`{}|/\\?#", z3, false, false, false, null, 240, null);
            if (f(n32)) {
                return;
            }
            if (t(n32)) {
                xc();
                return;
            }
            List<String> list = this.f9880a;
            if (list.get(list.size() - 1).length() == 0) {
                List<String> list2 = this.f9880a;
                list2.set(list2.size() - 1, n32);
            } else {
                this.f9880a.add(n32);
            }
            if (z2) {
                this.f9880a.add("");
            }
        }

        public final y r(String scheme) {
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            if (StringsKt.equals(scheme, "http", true)) {
                this.y = "http";
            } else if (StringsKt.equals(scheme, "https", true)) {
                this.y = "https";
            } else {
                throw new IllegalArgumentException("unexpected scheme: " + scheme);
            }
            return this;
        }

        public final y s(String str) {
            String str2;
            if (str != null) {
                str2 = n3.n3(r.f9869t, str, 0, 0, "", false, false, false, true, null, 187, null);
            } else {
                str2 = null;
            }
            this.f9884s = str2;
            return this;
        }

        public final boolean t(String str) {
            if (Intrinsics.areEqual(str, "..") || StringsKt.equals(str, "%2e.", true) || StringsKt.equals(str, ".%2e", true) || StringsKt.equals(str, "%2e%2e", true)) {
                return true;
            }
            return false;
        }

        public final y tl(r rVar, String input) {
            int wz2;
            char c2;
            int i;
            int i5;
            boolean z2;
            boolean z3;
            int i6;
            String str;
            int i8;
            boolean z4;
            boolean z5;
            Intrinsics.checkNotNullParameter(input, "input");
            int f32 = lc1.n3.f3(input, 0, 0, 3, null);
            int c4 = lc1.n3.c(input, f32, 0, 2, null);
            C0135y c0135y = f9879c5;
            int fb2 = c0135y.fb(input, f32, c4);
            String str2 = "(this as java.lang.Strin…ing(startIndex, endIndex)";
            char c6 = 65535;
            if (fb2 != -1) {
                if (StringsKt.startsWith(input, "https:", f32, true)) {
                    this.y = "https";
                    f32 += 6;
                } else if (StringsKt.startsWith(input, "http:", f32, true)) {
                    this.y = "http";
                    f32 += 5;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Expected URL scheme 'http' or 'https' but was '");
                    String substring = input.substring(0, fb2);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    sb.append(substring);
                    sb.append("'");
                    throw new IllegalArgumentException(sb.toString());
                }
            } else if (rVar != null) {
                this.y = rVar.x4();
            } else {
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
            }
            int s2 = c0135y.s(input, f32, c4);
            char c7 = '?';
            char c8 = '#';
            if (s2 < 2 && rVar != null && Intrinsics.areEqual(rVar.x4(), this.y)) {
                this.f9883n3 = rVar.s();
                this.f9886zn = rVar.gv();
                this.f9882gv = rVar.f();
                this.f9885v = rVar.mt();
                this.f9880a.clear();
                this.f9880a.addAll(rVar.a());
                if (f32 == c4 || input.charAt(f32) == '#') {
                    fb(rVar.fb());
                }
                i = c4;
            } else {
                int i10 = f32 + s2;
                boolean z7 = false;
                boolean z8 = false;
                while (true) {
                    wz2 = lc1.n3.wz(input, "@/\\?#", i10, c4);
                    if (wz2 != c4) {
                        c2 = input.charAt(wz2);
                    } else {
                        c2 = 65535;
                    }
                    if (c2 == c6 || c2 == c8 || c2 == '/' || c2 == '\\' || c2 == c7) {
                        break;
                    }
                    if (c2 != '@') {
                        i6 = c4;
                        str = str2;
                    } else {
                        if (!z7) {
                            int tl2 = lc1.n3.tl(input, ':', i10, wz2);
                            n3 n3Var = r.f9869t;
                            i6 = c4;
                            str = str2;
                            String n32 = n3.n3(n3Var, input, i10, tl2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                            if (z8) {
                                n32 = this.f9883n3 + "%40" + n32;
                            }
                            this.f9883n3 = n32;
                            i8 = wz2;
                            if (tl2 != i8) {
                                this.f9886zn = n3.n3(n3Var, input, tl2 + 1, i8, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                                z5 = true;
                            } else {
                                z5 = z7;
                            }
                            z7 = z5;
                            z4 = true;
                        } else {
                            i6 = c4;
                            str = str2;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(this.f9886zn);
                            sb2.append("%40");
                            i8 = wz2;
                            sb2.append(n3.n3(r.f9869t, input, i10, wz2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null));
                            this.f9886zn = sb2.toString();
                            z4 = z8;
                        }
                        i10 = i8 + 1;
                        z8 = z4;
                    }
                    str2 = str;
                    c4 = i6;
                    c8 = '#';
                    c7 = '?';
                    c6 = 65535;
                }
                i = c4;
                String str3 = str2;
                C0135y c0135y2 = f9879c5;
                int a2 = c0135y2.a(input, i10, wz2);
                int i11 = a2 + 1;
                if (i11 < wz2) {
                    i5 = i10;
                    this.f9882gv = lc1.y.v(n3.s(r.f9869t, input, i10, a2, false, 4, null));
                    int v2 = c0135y2.v(input, i11, wz2);
                    this.f9885v = v2;
                    if (v2 != -1) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (!z3) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Invalid URL port: \"");
                        String substring2 = input.substring(i11, wz2);
                        Intrinsics.checkNotNullExpressionValue(substring2, str3);
                        sb3.append(substring2);
                        sb3.append('\"');
                        throw new IllegalArgumentException(sb3.toString().toString());
                    }
                } else {
                    i5 = i10;
                    n3 n3Var2 = r.f9869t;
                    this.f9882gv = lc1.y.v(n3.s(n3Var2, input, i5, a2, false, 4, null));
                    String str4 = this.y;
                    Intrinsics.checkNotNull(str4);
                    this.f9885v = n3Var2.zn(str4);
                }
                if (this.f9882gv != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    f32 = wz2;
                } else {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Invalid URL host: \"");
                    String substring3 = input.substring(i5, a2);
                    Intrinsics.checkNotNullExpressionValue(substring3, str3);
                    sb4.append(substring3);
                    sb4.append('\"');
                    throw new IllegalArgumentException(sb4.toString().toString());
                }
            }
            int i12 = i;
            int wz3 = lc1.n3.wz(input, "?#", f32, i12);
            z(input, f32, wz3);
            if (wz3 < i12 && input.charAt(wz3) == '?') {
                int tl3 = lc1.n3.tl(input, '#', wz3, i12);
                n3 n3Var3 = r.f9869t;
                this.f9881fb = n3Var3.i9(n3.n3(n3Var3, input, wz3 + 1, tl3, " \"'<>#", true, false, true, false, null, 208, null));
                wz3 = tl3;
            }
            if (wz3 < i12 && input.charAt(wz3) == '#') {
                this.f9884s = n3.n3(r.f9869t, input, wz3 + 1, i12, "", true, false, false, true, null, 176, null);
            }
            return this;
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x0083, code lost:
            if (r1 != r4.zn(r3)) goto L31;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.String toString() {
            /*
                r6 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = r6.y
                if (r1 == 0) goto L12
                r0.append(r1)
                java.lang.String r1 = "://"
                r0.append(r1)
                goto L17
            L12:
                java.lang.String r1 = "//"
                r0.append(r1)
            L17:
                java.lang.String r1 = r6.f9883n3
                int r1 = r1.length()
                r2 = 58
                if (r1 <= 0) goto L22
                goto L2a
            L22:
                java.lang.String r1 = r6.f9886zn
                int r1 = r1.length()
                if (r1 <= 0) goto L44
            L2a:
                java.lang.String r1 = r6.f9883n3
                r0.append(r1)
                java.lang.String r1 = r6.f9886zn
                int r1 = r1.length()
                if (r1 <= 0) goto L3f
                r0.append(r2)
                java.lang.String r1 = r6.f9886zn
                r0.append(r1)
            L3f:
                r1 = 64
                r0.append(r1)
            L44:
                java.lang.String r1 = r6.f9882gv
                if (r1 == 0) goto L69
                kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
                r3 = 2
                r4 = 0
                r5 = 0
                boolean r1 = kotlin.text.StringsKt.contains$default(r1, r2, r5, r3, r4)
                if (r1 == 0) goto L64
                r1 = 91
                r0.append(r1)
                java.lang.String r1 = r6.f9882gv
                r0.append(r1)
                r1 = 93
                r0.append(r1)
                goto L69
            L64:
                java.lang.String r1 = r6.f9882gv
                r0.append(r1)
            L69:
                int r1 = r6.f9885v
                r3 = -1
                if (r1 != r3) goto L72
                java.lang.String r1 = r6.y
                if (r1 == 0) goto L8b
            L72:
                int r1 = r6.v()
                java.lang.String r3 = r6.y
                if (r3 == 0) goto L85
                kc1.r$n3 r4 = kc1.r.f9869t
                kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
                int r3 = r4.zn(r3)
                if (r1 == r3) goto L8b
            L85:
                r0.append(r2)
                r0.append(r1)
            L8b:
                kc1.r$n3 r1 = kc1.r.f9869t
                java.util.List<java.lang.String> r2 = r6.f9880a
                r1.c5(r2, r0)
                java.util.List<java.lang.String> r2 = r6.f9881fb
                if (r2 == 0) goto La3
                r2 = 63
                r0.append(r2)
                java.util.List<java.lang.String> r2 = r6.f9881fb
                kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
                r1.f(r2, r0)
            La3:
                java.lang.String r1 = r6.f9884s
                if (r1 == 0) goto Lb1
                r1 = 35
                r0.append(r1)
                java.lang.String r1 = r6.f9884s
                r0.append(r1)
            Lb1:
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "StringBuilder().apply(builderAction).toString()"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kc1.r.y.toString():java.lang.String");
        }

        public final int v() {
            int i = this.f9885v;
            if (i == -1) {
                n3 n3Var = r.f9869t;
                String str = this.y;
                Intrinsics.checkNotNull(str);
                return n3Var.zn(str);
            }
            return i;
        }

        public final y w(int i) {
            boolean z2 = true;
            if ((1 > i || 65535 < i) ? false : false) {
                this.f9885v = i;
                return this;
            }
            throw new IllegalArgumentException(("unexpected port: " + i).toString());
        }

        public final y wz(String password) {
            Intrinsics.checkNotNullParameter(password, "password");
            this.f9886zn = n3.n3(r.f9869t, password, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }

        public final void x4(String str) {
            this.f9884s = str;
        }

        public final void xc() {
            List<String> list = this.f9880a;
            if (list.remove(list.size() - 1).length() == 0 && !this.f9880a.isEmpty()) {
                List<String> list2 = this.f9880a;
                list2.set(list2.size() - 1, "");
                return;
            }
            this.f9880a.add("");
        }

        public final y y(String encodedPathSegment) {
            Intrinsics.checkNotNullParameter(encodedPathSegment, "encodedPathSegment");
            p(encodedPathSegment, 0, encodedPathSegment.length(), false, true);
            return this;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0044 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0041 -> B:11:0x0029). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void z(java.lang.String r11, int r12, int r13) {
            /*
                r10 = this;
                if (r12 != r13) goto L3
                return
            L3:
                char r0 = r11.charAt(r12)
                r1 = 47
                java.lang.String r2 = ""
                r3 = 1
                if (r0 == r1) goto L1e
                r1 = 92
                if (r0 != r1) goto L13
                goto L1e
            L13:
                java.util.List<java.lang.String> r0 = r10.f9880a
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L29
            L1e:
                java.util.List<java.lang.String> r0 = r10.f9880a
                r0.clear()
                java.util.List<java.lang.String> r0 = r10.f9880a
                r0.add(r2)
                goto L41
            L29:
                r6 = r12
                if (r6 >= r13) goto L44
                java.lang.String r12 = "/\\"
                int r12 = lc1.n3.wz(r11, r12, r6, r13)
                if (r12 >= r13) goto L36
                r0 = 1
                goto L37
            L36:
                r0 = 0
            L37:
                r9 = 1
                r4 = r10
                r5 = r11
                r7 = r12
                r8 = r0
                r4.p(r5, r6, r7, r8, r9)
                if (r0 == 0) goto L29
            L41:
                int r12 = r12 + 1
                goto L29
            L44:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kc1.r.y.z(java.lang.String, int, int):void");
        }

        public final y zn(String name, String str) {
            String str2;
            Intrinsics.checkNotNullParameter(name, "name");
            if (this.f9881fb == null) {
                this.f9881fb = new ArrayList();
            }
            List<String> list = this.f9881fb;
            Intrinsics.checkNotNull(list);
            n3 n3Var = r.f9869t;
            list.add(n3.n3(n3Var, name, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 219, null));
            List<String> list2 = this.f9881fb;
            Intrinsics.checkNotNull(list2);
            if (str != null) {
                str2 = n3.n3(n3Var, str, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 219, null);
            } else {
                str2 = null;
            }
            list2.add(str2);
            return this;
        }
    }

    public r(String scheme, String username, String password, String host, int i, List<String> pathSegments, List<String> list, String str, String url) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(pathSegments, "pathSegments");
        Intrinsics.checkNotNullParameter(url, "url");
        this.f9875n3 = scheme;
        this.f9878zn = username;
        this.f9873gv = password;
        this.f9877v = host;
        this.f9870a = i;
        this.f9872fb = pathSegments;
        this.f9876s = list;
        this.f9871c5 = str;
        this.f9874i9 = url;
        this.y = Intrinsics.areEqual(scheme, "https");
    }

    public static final r i9(String str) {
        return f9869t.gv(str);
    }

    public static final int n3(String str) {
        return f9869t.zn(str);
    }

    public static final r xc(String str) {
        return f9869t.a(str);
    }

    public final List<String> a() {
        int indexOf$default = StringsKt.indexOf$default((CharSequence) this.f9874i9, '/', this.f9875n3.length() + 3, false, 4, (Object) null);
        String str = this.f9874i9;
        int wz2 = lc1.n3.wz(str, "?#", indexOf$default, str.length());
        ArrayList arrayList = new ArrayList();
        while (indexOf$default < wz2) {
            int i = indexOf$default + 1;
            int tl2 = lc1.n3.tl(this.f9874i9, '/', i, wz2);
            String str2 = this.f9874i9;
            if (str2 != null) {
                String substring = str2.substring(i, tl2);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                arrayList.add(substring);
                indexOf$default = tl2;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        }
        return arrayList;
    }

    public final String c5() {
        return this.f9871c5;
    }

    public final String co() {
        if (this.f9876s == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        f9869t.f(this.f9876s, sb);
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof r) && Intrinsics.areEqual(((r) obj).f9874i9, this.f9874i9)) {
            return true;
        }
        return false;
    }

    public final String f() {
        return this.f9877v;
    }

    public final URL f3() {
        try {
            return new URL(this.f9874i9);
        } catch (MalformedURLException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final String fb() {
        if (this.f9876s == null) {
            return null;
        }
        int indexOf$default = StringsKt.indexOf$default((CharSequence) this.f9874i9, '?', 0, false, 6, (Object) null) + 1;
        String str = this.f9874i9;
        int tl2 = lc1.n3.tl(str, '#', indexOf$default, str.length());
        String str2 = this.f9874i9;
        if (str2 != null) {
            String substring = str2.substring(indexOf$default, tl2);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public final String gv() {
        if (this.f9873gv.length() == 0) {
            return "";
        }
        int indexOf$default = StringsKt.indexOf$default((CharSequence) this.f9874i9, ':', this.f9875n3.length() + 3, false, 4, (Object) null) + 1;
        int indexOf$default2 = StringsKt.indexOf$default((CharSequence) this.f9874i9, '@', 0, false, 6, (Object) null);
        String str = this.f9874i9;
        if (str != null) {
            String substring = str.substring(indexOf$default, indexOf$default2);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public int hashCode() {
        return this.f9874i9.hashCode();
    }

    public final URI i4() {
        String yVar = tl().mt().toString();
        try {
            return new URI(yVar);
        } catch (URISyntaxException e2) {
            try {
                URI create = URI.create(new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").replace(yVar, ""));
                Intrinsics.checkNotNullExpressionValue(create, "try {\n        val stripp…e) // Unexpected!\n      }");
                return create;
            } catch (Exception unused) {
                throw new RuntimeException(e2);
            }
        }
    }

    public final int mt() {
        return this.f9870a;
    }

    public final int p() {
        return this.f9872fb.size();
    }

    public final r r(String link) {
        Intrinsics.checkNotNullParameter(link, "link");
        y wz2 = wz(link);
        if (wz2 != null) {
            return wz2.gv();
        }
        return null;
    }

    public final String s() {
        if (this.f9878zn.length() == 0) {
            return "";
        }
        int length = this.f9875n3.length() + 3;
        String str = this.f9874i9;
        int wz2 = lc1.n3.wz(str, ":@", length, str.length());
        String str2 = this.f9874i9;
        if (str2 != null) {
            String substring = str2.substring(length, wz2);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public final boolean t() {
        return this.y;
    }

    public final y tl() {
        int i;
        y yVar = new y();
        yVar.d0(this.f9875n3);
        yVar.f3(s());
        yVar.i4(gv());
        yVar.n(this.f9877v);
        if (this.f9870a != f9869t.zn(this.f9875n3)) {
            i = this.f9870a;
        } else {
            i = -1;
        }
        yVar.c(i);
        yVar.c5().clear();
        yVar.c5().addAll(a());
        yVar.fb(fb());
        yVar.x4(zn());
        return yVar;
    }

    public String toString() {
        return this.f9874i9;
    }

    public final String v() {
        int indexOf$default = StringsKt.indexOf$default((CharSequence) this.f9874i9, '/', this.f9875n3.length() + 3, false, 4, (Object) null);
        String str = this.f9874i9;
        int wz2 = lc1.n3.wz(str, "?#", indexOf$default, str.length());
        String str2 = this.f9874i9;
        if (str2 != null) {
            String substring = str2.substring(indexOf$default, wz2);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public final List<String> w() {
        return this.f9872fb;
    }

    public final y wz(String link) {
        Intrinsics.checkNotNullParameter(link, "link");
        try {
            return new y().tl(this, link);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public final String x4() {
        return this.f9875n3;
    }

    public final String z() {
        y wz2 = wz("/...");
        Intrinsics.checkNotNull(wz2);
        return wz2.fh("").wz("").gv().toString();
    }

    public final String zn() {
        if (this.f9871c5 == null) {
            return null;
        }
        int indexOf$default = StringsKt.indexOf$default((CharSequence) this.f9874i9, '#', 0, false, 6, (Object) null) + 1;
        String str = this.f9874i9;
        if (str != null) {
            String substring = str.substring(indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
            return substring;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }
}
