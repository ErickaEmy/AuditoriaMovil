package androidx.compose.animation;

import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EnterExitTransition.kt */
/* loaded from: classes.dex */
public final class EnterTransitionImpl extends EnterTransition {
    private final TransitionData data;

    @Override // androidx.compose.animation.EnterTransition
    public TransitionData getData$animation_release() {
        return this.data;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnterTransitionImpl(TransitionData data) {
        super(null);
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }
}
