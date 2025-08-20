package kotlin.time;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public interface ComparableTimeMark extends TimeMark, Comparable<ComparableTimeMark> {

    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static int compareTo(ComparableTimeMark comparableTimeMark, ComparableTimeMark other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return Duration.m40compareToLRDsOJo(comparableTimeMark.mo37minusUwyO8pc(other), Duration.Companion.m66getZEROUwyO8pc());
        }
    }

    /* renamed from: minus-UwyO8pc  reason: not valid java name */
    long mo37minusUwyO8pc(ComparableTimeMark comparableTimeMark);
}
