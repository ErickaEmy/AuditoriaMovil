package y6;

import android.util.Property;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.google.android.material.R$id;
/* loaded from: classes.dex */
public class gv extends Property<ViewGroup, Float> {
    public static final Property<ViewGroup, Float> y = new gv("childrenAlpha");

    public gv(String str) {
        super(Float.class, str);
    }

    @Override // android.util.Property
    /* renamed from: n3 */
    public void set(@NonNull ViewGroup viewGroup, @NonNull Float f4) {
        float floatValue = f4.floatValue();
        viewGroup.setTag(R$id.mtrl_internal_children_alpha_tag, f4);
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            viewGroup.getChildAt(i).setAlpha(floatValue);
        }
    }

    @Override // android.util.Property
    @NonNull
    /* renamed from: y */
    public Float get(@NonNull ViewGroup viewGroup) {
        Float f4 = (Float) viewGroup.getTag(R$id.mtrl_internal_children_alpha_tag);
        if (f4 != null) {
            return f4;
        }
        return Float.valueOf(1.0f);
    }
}
