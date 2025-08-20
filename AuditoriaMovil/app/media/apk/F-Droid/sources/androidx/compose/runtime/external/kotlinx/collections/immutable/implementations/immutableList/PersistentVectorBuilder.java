package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.ListImplementation;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
/* compiled from: PersistentVectorBuilder.kt */
/* loaded from: classes.dex */
public final class PersistentVectorBuilder extends AbstractMutableList implements PersistentList.Builder {
    private MutabilityOwnership ownership;
    private Object[] root;
    private int rootShift;
    private int size;
    private Object[] tail;
    private PersistentList vector;
    private Object[] vectorRoot;
    private Object[] vectorTail;

    private final Object[] mutableBuffer() {
        Object[] objArr = new Object[33];
        objArr[32] = this.ownership;
        return objArr;
    }

    private final Object[] mutableBufferWith(Object obj) {
        Object[] objArr = new Object[33];
        objArr[0] = obj;
        objArr[32] = this.ownership;
        return objArr;
    }

    public final int getModCount$runtime_release() {
        return ((AbstractList) this).modCount;
    }

    public final Object[] getRoot$runtime_release() {
        return this.root;
    }

    public final int getRootShift$runtime_release() {
        return this.rootShift;
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.size;
    }

    public final Object[] getTail$runtime_release() {
        return this.tail;
    }

    public PersistentVectorBuilder(PersistentList vector, Object[] objArr, Object[] vectorTail, int i) {
        Intrinsics.checkNotNullParameter(vector, "vector");
        Intrinsics.checkNotNullParameter(vectorTail, "vectorTail");
        this.vector = vector;
        this.vectorRoot = objArr;
        this.vectorTail = vectorTail;
        this.rootShift = i;
        this.ownership = new MutabilityOwnership();
        this.root = this.vectorRoot;
        this.tail = this.vectorTail;
        this.size = this.vector.size();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList.Builder
    public PersistentList build() {
        PersistentList persistentVector;
        if (this.root == this.vectorRoot && this.tail == this.vectorTail) {
            persistentVector = this.vector;
        } else {
            this.ownership = new MutabilityOwnership();
            Object[] objArr = this.root;
            this.vectorRoot = objArr;
            Object[] objArr2 = this.tail;
            this.vectorTail = objArr2;
            if (objArr == null) {
                if (objArr2.length == 0) {
                    persistentVector = UtilsKt.persistentVectorOf();
                } else {
                    Object[] copyOf = Arrays.copyOf(this.tail, size());
                    Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                    persistentVector = new SmallPersistentVector(copyOf);
                }
            } else {
                Object[] objArr3 = this.root;
                Intrinsics.checkNotNull(objArr3);
                persistentVector = new PersistentVector(objArr3, this.tail, size(), this.rootShift);
            }
        }
        this.vector = persistentVector;
        return persistentVector;
    }

    private final int rootSize() {
        if (size() <= 32) {
            return 0;
        }
        return UtilsKt.rootSize(size());
    }

    private final int tailSize(int i) {
        return i <= 32 ? i : i - UtilsKt.rootSize(i);
    }

    private final int tailSize() {
        return tailSize(size());
    }

    private final boolean isMutable(Object[] objArr) {
        return objArr.length == 33 && objArr[32] == this.ownership;
    }

    private final Object[] makeMutable(Object[] objArr) {
        int coerceAtMost;
        Object[] copyInto$default;
        if (objArr == null) {
            return mutableBuffer();
        }
        if (isMutable(objArr)) {
            return objArr;
        }
        Object[] mutableBuffer = mutableBuffer();
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(objArr.length, 32);
        copyInto$default = ArraysKt___ArraysJvmKt.copyInto$default(objArr, mutableBuffer, 0, 0, coerceAtMost, 6, (Object) null);
        return copyInto$default;
    }

    private final Object[] makeMutableShiftingRight(Object[] objArr, int i) {
        Object[] copyInto;
        Object[] copyInto2;
        if (isMutable(objArr)) {
            copyInto2 = ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, i, 0, 32 - i);
            return copyInto2;
        }
        copyInto = ArraysKt___ArraysJvmKt.copyInto(objArr, mutableBuffer(), i, 0, 32 - i);
        return copyInto;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        ((AbstractList) this).modCount++;
        int tailSize = tailSize();
        if (tailSize < 32) {
            Object[] makeMutable = makeMutable(this.tail);
            makeMutable[tailSize] = obj;
            this.tail = makeMutable;
            this.size = size() + 1;
        } else {
            pushFilledTail(this.root, this.tail, mutableBufferWith(obj));
        }
        return true;
    }

    private final void pushFilledTail(Object[] objArr, Object[] objArr2, Object[] objArr3) {
        int size = size() >> 5;
        int i = this.rootShift;
        if (size > (1 << i)) {
            this.root = pushTail(mutableBufferWith(objArr), objArr2, this.rootShift + 5);
            this.tail = objArr3;
            this.rootShift += 5;
            this.size = size() + 1;
        } else if (objArr == null) {
            this.root = objArr2;
            this.tail = objArr3;
            this.size = size() + 1;
        } else {
            this.root = pushTail(objArr, objArr2, i);
            this.tail = objArr3;
            this.size = size() + 1;
        }
    }

    private final Object[] pushTail(Object[] objArr, Object[] objArr2, int i) {
        int indexSegment = UtilsKt.indexSegment(size() - 1, i);
        Object[] makeMutable = makeMutable(objArr);
        if (i == 5) {
            makeMutable[indexSegment] = objArr2;
        } else {
            makeMutable[indexSegment] = pushTail((Object[]) makeMutable[indexSegment], objArr2, i - 5);
        }
        return makeMutable;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        ((AbstractList) this).modCount++;
        int tailSize = tailSize();
        Iterator it = elements.iterator();
        if (32 - tailSize >= elements.size()) {
            this.tail = copyToBuffer(makeMutable(this.tail), tailSize, it);
            this.size = size() + elements.size();
        } else {
            int size = ((elements.size() + tailSize) - 1) / 32;
            Object[][] objArr = new Object[size];
            objArr[0] = copyToBuffer(makeMutable(this.tail), tailSize, it);
            for (int i = 1; i < size; i++) {
                objArr[i] = copyToBuffer(mutableBuffer(), 0, it);
            }
            this.root = pushBuffersIncreasingHeightIfNeeded(this.root, rootSize(), objArr);
            this.tail = copyToBuffer(mutableBuffer(), 0, it);
            this.size = size() + elements.size();
        }
        return true;
    }

    private final Object[] copyToBuffer(Object[] objArr, int i, Iterator it) {
        while (i < 32 && it.hasNext()) {
            objArr[i] = it.next();
            i++;
        }
        return objArr;
    }

    private final Object[] pushBuffersIncreasingHeightIfNeeded(Object[] objArr, int i, Object[][] objArr2) {
        Object[] makeMutable;
        Iterator it = ArrayIteratorKt.iterator(objArr2);
        int i2 = i >> 5;
        int i3 = this.rootShift;
        if (i2 < (1 << i3)) {
            makeMutable = pushBuffers(objArr, i, i3, it);
        } else {
            makeMutable = makeMutable(objArr);
        }
        while (it.hasNext()) {
            this.rootShift += 5;
            makeMutable = mutableBufferWith(makeMutable);
            int i4 = this.rootShift;
            pushBuffers(makeMutable, 1 << i4, i4, it);
        }
        return makeMutable;
    }

    private final Object[] pushBuffers(Object[] objArr, int i, int i2, Iterator it) {
        if (it.hasNext()) {
            if (i2 >= 0) {
                if (i2 == 0) {
                    return (Object[]) it.next();
                }
                Object[] makeMutable = makeMutable(objArr);
                int indexSegment = UtilsKt.indexSegment(i, i2);
                int i3 = i2 - 5;
                makeMutable[indexSegment] = pushBuffers((Object[]) makeMutable[indexSegment], i, i3, it);
                while (true) {
                    indexSegment++;
                    if (indexSegment >= 32 || !it.hasNext()) {
                        break;
                    }
                    makeMutable[indexSegment] = pushBuffers((Object[]) makeMutable[indexSegment], 0, i3, it);
                }
                return makeMutable;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, Object obj) {
        ListImplementation.checkPositionIndex$runtime_release(i, size());
        if (i == size()) {
            add(obj);
            return;
        }
        ((AbstractList) this).modCount++;
        int rootSize = rootSize();
        if (i >= rootSize) {
            insertIntoTail(this.root, i - rootSize, obj);
            return;
        }
        ObjectRef objectRef = new ObjectRef(null);
        Object[] objArr = this.root;
        Intrinsics.checkNotNull(objArr);
        insertIntoTail(insertIntoRoot(objArr, this.rootShift, i, obj, objectRef), 0, objectRef.getValue());
    }

    private final void insertIntoTail(Object[] objArr, int i, Object obj) {
        int tailSize = tailSize();
        Object[] makeMutable = makeMutable(this.tail);
        if (tailSize < 32) {
            ArraysKt___ArraysJvmKt.copyInto(this.tail, makeMutable, i + 1, i, tailSize);
            makeMutable[i] = obj;
            this.root = objArr;
            this.tail = makeMutable;
            this.size = size() + 1;
            return;
        }
        Object[] objArr2 = this.tail;
        Object obj2 = objArr2[31];
        ArraysKt___ArraysJvmKt.copyInto(objArr2, makeMutable, i + 1, i, 31);
        makeMutable[i] = obj;
        pushFilledTail(objArr, makeMutable, mutableBufferWith(obj2));
    }

    private final Object[] insertIntoRoot(Object[] objArr, int i, int i2, Object obj, ObjectRef objectRef) {
        Object obj2;
        Object[] copyInto;
        int indexSegment = UtilsKt.indexSegment(i2, i);
        if (i == 0) {
            objectRef.setValue(objArr[31]);
            copyInto = ArraysKt___ArraysJvmKt.copyInto(objArr, makeMutable(objArr), indexSegment + 1, indexSegment, 31);
            copyInto[indexSegment] = obj;
            return copyInto;
        }
        Object[] makeMutable = makeMutable(objArr);
        int i3 = i - 5;
        Object obj3 = makeMutable[indexSegment];
        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        makeMutable[indexSegment] = insertIntoRoot((Object[]) obj3, i3, i2, obj, objectRef);
        while (true) {
            indexSegment++;
            if (indexSegment >= 32 || (obj2 = makeMutable[indexSegment]) == null) {
                break;
            }
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            makeMutable[indexSegment] = insertIntoRoot((Object[]) obj2, i3, 0, objectRef.getValue(), objectRef);
        }
        return makeMutable;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection elements) {
        Object[] copyInto;
        Object[] copyInto2;
        Intrinsics.checkNotNullParameter(elements, "elements");
        ListImplementation.checkPositionIndex$runtime_release(i, size());
        if (i == size()) {
            return addAll(elements);
        }
        if (elements.isEmpty()) {
            return false;
        }
        ((AbstractList) this).modCount++;
        int i2 = (i >> 5) << 5;
        int size = (((size() - i2) + elements.size()) - 1) / 32;
        if (size == 0) {
            CommonFunctionsKt.m626assert(i >= rootSize());
            int i3 = i & 31;
            Object[] objArr = this.tail;
            copyInto2 = ArraysKt___ArraysJvmKt.copyInto(objArr, makeMutable(objArr), (((i + elements.size()) - 1) & 31) + 1, i3, tailSize());
            copyToBuffer(copyInto2, i3, elements.iterator());
            this.tail = copyInto2;
            this.size = size() + elements.size();
            return true;
        }
        Object[][] objArr2 = new Object[size];
        int tailSize = tailSize();
        int tailSize2 = tailSize(size() + elements.size());
        if (i >= rootSize()) {
            copyInto = mutableBuffer();
            splitToBuffers(elements, i, this.tail, tailSize, objArr2, size, copyInto);
        } else if (tailSize2 > tailSize) {
            int i4 = tailSize2 - tailSize;
            copyInto = makeMutableShiftingRight(this.tail, i4);
            insertIntoRoot(elements, i, i4, objArr2, size, copyInto);
        } else {
            int i5 = tailSize - tailSize2;
            copyInto = ArraysKt___ArraysJvmKt.copyInto(this.tail, mutableBuffer(), 0, i5, tailSize);
            int i6 = 32 - i5;
            Object[] makeMutableShiftingRight = makeMutableShiftingRight(this.tail, i6);
            int i7 = size - 1;
            objArr2[i7] = makeMutableShiftingRight;
            insertIntoRoot(elements, i, i6, objArr2, i7, makeMutableShiftingRight);
        }
        this.root = pushBuffersIncreasingHeightIfNeeded(this.root, i2, objArr2);
        this.tail = copyInto;
        this.size = size() + elements.size();
        return true;
    }

    private final void insertIntoRoot(Collection collection, int i, int i2, Object[][] objArr, int i3, Object[] objArr2) {
        if (this.root == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        int i4 = i >> 5;
        Object[] shiftLeafBuffers = shiftLeafBuffers(i4, i2, objArr, i3, objArr2);
        int rootSize = i3 - (((rootSize() >> 5) - 1) - i4);
        if (rootSize < i3) {
            objArr2 = objArr[rootSize];
            Intrinsics.checkNotNull(objArr2);
        }
        splitToBuffers(collection, i, shiftLeafBuffers, 32, objArr, rootSize, objArr2);
    }

    private final Object[] shiftLeafBuffers(int i, int i2, Object[][] objArr, int i3, Object[] objArr2) {
        if (this.root == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        ListIterator leafBufferIterator = leafBufferIterator(rootSize() >> 5);
        while (leafBufferIterator.previousIndex() != i) {
            Object[] objArr3 = (Object[]) leafBufferIterator.previous();
            ArraysKt___ArraysJvmKt.copyInto(objArr3, objArr2, 0, 32 - i2, 32);
            objArr2 = makeMutableShiftingRight(objArr3, i2);
            i3--;
            objArr[i3] = objArr2;
        }
        return (Object[]) leafBufferIterator.previous();
    }

    private final void splitToBuffers(Collection collection, int i, Object[] objArr, int i2, Object[][] objArr2, int i3, Object[] objArr3) {
        Object[] mutableBuffer;
        if (i3 < 1) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Object[] makeMutable = makeMutable(objArr);
        objArr2[0] = makeMutable;
        int i4 = i & 31;
        int size = ((i + collection.size()) - 1) & 31;
        int i5 = (i2 - i4) + size;
        if (i5 < 32) {
            ArraysKt___ArraysJvmKt.copyInto(makeMutable, objArr3, size + 1, i4, i2);
        } else {
            int i6 = i5 - 31;
            if (i3 == 1) {
                mutableBuffer = makeMutable;
            } else {
                mutableBuffer = mutableBuffer();
                i3--;
                objArr2[i3] = mutableBuffer;
            }
            int i7 = i2 - i6;
            ArraysKt___ArraysJvmKt.copyInto(makeMutable, objArr3, 0, i7, i2);
            ArraysKt___ArraysJvmKt.copyInto(makeMutable, mutableBuffer, size + 1, i4, i7);
            objArr3 = mutableBuffer;
        }
        Iterator it = collection.iterator();
        copyToBuffer(makeMutable, i4, it);
        for (int i8 = 1; i8 < i3; i8++) {
            objArr2[i8] = copyToBuffer(mutableBuffer(), 0, it);
        }
        copyToBuffer(objArr3, 0, it);
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i) {
        ListImplementation.checkElementIndex$runtime_release(i, size());
        return bufferFor(i)[i & 31];
    }

    private final Object[] bufferFor(int i) {
        if (rootSize() <= i) {
            return this.tail;
        }
        Object[] objArr = this.root;
        Intrinsics.checkNotNull(objArr);
        for (int i2 = this.rootShift; i2 > 0; i2 -= 5) {
            Object[] objArr2 = objArr[UtilsKt.indexSegment(i, i2)];
            Intrinsics.checkNotNull(objArr2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArr = objArr2;
        }
        return objArr;
    }

    @Override // kotlin.collections.AbstractMutableList
    public Object removeAt(int i) {
        ListImplementation.checkElementIndex$runtime_release(i, size());
        ((AbstractList) this).modCount++;
        int rootSize = rootSize();
        if (i >= rootSize) {
            return removeFromTailAt(this.root, rootSize, this.rootShift, i - rootSize);
        }
        ObjectRef objectRef = new ObjectRef(this.tail[0]);
        Object[] objArr = this.root;
        Intrinsics.checkNotNull(objArr);
        removeFromTailAt(removeFromRootAt(objArr, this.rootShift, i, objectRef), rootSize, this.rootShift, 0);
        return objectRef.getValue();
    }

    private final Object removeFromTailAt(Object[] objArr, int i, int i2, int i3) {
        Object[] copyInto;
        int size = size() - i;
        CommonFunctionsKt.m626assert(i3 < size);
        if (size == 1) {
            Object obj = this.tail[0];
            pullLastBufferFromRoot(objArr, i, i2);
            return obj;
        }
        Object[] objArr2 = this.tail;
        Object obj2 = objArr2[i3];
        copyInto = ArraysKt___ArraysJvmKt.copyInto(objArr2, makeMutable(objArr2), i3, i3 + 1, size);
        copyInto[size - 1] = null;
        this.root = objArr;
        this.tail = copyInto;
        this.size = (i + size) - 1;
        this.rootShift = i2;
        return obj2;
    }

    private final Object[] removeFromRootAt(Object[] objArr, int i, int i2, ObjectRef objectRef) {
        Object[] copyInto;
        int indexSegment = UtilsKt.indexSegment(i2, i);
        if (i == 0) {
            Object obj = objArr[indexSegment];
            copyInto = ArraysKt___ArraysJvmKt.copyInto(objArr, makeMutable(objArr), indexSegment, indexSegment + 1, 32);
            copyInto[31] = objectRef.getValue();
            objectRef.setValue(obj);
            return copyInto;
        }
        int indexSegment2 = objArr[31] == null ? UtilsKt.indexSegment(rootSize() - 1, i) : 31;
        Object[] makeMutable = makeMutable(objArr);
        int i3 = i - 5;
        int i4 = indexSegment + 1;
        if (i4 <= indexSegment2) {
            while (true) {
                Object obj2 = makeMutable[indexSegment2];
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                makeMutable[indexSegment2] = removeFromRootAt((Object[]) obj2, i3, 0, objectRef);
                if (indexSegment2 == i4) {
                    break;
                }
                indexSegment2--;
            }
        }
        Object obj3 = makeMutable[indexSegment];
        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        makeMutable[indexSegment] = removeFromRootAt((Object[]) obj3, i3, i2, objectRef);
        return makeMutable;
    }

    private final void pullLastBufferFromRoot(Object[] objArr, int i, int i2) {
        if (i2 == 0) {
            this.root = null;
            if (objArr == null) {
                objArr = new Object[0];
            }
            this.tail = objArr;
            this.size = i;
            this.rootShift = i2;
            return;
        }
        ObjectRef objectRef = new ObjectRef(null);
        Intrinsics.checkNotNull(objArr);
        Object[] pullLastBuffer = pullLastBuffer(objArr, i2, i, objectRef);
        Intrinsics.checkNotNull(pullLastBuffer);
        Object value = objectRef.getValue();
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        this.tail = (Object[]) value;
        this.size = i;
        if (pullLastBuffer[1] == null) {
            this.root = (Object[]) pullLastBuffer[0];
            this.rootShift = i2 - 5;
            return;
        }
        this.root = pullLastBuffer;
        this.rootShift = i2;
    }

    private final Object[] pullLastBuffer(Object[] objArr, int i, int i2, ObjectRef objectRef) {
        Object[] pullLastBuffer;
        int indexSegment = UtilsKt.indexSegment(i2 - 1, i);
        if (i == 5) {
            objectRef.setValue(objArr[indexSegment]);
            pullLastBuffer = null;
        } else {
            Object obj = objArr[indexSegment];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            pullLastBuffer = pullLastBuffer((Object[]) obj, i - 5, i2, objectRef);
        }
        if (pullLastBuffer == null && indexSegment == 0) {
            return null;
        }
        Object[] makeMutable = makeMutable(objArr);
        makeMutable[indexSegment] = pullLastBuffer;
        return makeMutable;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(final Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return removeAllWithPredicate(new Function1() { // from class: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.PersistentVectorBuilder$removeAll$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object obj) {
                return Boolean.valueOf(elements.contains(obj));
            }
        });
    }

    public final boolean removeAllWithPredicate(Function1 predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        boolean removeAll = removeAll(predicate);
        if (removeAll) {
            ((AbstractList) this).modCount++;
        }
        return removeAll;
    }

    private final boolean removeAll(Function1 function1) {
        Object[] pushBuffers;
        int tailSize = tailSize();
        ObjectRef objectRef = new ObjectRef(null);
        if (this.root == null) {
            return removeAllFromTail(function1, tailSize, objectRef) != tailSize;
        }
        ListIterator leafBufferIterator = leafBufferIterator(0);
        int i = 32;
        while (i == 32 && leafBufferIterator.hasNext()) {
            i = removeAll(function1, (Object[]) leafBufferIterator.next(), 32, objectRef);
        }
        if (i == 32) {
            CommonFunctionsKt.m626assert(!leafBufferIterator.hasNext());
            int removeAllFromTail = removeAllFromTail(function1, tailSize, objectRef);
            if (removeAllFromTail == 0) {
                pullLastBufferFromRoot(this.root, size(), this.rootShift);
            }
            return removeAllFromTail != tailSize;
        }
        int previousIndex = leafBufferIterator.previousIndex() << 5;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i2 = i;
        while (leafBufferIterator.hasNext()) {
            i2 = recyclableRemoveAll(function1, (Object[]) leafBufferIterator.next(), 32, i2, objectRef, arrayList2, arrayList);
            previousIndex = previousIndex;
        }
        int i3 = previousIndex;
        int recyclableRemoveAll = recyclableRemoveAll(function1, this.tail, tailSize, i2, objectRef, arrayList2, arrayList);
        Object value = objectRef.getValue();
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] objArr = (Object[]) value;
        ArraysKt___ArraysJvmKt.fill(objArr, (Object) null, recyclableRemoveAll, 32);
        if (arrayList.isEmpty()) {
            pushBuffers = this.root;
            Intrinsics.checkNotNull(pushBuffers);
        } else {
            pushBuffers = pushBuffers(this.root, i3, this.rootShift, arrayList.iterator());
        }
        int size = i3 + (arrayList.size() << 5);
        this.root = retainFirst(pushBuffers, size);
        this.tail = objArr;
        this.size = size + recyclableRemoveAll;
        return true;
    }

    private final Object[] retainFirst(Object[] objArr, int i) {
        if ((i & 31) != 0) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (i == 0) {
            this.rootShift = 0;
            return null;
        }
        int i2 = i - 1;
        while (true) {
            int i3 = this.rootShift;
            if ((i2 >> i3) == 0) {
                this.rootShift = i3 - 5;
                Object[] objArr2 = objArr[0];
                Intrinsics.checkNotNull(objArr2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                objArr = objArr2;
            } else {
                return nullifyAfter(objArr, i2, i3);
            }
        }
    }

    private final Object[] nullifyAfter(Object[] objArr, int i, int i2) {
        if (i2 >= 0) {
            if (i2 == 0) {
                return objArr;
            }
            int indexSegment = UtilsKt.indexSegment(i, i2);
            Object obj = objArr[indexSegment];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            Object nullifyAfter = nullifyAfter((Object[]) obj, i, i2 - 5);
            if (indexSegment < 31) {
                int i3 = indexSegment + 1;
                if (objArr[i3] != null) {
                    if (isMutable(objArr)) {
                        ArraysKt___ArraysJvmKt.fill(objArr, (Object) null, i3, 32);
                    }
                    objArr = ArraysKt___ArraysJvmKt.copyInto(objArr, mutableBuffer(), 0, 0, i3);
                }
            }
            if (nullifyAfter != objArr[indexSegment]) {
                Object[] makeMutable = makeMutable(objArr);
                makeMutable[indexSegment] = nullifyAfter;
                return makeMutable;
            }
            return objArr;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    private final int removeAllFromTail(Function1 function1, int i, ObjectRef objectRef) {
        int removeAll = removeAll(function1, this.tail, i, objectRef);
        if (removeAll == i) {
            CommonFunctionsKt.m626assert(objectRef.getValue() == this.tail);
            return i;
        }
        Object value = objectRef.getValue();
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] objArr = (Object[]) value;
        ArraysKt___ArraysJvmKt.fill(objArr, (Object) null, removeAll, i);
        this.tail = objArr;
        this.size = size() - (i - removeAll);
        return removeAll;
    }

    private final int removeAll(Function1 function1, Object[] objArr, int i, ObjectRef objectRef) {
        Object[] objArr2 = objArr;
        int i2 = i;
        boolean z = false;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (((Boolean) function1.invoke(obj)).booleanValue()) {
                if (!z) {
                    objArr2 = makeMutable(objArr);
                    z = true;
                    i2 = i3;
                }
            } else if (z) {
                objArr2[i2] = obj;
                i2++;
            }
        }
        objectRef.setValue(objArr2);
        return i2;
    }

    private final int recyclableRemoveAll(Function1 function1, Object[] objArr, int i, int i2, ObjectRef objectRef, List list, List list2) {
        Object[] mutableBuffer;
        if (isMutable(objArr)) {
            list.add(objArr);
        }
        Object value = objectRef.getValue();
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] objArr2 = (Object[]) value;
        Object[] objArr3 = objArr2;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (!((Boolean) function1.invoke(obj)).booleanValue()) {
                if (i2 == 32) {
                    if (!list.isEmpty()) {
                        mutableBuffer = (Object[]) list.remove(list.size() - 1);
                    } else {
                        mutableBuffer = mutableBuffer();
                    }
                    objArr3 = mutableBuffer;
                    i2 = 0;
                }
                objArr3[i2] = obj;
                i2++;
            }
        }
        objectRef.setValue(objArr3);
        if (objArr2 != objectRef.getValue()) {
            list2.add(objArr2);
        }
        return i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i, Object obj) {
        ListImplementation.checkElementIndex$runtime_release(i, size());
        if (rootSize() <= i) {
            Object[] makeMutable = makeMutable(this.tail);
            if (makeMutable != this.tail) {
                ((AbstractList) this).modCount++;
            }
            int i2 = i & 31;
            Object obj2 = makeMutable[i2];
            makeMutable[i2] = obj;
            this.tail = makeMutable;
            return obj2;
        }
        ObjectRef objectRef = new ObjectRef(null);
        Object[] objArr = this.root;
        Intrinsics.checkNotNull(objArr);
        this.root = setInRoot(objArr, this.rootShift, i, obj, objectRef);
        return objectRef.getValue();
    }

    private final Object[] setInRoot(Object[] objArr, int i, int i2, Object obj, ObjectRef objectRef) {
        int indexSegment = UtilsKt.indexSegment(i2, i);
        Object[] makeMutable = makeMutable(objArr);
        if (i == 0) {
            if (makeMutable != objArr) {
                ((AbstractList) this).modCount++;
            }
            objectRef.setValue(makeMutable[indexSegment]);
            makeMutable[indexSegment] = obj;
            return makeMutable;
        }
        Object obj2 = makeMutable[indexSegment];
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        makeMutable[indexSegment] = setInRoot((Object[]) obj2, i - 5, i2, obj, objectRef);
        return makeMutable;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return listIterator();
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator(int i) {
        ListImplementation.checkPositionIndex$runtime_release(i, size());
        return new PersistentVectorMutableIterator(this, i);
    }

    private final ListIterator leafBufferIterator(int i) {
        if (this.root == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        int rootSize = rootSize() >> 5;
        ListImplementation.checkPositionIndex$runtime_release(i, rootSize);
        int i2 = this.rootShift;
        if (i2 == 0) {
            Object[] objArr = this.root;
            Intrinsics.checkNotNull(objArr);
            return new SingleElementListIterator(objArr, i);
        }
        Object[] objArr2 = this.root;
        Intrinsics.checkNotNull(objArr2);
        return new TrieIterator(objArr2, i, rootSize, i2 / 5);
    }
}
