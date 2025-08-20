package androidx.compose.foundation.gestures;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import kotlin.coroutines.Continuation;
/* compiled from: Scrollable.kt */
/* loaded from: classes.dex */
public final class ScrollableKt$scrollableNestedScrollConnection$1 implements NestedScrollConnection {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ State $scrollLogic;

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    public /* synthetic */ Object mo162onPreFlingQWom1Mo(long j, Continuation continuation) {
        Object m1151onPreFlingQWom1Mo$suspendImpl;
        m1151onPreFlingQWom1Mo$suspendImpl = NestedScrollConnection.CC.m1151onPreFlingQWom1Mo$suspendImpl(this, j, continuation);
        return m1151onPreFlingQWom1Mo$suspendImpl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ScrollableKt$scrollableNestedScrollConnection$1(State state, boolean z) {
        this.$scrollLogic = state;
        this.$enabled = z;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public long mo163onPreScrollOzD1aCk(long j, int i) {
        if (NestedScrollSource.m1157equalsimpl0(i, NestedScrollSource.Companion.m1159getFlingWNlRxjI())) {
            ((ScrollingLogic) this.$scrollLogic.getValue()).registerNestedFling(true);
        }
        return Offset.Companion.m721getZeroF1C5BW0();
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public long mo161onPostScrollDzOQY0M(long j, long j2, int i) {
        if (this.$enabled) {
            return ((ScrollingLogic) this.$scrollLogic.getValue()).m167performRawScrollMKHz9U(j2);
        }
        return Offset.Companion.m721getZeroF1C5BW0();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo160onPostFlingRZ2iAVY(long r3, long r5, kotlin.coroutines.Continuation r7) {
        /*
            r2 = this;
            boolean r3 = r7 instanceof androidx.compose.foundation.gestures.ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1
            if (r3 == 0) goto L13
            r3 = r7
            androidx.compose.foundation.gestures.ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1 r3 = (androidx.compose.foundation.gestures.ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1) r3
            int r4 = r3.label
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r4 & r0
            if (r1 == 0) goto L13
            int r4 = r4 - r0
            r3.label = r4
            goto L18
        L13:
            androidx.compose.foundation.gestures.ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1 r3 = new androidx.compose.foundation.gestures.ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1
            r3.<init>(r2, r7)
        L18:
            java.lang.Object r4 = r3.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r3.label
            r1 = 1
            if (r0 == 0) goto L37
            if (r0 != r1) goto L2f
            long r5 = r3.J$0
            java.lang.Object r3 = r3.L$0
            androidx.compose.foundation.gestures.ScrollableKt$scrollableNestedScrollConnection$1 r3 = (androidx.compose.foundation.gestures.ScrollableKt$scrollableNestedScrollConnection$1) r3
            kotlin.ResultKt.throwOnFailure(r4)
            goto L54
        L2f:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r4)
            throw r3
        L37:
            kotlin.ResultKt.throwOnFailure(r4)
            boolean r4 = r2.$enabled
            if (r4 == 0) goto L5f
            androidx.compose.runtime.State r4 = r2.$scrollLogic
            java.lang.Object r4 = r4.getValue()
            androidx.compose.foundation.gestures.ScrollingLogic r4 = (androidx.compose.foundation.gestures.ScrollingLogic) r4
            r3.L$0 = r2
            r3.J$0 = r5
            r3.label = r1
            java.lang.Object r4 = r4.m165doFlingAnimationQWom1Mo(r5, r3)
            if (r4 != r7) goto L53
            return r7
        L53:
            r3 = r2
        L54:
            androidx.compose.ui.unit.Velocity r4 = (androidx.compose.ui.unit.Velocity) r4
            long r0 = r4.m1996unboximpl()
            long r4 = androidx.compose.ui.unit.Velocity.m1992minusAH228Gc(r5, r0)
            goto L66
        L5f:
            androidx.compose.ui.unit.Velocity$Companion r3 = androidx.compose.ui.unit.Velocity.Companion
            long r4 = r3.m1997getZero9UxMQ8M()
            r3 = r2
        L66:
            androidx.compose.ui.unit.Velocity r4 = androidx.compose.ui.unit.Velocity.m1983boximpl(r4)
            androidx.compose.runtime.State r3 = r3.$scrollLogic
            r4.m1996unboximpl()
            java.lang.Object r3 = r3.getValue()
            androidx.compose.foundation.gestures.ScrollingLogic r3 = (androidx.compose.foundation.gestures.ScrollingLogic) r3
            r5 = 0
            r3.registerNestedFling(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableKt$scrollableNestedScrollConnection$1.mo160onPostFlingRZ2iAVY(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
