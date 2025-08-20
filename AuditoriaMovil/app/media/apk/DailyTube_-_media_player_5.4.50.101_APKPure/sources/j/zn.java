package j;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public final class zn {

    /* renamed from: n3  reason: collision with root package name */
    public static boolean f9351n3;
    public static Field y;

    /* loaded from: classes.dex */
    public static class n3 {
        public static Drawable y(CompoundButton compoundButton) {
            return compoundButton.getButtonDrawable();
        }
    }

    /* loaded from: classes.dex */
    public static class y {
        public static void gv(CompoundButton compoundButton, PorterDuff.Mode mode) {
            compoundButton.setButtonTintMode(mode);
        }

        public static PorterDuff.Mode n3(CompoundButton compoundButton) {
            return compoundButton.getButtonTintMode();
        }

        public static ColorStateList y(CompoundButton compoundButton) {
            return compoundButton.getButtonTintList();
        }

        public static void zn(CompoundButton compoundButton, ColorStateList colorStateList) {
            compoundButton.setButtonTintList(colorStateList);
        }
    }

    public static void gv(@NonNull CompoundButton compoundButton, @Nullable PorterDuff.Mode mode) {
        y.gv(compoundButton, mode);
    }

    @Nullable
    public static ColorStateList n3(@NonNull CompoundButton compoundButton) {
        return y.y(compoundButton);
    }

    @Nullable
    public static Drawable y(@NonNull CompoundButton compoundButton) {
        if (Build.VERSION.SDK_INT >= 23) {
            return n3.y(compoundButton);
        }
        if (!f9351n3) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                y = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f9351n3 = true;
        }
        Field field = y;
        if (field != null) {
            try {
                return (Drawable) field.get(compoundButton);
            } catch (IllegalAccessException unused2) {
                y = null;
            }
        }
        return null;
    }

    public static void zn(@NonNull CompoundButton compoundButton, @Nullable ColorStateList colorStateList) {
        y.zn(compoundButton, colorStateList);
    }
}
