package androidx.compose.foundation.interaction;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: HoverInteraction.kt */
/* loaded from: classes.dex */
public final class HoverInteraction$Exit implements Interaction {
    private final HoverInteraction$Enter enter;

    public final HoverInteraction$Enter getEnter() {
        return this.enter;
    }

    public HoverInteraction$Exit(HoverInteraction$Enter enter) {
        Intrinsics.checkNotNullParameter(enter, "enter");
        this.enter = enter;
    }
}
