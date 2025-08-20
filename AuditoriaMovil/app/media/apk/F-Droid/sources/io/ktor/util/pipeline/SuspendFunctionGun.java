package io.ktor.util.pipeline;

import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SuspendFunctionGun.kt */
/* loaded from: classes.dex */
public final class SuspendFunctionGun extends PipelineContext {
    private final List blocks;
    private final Continuation continuation;
    private int index;
    private int lastSuspensionIndex;
    private Object subject;
    private final Continuation[] suspensions;

    public Object getSubject() {
        return this.subject;
    }

    public void setSubject(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<set-?>");
        this.subject = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuspendFunctionGun(Object initial, Object context, List blocks) {
        super(context);
        Intrinsics.checkNotNullParameter(initial, "initial");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(blocks, "blocks");
        this.blocks = blocks;
        this.continuation = new SuspendFunctionGun$continuation$1(this);
        this.subject = initial;
        this.suspensions = new Continuation[blocks.size()];
        this.lastSuspensionIndex = -1;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.continuation.getContext();
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public Object proceed(Continuation continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        if (this.index == this.blocks.size()) {
            coroutine_suspended = getSubject();
        } else {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            addContinuation(intercepted);
            if (loop(true)) {
                discardLastRootContinuation();
                coroutine_suspended = getSubject();
            } else {
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
        }
        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (coroutine_suspended == coroutine_suspended2) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return coroutine_suspended;
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public Object proceedWith(Object obj, Continuation continuation) {
        setSubject(obj);
        return proceed(continuation);
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public Object execute$ktor_utils(Object obj, Continuation continuation) {
        this.index = 0;
        if (this.blocks.size() == 0) {
            return obj;
        }
        setSubject(obj);
        if (this.lastSuspensionIndex >= 0) {
            throw new IllegalStateException("Already started");
        }
        return proceed(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean loop(boolean z) {
        Object invoke;
        Object coroutine_suspended;
        do {
            int i = this.index;
            if (i == this.blocks.size()) {
                if (z) {
                    return true;
                }
                Result.Companion companion = Result.Companion;
                resumeRootWith(Result.m2081constructorimpl(getSubject()));
                return false;
            }
            this.index = i + 1;
            try {
                invoke = ((Function3) this.blocks.get(i)).invoke(this, getSubject(), this.continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                resumeRootWith(Result.m2081constructorimpl(ResultKt.createFailure(th)));
                return false;
            }
        } while (invoke != coroutine_suspended);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resumeRootWith(Object obj) {
        int i = this.lastSuspensionIndex;
        if (i < 0) {
            throw new IllegalStateException("No more continuations to resume".toString());
        }
        Continuation continuation = this.suspensions[i];
        Intrinsics.checkNotNull(continuation);
        Continuation[] continuationArr = this.suspensions;
        int i2 = this.lastSuspensionIndex;
        this.lastSuspensionIndex = i2 - 1;
        continuationArr[i2] = null;
        if (!Result.m2086isFailureimpl(obj)) {
            continuation.resumeWith(obj);
            return;
        }
        Throwable m2084exceptionOrNullimpl = Result.m2084exceptionOrNullimpl(obj);
        Intrinsics.checkNotNull(m2084exceptionOrNullimpl);
        continuation.resumeWith(Result.m2081constructorimpl(ResultKt.createFailure(StackTraceRecoverKt.recoverStackTraceBridge(m2084exceptionOrNullimpl, continuation))));
    }

    private final void discardLastRootContinuation() {
        int i = this.lastSuspensionIndex;
        if (i < 0) {
            throw new IllegalStateException("No more continuations to resume");
        }
        Continuation[] continuationArr = this.suspensions;
        this.lastSuspensionIndex = i - 1;
        continuationArr[i] = null;
    }

    private final void addContinuation(Continuation continuation) {
        Continuation[] continuationArr = this.suspensions;
        int i = this.lastSuspensionIndex + 1;
        this.lastSuspensionIndex = i;
        continuationArr[i] = continuation;
    }
}
