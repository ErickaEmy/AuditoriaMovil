package z0;

import java.io.Serializable;
import java.util.Comparator;
import w0.xc;
/* loaded from: classes.dex */
public final class tl<T> extends yt<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final Comparator<T> comparator;

    public tl(Comparator<T> comparator) {
        this.comparator = (Comparator) xc.wz(comparator);
    }

    @Override // z0.yt, java.util.Comparator
    public int compare(T t2, T t3) {
        return this.comparator.compare(t2, t3);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof tl) {
            return this.comparator.equals(((tl) obj).comparator);
        }
        return false;
    }

    public int hashCode() {
        return this.comparator.hashCode();
    }

    public String toString() {
        return this.comparator.toString();
    }
}
