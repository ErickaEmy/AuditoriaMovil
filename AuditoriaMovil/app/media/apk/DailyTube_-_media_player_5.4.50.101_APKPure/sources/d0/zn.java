package d0;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;
import n.f;
/* loaded from: classes.dex */
public abstract class zn extends androidx.constraintlayout.widget.n3 {

    /* renamed from: co  reason: collision with root package name */
    public boolean f6962co;

    /* renamed from: z  reason: collision with root package name */
    public boolean f6963z;

    @Override // androidx.constraintlayout.widget.n3, android.view.View
    public void onAttachedToWindow() {
        ViewParent parent;
        super.onAttachedToWindow();
        if ((this.f6962co || this.f6963z) && (parent = getParent()) != null && (parent instanceof ConstraintLayout)) {
            ConstraintLayout constraintLayout = (ConstraintLayout) parent;
            int visibility = getVisibility();
            float elevation = getElevation();
            for (int i = 0; i < this.f1919v; i++) {
                View c52 = constraintLayout.c5(this.y[i]);
                if (c52 != null) {
                    if (this.f6962co) {
                        c52.setVisibility(visibility);
                    }
                    if (this.f6963z && elevation > 0.0f) {
                        c52.setTranslationZ(c52.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.widget.n3
    public void s(AttributeSet attributeSet) {
        super.s(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.f1867vn);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R$styleable.f1805ne) {
                    this.f6962co = true;
                } else if (index == R$styleable.f1716bv) {
                    this.f6963z = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.View
    public void setElevation(float f4) {
        super.setElevation(f4);
        gv();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        gv();
    }

    public void xc(f fVar, int i, int i5) {
    }
}
