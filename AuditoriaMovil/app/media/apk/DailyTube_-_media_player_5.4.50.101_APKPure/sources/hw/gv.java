package hw;

import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import androidx.annotation.NonNull;
import java.util.List;
/* loaded from: classes.dex */
public final class gv {
    public final DisplayCutout y;

    /* loaded from: classes.dex */
    public static class y {
        public static int a(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetTop();
        }

        public static int gv(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetLeft();
        }

        public static List<Rect> n3(DisplayCutout displayCutout) {
            return displayCutout.getBoundingRects();
        }

        public static int v(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetRight();
        }

        public static DisplayCutout y(Rect rect, List<Rect> list) {
            return new DisplayCutout(rect, list);
        }

        public static int zn(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetBottom();
        }
    }

    public gv(DisplayCutout displayCutout) {
        this.y = displayCutout;
    }

    public static gv v(DisplayCutout displayCutout) {
        if (displayCutout == null) {
            return null;
        }
        return new gv(displayCutout);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && gv.class == obj.getClass()) {
            return vl.zn.y(this.y, ((gv) obj).y);
        }
        return false;
    }

    public int gv() {
        if (Build.VERSION.SDK_INT >= 28) {
            return y.a(this.y);
        }
        return 0;
    }

    public int hashCode() {
        DisplayCutout displayCutout = this.y;
        if (displayCutout == null) {
            return 0;
        }
        return displayCutout.hashCode();
    }

    public int n3() {
        if (Build.VERSION.SDK_INT >= 28) {
            return y.gv(this.y);
        }
        return 0;
    }

    @NonNull
    public String toString() {
        return "DisplayCutoutCompat{" + this.y + "}";
    }

    public int y() {
        if (Build.VERSION.SDK_INT >= 28) {
            return y.zn(this.y);
        }
        return 0;
    }

    public int zn() {
        if (Build.VERSION.SDK_INT >= 28) {
            return y.v(this.y);
        }
        return 0;
    }
}
