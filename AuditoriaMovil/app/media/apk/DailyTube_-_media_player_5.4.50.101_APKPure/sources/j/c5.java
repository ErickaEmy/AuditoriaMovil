package j;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class c5 {

    /* loaded from: classes.dex */
    public static class y {
        public static void gv(ImageView imageView, PorterDuff.Mode mode) {
            imageView.setImageTintMode(mode);
        }

        public static PorterDuff.Mode n3(ImageView imageView) {
            return imageView.getImageTintMode();
        }

        public static ColorStateList y(ImageView imageView) {
            return imageView.getImageTintList();
        }

        public static void zn(ImageView imageView, ColorStateList colorStateList) {
            imageView.setImageTintList(colorStateList);
        }
    }

    public static void gv(@NonNull ImageView imageView, @Nullable PorterDuff.Mode mode) {
        Drawable drawable;
        int i = Build.VERSION.SDK_INT;
        y.gv(imageView, mode);
        if (i == 21 && (drawable = imageView.getDrawable()) != null && y.y(imageView) != null) {
            if (drawable.isStateful()) {
                drawable.setState(imageView.getDrawableState());
            }
            imageView.setImageDrawable(drawable);
        }
    }

    @Nullable
    public static PorterDuff.Mode n3(@NonNull ImageView imageView) {
        return y.n3(imageView);
    }

    @Nullable
    public static ColorStateList y(@NonNull ImageView imageView) {
        return y.y(imageView);
    }

    public static void zn(@NonNull ImageView imageView, @Nullable ColorStateList colorStateList) {
        Drawable drawable;
        int i = Build.VERSION.SDK_INT;
        y.zn(imageView, colorStateList);
        if (i == 21 && (drawable = imageView.getDrawable()) != null && y.y(imageView) != null) {
            if (drawable.isStateful()) {
                drawable.setState(imageView.getDrawableState());
            }
            imageView.setImageDrawable(drawable);
        }
    }
}
