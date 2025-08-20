package com.bumptech.glide.util.pool;

import android.util.Log;
import androidx.core.util.Pools$Pool;
import androidx.core.util.Pools$SynchronizedPool;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class FactoryPools {
    private static final Resetter EMPTY_RESETTER = new Resetter() { // from class: com.bumptech.glide.util.pool.FactoryPools.1
        @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
        public void reset(Object obj) {
        }
    };

    /* loaded from: classes.dex */
    public interface Factory {
        Object create();
    }

    /* loaded from: classes.dex */
    public interface Poolable {
        StateVerifier getVerifier();
    }

    /* loaded from: classes.dex */
    public interface Resetter {
        void reset(Object obj);
    }

    private static Resetter emptyResetter() {
        return EMPTY_RESETTER;
    }

    public static Pools$Pool threadSafe(int i, Factory factory) {
        return build(new Pools$SynchronizedPool(i), factory);
    }

    public static Pools$Pool threadSafeList() {
        return threadSafeList(20);
    }

    public static Pools$Pool threadSafeList(int i) {
        return build(new Pools$SynchronizedPool(i), new Factory() { // from class: com.bumptech.glide.util.pool.FactoryPools.2
            @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
            public List create() {
                return new ArrayList();
            }
        }, new Resetter() { // from class: com.bumptech.glide.util.pool.FactoryPools.3
            @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
            public void reset(List list) {
                list.clear();
            }
        });
    }

    private static Pools$Pool build(Pools$Pool pools$Pool, Factory factory) {
        return build(pools$Pool, factory, emptyResetter());
    }

    private static Pools$Pool build(Pools$Pool pools$Pool, Factory factory, Resetter resetter) {
        return new FactoryPool(pools$Pool, factory, resetter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class FactoryPool implements Pools$Pool {
        private final Factory factory;
        private final Pools$Pool pool;
        private final Resetter resetter;

        FactoryPool(Pools$Pool pools$Pool, Factory factory, Resetter resetter) {
            this.pool = pools$Pool;
            this.factory = factory;
            this.resetter = resetter;
        }

        @Override // androidx.core.util.Pools$Pool
        public Object acquire() {
            Object acquire = this.pool.acquire();
            if (acquire == null) {
                acquire = this.factory.create();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + acquire.getClass());
                }
            }
            if (acquire instanceof Poolable) {
                ((Poolable) acquire).getVerifier().setRecycled(false);
            }
            return acquire;
        }

        @Override // androidx.core.util.Pools$Pool
        public boolean release(Object obj) {
            if (obj instanceof Poolable) {
                ((Poolable) obj).getVerifier().setRecycled(true);
            }
            this.resetter.reset(obj);
            return this.pool.release(obj);
        }
    }
}
