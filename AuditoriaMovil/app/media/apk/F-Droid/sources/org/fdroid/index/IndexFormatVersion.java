package org.fdroid.index;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: IndexUpdater.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lorg/fdroid/index/IndexFormatVersion;", "", "(Ljava/lang/String;I)V", "ONE", "TWO", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class IndexFormatVersion {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ IndexFormatVersion[] $VALUES;
    public static final IndexFormatVersion ONE = new IndexFormatVersion("ONE", 0);
    public static final IndexFormatVersion TWO = new IndexFormatVersion("TWO", 1);

    private static final /* synthetic */ IndexFormatVersion[] $values() {
        return new IndexFormatVersion[]{ONE, TWO};
    }

    public static EnumEntries getEntries() {
        return $ENTRIES;
    }

    public static IndexFormatVersion valueOf(String str) {
        return (IndexFormatVersion) Enum.valueOf(IndexFormatVersion.class, str);
    }

    public static IndexFormatVersion[] values() {
        return (IndexFormatVersion[]) $VALUES.clone();
    }

    static {
        IndexFormatVersion[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private IndexFormatVersion(String str, int i) {
    }
}
