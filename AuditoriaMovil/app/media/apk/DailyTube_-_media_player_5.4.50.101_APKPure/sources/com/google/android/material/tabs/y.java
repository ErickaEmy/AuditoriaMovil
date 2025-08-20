package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.tabs.TabLayout;
import ur.f;
/* loaded from: classes.dex */
public class y {
    public static RectF n3(@NonNull TabLayout.c5 c5Var, int i) {
        int contentWidth = c5Var.getContentWidth();
        int contentHeight = c5Var.getContentHeight();
        int n32 = (int) f.n3(c5Var.getContext(), i);
        if (contentWidth < n32) {
            contentWidth = n32;
        }
        int left = (c5Var.getLeft() + c5Var.getRight()) / 2;
        int top = (c5Var.getTop() + c5Var.getBottom()) / 2;
        int i5 = contentWidth / 2;
        return new RectF(left - i5, top - (contentHeight / 2), i5 + left, top + (left / 2));
    }

    public static RectF y(TabLayout tabLayout, @Nullable View view) {
        if (view == null) {
            return new RectF();
        }
        if (!tabLayout.c() && (view instanceof TabLayout.c5)) {
            return n3((TabLayout.c5) view, 24);
        }
        return new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    public void gv(TabLayout tabLayout, View view, @NonNull Drawable drawable) {
        RectF y = y(tabLayout, view);
        drawable.setBounds((int) y.left, drawable.getBounds().top, (int) y.right, drawable.getBounds().bottom);
    }

    public void zn(TabLayout tabLayout, View view, View view2, float f4, @NonNull Drawable drawable) {
        RectF y = y(tabLayout, view);
        RectF y2 = y(tabLayout, view2);
        drawable.setBounds(y6.y.n3((int) y.left, (int) y2.left, f4), drawable.getBounds().top, y6.y.n3((int) y.right, (int) y2.right, f4), drawable.getBounds().bottom);
    }
}
