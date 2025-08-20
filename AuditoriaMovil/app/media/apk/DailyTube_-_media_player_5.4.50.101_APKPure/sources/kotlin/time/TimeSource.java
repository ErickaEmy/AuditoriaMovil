package kotlin.time;

import kotlin.jvm.internal.Intrinsics;
import kotlin.time.ComparableTimeMark;
import yc.gv;
/* loaded from: classes.dex */
public interface TimeSource {

    /* loaded from: classes.dex */
    public static final class Monotonic implements TimeSource {
        public static final Monotonic INSTANCE = new Monotonic();

        /* loaded from: classes.dex */
        public static final class ValueTimeMark implements ComparableTimeMark {
            private final long reading;

            private /* synthetic */ ValueTimeMark(long j2) {
                this.reading = j2;
            }

            /* renamed from: box-impl  reason: not valid java name */
            public static final /* synthetic */ ValueTimeMark m70boximpl(long j2) {
                return new ValueTimeMark(j2);
            }

            /* renamed from: constructor-impl  reason: not valid java name */
            public static long m71constructorimpl(long j2) {
                return j2;
            }

            /* renamed from: equals-impl  reason: not valid java name */
            public static boolean m72equalsimpl(long j2, Object obj) {
                return (obj instanceof ValueTimeMark) && j2 == ((ValueTimeMark) obj).m77unboximpl();
            }

            /* renamed from: hashCode-impl  reason: not valid java name */
            public static int m73hashCodeimpl(long j2) {
                return gv.y(j2);
            }

            /* renamed from: minus-6eNON_k  reason: not valid java name */
            public static final long m74minus6eNON_k(long j2, long j4) {
                return MonotonicTimeSource.INSTANCE.m67differenceBetweenfRLX17w(j2, j4);
            }

            /* renamed from: toString-impl  reason: not valid java name */
            public static String m76toStringimpl(long j2) {
                return "ValueTimeMark(reading=" + j2 + ')';
            }

            public boolean equals(Object obj) {
                return m72equalsimpl(this.reading, obj);
            }

            public int hashCode() {
                return m73hashCodeimpl(this.reading);
            }

            @Override // kotlin.time.ComparableTimeMark
            /* renamed from: minus-UwyO8pc */
            public long mo37minusUwyO8pc(ComparableTimeMark other) {
                Intrinsics.checkNotNullParameter(other, "other");
                return m75minusUwyO8pc(this.reading, other);
            }

            public String toString() {
                return m76toStringimpl(this.reading);
            }

            /* renamed from: unbox-impl  reason: not valid java name */
            public final /* synthetic */ long m77unboximpl() {
                return this.reading;
            }

            /* renamed from: minus-UwyO8pc  reason: not valid java name */
            public static long m75minusUwyO8pc(long j2, ComparableTimeMark other) {
                Intrinsics.checkNotNullParameter(other, "other");
                if (other instanceof ValueTimeMark) {
                    return m74minus6eNON_k(j2, ((ValueTimeMark) other).m77unboximpl());
                }
                throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + ((Object) m76toStringimpl(j2)) + " and " + other);
            }

            @Override // java.lang.Comparable
            public int compareTo(ComparableTimeMark comparableTimeMark) {
                return ComparableTimeMark.DefaultImpls.compareTo(this, comparableTimeMark);
            }
        }

        private Monotonic() {
        }

        @Override // kotlin.time.TimeSource
        public /* bridge */ /* synthetic */ TimeMark markNow() {
            return ValueTimeMark.m70boximpl(m69markNowz9LOYto());
        }

        /* renamed from: markNow-z9LOYto  reason: not valid java name */
        public long m69markNowz9LOYto() {
            return MonotonicTimeSource.INSTANCE.m68markNowz9LOYto();
        }

        public String toString() {
            return MonotonicTimeSource.INSTANCE.toString();
        }
    }

    TimeMark markNow();
}
