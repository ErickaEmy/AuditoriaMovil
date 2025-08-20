package androidx.work.impl.model;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: WorkTag.kt */
/* loaded from: classes.dex */
public final class WorkTag {
    private final String tag;
    private final String workSpecId;

    public final String getTag() {
        return this.tag;
    }

    public final String getWorkSpecId() {
        return this.workSpecId;
    }

    public WorkTag(String tag, String workSpecId) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(workSpecId, "workSpecId");
        this.tag = tag;
        this.workSpecId = workSpecId;
    }
}
