package d;

import java.lang.reflect.Array;
/* loaded from: classes.dex */
public final class fb {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object[], java.lang.Object] */
    public static <T> T[] n3(T[] tArr, int i, T t2) {
        if (i + 1 > tArr.length) {
            ?? r0 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), zn(i));
            System.arraycopy(tArr, 0, r0, 0, i);
            tArr = r0;
        }
        tArr[i] = t2;
        return tArr;
    }

    public static int[] y(int[] iArr, int i, int i5) {
        if (i + 1 > iArr.length) {
            int[] iArr2 = new int[zn(i)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            iArr = iArr2;
        }
        iArr[i] = i5;
        return iArr;
    }

    public static int zn(int i) {
        if (i <= 4) {
            return 8;
        }
        return i * 2;
    }
}
