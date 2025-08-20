package h6;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import com.google.android.material.progressindicator.CircularProgressIndicator;
/* loaded from: classes.dex */
public final class v extends n3 {

    /* renamed from: c5  reason: collision with root package name */
    public int f8757c5;

    /* renamed from: fb  reason: collision with root package name */
    public int f8758fb;

    /* renamed from: s  reason: collision with root package name */
    public int f8759s;

    public v(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.jj);
    }

    @Override // h6.n3
    public void v() {
        if (this.f8758fb >= this.y * 2) {
            return;
        }
        throw new IllegalArgumentException("The indicatorSize (" + this.f8758fb + " px) cannot be less than twice of the trackThickness (" + this.y + " px).");
    }

    public v(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, CircularProgressIndicator.f5811fh);
    }

    public v(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i5) {
        super(context, attributeSet, i, i5);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.mh);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R$dimen.mk);
        TypedArray s2 = ur.i9.s(context, attributeSet, R$styleable.f5193j3, i, i5, new int[0]);
        this.f8758fb = pv.zn.zn(context, s2, R$styleable.f5302wm, dimensionPixelSize);
        this.f8759s = pv.zn.zn(context, s2, R$styleable.f5252q, dimensionPixelSize2);
        this.f8757c5 = s2.getInt(R$styleable.f5230ne, 0);
        s2.recycle();
        v();
    }
}
