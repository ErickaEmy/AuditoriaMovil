package androidx.work.impl.model;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: SystemIdInfo.kt */
/* loaded from: classes.dex */
public abstract class SystemIdInfoKt {
    public static final SystemIdInfo systemIdInfo(WorkGenerationalId generationalId, int i) {
        Intrinsics.checkNotNullParameter(generationalId, "generationalId");
        return new SystemIdInfo(generationalId.getWorkSpecId(), generationalId.getGeneration(), i);
    }
}
