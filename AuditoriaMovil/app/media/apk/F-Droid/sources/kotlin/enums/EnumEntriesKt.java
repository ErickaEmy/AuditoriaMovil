package kotlin.enums;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: EnumEntries.kt */
/* loaded from: classes.dex */
public abstract class EnumEntriesKt {
    public static final EnumEntries enumEntries(Enum[] entries) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        return new EnumEntriesList(entries);
    }
}
