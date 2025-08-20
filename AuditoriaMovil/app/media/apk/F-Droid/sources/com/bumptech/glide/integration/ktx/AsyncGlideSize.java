package com.bumptech.glide.integration.ktx;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Flows.kt */
/* loaded from: classes.dex */
public final class AsyncGlideSize extends ResolvableGlideSize {
    private final Function1 asyncSize;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AsyncGlideSize) && Intrinsics.areEqual(this.asyncSize, ((AsyncGlideSize) obj).asyncSize);
    }

    public final Function1 getAsyncSize() {
        return this.asyncSize;
    }

    public int hashCode() {
        return this.asyncSize.hashCode();
    }

    public String toString() {
        return "AsyncGlideSize(asyncSize=" + this.asyncSize + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsyncGlideSize(Function1 asyncSize) {
        super(null);
        Intrinsics.checkNotNullParameter(asyncSize, "asyncSize");
        this.asyncSize = asyncSize;
    }
}
