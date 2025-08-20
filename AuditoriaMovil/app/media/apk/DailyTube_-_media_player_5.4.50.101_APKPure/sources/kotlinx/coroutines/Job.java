package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
/* loaded from: classes.dex */
public interface Job extends CoroutineContext.Element {
    public static final Key Key = Key.$$INSTANCE;

    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void cancel$default(Job job, CancellationException cancellationException, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    cancellationException = null;
                }
                job.cancel(cancellationException);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static <R> R fold(Job job, R r2, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return (R) CoroutineContext.Element.DefaultImpls.fold(job, r2, function2);
        }

        public static <E extends CoroutineContext.Element> E get(Job job, CoroutineContext.Key<E> key) {
            return (E) CoroutineContext.Element.DefaultImpls.get(job, key);
        }

        public static /* synthetic */ DisposableHandle invokeOnCompletion$default(Job job, boolean z2, boolean z3, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z2 = false;
                }
                if ((i & 2) != 0) {
                    z3 = true;
                }
                return job.invokeOnCompletion(z2, z3, function1);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
        }

        public static CoroutineContext minusKey(Job job, CoroutineContext.Key<?> key) {
            return CoroutineContext.Element.DefaultImpls.minusKey(job, key);
        }

        public static CoroutineContext plus(Job job, CoroutineContext coroutineContext) {
            return CoroutineContext.Element.DefaultImpls.plus(job, coroutineContext);
        }
    }

    /* loaded from: classes.dex */
    public static final class Key implements CoroutineContext.Key<Job> {
        static final /* synthetic */ Key $$INSTANCE = new Key();

        private Key() {
        }
    }

    ChildHandle attachChild(ChildJob childJob);

    void cancel(CancellationException cancellationException);

    CancellationException getCancellationException();

    Job getParent();

    DisposableHandle invokeOnCompletion(Function1<? super Throwable, Unit> function1);

    DisposableHandle invokeOnCompletion(boolean z2, boolean z3, Function1<? super Throwable, Unit> function1);

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    Object join(Continuation<? super Unit> continuation);

    boolean start();
}
