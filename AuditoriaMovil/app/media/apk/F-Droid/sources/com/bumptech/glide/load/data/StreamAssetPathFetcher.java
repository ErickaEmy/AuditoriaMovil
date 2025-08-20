package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import java.io.InputStream;
/* loaded from: classes.dex */
public class StreamAssetPathFetcher extends AssetPathFetcher {
    @Override // com.bumptech.glide.load.data.DataFetcher
    public Class getDataClass() {
        return InputStream.class;
    }

    public StreamAssetPathFetcher(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.data.AssetPathFetcher
    public InputStream loadResource(AssetManager assetManager, String str) {
        return assetManager.open(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.data.AssetPathFetcher
    public void close(InputStream inputStream) {
        inputStream.close();
    }
}
