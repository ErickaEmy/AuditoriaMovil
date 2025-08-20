package kotlinx.coroutines.reactive;

import he1.y;
import java.util.ServiceLoader;
import kotlin.coroutines.CoroutineContext;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.flow.Flow;
/* loaded from: classes.dex */
public final class ReactiveFlowKt {
    private static final ContextInjector[] contextInjectors = (ContextInjector[]) SequencesKt.toList(SequencesKt.asSequence(ServiceLoader.load(ContextInjector.class, ContextInjector.class.getClassLoader()).iterator())).toArray(new ContextInjector[0]);

    public static final <T> Flow<T> asFlow(y<T> yVar) {
        return new PublisherAsFlow(yVar, null, 0, null, 14, null);
    }

    public static final <T> y<T> injectCoroutineContext(y<T> yVar, CoroutineContext coroutineContext) {
        for (ContextInjector contextInjector : contextInjectors) {
            yVar = contextInjector.injectCoroutineContext(yVar, coroutineContext);
        }
        return yVar;
    }
}
