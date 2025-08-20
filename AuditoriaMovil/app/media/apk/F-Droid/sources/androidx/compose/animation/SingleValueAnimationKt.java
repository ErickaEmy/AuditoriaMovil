package androidx.compose.animation;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import kotlin.jvm.functions.Function1;
/* compiled from: SingleValueAnimation.kt */
/* loaded from: classes.dex */
public abstract class SingleValueAnimationKt {
    private static final SpringSpec colorDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);

    /* renamed from: animateColorAsState-euL9pac  reason: not valid java name */
    public static final State m25animateColorAsStateeuL9pac(long j, AnimationSpec animationSpec, String str, Function1 function1, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-451899108);
        AnimationSpec animationSpec2 = (i2 & 2) != 0 ? colorDefaultSpring : animationSpec;
        String str2 = (i2 & 4) != 0 ? "ColorAnimation" : str;
        Function1 function12 = (i2 & 8) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-451899108, i, -1, "androidx.compose.animation.animateColorAsState (SingleValueAnimation.kt:56)");
        }
        ColorSpace m854getColorSpaceimpl = Color.m854getColorSpaceimpl(j);
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed(m854getColorSpaceimpl);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(Color.m854getColorSpaceimpl(j));
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        int i3 = i << 6;
        State animateValueAsState = AnimateAsStateKt.animateValueAsState(Color.m841boximpl(j), (TwoWayConverter) rememberedValue, animationSpec2, null, str2, function12, composer, (i & 14) | 576 | (57344 & i3) | (i3 & 458752), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return animateValueAsState;
    }
}
