package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
/* loaded from: classes.dex */
public class Group extends n3 {
    public Group(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.constraintlayout.widget.n3
    public void i9(ConstraintLayout constraintLayout) {
        ConstraintLayout.n3 n3Var = (ConstraintLayout.n3) getLayoutParams();
        n3Var.f1678s8.cs(0);
        n3Var.f1678s8.g(0);
    }

    @Override // androidx.constraintlayout.widget.n3, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        gv();
    }

    @Override // androidx.constraintlayout.widget.n3
    public void s(AttributeSet attributeSet) {
        super.s(attributeSet);
        this.f1914f = false;
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
}
