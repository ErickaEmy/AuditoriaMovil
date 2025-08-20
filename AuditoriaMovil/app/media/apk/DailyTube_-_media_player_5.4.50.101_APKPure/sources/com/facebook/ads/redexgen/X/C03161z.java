package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdSettings;
/* renamed from: com.facebook.ads.redexgen.X.1z  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public /* synthetic */ class C03161z {
    public static final /* synthetic */ int[] A00;

    static {
        int[] iArr = new int[AdSettings.IntegrationErrorMode.values().length];
        A00 = iArr;
        try {
            iArr[AdSettings.IntegrationErrorMode.INTEGRATION_ERROR_CRASH_DEBUG_MODE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            A00[AdSettings.IntegrationErrorMode.INTEGRATION_ERROR_CALLBACK_MODE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
