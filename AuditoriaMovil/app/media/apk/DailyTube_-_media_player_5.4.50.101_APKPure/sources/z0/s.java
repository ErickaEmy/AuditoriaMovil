package z0;

import java.io.Serializable;
import w0.fb;
import w0.xc;
/* loaded from: classes.dex */
public final class s<F, T> extends yt<F> implements Serializable {
    private static final long serialVersionUID = 0;
    final fb<F, ? extends T> function;
    final yt<T> ordering;

    public s(fb<F, ? extends T> fbVar, yt<T> ytVar) {
        this.function = (fb) xc.wz(fbVar);
        this.ordering = (yt) xc.wz(ytVar);
    }

    @Override // z0.yt, java.util.Comparator
    public int compare(F f4, F f6) {
        return this.ordering.compare(this.function.apply(f4), this.function.apply(f6));
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        if (this.function.equals(sVar.function) && this.ordering.equals(sVar.ordering)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return w0.f.n3(this.function, this.ordering);
    }

    public String toString() {
        String valueOf = String.valueOf(this.ordering);
        String valueOf2 = String.valueOf(this.function);
        StringBuilder sb = new StringBuilder(valueOf.length() + 13 + valueOf2.length());
        sb.append(valueOf);
        sb.append(".onResultOf(");
        sb.append(valueOf2);
        sb.append(")");
        return sb.toString();
    }
}
