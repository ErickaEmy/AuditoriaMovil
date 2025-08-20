package androidx.compose.ui.node;

import kotlin.jvm.internal.FloatCompanionObject;
import org.bouncycastle.asn1.cmc.BodyPartID;
/* compiled from: HitTestResult.kt */
/* loaded from: classes.dex */
abstract class DistanceAndInLayer {
    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m1298constructorimpl(long j) {
        return j;
    }

    /* renamed from: isInLayer-impl  reason: not valid java name */
    public static final boolean m1300isInLayerimpl(long j) {
        return ((int) (j & BodyPartID.bodyIdMax)) != 0;
    }

    /* renamed from: getDistance-impl  reason: not valid java name */
    public static final float m1299getDistanceimpl(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* renamed from: compareTo-S_HNhKs  reason: not valid java name */
    public static final int m1297compareToS_HNhKs(long j, long j2) {
        boolean m1300isInLayerimpl = m1300isInLayerimpl(j);
        if (m1300isInLayerimpl != m1300isInLayerimpl(j2)) {
            return m1300isInLayerimpl ? -1 : 1;
        }
        return (int) Math.signum(m1299getDistanceimpl(j) - m1299getDistanceimpl(j2));
    }
}
