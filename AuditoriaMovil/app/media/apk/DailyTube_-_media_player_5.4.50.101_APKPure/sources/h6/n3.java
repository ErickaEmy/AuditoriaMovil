package h6;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
/* loaded from: classes.dex */
public abstract class n3 {

    /* renamed from: a  reason: collision with root package name */
    public int f8751a;

    /* renamed from: gv  reason: collision with root package name */
    public int f8752gv;

    /* renamed from: n3  reason: collision with root package name */
    public int f8753n3;

    /* renamed from: v  reason: collision with root package name */
    public int f8754v;
    public int y;
    @NonNull

    /* renamed from: zn  reason: collision with root package name */
    public int[] f8755zn = new int[0];

    public n3(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i5) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.mm);
        TypedArray s2 = ur.i9.s(context, attributeSet, R$styleable.f5305x, i, i5, new int[0]);
        this.y = pv.zn.zn(context, s2, R$styleable.f5235o, dimensionPixelSize);
        this.f8753n3 = Math.min(pv.zn.zn(context, s2, R$styleable.f5260qn, 0), this.y / 2);
        this.f8754v = s2.getInt(R$styleable.f5293vl, 0);
        this.f8751a = s2.getInt(R$styleable.f5120b, 0);
        zn(context, s2);
        gv(context, s2);
        s2.recycle();
    }

    public final void gv(@NonNull Context context, @NonNull TypedArray typedArray) {
        int i = R$styleable.f5194j5;
        if (typedArray.hasValue(i)) {
            this.f8752gv = typedArray.getColor(i, -1);
            return;
        }
        this.f8752gv = this.f8755zn[0];
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{16842803});
        float f4 = obtainStyledAttributes.getFloat(0, 0.2f);
        obtainStyledAttributes.recycle();
        this.f8752gv = td.y.y(this.f8752gv, (int) (f4 * 255.0f));
    }

    public boolean n3() {
        if (this.f8754v != 0) {
            return true;
        }
        return false;
    }

    public abstract void v();

    public boolean y() {
        if (this.f8751a != 0) {
            return true;
        }
        return false;
    }

    public final void zn(@NonNull Context context, @NonNull TypedArray typedArray) {
        int i = R$styleable.f5202k5;
        if (!typedArray.hasValue(i)) {
            this.f8755zn = new int[]{td.y.n3(context, R$attr.f5086t, -1)};
        } else if (typedArray.peekValue(i).type != 1) {
            this.f8755zn = new int[]{typedArray.getColor(i, -1)};
        } else {
            int[] intArray = context.getResources().getIntArray(typedArray.getResourceId(i, -1));
            this.f8755zn = intArray;
            if (intArray.length != 0) {
                return;
            }
            throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
        }
    }
}
