package org.fdroid.database;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import org.fdroid.index.v2.ReflectionDiffer;
/* compiled from: DbDiffUtils.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0082\u0001\u0010\u0003\u001a\u00020\u0004\"\b\b\u0000\u0010\u0005*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u001e\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\r0\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\u00112\u001e\u0010\u0012\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\r\u0012\u0004\u0012\u00020\u00040\u000bJb\u0010\u0003\u001a\u00020\u0004\"\b\b\u0000\u0010\u0005*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\r0\u00112\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f2\u0018\u0010\u0012\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\r\u0012\u0004\u0012\u00020\u00040\u0011JÀ\u0001\u0010\u0013\u001a\u00020\u0004\"\b\b\u0000\u0010\u0005*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00050\r2\u0018\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\u00160\u000b2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u0002H\u00050\u00112\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\u00112\u0018\u0010\u0019\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\r\u0012\u0004\u0012\u00020\u00040\u00112\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\u00160\u00112\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\rJ\u001c\u0010\u001c\u001a\u00020\u0004*\u00020\u00072\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\rH\u0002¨\u0006\u001e"}, d2 = {"Lorg/fdroid/database/DbDiffUtils;", "", "()V", "diffAndUpdateListTable", "", "T", "jsonObject", "Lkotlinx/serialization/json/JsonObject;", "jsonObjectKey", "", "listParser", "Lkotlin/Function2;", "Lkotlinx/serialization/json/JsonArray;", "", "deleteAll", "Lkotlin/Function0;", "deleteList", "Lkotlin/Function1;", "insertNewList", "diffAndUpdateTable", "itemList", "itemFinder", "", "newItem", "deleteOne", "insertReplace", "isNewItemValid", "keyDenyList", "checkDenyList", "list", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DbDiffUtils {
    public static final DbDiffUtils INSTANCE = new DbDiffUtils();

    private DbDiffUtils() {
    }

    public static /* synthetic */ void diffAndUpdateTable$default(DbDiffUtils dbDiffUtils, JsonObject jsonObject, String str, List list, Function2 function2, Function1 function1, Function0 function0, Function1 function12, Function1 function13, Function1 function14, List list2, int i, Object obj) throws SerializationException {
        dbDiffUtils.diffAndUpdateTable(jsonObject, str, list, function2, function1, function0, function12, function13, (i & 256) != 0 ? new Function1() { // from class: org.fdroid.database.DbDiffUtils$diffAndUpdateTable$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.TRUE;
            }
        } : function14, (i & 512) != 0 ? null : list2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> void diffAndUpdateTable(JsonObject jsonObject, String jsonObjectKey, List<? extends T> itemList, final Function2 itemFinder, Function1 newItem, Function0 deleteAll, Function1 deleteOne, Function1 insertReplace, Function1 isNewItemValid, List<String> list) throws SerializationException {
        JsonObject jsonObject2;
        List mutableList;
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(jsonObjectKey, "jsonObjectKey");
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        Intrinsics.checkNotNullParameter(itemFinder, "itemFinder");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        Intrinsics.checkNotNullParameter(deleteAll, "deleteAll");
        Intrinsics.checkNotNullParameter(deleteOne, "deleteOne");
        Intrinsics.checkNotNullParameter(insertReplace, "insertReplace");
        Intrinsics.checkNotNullParameter(isNewItemValid, "isNewItemValid");
        if (jsonObject.containsKey((Object) jsonObjectKey)) {
            if (Intrinsics.areEqual(jsonObject.get((Object) jsonObjectKey), JsonNull.INSTANCE)) {
                deleteAll.invoke();
                return;
            }
            JsonElement jsonElement = (JsonElement) jsonObject.get((Object) jsonObjectKey);
            if (jsonElement == null || (jsonObject2 = JsonElementKt.getJsonObject(jsonElement)) == null) {
                throw new IllegalStateException(("no " + jsonObjectKey + " object").toString());
            }
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) itemList);
            for (Map.Entry entry : jsonObject2.entrySet()) {
                final String str = (String) entry.getKey();
                JsonElement jsonElement2 = (JsonElement) entry.getValue();
                if (jsonElement2 instanceof JsonNull) {
                    CollectionsKt__MutableCollectionsKt.removeAll(mutableList, new Function1() { // from class: org.fdroid.database.DbDiffUtils$diffAndUpdateTable$2$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(Object it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            return (Boolean) Function2.this.invoke(str, it);
                        }
                    });
                    deleteOne.invoke(str);
                } else {
                    INSTANCE.checkDenyList(JsonElementKt.getJsonObject(jsonElement2), list);
                    Iterator it = mutableList.iterator();
                    int i = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i = -1;
                            break;
                        } else if (((Boolean) itemFinder.invoke(str, it.next())).booleanValue()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    Object obj = i == -1 ? null : mutableList.get(i);
                    if (obj == null) {
                        Object applyDiff = ReflectionDiffer.INSTANCE.applyDiff(newItem.invoke(str), JsonElementKt.getJsonObject(jsonElement2));
                        if (!((Boolean) isNewItemValid.invoke(applyDiff)).booleanValue()) {
                            throw new SerializationException(String.valueOf(newItem));
                        }
                        mutableList.add(applyDiff);
                    } else {
                        mutableList.set(i, ReflectionDiffer.INSTANCE.applyDiff(obj, JsonElementKt.getJsonObject(jsonElement2)));
                    }
                }
            }
            insertReplace.invoke(mutableList);
        }
    }

    public final <T> void diffAndUpdateListTable(JsonObject jsonObject, String jsonObjectKey, Function2 listParser, Function0 deleteAll, Function1 deleteList, Function2 insertNewList) throws SerializationException {
        JsonObject jsonObject2;
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(jsonObjectKey, "jsonObjectKey");
        Intrinsics.checkNotNullParameter(listParser, "listParser");
        Intrinsics.checkNotNullParameter(deleteAll, "deleteAll");
        Intrinsics.checkNotNullParameter(deleteList, "deleteList");
        Intrinsics.checkNotNullParameter(insertNewList, "insertNewList");
        if (jsonObject.containsKey((Object) jsonObjectKey)) {
            if (Intrinsics.areEqual(jsonObject.get((Object) jsonObjectKey), JsonNull.INSTANCE)) {
                deleteAll.invoke();
                return;
            }
            JsonElement jsonElement = (JsonElement) jsonObject.get((Object) jsonObjectKey);
            if (jsonElement == null || (jsonObject2 = JsonElementKt.getJsonObject(jsonElement)) == null) {
                throw new IllegalStateException(("no " + jsonObjectKey + " object").toString());
            }
            for (Map.Entry entry : jsonObject2.entrySet()) {
                String str = (String) entry.getKey();
                JsonElement jsonElement2 = (JsonElement) entry.getValue();
                if (jsonElement2 instanceof JsonNull) {
                    deleteList.invoke(str);
                } else {
                    deleteList.invoke(str);
                    insertNewList.invoke(str, (List) listParser.invoke(str, JsonElementKt.getJsonArray(jsonElement2)));
                }
            }
        }
    }

    public final <T> void diffAndUpdateListTable(JsonObject jsonObject, String jsonObjectKey, Function1 listParser, Function0 deleteList, Function1 insertNewList) throws SerializationException {
        JsonArray jsonArray;
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(jsonObjectKey, "jsonObjectKey");
        Intrinsics.checkNotNullParameter(listParser, "listParser");
        Intrinsics.checkNotNullParameter(deleteList, "deleteList");
        Intrinsics.checkNotNullParameter(insertNewList, "insertNewList");
        if (jsonObject.containsKey((Object) jsonObjectKey)) {
            if (Intrinsics.areEqual(jsonObject.get((Object) jsonObjectKey), JsonNull.INSTANCE)) {
                deleteList.invoke();
                return;
            }
            JsonElement jsonElement = (JsonElement) jsonObject.get((Object) jsonObjectKey);
            if (jsonElement == null || (jsonArray = JsonElementKt.getJsonArray(jsonElement)) == null) {
                throw new IllegalStateException(("no " + jsonObjectKey + " array").toString());
            }
            deleteList.invoke();
            insertNewList.invoke((List) listParser.invoke(jsonArray));
        }
    }

    private final void checkDenyList(JsonObject jsonObject, List<String> list) {
        if (list != null) {
            for (String str : list) {
                if (jsonObject.containsKey((Object) str)) {
                    throw new SerializationException(str);
                }
            }
        }
    }
}
