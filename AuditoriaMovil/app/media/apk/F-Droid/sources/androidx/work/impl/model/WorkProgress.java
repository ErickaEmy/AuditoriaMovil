package androidx.work.impl.model;

import androidx.work.Data;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: WorkProgress.kt */
/* loaded from: classes.dex */
public final class WorkProgress {
    private final Data progress;
    private final String workSpecId;

    public final Data getProgress() {
        return this.progress;
    }

    public final String getWorkSpecId() {
        return this.workSpecId;
    }

    public WorkProgress(String workSpecId, Data progress) {
        Intrinsics.checkNotNullParameter(workSpecId, "workSpecId");
        Intrinsics.checkNotNullParameter(progress, "progress");
        this.workSpecId = workSpecId;
        this.progress = progress;
    }
}
