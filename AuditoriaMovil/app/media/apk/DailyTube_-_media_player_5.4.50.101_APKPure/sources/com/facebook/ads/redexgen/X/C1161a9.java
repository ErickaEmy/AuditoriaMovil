package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.a9  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1161a9 implements InterfaceC03232g {
    private C03242h A00(InterfaceC03222f interfaceC03222f) {
        return (C03242h) interfaceC03222f.A6J();
    }

    public final void A01(InterfaceC03222f interfaceC03222f) {
        if (!interfaceC03222f.A8G()) {
            interfaceC03222f.AGE(0, 0, 0, 0);
            return;
        }
        float A7M = A7M(interfaceC03222f);
        float A7m = A7m(interfaceC03222f);
        float elevation = C03262j.A00(A7M, A7m, interfaceC03222f.A7l());
        int vPadding = (int) Math.ceil(elevation);
        float elevation2 = C03262j.A01(A7M, A7m, interfaceC03222f.A7l());
        int ceil = (int) Math.ceil(elevation2);
        interfaceC03222f.AGE(vPadding, ceil, vPadding, ceil);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03232g
    public final ColorStateList A66(InterfaceC03222f interfaceC03222f) {
        return A00(interfaceC03222f).A05();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03232g
    public final float A6t(InterfaceC03222f interfaceC03222f) {
        return interfaceC03222f.A6K().getElevation();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03232g
    public final float A7M(InterfaceC03222f interfaceC03222f) {
        return A00(interfaceC03222f).A03();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03232g
    public final float A7R(InterfaceC03222f interfaceC03222f) {
        return A7m(interfaceC03222f) * 2.0f;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03232g
    public final float A7S(InterfaceC03222f interfaceC03222f) {
        return A7m(interfaceC03222f) * 2.0f;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03232g
    public final float A7m(InterfaceC03222f interfaceC03222f) {
        return A00(interfaceC03222f).A04();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03232g
    public final void A8r() {
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03232g
    public final void A8s(InterfaceC03222f interfaceC03222f, Context context, ColorStateList colorStateList, float f4, float f6, float f9) {
        C03242h background = new C03242h(colorStateList, f4);
        interfaceC03222f.AFu(background);
        View view = interfaceC03222f.A6K();
        view.setClipToOutline(true);
        view.setElevation(f6);
        AG6(interfaceC03222f, f9);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03232g
    public final void AB7(InterfaceC03222f interfaceC03222f) {
        AG6(interfaceC03222f, A7M(interfaceC03222f));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03232g
    public final void ACk(InterfaceC03222f interfaceC03222f) {
        AG6(interfaceC03222f, A7M(interfaceC03222f));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03232g
    public final void AFt(InterfaceC03222f interfaceC03222f, ColorStateList colorStateList) {
        A00(interfaceC03222f).A08(colorStateList);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03232g
    public final void AFz(InterfaceC03222f interfaceC03222f, float f4) {
        interfaceC03222f.A6K().setElevation(f4);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03232g
    public final void AG6(InterfaceC03222f interfaceC03222f, float f4) {
        A00(interfaceC03222f).A07(f4, interfaceC03222f.A8G(), interfaceC03222f.A7l());
        A01(interfaceC03222f);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03232g
    public final void AGC(InterfaceC03222f interfaceC03222f, float f4) {
        A00(interfaceC03222f).A06(f4);
    }
}
