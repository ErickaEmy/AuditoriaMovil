package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.Tl  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class View$OnClickListenerC0988Tl extends AbstractC0842Nv implements View.OnClickListener {
    public static byte[] A0D;
    public static String[] A0E = {"idQnrwKrPQs0c3zYYHT6WTvW1aXoRMqQ", "Gekt1WHQiHnIJqxdwB9j8FzDtIJy1cfJ", "sF2V", "CdtBVDHmuEaNC9R8", "jtmNaJ8NDkAfiILRFeCM3WK", "aXO2Ks7stxeTyHMnCxwSATKtkmhK3bmt", "xmLEl9t0StR", ""};
    public static final int A0F;
    public int A00;
    public int A01;
    public Bitmap A02;
    public Paint A03;
    public Rect A04;
    public C1116Yn A05;
    public L9 A06;
    public C0990Tn A07;
    public String A08;
    public String A09;
    public boolean A0A;
    public final C0838Nr A0B;
    public final Map<String, String> A0C;

    public static String A04(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0D, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            int i10 = copyOfRange[i8] ^ i6;
            if (A0E[2].length() != 4) {
                throw new RuntimeException();
            }
            A0E[3] = "DG";
            copyOfRange[i8] = (byte) (i10 ^ 83);
        }
        return new String(copyOfRange);
    }

    public static void A07() {
        A0D = new byte[]{3, 12, 9, 3, 11, 63, 19, 15, 21, 18, 3, 5, 8, 12, 67, 3, 11, 29, 29, 11, 0, 9, 11, 28, Byte.MAX_VALUE, 121, 111, 120, 105, 102, 99, 105, 97};
    }

    static {
        A07();
        A0F = (int) (LD.A02 * 24.0f);
    }

    public View$OnClickListenerC0988Tl(C1116Yn c1116Yn, AbstractC1219b5 abstractC1219b5, C1P c1p, J2 j2, MC mc2, RE re, C0775Lg c0775Lg) {
        this(c1116Yn, abstractC1219b5.A0L(), c1p, abstractC1219b5.A0x().A0F().A06(), j2, mc2, re, c0775Lg, abstractC1219b5.A0y());
        this.A0B.A04(abstractC1219b5);
    }

    public View$OnClickListenerC0988Tl(C1116Yn c1116Yn, String str, C1P c1p, J2 j2, MC mc2, RE re, C0775Lg c0775Lg, C1U c1u) {
        this(c1116Yn, str, c1p, false, j2, mc2, re, c0775Lg, c1u);
    }

    public View$OnClickListenerC0988Tl(C1116Yn c1116Yn, String str, C1P c1p, boolean z2, J2 j2, MC mc2, RE re, C0775Lg c0775Lg, C1U c1u) {
        super(c1116Yn, c1p);
        this.A0C = new HashMap();
        this.A05 = c1116Yn;
        this.A0A = z2;
        this.A0B = new C0838Nr(c1116Yn, str, re, c0775Lg, j2, c1u, mc2);
        setOnClickListener(this);
        AbstractC0783Lo.A0G(1001, this);
    }

    public static Bitmap A03(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    private void A05() {
        String str;
        if (this.A0A && (str = this.A09) != null) {
            this.A02 = A03(AbstractC0792Lx.A03(this.A05, str.contains(A04(12, 12, 61)) ? EnumC0791Lw.MESSENGER : EnumC0791Lw.WHATSAPP));
            this.A03 = new Paint();
            int i = A0F;
            setPadding(i, 0, i, 0);
        }
    }

    private void A06() {
        L9 l92 = this.A06;
        if (l92 != null) {
            l92.A06();
        }
        C0990Tn c0990Tn = this.A07;
        if (c0990Tn != null) {
            c0990Tn.A04();
        }
    }

    public static boolean A08(AbstractC1219b5 abstractC1219b5) {
        return ((long) abstractC1219b5.A0u()) > 0 && abstractC1219b5.A0s() >= 0;
    }

    public final void A09(String str) {
        if (TextUtils.isEmpty(this.A08) || TextUtils.isEmpty(this.A09)) {
            return;
        }
        A06();
        this.A0C.put(A04(0, 12, 51), str);
        this.A0B.A07(this.A08, this.A09, this.A0C);
    }

    public final boolean A0A(AbstractC1219b5 abstractC1219b5, MB mb) {
        if (this.A06 != null || !A08(abstractC1219b5) || abstractC1219b5.A11().A01() == null || abstractC1219b5.A11().A00() == null) {
            return false;
        }
        this.A07 = new C0990Tn(abstractC1219b5.A0s(), abstractC1219b5.A0u(), abstractC1219b5.A0t(), abstractC1219b5.A11().A01(), abstractC1219b5.A11().A00(), mb, this);
        L9 l92 = new L9(abstractC1219b5.A0u(), this.A07);
        this.A06 = l92;
        l92.A07();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (KL.A02(this)) {
            return;
        }
        try {
            A09(A04(24, 9, 89));
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        A06();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.A02 != null) {
            this.A04 = new Rect(0, 0, this.A02.getWidth(), this.A02.getHeight());
            int width = this.A02.getWidth();
            this.A01 = width;
            this.A00 = 12;
            int shift = (width + 12) / 2;
            canvas.save();
            canvas.translate(shift, 0.0f);
        }
        super.onDraw(canvas);
        if (this.A02 != null) {
            float textWidth = this.A01;
            float width2 = ((getWidth() / 2.0f) - ((getPaint().measureText((String) getText()) + 10.0f) / 2.0f)) - textWidth;
            float textWidth2 = this.A00;
            int i = (int) (width2 - textWidth2);
            int top = (getHeight() / 2) - (this.A01 / 2);
            int left = this.A01;
            Rect destRect = new Rect(i, top, i + left, left + top);
            canvas.drawBitmap(this.A02, this.A04, destRect, this.A03);
            canvas.restore();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0) {
            A06();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (!z2) {
            A06();
        }
    }

    public void setCreativeAsCtaLoggingHelper(OG og) {
        this.A0B.A06(og);
    }

    public void setCta(C1Q c1q, String str, Map<String, String> extraData) {
        setCta(c1q, str, extraData, null);
    }

    public void setCta(C1Q c1q, String str, Map<String, String> extraData, InterfaceC0837Nq interfaceC0837Nq) {
        this.A08 = str;
        this.A09 = c1q.A05();
        this.A0C.putAll(extraData);
        this.A0B.A05(interfaceC0837Nq);
        String A04 = c1q.A04();
        if (!TextUtils.isEmpty(A04)) {
            String buttonText = this.A09;
            if (!TextUtils.isEmpty(buttonText)) {
                setText(A04);
                A05();
                return;
            }
        }
        setVisibility(8);
    }

    public void setIsInAppBrowser(boolean z2) {
        this.A0B.A08(z2);
    }
}
