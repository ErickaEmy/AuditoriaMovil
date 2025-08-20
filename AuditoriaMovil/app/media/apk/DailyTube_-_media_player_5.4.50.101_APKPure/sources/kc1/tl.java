package kc1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
/* loaded from: classes.dex */
public final class tl {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f9933a;

    /* renamed from: c5  reason: collision with root package name */
    public final boolean f9934c5;

    /* renamed from: fb  reason: collision with root package name */
    public final boolean f9935fb;

    /* renamed from: gv  reason: collision with root package name */
    public final String f9936gv;

    /* renamed from: n3  reason: collision with root package name */
    public final String f9937n3;

    /* renamed from: s  reason: collision with root package name */
    public final boolean f9938s;

    /* renamed from: v  reason: collision with root package name */
    public final String f9939v;
    public final String y;

    /* renamed from: zn  reason: collision with root package name */
    public final long f9940zn;

    /* renamed from: wz  reason: collision with root package name */
    public static final y f9932wz = new y(null);

    /* renamed from: i9  reason: collision with root package name */
    public static final Pattern f9929i9 = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: f  reason: collision with root package name */
    public static final Pattern f9928f = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: t  reason: collision with root package name */
    public static final Pattern f9930t = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: tl  reason: collision with root package name */
    public static final Pattern f9931tl = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* loaded from: classes.dex */
    public static final class y {
        public y() {
        }

        public final String a(String str) {
            if (!StringsKt.endsWith$default(str, ".", false, 2, (Object) null)) {
                String v2 = lc1.y.v(StringsKt.removePrefix(str, "."));
                if (v2 != null) {
                    return v2;
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException("Failed requirement.");
        }

        public final long fb(String str, int i, int i5) {
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z7;
            boolean z8;
            int y = y(str, i, i5, false);
            Matcher matcher = tl.f9931tl.matcher(str);
            int i6 = -1;
            int i8 = -1;
            int i10 = -1;
            int i11 = -1;
            int i12 = -1;
            int i13 = -1;
            while (y < i5) {
                int y2 = y(str, y + 1, i5, true);
                matcher.region(y, y2);
                if (i8 == -1 && matcher.usePattern(tl.f9931tl).matches()) {
                    String group = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(group, "matcher.group(1)");
                    i8 = Integer.parseInt(group);
                    String group2 = matcher.group(2);
                    Intrinsics.checkNotNullExpressionValue(group2, "matcher.group(2)");
                    i12 = Integer.parseInt(group2);
                    String group3 = matcher.group(3);
                    Intrinsics.checkNotNullExpressionValue(group3, "matcher.group(3)");
                    i13 = Integer.parseInt(group3);
                } else if (i10 == -1 && matcher.usePattern(tl.f9930t).matches()) {
                    String group4 = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(group4, "matcher.group(1)");
                    i10 = Integer.parseInt(group4);
                } else if (i11 == -1 && matcher.usePattern(tl.f9928f).matches()) {
                    String group5 = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(group5, "matcher.group(1)");
                    Locale locale = Locale.US;
                    Intrinsics.checkNotNullExpressionValue(locale, "Locale.US");
                    if (group5 != null) {
                        String lowerCase = group5.toLowerCase(locale);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                        String pattern = tl.f9928f.pattern();
                        Intrinsics.checkNotNullExpressionValue(pattern, "MONTH_PATTERN.pattern()");
                        i11 = StringsKt.indexOf$default((CharSequence) pattern, lowerCase, 0, false, 6, (Object) null) / 4;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                } else if (i6 == -1 && matcher.usePattern(tl.f9929i9).matches()) {
                    String group6 = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(group6, "matcher.group(1)");
                    i6 = Integer.parseInt(group6);
                }
                y = y(str, y2 + 1, i5, false);
            }
            if (70 <= i6 && 99 >= i6) {
                i6 += 1900;
            }
            if (i6 >= 0 && 69 >= i6) {
                i6 += 2000;
            }
            if (i6 >= 1601) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (i11 != -1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    if (1 <= i10 && 31 >= i10) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (z4) {
                        if (i8 >= 0 && 23 >= i8) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (z5) {
                            if (i12 >= 0 && 59 >= i12) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            if (z7) {
                                if (i13 >= 0 && 59 >= i13) {
                                    z8 = true;
                                } else {
                                    z8 = false;
                                }
                                if (z8) {
                                    GregorianCalendar gregorianCalendar = new GregorianCalendar(lc1.n3.f10301a);
                                    gregorianCalendar.setLenient(false);
                                    gregorianCalendar.set(1, i6);
                                    gregorianCalendar.set(2, i11 - 1);
                                    gregorianCalendar.set(5, i10);
                                    gregorianCalendar.set(11, i8);
                                    gregorianCalendar.set(12, i12);
                                    gregorianCalendar.set(13, i13);
                                    gregorianCalendar.set(14, 0);
                                    return gregorianCalendar.getTimeInMillis();
                                }
                                throw new IllegalArgumentException("Failed requirement.");
                            }
                            throw new IllegalArgumentException("Failed requirement.");
                        }
                        throw new IllegalArgumentException("Failed requirement.");
                    }
                    throw new IllegalArgumentException("Failed requirement.");
                }
                throw new IllegalArgumentException("Failed requirement.");
            }
            throw new IllegalArgumentException("Failed requirement.");
        }

        /* JADX WARN: Code restructure failed: missing block: B:53:0x00fe, code lost:
            if (r1 > 253402300799999L) goto L87;
         */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0110  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x0113  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x0156  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final kc1.tl gv(long r26, kc1.r r28, java.lang.String r29) {
            /*
                Method dump skipped, instructions count: 373
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: kc1.tl.y.gv(long, kc1.r, java.lang.String):kc1.tl");
        }

        public final boolean n3(String str, String str2) {
            if (Intrinsics.areEqual(str, str2)) {
                return true;
            }
            if (StringsKt.endsWith$default(str, str2, false, 2, (Object) null) && str.charAt((str.length() - str2.length()) - 1) == '.' && !lc1.n3.a(str)) {
                return true;
            }
            return false;
        }

        public final long s(String str) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong <= 0) {
                    return Long.MIN_VALUE;
                }
                return parseLong;
            } catch (NumberFormatException e2) {
                if (new Regex("-?\\d+").matches(str)) {
                    if (StringsKt.startsWith$default(str, "-", false, 2, (Object) null)) {
                        return Long.MIN_VALUE;
                    }
                    return Long.MAX_VALUE;
                }
                throw e2;
            }
        }

        public final List<tl> v(r url, z headers) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(headers, "headers");
            List<String> i92 = headers.i9("Set-Cookie");
            int size = i92.size();
            ArrayList arrayList = null;
            for (int i = 0; i < size; i++) {
                tl zn2 = zn(url, i92.get(i));
                if (zn2 != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(zn2);
                }
            }
            if (arrayList != null) {
                List<tl> unmodifiableList = Collections.unmodifiableList(arrayList);
                Intrinsics.checkNotNullExpressionValue(unmodifiableList, "Collections.unmodifiableList(cookies)");
                return unmodifiableList;
            }
            return CollectionsKt.emptyList();
        }

        public final int y(String str, int i, int i5, boolean z2) {
            boolean z3;
            while (i < i5) {
                char charAt = str.charAt(i);
                if ((charAt >= ' ' || charAt == '\t') && charAt < 127 && (('0' > charAt || '9' < charAt) && (('a' > charAt || 'z' < charAt) && (('A' > charAt || 'Z' < charAt) && charAt != ':')))) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (z3 == (!z2)) {
                    return i;
                }
                i++;
            }
            return i5;
        }

        public final tl zn(r url, String setCookie) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(setCookie, "setCookie");
            return gv(System.currentTimeMillis(), url, setCookie);
        }

        public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public tl(String str, String str2, long j2, String str3, String str4, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.y = str;
        this.f9937n3 = str2;
        this.f9940zn = j2;
        this.f9936gv = str3;
        this.f9939v = str4;
        this.f9933a = z2;
        this.f9935fb = z3;
        this.f9938s = z4;
        this.f9934c5 = z5;
    }

    public final String a(boolean z2) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.y);
        sb.append('=');
        sb.append(this.f9937n3);
        if (this.f9938s) {
            if (this.f9940zn == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(qc1.zn.n3(new Date(this.f9940zn)));
            }
        }
        if (!this.f9934c5) {
            sb.append("; domain=");
            if (z2) {
                sb.append(".");
            }
            sb.append(this.f9936gv);
        }
        sb.append("; path=");
        sb.append(this.f9939v);
        if (this.f9933a) {
            sb.append("; secure");
        }
        if (this.f9935fb) {
            sb.append("; httponly");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString()");
        return sb2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof tl) {
            tl tlVar = (tl) obj;
            if (Intrinsics.areEqual(tlVar.y, this.y) && Intrinsics.areEqual(tlVar.f9937n3, this.f9937n3) && tlVar.f9940zn == this.f9940zn && Intrinsics.areEqual(tlVar.f9936gv, this.f9936gv) && Intrinsics.areEqual(tlVar.f9939v, this.f9939v) && tlVar.f9933a == this.f9933a && tlVar.f9935fb == this.f9935fb && tlVar.f9938s == this.f9938s && tlVar.f9934c5 == this.f9934c5) {
                return true;
            }
        }
        return false;
    }

    public final String fb() {
        return this.f9937n3;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        return ((((((((((((((((527 + this.y.hashCode()) * 31) + this.f9937n3.hashCode()) * 31) + yc.gv.y(this.f9940zn)) * 31) + this.f9936gv.hashCode()) * 31) + this.f9939v.hashCode()) * 31) + yc.y.y(this.f9933a)) * 31) + yc.y.y(this.f9935fb)) * 31) + yc.y.y(this.f9938s)) * 31) + yc.y.y(this.f9934c5);
    }

    public String toString() {
        return a(false);
    }

    public final String v() {
        return this.y;
    }

    public /* synthetic */ tl(String str, String str2, long j2, String str3, String str4, boolean z2, boolean z3, boolean z4, boolean z5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j2, str3, str4, z2, z3, z4, z5);
    }
}
