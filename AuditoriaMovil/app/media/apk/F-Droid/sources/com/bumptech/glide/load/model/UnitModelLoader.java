package com.bumptech.glide.load.model;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
/* loaded from: classes.dex */
public class UnitModelLoader implements ModelLoader {
    private static final UnitModelLoader INSTANCE = new UnitModelLoader();

    public static UnitModelLoader getInstance() {
        return INSTANCE;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(Object obj) {
        return true;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData buildLoadData(Object obj, int i, int i2, Options options) {
        return new ModelLoader.LoadData(new ObjectKey(obj), new UnitFetcher(obj));
    }

    /* loaded from: classes.dex */
    private static class UnitFetcher implements DataFetcher {
        private final Object resource;

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
        }

        UnitFetcher(Object obj) {
            this.resource = obj;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void loadData(Priority priority, DataFetcher.DataCallback dataCallback) {
            dataCallback.onDataReady(this.resource);
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public Class getDataClass() {
            return this.resource.getClass();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }
    }

    /* loaded from: classes.dex */
    public static class Factory implements ModelLoaderFactory {
        private static final Factory FACTORY = new Factory();

        public static Factory getInstance() {
            return FACTORY;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return UnitModelLoader.getInstance();
        }
    }
}
