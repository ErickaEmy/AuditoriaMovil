package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.31  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class AnonymousClass31<K, V> {
    public static int A03;
    public static int A04;
    public static Object[] A05;
    public static Object[] A06;
    public static byte[] A07;
    public static String[] A08 = {"BrVHgBkmBksyBnnjIq0pHnqXAu9AUg3j", "iIth6RrlZFIJsCIcgsKekGbs32ChyRjv", "Uwdt1z4SmD1Mf7UvGeSYdNXOfhFYTYnY", "QITUqyWPG2VnlGrB2a6hYhF3R3KaavLD", "arDW8RiIBmWFNCZvgTvY8WvuJ76u3VTs", "pOGA2rk9V0ZEl", "438Cia9wbNYnLnXWpHR8BTCUnyjltaF2", "slnYcYZFDBEgJMtczrpzy3D6NQdPiCOq"};
    public int[] A01 = AbstractC03342r.A00;
    public Object[] A02 = AbstractC03342r.A02;
    public int A00 = 0;

    public static String A03(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 105);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        if (A08[5].length() == 11) {
            throw new RuntimeException();
        }
        String[] strArr = A08;
        strArr[0] = "Xtbm9MFCOkvOfDux5Me3XhO5K6Bs7EUd";
        strArr[1] = "PZcI0QBOeZ0LYFf6gJzuFWLZdUoY6utj";
        A07 = new byte[]{-69, 7, -5, -4, 6, -77, -32, -12, 3, -68, -62, -74, 3, 5};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final V A0A(int i) {
        int i5;
        Object[] objArr = this.A02;
        V v2 = (V) objArr[(i << 1) + 1];
        int i6 = this.A00;
        if (i6 <= 1) {
            A06(this.A01, objArr, i6);
            this.A01 = AbstractC03342r.A00;
            this.A02 = AbstractC03342r.A02;
            i5 = 0;
        } else {
            i5 = i6 - 1;
            int[] iArr = this.A01;
            if (iArr.length <= 8 || this.A00 >= iArr.length / 3) {
                if (i < i5) {
                    System.arraycopy(iArr, i + 1, iArr, i, i5 - i);
                    Object[] objArr2 = this.A02;
                    System.arraycopy(objArr2, (i + 1) << 1, objArr2, i << 1, (i5 - i) << 1);
                }
                Object[] objArr3 = this.A02;
                objArr3[i5 << 1] = null;
                objArr3[(i5 << 1) + 1] = null;
            } else {
                int i8 = i6 > 8 ? i6 + (i6 >> 1) : 8;
                int[] iArr2 = this.A01;
                Object[] objArr4 = this.A02;
                A05(i8);
                if (i6 != this.A00) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(iArr2, 0, this.A01, 0, i);
                    System.arraycopy(objArr4, 0, this.A02, 0, i << 1);
                }
                if (i < i5) {
                    System.arraycopy(iArr2, i + 1, this.A01, i, i5 - i);
                    System.arraycopy(objArr4, (i + 1) << 1, this.A02, i << 1, (i5 - i) << 1);
                }
            }
        }
        int i10 = this.A00;
        String[] strArr = A08;
        if (strArr[0].charAt(11) != strArr[1].charAt(11)) {
            String[] strArr2 = A08;
            strArr2[0] = "xFHRCOjHDqSI1UlNRZSx5FadcPcGQITj";
            strArr2[1] = "4ZMke5GLOi53P3lo3UgzHK3l5Qzb3367";
            if (i6 == i10) {
                this.A00 = i5;
                return v2;
            }
            throw new ConcurrentModificationException();
        }
        throw new RuntimeException();
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AnonymousClass31) {
            AnonymousClass31 anonymousClass31 = (AnonymousClass31) obj;
            if (size() != anonymousClass31.size()) {
                return false;
            }
            for (int i = 0; i < this.A00; i++) {
                try {
                    K A09 = A09(i);
                    V A0B = A0B(i);
                    Object obj2 = anonymousClass31.get(A09);
                    if (A0B == null) {
                        if (obj2 == null && anonymousClass31.containsKey(A09)) {
                        }
                        return false;
                    } else if (!A0B.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException unused) {
                    return false;
                } catch (NullPointerException unused2) {
                    return false;
                }
            }
            return true;
        } else if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i5 = 0; i5 < this.A00; i5++) {
                try {
                    K A092 = A09(i5);
                    V A0B2 = A0B(i5);
                    Object obj3 = map.get(A092);
                    if (A0B2 == null) {
                        if (obj3 == null && map.containsKey(A092)) {
                        }
                        return false;
                    } else if (!A0B2.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException unused3) {
                    return false;
                } catch (NullPointerException unused4) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final int hashCode() {
        int[] iArr = this.A01;
        Object[] objArr = this.A02;
        int i = 0;
        int i5 = 0;
        int i6 = 1;
        int i8 = this.A00;
        while (i5 < i8) {
            Object obj = objArr[i6];
            i += iArr[i5] ^ (obj == null ? 0 : obj.hashCode());
            i5++;
            i6 += 2;
        }
        return i;
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final V put(K k2, V v2) {
        int hashCode;
        int A01;
        int i = this.A00;
        if (k2 == null) {
            hashCode = 0;
            A01 = A00();
        } else {
            hashCode = k2.hashCode();
            A01 = A01(k2, hashCode);
        }
        if (A01 >= 0) {
            int i5 = (A01 << 1) + 1;
            Object[] objArr = this.A02;
            V v3 = (V) objArr[i5];
            objArr[i5] = v2;
            return v3;
        }
        int i6 = A01 ^ (-1);
        if (i >= this.A01.length) {
            int i8 = 8;
            if (i >= 8) {
                i8 = (i >> 1) + i;
            } else if (i < 4) {
                i8 = 4;
            }
            int[] iArr = this.A01;
            Object[] objArr2 = this.A02;
            A05(i8);
            if (i != this.A00) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.A01;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.A02, 0, objArr2.length);
            }
            A06(iArr, objArr2, i);
        }
        if (i6 < i) {
            int[] iArr3 = this.A01;
            System.arraycopy(iArr3, i6, iArr3, i6 + 1, i - i6);
            Object[] objArr3 = this.A02;
            System.arraycopy(objArr3, i6 << 1, objArr3, (i6 + 1) << 1, (this.A00 - i6) << 1);
        }
        int i10 = this.A00;
        if (i == i10) {
            int[] iArr4 = this.A01;
            if (i6 < iArr4.length) {
                iArr4[i6] = hashCode;
                Object[] objArr4 = this.A02;
                objArr4[i6 << 1] = k2;
                objArr4[(i6 << 1) + 1] = v2;
                this.A00 = i10 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    static {
        A04();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.31 != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    private final int A00() {
        int i = this.A00;
        if (i == 0) {
            return -1;
        }
        int A02 = A02(this.A01, i, 0);
        if (A02 < 0) {
            return A02;
        }
        int N = A02 << 1;
        if (this.A02[N] == null) {
            return A02;
        }
        int i5 = A02 + 1;
        while (i5 < i) {
            int N2 = this.A01[i5];
            if (N2 != 0) {
                break;
            }
            Object[] objArr = this.A02;
            String[] strArr = A08;
            String str = strArr[2];
            String str2 = strArr[4];
            int index = str.charAt(15);
            int N3 = str2.charAt(15);
            if (index != N3) {
                throw new RuntimeException();
            }
            A08[5] = "5BliZlAS3QBBz9o";
            int N4 = i5 << 1;
            if (objArr[N4] == null) {
                return i5;
            }
            i5++;
        }
        for (int end = A02 - 1; end >= 0; end--) {
            int N5 = this.A01[end];
            if (N5 != 0) {
                break;
            }
            int N6 = end << 1;
            if (this.A02[N6] == null) {
                return end;
            }
        }
        int N7 = i5 ^ (-1);
        return N7;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.31 != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    private final int A01(Object obj, int i) {
        int i5 = this.A00;
        if (i5 == 0) {
            if (A08[7].charAt(6) != 'Z') {
                throw new RuntimeException();
            }
            A08[7] = "y399iLZYsEEz0hzdxnUhzykHYZJwaaUE";
            return -1;
        }
        int end = A02(this.A01, i5, i);
        if (end < 0) {
            return end;
        }
        int N = end << 1;
        if (obj.equals(this.A02[N])) {
            return end;
        }
        int i6 = end + 1;
        while (i6 < i5) {
            int N2 = this.A01[i6];
            if (N2 != i) {
                break;
            }
            int N3 = i6 << 1;
            if (obj.equals(this.A02[N3])) {
                return i6;
            }
            i6++;
        }
        for (int end2 = end - 1; end2 >= 0; end2--) {
            int N4 = this.A01[end2];
            if (N4 != i) {
                break;
            }
            int N5 = end2 << 1;
            if (obj.equals(this.A02[N5])) {
                return end2;
            }
        }
        int N6 = i6 ^ (-1);
        return N6;
    }

    public static int A02(int[] iArr, int i, int i5) {
        try {
            return AbstractC03342r.A02(iArr, i, i5);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.31 != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    private void A05(int i) {
        if (i == 8) {
            synchronized (C1157a5.class) {
                Object[] objArr = A06;
                if (objArr != null) {
                    this.A02 = objArr;
                    A06 = (Object[]) objArr[0];
                    this.A01 = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    A04--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (C1157a5.class) {
                Object[] objArr2 = A05;
                if (objArr2 != null) {
                    this.A02 = objArr2;
                    A05 = (Object[]) objArr2[0];
                    this.A01 = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    A03--;
                    return;
                }
            }
        }
        this.A01 = new int[i];
        this.A02 = new Object[i << 1];
    }

    public static void A06(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (C1157a5.class) {
                if (A04 < 10) {
                    objArr[0] = A06;
                    objArr[1] = iArr;
                    for (int i5 = (i << 1) - 1; i5 >= 2; i5--) {
                        objArr[i5] = null;
                    }
                    A06 = objArr;
                    A04++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (C1157a5.class) {
                if (A03 < 10) {
                    objArr[0] = A05;
                    objArr[1] = iArr;
                    for (int i6 = (i << 1) - 1; i6 >= 2; i6--) {
                        objArr[i6] = null;
                    }
                    A05 = objArr;
                    A03++;
                }
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.31 != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    public final int A07(Object obj) {
        int i = this.A00 * 2;
        Object[] objArr = this.A02;
        if (obj == null) {
            for (int i5 = 1; i5 < i; i5 += 2) {
                if (objArr[i5] == null) {
                    int N = i5 >> 1;
                    return N;
                }
            }
            return -1;
        }
        for (int i6 = 1; i6 < i; i6 += 2) {
            if (obj.equals(objArr[i6])) {
                int N2 = i6 >> 1;
                return N2;
            }
        }
        return -1;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.31 != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    public final int A08(Object obj) {
        return obj == null ? A00() : A01(obj, obj.hashCode());
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.31 != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    public final K A09(int i) {
        return (K) this.A02[i << 1];
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.31 != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    public final V A0B(int i) {
        return (V) this.A02[(i << 1) + 1];
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.31 != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    public final V A0C(int i, V v2) {
        int i5 = (i << 1) + 1;
        Object[] objArr = this.A02;
        V v3 = (V) objArr[i5];
        objArr[i5] = v2;
        return v3;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.31 != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    public final void A0D(int i) {
        int i5 = this.A00;
        int osize = this.A01.length;
        if (osize < i) {
            int[] iArr = this.A01;
            Object[] objArr = this.A02;
            A05(i);
            int osize2 = this.A00;
            if (osize2 > 0) {
                System.arraycopy(iArr, 0, this.A01, 0, i5);
                int osize3 = i5 << 1;
                System.arraycopy(objArr, 0, this.A02, 0, osize3);
            }
            A06(iArr, objArr, i5);
        }
        int osize4 = this.A00;
        if (osize4 == i5) {
            return;
        }
        throw new ConcurrentModificationException();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.31 != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    public final void clear() {
        if (this.A00 > 0) {
            int[] iArr = this.A01;
            Object[] objArr = this.A02;
            int i = this.A00;
            int[] ohashes = AbstractC03342r.A00;
            this.A01 = ohashes;
            this.A02 = AbstractC03342r.A02;
            this.A00 = 0;
            A06(iArr, objArr, i);
        }
        if (this.A00 <= 0) {
            return;
        }
        throw new ConcurrentModificationException();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.31 != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    public final boolean containsKey(Object obj) {
        return A08(obj) >= 0;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.31 != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    public final boolean containsValue(Object obj) {
        return A07(obj) >= 0;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.31 != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    public final V get(Object obj) {
        int index = A08(obj);
        if (index >= 0) {
            return (V) this.A02[(index << 1) + 1];
        }
        return null;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.31 != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    public final boolean isEmpty() {
        return this.A00 <= 0;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.31 != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    public final V remove(Object obj) {
        int index = A08(obj);
        if (index >= 0) {
            return A0A(index);
        }
        String[] strArr = A08;
        if (strArr[2].charAt(15) != strArr[4].charAt(15)) {
            throw new RuntimeException();
        }
        A08[5] = "POG7nMkVNzdGaGlGxNMu0E80q";
        return null;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.31 != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    public final int size() {
        return this.A00;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.31 != com.facebook.ads.internal.androidx.support.v4.util.SimpleArrayMap<K, V> */
    public final String toString() {
        if (isEmpty()) {
            return A03(12, 2, 31);
        }
        StringBuilder sb = new StringBuilder(this.A00 * 28);
        sb.append('{');
        for (int i = 0; i < this.A00; i++) {
            if (i > 0) {
                sb.append(A03(10, 2, 45));
            }
            K A09 = A09(i);
            int i5 = A08[5].length();
            if (i5 == 11) {
                throw new RuntimeException();
            }
            String[] strArr = A08;
            strArr[6] = "5MoFeGsxqoTSR8Y6IShdOiE5VevAoRo0";
            strArr[3] = "kGPruxXsJMcA49LPD5OztVvQJS4oto1Y";
            String A032 = A03(0, 10, 42);
            if (A09 != this) {
                sb.append(A09);
            } else {
                sb.append(A032);
            }
            sb.append('=');
            V A0B = A0B(i);
            if (A0B != this) {
                sb.append(A0B);
            } else {
                sb.append(A032);
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
