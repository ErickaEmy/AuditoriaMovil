package com.facebook.ads.redexgen.X;

import android.graphics.drawable.Drawable;
/* renamed from: com.facebook.ads.redexgen.X.aB  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1163aB implements InterfaceC03222f {
    public Drawable A00;
    public final /* synthetic */ AbstractC03212e A01;

    public C1163aB(AbstractC03212e abstractC03212e) {
        this.A01 = abstractC03212e;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03222f
    public final Drawable A6J() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03222f
    public final AbstractC03212e A6K() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03222f
    public final boolean A7l() {
        return this.A01.getPreventCornerOverlap();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03222f
    public final boolean A8G() {
        return this.A01.getUseCompatPadding();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03222f
    public final void AFu(Drawable drawable) {
        this.A00 = drawable;
        this.A01.setBackgroundDrawable(drawable);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03222f
    public final void AG7(int i, int i5) {
        if (i > this.A01.A01) {
            super/*android.widget.FrameLayout*/.setMinimumWidth(i);
        }
        if (i5 > this.A01.A00) {
            super/*android.widget.FrameLayout*/.setMinimumHeight(i5);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC03222f
    public final void AGE(int i, int i5, int i6, int i8) {
        this.A01.A05.set(i, i5, i6, i8);
        AbstractC03212e abstractC03212e = this.A01;
        super/*android.widget.FrameLayout*/.setPadding(abstractC03212e.A04.left + i, this.A01.A04.top + i5, this.A01.A04.right + i6, this.A01.A04.bottom + i8);
    }
}
