package hw;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.PointerIcon;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public final class z {
    public final PointerIcon y;

    /* loaded from: classes.dex */
    public static class y {
        public static PointerIcon n3(Context context, int i) {
            return PointerIcon.getSystemIcon(context, i);
        }

        public static PointerIcon y(Bitmap bitmap, float f4, float f6) {
            return PointerIcon.create(bitmap, f4, f6);
        }

        public static PointerIcon zn(Resources resources, int i) {
            return PointerIcon.load(resources, i);
        }
    }

    public z(PointerIcon pointerIcon) {
        this.y = pointerIcon;
    }

    @NonNull
    public static z n3(@NonNull Context context, int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new z(y.n3(context, i));
        }
        return new z(null);
    }

    @Nullable
    public Object y() {
        return this.y;
    }
}
