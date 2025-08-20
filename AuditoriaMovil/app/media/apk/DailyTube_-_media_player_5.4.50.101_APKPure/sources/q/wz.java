package q;

import java.util.Arrays;
import java.util.List;
import uo.y;
/* loaded from: classes.dex */
public abstract class wz<V, O> implements tl<V, O> {
    public final List<y<V>> y;

    public wz(List<y<V>> list) {
        this.y = list;
    }

    @Override // q.tl
    public List<y<V>> n3() {
        return this.y;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.y.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.y.toArray()));
        }
        return sb.toString();
    }

    @Override // q.tl
    public boolean zn() {
        if (this.y.isEmpty()) {
            return true;
        }
        if (this.y.size() == 1 && this.y.get(0).c5()) {
            return true;
        }
        return false;
    }
}
