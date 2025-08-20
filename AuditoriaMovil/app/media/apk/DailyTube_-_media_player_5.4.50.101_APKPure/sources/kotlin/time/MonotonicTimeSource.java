package kotlin.time;

import kotlin.time.TimeSource;
/* loaded from: classes.dex */
public final class MonotonicTimeSource implements TimeSource {
    public static final MonotonicTimeSource INSTANCE = new MonotonicTimeSource();
    private static final long zero = System.nanoTime();

    private MonotonicTimeSource() {
    }

    private final long read() {
        return System.nanoTime() - zero;
    }

    /* renamed from: differenceBetween-fRLX17w  reason: not valid java name */
    public final long m67differenceBetweenfRLX17w(long j2, long j4) {
        return LongSaturatedMathKt.saturatingOriginsDiff(j2, j4, DurationUnit.NANOSECONDS);
    }

    @Override // kotlin.time.TimeSource
    public /* bridge */ /* synthetic */ TimeMark markNow() {
        return TimeSource.Monotonic.ValueTimeMark.m70boximpl(m68markNowz9LOYto());
    }

    /* renamed from: markNow-z9LOYto  reason: not valid java name */
    public long m68markNowz9LOYto() {
        return TimeSource.Monotonic.ValueTimeMark.m71constructorimpl(read());
    }

    public String toString() {
        return "TimeSource(System.nanoTime())";
    }
}
