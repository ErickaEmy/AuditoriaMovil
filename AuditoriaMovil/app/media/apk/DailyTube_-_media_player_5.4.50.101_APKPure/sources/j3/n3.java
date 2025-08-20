package j3;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import androidx.annotation.Nullable;
import br.gv;
import br.s;
import java.io.IOException;
import java.util.Map;
import yk.ta;
/* loaded from: classes.dex */
public class n3 {

    /* renamed from: gv  reason: collision with root package name */
    public static final Object f9365gv = new Object();

    /* renamed from: n3  reason: collision with root package name */
    public final String f9366n3;
    @Nullable
    public final Context y;

    /* renamed from: zn  reason: collision with root package name */
    public final Map<String, ta> f9367zn;

    public n3(Drawable.Callback callback, String str, yk.n3 n3Var, Map<String, ta> map) {
        if (!TextUtils.isEmpty(str) && str.charAt(str.length() - 1) != '/') {
            this.f9366n3 = str + '/';
        } else {
            this.f9366n3 = str;
        }
        this.f9367zn = map;
        gv(n3Var);
        if (!(callback instanceof View)) {
            this.y = null;
        } else {
            this.y = ((View) callback).getContext().getApplicationContext();
        }
    }

    public boolean n3(Context context) {
        if ((context == null && this.y == null) || this.y.equals(context)) {
            return true;
        }
        return false;
    }

    @Nullable
    public Bitmap y(String str) {
        ta taVar = this.f9367zn.get(str);
        if (taVar == null) {
            return null;
        }
        Bitmap y = taVar.y();
        if (y != null) {
            return y;
        }
        Context context = this.y;
        if (context == null) {
            return null;
        }
        String n32 = taVar.n3();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (n32.startsWith("data:") && n32.indexOf("base64,") > 0) {
            try {
                byte[] decode = Base64.decode(n32.substring(n32.indexOf(44) + 1), 0);
                return zn(str, BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
            } catch (IllegalArgumentException e2) {
                gv.gv("data URL did not have correct base64 format.", e2);
                return null;
            }
        }
        try {
            if (!TextUtils.isEmpty(this.f9366n3)) {
                AssetManager assets = context.getAssets();
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(assets.open(this.f9366n3 + n32), null, options);
                    if (decodeStream == null) {
                        gv.zn("Decoded image `" + str + "` is null.");
                        return null;
                    }
                    return zn(str, s.t(decodeStream, taVar.v(), taVar.zn()));
                } catch (IllegalArgumentException e3) {
                    gv.gv("Unable to decode image `" + str + "`.", e3);
                    return null;
                }
            }
            throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
        } catch (IOException e5) {
            gv.gv("Unable to open asset.", e5);
            return null;
        }
    }

    public final Bitmap zn(String str, @Nullable Bitmap bitmap) {
        synchronized (f9365gv) {
            this.f9367zn.get(str).a(bitmap);
        }
        return bitmap;
    }

    public void gv(@Nullable yk.n3 n3Var) {
    }
}
