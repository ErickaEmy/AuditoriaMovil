package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.bridge.fbsdk.FBLoginASID;
import com.facebook.ads.internal.bridge.gms.AdvertisingId;
import com.facebook.ads.internal.settings.AdInternalSettings;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class YO implements C7k {
    public static byte[] A01;
    public static String[] A02 = {"5s7Vvh0NyBhQSPw27iRWGG1DtqQsP1Sv", "FrTyZebbkrmGpsa0d1dFSR1fbKrcWzi5", "vbBgTS8gp4295EX74czAq4g", "ai", "WolquZ0AL0Qdfn", "cakCtq0fnE5al5DYRrCiV1B2lu7xESbR", "HXQXhYUpdji2Kg3a54R03lC9IEJsCvaM", "NPxj8bqKiKcB9Z0ZqCVSMRQGt9eaxHA1"};
    public final C04447f A00;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 16);
            String[] strArr = A02;
            if (strArr[2].length() == strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[0] = "3cPMFplOUK5Ssg4O5bRCUJRCJG4m75Bq";
            strArr2[6] = "bSCrfJrMY4RCrVdm5HRU5l61ngvuX2qf";
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-81, -36, -46, -32, -35, -41, -46};
    }

    static {
        A01();
    }

    public YO(C04447f c04447f) {
        this.A00 = c04447f;
    }

    @Override // com.facebook.ads.redexgen.X.C7k
    public final String A6E() {
        return null;
    }

    @Override // com.facebook.ads.redexgen.X.C7k
    public final String A73() {
        return K9.A02(this.A00);
    }

    @Override // com.facebook.ads.redexgen.X.C7k
    public final String A74() {
        return FBLoginASID.getFBLoginASID();
    }

    @Override // com.facebook.ads.redexgen.X.C7k
    public final String A7P() {
        return AdInternalSettings.getMediationService();
    }

    @Override // com.facebook.ads.redexgen.X.C7k
    public final String A7V() {
        return null;
    }

    @Override // com.facebook.ads.redexgen.X.C7k
    public final InterfaceC04477j A7p() {
        AdvertisingId advertisingIdInfoDirectly = AdvertisingId.getAdvertisingIdInfoDirectly(this.A00);
        if (advertisingIdInfoDirectly == null) {
            return null;
        }
        return new YP(this, advertisingIdInfoDirectly);
    }

    @Override // com.facebook.ads.redexgen.X.C7k
    public final String A8F() {
        return AdInternalSettings.getUrlPrefix();
    }

    @Override // com.facebook.ads.redexgen.X.C7k
    public final String A8H() {
        return A00(0, 7, 94);
    }

    @Override // com.facebook.ads.redexgen.X.C7k
    public final String A8I() {
        return BuildConfigApi.getVersionName(this.A00);
    }

    @Override // com.facebook.ads.redexgen.X.C7k
    public final boolean A8z() {
        return BuildConfigApi.isDebug();
    }
}
