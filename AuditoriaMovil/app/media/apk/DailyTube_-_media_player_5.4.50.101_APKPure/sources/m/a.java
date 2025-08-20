package m;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import m.v;
import u0.fb;
/* loaded from: classes.dex */
public final class a {
    public static final v a(fb database, String tableName) {
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        return new v(tableName, y(database, tableName), zn(database, tableName), v(database, tableName));
    }

    public static final v.C0151v gv(fb fbVar, String str, boolean z2) {
        String str2;
        Cursor rb2 = fbVar.rb("PRAGMA index_xinfo(`" + str + "`)");
        try {
            Cursor cursor = rb2;
            int columnIndex = cursor.getColumnIndex("seqno");
            int columnIndex2 = cursor.getColumnIndex("cid");
            int columnIndex3 = cursor.getColumnIndex("name");
            int columnIndex4 = cursor.getColumnIndex("desc");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex4 != -1) {
                TreeMap treeMap = new TreeMap();
                TreeMap treeMap2 = new TreeMap();
                while (cursor.moveToNext()) {
                    if (cursor.getInt(columnIndex2) >= 0) {
                        int i = cursor.getInt(columnIndex);
                        String columnName = cursor.getString(columnIndex3);
                        if (cursor.getInt(columnIndex4) > 0) {
                            str2 = "DESC";
                        } else {
                            str2 = "ASC";
                        }
                        Integer valueOf = Integer.valueOf(i);
                        Intrinsics.checkNotNullExpressionValue(columnName, "columnName");
                        treeMap.put(valueOf, columnName);
                        treeMap2.put(Integer.valueOf(i), str2);
                    }
                }
                Collection values = treeMap.values();
                Intrinsics.checkNotNullExpressionValue(values, "columnsMap.values");
                List list = CollectionsKt.toList(values);
                Collection values2 = treeMap2.values();
                Intrinsics.checkNotNullExpressionValue(values2, "ordersMap.values");
                v.C0151v c0151v = new v.C0151v(str, z2, list, CollectionsKt.toList(values2));
                CloseableKt.closeFinally(rb2, null);
                return c0151v;
            }
            CloseableKt.closeFinally(rb2, null);
            return null;
        } finally {
        }
    }

    public static final List<v.gv> n3(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex("to");
        List createListBuilder = CollectionsKt.createListBuilder();
        while (cursor.moveToNext()) {
            int i = cursor.getInt(columnIndex);
            int i5 = cursor.getInt(columnIndex2);
            String string = cursor.getString(columnIndex3);
            Intrinsics.checkNotNullExpressionValue(string, "cursor.getString(fromColumnIndex)");
            String string2 = cursor.getString(columnIndex4);
            Intrinsics.checkNotNullExpressionValue(string2, "cursor.getString(toColumnIndex)");
            createListBuilder.add(new v.gv(i, i5, string, string2));
        }
        return CollectionsKt.sorted(CollectionsKt.build(createListBuilder));
    }

    public static final Set<v.C0151v> v(fb fbVar, String str) {
        Cursor rb2 = fbVar.rb("PRAGMA index_list(`" + str + "`)");
        try {
            Cursor cursor = rb2;
            int columnIndex = cursor.getColumnIndex("name");
            int columnIndex2 = cursor.getColumnIndex("origin");
            int columnIndex3 = cursor.getColumnIndex("unique");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                Set createSetBuilder = SetsKt.createSetBuilder();
                while (cursor.moveToNext()) {
                    if (Intrinsics.areEqual("c", cursor.getString(columnIndex2))) {
                        String name = cursor.getString(columnIndex);
                        boolean z2 = true;
                        if (cursor.getInt(columnIndex3) != 1) {
                            z2 = false;
                        }
                        Intrinsics.checkNotNullExpressionValue(name, "name");
                        v.C0151v gv2 = gv(fbVar, name, z2);
                        if (gv2 == null) {
                            CloseableKt.closeFinally(rb2, null);
                            return null;
                        }
                        createSetBuilder.add(gv2);
                    }
                }
                Set<v.C0151v> build = SetsKt.build(createSetBuilder);
                CloseableKt.closeFinally(rb2, null);
                return build;
            }
            CloseableKt.closeFinally(rb2, null);
            return null;
        } finally {
        }
    }

    public static final Map<String, v.y> y(fb fbVar, String str) {
        boolean z2;
        Cursor rb2 = fbVar.rb("PRAGMA table_info(`" + str + "`)");
        try {
            Cursor cursor = rb2;
            if (cursor.getColumnCount() <= 0) {
                Map<String, v.y> emptyMap = MapsKt.emptyMap();
                CloseableKt.closeFinally(rb2, null);
                return emptyMap;
            }
            int columnIndex = cursor.getColumnIndex("name");
            int columnIndex2 = cursor.getColumnIndex("type");
            int columnIndex3 = cursor.getColumnIndex("notnull");
            int columnIndex4 = cursor.getColumnIndex("pk");
            int columnIndex5 = cursor.getColumnIndex("dflt_value");
            Map createMapBuilder = MapsKt.createMapBuilder();
            while (cursor.moveToNext()) {
                String name = cursor.getString(columnIndex);
                String type = cursor.getString(columnIndex2);
                if (cursor.getInt(columnIndex3) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                int i = cursor.getInt(columnIndex4);
                String string = cursor.getString(columnIndex5);
                Intrinsics.checkNotNullExpressionValue(name, "name");
                Intrinsics.checkNotNullExpressionValue(type, "type");
                createMapBuilder.put(name, new v.y(name, type, z2, i, string, 2));
            }
            Map<String, v.y> build = MapsKt.build(createMapBuilder);
            CloseableKt.closeFinally(rb2, null);
            return build;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(rb2, th);
                throw th2;
            }
        }
    }

    public static final Set<v.zn> zn(fb fbVar, String str) {
        Cursor rb2 = fbVar.rb("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            Cursor cursor = rb2;
            int columnIndex = cursor.getColumnIndex("id");
            int columnIndex2 = cursor.getColumnIndex("seq");
            int columnIndex3 = cursor.getColumnIndex("table");
            int columnIndex4 = cursor.getColumnIndex("on_delete");
            int columnIndex5 = cursor.getColumnIndex("on_update");
            List<v.gv> n32 = n3(cursor);
            cursor.moveToPosition(-1);
            Set createSetBuilder = SetsKt.createSetBuilder();
            while (cursor.moveToNext()) {
                if (cursor.getInt(columnIndex2) == 0) {
                    int i = cursor.getInt(columnIndex);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList<v.gv> arrayList3 = new ArrayList();
                    for (Object obj : n32) {
                        if (((v.gv) obj).zn() == i) {
                            arrayList3.add(obj);
                        }
                    }
                    for (v.gv gvVar : arrayList3) {
                        arrayList.add(gvVar.n3());
                        arrayList2.add(gvVar.gv());
                    }
                    String string = cursor.getString(columnIndex3);
                    Intrinsics.checkNotNullExpressionValue(string, "cursor.getString(tableColumnIndex)");
                    String string2 = cursor.getString(columnIndex4);
                    Intrinsics.checkNotNullExpressionValue(string2, "cursor.getString(onDeleteColumnIndex)");
                    String string3 = cursor.getString(columnIndex5);
                    Intrinsics.checkNotNullExpressionValue(string3, "cursor.getString(onUpdateColumnIndex)");
                    createSetBuilder.add(new v.zn(string, string2, string3, arrayList, arrayList2));
                }
            }
            Set<v.zn> build = SetsKt.build(createSetBuilder);
            CloseableKt.closeFinally(rb2, null);
            return build;
        } finally {
        }
    }
}
