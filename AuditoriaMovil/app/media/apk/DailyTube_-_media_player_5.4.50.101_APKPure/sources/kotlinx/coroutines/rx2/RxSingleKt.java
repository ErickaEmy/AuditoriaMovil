package kotlinx.coroutines.rx2;

import eb1.co;
import eb1.x4;
import eb1.z;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.rx2.RxSingleKt;
/* loaded from: classes.dex */
public final class RxSingleKt {
    public static final <T> co<T> rxSingle(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        if (coroutineContext.get(Job.Key) == null) {
            return rxSingleInternal(GlobalScope.INSTANCE, coroutineContext, function2);
        }
        throw new IllegalArgumentException(("Single context cannot contain job in it.Its lifecycle should be managed via Disposable handle. Had " + coroutineContext).toString());
    }

    public static /* synthetic */ co rxSingle$default(CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return rxSingle(coroutineContext, function2);
    }

    private static final <T> co<T> rxSingleInternal(final CoroutineScope coroutineScope, final CoroutineContext coroutineContext, final Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        return co.n3(new x4() { // from class: hc1.y
            public final void y(z zVar) {
                RxSingleKt.rxSingleInternal$lambda$1(CoroutineScope.this, coroutineContext, function2, zVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rxSingleInternal$lambda$1(CoroutineScope coroutineScope, CoroutineContext coroutineContext, Function2 function2, z zVar) {
        RxSingleCoroutine rxSingleCoroutine = new RxSingleCoroutine(CoroutineContextKt.newCoroutineContext(coroutineScope, coroutineContext), zVar);
        zVar.y(new RxCancellable(rxSingleCoroutine));
        rxSingleCoroutine.start(CoroutineStart.DEFAULT, rxSingleCoroutine, function2);
    }
}
