package j;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EdgeEffect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public final class s {

    /* loaded from: classes.dex */
    public static class n3 {
        public static float n3(EdgeEffect edgeEffect) {
            try {
                return edgeEffect.getDistance();
            } catch (Throwable unused) {
                return 0.0f;
            }
        }

        public static EdgeEffect y(Context context, AttributeSet attributeSet) {
            try {
                return new EdgeEffect(context, attributeSet);
            } catch (Throwable unused) {
                return new EdgeEffect(context);
            }
        }

        public static float zn(EdgeEffect edgeEffect, float f4, float f6) {
            try {
                return edgeEffect.onPullDistance(f4, f6);
            } catch (Throwable unused) {
                edgeEffect.onPull(f4, f6);
                return 0.0f;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class y {
        public static void y(EdgeEffect edgeEffect, float f4, float f6) {
            edgeEffect.onPull(f4, f6);
        }
    }

    public static float gv(@NonNull EdgeEffect edgeEffect, float f4, float f6) {
        if (Build.VERSION.SDK_INT >= 31) {
            return n3.zn(edgeEffect, f4, f6);
        }
        zn(edgeEffect, f4, f6);
        return f4;
    }

    public static float n3(@NonNull EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return n3.n3(edgeEffect);
        }
        return 0.0f;
    }

    @NonNull
    public static EdgeEffect y(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        if (Build.VERSION.SDK_INT >= 31) {
            return n3.y(context, attributeSet);
        }
        return new EdgeEffect(context);
    }

    public static void zn(@NonNull EdgeEffect edgeEffect, float f4, float f6) {
        y.y(edgeEffect, f4, f6);
    }
}
