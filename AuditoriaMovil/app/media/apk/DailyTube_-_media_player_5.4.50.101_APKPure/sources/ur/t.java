package ur;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
public class t extends ImageButton {
    public int y;

    public t(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final int getUserSetVisibility() {
        return this.y;
    }

    public final void n3(int i, boolean z2) {
        super.setVisibility(i);
        if (z2) {
            this.y = i;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        n3(i, true);
    }

    public t(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.y = getVisibility();
    }
}
