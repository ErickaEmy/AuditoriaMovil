package j5;

import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public final class n3 {

    /* loaded from: classes.dex */
    public static class y {
        public static void n3(AccessibilityEvent accessibilityEvent, int i) {
            accessibilityEvent.setContentChangeTypes(i);
        }

        public static int y(AccessibilityEvent accessibilityEvent) {
            return accessibilityEvent.getContentChangeTypes();
        }
    }

    public static void n3(@NonNull AccessibilityEvent accessibilityEvent, int i) {
        y.n3(accessibilityEvent, i);
    }

    public static int y(@NonNull AccessibilityEvent accessibilityEvent) {
        return y.y(accessibilityEvent);
    }
}
