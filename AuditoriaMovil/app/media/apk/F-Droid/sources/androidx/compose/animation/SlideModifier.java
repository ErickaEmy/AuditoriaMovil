package androidx.compose.animation;

import androidx.appcompat.app.ToolbarActionBar$$ExternalSyntheticThrowCCEIfNotNull0;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.State;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: EnterExitTransition.kt */
/* loaded from: classes.dex */
final class SlideModifier extends LayoutModifierWithPassThroughIntrinsics {
    private final Transition.DeferredAnimation lazyAnimation;
    private final State slideIn;
    private final State slideOut;
    private final Function1 transitionSpec;

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

    public final Transition.DeferredAnimation getLazyAnimation() {
        return this.lazyAnimation;
    }

    public final State getSlideIn() {
        return this.slideIn;
    }

    public final State getSlideOut() {
        return this.slideOut;
    }

    public final Function1 getTransitionSpec() {
        return this.transitionSpec;
    }

    public SlideModifier(Transition.DeferredAnimation lazyAnimation, State slideIn, State slideOut) {
        Intrinsics.checkNotNullParameter(lazyAnimation, "lazyAnimation");
        Intrinsics.checkNotNullParameter(slideIn, "slideIn");
        Intrinsics.checkNotNullParameter(slideOut, "slideOut");
        this.lazyAnimation = lazyAnimation;
        this.slideIn = slideIn;
        this.slideOut = slideOut;
        this.transitionSpec = new Function1() { // from class: androidx.compose.animation.SlideModifier$transitionSpec$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final FiniteAnimationSpec invoke(Transition.Segment segment) {
                Intrinsics.checkNotNullParameter(segment, "$this$null");
                EnterExitState enterExitState = EnterExitState.PreEnter;
                EnterExitState enterExitState2 = EnterExitState.Visible;
                if (segment.isTransitioningTo(enterExitState, enterExitState2)) {
                    ToolbarActionBar$$ExternalSyntheticThrowCCEIfNotNull0.m(SlideModifier.this.getSlideIn().getValue());
                    return EnterExitTransitionKt.access$getDefaultOffsetAnimationSpec$p();
                } else if (segment.isTransitioningTo(enterExitState2, EnterExitState.PostExit)) {
                    ToolbarActionBar$$ExternalSyntheticThrowCCEIfNotNull0.m(SlideModifier.this.getSlideOut().getValue());
                    return EnterExitTransitionKt.access$getDefaultOffsetAnimationSpec$p();
                } else {
                    return EnterExitTransitionKt.access$getDefaultOffsetAnimationSpec$p();
                }
            }
        };
    }

    /* renamed from: targetValueByState-oFUgxo0  reason: not valid java name */
    public final long m26targetValueByStateoFUgxo0(EnterExitState targetState, long j) {
        Intrinsics.checkNotNullParameter(targetState, "targetState");
        ToolbarActionBar$$ExternalSyntheticThrowCCEIfNotNull0.m(this.slideIn.getValue());
        IntOffset.Companion companion = IntOffset.Companion;
        long m1942getZeronOccac = companion.m1942getZeronOccac();
        ToolbarActionBar$$ExternalSyntheticThrowCCEIfNotNull0.m(this.slideOut.getValue());
        long m1942getZeronOccac2 = companion.m1942getZeronOccac();
        int i = WhenMappings.$EnumSwitchMapping$0[targetState.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return m1942getZeronOccac2;
                }
                throw new NoWhenBranchMatchedException();
            }
            return m1942getZeronOccac;
        }
        return companion.m1942getZeronOccac();
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo20measure3p2s80s(MeasureScope measure, Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        final Placeable mo1251measureBRTryo0 = measurable.mo1251measureBRTryo0(j);
        final long IntSize = IntSizeKt.IntSize(mo1251measureBRTryo0.getWidth(), mo1251measureBRTryo0.getHeight());
        return MeasureScope.CC.layout$default(measure, mo1251measureBRTryo0.getWidth(), mo1251measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.animation.SlideModifier$measure$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope layout) {
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                Transition.DeferredAnimation lazyAnimation = SlideModifier.this.getLazyAnimation();
                Function1 transitionSpec = SlideModifier.this.getTransitionSpec();
                final SlideModifier slideModifier = SlideModifier.this;
                final long j2 = IntSize;
                Placeable.PlacementScope.m1275placeWithLayeraW9wM$default(layout, mo1251measureBRTryo0, ((IntOffset) lazyAnimation.animate(transitionSpec, new Function1() { // from class: androidx.compose.animation.SlideModifier$measure$1$slideOffset$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return IntOffset.m1929boximpl(m27invokeBjo55l4((EnterExitState) obj));
                    }

                    /* renamed from: invoke-Bjo55l4  reason: not valid java name */
                    public final long m27invokeBjo55l4(EnterExitState it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return SlideModifier.this.m26targetValueByStateoFUgxo0(it, j2);
                    }
                }).getValue()).m1941unboximpl(), 0.0f, null, 6, null);
            }
        }, 4, null);
    }
}
