package kotlinx.coroutines;
/* compiled from: CompletableDeferred.kt */
/* loaded from: classes2.dex */
public interface CompletableDeferred extends Deferred {
    boolean complete(Object obj);

    boolean completeExceptionally(Throwable th);
}
