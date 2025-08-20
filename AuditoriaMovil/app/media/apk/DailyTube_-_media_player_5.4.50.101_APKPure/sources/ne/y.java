package ne;

import android.annotation.SuppressLint;
import android.graphics.PointF;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class y {

    /* renamed from: n3  reason: collision with root package name */
    public final PointF f12025n3;
    public final PointF y;

    /* renamed from: zn  reason: collision with root package name */
    public final PointF f12026zn;

    public y() {
        this.y = new PointF();
        this.f12025n3 = new PointF();
        this.f12026zn = new PointF();
    }

    public void a(float f4, float f6) {
        this.f12026zn.set(f4, f6);
    }

    public void gv(float f4, float f6) {
        this.y.set(f4, f6);
    }

    public PointF n3() {
        return this.f12025n3;
    }

    @NonNull
    @SuppressLint({"DefaultLocale"})
    public String toString() {
        return String.format("v=%.2f,%.2f cp1=%.2f,%.2f cp2=%.2f,%.2f", Float.valueOf(this.f12026zn.x), Float.valueOf(this.f12026zn.y), Float.valueOf(this.y.x), Float.valueOf(this.y.y), Float.valueOf(this.f12025n3.x), Float.valueOf(this.f12025n3.y));
    }

    public void v(float f4, float f6) {
        this.f12025n3.set(f4, f6);
    }

    public PointF y() {
        return this.y;
    }

    public PointF zn() {
        return this.f12026zn;
    }

    public y(PointF pointF, PointF pointF2, PointF pointF3) {
        this.y = pointF;
        this.f12025n3 = pointF2;
        this.f12026zn = pointF3;
    }
}
