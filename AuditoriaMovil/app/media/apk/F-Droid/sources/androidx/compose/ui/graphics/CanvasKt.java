package androidx.compose.ui.graphics;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: Canvas.kt */
/* loaded from: classes.dex */
public abstract class CanvasKt {
    public static final Canvas Canvas(ImageBitmap image) {
        Intrinsics.checkNotNullParameter(image, "image");
        return AndroidCanvas_androidKt.ActualCanvas(image);
    }
}
