package nd;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import vn.p;
import yk.mg;
import yk.ta;
import yk.ud;
/* loaded from: classes.dex */
public class gv extends n3 {

    /* renamed from: d  reason: collision with root package name */
    public final Rect f11938d;
    @Nullable

    /* renamed from: ej  reason: collision with root package name */
    public vn.y<ColorFilter, ColorFilter> f11939ej;

    /* renamed from: mg  reason: collision with root package name */
    public final Paint f11940mg;

    /* renamed from: ta  reason: collision with root package name */
    public final Rect f11941ta;
    @Nullable

    /* renamed from: ud  reason: collision with root package name */
    public vn.y<Bitmap, Bitmap> f11942ud;
    @Nullable

    /* renamed from: z6  reason: collision with root package name */
    public final ta f11943z6;

    public gv(mg mgVar, v vVar) {
        super(mgVar, vVar);
        this.f11940mg = new i2.y(3);
        this.f11941ta = new Rect();
        this.f11938d = new Rect();
        this.f11943z6 = mgVar.b(vVar.tl());
    }

    @Override // nd.n3, ne.a
    public <T> void a(T t2, @Nullable uo.zn<T> znVar) {
        super.a(t2, znVar);
        if (t2 == ud.f15449x) {
            if (znVar == null) {
                this.f11939ej = null;
            } else {
                this.f11939ej = new p(znVar);
            }
        } else if (t2 == ud.f15452yt) {
            if (znVar == null) {
                this.f11942ud = null;
            } else {
                this.f11942ud = new p(znVar);
            }
        }
    }

    @Override // nd.n3, i3.v
    public void gv(RectF rectF, Matrix matrix, boolean z2) {
        super.gv(rectF, matrix, z2);
        if (this.f11943z6 != null) {
            float v2 = br.s.v();
            rectF.set(0.0f, 0.0f, this.f11943z6.v() * v2, this.f11943z6.zn() * v2);
            this.f11969xc.mapRect(rectF);
        }
    }

    @Nullable
    public final Bitmap vl() {
        Bitmap s2;
        vn.y<Bitmap, Bitmap> yVar = this.f11942ud;
        if (yVar != null && (s2 = yVar.s()) != null) {
            return s2;
        }
        Bitmap mg2 = this.f11966w.mg(this.f11959p.tl());
        if (mg2 != null) {
            return mg2;
        }
        ta taVar = this.f11943z6;
        if (taVar != null) {
            return taVar.y();
        }
        return null;
    }

    @Override // nd.n3
    public void z(@NonNull Canvas canvas, Matrix matrix, int i) {
        Bitmap vl2 = vl();
        if (vl2 != null && !vl2.isRecycled() && this.f11943z6 != null) {
            float v2 = br.s.v();
            this.f11940mg.setAlpha(i);
            vn.y<ColorFilter, ColorFilter> yVar = this.f11939ej;
            if (yVar != null) {
                this.f11940mg.setColorFilter(yVar.s());
            }
            canvas.save();
            canvas.concat(matrix);
            this.f11941ta.set(0, 0, vl2.getWidth(), vl2.getHeight());
            if (this.f11966w.k5()) {
                this.f11938d.set(0, 0, (int) (this.f11943z6.v() * v2), (int) (this.f11943z6.zn() * v2));
            } else {
                this.f11938d.set(0, 0, (int) (vl2.getWidth() * v2), (int) (vl2.getHeight() * v2));
            }
            canvas.drawBitmap(vl2, this.f11941ta, this.f11938d, this.f11940mg);
            canvas.restore();
        }
    }
}
