package lc;

import androidx.annotation.NonNull;
import androidx.lifecycle.wz;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import y5.b;
import y5.ud;
/* loaded from: classes.dex */
public class s extends ud {

    /* renamed from: v  reason: collision with root package name */
    public static final wz.n3 f10296v = new y();
    public final HashMap<UUID, b> y = new HashMap<>();

    /* loaded from: classes.dex */
    public class y implements wz.n3 {
        @Override // androidx.lifecycle.wz.n3
        @NonNull
        public <T extends ud> T create(@NonNull Class<T> cls) {
            return new s();
        }
    }

    @NonNull
    public static s el(b bVar) {
        return (s) new wz(bVar, f10296v).y(s.class);
    }

    @NonNull
    public b g6(@NonNull UUID uuid) {
        b bVar = this.y.get(uuid);
        if (bVar == null) {
            b bVar2 = new b();
            this.y.put(uuid, bVar2);
            return bVar2;
        }
        return bVar;
    }

    @Override // y5.ud
    public void onCleared() {
        for (b bVar : this.y.values()) {
            bVar.y();
        }
        this.y.clear();
    }

    public void st(@NonNull UUID uuid) {
        b remove = this.y.remove(uuid);
        if (remove != null) {
            remove.y();
        }
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("NavControllerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} ViewModelStores (");
        Iterator<UUID> it = this.y.keySet().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
