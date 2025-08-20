package com.bumptech.glide.load.data;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
/* loaded from: classes.dex */
public class FileDescriptorAssetPathFetcher extends AssetPathFetcher {
    @Override // com.bumptech.glide.load.data.DataFetcher
    public Class getDataClass() {
        return AssetFileDescriptor.class;
    }

    public FileDescriptorAssetPathFetcher(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.data.AssetPathFetcher
    public AssetFileDescriptor loadResource(AssetManager assetManager, String str) {
        return assetManager.openFd(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.data.AssetPathFetcher
    public void close(AssetFileDescriptor assetFileDescriptor) {
        assetFileDescriptor.close();
    }
}
