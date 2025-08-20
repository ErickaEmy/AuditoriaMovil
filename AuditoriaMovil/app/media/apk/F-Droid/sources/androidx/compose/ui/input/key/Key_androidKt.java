package androidx.compose.ui.input.key;

import org.bouncycastle.asn1.cmc.BodyPartID;
/* compiled from: Key.android.kt */
/* loaded from: classes.dex */
public abstract class Key_androidKt {
    /* renamed from: getNativeKeyCode-YVgTNJs  reason: not valid java name */
    public static final int m1149getNativeKeyCodeYVgTNJs(long j) {
        return (int) (j >> 32);
    }

    public static final long Key(int i) {
        return Key.m1116constructorimpl((i << 32) | (0 & BodyPartID.bodyIdMax));
    }
}
