package o6;
/* loaded from: classes.dex */
public final class t {
    public static String y(int i, int[] iArr, String[] strArr, int[] iArr2) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        for (int i5 = 0; i5 < i; i5++) {
            int i6 = iArr[i5];
            if (i6 != 1 && i6 != 2) {
                if (i6 == 3 || i6 == 4 || i6 == 5) {
                    sb.append('.');
                    String str = strArr[i5];
                    if (str != null) {
                        sb.append(str);
                    }
                }
            } else {
                sb.append('[');
                sb.append(iArr2[i5]);
                sb.append(']');
            }
        }
        return sb.toString();
    }
}
