package androidx.compose.animation.core;

import androidx.appcompat.app.ToolbarActionBar$$ExternalSyntheticThrowCCEIfNotNull0;
import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.ui.platform.InfiniteAnimationPolicy;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
/* compiled from: InfiniteAnimationPolicy.kt */
/* loaded from: classes.dex */
public abstract class InfiniteAnimationPolicyKt {
    public static final Object withInfiniteAnimationFrameNanos(Function1 function1, Continuation continuation) {
        ToolbarActionBar$$ExternalSyntheticThrowCCEIfNotNull0.m(continuation.getContext().get(InfiniteAnimationPolicy.Key));
        return MonotonicFrameClockKt.withFrameNanos(function1, continuation);
    }
}
