package androidx.compose.ui.unit;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: TextUnit.kt */
/* loaded from: classes.dex */
public final class TextUnitType {
    private final long type;
    public static final Companion Companion = new Companion(null);
    private static final long Unspecified = m1974constructorimpl(0);
    private static final long Sp = m1974constructorimpl(4294967296L);
    private static final long Em = m1974constructorimpl(8589934592L);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ TextUnitType m1973boximpl(long j) {
        return new TextUnitType(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m1974constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1975equalsimpl(long j, Object obj) {
        return (obj instanceof TextUnitType) && j == ((TextUnitType) obj).m1979unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1976equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1977hashCodeimpl(long j) {
        return FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(j);
    }

    public boolean equals(Object obj) {
        return m1975equalsimpl(this.type, obj);
    }

    public int hashCode() {
        return m1977hashCodeimpl(this.type);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m1979unboximpl() {
        return this.type;
    }

    private /* synthetic */ TextUnitType(long j) {
        this.type = j;
    }

    public String toString() {
        return m1978toStringimpl(this.type);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1978toStringimpl(long j) {
        return m1976equalsimpl0(j, Unspecified) ? "Unspecified" : m1976equalsimpl0(j, Sp) ? "Sp" : m1976equalsimpl0(j, Em) ? "Em" : "Invalid";
    }

    /* compiled from: TextUnit.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getUnspecified-UIouoOA  reason: not valid java name */
        public final long m1982getUnspecifiedUIouoOA() {
            return TextUnitType.Unspecified;
        }

        /* renamed from: getSp-UIouoOA  reason: not valid java name */
        public final long m1981getSpUIouoOA() {
            return TextUnitType.Sp;
        }

        /* renamed from: getEm-UIouoOA  reason: not valid java name */
        public final long m1980getEmUIouoOA() {
            return TextUnitType.Em;
        }
    }
}
