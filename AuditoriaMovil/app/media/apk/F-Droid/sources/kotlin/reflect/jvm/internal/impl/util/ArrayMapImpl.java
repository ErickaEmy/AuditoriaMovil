package kotlin.reflect.jvm.internal.impl.util;

import java.util.Arrays;
import java.util.Iterator;
import kotlin.collections.AbstractIterator;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArrayMap.kt */
/* loaded from: classes2.dex */
public final class ArrayMapImpl extends ArrayMap {
    public static final Companion Companion = new Companion(null);
    private Object[] data;
    private int size;

    /* compiled from: ArrayMap.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public int getSize() {
        return this.size;
    }

    private ArrayMapImpl(Object[] objArr, int i) {
        super(null);
        this.data = objArr;
        this.size = i;
    }

    public ArrayMapImpl() {
        this(new Object[20], 0);
    }

    private final void ensureCapacity(int i) {
        Object[] objArr = this.data;
        if (objArr.length > i) {
            return;
        }
        int length = objArr.length;
        do {
            length *= 2;
        } while (length <= i);
        Object[] copyOf = Arrays.copyOf(this.data, length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        this.data = copyOf;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public void set(int i, Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        ensureCapacity(i);
        if (this.data[i] == null) {
            this.size = getSize() + 1;
        }
        this.data[i] = value;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public Object get(int i) {
        Object orNull;
        orNull = ArraysKt___ArraysKt.getOrNull(this.data, i);
        return orNull;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap, java.lang.Iterable
    public Iterator iterator() {
        return new AbstractIterator() { // from class: kotlin.reflect.jvm.internal.impl.util.ArrayMapImpl$iterator$1
            private int index = -1;

            @Override // kotlin.collections.AbstractIterator
            protected void computeNext() {
                Object[] objArr;
                Object[] objArr2;
                Object[] objArr3;
                Object[] objArr4;
                do {
                    int i = this.index + 1;
                    this.index = i;
                    objArr = ArrayMapImpl.this.data;
                    if (i >= objArr.length) {
                        break;
                    }
                    objArr4 = ArrayMapImpl.this.data;
                } while (objArr4[this.index] == null);
                int i2 = this.index;
                objArr2 = ArrayMapImpl.this.data;
                if (i2 < objArr2.length) {
                    objArr3 = ArrayMapImpl.this.data;
                    Object obj = objArr3[this.index];
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of org.jetbrains.kotlin.util.ArrayMapImpl");
                    setNext(obj);
                    return;
                }
                done();
            }
        };
    }
}
