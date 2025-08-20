package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.unit.Velocity;
import kotlin.coroutines.Continuation;
/* compiled from: NestedScrollModifier.kt */
/* loaded from: classes.dex */
public interface NestedScrollConnection {
    /* renamed from: onPostFling-RZ2iAVY */
    Object mo160onPostFlingRZ2iAVY(long j, long j2, Continuation continuation);

    /* renamed from: onPostScroll-DzOQY0M */
    long mo161onPostScrollDzOQY0M(long j, long j2, int i);

    /* renamed from: onPreFling-QWom1Mo */
    Object mo162onPreFlingQWom1Mo(long j, Continuation continuation);

    /* renamed from: onPreScroll-OzD1aCk */
    long mo163onPreScrollOzD1aCk(long j, int i);

    /* compiled from: NestedScrollModifier.kt */
    /* renamed from: androidx.compose.ui.input.nestedscroll.NestedScrollConnection$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
        /* renamed from: onPreFling-QWom1Mo$suspendImpl  reason: not valid java name */
        public static /* synthetic */ Object m1151onPreFlingQWom1Mo$suspendImpl(NestedScrollConnection nestedScrollConnection, long j, Continuation continuation) {
            return Velocity.m1983boximpl(Velocity.Companion.m1997getZero9UxMQ8M());
        }
    }
}
