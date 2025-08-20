package androidx.compose.ui.platform;

import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
/* compiled from: ViewConfiguration.kt */
/* loaded from: classes.dex */
public interface ViewConfiguration {
    long getDoubleTapMinTimeMillis();

    long getDoubleTapTimeoutMillis();

    long getLongPressTimeoutMillis();

    /* renamed from: getMinimumTouchTargetSize-MYxV2XQ */
    long mo1314getMinimumTouchTargetSizeMYxV2XQ();

    float getTouchSlop();

    /* compiled from: ViewConfiguration.kt */
    /* renamed from: androidx.compose.ui.platform.ViewConfiguration$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
        /* renamed from: $default$getMinimumTouchTargetSize-MYxV2XQ  reason: not valid java name */
        public static long m1462$default$getMinimumTouchTargetSizeMYxV2XQ(ViewConfiguration viewConfiguration) {
            float f = 48;
            return DpKt.m1907DpSizeYgX7TsA(Dp.m1897constructorimpl(f), Dp.m1897constructorimpl(f));
        }
    }
}
