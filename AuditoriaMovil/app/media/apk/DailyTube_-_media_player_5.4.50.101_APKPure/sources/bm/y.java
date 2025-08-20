package bm;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.material.tabs.TabLayout;
/* loaded from: classes.dex */
public class y extends com.google.android.material.tabs.y {
    public static float a(float f4) {
        return (float) Math.sin((f4 * 3.141592653589793d) / 2.0d);
    }

    public static float v(float f4) {
        return (float) (1.0d - Math.cos((f4 * 3.141592653589793d) / 2.0d));
    }

    @Override // com.google.android.material.tabs.y
    public void zn(TabLayout tabLayout, View view, View view2, float f4, @NonNull Drawable drawable) {
        float a2;
        float v2;
        RectF y = com.google.android.material.tabs.y.y(tabLayout, view);
        RectF y2 = com.google.android.material.tabs.y.y(tabLayout, view2);
        if (y.left < y2.left) {
            a2 = v(f4);
            v2 = a(f4);
        } else {
            a2 = a(f4);
            v2 = v(f4);
        }
        drawable.setBounds(y6.y.n3((int) y.left, (int) y2.left, a2), drawable.getBounds().top, y6.y.n3((int) y.right, (int) y2.right, v2), drawable.getBounds().bottom);
    }
}
