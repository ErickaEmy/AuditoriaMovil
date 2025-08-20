package wz;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class j extends Resources {

    /* renamed from: n3  reason: collision with root package name */
    public static boolean f14725n3;
    public final WeakReference<Context> y;

    public j(@NonNull Context context, @NonNull Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.y = new WeakReference<>(context);
    }

    public static boolean n3() {
        y();
        return false;
    }

    public static boolean y() {
        return f14725n3;
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        Context context = this.y.get();
        if (context != null) {
            return z6.s().z(context, this, i);
        }
        return super.getDrawable(i);
    }

    public final Drawable zn(int i) {
        return super.getDrawable(i);
    }
}
