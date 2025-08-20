package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import h6.a;
import h6.i9;
import h6.v;
/* loaded from: classes.dex */
public final class CircularProgressIndicator extends y<v> {

    /* renamed from: fh  reason: collision with root package name */
    public static final int f5811fh = R$style.ov;

    public CircularProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.jj);
    }

    public final void co() {
        setIndeterminateDrawable(i9.co(getContext(), (v) this.y));
        setProgressDrawable(a.r(getContext(), (v) this.y));
    }

    public int getIndicatorDirection() {
        return ((v) this.y).f8757c5;
    }

    public int getIndicatorInset() {
        return ((v) this.y).f8759s;
    }

    public int getIndicatorSize() {
        return ((v) this.y).f8758fb;
    }

    @Override // com.google.android.material.progressindicator.y
    /* renamed from: mt */
    public v c5(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        return new v(context, attributeSet);
    }

    public void setIndicatorDirection(int i) {
        ((v) this.y).f8757c5 = i;
        invalidate();
    }

    public void setIndicatorInset(int i) {
        S s2 = this.y;
        if (((v) s2).f8759s != i) {
            ((v) s2).f8759s = i;
            invalidate();
        }
    }

    public void setIndicatorSize(int i) {
        S s2 = this.y;
        if (((v) s2).f8758fb != i) {
            ((v) s2).f8758fb = i;
            ((v) s2).v();
            invalidate();
        }
    }

    @Override // com.google.android.material.progressindicator.y
    public void setTrackThickness(int i) {
        super.setTrackThickness(i);
        ((v) this.y).v();
    }

    public CircularProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, f5811fh);
        co();
    }
}
