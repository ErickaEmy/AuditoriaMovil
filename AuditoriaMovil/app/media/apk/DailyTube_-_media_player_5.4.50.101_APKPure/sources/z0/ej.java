package z0;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import w0.xc;
/* loaded from: classes.dex */
public abstract class ej<K0, V0> {

    /* loaded from: classes.dex */
    public static abstract class gv<K0, V0> extends ej<K0, V0> {
        public gv() {
            super(null);
        }

        public abstract <K extends K0, V extends V0> rz<K, V> v();
    }

    /* loaded from: classes.dex */
    public class n3 extends v<K0> {
        public final /* synthetic */ Comparator y;

        public n3(Comparator comparator) {
            this.y = comparator;
        }

        @Override // z0.ej.v
        public <K extends K0, V> Map<K, Collection<V>> zn() {
            return new TreeMap(this.y);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class v<K0> {

        /* loaded from: classes.dex */
        public class y extends gv<K0, Object> {
            public final /* synthetic */ int y;

            public y(int i) {
                this.y = i;
            }

            @Override // z0.ej.gv
            public <K extends K0, V> rz<K, V> v() {
                return ud.n3(v.this.zn(), new zn(this.y));
            }
        }

        public gv<K0, Object> n3(int i) {
            c5.n3(i, "expectedValuesPerKey");
            return new y(i);
        }

        public gv<K0, Object> y() {
            return n3(2);
        }

        public abstract <K extends K0, V> Map<K, Collection<V>> zn();
    }

    /* loaded from: classes.dex */
    public class y extends v<Object> {
        public final /* synthetic */ int y;

        public y(int i) {
            this.y = i;
        }

        @Override // z0.ej.v
        public <K, V> Map<K, Collection<V>> zn() {
            return vl.zn(this.y);
        }
    }

    /* loaded from: classes.dex */
    public static final class zn<V> implements w0.z<List<V>>, Serializable {
        private final int expectedValuesPerKey;

        public zn(int i) {
            this.expectedValuesPerKey = c5.n3(i, "expectedValuesPerKey");
        }

        @Override // w0.z
        /* renamed from: y */
        public List<V> get() {
            return new ArrayList(this.expectedValuesPerKey);
        }
    }

    public /* synthetic */ ej(y yVar) {
        this();
    }

    public static <K0> v<K0> gv(Comparator<K0> comparator) {
        xc.wz(comparator);
        return new n3(comparator);
    }

    public static v<Object> n3(int i) {
        c5.n3(i, "expectedKeys");
        return new y(i);
    }

    public static v<Object> y() {
        return n3(8);
    }

    public static v<Comparable> zn() {
        return gv(yt.v());
    }

    public ej() {
    }
}
