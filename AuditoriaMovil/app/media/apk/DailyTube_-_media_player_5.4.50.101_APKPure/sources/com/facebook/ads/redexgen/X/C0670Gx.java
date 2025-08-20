package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
/* JADX INFO: Add missing generic type declarations: [E] */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0092\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\t\u001a\u00020\nH\u0096\u0002J\u000e\u0010\u000b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\fR\u001a\u0010\u0003\u001a\u00020\u0004X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lkotlin/collections/AbstractList$IteratorImpl;", "", "(Lkotlin/collections/AbstractList;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* renamed from: com.facebook.ads.redexgen.X.Gx  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0670Gx<E> implements Iterator<E> {
    public static byte[] A02;
    public int A00;
    public final /* synthetic */ AbstractC04346u<E> A01;

    static {
        A03();
    }

    public static String A02(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 117);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A02 = new byte[]{48, 15, 26, 13, 30, 11, 22, 16, 17, 95, 22, 12, 95, 17, 16, 11, 95, 12, 10, 15, 15, 16, 13, 11, 26, 27, 95, 25, 16, 13, 95, 13, 26, 30, 27, 82, 16, 17, 19, 6, 95, 28, 16, 19, 19, 26, 28, 11, 22, 16, 17};
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException(A02(0, 51, 10));
    }

    public C0670Gx(AbstractC04346u abstractC04346u) {
        this.A01 = abstractC04346u;
    }

    public final int A04() {
        return this.A00;
    }

    public final void A05(int i) {
        this.A00 = i;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.A00 < this.A01.size();
    }

    @Override // java.util.Iterator
    public final E next() {
        if (hasNext()) {
            AbstractC04346u<E> abstractC04346u = this.A01;
            int i = this.A00;
            this.A00 = i + 1;
            return abstractC04346u.get(i);
        }
        throw new NoSuchElementException();
    }
}
