package androidx.compose.foundation.text;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.unit.Dp;
import androidx.room.RoomDatabase;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: TextFieldCursor.kt */
/* loaded from: classes.dex */
public abstract class TextFieldCursorKt {
    private static final AnimationSpec cursorAnimationSpec = AnimationSpecKt.m31infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1() { // from class: androidx.compose.foundation.text.TextFieldCursorKt$cursorAnimationSpec$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((KeyframesSpec.KeyframesSpecConfig) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(KeyframesSpec.KeyframesSpecConfig keyframes) {
            Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
            keyframes.setDurationMillis(1000);
            Float valueOf = Float.valueOf(1.0f);
            keyframes.at(valueOf, 0);
            keyframes.at(valueOf, 499);
            Float valueOf2 = Float.valueOf(0.0f);
            keyframes.at(valueOf2, 500);
            keyframes.at(valueOf2, RoomDatabase.MAX_BIND_PARAMETER_CNT);
        }
    }), null, 0, 6, null);
    private static final float DefaultCursorThickness = Dp.m1897constructorimpl(2);

    public static final float getDefaultCursorThickness() {
        return DefaultCursorThickness;
    }

    public static final Modifier cursor(Modifier modifier, final TextFieldState state, final TextFieldValue value, final OffsetMapping offsetMapping, final Brush cursorBrush, boolean z) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(offsetMapping, "offsetMapping");
        Intrinsics.checkNotNullParameter(cursorBrush, "cursorBrush");
        return z ? ComposedModifierKt.composed$default(modifier, null, new Function3() { // from class: androidx.compose.foundation.text.TextFieldCursorKt$cursor$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            public final Modifier invoke(Modifier composed, Composer composer, int i) {
                Modifier modifier2;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                composer.startReplaceableGroup(1634330012);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1634330012, i, -1, "androidx.compose.foundation.text.cursor.<anonymous> (TextFieldCursor.kt:44)");
                }
                composer.startReplaceableGroup(-492369756);
                Object rememberedValue = composer.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = AnimatableKt.Animatable$default(1.0f, 0.0f, 2, null);
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceableGroup();
                final Animatable animatable = (Animatable) rememberedValue;
                Brush brush = Brush.this;
                boolean z2 = ((brush instanceof SolidColor) && ((SolidColor) brush).m962getValue0d7_KjU() == Color.Companion.m864getUnspecified0d7_KjU()) ? false : true;
                if (state.getHasFocus() && TextRange.m1579getCollapsedimpl(value.m1718getSelectiond9O1mEE()) && z2) {
                    EffectsKt.LaunchedEffect(value.getAnnotatedString(), TextRange.m1573boximpl(value.m1718getSelectiond9O1mEE()), new AnonymousClass1(animatable, null), composer, 512);
                    final OffsetMapping offsetMapping2 = offsetMapping;
                    final TextFieldValue textFieldValue = value;
                    final TextFieldState textFieldState = state;
                    final Brush brush2 = Brush.this;
                    modifier2 = DrawModifierKt.drawWithContent(composed, new Function1() { // from class: androidx.compose.foundation.text.TextFieldCursorKt$cursor$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((ContentDrawScope) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(ContentDrawScope drawWithContent) {
                            float coerceIn;
                            Rect rect;
                            float coerceAtMost;
                            TextLayoutResult value2;
                            Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
                            drawWithContent.drawContent();
                            coerceIn = RangesKt___RangesKt.coerceIn(((Number) Animatable.this.getValue()).floatValue(), 0.0f, 1.0f);
                            if (coerceIn == 0.0f) {
                                return;
                            }
                            int originalToTransformed = offsetMapping2.originalToTransformed(TextRange.m1585getStartimpl(textFieldValue.m1718getSelectiond9O1mEE()));
                            TextLayoutResultProxy layoutResult = textFieldState.getLayoutResult();
                            if (layoutResult == null || (value2 = layoutResult.getValue()) == null || (rect = value2.getCursorRect(originalToTransformed)) == null) {
                                rect = new Rect(0.0f, 0.0f, 0.0f, 0.0f);
                            }
                            float mo155toPx0680j_4 = drawWithContent.mo155toPx0680j_4(TextFieldCursorKt.getDefaultCursorThickness());
                            float f = mo155toPx0680j_4 / 2;
                            coerceAtMost = RangesKt___RangesKt.coerceAtMost(rect.getLeft() + f, Size.m745getWidthimpl(drawWithContent.mo1040getSizeNHjbRc()) - f);
                            DrawScope.CC.m1059drawLine1RTmtNc$default(drawWithContent, brush2, OffsetKt.Offset(coerceAtMost, rect.getTop()), OffsetKt.Offset(coerceAtMost, rect.getBottom()), mo155toPx0680j_4, 0, null, coerceIn, null, 0, 432, null);
                        }
                    });
                } else {
                    modifier2 = Modifier.Companion;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return modifier2;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: TextFieldCursor.kt */
            /* renamed from: androidx.compose.foundation.text.TextFieldCursorKt$cursor$1$1  reason: invalid class name */
            /* loaded from: classes.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2 {
                final /* synthetic */ Animatable $cursorAlpha;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(Animatable animatable, Continuation continuation) {
                    super(2, continuation);
                    this.$cursorAlpha = animatable;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    return new AnonymousClass1(this.$cursorAlpha, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: TextFieldCursor.kt */
                /* renamed from: androidx.compose.foundation.text.TextFieldCursorKt$cursor$1$1$1  reason: invalid class name and collision with other inner class name */
                /* loaded from: classes.dex */
                public static final class C00111 extends SuspendLambda implements Function2 {
                    final /* synthetic */ Animatable $cursorAlpha;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00111(Animatable animatable, Continuation continuation) {
                        super(2, continuation);
                        this.$cursorAlpha = animatable;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object obj, Continuation continuation) {
                        return new C00111(this.$cursorAlpha, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                        return ((C00111) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended;
                        AnimationSpec animationSpec;
                        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Animatable animatable = this.$cursorAlpha;
                            Float boxFloat = Boxing.boxFloat(1.0f);
                            this.label = 1;
                            if (animatable.snapTo(boxFloat, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else if (i != 1) {
                            if (i == 2) {
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            ResultKt.throwOnFailure(obj);
                        }
                        Animatable animatable2 = this.$cursorAlpha;
                        Float boxFloat2 = Boxing.boxFloat(0.0f);
                        animationSpec = TextFieldCursorKt.cursorAnimationSpec;
                        this.label = 2;
                        if (Animatable.animateTo$default(animatable2, boxFloat2, animationSpec, null, null, this, 12, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        FixedMotionDurationScale fixedMotionDurationScale = FixedMotionDurationScale.INSTANCE;
                        C00111 c00111 = new C00111(this.$cursorAlpha, null);
                        this.label = 1;
                        if (BuildersKt.withContext(fixedMotionDurationScale, c00111, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }
        }, 1, null) : modifier;
    }
}
