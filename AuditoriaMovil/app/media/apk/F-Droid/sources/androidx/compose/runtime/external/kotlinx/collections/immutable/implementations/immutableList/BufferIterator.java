package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BufferIterator.kt */
/* loaded from: classes.dex */
public final class BufferIterator extends AbstractListIterator {
    private final Object[] buffer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BufferIterator(Object[] buffer, int i, int i2) {
        super(i, i2);
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.buffer = buffer;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object[] objArr = this.buffer;
        int index = getIndex();
        setIndex(index + 1);
        return objArr[index];
    }

    @Override // java.util.ListIterator
    public Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        Object[] objArr = this.buffer;
        setIndex(getIndex() - 1);
        return objArr[getIndex()];
    }
}
