package androidx.compose.ui.unit;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import org.bouncycastle.asn1.cmc.BodyPartID;
/* compiled from: Velocity.kt */
/* loaded from: classes.dex */
public final class Velocity {
    public static final Companion Companion = new Companion(null);
    private static final long Zero = VelocityKt.Velocity(0.0f, 0.0f);
    private final long packedValue;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Velocity m1983boximpl(long j) {
        return new Velocity(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m1984constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1987equalsimpl(long j, Object obj) {
        return (obj instanceof Velocity) && j == ((Velocity) obj).m1996unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1988equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1991hashCodeimpl(long j) {
        return FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(j);
    }

    public boolean equals(Object obj) {
        return m1987equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m1991hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m1996unboximpl() {
        return this.packedValue;
    }

    /* renamed from: getX-impl  reason: not valid java name */
    public static final float m1989getXimpl(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j >> 32));
    }

    private /* synthetic */ Velocity(long j) {
        this.packedValue = j;
    }

    /* renamed from: getY-impl  reason: not valid java name */
    public static final float m1990getYimpl(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j & BodyPartID.bodyIdMax));
    }

    /* renamed from: copy-OhffZ5M  reason: not valid java name */
    public static final long m1985copyOhffZ5M(long j, float f, float f2) {
        return VelocityKt.Velocity(f, f2);
    }

    /* renamed from: copy-OhffZ5M$default  reason: not valid java name */
    public static /* synthetic */ long m1986copyOhffZ5M$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m1989getXimpl(j);
        }
        if ((i & 2) != 0) {
            f2 = m1990getYimpl(j);
        }
        return m1985copyOhffZ5M(j, f, f2);
    }

    /* compiled from: Velocity.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getZero-9UxMQ8M  reason: not valid java name */
        public final long m1997getZero9UxMQ8M() {
            return Velocity.Zero;
        }
    }

    /* renamed from: minus-AH228Gc  reason: not valid java name */
    public static final long m1992minusAH228Gc(long j, long j2) {
        return VelocityKt.Velocity(m1989getXimpl(j) - m1989getXimpl(j2), m1990getYimpl(j) - m1990getYimpl(j2));
    }

    /* renamed from: plus-AH228Gc  reason: not valid java name */
    public static final long m1993plusAH228Gc(long j, long j2) {
        return VelocityKt.Velocity(m1989getXimpl(j) + m1989getXimpl(j2), m1990getYimpl(j) + m1990getYimpl(j2));
    }

    /* renamed from: times-adjELrA  reason: not valid java name */
    public static final long m1994timesadjELrA(long j, float f) {
        return VelocityKt.Velocity(m1989getXimpl(j) * f, m1990getYimpl(j) * f);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1995toStringimpl(long j) {
        return CoreConstants.LEFT_PARENTHESIS_CHAR + m1989getXimpl(j) + ", " + m1990getYimpl(j) + ") px/sec";
    }

    public String toString() {
        return m1995toStringimpl(this.packedValue);
    }
}
