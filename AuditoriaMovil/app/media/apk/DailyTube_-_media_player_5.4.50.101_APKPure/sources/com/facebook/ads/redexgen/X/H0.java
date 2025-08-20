package com.facebook.ads.redexgen.X;

import com.uv.v7.R;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0007\b\u0004¢\u0006\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H¦\u0002J\u0015\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0015¢\u0006\u0002\u0010\u0014J'\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0012\"\u0004\b\u0001\u0010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0012H\u0014¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001a"}, d2 = {"Lkotlin/collections/AbstractCollection;", "E", "", "()V", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "isEmpty", "iterator", "", "toArray", "", "", "()[Ljava/lang/Object;", "T", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: assets/audience_network.dex */
public abstract class H0<E> implements Collection<E> {
    public static byte[] A00;
    public static String[] A01 = {"vpqNXUEZRAyywosRDfA1klskIajZed", "OHtIs9AL0l", "MLwNR7EASioILyVlIbGXwLV7TCbYE8Bh", "wPJI2GbFDuXbz4x7LgUCS1JDTvkmrQWe", "Oad1wY6FMbzjC20tZEnzqVoj9IblLiUi", "lRmyixXyRoksWskF89hESh3U8UhIe2Vs", "nkJYZkIWegDMfSCLriuG3dJId", "kWatFbSy5VoKX3rN5NMrFvDtFj2em1kx"};

    public static String A08(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 28);
        }
        return new String(copyOfRange);
    }

    public static void A09() {
        A00 = new byte[]{72, 60, 122, -101, -112, -99, -116, -97, -108, -102, -103, 75, -108, -98, 75, -103, -102, -97, 75, -98, -96, -101, -101, -102, -99, -97, -112, -113, 75, -111, -102, -99, 75, -99, -112, -116, -113, 88, -102, -103, -105, -92, 75, -114, -102, -105, -105, -112, -114, -97, -108, -102, -103, -114, -20, -95, -78, -78, -95, -71, -85, -78, -85, -77, -85, -76, -70, -71};
    }

    public abstract int A0A();

    @Override // java.util.Collection
    public final boolean add(E e2) {
        throw new UnsupportedOperationException(A08(2, 51, 15));
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException(A08(2, 51, 15));
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException(A08(2, 51, 15));
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection
    public final boolean containsAll(Collection<? extends Object> collection) {
        C1270bu.A07(collection, A08(60, 8, 42));
        Collection<? extends Object> collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        for (Object obj : collection2) {
            if (!contains(obj)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public abstract Iterator<E> iterator();

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException(A08(2, 51, 15));
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException(A08(2, 51, 15));
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException(A08(2, 51, 15));
    }

    static {
        A09();
    }

    @Override // java.util.Collection, java.util.List
    public boolean contains(E e2) {
        H0<E> h0 = this;
        if ((h0 instanceof Collection) && h0.isEmpty()) {
            return false;
        }
        for (E e3 : h0) {
            boolean A0A = C1270bu.A0A(e3, e2);
            String[] strArr = A01;
            if (strArr[1].length() == strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[1] = "sRJmN2MMEv";
            strArr2[0] = "rlos11EJgA8vpDSt1wHrGDeXVXDu3T";
            if (A0A) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return A0A();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return AbstractC1272bw.A02(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        C1270bu.A07(tArr, A08(55, 5, 36));
        return (T[]) AbstractC1272bw.A03(this, tArr);
    }

    public final String toString() {
        return C0R.A03(this, A08(0, 2, 0), A08(53, 1, 23), A08(54, 1, R.styleable.AppCompatTheme_tooltipFrameBackground), 0, null, new C3O(this), 24, null);
    }
}
