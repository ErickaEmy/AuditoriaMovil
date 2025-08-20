package androidx.viewpager2.widget;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
/* loaded from: classes.dex */
public final class y extends ViewPager2.c5 {
    @NonNull
    public final List<ViewPager2.c5> y;

    public y(int i) {
        this.y = new ArrayList(i);
    }

    public void n3(ViewPager2.c5 c5Var) {
        this.y.remove(c5Var);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.c5
    public void onPageScrollStateChanged(int i) {
        try {
            for (ViewPager2.c5 c5Var : this.y) {
                c5Var.onPageScrollStateChanged(i);
            }
        } catch (ConcurrentModificationException e2) {
            zn(e2);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.c5
    public void onPageScrolled(int i, float f4, int i5) {
        try {
            for (ViewPager2.c5 c5Var : this.y) {
                c5Var.onPageScrolled(i, f4, i5);
            }
        } catch (ConcurrentModificationException e2) {
            zn(e2);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.c5
    public void onPageSelected(int i) {
        try {
            for (ViewPager2.c5 c5Var : this.y) {
                c5Var.onPageSelected(i);
            }
        } catch (ConcurrentModificationException e2) {
            zn(e2);
        }
    }

    public void y(ViewPager2.c5 c5Var) {
        this.y.add(c5Var);
    }

    public final void zn(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }
}
