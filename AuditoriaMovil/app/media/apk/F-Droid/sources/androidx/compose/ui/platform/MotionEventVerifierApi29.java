package androidx.compose.ui.platform;

import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidComposeView.android.kt */
/* loaded from: classes.dex */
final class MotionEventVerifierApi29 {
    public static final MotionEventVerifierApi29 INSTANCE = new MotionEventVerifierApi29();

    private MotionEventVerifierApi29() {
    }

    public final boolean isValidMotionEvent(MotionEvent event, int i) {
        float rawX;
        float rawY;
        Intrinsics.checkNotNullParameter(event, "event");
        rawX = event.getRawX(i);
        if (!Float.isInfinite(rawX) && !Float.isNaN(rawX)) {
            rawY = event.getRawY(i);
            if (!Float.isInfinite(rawY) && !Float.isNaN(rawY)) {
                return true;
            }
        }
        return false;
    }
}
