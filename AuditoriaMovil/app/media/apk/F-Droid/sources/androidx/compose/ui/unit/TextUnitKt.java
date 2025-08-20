package androidx.compose.ui.unit;

import androidx.compose.ui.util.MathHelpersKt;
import org.bouncycastle.asn1.cmc.BodyPartID;
/* compiled from: TextUnit.kt */
/* loaded from: classes.dex */
public abstract class TextUnitKt {
    /* renamed from: TextUnit-anM5pPY  reason: not valid java name */
    public static final long m1969TextUnitanM5pPY(float f, long j) {
        return pack(j, f);
    }

    /* renamed from: isUnspecified--R2X_6o  reason: not valid java name */
    public static final boolean m1971isUnspecifiedR2X_6o(long j) {
        return TextUnit.m1962getRawTypeimpl(j) == 0;
    }

    public static final long getSp(float f) {
        return pack(4294967296L, f);
    }

    public static final long getEm(float f) {
        return pack(8589934592L, f);
    }

    public static final long getSp(double d) {
        return pack(4294967296L, (float) d);
    }

    public static final long getSp(int i) {
        return pack(4294967296L, i);
    }

    public static final long getEm(int i) {
        return pack(8589934592L, i);
    }

    public static final long pack(long j, float f) {
        return TextUnit.m1959constructorimpl(j | (Float.floatToIntBits(f) & BodyPartID.bodyIdMax));
    }

    /* renamed from: checkArithmetic-NB67dxo  reason: not valid java name */
    public static final void m1970checkArithmeticNB67dxo(long j, long j2) {
        if (m1971isUnspecifiedR2X_6o(j) || m1971isUnspecifiedR2X_6o(j2)) {
            throw new IllegalArgumentException("Cannot perform operation for Unspecified type.".toString());
        }
        if (TextUnitType.m1976equalsimpl0(TextUnit.m1963getTypeUIouoOA(j), TextUnit.m1963getTypeUIouoOA(j2))) {
            return;
        }
        throw new IllegalArgumentException(("Cannot perform operation for " + ((Object) TextUnitType.m1978toStringimpl(TextUnit.m1963getTypeUIouoOA(j))) + " and " + ((Object) TextUnitType.m1978toStringimpl(TextUnit.m1963getTypeUIouoOA(j2)))).toString());
    }

    /* renamed from: lerp-C3pnCVY  reason: not valid java name */
    public static final long m1972lerpC3pnCVY(long j, long j2, float f) {
        m1970checkArithmeticNB67dxo(j, j2);
        return pack(TextUnit.m1962getRawTypeimpl(j), MathHelpersKt.lerp(TextUnit.m1964getValueimpl(j), TextUnit.m1964getValueimpl(j2), f));
    }
}
