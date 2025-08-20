package hw;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public final class c5 {

    /* loaded from: classes.dex */
    public static class y {
        public static CharSequence a(MenuItem menuItem) {
            return menuItem.getTooltipText();
        }

        public static MenuItem c5(MenuItem menuItem, ColorStateList colorStateList) {
            return menuItem.setIconTintList(colorStateList);
        }

        public static MenuItem f(MenuItem menuItem, char c2, int i) {
            return menuItem.setNumericShortcut(c2, i);
        }

        public static MenuItem fb(MenuItem menuItem, char c2, int i) {
            return menuItem.setAlphabeticShortcut(c2, i);
        }

        public static PorterDuff.Mode gv(MenuItem menuItem) {
            return menuItem.getIconTintMode();
        }

        public static MenuItem i9(MenuItem menuItem, PorterDuff.Mode mode) {
            return menuItem.setIconTintMode(mode);
        }

        public static CharSequence n3(MenuItem menuItem) {
            return menuItem.getContentDescription();
        }

        public static MenuItem s(MenuItem menuItem, CharSequence charSequence) {
            return menuItem.setContentDescription(charSequence);
        }

        public static MenuItem t(MenuItem menuItem, char c2, char c4, int i, int i5) {
            return menuItem.setShortcut(c2, c4, i, i5);
        }

        public static MenuItem tl(MenuItem menuItem, CharSequence charSequence) {
            return menuItem.setTooltipText(charSequence);
        }

        public static int v(MenuItem menuItem) {
            return menuItem.getNumericModifiers();
        }

        public static int y(MenuItem menuItem) {
            return menuItem.getAlphabeticModifiers();
        }

        public static ColorStateList zn(MenuItem menuItem) {
            return menuItem.getIconTintList();
        }
    }

    public static void a(@NonNull MenuItem menuItem, char c2, int i) {
        if (menuItem instanceof ud.n3) {
            ((ud.n3) menuItem).setNumericShortcut(c2, i);
        } else if (Build.VERSION.SDK_INT >= 26) {
            y.f(menuItem, c2, i);
        }
    }

    public static void fb(@NonNull MenuItem menuItem, @Nullable CharSequence charSequence) {
        if (menuItem instanceof ud.n3) {
            ((ud.n3) menuItem).setTooltipText(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            y.tl(menuItem, charSequence);
        }
    }

    public static void gv(@NonNull MenuItem menuItem, @Nullable ColorStateList colorStateList) {
        if (menuItem instanceof ud.n3) {
            ((ud.n3) menuItem).setIconTintList(colorStateList);
        } else if (Build.VERSION.SDK_INT >= 26) {
            y.c5(menuItem, colorStateList);
        }
    }

    public static void n3(@NonNull MenuItem menuItem, char c2, int i) {
        if (menuItem instanceof ud.n3) {
            ((ud.n3) menuItem).setAlphabeticShortcut(c2, i);
        } else if (Build.VERSION.SDK_INT >= 26) {
            y.fb(menuItem, c2, i);
        }
    }

    public static void v(@NonNull MenuItem menuItem, @Nullable PorterDuff.Mode mode) {
        if (menuItem instanceof ud.n3) {
            ((ud.n3) menuItem).setIconTintMode(mode);
        } else if (Build.VERSION.SDK_INT >= 26) {
            y.i9(menuItem, mode);
        }
    }

    @Nullable
    public static MenuItem y(@NonNull MenuItem menuItem, @Nullable n3 n3Var) {
        if (menuItem instanceof ud.n3) {
            return ((ud.n3) menuItem).y(n3Var);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static void zn(@NonNull MenuItem menuItem, @Nullable CharSequence charSequence) {
        if (menuItem instanceof ud.n3) {
            ((ud.n3) menuItem).setContentDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            y.s(menuItem, charSequence);
        }
    }
}
