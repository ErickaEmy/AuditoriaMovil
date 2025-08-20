package ej;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public final class y {

    /* renamed from: gv  reason: collision with root package name */
    public static boolean f7618gv;

    /* renamed from: n3  reason: collision with root package name */
    public static boolean f7619n3;
    public static Method y;

    /* renamed from: zn  reason: collision with root package name */
    public static Method f7620zn;

    /* loaded from: classes.dex */
    public static class n3 {
        public static void a(Drawable drawable, int i, int i5, int i6, int i8) {
            drawable.setHotspotBounds(i, i5, i6, i8);
        }

        public static void c5(Drawable drawable, PorterDuff.Mode mode) {
            drawable.setTintMode(mode);
        }

        public static void fb(Drawable drawable, int i) {
            drawable.setTint(i);
        }

        public static void gv(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        }

        public static boolean n3(Drawable drawable) {
            return drawable.canApplyTheme();
        }

        public static void s(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        public static void v(Drawable drawable, float f4, float f6) {
            drawable.setHotspot(f4, f6);
        }

        public static void y(Drawable drawable, Resources.Theme theme) {
            drawable.applyTheme(theme);
        }

        public static ColorFilter zn(Drawable drawable) {
            return drawable.getColorFilter();
        }
    }

    /* renamed from: ej.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0091y {
        public static boolean gv(Drawable drawable) {
            return drawable.isAutoMirrored();
        }

        public static Drawable n3(DrawableContainer.DrawableContainerState drawableContainerState, int i) {
            return drawableContainerState.getChild(i);
        }

        public static void v(Drawable drawable, boolean z2) {
            drawable.setAutoMirrored(z2);
        }

        public static int y(Drawable drawable) {
            return drawable.getAlpha();
        }

        public static Drawable zn(InsetDrawable insetDrawable) {
            return insetDrawable.getDrawable();
        }
    }

    /* loaded from: classes.dex */
    public static class zn {
        public static boolean n3(Drawable drawable, int i) {
            return drawable.setLayoutDirection(i);
        }

        public static int y(Drawable drawable) {
            return drawable.getLayoutDirection();
        }
    }

    public static int a(@NonNull Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23) {
            return zn.y(drawable);
        }
        if (!f7618gv) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", null);
                f7620zn = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            f7618gv = true;
        }
        Method method = f7620zn;
        if (method != null) {
            try {
                return ((Integer) method.invoke(drawable, null)).intValue();
            } catch (Exception unused2) {
                f7620zn = null;
                return 0;
            }
        }
        return 0;
    }

    @Deprecated
    public static void c5(@NonNull Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static void f(@NonNull Drawable drawable, float f4, float f6) {
        n3.v(drawable, f4, f6);
    }

    public static void fb(@NonNull Drawable drawable, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        n3.gv(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    public static int gv(@NonNull Drawable drawable) {
        return C0091y.y(drawable);
    }

    public static void i9(@NonNull Drawable drawable, boolean z2) {
        C0091y.v(drawable, z2);
    }

    @NonNull
    public static Drawable mt(@NonNull Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23) {
            return drawable;
        }
        if (!(drawable instanceof a)) {
            return new c5(drawable);
        }
        return drawable;
    }

    public static boolean n3(@NonNull Drawable drawable) {
        return n3.n3(drawable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Drawable> T p(@NonNull Drawable drawable) {
        if (drawable instanceof fb) {
            return (T) ((fb) drawable).y();
        }
        return drawable;
    }

    public static boolean s(@NonNull Drawable drawable) {
        return C0091y.gv(drawable);
    }

    public static void t(@NonNull Drawable drawable, int i, int i5, int i6, int i8) {
        n3.a(drawable, i, i5, i6, i8);
    }

    public static boolean tl(@NonNull Drawable drawable, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return zn.n3(drawable, i);
        }
        if (!f7619n3) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                y = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            f7619n3 = true;
        }
        Method method = y;
        if (method != null) {
            try {
                method.invoke(drawable, Integer.valueOf(i));
                return true;
            } catch (Exception unused2) {
                y = null;
            }
        }
        return false;
    }

    @Nullable
    public static ColorFilter v(@NonNull Drawable drawable) {
        return n3.zn(drawable);
    }

    public static void w(@NonNull Drawable drawable, @Nullable PorterDuff.Mode mode) {
        n3.c5(drawable, mode);
    }

    public static void wz(@NonNull Drawable drawable, int i) {
        n3.fb(drawable, i);
    }

    public static void xc(@NonNull Drawable drawable, @Nullable ColorStateList colorStateList) {
        n3.s(drawable, colorStateList);
    }

    public static void y(@NonNull Drawable drawable, @NonNull Resources.Theme theme) {
        n3.y(drawable, theme);
    }

    public static void zn(@NonNull Drawable drawable) {
        DrawableContainer.DrawableContainerState drawableContainerState;
        if (Build.VERSION.SDK_INT >= 23) {
            drawable.clearColorFilter();
            return;
        }
        drawable.clearColorFilter();
        if (drawable instanceof InsetDrawable) {
            zn(C0091y.zn((InsetDrawable) drawable));
        } else if (drawable instanceof fb) {
            zn(((fb) drawable).y());
        } else if ((drawable instanceof DrawableContainer) && (drawableContainerState = (DrawableContainer.DrawableContainerState) ((DrawableContainer) drawable).getConstantState()) != null) {
            int childCount = drawableContainerState.getChildCount();
            for (int i = 0; i < childCount; i++) {
                Drawable n32 = C0091y.n3(drawableContainerState, i);
                if (n32 != null) {
                    zn(n32);
                }
            }
        }
    }
}
