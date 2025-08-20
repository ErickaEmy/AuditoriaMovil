package b0;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import pv.n3;
import pv.zn;
/* loaded from: classes.dex */
public class y extends AppCompatTextView {
    public y(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public static int c5(@NonNull Context context, @NonNull TypedArray typedArray, @NonNull int... iArr) {
        int i = -1;
        for (int i5 = 0; i5 < iArr.length && i < 0; i5++) {
            i = zn.zn(context, typedArray, iArr[i5], -1);
        }
        return i;
    }

    public static boolean fb(Context context) {
        return n3.n3(context, R$attr.fdb, true);
    }

    public static boolean i9(@NonNull Context context, @NonNull Resources.Theme theme, @Nullable AttributeSet attributeSet, int i, int i5) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, R$styleable.gp, i, i5);
        int c52 = c5(context, obtainStyledAttributes, R$styleable.mk, R$styleable.lq);
        obtainStyledAttributes.recycle();
        if (c52 != -1) {
            return true;
        }
        return false;
    }

    public static int s(@NonNull Resources.Theme theme, @Nullable AttributeSet attributeSet, int i, int i5) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, R$styleable.gp, i, i5);
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.yb, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    public final void a(@NonNull Resources.Theme theme, int i) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(i, R$styleable.or);
        int c52 = c5(getContext(), obtainStyledAttributes, R$styleable.nw, R$styleable.a0);
        obtainStyledAttributes.recycle();
        if (c52 >= 0) {
            setLineHeight(c52);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextAppearance(@NonNull Context context, int i) {
        super.setTextAppearance(context, i);
        if (fb(context)) {
            a(context.getTheme(), i);
        }
    }

    public y(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public y(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i5) {
        super(c0.y.zn(context, attributeSet, i, i5), attributeSet, i);
        int s2;
        Context context2 = getContext();
        if (fb(context2)) {
            Resources.Theme theme = context2.getTheme();
            if (i9(context2, theme, attributeSet, i, i5) || (s2 = s(theme, attributeSet, i, i5)) == -1) {
                return;
            }
            a(theme, s2);
        }
    }
}
