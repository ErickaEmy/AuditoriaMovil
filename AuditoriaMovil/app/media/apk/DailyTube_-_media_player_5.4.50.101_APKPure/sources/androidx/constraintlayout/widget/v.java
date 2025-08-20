package androidx.constraintlayout.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import n.v;
/* loaded from: classes.dex */
public class v extends View {

    /* renamed from: fb  reason: collision with root package name */
    public int f1921fb;

    /* renamed from: v  reason: collision with root package name */
    public View f1922v;
    public int y;

    public View getContent() {
        return this.f1922v;
    }

    public int getEmptyVisibility() {
        return this.f1921fb;
    }

    public void n3(ConstraintLayout constraintLayout) {
        if (this.y == -1 && !isInEditMode()) {
            setVisibility(this.f1921fb);
        }
        View findViewById = constraintLayout.findViewById(this.y);
        this.f1922v = findViewById;
        if (findViewById != null) {
            ((ConstraintLayout.n3) findViewById.getLayoutParams()).f1682u = true;
            this.f1922v.setVisibility(0);
            setVisibility(0);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize(rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((width / 2.0f) - (rect.width() / 2.0f)) - rect.left, ((height / 2.0f) + (rect.height() / 2.0f)) - rect.bottom, paint);
        }
    }

    public void setContentId(int i) {
        View findViewById;
        if (this.y == i) {
            return;
        }
        View view = this.f1922v;
        if (view != null) {
            view.setVisibility(0);
            ((ConstraintLayout.n3) this.f1922v.getLayoutParams()).f1682u = false;
            this.f1922v = null;
        }
        this.y = i;
        if (i != -1 && (findViewById = ((View) getParent()).findViewById(i)) != null) {
            findViewById.setVisibility(8);
        }
    }

    public void setEmptyVisibility(int i) {
        this.f1921fb = i;
    }

    public void y(ConstraintLayout constraintLayout) {
        if (this.f1922v == null) {
            return;
        }
        ConstraintLayout.n3 n3Var = (ConstraintLayout.n3) getLayoutParams();
        ConstraintLayout.n3 n3Var2 = (ConstraintLayout.n3) this.f1922v.getLayoutParams();
        n3Var2.f1678s8.le(0);
        v.n3 n2 = n3Var.f1678s8.n();
        v.n3 n3Var3 = v.n3.FIXED;
        if (n2 != n3Var3) {
            n3Var.f1678s8.cs(n3Var2.f1678s8.qn());
        }
        if (n3Var.f1678s8.vl() != n3Var3) {
            n3Var.f1678s8.g(n3Var2.f1678s8.x4());
        }
        n3Var2.f1678s8.le(8);
    }
}
