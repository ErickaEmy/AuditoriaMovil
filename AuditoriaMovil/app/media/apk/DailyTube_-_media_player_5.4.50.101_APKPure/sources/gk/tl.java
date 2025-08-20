package gk;

import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import gk.gv;
/* loaded from: classes.dex */
public final class tl extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener, gv.y {

    /* renamed from: f  reason: collision with root package name */
    public final GestureDetector f8331f;

    /* renamed from: fb  reason: collision with root package name */
    public final y f8332fb;

    /* renamed from: s  reason: collision with root package name */
    public final float f8333s;
    public final PointF y = new PointF();

    /* renamed from: v  reason: collision with root package name */
    public final PointF f8335v = new PointF();

    /* renamed from: t  reason: collision with root package name */
    public volatile float f8334t = 3.1415927f;

    /* loaded from: classes.dex */
    public interface y {
        void n3(PointF pointF);

        boolean onSingleTapUp(MotionEvent motionEvent);
    }

    public tl(Context context, y yVar, float f4) {
        this.f8332fb = yVar;
        this.f8333s = f4;
        this.f8331f = new GestureDetector(context, this);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        this.y.set(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f4, float f6) {
        float x2 = (motionEvent2.getX() - this.y.x) / this.f8333s;
        float y2 = motionEvent2.getY();
        PointF pointF = this.y;
        float f9 = (y2 - pointF.y) / this.f8333s;
        pointF.set(motionEvent2.getX(), motionEvent2.getY());
        double d2 = this.f8334t;
        float cos = (float) Math.cos(d2);
        float sin = (float) Math.sin(d2);
        PointF pointF2 = this.f8335v;
        pointF2.x -= (cos * x2) - (sin * f9);
        float f10 = pointF2.y + (sin * x2) + (cos * f9);
        pointF2.y = f10;
        pointF2.y = Math.max(-45.0f, Math.min(45.0f, f10));
        this.f8332fb.n3(this.f8335v);
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return this.f8332fb.onSingleTapUp(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f8331f.onTouchEvent(motionEvent);
    }

    @Override // gk.gv.y
    public void y(float[] fArr, float f4) {
        this.f8334t = -f4;
    }
}
