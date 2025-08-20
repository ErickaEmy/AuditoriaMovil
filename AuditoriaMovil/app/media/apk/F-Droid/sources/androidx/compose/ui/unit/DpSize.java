package androidx.compose.ui.unit;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import org.bouncycastle.asn1.cmc.BodyPartID;
/* compiled from: Dp.kt */
/* loaded from: classes.dex */
public final class DpSize {
    public static final Companion Companion = new Companion(null);
    private static final long Unspecified;
    private static final long Zero;
    private final long packedValue;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ DpSize m1918boximpl(long j) {
        return new DpSize(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m1919constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1920equalsimpl(long j, Object obj) {
        return (obj instanceof DpSize) && j == ((DpSize) obj).m1926unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1921equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1924hashCodeimpl(long j) {
        return FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(j);
    }

    public boolean equals(Object obj) {
        return m1920equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m1924hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m1926unboximpl() {
        return this.packedValue;
    }

    /* renamed from: getWidth-D9Ej5fM  reason: not valid java name */
    public static final float m1923getWidthD9Ej5fM(long j) {
        if (j != Unspecified) {
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            return Dp.m1897constructorimpl(Float.intBitsToFloat((int) (j >> 32)));
        }
        throw new IllegalStateException("DpSize is unspecified".toString());
    }

    /* renamed from: getHeight-D9Ej5fM  reason: not valid java name */
    public static final float m1922getHeightD9Ej5fM(long j) {
        if (j != Unspecified) {
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            return Dp.m1897constructorimpl(Float.intBitsToFloat((int) (j & BodyPartID.bodyIdMax)));
        }
        throw new IllegalStateException("DpSize is unspecified".toString());
    }

    static {
        float f = 0;
        Zero = DpKt.m1907DpSizeYgX7TsA(Dp.m1897constructorimpl(f), Dp.m1897constructorimpl(f));
        Dp.Companion companion = Dp.Companion;
        Unspecified = DpKt.m1907DpSizeYgX7TsA(companion.m1905getUnspecifiedD9Ej5fM(), companion.m1905getUnspecifiedD9Ej5fM());
    }

    private /* synthetic */ DpSize(long j) {
        this.packedValue = j;
    }

    public String toString() {
        return m1925toStringimpl(this.packedValue);
    }

    /* compiled from: Dp.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getZero-MYxV2XQ  reason: not valid java name */
        public final long m1928getZeroMYxV2XQ() {
            return DpSize.Zero;
        }

        /* renamed from: getUnspecified-MYxV2XQ  reason: not valid java name */
        public final long m1927getUnspecifiedMYxV2XQ() {
            return DpSize.Unspecified;
        }
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1925toStringimpl(long j) {
        if (j != Companion.m1927getUnspecifiedMYxV2XQ()) {
            return ((Object) Dp.m1901toStringimpl(m1923getWidthD9Ej5fM(j))) + " x " + ((Object) Dp.m1901toStringimpl(m1922getHeightD9Ej5fM(j)));
        }
        return "DpSize.Unspecified";
    }
}
