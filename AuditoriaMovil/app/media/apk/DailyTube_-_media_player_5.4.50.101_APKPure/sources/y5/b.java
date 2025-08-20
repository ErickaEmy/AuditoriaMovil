package y5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    public final HashMap<String, ud> y = new HashMap<>();

    public final void gv(String str, ud udVar) {
        ud put = this.y.put(str, udVar);
        if (put != null) {
            put.onCleared();
        }
    }

    public final ud n3(String str) {
        return this.y.get(str);
    }

    public final void y() {
        for (ud udVar : this.y.values()) {
            udVar.clear();
        }
        this.y.clear();
    }

    public Set<String> zn() {
        return new HashSet(this.y.keySet());
    }
}
