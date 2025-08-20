package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
/* renamed from: com.facebook.ads.redexgen.X.Lv  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC0790Lv {
    public static Bitmap A00(C1116Yn c1116Yn, Bitmap bitmap, int i) throws RSRuntimeException {
        RenderScript renderScript = null;
        Allocation allocation = null;
        Allocation output = null;
        ScriptIntrinsicBlur scriptIntrinsicBlur = null;
        try {
            renderScript = RenderScript.create(c1116Yn);
            renderScript.setMessageHandler(new RenderScript.RSMessageHandler());
            allocation = Allocation.createFromBitmap(renderScript, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
            output = Allocation.createTyped(renderScript, allocation.getType());
            scriptIntrinsicBlur = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
            scriptIntrinsicBlur.setInput(allocation);
            scriptIntrinsicBlur.setRadius(i);
            scriptIntrinsicBlur.forEach(output);
            output.copyTo(bitmap);
            return bitmap;
        } finally {
            if (renderScript != null) {
                renderScript.destroy();
            }
            if (allocation != null) {
                allocation.destroy();
            }
            if (output != null) {
                output.destroy();
            }
            if (scriptIntrinsicBlur != null) {
                scriptIntrinsicBlur.destroy();
            }
        }
    }

    public static Bitmap A01(C1116Yn c1116Yn, Bitmap bitmap, int i, int i5) {
        int width = bitmap.getWidth() / i5;
        int height = bitmap.getHeight() / i5;
        if (width == 0 || height == 0) {
            return null;
        }
        int height2 = Build.VERSION.SDK_INT;
        if (height2 < 18) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.scale(1.0f / i5, 1.0f / i5);
        Paint paint = new Paint();
        paint.setFlags(3);
        paint.setColorFilter(new PorterDuffColorFilter(0, PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        try {
            Bitmap A00 = A00(c1116Yn, createBitmap, i);
            if (i5 != 1) {
                int height3 = bitmap.getWidth();
                int width2 = bitmap.getHeight();
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(A00, height3, width2, true);
                A00.recycle();
                return createScaledBitmap;
            }
            return A00;
        } catch (RSRuntimeException unused) {
            return new C1003Ua().A02(createBitmap, i);
        }
    }
}
