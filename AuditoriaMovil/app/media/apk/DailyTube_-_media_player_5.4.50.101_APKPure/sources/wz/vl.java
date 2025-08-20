package wz;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class vl extends ej {

    /* renamed from: n3  reason: collision with root package name */
    public final WeakReference<Context> f14827n3;

    public vl(@NonNull Context context, @NonNull Resources resources) {
        super(resources);
        this.f14827n3 = new WeakReference<>(context);
    }

    @Override // wz.ej, android.content.res.Resources
    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        Drawable drawable = super.getDrawable(i);
        Context context = this.f14827n3.get();
        if (drawable != null && context != null) {
            z6.s().f3(context, i, drawable);
        }
        return drawable;
    }
}
