package androidx.compose.foundation.interaction;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: PressInteraction.kt */
/* loaded from: classes.dex */
public final class PressInteraction$Release implements Interaction {
    private final PressInteraction$Press press;

    public final PressInteraction$Press getPress() {
        return this.press;
    }

    public PressInteraction$Release(PressInteraction$Press press) {
        Intrinsics.checkNotNullParameter(press, "press");
        this.press = press;
    }
}
