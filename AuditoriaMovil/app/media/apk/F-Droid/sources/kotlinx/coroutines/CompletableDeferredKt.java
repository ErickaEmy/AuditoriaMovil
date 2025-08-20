package kotlinx.coroutines;
/* compiled from: CompletableDeferred.kt */
/* loaded from: classes2.dex */
public abstract class CompletableDeferredKt {
    public static final CompletableDeferred CompletableDeferred(Job job) {
        return new CompletableDeferredImpl(job);
    }

    public static /* synthetic */ CompletableDeferred CompletableDeferred$default(Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            job = null;
        }
        return CompletableDeferred(job);
    }
}
