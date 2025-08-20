package androidx.compose.foundation;

import android.content.Context;
import android.os.Build;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidOverscroll.kt */
/* loaded from: classes.dex */
public abstract class AndroidOverscrollKt {
    private static final Modifier StretchOverscrollNonClippingLayer;

    public static final OverscrollEffect rememberOverscrollEffect(Composer composer, int i) {
        OverscrollEffect overscrollEffect;
        composer.startReplaceableGroup(-81138291);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-81138291, i, -1, "androidx.compose.foundation.rememberOverscrollEffect (AndroidOverscroll.kt:62)");
        }
        Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        OverscrollConfiguration overscrollConfiguration = (OverscrollConfiguration) composer.consume(OverscrollConfigurationKt.getLocalOverscrollConfiguration());
        if (overscrollConfiguration != null) {
            composer.startReplaceableGroup(511388516);
            boolean changed = composer.changed(context) | composer.changed(overscrollConfiguration);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new AndroidEdgeEffectOverscrollEffect(context, overscrollConfiguration);
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            overscrollEffect = (OverscrollEffect) rememberedValue;
        } else {
            overscrollEffect = NoOpOverscrollEffect.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return overscrollEffect;
    }

    static {
        Modifier modifier;
        if (Build.VERSION.SDK_INT >= 31) {
            modifier = LayoutModifierKt.layout(LayoutModifierKt.layout(Modifier.Companion, new Function3() { // from class: androidx.compose.foundation.AndroidOverscrollKt$StretchOverscrollNonClippingLayer$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return m74invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).m1877unboximpl());
                }

                /* renamed from: invoke-3p2s80s  reason: not valid java name */
                public final MeasureResult m74invoke3p2s80s(MeasureScope layout, Measurable measurable, long j) {
                    Intrinsics.checkNotNullParameter(layout, "$this$layout");
                    Intrinsics.checkNotNullParameter(measurable, "measurable");
                    final Placeable mo1251measureBRTryo0 = measurable.mo1251measureBRTryo0(j);
                    final int mo150roundToPx0680j_4 = layout.mo150roundToPx0680j_4(Dp.m1897constructorimpl(ClipScrollableContainerKt.getMaxSupportedElevation() * 2));
                    return MeasureScope.CC.layout$default(layout, mo1251measureBRTryo0.getMeasuredWidth() - mo150roundToPx0680j_4, mo1251measureBRTryo0.getMeasuredHeight() - mo150roundToPx0680j_4, null, new Function1() { // from class: androidx.compose.foundation.AndroidOverscrollKt$StretchOverscrollNonClippingLayer$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((Placeable.PlacementScope) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Placeable.PlacementScope layout2) {
                            Intrinsics.checkNotNullParameter(layout2, "$this$layout");
                            Placeable placeable = Placeable.this;
                            Placeable.PlacementScope.placeWithLayer$default(layout2, placeable, ((-mo150roundToPx0680j_4) / 2) - ((placeable.getWidth() - Placeable.this.getMeasuredWidth()) / 2), ((-mo150roundToPx0680j_4) / 2) - ((Placeable.this.getHeight() - Placeable.this.getMeasuredHeight()) / 2), 0.0f, null, 12, null);
                        }
                    }, 4, null);
                }
            }), new Function3() { // from class: androidx.compose.foundation.AndroidOverscrollKt$StretchOverscrollNonClippingLayer$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return m75invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).m1877unboximpl());
                }

                /* renamed from: invoke-3p2s80s  reason: not valid java name */
                public final MeasureResult m75invoke3p2s80s(MeasureScope layout, Measurable measurable, long j) {
                    Intrinsics.checkNotNullParameter(layout, "$this$layout");
                    Intrinsics.checkNotNullParameter(measurable, "measurable");
                    final Placeable mo1251measureBRTryo0 = measurable.mo1251measureBRTryo0(j);
                    final int mo150roundToPx0680j_4 = layout.mo150roundToPx0680j_4(Dp.m1897constructorimpl(ClipScrollableContainerKt.getMaxSupportedElevation() * 2));
                    return MeasureScope.CC.layout$default(layout, mo1251measureBRTryo0.getWidth() + mo150roundToPx0680j_4, mo1251measureBRTryo0.getHeight() + mo150roundToPx0680j_4, null, new Function1() { // from class: androidx.compose.foundation.AndroidOverscrollKt$StretchOverscrollNonClippingLayer$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((Placeable.PlacementScope) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Placeable.PlacementScope layout2) {
                            Intrinsics.checkNotNullParameter(layout2, "$this$layout");
                            Placeable placeable = Placeable.this;
                            int i = mo150roundToPx0680j_4;
                            Placeable.PlacementScope.place$default(layout2, placeable, i / 2, i / 2, 0.0f, 4, null);
                        }
                    }, 4, null);
                }
            });
        } else {
            modifier = Modifier.Companion;
        }
        StretchOverscrollNonClippingLayer = modifier;
    }
}
