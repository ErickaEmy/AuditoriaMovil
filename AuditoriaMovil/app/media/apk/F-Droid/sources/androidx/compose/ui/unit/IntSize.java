package androidx.compose.ui.unit;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.bouncycastle.asn1.cmc.BodyPartID;
/* compiled from: IntSize.kt */
/* loaded from: classes.dex */
public final class IntSize {
    public static final Companion Companion = new Companion(null);
    private static final long Zero = m1947constructorimpl(0);
    private final long packedValue;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ IntSize m1946boximpl(long j) {
        return new IntSize(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m1947constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1948equalsimpl(long j, Object obj) {
        return (obj instanceof IntSize) && j == ((IntSize) obj).m1954unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1949equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getHeight-impl  reason: not valid java name */
    public static final int m1950getHeightimpl(long j) {
        return (int) (j & BodyPartID.bodyIdMax);
    }

    /* renamed from: getWidth-impl  reason: not valid java name */
    public static final int m1951getWidthimpl(long j) {
        return (int) (j >> 32);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1952hashCodeimpl(long j) {
        return FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(j);
    }

    public boolean equals(Object obj) {
        return m1948equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m1952hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m1954unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ IntSize(long j) {
        this.packedValue = j;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1953toStringimpl(long j) {
        return m1951getWidthimpl(j) + " x " + m1950getHeightimpl(j);
    }

    public String toString() {
        return m1953toStringimpl(this.packedValue);
    }

    /* compiled from: IntSize.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getZero-YbymL2g  reason: not valid java name */
        public final long m1955getZeroYbymL2g() {
            return IntSize.Zero;
        }
    }
}
