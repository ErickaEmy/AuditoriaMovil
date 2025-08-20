package androidx.compose.foundation.interaction;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: DragInteraction.kt */
/* loaded from: classes.dex */
public final class DragInteraction$Stop implements Interaction {
    private final DragInteraction$Start start;

    public final DragInteraction$Start getStart() {
        return this.start;
    }

    public DragInteraction$Stop(DragInteraction$Start start) {
        Intrinsics.checkNotNullParameter(start, "start");
        this.start = start;
    }
}
