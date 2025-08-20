package com.facebook.ads.redexgen.X;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.uv.v7.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.Wo  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1065Wo implements InterfaceC0554Bs {
    public static byte[] A0C;
    public static String[] A0D = {"1uxTk9uu8NGqb4bRD7SiE7", "Ssi3SEW4IwUGp9bqpG4lGM81x4BmU482", "xmiG4gye91jMk16VeYAf2JsNYB9ZLAXn", "P3M63oXZ4RlItM7d6tCP0FhU4UJB0VVm", "pvrI0I2hPgkxZ7mKqcVNCE", "IViSy7bNMMRqTObQqgQHZJ03ioQVAxI3", "AKSfxMAYbymYkKmkIHXjHayRWnu0Srjs", "XaZNcJans0E3GSdApjoK7oUba6xaED3H"};
    public static final InterfaceC0557Bv A0E;
    public static final long A0F;
    public static final long A0G;
    public static final long A0H;
    public int A00;
    public int A01;
    public InterfaceC0556Bu A02;
    public DD A03;
    public boolean A04;
    public final int A05;
    public final SparseArray<DD> A06;
    public final SparseBooleanArray A07;
    public final SparseIntArray A08;
    public final DB A09;
    public final C0697Hz A0A;
    public final List<IB> A0B;

    public static String A0D(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0C, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 25);
        }
        return new String(copyOfRange);
    }

    public static void A0G() {
        A0C = new byte[]{-64, -62, -84, -78, -106, -76, -63, -63, -62, -57, 115, -71, -68, -63, -73, 115, -58, -52, -63, -74, 115, -75, -52, -57, -72, -127, 115, -96, -62, -58, -57, 115, -65, -68, -66, -72, -65, -52, 115, -63, -62, -57, 115, -76, 115, -89, -59, -76, -63, -58, -61, -62, -59, -57, 115, -90, -57, -59, -72, -76, -64, -127, 115, 111, 113, 97, -53, -56, -39, -58};
    }

    static {
        A0G();
        A0E = new C1068Wr();
        A0F = IF.A08(A0D(0, 4, 102));
        A0G = IF.A08(A0D(62, 4, 21));
        A0H = IF.A08(A0D(66, 4, R.styleable.AppCompatTheme_textAppearancePopupMenuHeader));
    }

    public C1065Wo() {
        this(0);
    }

    public C1065Wo(int i) {
        this(1, i);
    }

    public C1065Wo(int i, int i5) {
        this(i, new IB(0L), new X5(i5));
    }

    public C1065Wo(int i, IB ib, DB db) {
        this.A09 = (DB) AbstractC0672Ha.A01(db);
        this.A05 = i;
        if (i == 1 || i == 2) {
            this.A0B = Collections.singletonList(ib);
        } else {
            ArrayList arrayList = new ArrayList();
            this.A0B = arrayList;
            arrayList.add(ib);
        }
        this.A0A = new C0697Hz(new byte[9400], 0);
        this.A07 = new SparseBooleanArray();
        this.A06 = new SparseArray<>();
        this.A08 = new SparseIntArray();
        A0F();
    }

    public static /* synthetic */ int A01(C1065Wo c1065Wo) {
        int i = c1065Wo.A01;
        c1065Wo.A01 = i + 1;
        return i;
    }

    private void A0F() {
        this.A07.clear();
        this.A06.clear();
        SparseArray<DD> A4d = this.A09.A4d();
        int size = A4d.size();
        for (int i = 0; i < size; i++) {
            SparseArray<DD> sparseArray = this.A06;
            int initialPayloadReadersSize = A4d.keyAt(i);
            sparseArray.put(initialPayloadReadersSize, A4d.valueAt(i));
        }
        this.A06.put(0, new C1070Wt(new C1067Wq(this)));
        this.A03 = null;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0554Bs
    public final void A8o(InterfaceC0556Bu interfaceC0556Bu) {
        this.A02 = interfaceC0556Bu;
        interfaceC0556Bu.AFi(new C1086Xj(-9223372036854775807L));
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0094, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x013a, code lost:
        if ((r12 & 32) != 0) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x013c, code lost:
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0167, code lost:
        if ((r12 & 32) != 0) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x016a, code lost:
        r10 = false;
     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0554Bs
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int AEH(com.facebook.ads.redexgen.X.InterfaceC0555Bt r14, com.facebook.ads.redexgen.X.C0559Bz r15) throws java.io.IOException, java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 438
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1065Wo.AEH(com.facebook.ads.redexgen.X.Bt, com.facebook.ads.redexgen.X.Bz):int");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0554Bs
    public final void AFh(long j2, long j4) {
        int size = this.A0B.size();
        for (int i = 0; i < size; i++) {
            this.A0B.get(i).A08();
        }
        this.A0A.A0V();
        this.A08.clear();
        A0F();
        this.A00 = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
        r3 = r3 + 1;
     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0554Bs
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean AGR(com.facebook.ads.redexgen.X.InterfaceC0555Bt r7) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r6 = this;
            com.facebook.ads.redexgen.X.Hz r0 = r6.A0A
            byte[] r5 = r0.A00
            r0 = 940(0x3ac, float:1.317E-42)
            r4 = 0
            r7.ADv(r5, r4, r0)
            r3 = 0
        Lb:
            r0 = 188(0xbc, float:2.63E-43)
            if (r3 >= r0) goto L27
            r2 = 0
        L10:
            r0 = 5
            if (r2 != r0) goto L18
            r7.AGP(r3)
            r0 = 1
            return r0
        L18:
            int r0 = r2 * 188
            int r0 = r0 + r3
            r1 = r5[r0]
            r0 = 71
            if (r1 == r0) goto L24
            int r3 = r3 + 1
            goto Lb
        L24:
            int r2 = r2 + 1
            goto L10
        L27:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1065Wo.AGR(com.facebook.ads.redexgen.X.Bt):boolean");
    }
}
