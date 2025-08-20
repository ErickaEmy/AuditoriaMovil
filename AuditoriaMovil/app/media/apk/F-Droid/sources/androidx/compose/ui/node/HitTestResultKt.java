package androidx.compose.ui.node;

import org.bouncycastle.asn1.cmc.BodyPartID;
/* compiled from: HitTestResult.kt */
/* loaded from: classes.dex */
public abstract class HitTestResultKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final long DistanceAndInLayer(float f, boolean z) {
        return DistanceAndInLayer.m1298constructorimpl(((z ? 1L : 0L) & BodyPartID.bodyIdMax) | (Float.floatToIntBits(f) << 32));
    }
}
