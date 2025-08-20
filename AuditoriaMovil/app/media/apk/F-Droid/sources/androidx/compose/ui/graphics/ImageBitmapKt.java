package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ImageBitmap.kt */
/* loaded from: classes.dex */
public abstract class ImageBitmapKt {
    /* renamed from: ImageBitmap-x__-hDU$default  reason: not valid java name */
    public static /* synthetic */ ImageBitmap m908ImageBitmapx__hDU$default(int i, int i2, int i3, boolean z, ColorSpace colorSpace, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = ImageBitmapConfig.Companion.m903getArgb8888_sVssgQ();
        }
        if ((i4 & 8) != 0) {
            z = true;
        }
        if ((i4 & 16) != 0) {
            colorSpace = ColorSpaces.INSTANCE.getSrgb();
        }
        return m907ImageBitmapx__hDU(i, i2, i3, z, colorSpace);
    }

    /* renamed from: ImageBitmap-x__-hDU  reason: not valid java name */
    public static final ImageBitmap m907ImageBitmapx__hDU(int i, int i2, int i3, boolean z, ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        return AndroidImageBitmap_androidKt.m767ActualImageBitmapx__hDU(i, i2, i3, z, colorSpace);
    }
}
