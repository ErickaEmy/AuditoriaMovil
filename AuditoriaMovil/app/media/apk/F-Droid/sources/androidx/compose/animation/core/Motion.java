package androidx.compose.animation.core;

import kotlin.jvm.internal.FloatCompanionObject;
import org.bouncycastle.asn1.cmc.BodyPartID;
/* compiled from: SpringSimulation.kt */
/* loaded from: classes.dex */
public abstract class Motion {
    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m34constructorimpl(long j) {
        return j;
    }

    /* renamed from: getValue-impl  reason: not valid java name */
    public static final float m35getValueimpl(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* renamed from: getVelocity-impl  reason: not valid java name */
    public static final float m36getVelocityimpl(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j & BodyPartID.bodyIdMax));
    }
}
