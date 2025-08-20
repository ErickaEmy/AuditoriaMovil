package kotlinx.coroutines.internal;

import kotlin.jvm.functions.Function2;
/* loaded from: classes.dex */
public final class ConcurrentLinkedListKt {
    private static final Symbol CLOSED = new Symbol("CLOSED");

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlinx.coroutines.internal.ConcurrentLinkedListNode] */
    public static final <N extends ConcurrentLinkedListNode<N>> N close(N n2) {
        while (true) {
            Object nextOrClosed = n2.getNextOrClosed();
            if (nextOrClosed == CLOSED) {
                return n2;
            }
            ?? r0 = (ConcurrentLinkedListNode) nextOrClosed;
            if (r0 == 0) {
                if (n2.markAsClosed()) {
                    return n2;
                }
            } else {
                n2 = r0;
            }
        }
    }

    public static final <S extends Segment<S>> Object findSegmentInternal(S s2, long j2, Function2<? super Long, ? super S, ? extends S> function2) {
        while (true) {
            if (s2.id < j2 || s2.isRemoved()) {
                Object nextOrClosed = s2.getNextOrClosed();
                if (nextOrClosed == CLOSED) {
                    return SegmentOrClosed.m111constructorimpl(CLOSED);
                }
                S s3 = (S) ((ConcurrentLinkedListNode) nextOrClosed);
                if (s3 == null) {
                    s3 = function2.invoke(Long.valueOf(s2.id + 1), s2);
                    if (s2.trySetNext(s3)) {
                        if (s2.isRemoved()) {
                            s2.remove();
                        }
                    }
                }
                s2 = s3;
            } else {
                return SegmentOrClosed.m111constructorimpl(s2);
            }
        }
    }
}
