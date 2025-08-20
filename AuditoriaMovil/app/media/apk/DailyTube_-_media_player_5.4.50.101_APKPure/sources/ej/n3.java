package ej;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public final class n3 {
    public static /* synthetic */ Bitmap n3(Drawable drawable, int i, int i5, Bitmap.Config config, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = drawable.getIntrinsicWidth();
        }
        if ((i6 & 2) != 0) {
            i5 = drawable.getIntrinsicHeight();
        }
        if ((i6 & 4) != 0) {
            config = null;
        }
        return y(drawable, i, i5, config);
    }

    public static final Bitmap y(Drawable drawable, int i, int i5, Bitmap.Config config) {
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                if (config == null || bitmapDrawable.getBitmap().getConfig() == config) {
                    if (i == bitmapDrawable.getBitmap().getWidth() && i5 == bitmapDrawable.getBitmap().getHeight()) {
                        return bitmapDrawable.getBitmap();
                    }
                    return Bitmap.createScaledBitmap(bitmapDrawable.getBitmap(), i, i5, true);
                }
            } else {
                throw new IllegalArgumentException("bitmap is null");
            }
        }
        Rect bounds = drawable.getBounds();
        int i6 = bounds.left;
        int i8 = bounds.top;
        int i10 = bounds.right;
        int i11 = bounds.bottom;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i5, config);
        drawable.setBounds(0, 0, i, i5);
        drawable.draw(new Canvas(createBitmap));
        drawable.setBounds(i6, i8, i10, i11);
        return createBitmap;
    }
}
