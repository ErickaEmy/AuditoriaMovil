package androidx.compose.ui.graphics;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import org.bouncycastle.asn1.cmc.BodyPartID;
/* compiled from: TransformOrigin.kt */
/* loaded from: classes.dex */
public final class TransformOrigin {
    private final long packedValue;
    public static final Companion Companion = new Companion(null);
    private static final long Center = TransformOriginKt.TransformOrigin(0.5f, 0.5f);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ TransformOrigin m983boximpl(long j) {
        return new TransformOrigin(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m984constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m985equalsimpl(long j, Object obj) {
        return (obj instanceof TransformOrigin) && j == ((TransformOrigin) obj).m991unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m986equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m989hashCodeimpl(long j) {
        return FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(j);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m990toStringimpl(long j) {
        return "TransformOrigin(packedValue=" + j + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public boolean equals(Object obj) {
        return m985equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m989hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m990toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m991unboximpl() {
        return this.packedValue;
    }

    /* renamed from: getPivotFractionX-impl  reason: not valid java name */
    public static final float m987getPivotFractionXimpl(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j >> 32));
    }

    private /* synthetic */ TransformOrigin(long j) {
        this.packedValue = j;
    }

    /* renamed from: getPivotFractionY-impl  reason: not valid java name */
    public static final float m988getPivotFractionYimpl(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j & BodyPartID.bodyIdMax));
    }

    /* compiled from: TransformOrigin.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getCenter-SzJe1aQ  reason: not valid java name */
        public final long m992getCenterSzJe1aQ() {
            return TransformOrigin.Center;
        }
    }
}
