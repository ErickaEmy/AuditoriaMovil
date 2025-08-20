package org.fdroid.database;

import androidx.lifecycle.LiveData;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsJVMKt;
import org.fdroid.database.AppDaoInt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppDao.kt */
/* loaded from: classes2.dex */
public final class AppDaoInt$AppListLiveData$addSource$1 extends Lambda implements Function1 {
    final /* synthetic */ AppDaoInt.AppListLiveData this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppDaoInt$AppListLiveData$addSource$1(AppDaoInt.AppListLiveData appListLiveData) {
        super(1);
        this.this$0 = appListLiveData;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(List list) {
        ArrayList<LiveData> arrayList;
        List sortedWith;
        arrayList = this.this$0.list;
        ArrayList arrayList2 = new ArrayList();
        boolean z = true;
        for (LiveData liveData : arrayList) {
            List list2 = (List) liveData.getValue();
            if (list2 == null) {
                list2 = CollectionsKt__CollectionsKt.emptyList();
                z = false;
            }
            Intrinsics.checkNotNull(list2);
            CollectionsKt__MutableCollectionsKt.addAll(arrayList2, list2);
        }
        if (z) {
            AppDaoInt.AppListLiveData appListLiveData = this.this$0;
            final AnonymousClass1 anonymousClass1 = new Function2() { // from class: org.fdroid.database.AppDaoInt$AppListLiveData$addSource$1.1
                @Override // kotlin.jvm.functions.Function2
                public final Integer invoke(AppListItem appListItem, AppListItem appListItem2) {
                    int compareTo;
                    String name = appListItem.getName();
                    if (name == null) {
                        name = "";
                    }
                    String name2 = appListItem2.getName();
                    compareTo = StringsKt__StringsJVMKt.compareTo(name, name2 != null ? name2 : "", true);
                    return Integer.valueOf(compareTo);
                }
            };
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: org.fdroid.database.AppDaoInt$AppListLiveData$addSource$1$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int invoke$lambda$2;
                    invoke$lambda$2 = AppDaoInt$AppListLiveData$addSource$1.invoke$lambda$2(Function2.this, obj, obj2);
                    return invoke$lambda$2;
                }
            });
            appListLiveData.setValue(sortedWith);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int invoke$lambda$2(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }
}
