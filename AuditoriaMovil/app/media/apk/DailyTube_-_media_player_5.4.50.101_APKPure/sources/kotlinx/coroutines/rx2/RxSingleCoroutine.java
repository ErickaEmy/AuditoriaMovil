package kotlinx.coroutines.rx2;

import eb1.z;
import kotlin.ExceptionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.AbstractCoroutine;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class RxSingleCoroutine<T> extends AbstractCoroutine<T> {
    private final z<T> subscriber;

    public RxSingleCoroutine(CoroutineContext coroutineContext, z<T> zVar) {
        super(coroutineContext, false, true);
        this.subscriber = zVar;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public void onCancelled(Throwable th, boolean z2) {
        try {
            if (this.subscriber.gv(th)) {
                return;
            }
        } catch (Throwable th2) {
            ExceptionsKt.addSuppressed(th, th2);
        }
        RxCancellableKt.handleUndeliverableException(th, getContext());
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public void onCompleted(T t2) {
        try {
            this.subscriber.onSuccess(t2);
        } catch (Throwable th) {
            RxCancellableKt.handleUndeliverableException(th, getContext());
        }
    }
}
