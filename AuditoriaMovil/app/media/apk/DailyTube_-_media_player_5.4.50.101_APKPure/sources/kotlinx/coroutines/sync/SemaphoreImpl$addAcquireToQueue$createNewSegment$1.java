package kotlinx.coroutines.sync;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* loaded from: classes.dex */
public /* synthetic */ class SemaphoreImpl$addAcquireToQueue$createNewSegment$1 extends FunctionReferenceImpl implements Function2<Long, SemaphoreSegment, SemaphoreSegment> {
    public static final SemaphoreImpl$addAcquireToQueue$createNewSegment$1 INSTANCE = new SemaphoreImpl$addAcquireToQueue$createNewSegment$1();

    public SemaphoreImpl$addAcquireToQueue$createNewSegment$1() {
        super(2, SemaphoreKt.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ SemaphoreSegment invoke(Long l2, SemaphoreSegment semaphoreSegment) {
        return invoke(l2.longValue(), semaphoreSegment);
    }

    public final SemaphoreSegment invoke(long j2, SemaphoreSegment semaphoreSegment) {
        SemaphoreSegment createSegment;
        createSegment = SemaphoreKt.createSegment(j2, semaphoreSegment);
        return createSegment;
    }
}
