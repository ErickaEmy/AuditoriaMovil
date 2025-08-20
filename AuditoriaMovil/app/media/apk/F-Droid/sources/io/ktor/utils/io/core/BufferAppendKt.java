package io.ktor.utils.io.core;

import io.ktor.utils.io.bits.Memory;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BufferAppend.kt */
/* loaded from: classes.dex */
public abstract class BufferAppendKt {
    public static final int writeBufferAppend(Buffer buffer, Buffer other, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(other.getWritePosition() - other.getReadPosition(), i);
        if (buffer.getLimit() - buffer.getWritePosition() <= min) {
            writeBufferAppendUnreserve(buffer, min);
        }
        ByteBuffer m2064getMemorySK3TCg8 = buffer.m2064getMemorySK3TCg8();
        int writePosition = buffer.getWritePosition();
        buffer.getLimit();
        ByteBuffer m2064getMemorySK3TCg82 = other.m2064getMemorySK3TCg8();
        int readPosition = other.getReadPosition();
        other.getWritePosition();
        Memory.m2058copyToJT6ljtQ(m2064getMemorySK3TCg82, m2064getMemorySK3TCg8, readPosition, min, writePosition);
        other.discardExact(min);
        buffer.commitWritten(min);
        return min;
    }

    private static final void writeBufferAppendUnreserve(Buffer buffer, int i) {
        if ((buffer.getLimit() - buffer.getWritePosition()) + (buffer.getCapacity() - buffer.getLimit()) < i) {
            throw new IllegalArgumentException("Can't append buffer: not enough free space at the end");
        }
        if ((buffer.getWritePosition() + i) - buffer.getLimit() > 0) {
            buffer.releaseEndGap$ktor_io();
        }
    }
}
