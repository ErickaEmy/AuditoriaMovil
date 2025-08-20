package com.facebook.ads.redexgen.X;

import android.app.Activity;
import android.os.Bundle;
import com.facebook.ads.internal.api.AudienceNetworkExportedActivityApi;
import java.util.Arrays;
import java.util.UUID;
/* renamed from: com.facebook.ads.redexgen.X.Iv  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0717Iv implements AudienceNetworkExportedActivityApi {
    public static byte[] A01;
    public static String[] A02 = {"lqcZKkXS6TgOyt76sZ5yjVO68Nd1QdQN", "bQWyI3suGbnh3U5StjCALiPIzXDV3Wa6", "hqk98641WxUvYLytASVEQqAqBzewRvKz", "WJUhx8cI8X6XmYecnMlLMKWkuLUkkXH9", "MP1e4gCZR", "1EPuqCSCyQ9J2YoomIIpPWX0Nb9xTOcz", "0suERcaSwAa0E2CxcbYZCTLc9cS16", "2TigNonfP4HCMPOeSAXXuXDynNOGBzuQ"};
    public final Activity A00;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 97);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        byte[] bArr = {126, 121, 99, 104, 101, 97, 104, 118, 103, 103, 104, 120, 101, 126, 114, 121, 99, 118, 99, 126, 120, 121, 104, 124, 114, 110, 61, 58, 60, 49, 47, 42, 49, 39, 42, 49, 37, 43, 55};
        if (A02[2].charAt(23) != 'q') {
            throw new RuntimeException();
        }
        A02[2] = "wLiEtUSufX2SvKxRiuuw2ghqe6rTYyXA";
        A01 = bArr;
    }

    static {
        A01();
    }

    public C0717Iv(Activity activity) {
        this.A00 = activity;
    }

    private void A02(int i) {
        this.A00.setResult(i);
        this.A00.finish();
    }

    private boolean A03(C0716Iu c0716Iu) {
        String callingPackage = this.A00.getCallingPackage();
        if (callingPackage != null) {
            String callingPackage2 = c0716Iu.A03;
            if (callingPackage.equals(callingPackage2)) {
                return true;
            }
        }
        A02(12);
        if (c0716Iu.A00 instanceof C1181aT) {
            ((C1181aT) c0716Iu.A00).A0F().A0E().AEj();
        }
        if (c0716Iu.A00 instanceof C1178aQ) {
            ((C1178aQ) c0716Iu.A00).A0H().A0E().AEj();
            return false;
        }
        return false;
    }

    public final void onCreate(Bundle bundle) {
        C1116Yn A05 = C03955c.A05(this.A00, UUID.randomUUID().toString());
        if (this.A00.isTaskRoot()) {
            A05.A0E().AEc();
            A02(10);
            return;
        }
        String adId = this.A00.getIntent().getStringExtra(A00(26, 13, 15));
        if (adId == null) {
            A05.A0E().AEf();
            A02(11);
            return;
        }
        C0716Iu A04 = VW.A00().A04(adId);
        AnonymousClass23 anonymousClass23 = A04 != null ? A04.A00 : null;
        if (A02[6].length() == 29) {
            A02[6] = "3hvfYctBGPg0BeMvR8jiqRXkEjCpv";
            if (A04 != null && (anonymousClass23 instanceof C1178aQ)) {
                if (!A03(A04)) {
                    return;
                }
                C1178aQ c1178aQ = (C1178aQ) anonymousClass23;
                c1178aQ.A0G().A02().A0I(this.A00);
                c1178aQ.A0M(this.A00.getIntent().getIntExtra(A00(0, 26, 86), -1), 0L);
            } else {
                if (A04 != null) {
                    boolean z2 = anonymousClass23 instanceof C1181aT;
                    if (A02[1].charAt(21) == 'i') {
                        A02[2] = "XUW1n7Q8abvbP2RLETYRfIyqCZkI4d7q";
                        if (z2) {
                            if (!A03(A04)) {
                                return;
                            }
                            C1181aT c1181aT = (C1181aT) anonymousClass23;
                            c1181aT.A0E().A05().A0I(this.A00);
                            c1181aT.A0J();
                        }
                    }
                }
                A05.A0E().AF5();
                A02(13);
                return;
            }
            this.A00.setResult(-1);
            this.A00.finish();
            return;
        }
        throw new RuntimeException();
    }
}
