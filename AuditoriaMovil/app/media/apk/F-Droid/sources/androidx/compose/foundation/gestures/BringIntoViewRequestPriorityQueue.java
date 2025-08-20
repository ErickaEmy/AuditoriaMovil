package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.ContentInViewModifier;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.Rect;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CancellableContinuation;
/* compiled from: BringIntoViewRequestPriorityQueue.kt */
/* loaded from: classes.dex */
public final class BringIntoViewRequestPriorityQueue {
    private final MutableVector requests = new MutableVector(new ContentInViewModifier.Request[16], 0);

    public final void resumeAndRemoveAll() {
        IntRange intRange = new IntRange(0, this.requests.getSize() - 1);
        int first = intRange.getFirst();
        int last = intRange.getLast();
        if (first <= last) {
            while (true) {
                ((ContentInViewModifier.Request) this.requests.getContent()[first]).getContinuation().resumeWith(Result.m2081constructorimpl(Unit.INSTANCE));
                if (first == last) {
                    break;
                }
                first++;
            }
        }
        this.requests.clear();
    }

    public final boolean enqueue(final ContentInViewModifier.Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Rect rect = (Rect) request.getCurrentBounds().invoke();
        if (rect == null) {
            CancellableContinuation continuation = request.getContinuation();
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m2081constructorimpl(Unit.INSTANCE));
            return false;
        }
        request.getContinuation().invokeOnCancellation(new Function1() { // from class: androidx.compose.foundation.gestures.BringIntoViewRequestPriorityQueue$enqueue$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable th) {
                MutableVector mutableVector;
                mutableVector = BringIntoViewRequestPriorityQueue.this.requests;
                mutableVector.remove(request);
            }
        });
        IntRange intRange = new IntRange(0, this.requests.getSize() - 1);
        int first = intRange.getFirst();
        int last = intRange.getLast();
        if (first <= last) {
            while (true) {
                Rect rect2 = (Rect) ((ContentInViewModifier.Request) this.requests.getContent()[last]).getCurrentBounds().invoke();
                if (rect2 != null) {
                    Rect intersect = rect.intersect(rect2);
                    if (Intrinsics.areEqual(intersect, rect)) {
                        this.requests.add(last + 1, request);
                        return true;
                    } else if (!Intrinsics.areEqual(intersect, rect2)) {
                        CancellationException cancellationException = new CancellationException("bringIntoView call interrupted by a newer, non-overlapping call");
                        int size = this.requests.getSize() - 1;
                        if (size <= last) {
                            while (true) {
                                ((ContentInViewModifier.Request) this.requests.getContent()[last]).getContinuation().cancel(cancellationException);
                                if (size == last) {
                                    break;
                                }
                                size++;
                            }
                        }
                    }
                }
                if (last == first) {
                    break;
                }
                last--;
            }
        }
        this.requests.add(0, request);
        return true;
    }

    public final void cancelAndRemoveAll(Throwable th) {
        MutableVector mutableVector = this.requests;
        int size = mutableVector.getSize();
        CancellableContinuation[] cancellableContinuationArr = new CancellableContinuation[size];
        for (int i = 0; i < size; i++) {
            cancellableContinuationArr[i] = ((ContentInViewModifier.Request) mutableVector.getContent()[i]).getContinuation();
        }
        for (int i2 = 0; i2 < size; i2++) {
            cancellableContinuationArr[i2].cancel(th);
        }
        if (!this.requests.isEmpty()) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }
}
