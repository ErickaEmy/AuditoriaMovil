package io.reactivex.rxjava3.disposables;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class RunnableDisposable extends ReferenceDisposable {
    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableDisposable(Runnable runnable) {
        super(runnable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.reactivex.rxjava3.disposables.ReferenceDisposable
    public void onDisposed(Runnable runnable) {
        runnable.run();
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public String toString() {
        return "RunnableDisposable(disposed=" + isDisposed() + ", " + get() + ")";
    }
}
