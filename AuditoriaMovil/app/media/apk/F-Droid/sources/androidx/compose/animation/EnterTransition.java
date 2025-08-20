package androidx.compose.animation;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: EnterExitTransition.kt */
/* loaded from: classes.dex */
public abstract class EnterTransition {
    public static final Companion Companion = new Companion(null);
    private static final EnterTransition None = new EnterTransitionImpl(new TransitionData(null, null, null, null, 15, null));

    /* compiled from: EnterExitTransition.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ EnterTransition(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract TransitionData getData$animation_release();

    private EnterTransition() {
    }

    public final EnterTransition plus(EnterTransition enter) {
        Intrinsics.checkNotNullParameter(enter, "enter");
        Fade fade = getData$animation_release().getFade();
        if (fade == null) {
            fade = enter.getData$animation_release().getFade();
        }
        getData$animation_release().getSlide();
        enter.getData$animation_release().getSlide();
        ChangeSize changeSize = getData$animation_release().getChangeSize();
        if (changeSize == null) {
            changeSize = enter.getData$animation_release().getChangeSize();
        }
        getData$animation_release().getScale();
        enter.getData$animation_release().getScale();
        return new EnterTransitionImpl(new TransitionData(fade, null, changeSize, null));
    }

    public String toString() {
        if (Intrinsics.areEqual(this, None)) {
            return "EnterTransition.None";
        }
        TransitionData data$animation_release = getData$animation_release();
        StringBuilder sb = new StringBuilder();
        sb.append("EnterTransition: \nFade - ");
        Fade fade = data$animation_release.getFade();
        sb.append(fade != null ? fade.toString() : null);
        sb.append(",\nSlide - ");
        data$animation_release.getSlide();
        sb.append((String) null);
        sb.append(",\nShrink - ");
        ChangeSize changeSize = data$animation_release.getChangeSize();
        sb.append(changeSize != null ? changeSize.toString() : null);
        sb.append(",\nScale - ");
        data$animation_release.getScale();
        sb.append((String) null);
        return sb.toString();
    }

    public boolean equals(Object obj) {
        return (obj instanceof EnterTransition) && Intrinsics.areEqual(((EnterTransition) obj).getData$animation_release(), getData$animation_release());
    }

    public int hashCode() {
        return getData$animation_release().hashCode();
    }
}
