package io.ktor.utils.io.core;

import ch.qos.logback.core.CoreConstants;
import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.bits.MemoryJvmKt;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BufferPrimitives.kt */
/* loaded from: classes.dex */
public abstract class BufferPrimitivesKt {
    public static final void readFully(Buffer buffer, byte[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        ByteBuffer m2064getMemorySK3TCg8 = buffer.m2064getMemorySK3TCg8();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= i2) {
            MemoryJvmKt.m2062copyTo9zorpBc(m2064getMemorySK3TCg8, destination, readPosition, i2, i);
            Unit unit = Unit.INSTANCE;
            buffer.discardExact(i2);
            return;
        }
        throw new EOFException("Not enough bytes to read a byte array of size " + i2 + CoreConstants.DOT);
    }

    public static final short readShort(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer m2064getMemorySK3TCg8 = buffer.m2064getMemorySK3TCg8();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= 2) {
            Short valueOf = Short.valueOf(m2064getMemorySK3TCg8.getShort(readPosition));
            buffer.discardExact(2);
            return valueOf.shortValue();
        }
        throw new EOFException("Not enough bytes to read a short integer of size 2" + CoreConstants.DOT);
    }

    public static final void writeFully(Buffer buffer, byte[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        ByteBuffer m2064getMemorySK3TCg8 = buffer.m2064getMemorySK3TCg8();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit >= i2) {
            ByteBuffer order = ByteBuffer.wrap(source, i, i2).slice().order(ByteOrder.BIG_ENDIAN);
            Intrinsics.checkNotNullExpressionValue(order, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
            Memory.m2058copyToJT6ljtQ(Memory.m2057constructorimpl(order), m2064getMemorySK3TCg8, 0, i2, writePosition);
            buffer.commitWritten(i2);
            return;
        }
        throw new InsufficientSpaceException("byte array", i2, limit);
    }

    public static final void writeShort(Buffer buffer, short s) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer m2064getMemorySK3TCg8 = buffer.m2064getMemorySK3TCg8();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit >= 2) {
            m2064getMemorySK3TCg8.putShort(writePosition, s);
            buffer.commitWritten(2);
            return;
        }
        throw new InsufficientSpaceException("short integer", 2, limit);
    }
}
