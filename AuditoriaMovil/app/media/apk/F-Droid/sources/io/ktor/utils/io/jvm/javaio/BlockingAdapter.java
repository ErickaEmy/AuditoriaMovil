package io.ktor.utils.io.jvm.javaio;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.EventLoopKt;
import kotlinx.coroutines.Job;
/* compiled from: Blocking.kt */
/* loaded from: classes.dex */
abstract class BlockingAdapter {
    static final /* synthetic */ AtomicReferenceFieldUpdater state$FU = AtomicReferenceFieldUpdater.newUpdater(BlockingAdapter.class, Object.class, "state");
    private final DisposableHandle disposable;
    private final Continuation end;
    private int length;
    private int offset;
    private final Job parent;
    volatile /* synthetic */ int result;
    volatile /* synthetic */ Object state;

    /* JADX INFO: Access modifiers changed from: protected */
    public final void finish(int i) {
        this.result = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getLength() {
        return this.length;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getOffset() {
        return this.offset;
    }

    public final Job getParent() {
        return this.parent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object loop(Continuation continuation);

    public BlockingAdapter(Job job) {
        this.parent = job;
        Continuation continuation = new Continuation() { // from class: io.ktor.utils.io.jvm.javaio.BlockingAdapter$end$1
            private final CoroutineContext context;

            @Override // kotlin.coroutines.Continuation
            public CoroutineContext getContext() {
                return this.context;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.context = BlockingAdapter.this.getParent() != null ? UnsafeBlockingTrampoline.INSTANCE.plus(BlockingAdapter.this.getParent()) : UnsafeBlockingTrampoline.INSTANCE;
            }

            @Override // kotlin.coroutines.Continuation
            public void resumeWith(Object obj) {
                Object obj2;
                boolean z;
                Throwable m2084exceptionOrNullimpl;
                DisposableHandle disposableHandle;
                Job parent;
                Object m2084exceptionOrNullimpl2 = Result.m2084exceptionOrNullimpl(obj);
                if (m2084exceptionOrNullimpl2 == null) {
                    m2084exceptionOrNullimpl2 = Unit.INSTANCE;
                }
                BlockingAdapter blockingAdapter = BlockingAdapter.this;
                do {
                    obj2 = blockingAdapter.state;
                    z = obj2 instanceof Thread;
                    if (!z && !(obj2 instanceof Continuation) && !Intrinsics.areEqual(obj2, this)) {
                        return;
                    }
                } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(BlockingAdapter.state$FU, blockingAdapter, obj2, m2084exceptionOrNullimpl2));
                if (z) {
                    PollersKt.getParkingImpl().unpark(obj2);
                } else if ((obj2 instanceof Continuation) && (m2084exceptionOrNullimpl = Result.m2084exceptionOrNullimpl(obj)) != null) {
                    ((Continuation) obj2).resumeWith(Result.m2081constructorimpl(ResultKt.createFailure(m2084exceptionOrNullimpl)));
                }
                if (Result.m2086isFailureimpl(obj) && !(Result.m2084exceptionOrNullimpl(obj) instanceof CancellationException) && (parent = BlockingAdapter.this.getParent()) != null) {
                    Job.DefaultImpls.cancel$default(parent, null, 1, null);
                }
                disposableHandle = BlockingAdapter.this.disposable;
                if (disposableHandle != null) {
                    disposableHandle.dispose();
                }
            }
        };
        this.end = continuation;
        this.state = this;
        this.result = 0;
        this.disposable = job != null ? job.invokeOnCompletion(new Function1() { // from class: io.ktor.utils.io.jvm.javaio.BlockingAdapter$disposable$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable th) {
                Continuation continuation2;
                if (th != null) {
                    continuation2 = BlockingAdapter.this.end;
                    Result.Companion companion = Result.Companion;
                    continuation2.resumeWith(Result.m2081constructorimpl(ResultKt.createFailure(th)));
                }
            }
        }) : null;
        ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(new BlockingAdapter$block$1(this, null), 1)).invoke(continuation);
        if (this.state == this) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public final void shutdown() {
        DisposableHandle disposableHandle = this.disposable;
        if (disposableHandle != null) {
            disposableHandle.dispose();
        }
        Continuation continuation = this.end;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m2081constructorimpl(ResultKt.createFailure(new CancellationException("Stream closed"))));
    }

    public final int submitAndAwait(byte[] buffer, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.offset = i;
        this.length = i2;
        return submitAndAwait(buffer);
    }

    public final int submitAndAwait(Object jobToken) {
        Object obj;
        Object noWhenBranchMatchedException;
        Intrinsics.checkNotNullParameter(jobToken, "jobToken");
        Thread thread = Thread.currentThread();
        Continuation continuation = null;
        do {
            obj = this.state;
            if (obj instanceof Continuation) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any>");
                continuation = (Continuation) obj;
                noWhenBranchMatchedException = thread;
            } else if (obj instanceof Unit) {
                return this.result;
            } else {
                if (obj instanceof Throwable) {
                    throw ((Throwable) obj);
                }
                if (obj instanceof Thread) {
                    throw new IllegalStateException("There is already thread owning adapter");
                }
                if (Intrinsics.areEqual(obj, this)) {
                    throw new IllegalStateException("Not yet started");
                }
                noWhenBranchMatchedException = new NoWhenBranchMatchedException();
            }
            Intrinsics.checkNotNullExpressionValue(noWhenBranchMatchedException, "when (value) {\n         …Exception()\n            }");
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(state$FU, this, obj, noWhenBranchMatchedException));
        Intrinsics.checkNotNull(continuation);
        continuation.resumeWith(Result.m2081constructorimpl(jobToken));
        Intrinsics.checkNotNullExpressionValue(thread, "thread");
        parkingLoop(thread);
        Object obj2 = this.state;
        if (obj2 instanceof Throwable) {
            throw ((Throwable) obj2);
        }
        return this.result;
    }

    private final void parkingLoop(Thread thread) {
        if (this.state != thread) {
            return;
        }
        if (!PollersKt.isParkingAllowed()) {
            BlockingKt.access$getADAPTER_LOGGER().warn("Blocking network thread detected. \nIt can possible lead to a performance decline or even a deadlock.\nPlease make sure you're using blocking IO primitives like InputStream and OutputStream only in \nthe context of Dispatchers.IO:\n```\nwithContext(Dispatchers.IO) {\n    myInputStream.read()\n}\n```");
        }
        while (true) {
            long processNextEventInCurrentThread = EventLoopKt.processNextEventInCurrentThread();
            if (this.state != thread) {
                return;
            }
            if (processNextEventInCurrentThread > 0) {
                PollersKt.getParkingImpl().park(processNextEventInCurrentThread);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object rendezvousBlock(Continuation continuation) {
        Continuation intercepted;
        Object obj;
        Continuation continuation2;
        Object coroutine_suspended;
        Object obj2 = null;
        while (true) {
            Object obj3 = this.state;
            if (obj3 instanceof Thread) {
                continuation2 = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
                obj = obj3;
            } else if (!Intrinsics.areEqual(obj3, this)) {
                throw new IllegalStateException("Already suspended or in finished state");
            } else {
                intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
                obj = obj2;
                continuation2 = intercepted;
            }
            if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(state$FU, this, obj3, continuation2)) {
                if (obj != null) {
                    PollersKt.getParkingImpl().unpark(obj);
                }
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                return coroutine_suspended;
            }
            obj2 = obj;
        }
    }
}
