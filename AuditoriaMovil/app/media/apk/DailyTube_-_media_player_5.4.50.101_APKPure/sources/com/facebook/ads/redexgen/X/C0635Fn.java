package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.text.Layout;
/* renamed from: com.facebook.ads.redexgen.X.Fn  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0635Fn {
    public final float A00;
    public final float A01;
    public final float A02;
    public final float A03;
    public final float A04;
    public final int A05;
    public final int A06;
    public final int A07;
    public final int A08;
    public final int A09;
    public final Bitmap A0A;
    public final Layout.Alignment A0B;
    public final CharSequence A0C;
    public final boolean A0D;

    public C0635Fn(Bitmap bitmap, float f4, int i, float f6, int i5, float f9, float f10) {
        this(null, null, bitmap, f6, 0, i5, f4, i, Integer.MIN_VALUE, Float.MIN_VALUE, f9, f10, false, -16777216);
    }

    public C0635Fn(CharSequence charSequence) {
        this(charSequence, null, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public C0635Fn(CharSequence charSequence, Layout.Alignment alignment, float f4, int i, int i5, float f6, int i6, float f9) {
        this(charSequence, alignment, f4, i, i5, f6, i6, f9, false, -16777216);
    }

    public C0635Fn(CharSequence charSequence, Layout.Alignment alignment, float f4, int i, int i5, float f6, int i6, float f9, int i8, float f10) {
        this(charSequence, alignment, null, f4, i, i5, f6, i6, i8, f10, f9, Float.MIN_VALUE, false, -16777216);
    }

    public C0635Fn(CharSequence charSequence, Layout.Alignment alignment, float f4, int i, int i5, float f6, int i6, float f9, boolean z2, int i8) {
        this(charSequence, alignment, null, f4, i, i5, f6, i6, Integer.MIN_VALUE, Float.MIN_VALUE, f9, Float.MIN_VALUE, z2, i8);
    }

    public C0635Fn(CharSequence charSequence, Layout.Alignment alignment, Bitmap bitmap, float f4, int i, int i5, float f6, int i6, int i8, float f9, float f10, float f11, boolean z2, int i10) {
        this.A0C = charSequence;
        this.A0B = alignment;
        this.A0A = bitmap;
        this.A01 = f4;
        this.A06 = i;
        this.A05 = i5;
        this.A02 = f6;
        this.A07 = i6;
        this.A03 = f10;
        this.A00 = f11;
        this.A0D = z2;
        this.A09 = i10;
        this.A08 = i8;
        this.A04 = f9;
    }
}
