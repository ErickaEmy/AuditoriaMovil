package hx;

import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class i9 extends gv {
    public float y = -1.0f;

    @Override // hx.gv
    public void y(@NonNull tl tlVar, float f4, float f6, float f9) {
        tlVar.xc(0.0f, f9 * f6, 180.0f, 180.0f - f4);
        float f10 = f9 * 2.0f * f6;
        tlVar.y(0.0f, 0.0f, f10, f10, 180.0f, f4);
    }
}
