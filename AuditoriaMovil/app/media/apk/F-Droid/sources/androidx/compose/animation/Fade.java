package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: EnterExitTransition.kt */
/* loaded from: classes.dex */
public final class Fade {
    private final float alpha;
    private final FiniteAnimationSpec animationSpec;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Fade) {
            Fade fade = (Fade) obj;
            return Float.compare(this.alpha, fade.alpha) == 0 && Intrinsics.areEqual(this.animationSpec, fade.animationSpec);
        }
        return false;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final FiniteAnimationSpec getAnimationSpec() {
        return this.animationSpec;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.alpha) * 31) + this.animationSpec.hashCode();
    }

    public String toString() {
        return "Fade(alpha=" + this.alpha + ", animationSpec=" + this.animationSpec + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public Fade(float f, FiniteAnimationSpec animationSpec) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        this.alpha = f;
        this.animationSpec = animationSpec;
    }
}
