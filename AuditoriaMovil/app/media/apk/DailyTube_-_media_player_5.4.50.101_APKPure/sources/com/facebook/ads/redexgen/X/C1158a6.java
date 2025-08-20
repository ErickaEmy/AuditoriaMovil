package com.facebook.ads.redexgen.X;

import java.util.Map;
/* JADX INFO: Add missing generic type declarations: [V, K] */
/* renamed from: com.facebook.ads.redexgen.X.a6  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1158a6<K, V> extends AbstractC03412y<K, V> {
    public final /* synthetic */ C1157a5 A00;

    public C1158a6(C1157a5 c1157a5) {
        this.A00 = c1157a5;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC03412y
    public final int A04() {
        return ((AnonymousClass31) this.A00).A00;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC03412y
    public final int A05(Object obj) {
        return this.A00.A08(obj);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC03412y
    public final int A06(Object obj) {
        return this.A00.A07(obj);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC03412y
    public final Map<K, V> A07() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC03412y
    public final Object A0B(int i, int i5) {
        return this.A00.A02[(i << 1) + i5];
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC03412y
    public final V A0C(int i, V value) {
        return this.A00.A0C(i, value);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC03412y
    public final void A0D() {
        this.A00.clear();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC03412y
    public final void A0E(int i) {
        this.A00.A0A(i);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC03412y
    public final void A0F(K key, V value) {
        this.A00.put(key, value);
    }
}
