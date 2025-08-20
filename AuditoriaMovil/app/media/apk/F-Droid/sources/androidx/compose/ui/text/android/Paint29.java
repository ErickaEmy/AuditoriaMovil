package androidx.compose.ui.text.android;

import android.graphics.Paint;
import android.graphics.Rect;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PaintExtensions.kt */
/* loaded from: classes.dex */
final class Paint29 {
    public static final Paint29 INSTANCE = new Paint29();

    private Paint29() {
    }

    public static final void getTextBounds(Paint paint, CharSequence text, int i, int i2, Rect rect) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(rect, "rect");
        paint.getTextBounds(text, i, i2, rect);
    }
}
