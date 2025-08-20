package androidx.compose.foundation.lazy.layout;
/* compiled from: LazyLayoutPrefetchState.kt */
/* loaded from: classes.dex */
public final class LazyLayoutPrefetchState {
    private Prefetcher prefetcher;

    /* compiled from: LazyLayoutPrefetchState.kt */
    /* loaded from: classes.dex */
    public interface PrefetchHandle {
        void cancel();
    }

    /* compiled from: LazyLayoutPrefetchState.kt */
    /* loaded from: classes.dex */
    public interface Prefetcher {
        /* renamed from: schedulePrefetch-0kLqBqw  reason: not valid java name */
        PrefetchHandle mo270schedulePrefetch0kLqBqw(int i, long j);
    }

    public final void setPrefetcher$foundation_release(Prefetcher prefetcher) {
        this.prefetcher = prefetcher;
    }

    /* renamed from: schedulePrefetch-0kLqBqw  reason: not valid java name */
    public final PrefetchHandle m269schedulePrefetch0kLqBqw(int i, long j) {
        PrefetchHandle mo270schedulePrefetch0kLqBqw;
        Prefetcher prefetcher = this.prefetcher;
        return (prefetcher == null || (mo270schedulePrefetch0kLqBqw = prefetcher.mo270schedulePrefetch0kLqBqw(i, j)) == null) ? DummyHandle.INSTANCE : mo270schedulePrefetch0kLqBqw;
    }
}
