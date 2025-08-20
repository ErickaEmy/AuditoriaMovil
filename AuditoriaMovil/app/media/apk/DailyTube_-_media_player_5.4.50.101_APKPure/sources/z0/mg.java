package z0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import w0.xc;
/* loaded from: classes.dex */
public final class mg {
    public static int a(List<?> list, Object obj) {
        if (list instanceof RandomAccess) {
            return fb(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (w0.f.y(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public static <E> ArrayList<E> c5(Iterator<? extends E> it) {
        ArrayList<E> s2 = s();
        fh.y(s2, it);
        return s2;
    }

    public static int fb(List<?> list, Object obj) {
        if (obj == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
            return -1;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            if (obj.equals(list.get(size2))) {
                return size2;
            }
        }
        return -1;
    }

    public static int gv(List<?> list, Object obj) {
        if (list instanceof RandomAccess) {
            return v(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (w0.f.y(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    @SafeVarargs
    public static <E> ArrayList<E> i9(E... eArr) {
        xc.wz(eArr);
        ArrayList<E> arrayList = new ArrayList<>(n3(eArr.length));
        Collections.addAll(arrayList, eArr);
        return arrayList;
    }

    public static int n3(int i) {
        c5.n3(i, "arraySize");
        return d1.a.tl(i + 5 + (i / 10));
    }

    public static <E> ArrayList<E> s() {
        return new ArrayList<>();
    }

    public static int v(List<?> list, Object obj) {
        int size = list.size();
        int i = 0;
        if (obj == null) {
            while (i < size) {
                if (list.get(i) == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        while (i < size) {
            if (obj.equals(list.get(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static <T> List<T> y(Iterable<T> iterable) {
        return (List) iterable;
    }

    public static boolean zn(List<?> list, Object obj) {
        if (obj == xc.wz(list)) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        if ((list instanceof RandomAccess) && (list2 instanceof RandomAccess)) {
            for (int i = 0; i < size; i++) {
                if (!w0.f.y(list.get(i), list2.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return fh.v(list.iterator(), list2.iterator());
    }
}
