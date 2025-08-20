package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup;
/* renamed from: com.facebook.ads.redexgen.X.4p  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C03834p extends ViewGroup.MarginLayoutParams {
    public AnonymousClass56 A00;
    public boolean A01;
    public boolean A02;
    public final Rect A03;

    public C03834p(int i, int i5) {
        super(i, i5);
        this.A03 = new Rect();
        this.A01 = true;
        this.A02 = false;
    }

    public C03834p(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.A03 = new Rect();
        this.A01 = true;
        this.A02 = false;
    }

    public C03834p(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.A03 = new Rect();
        this.A01 = true;
        this.A02 = false;
    }

    public C03834p(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.A03 = new Rect();
        this.A01 = true;
        this.A02 = false;
    }

    public C03834p(C03834p c03834p) {
        super((ViewGroup.LayoutParams) c03834p);
        this.A03 = new Rect();
        this.A01 = true;
        this.A02 = false;
    }

    public final int A00() {
        return this.A00.A0I();
    }

    public final boolean A01() {
        return this.A00.A0d();
    }

    public final boolean A02() {
        return this.A00.A0a();
    }

    public final boolean A03() {
        return this.A00.A0Z();
    }
}
