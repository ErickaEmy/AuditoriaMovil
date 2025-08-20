package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Arrays;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TrieNode.kt */
/* loaded from: classes.dex */
public abstract class TrieNodeKt {
    public static final /* synthetic */ Object[] access$insertEntryAtIndex(Object[] objArr, int i, Object obj, Object obj2) {
        return insertEntryAtIndex(objArr, i, obj, obj2);
    }

    public static final /* synthetic */ Object[] access$removeEntryAtIndex(Object[] objArr, int i) {
        return removeEntryAtIndex(objArr, i);
    }

    public static final /* synthetic */ Object[] access$removeNodeAtIndex(Object[] objArr, int i) {
        return removeNodeAtIndex(objArr, i);
    }

    public static final /* synthetic */ Object[] access$replaceEntryWithNode(Object[] objArr, int i, int i2, TrieNode trieNode) {
        return replaceEntryWithNode(objArr, i, i2, trieNode);
    }

    public static final /* synthetic */ Object[] access$replaceNodeWithEntry(Object[] objArr, int i, int i2, Object obj, Object obj2) {
        return replaceNodeWithEntry(objArr, i, i2, obj, obj2);
    }

    public static final int indexSegment(int i, int i2) {
        return (i >> i2) & 31;
    }

    public static final Object[] insertEntryAtIndex(Object[] objArr, int i, Object obj, Object obj2) {
        Object[] objArr2 = new Object[objArr.length + 2];
        ArraysKt___ArraysJvmKt.copyInto$default(objArr, objArr2, 0, 0, i, 6, (Object) null);
        ArraysKt___ArraysJvmKt.copyInto(objArr, objArr2, i + 2, i, objArr.length);
        objArr2[i] = obj;
        objArr2[i + 1] = obj2;
        return objArr2;
    }

    public static final Object[] replaceEntryWithNode(Object[] objArr, int i, int i2, TrieNode trieNode) {
        Object[] objArr2 = new Object[objArr.length - 1];
        ArraysKt___ArraysJvmKt.copyInto$default(objArr, objArr2, 0, 0, i, 6, (Object) null);
        ArraysKt___ArraysJvmKt.copyInto(objArr, objArr2, i, i + 2, i2);
        objArr2[i2 - 2] = trieNode;
        ArraysKt___ArraysJvmKt.copyInto(objArr, objArr2, i2 - 1, i2, objArr.length);
        return objArr2;
    }

    public static final Object[] replaceNodeWithEntry(Object[] objArr, int i, int i2, Object obj, Object obj2) {
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length + 1);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        ArraysKt___ArraysJvmKt.copyInto(copyOf, copyOf, i + 2, i + 1, objArr.length);
        ArraysKt___ArraysJvmKt.copyInto(copyOf, copyOf, i2 + 2, i2, i);
        copyOf[i2] = obj;
        copyOf[i2 + 1] = obj2;
        return copyOf;
    }

    public static final Object[] removeEntryAtIndex(Object[] objArr, int i) {
        Object[] objArr2 = new Object[objArr.length - 2];
        ArraysKt___ArraysJvmKt.copyInto$default(objArr, objArr2, 0, 0, i, 6, (Object) null);
        ArraysKt___ArraysJvmKt.copyInto(objArr, objArr2, i, i + 2, objArr.length);
        return objArr2;
    }

    public static final Object[] removeNodeAtIndex(Object[] objArr, int i) {
        Object[] objArr2 = new Object[objArr.length - 1];
        ArraysKt___ArraysJvmKt.copyInto$default(objArr, objArr2, 0, 0, i, 6, (Object) null);
        ArraysKt___ArraysJvmKt.copyInto(objArr, objArr2, i, i + 1, objArr.length);
        return objArr2;
    }
}
