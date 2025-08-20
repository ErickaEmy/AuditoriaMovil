package com.facebook.ads.redexgen.X;

import java.util.Collection;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.ba  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1250ba implements InterfaceC02760k {
    public final /* synthetic */ C1116Yn A00;
    public final /* synthetic */ String A01;
    public final /* synthetic */ JSONObject A02;

    public C1250ba(JSONObject jSONObject, C1116Yn c1116Yn, String str) {
        this.A02 = jSONObject;
        this.A00 = c1116Yn;
        this.A01 = str;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC02760k
    public final String A6T() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC02760k
    public final Collection<String> A6n() {
        return AbstractC02770l.A03(this.A00, this.A02);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC02760k
    public final EnumC02750j A7E() {
        return AbstractC02770l.A00(this.A02);
    }
}
