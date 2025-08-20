package y6;

import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class v extends Property<Drawable, Integer> {

    /* renamed from: n3  reason: collision with root package name */
    public static final Property<Drawable, Integer> f15323n3 = new v();
    public final WeakHashMap<Drawable, Integer> y;

    public v() {
        super(Integer.class, "drawableAlphaCompat");
        this.y = new WeakHashMap<>();
    }

    @Override // android.util.Property
    /* renamed from: n3 */
    public void set(@NonNull Drawable drawable, @NonNull Integer num) {
        drawable.setAlpha(num.intValue());
    }

    @Override // android.util.Property
    @Nullable
    /* renamed from: y */
    public Integer get(@NonNull Drawable drawable) {
        return Integer.valueOf(drawable.getAlpha());
    }
}
