package hx;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class y implements zn {
    public final float y;

    public y(float f4) {
        this.y = f4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof y) && this.y == ((y) obj).y) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.y)});
    }

    @Override // hx.zn
    public float y(@NonNull RectF rectF) {
        return this.y;
    }
}
