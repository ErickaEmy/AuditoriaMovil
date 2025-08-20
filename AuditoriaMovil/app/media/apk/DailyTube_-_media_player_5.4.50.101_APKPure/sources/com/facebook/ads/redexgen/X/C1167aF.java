package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.aF  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1167aF {
    public static byte[] A03;
    public final C2R A00;
    public final QK A01;
    public final List<C1166aE> A02;

    static {
        A01();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 49);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{126, 121, 108, 121, 100, 126, 121, 100, 110, 126, 106, 123, 109, 106, 109};
    }

    public C1167aF(List<C2P> list, Bundle bundle, QK qk2) {
        this.A02 = new ArrayList(list.size());
        this.A01 = qk2;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(A00(10, 5, 15));
        for (int i = 0; i < list.size(); i++) {
            this.A02.add(new C1166aE(list.get(i), (Bundle) parcelableArrayList.get(i)));
        }
        this.A00 = (C2R) LR.A00(bundle.getByteArray(A00(0, 10, 28)));
    }

    public C1167aF(List<C2P> list, QK qk2) {
        this.A02 = new ArrayList(list.size());
        this.A01 = qk2;
        for (C2P c2p : list) {
            this.A02.add(new C1166aE(c2p));
        }
        this.A00 = new C2R();
    }

    public final Bundle A02() {
        Bundle bundle = new Bundle();
        bundle.putByteArray(A00(0, 10, 28), LR.A01(this.A00));
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(this.A02.size());
        for (C1166aE c1166aE : this.A02) {
            Bundle bundle2 = c1166aE.A05();
            arrayList.add(bundle2);
        }
        bundle.putParcelableArrayList(A00(10, 5, 15), arrayList);
        return bundle;
    }

    public final C2R A03() {
        return this.A00;
    }

    public final void A04() {
        this.A00.A03();
        for (C1166aE c1166aE : this.A02) {
            c1166aE.A06();
        }
    }

    public final void A05() {
        this.A00.A02();
    }

    public final void A06(double d2, double d3) {
        if (d3 >= 0.0d) {
            this.A00.A05(d2, d3);
        }
        double A8K = this.A01.A8K();
        this.A00.A04(d2, A8K);
        for (C1166aE c1166aE : this.A02) {
            c1166aE.A07(d2, A8K);
        }
    }
}
