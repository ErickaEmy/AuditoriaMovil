package cr;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class co implements z {
    public final ViewGroupOverlay y;

    public co(@NonNull ViewGroup viewGroup) {
        this.y = viewGroup.getOverlay();
    }

    @Override // cr.z
    public void gv(@NonNull View view) {
        this.y.remove(view);
    }

    @Override // cr.i4
    public void n3(@NonNull Drawable drawable) {
        this.y.remove(drawable);
    }

    @Override // cr.i4
    public void y(@NonNull Drawable drawable) {
        this.y.add(drawable);
    }

    @Override // cr.z
    public void zn(@NonNull View view) {
        this.y.add(view);
    }
}
