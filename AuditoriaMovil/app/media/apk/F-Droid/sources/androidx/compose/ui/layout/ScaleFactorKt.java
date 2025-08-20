package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import org.bouncycastle.asn1.cmc.BodyPartID;
/* compiled from: ScaleFactor.kt */
/* loaded from: classes.dex */
public abstract class ScaleFactorKt {
    public static final long ScaleFactor(float f, float f2) {
        return ScaleFactor.m1280constructorimpl((Float.floatToIntBits(f2) & BodyPartID.bodyIdMax) | (Float.floatToIntBits(f) << 32));
    }

    /* renamed from: times-UQTWf7w  reason: not valid java name */
    public static final long m1283timesUQTWf7w(long j, long j2) {
        return SizeKt.Size(Size.m745getWidthimpl(j) * ScaleFactor.m1281getScaleXimpl(j2), Size.m743getHeightimpl(j) * ScaleFactor.m1282getScaleYimpl(j2));
    }
}
