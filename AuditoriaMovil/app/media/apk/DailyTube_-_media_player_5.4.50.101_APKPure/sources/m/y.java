package m;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Build;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* loaded from: classes.dex */
public final class y {
    public static final int gv(Cursor c2, String name) {
        Intrinsics.checkNotNullParameter(c2, "c");
        Intrinsics.checkNotNullParameter(name, "name");
        int columnIndex = c2.getColumnIndex(name);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        int columnIndex2 = c2.getColumnIndex('`' + name + '`');
        if (columnIndex2 < 0) {
            return n3(c2, name);
        }
        return columnIndex2;
    }

    public static final int n3(Cursor cursor, String str) {
        if (Build.VERSION.SDK_INT > 25 || str.length() == 0) {
            return -1;
        }
        String[] columnNames = cursor.getColumnNames();
        Intrinsics.checkNotNullExpressionValue(columnNames, "columnNames");
        return zn(columnNames, str);
    }

    public static final int v(Cursor c2, String name) {
        String str;
        Intrinsics.checkNotNullParameter(c2, "c");
        Intrinsics.checkNotNullParameter(name, "name");
        int gv2 = gv(c2, name);
        if (gv2 >= 0) {
            return gv2;
        }
        try {
            String[] columnNames = c2.getColumnNames();
            Intrinsics.checkNotNullExpressionValue(columnNames, "c.columnNames");
            str = ArraysKt.joinToString$default(columnNames, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null);
        } catch (Exception unused) {
            str = "unknown";
        }
        throw new IllegalArgumentException("column '" + name + "' does not exist. Available columns: " + str);
    }

    public static final Cursor y(Cursor c2) {
        Intrinsics.checkNotNullParameter(c2, "c");
        Cursor cursor = c2;
        try {
            Cursor cursor2 = cursor;
            MatrixCursor matrixCursor = new MatrixCursor(cursor2.getColumnNames(), cursor2.getCount());
            while (cursor2.moveToNext()) {
                Object[] objArr = new Object[cursor2.getColumnCount()];
                int columnCount = c2.getColumnCount();
                for (int i = 0; i < columnCount; i++) {
                    int type = cursor2.getType(i);
                    if (type != 0) {
                        if (type != 1) {
                            if (type != 2) {
                                if (type != 3) {
                                    if (type == 4) {
                                        objArr[i] = cursor2.getBlob(i);
                                    } else {
                                        throw new IllegalStateException();
                                    }
                                } else {
                                    objArr[i] = cursor2.getString(i);
                                }
                            } else {
                                objArr[i] = Double.valueOf(cursor2.getDouble(i));
                            }
                        } else {
                            objArr[i] = Long.valueOf(cursor2.getLong(i));
                        }
                    } else {
                        objArr[i] = null;
                    }
                }
                matrixCursor.addRow(objArr);
            }
            CloseableKt.closeFinally(cursor, null);
            return matrixCursor;
        } finally {
        }
    }

    public static final int zn(String[] columnNames, String name) {
        Intrinsics.checkNotNullParameter(columnNames, "columnNames");
        Intrinsics.checkNotNullParameter(name, "name");
        String str = '.' + name;
        String str2 = '.' + name + '`';
        int length = columnNames.length;
        int i = 0;
        int i5 = 0;
        while (i < length) {
            String str3 = columnNames[i];
            int i6 = i5 + 1;
            if (str3.length() >= name.length() + 2) {
                if (StringsKt.endsWith$default(str3, str, false, 2, (Object) null)) {
                    return i5;
                }
                if (str3.charAt(0) == '`' && StringsKt.endsWith$default(str3, str2, false, 2, (Object) null)) {
                    return i5;
                }
            }
            i++;
            i5 = i6;
        }
        return -1;
    }
}
