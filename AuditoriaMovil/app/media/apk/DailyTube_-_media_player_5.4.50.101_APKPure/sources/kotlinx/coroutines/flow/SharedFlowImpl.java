package kotlinx.coroutines.flow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.internal.Symbol;
/* loaded from: classes.dex */
public class SharedFlowImpl<T> extends AbstractSharedFlow<SharedFlowSlot> implements MutableSharedFlow<T>, Flow, FusibleFlow<T> {
    private Object[] buffer;
    private final int bufferCapacity;
    private int bufferSize;
    private long minCollectorIndex;
    private final BufferOverflow onBufferOverflow;
    private int queueSize;
    private final int replay;
    private long replayIndex;

    /* loaded from: classes.dex */
    public static final class Emitter implements DisposableHandle {
        public final Continuation<Unit> cont;
        public final SharedFlowImpl<?> flow;
        public long index;
        public final Object value;

        /* JADX WARN: Multi-variable type inference failed */
        public Emitter(SharedFlowImpl<?> sharedFlowImpl, long j2, Object obj, Continuation<? super Unit> continuation) {
            this.flow = sharedFlowImpl;
            this.index = j2;
            this.value = obj;
            this.cont = continuation;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            this.flow.cancelEmitter(this);
        }
    }

    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BufferOverflow.values().length];
            try {
                iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SharedFlowImpl(int i, int i5, BufferOverflow bufferOverflow) {
        this.replay = i;
        this.bufferCapacity = i5;
        this.onBufferOverflow = bufferOverflow;
    }

    private final Object awaitValue(SharedFlowSlot sharedFlowSlot, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        synchronized (this) {
            try {
                if (tryPeekLocked(sharedFlowSlot) < 0) {
                    sharedFlowSlot.cont = cancellableContinuationImpl;
                } else {
                    Result.Companion companion = Result.Companion;
                    cancellableContinuationImpl.resumeWith(Result.m28constructorimpl(Unit.INSTANCE));
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
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
    public final void cancelEmitter(Emitter emitter) {
        synchronized (this) {
            if (emitter.index < getHead()) {
                return;
            }
            Object[] objArr = this.buffer;
            Intrinsics.checkNotNull(objArr);
            if (SharedFlowKt.access$getBufferAt(objArr, emitter.index) != emitter) {
                return;
            }
            SharedFlowKt.access$setBufferAt(objArr, emitter.index, SharedFlowKt.NO_VALUE);
            cleanupTailLocked();
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void cleanupTailLocked() {
        if (this.bufferCapacity == 0 && this.queueSize <= 1) {
            return;
        }
        Object[] objArr = this.buffer;
        Intrinsics.checkNotNull(objArr);
        while (this.queueSize > 0 && SharedFlowKt.access$getBufferAt(objArr, (getHead() + getTotalSize()) - 1) == SharedFlowKt.NO_VALUE) {
            this.queueSize--;
            SharedFlowKt.access$setBufferAt(objArr, getHead() + getTotalSize(), null);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|(3:(6:(1:(1:11)(2:41|42))(1:43)|12|13|14|15|(3:16|(3:28|29|(2:31|32)(1:33))(4:18|(1:20)|21|(2:23|24)(1:26))|27))(4:44|45|46|47)|37|38)(5:53|54|55|(2:57|(1:59))|61)|48|49|15|(3:16|(0)(0)|27)))|64|6|(0)(0)|48|49|15|(3:16|(0)(0)|27)) */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00c2, code lost:
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c3, code lost:
        r5 = r8;
        r8 = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ <T> java.lang.Object collect$suspendImpl(kotlinx.coroutines.flow.SharedFlowImpl<T> r8, kotlinx.coroutines.flow.FlowCollector<? super T> r9, kotlin.coroutines.Continuation<?> r10) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.collect$suspendImpl(kotlinx.coroutines.flow.SharedFlowImpl, kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void correctCollectorIndexesOnDropOldest(long j2) {
        AbstractSharedFlowSlot[] access$getSlots;
        if (AbstractSharedFlow.access$getNCollectors(this) != 0 && (access$getSlots = AbstractSharedFlow.access$getSlots(this)) != null) {
            for (AbstractSharedFlowSlot abstractSharedFlowSlot : access$getSlots) {
                if (abstractSharedFlowSlot != null) {
                    SharedFlowSlot sharedFlowSlot = (SharedFlowSlot) abstractSharedFlowSlot;
                    long j4 = sharedFlowSlot.index;
                    if (j4 >= 0 && j4 < j2) {
                        sharedFlowSlot.index = j2;
                    }
                }
            }
        }
        this.minCollectorIndex = j2;
    }

    private final void dropOldestLocked() {
        Object[] objArr = this.buffer;
        Intrinsics.checkNotNull(objArr);
        SharedFlowKt.access$setBufferAt(objArr, getHead(), null);
        this.bufferSize--;
        long head = getHead() + 1;
        if (this.replayIndex < head) {
            this.replayIndex = head;
        }
        if (this.minCollectorIndex < head) {
            correctCollectorIndexesOnDropOldest(head);
        }
        if (DebugKt.getASSERTIONS_ENABLED() && getHead() != head) {
            throw new AssertionError();
        }
    }

    public static /* synthetic */ <T> Object emit$suspendImpl(SharedFlowImpl<T> sharedFlowImpl, T t2, Continuation<? super Unit> continuation) {
        if (sharedFlowImpl.tryEmit(t2)) {
            return Unit.INSTANCE;
        }
        Object emitSuspend = sharedFlowImpl.emitSuspend(t2, continuation);
        if (emitSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return emitSuspend;
        }
        return Unit.INSTANCE;
    }

    private final Object emitSuspend(T t2, Continuation<? super Unit> continuation) {
        Continuation<Unit>[] continuationArr;
        Emitter emitter;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        Continuation<Unit>[] continuationArr2 = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            try {
                if (tryEmitLocked(t2)) {
                    Result.Companion companion = Result.Companion;
                    cancellableContinuationImpl.resumeWith(Result.m28constructorimpl(Unit.INSTANCE));
                    continuationArr = findSlotsToResumeLocked(continuationArr2);
                    emitter = null;
                } else {
                    Emitter emitter2 = new Emitter(this, getTotalSize() + getHead(), t2, cancellableContinuationImpl);
                    enqueueLocked(emitter2);
                    this.queueSize++;
                    if (this.bufferCapacity == 0) {
                        continuationArr2 = findSlotsToResumeLocked(continuationArr2);
                    }
                    continuationArr = continuationArr2;
                    emitter = emitter2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (emitter != null) {
            CancellableContinuationKt.disposeOnCancellation(cancellableContinuationImpl, emitter);
        }
        for (Continuation<Unit> continuation2 : continuationArr) {
            if (continuation2 != null) {
                Result.Companion companion2 = Result.Companion;
                continuation2.resumeWith(Result.m28constructorimpl(Unit.INSTANCE));
            }
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
    public final void enqueueLocked(Object obj) {
        int totalSize = getTotalSize();
        Object[] objArr = this.buffer;
        if (objArr == null) {
            objArr = growBuffer(null, 0, 2);
        } else if (totalSize >= objArr.length) {
            objArr = growBuffer(objArr, totalSize, objArr.length * 2);
        }
        SharedFlowKt.access$setBufferAt(objArr, getHead() + totalSize, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.lang.Object[], java.lang.Object] */
    public final Continuation<Unit>[] findSlotsToResumeLocked(Continuation<Unit>[] continuationArr) {
        AbstractSharedFlowSlot[] access$getSlots;
        SharedFlowSlot sharedFlowSlot;
        Continuation<? super Unit> continuation;
        int length = continuationArr.length;
        if (AbstractSharedFlow.access$getNCollectors(this) != 0 && (access$getSlots = AbstractSharedFlow.access$getSlots(this)) != null) {
            int length2 = access$getSlots.length;
            int i = 0;
            continuationArr = continuationArr;
            while (i < length2) {
                AbstractSharedFlowSlot abstractSharedFlowSlot = access$getSlots[i];
                if (abstractSharedFlowSlot != null && (continuation = (sharedFlowSlot = (SharedFlowSlot) abstractSharedFlowSlot).cont) != null && tryPeekLocked(sharedFlowSlot) >= 0) {
                    int length3 = continuationArr.length;
                    continuationArr = continuationArr;
                    if (length >= length3) {
                        ?? copyOf = Arrays.copyOf(continuationArr, Math.max(2, continuationArr.length * 2));
                        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                        continuationArr = copyOf;
                    }
                    continuationArr[length] = continuation;
                    sharedFlowSlot.cont = null;
                    length++;
                }
                i++;
                continuationArr = continuationArr;
            }
        }
        return continuationArr;
    }

    private final long getBufferEndIndex() {
        return getHead() + this.bufferSize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getHead() {
        return Math.min(this.minCollectorIndex, this.replayIndex);
    }

    private final Object getPeekedValueLockedAt(long j2) {
        Object[] objArr = this.buffer;
        Intrinsics.checkNotNull(objArr);
        Object access$getBufferAt = SharedFlowKt.access$getBufferAt(objArr, j2);
        if (access$getBufferAt instanceof Emitter) {
            return ((Emitter) access$getBufferAt).value;
        }
        return access$getBufferAt;
    }

    private final long getQueueEndIndex() {
        return getHead() + this.bufferSize + this.queueSize;
    }

    private final int getReplaySize() {
        return (int) ((getHead() + this.bufferSize) - this.replayIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getTotalSize() {
        return this.bufferSize + this.queueSize;
    }

    private final Object[] growBuffer(Object[] objArr, int i, int i5) {
        if (i5 > 0) {
            Object[] objArr2 = new Object[i5];
            this.buffer = objArr2;
            if (objArr == null) {
                return objArr2;
            }
            long head = getHead();
            for (int i6 = 0; i6 < i; i6++) {
                long j2 = i6 + head;
                SharedFlowKt.access$setBufferAt(objArr2, j2, SharedFlowKt.access$getBufferAt(objArr, j2));
            }
            return objArr2;
        }
        throw new IllegalStateException("Buffer size overflow");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean tryEmitLocked(T t2) {
        if (getNCollectors() == 0) {
            return tryEmitNoCollectorsLocked(t2);
        }
        if (this.bufferSize >= this.bufferCapacity && this.minCollectorIndex <= this.replayIndex) {
            int i = WhenMappings.$EnumSwitchMapping$0[this.onBufferOverflow.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return true;
                }
            } else {
                return false;
            }
        }
        enqueueLocked(t2);
        int i5 = this.bufferSize + 1;
        this.bufferSize = i5;
        if (i5 > this.bufferCapacity) {
            dropOldestLocked();
        }
        if (getReplaySize() > this.replay) {
            updateBufferLocked(this.replayIndex + 1, this.minCollectorIndex, getBufferEndIndex(), getQueueEndIndex());
        }
        return true;
    }

    private final boolean tryEmitNoCollectorsLocked(T t2) {
        if (DebugKt.getASSERTIONS_ENABLED() && getNCollectors() != 0) {
            throw new AssertionError();
        }
        if (this.replay == 0) {
            return true;
        }
        enqueueLocked(t2);
        int i = this.bufferSize + 1;
        this.bufferSize = i;
        if (i > this.replay) {
            dropOldestLocked();
        }
        this.minCollectorIndex = getHead() + this.bufferSize;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long tryPeekLocked(SharedFlowSlot sharedFlowSlot) {
        long j2 = sharedFlowSlot.index;
        if (j2 < getBufferEndIndex()) {
            return j2;
        }
        if (this.bufferCapacity > 0 || j2 > getHead() || this.queueSize == 0) {
            return -1L;
        }
        return j2;
    }

    private final Object tryTakeValue(SharedFlowSlot sharedFlowSlot) {
        Object obj;
        Continuation<Unit>[] continuationArr = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            try {
                long tryPeekLocked = tryPeekLocked(sharedFlowSlot);
                if (tryPeekLocked < 0) {
                    obj = SharedFlowKt.NO_VALUE;
                } else {
                    long j2 = sharedFlowSlot.index;
                    Object peekedValueLockedAt = getPeekedValueLockedAt(tryPeekLocked);
                    sharedFlowSlot.index = tryPeekLocked + 1;
                    continuationArr = updateCollectorIndexLocked$kotlinx_coroutines_core(j2);
                    obj = peekedValueLockedAt;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        for (Continuation<Unit> continuation : continuationArr) {
            if (continuation != null) {
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m28constructorimpl(Unit.INSTANCE));
            }
        }
        return obj;
    }

    private final void updateBufferLocked(long j2, long j4, long j6, long j7) {
        long min = Math.min(j4, j2);
        if (DebugKt.getASSERTIONS_ENABLED() && min < getHead()) {
            throw new AssertionError();
        }
        for (long head = getHead(); head < min; head++) {
            Object[] objArr = this.buffer;
            Intrinsics.checkNotNull(objArr);
            SharedFlowKt.access$setBufferAt(objArr, head, null);
        }
        this.replayIndex = j2;
        this.minCollectorIndex = j4;
        this.bufferSize = (int) (j6 - min);
        this.queueSize = (int) (j7 - j6);
        if (DebugKt.getASSERTIONS_ENABLED() && this.bufferSize < 0) {
            throw new AssertionError();
        }
        if (DebugKt.getASSERTIONS_ENABLED() && this.queueSize < 0) {
            throw new AssertionError();
        }
        if (DebugKt.getASSERTIONS_ENABLED() && this.replayIndex > getHead() + this.bufferSize) {
            throw new AssertionError();
        }
    }

    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<?> continuation) {
        return collect$suspendImpl(this, flowCollector, continuation);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow, kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t2, Continuation<? super Unit> continuation) {
        return emit$suspendImpl(this, t2, continuation);
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public Flow<T> fuse(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        return SharedFlowKt.fuseSharedFlow(this, coroutineContext, i, bufferOverflow);
    }

    public final T getLastReplayedLocked() {
        Object[] objArr = this.buffer;
        Intrinsics.checkNotNull(objArr);
        return (T) SharedFlowKt.access$getBufferAt(objArr, (this.replayIndex + getReplaySize()) - 1);
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    public List<T> getReplayCache() {
        synchronized (this) {
            int replaySize = getReplaySize();
            if (replaySize == 0) {
                return CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList(replaySize);
            Object[] objArr = this.buffer;
            Intrinsics.checkNotNull(objArr);
            for (int i = 0; i < replaySize; i++) {
                arrayList.add(SharedFlowKt.access$getBufferAt(objArr, this.replayIndex + i));
            }
            return arrayList;
        }
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public void resetReplayCache() {
        synchronized (this) {
            updateBufferLocked(getBufferEndIndex(), this.minCollectorIndex, getBufferEndIndex(), getQueueEndIndex());
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public boolean tryEmit(T t2) {
        int i;
        boolean z2;
        Continuation<Unit>[] continuationArr = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            if (tryEmitLocked(t2)) {
                continuationArr = findSlotsToResumeLocked(continuationArr);
                z2 = true;
            } else {
                z2 = false;
            }
        }
        for (Continuation<Unit> continuation : continuationArr) {
            if (continuation != null) {
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m28constructorimpl(Unit.INSTANCE));
            }
        }
        return z2;
    }

    public final Continuation<Unit>[] updateCollectorIndexLocked$kotlinx_coroutines_core(long j2) {
        int i;
        long j4;
        long j6;
        long j7;
        boolean z2;
        long j8;
        AbstractSharedFlowSlot[] access$getSlots;
        if (DebugKt.getASSERTIONS_ENABLED() && j2 < this.minCollectorIndex) {
            throw new AssertionError();
        }
        if (j2 > this.minCollectorIndex) {
            return AbstractSharedFlowKt.EMPTY_RESUMES;
        }
        long head = getHead();
        long j9 = this.bufferSize + head;
        if (this.bufferCapacity == 0 && this.queueSize > 0) {
            j9++;
        }
        if (AbstractSharedFlow.access$getNCollectors(this) != 0 && (access$getSlots = AbstractSharedFlow.access$getSlots(this)) != null) {
            for (AbstractSharedFlowSlot abstractSharedFlowSlot : access$getSlots) {
                if (abstractSharedFlowSlot != null) {
                    long j10 = ((SharedFlowSlot) abstractSharedFlowSlot).index;
                    if (j10 >= 0 && j10 < j9) {
                        j9 = j10;
                    }
                }
            }
        }
        if (DebugKt.getASSERTIONS_ENABLED() && j9 < this.minCollectorIndex) {
            throw new AssertionError();
        }
        if (j9 <= this.minCollectorIndex) {
            return AbstractSharedFlowKt.EMPTY_RESUMES;
        }
        long bufferEndIndex = getBufferEndIndex();
        if (getNCollectors() > 0) {
            i = Math.min(this.queueSize, this.bufferCapacity - ((int) (bufferEndIndex - j9)));
        } else {
            i = this.queueSize;
        }
        Continuation<Unit>[] continuationArr = AbstractSharedFlowKt.EMPTY_RESUMES;
        long j11 = this.queueSize + bufferEndIndex;
        if (i > 0) {
            continuationArr = new Continuation[i];
            Object[] objArr = this.buffer;
            Intrinsics.checkNotNull(objArr);
            long j12 = bufferEndIndex;
            int i5 = 0;
            while (true) {
                if (bufferEndIndex < j11) {
                    Object access$getBufferAt = SharedFlowKt.access$getBufferAt(objArr, bufferEndIndex);
                    j4 = j9;
                    Symbol symbol = SharedFlowKt.NO_VALUE;
                    if (access$getBufferAt != symbol) {
                        Intrinsics.checkNotNull(access$getBufferAt, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                        Emitter emitter = (Emitter) access$getBufferAt;
                        int i6 = i5 + 1;
                        j6 = j11;
                        continuationArr[i5] = emitter.cont;
                        SharedFlowKt.access$setBufferAt(objArr, bufferEndIndex, symbol);
                        SharedFlowKt.access$setBufferAt(objArr, j12, emitter.value);
                        j8 = 1;
                        j12++;
                        if (i6 >= i) {
                            break;
                        }
                        i5 = i6;
                    } else {
                        j6 = j11;
                        j8 = 1;
                    }
                    bufferEndIndex += j8;
                    j9 = j4;
                    j11 = j6;
                } else {
                    j4 = j9;
                    j6 = j11;
                    break;
                }
            }
            bufferEndIndex = j12;
        } else {
            j4 = j9;
            j6 = j11;
        }
        int i8 = (int) (bufferEndIndex - head);
        if (getNCollectors() == 0) {
            j7 = bufferEndIndex;
        } else {
            j7 = j4;
        }
        long max = Math.max(this.replayIndex, bufferEndIndex - Math.min(this.replay, i8));
        if (this.bufferCapacity == 0 && max < j6) {
            Object[] objArr2 = this.buffer;
            Intrinsics.checkNotNull(objArr2);
            if (Intrinsics.areEqual(SharedFlowKt.access$getBufferAt(objArr2, max), SharedFlowKt.NO_VALUE)) {
                bufferEndIndex++;
                max++;
            }
        }
        updateBufferLocked(max, j7, bufferEndIndex, j6);
        cleanupTailLocked();
        if (continuationArr.length == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            return findSlotsToResumeLocked(continuationArr);
        }
        return continuationArr;
    }

    public final long updateNewCollectorIndexLocked$kotlinx_coroutines_core() {
        long j2 = this.replayIndex;
        if (j2 < this.minCollectorIndex) {
            this.minCollectorIndex = j2;
        }
        return j2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public SharedFlowSlot createSlot() {
        return new SharedFlowSlot();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public SharedFlowSlot[] createSlotArray(int i) {
        return new SharedFlowSlot[i];
    }
}
