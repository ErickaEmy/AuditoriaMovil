package androidx.compose.animation;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: EnterExitTransition.kt */
/* loaded from: classes.dex */
public final class TransitionData {
    private final ChangeSize changeSize;
    private final Fade fade;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TransitionData) {
            TransitionData transitionData = (TransitionData) obj;
            return Intrinsics.areEqual(this.fade, transitionData.fade) && Intrinsics.areEqual((Object) null, (Object) null) && Intrinsics.areEqual(this.changeSize, transitionData.changeSize) && Intrinsics.areEqual((Object) null, (Object) null);
        }
        return false;
    }

    public final ChangeSize getChangeSize() {
        return this.changeSize;
    }

    public final Fade getFade() {
        return this.fade;
    }

    public final Scale getScale() {
        return null;
    }

    public final Slide getSlide() {
        return null;
    }

    public int hashCode() {
        Fade fade = this.fade;
        int hashCode = (fade == null ? 0 : fade.hashCode()) * 961;
        ChangeSize changeSize = this.changeSize;
        return (hashCode + (changeSize != null ? changeSize.hashCode() : 0)) * 31;
    }

    public String toString() {
        return "TransitionData(fade=" + this.fade + ", slide=" + ((Object) null) + ", changeSize=" + this.changeSize + ", scale=" + ((Object) null) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public TransitionData(Fade fade, Slide slide, ChangeSize changeSize, Scale scale) {
        this.fade = fade;
        this.changeSize = changeSize;
    }

    public /* synthetic */ TransitionData(Fade fade, Slide slide, ChangeSize changeSize, Scale scale, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : fade, (i & 2) != 0 ? null : slide, (i & 4) != 0 ? null : changeSize, (i & 8) != 0 ? null : scale);
    }
}
