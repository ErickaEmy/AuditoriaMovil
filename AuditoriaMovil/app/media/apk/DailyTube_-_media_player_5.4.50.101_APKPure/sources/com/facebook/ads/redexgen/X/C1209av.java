package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdError;
import java.util.ArrayList;
/* renamed from: com.facebook.ads.redexgen.X.av  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1209av implements C6U {
    public static String[] A05 = {"udExhBBZigXHD765", "VCbgsgLtwNII3DWSf3Df", "sJ3cSki5Ts1gkpIy0", "hudoenMQ7OfQJqKUwYviTAHkC5956B", "3GiDDKpH2PPu7", "VAV0OzmNbR17K1ZAu", "eIBPlY8UdwZIA15YBWaPzTw3Re1i6Niv", "w6ShnqqW6c5InpRu2fdQvGfdyx0XiT7r"};
    public final /* synthetic */ AbstractC1219b5 A00;
    public final /* synthetic */ InterfaceC02981h A01;
    public final /* synthetic */ C02991i A02;
    public final /* synthetic */ C1116Yn A03;
    public final /* synthetic */ boolean A04;

    public C1209av(C02991i c02991i, C1116Yn c1116Yn, boolean z2, AbstractC1219b5 abstractC1219b5, InterfaceC02981h interfaceC02981h) {
        this.A02 = c02991i;
        this.A03 = c1116Yn;
        this.A04 = z2;
        this.A00 = abstractC1219b5;
        this.A01 = interfaceC02981h;
    }

    private void A00(boolean z2) {
        ArrayList arrayList;
        if (z2) {
            C1116Yn c1116Yn = this.A03;
            String[] strArr = A05;
            if (strArr[7].length() != strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A05;
            strArr2[5] = "ua1Hqbcww3qJrVJ6O";
            strArr2[2] = "2U70GzBDbPON7gkn8";
            if (C0705Ih.A1O(c1116Yn) && this.A04) {
                arrayList = this.A02.A02;
                arrayList.add(PC.A01(this.A03, this.A00, 1, new C1210aw(this)));
                return;
            }
            this.A01.AAf();
            return;
        }
        this.A01.AAe(AdError.CACHE_ERROR);
    }

    @Override // com.facebook.ads.redexgen.X.C6U
    public final void AB2() {
        A00(false);
    }

    @Override // com.facebook.ads.redexgen.X.C6U
    public final void ABB() {
        A00(true);
    }
}
