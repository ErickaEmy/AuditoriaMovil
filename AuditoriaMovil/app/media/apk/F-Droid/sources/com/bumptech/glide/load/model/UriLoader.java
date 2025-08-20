package com.bumptech.glide.load.model;

import android.content.ContentResolver;
import android.net.Uri;
import ch.qos.logback.core.joran.action.Action;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.AssetFileDescriptorLocalUriFetcher;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.FileDescriptorLocalUriFetcher;
import com.bumptech.glide.load.data.StreamLocalUriFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class UriLoader implements ModelLoader {
    private static final Set SCHEMES = Collections.unmodifiableSet(new HashSet(Arrays.asList(Action.FILE_ATTRIBUTE, "content", "android.resource")));
    private final LocalUriFetcherFactory factory;

    /* loaded from: classes.dex */
    public interface LocalUriFetcherFactory {
        DataFetcher build(Uri uri);
    }

    public UriLoader(LocalUriFetcherFactory localUriFetcherFactory) {
        this.factory = localUriFetcherFactory;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData buildLoadData(Uri uri, int i, int i2, Options options) {
        return new ModelLoader.LoadData(new ObjectKey(uri), this.factory.build(uri));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(Uri uri) {
        return SCHEMES.contains(uri.getScheme());
    }

    /* loaded from: classes.dex */
    public static class StreamFactory implements ModelLoaderFactory, LocalUriFetcherFactory {
        private final ContentResolver contentResolver;

        public StreamFactory(ContentResolver contentResolver) {
            this.contentResolver = contentResolver;
        }

        @Override // com.bumptech.glide.load.model.UriLoader.LocalUriFetcherFactory
        public DataFetcher build(Uri uri) {
            return new StreamLocalUriFetcher(this.contentResolver, uri);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UriLoader(this);
        }
    }

    /* loaded from: classes.dex */
    public static class FileDescriptorFactory implements ModelLoaderFactory, LocalUriFetcherFactory {
        private final ContentResolver contentResolver;

        public FileDescriptorFactory(ContentResolver contentResolver) {
            this.contentResolver = contentResolver;
        }

        @Override // com.bumptech.glide.load.model.UriLoader.LocalUriFetcherFactory
        public DataFetcher build(Uri uri) {
            return new FileDescriptorLocalUriFetcher(this.contentResolver, uri);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UriLoader(this);
        }
    }

    /* loaded from: classes.dex */
    public static final class AssetFileDescriptorFactory implements ModelLoaderFactory, LocalUriFetcherFactory {
        private final ContentResolver contentResolver;

        public AssetFileDescriptorFactory(ContentResolver contentResolver) {
            this.contentResolver = contentResolver;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UriLoader(this);
        }

        @Override // com.bumptech.glide.load.model.UriLoader.LocalUriFetcherFactory
        public DataFetcher build(Uri uri) {
            return new AssetFileDescriptorLocalUriFetcher(this.contentResolver, uri);
        }
    }
}
