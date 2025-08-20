package kotlinx.coroutines;
/* loaded from: classes.dex */
public interface CompletableDeferred<T> extends Deferred<T> {
    boolean complete(T t2);

    boolean completeExceptionally(Throwable th);
}
