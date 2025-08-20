package androidx.compose.ui.text.android;

import org.bouncycastle.asn1.cmc.BodyPartID;
/* compiled from: TextLayout.kt */
/* loaded from: classes.dex */
public abstract class VerticalPaddings {
    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m1610constructorimpl(long j) {
        return j;
    }

    /* renamed from: getBottomPadding-impl  reason: not valid java name */
    public static final int m1611getBottomPaddingimpl(long j) {
        return (int) (j & BodyPartID.bodyIdMax);
    }

    /* renamed from: getTopPadding-impl  reason: not valid java name */
    public static final int m1612getTopPaddingimpl(long j) {
        return (int) (j >> 32);
    }
}
