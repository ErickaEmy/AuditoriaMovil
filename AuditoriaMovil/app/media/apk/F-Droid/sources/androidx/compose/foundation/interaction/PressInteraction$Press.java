package androidx.compose.foundation.interaction;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: PressInteraction.kt */
/* loaded from: classes.dex */
public final class PressInteraction$Press implements Interaction {
    private final long pressPosition;

    public /* synthetic */ PressInteraction$Press(long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(j);
    }

    /* renamed from: getPressPosition-F1C5BW0  reason: not valid java name */
    public final long m179getPressPositionF1C5BW0() {
        return this.pressPosition;
    }

    private PressInteraction$Press(long j) {
        this.pressPosition = j;
    }
}
