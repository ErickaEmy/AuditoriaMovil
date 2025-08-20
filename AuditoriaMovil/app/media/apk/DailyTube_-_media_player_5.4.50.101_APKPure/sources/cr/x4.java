package cr;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class x4 implements i4 {
    public final ViewOverlay y;

    public x4(@NonNull View view) {
        this.y = view.getOverlay();
    }

    @Override // cr.i4
    public void n3(@NonNull Drawable drawable) {
        this.y.remove(drawable);
    }

    @Override // cr.i4
    public void y(@NonNull Drawable drawable) {
        this.y.add(drawable);
    }
}
