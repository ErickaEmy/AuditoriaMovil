package androidx.core.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.PointerIcon;
/* loaded from: classes.dex */
public final class PointerIconCompat {
    private final PointerIcon mPointerIcon;

    public Object getPointerIcon() {
        return this.mPointerIcon;
    }

    private PointerIconCompat(PointerIcon pointerIcon) {
        this.mPointerIcon = pointerIcon;
    }

    public static PointerIconCompat getSystemIcon(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new PointerIconCompat(Api24Impl.getSystemIcon(context, i));
        }
        return new PointerIconCompat(null);
    }

    /* loaded from: classes.dex */
    static class Api24Impl {
        static PointerIcon getSystemIcon(Context context, int i) {
            return PointerIcon.getSystemIcon(context, i);
        }

        static PointerIcon create(Bitmap bitmap, float f, float f2) {
            return PointerIcon.create(bitmap, f, f2);
        }

        static PointerIcon load(Resources resources, int i) {
            return PointerIcon.load(resources, i);
        }
    }
}
