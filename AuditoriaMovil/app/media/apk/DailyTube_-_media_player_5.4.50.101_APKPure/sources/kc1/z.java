package kc1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
/* loaded from: classes.dex */
public final class z implements Iterable<Pair<? extends String, ? extends String>>, KMappedMarker {

    /* renamed from: v  reason: collision with root package name */
    public static final n3 f9958v = new n3(null);
    public final String[] y;

    /* loaded from: classes.dex */
    public static final class n3 {
        public n3() {
        }

        public final String a(String[] strArr, String str) {
            IntProgression step = RangesKt.step(RangesKt.downTo(strArr.length - 2, 0), 2);
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
            while (!StringsKt.equals(str, strArr[first], true)) {
                if (first != last) {
                    first += step2;
                } else {
                    return null;
                }
            }
            return strArr[first + 1];
        }

        public final z fb(String... namesAndValues) {
            boolean z2;
            boolean z3;
            Intrinsics.checkNotNullParameter(namesAndValues, "namesAndValues");
            if (namesAndValues.length % 2 == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                Object clone = namesAndValues.clone();
                if (clone != null) {
                    String[] strArr = (String[]) clone;
                    int length = strArr.length;
                    for (int i = 0; i < length; i++) {
                        String str = strArr[i];
                        if (str != null) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            if (str != null) {
                                strArr[i] = StringsKt.trim(str).toString();
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                            }
                        } else {
                            throw new IllegalArgumentException("Headers cannot be null");
                        }
                    }
                    IntProgression step = RangesKt.step(ArraysKt.getIndices(strArr), 2);
                    int first = step.getFirst();
                    int last = step.getLast();
                    int step2 = step.getStep();
                    if (step2 < 0 ? first >= last : first <= last) {
                        while (true) {
                            String str2 = strArr[first];
                            String str3 = strArr[first + 1];
                            gv(str2);
                            v(str3, str2);
                            if (first == last) {
                                break;
                            }
                            first += step2;
                        }
                    }
                    return new z(strArr, null);
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
            }
            throw new IllegalArgumentException("Expected alternating header names and values");
        }

        public final void gv(String str) {
            boolean z2;
            boolean z3;
            if (str.length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char charAt = str.charAt(i);
                    if ('!' <= charAt && '~' >= charAt) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (!z3) {
                        throw new IllegalArgumentException(lc1.n3.p("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str).toString());
                    }
                }
                return;
            }
            throw new IllegalArgumentException("name is empty");
        }

        public final void v(String str, String str2) {
            boolean z2;
            String str3;
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (charAt != '\t' && (' ' > charAt || '~' < charAt)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(lc1.n3.p("Unexpected char %#04x at %d in %s value", Integer.valueOf(charAt), Integer.valueOf(i), str2));
                    if (lc1.n3.ta(str2)) {
                        str3 = "";
                    } else {
                        str3 = ": " + str;
                    }
                    sb.append(str3);
                    throw new IllegalArgumentException(sb.toString().toString());
                }
            }
        }

        public /* synthetic */ n3(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static final class y {
        public final List<String> y = new ArrayList(20);

        public final z a() {
            Object[] array = this.y.toArray(new String[0]);
            if (array != null) {
                return new z((String[]) array, null);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        public final y c5(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            int i = 0;
            while (i < this.y.size()) {
                if (StringsKt.equals(name, this.y.get(i), true)) {
                    this.y.remove(i);
                    this.y.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        public final String fb(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            IntProgression step = RangesKt.step(RangesKt.downTo(this.y.size() - 2, 0), 2);
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
            while (!StringsKt.equals(name, this.y.get(first), true)) {
                if (first != last) {
                    first += step2;
                } else {
                    return null;
                }
            }
            return this.y.get(first + 1);
        }

        public final y gv(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            this.y.add(name);
            this.y.add(StringsKt.trim(value).toString());
            return this;
        }

        public final y i9(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            n3 n3Var = z.f9958v;
            n3Var.gv(name);
            n3Var.v(value, name);
            c5(name);
            gv(name, value);
            return this;
        }

        public final y n3(z headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                gv(headers.zn(i), headers.c5(i));
            }
            return this;
        }

        public final List<String> s() {
            return this.y;
        }

        public final y v(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            z.f9958v.gv(name);
            gv(name, value);
            return this;
        }

        public final y y(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            n3 n3Var = z.f9958v;
            n3Var.gv(name);
            n3Var.v(value, name);
            gv(name, value);
            return this;
        }

        public final y zn(String line) {
            Intrinsics.checkNotNullParameter(line, "line");
            int indexOf$default = StringsKt.indexOf$default((CharSequence) line, ':', 1, false, 4, (Object) null);
            if (indexOf$default != -1) {
                String substring = line.substring(0, indexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String substring2 = line.substring(indexOf$default + 1);
                Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.String).substring(startIndex)");
                gv(substring, substring2);
            } else if (line.charAt(0) == ':') {
                String substring3 = line.substring(1);
                Intrinsics.checkNotNullExpressionValue(substring3, "(this as java.lang.String).substring(startIndex)");
                gv("", substring3);
            } else {
                gv("", line);
            }
            return this;
        }
    }

    public z(String[] strArr) {
        this.y = strArr;
    }

    public static final z a(String... strArr) {
        return f9958v.fb(strArr);
    }

    public final String c5(int i) {
        return this.y[(i * 2) + 1];
    }

    public boolean equals(Object obj) {
        if ((obj instanceof z) && Arrays.equals(this.y, ((z) obj).y)) {
            return true;
        }
        return false;
    }

    public final Map<String, List<String>> fb() {
        TreeMap treeMap = new TreeMap(StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
        int size = size();
        for (int i = 0; i < size; i++) {
            String zn2 = zn(i);
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, "Locale.US");
            if (zn2 != null) {
                String lowerCase = zn2.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                List list = (List) treeMap.get(lowerCase);
                if (list == null) {
                    list = new ArrayList(2);
                    treeMap.put(lowerCase, list);
                }
                list.add(c5(i));
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        }
        return treeMap;
    }

    public final Set<String> gv() {
        TreeSet treeSet = new TreeSet(StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
        int size = size();
        for (int i = 0; i < size; i++) {
            treeSet.add(zn(i));
        }
        Set<String> unmodifiableSet = Collections.unmodifiableSet(treeSet);
        Intrinsics.checkNotNullExpressionValue(unmodifiableSet, "Collections.unmodifiableSet(result)");
        return unmodifiableSet;
    }

    public int hashCode() {
        return Arrays.hashCode(this.y);
    }

    public final List<String> i9(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        int size = size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            if (StringsKt.equals(name, zn(i), true)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(c5(i));
            }
        }
        if (arrayList != null) {
            List<String> unmodifiableList = Collections.unmodifiableList(arrayList);
            Intrinsics.checkNotNullExpressionValue(unmodifiableList, "Collections.unmodifiableList(result)");
            return unmodifiableList;
        }
        return CollectionsKt.emptyList();
    }

    @Override // java.lang.Iterable
    public Iterator<Pair<? extends String, ? extends String>> iterator() {
        int size = size();
        Pair[] pairArr = new Pair[size];
        for (int i = 0; i < size; i++) {
            pairArr[i] = TuplesKt.to(zn(i), c5(i));
        }
        return ArrayIteratorKt.iterator(pairArr);
    }

    public final Date n3(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        String y2 = y(name);
        if (y2 != null) {
            return qc1.zn.y(y2);
        }
        return null;
    }

    public final int size() {
        return this.y.length / 2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i = 0; i < size; i++) {
            String zn2 = zn(i);
            String c52 = c5(i);
            sb.append(zn2);
            sb.append(": ");
            if (lc1.n3.ta(zn2)) {
                c52 = "██";
            }
            sb.append(c52);
            sb.append("\n");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final y v() {
        y yVar = new y();
        CollectionsKt.addAll(yVar.s(), this.y);
        return yVar;
    }

    public final String y(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return f9958v.a(this.y, name);
    }

    public final String zn(int i) {
        return this.y[i * 2];
    }

    public /* synthetic */ z(String[] strArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(strArr);
    }
}
