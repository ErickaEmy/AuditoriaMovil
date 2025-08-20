package z0;
/* loaded from: classes.dex */
public final class k5 {
    public static <T> T[] gv(T[] tArr, int i) {
        return (T[]) vl.n3(tArr, i);
    }

    public static Object[] n3(Object... objArr) {
        zn(objArr, objArr.length);
        return objArr;
    }

    public static Object y(Object obj, int i) {
        if (obj != null) {
            return obj;
        }
        StringBuilder sb = new StringBuilder(20);
        sb.append("at index ");
        sb.append(i);
        throw new NullPointerException(sb.toString());
    }

    public static Object[] zn(Object[] objArr, int i) {
        for (int i5 = 0; i5 < i; i5++) {
            y(objArr[i5], i5);
        }
        return objArr;
    }
}
