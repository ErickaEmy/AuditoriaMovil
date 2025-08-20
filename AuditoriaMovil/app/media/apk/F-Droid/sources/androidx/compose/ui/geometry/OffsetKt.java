package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import org.bouncycastle.asn1.cmc.BodyPartID;
/* compiled from: Offset.kt */
/* loaded from: classes.dex */
public abstract class OffsetKt {
    public static final long Offset(float f, float f2) {
        return Offset.m701constructorimpl((Float.floatToIntBits(f2) & BodyPartID.bodyIdMax) | (Float.floatToIntBits(f) << 32));
    }

    /* renamed from: lerp-Wko1d7g  reason: not valid java name */
    public static final long m724lerpWko1d7g(long j, long j2, float f) {
        return Offset(MathHelpersKt.lerp(Offset.m709getXimpl(j), Offset.m709getXimpl(j2), f), MathHelpersKt.lerp(Offset.m710getYimpl(j), Offset.m710getYimpl(j2), f));
    }

    /* renamed from: isFinite-k-4lQ0M  reason: not valid java name */
    public static final boolean m722isFinitek4lQ0M(long j) {
        float m709getXimpl = Offset.m709getXimpl(j);
        if (!Float.isInfinite(m709getXimpl) && !Float.isNaN(m709getXimpl)) {
            float m710getYimpl = Offset.m710getYimpl(j);
            if (!Float.isInfinite(m710getYimpl) && !Float.isNaN(m710getYimpl)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: isSpecified-k-4lQ0M  reason: not valid java name */
    public static final boolean m723isSpecifiedk4lQ0M(long j) {
        return j != Offset.Companion.m720getUnspecifiedF1C5BW0();
    }
}
