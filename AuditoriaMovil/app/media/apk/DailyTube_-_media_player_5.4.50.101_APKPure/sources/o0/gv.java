package o0;

import android.content.Context;
import android.content.res.Resources;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class gv {
    public static Interpolator y(Context context, int i) throws Resources.NotFoundException {
        return AnimationUtils.loadInterpolator(context, i);
    }
}
