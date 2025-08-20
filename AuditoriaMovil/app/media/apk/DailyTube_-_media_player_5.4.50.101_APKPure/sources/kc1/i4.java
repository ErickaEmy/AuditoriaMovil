package kc1;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
/* loaded from: classes.dex */
public final class i4 {

    /* renamed from: gv  reason: collision with root package name */
    public final String[] f9791gv;

    /* renamed from: n3  reason: collision with root package name */
    public final String f9792n3;
    public final String y;

    /* renamed from: zn  reason: collision with root package name */
    public final String f9793zn;

    /* renamed from: fb  reason: collision with root package name */
    public static final y f9789fb = new y(null);

    /* renamed from: v  reason: collision with root package name */
    public static final Pattern f9790v = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f9788a = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* loaded from: classes.dex */
    public static final class y {
        public y() {
        }

        public final i4 n3(String toMediaTypeOrNull) {
            Intrinsics.checkNotNullParameter(toMediaTypeOrNull, "$this$toMediaTypeOrNull");
            try {
                return y(toMediaTypeOrNull);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public final i4 y(String toMediaType) {
            Intrinsics.checkNotNullParameter(toMediaType, "$this$toMediaType");
            Matcher matcher = i4.f9790v.matcher(toMediaType);
            if (matcher.lookingAt()) {
                String group = matcher.group(1);
                Intrinsics.checkNotNullExpressionValue(group, "typeSubtype.group(1)");
                Locale locale = Locale.US;
                Intrinsics.checkNotNullExpressionValue(locale, "Locale.US");
                if (group != null) {
                    String lowerCase = group.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    String group2 = matcher.group(2);
                    Intrinsics.checkNotNullExpressionValue(group2, "typeSubtype.group(2)");
                    Intrinsics.checkNotNullExpressionValue(locale, "Locale.US");
                    if (group2 != null) {
                        String lowerCase2 = group2.toLowerCase(locale);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
                        ArrayList arrayList = new ArrayList();
                        Matcher matcher2 = i4.f9788a.matcher(toMediaType);
                        int end = matcher.end();
                        while (end < toMediaType.length()) {
                            matcher2.region(end, toMediaType.length());
                            if (matcher2.lookingAt()) {
                                String group3 = matcher2.group(1);
                                if (group3 == null) {
                                    end = matcher2.end();
                                } else {
                                    String group4 = matcher2.group(2);
                                    if (group4 == null) {
                                        group4 = matcher2.group(3);
                                    } else if (StringsKt.startsWith$default(group4, "'", false, 2, (Object) null) && StringsKt.endsWith$default(group4, "'", false, 2, (Object) null) && group4.length() > 2) {
                                        group4 = group4.substring(1, group4.length() - 1);
                                        Intrinsics.checkNotNullExpressionValue(group4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                    }
                                    arrayList.add(group3);
                                    arrayList.add(group4);
                                    end = matcher2.end();
                                }
                            } else {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Parameter is not formatted correctly: \"");
                                String substring = toMediaType.substring(end);
                                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                                sb.append(substring);
                                sb.append("\" for: \"");
                                sb.append(toMediaType);
                                sb.append('\"');
                                throw new IllegalArgumentException(sb.toString().toString());
                            }
                        }
                        Object[] array = arrayList.toArray(new String[0]);
                        if (array != null) {
                            return new i4(toMediaType, lowerCase, lowerCase2, (String[]) array, null);
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            throw new IllegalArgumentException(("No subtype found for: \"" + toMediaType + '\"').toString());
        }

        public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public i4(String str, String str2, String str3, String[] strArr) {
        this.y = str;
        this.f9792n3 = str2;
        this.f9793zn = str3;
        this.f9791gv = strArr;
    }

    public static final i4 fb(String str) {
        return f9789fb.n3(str);
    }

    public static /* synthetic */ Charset gv(i4 i4Var, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = null;
        }
        return i4Var.zn(charset);
    }

    public static final i4 v(String str) {
        return f9789fb.y(str);
    }

    public final String a(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        IntProgression step = RangesKt.step(ArraysKt.getIndices(this.f9791gv), 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if (step2 >= 0) {
            if (first > last) {
                return null;
            }
        } else if (first < last) {
            return null;
        }
        while (!StringsKt.equals(this.f9791gv[first], name, true)) {
            if (first != last) {
                first += step2;
            } else {
                return null;
            }
        }
        return this.f9791gv[first + 1];
    }

    public final String c5() {
        return this.f9792n3;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof i4) && Intrinsics.areEqual(((i4) obj).y, this.y)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.y.hashCode();
    }

    public final String s() {
        return this.f9793zn;
    }

    public String toString() {
        return this.y;
    }

    public final Charset zn(Charset charset) {
        String a2 = a("charset");
        if (a2 != null) {
            try {
                return Charset.forName(a2);
            } catch (IllegalArgumentException unused) {
                return charset;
            }
        }
        return charset;
    }

    public /* synthetic */ i4(String str, String str2, String str3, String[] strArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, strArr);
    }
}
