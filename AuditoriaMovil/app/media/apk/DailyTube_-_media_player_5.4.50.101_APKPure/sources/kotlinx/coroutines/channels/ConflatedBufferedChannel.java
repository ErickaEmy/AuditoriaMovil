package kotlinx.coroutines.channels;

import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
/* loaded from: classes.dex */
public class ConflatedBufferedChannel<E> extends BufferedChannel<E> {
    private final int capacity;
    private final BufferOverflow onBufferOverflow;

    public ConflatedBufferedChannel(int i, BufferOverflow bufferOverflow, Function1<? super E, Unit> function1) {
        super(i, function1);
        this.capacity = i;
        this.onBufferOverflow = bufferOverflow;
        if (bufferOverflow != BufferOverflow.SUSPEND) {
            if (i >= 1) {
                return;
            }
            throw new IllegalArgumentException(("Buffered channel capacity must be at least 1, but " + i + " was specified").toString());
        }
        throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + Reflection.getOrCreateKotlinClass(BufferedChannel.class).getSimpleName() + " instead").toString());
    }

    public static /* synthetic */ <E> Object send$suspendImpl(ConflatedBufferedChannel<E> conflatedBufferedChannel, E e2, Continuation<? super Unit> continuation) {
        UndeliveredElementException callUndeliveredElementCatchingException$default;
        Object m101trySendImplMj0NB7M = conflatedBufferedChannel.m101trySendImplMj0NB7M(e2, true);
        if (m101trySendImplMj0NB7M instanceof ChannelResult.Closed) {
            ChannelResult.m89exceptionOrNullimpl(m101trySendImplMj0NB7M);
            Function1<E, Unit> function1 = conflatedBufferedChannel.onUndeliveredElement;
            if (function1 != null && (callUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, e2, null, 2, null)) != null) {
                ExceptionsKt.addSuppressed(callUndeliveredElementCatchingException$default, conflatedBufferedChannel.getSendException());
                throw callUndeliveredElementCatchingException$default;
            }
            throw conflatedBufferedChannel.getSendException();
        }
        return Unit.INSTANCE;
    }

    /* renamed from: trySendDropLatest-Mj0NB7M  reason: not valid java name */
    private final Object m99trySendDropLatestMj0NB7M(E e2, boolean z2) {
        Function1<E, Unit> function1;
        UndeliveredElementException callUndeliveredElementCatchingException$default;
        Object mo85trySendJP2dKIU = super.mo85trySendJP2dKIU(e2);
        if (!ChannelResult.m93isSuccessimpl(mo85trySendJP2dKIU) && !ChannelResult.m92isClosedimpl(mo85trySendJP2dKIU)) {
            if (z2 && (function1 = this.onUndeliveredElement) != null && (callUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, e2, null, 2, null)) != null) {
                throw callUndeliveredElementCatchingException$default;
            }
            return ChannelResult.Companion.m98successJP2dKIU(Unit.INSTANCE);
        }
        return mo85trySendJP2dKIU;
    }

    /* renamed from: trySendDropOldest-JP2dKIU  reason: not valid java name */
    private final Object m100trySendDropOldestJP2dKIU(E e2) {
        ChannelSegment channelSegment;
        Waiter waiter;
        Symbol symbol = BufferedChannelKt.BUFFERED;
        ChannelSegment channelSegment2 = (ChannelSegment) BufferedChannel.sendSegment$FU.get(this);
        while (true) {
            long andIncrement = BufferedChannel.sendersAndCloseStatus$FU.getAndIncrement(this);
            long j2 = andIncrement & 1152921504606846975L;
            boolean isClosedForSend0 = isClosedForSend0(andIncrement);
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j4 = j2 / i;
            int i5 = (int) (j2 % i);
            if (channelSegment2.id != j4) {
                ChannelSegment findSegmentSend = findSegmentSend(j4, channelSegment2);
                if (findSegmentSend == null) {
                    if (isClosedForSend0) {
                        return ChannelResult.Companion.m96closedJP2dKIU(getSendException());
                    }
                } else {
                    channelSegment = findSegmentSend;
                }
            } else {
                channelSegment = channelSegment2;
            }
            int updateCellSend = updateCellSend(channelSegment, i5, e2, j2, symbol, isClosedForSend0);
            if (updateCellSend != 0) {
                if (updateCellSend != 1) {
                    if (updateCellSend != 2) {
                        if (updateCellSend != 3) {
                            if (updateCellSend != 4) {
                                if (updateCellSend == 5) {
                                    channelSegment.cleanPrev();
                                }
                                channelSegment2 = channelSegment;
                            } else {
                                if (j2 < getReceiversCounter$kotlinx_coroutines_core()) {
                                    channelSegment.cleanPrev();
                                }
                                return ChannelResult.Companion.m96closedJP2dKIU(getSendException());
                            }
                        } else {
                            throw new IllegalStateException("unexpected");
                        }
                    } else if (isClosedForSend0) {
                        channelSegment.onSlotCleaned();
                        return ChannelResult.Companion.m96closedJP2dKIU(getSendException());
                    } else {
                        if (symbol instanceof Waiter) {
                            waiter = (Waiter) symbol;
                        } else {
                            waiter = null;
                        }
                        if (waiter != null) {
                            prepareSenderForSuspension(waiter, channelSegment, i5);
                        }
                        dropFirstElementUntilTheSpecifiedCellIsInTheBuffer((channelSegment.id * i) + i5);
                        return ChannelResult.Companion.m98successJP2dKIU(Unit.INSTANCE);
                    }
                } else {
                    return ChannelResult.Companion.m98successJP2dKIU(Unit.INSTANCE);
                }
            } else {
                channelSegment.cleanPrev();
                return ChannelResult.Companion.m98successJP2dKIU(Unit.INSTANCE);
            }
        }
    }

    /* renamed from: trySendImpl-Mj0NB7M  reason: not valid java name */
    private final Object m101trySendImplMj0NB7M(E e2, boolean z2) {
        if (this.onBufferOverflow == BufferOverflow.DROP_LATEST) {
            return m99trySendDropLatestMj0NB7M(e2, z2);
        }
        return m100trySendDropOldestJP2dKIU(e2);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public boolean isConflatedDropOldest() {
        if (this.onBufferOverflow == BufferOverflow.DROP_OLDEST) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    public Object send(E e2, Continuation<? super Unit> continuation) {
        return send$suspendImpl((ConflatedBufferedChannel) this, (Object) e2, continuation);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    /* renamed from: trySend-JP2dKIU */
    public Object mo85trySendJP2dKIU(E e2) {
        return m101trySendImplMj0NB7M(e2, false);
    }
}
