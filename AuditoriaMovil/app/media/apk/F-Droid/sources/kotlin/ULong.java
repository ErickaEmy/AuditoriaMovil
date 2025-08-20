package kotlin;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: ULong.kt */
/* loaded from: classes.dex */
public final class ULong implements Comparable {
    public static final Companion Companion = new Companion(null);
    private final long data;

    /* compiled from: ULong.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ULong m2134boximpl(long j) {
        return new ULong(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m2135constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m2136equalsimpl(long j, Object obj) {
        return (obj instanceof ULong) && j == ((ULong) obj).m2140unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m2137equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m2138hashCodeimpl(long j) {
        return FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(j);
    }

    public boolean equals(Object obj) {
        return m2136equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m2138hashCodeimpl(this.data);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m2140unboximpl() {
        return this.data;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return UnsignedKt.ulongCompare(m2140unboximpl(), ((ULong) obj).m2140unboximpl());
    }

    private /* synthetic */ ULong(long j) {
        this.data = j;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m2139toStringimpl(long j) {
        return UnsignedKt.ulongToString(j);
    }

    public String toString() {
        return m2139toStringimpl(this.data);
    }
}
