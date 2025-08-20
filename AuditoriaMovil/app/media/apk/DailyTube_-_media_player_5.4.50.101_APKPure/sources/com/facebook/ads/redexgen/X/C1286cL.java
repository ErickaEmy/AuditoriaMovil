package com.facebook.ads.redexgen.X;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.cL  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1286cL {
    public final InterfaceC1290cP A00;
    public final String A01;
    public final Collection<C1300ca> A02;
    public final Collection<C1300ca> A03;
    public final List<Rect> A04;

    public C1286cL(String str, InterfaceC1290cP interfaceC1290cP, List<Rect> rects, Collection<C1300ca> collection, Collection<C1300ca> collection2) {
        this.A01 = str;
        this.A00 = interfaceC1290cP;
        this.A04 = new ArrayList(rects);
        this.A02 = collection;
        this.A03 = collection2;
    }
}
