package com.google.android.material.badge;

import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class y {
    public static final boolean y = false;

    public static void gv(@NonNull Rect rect, float f4, float f6, float f9, float f10) {
        rect.set((int) (f4 - f9), (int) (f6 - f10), (int) (f4 + f9), (int) (f6 + f10));
    }

    public static void n3(@Nullable BadgeDrawable badgeDrawable, @NonNull View view) {
        if (badgeDrawable == null) {
            return;
        }
        if (!y && badgeDrawable.s() == null) {
            view.getOverlay().remove(badgeDrawable);
        } else {
            badgeDrawable.s().setForeground(null);
        }
    }

    public static void y(@NonNull BadgeDrawable badgeDrawable, @NonNull View view, @Nullable FrameLayout frameLayout) {
        zn(badgeDrawable, view, frameLayout);
        if (badgeDrawable.s() != null) {
            badgeDrawable.s().setForeground(badgeDrawable);
        } else if (!y) {
            view.getOverlay().add(badgeDrawable);
        } else {
            throw new IllegalArgumentException("Trying to reference null customBadgeParent");
        }
    }

    public static void zn(@NonNull BadgeDrawable badgeDrawable, @NonNull View view, @Nullable FrameLayout frameLayout) {
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        badgeDrawable.setBounds(rect);
        badgeDrawable.n(view, frameLayout);
    }
}
