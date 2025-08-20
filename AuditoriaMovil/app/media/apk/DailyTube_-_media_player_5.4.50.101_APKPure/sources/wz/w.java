package wz;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;
/* loaded from: classes.dex */
public class w extends RatingBar {
    public final wz y;

    public w(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.f633ej);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i, int i5) {
        super.onMeasure(i, i5);
        Bitmap n32 = this.y.n3();
        if (n32 != null) {
            setMeasuredDimension(View.resolveSizeAndState(n32.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }

    public w(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        x.y(this, getContext());
        wz wzVar = new wz(this);
        this.y = wzVar;
        wzVar.zn(attributeSet, i);
    }
}
