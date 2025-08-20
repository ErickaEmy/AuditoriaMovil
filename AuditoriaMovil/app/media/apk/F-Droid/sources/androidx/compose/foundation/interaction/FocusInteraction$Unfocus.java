package androidx.compose.foundation.interaction;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: FocusInteraction.kt */
/* loaded from: classes.dex */
public final class FocusInteraction$Unfocus implements Interaction {
    private final FocusInteraction$Focus focus;

    public final FocusInteraction$Focus getFocus() {
        return this.focus;
    }

    public FocusInteraction$Unfocus(FocusInteraction$Focus focus) {
        Intrinsics.checkNotNullParameter(focus, "focus");
        this.focus = focus;
    }
}
