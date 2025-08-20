package com.bumptech.glide.integration.compose;

import com.bumptech.glide.integration.ktx.Size;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
/* compiled from: Sizes.kt */
/* loaded from: classes.dex */
public final class SizeObserver {
    private final CompletableDeferred size = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);

    public final void setSize(Size size) {
        Intrinsics.checkNotNullParameter(size, "size");
        this.size.complete(size);
    }

    public final Object getSize(Continuation continuation) {
        return this.size.await(continuation);
    }
}
