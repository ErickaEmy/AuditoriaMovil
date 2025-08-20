package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.SizeKt;
import org.bouncycastle.asn1.cmc.BodyPartID;
/* compiled from: IntSize.kt */
/* loaded from: classes.dex */
public abstract class IntSizeKt {
    public static final long IntSize(int i, int i2) {
        return IntSize.m1947constructorimpl((i2 & BodyPartID.bodyIdMax) | (i << 32));
    }

    /* renamed from: getCenter-ozmzZPI  reason: not valid java name */
    public static final long m1956getCenterozmzZPI(long j) {
        return IntOffsetKt.IntOffset(IntSize.m1951getWidthimpl(j) / 2, IntSize.m1950getHeightimpl(j) / 2);
    }

    /* renamed from: toSize-ozmzZPI  reason: not valid java name */
    public static final long m1957toSizeozmzZPI(long j) {
        return SizeKt.Size(IntSize.m1951getWidthimpl(j), IntSize.m1950getHeightimpl(j));
    }
}
