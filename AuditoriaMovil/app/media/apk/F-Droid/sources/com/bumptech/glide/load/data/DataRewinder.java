package com.bumptech.glide.load.data;
/* loaded from: classes.dex */
public interface DataRewinder {

    /* loaded from: classes.dex */
    public interface Factory {
        DataRewinder build(Object obj);

        Class getDataClass();
    }

    void cleanup();

    Object rewindAndGet();
}
