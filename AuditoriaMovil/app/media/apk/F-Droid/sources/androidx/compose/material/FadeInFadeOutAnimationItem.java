package androidx.compose.material;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SnackbarHost.kt */
/* loaded from: classes.dex */
final class FadeInFadeOutAnimationItem {
    private final Object key;
    private final Function3 transition;

    public final Object component1() {
        return this.key;
    }

    public final Function3 component2() {
        return this.transition;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FadeInFadeOutAnimationItem) {
            FadeInFadeOutAnimationItem fadeInFadeOutAnimationItem = (FadeInFadeOutAnimationItem) obj;
            return Intrinsics.areEqual(this.key, fadeInFadeOutAnimationItem.key) && Intrinsics.areEqual(this.transition, fadeInFadeOutAnimationItem.transition);
        }
        return false;
    }

    public final Object getKey() {
        return this.key;
    }

    public int hashCode() {
        Object obj = this.key;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.transition.hashCode();
    }

    public String toString() {
        return "FadeInFadeOutAnimationItem(key=" + this.key + ", transition=" + this.transition + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public FadeInFadeOutAnimationItem(Object obj, Function3 transition) {
        Intrinsics.checkNotNullParameter(transition, "transition");
        this.key = obj;
        this.transition = transition;
    }
}
