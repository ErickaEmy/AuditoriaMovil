package kotlinx.coroutines.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.Segment;
/* loaded from: classes.dex */
public final class SegmentOrClosed<S extends Segment<S>> {
    /* renamed from: constructor-impl  reason: not valid java name */
    public static <S extends Segment<S>> Object m111constructorimpl(Object obj) {
        return obj;
    }

    /* renamed from: getSegment-impl  reason: not valid java name */
    public static final S m112getSegmentimpl(Object obj) {
        if (obj != ConcurrentLinkedListKt.CLOSED) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
            return (S) obj;
        }
        throw new IllegalStateException("Does not contain segment");
    }

    /* renamed from: isClosed-impl  reason: not valid java name */
    public static final boolean m113isClosedimpl(Object obj) {
        if (obj == ConcurrentLinkedListKt.CLOSED) {
            return true;
        }
        return false;
    }
}
