package wz;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.ActionBarContainer;
/* loaded from: classes.dex */
public class n3 extends Drawable {
    public final ActionBarContainer y;

    public n3(ActionBarContainer actionBarContainer) {
        this.y = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.y;
        if (actionBarContainer.f1237p) {
            Drawable drawable = actionBarContainer.f1241w;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f1235f;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        ActionBarContainer actionBarContainer2 = this.y;
        Drawable drawable3 = actionBarContainer2.f1239t;
        if (drawable3 != null && actionBarContainer2.f1234co) {
            drawable3.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(@NonNull Outline outline) {
        ActionBarContainer actionBarContainer = this.y;
        if (actionBarContainer.f1237p) {
            Drawable drawable = actionBarContainer.f1241w;
            if (drawable != null) {
                drawable.getOutline(outline);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f1235f;
        if (drawable2 != null) {
            drawable2.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
