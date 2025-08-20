package os;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    public int f12351a;

    /* renamed from: fb  reason: collision with root package name */
    public final Path f12352fb;

    /* renamed from: gv  reason: collision with root package name */
    public int f12353gv;
    @NonNull

    /* renamed from: n3  reason: collision with root package name */
    public final Paint f12354n3;

    /* renamed from: s  reason: collision with root package name */
    public Paint f12355s;

    /* renamed from: v  reason: collision with root package name */
    public int f12356v;
    @NonNull
    public final Paint y;
    @NonNull

    /* renamed from: zn  reason: collision with root package name */
    public final Paint f12357zn;

    /* renamed from: c5  reason: collision with root package name */
    public static final int[] f12347c5 = new int[3];

    /* renamed from: i9  reason: collision with root package name */
    public static final float[] f12349i9 = {0.0f, 0.5f, 1.0f};

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f12348f = new int[4];

    /* renamed from: t  reason: collision with root package name */
    public static final float[] f12350t = {0.0f, 0.0f, 0.5f, 1.0f};

    public y() {
        this(-16777216);
    }

    public void gv(int i) {
        this.f12353gv = z6.y.a(i, 68);
        this.f12356v = z6.y.a(i, 20);
        this.f12351a = z6.y.a(i, 0);
        this.y.setColor(this.f12353gv);
    }

    public void n3(@NonNull Canvas canvas, @Nullable Matrix matrix, @NonNull RectF rectF, int i) {
        rectF.bottom += i;
        rectF.offset(0.0f, -i);
        int[] iArr = f12347c5;
        iArr[0] = this.f12351a;
        iArr[1] = this.f12356v;
        iArr[2] = this.f12353gv;
        Paint paint = this.f12357zn;
        float f4 = rectF.left;
        paint.setShader(new LinearGradient(f4, rectF.top, f4, rectF.bottom, iArr, f12349i9, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.f12357zn);
        canvas.restore();
    }

    public void y(@NonNull Canvas canvas, @Nullable Matrix matrix, @NonNull RectF rectF, int i, float f4, float f6) {
        boolean z2;
        if (f6 < 0.0f) {
            z2 = true;
        } else {
            z2 = false;
        }
        Path path = this.f12352fb;
        if (z2) {
            int[] iArr = f12348f;
            iArr[0] = 0;
            iArr[1] = this.f12351a;
            iArr[2] = this.f12356v;
            iArr[3] = this.f12353gv;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f4, f6);
            path.close();
            float f9 = -i;
            rectF.inset(f9, f9);
            int[] iArr2 = f12348f;
            iArr2[0] = 0;
            iArr2[1] = this.f12353gv;
            iArr2[2] = this.f12356v;
            iArr2[3] = this.f12351a;
        }
        float width = rectF.width() / 2.0f;
        if (width <= 0.0f) {
            return;
        }
        float f10 = 1.0f - (i / width);
        float[] fArr = f12350t;
        fArr[1] = f10;
        fArr[2] = ((1.0f - f10) / 2.0f) + f10;
        this.f12354n3.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), width, f12348f, fArr, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        if (!z2) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, this.f12355s);
        }
        canvas.drawArc(rectF, f4, f6, true, this.f12354n3);
        canvas.restore();
    }

    @NonNull
    public Paint zn() {
        return this.y;
    }

    public y(int i) {
        this.f12352fb = new Path();
        this.f12355s = new Paint();
        this.y = new Paint();
        gv(i);
        this.f12355s.setColor(0);
        Paint paint = new Paint(4);
        this.f12354n3 = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f12357zn = new Paint(paint);
    }
}
