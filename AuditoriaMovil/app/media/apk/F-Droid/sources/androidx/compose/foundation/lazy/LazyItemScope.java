package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.IntOffset;
/* compiled from: LazyItemScope.kt */
/* loaded from: classes.dex */
public interface LazyItemScope {
    Modifier animateItemPlacement(Modifier modifier, FiniteAnimationSpec finiteAnimationSpec);

    /* compiled from: LazyItemScope.kt */
    /* renamed from: androidx.compose.foundation.lazy.LazyItemScope$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
        public static /* synthetic */ Modifier animateItemPlacement$default(LazyItemScope lazyItemScope, Modifier modifier, FiniteAnimationSpec finiteAnimationSpec, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m1929boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);
                }
                return lazyItemScope.animateItemPlacement(modifier, finiteAnimationSpec);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateItemPlacement");
        }
    }
}
