package v5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class i9<E> implements Iterable<E> {
    public final Object y = new Object();

    /* renamed from: v  reason: collision with root package name */
    public final Map<E, Integer> f14356v = new HashMap();

    /* renamed from: fb  reason: collision with root package name */
    public Set<E> f14354fb = Collections.emptySet();

    /* renamed from: s  reason: collision with root package name */
    public List<E> f14355s = Collections.emptyList();

    public Set<E> ct() {
        Set<E> set;
        synchronized (this.y) {
            set = this.f14354fb;
        }
        return set;
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        Iterator<E> it;
        synchronized (this.y) {
            it = this.f14355s.iterator();
        }
        return it;
    }

    public int n3(E e2) {
        int i;
        synchronized (this.y) {
            try {
                if (this.f14356v.containsKey(e2)) {
                    i = this.f14356v.get(e2).intValue();
                } else {
                    i = 0;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    public void y(E e2) {
        synchronized (this.y) {
            try {
                ArrayList arrayList = new ArrayList(this.f14355s);
                arrayList.add(e2);
                this.f14355s = Collections.unmodifiableList(arrayList);
                Integer num = this.f14356v.get(e2);
                if (num == null) {
                    HashSet hashSet = new HashSet(this.f14354fb);
                    hashSet.add(e2);
                    this.f14354fb = Collections.unmodifiableSet(hashSet);
                }
                Map<E, Integer> map = this.f14356v;
                int i = 1;
                if (num != null) {
                    i = 1 + num.intValue();
                }
                map.put(e2, Integer.valueOf(i));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void zn(E e2) {
        synchronized (this.y) {
            try {
                Integer num = this.f14356v.get(e2);
                if (num == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList(this.f14355s);
                arrayList.remove(e2);
                this.f14355s = Collections.unmodifiableList(arrayList);
                if (num.intValue() == 1) {
                    this.f14356v.remove(e2);
                    HashSet hashSet = new HashSet(this.f14354fb);
                    hashSet.remove(e2);
                    this.f14354fb = Collections.unmodifiableSet(hashSet);
                } else {
                    this.f14356v.put(e2, Integer.valueOf(num.intValue() - 1));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
