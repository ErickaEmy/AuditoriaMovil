package w0;

import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public final class p {
    public static <T> w<T> a(w<T> wVar) {
        return new gv(wVar);
    }

    public static String fb(String str, Iterable<?> iterable) {
        StringBuilder sb = new StringBuilder("Predicates.");
        sb.append(str);
        sb.append('(');
        boolean z2 = true;
        for (Object obj : iterable) {
            if (!z2) {
                sb.append(',');
            }
            sb.append(obj);
            z2 = false;
        }
        sb.append(')');
        return sb.toString();
    }

    public static <T> w<T> gv(T t2) {
        if (t2 == null) {
            return v();
        }
        return new zn(t2, (y) null).y();
    }

    public static <T> w<T> n3(w<? super T> wVar, w<? super T> wVar2) {
        return new n3(zn((w) xc.wz(wVar), (w) xc.wz(wVar2)), (y) null);
    }

    public static <T> w<T> v() {
        return v.fb.gv();
    }

    public static <T> List<w<? super T>> zn(w<? super T> wVar, w<? super T> wVar2) {
        return Arrays.asList(wVar, wVar2);
    }
}
