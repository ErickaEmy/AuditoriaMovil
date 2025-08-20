package androidx.compose.ui.text;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.bouncycastle.asn1.cmc.BodyPartID;
/* compiled from: TextRange.kt */
/* loaded from: classes.dex */
public final class TextRange {
    public static final Companion Companion = new Companion(null);
    private static final long Zero = TextRangeKt.TextRange(0);
    private final long packedValue;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ TextRange m1573boximpl(long j) {
        return new TextRange(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m1574constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1577equalsimpl(long j, Object obj) {
        return (obj instanceof TextRange) && j == ((TextRange) obj).m1589unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1578equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getEnd-impl  reason: not valid java name */
    public static final int m1580getEndimpl(long j) {
        return (int) (j & BodyPartID.bodyIdMax);
    }

    /* renamed from: getStart-impl  reason: not valid java name */
    public static final int m1585getStartimpl(long j) {
        return (int) (j >> 32);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1586hashCodeimpl(long j) {
        return FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(j);
    }

    public boolean equals(Object obj) {
        return m1577equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m1586hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m1589unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ TextRange(long j) {
        this.packedValue = j;
    }

    /* renamed from: getMin-impl  reason: not valid java name */
    public static final int m1583getMinimpl(long j) {
        return m1585getStartimpl(j) > m1580getEndimpl(j) ? m1580getEndimpl(j) : m1585getStartimpl(j);
    }

    /* renamed from: getMax-impl  reason: not valid java name */
    public static final int m1582getMaximpl(long j) {
        return m1585getStartimpl(j) > m1580getEndimpl(j) ? m1585getStartimpl(j) : m1580getEndimpl(j);
    }

    /* renamed from: getCollapsed-impl  reason: not valid java name */
    public static final boolean m1579getCollapsedimpl(long j) {
        return m1585getStartimpl(j) == m1580getEndimpl(j);
    }

    /* renamed from: getReversed-impl  reason: not valid java name */
    public static final boolean m1584getReversedimpl(long j) {
        return m1585getStartimpl(j) > m1580getEndimpl(j);
    }

    /* renamed from: getLength-impl  reason: not valid java name */
    public static final int m1581getLengthimpl(long j) {
        return m1582getMaximpl(j) - m1583getMinimpl(j);
    }

    /* renamed from: intersects-5zc-tL8  reason: not valid java name */
    public static final boolean m1587intersects5zctL8(long j, long j2) {
        return m1583getMinimpl(j) < m1582getMaximpl(j2) && m1583getMinimpl(j2) < m1582getMaximpl(j);
    }

    /* renamed from: contains-5zc-tL8  reason: not valid java name */
    public static final boolean m1575contains5zctL8(long j, long j2) {
        return m1583getMinimpl(j) <= m1583getMinimpl(j2) && m1582getMaximpl(j2) <= m1582getMaximpl(j);
    }

    /* renamed from: contains-impl  reason: not valid java name */
    public static final boolean m1576containsimpl(long j, int i) {
        return i < m1582getMaximpl(j) && m1583getMinimpl(j) <= i;
    }

    public String toString() {
        return m1588toStringimpl(this.packedValue);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1588toStringimpl(long j) {
        return "TextRange(" + m1585getStartimpl(j) + ", " + m1580getEndimpl(j) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    /* compiled from: TextRange.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getZero-d9O1mEE  reason: not valid java name */
        public final long m1590getZerod9O1mEE() {
            return TextRange.Zero;
        }
    }
}
