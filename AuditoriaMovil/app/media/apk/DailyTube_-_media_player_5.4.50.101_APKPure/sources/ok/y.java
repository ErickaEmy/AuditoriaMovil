package ok;

import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class y implements View.OnTouchListener {

    /* renamed from: fb  reason: collision with root package name */
    public final int f12333fb;

    /* renamed from: s  reason: collision with root package name */
    public final int f12334s;

    /* renamed from: v  reason: collision with root package name */
    public final int f12335v;
    @NonNull
    public final Dialog y;

    public y(@NonNull Dialog dialog, @NonNull Rect rect) {
        this.y = dialog;
        this.f12335v = rect.left;
        this.f12333fb = rect.top;
        this.f12334s = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@NonNull View view, @NonNull MotionEvent motionEvent) {
        View findViewById = view.findViewById(16908290);
        int left = this.f12335v + findViewById.getLeft();
        int width = findViewById.getWidth() + left;
        int top = this.f12333fb + findViewById.getTop();
        if (new RectF(left, top, width, findViewById.getHeight() + top).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            obtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            obtain.setAction(0);
            int i = this.f12334s;
            obtain.setLocation((-i) - 1, (-i) - 1);
        }
        view.performClick();
        return this.y.onTouchEvent(obtain);
    }
}
