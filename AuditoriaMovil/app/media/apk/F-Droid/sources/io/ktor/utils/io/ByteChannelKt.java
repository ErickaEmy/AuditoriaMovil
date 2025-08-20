package io.ktor.utils.io;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ByteChannel.kt */
/* loaded from: classes.dex */
public abstract class ByteChannelKt {
    public static final ByteChannel ByteChannel(boolean z) {
        return new ByteBufferChannel(z, null, 0, 6, null);
    }

    public static /* synthetic */ ByteChannel ByteChannel$default(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return ByteChannel(z);
    }

    public static final ByteReadChannel ByteReadChannel(byte[] content, int i, int i2) {
        Intrinsics.checkNotNullParameter(content, "content");
        ByteBuffer wrap = ByteBuffer.wrap(content, i, i2);
        Intrinsics.checkNotNullExpressionValue(wrap, "wrap(content, offset, length)");
        return new ByteBufferChannel(wrap);
    }
}
