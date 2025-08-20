package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.util.Util;
import java.util.Queue;
/* loaded from: classes.dex */
abstract class BaseKeyPool {
    private final Queue keyPool = Util.createQueue(20);

    abstract Poolable create();

    /* JADX INFO: Access modifiers changed from: package-private */
    public Poolable get() {
        Poolable poolable = (Poolable) this.keyPool.poll();
        return poolable == null ? create() : poolable;
    }

    public void offer(Poolable poolable) {
        if (this.keyPool.size() < 20) {
            this.keyPool.offer(poolable);
        }
    }
}
