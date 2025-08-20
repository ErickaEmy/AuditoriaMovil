package com.bumptech.glide.util;
/* loaded from: classes.dex */
public abstract class GlideSuppliers {

    /* loaded from: classes.dex */
    public interface GlideSupplier {
        Object get();
    }

    public static GlideSupplier memorize(final GlideSupplier glideSupplier) {
        return new GlideSupplier() { // from class: com.bumptech.glide.util.GlideSuppliers.1
            private volatile Object instance;

            @Override // com.bumptech.glide.util.GlideSuppliers.GlideSupplier
            public Object get() {
                if (this.instance == null) {
                    synchronized (this) {
                        try {
                            if (this.instance == null) {
                                this.instance = Preconditions.checkNotNull(GlideSupplier.this.get());
                            }
                        } finally {
                        }
                    }
                }
                return this.instance;
            }
        };
    }
}
