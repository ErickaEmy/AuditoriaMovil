package androidx.compose.runtime.internal;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: ThreadMap.kt */
/* loaded from: classes.dex */
public final class ThreadMap {
    private final long[] keys;
    private final int size;
    private final Object[] values;

    public ThreadMap(int i, long[] keys, Object[] values) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        Intrinsics.checkNotNullParameter(values, "values");
        this.size = i;
        this.keys = keys;
        this.values = values;
    }

    public final Object get(long j) {
        int find = find(j);
        if (find >= 0) {
            return this.values[find];
        }
        return null;
    }

    public final boolean trySet(long j, Object obj) {
        int find = find(j);
        if (find < 0) {
            return false;
        }
        this.values[find] = obj;
        return true;
    }

    private final int find(long j) {
        int i = this.size - 1;
        if (i != -1) {
            int i2 = 0;
            if (i == 0) {
                long j2 = this.keys[0];
                if (j2 == j) {
                    return 0;
                }
                return j2 > j ? -2 : -1;
            }
            while (i2 <= i) {
                int i3 = (i2 + i) >>> 1;
                int i4 = ((this.keys[i3] - j) > 0L ? 1 : ((this.keys[i3] - j) == 0L ? 0 : -1));
                if (i4 < 0) {
                    i2 = i3 + 1;
                } else if (i4 <= 0) {
                    return i3;
                } else {
                    i = i3 - 1;
                }
            }
            return -(i2 + 1);
        }
        return -1;
    }

    public final ThreadMap newWith(long j, Object obj) {
        int i = this.size;
        int i2 = 0;
        int i3 = 0;
        for (Object obj2 : this.values) {
            if (obj2 != null) {
                i3++;
            }
        }
        int i4 = i3 + 1;
        long[] jArr = new long[i4];
        Object[] objArr = new Object[i4];
        if (i4 > 1) {
            int i5 = 0;
            while (true) {
                if (i2 >= i4 || i5 >= i) {
                    break;
                }
                long j2 = this.keys[i5];
                Object obj3 = this.values[i5];
                if (j2 > j) {
                    jArr[i2] = j;
                    objArr[i2] = obj;
                    i2++;
                    break;
                }
                if (obj3 != null) {
                    jArr[i2] = j2;
                    objArr[i2] = obj3;
                    i2++;
                }
                i5++;
            }
            if (i5 == i) {
                jArr[i3] = j;
                objArr[i3] = obj;
            } else {
                while (i2 < i4) {
                    long j3 = this.keys[i5];
                    Object obj4 = this.values[i5];
                    if (obj4 != null) {
                        jArr[i2] = j3;
                        objArr[i2] = obj4;
                        i2++;
                    }
                    i5++;
                }
            }
        } else {
            jArr[0] = j;
            objArr[0] = obj;
        }
        return new ThreadMap(i4, jArr, objArr);
    }
}
