package ej;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.Gravity;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class zn extends gv {
    public zn(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(@NonNull Outline outline) {
        fb();
        outline.setRoundRect(this.f7604s, n3());
    }

    @Override // ej.gv
    public void zn(int i, int i5, int i6, Rect rect, Rect rect2) {
        Gravity.apply(i, i5, i6, rect, rect2, 0);
    }
}
