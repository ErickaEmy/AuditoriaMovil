package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import org.bouncycastle.asn1.cmc.BodyPartID;
/* compiled from: IntOffset.kt */
/* loaded from: classes.dex */
public abstract class IntOffsetKt {
    public static final long IntOffset(int i, int i2) {
        return IntOffset.m1932constructorimpl((i2 & BodyPartID.bodyIdMax) | (i << 32));
    }

    /* renamed from: plus-Nv-tHpc  reason: not valid java name */
    public static final long m1944plusNvtHpc(long j, long j2) {
        return OffsetKt.Offset(Offset.m709getXimpl(j) + IntOffset.m1937getXimpl(j2), Offset.m710getYimpl(j) + IntOffset.m1938getYimpl(j2));
    }

    /* renamed from: minus-Nv-tHpc  reason: not valid java name */
    public static final long m1943minusNvtHpc(long j, long j2) {
        return OffsetKt.Offset(Offset.m709getXimpl(j) - IntOffset.m1937getXimpl(j2), Offset.m710getYimpl(j) - IntOffset.m1938getYimpl(j2));
    }
}
