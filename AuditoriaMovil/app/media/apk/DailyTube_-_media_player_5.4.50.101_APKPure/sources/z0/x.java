package z0;

import java.io.Serializable;
import w0.xc;
/* loaded from: classes.dex */
public final class x extends yt<Comparable<?>> implements Serializable {
    private static final long serialVersionUID = 0;
    public static final x y = new x();

    private Object readResolve() {
        return y;
    }

    @Override // z0.yt, java.util.Comparator
    /* renamed from: p */
    public int compare(Comparable<?> comparable, Comparable<?> comparable2) {
        xc.wz(comparable);
        xc.wz(comparable2);
        return comparable.compareTo(comparable2);
    }

    @Override // z0.yt
    public <S extends Comparable<?>> yt<S> t() {
        return o.y;
    }

    public String toString() {
        return "Ordering.natural()";
    }
}
