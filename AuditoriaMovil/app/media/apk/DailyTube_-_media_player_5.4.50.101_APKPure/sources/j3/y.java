package j3;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Nullable;
import br.gv;
import java.util.HashMap;
import java.util.Map;
import ne.c5;
import ne.zn;
/* loaded from: classes.dex */
public class y {

    /* renamed from: gv  reason: collision with root package name */
    public final AssetManager f9368gv;
    public final c5<String> y = new c5<>();

    /* renamed from: n3  reason: collision with root package name */
    public final Map<c5<String>, Typeface> f9369n3 = new HashMap();

    /* renamed from: zn  reason: collision with root package name */
    public final Map<String, Typeface> f9371zn = new HashMap();

    /* renamed from: v  reason: collision with root package name */
    public String f9370v = ".ttf";

    public y(Drawable.Callback callback, @Nullable yk.y yVar) {
        if (!(callback instanceof View)) {
            gv.zn("LottieDrawable must be inside of a view for images to work.");
            this.f9368gv = null;
            return;
        }
        this.f9368gv = ((View) callback).getContext().getAssets();
    }

    public Typeface n3(zn znVar) {
        this.y.n3(znVar.y(), znVar.zn());
        Typeface typeface = this.f9369n3.get(this.y);
        if (typeface != null) {
            return typeface;
        }
        Typeface v2 = v(y(znVar), znVar.zn());
        this.f9369n3.put(this.y, v2);
        return v2;
    }

    public final Typeface v(Typeface typeface, String str) {
        int i;
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        if (contains && contains2) {
            i = 3;
        } else if (contains) {
            i = 2;
        } else if (contains2) {
            i = 1;
        } else {
            i = 0;
        }
        if (typeface.getStyle() == i) {
            return typeface;
        }
        return Typeface.create(typeface, i);
    }

    public final Typeface y(zn znVar) {
        String y = znVar.y();
        Typeface typeface = this.f9371zn.get(y);
        if (typeface != null) {
            return typeface;
        }
        znVar.zn();
        znVar.n3();
        if (znVar.gv() != null) {
            return znVar.gv();
        }
        Typeface createFromAsset = Typeface.createFromAsset(this.f9368gv, "fonts/" + y + this.f9370v);
        this.f9371zn.put(y, createFromAsset);
        return createFromAsset;
    }

    public void zn(String str) {
        this.f9370v = str;
    }

    public void gv(@Nullable yk.y yVar) {
    }
}
