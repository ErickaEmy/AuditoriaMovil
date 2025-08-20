package d1;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import w0.xc;
/* loaded from: classes.dex */
public final class a extends fb {

    /* loaded from: classes.dex */
    public static class y extends AbstractList<Integer> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final int[] array;
        final int end;
        final int start;

        public y(int[] iArr) {
            this(iArr, 0, iArr.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            if ((obj instanceof Integer) && a.i9(this.array, ((Integer) obj).intValue(), this.start, this.end) != -1) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof y) {
                y yVar = (y) obj;
                int size = size();
                if (yVar.size() != size) {
                    return false;
                }
                for (int i = 0; i < size; i++) {
                    if (this.array[this.start + i] != yVar.array[yVar.start + i]) {
                        return false;
                    }
                }
                return true;
            }
            return super.equals(obj);
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: gv */
        public Integer set(int i, Integer num) {
            xc.t(i, size());
            int[] iArr = this.array;
            int i5 = this.start;
            int i6 = iArr[i5 + i];
            iArr[i5 + i] = ((Integer) xc.wz(num)).intValue();
            return Integer.valueOf(i6);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int i = 1;
            for (int i5 = this.start; i5 < this.end; i5++) {
                i = (i * 31) + a.s(this.array[i5]);
            }
            return i;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int i92;
            if ((obj instanceof Integer) && (i92 = a.i9(this.array, ((Integer) obj).intValue(), this.start, this.end)) >= 0) {
                return i92 - this.start;
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int f4;
            if ((obj instanceof Integer) && (f4 = a.f(this.array, ((Integer) obj).intValue(), this.start, this.end)) >= 0) {
                return f4 - this.start;
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Integer> subList(int i, int i5) {
            xc.mt(i, i5, size());
            if (i == i5) {
                return Collections.emptyList();
            }
            int[] iArr = this.array;
            int i6 = this.start;
            return new y(iArr, i + i6, i6 + i5);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 5);
            sb.append('[');
            sb.append(this.array[this.start]);
            int i = this.start;
            while (true) {
                i++;
                if (i < this.end) {
                    sb.append(", ");
                    sb.append(this.array[i]);
                } else {
                    sb.append(']');
                    return sb.toString();
                }
            }
        }

        public int[] v() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: y */
        public Integer get(int i) {
            xc.t(i, size());
            return Integer.valueOf(this.array[this.start + i]);
        }

        public y(int[] iArr, int i, int i5) {
            this.array = iArr;
            this.start = i;
            this.end = i5;
        }
    }

    public static int a(int i, int i5, int i6) {
        boolean z2;
        if (i5 <= i6) {
            z2 = true;
        } else {
            z2 = false;
        }
        xc.fb(z2, "min (%s) must be less than or equal to max (%s)", i5, i6);
        return Math.min(Math.max(i, i5), i6);
    }

    public static int c5(int[] iArr, int i) {
        return i9(iArr, i, 0, iArr.length);
    }

    public static int f(int[] iArr, int i, int i5, int i6) {
        for (int i8 = i6 - 1; i8 >= i5; i8--) {
            if (iArr[i8] == i) {
                return i8;
            }
        }
        return -1;
    }

    public static int fb(byte b2, byte b3, byte b4, byte b5) {
        return (b2 << 24) | ((b3 & 255) << 16) | ((b4 & 255) << 8) | (b5 & 255);
    }

    public static int gv(long j2) {
        boolean z2;
        int i = (int) j2;
        if (i == j2) {
            z2 = true;
        } else {
            z2 = false;
        }
        xc.c5(z2, "Out of range: %s", j2);
        return i;
    }

    public static int i9(int[] iArr, int i, int i5, int i6) {
        while (i5 < i6) {
            if (iArr[i5] == i) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    public static int t(int... iArr) {
        boolean z2;
        if (iArr.length > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        xc.gv(z2);
        int i = iArr[0];
        for (int i5 = 1; i5 < iArr.length; i5++) {
            int i6 = iArr[i5];
            if (i6 < i) {
                i = i6;
            }
        }
        return i;
    }

    public static int tl(long j2) {
        if (j2 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j2 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j2;
    }

    public static int v(int i, int i5) {
        if (i < i5) {
            return -1;
        }
        if (i > i5) {
            return 1;
        }
        return 0;
    }

    public static int[] wz(Collection<? extends Number> collection) {
        if (collection instanceof y) {
            return ((y) collection).v();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = ((Number) xc.wz(array[i])).intValue();
        }
        return iArr;
    }

    public static List<Integer> zn(int... iArr) {
        if (iArr.length == 0) {
            return Collections.emptyList();
        }
        return new y(iArr);
    }

    public static int s(int i) {
        return i;
    }
}
