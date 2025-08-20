package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause1Impl;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.TrySelectDetailedResult;
import r.n3;
/* loaded from: classes.dex */
public class BufferedChannel<E> implements Channel<E> {
    private volatile Object _closeCause;
    private volatile long bufferEnd;
    private volatile Object bufferEndSegment;
    private final int capacity;
    private volatile Object closeHandler;
    private volatile long completedExpandBuffersAndPauseFlag;
    public final Function1<E, Unit> onUndeliveredElement;
    private final Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> onUndeliveredElementReceiveCancellationConstructor;
    private volatile Object receiveSegment;
    private volatile long receivers;
    private volatile Object sendSegment;
    private volatile long sendersAndCloseStatus;
    private static final AtomicLongFieldUpdater sendersAndCloseStatus$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "sendersAndCloseStatus");
    private static final AtomicLongFieldUpdater receivers$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "receivers");
    private static final AtomicLongFieldUpdater bufferEnd$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "bufferEnd");
    private static final AtomicLongFieldUpdater completedExpandBuffersAndPauseFlag$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "completedExpandBuffersAndPauseFlag");
    private static final AtomicReferenceFieldUpdater sendSegment$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "sendSegment");
    private static final AtomicReferenceFieldUpdater receiveSegment$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "receiveSegment");
    private static final AtomicReferenceFieldUpdater bufferEndSegment$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "bufferEndSegment");
    private static final AtomicReferenceFieldUpdater _closeCause$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "_closeCause");
    private static final AtomicReferenceFieldUpdater closeHandler$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "closeHandler");

    /* loaded from: classes.dex */
    public final class BufferedChannelIterator implements ChannelIterator<E>, Waiter {
        private CancellableContinuationImpl<? super Boolean> continuation;
        private Object receiveResult;

        public BufferedChannelIterator() {
            Symbol symbol;
            symbol = BufferedChannelKt.NO_RECEIVE_RESULT;
            this.receiveResult = symbol;
        }

        private final Object hasNextOnNoWaiterSuspend(ChannelSegment<E> channelSegment, int i, long j2, Continuation<? super Boolean> continuation) {
            Symbol symbol;
            Symbol symbol2;
            Boolean boxBoolean;
            Symbol symbol3;
            Symbol symbol4;
            Symbol symbol5;
            BufferedChannel<E> bufferedChannel = BufferedChannel.this;
            CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation));
            try {
                this.continuation = orCreateCancellableContinuation;
                Object updateCellReceive = bufferedChannel.updateCellReceive(channelSegment, i, j2, this);
                symbol = BufferedChannelKt.SUSPEND;
                if (updateCellReceive == symbol) {
                    bufferedChannel.prepareReceiverForSuspension(this, channelSegment, i);
                } else {
                    symbol2 = BufferedChannelKt.FAILED;
                    Function1<Throwable, Unit> function1 = null;
                    if (updateCellReceive == symbol2) {
                        if (j2 < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                            channelSegment.cleanPrev();
                        }
                        ChannelSegment channelSegment2 = (ChannelSegment) BufferedChannel.receiveSegment$FU.get(bufferedChannel);
                        while (true) {
                            if (bufferedChannel.isClosedForReceive()) {
                                onClosedHasNextNoWaiterSuspend();
                                break;
                            }
                            long andIncrement = BufferedChannel.receivers$FU.getAndIncrement(bufferedChannel);
                            int i5 = BufferedChannelKt.SEGMENT_SIZE;
                            long j4 = andIncrement / i5;
                            int i6 = (int) (andIncrement % i5);
                            if (channelSegment2.id != j4) {
                                ChannelSegment findSegmentReceive = bufferedChannel.findSegmentReceive(j4, channelSegment2);
                                if (findSegmentReceive != null) {
                                    channelSegment2 = findSegmentReceive;
                                }
                            }
                            Object updateCellReceive2 = bufferedChannel.updateCellReceive(channelSegment2, i6, andIncrement, this);
                            symbol3 = BufferedChannelKt.SUSPEND;
                            if (updateCellReceive2 == symbol3) {
                                bufferedChannel.prepareReceiverForSuspension(this, channelSegment2, i6);
                                break;
                            }
                            symbol4 = BufferedChannelKt.FAILED;
                            if (updateCellReceive2 != symbol4) {
                                symbol5 = BufferedChannelKt.SUSPEND_NO_WAITER;
                                if (updateCellReceive2 != symbol5) {
                                    channelSegment2.cleanPrev();
                                    this.receiveResult = updateCellReceive2;
                                    this.continuation = null;
                                    boxBoolean = Boxing.boxBoolean(true);
                                    Function1<E, Unit> function12 = bufferedChannel.onUndeliveredElement;
                                    if (function12 != null) {
                                        function1 = OnUndeliveredElementKt.bindCancellationFun(function12, updateCellReceive2, orCreateCancellableContinuation.getContext());
                                    }
                                } else {
                                    throw new IllegalStateException("unexpected");
                                }
                            } else if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                                channelSegment2.cleanPrev();
                            }
                        }
                    } else {
                        channelSegment.cleanPrev();
                        this.receiveResult = updateCellReceive;
                        this.continuation = null;
                        boxBoolean = Boxing.boxBoolean(true);
                        Function1<E, Unit> function13 = bufferedChannel.onUndeliveredElement;
                        if (function13 != null) {
                            function1 = OnUndeliveredElementKt.bindCancellationFun(function13, updateCellReceive, orCreateCancellableContinuation.getContext());
                        }
                    }
                    orCreateCancellableContinuation.resume(boxBoolean, function1);
                }
                Object result = orCreateCancellableContinuation.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(continuation);
                }
                return result;
            } catch (Throwable th) {
                orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                throw th;
            }
        }

        private final boolean onClosedHasNext() {
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable closeCause = BufferedChannel.this.getCloseCause();
            if (closeCause == null) {
                return false;
            }
            throw StackTraceRecoveryKt.recoverStackTrace(closeCause);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void onClosedHasNextNoWaiterSuspend() {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            Intrinsics.checkNotNull(cancellableContinuationImpl);
            this.continuation = null;
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable closeCause = BufferedChannel.this.getCloseCause();
            if (closeCause == null) {
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl.resumeWith(Result.m28constructorimpl(Boolean.FALSE));
                return;
            }
            if (DebugKt.getRECOVER_STACK_TRACES() && (cancellableContinuationImpl instanceof CoroutineStackFrame)) {
                closeCause = StackTraceRecoveryKt.recoverFromStackFrame(closeCause, cancellableContinuationImpl);
            }
            Result.Companion companion2 = Result.Companion;
            cancellableContinuationImpl.resumeWith(Result.m28constructorimpl(ResultKt.createFailure(closeCause)));
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public Object hasNext(Continuation<? super Boolean> continuation) {
            ChannelSegment<E> channelSegment;
            Symbol symbol;
            Symbol symbol2;
            Symbol symbol3;
            BufferedChannel<E> bufferedChannel = BufferedChannel.this;
            ChannelSegment<E> channelSegment2 = (ChannelSegment) BufferedChannel.receiveSegment$FU.get(bufferedChannel);
            while (!bufferedChannel.isClosedForReceive()) {
                long andIncrement = BufferedChannel.receivers$FU.getAndIncrement(bufferedChannel);
                int i = BufferedChannelKt.SEGMENT_SIZE;
                long j2 = andIncrement / i;
                int i5 = (int) (andIncrement % i);
                if (channelSegment2.id != j2) {
                    ChannelSegment<E> findSegmentReceive = bufferedChannel.findSegmentReceive(j2, channelSegment2);
                    if (findSegmentReceive == null) {
                        continue;
                    } else {
                        channelSegment = findSegmentReceive;
                    }
                } else {
                    channelSegment = channelSegment2;
                }
                Object updateCellReceive = bufferedChannel.updateCellReceive(channelSegment, i5, andIncrement, null);
                symbol = BufferedChannelKt.SUSPEND;
                if (updateCellReceive != symbol) {
                    symbol2 = BufferedChannelKt.FAILED;
                    if (updateCellReceive != symbol2) {
                        symbol3 = BufferedChannelKt.SUSPEND_NO_WAITER;
                        if (updateCellReceive == symbol3) {
                            return hasNextOnNoWaiterSuspend(channelSegment, i5, andIncrement, continuation);
                        }
                        channelSegment.cleanPrev();
                        this.receiveResult = updateCellReceive;
                        return Boxing.boxBoolean(true);
                    }
                    if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                    channelSegment2 = channelSegment;
                } else {
                    throw new IllegalStateException("unreachable");
                }
            }
            return Boxing.boxBoolean(onClosedHasNext());
        }

        @Override // kotlinx.coroutines.Waiter
        public void invokeOnCancellation(Segment<?> segment, int i) {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            if (cancellableContinuationImpl != null) {
                cancellableContinuationImpl.invokeOnCancellation(segment, i);
            }
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public E next() {
            Symbol symbol;
            Symbol symbol2;
            E e2 = (E) this.receiveResult;
            symbol = BufferedChannelKt.NO_RECEIVE_RESULT;
            if (e2 != symbol) {
                symbol2 = BufferedChannelKt.NO_RECEIVE_RESULT;
                this.receiveResult = symbol2;
                if (e2 != BufferedChannelKt.getCHANNEL_CLOSED()) {
                    return e2;
                }
                throw StackTraceRecoveryKt.recoverStackTrace(BufferedChannel.this.getReceiveException());
            }
            throw new IllegalStateException("`hasNext()` has not been invoked");
        }

        public final boolean tryResumeHasNext(E e2) {
            boolean tryResume0;
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            Intrinsics.checkNotNull(cancellableContinuationImpl);
            Function1<Throwable, Unit> function1 = null;
            this.continuation = null;
            this.receiveResult = e2;
            Boolean bool = Boolean.TRUE;
            Function1<E, Unit> function12 = BufferedChannel.this.onUndeliveredElement;
            if (function12 != null) {
                function1 = OnUndeliveredElementKt.bindCancellationFun(function12, e2, cancellableContinuationImpl.getContext());
            }
            tryResume0 = BufferedChannelKt.tryResume0(cancellableContinuationImpl, bool, function1);
            return tryResume0;
        }

        public final void tryResumeHasNextOnClosedChannel() {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            Intrinsics.checkNotNull(cancellableContinuationImpl);
            this.continuation = null;
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable closeCause = BufferedChannel.this.getCloseCause();
            if (closeCause == null) {
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl.resumeWith(Result.m28constructorimpl(Boolean.FALSE));
                return;
            }
            if (DebugKt.getRECOVER_STACK_TRACES() && (cancellableContinuationImpl instanceof CoroutineStackFrame)) {
                closeCause = StackTraceRecoveryKt.recoverFromStackFrame(closeCause, cancellableContinuationImpl);
            }
            Result.Companion companion2 = Result.Companion;
            cancellableContinuationImpl.resumeWith(Result.m28constructorimpl(ResultKt.createFailure(closeCause)));
        }
    }

    /* loaded from: classes.dex */
    public static final class SendBroadcast implements Waiter {
        private final /* synthetic */ CancellableContinuationImpl<Boolean> $$delegate_0;
        private final CancellableContinuation<Boolean> cont;

        public final CancellableContinuation<Boolean> getCont() {
            return this.cont;
        }

        @Override // kotlinx.coroutines.Waiter
        public void invokeOnCancellation(Segment<?> segment, int i) {
            this.$$delegate_0.invokeOnCancellation(segment, i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [kotlin.jvm.functions.Function1<? super E, kotlin.Unit>, kotlin.jvm.functions.Function1<E, kotlin.Unit>] */
    public BufferedChannel(int i, Function1<? super E, Unit> function1) {
        long initialBufferEnd;
        Function3 function3;
        Symbol symbol;
        this.capacity = i;
        this.onUndeliveredElement = function1;
        if (i >= 0) {
            initialBufferEnd = BufferedChannelKt.initialBufferEnd(i);
            this.bufferEnd = initialBufferEnd;
            this.completedExpandBuffersAndPauseFlag = getBufferEndCounter();
            ChannelSegment channelSegment = new ChannelSegment(0L, null, this, 3);
            this.sendSegment = channelSegment;
            this.receiveSegment = channelSegment;
            if (isRendezvousOrUnlimited()) {
                channelSegment = BufferedChannelKt.NULL_SEGMENT;
                Intrinsics.checkNotNull(channelSegment, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
            }
            this.bufferEndSegment = channelSegment;
            if (function1 != 0) {
                function3 = new Function3<SelectInstance<?>, Object, Object, Function1<? super Throwable, ? extends Unit>>(this) { // from class: kotlinx.coroutines.channels.BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1
                    final /* synthetic */ BufferedChannel<E> this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                        this.this$0 = this;
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Function1<Throwable, Unit> invoke(final SelectInstance<?> selectInstance, Object obj, final Object obj2) {
                        final BufferedChannel<E> bufferedChannel = this.this$0;
                        return new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.channels.BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                                invoke2(th);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(Throwable th) {
                                if (obj2 != BufferedChannelKt.getCHANNEL_CLOSED()) {
                                    OnUndeliveredElementKt.callUndeliveredElement(bufferedChannel.onUndeliveredElement, obj2, selectInstance.getContext());
                                }
                            }
                        };
                    }
                };
            } else {
                function3 = null;
            }
            this.onUndeliveredElementReceiveCancellationConstructor = function3;
            symbol = BufferedChannelKt.NO_CLOSE_CAUSE;
            this._closeCause = symbol;
            return;
        }
        throw new IllegalArgumentException(("Invalid channel capacity: " + i + ", should be >=0").toString());
    }

    private final boolean bufferOrRendezvousSend(long j2) {
        if (j2 >= getBufferEndCounter() && j2 >= getReceiversCounter$kotlinx_coroutines_core() + this.capacity) {
            return false;
        }
        return true;
    }

    private final void cancelSuspendedReceiveRequests(ChannelSegment<E> channelSegment, long j2) {
        Symbol symbol;
        Object m107constructorimpl$default = InlineList.m107constructorimpl$default(null, 1, null);
        loop0: while (channelSegment != null) {
            for (int i = BufferedChannelKt.SEGMENT_SIZE - 1; -1 < i; i--) {
                if ((channelSegment.id * BufferedChannelKt.SEGMENT_SIZE) + i < j2) {
                    break loop0;
                }
                while (true) {
                    Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
                    if (state$kotlinx_coroutines_core != null) {
                        symbol = BufferedChannelKt.IN_BUFFER;
                        if (state$kotlinx_coroutines_core != symbol) {
                            if (state$kotlinx_coroutines_core instanceof WaiterEB) {
                                if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                                    m107constructorimpl$default = InlineList.m108plusFjFbRPM(m107constructorimpl$default, ((WaiterEB) state$kotlinx_coroutines_core).waiter);
                                    channelSegment.onCancelledRequest(i, true);
                                    break;
                                }
                            } else if (!(state$kotlinx_coroutines_core instanceof Waiter)) {
                                break;
                            } else if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                                m107constructorimpl$default = InlineList.m108plusFjFbRPM(m107constructorimpl$default, state$kotlinx_coroutines_core);
                                channelSegment.onCancelledRequest(i, true);
                                break;
                            }
                        }
                    }
                    if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                        channelSegment.onSlotCleaned();
                        break;
                    }
                }
            }
            channelSegment = (ChannelSegment) channelSegment.getPrev();
        }
        if (m107constructorimpl$default != null) {
            if (!(m107constructorimpl$default instanceof ArrayList)) {
                resumeReceiverOnClosedChannel((Waiter) m107constructorimpl$default);
                return;
            }
            Intrinsics.checkNotNull(m107constructorimpl$default, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            ArrayList arrayList = (ArrayList) m107constructorimpl$default;
            for (int size = arrayList.size() - 1; -1 < size; size--) {
                resumeReceiverOnClosedChannel((Waiter) arrayList.get(size));
            }
        }
    }

    private final ChannelSegment<E> closeLinkedList() {
        ChannelSegment channelSegment = bufferEndSegment$FU.get(this);
        ChannelSegment channelSegment2 = (ChannelSegment) sendSegment$FU.get(this);
        if (channelSegment2.id > ((ChannelSegment) channelSegment).id) {
            channelSegment = channelSegment2;
        }
        ChannelSegment channelSegment3 = (ChannelSegment) receiveSegment$FU.get(this);
        if (channelSegment3.id > ((ChannelSegment) channelSegment).id) {
            channelSegment = channelSegment3;
        }
        return (ChannelSegment) ConcurrentLinkedListKt.close((ConcurrentLinkedListNode) channelSegment);
    }

    private final void completeCancel(long j2) {
        removeUnprocessedElements(completeClose(j2));
    }

    private final ChannelSegment<E> completeClose(long j2) {
        ChannelSegment<E> closeLinkedList = closeLinkedList();
        if (isConflatedDropOldest()) {
            long markAllEmptyCellsAsClosed = markAllEmptyCellsAsClosed(closeLinkedList);
            if (markAllEmptyCellsAsClosed != -1) {
                dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(markAllEmptyCellsAsClosed);
            }
        }
        cancelSuspendedReceiveRequests(closeLinkedList, j2);
        return closeLinkedList;
    }

    private final void completeCloseOrCancel() {
        isClosedForSend();
    }

    private final void expandBuffer() {
        if (isRendezvousOrUnlimited()) {
            return;
        }
        ChannelSegment<E> channelSegment = (ChannelSegment) bufferEndSegment$FU.get(this);
        while (true) {
            long andIncrement = bufferEnd$FU.getAndIncrement(this);
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j2 = andIncrement / i;
            if (getSendersCounter$kotlinx_coroutines_core() <= andIncrement) {
                if (channelSegment.id < j2 && channelSegment.getNext() != 0) {
                    moveSegmentBufferEndToSpecifiedOrLast(j2, channelSegment);
                }
                incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
                return;
            }
            if (channelSegment.id != j2) {
                ChannelSegment<E> findSegmentBufferEnd = findSegmentBufferEnd(j2, channelSegment, andIncrement);
                if (findSegmentBufferEnd == null) {
                    continue;
                } else {
                    channelSegment = findSegmentBufferEnd;
                }
            }
            if (updateCellExpandBuffer(channelSegment, (int) (andIncrement % i), andIncrement)) {
                incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
                return;
            }
            incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
        }
    }

    private final ChannelSegment<E> findSegmentBufferEnd(long j2, ChannelSegment<E> channelSegment, long j4) {
        Object findSegmentInternal;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = bufferEndSegment$FU;
        Function2 function2 = (Function2) BufferedChannelKt.createSegmentFunction();
        loop0: while (true) {
            findSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(channelSegment, j2, function2);
            if (!SegmentOrClosed.m113isClosedimpl(findSegmentInternal)) {
                Segment m112getSegmentimpl = SegmentOrClosed.m112getSegmentimpl(findSegmentInternal);
                while (true) {
                    Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                    if (segment.id >= m112getSegmentimpl.id) {
                        break loop0;
                    } else if (!m112getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    } else if (n3.y(atomicReferenceFieldUpdater, this, segment, m112getSegmentimpl)) {
                        if (segment.decPointers$kotlinx_coroutines_core()) {
                            segment.remove();
                        }
                    } else if (m112getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                        m112getSegmentimpl.remove();
                    }
                }
            } else {
                break;
            }
        }
        if (SegmentOrClosed.m113isClosedimpl(findSegmentInternal)) {
            completeCloseOrCancel();
            moveSegmentBufferEndToSpecifiedOrLast(j2, channelSegment);
            incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
            return null;
        }
        ChannelSegment<E> channelSegment2 = (ChannelSegment) SegmentOrClosed.m112getSegmentimpl(findSegmentInternal);
        long j6 = channelSegment2.id;
        if (j6 > j2) {
            int i = BufferedChannelKt.SEGMENT_SIZE;
            if (bufferEnd$FU.compareAndSet(this, j4 + 1, i * j6)) {
                incCompletedExpandBufferAttempts((channelSegment2.id * i) - j4);
                return null;
            }
            incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
            return null;
        } else if (DebugKt.getASSERTIONS_ENABLED() && channelSegment2.id != j2) {
            throw new AssertionError();
        } else {
            return channelSegment2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ChannelSegment<E> findSegmentReceive(long j2, ChannelSegment<E> channelSegment) {
        Object findSegmentInternal;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = receiveSegment$FU;
        Function2 function2 = (Function2) BufferedChannelKt.createSegmentFunction();
        loop0: while (true) {
            findSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(channelSegment, j2, function2);
            if (!SegmentOrClosed.m113isClosedimpl(findSegmentInternal)) {
                Segment m112getSegmentimpl = SegmentOrClosed.m112getSegmentimpl(findSegmentInternal);
                while (true) {
                    Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                    if (segment.id >= m112getSegmentimpl.id) {
                        break loop0;
                    } else if (!m112getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    } else if (n3.y(atomicReferenceFieldUpdater, this, segment, m112getSegmentimpl)) {
                        if (segment.decPointers$kotlinx_coroutines_core()) {
                            segment.remove();
                        }
                    } else if (m112getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                        m112getSegmentimpl.remove();
                    }
                }
            } else {
                break;
            }
        }
        if (SegmentOrClosed.m113isClosedimpl(findSegmentInternal)) {
            completeCloseOrCancel();
            if (channelSegment.id * BufferedChannelKt.SEGMENT_SIZE >= getSendersCounter$kotlinx_coroutines_core()) {
                return null;
            }
            channelSegment.cleanPrev();
            return null;
        }
        ChannelSegment<E> channelSegment2 = (ChannelSegment) SegmentOrClosed.m112getSegmentimpl(findSegmentInternal);
        if (!isRendezvousOrUnlimited() && j2 <= getBufferEndCounter() / BufferedChannelKt.SEGMENT_SIZE) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = bufferEndSegment$FU;
            while (true) {
                Segment segment2 = (Segment) atomicReferenceFieldUpdater2.get(this);
                if (segment2.id >= channelSegment2.id || !channelSegment2.tryIncPointers$kotlinx_coroutines_core()) {
                    break;
                } else if (n3.y(atomicReferenceFieldUpdater2, this, segment2, channelSegment2)) {
                    if (segment2.decPointers$kotlinx_coroutines_core()) {
                        segment2.remove();
                    }
                } else if (channelSegment2.decPointers$kotlinx_coroutines_core()) {
                    channelSegment2.remove();
                }
            }
        }
        long j4 = channelSegment2.id;
        if (j4 > j2) {
            int i = BufferedChannelKt.SEGMENT_SIZE;
            updateReceiversCounterIfLower(j4 * i);
            if (channelSegment2.id * i >= getSendersCounter$kotlinx_coroutines_core()) {
                return null;
            }
            channelSegment2.cleanPrev();
            return null;
        } else if (DebugKt.getASSERTIONS_ENABLED() && channelSegment2.id != j2) {
            throw new AssertionError();
        } else {
            return channelSegment2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ChannelSegment<E> findSegmentSend(long j2, ChannelSegment<E> channelSegment) {
        Object findSegmentInternal;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = sendSegment$FU;
        Function2 function2 = (Function2) BufferedChannelKt.createSegmentFunction();
        loop0: while (true) {
            findSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(channelSegment, j2, function2);
            if (!SegmentOrClosed.m113isClosedimpl(findSegmentInternal)) {
                Segment m112getSegmentimpl = SegmentOrClosed.m112getSegmentimpl(findSegmentInternal);
                while (true) {
                    Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                    if (segment.id >= m112getSegmentimpl.id) {
                        break loop0;
                    } else if (!m112getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    } else if (n3.y(atomicReferenceFieldUpdater, this, segment, m112getSegmentimpl)) {
                        if (segment.decPointers$kotlinx_coroutines_core()) {
                            segment.remove();
                        }
                    } else if (m112getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                        m112getSegmentimpl.remove();
                    }
                }
            } else {
                break;
            }
        }
        if (SegmentOrClosed.m113isClosedimpl(findSegmentInternal)) {
            completeCloseOrCancel();
            if (channelSegment.id * BufferedChannelKt.SEGMENT_SIZE >= getReceiversCounter$kotlinx_coroutines_core()) {
                return null;
            }
            channelSegment.cleanPrev();
            return null;
        }
        ChannelSegment<E> channelSegment2 = (ChannelSegment) SegmentOrClosed.m112getSegmentimpl(findSegmentInternal);
        long j4 = channelSegment2.id;
        if (j4 > j2) {
            int i = BufferedChannelKt.SEGMENT_SIZE;
            updateSendersCounterIfLower(j4 * i);
            if (channelSegment2.id * i >= getReceiversCounter$kotlinx_coroutines_core()) {
                return null;
            }
            channelSegment2.cleanPrev();
            return null;
        } else if (DebugKt.getASSERTIONS_ENABLED() && channelSegment2.id != j2) {
            throw new AssertionError();
        } else {
            return channelSegment2;
        }
    }

    private final long getBufferEndCounter() {
        return bufferEnd$FU.get(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Throwable getReceiveException() {
        Throwable closeCause = getCloseCause();
        if (closeCause == null) {
            return new ClosedReceiveChannelException("Channel was closed");
        }
        return closeCause;
    }

    private final void incCompletedExpandBufferAttempts(long j2) {
        if ((completedExpandBuffersAndPauseFlag$FU.addAndGet(this, j2) & 4611686018427387904L) != 0) {
            do {
            } while ((completedExpandBuffersAndPauseFlag$FU.get(this) & 4611686018427387904L) != 0);
        }
    }

    public static /* synthetic */ void incCompletedExpandBufferAttempts$default(BufferedChannel bufferedChannel, long j2, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                j2 = 1;
            }
            bufferedChannel.incCompletedExpandBufferAttempts(j2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
    }

    private final void invokeCloseHandler() {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = closeHandler$FU;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
        } while (!n3.y(atomicReferenceFieldUpdater, this, obj, obj == null ? BufferedChannelKt.CLOSE_HANDLER_CLOSED : BufferedChannelKt.CLOSE_HANDLER_INVOKED));
        if (obj == null) {
            return;
        }
        Function1 function1 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 1);
        ((Function1) obj).invoke(getCloseCause());
    }

    private final boolean isCellNonEmpty(ChannelSegment<E> channelSegment, int i, long j2) {
        Object state$kotlinx_coroutines_core;
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        Symbol symbol4;
        Symbol symbol5;
        Symbol symbol6;
        Symbol symbol7;
        do {
            state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
            if (state$kotlinx_coroutines_core != null) {
                symbol2 = BufferedChannelKt.IN_BUFFER;
                if (state$kotlinx_coroutines_core != symbol2) {
                    if (state$kotlinx_coroutines_core != BufferedChannelKt.BUFFERED) {
                        symbol3 = BufferedChannelKt.INTERRUPTED_SEND;
                        if (state$kotlinx_coroutines_core != symbol3 && state$kotlinx_coroutines_core != BufferedChannelKt.getCHANNEL_CLOSED()) {
                            symbol4 = BufferedChannelKt.DONE_RCV;
                            if (state$kotlinx_coroutines_core != symbol4) {
                                symbol5 = BufferedChannelKt.POISONED;
                                if (state$kotlinx_coroutines_core != symbol5) {
                                    symbol6 = BufferedChannelKt.RESUMING_BY_EB;
                                    if (state$kotlinx_coroutines_core != symbol6) {
                                        symbol7 = BufferedChannelKt.RESUMING_BY_RCV;
                                        if (state$kotlinx_coroutines_core == symbol7 || j2 != getReceiversCounter$kotlinx_coroutines_core()) {
                                            return false;
                                        }
                                        return true;
                                    }
                                    return true;
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return true;
                }
            }
            symbol = BufferedChannelKt.POISONED;
        } while (!channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, symbol));
        expandBuffer();
        return false;
    }

    private final boolean isClosed(long j2, boolean z2) {
        int i = (int) (j2 >> 60);
        if (i == 0 || i == 1) {
            return false;
        }
        if (i != 2) {
            if (i == 3) {
                completeCancel(j2 & 1152921504606846975L);
            } else {
                throw new IllegalStateException(("unexpected close status: " + i).toString());
            }
        } else {
            completeClose(j2 & 1152921504606846975L);
            if (z2 && hasElements$kotlinx_coroutines_core()) {
                return false;
            }
        }
        return true;
    }

    private final boolean isClosedForReceive0(long j2) {
        return isClosed(j2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isClosedForSend0(long j2) {
        return isClosed(j2, false);
    }

    private final boolean isRendezvousOrUnlimited() {
        long bufferEndCounter = getBufferEndCounter();
        if (bufferEndCounter != 0 && bufferEndCounter != Long.MAX_VALUE) {
            return false;
        }
        return true;
    }

    private final long markAllEmptyCellsAsClosed(ChannelSegment<E> channelSegment) {
        Symbol symbol;
        do {
            int i = BufferedChannelKt.SEGMENT_SIZE;
            while (true) {
                i--;
                if (-1 < i) {
                    long j2 = (channelSegment.id * BufferedChannelKt.SEGMENT_SIZE) + i;
                    if (j2 >= getReceiversCounter$kotlinx_coroutines_core()) {
                        while (true) {
                            Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
                            if (state$kotlinx_coroutines_core != null) {
                                symbol = BufferedChannelKt.IN_BUFFER;
                                if (state$kotlinx_coroutines_core != symbol) {
                                    if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED) {
                                        return j2;
                                    }
                                }
                            }
                            if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                                channelSegment.onSlotCleaned();
                                break;
                            }
                        }
                    } else {
                        return -1L;
                    }
                } else {
                    channelSegment = (ChannelSegment) channelSegment.getPrev();
                }
            }
        } while (channelSegment != null);
        return -1L;
    }

    private final void markCancellationStarted() {
        long j2;
        long constructSendersAndCloseStatus;
        AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$FU;
        do {
            j2 = atomicLongFieldUpdater.get(this);
            if (((int) (j2 >> 60)) == 0) {
                constructSendersAndCloseStatus = BufferedChannelKt.constructSendersAndCloseStatus(1152921504606846975L & j2, 1);
            } else {
                return;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j2, constructSendersAndCloseStatus));
    }

    private final void markCancelled() {
        long j2;
        long constructSendersAndCloseStatus;
        AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$FU;
        do {
            j2 = atomicLongFieldUpdater.get(this);
            constructSendersAndCloseStatus = BufferedChannelKt.constructSendersAndCloseStatus(1152921504606846975L & j2, 3);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j2, constructSendersAndCloseStatus));
    }

    private final void markClosed() {
        long j2;
        long constructSendersAndCloseStatus;
        AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$FU;
        do {
            j2 = atomicLongFieldUpdater.get(this);
            int i = (int) (j2 >> 60);
            if (i == 0) {
                constructSendersAndCloseStatus = BufferedChannelKt.constructSendersAndCloseStatus(j2 & 1152921504606846975L, 2);
            } else if (i == 1) {
                constructSendersAndCloseStatus = BufferedChannelKt.constructSendersAndCloseStatus(j2 & 1152921504606846975L, 3);
            } else {
                return;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j2, constructSendersAndCloseStatus));
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0011, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void moveSegmentBufferEndToSpecifiedOrLast(long r6, kotlinx.coroutines.channels.ChannelSegment<E> r8) {
        /*
            r5 = this;
        L0:
            long r0 = r8.id
            int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r2 >= 0) goto L11
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r0 = r8.getNext()
            kotlinx.coroutines.channels.ChannelSegment r0 = (kotlinx.coroutines.channels.ChannelSegment) r0
            if (r0 != 0) goto Lf
            goto L11
        Lf:
            r8 = r0
            goto L0
        L11:
            boolean r6 = r8.isRemoved()
            if (r6 == 0) goto L22
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r6 = r8.getNext()
            kotlinx.coroutines.channels.ChannelSegment r6 = (kotlinx.coroutines.channels.ChannelSegment) r6
            if (r6 != 0) goto L20
            goto L22
        L20:
            r8 = r6
            goto L11
        L22:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = kotlinx.coroutines.channels.BufferedChannel.bufferEndSegment$FU
        L24:
            java.lang.Object r7 = r6.get(r5)
            kotlinx.coroutines.internal.Segment r7 = (kotlinx.coroutines.internal.Segment) r7
            long r0 = r7.id
            long r2 = r8.id
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L33
            goto L49
        L33:
            boolean r0 = r8.tryIncPointers$kotlinx_coroutines_core()
            if (r0 != 0) goto L3a
            goto L11
        L3a:
            boolean r0 = r.n3.y(r6, r5, r7, r8)
            if (r0 == 0) goto L4a
            boolean r6 = r7.decPointers$kotlinx_coroutines_core()
            if (r6 == 0) goto L49
            r7.remove()
        L49:
            return
        L4a:
            boolean r7 = r8.decPointers$kotlinx_coroutines_core()
            if (r7 == 0) goto L24
            r8.remove()
            goto L24
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.moveSegmentBufferEndToSpecifiedOrLast(long, kotlinx.coroutines.channels.ChannelSegment):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClosedReceiveCatchingOnNoWaiterSuspend(CancellableContinuation<? super ChannelResult<? extends E>> cancellableContinuation) {
        Result.Companion companion = Result.Companion;
        cancellableContinuation.resumeWith(Result.m28constructorimpl(ChannelResult.m86boximpl(ChannelResult.Companion.m96closedJP2dKIU(getCloseCause()))));
    }

    private final void onClosedSelectOnReceive(SelectInstance<?> selectInstance) {
        selectInstance.selectInRegistrationPhase(BufferedChannelKt.getCHANNEL_CLOSED());
    }

    private final Object onClosedSend(E e2, Continuation<? super Unit> continuation) {
        Throwable callUndeliveredElementCatchingException$default;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        if (function1 != null && (callUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, e2, null, 2, null)) != null) {
            ExceptionsKt.addSuppressed(callUndeliveredElementCatchingException$default, getSendException());
            Result.Companion companion = Result.Companion;
            if (DebugKt.getRECOVER_STACK_TRACES()) {
                callUndeliveredElementCatchingException$default = StackTraceRecoveryKt.recoverFromStackFrame(callUndeliveredElementCatchingException$default, cancellableContinuationImpl);
            }
            cancellableContinuationImpl.resumeWith(Result.m28constructorimpl(ResultKt.createFailure(callUndeliveredElementCatchingException$default)));
        } else {
            Throwable sendException = getSendException();
            Result.Companion companion2 = Result.Companion;
            if (DebugKt.getRECOVER_STACK_TRACES()) {
                sendException = StackTraceRecoveryKt.recoverFromStackFrame(sendException, cancellableContinuationImpl);
            }
            cancellableContinuationImpl.resumeWith(Result.m28constructorimpl(ResultKt.createFailure(sendException)));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return result;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClosedSendOnNoWaiterSuspend(E e2, CancellableContinuation<? super Unit> cancellableContinuation) {
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        if (function1 != null) {
            OnUndeliveredElementKt.callUndeliveredElement(function1, e2, cancellableContinuation.getContext());
        }
        Throwable sendException = getSendException();
        if (DebugKt.getRECOVER_STACK_TRACES() && (cancellableContinuation instanceof CoroutineStackFrame)) {
            sendException = StackTraceRecoveryKt.recoverFromStackFrame(sendException, (CoroutineStackFrame) cancellableContinuation);
        }
        Result.Companion companion = Result.Companion;
        cancellableContinuation.resumeWith(Result.m28constructorimpl(ResultKt.createFailure(sendException)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void prepareReceiverForSuspension(Waiter waiter, ChannelSegment<E> channelSegment, int i) {
        onReceiveEnqueued();
        waiter.invokeOnCancellation(channelSegment, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void prepareSenderForSuspension(Waiter waiter, ChannelSegment<E> channelSegment, int i) {
        waiter.invokeOnCancellation(channelSegment, i + BufferedChannelKt.SEGMENT_SIZE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object processResultSelectReceiveCatching(Object obj, Object obj2) {
        Object m98successJP2dKIU;
        if (obj2 == BufferedChannelKt.getCHANNEL_CLOSED()) {
            m98successJP2dKIU = ChannelResult.Companion.m96closedJP2dKIU(getCloseCause());
        } else {
            m98successJP2dKIU = ChannelResult.Companion.m98successJP2dKIU(obj2);
        }
        return ChannelResult.m86boximpl(m98successJP2dKIU);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* renamed from: receiveCatching-JP2dKIU$suspendImpl  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ <E> java.lang.Object m81receiveCatchingJP2dKIU$suspendImpl(kotlinx.coroutines.channels.BufferedChannel<E> r13, kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ChannelResult<? extends E>> r14) {
        /*
            boolean r0 = r14 instanceof kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1
            if (r0 == 0) goto L14
            r0 = r14
            kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1 r0 = (kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1 r0 = new kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1
            r0.<init>(r13, r14)
            goto L12
        L1a:
            java.lang.Object r14 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L3a
            if (r1 != r2) goto L32
            kotlin.ResultKt.throwOnFailure(r14)
            kotlinx.coroutines.channels.ChannelResult r14 = (kotlinx.coroutines.channels.ChannelResult) r14
            java.lang.Object r13 = r14.m95unboximpl()
            goto Lb2
        L32:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L3a:
            kotlin.ResultKt.throwOnFailure(r14)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r14 = access$getReceiveSegment$FU$p()
            java.lang.Object r14 = r14.get(r13)
            kotlinx.coroutines.channels.ChannelSegment r14 = (kotlinx.coroutines.channels.ChannelSegment) r14
        L47:
            boolean r1 = r13.isClosedForReceive()
            if (r1 == 0) goto L58
            kotlinx.coroutines.channels.ChannelResult$Companion r14 = kotlinx.coroutines.channels.ChannelResult.Companion
            java.lang.Throwable r13 = r13.getCloseCause()
            java.lang.Object r13 = r14.m96closedJP2dKIU(r13)
            goto Lb2
        L58:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = access$getReceivers$FU$p()
            long r4 = r1.getAndIncrement(r13)
            int r1 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r7 = (long) r1
            long r7 = r4 / r7
            long r9 = (long) r1
            long r9 = r4 % r9
            int r3 = (int) r9
            long r9 = r14.id
            int r1 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r1 == 0) goto L77
            kotlinx.coroutines.channels.ChannelSegment r1 = access$findSegmentReceive(r13, r7, r14)
            if (r1 != 0) goto L76
            goto L47
        L76:
            r14 = r1
        L77:
            r12 = 0
            r7 = r13
            r8 = r14
            r9 = r3
            r10 = r4
            java.lang.Object r1 = access$updateCellReceive(r7, r8, r9, r10, r12)
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.access$getSUSPEND$p()
            if (r1 == r7) goto Lb3
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.access$getFAILED$p()
            if (r1 != r7) goto L98
            long r7 = r13.getSendersCounter$kotlinx_coroutines_core()
            int r1 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r1 >= 0) goto L47
            r14.cleanPrev()
            goto L47
        L98:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()
            if (r1 != r7) goto La9
            r6.label = r2
            r1 = r13
            r2 = r14
            java.lang.Object r13 = r1.m82receiveCatchingOnNoWaiterSuspendGKJJFZk(r2, r3, r4, r6)
            if (r13 != r0) goto Lb2
            return r0
        La9:
            r14.cleanPrev()
            kotlinx.coroutines.channels.ChannelResult$Companion r13 = kotlinx.coroutines.channels.ChannelResult.Companion
            java.lang.Object r13 = r13.m98successJP2dKIU(r1)
        Lb2:
            return r13
        Lb3:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "unexpected"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.m81receiveCatchingJP2dKIU$suspendImpl(kotlinx.coroutines.channels.BufferedChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* renamed from: receiveCatchingOnNoWaiterSuspend-GKJJFZk  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m82receiveCatchingOnNoWaiterSuspendGKJJFZk(kotlinx.coroutines.channels.ChannelSegment<E> r11, int r12, long r13, kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ChannelResult<? extends E>> r15) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.m82receiveCatchingOnNoWaiterSuspendGKJJFZk(kotlinx.coroutines.channels.ChannelSegment, int, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerSelectForReceive(SelectInstance<?> selectInstance, Object obj) {
        Symbol symbol;
        Waiter waiter;
        Symbol symbol2;
        Symbol symbol3;
        ChannelSegment channelSegment = (ChannelSegment) receiveSegment$FU.get(this);
        while (!isClosedForReceive()) {
            long andIncrement = receivers$FU.getAndIncrement(this);
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j2 = andIncrement / i;
            int i5 = (int) (andIncrement % i);
            if (channelSegment.id != j2) {
                ChannelSegment findSegmentReceive = findSegmentReceive(j2, channelSegment);
                if (findSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = findSegmentReceive;
                }
            }
            Object updateCellReceive = updateCellReceive(channelSegment, i5, andIncrement, selectInstance);
            symbol = BufferedChannelKt.SUSPEND;
            if (updateCellReceive != symbol) {
                symbol2 = BufferedChannelKt.FAILED;
                if (updateCellReceive != symbol2) {
                    symbol3 = BufferedChannelKt.SUSPEND_NO_WAITER;
                    if (updateCellReceive != symbol3) {
                        channelSegment.cleanPrev();
                        selectInstance.selectInRegistrationPhase(updateCellReceive);
                        return;
                    }
                    throw new IllegalStateException("unexpected");
                } else if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
            } else {
                if (selectInstance instanceof Waiter) {
                    waiter = (Waiter) selectInstance;
                } else {
                    waiter = null;
                }
                if (waiter != null) {
                    prepareReceiverForSuspension(waiter, channelSegment, i5);
                    return;
                }
                return;
            }
        }
        onClosedSelectOnReceive(selectInstance);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b4, code lost:
        r13 = (kotlinx.coroutines.channels.ChannelSegment) r13.getPrev();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void removeUnprocessedElements(kotlinx.coroutines.channels.ChannelSegment<E> r13) {
        /*
            r12 = this;
            kotlin.jvm.functions.Function1<E, kotlin.Unit> r0 = r12.onUndeliveredElement
            r1 = 0
            r2 = 1
            java.lang.Object r3 = kotlinx.coroutines.internal.InlineList.m107constructorimpl$default(r1, r2, r1)
        L8:
            int r4 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            int r4 = r4 - r2
        Lb:
            r5 = -1
            if (r5 >= r4) goto Lb4
            long r6 = r13.id
            int r8 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r8 = (long) r8
            long r6 = r6 * r8
            long r8 = (long) r4
            long r6 = r6 + r8
        L17:
            java.lang.Object r8 = r13.getState$kotlinx_coroutines_core(r4)
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.access$getDONE_RCV$p()
            if (r8 == r9) goto Lbc
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.BUFFERED
            if (r8 != r9) goto L49
            long r9 = r12.getReceiversCounter$kotlinx_coroutines_core()
            int r11 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r11 < 0) goto Lbc
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED()
            boolean r8 = r13.casState$kotlinx_coroutines_core(r4, r8, r9)
            if (r8 == 0) goto L17
            if (r0 == 0) goto L41
            java.lang.Object r5 = r13.getElement$kotlinx_coroutines_core(r4)
            kotlinx.coroutines.internal.UndeliveredElementException r1 = kotlinx.coroutines.internal.OnUndeliveredElementKt.callUndeliveredElementCatchingException(r0, r5, r1)
        L41:
            r13.cleanElement$kotlinx_coroutines_core(r4)
            r13.onSlotCleaned()
            goto Lb0
        L49:
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.access$getIN_BUFFER$p()
            if (r8 == r9) goto La3
            if (r8 != 0) goto L52
            goto La3
        L52:
            boolean r9 = r8 instanceof kotlinx.coroutines.Waiter
            if (r9 != 0) goto L6f
            boolean r9 = r8 instanceof kotlinx.coroutines.channels.WaiterEB
            if (r9 == 0) goto L5b
            goto L6f
        L5b:
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.access$getRESUMING_BY_EB$p()
            if (r8 == r9) goto Lbc
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.access$getRESUMING_BY_RCV$p()
            if (r8 != r9) goto L68
            goto Lbc
        L68:
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.access$getRESUMING_BY_EB$p()
            if (r8 == r9) goto L17
            goto Lb0
        L6f:
            long r9 = r12.getReceiversCounter$kotlinx_coroutines_core()
            int r11 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r11 < 0) goto Lbc
            boolean r9 = r8 instanceof kotlinx.coroutines.channels.WaiterEB
            if (r9 == 0) goto L81
            r9 = r8
            kotlinx.coroutines.channels.WaiterEB r9 = (kotlinx.coroutines.channels.WaiterEB) r9
            kotlinx.coroutines.Waiter r9 = r9.waiter
            goto L84
        L81:
            r9 = r8
            kotlinx.coroutines.Waiter r9 = (kotlinx.coroutines.Waiter) r9
        L84:
            kotlinx.coroutines.internal.Symbol r10 = kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED()
            boolean r8 = r13.casState$kotlinx_coroutines_core(r4, r8, r10)
            if (r8 == 0) goto L17
            if (r0 == 0) goto L98
            java.lang.Object r5 = r13.getElement$kotlinx_coroutines_core(r4)
            kotlinx.coroutines.internal.UndeliveredElementException r1 = kotlinx.coroutines.internal.OnUndeliveredElementKt.callUndeliveredElementCatchingException(r0, r5, r1)
        L98:
            java.lang.Object r3 = kotlinx.coroutines.internal.InlineList.m108plusFjFbRPM(r3, r9)
            r13.cleanElement$kotlinx_coroutines_core(r4)
            r13.onSlotCleaned()
            goto Lb0
        La3:
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED()
            boolean r8 = r13.casState$kotlinx_coroutines_core(r4, r8, r9)
            if (r8 == 0) goto L17
            r13.onSlotCleaned()
        Lb0:
            int r4 = r4 + (-1)
            goto Lb
        Lb4:
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r13 = r13.getPrev()
            kotlinx.coroutines.channels.ChannelSegment r13 = (kotlinx.coroutines.channels.ChannelSegment) r13
            if (r13 != 0) goto L8
        Lbc:
            if (r3 == 0) goto Le2
            boolean r13 = r3 instanceof java.util.ArrayList
            if (r13 != 0) goto Lc8
            kotlinx.coroutines.Waiter r3 = (kotlinx.coroutines.Waiter) r3
            r12.resumeSenderOnCancelledChannel(r3)
            goto Le2
        Lc8:
            java.lang.String r13 = "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r13)
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            int r13 = r3.size()
            int r13 = r13 - r2
        Ld4:
            if (r5 >= r13) goto Le2
            java.lang.Object r0 = r3.get(r13)
            kotlinx.coroutines.Waiter r0 = (kotlinx.coroutines.Waiter) r0
            r12.resumeSenderOnCancelledChannel(r0)
            int r13 = r13 + (-1)
            goto Ld4
        Le2:
            if (r1 != 0) goto Le5
            return
        Le5:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.removeUnprocessedElements(kotlinx.coroutines.channels.ChannelSegment):void");
    }

    private final void resumeReceiverOnClosedChannel(Waiter waiter) {
        resumeWaiterOnClosedChannel(waiter, true);
    }

    private final void resumeSenderOnCancelledChannel(Waiter waiter) {
        resumeWaiterOnClosedChannel(waiter, false);
    }

    private final void resumeWaiterOnClosedChannel(Waiter waiter, boolean z2) {
        Throwable sendException;
        if (waiter instanceof SendBroadcast) {
            CancellableContinuation<Boolean> cont = ((SendBroadcast) waiter).getCont();
            Result.Companion companion = Result.Companion;
            cont.resumeWith(Result.m28constructorimpl(Boolean.FALSE));
        } else if (waiter instanceof CancellableContinuation) {
            Continuation continuation = (Continuation) waiter;
            Result.Companion companion2 = Result.Companion;
            if (z2) {
                sendException = getReceiveException();
            } else {
                sendException = getSendException();
            }
            continuation.resumeWith(Result.m28constructorimpl(ResultKt.createFailure(sendException)));
        } else if (waiter instanceof ReceiveCatching) {
            CancellableContinuationImpl<ChannelResult<? extends E>> cancellableContinuationImpl = ((ReceiveCatching) waiter).cont;
            Result.Companion companion3 = Result.Companion;
            cancellableContinuationImpl.resumeWith(Result.m28constructorimpl(ChannelResult.m86boximpl(ChannelResult.Companion.m96closedJP2dKIU(getCloseCause()))));
        } else if (waiter instanceof BufferedChannelIterator) {
            ((BufferedChannelIterator) waiter).tryResumeHasNextOnClosedChannel();
        } else if (waiter instanceof SelectInstance) {
            ((SelectInstance) waiter).trySelect(this, BufferedChannelKt.getCHANNEL_CLOSED());
        } else {
            throw new IllegalStateException(("Unexpected waiter: " + waiter).toString());
        }
    }

    public static /* synthetic */ <E> Object send$suspendImpl(BufferedChannel<E> bufferedChannel, E e2, Continuation<? super Unit> continuation) {
        ChannelSegment<E> channelSegment = (ChannelSegment) sendSegment$FU.get(bufferedChannel);
        while (true) {
            long andIncrement = sendersAndCloseStatus$FU.getAndIncrement(bufferedChannel);
            long j2 = 1152921504606846975L & andIncrement;
            boolean isClosedForSend0 = bufferedChannel.isClosedForSend0(andIncrement);
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j4 = j2 / i;
            int i5 = (int) (j2 % i);
            if (channelSegment.id != j4) {
                ChannelSegment<E> findSegmentSend = bufferedChannel.findSegmentSend(j4, channelSegment);
                if (findSegmentSend == null) {
                    if (isClosedForSend0) {
                        Object onClosedSend = bufferedChannel.onClosedSend(e2, continuation);
                        if (onClosedSend == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            return onClosedSend;
                        }
                    }
                } else {
                    channelSegment = findSegmentSend;
                }
            }
            int updateCellSend = bufferedChannel.updateCellSend(channelSegment, i5, e2, j2, null, isClosedForSend0);
            if (updateCellSend != 0) {
                if (updateCellSend == 1) {
                    break;
                } else if (updateCellSend != 2) {
                    if (updateCellSend != 3) {
                        if (updateCellSend != 4) {
                            if (updateCellSend == 5) {
                                channelSegment.cleanPrev();
                            }
                        } else {
                            if (j2 < bufferedChannel.getReceiversCounter$kotlinx_coroutines_core()) {
                                channelSegment.cleanPrev();
                            }
                            Object onClosedSend2 = bufferedChannel.onClosedSend(e2, continuation);
                            if (onClosedSend2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                return onClosedSend2;
                            }
                        }
                    } else {
                        Object sendOnNoWaiterSuspend = bufferedChannel.sendOnNoWaiterSuspend(channelSegment, i5, e2, j2, continuation);
                        if (sendOnNoWaiterSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            return sendOnNoWaiterSuspend;
                        }
                    }
                } else if (isClosedForSend0) {
                    channelSegment.onSlotCleaned();
                    Object onClosedSend3 = bufferedChannel.onClosedSend(e2, continuation);
                    if (onClosedSend3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return onClosedSend3;
                    }
                } else if (DebugKt.getASSERTIONS_ENABLED()) {
                    throw new AssertionError();
                }
            } else {
                channelSegment.cleanPrev();
                break;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x011d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object sendOnNoWaiterSuspend(kotlinx.coroutines.channels.ChannelSegment<E> r21, int r22, E r23, long r24, kotlin.coroutines.Continuation<? super kotlin.Unit> r26) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.sendOnNoWaiterSuspend(kotlinx.coroutines.channels.ChannelSegment, int, java.lang.Object, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean shouldSendSuspend(long j2) {
        if (isClosedForSend0(j2)) {
            return false;
        }
        return !bufferOrRendezvousSend(j2 & 1152921504606846975L);
    }

    private final boolean tryResumeReceiver(Object obj, E e2) {
        boolean tryResume0;
        boolean tryResume02;
        if (obj instanceof SelectInstance) {
            return ((SelectInstance) obj).trySelect(this, e2);
        }
        Function1<Throwable, Unit> function1 = null;
        if (obj instanceof ReceiveCatching) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            ReceiveCatching receiveCatching = (ReceiveCatching) obj;
            CancellableContinuationImpl<ChannelResult<? extends E>> cancellableContinuationImpl = receiveCatching.cont;
            ChannelResult m86boximpl = ChannelResult.m86boximpl(ChannelResult.Companion.m98successJP2dKIU(e2));
            Function1<E, Unit> function12 = this.onUndeliveredElement;
            if (function12 != null) {
                function1 = OnUndeliveredElementKt.bindCancellationFun(function12, e2, receiveCatching.cont.getContext());
            }
            tryResume02 = BufferedChannelKt.tryResume0(cancellableContinuationImpl, m86boximpl, function1);
            return tryResume02;
        } else if (obj instanceof BufferedChannelIterator) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            return ((BufferedChannelIterator) obj).tryResumeHasNext(e2);
        } else if (obj instanceof CancellableContinuation) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            CancellableContinuation cancellableContinuation = (CancellableContinuation) obj;
            Function1<E, Unit> function13 = this.onUndeliveredElement;
            if (function13 != null) {
                function1 = OnUndeliveredElementKt.bindCancellationFun(function13, e2, cancellableContinuation.getContext());
            }
            tryResume0 = BufferedChannelKt.tryResume0(cancellableContinuation, e2, function1);
            return tryResume0;
        } else {
            throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
        }
    }

    private final boolean tryResumeSender(Object obj, ChannelSegment<E> channelSegment, int i) {
        if (obj instanceof CancellableContinuation) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return BufferedChannelKt.tryResume0$default((CancellableContinuation) obj, Unit.INSTANCE, null, 2, null);
        } else if (obj instanceof SelectInstance) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            TrySelectDetailedResult trySelectDetailed = ((SelectImplementation) obj).trySelectDetailed(this, Unit.INSTANCE);
            if (trySelectDetailed == TrySelectDetailedResult.REREGISTER) {
                channelSegment.cleanElement$kotlinx_coroutines_core(i);
            }
            if (trySelectDetailed == TrySelectDetailedResult.SUCCESSFUL) {
                return true;
            }
            return false;
        } else if (obj instanceof SendBroadcast) {
            return BufferedChannelKt.tryResume0$default(((SendBroadcast) obj).getCont(), Boolean.TRUE, null, 2, null);
        } else {
            throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
        }
    }

    private final boolean updateCellExpandBuffer(ChannelSegment<E> channelSegment, int i, long j2) {
        Symbol symbol;
        Symbol symbol2;
        Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
        if ((state$kotlinx_coroutines_core instanceof Waiter) && j2 >= receivers$FU.get(this)) {
            symbol = BufferedChannelKt.RESUMING_BY_EB;
            if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, symbol)) {
                if (!tryResumeSender(state$kotlinx_coroutines_core, channelSegment, i)) {
                    symbol2 = BufferedChannelKt.INTERRUPTED_SEND;
                    channelSegment.setState$kotlinx_coroutines_core(i, symbol2);
                    channelSegment.onCancelledRequest(i, false);
                    return false;
                }
                channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.BUFFERED);
                return true;
            }
        }
        return updateCellExpandBufferSlow(channelSegment, i, j2);
    }

    private final boolean updateCellExpandBufferSlow(ChannelSegment<E> channelSegment, int i, long j2) {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        Symbol symbol4;
        Symbol symbol5;
        Symbol symbol6;
        Symbol symbol7;
        Symbol symbol8;
        while (true) {
            Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
            if (!(state$kotlinx_coroutines_core instanceof Waiter)) {
                symbol3 = BufferedChannelKt.INTERRUPTED_SEND;
                if (state$kotlinx_coroutines_core == symbol3) {
                    return false;
                }
                if (state$kotlinx_coroutines_core == null) {
                    symbol4 = BufferedChannelKt.IN_BUFFER;
                    if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, symbol4)) {
                        return true;
                    }
                } else if (state$kotlinx_coroutines_core != BufferedChannelKt.BUFFERED) {
                    symbol5 = BufferedChannelKt.POISONED;
                    if (state$kotlinx_coroutines_core == symbol5) {
                        break;
                    }
                    symbol6 = BufferedChannelKt.DONE_RCV;
                    if (state$kotlinx_coroutines_core == symbol6) {
                        break;
                    }
                    symbol7 = BufferedChannelKt.INTERRUPTED_RCV;
                    if (state$kotlinx_coroutines_core != symbol7 && state$kotlinx_coroutines_core != BufferedChannelKt.getCHANNEL_CLOSED()) {
                        symbol8 = BufferedChannelKt.RESUMING_BY_RCV;
                        if (state$kotlinx_coroutines_core != symbol8) {
                            throw new IllegalStateException(("Unexpected cell state: " + state$kotlinx_coroutines_core).toString());
                        }
                    } else {
                        return true;
                    }
                } else {
                    return true;
                }
            } else if (j2 >= receivers$FU.get(this)) {
                symbol = BufferedChannelKt.RESUMING_BY_EB;
                if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, symbol)) {
                    if (!tryResumeSender(state$kotlinx_coroutines_core, channelSegment, i)) {
                        symbol2 = BufferedChannelKt.INTERRUPTED_SEND;
                        channelSegment.setState$kotlinx_coroutines_core(i, symbol2);
                        channelSegment.onCancelledRequest(i, false);
                        return false;
                    }
                    channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.BUFFERED);
                    return true;
                }
            } else if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, new WaiterEB((Waiter) state$kotlinx_coroutines_core))) {
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updateCellReceive(ChannelSegment<E> channelSegment, int i, long j2, Object obj) {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
        if (state$kotlinx_coroutines_core == null) {
            if (j2 >= (sendersAndCloseStatus$FU.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    symbol3 = BufferedChannelKt.SUSPEND_NO_WAITER;
                    return symbol3;
                } else if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, obj)) {
                    expandBuffer();
                    symbol2 = BufferedChannelKt.SUSPEND;
                    return symbol2;
                }
            }
        } else if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED) {
            symbol = BufferedChannelKt.DONE_RCV;
            if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, symbol)) {
                expandBuffer();
                return channelSegment.retrieveElement$kotlinx_coroutines_core(i);
            }
        }
        return updateCellReceiveSlow(channelSegment, i, j2, obj);
    }

    private final Object updateCellReceiveSlow(ChannelSegment<E> channelSegment, int i, long j2, Object obj) {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        Symbol symbol4;
        Symbol symbol5;
        Symbol symbol6;
        Symbol symbol7;
        Symbol symbol8;
        Symbol symbol9;
        Symbol symbol10;
        Symbol symbol11;
        Symbol symbol12;
        Symbol symbol13;
        Symbol symbol14;
        Symbol symbol15;
        Symbol symbol16;
        while (true) {
            Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
            if (state$kotlinx_coroutines_core != null) {
                symbol5 = BufferedChannelKt.IN_BUFFER;
                if (state$kotlinx_coroutines_core != symbol5) {
                    if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED) {
                        symbol6 = BufferedChannelKt.DONE_RCV;
                        if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, symbol6)) {
                            expandBuffer();
                            return channelSegment.retrieveElement$kotlinx_coroutines_core(i);
                        }
                    } else {
                        symbol7 = BufferedChannelKt.INTERRUPTED_SEND;
                        if (state$kotlinx_coroutines_core == symbol7) {
                            symbol8 = BufferedChannelKt.FAILED;
                            return symbol8;
                        }
                        symbol9 = BufferedChannelKt.POISONED;
                        if (state$kotlinx_coroutines_core == symbol9) {
                            symbol10 = BufferedChannelKt.FAILED;
                            return symbol10;
                        } else if (state$kotlinx_coroutines_core != BufferedChannelKt.getCHANNEL_CLOSED()) {
                            symbol12 = BufferedChannelKt.RESUMING_BY_EB;
                            if (state$kotlinx_coroutines_core != symbol12) {
                                symbol13 = BufferedChannelKt.RESUMING_BY_RCV;
                                if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, symbol13)) {
                                    boolean z2 = state$kotlinx_coroutines_core instanceof WaiterEB;
                                    if (z2) {
                                        state$kotlinx_coroutines_core = ((WaiterEB) state$kotlinx_coroutines_core).waiter;
                                    }
                                    if (tryResumeSender(state$kotlinx_coroutines_core, channelSegment, i)) {
                                        symbol16 = BufferedChannelKt.DONE_RCV;
                                        channelSegment.setState$kotlinx_coroutines_core(i, symbol16);
                                        expandBuffer();
                                        return channelSegment.retrieveElement$kotlinx_coroutines_core(i);
                                    }
                                    symbol14 = BufferedChannelKt.INTERRUPTED_SEND;
                                    channelSegment.setState$kotlinx_coroutines_core(i, symbol14);
                                    channelSegment.onCancelledRequest(i, false);
                                    if (z2) {
                                        expandBuffer();
                                    }
                                    symbol15 = BufferedChannelKt.FAILED;
                                    return symbol15;
                                }
                            } else {
                                continue;
                            }
                        } else {
                            expandBuffer();
                            symbol11 = BufferedChannelKt.FAILED;
                            return symbol11;
                        }
                    }
                }
            }
            if (j2 < (sendersAndCloseStatus$FU.get(this) & 1152921504606846975L)) {
                symbol = BufferedChannelKt.POISONED;
                if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, symbol)) {
                    expandBuffer();
                    symbol2 = BufferedChannelKt.FAILED;
                    return symbol2;
                }
            } else if (obj == null) {
                symbol3 = BufferedChannelKt.SUSPEND_NO_WAITER;
                return symbol3;
            } else if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, obj)) {
                expandBuffer();
                symbol4 = BufferedChannelKt.SUSPEND;
                return symbol4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int updateCellSend(ChannelSegment<E> channelSegment, int i, E e2, long j2, Object obj, boolean z2) {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        channelSegment.storeElement$kotlinx_coroutines_core(i, e2);
        if (z2) {
            return updateCellSendSlow(channelSegment, i, e2, j2, obj, z2);
        }
        Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
        if (state$kotlinx_coroutines_core == null) {
            if (bufferOrRendezvousSend(j2)) {
                if (channelSegment.casState$kotlinx_coroutines_core(i, null, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            } else if (obj == null) {
                return 3;
            } else {
                if (channelSegment.casState$kotlinx_coroutines_core(i, null, obj)) {
                    return 2;
                }
            }
        } else if (state$kotlinx_coroutines_core instanceof Waiter) {
            channelSegment.cleanElement$kotlinx_coroutines_core(i);
            if (tryResumeReceiver(state$kotlinx_coroutines_core, e2)) {
                symbol3 = BufferedChannelKt.DONE_RCV;
                channelSegment.setState$kotlinx_coroutines_core(i, symbol3);
                onReceiveDequeued();
                return 0;
            }
            symbol = BufferedChannelKt.INTERRUPTED_RCV;
            Object andSetState$kotlinx_coroutines_core = channelSegment.getAndSetState$kotlinx_coroutines_core(i, symbol);
            symbol2 = BufferedChannelKt.INTERRUPTED_RCV;
            if (andSetState$kotlinx_coroutines_core != symbol2) {
                channelSegment.onCancelledRequest(i, true);
            }
            return 5;
        }
        return updateCellSendSlow(channelSegment, i, e2, j2, obj, z2);
    }

    private final int updateCellSendSlow(ChannelSegment<E> channelSegment, int i, E e2, long j2, Object obj, boolean z2) {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        Symbol symbol4;
        Symbol symbol5;
        Symbol symbol6;
        Symbol symbol7;
        while (true) {
            Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
            if (state$kotlinx_coroutines_core != null) {
                symbol2 = BufferedChannelKt.IN_BUFFER;
                if (state$kotlinx_coroutines_core != symbol2) {
                    symbol3 = BufferedChannelKt.INTERRUPTED_RCV;
                    if (state$kotlinx_coroutines_core != symbol3) {
                        symbol4 = BufferedChannelKt.POISONED;
                        if (state$kotlinx_coroutines_core == symbol4) {
                            channelSegment.cleanElement$kotlinx_coroutines_core(i);
                            return 5;
                        } else if (state$kotlinx_coroutines_core == BufferedChannelKt.getCHANNEL_CLOSED()) {
                            channelSegment.cleanElement$kotlinx_coroutines_core(i);
                            completeCloseOrCancel();
                            return 4;
                        } else if (DebugKt.getASSERTIONS_ENABLED() && !(state$kotlinx_coroutines_core instanceof Waiter) && !(state$kotlinx_coroutines_core instanceof WaiterEB)) {
                            throw new AssertionError();
                        } else {
                            channelSegment.cleanElement$kotlinx_coroutines_core(i);
                            if (state$kotlinx_coroutines_core instanceof WaiterEB) {
                                state$kotlinx_coroutines_core = ((WaiterEB) state$kotlinx_coroutines_core).waiter;
                            }
                            if (tryResumeReceiver(state$kotlinx_coroutines_core, e2)) {
                                symbol7 = BufferedChannelKt.DONE_RCV;
                                channelSegment.setState$kotlinx_coroutines_core(i, symbol7);
                                onReceiveDequeued();
                                return 0;
                            }
                            symbol5 = BufferedChannelKt.INTERRUPTED_RCV;
                            Object andSetState$kotlinx_coroutines_core = channelSegment.getAndSetState$kotlinx_coroutines_core(i, symbol5);
                            symbol6 = BufferedChannelKt.INTERRUPTED_RCV;
                            if (andSetState$kotlinx_coroutines_core != symbol6) {
                                channelSegment.onCancelledRequest(i, true);
                            }
                            return 5;
                        }
                    }
                    channelSegment.cleanElement$kotlinx_coroutines_core(i);
                    return 5;
                } else if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            } else if (bufferOrRendezvousSend(j2) && !z2) {
                if (channelSegment.casState$kotlinx_coroutines_core(i, null, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            } else if (z2) {
                symbol = BufferedChannelKt.INTERRUPTED_SEND;
                if (channelSegment.casState$kotlinx_coroutines_core(i, null, symbol)) {
                    channelSegment.onCancelledRequest(i, false);
                    return 4;
                }
            } else if (obj == null) {
                return 3;
            } else {
                if (channelSegment.casState$kotlinx_coroutines_core(i, null, obj)) {
                    return 2;
                }
            }
        }
    }

    private final void updateReceiversCounterIfLower(long j2) {
        long j4;
        AtomicLongFieldUpdater atomicLongFieldUpdater = receivers$FU;
        do {
            j4 = atomicLongFieldUpdater.get(this);
            if (j4 >= j2) {
                return;
            }
        } while (!receivers$FU.compareAndSet(this, j4, j2));
    }

    private final void updateSendersCounterIfLower(long j2) {
        long j4;
        long constructSendersAndCloseStatus;
        AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$FU;
        do {
            j4 = atomicLongFieldUpdater.get(this);
            long j6 = 1152921504606846975L & j4;
            if (j6 < j2) {
                constructSendersAndCloseStatus = BufferedChannelKt.constructSendersAndCloseStatus(j6, (int) (j4 >> 60));
            } else {
                return;
            }
        } while (!sendersAndCloseStatus$FU.compareAndSet(this, j4, constructSendersAndCloseStatus));
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel(CancellationException cancellationException) {
        cancelImpl$kotlinx_coroutines_core(cancellationException);
    }

    public boolean cancelImpl$kotlinx_coroutines_core(Throwable th) {
        if (th == null) {
            th = new CancellationException("Channel was cancelled");
        }
        return closeOrCancelImpl(th, true);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable th) {
        return closeOrCancelImpl(th, false);
    }

    public boolean closeOrCancelImpl(Throwable th, boolean z2) {
        Symbol symbol;
        if (z2) {
            markCancellationStarted();
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _closeCause$FU;
        symbol = BufferedChannelKt.NO_CLOSE_CAUSE;
        boolean y = n3.y(atomicReferenceFieldUpdater, this, symbol, th);
        if (z2) {
            markCancelled();
        } else {
            markClosed();
        }
        completeCloseOrCancel();
        onClosedIdempotent();
        if (y) {
            invokeCloseHandler();
        }
        return y;
    }

    public final void dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(long j2) {
        Symbol symbol;
        UndeliveredElementException callUndeliveredElementCatchingException$default;
        if (DebugKt.getASSERTIONS_ENABLED() && !isConflatedDropOldest()) {
            throw new AssertionError();
        }
        ChannelSegment<E> channelSegment = (ChannelSegment) receiveSegment$FU.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = receivers$FU;
            long j4 = atomicLongFieldUpdater.get(this);
            if (j2 < Math.max(this.capacity + j4, getBufferEndCounter())) {
                return;
            }
            if (atomicLongFieldUpdater.compareAndSet(this, j4, j4 + 1)) {
                int i = BufferedChannelKt.SEGMENT_SIZE;
                long j6 = j4 / i;
                int i5 = (int) (j4 % i);
                if (channelSegment.id != j6) {
                    ChannelSegment<E> findSegmentReceive = findSegmentReceive(j6, channelSegment);
                    if (findSegmentReceive == null) {
                        continue;
                    } else {
                        channelSegment = findSegmentReceive;
                    }
                }
                Object updateCellReceive = updateCellReceive(channelSegment, i5, j4, null);
                symbol = BufferedChannelKt.FAILED;
                if (updateCellReceive == symbol) {
                    if (j4 < getSendersCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                } else {
                    channelSegment.cleanPrev();
                    Function1<E, Unit> function1 = this.onUndeliveredElement;
                    if (function1 != null && (callUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, updateCellReceive, null, 2, null)) != null) {
                        throw callUndeliveredElementCatchingException$default;
                    }
                }
            }
        }
    }

    public final Throwable getCloseCause() {
        return (Throwable) _closeCause$FU.get(this);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1<ChannelResult<E>> getOnReceiveCatching() {
        BufferedChannel$onReceiveCatching$1 bufferedChannel$onReceiveCatching$1 = BufferedChannel$onReceiveCatching$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveCatching$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        BufferedChannel$onReceiveCatching$2 bufferedChannel$onReceiveCatching$2 = BufferedChannel$onReceiveCatching$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveCatching$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause1Impl(this, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveCatching$1, 3), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveCatching$2, 3), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    public final long getReceiversCounter$kotlinx_coroutines_core() {
        return receivers$FU.get(this);
    }

    public final Throwable getSendException() {
        Throwable closeCause = getCloseCause();
        if (closeCause == null) {
            return new ClosedSendChannelException("Channel was closed");
        }
        return closeCause;
    }

    public final long getSendersCounter$kotlinx_coroutines_core() {
        return sendersAndCloseStatus$FU.get(this) & 1152921504606846975L;
    }

    public final boolean hasElements$kotlinx_coroutines_core() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = receiveSegment$FU;
            ChannelSegment<E> channelSegment = (ChannelSegment) atomicReferenceFieldUpdater.get(this);
            long receiversCounter$kotlinx_coroutines_core = getReceiversCounter$kotlinx_coroutines_core();
            if (getSendersCounter$kotlinx_coroutines_core() <= receiversCounter$kotlinx_coroutines_core) {
                return false;
            }
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j2 = receiversCounter$kotlinx_coroutines_core / i;
            if (channelSegment.id != j2 && (channelSegment = findSegmentReceive(j2, channelSegment)) == null) {
                if (((ChannelSegment) atomicReferenceFieldUpdater.get(this)).id < j2) {
                    return false;
                }
            } else {
                channelSegment.cleanPrev();
                if (isCellNonEmpty(channelSegment, (int) (receiversCounter$kotlinx_coroutines_core % i), receiversCounter$kotlinx_coroutines_core)) {
                    return true;
                }
                receivers$FU.compareAndSet(this, receiversCounter$kotlinx_coroutines_core, receiversCounter$kotlinx_coroutines_core + 1);
            }
        }
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(Function1<? super Throwable, Unit> function1) {
        Symbol symbol;
        Symbol symbol2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Symbol symbol3;
        Symbol symbol4;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = closeHandler$FU;
        if (n3.y(atomicReferenceFieldUpdater2, this, null, function1)) {
            return;
        }
        do {
            Object obj = atomicReferenceFieldUpdater2.get(this);
            symbol = BufferedChannelKt.CLOSE_HANDLER_CLOSED;
            if (obj != symbol) {
                symbol2 = BufferedChannelKt.CLOSE_HANDLER_INVOKED;
                if (obj == symbol2) {
                    throw new IllegalStateException("Another handler was already registered and successfully invoked");
                }
                throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
            }
            atomicReferenceFieldUpdater = closeHandler$FU;
            symbol3 = BufferedChannelKt.CLOSE_HANDLER_CLOSED;
            symbol4 = BufferedChannelKt.CLOSE_HANDLER_INVOKED;
        } while (!n3.y(atomicReferenceFieldUpdater, this, symbol3, symbol4));
        function1.invoke(getCloseCause());
    }

    public boolean isClosedForReceive() {
        return isClosedForReceive0(sendersAndCloseStatus$FU.get(this));
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return isClosedForSend0(sendersAndCloseStatus$FU.get(this));
    }

    public boolean isConflatedDropOldest() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public ChannelIterator<E> iterator() {
        return new BufferedChannelIterator();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean offer(E e2) {
        return Channel.DefaultImpls.offer(this, e2);
    }

    public void onClosedIdempotent() {
    }

    public void onReceiveDequeued() {
    }

    public void onReceiveEnqueued() {
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: receiveCatching-JP2dKIU  reason: not valid java name */
    public Object mo83receiveCatchingJP2dKIU(Continuation<? super ChannelResult<? extends E>> continuation) {
        return m81receiveCatchingJP2dKIU$suspendImpl(this, continuation);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object send(E e2, Continuation<? super Unit> continuation) {
        return send$suspendImpl(this, e2, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:91:0x01dd, code lost:
        r3 = (kotlinx.coroutines.channels.ChannelSegment) r3.getNext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01e4, code lost:
        if (r3 != null) goto L106;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01dd A[EDGE_INSN: B:109:0x01dd->B:91:0x01dd ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 527
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.toString():java.lang.String");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: tryReceive-PtdJZtk  reason: not valid java name */
    public Object mo84tryReceivePtdJZtk() {
        Symbol symbol;
        ChannelSegment channelSegment;
        Symbol symbol2;
        Waiter waiter;
        Symbol symbol3;
        Symbol symbol4;
        long j2 = receivers$FU.get(this);
        long j4 = sendersAndCloseStatus$FU.get(this);
        if (isClosedForReceive0(j4)) {
            return ChannelResult.Companion.m96closedJP2dKIU(getCloseCause());
        }
        if (j2 < (j4 & 1152921504606846975L)) {
            symbol = BufferedChannelKt.INTERRUPTED_RCV;
            ChannelSegment channelSegment2 = (ChannelSegment) receiveSegment$FU.get(this);
            while (!isClosedForReceive()) {
                long andIncrement = receivers$FU.getAndIncrement(this);
                int i = BufferedChannelKt.SEGMENT_SIZE;
                long j6 = andIncrement / i;
                int i5 = (int) (andIncrement % i);
                if (channelSegment2.id != j6) {
                    ChannelSegment findSegmentReceive = findSegmentReceive(j6, channelSegment2);
                    if (findSegmentReceive == null) {
                        continue;
                    } else {
                        channelSegment = findSegmentReceive;
                    }
                } else {
                    channelSegment = channelSegment2;
                }
                Object updateCellReceive = updateCellReceive(channelSegment, i5, andIncrement, symbol);
                symbol2 = BufferedChannelKt.SUSPEND;
                if (updateCellReceive != symbol2) {
                    symbol3 = BufferedChannelKt.FAILED;
                    if (updateCellReceive != symbol3) {
                        symbol4 = BufferedChannelKt.SUSPEND_NO_WAITER;
                        if (updateCellReceive != symbol4) {
                            channelSegment.cleanPrev();
                            return ChannelResult.Companion.m98successJP2dKIU(updateCellReceive);
                        }
                        throw new IllegalStateException("unexpected");
                    }
                    if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                    channelSegment2 = channelSegment;
                } else {
                    if (symbol instanceof Waiter) {
                        waiter = (Waiter) symbol;
                    } else {
                        waiter = null;
                    }
                    if (waiter != null) {
                        prepareReceiverForSuspension(waiter, channelSegment, i5);
                    }
                    waitExpandBufferCompletion$kotlinx_coroutines_core(andIncrement);
                    channelSegment.onSlotCleaned();
                    return ChannelResult.Companion.m97failurePtdJZtk();
                }
            }
            return ChannelResult.Companion.m96closedJP2dKIU(getCloseCause());
        }
        return ChannelResult.Companion.m97failurePtdJZtk();
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
        return kotlinx.coroutines.channels.ChannelResult.Companion.m98successJP2dKIU(kotlin.Unit.INSTANCE);
     */
    @Override // kotlinx.coroutines.channels.SendChannel
    /* renamed from: trySend-JP2dKIU  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo85trySendJP2dKIU(E r15) {
        /*
            r14 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = kotlinx.coroutines.channels.BufferedChannel.sendersAndCloseStatus$FU
            long r0 = r0.get(r14)
            boolean r0 = r14.shouldSendSuspend(r0)
            if (r0 == 0) goto L13
            kotlinx.coroutines.channels.ChannelResult$Companion r15 = kotlinx.coroutines.channels.ChannelResult.Companion
            java.lang.Object r15 = r15.m97failurePtdJZtk()
            return r15
        L13:
            kotlinx.coroutines.internal.Symbol r8 = kotlinx.coroutines.channels.BufferedChannelKt.access$getINTERRUPTED_SEND$p()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = access$getSendSegment$FU$p()
            java.lang.Object r0 = r0.get(r14)
            kotlinx.coroutines.channels.ChannelSegment r0 = (kotlinx.coroutines.channels.ChannelSegment) r0
        L21:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = access$getSendersAndCloseStatus$FU$p()
            long r1 = r1.getAndIncrement(r14)
            r3 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r9 = r1 & r3
            boolean r11 = access$isClosedForSend0(r14, r1)
            int r1 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r2 = (long) r1
            long r2 = r9 / r2
            long r4 = (long) r1
            long r4 = r9 % r4
            int r12 = (int) r4
            long r4 = r0.id
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 == 0) goto L59
            kotlinx.coroutines.channels.ChannelSegment r1 = access$findSegmentSend(r14, r2, r0)
            if (r1 != 0) goto L57
            if (r11 == 0) goto L21
        L4b:
            kotlinx.coroutines.channels.ChannelResult$Companion r15 = kotlinx.coroutines.channels.ChannelResult.Companion
            java.lang.Throwable r0 = r14.getSendException()
            java.lang.Object r15 = r15.m96closedJP2dKIU(r0)
            goto Lba
        L57:
            r13 = r1
            goto L5a
        L59:
            r13 = r0
        L5a:
            r0 = r14
            r1 = r13
            r2 = r12
            r3 = r15
            r4 = r9
            r6 = r8
            r7 = r11
            int r0 = access$updateCellSend(r0, r1, r2, r3, r4, r6, r7)
            if (r0 == 0) goto Lb6
            r1 = 1
            if (r0 == r1) goto Lad
            r1 = 2
            if (r0 == r1) goto L90
            r1 = 3
            if (r0 == r1) goto L88
            r1 = 4
            if (r0 == r1) goto L7c
            r1 = 5
            if (r0 == r1) goto L77
            goto L7a
        L77:
            r13.cleanPrev()
        L7a:
            r0 = r13
            goto L21
        L7c:
            long r0 = r14.getReceiversCounter$kotlinx_coroutines_core()
            int r15 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r15 >= 0) goto L4b
            r13.cleanPrev()
            goto L4b
        L88:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "unexpected"
            r15.<init>(r0)
            throw r15
        L90:
            if (r11 == 0) goto L96
            r13.onSlotCleaned()
            goto L4b
        L96:
            boolean r15 = r8 instanceof kotlinx.coroutines.Waiter
            if (r15 == 0) goto L9d
            kotlinx.coroutines.Waiter r8 = (kotlinx.coroutines.Waiter) r8
            goto L9e
        L9d:
            r8 = 0
        L9e:
            if (r8 == 0) goto La3
            access$prepareSenderForSuspension(r14, r8, r13, r12)
        La3:
            r13.onSlotCleaned()
            kotlinx.coroutines.channels.ChannelResult$Companion r15 = kotlinx.coroutines.channels.ChannelResult.Companion
            java.lang.Object r15 = r15.m97failurePtdJZtk()
            goto Lba
        Lad:
            kotlinx.coroutines.channels.ChannelResult$Companion r15 = kotlinx.coroutines.channels.ChannelResult.Companion
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            java.lang.Object r15 = r15.m98successJP2dKIU(r0)
            goto Lba
        Lb6:
            r13.cleanPrev()
            goto Lad
        Lba:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.mo85trySendJP2dKIU(java.lang.Object):java.lang.Object");
    }

    public final void waitExpandBufferCompletion$kotlinx_coroutines_core(long j2) {
        int i;
        long j4;
        long constructEBCompletedAndPauseFlag;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        boolean z2;
        long constructEBCompletedAndPauseFlag2;
        long j6;
        long constructEBCompletedAndPauseFlag3;
        if (isRendezvousOrUnlimited()) {
            return;
        }
        do {
        } while (getBufferEndCounter() <= j2);
        i = BufferedChannelKt.EXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS;
        for (int i5 = 0; i5 < i; i5++) {
            long bufferEndCounter = getBufferEndCounter();
            if (bufferEndCounter == (completedExpandBuffersAndPauseFlag$FU.get(this) & 4611686018427387903L) && bufferEndCounter == getBufferEndCounter()) {
                return;
            }
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater2 = completedExpandBuffersAndPauseFlag$FU;
        do {
            j4 = atomicLongFieldUpdater2.get(this);
            constructEBCompletedAndPauseFlag = BufferedChannelKt.constructEBCompletedAndPauseFlag(j4 & 4611686018427387903L, true);
        } while (!atomicLongFieldUpdater2.compareAndSet(this, j4, constructEBCompletedAndPauseFlag));
        while (true) {
            long bufferEndCounter2 = getBufferEndCounter();
            atomicLongFieldUpdater = completedExpandBuffersAndPauseFlag$FU;
            long j7 = atomicLongFieldUpdater.get(this);
            long j8 = j7 & 4611686018427387903L;
            if ((4611686018427387904L & j7) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (bufferEndCounter2 == j8 && bufferEndCounter2 == getBufferEndCounter()) {
                break;
            } else if (!z2) {
                constructEBCompletedAndPauseFlag2 = BufferedChannelKt.constructEBCompletedAndPauseFlag(j8, true);
                atomicLongFieldUpdater.compareAndSet(this, j7, constructEBCompletedAndPauseFlag2);
            }
        }
        do {
            j6 = atomicLongFieldUpdater.get(this);
            constructEBCompletedAndPauseFlag3 = BufferedChannelKt.constructEBCompletedAndPauseFlag(j6 & 4611686018427387903L, false);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j6, constructEBCompletedAndPauseFlag3));
    }
}
