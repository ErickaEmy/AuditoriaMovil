package androidx.viewpager2.widget;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class n3 implements ViewPager2.f {
    public final List<ViewPager2.f> y = new ArrayList();

    public void n3(@NonNull ViewPager2.f fVar) {
        this.y.remove(fVar);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.f
    public void transformPage(@NonNull View view, float f4) {
        for (ViewPager2.f fVar : this.y) {
            fVar.transformPage(view, f4);
        }
    }

    public void y(@NonNull ViewPager2.f fVar) {
        this.y.add(fVar);
    }
}
