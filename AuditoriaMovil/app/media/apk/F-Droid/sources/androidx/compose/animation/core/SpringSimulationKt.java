package androidx.compose.animation.core;

import org.bouncycastle.asn1.cmc.BodyPartID;
/* compiled from: SpringSimulation.kt */
/* loaded from: classes.dex */
public abstract class SpringSimulationKt {
    private static final float UNSET = Float.MAX_VALUE;

    public static final float getUNSET() {
        return UNSET;
    }

    public static final long Motion(float f, float f2) {
        return Motion.m34constructorimpl((Float.floatToIntBits(f2) & BodyPartID.bodyIdMax) | (Float.floatToIntBits(f) << 32));
    }
}
