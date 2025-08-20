package androidx.compose.ui.unit;

import org.bouncycastle.asn1.cmc.BodyPartID;
/* compiled from: Velocity.kt */
/* loaded from: classes.dex */
public abstract class VelocityKt {
    public static final long Velocity(float f, float f2) {
        return Velocity.m1984constructorimpl((Float.floatToIntBits(f2) & BodyPartID.bodyIdMax) | (Float.floatToIntBits(f) << 32));
    }
}
