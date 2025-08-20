package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: EnterExitTransition.kt */
/* loaded from: classes.dex */
public abstract class EnterExitTransitionKt {
    private static final TwoWayConverter TransformOriginVectorConverter = VectorConvertersKt.TwoWayConverter(new Function1() { // from class: androidx.compose.animation.EnterExitTransitionKt$TransformOriginVectorConverter$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return m16invoke__ExYCQ(((TransformOrigin) obj).m991unboximpl());
        }

        /* renamed from: invoke-__ExYCQ  reason: not valid java name */
        public final AnimationVector2D m16invoke__ExYCQ(long j) {
            return new AnimationVector2D(TransformOrigin.m987getPivotFractionXimpl(j), TransformOrigin.m988getPivotFractionYimpl(j));
        }
    }, new Function1() { // from class: androidx.compose.animation.EnterExitTransitionKt$TransformOriginVectorConverter$2
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return TransformOrigin.m983boximpl(m17invokeLIALnN8((AnimationVector2D) obj));
        }

        /* renamed from: invoke-LIALnN8  reason: not valid java name */
        public final long m17invokeLIALnN8(AnimationVector2D it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return TransformOriginKt.TransformOrigin(it.getV1(), it.getV2());
        }
    });
    private static final MutableFloatState DefaultAlpha = PrimitiveSnapshotStateKt.mutableFloatStateOf(1.0f);
    private static final SpringSpec DefaultAlphaAndScaleSpring = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
    private static final SpringSpec DefaultOffsetAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m1929boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);
    private static final SpringSpec DefaultSizeAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m1946boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);

    /* compiled from: EnterExitTransition.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EnterExitState.values().length];
            try {
                iArr[EnterExitState.Visible.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnterExitState.PreEnter.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnterExitState.PostExit.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final /* synthetic */ SpringSpec access$getDefaultOffsetAnimationSpec$p() {
        return DefaultOffsetAnimationSpec;
    }

    public static final /* synthetic */ SpringSpec access$getDefaultSizeAnimationSpec$p() {
        return DefaultSizeAnimationSpec;
    }

    private static final boolean createModifier$lambda$1(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    public static final float createModifier$lambda$11(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    public static final long createModifier$lambda$13(State state) {
        return ((TransformOrigin) state.getValue()).m991unboximpl();
    }

    private static final boolean createModifier$lambda$4(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    public static final float createModifier$lambda$8(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    public static /* synthetic */ EnterTransition fadeIn$default(FiniteAnimationSpec finiteAnimationSpec, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return fadeIn(finiteAnimationSpec, f);
    }

    public static final EnterTransition fadeIn(FiniteAnimationSpec animationSpec, float f) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        return new EnterTransitionImpl(new TransitionData(new Fade(f, animationSpec), null, null, null, 14, null));
    }

    public static /* synthetic */ ExitTransition fadeOut$default(FiniteAnimationSpec finiteAnimationSpec, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return fadeOut(finiteAnimationSpec, f);
    }

    public static final ExitTransition fadeOut(FiniteAnimationSpec animationSpec, float f) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        return new ExitTransitionImpl(new TransitionData(new Fade(f, animationSpec), null, null, null, 14, null));
    }

    public static final EnterTransition expandIn(FiniteAnimationSpec animationSpec, Alignment expandFrom, boolean z, Function1 initialSize) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(expandFrom, "expandFrom");
        Intrinsics.checkNotNullParameter(initialSize, "initialSize");
        return new EnterTransitionImpl(new TransitionData(null, null, new ChangeSize(expandFrom, initialSize, animationSpec, z), null, 11, null));
    }

    public static final ExitTransition shrinkOut(FiniteAnimationSpec animationSpec, Alignment shrinkTowards, boolean z, Function1 targetSize) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(shrinkTowards, "shrinkTowards");
        Intrinsics.checkNotNullParameter(targetSize, "targetSize");
        return new ExitTransitionImpl(new TransitionData(null, null, new ChangeSize(shrinkTowards, targetSize, animationSpec, z), null, 11, null));
    }

    public static /* synthetic */ EnterTransition expandVertically$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Vertical vertical, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m1946boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);
        }
        if ((i & 2) != 0) {
            vertical = Alignment.Companion.getBottom();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1() { // from class: androidx.compose.animation.EnterExitTransitionKt$expandVertically$1
                public final Integer invoke(int i2) {
                    return 0;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return invoke(((Number) obj2).intValue());
                }
            };
        }
        return expandVertically(finiteAnimationSpec, vertical, z, function1);
    }

    public static final EnterTransition expandVertically(FiniteAnimationSpec animationSpec, Alignment.Vertical expandFrom, boolean z, final Function1 initialHeight) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(expandFrom, "expandFrom");
        Intrinsics.checkNotNullParameter(initialHeight, "initialHeight");
        return expandIn(animationSpec, toAlignment(expandFrom), z, new Function1() { // from class: androidx.compose.animation.EnterExitTransitionKt$expandVertically$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return IntSize.m1946boximpl(m18invokemzRDjE0(((IntSize) obj).m1954unboximpl()));
            }

            /* renamed from: invoke-mzRDjE0  reason: not valid java name */
            public final long m18invokemzRDjE0(long j) {
                return IntSizeKt.IntSize(IntSize.m1951getWidthimpl(j), ((Number) Function1.this.invoke(Integer.valueOf(IntSize.m1950getHeightimpl(j)))).intValue());
            }
        });
    }

    public static /* synthetic */ ExitTransition shrinkVertically$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Vertical vertical, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m1946boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);
        }
        if ((i & 2) != 0) {
            vertical = Alignment.Companion.getBottom();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkVertically$1
                public final Integer invoke(int i2) {
                    return 0;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return invoke(((Number) obj2).intValue());
                }
            };
        }
        return shrinkVertically(finiteAnimationSpec, vertical, z, function1);
    }

    public static final ExitTransition shrinkVertically(FiniteAnimationSpec animationSpec, Alignment.Vertical shrinkTowards, boolean z, final Function1 targetHeight) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(shrinkTowards, "shrinkTowards");
        Intrinsics.checkNotNullParameter(targetHeight, "targetHeight");
        return shrinkOut(animationSpec, toAlignment(shrinkTowards), z, new Function1() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkVertically$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return IntSize.m1946boximpl(m19invokemzRDjE0(((IntSize) obj).m1954unboximpl()));
            }

            /* renamed from: invoke-mzRDjE0  reason: not valid java name */
            public final long m19invokemzRDjE0(long j) {
                return IntSizeKt.IntSize(IntSize.m1951getWidthimpl(j), ((Number) Function1.this.invoke(Integer.valueOf(IntSize.m1950getHeightimpl(j)))).intValue());
            }
        });
    }

    private static final Alignment toAlignment(Alignment.Vertical vertical) {
        Alignment.Companion companion = Alignment.Companion;
        return Intrinsics.areEqual(vertical, companion.getTop()) ? companion.getTopCenter() : Intrinsics.areEqual(vertical, companion.getBottom()) ? companion.getBottomCenter() : companion.getCenter();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:225:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x021e  */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r30v0, types: [androidx.compose.runtime.Composer, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.ui.Modifier createModifier(androidx.compose.animation.core.Transition r26, final androidx.compose.animation.EnterTransition r27, final androidx.compose.animation.ExitTransition r28, java.lang.String r29, androidx.compose.runtime.Composer r30, int r31) {
        /*
            Method dump skipped, instructions count: 1360
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.EnterExitTransitionKt.createModifier(androidx.compose.animation.core.Transition, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
    }

    private static final void createModifier$lambda$2(MutableState mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final void createModifier$lambda$5(MutableState mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final Modifier slideInOut(Modifier modifier, final Transition transition, final State state, final State state2, final String str) {
        return ComposedModifierKt.composed$default(modifier, null, new Function3() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideInOut$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            private static final boolean invoke$lambda$1(MutableState mutableState) {
                return ((Boolean) mutableState.getValue()).booleanValue();
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            private static final void invoke$lambda$2(MutableState mutableState, boolean z) {
                mutableState.setValue(Boolean.valueOf(z));
            }

            public final Modifier invoke(Modifier composed, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                composer.startReplaceableGroup(158379472);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(158379472, i, -1, "androidx.compose.animation.slideInOut.<anonymous> (EnterExitTransition.kt:949)");
                }
                Transition transition2 = Transition.this;
                composer.startReplaceableGroup(1157296644);
                boolean changed = composer.changed(transition2);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceableGroup();
                MutableState mutableState = (MutableState) rememberedValue;
                if (Transition.this.getCurrentState() == Transition.this.getTargetState() && !Transition.this.isSeeking()) {
                    invoke$lambda$2(mutableState, false);
                } else if (state.getValue() != null || state2.getValue() != null) {
                    invoke$lambda$2(mutableState, true);
                }
                if (invoke$lambda$1(mutableState)) {
                    Transition transition3 = Transition.this;
                    TwoWayConverter vectorConverter = VectorConvertersKt.getVectorConverter(IntOffset.Companion);
                    String str2 = str;
                    composer.startReplaceableGroup(-492369756);
                    Object rememberedValue2 = composer.rememberedValue();
                    Composer.Companion companion = Composer.Companion;
                    if (rememberedValue2 == companion.getEmpty()) {
                        rememberedValue2 = str2 + " slide";
                        composer.updateRememberedValue(rememberedValue2);
                    }
                    composer.endReplaceableGroup();
                    Transition.DeferredAnimation createDeferredAnimation = TransitionKt.createDeferredAnimation(transition3, vectorConverter, (String) rememberedValue2, composer, 448, 0);
                    Transition transition4 = Transition.this;
                    State state3 = state;
                    State state4 = state2;
                    composer.startReplaceableGroup(1157296644);
                    boolean changed2 = composer.changed(transition4);
                    Object rememberedValue3 = composer.rememberedValue();
                    if (changed2 || rememberedValue3 == companion.getEmpty()) {
                        rememberedValue3 = new SlideModifier(createDeferredAnimation, state3, state4);
                        composer.updateRememberedValue(rememberedValue3);
                    }
                    composer.endReplaceableGroup();
                    composed = composed.then((SlideModifier) rememberedValue3);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return composed;
            }
        }, 1, null);
    }

    private static final Modifier shrinkExpand(Modifier modifier, final Transition transition, final State state, final State state2, final String str) {
        return ComposedModifierKt.composed$default(modifier, null, new Function3() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkExpand$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            private static final boolean invoke$lambda$1(MutableState mutableState) {
                return ((Boolean) mutableState.getValue()).booleanValue();
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            private static final void invoke$lambda$2(MutableState mutableState, boolean z) {
                mutableState.setValue(Boolean.valueOf(z));
            }

            /* JADX WARN: Removed duplicated region for block: B:41:0x00e9  */
            /* JADX WARN: Removed duplicated region for block: B:45:0x011b  */
            /* JADX WARN: Removed duplicated region for block: B:48:0x013d  */
            /* JADX WARN: Removed duplicated region for block: B:56:0x01a0  */
            /* JADX WARN: Removed duplicated region for block: B:57:0x01a4  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final androidx.compose.ui.Modifier invoke(androidx.compose.ui.Modifier r21, androidx.compose.runtime.Composer r22, int r23) {
                /*
                    Method dump skipped, instructions count: 506
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.EnterExitTransitionKt$shrinkExpand$1.invoke(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
            }
        }, 1, null);
    }
}
