package androidx.compose.ui.graphics;

import android.graphics.BlendModeColorFilter;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidColorFilter.android.kt */
/* loaded from: classes.dex */
public abstract class AndroidColorFilter_androidKt {
    public static final android.graphics.ColorFilter asAndroidColorFilter(ColorFilter colorFilter) {
        Intrinsics.checkNotNullParameter(colorFilter, "<this>");
        return colorFilter.getNativeColorFilter$ui_graphics_release();
    }

    /* renamed from: actualTintColorFilter-xETnrds  reason: not valid java name */
    public static final ColorFilter m765actualTintColorFilterxETnrds(long j, int i) {
        BlendModeColorFilter porterDuffColorFilter;
        if (Build.VERSION.SDK_INT >= 29) {
            porterDuffColorFilter = BlendModeColorFilterHelper.INSTANCE.m830BlendModeColorFilterxETnrds(j, i);
        } else {
            porterDuffColorFilter = new PorterDuffColorFilter(ColorKt.m871toArgb8_81llA(j), AndroidBlendMode_androidKt.m755toPorterDuffModes9anfk8(i));
        }
        return new ColorFilter(porterDuffColorFilter);
    }
}
