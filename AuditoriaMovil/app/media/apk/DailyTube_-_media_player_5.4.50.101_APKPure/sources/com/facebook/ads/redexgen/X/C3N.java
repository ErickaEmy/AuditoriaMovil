package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.RandomAccess;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0002\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B#\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0016\u0010\u000e\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0002\u0010\u0010R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lkotlin/collections/AbstractList$SubList;", "E", "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "list", "fromIndex", "", "toIndex", "(Lkotlin/collections/AbstractList;II)V", "_size", "size", "getSize", "()I", "get", "index", "(I)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* renamed from: com.facebook.ads.redexgen.X.3N  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C3N<E> extends AbstractC04346u<E> implements RandomAccess {
    public static byte[] A03;
    public int A00;
    public final int A01;
    public final AbstractC04346u<E> A02;

    static {
        A01();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 57);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{15, 10, 16, 23};
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C3N(AbstractC04346u<? extends E> abstractC04346u, int i, int i5) {
        C1270bu.A07(abstractC04346u, A00(0, 4, 90));
        this.A02 = abstractC04346u;
        this.A01 = i;
        AbstractC04346u.A02.A05(i, i5, abstractC04346u.size());
        this.A00 = i5 - i;
    }

    @Override // com.facebook.ads.redexgen.X.H0
    public final int A0A() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC04346u, java.util.List
    public final E get(int i) {
        AbstractC04346u.A02.A03(i, this.A00);
        return this.A02.get(this.A01 + i);
    }
}
