package io.ktor.utils.io.internal;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ReadWriteBufferState.kt */
/* loaded from: classes.dex */
public abstract class ReadWriteBufferStateKt {
    private static final ByteBuffer EmptyByteBuffer;
    private static final RingBufferCapacity EmptyCapacity;

    public static final ByteBuffer getEmptyByteBuffer() {
        return EmptyByteBuffer;
    }

    public static final RingBufferCapacity getEmptyCapacity() {
        return EmptyCapacity;
    }

    static {
        ByteBuffer allocate = ByteBuffer.allocate(0);
        Intrinsics.checkNotNullExpressionValue(allocate, "allocate(0)");
        EmptyByteBuffer = allocate;
        EmptyCapacity = new RingBufferCapacity(0);
    }
}
