package kotlin.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public interface ContinuationInterceptor extends CoroutineContext.Element {
    public static final Key Key = Key.$$INSTANCE;

    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static <E extends CoroutineContext.Element> E get(ContinuationInterceptor continuationInterceptor, CoroutineContext.Key<E> key) {
            Intrinsics.checkNotNullParameter(key, "key");
            if (key instanceof AbstractCoroutineContextKey) {
                AbstractCoroutineContextKey abstractCoroutineContextKey = (AbstractCoroutineContextKey) key;
                if (!abstractCoroutineContextKey.isSubKey$kotlin_stdlib(continuationInterceptor.getKey())) {
                    return null;
                }
                E e2 = (E) abstractCoroutineContextKey.tryCast$kotlin_stdlib(continuationInterceptor);
                if (!(e2 instanceof CoroutineContext.Element)) {
                    return null;
                }
                return e2;
            } else if (ContinuationInterceptor.Key != key) {
                return null;
            } else {
                Intrinsics.checkNotNull(continuationInterceptor, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return continuationInterceptor;
            }
        }

        public static CoroutineContext minusKey(ContinuationInterceptor continuationInterceptor, CoroutineContext.Key<?> key) {
            Intrinsics.checkNotNullParameter(key, "key");
            if (key instanceof AbstractCoroutineContextKey) {
                AbstractCoroutineContextKey abstractCoroutineContextKey = (AbstractCoroutineContextKey) key;
                if (abstractCoroutineContextKey.isSubKey$kotlin_stdlib(continuationInterceptor.getKey()) && abstractCoroutineContextKey.tryCast$kotlin_stdlib(continuationInterceptor) != null) {
                    return EmptyCoroutineContext.INSTANCE;
                }
                return continuationInterceptor;
            } else if (ContinuationInterceptor.Key == key) {
                return EmptyCoroutineContext.INSTANCE;
            } else {
                return continuationInterceptor;
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class Key implements CoroutineContext.Key<ContinuationInterceptor> {
        static final /* synthetic */ Key $$INSTANCE = new Key();

        private Key() {
        }
    }

    <T> Continuation<T> interceptContinuation(Continuation<? super T> continuation);

    void releaseInterceptedContinuation(Continuation<?> continuation);
}
