package hw;

import android.view.MotionEvent;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public final class i9 {
    public static boolean y(@NonNull MotionEvent motionEvent, int i) {
        if ((motionEvent.getSource() & i) == i) {
            return true;
        }
        return false;
    }
}
