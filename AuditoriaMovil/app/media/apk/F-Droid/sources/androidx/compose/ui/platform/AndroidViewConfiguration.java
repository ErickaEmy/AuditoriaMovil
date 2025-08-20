package androidx.compose.ui.platform;

import androidx.compose.ui.platform.ViewConfiguration;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidViewConfiguration.android.kt */
/* loaded from: classes.dex */
public final class AndroidViewConfiguration implements ViewConfiguration {
    private final android.view.ViewConfiguration viewConfiguration;

    @Override // androidx.compose.ui.platform.ViewConfiguration
    public long getDoubleTapMinTimeMillis() {
        return 40L;
    }

    @Override // androidx.compose.ui.platform.ViewConfiguration
    /* renamed from: getMinimumTouchTargetSize-MYxV2XQ */
    public /* synthetic */ long mo1314getMinimumTouchTargetSizeMYxV2XQ() {
        return ViewConfiguration.CC.m1462$default$getMinimumTouchTargetSizeMYxV2XQ(this);
    }

    public AndroidViewConfiguration(android.view.ViewConfiguration viewConfiguration) {
        Intrinsics.checkNotNullParameter(viewConfiguration, "viewConfiguration");
        this.viewConfiguration = viewConfiguration;
    }

    @Override // androidx.compose.ui.platform.ViewConfiguration
    public long getLongPressTimeoutMillis() {
        return android.view.ViewConfiguration.getLongPressTimeout();
    }

    @Override // androidx.compose.ui.platform.ViewConfiguration
    public long getDoubleTapTimeoutMillis() {
        return android.view.ViewConfiguration.getDoubleTapTimeout();
    }

    @Override // androidx.compose.ui.platform.ViewConfiguration
    public float getTouchSlop() {
        return this.viewConfiguration.getScaledTouchSlop();
    }
}
