package androidx.compose.ui.unit;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import androidx.compose.ui.unit.Dp;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import org.bouncycastle.asn1.cmc.BodyPartID;
/* compiled from: Dp.kt */
/* loaded from: classes.dex */
public final class DpOffset {
    public static final Companion Companion = new Companion(null);
    private static final long Unspecified;
    private static final long Zero;
    private final long packedValue;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ DpOffset m1908boximpl(long j) {
        return new DpOffset(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m1909constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1910equalsimpl(long j, Object obj) {
        return (obj instanceof DpOffset) && j == ((DpOffset) obj).m1916unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1911equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1914hashCodeimpl(long j) {
        return FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(j);
    }

    public boolean equals(Object obj) {
        return m1910equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m1914hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m1916unboximpl() {
        return this.packedValue;
    }

    /* renamed from: getX-D9Ej5fM  reason: not valid java name */
    public static final float m1912getXD9Ej5fM(long j) {
        if (j != Unspecified) {
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            return Dp.m1897constructorimpl(Float.intBitsToFloat((int) (j >> 32)));
        }
        throw new IllegalStateException("DpOffset is unspecified".toString());
    }

    /* renamed from: getY-D9Ej5fM  reason: not valid java name */
    public static final float m1913getYD9Ej5fM(long j) {
        if (j != Unspecified) {
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            return Dp.m1897constructorimpl(Float.intBitsToFloat((int) (j & BodyPartID.bodyIdMax)));
        }
        throw new IllegalStateException("DpOffset is unspecified".toString());
    }

    static {
        float f = 0;
        Zero = DpKt.m1906DpOffsetYgX7TsA(Dp.m1897constructorimpl(f), Dp.m1897constructorimpl(f));
        Dp.Companion companion = Dp.Companion;
        Unspecified = DpKt.m1906DpOffsetYgX7TsA(companion.m1905getUnspecifiedD9Ej5fM(), companion.m1905getUnspecifiedD9Ej5fM());
    }

    private /* synthetic */ DpOffset(long j) {
        this.packedValue = j;
    }

    public String toString() {
        return m1915toStringimpl(this.packedValue);
    }

    /* compiled from: Dp.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getUnspecified-RKDOV3M  reason: not valid java name */
        public final long m1917getUnspecifiedRKDOV3M() {
            return DpOffset.Unspecified;
        }
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1915toStringimpl(long j) {
        if (j != Companion.m1917getUnspecifiedRKDOV3M()) {
            return CoreConstants.LEFT_PARENTHESIS_CHAR + ((Object) Dp.m1901toStringimpl(m1912getXD9Ej5fM(j))) + ", " + ((Object) Dp.m1901toStringimpl(m1913getYD9Ej5fM(j))) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
        return "DpOffset.Unspecified";
    }
}
