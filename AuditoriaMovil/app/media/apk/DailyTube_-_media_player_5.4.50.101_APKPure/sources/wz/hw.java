package wz;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.Nullable;
import d.s;
/* loaded from: classes.dex */
public class hw {

    /* renamed from: n3  reason: collision with root package name */
    public final TypedArray f14723n3;
    public final Context y;

    /* renamed from: zn  reason: collision with root package name */
    public TypedValue f14724zn;

    public hw(Context context, TypedArray typedArray) {
        this.y = context;
        this.f14723n3 = typedArray;
    }

    public static hw r(Context context, AttributeSet attributeSet, int[] iArr) {
        return new hw(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static hw x4(Context context, AttributeSet attributeSet, int[] iArr, int i, int i5) {
        return new hw(context, context.obtainStyledAttributes(attributeSet, iArr, i, i5));
    }

    public static hw z(Context context, int i, int[] iArr) {
        return new hw(context, context.obtainStyledAttributes(i, iArr));
    }

    public int a(int i, int i5) {
        return this.f14723n3.getDimensionPixelSize(i, i5);
    }

    public float c5(int i, float f4) {
        return this.f14723n3.getFloat(i, f4);
    }

    public boolean co(int i) {
        return this.f14723n3.hasValue(i);
    }

    public int f(int i, int i5) {
        return this.f14723n3.getInt(i, i5);
    }

    public Drawable fb(int i) {
        int resourceId;
        if (this.f14723n3.hasValue(i) && (resourceId = this.f14723n3.getResourceId(i, 0)) != 0) {
            return c5.y.gv(this.y, resourceId);
        }
        return this.f14723n3.getDrawable(i);
    }

    public float gv(int i, float f4) {
        return this.f14723n3.getDimension(i, f4);
    }

    public void i4() {
        this.f14723n3.recycle();
    }

    @Nullable
    public Typeface i9(int i, int i5, @Nullable s.v vVar) {
        int resourceId = this.f14723n3.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f14724zn == null) {
            this.f14724zn = new TypedValue();
        }
        return d.s.fb(this.y, resourceId, this.f14724zn, i5, vVar);
    }

    public TypedArray mt() {
        return this.f14723n3;
    }

    public int n3(int i, int i5) {
        return this.f14723n3.getColor(i, i5);
    }

    public CharSequence[] p(int i) {
        return this.f14723n3.getTextArray(i);
    }

    public Drawable s(int i) {
        int resourceId;
        if (this.f14723n3.hasValue(i) && (resourceId = this.f14723n3.getResourceId(i, 0)) != 0) {
            return c5.n3().gv(this.y, resourceId, true);
        }
        return null;
    }

    public int t(int i, int i5) {
        return this.f14723n3.getInteger(i, i5);
    }

    public int tl(int i, int i5) {
        return this.f14723n3.getLayoutDimension(i, i5);
    }

    public int v(int i, int i5) {
        return this.f14723n3.getDimensionPixelOffset(i, i5);
    }

    public CharSequence w(int i) {
        return this.f14723n3.getText(i);
    }

    public int wz(int i, int i5) {
        return this.f14723n3.getResourceId(i, i5);
    }

    public String xc(int i) {
        return this.f14723n3.getString(i);
    }

    public boolean y(int i, boolean z2) {
        return this.f14723n3.getBoolean(i, z2);
    }

    public ColorStateList zn(int i) {
        int resourceId;
        ColorStateList zn2;
        if (this.f14723n3.hasValue(i) && (resourceId = this.f14723n3.getResourceId(i, 0)) != 0 && (zn2 = c5.y.zn(this.y, resourceId)) != null) {
            return zn2;
        }
        return this.f14723n3.getColorStateList(i);
    }
}
