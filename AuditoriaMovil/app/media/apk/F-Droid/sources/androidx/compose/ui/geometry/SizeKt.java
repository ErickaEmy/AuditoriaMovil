package androidx.compose.ui.geometry;

import org.bouncycastle.asn1.cmc.BodyPartID;
/* compiled from: Size.kt */
/* loaded from: classes.dex */
public abstract class SizeKt {
    public static final long Size(float f, float f2) {
        return Size.m740constructorimpl((Float.floatToIntBits(f2) & BodyPartID.bodyIdMax) | (Float.floatToIntBits(f) << 32));
    }

    /* renamed from: toRect-uvyYCjk  reason: not valid java name */
    public static final Rect m753toRectuvyYCjk(long j) {
        return RectKt.m732Recttz77jQw(Offset.Companion.m721getZeroF1C5BW0(), j);
    }

    /* renamed from: getCenter-uvyYCjk  reason: not valid java name */
    public static final long m752getCenteruvyYCjk(long j) {
        return OffsetKt.Offset(Size.m745getWidthimpl(j) / 2.0f, Size.m743getHeightimpl(j) / 2.0f);
    }
}
