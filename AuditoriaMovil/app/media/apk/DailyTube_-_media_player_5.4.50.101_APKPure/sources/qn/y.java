package qn;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public final class y {

    /* renamed from: qn.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0189y {
        public static Interpolator n3(float f4, float f6, float f9, float f10) {
            return new PathInterpolator(f4, f6, f9, f10);
        }

        public static Interpolator y(float f4, float f6) {
            return new PathInterpolator(f4, f6);
        }

        public static Interpolator zn(Path path) {
            return new PathInterpolator(path);
        }
    }

    @NonNull
    public static Interpolator y(float f4, float f6, float f9, float f10) {
        return C0189y.n3(f4, f6, f9, f10);
    }
}
