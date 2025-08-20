package androidx.viewpager2.widget;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;
/* loaded from: classes.dex */
public final class gv extends ViewPager2.c5 {

    /* renamed from: n3  reason: collision with root package name */
    public ViewPager2.f f3663n3;
    public final LinearLayoutManager y;

    public gv(LinearLayoutManager linearLayoutManager) {
        this.y = linearLayoutManager;
    }

    public void n3(@Nullable ViewPager2.f fVar) {
        this.f3663n3 = fVar;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.c5
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager2.widget.ViewPager2.c5
    public void onPageScrolled(int i, float f4, int i5) {
        if (this.f3663n3 == null) {
            return;
        }
        float f6 = -f4;
        for (int i6 = 0; i6 < this.y.oz(); i6++) {
            View j2 = this.y.j(i6);
            if (j2 != null) {
                this.f3663n3.transformPage(j2, (this.y.ap(j2) - i) + f6);
            } else {
                throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", Integer.valueOf(i6), Integer.valueOf(this.y.oz())));
            }
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.c5
    public void onPageSelected(int i) {
    }

    public ViewPager2.f y() {
        return this.f3663n3;
    }
}
