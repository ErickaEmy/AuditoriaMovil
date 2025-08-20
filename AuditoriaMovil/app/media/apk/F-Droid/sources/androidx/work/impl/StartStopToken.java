package androidx.work.impl;

import androidx.work.impl.model.WorkGenerationalId;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: StartStopToken.kt */
/* loaded from: classes.dex */
public final class StartStopToken {
    private final WorkGenerationalId id;

    public final WorkGenerationalId getId() {
        return this.id;
    }

    public StartStopToken(WorkGenerationalId id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
    }
}
