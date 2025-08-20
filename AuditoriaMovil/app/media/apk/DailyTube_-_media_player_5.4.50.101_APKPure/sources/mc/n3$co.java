package mc;

import java.util.ArrayList;
import java.util.List;
import mc.n3;
/* loaded from: classes.dex */
public class n3$co {

    /* renamed from: n3  reason: collision with root package name */
    public int f11458n3;
    public List<n3.z> y;

    public n3$co() {
    }

    public boolean a() {
        List<n3.z> list = this.y;
        if (list != null && !list.isEmpty()) {
            return false;
        }
        return true;
    }

    public int fb() {
        List<n3.z> list = this.y;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void gv() {
        this.f11458n3 += 1000000;
    }

    public void n3() {
        this.f11458n3 += 1000;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (n3.z zVar : this.y) {
            sb.append(zVar);
            sb.append(' ');
        }
        sb.append('[');
        sb.append(this.f11458n3);
        sb.append(']');
        return sb.toString();
    }

    public n3.z v(int i) {
        return this.y.get(i);
    }

    public void y(n3.z zVar) {
        if (this.y == null) {
            this.y = new ArrayList();
        }
        this.y.add(zVar);
    }

    public void zn() {
        this.f11458n3++;
    }
}
