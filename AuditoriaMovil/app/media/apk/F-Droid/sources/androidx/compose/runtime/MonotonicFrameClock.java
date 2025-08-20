package androidx.compose.runtime;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MonotonicFrameClock.kt */
/* loaded from: classes.dex */
public interface MonotonicFrameClock extends CoroutineContext.Element {
    public static final Key Key = Key.$$INSTANCE;

    /* compiled from: MonotonicFrameClock.kt */
    /* loaded from: classes.dex */
    public static final class Key implements CoroutineContext.Key {
        static final /* synthetic */ Key $$INSTANCE = new Key();

        private Key() {
        }
    }

    Object withFrameNanos(Function1 function1, Continuation continuation);

    /* compiled from: MonotonicFrameClock.kt */
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static Object fold(MonotonicFrameClock monotonicFrameClock, Object obj, Function2 operation) {
            Intrinsics.checkNotNullParameter(operation, "operation");
            return CoroutineContext.Element.DefaultImpls.fold(monotonicFrameClock, obj, operation);
        }

        public static CoroutineContext.Element get(MonotonicFrameClock monotonicFrameClock, CoroutineContext.Key key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return CoroutineContext.Element.DefaultImpls.get(monotonicFrameClock, key);
        }

        public static CoroutineContext minusKey(MonotonicFrameClock monotonicFrameClock, CoroutineContext.Key key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return CoroutineContext.Element.DefaultImpls.minusKey(monotonicFrameClock, key);
        }

        public static CoroutineContext plus(MonotonicFrameClock monotonicFrameClock, CoroutineContext context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return CoroutineContext.Element.DefaultImpls.plus(monotonicFrameClock, context);
        }
    }

    /* compiled from: MonotonicFrameClock.kt */
    /* renamed from: androidx.compose.runtime.MonotonicFrameClock$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
    }
}
