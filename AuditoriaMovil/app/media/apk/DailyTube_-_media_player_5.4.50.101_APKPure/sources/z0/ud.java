package z0;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import w0.xc;
/* loaded from: classes.dex */
public final class ud {

    /* loaded from: classes.dex */
    public static abstract class n3<K, V> extends AbstractCollection<Map.Entry<K, V>> {
        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            y().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return y().v(entry.getKey(), entry.getValue());
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return y().remove(entry.getKey(), entry.getValue());
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return y().size();
        }

        public abstract z6<K, V> y();
    }

    /* loaded from: classes.dex */
    public static class y<K, V> extends zn<K, V> {
        private static final long serialVersionUID = 0;

        /* renamed from: w  reason: collision with root package name */
        public transient w0.z<? extends List<V>> f15640w;

        public y(Map<K, Collection<V>> map, w0.z<? extends List<V>> zVar) {
            super(map);
            this.f15640w = (w0.z) xc.wz(zVar);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.f15640w = (w0.z) objectInputStream.readObject();
            dm((Map) objectInputStream.readObject());
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.f15640w);
            objectOutputStream.writeObject(yt());
        }

        @Override // z0.gv
        /* renamed from: ra */
        public List<V> j5() {
            return this.f15640w.get();
        }

        @Override // z0.a
        public Map<K, Collection<V>> s() {
            return j();
        }

        @Override // z0.a
        public Set<K> t() {
            return k();
        }
    }

    public static <K, V> rz<K, V> n3(Map<K, Collection<V>> map, w0.z<? extends List<V>> zVar) {
        return new y(map, zVar);
    }

    public static boolean y(z6<?, ?> z6Var, Object obj) {
        if (obj == z6Var) {
            return true;
        }
        if (obj instanceof z6) {
            return z6Var.gv().equals(((z6) obj).gv());
        }
        return false;
    }
}
