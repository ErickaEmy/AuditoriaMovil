package androidx.compose.ui.geometry;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import org.bouncycastle.asn1.cmc.BodyPartID;
/* compiled from: CornerRadius.kt */
/* loaded from: classes.dex */
public abstract class CornerRadius {
    public static final Companion Companion = new Companion(null);
    private static final long Zero = CornerRadiusKt.CornerRadius$default(0.0f, 0.0f, 2, null);

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m691constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m692equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m695hashCodeimpl(long j) {
        return FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(j);
    }

    /* renamed from: getX-impl  reason: not valid java name */
    public static final float m693getXimpl(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* renamed from: getY-impl  reason: not valid java name */
    public static final float m694getYimpl(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j & BodyPartID.bodyIdMax));
    }

    /* compiled from: CornerRadius.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getZero-kKHJgLs  reason: not valid java name */
        public final long m697getZerokKHJgLs() {
            return CornerRadius.Zero;
        }
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m696toStringimpl(long j) {
        if (m693getXimpl(j) == m694getYimpl(j)) {
            return "CornerRadius.circular(" + GeometryUtilsKt.toStringAsFixed(m693getXimpl(j), 1) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
        return "CornerRadius.elliptical(" + GeometryUtilsKt.toStringAsFixed(m693getXimpl(j), 1) + ", " + GeometryUtilsKt.toStringAsFixed(m694getYimpl(j), 1) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
