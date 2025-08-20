package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
/* loaded from: classes.dex */
public interface Deferred<T> extends Job {
    Object await(Continuation<? super T> continuation);

    T getCompleted();

    Throwable getCompletionExceptionOrNull();
}
