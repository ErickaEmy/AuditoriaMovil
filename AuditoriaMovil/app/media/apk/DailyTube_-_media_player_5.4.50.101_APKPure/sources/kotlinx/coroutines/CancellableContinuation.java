package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
/* loaded from: classes.dex */
public interface CancellableContinuation<T> extends Continuation<T> {
    void completeResume(Object obj);

    void invokeOnCancellation(Function1<? super Throwable, Unit> function1);

    boolean isCompleted();

    void resume(T t2, Function1<? super Throwable, Unit> function1);

    void resumeUndispatched(CoroutineDispatcher coroutineDispatcher, T t2);

    Object tryResume(T t2, Object obj, Function1<? super Throwable, Unit> function1);

    Object tryResumeWithException(Throwable th);
}
