package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.unit.Velocity;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Scrollable.kt */
/* loaded from: classes.dex */
public final class ScrollingLogic {
    private final FlingBehavior flingBehavior;
    private final MutableState isNestedFlinging;
    private final State nestedScrollDispatcher;
    private final Orientation orientation;
    private final OverscrollEffect overscrollEffect;
    private final boolean reverseDirection;
    private final ScrollableState scrollableState;

    public final FlingBehavior getFlingBehavior() {
        return this.flingBehavior;
    }

    public final State getNestedScrollDispatcher() {
        return this.nestedScrollDispatcher;
    }

    public final ScrollableState getScrollableState() {
        return this.scrollableState;
    }

    public final float reverseIfNeeded(float f) {
        return this.reverseDirection ? f * (-1) : f;
    }

    public ScrollingLogic(Orientation orientation, boolean z, State nestedScrollDispatcher, ScrollableState scrollableState, FlingBehavior flingBehavior, OverscrollEffect overscrollEffect) {
        MutableState mutableStateOf$default;
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(nestedScrollDispatcher, "nestedScrollDispatcher");
        Intrinsics.checkNotNullParameter(scrollableState, "scrollableState");
        Intrinsics.checkNotNullParameter(flingBehavior, "flingBehavior");
        this.orientation = orientation;
        this.reverseDirection = z;
        this.nestedScrollDispatcher = nestedScrollDispatcher;
        this.scrollableState = scrollableState;
        this.flingBehavior = flingBehavior;
        this.overscrollEffect = overscrollEffect;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.isNestedFlinging = mutableStateOf$default;
    }

    /* renamed from: toOffset-tuRUvjQ  reason: not valid java name */
    public final long m173toOffsettuRUvjQ(float f) {
        if (f == 0.0f) {
            return Offset.Companion.m721getZeroF1C5BW0();
        }
        return this.orientation == Orientation.Horizontal ? OffsetKt.Offset(f, 0.0f) : OffsetKt.Offset(0.0f, f);
    }

    /* renamed from: singleAxisOffset-MK-Hz9U  reason: not valid java name */
    public final long m169singleAxisOffsetMKHz9U(long j) {
        return this.orientation == Orientation.Horizontal ? Offset.m703copydBAh8RU$default(j, 0.0f, 0.0f, 1, null) : Offset.m703copydBAh8RU$default(j, 0.0f, 0.0f, 2, null);
    }

    /* renamed from: toFloat-k-4lQ0M  reason: not valid java name */
    public final float m172toFloatk4lQ0M(long j) {
        return this.orientation == Orientation.Horizontal ? Offset.m709getXimpl(j) : Offset.m710getYimpl(j);
    }

    /* renamed from: toFloat-TH1AsA0  reason: not valid java name */
    public final float m171toFloatTH1AsA0(long j) {
        return this.orientation == Orientation.Horizontal ? Velocity.m1989getXimpl(j) : Velocity.m1990getYimpl(j);
    }

    /* renamed from: singleAxisVelocity-AH228Gc  reason: not valid java name */
    public final long m170singleAxisVelocityAH228Gc(long j) {
        return this.orientation == Orientation.Horizontal ? Velocity.m1986copyOhffZ5M$default(j, 0.0f, 0.0f, 1, null) : Velocity.m1986copyOhffZ5M$default(j, 0.0f, 0.0f, 2, null);
    }

    /* renamed from: update-QWom1Mo  reason: not valid java name */
    public final long m174updateQWom1Mo(long j, float f) {
        return this.orientation == Orientation.Horizontal ? Velocity.m1986copyOhffZ5M$default(j, f, 0.0f, 2, null) : Velocity.m1986copyOhffZ5M$default(j, 0.0f, f, 1, null);
    }

    /* renamed from: reverseIfNeeded-MK-Hz9U  reason: not valid java name */
    public final long m168reverseIfNeededMKHz9U(long j) {
        return this.reverseDirection ? Offset.m715timestuRUvjQ(j, -1.0f) : j;
    }

    /* renamed from: dispatchScroll-3eAAhYA  reason: not valid java name */
    public final long m164dispatchScroll3eAAhYA(final ScrollScope dispatchScroll, long j, final int i) {
        Intrinsics.checkNotNullParameter(dispatchScroll, "$this$dispatchScroll");
        long m169singleAxisOffsetMKHz9U = m169singleAxisOffsetMKHz9U(j);
        Function1 function1 = new Function1() { // from class: androidx.compose.foundation.gestures.ScrollingLogic$dispatchScroll$performScroll$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return Offset.m698boximpl(m175invokeMKHz9U(((Offset) obj).m718unboximpl()));
            }

            /* renamed from: invoke-MK-Hz9U  reason: not valid java name */
            public final long m175invokeMKHz9U(long j2) {
                NestedScrollDispatcher nestedScrollDispatcher = (NestedScrollDispatcher) ScrollingLogic.this.getNestedScrollDispatcher().getValue();
                long m1155dispatchPreScrollOzD1aCk = nestedScrollDispatcher.m1155dispatchPreScrollOzD1aCk(j2, i);
                long m713minusMKHz9U = Offset.m713minusMKHz9U(j2, m1155dispatchPreScrollOzD1aCk);
                ScrollingLogic scrollingLogic = ScrollingLogic.this;
                long m168reverseIfNeededMKHz9U = scrollingLogic.m168reverseIfNeededMKHz9U(scrollingLogic.m173toOffsettuRUvjQ(dispatchScroll.scrollBy(scrollingLogic.m172toFloatk4lQ0M(scrollingLogic.m168reverseIfNeededMKHz9U(m713minusMKHz9U)))));
                return Offset.m714plusMKHz9U(Offset.m714plusMKHz9U(m1155dispatchPreScrollOzD1aCk, m168reverseIfNeededMKHz9U), nestedScrollDispatcher.m1153dispatchPostScrollDzOQY0M(m168reverseIfNeededMKHz9U, Offset.m713minusMKHz9U(m713minusMKHz9U, m168reverseIfNeededMKHz9U), i));
            }
        };
        if (this.overscrollEffect != null && getShouldDispatchOverscroll()) {
            return this.overscrollEffect.mo72applyToScrollRhakbz0(m169singleAxisOffsetMKHz9U, i, function1);
        }
        return ((Offset) function1.invoke(Offset.m698boximpl(m169singleAxisOffsetMKHz9U))).m718unboximpl();
    }

    private final boolean getShouldDispatchOverscroll() {
        return this.scrollableState.getCanScrollForward() || this.scrollableState.getCanScrollBackward();
    }

    /* renamed from: performRawScroll-MK-Hz9U  reason: not valid java name */
    public final long m167performRawScrollMKHz9U(long j) {
        if (this.scrollableState.isScrollInProgress()) {
            return Offset.Companion.m721getZeroF1C5BW0();
        }
        return m173toOffsettuRUvjQ(reverseIfNeeded(this.scrollableState.dispatchRawDelta(reverseIfNeeded(m172toFloatk4lQ0M(j)))));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    /* renamed from: onDragStopped-sF-c-tU  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m166onDragStoppedsFctU(long r6, kotlin.coroutines.Continuation r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1 r0 = (androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1 r0 = new androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L39
            if (r2 == r4) goto L31
            if (r2 != r3) goto L29
            goto L31
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            java.lang.Object r6 = r0.L$0
            androidx.compose.foundation.gestures.ScrollingLogic r6 = (androidx.compose.foundation.gestures.ScrollingLogic) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L71
        L39:
            kotlin.ResultKt.throwOnFailure(r8)
            r5.registerNestedFling(r4)
            long r6 = r5.m170singleAxisVelocityAH228Gc(r6)
            androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$performFling$1 r8 = new androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$performFling$1
            r2 = 0
            r8.<init>(r5, r2)
            androidx.compose.foundation.OverscrollEffect r2 = r5.overscrollEffect
            if (r2 == 0) goto L62
            boolean r2 = r5.getShouldDispatchOverscroll()
            if (r2 == 0) goto L62
            androidx.compose.foundation.OverscrollEffect r2 = r5.overscrollEffect
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r2.mo71applyToFlingBMRW4eQ(r6, r8, r0)
            if (r6 != r1) goto L60
            return r1
        L60:
            r6 = r5
            goto L71
        L62:
            androidx.compose.ui.unit.Velocity r6 = androidx.compose.ui.unit.Velocity.m1983boximpl(r6)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r8.invoke(r6, r0)
            if (r6 != r1) goto L60
            return r1
        L71:
            r7 = 0
            r6.registerNestedFling(r7)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollingLogic.m166onDragStoppedsFctU(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* renamed from: doFlingAnimation-QWom1Mo  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m165doFlingAnimationQWom1Mo(long r13, kotlin.coroutines.Continuation r15) {
        /*
            r12 = this;
            boolean r0 = r15 instanceof androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1
            if (r0 == 0) goto L14
            r0 = r15
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1 r0 = (androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1 r0 = new androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1
            r0.<init>(r12, r15)
            goto L12
        L1a:
            java.lang.Object r15 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L37
            if (r1 != r2) goto L2f
            java.lang.Object r13 = r4.L$0
            kotlin.jvm.internal.Ref$LongRef r13 = (kotlin.jvm.internal.Ref$LongRef) r13
            kotlin.ResultKt.throwOnFailure(r15)
            goto L5e
        L2f:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L37:
            kotlin.ResultKt.throwOnFailure(r15)
            kotlin.jvm.internal.Ref$LongRef r15 = new kotlin.jvm.internal.Ref$LongRef
            r15.<init>()
            r15.element = r13
            androidx.compose.foundation.gestures.ScrollableState r1 = r12.scrollableState
            r3 = 0
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2 r11 = new androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2
            r10 = 0
            r5 = r11
            r6 = r12
            r7 = r15
            r8 = r13
            r5.<init>(r6, r7, r8, r10)
            r5 = 1
            r6 = 0
            r4.L$0 = r15
            r4.label = r2
            r2 = r3
            r3 = r11
            java.lang.Object r13 = androidx.compose.foundation.gestures.ScrollableState.CC.scroll$default(r1, r2, r3, r4, r5, r6)
            if (r13 != r0) goto L5d
            return r0
        L5d:
            r13 = r15
        L5e:
            long r13 = r13.element
            androidx.compose.ui.unit.Velocity r13 = androidx.compose.ui.unit.Velocity.m1983boximpl(r13)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollingLogic.m165doFlingAnimationQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean shouldScrollImmediately() {
        OverscrollEffect overscrollEffect;
        return this.scrollableState.isScrollInProgress() || ((Boolean) this.isNestedFlinging.getValue()).booleanValue() || ((overscrollEffect = this.overscrollEffect) != null && overscrollEffect.isInProgress());
    }

    public final void registerNestedFling(boolean z) {
        this.isNestedFlinging.setValue(Boolean.valueOf(z));
    }
}
