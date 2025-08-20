package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RectHelper.android.kt */
/* loaded from: classes.dex */
public abstract class RectHelper_androidKt {
    public static final Rect toComposeRect(android.graphics.Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "<this>");
        return new Rect(rect.left, rect.top, rect.right, rect.bottom);
    }
}
