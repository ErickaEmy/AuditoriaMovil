package m;

import android.annotation.SuppressLint;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rb.wz;
import u0.fb;
/* loaded from: classes.dex */
public final class v {

    /* renamed from: v  reason: collision with root package name */
    public static final n3 f10529v = new n3(null);

    /* renamed from: gv  reason: collision with root package name */
    public final Set<C0151v> f10530gv;

    /* renamed from: n3  reason: collision with root package name */
    public final Map<String, y> f10531n3;
    public final String y;

    /* renamed from: zn  reason: collision with root package name */
    public final Set<zn> f10532zn;

    /* loaded from: classes.dex */
    public static final class gv implements Comparable<gv> {

        /* renamed from: fb  reason: collision with root package name */
        public final String f10533fb;

        /* renamed from: s  reason: collision with root package name */
        public final String f10534s;

        /* renamed from: v  reason: collision with root package name */
        public final int f10535v;
        public final int y;

        public gv(int i, int i5, String from, String to) {
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(to, "to");
            this.y = i;
            this.f10535v = i5;
            this.f10533fb = from;
            this.f10534s = to;
        }

        public final String gv() {
            return this.f10534s;
        }

        public final String n3() {
            return this.f10533fb;
        }

        @Override // java.lang.Comparable
        /* renamed from: y */
        public int compareTo(gv other) {
            Intrinsics.checkNotNullParameter(other, "other");
            int i = this.y - other.y;
            if (i == 0) {
                return this.f10535v - other.f10535v;
            }
            return i;
        }

        public final int zn() {
            return this.y;
        }
    }

    /* loaded from: classes.dex */
    public static final class n3 {
        public /* synthetic */ n3(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final v y(fb database, String tableName) {
            Intrinsics.checkNotNullParameter(database, "database");
            Intrinsics.checkNotNullParameter(tableName, "tableName");
            return a.a(database, tableName);
        }

        public n3() {
        }
    }

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: s  reason: collision with root package name */
        public static final C0152y f10540s = new C0152y(null);

        /* renamed from: a  reason: collision with root package name */
        public final int f10541a;

        /* renamed from: fb  reason: collision with root package name */
        public final int f10542fb;

        /* renamed from: gv  reason: collision with root package name */
        public final int f10543gv;

        /* renamed from: n3  reason: collision with root package name */
        public final String f10544n3;

        /* renamed from: v  reason: collision with root package name */
        public final String f10545v;
        public final String y;

        /* renamed from: zn  reason: collision with root package name */
        public final boolean f10546zn;

        /* renamed from: m.v$y$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0152y {
            public /* synthetic */ C0152y(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @SuppressLint({"SyntheticAccessor"})
            public final boolean n3(String current, String str) {
                Intrinsics.checkNotNullParameter(current, "current");
                if (Intrinsics.areEqual(current, str)) {
                    return true;
                }
                if (y(current)) {
                    String substring = current.substring(1, current.length() - 1);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    return Intrinsics.areEqual(StringsKt.trim(substring).toString(), str);
                }
                return false;
            }

            public final boolean y(String str) {
                if (str.length() == 0) {
                    return false;
                }
                int i = 0;
                int i5 = 0;
                int i6 = 0;
                while (i < str.length()) {
                    char charAt = str.charAt(i);
                    int i8 = i6 + 1;
                    if (i6 == 0 && charAt != '(') {
                        return false;
                    }
                    if (charAt == '(') {
                        i5++;
                    } else if (charAt == ')' && i5 - 1 == 0 && i6 != str.length() - 1) {
                        return false;
                    }
                    i++;
                    i6 = i8;
                }
                if (i5 != 0) {
                    return false;
                }
                return true;
            }

            public C0152y() {
            }
        }

        public y(String name, String type, boolean z2, int i, String str, int i5) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(type, "type");
            this.y = name;
            this.f10544n3 = type;
            this.f10546zn = z2;
            this.f10543gv = i;
            this.f10545v = str;
            this.f10541a = i5;
            this.f10542fb = y(type);
        }

        public boolean equals(Object obj) {
            String str;
            String str2;
            String str3;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof y) || this.f10543gv != ((y) obj).f10543gv) {
                return false;
            }
            y yVar = (y) obj;
            if (!Intrinsics.areEqual(this.y, yVar.y) || this.f10546zn != yVar.f10546zn) {
                return false;
            }
            if (this.f10541a == 1 && yVar.f10541a == 2 && (str3 = this.f10545v) != null && !f10540s.n3(str3, yVar.f10545v)) {
                return false;
            }
            if (this.f10541a == 2 && yVar.f10541a == 1 && (str2 = yVar.f10545v) != null && !f10540s.n3(str2, this.f10545v)) {
                return false;
            }
            int i = this.f10541a;
            if ((i == 0 || i != yVar.f10541a || ((str = this.f10545v) == null ? yVar.f10545v == null : f10540s.n3(str, yVar.f10545v))) && this.f10542fb == yVar.f10542fb) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            int hashCode = ((this.y.hashCode() * 31) + this.f10542fb) * 31;
            if (this.f10546zn) {
                i = 1231;
            } else {
                i = 1237;
            }
            return ((hashCode + i) * 31) + this.f10543gv;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Column{name='");
            sb.append(this.y);
            sb.append("', type='");
            sb.append(this.f10544n3);
            sb.append("', affinity='");
            sb.append(this.f10542fb);
            sb.append("', notNull=");
            sb.append(this.f10546zn);
            sb.append(", primaryKeyPosition=");
            sb.append(this.f10543gv);
            sb.append(", defaultValue='");
            String str = this.f10545v;
            if (str == null) {
                str = "undefined";
            }
            sb.append(str);
            sb.append("'}");
            return sb.toString();
        }

        public final int y(String str) {
            if (str == null) {
                return 5;
            }
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String upperCase = str.toUpperCase(US);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
            if (StringsKt.contains$default((CharSequence) upperCase, (CharSequence) "INT", false, 2, (Object) null)) {
                return 3;
            }
            if (StringsKt.contains$default((CharSequence) upperCase, (CharSequence) "CHAR", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) upperCase, (CharSequence) "CLOB", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) upperCase, (CharSequence) "TEXT", false, 2, (Object) null)) {
                return 2;
            }
            if (StringsKt.contains$default((CharSequence) upperCase, (CharSequence) "BLOB", false, 2, (Object) null)) {
                return 5;
            }
            if (!StringsKt.contains$default((CharSequence) upperCase, (CharSequence) "REAL", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) upperCase, (CharSequence) "FLOA", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) upperCase, (CharSequence) "DOUB", false, 2, (Object) null)) {
                return 1;
            }
            return 4;
        }
    }

    /* loaded from: classes.dex */
    public static final class zn {

        /* renamed from: gv  reason: collision with root package name */
        public final List<String> f10547gv;

        /* renamed from: n3  reason: collision with root package name */
        public final String f10548n3;

        /* renamed from: v  reason: collision with root package name */
        public final List<String> f10549v;
        public final String y;

        /* renamed from: zn  reason: collision with root package name */
        public final String f10550zn;

        public zn(String referenceTable, String onDelete, String onUpdate, List<String> columnNames, List<String> referenceColumnNames) {
            Intrinsics.checkNotNullParameter(referenceTable, "referenceTable");
            Intrinsics.checkNotNullParameter(onDelete, "onDelete");
            Intrinsics.checkNotNullParameter(onUpdate, "onUpdate");
            Intrinsics.checkNotNullParameter(columnNames, "columnNames");
            Intrinsics.checkNotNullParameter(referenceColumnNames, "referenceColumnNames");
            this.y = referenceTable;
            this.f10548n3 = onDelete;
            this.f10550zn = onUpdate;
            this.f10547gv = columnNames;
            this.f10549v = referenceColumnNames;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof zn)) {
                return false;
            }
            zn znVar = (zn) obj;
            if (!Intrinsics.areEqual(this.y, znVar.y) || !Intrinsics.areEqual(this.f10548n3, znVar.f10548n3) || !Intrinsics.areEqual(this.f10550zn, znVar.f10550zn) || !Intrinsics.areEqual(this.f10547gv, znVar.f10547gv)) {
                return false;
            }
            return Intrinsics.areEqual(this.f10549v, znVar.f10549v);
        }

        public int hashCode() {
            return (((((((this.y.hashCode() * 31) + this.f10548n3.hashCode()) * 31) + this.f10550zn.hashCode()) * 31) + this.f10547gv.hashCode()) * 31) + this.f10549v.hashCode();
        }

        public String toString() {
            return "ForeignKey{referenceTable='" + this.y + "', onDelete='" + this.f10548n3 + " +', onUpdate='" + this.f10550zn + "', columnNames=" + this.f10547gv + ", referenceColumnNames=" + this.f10549v + '}';
        }
    }

    public v(String name, Map<String, y> columns, Set<zn> foreignKeys, Set<C0151v> set) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(columns, "columns");
        Intrinsics.checkNotNullParameter(foreignKeys, "foreignKeys");
        this.y = name;
        this.f10531n3 = columns;
        this.f10532zn = foreignKeys;
        this.f10530gv = set;
    }

    public static final v y(fb fbVar, String str) {
        return f10529v.y(fbVar, str);
    }

    public boolean equals(Object obj) {
        Set<C0151v> set;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        if (!Intrinsics.areEqual(this.y, vVar.y) || !Intrinsics.areEqual(this.f10531n3, vVar.f10531n3) || !Intrinsics.areEqual(this.f10532zn, vVar.f10532zn)) {
            return false;
        }
        Set<C0151v> set2 = this.f10530gv;
        if (set2 == null || (set = vVar.f10530gv) == null) {
            return true;
        }
        return Intrinsics.areEqual(set2, set);
    }

    public int hashCode() {
        return (((this.y.hashCode() * 31) + this.f10531n3.hashCode()) * 31) + this.f10532zn.hashCode();
    }

    public String toString() {
        return "TableInfo{name='" + this.y + "', columns=" + this.f10531n3 + ", foreignKeys=" + this.f10532zn + ", indices=" + this.f10530gv + '}';
    }

    /* renamed from: m.v$v  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0151v {

        /* renamed from: v  reason: collision with root package name */
        public static final y f10536v = new y(null);

        /* renamed from: gv  reason: collision with root package name */
        public List<String> f10537gv;

        /* renamed from: n3  reason: collision with root package name */
        public final boolean f10538n3;
        public final String y;

        /* renamed from: zn  reason: collision with root package name */
        public final List<String> f10539zn;

        /* renamed from: m.v$v$y */
        /* loaded from: classes.dex */
        public static final class y {
            public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public y() {
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.util.Collection] */
        /* JADX WARN: Type inference failed for: r5v2 */
        /* JADX WARN: Type inference failed for: r5v4, types: [java.util.ArrayList] */
        public C0151v(String name, boolean z2, List<String> columns, List<String> orders) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(columns, "columns");
            Intrinsics.checkNotNullParameter(orders, "orders");
            this.y = name;
            this.f10538n3 = z2;
            this.f10539zn = columns;
            this.f10537gv = orders;
            List<String> list = orders;
            if (list.isEmpty()) {
                int size = columns.size();
                list = new ArrayList(size);
                for (int i = 0; i < size; i++) {
                    list.add(wz.ASC.name());
                }
            }
            this.f10537gv = (List) list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0151v)) {
                return false;
            }
            C0151v c0151v = (C0151v) obj;
            if (this.f10538n3 != c0151v.f10538n3 || !Intrinsics.areEqual(this.f10539zn, c0151v.f10539zn) || !Intrinsics.areEqual(this.f10537gv, c0151v.f10537gv)) {
                return false;
            }
            if (StringsKt.startsWith$default(this.y, "index_", false, 2, (Object) null)) {
                return StringsKt.startsWith$default(c0151v.y, "index_", false, 2, (Object) null);
            }
            return Intrinsics.areEqual(this.y, c0151v.y);
        }

        public int hashCode() {
            int hashCode;
            if (StringsKt.startsWith$default(this.y, "index_", false, 2, (Object) null)) {
                hashCode = -1184239155;
            } else {
                hashCode = this.y.hashCode();
            }
            return (((((hashCode * 31) + (this.f10538n3 ? 1 : 0)) * 31) + this.f10539zn.hashCode()) * 31) + this.f10537gv.hashCode();
        }

        public String toString() {
            return "Index{name='" + this.y + "', unique=" + this.f10538n3 + ", columns=" + this.f10539zn + ", orders=" + this.f10537gv + "'}";
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public C0151v(java.lang.String r5, boolean r6, java.util.List<java.lang.String> r7) {
            /*
                r4 = this;
                java.lang.String r0 = "name"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                java.lang.String r0 = "columns"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                int r0 = r7.size()
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>(r0)
                r2 = 0
            L14:
                if (r2 >= r0) goto L22
                rb.wz r3 = rb.wz.ASC
                java.lang.String r3 = r3.name()
                r1.add(r3)
                int r2 = r2 + 1
                goto L14
            L22:
                r4.<init>(r5, r6, r7, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: m.v.C0151v.<init>(java.lang.String, boolean, java.util.List):void");
        }
    }
}
