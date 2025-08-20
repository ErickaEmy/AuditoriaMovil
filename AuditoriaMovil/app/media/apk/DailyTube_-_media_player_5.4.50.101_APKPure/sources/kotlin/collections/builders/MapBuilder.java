package kotlin.collections.builders;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
/* loaded from: classes.dex */
public final class MapBuilder<K, V> implements Map<K, V>, Serializable, KMutableMap {
    public static final Companion Companion = new Companion(null);
    private static final MapBuilder Empty;
    private MapBuilderEntries<K, V> entriesView;
    private int[] hashArray;
    private int hashShift;
    private boolean isReadOnly;
    private K[] keysArray;
    private MapBuilderKeys<K> keysView;
    private int length;
    private int maxProbeDistance;
    private int modCount;
    private int[] presenceArray;
    private int size;
    private V[] valuesArray;
    private MapBuilderValues<V> valuesView;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int computeHashSize(int i) {
            return Integer.highestOneBit(RangesKt.coerceAtLeast(i, 1) * 3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int computeShift(int i) {
            return Integer.numberOfLeadingZeros(i) + 1;
        }

        public final MapBuilder getEmpty$kotlin_stdlib() {
            return MapBuilder.Empty;
        }

        private Companion() {
        }
    }

    /* loaded from: classes.dex */
    public static final class EntriesItr<K, V> extends Itr<K, V> implements Iterator<Map.Entry<K, V>>, KMappedMarker {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EntriesItr(MapBuilder<K, V> map) {
            super(map);
            Intrinsics.checkNotNullParameter(map, "map");
        }

        public final void nextAppendString(StringBuilder sb) {
            Intrinsics.checkNotNullParameter(sb, "sb");
            if (getIndex$kotlin_stdlib() < ((MapBuilder) getMap$kotlin_stdlib()).length) {
                int index$kotlin_stdlib = getIndex$kotlin_stdlib();
                setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
                setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
                Object obj = ((MapBuilder) getMap$kotlin_stdlib()).keysArray[getLastIndex$kotlin_stdlib()];
                if (obj == getMap$kotlin_stdlib()) {
                    sb.append("(this Map)");
                } else {
                    sb.append(obj);
                }
                sb.append('=');
                Object[] objArr = ((MapBuilder) getMap$kotlin_stdlib()).valuesArray;
                Intrinsics.checkNotNull(objArr);
                Object obj2 = objArr[getLastIndex$kotlin_stdlib()];
                if (obj2 == getMap$kotlin_stdlib()) {
                    sb.append("(this Map)");
                } else {
                    sb.append(obj2);
                }
                initNext$kotlin_stdlib();
                return;
            }
            throw new NoSuchElementException();
        }

        public final int nextHashCode$kotlin_stdlib() {
            int i;
            if (getIndex$kotlin_stdlib() < ((MapBuilder) getMap$kotlin_stdlib()).length) {
                int index$kotlin_stdlib = getIndex$kotlin_stdlib();
                setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
                setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
                Object obj = ((MapBuilder) getMap$kotlin_stdlib()).keysArray[getLastIndex$kotlin_stdlib()];
                int i5 = 0;
                if (obj != null) {
                    i = obj.hashCode();
                } else {
                    i = 0;
                }
                Object[] objArr = ((MapBuilder) getMap$kotlin_stdlib()).valuesArray;
                Intrinsics.checkNotNull(objArr);
                Object obj2 = objArr[getLastIndex$kotlin_stdlib()];
                if (obj2 != null) {
                    i5 = obj2.hashCode();
                }
                int i6 = i ^ i5;
                initNext$kotlin_stdlib();
                return i6;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public EntryRef<K, V> next() {
            checkForComodification$kotlin_stdlib();
            if (getIndex$kotlin_stdlib() < ((MapBuilder) getMap$kotlin_stdlib()).length) {
                int index$kotlin_stdlib = getIndex$kotlin_stdlib();
                setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
                setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
                EntryRef<K, V> entryRef = new EntryRef<>(getMap$kotlin_stdlib(), getLastIndex$kotlin_stdlib());
                initNext$kotlin_stdlib();
                return entryRef;
            }
            throw new NoSuchElementException();
        }
    }

    /* loaded from: classes.dex */
    public static final class EntryRef<K, V> implements Map.Entry<K, V>, KMappedMarker {
        private final int index;
        private final MapBuilder<K, V> map;

        public EntryRef(MapBuilder<K, V> map, int i) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.map = map;
            this.index = i;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (Intrinsics.areEqual(entry.getKey(), getKey()) && Intrinsics.areEqual(entry.getValue(), getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) ((MapBuilder) this.map).keysArray[this.index];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            Object[] objArr = ((MapBuilder) this.map).valuesArray;
            Intrinsics.checkNotNull(objArr);
            return (V) objArr[this.index];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int i;
            K key = getKey();
            int i5 = 0;
            if (key != null) {
                i = key.hashCode();
            } else {
                i = 0;
            }
            V value = getValue();
            if (value != null) {
                i5 = value.hashCode();
            }
            return i ^ i5;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v2) {
            this.map.checkIsMutable$kotlin_stdlib();
            Object[] allocateValuesArray = this.map.allocateValuesArray();
            int i = this.index;
            V v3 = (V) allocateValuesArray[i];
            allocateValuesArray[i] = v2;
            return v3;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append('=');
            sb.append(getValue());
            return sb.toString();
        }
    }

    /* loaded from: classes.dex */
    public static class Itr<K, V> {
        private int expectedModCount;
        private int index;
        private int lastIndex;
        private final MapBuilder<K, V> map;

        public Itr(MapBuilder<K, V> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.map = map;
            this.lastIndex = -1;
            this.expectedModCount = ((MapBuilder) map).modCount;
            initNext$kotlin_stdlib();
        }

        public final void checkForComodification$kotlin_stdlib() {
            if (((MapBuilder) this.map).modCount == this.expectedModCount) {
                return;
            }
            throw new ConcurrentModificationException();
        }

        public final int getIndex$kotlin_stdlib() {
            return this.index;
        }

        public final int getLastIndex$kotlin_stdlib() {
            return this.lastIndex;
        }

        public final MapBuilder<K, V> getMap$kotlin_stdlib() {
            return this.map;
        }

        public final boolean hasNext() {
            if (this.index < ((MapBuilder) this.map).length) {
                return true;
            }
            return false;
        }

        public final void initNext$kotlin_stdlib() {
            while (this.index < ((MapBuilder) this.map).length) {
                int[] iArr = ((MapBuilder) this.map).presenceArray;
                int i = this.index;
                if (iArr[i] < 0) {
                    this.index = i + 1;
                } else {
                    return;
                }
            }
        }

        public final void remove() {
            checkForComodification$kotlin_stdlib();
            if (this.lastIndex != -1) {
                this.map.checkIsMutable$kotlin_stdlib();
                this.map.removeKeyAt(this.lastIndex);
                this.lastIndex = -1;
                this.expectedModCount = ((MapBuilder) this.map).modCount;
                return;
            }
            throw new IllegalStateException("Call next() before removing element from the iterator.");
        }

        public final void setIndex$kotlin_stdlib(int i) {
            this.index = i;
        }

        public final void setLastIndex$kotlin_stdlib(int i) {
            this.lastIndex = i;
        }
    }

    /* loaded from: classes.dex */
    public static final class KeysItr<K, V> extends Itr<K, V> implements Iterator<K>, KMappedMarker {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public KeysItr(MapBuilder<K, V> map) {
            super(map);
            Intrinsics.checkNotNullParameter(map, "map");
        }

        @Override // java.util.Iterator
        public K next() {
            checkForComodification$kotlin_stdlib();
            if (getIndex$kotlin_stdlib() < ((MapBuilder) getMap$kotlin_stdlib()).length) {
                int index$kotlin_stdlib = getIndex$kotlin_stdlib();
                setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
                setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
                K k2 = (K) ((MapBuilder) getMap$kotlin_stdlib()).keysArray[getLastIndex$kotlin_stdlib()];
                initNext$kotlin_stdlib();
                return k2;
            }
            throw new NoSuchElementException();
        }
    }

    /* loaded from: classes.dex */
    public static final class ValuesItr<K, V> extends Itr<K, V> implements Iterator<V>, KMappedMarker {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ValuesItr(MapBuilder<K, V> map) {
            super(map);
            Intrinsics.checkNotNullParameter(map, "map");
        }

        @Override // java.util.Iterator
        public V next() {
            checkForComodification$kotlin_stdlib();
            if (getIndex$kotlin_stdlib() < ((MapBuilder) getMap$kotlin_stdlib()).length) {
                int index$kotlin_stdlib = getIndex$kotlin_stdlib();
                setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
                setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
                Object[] objArr = ((MapBuilder) getMap$kotlin_stdlib()).valuesArray;
                Intrinsics.checkNotNull(objArr);
                V v2 = (V) objArr[getLastIndex$kotlin_stdlib()];
                initNext$kotlin_stdlib();
                return v2;
            }
            throw new NoSuchElementException();
        }
    }

    static {
        MapBuilder mapBuilder = new MapBuilder(0);
        mapBuilder.isReadOnly = true;
        Empty = mapBuilder;
    }

    private MapBuilder(K[] kArr, V[] vArr, int[] iArr, int[] iArr2, int i, int i5) {
        this.keysArray = kArr;
        this.valuesArray = vArr;
        this.presenceArray = iArr;
        this.hashArray = iArr2;
        this.maxProbeDistance = i;
        this.length = i5;
        this.hashShift = Companion.computeShift(getHashSize());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V[] allocateValuesArray() {
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            return vArr;
        }
        V[] vArr2 = (V[]) ListBuilderKt.arrayOfUninitializedElements(getCapacity$kotlin_stdlib());
        this.valuesArray = vArr2;
        return vArr2;
    }

    private final void compact() {
        int i;
        V[] vArr = this.valuesArray;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            i = this.length;
            if (i5 >= i) {
                break;
            }
            if (this.presenceArray[i5] >= 0) {
                K[] kArr = this.keysArray;
                kArr[i6] = kArr[i5];
                if (vArr != null) {
                    vArr[i6] = vArr[i5];
                }
                i6++;
            }
            i5++;
        }
        ListBuilderKt.resetRange(this.keysArray, i6, i);
        if (vArr != null) {
            ListBuilderKt.resetRange(vArr, i6, this.length);
        }
        this.length = i6;
    }

    private final boolean contentEquals(Map<?, ?> map) {
        if (size() == map.size() && containsAllEntries$kotlin_stdlib(map.entrySet())) {
            return true;
        }
        return false;
    }

    private final void ensureCapacity(int i) {
        V[] vArr;
        if (i >= 0) {
            if (i > getCapacity$kotlin_stdlib()) {
                int newCapacity$kotlin_stdlib = AbstractList.Companion.newCapacity$kotlin_stdlib(getCapacity$kotlin_stdlib(), i);
                this.keysArray = (K[]) ListBuilderKt.copyOfUninitializedElements(this.keysArray, newCapacity$kotlin_stdlib);
                V[] vArr2 = this.valuesArray;
                if (vArr2 != null) {
                    vArr = (V[]) ListBuilderKt.copyOfUninitializedElements(vArr2, newCapacity$kotlin_stdlib);
                } else {
                    vArr = null;
                }
                this.valuesArray = vArr;
                int[] copyOf = Arrays.copyOf(this.presenceArray, newCapacity$kotlin_stdlib);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                this.presenceArray = copyOf;
                int computeHashSize = Companion.computeHashSize(newCapacity$kotlin_stdlib);
                if (computeHashSize > getHashSize()) {
                    rehash(computeHashSize);
                    return;
                }
                return;
            }
            return;
        }
        throw new OutOfMemoryError();
    }

    private final void ensureExtraCapacity(int i) {
        if (shouldCompact(i)) {
            rehash(getHashSize());
        } else {
            ensureCapacity(this.length + i);
        }
    }

    private final int findKey(K k2) {
        int hash = hash(k2);
        int i = this.maxProbeDistance;
        while (true) {
            int i5 = this.hashArray[hash];
            if (i5 == 0) {
                return -1;
            }
            if (i5 > 0) {
                int i6 = i5 - 1;
                if (Intrinsics.areEqual(this.keysArray[i6], k2)) {
                    return i6;
                }
            }
            i--;
            if (i < 0) {
                return -1;
            }
            int i8 = hash - 1;
            if (hash == 0) {
                hash = getHashSize() - 1;
            } else {
                hash = i8;
            }
        }
    }

    private final int findValue(V v2) {
        int i = this.length;
        while (true) {
            i--;
            if (i < 0) {
                return -1;
            }
            if (this.presenceArray[i] >= 0) {
                V[] vArr = this.valuesArray;
                Intrinsics.checkNotNull(vArr);
                if (Intrinsics.areEqual(vArr[i], v2)) {
                    return i;
                }
            }
        }
    }

    private final int getHashSize() {
        return this.hashArray.length;
    }

    private final int hash(K k2) {
        int i;
        if (k2 != null) {
            i = k2.hashCode();
        } else {
            i = 0;
        }
        return (i * (-1640531527)) >>> this.hashShift;
    }

    private final boolean putAllEntries(Collection<? extends Map.Entry<? extends K, ? extends V>> collection) {
        boolean z2 = false;
        if (collection.isEmpty()) {
            return false;
        }
        ensureExtraCapacity(collection.size());
        for (Map.Entry<? extends K, ? extends V> entry : collection) {
            if (putEntry(entry)) {
                z2 = true;
            }
        }
        return z2;
    }

    private final boolean putEntry(Map.Entry<? extends K, ? extends V> entry) {
        int addKey$kotlin_stdlib = addKey$kotlin_stdlib(entry.getKey());
        V[] allocateValuesArray = allocateValuesArray();
        if (addKey$kotlin_stdlib >= 0) {
            allocateValuesArray[addKey$kotlin_stdlib] = entry.getValue();
            return true;
        }
        int i = (-addKey$kotlin_stdlib) - 1;
        if (!Intrinsics.areEqual(entry.getValue(), allocateValuesArray[i])) {
            allocateValuesArray[i] = entry.getValue();
            return true;
        }
        return false;
    }

    private final boolean putRehash(int i) {
        int hash = hash(this.keysArray[i]);
        int i5 = this.maxProbeDistance;
        while (true) {
            int[] iArr = this.hashArray;
            if (iArr[hash] == 0) {
                iArr[hash] = i + 1;
                this.presenceArray[i] = hash;
                return true;
            }
            i5--;
            if (i5 < 0) {
                return false;
            }
            int i6 = hash - 1;
            if (hash == 0) {
                hash = getHashSize() - 1;
            } else {
                hash = i6;
            }
        }
    }

    private final void registerModification() {
        this.modCount++;
    }

    private final void rehash(int i) {
        registerModification();
        if (this.length > size()) {
            compact();
        }
        int i5 = 0;
        if (i != getHashSize()) {
            this.hashArray = new int[i];
            this.hashShift = Companion.computeShift(i);
        } else {
            ArraysKt.fill(this.hashArray, 0, 0, getHashSize());
        }
        while (i5 < this.length) {
            int i6 = i5 + 1;
            if (putRehash(i5)) {
                i5 = i6;
            } else {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
        }
    }

    private final void removeHashAt(int i) {
        int coerceAtMost = RangesKt.coerceAtMost(this.maxProbeDistance * 2, getHashSize() / 2);
        int i5 = 0;
        int i6 = i;
        do {
            int i8 = i - 1;
            if (i == 0) {
                i = getHashSize() - 1;
            } else {
                i = i8;
            }
            i5++;
            if (i5 > this.maxProbeDistance) {
                this.hashArray[i6] = 0;
                return;
            }
            int[] iArr = this.hashArray;
            int i10 = iArr[i];
            if (i10 == 0) {
                iArr[i6] = 0;
                return;
            }
            if (i10 < 0) {
                iArr[i6] = -1;
            } else {
                int i11 = i10 - 1;
                if (((hash(this.keysArray[i11]) - i) & (getHashSize() - 1)) >= i5) {
                    this.hashArray[i6] = i10;
                    this.presenceArray[i11] = i6;
                }
                coerceAtMost--;
            }
            i6 = i;
            i5 = 0;
            coerceAtMost--;
        } while (coerceAtMost >= 0);
        this.hashArray[i6] = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeKeyAt(int i) {
        ListBuilderKt.resetAt(this.keysArray, i);
        removeHashAt(this.presenceArray[i]);
        this.presenceArray[i] = -1;
        this.size = size() - 1;
        registerModification();
    }

    private final boolean shouldCompact(int i) {
        int capacity$kotlin_stdlib = getCapacity$kotlin_stdlib();
        int i5 = this.length;
        int i6 = capacity$kotlin_stdlib - i5;
        int size = i5 - size();
        if (i6 < i && i6 + size >= i && size >= getCapacity$kotlin_stdlib() / 4) {
            return true;
        }
        return false;
    }

    private final Object writeReplace() {
        if (this.isReadOnly) {
            return new SerializedMap(this);
        }
        throw new NotSerializableException("The map cannot be serialized while it is being built.");
    }

    public final int addKey$kotlin_stdlib(K k2) {
        checkIsMutable$kotlin_stdlib();
        while (true) {
            int hash = hash(k2);
            int coerceAtMost = RangesKt.coerceAtMost(this.maxProbeDistance * 2, getHashSize() / 2);
            int i = 0;
            while (true) {
                int i5 = this.hashArray[hash];
                if (i5 <= 0) {
                    if (this.length >= getCapacity$kotlin_stdlib()) {
                        ensureExtraCapacity(1);
                    } else {
                        int i6 = this.length;
                        int i8 = i6 + 1;
                        this.length = i8;
                        this.keysArray[i6] = k2;
                        this.presenceArray[i6] = hash;
                        this.hashArray[hash] = i8;
                        this.size = size() + 1;
                        registerModification();
                        if (i > this.maxProbeDistance) {
                            this.maxProbeDistance = i;
                        }
                        return i6;
                    }
                } else if (Intrinsics.areEqual(this.keysArray[i5 - 1], k2)) {
                    return -i5;
                } else {
                    i++;
                    if (i > coerceAtMost) {
                        rehash(getHashSize() * 2);
                        break;
                    }
                    int i10 = hash - 1;
                    if (hash == 0) {
                        hash = getHashSize() - 1;
                    } else {
                        hash = i10;
                    }
                }
            }
        }
    }

    public final Map<K, V> build() {
        checkIsMutable$kotlin_stdlib();
        this.isReadOnly = true;
        if (size() > 0) {
            return this;
        }
        MapBuilder mapBuilder = Empty;
        Intrinsics.checkNotNull(mapBuilder, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return mapBuilder;
    }

    public final void checkIsMutable$kotlin_stdlib() {
        if (!this.isReadOnly) {
            return;
        }
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @Override // java.util.Map
    public void clear() {
        checkIsMutable$kotlin_stdlib();
        ?? it = new IntRange(0, this.length - 1).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            int[] iArr = this.presenceArray;
            int i = iArr[nextInt];
            if (i >= 0) {
                this.hashArray[i] = 0;
                iArr[nextInt] = -1;
            }
        }
        ListBuilderKt.resetRange(this.keysArray, 0, this.length);
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            ListBuilderKt.resetRange(vArr, 0, this.length);
        }
        this.size = 0;
        this.length = 0;
        registerModification();
    }

    public final boolean containsAllEntries$kotlin_stdlib(Collection<?> m2) {
        Intrinsics.checkNotNullParameter(m2, "m");
        for (Object obj : m2) {
            if (obj != null) {
                try {
                    if (!containsEntry$kotlin_stdlib((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean containsEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        int findKey = findKey(entry.getKey());
        if (findKey < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        Intrinsics.checkNotNull(vArr);
        return Intrinsics.areEqual(vArr[findKey], entry.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        if (findKey(obj) >= 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        if (findValue(obj) >= 0) {
            return true;
        }
        return false;
    }

    public final EntriesItr<K, V> entriesIterator$kotlin_stdlib() {
        return new EntriesItr<>(this);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (obj != this && (!(obj instanceof Map) || !contentEquals((Map) obj))) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V get(Object obj) {
        int findKey = findKey(obj);
        if (findKey < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        Intrinsics.checkNotNull(vArr);
        return vArr[findKey];
    }

    public final int getCapacity$kotlin_stdlib() {
        return this.keysArray.length;
    }

    public Set<Map.Entry<K, V>> getEntries() {
        MapBuilderEntries<K, V> mapBuilderEntries = this.entriesView;
        if (mapBuilderEntries == null) {
            MapBuilderEntries<K, V> mapBuilderEntries2 = new MapBuilderEntries<>(this);
            this.entriesView = mapBuilderEntries2;
            return mapBuilderEntries2;
        }
        return mapBuilderEntries;
    }

    public Set<K> getKeys() {
        MapBuilderKeys<K> mapBuilderKeys = this.keysView;
        if (mapBuilderKeys == null) {
            MapBuilderKeys<K> mapBuilderKeys2 = new MapBuilderKeys<>(this);
            this.keysView = mapBuilderKeys2;
            return mapBuilderKeys2;
        }
        return mapBuilderKeys;
    }

    public int getSize() {
        return this.size;
    }

    public Collection<V> getValues() {
        MapBuilderValues<V> mapBuilderValues = this.valuesView;
        if (mapBuilderValues == null) {
            MapBuilderValues<V> mapBuilderValues2 = new MapBuilderValues<>(this);
            this.valuesView = mapBuilderValues2;
            return mapBuilderValues2;
        }
        return mapBuilderValues;
    }

    @Override // java.util.Map
    public int hashCode() {
        EntriesItr<K, V> entriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i = 0;
        while (entriesIterator$kotlin_stdlib.hasNext()) {
            i += entriesIterator$kotlin_stdlib.nextHashCode$kotlin_stdlib();
        }
        return i;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public final boolean isReadOnly$kotlin_stdlib() {
        return this.isReadOnly;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    public final KeysItr<K, V> keysIterator$kotlin_stdlib() {
        return new KeysItr<>(this);
    }

    @Override // java.util.Map
    public V put(K k2, V v2) {
        checkIsMutable$kotlin_stdlib();
        int addKey$kotlin_stdlib = addKey$kotlin_stdlib(k2);
        V[] allocateValuesArray = allocateValuesArray();
        if (addKey$kotlin_stdlib < 0) {
            int i = (-addKey$kotlin_stdlib) - 1;
            V v3 = allocateValuesArray[i];
            allocateValuesArray[i] = v2;
            return v3;
        }
        allocateValuesArray[addKey$kotlin_stdlib] = v2;
        return null;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        checkIsMutable$kotlin_stdlib();
        putAllEntries(from.entrySet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V remove(Object obj) {
        int removeKey$kotlin_stdlib = removeKey$kotlin_stdlib(obj);
        if (removeKey$kotlin_stdlib < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        Intrinsics.checkNotNull(vArr);
        V v2 = vArr[removeKey$kotlin_stdlib];
        ListBuilderKt.resetAt(vArr, removeKey$kotlin_stdlib);
        return v2;
    }

    public final boolean removeEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        checkIsMutable$kotlin_stdlib();
        int findKey = findKey(entry.getKey());
        if (findKey < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        Intrinsics.checkNotNull(vArr);
        if (!Intrinsics.areEqual(vArr[findKey], entry.getValue())) {
            return false;
        }
        removeKeyAt(findKey);
        return true;
    }

    public final int removeKey$kotlin_stdlib(K k2) {
        checkIsMutable$kotlin_stdlib();
        int findKey = findKey(k2);
        if (findKey < 0) {
            return -1;
        }
        removeKeyAt(findKey);
        return findKey;
    }

    public final boolean removeValue$kotlin_stdlib(V v2) {
        checkIsMutable$kotlin_stdlib();
        int findValue = findValue(v2);
        if (findValue < 0) {
            return false;
        }
        removeKeyAt(findValue);
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((size() * 3) + 2);
        sb.append("{");
        EntriesItr<K, V> entriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i = 0;
        while (entriesIterator$kotlin_stdlib.hasNext()) {
            if (i > 0) {
                sb.append(", ");
            }
            entriesIterator$kotlin_stdlib.nextAppendString(sb);
            i++;
        }
        sb.append("}");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    public final ValuesItr<K, V> valuesIterator$kotlin_stdlib() {
        return new ValuesItr<>(this);
    }

    public MapBuilder() {
        this(8);
    }

    public MapBuilder(int i) {
        this(ListBuilderKt.arrayOfUninitializedElements(i), null, new int[i], new int[Companion.computeHashSize(i)], 2, 0);
    }
}
