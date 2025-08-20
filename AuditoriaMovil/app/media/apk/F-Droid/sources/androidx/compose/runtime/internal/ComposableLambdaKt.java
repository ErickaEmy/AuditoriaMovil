package androidx.compose.runtime.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImpl;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ComposableLambda.kt */
/* loaded from: classes.dex */
public abstract class ComposableLambdaKt {
    public static final int bitsForSlot(int i, int i2) {
        return i << (((i2 % 10) * 3) + 1);
    }

    public static final int sameBits(int i) {
        return bitsForSlot(1, i);
    }

    public static final int differentBits(int i) {
        return bitsForSlot(2, i);
    }

    public static final boolean replacableWith(RecomposeScope recomposeScope, RecomposeScope other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (recomposeScope != null) {
            if ((recomposeScope instanceof RecomposeScopeImpl) && (other instanceof RecomposeScopeImpl)) {
                RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) recomposeScope;
                if (!recomposeScopeImpl.getValid() || Intrinsics.areEqual(recomposeScope, other) || Intrinsics.areEqual(recomposeScopeImpl.getAnchor(), ((RecomposeScopeImpl) other).getAnchor())) {
                }
            }
            return false;
        }
        return true;
    }

    public static final ComposableLambda composableLambda(Composer composer, int i, boolean z, Object block) {
        ComposableLambdaImpl composableLambdaImpl;
        Intrinsics.checkNotNullParameter(composer, "composer");
        Intrinsics.checkNotNullParameter(block, "block");
        composer.startReplaceableGroup(i);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            composableLambdaImpl = new ComposableLambdaImpl(i, z);
            composer.updateRememberedValue(composableLambdaImpl);
        } else {
            Intrinsics.checkNotNull(rememberedValue, "null cannot be cast to non-null type androidx.compose.runtime.internal.ComposableLambdaImpl");
            composableLambdaImpl = (ComposableLambdaImpl) rememberedValue;
        }
        composableLambdaImpl.update(block);
        composer.endReplaceableGroup();
        return composableLambdaImpl;
    }

    public static final ComposableLambda composableLambdaInstance(int i, boolean z, Object block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ComposableLambdaImpl composableLambdaImpl = new ComposableLambdaImpl(i, z);
        composableLambdaImpl.update(block);
        return composableLambdaImpl;
    }
}
