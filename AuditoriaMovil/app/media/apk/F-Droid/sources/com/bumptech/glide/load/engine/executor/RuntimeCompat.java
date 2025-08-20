package com.bumptech.glide.load.engine.executor;
/* loaded from: classes.dex */
abstract class RuntimeCompat {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int availableProcessors() {
        return Runtime.getRuntime().availableProcessors();
    }
}
