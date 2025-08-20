package androidx.compose.ui.unit;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.bouncycastle.asn1.cmc.BodyPartID;
/* compiled from: IntOffset.kt */
/* loaded from: classes.dex */
public final class IntOffset {
    public static final Companion Companion = new Companion(null);
    private static final long Zero = IntOffsetKt.IntOffset(0, 0);
    private final long packedValue;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ IntOffset m1929boximpl(long j) {
        return new IntOffset(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m1932constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1935equalsimpl(long j, Object obj) {
        return (obj instanceof IntOffset) && j == ((IntOffset) obj).m1941unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1936equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getX-impl  reason: not valid java name */
    public static final int m1937getXimpl(long j) {
        return (int) (j >> 32);
    }

    /* renamed from: getY-impl  reason: not valid java name */
    public static final int m1938getYimpl(long j) {
        return (int) (j & BodyPartID.bodyIdMax);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1939hashCodeimpl(long j) {
        return FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(j);
    }

    public boolean equals(Object obj) {
        return m1935equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m1939hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m1941unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ IntOffset(long j) {
        this.packedValue = j;
    }

    /* renamed from: component1-impl  reason: not valid java name */
    public static final int m1930component1impl(long j) {
        return m1937getXimpl(j);
    }

    /* renamed from: component2-impl  reason: not valid java name */
    public static final int m1931component2impl(long j) {
        return m1938getYimpl(j);
    }

    /* renamed from: copy-iSbpLlY  reason: not valid java name */
    public static final long m1933copyiSbpLlY(long j, int i, int i2) {
        return IntOffsetKt.IntOffset(i, i2);
    }

    /* renamed from: copy-iSbpLlY$default  reason: not valid java name */
    public static /* synthetic */ long m1934copyiSbpLlY$default(long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = m1937getXimpl(j);
        }
        if ((i3 & 2) != 0) {
            i2 = m1938getYimpl(j);
        }
        return m1933copyiSbpLlY(j, i, i2);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1940toStringimpl(long j) {
        return CoreConstants.LEFT_PARENTHESIS_CHAR + m1937getXimpl(j) + ", " + m1938getYimpl(j) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public String toString() {
        return m1940toStringimpl(this.packedValue);
    }

    /* compiled from: IntOffset.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getZero-nOcc-ac  reason: not valid java name */
        public final long m1942getZeronOccac() {
            return IntOffset.Zero;
        }
    }
}
