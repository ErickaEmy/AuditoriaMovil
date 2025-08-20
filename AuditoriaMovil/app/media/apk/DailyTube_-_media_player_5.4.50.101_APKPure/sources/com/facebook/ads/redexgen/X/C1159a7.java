package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
/* renamed from: com.facebook.ads.redexgen.X.a7  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1159a7 implements InterfaceC03232g {
    public final RectF A00 = new RectF();

    private C03262j A00(Context context, ColorStateList colorStateList, float f4, float f6, float f9) {
        return new C03262j(context.getResources(), colorStateList, f4, f6, f9);
    }

    private C03262j A01(InterfaceC03222f interfaceC03222f) {
        return (C03262j) interfaceC03222f.A6J();
    }

    public final void A02(InterfaceC03222f interfaceC03222f) {
        Rect rect = new Rect();
        A01(interfaceC03222f).A0K(rect);
        interfaceC03222f.AG7((int) Math.ceil(A7S(interfaceC03222f)), (int) Math.ceil(A7R(interfaceC03222f)));
        interfaceC03222f.AGE(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03232g
    public final ColorStateList A66(InterfaceC03222f interfaceC03222f) {
        return A01(interfaceC03222f).A0F();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03232g
    public final float A6t(InterfaceC03222f interfaceC03222f) {
        return A01(interfaceC03222f).A0E();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03232g
    public final float A7M(InterfaceC03222f interfaceC03222f) {
        return A01(interfaceC03222f).A0B();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03232g
    public final float A7R(InterfaceC03222f interfaceC03222f) {
        return A01(interfaceC03222f).A0C();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03232g
    public final float A7S(InterfaceC03222f interfaceC03222f) {
        return A01(interfaceC03222f).A0D();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03232g
    public final float A7m(InterfaceC03222f interfaceC03222f) {
        return A01(interfaceC03222f).A0A();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03232g
    public void A8r() {
        C03262j.A0G = new C1160a8(this);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03232g
    public final void A8s(InterfaceC03222f interfaceC03222f, Context context, ColorStateList colorStateList, float f4, float f6, float f9) {
        C03262j A00 = A00(context, colorStateList, f4, f6, f9);
        A00.A0L(interfaceC03222f.A7l());
        interfaceC03222f.AFu(A00);
        A02(interfaceC03222f);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03232g
    public final void AB7(InterfaceC03222f interfaceC03222f) {
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03232g
    public final void ACk(InterfaceC03222f interfaceC03222f) {
        A01(interfaceC03222f).A0L(interfaceC03222f.A7l());
        A02(interfaceC03222f);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03232g
    public final void AFt(InterfaceC03222f interfaceC03222f, ColorStateList colorStateList) {
        A01(interfaceC03222f).A0J(colorStateList);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03232g
    public final void AFz(InterfaceC03222f interfaceC03222f, float f4) {
        A01(interfaceC03222f).A0I(f4);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03232g
    public final void AG6(InterfaceC03222f interfaceC03222f, float f4) {
        A01(interfaceC03222f).A0H(f4);
        A02(interfaceC03222f);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03232g
    public final void AGC(InterfaceC03222f interfaceC03222f, float f4) {
        A01(interfaceC03222f).A0G(f4);
        A02(interfaceC03222f);
    }
}
