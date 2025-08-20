package vn;

import java.util.List;
import uo.zn;
/* loaded from: classes.dex */
public class gv extends fb<Float> {
    public gv(List<uo.y<Float>> list) {
        super(list);
    }

    @Override // vn.y
    /* renamed from: mt */
    public Float c5(uo.y<Float> yVar, float f4) {
        return Float.valueOf(p(yVar, f4));
    }

    public float p(uo.y<Float> yVar, float f4) {
        Float f6;
        if (yVar.n3 != null && yVar.zn != null) {
            zn<A> znVar = this.f14478v;
            if (znVar != 0 && (f6 = (Float) znVar.n3(yVar.fb, yVar.s.floatValue(), (Float) yVar.n3, (Float) yVar.zn, f4, v(), a())) != null) {
                return f6.floatValue();
            }
            return br.fb.c5(yVar.fb(), yVar.gv(), f4);
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }

    public float w() {
        return p(n3(), gv());
    }
}
