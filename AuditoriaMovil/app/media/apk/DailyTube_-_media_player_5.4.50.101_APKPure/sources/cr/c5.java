package cr;

import android.animation.TypeEvaluator;
import android.graphics.Rect;
/* loaded from: classes.dex */
public class c5 implements TypeEvaluator<Rect> {
    public Rect y;

    @Override // android.animation.TypeEvaluator
    /* renamed from: y */
    public Rect evaluate(float f4, Rect rect, Rect rect2) {
        int i = rect.left;
        int i5 = i + ((int) ((rect2.left - i) * f4));
        int i6 = rect.top;
        int i8 = i6 + ((int) ((rect2.top - i6) * f4));
        int i10 = rect.right;
        int i11 = i10 + ((int) ((rect2.right - i10) * f4));
        int i12 = rect.bottom;
        int i13 = i12 + ((int) ((rect2.bottom - i12) * f4));
        Rect rect3 = this.y;
        if (rect3 == null) {
            return new Rect(i5, i8, i11, i13);
        }
        rect3.set(i5, i8, i11, i13);
        return this.y;
    }
}
