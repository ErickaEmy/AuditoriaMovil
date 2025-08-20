package androidx.compose.runtime;

import androidx.compose.runtime.BroadcastFrameClock;
import androidx.compose.runtime.MonotonicFrameClock;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CancellableContinuationImpl;
/* compiled from: BroadcastFrameClock.kt */
/* loaded from: classes.dex */
public final class BroadcastFrameClock implements MonotonicFrameClock {
    private Throwable failureCause;
    private final Function0 onNewAwaiters;
    private final Object lock = new Object();
    private List awaiters = new ArrayList();
    private List spareList = new ArrayList();

    @Override // kotlin.coroutines.CoroutineContext.Element
    public /* synthetic */ CoroutineContext.Key getKey() {
        CoroutineContext.Key key;
        key = MonotonicFrameClock.Key;
        return key;
    }

    public BroadcastFrameClock(Function0 function0) {
        this.onNewAwaiters = function0;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public Object fold(Object obj, Function2 function2) {
        return MonotonicFrameClock.DefaultImpls.fold(this, obj, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext.Element get(CoroutineContext.Key key) {
        return MonotonicFrameClock.DefaultImpls.get(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key key) {
        return MonotonicFrameClock.DefaultImpls.minusKey(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return MonotonicFrameClock.DefaultImpls.plus(this, coroutineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BroadcastFrameClock.kt */
    /* loaded from: classes.dex */
    public static final class FrameAwaiter {
        private final Continuation continuation;
        private final Function1 onFrame;

        public final Continuation getContinuation() {
            return this.continuation;
        }

        public FrameAwaiter(Function1 onFrame, Continuation continuation) {
            Intrinsics.checkNotNullParameter(onFrame, "onFrame");
            Intrinsics.checkNotNullParameter(continuation, "continuation");
            this.onFrame = onFrame;
            this.continuation = continuation;
        }

        public final void resume(long j) {
            Object m2081constructorimpl;
            Continuation continuation = this.continuation;
            try {
                Result.Companion companion = Result.Companion;
                m2081constructorimpl = Result.m2081constructorimpl(this.onFrame.invoke(Long.valueOf(j)));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                m2081constructorimpl = Result.m2081constructorimpl(ResultKt.createFailure(th));
            }
            continuation.resumeWith(m2081constructorimpl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fail(Throwable th) {
        synchronized (this.lock) {
            try {
                if (this.failureCause != null) {
                    return;
                }
                this.failureCause = th;
                List list = this.awaiters;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    Continuation continuation = ((FrameAwaiter) list.get(i)).getContinuation();
                    Result.Companion companion = Result.Companion;
                    continuation.resumeWith(Result.m2081constructorimpl(ResultKt.createFailure(th)));
                }
                this.awaiters.clear();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean getHasAwaiters() {
        boolean z;
        synchronized (this.lock) {
            z = !this.awaiters.isEmpty();
        }
        return z;
    }

    public final void sendFrame(long j) {
        synchronized (this.lock) {
            try {
                List list = this.awaiters;
                this.awaiters = this.spareList;
                this.spareList = list;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    ((FrameAwaiter) list.get(i)).resume(j);
                }
                list.clear();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock
    public Object withFrameNanos(Function1 function1, Continuation continuation) {
        Continuation intercepted;
        FrameAwaiter frameAwaiter;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        synchronized (this.lock) {
            Throwable th = this.failureCause;
            if (th != null) {
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl.resumeWith(Result.m2081constructorimpl(ResultKt.createFailure(th)));
            } else {
                ref$ObjectRef.element = new FrameAwaiter(function1, cancellableContinuationImpl);
                boolean z = !this.awaiters.isEmpty();
                List list = this.awaiters;
                Object obj = ref$ObjectRef.element;
                if (obj == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("awaiter");
                    frameAwaiter = null;
                } else {
                    frameAwaiter = (FrameAwaiter) obj;
                }
                list.add(frameAwaiter);
                boolean z2 = !z;
                cancellableContinuationImpl.invokeOnCancellation(new Function1() { // from class: androidx.compose.runtime.BroadcastFrameClock$withFrameNanos$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((Throwable) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Throwable th2) {
                        BroadcastFrameClock.FrameAwaiter frameAwaiter2;
                        Object obj2 = BroadcastFrameClock.this.lock;
                        BroadcastFrameClock broadcastFrameClock = BroadcastFrameClock.this;
                        Ref$ObjectRef ref$ObjectRef2 = ref$ObjectRef;
                        synchronized (obj2) {
                            try {
                                List list2 = broadcastFrameClock.awaiters;
                                Object obj3 = ref$ObjectRef2.element;
                                if (obj3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("awaiter");
                                    frameAwaiter2 = null;
                                } else {
                                    frameAwaiter2 = (BroadcastFrameClock.FrameAwaiter) obj3;
                                }
                                list2.remove(frameAwaiter2);
                                Unit unit = Unit.INSTANCE;
                            } catch (Throwable th3) {
                                throw th3;
                            }
                        }
                    }
                });
                if (z2 && this.onNewAwaiters != null) {
                    try {
                        this.onNewAwaiters.invoke();
                    } catch (Throwable th2) {
                        fail(th2);
                    }
                }
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
