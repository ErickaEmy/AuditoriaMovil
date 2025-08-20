package androidx.room.util;

import android.database.Cursor;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.fdroid.fdroid.nearby.peers.BonjourPeer;
/* compiled from: TableInfo.kt */
/* loaded from: classes.dex */
public abstract class TableInfoKt {
    public static final TableInfo readTableInfo(SupportSQLiteDatabase database, String tableName) {
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        return new TableInfo(tableName, readColumns(database, tableName), readForeignKeys(database, tableName), readIndices(database, tableName));
    }

    private static final Set readForeignKeys(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        Set createSetBuilder;
        Set build;
        Cursor query = supportSQLiteDatabase.query("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            int columnIndex = query.getColumnIndex("id");
            int columnIndex2 = query.getColumnIndex("seq");
            int columnIndex3 = query.getColumnIndex("table");
            int columnIndex4 = query.getColumnIndex("on_delete");
            int columnIndex5 = query.getColumnIndex("on_update");
            List readForeignKeyFieldMappings = readForeignKeyFieldMappings(query);
            query.moveToPosition(-1);
            createSetBuilder = SetsKt__SetsJVMKt.createSetBuilder();
            while (query.moveToNext()) {
                if (query.getInt(columnIndex2) == 0) {
                    int i = query.getInt(columnIndex);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList<TableInfo.ForeignKeyWithSequence> arrayList3 = new ArrayList();
                    for (Object obj : readForeignKeyFieldMappings) {
                        if (((TableInfo.ForeignKeyWithSequence) obj).getId() == i) {
                            arrayList3.add(obj);
                        }
                    }
                    for (TableInfo.ForeignKeyWithSequence foreignKeyWithSequence : arrayList3) {
                        arrayList.add(foreignKeyWithSequence.getFrom());
                        arrayList2.add(foreignKeyWithSequence.getTo());
                    }
                    String string = query.getString(columnIndex3);
                    Intrinsics.checkNotNullExpressionValue(string, "cursor.getString(tableColumnIndex)");
                    String string2 = query.getString(columnIndex4);
                    Intrinsics.checkNotNullExpressionValue(string2, "cursor.getString(onDeleteColumnIndex)");
                    String string3 = query.getString(columnIndex5);
                    Intrinsics.checkNotNullExpressionValue(string3, "cursor.getString(onUpdateColumnIndex)");
                    createSetBuilder.add(new TableInfo.ForeignKey(string, string2, string3, arrayList, arrayList2));
                }
            }
            build = SetsKt__SetsJVMKt.build(createSetBuilder);
            CloseableKt.closeFinally(query, null);
            return build;
        } finally {
        }
    }

    private static final List readForeignKeyFieldMappings(Cursor cursor) {
        List createListBuilder;
        List build;
        List sorted;
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex("to");
        createListBuilder = CollectionsKt__CollectionsJVMKt.createListBuilder();
        while (cursor.moveToNext()) {
            int i = cursor.getInt(columnIndex);
            int i2 = cursor.getInt(columnIndex2);
            String string = cursor.getString(columnIndex3);
            Intrinsics.checkNotNullExpressionValue(string, "cursor.getString(fromColumnIndex)");
            String string2 = cursor.getString(columnIndex4);
            Intrinsics.checkNotNullExpressionValue(string2, "cursor.getString(toColumnIndex)");
            createListBuilder.add(new TableInfo.ForeignKeyWithSequence(i, i2, string, string2));
        }
        build = CollectionsKt__CollectionsJVMKt.build(createListBuilder);
        sorted = CollectionsKt___CollectionsKt.sorted(build);
        return sorted;
    }

    private static final Map readColumns(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        Map createMapBuilder;
        Map build;
        Map emptyMap;
        Cursor query = supportSQLiteDatabase.query("PRAGMA table_info(`" + str + "`)");
        try {
            if (query.getColumnCount() <= 0) {
                emptyMap = MapsKt__MapsKt.emptyMap();
                CloseableKt.closeFinally(query, null);
                return emptyMap;
            }
            int columnIndex = query.getColumnIndex("name");
            int columnIndex2 = query.getColumnIndex(BonjourPeer.TYPE);
            int columnIndex3 = query.getColumnIndex("notnull");
            int columnIndex4 = query.getColumnIndex("pk");
            int columnIndex5 = query.getColumnIndex("dflt_value");
            createMapBuilder = MapsKt__MapsJVMKt.createMapBuilder();
            while (query.moveToNext()) {
                String name = query.getString(columnIndex);
                String type = query.getString(columnIndex2);
                boolean z = query.getInt(columnIndex3) != 0;
                int i = query.getInt(columnIndex4);
                String string = query.getString(columnIndex5);
                Intrinsics.checkNotNullExpressionValue(name, "name");
                Intrinsics.checkNotNullExpressionValue(type, "type");
                createMapBuilder.put(name, new TableInfo.Column(name, type, z, i, string, 2));
            }
            build = MapsKt__MapsJVMKt.build(createMapBuilder);
            CloseableKt.closeFinally(query, null);
            return build;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(query, th);
                throw th2;
            }
        }
    }

    private static final Set readIndices(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        Set createSetBuilder;
        Set build;
        Cursor query = supportSQLiteDatabase.query("PRAGMA index_list(`" + str + "`)");
        try {
            int columnIndex = query.getColumnIndex("name");
            int columnIndex2 = query.getColumnIndex("origin");
            int columnIndex3 = query.getColumnIndex("unique");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                createSetBuilder = SetsKt__SetsJVMKt.createSetBuilder();
                while (query.moveToNext()) {
                    if (Intrinsics.areEqual("c", query.getString(columnIndex2))) {
                        String name = query.getString(columnIndex);
                        boolean z = true;
                        if (query.getInt(columnIndex3) != 1) {
                            z = false;
                        }
                        Intrinsics.checkNotNullExpressionValue(name, "name");
                        TableInfo.Index readIndex = readIndex(supportSQLiteDatabase, name, z);
                        if (readIndex == null) {
                            CloseableKt.closeFinally(query, null);
                            return null;
                        }
                        createSetBuilder.add(readIndex);
                    }
                }
                build = SetsKt__SetsJVMKt.build(createSetBuilder);
                CloseableKt.closeFinally(query, null);
                return build;
            }
            CloseableKt.closeFinally(query, null);
            return null;
        } finally {
        }
    }

    private static final TableInfo.Index readIndex(SupportSQLiteDatabase supportSQLiteDatabase, String str, boolean z) {
        List list;
        List list2;
        Cursor query = supportSQLiteDatabase.query("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = query.getColumnIndex("seqno");
            int columnIndex2 = query.getColumnIndex("cid");
            int columnIndex3 = query.getColumnIndex("name");
            int columnIndex4 = query.getColumnIndex("desc");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex4 != -1) {
                TreeMap treeMap = new TreeMap();
                TreeMap treeMap2 = new TreeMap();
                while (query.moveToNext()) {
                    if (query.getInt(columnIndex2) >= 0) {
                        int i = query.getInt(columnIndex);
                        String columnName = query.getString(columnIndex3);
                        String str2 = query.getInt(columnIndex4) > 0 ? "DESC" : "ASC";
                        Integer valueOf = Integer.valueOf(i);
                        Intrinsics.checkNotNullExpressionValue(columnName, "columnName");
                        treeMap.put(valueOf, columnName);
                        treeMap2.put(Integer.valueOf(i), str2);
                    }
                }
                Collection values = treeMap.values();
                Intrinsics.checkNotNullExpressionValue(values, "columnsMap.values");
                list = CollectionsKt___CollectionsKt.toList(values);
                Collection values2 = treeMap2.values();
                Intrinsics.checkNotNullExpressionValue(values2, "ordersMap.values");
                list2 = CollectionsKt___CollectionsKt.toList(values2);
                TableInfo.Index index = new TableInfo.Index(str, z, list, list2);
                CloseableKt.closeFinally(query, null);
                return index;
            }
            CloseableKt.closeFinally(query, null);
            return null;
        } finally {
        }
    }
}
