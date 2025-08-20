package org.fdroid.database;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: AppDao.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lorg/fdroid/database/AppListSortOrder;", "", "(Ljava/lang/String;I)V", "LAST_UPDATED", "NAME", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AppListSortOrder {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AppListSortOrder[] $VALUES;
    public static final AppListSortOrder LAST_UPDATED = new AppListSortOrder("LAST_UPDATED", 0);
    public static final AppListSortOrder NAME = new AppListSortOrder("NAME", 1);

    private static final /* synthetic */ AppListSortOrder[] $values() {
        return new AppListSortOrder[]{LAST_UPDATED, NAME};
    }

    public static EnumEntries getEntries() {
        return $ENTRIES;
    }

    public static AppListSortOrder valueOf(String str) {
        return (AppListSortOrder) Enum.valueOf(AppListSortOrder.class, str);
    }

    public static AppListSortOrder[] values() {
        return (AppListSortOrder[]) $VALUES.clone();
    }

    private AppListSortOrder(String str, int i) {
    }

    static {
        AppListSortOrder[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
