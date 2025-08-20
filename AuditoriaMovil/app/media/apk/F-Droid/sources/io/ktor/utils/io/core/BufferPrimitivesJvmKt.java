package io.ktor.utils.io.core;

import io.ktor.utils.io.bits.MemoryJvmKt;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BufferPrimitivesJvm.kt */
/* loaded from: classes.dex */
public abstract class BufferPrimitivesJvmKt {
    public static final void writeFully(Buffer buffer, ByteBuffer source) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        int remaining = source.remaining();
        ByteBuffer m2064getMemorySK3TCg8 = buffer.m2064getMemorySK3TCg8();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit >= remaining) {
            MemoryJvmKt.m2063copyToSG11BkQ(source, m2064getMemorySK3TCg8, writePosition);
            buffer.commitWritten(remaining);
            return;
        }
        throw new InsufficientSpaceException("buffer content", remaining, limit);
    }
}
