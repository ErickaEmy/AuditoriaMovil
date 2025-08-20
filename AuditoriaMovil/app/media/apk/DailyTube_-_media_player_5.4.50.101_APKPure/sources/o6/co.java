package o6;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import o6.a;
/* loaded from: classes.dex */
public final class co {

    /* renamed from: v  reason: collision with root package name */
    public static final List<a.y> f12145v;

    /* renamed from: n3  reason: collision with root package name */
    public final int f12147n3;
    public final List<a.y> y;

    /* renamed from: zn  reason: collision with root package name */
    public final ThreadLocal<zn> f12148zn = new ThreadLocal<>();

    /* renamed from: gv  reason: collision with root package name */
    public final Map<Object, a<?>> f12146gv = new LinkedHashMap();

    /* loaded from: classes.dex */
    public static final class n3<T> extends a<T> {

        /* renamed from: gv  reason: collision with root package name */
        public a<T> f12149gv;

        /* renamed from: n3  reason: collision with root package name */
        public final String f12150n3;
        public final Type y;

        /* renamed from: zn  reason: collision with root package name */
        public final Object f12151zn;

        public n3(Type type, String str, Object obj) {
            this.y = type;
            this.f12150n3 = str;
            this.f12151zn = obj;
        }

        @Override // o6.a
        public void a(w wVar, T t2) throws IOException {
            a<T> aVar = this.f12149gv;
            if (aVar != null) {
                aVar.a(wVar, t2);
                return;
            }
            throw new IllegalStateException("JsonAdapter isn't ready");
        }

        @Override // o6.a
        public T n3(f fVar) throws IOException {
            a<T> aVar = this.f12149gv;
            if (aVar != null) {
                return aVar.n3(fVar);
            }
            throw new IllegalStateException("JsonAdapter isn't ready");
        }

        public String toString() {
            a<T> aVar = this.f12149gv;
            if (aVar != null) {
                return aVar.toString();
            }
            return super.toString();
        }
    }

    /* loaded from: classes.dex */
    public static final class y {
        public final List<a.y> y = new ArrayList();

        /* renamed from: n3  reason: collision with root package name */
        public int f12152n3 = 0;

        public co y() {
            return new co(this);
        }
    }

    /* loaded from: classes.dex */
    public final class zn {

        /* renamed from: zn  reason: collision with root package name */
        public boolean f12155zn;
        public final List<n3<?>> y = new ArrayList();

        /* renamed from: n3  reason: collision with root package name */
        public final Deque<n3<?>> f12154n3 = new ArrayDeque();

        public zn() {
        }

        public <T> a<T> gv(Type type, String str, Object obj) {
            int size = this.y.size();
            for (int i = 0; i < size; i++) {
                n3<?> n3Var = this.y.get(i);
                if (n3Var.f12151zn.equals(obj)) {
                    this.f12154n3.add(n3Var);
                    a<T> aVar = (a<T>) n3Var.f12149gv;
                    if (aVar != null) {
                        return aVar;
                    }
                    return n3Var;
                }
            }
            n3<?> n3Var2 = new n3<>(type, str, obj);
            this.y.add(n3Var2);
            this.f12154n3.add(n3Var2);
            return null;
        }

        public IllegalArgumentException n3(IllegalArgumentException illegalArgumentException) {
            if (this.f12155zn) {
                return illegalArgumentException;
            }
            this.f12155zn = true;
            if (this.f12154n3.size() == 1 && this.f12154n3.getFirst().f12150n3 == null) {
                return illegalArgumentException;
            }
            StringBuilder sb = new StringBuilder(illegalArgumentException.getMessage());
            Iterator<n3<?>> descendingIterator = this.f12154n3.descendingIterator();
            while (descendingIterator.hasNext()) {
                n3<?> next = descendingIterator.next();
                sb.append("\nfor ");
                sb.append(next.y);
                if (next.f12150n3 != null) {
                    sb.append(' ');
                    sb.append(next.f12150n3);
                }
            }
            return new IllegalArgumentException(sb.toString(), illegalArgumentException);
        }

        public <T> void y(a<T> aVar) {
            this.f12154n3.getLast().f12149gv = aVar;
        }

        public void zn(boolean z2) {
            this.f12154n3.removeLast();
            if (!this.f12154n3.isEmpty()) {
                return;
            }
            co.this.f12148zn.remove();
            if (z2) {
                synchronized (co.this.f12146gv) {
                    try {
                        int size = this.y.size();
                        for (int i = 0; i < size; i++) {
                            n3<?> n3Var = this.y.get(i);
                            a<T> aVar = (a) co.this.f12146gv.put(n3Var.f12151zn, n3Var.f12149gv);
                            if (aVar != 0) {
                                n3Var.f12149gv = aVar;
                                co.this.f12146gv.put(n3Var.f12151zn, aVar);
                            }
                        }
                    } finally {
                    }
                }
            }
        }
    }

    static {
        ArrayList arrayList = new ArrayList(5);
        f12145v = arrayList;
        arrayList.add(r.y);
        arrayList.add(gv.f12172n3);
        arrayList.add(mt.f12173zn);
        arrayList.add(o6.y.f12234zn);
        arrayList.add(z.y);
        arrayList.add(o6.zn.f12236gv);
    }

    public co(y yVar) {
        int size = yVar.y.size();
        List<a.y> list = f12145v;
        ArrayList arrayList = new ArrayList(size + list.size());
        arrayList.addAll(yVar.y);
        arrayList.addAll(list);
        this.y = Collections.unmodifiableList(arrayList);
        this.f12147n3 = yVar.f12152n3;
    }

    public <T> a<T> a(Type type, Set<? extends Annotation> set, String str) {
        if (type != null) {
            if (set != null) {
                Type xc2 = p6.n3.xc(p6.n3.y(type));
                Object fb2 = fb(xc2, set);
                synchronized (this.f12146gv) {
                    try {
                        a<T> aVar = (a<T>) this.f12146gv.get(fb2);
                        if (aVar != null) {
                            return aVar;
                        }
                        zn znVar = this.f12148zn.get();
                        if (znVar == null) {
                            znVar = new zn();
                            this.f12148zn.set(znVar);
                        }
                        a<T> gv2 = znVar.gv(xc2, str, fb2);
                        try {
                            if (gv2 != null) {
                                return gv2;
                            }
                            try {
                                int size = this.y.size();
                                for (int i = 0; i < size; i++) {
                                    a<T> aVar2 = (a<T>) this.y.get(i).y(xc2, set, this);
                                    if (aVar2 != null) {
                                        znVar.y(aVar2);
                                        znVar.zn(true);
                                        return aVar2;
                                    }
                                }
                                throw new IllegalArgumentException("No JsonAdapter for " + p6.n3.z(xc2, set));
                            } catch (IllegalArgumentException e2) {
                                throw znVar.n3(e2);
                            }
                        } finally {
                            znVar.zn(false);
                        }
                    } finally {
                    }
                }
            }
            throw new NullPointerException("annotations == null");
        }
        throw new NullPointerException("type == null");
    }

    public final Object fb(Type type, Set<? extends Annotation> set) {
        if (set.isEmpty()) {
            return type;
        }
        return Arrays.asList(type, set);
    }

    public <T> a<T> gv(Type type) {
        return v(type, p6.n3.y);
    }

    public <T> a<T> v(Type type, Set<? extends Annotation> set) {
        return a(type, set, null);
    }

    public <T> a<T> zn(Class<T> cls) {
        return v(cls, p6.n3.y);
    }
}
