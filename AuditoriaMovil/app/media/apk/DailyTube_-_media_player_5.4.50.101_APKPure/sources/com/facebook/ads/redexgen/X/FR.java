package com.facebook.ads.redexgen.X;

import android.view.View;
import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: assets/audience_network.dex */
public final class FR extends AbstractC1200am {
    public static byte[] A03;
    public long A00;
    public View A01;
    public EQ A02;

    static {
        A05();
    }

    public static String A03(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 12);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A03 = new byte[]{60, 57, 46, 41, 42, 37, 37, 46, 57, 20, 57, 46, 45, 57, 46, 56, 35, 20, 63, 34, 38, 46, 4, 15, 6, 14, 9, 56, 23, 6, 21, 6, 10, 20, 3, 20, 109, 122, 122, 103, 122, 40, Byte.MAX_VALUE, 96, 97, 100, 109, 40, 120, 105, 122, 123, 97, 102, 111, 40, 107, 96, 105, 97, 102, 109, 108, 40, 105, 108, 123, 40, 74, 105, 102, 102, 109, 122};
    }

    public FR(EQ eq, C03111u c03111u) {
        super(eq, c03111u);
        this.A00 = 10000L;
        this.A02 = eq;
    }

    private C1203ap A01(Runnable runnable) {
        return new C1203ap(this, runnable);
    }

    private List<JSONObject> A04(C03121v c03121v) {
        ArrayList arrayList = new ArrayList();
        JSONObject A032 = c03121v.A03();
        String A033 = A03(22, 12, 107);
        if (A032.has(A033)) {
            try {
                this.A00 = A032.getJSONObject(A033).optInt(A03(3, 19, 71), 10000);
                JSONArray adsArray = A032.getJSONArray(A03(0, 3, 81));
                if (adsArray.length() > 0) {
                    for (int i = 0; i < adsArray.length(); i++) {
                        arrayList.add((JSONObject) adsArray.get(i));
                    }
                }
            } catch (JSONException unused) {
                String A034 = A03(36, 38, 4);
                this.A02.A0E().A4t(C0722Jb.A01(AdErrorType.UNKNOWN_ERROR, A034).A03().getErrorCode(), A034);
                return arrayList;
            }
        } else {
            arrayList.add(A032);
        }
        return arrayList;
    }

    private void A06(C1237bN c1237bN, JSONObject jSONObject, C8T c8t) {
        this.A0C = false;
        C1202ao c1202ao = new C1202ao(this, c1237bN, LJ.A02(jSONObject, A03(34, 2, 108)));
        A0F().postDelayed(c1202ao, c8t.A05());
        c1237bN.A0J(this.A02, this.A08, this.A07.A08, A01(c1202ao), jSONObject, c8t);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1200am
    public final void A0M() {
        if (this.A01 != null) {
            this.A02.A0E().A3y();
            this.A06.A0E(this.A01);
            return;
        }
        this.A02.A0E().A3z();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1200am
    public final void A0O(InterfaceC02800p interfaceC02800p, C8S c8s, C8Q c8q, final C03121v c03121v) {
        this.A02.A0E().A3s();
        final C1237bN c1237bN = (C1237bN) interfaceC02800p;
        final List<JSONObject> A04 = A04(c03121v);
        A06(c1237bN, A04.get(0), c03121v.A01());
        if (A04.size() > 1) {
            A0F().postDelayed(new Runnable() { // from class: com.facebook.ads.redexgen.X.1w
                @Override // java.lang.Runnable
                public final void run() {
                    FR.this.A0X(c1237bN, A04, c03121v);
                }
            }, this.A00);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1200am
    public final void A0R(String str) {
        this.A02.A0E().A3x(str != null);
        super.A0R(str);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1200am
    public final void A0V(boolean z2) {
        super.A0V(z2);
        this.A01 = null;
    }

    public final /* synthetic */ void A0X(C1237bN c1237bN, List list, C03121v c03121v) {
        A06(c1237bN, (JSONObject) list.get(1), c03121v.A01());
    }
}
