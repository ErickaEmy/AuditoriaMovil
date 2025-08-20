package c0;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$attr;
import t.gv;
/* loaded from: classes.dex */
public class y {
    public static final int[] y = {16842752, R$attr.f5079b};

    /* renamed from: n3  reason: collision with root package name */
    public static final int[] f3970n3 = {R$attr.fr5};

    public static int n3(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i5) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f3970n3, i, i5);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    public static int y(@NonNull Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, y);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
        if (resourceId == 0) {
            return resourceId2;
        }
        return resourceId;
    }

    @NonNull
    public static Context zn(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i5) {
        boolean z2;
        int n32 = n3(context, attributeSet, i, i5);
        if ((context instanceof gv) && ((gv) context).zn() == n32) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (n32 != 0 && !z2) {
            gv gvVar = new gv(context, n32);
            int y2 = y(context, attributeSet);
            if (y2 != 0) {
                gvVar.getTheme().applyStyle(y2, true);
            }
            return gvVar;
        }
        return context;
    }
}
