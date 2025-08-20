package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.ActualJvm_jvmKt;
import androidx.compose.runtime.WeakReference;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SnapshotWeakSet.kt */
/* loaded from: classes.dex */
public final class SnapshotWeakSet {
    private int size;
    private int[] hashes = new int[16];
    private WeakReference[] values = new WeakReference[16];

    public final int[] getHashes$runtime_release() {
        return this.hashes;
    }

    public final int getSize$runtime_release() {
        return this.size;
    }

    public final WeakReference[] getValues$runtime_release() {
        return this.values;
    }

    public final void setSize$runtime_release(int i) {
        this.size = i;
    }

    public final boolean add(Object value) {
        int i;
        Intrinsics.checkNotNullParameter(value, "value");
        int i2 = this.size;
        int identityHashCode = ActualJvm_jvmKt.identityHashCode(value);
        if (i2 > 0) {
            i = find(value, identityHashCode);
            if (i >= 0) {
                return false;
            }
        } else {
            i = -1;
        }
        int i3 = -(i + 1);
        WeakReference[] weakReferenceArr = this.values;
        int length = weakReferenceArr.length;
        if (i2 == length) {
            int i4 = length * 2;
            WeakReference[] weakReferenceArr2 = new WeakReference[i4];
            int[] iArr = new int[i4];
            int i5 = i3 + 1;
            ArraysKt___ArraysJvmKt.copyInto(weakReferenceArr, weakReferenceArr2, i5, i3, i2);
            ArraysKt___ArraysJvmKt.copyInto$default(this.values, weakReferenceArr2, 0, 0, i3, 6, (Object) null);
            ArraysKt___ArraysJvmKt.copyInto(this.hashes, iArr, i5, i3, i2);
            ArraysKt___ArraysJvmKt.copyInto$default(this.hashes, iArr, 0, 0, i3, 6, (Object) null);
            this.values = weakReferenceArr2;
            this.hashes = iArr;
        } else {
            int i6 = i3 + 1;
            ArraysKt___ArraysJvmKt.copyInto(weakReferenceArr, weakReferenceArr, i6, i3, i2);
            int[] iArr2 = this.hashes;
            ArraysKt___ArraysJvmKt.copyInto(iArr2, iArr2, i6, i3, i2);
        }
        this.values[i3] = new WeakReference(value);
        this.hashes[i3] = identityHashCode;
        this.size++;
        return true;
    }

    private final int find(Object obj, int i) {
        int i2 = this.size - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            int i5 = this.hashes[i4];
            if (i5 < i) {
                i3 = i4 + 1;
            } else if (i5 <= i) {
                WeakReference weakReference = this.values[i4];
                return obj == (weakReference != null ? weakReference.get() : null) ? i4 : findExactIndex(i4, obj, i);
            } else {
                i2 = i4 - 1;
            }
        }
        return -(i3 + 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x002c, code lost:
        return -(r4 + 1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int findExactIndex(int r4, java.lang.Object r5, int r6) {
        /*
            r3 = this;
            int r0 = r4 + (-1)
        L2:
            r1 = 0
            r2 = -1
            if (r2 >= r0) goto L1d
            int[] r2 = r3.hashes
            r2 = r2[r0]
            if (r2 == r6) goto Ld
            goto L1d
        Ld:
            androidx.compose.runtime.WeakReference[] r2 = r3.values
            r2 = r2[r0]
            if (r2 == 0) goto L17
            java.lang.Object r1 = r2.get()
        L17:
            if (r1 != r5) goto L1a
            return r0
        L1a:
            int r0 = r0 + (-1)
            goto L2
        L1d:
            int r4 = r4 + 1
            int r0 = r3.size
        L21:
            if (r4 >= r0) goto L3f
            int[] r2 = r3.hashes
            r2 = r2[r4]
            if (r2 == r6) goto L2d
        L29:
            int r4 = r4 + 1
            int r4 = -r4
            return r4
        L2d:
            androidx.compose.runtime.WeakReference[] r2 = r3.values
            r2 = r2[r4]
            if (r2 == 0) goto L38
            java.lang.Object r2 = r2.get()
            goto L39
        L38:
            r2 = r1
        L39:
            if (r2 != r5) goto L3c
            return r4
        L3c:
            int r4 = r4 + 1
            goto L21
        L3f:
            int r4 = r3.size
            goto L29
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotWeakSet.findExactIndex(int, java.lang.Object, int):int");
    }
}
