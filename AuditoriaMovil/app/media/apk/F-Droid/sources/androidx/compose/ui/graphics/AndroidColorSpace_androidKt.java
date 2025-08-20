package androidx.compose.ui.graphics;

import android.graphics.ColorSpace;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidColorSpace.android.kt */
/* loaded from: classes.dex */
public abstract class AndroidColorSpace_androidKt {
    public static final ColorSpace toAndroidColorSpace(androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(colorSpace, "<this>");
        return ColorSpaceVerificationHelper.androidColorSpace(colorSpace);
    }

    public static final androidx.compose.ui.graphics.colorspace.ColorSpace toComposeColorSpace(ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(colorSpace, "<this>");
        return ColorSpaceVerificationHelper.composeColorSpace(colorSpace);
    }
}
