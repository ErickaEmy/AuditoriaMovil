package com.facebook.ads.redexgen.X;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class NP extends LinearLayout {
    public static byte[] A04;
    public static String[] A05 = {"c3XyMVVK2ZPeOt0e4CLBNBDbK", "DsCUYZfHfFO6YC0ZUz1", "eLhkJXERmPgt", "", "", "5cC1cV814bBflaO82eB2FX5nm", "", "kS5kSd3yRJfI"};
    public Drawable A00;
    public TextView A01;
    public TextView A02;
    public final C1116Yn A03;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 119);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        byte[] bArr = {7, 27, 27, 31, 28};
        if (A05[4].length() != 0) {
            throw new RuntimeException();
        }
        A05[1] = "lhzBP3Bo4mEfv1CoOUdrfuIGeogVZlJ";
        A04 = bArr;
    }

    static {
        A02();
    }

    public NP(C1116Yn c1116Yn) {
        super(c1116Yn);
        this.A03 = c1116Yn;
        A01();
    }

    private void A01() {
        float f4 = getResources().getDisplayMetrics().density;
        setOrientation(1);
        this.A02 = new TextView(getContext());
        LinearLayout.LayoutParams titleTextViewParams = new LinearLayout.LayoutParams(-1, -2);
        this.A02.setTextColor(-16777216);
        this.A02.setTextSize(2, 20.0f);
        this.A02.setEllipsize(TextUtils.TruncateAt.END);
        this.A02.setSingleLine(true);
        this.A02.setVisibility(8);
        this.A02.setGravity(17);
        addView(this.A02, titleTextViewParams);
        this.A01 = new TextView(getContext());
        LinearLayout.LayoutParams titleTextViewParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.A01.setAlpha(0.5f);
        this.A01.setTextColor(-16777216);
        this.A01.setTextSize(2, 15.0f);
        float density = 5.0f * f4;
        this.A01.setCompoundDrawablePadding((int) density);
        this.A01.setEllipsize(TextUtils.TruncateAt.END);
        this.A01.setSingleLine(true);
        this.A01.setVisibility(8);
        this.A01.setGravity(17);
        addView(this.A01, titleTextViewParams2);
        if (C0705Ih.A2N(this.A03)) {
            this.A02.setVisibility(4);
            this.A01.setVisibility(4);
        }
    }

    private Drawable getPadlockDrawable() {
        if (this.A00 == null) {
            this.A00 = AbstractC0792Lx.A03(this.A03, EnumC0791Lw.BROWSER_PADLOCK);
        }
        return this.A00;
    }

    public void setSubtitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.A01.setText((CharSequence) null);
            this.A01.setVisibility(4);
            return;
        }
        Uri A00 = AbstractC0767Ky.A00(str);
        this.A01.setText(A00.getHost());
        this.A01.setCompoundDrawablesRelativeWithIntrinsicBounds(A00(0, 5, 24).equals(A00.getScheme()) ? getPadlockDrawable() : null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.A01.setVisibility(0);
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.A02.setText((CharSequence) null);
            String[] strArr = A05;
            if (strArr[6].length() != strArr[3].length()) {
                throw new RuntimeException();
            }
            A05[4] = "";
            this.A02.setVisibility(4);
            return;
        }
        this.A02.setText(str);
        this.A02.setVisibility(0);
    }
}
