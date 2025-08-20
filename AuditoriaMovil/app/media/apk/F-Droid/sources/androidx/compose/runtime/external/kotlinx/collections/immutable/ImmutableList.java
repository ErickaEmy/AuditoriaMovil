package androidx.compose.runtime.external.kotlinx.collections.immutable;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.ListImplementation;
import java.util.List;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
/* compiled from: ImmutableList.kt */
/* loaded from: classes.dex */
public interface ImmutableList extends List, ImmutableCollection, KMappedMarker {

    /* compiled from: ImmutableList.kt */
    /* renamed from: androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
        public static ImmutableList $default$subList(ImmutableList immutableList, int i, int i2) {
            return new SubList(immutableList, i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ImmutableList.kt */
    /* loaded from: classes.dex */
    public static final class SubList extends AbstractList implements ImmutableList {
        private int _size;
        private final int fromIndex;
        private final ImmutableList source;
        private final int toIndex;

        @Override // kotlin.collections.AbstractCollection
        public int getSize() {
            return this._size;
        }

        public SubList(ImmutableList source, int i, int i2) {
            Intrinsics.checkNotNullParameter(source, "source");
            this.source = source;
            this.fromIndex = i;
            this.toIndex = i2;
            ListImplementation.checkRangeIndexes$runtime_release(i, i2, source.size());
            this._size = i2 - i;
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public Object get(int i) {
            ListImplementation.checkElementIndex$runtime_release(i, this._size);
            return this.source.get(this.fromIndex + i);
        }

        @Override // kotlin.collections.AbstractList, java.util.List
        public ImmutableList subList(int i, int i2) {
            ListImplementation.checkRangeIndexes$runtime_release(i, i2, this._size);
            ImmutableList immutableList = this.source;
            int i3 = this.fromIndex;
            return new SubList(immutableList, i + i3, i3 + i2);
        }
    }
}
