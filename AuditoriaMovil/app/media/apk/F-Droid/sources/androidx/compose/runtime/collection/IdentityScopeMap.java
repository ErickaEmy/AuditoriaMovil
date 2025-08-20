package androidx.compose.runtime.collection;

import androidx.compose.runtime.ActualJvm_jvmKt;
import java.util.Arrays;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: IdentityScopeMap.kt */
/* loaded from: classes.dex */
public final class IdentityScopeMap {
    private IdentityArraySet[] scopeSets;
    private int size;
    private int[] valueOrder;
    private Object[] values;

    public final IdentityArraySet[] getScopeSets() {
        return this.scopeSets;
    }

    public final int getSize() {
        return this.size;
    }

    public final int[] getValueOrder() {
        return this.valueOrder;
    }

    public final Object[] getValues() {
        return this.values;
    }

    public final void setSize(int i) {
        this.size = i;
    }

    public IdentityScopeMap() {
        int[] iArr = new int[50];
        for (int i = 0; i < 50; i++) {
            iArr[i] = i;
        }
        this.valueOrder = iArr;
        this.values = new Object[50];
        this.scopeSets = new IdentityArraySet[50];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IdentityArraySet scopeSetAt(int i) {
        IdentityArraySet identityArraySet = this.scopeSets[this.valueOrder[i]];
        Intrinsics.checkNotNull(identityArraySet);
        return identityArraySet;
    }

    public final boolean add(Object value, Object scope) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(scope, "scope");
        return getOrCreateIdentitySet(value).add(scope);
    }

    public final boolean contains(Object element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return find(element) >= 0;
    }

    private final IdentityArraySet getOrCreateIdentitySet(Object obj) {
        int i;
        int i2 = this.size;
        int[] iArr = this.valueOrder;
        Object[] objArr = this.values;
        IdentityArraySet[] identityArraySetArr = this.scopeSets;
        if (i2 > 0) {
            i = find(obj);
            if (i >= 0) {
                return scopeSetAt(i);
            }
        } else {
            i = -1;
        }
        int i3 = -(i + 1);
        if (i2 < iArr.length) {
            int i4 = iArr[i2];
            objArr[i4] = obj;
            IdentityArraySet identityArraySet = identityArraySetArr[i4];
            if (identityArraySet == null) {
                identityArraySet = new IdentityArraySet();
                identityArraySetArr[i4] = identityArraySet;
            }
            if (i3 < i2) {
                ArraysKt___ArraysJvmKt.copyInto(iArr, iArr, i3 + 1, i3, i2);
            }
            iArr[i3] = i4;
            this.size++;
            return identityArraySet;
        }
        int length = iArr.length * 2;
        Object[] copyOf = Arrays.copyOf(identityArraySetArr, length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        IdentityArraySet[] identityArraySetArr2 = (IdentityArraySet[]) copyOf;
        IdentityArraySet identityArraySet2 = new IdentityArraySet();
        identityArraySetArr2[i2] = identityArraySet2;
        Object[] copyOf2 = Arrays.copyOf(objArr, length);
        Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
        copyOf2[i2] = obj;
        int[] iArr2 = new int[length];
        for (int i5 = i2 + 1; i5 < length; i5++) {
            iArr2[i5] = i5;
        }
        if (i3 < i2) {
            ArraysKt___ArraysJvmKt.copyInto(iArr, iArr2, i3 + 1, i3, i2);
        }
        iArr2[i3] = i2;
        if (i3 > 0) {
            ArraysKt___ArraysJvmKt.copyInto$default(iArr, iArr2, 0, 0, i3, 6, (Object) null);
        }
        this.scopeSets = identityArraySetArr2;
        this.values = copyOf2;
        this.valueOrder = iArr2;
        this.size++;
        return identityArraySet2;
    }

    public final void clear() {
        IdentityArraySet[] identityArraySetArr = this.scopeSets;
        int[] iArr = this.valueOrder;
        Object[] objArr = this.values;
        int length = identityArraySetArr.length;
        for (int i = 0; i < length; i++) {
            IdentityArraySet identityArraySet = identityArraySetArr[i];
            if (identityArraySet != null) {
                identityArraySet.clear();
            }
            iArr[i] = i;
            objArr[i] = null;
        }
        this.size = 0;
    }

    public final boolean remove(Object value, Object scope) {
        int i;
        IdentityArraySet identityArraySet;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(scope, "scope");
        int find = find(value);
        int[] iArr = this.valueOrder;
        IdentityArraySet[] identityArraySetArr = this.scopeSets;
        Object[] objArr = this.values;
        int i2 = this.size;
        if (find < 0 || (identityArraySet = identityArraySetArr[(i = iArr[find])]) == null) {
            return false;
        }
        boolean remove = identityArraySet.remove(scope);
        if (identityArraySet.size() == 0) {
            int i3 = find + 1;
            if (i3 < i2) {
                ArraysKt___ArraysJvmKt.copyInto(iArr, iArr, find, i3, i2);
            }
            int i4 = i2 - 1;
            iArr[i4] = i;
            objArr[i] = null;
            this.size = i4;
        }
        return remove;
    }

    public final void removeScope(Object scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        int[] valueOrder = getValueOrder();
        IdentityArraySet[] scopeSets = getScopeSets();
        Object[] values = getValues();
        int size = getSize();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            int i3 = valueOrder[i2];
            IdentityArraySet identityArraySet = scopeSets[i3];
            Intrinsics.checkNotNull(identityArraySet);
            identityArraySet.remove(scope);
            if (identityArraySet.size() > 0) {
                if (i != i2) {
                    int i4 = valueOrder[i];
                    valueOrder[i] = i3;
                    valueOrder[i2] = i4;
                }
                i++;
            }
        }
        int size2 = getSize();
        for (int i5 = i; i5 < size2; i5++) {
            values[valueOrder[i5]] = null;
        }
        setSize(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int find(Object obj) {
        int identityHashCode = ActualJvm_jvmKt.identityHashCode(obj);
        int i = this.size - 1;
        Object[] objArr = this.values;
        int[] iArr = this.valueOrder;
        int i2 = 0;
        while (i2 <= i) {
            int i3 = (i2 + i) >>> 1;
            Object obj2 = objArr[iArr[i3]];
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
        Object[] objArr = this.values;
        int[] iArr = this.valueOrder;
        for (int i3 = i - 1; -1 < i3; i3--) {
            Object obj2 = objArr[iArr[i3]];
            if (obj2 == obj) {
                return i3;
            }
            if (ActualJvm_jvmKt.identityHashCode(obj2) != i2) {
                break;
            }
        }
        int i4 = i + 1;
        int i5 = this.size;
        while (true) {
            if (i4 >= i5) {
                i4 = this.size;
                break;
            }
            Object obj3 = objArr[iArr[i4]];
            if (obj3 == obj) {
                return i4;
            }
            if (ActualJvm_jvmKt.identityHashCode(obj3) != i2) {
                break;
            }
            i4++;
        }
        return -(i4 + 1);
    }
}
