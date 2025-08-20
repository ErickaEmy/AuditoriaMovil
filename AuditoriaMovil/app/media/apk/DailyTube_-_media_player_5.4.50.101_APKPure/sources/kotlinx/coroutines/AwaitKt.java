package kotlinx.coroutines;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
/* loaded from: classes.dex */
public final class AwaitKt {
    public static final <T> Object awaitAll(Collection<? extends Deferred<? extends T>> collection, Continuation<? super List<? extends T>> continuation) {
        if (collection.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        return new AwaitAll((Deferred[]) collection.toArray(new Deferred[0])).await(continuation);
    }
}
