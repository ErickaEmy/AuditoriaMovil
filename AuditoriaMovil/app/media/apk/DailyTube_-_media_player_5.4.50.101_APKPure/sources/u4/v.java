package u4;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.NonNull;
import com.google.android.material.R$attr;
import com.google.android.material.R$integer;
import ur.i9;
/* loaded from: classes.dex */
public class v {
    public static final int[] y = {16843848};

    public static void n3(@NonNull View view, float f4) {
        int integer = view.getResources().getInteger(R$integer.b);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j2 = integer;
        stateListAnimator.addState(new int[]{16842766, R$attr.fhk, -R$attr.fhj}, ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(j2));
        stateListAnimator.addState(new int[]{16842766}, ObjectAnimator.ofFloat(view, "elevation", f4).setDuration(j2));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(0L));
        view.setStateListAnimator(stateListAnimator);
    }

    public static void y(@NonNull View view) {
        view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }

    public static void zn(@NonNull View view, AttributeSet attributeSet, int i, int i5) {
        Context context = view.getContext();
        TypedArray s2 = i9.s(context, attributeSet, y, i, i5, new int[0]);
        try {
            if (s2.hasValue(0)) {
                view.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, s2.getResourceId(0, 0)));
            }
        } finally {
            s2.recycle();
        }
    }
}
