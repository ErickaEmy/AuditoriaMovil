package zr;

import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import v5.j5;
import z0.d0;
/* loaded from: classes.dex */
public final class n3 {

    /* renamed from: gv  reason: collision with root package name */
    public final Random f15929gv;

    /* renamed from: n3  reason: collision with root package name */
    public final Map<Integer, Long> f15930n3;
    public final Map<String, Long> y;

    /* renamed from: zn  reason: collision with root package name */
    public final Map<List<Pair<String, Integer>>, dq.n3> f15931zn;

    public n3() {
        this(new Random());
    }

    public static int a(List<dq.n3> list) {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < list.size(); i++) {
            hashSet.add(Integer.valueOf(list.get(i).f7371zn));
        }
        return hashSet.size();
    }

    public static int gv(dq.n3 n3Var, dq.n3 n3Var2) {
        int compare = Integer.compare(n3Var.f7371zn, n3Var2.f7371zn);
        if (compare == 0) {
            return n3Var.f7370n3.compareTo(n3Var2.f7370n3);
        }
        return compare;
    }

    public static <T> void n3(T t2, long j2, Map<T, Long> map) {
        if (map.containsKey(t2)) {
            j2 = Math.max(j2, ((Long) j5.i9(map.get(t2))).longValue());
        }
        map.put(t2, Long.valueOf(j2));
    }

    public static <T> void s(long j2, Map<T, Long> map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<T, Long> entry : map.entrySet()) {
            if (entry.getValue().longValue() <= j2) {
                arrayList.add(entry.getKey());
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            map.remove(arrayList.get(i));
        }
    }

    public void c5() {
        this.y.clear();
        this.f15930n3.clear();
        this.f15931zn.clear();
    }

    public final dq.n3 f(List<dq.n3> list) {
        int i = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            i += list.get(i5).f7369gv;
        }
        int nextInt = this.f15929gv.nextInt(i);
        int i6 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            dq.n3 n3Var = list.get(i8);
            i6 += n3Var.f7369gv;
            if (nextInt < i6) {
                return n3Var;
            }
        }
        return (dq.n3) d0.v(list);
    }

    public int fb(List<dq.n3> list) {
        HashSet hashSet = new HashSet();
        List<dq.n3> zn2 = zn(list);
        for (int i = 0; i < zn2.size(); i++) {
            hashSet.add(Integer.valueOf(zn2.get(i).f7371zn));
        }
        return hashSet.size();
    }

    @Nullable
    public dq.n3 i9(List<dq.n3> list) {
        List<dq.n3> zn2 = zn(list);
        if (zn2.size() < 2) {
            return (dq.n3) d0.gv(zn2, null);
        }
        Collections.sort(zn2, new Comparator() { // from class: zr.y
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int gv2;
                gv2 = n3.gv((dq.n3) obj, (dq.n3) obj2);
                return gv2;
            }
        });
        ArrayList arrayList = new ArrayList();
        int i = zn2.get(0).f7371zn;
        int i5 = 0;
        while (true) {
            if (i5 >= zn2.size()) {
                break;
            }
            dq.n3 n3Var = zn2.get(i5);
            if (i != n3Var.f7371zn) {
                if (arrayList.size() == 1) {
                    return zn2.get(0);
                }
            } else {
                arrayList.add(new Pair(n3Var.f7370n3, Integer.valueOf(n3Var.f7369gv)));
                i5++;
            }
        }
        dq.n3 n3Var2 = this.f15931zn.get(arrayList);
        if (n3Var2 == null) {
            dq.n3 f4 = f(zn2.subList(0, arrayList.size()));
            this.f15931zn.put(arrayList, f4);
            return f4;
        }
        return n3Var2;
    }

    public void v(dq.n3 n3Var, long j2) {
        long elapsedRealtime = SystemClock.elapsedRealtime() + j2;
        n3(n3Var.f7370n3, elapsedRealtime, this.y);
        int i = n3Var.f7371zn;
        if (i != Integer.MIN_VALUE) {
            n3(Integer.valueOf(i), elapsedRealtime, this.f15930n3);
        }
    }

    public final List<dq.n3> zn(List<dq.n3> list) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        s(elapsedRealtime, this.y);
        s(elapsedRealtime, this.f15930n3);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            dq.n3 n3Var = list.get(i);
            if (!this.y.containsKey(n3Var.f7370n3) && !this.f15930n3.containsKey(Integer.valueOf(n3Var.f7371zn))) {
                arrayList.add(n3Var);
            }
        }
        return arrayList;
    }

    public n3(Random random) {
        this.f15931zn = new HashMap();
        this.f15929gv = random;
        this.y = new HashMap();
        this.f15930n3 = new HashMap();
    }
}
