package com.facebook.ads.redexgen.X;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Ng  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0827Ng extends Drawable {
    public static byte[] A0G;
    public static String[] A0H = {"Mp", "s1okci9AACeOEsTaqEhejkWwVhqIiyNU", "empHZDdin7c86b5ED3ajK85vhcLRVQYd", "QRrQz6m9v7aBhecCWxUXgpf0lUmjJya0", "Hctlswo9ad12sYru2lKVThOw6NzJy2jW", "0MQcFv6TsH62DS4QTRzsSvzajYizZeJ9", "0Y", "3fR7fZsYHtoPr7aoRN1kO3di1PlcoJD4"};
    public int A00;
    public int A01;
    public int A02;
    public long A03;
    public String A04;
    public String A05;
    public String A06;
    public WeakReference<RE> A07;
    public boolean A08;
    public final Paint A09;
    public final Paint A0A;
    public final Paint A0B;
    public final Path A0C;
    public final Handler A0D;
    public final TextPaint A0E;
    public final Runnable A0F;

    public static String A02(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0G, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 62);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A0G = new byte[]{65, 73, 21, 42, 38, 52, 121, 99, 24, 87, 94, 24, 81, 93, 49, 18, 28, 25, 24, 25, 93, 117, 109, 114, 116, 109, 115, 55, 21, 6, 16, 84, 86, 113, 118, 107, 118, 126, 115, 118, 101, 118, 113, 120, 49, 49, 49, 60, 11, 4, 79, 68, Byte.MAX_VALUE, 122, Byte.MAX_VALUE, 126, 102, Byte.MAX_VALUE, 108, 83, 95, 77, 91, 88, 83, 86, 83, 78, 67, 26, 121, 82, 95, 89, 81, 95, 72, 26, 84, 85, 78, 26, 73, 95, 78, 32, 104, 48, 125, 51, 96, 33, 39, 47};
    }

    static {
        A04();
    }

    public C0827Ng() {
        Paint paint = new Paint();
        this.A09 = paint;
        Paint paint2 = new Paint();
        this.A0A = paint2;
        this.A0C = new Path();
        TextPaint textPaint = new TextPaint();
        this.A0E = textPaint;
        Paint paint3 = new Paint();
        this.A0B = paint3;
        this.A0D = new Handler();
        this.A0F = new C0994Tr(this);
        paint.setColor(Color.argb(127, 36, 36, 36));
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(Color.argb(191, 0, 255, 0));
        paint2.setStrokeWidth(20.0f);
        paint2.setStyle(Paint.Style.STROKE);
        textPaint.setAntiAlias(true);
        textPaint.setColor(-1);
        textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        textPaint.setTextSize(30.0f);
        paint3.setColor(Color.argb(212, 0, 0, 0));
        paint3.setStyle(Paint.Style.FILL_AND_STROKE);
        A07();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A03() {
        StringBuilder sb = new StringBuilder();
        int i = this.A00;
        String A02 = A02(0, 1, 117);
        if (i <= 0) {
            if (!TextUtils.isEmpty(this.A06)) {
                sb.append(this.A06);
                sb.append(A02);
            }
            if (!TextUtils.isEmpty(this.A04)) {
                sb.append(this.A04);
                sb.append(A02);
            }
            sb.append(A02(47, 4, 81));
            sb.append(A02(21, 6, 125));
            sb.append(A02(12, 9, 67));
            if (this.A03 > 0) {
                long max = Math.max(0L, System.currentTimeMillis() - this.A03);
                int i5 = (int) (max / 3600000);
                long j2 = max % 3600000;
                int minutes = (int) (j2 / 60000);
                int i6 = (int) ((j2 % 60000) / 1000);
                if (i5 > 0) {
                    sb.append(i5);
                    sb.append(A02(85, 2, 118));
                }
                if (i5 > 0 || minutes > 0) {
                    sb.append(minutes);
                    sb.append(A02(87, 2, 99));
                }
                sb.append(i6);
                sb.append(A02(89, 5, 126));
            } else {
                String[] strArr = A0H;
                if (strArr[3].charAt(18) == strArr[1].charAt(18)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0H;
                strArr2[4] = "KaVl90AUCQiyYrscuVoIg37eW2R2JvQo";
                strArr2[2] = "0pxfQADbA4sIF5gDourAGVlubWCldmoZ";
                sb.append(A02(51, 7, 47));
            }
        } else {
            sb.append(A02(27, 5, 74));
            sb.append(this.A01 + 1);
            sb.append(A02(8, 4, 6));
            sb.append(this.A00);
        }
        sb.append(A02(1, 7, 125));
        WeakReference<RE> weakReference = this.A07;
        if (weakReference == null || weakReference.get() == null) {
            sb.append(A02(58, 27, 4));
        } else {
            sb.append(this.A07.get().A0R());
        }
        String sb2 = sb.toString();
        this.A05 = sb2;
        float f4 = -2.14748365E9f;
        String[] split = sb2.split(A02);
        for (String str : split) {
            f4 = Math.max(f4, this.A0E.measureText(str, 0, str.length()));
        }
        this.A02 = (int) (0.5f + f4);
        invalidateSelf();
    }

    public final void A07() {
        this.A00 = 0;
        this.A01 = -1;
        this.A05 = A02(32, 15, 33);
        this.A02 = 100;
        this.A06 = null;
        this.A03 = -1L;
        this.A07 = null;
        A0D(false);
    }

    public final void A08(int i, int i5) {
        this.A00 = i;
        this.A01 = i5;
        A03();
    }

    public final void A09(long j2) {
        this.A03 = j2;
        A03();
    }

    public final void A0A(RE re) {
        this.A07 = new WeakReference<>(re);
        A03();
    }

    public final void A0B(String str) {
        this.A04 = str;
        A03();
    }

    public final void A0C(String str) {
        this.A06 = str;
        A03();
    }

    public final void A0D(boolean z2) {
        this.A08 = z2;
        if (z2) {
            this.A0D.post(this.A0F);
        } else {
            this.A0D.removeCallbacks(this.A0F);
        }
        invalidateSelf();
    }

    public final boolean A0E() {
        return this.A08;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (!this.A08) {
            return;
        }
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        canvas.drawRect(0.0f, 0.0f, width, height, this.A09);
        StaticLayout textLayout = new StaticLayout(this.A05, this.A0E, this.A02, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        float f4 = width / 2.0f;
        float f6 = height / 2.0f;
        float width2 = textLayout.getWidth() / 2.0f;
        float height2 = textLayout.getHeight() / 2.0f;
        float canvasMiddleY = f4 - width2;
        float textMiddleX = f6 - height2;
        float textMiddleY = f4 + width2;
        canvas.drawRect(canvasMiddleY - 40.0f, textMiddleX - 40.0f, textMiddleY + 40.0f, f6 + height2 + 40.0f, this.A0B);
        canvas.save();
        canvas.translate(f4 - width2, f6 - height2);
        textLayout.draw(canvas);
        canvas.restore();
        this.A0C.reset();
        this.A0C.moveTo(0.0f, 0.0f);
        this.A0C.lineTo(width, 0.0f);
        this.A0C.lineTo(width, height);
        this.A0C.lineTo(0.0f, height);
        this.A0C.lineTo(0.0f, 0.0f);
        canvas.drawPath(this.A0C, this.A0A);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
