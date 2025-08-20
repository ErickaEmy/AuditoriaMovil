package androidx.compose.ui.geometry;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import org.bouncycastle.asn1.cmc.BodyPartID;
/* compiled from: Offset.kt */
/* loaded from: classes.dex */
public final class Offset {
    private final long packedValue;
    public static final Companion Companion = new Companion(null);
    private static final long Zero = OffsetKt.Offset(0.0f, 0.0f);
    private static final long Infinite = OffsetKt.Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
    private static final long Unspecified = OffsetKt.Offset(Float.NaN, Float.NaN);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Offset m698boximpl(long j) {
        return new Offset(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m701constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m705equalsimpl(long j, Object obj) {
        return (obj instanceof Offset) && j == ((Offset) obj).m718unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m706equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m711hashCodeimpl(long j) {
        return FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(j);
    }

    public boolean equals(Object obj) {
        return m705equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m711hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m718unboximpl() {
        return this.packedValue;
    }

    /* renamed from: getX-impl  reason: not valid java name */
    public static final float m709getXimpl(long j) {
        if (j != Unspecified) {
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            return Float.intBitsToFloat((int) (j >> 32));
        }
        throw new IllegalStateException("Offset is unspecified".toString());
    }

    /* renamed from: getY-impl  reason: not valid java name */
    public static final float m710getYimpl(long j) {
        if (j != Unspecified) {
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            return Float.intBitsToFloat((int) (j & BodyPartID.bodyIdMax));
        }
        throw new IllegalStateException("Offset is unspecified".toString());
    }

    private /* synthetic */ Offset(long j) {
        this.packedValue = j;
    }

    /* renamed from: component1-impl  reason: not valid java name */
    public static final float m699component1impl(long j) {
        return m709getXimpl(j);
    }

    /* renamed from: component2-impl  reason: not valid java name */
    public static final float m700component2impl(long j) {
        return m710getYimpl(j);
    }

    /* renamed from: copy-dBAh8RU  reason: not valid java name */
    public static final long m702copydBAh8RU(long j, float f, float f2) {
        return OffsetKt.Offset(f, f2);
    }

    /* renamed from: copy-dBAh8RU$default  reason: not valid java name */
    public static /* synthetic */ long m703copydBAh8RU$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m709getXimpl(j);
        }
        if ((i & 2) != 0) {
            f2 = m710getYimpl(j);
        }
        return m702copydBAh8RU(j, f, f2);
    }

    /* compiled from: Offset.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getZero-F1C5BW0  reason: not valid java name */
        public final long m721getZeroF1C5BW0() {
            return Offset.Zero;
        }

        /* renamed from: getInfinite-F1C5BW0  reason: not valid java name */
        public final long m719getInfiniteF1C5BW0() {
            return Offset.Infinite;
        }

        /* renamed from: getUnspecified-F1C5BW0  reason: not valid java name */
        public final long m720getUnspecifiedF1C5BW0() {
            return Offset.Unspecified;
        }
    }

    /* renamed from: isValid-impl  reason: not valid java name */
    public static final boolean m712isValidimpl(long j) {
        if (Float.isNaN(m709getXimpl(j)) || Float.isNaN(m710getYimpl(j))) {
            throw new IllegalStateException("Offset argument contained a NaN value.".toString());
        }
        return true;
    }

    /* renamed from: getDistance-impl  reason: not valid java name */
    public static final float m707getDistanceimpl(long j) {
        return (float) Math.sqrt((m709getXimpl(j) * m709getXimpl(j)) + (m710getYimpl(j) * m710getYimpl(j)));
    }

    /* renamed from: getDistanceSquared-impl  reason: not valid java name */
    public static final float m708getDistanceSquaredimpl(long j) {
        return (m709getXimpl(j) * m709getXimpl(j)) + (m710getYimpl(j) * m710getYimpl(j));
    }

    /* renamed from: unaryMinus-F1C5BW0  reason: not valid java name */
    public static final long m717unaryMinusF1C5BW0(long j) {
        return OffsetKt.Offset(-m709getXimpl(j), -m710getYimpl(j));
    }

    /* renamed from: minus-MK-Hz9U  reason: not valid java name */
    public static final long m713minusMKHz9U(long j, long j2) {
        return OffsetKt.Offset(m709getXimpl(j) - m709getXimpl(j2), m710getYimpl(j) - m710getYimpl(j2));
    }

    /* renamed from: plus-MK-Hz9U  reason: not valid java name */
    public static final long m714plusMKHz9U(long j, long j2) {
        return OffsetKt.Offset(m709getXimpl(j) + m709getXimpl(j2), m710getYimpl(j) + m710getYimpl(j2));
    }

    /* renamed from: times-tuRUvjQ  reason: not valid java name */
    public static final long m715timestuRUvjQ(long j, float f) {
        return OffsetKt.Offset(m709getXimpl(j) * f, m710getYimpl(j) * f);
    }

    /* renamed from: div-tuRUvjQ  reason: not valid java name */
    public static final long m704divtuRUvjQ(long j, float f) {
        return OffsetKt.Offset(m709getXimpl(j) / f, m710getYimpl(j) / f);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m716toStringimpl(long j) {
        if (OffsetKt.m723isSpecifiedk4lQ0M(j)) {
            return "Offset(" + GeometryUtilsKt.toStringAsFixed(m709getXimpl(j), 1) + ", " + GeometryUtilsKt.toStringAsFixed(m710getYimpl(j), 1) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
        return "Offset.Unspecified";
    }

    public String toString() {
        return m716toStringimpl(this.packedValue);
    }
}
