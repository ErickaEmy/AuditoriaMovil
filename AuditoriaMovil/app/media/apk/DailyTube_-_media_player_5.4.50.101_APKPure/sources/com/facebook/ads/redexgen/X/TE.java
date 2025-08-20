package com.facebook.ads.redexgen.X;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import com.uv.v7.R;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public class TE extends NY {
    public static byte[] A01;
    public final /* synthetic */ PB A00;

    static {
        A04();
    }

    public static String A03(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ R.styleable.AppCompatTheme_tooltipForegroundColor);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A01 = new byte[]{5, 24, 15, 0, 12, 8, 2, 62, 18, 5, 10, 62, 13, 0, 24, 4, 19, 62, 2, 14, 15, 21, 4, 15, 21, 62, 9, 4, 8, 6, 9, 21, 12, 17, 6, 9, 5, 1, 11, 55, 27, 12, 3, 55, 4, 9, 17, 13, 26, 55, 11, 7, 6, 28, 13, 6, 28, 55, 31, 1, 12, 28, 0};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    public final void onMeasure(int i, int i5) {
        int dynamicWebViewWidth = getDynamicWebViewWidth();
        int dynamicWebViewHeight = getDynamicWebViewHeight();
        if (dynamicWebViewWidth <= 0 || dynamicWebViewHeight <= 0) {
            super.onMeasure(i, i5);
            return;
        }
        float f4 = dynamicWebViewWidth / dynamicWebViewHeight;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i5);
        boolean z2 = mode != 1073741824;
        boolean z3 = mode2 != 1073741824;
        int i6 = getResources().getDisplayMetrics().widthPixels;
        int i8 = getResources().getDisplayMetrics().heightPixels;
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            i8 = Integer.MAX_VALUE;
            i6 = viewGroup.getWidth() != 0 ? viewGroup.getWidth() : Integer.MAX_VALUE;
            if (viewGroup.getHeight() != 0) {
                i8 = viewGroup.getHeight();
            }
        }
        int A012 = A01(dynamicWebViewWidth, i6, i);
        int A013 = A01(dynamicWebViewHeight, i8, i5);
        if ((z3 || z2) && Math.abs((A012 / A013) - f4) > 1.0E-7d) {
            boolean z4 = false;
            if (z3) {
                A013 = (int) (A012 / f4);
                z4 = true;
            }
            if (!z4 && z2) {
                A012 = (int) (A013 * f4);
            }
        }
        setMeasuredDimension(A012, A013);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TE(PB pb, C1116Yn c1116Yn) {
        super(c1116Yn);
        this.A00 = pb;
        getSettings().setAllowFileAccess(true);
        setBackgroundColor(0);
    }

    private int A01(int i, int i5, int i6) {
        int specMode = View.MeasureSpec.getMode(i6);
        int result = View.MeasureSpec.getSize(i6);
        switch (specMode) {
            case Integer.MIN_VALUE:
                return Math.min(Math.min(i, result), i5);
            case 0:
                return Math.min(i, i5);
            case 1073741824:
                return result;
            default:
                return i;
        }
    }

    @Override // com.facebook.ads.redexgen.X.NY
    public final WebChromeClient A0D() {
        return new P6(this.A00);
    }

    @Override // com.facebook.ads.redexgen.X.NY
    public final WebViewClient A0E() {
        return new P7(this.A00);
    }

    private int getDynamicWebViewHeight() {
        AbstractC1219b5 abstractC1219b5;
        abstractC1219b5 = this.A00.A09;
        return abstractC1219b5.A0V().optInt(A03(0, 32, 19));
    }

    private int getDynamicWebViewWidth() {
        AbstractC1219b5 abstractC1219b5;
        abstractC1219b5 = this.A00.A09;
        return abstractC1219b5.A0V().optInt(A03(32, 31, 26));
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        P0 p02;
        P0 p03;
        p02 = this.A00.A02;
        if (p02 != null) {
            p03 = this.A00.A02;
            p03.ADL(this, motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }
}
