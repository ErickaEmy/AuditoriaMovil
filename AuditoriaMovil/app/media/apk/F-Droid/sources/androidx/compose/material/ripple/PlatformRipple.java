package androidx.compose.material.ripple;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Ripple.android.kt */
/* loaded from: classes.dex */
public final class PlatformRipple extends Ripple {
    public /* synthetic */ PlatformRipple(boolean z, float f, State state, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, f, state);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private PlatformRipple(boolean z, float f, State color) {
        super(z, f, color, null);
        Intrinsics.checkNotNullParameter(color, "color");
    }

    @Override // androidx.compose.material.ripple.Ripple
    /* renamed from: rememberUpdatedRippleInstance-942rkJo  reason: not valid java name */
    public RippleIndicationInstance mo586rememberUpdatedRippleInstance942rkJo(InteractionSource interactionSource, boolean z, float f, State color, State rippleAlpha, Composer composer, int i) {
        View view;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(rippleAlpha, "rippleAlpha");
        composer.startReplaceableGroup(331259447);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(331259447, i, -1, "androidx.compose.material.ripple.PlatformRipple.rememberUpdatedRippleInstance (Ripple.android.kt:57)");
        }
        ViewGroup findNearestViewGroup = findNearestViewGroup(composer, (i >> 15) & 14);
        composer.startReplaceableGroup(1643267286);
        if (findNearestViewGroup.isInEditMode()) {
            composer.startReplaceableGroup(511388516);
            boolean changed = composer.changed(interactionSource) | composer.changed(this);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new CommonRippleIndicationInstance(z, f, color, rippleAlpha, null);
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            CommonRippleIndicationInstance commonRippleIndicationInstance = (CommonRippleIndicationInstance) rememberedValue;
            composer.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return commonRippleIndicationInstance;
        }
        composer.endReplaceableGroup();
        int childCount = findNearestViewGroup.getChildCount();
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                view = null;
                break;
            }
            view = findNearestViewGroup.getChildAt(i2);
            if (view instanceof RippleContainer) {
                break;
            }
            i2++;
        }
        if (view == null) {
            Context context = findNearestViewGroup.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            view = new RippleContainer(context);
            findNearestViewGroup.addView(view);
        }
        composer.startReplaceableGroup(1618982084);
        boolean changed2 = composer.changed(interactionSource) | composer.changed(this) | composer.changed(view);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new AndroidRippleIndicationInstance(z, f, color, rippleAlpha, (RippleContainer) view, null);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        AndroidRippleIndicationInstance androidRippleIndicationInstance = (AndroidRippleIndicationInstance) rememberedValue2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return androidRippleIndicationInstance;
    }

    private final ViewGroup findNearestViewGroup(Composer composer, int i) {
        composer.startReplaceableGroup(-1737891121);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1737891121, i, -1, "androidx.compose.material.ripple.PlatformRipple.findNearestViewGroup (Ripple.android.kt:104)");
        }
        Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
        while (!(consume instanceof ViewGroup)) {
            ViewParent parent = ((View) consume).getParent();
            if (!(parent instanceof View)) {
                throw new IllegalArgumentException(("Couldn't find a valid parent for " + consume + ". Are you overriding LocalView and providing a View that is not attached to the view hierarchy?").toString());
            }
            Intrinsics.checkNotNullExpressionValue(parent, "parent");
            consume = parent;
        }
        ViewGroup viewGroup = (ViewGroup) consume;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return viewGroup;
    }
}
