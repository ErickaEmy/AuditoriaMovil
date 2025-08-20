package androidx.compose.runtime.collection;

import androidx.compose.runtime.ActualJvm_jvmKt;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: IdentityArrayIntMap.kt */
/* loaded from: classes.dex */
public final class IdentityArrayIntMap {
    private int size;
    private Object[] keys = new Object[4];
    private int[] values = new int[4];

    public final Object[] getKeys() {
        return this.keys;
    }

    public final int getSize() {
        return this.size;
    }

    public final int[] getValues() {
        return this.values;
    }

    public final int add(Object key, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(key, "key");
        int[] iArr = this.values;
        if (this.size > 0) {
            i2 = find(key);
            if (i2 >= 0) {
                int i3 = iArr[i2];
                iArr[i2] = i;
                return i3;
            }
        } else {
            i2 = -1;
        }
        int i4 = -(i2 + 1);
        Object[] objArr = this.keys;
        int i5 = this.size;
        if (i5 == objArr.length) {
            Object[] objArr2 = new Object[objArr.length * 2];
            int[] iArr2 = new int[objArr.length * 2];
            int i6 = i4 + 1;
            ArraysKt___ArraysJvmKt.copyInto(objArr, objArr2, i6, i4, i5);
            ArraysKt___ArraysJvmKt.copyInto(iArr, iArr2, i6, i4, i5);
            ArraysKt___ArraysJvmKt.copyInto$default(objArr, objArr2, 0, 0, i4, 6, (Object) null);
            ArraysKt___ArraysJvmKt.copyInto$default(iArr, iArr2, 0, 0, i4, 6, (Object) null);
            this.keys = objArr2;
            this.values = iArr2;
        } else {
            int i7 = i4 + 1;
            ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, i7, i4, i5);
            ArraysKt___ArraysJvmKt.copyInto(iArr, iArr, i7, i4, i5);
        }
        this.keys[i4] = key;
        this.values[i4] = i;
        this.size++;
        return -1;
    }

    private final int find(Object obj) {
        int i = this.size - 1;
        int identityHashCode = ActualJvm_jvmKt.identityHashCode(obj);
        Object[] objArr = this.keys;
        int i2 = 0;
        while (i2 <= i) {
            int i3 = (i2 + i) >>> 1;
            Object obj2 = objArr[i3];
            int identityHashCode2 = ActualJvm_jvmKt.identityHashCode(obj2);
            if (identityHashCode2 < identityHashCode) {
                i2 = i3 + 1;
            } else if (identityHashCode2 <= identityHashCode) {
                return obj2 == obj ? i3 : findExactIndex(i3, obj, identityHashCode);
            } else {
                i = i3 - 1;
            }
        }
        return -(i2 + 1);
    }

    private final int findExactIndex(int i, Object obj, int i2) {
        Object obj2;
        Object[] objArr = this.keys;
        int i3 = this.size;
        for (int i4 = i - 1; -1 < i4; i4--) {
            Object obj3 = objArr[i4];
            if (obj3 == obj) {
                return i4;
            }
            if (ActualJvm_jvmKt.identityHashCode(obj3) != i2) {
                break;
            }
        }
        do {
            i++;
            if (i >= i3) {
                return -(i3 + 1);
            }
            obj2 = objArr[i];
            if (obj2 == obj) {
                return i;
            }
        } while (ActualJvm_jvmKt.identityHashCode(obj2) == i2);
        return -(i + 1);
    }
}
