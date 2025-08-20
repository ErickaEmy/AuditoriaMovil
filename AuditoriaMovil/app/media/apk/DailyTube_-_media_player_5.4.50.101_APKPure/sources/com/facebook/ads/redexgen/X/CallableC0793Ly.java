package com.facebook.ads.redexgen.X;

import java.util.concurrent.Callable;
/* renamed from: com.facebook.ads.redexgen.X.Ly  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class CallableC0793Ly implements Callable<Void> {
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int[] A06;

    public CallableC0793Ly(int[] iArr, int i, int i5, int i6, int i8, int i10, int i11) {
        this.A06 = iArr;
        this.A05 = i;
        this.A01 = i5;
        this.A02 = i6;
        this.A04 = i8;
        this.A00 = i10;
        this.A03 = i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.Callable
    /* renamed from: A00 */
    public final Void call() throws Exception {
        C1003Ua.A00(this.A06, this.A05, this.A01, this.A02, this.A04, this.A00, this.A03);
        return null;
    }
}
