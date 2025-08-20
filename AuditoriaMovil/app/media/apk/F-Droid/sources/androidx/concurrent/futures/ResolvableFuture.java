package androidx.concurrent.futures;
/* loaded from: classes.dex */
public final class ResolvableFuture extends AbstractResolvableFuture {
    public static ResolvableFuture create() {
        return new ResolvableFuture();
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    public boolean set(Object obj) {
        return super.set(obj);
    }

    private ResolvableFuture() {
    }
}
