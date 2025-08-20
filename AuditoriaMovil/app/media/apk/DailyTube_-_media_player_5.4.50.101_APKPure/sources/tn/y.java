package tn;

import android.graphics.Canvas;
import android.os.Build;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class y {
    public static int y(@NonNull Canvas canvas, float f4, float f6, float f9, float f10, int i) {
        if (Build.VERSION.SDK_INT > 21) {
            return canvas.saveLayerAlpha(f4, f6, f9, f10, i);
        }
        return canvas.saveLayerAlpha(f4, f6, f9, f10, i, 31);
    }
}
