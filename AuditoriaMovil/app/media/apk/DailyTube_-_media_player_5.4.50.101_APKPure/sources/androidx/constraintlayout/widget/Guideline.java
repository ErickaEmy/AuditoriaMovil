package androidx.constraintlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
/* loaded from: classes.dex */
public class Guideline extends View {
    public Guideline(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int i, int i5) {
        setMeasuredDimension(0, 0);
    }

    public void setGuidelineBegin(int i) {
        ConstraintLayout.n3 n3Var = (ConstraintLayout.n3) getLayoutParams();
        n3Var.y = i;
        setLayoutParams(n3Var);
    }

    public void setGuidelineEnd(int i) {
        ConstraintLayout.n3 n3Var = (ConstraintLayout.n3) getLayoutParams();
        n3Var.f1665n3 = i;
        setLayoutParams(n3Var);
    }

    public void setGuidelinePercent(float f4) {
        ConstraintLayout.n3 n3Var = (ConstraintLayout.n3) getLayoutParams();
        n3Var.f1697zn = f4;
        setLayoutParams(n3Var);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
    }

    public Guideline(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }
}
