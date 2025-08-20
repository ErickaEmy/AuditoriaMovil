package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: EnterExitTransition.kt */
/* loaded from: classes.dex */
final class ExpandShrinkModifier extends LayoutModifierWithPassThroughIntrinsics {
    private final State alignment;
    private Alignment currentAlignment;
    private final State expand;
    private final Transition.DeferredAnimation offsetAnimation;
    private final State shrink;
    private final Transition.DeferredAnimation sizeAnimation;
    private final Function1 sizeTransitionSpec;

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

    public final Alignment getCurrentAlignment() {
        return this.currentAlignment;
    }

    public final State getExpand() {
        return this.expand;
    }

    public final State getShrink() {
        return this.shrink;
    }

    public final void setCurrentAlignment(Alignment alignment) {
        this.currentAlignment = alignment;
    }

    public ExpandShrinkModifier(Transition.DeferredAnimation sizeAnimation, Transition.DeferredAnimation offsetAnimation, State expand, State shrink, State alignment) {
        Intrinsics.checkNotNullParameter(sizeAnimation, "sizeAnimation");
        Intrinsics.checkNotNullParameter(offsetAnimation, "offsetAnimation");
        Intrinsics.checkNotNullParameter(expand, "expand");
        Intrinsics.checkNotNullParameter(shrink, "shrink");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        this.sizeAnimation = sizeAnimation;
        this.offsetAnimation = offsetAnimation;
        this.expand = expand;
        this.shrink = shrink;
        this.alignment = alignment;
        this.sizeTransitionSpec = new Function1() { // from class: androidx.compose.animation.ExpandShrinkModifier$sizeTransitionSpec$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final FiniteAnimationSpec invoke(Transition.Segment segment) {
                Intrinsics.checkNotNullParameter(segment, "$this$null");
                EnterExitState enterExitState = EnterExitState.PreEnter;
                EnterExitState enterExitState2 = EnterExitState.Visible;
                FiniteAnimationSpec finiteAnimationSpec = null;
                if (segment.isTransitioningTo(enterExitState, enterExitState2)) {
                    ChangeSize changeSize = (ChangeSize) ExpandShrinkModifier.this.getExpand().getValue();
                    if (changeSize != null) {
                        finiteAnimationSpec = changeSize.getAnimationSpec();
                    }
                } else if (segment.isTransitioningTo(enterExitState2, EnterExitState.PostExit)) {
                    ChangeSize changeSize2 = (ChangeSize) ExpandShrinkModifier.this.getShrink().getValue();
                    if (changeSize2 != null) {
                        finiteAnimationSpec = changeSize2.getAnimationSpec();
                    }
                } else {
                    finiteAnimationSpec = EnterExitTransitionKt.access$getDefaultSizeAnimationSpec$p();
                }
                return finiteAnimationSpec == null ? EnterExitTransitionKt.access$getDefaultSizeAnimationSpec$p() : finiteAnimationSpec;
            }
        };
    }

    /* renamed from: sizeByState-Uzc_VyU  reason: not valid java name */
    public final long m21sizeByStateUzc_VyU(EnterExitState targetState, long j) {
        Intrinsics.checkNotNullParameter(targetState, "targetState");
        ChangeSize changeSize = (ChangeSize) this.expand.getValue();
        long m1954unboximpl = changeSize != null ? ((IntSize) changeSize.getSize().invoke(IntSize.m1946boximpl(j))).m1954unboximpl() : j;
        ChangeSize changeSize2 = (ChangeSize) this.shrink.getValue();
        long m1954unboximpl2 = changeSize2 != null ? ((IntSize) changeSize2.getSize().invoke(IntSize.m1946boximpl(j))).m1954unboximpl() : j;
        int i = WhenMappings.$EnumSwitchMapping$0[targetState.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return m1954unboximpl2;
                }
                throw new NoWhenBranchMatchedException();
            }
            return m1954unboximpl;
        }
        return j;
    }

    /* renamed from: targetOffsetByState-oFUgxo0  reason: not valid java name */
    public final long m22targetOffsetByStateoFUgxo0(EnterExitState targetState, long j) {
        Intrinsics.checkNotNullParameter(targetState, "targetState");
        if (this.currentAlignment == null) {
            return IntOffset.Companion.m1942getZeronOccac();
        }
        if (this.alignment.getValue() != null && !Intrinsics.areEqual(this.currentAlignment, this.alignment.getValue())) {
            int i = WhenMappings.$EnumSwitchMapping$0[targetState.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        ChangeSize changeSize = (ChangeSize) this.shrink.getValue();
                        if (changeSize != null) {
                            long m1954unboximpl = ((IntSize) changeSize.getSize().invoke(IntSize.m1946boximpl(j))).m1954unboximpl();
                            Object value = this.alignment.getValue();
                            Intrinsics.checkNotNull(value);
                            Alignment alignment = (Alignment) value;
                            LayoutDirection layoutDirection = LayoutDirection.Ltr;
                            long mo636alignKFBX0sM = alignment.mo636alignKFBX0sM(j, m1954unboximpl, layoutDirection);
                            Alignment alignment2 = this.currentAlignment;
                            Intrinsics.checkNotNull(alignment2);
                            long mo636alignKFBX0sM2 = alignment2.mo636alignKFBX0sM(j, m1954unboximpl, layoutDirection);
                            return IntOffsetKt.IntOffset(IntOffset.m1937getXimpl(mo636alignKFBX0sM) - IntOffset.m1937getXimpl(mo636alignKFBX0sM2), IntOffset.m1938getYimpl(mo636alignKFBX0sM) - IntOffset.m1938getYimpl(mo636alignKFBX0sM2));
                        }
                        return IntOffset.Companion.m1942getZeronOccac();
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return IntOffset.Companion.m1942getZeronOccac();
            }
            return IntOffset.Companion.m1942getZeronOccac();
        }
        return IntOffset.Companion.m1942getZeronOccac();
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult mo20measure3p2s80s(MeasureScope measure, Measurable measurable, long j) {
        final long m1942getZeronOccac;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        final Placeable mo1251measureBRTryo0 = measurable.mo1251measureBRTryo0(j);
        final long IntSize = IntSizeKt.IntSize(mo1251measureBRTryo0.getWidth(), mo1251measureBRTryo0.getHeight());
        long m1954unboximpl = ((IntSize) this.sizeAnimation.animate(this.sizeTransitionSpec, new Function1() { // from class: androidx.compose.animation.ExpandShrinkModifier$measure$currentSize$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return IntSize.m1946boximpl(m23invokeYEO4UFw((EnterExitState) obj));
            }

            /* renamed from: invoke-YEO4UFw  reason: not valid java name */
            public final long m23invokeYEO4UFw(EnterExitState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return ExpandShrinkModifier.this.m21sizeByStateUzc_VyU(it, IntSize);
            }
        }).getValue()).m1954unboximpl();
        final long m1941unboximpl = ((IntOffset) this.offsetAnimation.animate(new Function1() { // from class: androidx.compose.animation.ExpandShrinkModifier$measure$offsetDelta$1
            @Override // kotlin.jvm.functions.Function1
            public final FiniteAnimationSpec invoke(Transition.Segment animate) {
                Intrinsics.checkNotNullParameter(animate, "$this$animate");
                return EnterExitTransitionKt.access$getDefaultOffsetAnimationSpec$p();
            }
        }, new Function1() { // from class: androidx.compose.animation.ExpandShrinkModifier$measure$offsetDelta$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return IntOffset.m1929boximpl(m24invokeBjo55l4((EnterExitState) obj));
            }

            /* renamed from: invoke-Bjo55l4  reason: not valid java name */
            public final long m24invokeBjo55l4(EnterExitState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return ExpandShrinkModifier.this.m22targetOffsetByStateoFUgxo0(it, IntSize);
            }
        }).getValue()).m1941unboximpl();
        Alignment alignment = this.currentAlignment;
        if (alignment != null) {
            m1942getZeronOccac = alignment.mo636alignKFBX0sM(IntSize, m1954unboximpl, LayoutDirection.Ltr);
        } else {
            m1942getZeronOccac = IntOffset.Companion.m1942getZeronOccac();
        }
        return MeasureScope.CC.layout$default(measure, IntSize.m1951getWidthimpl(m1954unboximpl), IntSize.m1950getHeightimpl(m1954unboximpl), null, new Function1() { // from class: androidx.compose.animation.ExpandShrinkModifier$measure$1
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
                Placeable.PlacementScope.place$default(layout, Placeable.this, IntOffset.m1937getXimpl(m1942getZeronOccac) + IntOffset.m1937getXimpl(m1941unboximpl), IntOffset.m1938getYimpl(m1942getZeronOccac) + IntOffset.m1938getYimpl(m1941unboximpl), 0.0f, 4, null);
            }
        }, 4, null);
    }
}
