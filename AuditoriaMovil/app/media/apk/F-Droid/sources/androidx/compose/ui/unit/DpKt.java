package androidx.compose.ui.unit;

import org.bouncycastle.asn1.cmc.BodyPartID;
/* compiled from: Dp.kt */
/* loaded from: classes.dex */
public abstract class DpKt {
    /* renamed from: DpOffset-YgX7TsA  reason: not valid java name */
    public static final long m1906DpOffsetYgX7TsA(float f, float f2) {
        return DpOffset.m1909constructorimpl((Float.floatToIntBits(f2) & BodyPartID.bodyIdMax) | (Float.floatToIntBits(f) << 32));
    }

    /* renamed from: DpSize-YgX7TsA  reason: not valid java name */
    public static final long m1907DpSizeYgX7TsA(float f, float f2) {
        return DpSize.m1919constructorimpl((Float.floatToIntBits(f2) & BodyPartID.bodyIdMax) | (Float.floatToIntBits(f) << 32));
    }
}
