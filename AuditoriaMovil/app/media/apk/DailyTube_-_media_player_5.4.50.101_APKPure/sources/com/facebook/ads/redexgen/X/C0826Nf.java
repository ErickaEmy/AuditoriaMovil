package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
/* renamed from: com.facebook.ads.redexgen.X.Nf  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0826Nf extends FrameLayout {
    public int A00;
    public int A01;
    public final ImageView A02;
    public final ImageView A03;

    public C0826Nf(C1116Yn c1116Yn) {
        super(c1116Yn);
        this.A03 = new ImageView(c1116Yn);
        this.A02 = new ImageView(c1116Yn);
        A00();
    }

    public C0826Nf(C1116Yn c1116Yn, AttributeSet attributeSet) {
        super(c1116Yn, attributeSet);
        this.A03 = new ImageView(c1116Yn, attributeSet);
        this.A02 = new ImageView(c1116Yn, attributeSet);
        A00();
    }

    public C0826Nf(C1116Yn c1116Yn, AttributeSet attributeSet, int i) {
        super(c1116Yn, attributeSet, i);
        this.A03 = new ImageView(c1116Yn, attributeSet, i);
        this.A02 = new ImageView(c1116Yn, attributeSet, i);
        A00();
    }

    public C0826Nf(C1116Yn c1116Yn, AttributeSet attributeSet, int i, int i5) {
        super(c1116Yn, attributeSet, i, i5);
        this.A03 = new ImageView(c1116Yn, attributeSet, i, i5);
        this.A02 = new ImageView(c1116Yn, attributeSet, i, i5);
        A00();
    }

    private void A00() {
        addView(this.A02, new FrameLayout.LayoutParams(-1, -1));
        addView(this.A03, new FrameLayout.LayoutParams(-2, -2));
        LI.A04(this.A03, LI.A0A);
        setId(AbstractC0783Lo.A00());
    }

    public ImageView getBodyImageView() {
        return this.A03;
    }

    public int getImageHeight() {
        return this.A00;
    }

    public int getImageWidth() {
        return this.A01;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i, int i5, int i6, int i8) {
        int i10;
        int i11 = this.A01;
        if (i11 <= 0 || (i10 = this.A00) <= 0) {
            super.onLayout(z2, i, i5, i6, i8);
            return;
        }
        int i12 = i6 - i;
        int i13 = i8 - i5;
        float min = Math.min(i12 / i11, i13 / i10);
        int i14 = (int) (this.A01 * min);
        int blurBorderViewWidth = (int) (this.A00 * min);
        this.A02.layout(i, i5, i6, i8);
        int expectedImageWidth = (i12 / 2) + i;
        int i15 = (i13 / 2) + i5;
        this.A03.layout(expectedImageWidth - (i14 / 2), i15 - (blurBorderViewWidth / 2), (i14 / 2) + expectedImageWidth, i15 + (blurBorderViewWidth / 2));
        this.A02.setVisibility(0);
    }

    public void setImage(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap2 != null) {
            AbstractC0783Lo.A0S(this.A02, new BitmapDrawable(getContext().getResources(), bitmap2));
        } else {
            AbstractC0783Lo.A0M(this.A02, 0);
        }
        if (bitmap != null) {
            this.A01 = bitmap.getWidth();
            this.A00 = bitmap.getHeight();
            this.A03.setImageBitmap(Bitmap.createBitmap(bitmap));
            return;
        }
        this.A03.setImageDrawable(null);
    }
}
