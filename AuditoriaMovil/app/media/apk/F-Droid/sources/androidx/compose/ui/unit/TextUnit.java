package androidx.compose.ui.unit;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import org.bouncycastle.asn1.cmc.BodyPartID;
/* compiled from: TextUnit.kt */
/* loaded from: classes.dex */
public final class TextUnit {
    public static final Companion Companion = new Companion(null);
    private static final TextUnitType[] TextUnitTypes;
    private static final long Unspecified;
    private final long packedValue;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ TextUnit m1958boximpl(long j) {
        return new TextUnit(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m1959constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1960equalsimpl(long j, Object obj) {
        return (obj instanceof TextUnit) && j == ((TextUnit) obj).m1967unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1961equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getRawType-impl  reason: not valid java name */
    public static final long m1962getRawTypeimpl(long j) {
        return j & 1095216660480L;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1965hashCodeimpl(long j) {
        return FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(j);
    }

    public boolean equals(Object obj) {
        return m1960equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m1965hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m1967unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ TextUnit(long j) {
        this.packedValue = j;
    }

    public String toString() {
        return m1966toStringimpl(this.packedValue);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1966toStringimpl(long j) {
        long m1963getTypeUIouoOA = m1963getTypeUIouoOA(j);
        TextUnitType.Companion companion = TextUnitType.Companion;
        if (TextUnitType.m1976equalsimpl0(m1963getTypeUIouoOA, companion.m1982getUnspecifiedUIouoOA())) {
            return "Unspecified";
        }
        if (TextUnitType.m1976equalsimpl0(m1963getTypeUIouoOA, companion.m1981getSpUIouoOA())) {
            return m1964getValueimpl(j) + ".sp";
        } else if (TextUnitType.m1976equalsimpl0(m1963getTypeUIouoOA, companion.m1980getEmUIouoOA())) {
            return m1964getValueimpl(j) + ".em";
        } else {
            return "Invalid";
        }
    }

    static {
        TextUnitType.Companion companion = TextUnitType.Companion;
        TextUnitTypes = new TextUnitType[]{TextUnitType.m1973boximpl(companion.m1982getUnspecifiedUIouoOA()), TextUnitType.m1973boximpl(companion.m1981getSpUIouoOA()), TextUnitType.m1973boximpl(companion.m1980getEmUIouoOA())};
        Unspecified = TextUnitKt.pack(0L, Float.NaN);
    }

    /* compiled from: TextUnit.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getUnspecified-XSAIIZE  reason: not valid java name */
        public final long m1968getUnspecifiedXSAIIZE() {
            return TextUnit.Unspecified;
        }
    }

    /* renamed from: getType-UIouoOA  reason: not valid java name */
    public static final long m1963getTypeUIouoOA(long j) {
        return TextUnitTypes[(int) (m1962getRawTypeimpl(j) >>> 32)].m1979unboximpl();
    }

    /* renamed from: getValue-impl  reason: not valid java name */
    public static final float m1964getValueimpl(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j & BodyPartID.bodyIdMax));
    }
}
