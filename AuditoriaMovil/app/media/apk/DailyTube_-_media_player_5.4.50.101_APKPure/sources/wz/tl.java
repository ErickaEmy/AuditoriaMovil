package wz;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$styleable;
/* loaded from: classes.dex */
public class tl extends PopupWindow {

    /* renamed from: n3  reason: collision with root package name */
    public static final boolean f14814n3 = false;
    public boolean y;

    public tl(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i5) {
        super(context, attributeSet, i, i5);
        y(context, attributeSet, i, i5);
    }

    public final void n3(boolean z2) {
        if (f14814n3) {
            this.y = z2;
        } else {
            j.t.y(this, z2);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i5) {
        if (f14814n3 && this.y) {
            i5 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i5);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i, int i5, int i6, int i8) {
        if (f14814n3 && this.y) {
            i5 -= view.getHeight();
        }
        super.update(view, i, i5, i6, i8);
    }

    public final void y(Context context, AttributeSet attributeSet, int i, int i5) {
        hw x42 = hw.x4(context, attributeSet, R$styleable.fp, i, i5);
        int i6 = R$styleable.sh;
        if (x42.co(i6)) {
            n3(x42.y(i6, false));
        }
        setBackgroundDrawable(x42.fb(R$styleable.hj));
        x42.i4();
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i5, int i6) {
        if (f14814n3 && this.y) {
            i5 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i5, i6);
    }
}
