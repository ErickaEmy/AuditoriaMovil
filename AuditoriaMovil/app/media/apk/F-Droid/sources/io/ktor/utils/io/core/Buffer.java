package io.ktor.utils.io.core;

import ch.qos.logback.core.CoreConstants;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
/* compiled from: Buffer.kt */
/* loaded from: classes.dex */
public abstract class Buffer {
    public static final Companion Companion = new Companion(null);
    private final int capacity;
    private int limit;
    private final ByteBuffer memory;
    private int readPosition;
    private int startGap;
    private int writePosition;

    public /* synthetic */ Buffer(ByteBuffer byteBuffer, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteBuffer);
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public final int getLimit() {
        return this.limit;
    }

    /* renamed from: getMemory-SK3TCg8  reason: not valid java name */
    public final ByteBuffer m2064getMemorySK3TCg8() {
        return this.memory;
    }

    public final int getReadPosition() {
        return this.readPosition;
    }

    public final int getStartGap() {
        return this.startGap;
    }

    public final int getWritePosition() {
        return this.writePosition;
    }

    public final void releaseEndGap$ktor_io() {
        this.limit = this.capacity;
    }

    public final void resetForWrite(int i) {
        int i2 = this.startGap;
        this.readPosition = i2;
        this.writePosition = i2;
        this.limit = i;
    }

    private Buffer(ByteBuffer memory) {
        Intrinsics.checkNotNullParameter(memory, "memory");
        this.memory = memory;
        this.limit = memory.limit();
        this.capacity = memory.limit();
    }

    public final byte readByte() {
        int i = this.readPosition;
        if (i != this.writePosition) {
            this.readPosition = i + 1;
            return this.memory.get(i);
        }
        throw new EOFException("No readable bytes available.");
    }

    public final void discardExact(int i) {
        if (i == 0) {
            return;
        }
        int i2 = this.readPosition + i;
        if (i < 0 || i2 > this.writePosition) {
            BufferKt.discardFailed(i, getWritePosition() - getReadPosition());
            throw new KotlinNothingValueException();
        } else {
            this.readPosition = i2;
        }
    }

    public final void discardUntilIndex$ktor_io(int i) {
        if (i < 0 || i > this.writePosition) {
            BufferKt.discardFailed(i - this.readPosition, getWritePosition() - getReadPosition());
            throw new KotlinNothingValueException();
        } else if (this.readPosition != i) {
            this.readPosition = i;
        }
    }

    public final void commitWritten(int i) {
        int i2 = this.writePosition + i;
        if (i < 0 || i2 > this.limit) {
            BufferKt.commitWrittenFailed(i, getLimit() - getWritePosition());
            throw new KotlinNothingValueException();
        } else {
            this.writePosition = i2;
        }
    }

    public final boolean commitWrittenUntilIndex(int i) {
        int i2 = this.limit;
        int i3 = this.writePosition;
        if (i < i3) {
            BufferKt.commitWrittenFailed(i - i3, getLimit() - getWritePosition());
            throw new KotlinNothingValueException();
        } else if (i < i2) {
            this.writePosition = i;
            return true;
        } else if (i == i2) {
            this.writePosition = i;
            return false;
        } else {
            BufferKt.commitWrittenFailed(i - i3, getLimit() - getWritePosition());
            throw new KotlinNothingValueException();
        }
    }

    public final void reserveStartGap(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(("startGap shouldn't be negative: " + i).toString());
        }
        int i2 = this.readPosition;
        if (i2 >= i) {
            this.startGap = i;
        } else if (i2 != this.writePosition) {
            BufferKt.startGapReservationFailed(this, i);
            throw new KotlinNothingValueException();
        } else if (i > this.limit) {
            BufferKt.startGapReservationFailedDueToLimit(this, i);
            throw new KotlinNothingValueException();
        } else {
            this.writePosition = i;
            this.readPosition = i;
            this.startGap = i;
        }
    }

    public final void reserveEndGap(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(("endGap shouldn't be negative: " + i).toString());
        }
        int i2 = this.capacity - i;
        if (i2 >= this.writePosition) {
            this.limit = i2;
            return;
        }
        if (i2 < 0) {
            BufferKt.endGapReservationFailedDueToCapacity(this, i);
        }
        if (i2 < this.startGap) {
            BufferKt.endGapReservationFailedDueToStartGap(this, i);
        }
        if (this.readPosition != this.writePosition) {
            BufferKt.endGapReservationFailedDueToContent(this, i);
            return;
        }
        this.limit = i2;
        this.readPosition = i2;
        this.writePosition = i2;
    }

    public final void resetForWrite() {
        resetForWrite(this.capacity - this.startGap);
    }

    public final void releaseGaps$ktor_io() {
        releaseStartGap$ktor_io(0);
        releaseEndGap$ktor_io();
    }

    public final void releaseStartGap$ktor_io(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(("newReadPosition shouldn't be negative: " + i).toString());
        } else if (i <= this.readPosition) {
            this.readPosition = i;
            if (this.startGap > i) {
                this.startGap = i;
            }
        } else {
            throw new IllegalArgumentException(("newReadPosition shouldn't be ahead of the read position: " + i + " > " + this.readPosition).toString());
        }
    }

    public void reset() {
        releaseGaps$ktor_io();
        resetForWrite();
    }

    public String toString() {
        int checkRadix;
        StringBuilder sb = new StringBuilder();
        sb.append("Buffer[0x");
        int hashCode = hashCode();
        checkRadix = CharsKt__CharJVMKt.checkRadix(16);
        String num = Integer.toString(hashCode, checkRadix);
        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
        sb.append(num);
        sb.append("](");
        sb.append(getWritePosition() - getReadPosition());
        sb.append(" used, ");
        sb.append(getLimit() - getWritePosition());
        sb.append(" free, ");
        sb.append(this.startGap + (getCapacity() - getLimit()));
        sb.append(" reserved of ");
        sb.append(this.capacity);
        sb.append(CoreConstants.RIGHT_PARENTHESIS_CHAR);
        return sb.toString();
    }

    /* compiled from: Buffer.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Buffer getEmpty() {
            return ChunkBuffer.Companion.getEmpty();
        }
    }
}
