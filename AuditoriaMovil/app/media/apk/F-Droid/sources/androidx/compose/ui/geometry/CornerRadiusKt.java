package androidx.compose.ui.geometry;

import org.bouncycastle.asn1.cmc.BodyPartID;
/* compiled from: CornerRadius.kt */
/* loaded from: classes.dex */
public abstract class CornerRadiusKt {
    public static final long CornerRadius(float f, float f2) {
        return CornerRadius.m691constructorimpl((Float.floatToIntBits(f2) & BodyPartID.bodyIdMax) | (Float.floatToIntBits(f) << 32));
    }

    public static /* synthetic */ long CornerRadius$default(float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = f;
        }
        return CornerRadius(f, f2);
    }
}
