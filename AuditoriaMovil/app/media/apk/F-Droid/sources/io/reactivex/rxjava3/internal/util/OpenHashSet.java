package io.reactivex.rxjava3.internal.util;
/* loaded from: classes.dex */
public final class OpenHashSet {
    Object[] keys;
    final float loadFactor;
    int mask;
    int maxSize;
    int size;

    static int mix(int i) {
        int i2 = i * (-1640531527);
        return i2 ^ (i2 >>> 16);
    }

    public Object[] keys() {
        return this.keys;
    }

    public OpenHashSet() {
        this(16, 0.75f);
    }

    public OpenHashSet(int i, float f) {
        this.loadFactor = f;
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(i);
        this.mask = roundToPowerOfTwo - 1;
        this.maxSize = (int) (f * roundToPowerOfTwo);
        this.keys = new Object[roundToPowerOfTwo];
    }

    public boolean add(Object obj) {
        Object obj2;
        Object[] objArr = this.keys;
        int i = this.mask;
        int mix = mix(obj.hashCode()) & i;
        Object obj3 = objArr[mix];
        if (obj3 != null) {
            if (obj3.equals(obj)) {
                return false;
            }
            do {
                mix = (mix + 1) & i;
                obj2 = objArr[mix];
                if (obj2 == null) {
                }
            } while (!obj2.equals(obj));
            return false;
        }
        objArr[mix] = obj;
        int i2 = this.size + 1;
        this.size = i2;
        if (i2 >= this.maxSize) {
            rehash();
        }
        return true;
    }

    public boolean remove(Object obj) {
        Object obj2;
        Object[] objArr = this.keys;
        int i = this.mask;
        int mix = mix(obj.hashCode()) & i;
        Object obj3 = objArr[mix];
        if (obj3 == null) {
            return false;
        }
        if (obj3.equals(obj)) {
            return removeEntry(mix, objArr, i);
        }
        do {
            mix = (mix + 1) & i;
            obj2 = objArr[mix];
            if (obj2 == null) {
                return false;
            }
        } while (!obj2.equals(obj));
        return removeEntry(mix, objArr, i);
    }

    boolean removeEntry(int i, Object[] objArr, int i2) {
        int i3;
        Object obj;
        this.size--;
        while (true) {
            int i4 = i + 1;
            while (true) {
                i3 = i4 & i2;
                obj = objArr[i3];
                if (obj == null) {
                    objArr[i] = null;
                    return true;
                }
                int mix = mix(obj.hashCode()) & i2;
                if (i > i3) {
                    if (i >= mix && mix > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                } else if (i < mix && mix <= i3) {
                    i4 = i3 + 1;
                }
            }
            objArr[i] = obj;
            i = i3;
        }
    }

    void rehash() {
        Object obj;
        Object[] objArr = this.keys;
        int length = objArr.length;
        int i = length << 1;
        int i2 = i - 1;
        Object[] objArr2 = new Object[i];
        int i3 = this.size;
        while (true) {
            int i4 = i3 - 1;
            if (i3 == 0) {
                this.mask = i2;
                this.maxSize = (int) (i * this.loadFactor);
                this.keys = objArr2;
                return;
            }
            do {
                length--;
                obj = objArr[length];
            } while (obj == null);
            int mix = mix(obj.hashCode()) & i2;
            if (objArr2[mix] != null) {
                do {
                    mix = (mix + 1) & i2;
                } while (objArr2[mix] != null);
            }
            objArr2[mix] = objArr[length];
            i3 = i4;
        }
    }
}
