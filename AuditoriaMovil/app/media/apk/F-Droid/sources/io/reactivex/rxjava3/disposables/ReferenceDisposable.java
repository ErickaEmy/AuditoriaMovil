package io.reactivex.rxjava3.disposables;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
abstract class ReferenceDisposable extends AtomicReference implements Disposable {
    protected abstract void onDisposed(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReferenceDisposable(Object obj) {
        super(obj);
        Objects.requireNonNull(obj, "value is null");
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final void dispose() {
        Object andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        onDisposed(andSet);
    }

    @Override // io.reactivex.rxjava3.disposables.Disposable
    public final boolean isDisposed() {
        return get() == null;
    }
}
