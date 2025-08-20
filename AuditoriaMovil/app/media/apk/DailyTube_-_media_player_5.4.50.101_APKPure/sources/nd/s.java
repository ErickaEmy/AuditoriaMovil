package nd;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import vn.p;
import yk.mg;
import yk.ud;
/* loaded from: classes.dex */
public class s extends n3 {

    /* renamed from: d  reason: collision with root package name */
    public final float[] f11973d;

    /* renamed from: ej  reason: collision with root package name */
    public final v f11974ej;

    /* renamed from: mg  reason: collision with root package name */
    public final RectF f11975mg;

    /* renamed from: ta  reason: collision with root package name */
    public final Paint f11976ta;
    @Nullable

    /* renamed from: ud  reason: collision with root package name */
    public vn.y<ColorFilter, ColorFilter> f11977ud;

    /* renamed from: z6  reason: collision with root package name */
    public final Path f11978z6;

    public s(mg mgVar, v vVar) {
        super(mgVar, vVar);
        this.f11975mg = new RectF();
        i2.y yVar = new i2.y();
        this.f11976ta = yVar;
        this.f11973d = new float[8];
        this.f11978z6 = new Path();
        this.f11974ej = vVar;
        yVar.setAlpha(0);
        yVar.setStyle(Paint.Style.FILL);
        yVar.setColor(vVar.xc());
    }

    @Override // nd.n3, ne.a
    public <T> void a(T t2, @Nullable uo.zn<T> znVar) {
        super.a(t2, znVar);
        if (t2 == ud.f15449x) {
            if (znVar == null) {
                this.f11977ud = null;
            } else {
                this.f11977ud = new p(znVar);
            }
        }
    }

    @Override // nd.n3, i3.v
    public void gv(RectF rectF, Matrix matrix, boolean z2) {
        super.gv(rectF, matrix, z2);
        this.f11975mg.set(0.0f, 0.0f, this.f11974ej.p(), this.f11974ej.w());
        this.f11969xc.mapRect(this.f11975mg);
        rectF.set(this.f11975mg);
    }

    @Override // nd.n3
    public void z(Canvas canvas, Matrix matrix, int i) {
        int intValue;
        int alpha = Color.alpha(this.f11974ej.xc());
        if (alpha == 0) {
            return;
        }
        if (this.f11950f3.s() == null) {
            intValue = 100;
        } else {
            intValue = this.f11950f3.s().s().intValue();
        }
        int i5 = (int) ((i / 255.0f) * (((alpha / 255.0f) * intValue) / 100.0f) * 255.0f);
        this.f11976ta.setAlpha(i5);
        vn.y<ColorFilter, ColorFilter> yVar = this.f11977ud;
        if (yVar != null) {
            this.f11976ta.setColorFilter(yVar.s());
        }
        if (i5 > 0) {
            float[] fArr = this.f11973d;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.f11974ej.p();
            float[] fArr2 = this.f11973d;
            fArr2[3] = 0.0f;
            fArr2[4] = this.f11974ej.p();
            this.f11973d[5] = this.f11974ej.w();
            float[] fArr3 = this.f11973d;
            fArr3[6] = 0.0f;
            fArr3[7] = this.f11974ej.w();
            matrix.mapPoints(this.f11973d);
            this.f11978z6.reset();
            Path path = this.f11978z6;
            float[] fArr4 = this.f11973d;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.f11978z6;
            float[] fArr5 = this.f11973d;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.f11978z6;
            float[] fArr6 = this.f11973d;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.f11978z6;
            float[] fArr7 = this.f11973d;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.f11978z6;
            float[] fArr8 = this.f11973d;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.f11978z6.close();
            canvas.drawPath(this.f11978z6, this.f11976ta);
        }
    }
}
