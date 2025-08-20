package io.ktor.utils.io.core;

import ch.qos.logback.core.CoreConstants;
import io.ktor.utils.io.bits.MemoryJvmKt;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BufferUtilsJvm.kt */
/* loaded from: classes.dex */
public abstract class BufferUtilsJvmKt {
    public static final void readFully(Buffer buffer, ByteBuffer dst, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(dst, "dst");
        ByteBuffer m2064getMemorySK3TCg8 = buffer.m2064getMemorySK3TCg8();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= i) {
            int limit = dst.limit();
            try {
                dst.limit(dst.position() + i);
                MemoryJvmKt.m2061copyTo62zg_DM(m2064getMemorySK3TCg8, dst, readPosition);
                dst.limit(limit);
                Unit unit = Unit.INSTANCE;
                buffer.discardExact(i);
                return;
            } catch (Throwable th) {
                dst.limit(limit);
                throw th;
            }
        }
        throw new EOFException("Not enough bytes to read a buffer content of size " + i + CoreConstants.DOT);
    }
}
