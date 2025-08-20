package y6;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
/* loaded from: classes.dex */
public class y {
    public static final TimeInterpolator y = new LinearInterpolator();

    /* renamed from: n3  reason: collision with root package name */
    public static final TimeInterpolator f15325n3 = new jz.n3();

    /* renamed from: zn  reason: collision with root package name */
    public static final TimeInterpolator f15327zn = new jz.y();

    /* renamed from: gv  reason: collision with root package name */
    public static final TimeInterpolator f15324gv = new jz.zn();

    /* renamed from: v  reason: collision with root package name */
    public static final TimeInterpolator f15326v = new DecelerateInterpolator();

    public static int n3(int i, int i5, float f4) {
        return i + Math.round(f4 * (i5 - i));
    }

    public static float y(float f4, float f6, float f9) {
        return f4 + (f9 * (f6 - f4));
    }
}
