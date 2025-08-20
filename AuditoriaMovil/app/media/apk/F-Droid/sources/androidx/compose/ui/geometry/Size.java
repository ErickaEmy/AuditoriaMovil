package androidx.compose.ui.geometry;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import org.bouncycastle.asn1.cmc.BodyPartID;
/* compiled from: Size.kt */
/* loaded from: classes.dex */
public final class Size {
    private final long packedValue;
    public static final Companion Companion = new Companion(null);
    private static final long Zero = SizeKt.Size(0.0f, 0.0f);
    private static final long Unspecified = SizeKt.Size(Float.NaN, Float.NaN);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Size m739boximpl(long j) {
        return new Size(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m740constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m741equalsimpl(long j, Object obj) {
        return (obj instanceof Size) && j == ((Size) obj).m749unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m742equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m746hashCodeimpl(long j) {
        return FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(j);
    }

    public boolean equals(Object obj) {
        return m741equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m746hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m749unboximpl() {
        return this.packedValue;
    }

    /* renamed from: getWidth-impl  reason: not valid java name */
    public static final float m745getWidthimpl(long j) {
        if (j != Unspecified) {
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            return Float.intBitsToFloat((int) (j >> 32));
        }
        throw new IllegalStateException("Size is unspecified".toString());
    }

    /* renamed from: getHeight-impl  reason: not valid java name */
    public static final float m743getHeightimpl(long j) {
        if (j != Unspecified) {
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            return Float.intBitsToFloat((int) (j & BodyPartID.bodyIdMax));
        }
        throw new IllegalStateException("Size is unspecified".toString());
    }

    private /* synthetic */ Size(long j) {
        this.packedValue = j;
    }

    /* compiled from: Size.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getZero-NH-jbRc  reason: not valid java name */
        public final long m751getZeroNHjbRc() {
            return Size.Zero;
        }

        /* renamed from: getUnspecified-NH-jbRc  reason: not valid java name */
        public final long m750getUnspecifiedNHjbRc() {
            return Size.Unspecified;
        }
    }

    /* renamed from: isEmpty-impl  reason: not valid java name */
    public static final boolean m747isEmptyimpl(long j) {
        return m745getWidthimpl(j) <= 0.0f || m743getHeightimpl(j) <= 0.0f;
    }

    /* renamed from: getMinDimension-impl  reason: not valid java name */
    public static final float m744getMinDimensionimpl(long j) {
        return Math.min(Math.abs(m745getWidthimpl(j)), Math.abs(m743getHeightimpl(j)));
    }

    public String toString() {
        return m748toStringimpl(this.packedValue);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m748toStringimpl(long j) {
        if (j != Companion.m750getUnspecifiedNHjbRc()) {
            return "Size(" + GeometryUtilsKt.toStringAsFixed(m745getWidthimpl(j), 1) + ", " + GeometryUtilsKt.toStringAsFixed(m743getHeightimpl(j), 1) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
        return "Size.Unspecified";
    }
}
