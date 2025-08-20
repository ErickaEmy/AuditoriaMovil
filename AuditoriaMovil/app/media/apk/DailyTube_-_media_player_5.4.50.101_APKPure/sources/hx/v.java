package hx;

import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class v extends gv {
    public float y = -1.0f;

    @Override // hx.gv
    public void y(@NonNull tl tlVar, float f4, float f6, float f9) {
        tlVar.xc(0.0f, f9 * f6, 180.0f, 180.0f - f4);
        double d2 = f9;
        double d3 = f6;
        tlVar.tl((float) (Math.sin(Math.toRadians(f4)) * d2 * d3), (float) (Math.sin(Math.toRadians(90.0f - f4)) * d2 * d3));
    }
}
