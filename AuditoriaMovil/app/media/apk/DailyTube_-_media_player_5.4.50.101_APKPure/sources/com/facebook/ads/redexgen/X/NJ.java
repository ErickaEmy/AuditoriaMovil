package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.Arrays;
import java.util.List;
/* loaded from: assets/audience_network.dex */
public final class NJ extends LinearLayout {
    public static byte[] A0E;
    public static String[] A0F = {"knq4crm7fvqQP", "POuWJNR6FFtqsTvB6KeDXgsqVDDrfXB5", "10LYd3PkBnL3JTlwXO74lkb8laVhyfxM", "yGvyB2PsIdOlgSHN7xWAdIyeKrkcUuSJ", "30OsfDGqNeLBXhmKwxFpv8WuoKRgKdOB", "v4mwmIuaROl", "LuFvPWZsJ2RrZ", "py7QobRXpH9AZVstdVJJOkEIejHuBaN9"};
    public static final int A0G;
    public static final int A0H;
    public static final Uri A0I;
    public static final View.OnTouchListener A0J;
    public ImageView A00;
    public ImageView A01;
    public ImageView A02;
    public ImageView A03;
    public LinearLayout A04;
    public NI A05;
    public NP A06;
    public String A07;
    public boolean A08;
    public final float A09;
    public final WebView A0A;
    public final C1116Yn A0B;
    public final NT A0C;
    public final boolean A0D;

    public static String A06(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0E, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            byte b2 = (byte) ((copyOfRange[i8] ^ i6) ^ 39);
            String[] strArr = A0F;
            if (strArr[3].charAt(13) == strArr[1].charAt(13)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0F;
            strArr2[6] = "2vQcPj1ELj1bu";
            strArr2[0] = "7aOELiI6quiDs";
            copyOfRange[i8] = b2;
        }
        return new String(copyOfRange);
    }

    public static void A0A() {
        A0E = new byte[]{80, 115, 113, 121, 27, 52, 55, 43, 61, 39, 14, 19, 22, 0, 19, 5, 14, 49, 36, 47, 97, 47, 32, 53, 40, 55, 36, 97, 35, 51, 46, 54, 50, 36, 51, 5, 6, 11, 17, 16, 94, 6, 8, 5, 10, 15, 18, 29, 23, 1, 28, 26, 23, 93, 26, 29, 7, 22, 29, 7, 93, 18, 16, 7, 26, 28, 29, 93, 37, 58, 54, 36, 27, 23, 21, 86, 25, 22, 28, 10, 23, 17, 28, 86, 27, 16, 10, 23, 21, 29, 80, 76, 76, 72, 2, 23, 23, 79, 79, 79, 22, 94, 89, 91, 93, 90, 87, 87, 83, 22, 91, 87, 85};
    }

    static {
        A0A();
        A0G = Color.rgb(224, 224, 224);
        A0I = AbstractC0767Ky.A00(A06(90, 23, 31));
        A0J = new ND();
        A0H = Color.argb(34, 0, 0, 0);
    }

    public NJ(C1116Yn c1116Yn, WebView webView) {
        this(c1116Yn, webView, false);
    }

    public NJ(C1116Yn c1116Yn, WebView webView, boolean z2) {
        super(c1116Yn);
        this.A09 = getResources().getDisplayMetrics().density;
        this.A0C = new U3(this);
        this.A0A = webView;
        this.A0B = c1116Yn;
        this.A08 = AbstractC0706Ii.A06(c1116Yn);
        this.A0D = z2;
        A08();
    }

    private void A08() {
        int buttonSizePx;
        int i = (int) (this.A09 * 50.0f);
        AbstractC0783Lo.A0M(this, -1);
        setGravity(16);
        ImageView imageView = new ImageView(this.A0B);
        this.A01 = imageView;
        imageView.setContentDescription(A06(4, 5, 127));
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
        this.A01.setScaleType(ImageView.ScaleType.CENTER);
        this.A01.setImageBitmap(AbstractC0792Lx.A01(EnumC0791Lw.BROWSER_CLOSE));
        ImageView imageView2 = this.A01;
        View.OnTouchListener onTouchListener = A0J;
        imageView2.setOnTouchListener(onTouchListener);
        this.A01.setOnClickListener(new NE(this));
        addView(this.A01, layoutParams);
        if (this.A08 && !C0705Ih.A2N(this.A0B)) {
            ImageView imageView3 = new ImageView(this.A0B);
            this.A00 = imageView3;
            imageView3.setEnabled(false);
            this.A00.setAlpha(0.3f);
            this.A00.setContentDescription(A06(0, 4, 53));
            LinearLayout.LayoutParams backButtonParams = new LinearLayout.LayoutParams(i, i);
            this.A00.setScaleType(ImageView.ScaleType.CENTER);
            this.A00.setImageBitmap(AbstractC0792Lx.A01(EnumC0791Lw.BACK_ARROW));
            this.A00.setOnTouchListener(onTouchListener);
            this.A00.setOnClickListener(new NF(this));
            addView(this.A00, backButtonParams);
        }
        this.A06 = new NP(this.A0B);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        if (this.A08 || C0705Ih.A2N(this.A0B)) {
            buttonSizePx = 1056964608;
        } else {
            buttonSizePx = 1065353216;
        }
        layoutParams2.weight = buttonSizePx;
        this.A06.setGravity(17);
        if (C0705Ih.A2N(this.A0B) && !this.A0D) {
            LinearLayout linearLayout = new LinearLayout(this.A0B);
            this.A04 = linearLayout;
            linearLayout.setOrientation(1);
            LinearLayout linearLayout2 = this.A04;
            float f4 = this.A09;
            int buttonSizePx2 = (int) (f4 * 2.0f);
            linearLayout2.setPadding(0, (int) (f4 * 2.0f), 0, buttonSizePx2);
            layoutParams2.setMarginStart(0);
            addView(this.A04, layoutParams2);
            ImageView imageView4 = new ImageView(this.A0B);
            imageView4.setScaleType(ImageView.ScaleType.CENTER);
            imageView4.setImageBitmap(AbstractC0792Lx.A01(EnumC0791Lw.HANDLER));
            float f6 = this.A09;
            int buttonSizePx3 = (int) (f6 * 4.0f);
            imageView4.setPadding(0, (int) (f6 * 4.0f), 0, buttonSizePx3);
            this.A04.addView(imageView4, new LinearLayout.LayoutParams(-1, -2));
            LinearLayout.LayoutParams titleViewsParams = new LinearLayout.LayoutParams(-1, -2);
            this.A04.addView(this.A06, titleViewsParams);
        } else {
            addView(this.A06, layoutParams2);
        }
        if (this.A08 && !C0705Ih.A2N(this.A0B)) {
            ImageView imageView5 = new ImageView(this.A0B);
            this.A02 = imageView5;
            imageView5.setEnabled(false);
            this.A02.setAlpha(0.3f);
            this.A02.setContentDescription(A06(9, 7, 70));
            LinearLayout.LayoutParams titleViewsParams2 = new LinearLayout.LayoutParams(i, i);
            this.A02.setScaleType(ImageView.ScaleType.CENTER);
            this.A02.setImageBitmap(AbstractC0792Lx.A02(EnumC0791Lw.BACK_ARROW));
            this.A02.setOnTouchListener(onTouchListener);
            this.A02.setOnClickListener(new NG(this));
            addView(this.A02, titleViewsParams2);
        }
        this.A03 = new ImageView(this.A0B);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i, i);
        this.A03.setContentDescription(A06(16, 19, 102));
        this.A03.setScaleType(ImageView.ScaleType.CENTER);
        this.A03.setOnTouchListener(onTouchListener);
        this.A03.setOnClickListener(new NH(this));
        addView(this.A03, layoutParams3);
        A09();
    }

    private void A09() {
        PackageManager packageManager = this.A0B.getPackageManager();
        Bitmap bitmap = null;
        if (packageManager != null) {
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(new Intent(A06(46, 26, 84), A0I), 65536);
            if (queryIntentActivities.isEmpty()) {
                this.A03.setVisibility(8);
            } else {
                if (queryIntentActivities.size() == 1 && queryIntentActivities.get(0).activityInfo != null) {
                    if (A06(72, 18, 95).equals(queryIntentActivities.get(0).activityInfo.packageName)) {
                        bitmap = AbstractC0792Lx.A01(EnumC0791Lw.BROWSER_LAUNCH_CHROME);
                    }
                }
                bitmap = AbstractC0792Lx.A01(EnumC0791Lw.BROWSER_LAUNCH_NATIVE);
            }
        }
        if (C0705Ih.A2N(this.A0B)) {
            this.A03.setVisibility(0);
            bitmap = AbstractC0792Lx.A01(EnumC0791Lw.BROWSER_LAUNCH_NATIVE);
        }
        ImageView imageView = this.A03;
        String[] strArr = A0F;
        if (strArr[6].length() != strArr[0].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0F;
        strArr2[3] = "Ik1lUxwfUY0m3mLxiVim5pYdTJeAjco4";
        strArr2[1] = "FSuRgMaNDMwOoFjkuIBtKYf6vflm3uDf";
        imageView.setImageBitmap(bitmap);
    }

    public NT getBrowserNavigationListener() {
        return this.A0C;
    }

    public void setListener(NI ni) {
        this.A05 = ni;
    }

    public void setTitle(String str) {
        this.A06.setTitle(str);
    }

    public void setUrl(String str) {
        this.A07 = str;
        if (TextUtils.isEmpty(str) || A06(35, 11, 67).equals(this.A07)) {
            this.A06.setSubtitle(null);
            this.A03.setEnabled(false);
            this.A03.setColorFilter(new PorterDuffColorFilter(A0G, PorterDuff.Mode.SRC_IN));
            return;
        }
        this.A06.setSubtitle(this.A07);
        this.A03.setEnabled(true);
        this.A03.setColorFilter((ColorFilter) null);
    }
}
