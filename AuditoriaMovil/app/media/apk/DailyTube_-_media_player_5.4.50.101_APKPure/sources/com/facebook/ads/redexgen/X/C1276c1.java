package com.facebook.ads.redexgen.X;

import com.uv.v7.R;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\nJ\u001d\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\rJ\u001d\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u000fJ%\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0013J\u001d\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0017J%\u0010\u0018\u001a\u00020\u00192\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001b2\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0000¢\u0006\u0002\b\u001dJ\u0019\u0010\u001e\u001a\u00020\u00042\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0000¢\u0006\u0002\b\u001fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lkotlin/collections/AbstractList$Companion;", "", "()V", "maxArraySize", "", "checkBoundsIndexes", "", "startIndex", "endIndex", "size", "checkBoundsIndexes$kotlin_stdlib", "checkElementIndex", "index", "checkElementIndex$kotlin_stdlib", "checkPositionIndex", "checkPositionIndex$kotlin_stdlib", "checkRangeIndexes", "fromIndex", "toIndex", "checkRangeIndexes$kotlin_stdlib", "newCapacity", "oldCapacity", "minCapacity", "newCapacity$kotlin_stdlib", "orderedEquals", "", "c", "", "other", "orderedEquals$kotlin_stdlib", "orderedHashCode", "orderedHashCode$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* renamed from: com.facebook.ads.redexgen.X.c1  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1276c1 {
    public static byte[] A00;
    public static String[] A01 = {"KuTCkc88m5Khn4CyGrhwL", "IxLDI0IPbZApfW", "JVK2BzSuCceVtUDdSj5I07", "lBsBUWPEcrP06ZbqPLvUU4J", "22gZmP1JxBFCsFHb94EDAJ1IphHRhPLW", "4VOii7FoXK5P7l8zZ6nforp6Ebd", "RjeQAgQKhl5JskIp4JuQN5iIalMDBvKB", "EBwOVG6Ugh4W3c0PQTNtiW44jE9"};

    public /* synthetic */ C1276c1(AbstractC1271bv abstractC1271bv) {
        this();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 70);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-105, -75, -105, -21, -26, -64, -27, -37, -36, -17, -79, -105, -113, -125, -42, -52, -35, -56, -99, -125, -120, 124, -48, -53, -91, -54, -64, -63, -44, -106, 124, 29, 3, 15, 12, 10, -26, 11, 1, 2, 21, -41, -67, -30, -25, -35, -34, -15, -77, -103, 37, 42, 30, 27, 40};
    }

    static {
        A01();
    }

    public C1276c1() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0059, code lost:
        if (r4 != null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x005b, code lost:
        r0 = r4.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0061, code lost:
        if (r4 != null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0064, code lost:
        r0 = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int A02(java.util.Collection<?> r7) {
        /*
            r6 = this;
            r2 = 31
            r1 = 1
            r0 = 116(0x74, float:1.63E-43)
            java.lang.String r0 = A00(r2, r1, r0)
            com.facebook.ads.redexgen.X.C1270bu.A07(r7, r0)
            r3 = 1
            java.util.Iterator r5 = r7.iterator()
        L11:
            boolean r4 = r5.hasNext()
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1276c1.A01
            r0 = 3
            r1 = r2[r0]
            r0 = 2
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L67
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1276c1.A01
            java.lang.String r1 = "SCwB4moZZna0suClCc4GjhLyaW7wqAtq"
            r0 = 6
            r2[r0] = r1
            java.lang.String r1 = "mduzLj9uz3KnspGGdaJJ9nMm6LkrQb3g"
            r0 = 4
            r2[r0] = r1
            if (r4 == 0) goto L66
            java.lang.Object r4 = r5.next()
            int r3 = r3 * 31
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1276c1.A01
            r0 = 3
            r1 = r2[r0]
            r0 = 2
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L61
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1276c1.A01
            java.lang.String r1 = "hMwjEsxw7wl5skWc3rQN1oqLejAug6sa"
            r0 = 6
            r2[r0] = r1
            java.lang.String r1 = "wRbKU8F1FGogs5q469JLSPNenN0joauE"
            r0 = 4
            r2[r0] = r1
            if (r4 == 0) goto L64
        L5b:
            int r0 = r4.hashCode()
        L5f:
            int r3 = r3 + r0
            goto L11
        L61:
            if (r4 == 0) goto L64
            goto L5b
        L64:
            r0 = 0
            goto L5f
        L66:
            return r3
        L67:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1276c1.A02(java.util.Collection):int");
    }

    public final void A03(int i, int i5) {
        if (i >= 0 && i < i5) {
            return;
        }
        throw new IndexOutOfBoundsException(A00(43, 7, 51) + i + A00(12, 8, 29) + i5);
    }

    public final void A04(int i, int i5) {
        if (i >= 0 && i <= i5) {
            return;
        }
        throw new IndexOutOfBoundsException(A00(43, 7, 51) + i + A00(12, 8, 29) + i5);
    }

    public final void A05(int i, int i5, int i6) {
        String A002 = A00(32, 11, 87);
        if (i >= 0 && i5 <= i6) {
            if (i <= i5) {
                return;
            }
            throw new IllegalArgumentException(A002 + i + A00(0, 12, 49) + i5);
        }
        throw new IndexOutOfBoundsException(A002 + i + A00(20, 11, 22) + i5 + A00(12, 8, 29) + i6);
    }

    public final boolean A06(Collection<?> collection, Collection<?> collection2) {
        C1270bu.A07(collection, A00(31, 1, 116));
        C1270bu.A07(collection2, A00(50, 5, R.styleable.AppCompatTheme_toolbarNavigationButtonStyle));
        if (collection.size() != collection2.size()) {
            return false;
        }
        Iterator<?> it = collection2.iterator();
        Iterator<?> it2 = collection.iterator();
        while (it2.hasNext()) {
            if (!C1270bu.A0A(it2.next(), it.next())) {
                return false;
            }
        }
        return true;
    }
}
