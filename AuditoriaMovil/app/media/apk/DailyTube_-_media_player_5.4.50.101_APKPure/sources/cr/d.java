package cr;

import android.view.View;
import android.view.WindowId;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class d implements z6 {
    public final WindowId y;

    public d(@NonNull View view) {
        this.y = view.getWindowId();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof d) && ((d) obj).y.equals(this.y)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.y.hashCode();
    }
}
