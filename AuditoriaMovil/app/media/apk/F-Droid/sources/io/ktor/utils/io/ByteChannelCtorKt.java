package io.ktor.utils.io;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: ByteChannelCtor.kt */
/* loaded from: classes.dex */
public abstract class ByteChannelCtorKt {
    public static final ByteReadChannel ByteReadChannel(byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        return ByteChannelKt.ByteReadChannel(content, 0, content.length);
    }
}
