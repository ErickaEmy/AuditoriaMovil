package com.bumptech.glide.util.pool;
/* loaded from: classes.dex */
public abstract class StateVerifier {
    private StateVerifier() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setRecycled(boolean z);

    public abstract void throwIfRecycled();

    public static StateVerifier newInstance() {
        return new DefaultStateVerifier();
    }

    /* loaded from: classes.dex */
    private static class DefaultStateVerifier extends StateVerifier {
        private volatile boolean isReleased;

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void setRecycled(boolean z) {
            this.isReleased = z;
        }

        DefaultStateVerifier() {
            super();
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void throwIfRecycled() {
            if (this.isReleased) {
                throw new IllegalStateException("Already released");
            }
        }
    }
}
