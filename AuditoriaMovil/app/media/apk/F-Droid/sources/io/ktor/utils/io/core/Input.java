package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.MalformedUTF8InputException;
import io.ktor.utils.io.core.internal.UnsafeKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.Closeable;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
/* compiled from: Input.kt */
/* loaded from: classes.dex */
public abstract class Input implements Closeable {
    public static final Companion Companion = new Companion(null);
    private ChunkBuffer _head;
    private int headEndExclusive;
    private ByteBuffer headMemory;
    private int headPosition;
    private boolean noMoreChunksAvailable;
    private final ObjectPool pool;
    private long tailRemaining;

    /* compiled from: Input.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final boolean canRead() {
        return (this.headPosition == this.headEndExclusive && this.tailRemaining == 0) ? false : true;
    }

    protected abstract void closeSource();

    protected abstract ChunkBuffer fill();

    public final int getHeadEndExclusive() {
        return this.headEndExclusive;
    }

    /* renamed from: getHeadMemory-SK3TCg8  reason: not valid java name */
    public final ByteBuffer m2066getHeadMemorySK3TCg8() {
        return this.headMemory;
    }

    public final int getHeadPosition() {
        return this.headPosition;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void markNoMoreChunksAvailable() {
        if (this.noMoreChunksAvailable) {
            return;
        }
        this.noMoreChunksAvailable = true;
    }

    public final void setHeadPosition(int i) {
        this.headPosition = i;
    }

    public Input(ChunkBuffer head, long j, ObjectPool pool) {
        Intrinsics.checkNotNullParameter(head, "head");
        Intrinsics.checkNotNullParameter(pool, "pool");
        this.pool = pool;
        this._head = head;
        this.headMemory = head.m2064getMemorySK3TCg8();
        this.headPosition = head.getReadPosition();
        int writePosition = head.getWritePosition();
        this.headEndExclusive = writePosition;
        this.tailRemaining = j - (writePosition - this.headPosition);
    }

    private final void set_head(ChunkBuffer chunkBuffer) {
        this._head = chunkBuffer;
        this.headMemory = chunkBuffer.m2064getMemorySK3TCg8();
        this.headPosition = chunkBuffer.getReadPosition();
        this.headEndExclusive = chunkBuffer.getWritePosition();
    }

    public final ChunkBuffer getHead() {
        ChunkBuffer chunkBuffer = this._head;
        chunkBuffer.discardUntilIndex$ktor_io(this.headPosition);
        return chunkBuffer;
    }

    private final void afterRead(ChunkBuffer chunkBuffer) {
        if (chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition() == 0) {
            releaseHead$ktor_io(chunkBuffer);
        }
    }

    public final void setTailRemaining(long j) {
        if (j >= 0) {
            this.tailRemaining = j;
            return;
        }
        throw new IllegalArgumentException(("tailRemaining shouldn't be negative: " + j).toString());
    }

    private final ChunkBuffer prepareReadLoop(int i, ChunkBuffer chunkBuffer) {
        while (true) {
            int headEndExclusive = getHeadEndExclusive() - getHeadPosition();
            if (headEndExclusive >= i) {
                return chunkBuffer;
            }
            ChunkBuffer next = chunkBuffer.getNext();
            if (next == null && (next = doFill()) == null) {
                return null;
            }
            if (headEndExclusive == 0) {
                if (chunkBuffer != ChunkBuffer.Companion.getEmpty()) {
                    releaseHead$ktor_io(chunkBuffer);
                }
                chunkBuffer = next;
            } else {
                int writeBufferAppend = BufferAppendKt.writeBufferAppend(chunkBuffer, next, i - headEndExclusive);
                this.headEndExclusive = chunkBuffer.getWritePosition();
                setTailRemaining(this.tailRemaining - writeBufferAppend);
                if (next.getWritePosition() <= next.getReadPosition()) {
                    chunkBuffer.setNext(null);
                    chunkBuffer.setNext(next.cleanNext());
                    next.release(this.pool);
                } else {
                    next.reserveStartGap(writeBufferAppend);
                }
                if (chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition() >= i) {
                    return chunkBuffer;
                }
                if (i > 8) {
                    minSizeIsTooBig(i);
                    throw new KotlinNothingValueException();
                }
            }
        }
    }

    public final boolean getEndOfInput() {
        return getHeadEndExclusive() - getHeadPosition() == 0 && this.tailRemaining == 0 && (this.noMoreChunksAvailable || doFill() == null);
    }

    public final long getRemaining() {
        return (getHeadEndExclusive() - getHeadPosition()) + this.tailRemaining;
    }

    public final void release() {
        ChunkBuffer head = getHead();
        ChunkBuffer empty = ChunkBuffer.Companion.getEmpty();
        if (head != empty) {
            set_head(empty);
            setTailRemaining(0L);
            BuffersKt.releaseAll(head, this.pool);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        release();
        if (!this.noMoreChunksAvailable) {
            this.noMoreChunksAvailable = true;
        }
        closeSource();
    }

    public final int discard(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(("Negative discard is not allowed: " + i).toString());
        }
        return discardAsMuchAsPossible(i, 0);
    }

    public final void discardExact(int i) {
        if (discard(i) == i) {
            return;
        }
        throw new EOFException("Unable to discard " + i + " bytes due to end of packet");
    }

    public static /* synthetic */ String readText$default(Input input, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = Integer.MAX_VALUE;
            }
            return input.readText(i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readText");
    }

    public final String readText(int i, int i2) {
        int coerceAtLeast;
        int coerceAtMost;
        if (i == 0 && (i2 == 0 || getEndOfInput())) {
            return "";
        }
        long remaining = getRemaining();
        if (remaining > 0 && i2 >= remaining) {
            return StringsKt.readTextExactBytes$default(this, (int) remaining, null, 2, null);
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i, 16);
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(coerceAtLeast, i2);
        StringBuilder sb = new StringBuilder(coerceAtMost);
        readASCII(sb, i, i2);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    private final int readASCII(Appendable appendable, int i, int i2) {
        int i3;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (i2 == 0 && i == 0) {
            return 0;
        }
        if (getEndOfInput()) {
            if (i == 0) {
                return 0;
            }
            atLeastMinCharactersRequire(i);
            throw new KotlinNothingValueException();
        } else if (i2 < i) {
            minShouldBeLess(i, i2);
            throw new KotlinNothingValueException();
        } else {
            ChunkBuffer prepareReadFirstHead = UnsafeKt.prepareReadFirstHead(this, 1);
            if (prepareReadFirstHead == null) {
                i3 = 0;
            } else {
                i3 = 0;
                boolean z5 = false;
                while (true) {
                    try {
                        ByteBuffer m2064getMemorySK3TCg8 = prepareReadFirstHead.m2064getMemorySK3TCg8();
                        int readPosition = prepareReadFirstHead.getReadPosition();
                        int writePosition = prepareReadFirstHead.getWritePosition();
                        for (int i4 = readPosition; i4 < writePosition; i4++) {
                            byte b = m2064getMemorySK3TCg8.get(i4);
                            int i5 = b & 255;
                            if ((b & 128) != 128) {
                                char c = (char) i5;
                                if (i3 == i2) {
                                    z3 = false;
                                } else {
                                    appendable.append(c);
                                    i3++;
                                    z3 = true;
                                }
                                if (z3) {
                                }
                            }
                            prepareReadFirstHead.discardExact(i4 - readPosition);
                            z = false;
                            break;
                        }
                        prepareReadFirstHead.discardExact(writePosition - readPosition);
                        z = true;
                        if (z) {
                            z2 = true;
                        } else if (i3 == i2) {
                            z2 = false;
                        } else {
                            z2 = false;
                            z5 = true;
                        }
                        if (z2) {
                            try {
                                prepareReadFirstHead = UnsafeKt.prepareReadNextHead(this, prepareReadFirstHead);
                                if (prepareReadFirstHead == null) {
                                    break;
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (z4) {
                                    UnsafeKt.completeReadHead(this, prepareReadFirstHead);
                                }
                                throw th;
                            }
                        } else {
                            UnsafeKt.completeReadHead(this, prepareReadFirstHead);
                            break;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        z4 = true;
                    }
                }
                z4 = z5;
            }
            if (z4) {
                return i3 + readUtf8(appendable, i - i3, i2 - i3);
            }
            if (i3 >= i) {
                return i3;
            }
            prematureEndOfStreamChars(i, i3);
            throw new KotlinNothingValueException();
        }
    }

    private final Void atLeastMinCharactersRequire(int i) {
        throw new EOFException("at least " + i + " characters required but no bytes available");
    }

    private final Void minShouldBeLess(int i, int i2) {
        throw new IllegalArgumentException("min should be less or equal to max but min = " + i + ", max = " + i2);
    }

    private final Void prematureEndOfStreamChars(int i, int i2) {
        throw new MalformedUTF8InputException("Premature end of stream: expected at least " + i + " chars but had only " + i2);
    }

    private final int discardAsMuchAsPossible(int i, int i2) {
        while (i != 0) {
            ChunkBuffer prepareRead = prepareRead(1);
            if (prepareRead == null) {
                return i2;
            }
            int min = Math.min(prepareRead.getWritePosition() - prepareRead.getReadPosition(), i);
            prepareRead.discardExact(min);
            this.headPosition += min;
            afterRead(prepareRead);
            i -= min;
            i2 += min;
        }
        return i2;
    }

    public final ChunkBuffer prepareReadHead$ktor_io(int i) {
        return prepareReadLoop(i, getHead());
    }

    public final ChunkBuffer ensureNextHead$ktor_io(ChunkBuffer current) {
        Intrinsics.checkNotNullParameter(current, "current");
        return ensureNext(current);
    }

    public final ChunkBuffer ensureNext(ChunkBuffer current) {
        Intrinsics.checkNotNullParameter(current, "current");
        return ensureNext(current, ChunkBuffer.Companion.getEmpty());
    }

    public final void fixGapAfterRead$ktor_io(ChunkBuffer current) {
        Intrinsics.checkNotNullParameter(current, "current");
        ChunkBuffer next = current.getNext();
        if (next == null) {
            fixGapAfterReadFallback(current);
            return;
        }
        int writePosition = current.getWritePosition() - current.getReadPosition();
        int min = Math.min(writePosition, 8 - (current.getCapacity() - current.getLimit()));
        if (next.getStartGap() < min) {
            fixGapAfterReadFallback(current);
            return;
        }
        BufferKt.restoreStartGap(next, min);
        if (writePosition > min) {
            current.releaseEndGap$ktor_io();
            this.headEndExclusive = current.getWritePosition();
            setTailRemaining(this.tailRemaining + min);
            return;
        }
        set_head(next);
        setTailRemaining(this.tailRemaining - ((next.getWritePosition() - next.getReadPosition()) - min));
        current.cleanNext();
        current.release(this.pool);
    }

    private final void fixGapAfterReadFallback(ChunkBuffer chunkBuffer) {
        if (!this.noMoreChunksAvailable || chunkBuffer.getNext() != null) {
            int writePosition = chunkBuffer.getWritePosition() - chunkBuffer.getReadPosition();
            int min = Math.min(writePosition, 8 - (chunkBuffer.getCapacity() - chunkBuffer.getLimit()));
            if (writePosition > min) {
                fixGapAfterReadFallbackUnreserved(chunkBuffer, writePosition, min);
            } else {
                ChunkBuffer chunkBuffer2 = (ChunkBuffer) this.pool.borrow();
                chunkBuffer2.reserveEndGap(8);
                chunkBuffer2.setNext(chunkBuffer.cleanNext());
                BufferAppendKt.writeBufferAppend(chunkBuffer2, chunkBuffer, writePosition);
                set_head(chunkBuffer2);
            }
            chunkBuffer.release(this.pool);
            return;
        }
        this.headPosition = chunkBuffer.getReadPosition();
        this.headEndExclusive = chunkBuffer.getWritePosition();
        setTailRemaining(0L);
    }

    private final void fixGapAfterReadFallbackUnreserved(ChunkBuffer chunkBuffer, int i, int i2) {
        ChunkBuffer chunkBuffer2 = (ChunkBuffer) this.pool.borrow();
        ChunkBuffer chunkBuffer3 = (ChunkBuffer) this.pool.borrow();
        chunkBuffer2.reserveEndGap(8);
        chunkBuffer3.reserveEndGap(8);
        chunkBuffer2.setNext(chunkBuffer3);
        chunkBuffer3.setNext(chunkBuffer.cleanNext());
        BufferAppendKt.writeBufferAppend(chunkBuffer2, chunkBuffer, i - i2);
        BufferAppendKt.writeBufferAppend(chunkBuffer3, chunkBuffer, i2);
        set_head(chunkBuffer2);
        setTailRemaining(BuffersKt.remainingAll(chunkBuffer3));
    }

    private final ChunkBuffer ensureNext(ChunkBuffer chunkBuffer, ChunkBuffer chunkBuffer2) {
        while (chunkBuffer != chunkBuffer2) {
            ChunkBuffer cleanNext = chunkBuffer.cleanNext();
            chunkBuffer.release(this.pool);
            if (cleanNext != null) {
                if (cleanNext.getWritePosition() > cleanNext.getReadPosition()) {
                    set_head(cleanNext);
                    setTailRemaining(this.tailRemaining - (cleanNext.getWritePosition() - cleanNext.getReadPosition()));
                    return cleanNext;
                }
                chunkBuffer = cleanNext;
            } else {
                set_head(chunkBuffer2);
                setTailRemaining(0L);
                chunkBuffer = chunkBuffer2;
            }
        }
        return doFill();
    }

    private final ChunkBuffer doFill() {
        if (this.noMoreChunksAvailable) {
            return null;
        }
        ChunkBuffer fill = fill();
        if (fill == null) {
            this.noMoreChunksAvailable = true;
            return null;
        }
        appendView(fill);
        return fill;
    }

    private final void appendView(ChunkBuffer chunkBuffer) {
        ChunkBuffer findTail = BuffersKt.findTail(this._head);
        if (findTail == ChunkBuffer.Companion.getEmpty()) {
            set_head(chunkBuffer);
            if (this.tailRemaining != 0) {
                throw new IllegalStateException("It should be no tail remaining bytes if current tail is EmptyBuffer");
            }
            ChunkBuffer next = chunkBuffer.getNext();
            setTailRemaining(next != null ? BuffersKt.remainingAll(next) : 0L);
            return;
        }
        findTail.setNext(chunkBuffer);
        setTailRemaining(this.tailRemaining + BuffersKt.remainingAll(chunkBuffer));
    }

    public final ChunkBuffer prepareRead(int i) {
        ChunkBuffer head = getHead();
        return this.headEndExclusive - this.headPosition >= i ? head : prepareReadLoop(i, head);
    }

    private final Void minSizeIsTooBig(int i) {
        throw new IllegalStateException("minSize of " + i + " is too big (should be less than 8)");
    }

    public final ChunkBuffer releaseHead$ktor_io(ChunkBuffer head) {
        Intrinsics.checkNotNullParameter(head, "head");
        ChunkBuffer cleanNext = head.cleanNext();
        if (cleanNext == null) {
            cleanNext = ChunkBuffer.Companion.getEmpty();
        }
        set_head(cleanNext);
        setTailRemaining(this.tailRemaining - (cleanNext.getWritePosition() - cleanNext.getReadPosition()));
        head.release(this.pool);
        return cleanNext;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005a, code lost:
        io.ktor.utils.io.core.internal.UTF8Kt.malformedByteCount(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0062, code lost:
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00e4, code lost:
        r4 = 1;
        io.ktor.utils.io.core.internal.UTF8Kt.malformedCodePoint(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00ed, code lost:
        throw new kotlin.KotlinNothingValueException();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int readUtf8(java.lang.Appendable r18, int r19, int r20) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.Input.readUtf8(java.lang.Appendable, int, int):int");
    }
}
