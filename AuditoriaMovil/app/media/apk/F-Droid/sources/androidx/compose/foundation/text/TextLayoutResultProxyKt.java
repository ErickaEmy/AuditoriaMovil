package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
/* compiled from: TextLayoutResultProxy.kt */
/* loaded from: classes.dex */
public abstract class TextLayoutResultProxyKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: coerceIn-3MmeM6k  reason: not valid java name */
    public static final long m362coerceIn3MmeM6k(long j, Rect rect) {
        float right;
        float bottom;
        if (Offset.m709getXimpl(j) < rect.getLeft()) {
            right = rect.getLeft();
        } else {
            right = Offset.m709getXimpl(j) > rect.getRight() ? rect.getRight() : Offset.m709getXimpl(j);
        }
        if (Offset.m710getYimpl(j) < rect.getTop()) {
            bottom = rect.getTop();
        } else {
            bottom = Offset.m710getYimpl(j) > rect.getBottom() ? rect.getBottom() : Offset.m710getYimpl(j);
        }
        return OffsetKt.Offset(right, bottom);
    }
}
