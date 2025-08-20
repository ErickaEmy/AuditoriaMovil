package com.facebook.ads.redexgen.X;

import java.io.IOException;
/* renamed from: com.facebook.ads.redexgen.X.9c  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C04879c extends Exception {
    public final int A00;
    public final int A01;

    public C04879c(int i, String str, Throwable th, int i5) {
        super(str, th);
        this.A01 = i;
        this.A00 = i5;
    }

    public static C04879c A00(IOException iOException) {
        return new C04879c(0, null, iOException, -1);
    }

    public static C04879c A01(Exception exc, int i) {
        return new C04879c(1, null, exc, i);
    }

    public static C04879c A02(RuntimeException runtimeException) {
        return new C04879c(2, null, runtimeException, -1);
    }
}
