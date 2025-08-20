package androidx.room.util;

import android.database.Cursor;
import androidx.sqlite.db.SupportSQLiteDatabase;
import ch.qos.logback.core.CoreConstants;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
/* compiled from: FtsTableInfo.kt */
/* loaded from: classes.dex */
public final class FtsTableInfo {
    public static final Companion Companion = new Companion(null);
    private static final String[] FTS_OPTIONS = {"tokenize=", "compress=", "content=", "languageid=", "matchinfo=", "notindexed=", "order=", "prefix=", "uncompress="};
    public final Set columns;
    public final String name;
    public final Set options;

    public static final FtsTableInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        return Companion.read(supportSQLiteDatabase, str);
    }

    public FtsTableInfo(String name, Set columns, Set options) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(columns, "columns");
        Intrinsics.checkNotNullParameter(options, "options");
        this.name = name;
        this.columns = columns;
        this.options = options;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FtsTableInfo(String name, Set columns, String createSql) {
        this(name, columns, Companion.parseOptions(createSql));
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(columns, "columns");
        Intrinsics.checkNotNullParameter(createSql, "createSql");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FtsTableInfo) {
            FtsTableInfo ftsTableInfo = (FtsTableInfo) obj;
            if (Intrinsics.areEqual(this.name, ftsTableInfo.name) && Intrinsics.areEqual(this.columns, ftsTableInfo.columns)) {
                return Intrinsics.areEqual(this.options, ftsTableInfo.options);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.columns.hashCode()) * 31) + this.options.hashCode();
    }

    public String toString() {
        return "FtsTableInfo{name='" + this.name + "', columns=" + this.columns + ", options=" + this.options + "'}";
    }

    /* compiled from: FtsTableInfo.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FtsTableInfo read(SupportSQLiteDatabase database, String tableName) {
            Intrinsics.checkNotNullParameter(database, "database");
            Intrinsics.checkNotNullParameter(tableName, "tableName");
            return new FtsTableInfo(tableName, readColumns(database, tableName), readOptions(database, tableName));
        }

        private final Set readColumns(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
            Set createSetBuilder;
            Set build;
            createSetBuilder = SetsKt__SetsJVMKt.createSetBuilder();
            Cursor query = supportSQLiteDatabase.query("PRAGMA table_info(`" + str + "`)");
            try {
                if (query.getColumnCount() > 0) {
                    int columnIndex = query.getColumnIndex("name");
                    while (query.moveToNext()) {
                        String string = query.getString(columnIndex);
                        Intrinsics.checkNotNullExpressionValue(string, "cursor.getString(nameIndex)");
                        createSetBuilder.add(string);
                    }
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(query, null);
                build = SetsKt__SetsJVMKt.build(createSetBuilder);
                return build;
            } finally {
            }
        }

        private final Set readOptions(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
            Cursor query = supportSQLiteDatabase.query("SELECT * FROM sqlite_master WHERE `name` = '" + str + CoreConstants.SINGLE_QUOTE_CHAR);
            try {
                String sql = query.moveToFirst() ? query.getString(query.getColumnIndexOrThrow("sql")) : "";
                CloseableKt.closeFinally(query, null);
                Intrinsics.checkNotNullExpressionValue(sql, "sql");
                return parseOptions(sql);
            } finally {
            }
        }

        public final Set parseOptions(String createStatement) {
            int indexOf$default;
            int lastIndexOf$default;
            CharSequence trim;
            Set set;
            boolean startsWith$default;
            Character ch2;
            Set emptySet;
            Intrinsics.checkNotNullParameter(createStatement, "createStatement");
            if (createStatement.length() == 0) {
                emptySet = SetsKt__SetsKt.emptySet();
                return emptySet;
            }
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) createStatement, (char) CoreConstants.LEFT_PARENTHESIS_CHAR, 0, false, 6, (Object) null);
            lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) createStatement, (char) CoreConstants.RIGHT_PARENTHESIS_CHAR, 0, false, 6, (Object) null);
            String substring = createStatement.substring(indexOf$default + 1, lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            ArrayList arrayList = new ArrayList();
            ArrayDeque arrayDeque = new ArrayDeque();
            int i = -1;
            int i2 = 0;
            int i3 = 0;
            while (i2 < substring.length()) {
                char charAt = substring.charAt(i2);
                int i4 = i3 + 1;
                if (charAt == '\'' || charAt == '\"' || charAt == '`') {
                    if (arrayDeque.isEmpty()) {
                        arrayDeque.push(Character.valueOf(charAt));
                    } else {
                        Character ch3 = (Character) arrayDeque.peek();
                        if (ch3 != null && ch3.charValue() == charAt) {
                            arrayDeque.pop();
                        }
                    }
                } else if (charAt == '[') {
                    if (arrayDeque.isEmpty()) {
                        arrayDeque.push(Character.valueOf(charAt));
                    }
                } else if (charAt == ']') {
                    if (!arrayDeque.isEmpty() && (ch2 = (Character) arrayDeque.peek()) != null && ch2.charValue() == '[') {
                        arrayDeque.pop();
                    }
                } else if (charAt == ',' && arrayDeque.isEmpty()) {
                    String substring2 = substring.substring(i + 1, i3);
                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    int length = substring2.length() - 1;
                    int i5 = 0;
                    boolean z = false;
                    while (i5 <= length) {
                        boolean z2 = Intrinsics.compare((int) substring2.charAt(!z ? i5 : length), 32) <= 0;
                        if (z) {
                            if (!z2) {
                                break;
                            }
                            length--;
                        } else if (z2) {
                            i5++;
                        } else {
                            z = true;
                        }
                    }
                    arrayList.add(substring2.subSequence(i5, length + 1).toString());
                    i = i3;
                }
                i2++;
                i3 = i4;
            }
            String substring3 = substring.substring(i + 1);
            Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String).substring(startIndex)");
            trim = StringsKt__StringsKt.trim(substring3);
            arrayList.add(trim.toString());
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                String str = (String) obj;
                String[] strArr = FtsTableInfo.FTS_OPTIONS;
                int length2 = strArr.length;
                int i6 = 0;
                while (true) {
                    if (i6 < length2) {
                        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, strArr[i6], false, 2, null);
                        if (startsWith$default) {
                            arrayList2.add(obj);
                            break;
                        }
                        i6++;
                    }
                }
            }
            set = CollectionsKt___CollectionsKt.toSet(arrayList2);
            return set;
        }
    }
}
