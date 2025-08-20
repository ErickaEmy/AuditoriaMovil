package androidx.compose.foundation;

import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$LongRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Magnifier.kt */
/* loaded from: classes.dex */
public final class MagnifierKt$magnifier$4 extends Lambda implements Function3 {
    final /* synthetic */ Function1 $magnifierCenter;
    final /* synthetic */ Function1 $onSizeChanged;
    final /* synthetic */ PlatformMagnifierFactory $platformMagnifierFactory;
    final /* synthetic */ Function1 $sourceCenter;
    final /* synthetic */ MagnifierStyle $style;
    final /* synthetic */ float $zoom;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagnifierKt$magnifier$4(Function1 function1, Function1 function12, float f, Function1 function13, PlatformMagnifierFactory platformMagnifierFactory, MagnifierStyle magnifierStyle) {
        super(3);
        this.$sourceCenter = function1;
        this.$magnifierCenter = function12;
        this.$zoom = f;
        this.$onSizeChanged = function13;
        this.$platformMagnifierFactory = platformMagnifierFactory;
        this.$style = magnifierStyle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long invoke$lambda$1(MutableState mutableState) {
        return ((Offset) mutableState.getValue()).m718unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$10(State state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1 invoke$lambda$3(State state) {
        return (Function1) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1 invoke$lambda$4(State state) {
        return (Function1) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float invoke$lambda$5(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1 invoke$lambda$6(State state) {
        return (Function1) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long invoke$lambda$8(State state) {
        return ((Offset) state.getValue()).m718unboximpl();
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final Modifier invoke(Modifier composed, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(composed, "$this$composed");
        composer.startReplaceableGroup(-454877003);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-454877003, i, -1, "androidx.compose.foundation.magnifier.<anonymous> (Magnifier.kt:270)");
        }
        View view = (View) composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
        final Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m698boximpl(Offset.Companion.m720getUnspecifiedF1C5BW0()), null, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue;
        final State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(this.$sourceCenter, composer, 0);
        State rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(this.$magnifierCenter, composer, 0);
        State rememberUpdatedState3 = SnapshotStateKt.rememberUpdatedState(Float.valueOf(this.$zoom), composer, 0);
        State rememberUpdatedState4 = SnapshotStateKt.rememberUpdatedState(this.$onSizeChanged, composer, 0);
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.foundation.MagnifierKt$magnifier$4$sourceCenterInRoot$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    return Offset.m698boximpl(m110invokeF1C5BW0());
                }

                /* renamed from: invoke-F1C5BW0  reason: not valid java name */
                public final long m110invokeF1C5BW0() {
                    Function1 invoke$lambda$3;
                    invoke$lambda$3 = MagnifierKt$magnifier$4.invoke$lambda$3(rememberUpdatedState);
                    long m718unboximpl = ((Offset) invoke$lambda$3.invoke(Density.this)).m718unboximpl();
                    if (OffsetKt.m723isSpecifiedk4lQ0M(MagnifierKt$magnifier$4.invoke$lambda$1(mutableState)) && OffsetKt.m723isSpecifiedk4lQ0M(m718unboximpl)) {
                        return Offset.m714plusMKHz9U(MagnifierKt$magnifier$4.invoke$lambda$1(mutableState), m718unboximpl);
                    }
                    return Offset.Companion.m720getUnspecifiedF1C5BW0();
                }
            });
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        final State state = (State) rememberedValue2;
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
            rememberedValue3 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.foundation.MagnifierKt$magnifier$4$isMagnifierShown$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.valueOf(OffsetKt.m723isSpecifiedk4lQ0M(MagnifierKt$magnifier$4.invoke$lambda$8(State.this)));
                }
            });
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceableGroup();
        State state2 = (State) rememberedValue3;
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue4 = composer.rememberedValue();
        if (rememberedValue4 == companion.getEmpty()) {
            rememberedValue4 = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, null);
            composer.updateRememberedValue(rememberedValue4);
        }
        composer.endReplaceableGroup();
        final MutableSharedFlow mutableSharedFlow = (MutableSharedFlow) rememberedValue4;
        float f = this.$platformMagnifierFactory.getCanUpdateZoom() ? 0.0f : this.$zoom;
        MagnifierStyle magnifierStyle = this.$style;
        EffectsKt.LaunchedEffect(new Object[]{view, density, Float.valueOf(f), magnifierStyle, Boolean.valueOf(Intrinsics.areEqual(magnifierStyle, MagnifierStyle.Companion.getTextDefault()))}, (Function2) new AnonymousClass1(this.$platformMagnifierFactory, this.$style, view, density, this.$zoom, mutableSharedFlow, rememberUpdatedState4, state2, state, rememberUpdatedState2, mutableState, rememberUpdatedState3, null), composer, 72);
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed(mutableState);
        Object rememberedValue5 = composer.rememberedValue();
        if (changed || rememberedValue5 == companion.getEmpty()) {
            rememberedValue5 = new Function1() { // from class: androidx.compose.foundation.MagnifierKt$magnifier$4$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((LayoutCoordinates) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(LayoutCoordinates it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    MagnifierKt$magnifier$4.invoke$lambda$2(MutableState.this, LayoutCoordinatesKt.positionInRoot(it));
                }
            };
            composer.updateRememberedValue(rememberedValue5);
        }
        composer.endReplaceableGroup();
        Modifier drawBehind = DrawModifierKt.drawBehind(OnGloballyPositionedModifierKt.onGloballyPositioned(composed, (Function1) rememberedValue5), new Function1() { // from class: androidx.compose.foundation.MagnifierKt$magnifier$4.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DrawScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(DrawScope drawBehind2) {
                Intrinsics.checkNotNullParameter(drawBehind2, "$this$drawBehind");
                MutableSharedFlow.this.tryEmit(Unit.INSTANCE);
            }
        });
        composer.startReplaceableGroup(1157296644);
        boolean changed2 = composer.changed(state);
        Object rememberedValue6 = composer.rememberedValue();
        if (changed2 || rememberedValue6 == companion.getEmpty()) {
            rememberedValue6 = new Function1() { // from class: androidx.compose.foundation.MagnifierKt$magnifier$4$4$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((SemanticsPropertyReceiver) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(SemanticsPropertyReceiver semantics) {
                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                    SemanticsPropertyKey magnifierPositionInRoot = MagnifierKt.getMagnifierPositionInRoot();
                    final State state3 = State.this;
                    semantics.set(magnifierPositionInRoot, new Function0() { // from class: androidx.compose.foundation.MagnifierKt$magnifier$4$4$1.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            return Offset.m698boximpl(m109invokeF1C5BW0());
                        }

                        /* renamed from: invoke-F1C5BW0  reason: not valid java name */
                        public final long m109invokeF1C5BW0() {
                            return MagnifierKt$magnifier$4.invoke$lambda$8(State.this);
                        }
                    });
                }
            };
            composer.updateRememberedValue(rememberedValue6);
        }
        composer.endReplaceableGroup();
        Modifier semantics$default = SemanticsModifierKt.semantics$default(drawBehind, false, (Function1) rememberedValue6, 1, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return semantics$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$2(MutableState mutableState, long j) {
        mutableState.setValue(Offset.m698boximpl(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Magnifier.kt */
    /* renamed from: androidx.compose.foundation.MagnifierKt$magnifier$4$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ MutableState $anchorPositionInRoot$delegate;
        final /* synthetic */ Density $density;
        final /* synthetic */ State $isMagnifierShown$delegate;
        final /* synthetic */ MutableSharedFlow $onNeedsUpdate;
        final /* synthetic */ PlatformMagnifierFactory $platformMagnifierFactory;
        final /* synthetic */ State $sourceCenterInRoot$delegate;
        final /* synthetic */ MagnifierStyle $style;
        final /* synthetic */ State $updatedMagnifierCenter$delegate;
        final /* synthetic */ State $updatedOnSizeChanged$delegate;
        final /* synthetic */ State $updatedZoom$delegate;
        final /* synthetic */ View $view;
        final /* synthetic */ float $zoom;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PlatformMagnifierFactory platformMagnifierFactory, MagnifierStyle magnifierStyle, View view, Density density, float f, MutableSharedFlow mutableSharedFlow, State state, State state2, State state3, State state4, MutableState mutableState, State state5, Continuation continuation) {
            super(2, continuation);
            this.$platformMagnifierFactory = platformMagnifierFactory;
            this.$style = magnifierStyle;
            this.$view = view;
            this.$density = density;
            this.$zoom = f;
            this.$onNeedsUpdate = mutableSharedFlow;
            this.$updatedOnSizeChanged$delegate = state;
            this.$isMagnifierShown$delegate = state2;
            this.$sourceCenterInRoot$delegate = state3;
            this.$updatedMagnifierCenter$delegate = state4;
            this.$anchorPositionInRoot$delegate = mutableState;
            this.$updatedZoom$delegate = state5;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$platformMagnifierFactory, this.$style, this.$view, this.$density, this.$zoom, this.$onNeedsUpdate, this.$updatedOnSizeChanged$delegate, this.$isMagnifierShown$delegate, this.$sourceCenterInRoot$delegate, this.$updatedMagnifierCenter$delegate, this.$anchorPositionInRoot$delegate, this.$updatedZoom$delegate, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Magnifier.kt */
        /* renamed from: androidx.compose.foundation.MagnifierKt$magnifier$4$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C00011 extends SuspendLambda implements Function2 {
            final /* synthetic */ PlatformMagnifier $magnifier;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00011(PlatformMagnifier platformMagnifier, Continuation continuation) {
                super(2, continuation);
                this.$magnifier = platformMagnifier;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new C00011(this.$magnifier, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Unit unit, Continuation continuation) {
                return ((C00011) create(unit, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.$magnifier.updateContent();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            PlatformMagnifier platformMagnifier;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                final PlatformMagnifier create = this.$platformMagnifierFactory.create(this.$style, this.$view, this.$density, this.$zoom);
                final Ref$LongRef ref$LongRef = new Ref$LongRef();
                long mo115getSizeYbymL2g = create.mo115getSizeYbymL2g();
                Density density = this.$density;
                Function1 invoke$lambda$6 = MagnifierKt$magnifier$4.invoke$lambda$6(this.$updatedOnSizeChanged$delegate);
                if (invoke$lambda$6 != null) {
                    invoke$lambda$6.invoke(DpSize.m1918boximpl(density.mo153toDpSizekrfVVM(IntSizeKt.m1957toSizeozmzZPI(mo115getSizeYbymL2g))));
                }
                ref$LongRef.element = mo115getSizeYbymL2g;
                FlowKt.launchIn(FlowKt.onEach(this.$onNeedsUpdate, new C00011(create, null)), coroutineScope);
                try {
                    final Density density2 = this.$density;
                    final State state = this.$isMagnifierShown$delegate;
                    final State state2 = this.$sourceCenterInRoot$delegate;
                    final State state3 = this.$updatedMagnifierCenter$delegate;
                    final MutableState mutableState = this.$anchorPositionInRoot$delegate;
                    final State state4 = this.$updatedZoom$delegate;
                    final State state5 = this.$updatedOnSizeChanged$delegate;
                    Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: androidx.compose.foundation.MagnifierKt.magnifier.4.1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m108invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: collision with other method in class */
                        public final void m108invoke() {
                            long m720getUnspecifiedF1C5BW0;
                            if (MagnifierKt$magnifier$4.invoke$lambda$10(state)) {
                                PlatformMagnifier platformMagnifier2 = PlatformMagnifier.this;
                                long invoke$lambda$8 = MagnifierKt$magnifier$4.invoke$lambda$8(state2);
                                Object invoke = MagnifierKt$magnifier$4.invoke$lambda$4(state3).invoke(density2);
                                MutableState mutableState2 = mutableState;
                                long m718unboximpl = ((Offset) invoke).m718unboximpl();
                                if (OffsetKt.m723isSpecifiedk4lQ0M(m718unboximpl)) {
                                    m720getUnspecifiedF1C5BW0 = Offset.m714plusMKHz9U(MagnifierKt$magnifier$4.invoke$lambda$1(mutableState2), m718unboximpl);
                                } else {
                                    m720getUnspecifiedF1C5BW0 = Offset.Companion.m720getUnspecifiedF1C5BW0();
                                }
                                platformMagnifier2.mo116updateWko1d7g(invoke$lambda$8, m720getUnspecifiedF1C5BW0, MagnifierKt$magnifier$4.invoke$lambda$5(state4));
                                long mo115getSizeYbymL2g2 = PlatformMagnifier.this.mo115getSizeYbymL2g();
                                Ref$LongRef ref$LongRef2 = ref$LongRef;
                                Density density3 = density2;
                                State state6 = state5;
                                if (IntSize.m1949equalsimpl0(mo115getSizeYbymL2g2, ref$LongRef2.element)) {
                                    return;
                                }
                                ref$LongRef2.element = mo115getSizeYbymL2g2;
                                Function1 invoke$lambda$62 = MagnifierKt$magnifier$4.invoke$lambda$6(state6);
                                if (invoke$lambda$62 != null) {
                                    invoke$lambda$62.invoke(DpSize.m1918boximpl(density3.mo153toDpSizekrfVVM(IntSizeKt.m1957toSizeozmzZPI(mo115getSizeYbymL2g2))));
                                    return;
                                }
                                return;
                            }
                            PlatformMagnifier.this.dismiss();
                        }
                    });
                    this.L$0 = create;
                    this.label = 1;
                    if (FlowKt.collect(snapshotFlow, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    platformMagnifier = create;
                } catch (Throwable th) {
                    th = th;
                    platformMagnifier = create;
                    platformMagnifier.dismiss();
                    throw th;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                platformMagnifier = (PlatformMagnifier) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Throwable th2) {
                    th = th2;
                    platformMagnifier.dismiss();
                    throw th;
                }
            }
            platformMagnifier.dismiss();
            return Unit.INSTANCE;
        }
    }
}
