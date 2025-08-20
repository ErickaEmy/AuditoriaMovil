package j5;

import android.view.View;
import android.view.accessibility.AccessibilityRecord;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class v {

    /* loaded from: classes.dex */
    public static class n3 {
        public static void y(AccessibilityRecord accessibilityRecord, View view, int i) {
            accessibilityRecord.setSource(view, i);
        }
    }

    /* loaded from: classes.dex */
    public static class y {
        public static void gv(AccessibilityRecord accessibilityRecord, int i) {
            accessibilityRecord.setMaxScrollY(i);
        }

        public static int n3(AccessibilityRecord accessibilityRecord) {
            return accessibilityRecord.getMaxScrollY();
        }

        public static int y(AccessibilityRecord accessibilityRecord) {
            return accessibilityRecord.getMaxScrollX();
        }

        public static void zn(AccessibilityRecord accessibilityRecord, int i) {
            accessibilityRecord.setMaxScrollX(i);
        }
    }

    public static void n3(@NonNull AccessibilityRecord accessibilityRecord, int i) {
        y.gv(accessibilityRecord, i);
    }

    public static void y(@NonNull AccessibilityRecord accessibilityRecord, int i) {
        y.zn(accessibilityRecord, i);
    }

    public static void zn(@NonNull AccessibilityRecord accessibilityRecord, @Nullable View view, int i) {
        n3.y(accessibilityRecord, view, i);
    }
}
