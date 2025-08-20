package z0;

import java.io.Serializable;
import w0.xc;
/* loaded from: classes.dex */
public final class j<T> extends yt<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final yt<? super T> forwardOrder;

    public j(yt<? super T> ytVar) {
        this.forwardOrder = (yt) xc.wz(ytVar);
    }

    @Override // z0.yt, java.util.Comparator
    public int compare(T t2, T t3) {
        return this.forwardOrder.compare(t3, t2);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            return this.forwardOrder.equals(((j) obj).forwardOrder);
        }
        return false;
    }

    public int hashCode() {
        return -this.forwardOrder.hashCode();
    }

    @Override // z0.yt
    public <S extends T> yt<S> t() {
        return (yt<? super T>) this.forwardOrder;
    }

    public String toString() {
        String valueOf = String.valueOf(this.forwardOrder);
        StringBuilder sb = new StringBuilder(valueOf.length() + 10);
        sb.append(valueOf);
        sb.append(".reverse()");
        return sb.toString();
    }
}
