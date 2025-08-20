package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import vl.s;
/* loaded from: classes.dex */
public final class zn implements ViewPager2.f {
    public final int y;

    public zn(int i) {
        s.v(i, "Margin must be non-negative");
        this.y = i;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.f
    public void transformPage(@NonNull View view, float f4) {
        ViewPager2 y = y(view);
        float f6 = this.y * f4;
        if (y.getOrientation() == 0) {
            if (y.gv()) {
                f6 = -f6;
            }
            view.setTranslationX(f6);
            return;
        }
        view.setTranslationY(f6);
    }

    public final ViewPager2 y(@NonNull View view) {
        ViewParent parent = view.getParent();
        ViewParent parent2 = parent.getParent();
        if ((parent instanceof RecyclerView) && (parent2 instanceof ViewPager2)) {
            return (ViewPager2) parent2;
        }
        throw new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
    }
}
