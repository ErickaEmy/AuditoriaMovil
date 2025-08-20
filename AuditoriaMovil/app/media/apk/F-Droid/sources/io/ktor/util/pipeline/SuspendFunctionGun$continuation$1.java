package io.ktor.util.pipeline;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SuspendFunctionGun.kt */
/* loaded from: classes.dex */
public final class SuspendFunctionGun$continuation$1 implements Continuation, CoroutineStackFrame {
    private int currentIndex = Integer.MIN_VALUE;
    final /* synthetic */ SuspendFunctionGun this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SuspendFunctionGun$continuation$1(SuspendFunctionGun suspendFunctionGun) {
        this.this$0 = suspendFunctionGun;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation peekContinuation = peekContinuation();
        if (peekContinuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) peekContinuation;
        }
        return null;
    }

    private final Continuation peekContinuation() {
        Continuation[] continuationArr;
        int i;
        if (this.currentIndex == Integer.MIN_VALUE) {
            i = this.this$0.lastSuspensionIndex;
            this.currentIndex = i;
        }
        if (this.currentIndex < 0) {
            this.currentIndex = Integer.MIN_VALUE;
            return null;
        }
        try {
            continuationArr = this.this$0.suspensions;
            int i2 = this.currentIndex;
            Continuation continuation = continuationArr[i2];
            if (continuation == null) {
                return StackWalkingFailedFrame.INSTANCE;
            }
            this.currentIndex = i2 - 1;
            return continuation;
        } catch (Throwable unused) {
            return StackWalkingFailedFrame.INSTANCE;
        }
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        Continuation[] continuationArr;
        int i;
        CoroutineContext context;
        continuationArr = this.this$0.suspensions;
        i = this.this$0.lastSuspensionIndex;
        Continuation continuation = continuationArr[i];
        if (continuation == null || (context = continuation.getContext()) == null) {
            throw new IllegalStateException("Not started".toString());
        }
        return context;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        if (!Result.m2086isFailureimpl(obj)) {
            this.this$0.loop(false);
            return;
        }
        SuspendFunctionGun suspendFunctionGun = this.this$0;
        Throwable m2084exceptionOrNullimpl = Result.m2084exceptionOrNullimpl(obj);
        Intrinsics.checkNotNull(m2084exceptionOrNullimpl);
        suspendFunctionGun.resumeRootWith(Result.m2081constructorimpl(ResultKt.createFailure(m2084exceptionOrNullimpl)));
    }
}
