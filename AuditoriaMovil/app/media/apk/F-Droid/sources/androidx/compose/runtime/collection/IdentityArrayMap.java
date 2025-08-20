package androidx.compose.runtime.collection;

import androidx.compose.runtime.ActualJvm_jvmKt;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: IdentityArrayMap.kt */
/* loaded from: classes.dex */
public final class IdentityArrayMap {
    private Object[] keys;
    private int size;
    private Object[] values;

    public final Object[] getKeys() {
        return this.keys;
    }

    public final int getSize() {
        return this.size;
    }

    public final Object[] getValues() {
        return this.values;
    }

    public final boolean isNotEmpty() {
        return this.size > 0;
    }

    public IdentityArrayMap(int i) {
        this.keys = new Object[i];
        this.values = new Object[i];
    }

    public /* synthetic */ IdentityArrayMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 16 : i);
    }

    public final boolean contains(Object key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return find(key) >= 0;
    }

    public final Object get(Object key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int find = find(key);
        if (find >= 0) {
            return this.values[find];
        }
        return null;
    }

    public final void set(Object key, Object obj) {
        Intrinsics.checkNotNullParameter(key, "key");
        Object[] objArr = this.keys;
        Object[] objArr2 = this.values;
        int i = this.size;
        int find = find(key);
        if (find >= 0) {
            objArr2[find] = obj;
            return;
        }
        int i2 = -(find + 1);
        boolean z = i == objArr.length;
        Object[] objArr3 = z ? new Object[i * 2] : objArr;
        int i3 = i2 + 1;
        ArraysKt___ArraysJvmKt.copyInto(objArr, objArr3, i3, i2, i);
        if (z) {
            ArraysKt___ArraysJvmKt.copyInto$default(objArr, objArr3, 0, 0, i2, 6, (Object) null);
        }
        objArr3[i2] = key;
        this.keys = objArr3;
        Object[] objArr4 = z ? new Object[i * 2] : objArr2;
        ArraysKt___ArraysJvmKt.copyInto(objArr2, objArr4, i3, i2, i);
        if (z) {
            ArraysKt___ArraysJvmKt.copyInto$default(objArr2, objArr4, 0, 0, i2, 6, (Object) null);
        }
        objArr4[i2] = obj;
        this.values = objArr4;
        this.size++;
    }

    public final Object remove(Object key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int find = find(key);
        if (find >= 0) {
            Object[] objArr = this.values;
            Object obj = objArr[find];
            int i = this.size;
            Object[] objArr2 = this.keys;
            int i2 = find + 1;
            ArraysKt___ArraysJvmKt.copyInto(objArr2, objArr2, find, i2, i);
            ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, find, i2, i);
            int i3 = i - 1;
            objArr2[i3] = null;
            objArr[i3] = null;
            this.size = i3;
            return obj;
        }
        return null;
    }

    public final void clear() {
        this.size = 0;
        ArraysKt___ArraysJvmKt.fill$default(this.keys, (Object) null, 0, 0, 6, (Object) null);
        ArraysKt___ArraysJvmKt.fill$default(this.values, (Object) null, 0, 0, 6, (Object) null);
    }

    private final int find(Object obj) {
        int identityHashCode = ActualJvm_jvmKt.identityHashCode(obj);
        int i = this.size - 1;
        Object[] objArr = this.keys;
        int i2 = 0;
        while (i2 <= i) {
            int i3 = (i2 + i) >>> 1;
            Object obj2 = objArr[i3];
            int identityHashCode2 = ActualJvm_jvmKt.identityHashCode(obj2);
            if (identityHashCode2 < identityHashCode) {
                i2 = i3 + 1;
            } else if (identityHashCode2 <= identityHashCode) {
                return obj == obj2 ? i3 : findExactIndex(i3, obj, identityHashCode);
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
