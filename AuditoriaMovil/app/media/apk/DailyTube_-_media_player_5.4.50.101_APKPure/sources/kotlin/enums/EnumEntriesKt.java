package kotlin.enums;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class EnumEntriesKt {
    public static final <E extends Enum<E>> EnumEntries<E> enumEntries(E[] entries) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        return new EnumEntriesList(entries);
    }
}
