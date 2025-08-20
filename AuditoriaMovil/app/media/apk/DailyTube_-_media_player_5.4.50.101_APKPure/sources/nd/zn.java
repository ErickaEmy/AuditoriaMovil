package nd;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import nd.v;
import vn.p;
import yk.mg;
import yk.ud;
/* loaded from: classes.dex */
public class zn extends n3 {

    /* renamed from: d  reason: collision with root package name */
    public final RectF f12015d;

    /* renamed from: ej  reason: collision with root package name */
    public final Paint f12016ej;
    @Nullable

    /* renamed from: mg  reason: collision with root package name */
    public vn.y<Float, Float> f12017mg;

    /* renamed from: ta  reason: collision with root package name */
    public final List<n3> f12018ta;

    /* renamed from: ud  reason: collision with root package name */
    public boolean f12019ud;

    /* renamed from: z6  reason: collision with root package name */
    public final RectF f12020z6;

    /* loaded from: classes.dex */
    public static /* synthetic */ class y {
        public static final /* synthetic */ int[] y;

        static {
            int[] iArr = new int[v.n3.values().length];
            y = iArr;
            try {
                iArr[v.n3.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                y[v.n3.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public zn(mg mgVar, v vVar, List<v> list, yk.s sVar) {
        super(mgVar, vVar);
        int i;
        n3 n3Var;
        this.f12018ta = new ArrayList();
        this.f12015d = new RectF();
        this.f12020z6 = new RectF();
        this.f12016ej = new Paint();
        this.f12019ud = true;
        q.n3 r2 = vVar.r();
        if (r2 != null) {
            vn.y<Float, Float> y2 = r2.y();
            this.f12017mg = y2;
            c5(y2);
            this.f12017mg.y(this);
        } else {
            this.f12017mg = null;
        }
        z.v vVar2 = new z.v(sVar.f().size());
        int size = list.size() - 1;
        n3 n3Var2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            v vVar3 = list.get(size);
            n3 r3 = n3.r(this, vVar3, mgVar, sVar);
            if (r3 != null) {
                vVar2.tl(r3.n().gv(), r3);
                if (n3Var2 != null) {
                    n3Var2.ud(r3);
                    n3Var2 = null;
                } else {
                    this.f12018ta.add(0, r3);
                    int i5 = y.y[vVar3.s().ordinal()];
                    if (i5 == 1 || i5 == 2) {
                        n3Var2 = r3;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < vVar2.w(); i++) {
            n3 n3Var3 = (n3) vVar2.s(vVar2.t(i));
            if (n3Var3 != null && (n3Var = (n3) vVar2.s(n3Var3.n().i9())) != null) {
                n3Var3.x(n3Var);
            }
        }
    }

    @Override // nd.n3, ne.a
    public <T> void a(T t2, @Nullable uo.zn<T> znVar) {
        super.a(t2, znVar);
        if (t2 == ud.f15442ta) {
            if (znVar == null) {
                vn.y<Float, Float> yVar = this.f12017mg;
                if (yVar != null) {
                    yVar.wz(null);
                    return;
                }
                return;
            }
            p pVar = new p(znVar);
            this.f12017mg = pVar;
            pVar.y(this);
            c5(this.f12017mg);
        }
    }

    @Override // nd.n3
    public void a8(boolean z2) {
        super.a8(z2);
        for (n3 n3Var : this.f12018ta) {
            n3Var.a8(z2);
        }
    }

    @Override // nd.n3
    public void b(float f4) {
        super.b(f4);
        if (this.f12017mg != null) {
            f4 = ((this.f12017mg.s().floatValue() * this.f11959p.n3().c5()) - this.f11959p.n3().w()) / (this.f11966w.d().v() + 0.01f);
        }
        if (this.f12017mg == null) {
            f4 -= this.f11959p.mt();
        }
        if (this.f11959p.x4() != 0.0f && !"__container".equals(this.f11959p.c5())) {
            f4 /= this.f11959p.x4();
        }
        for (int size = this.f12018ta.size() - 1; size >= 0; size--) {
            this.f12018ta.get(size).b(f4);
        }
    }

    @Override // nd.n3
    public void ej(ne.v vVar, int i, List<ne.v> list, ne.v vVar2) {
        for (int i5 = 0; i5 < this.f12018ta.size(); i5++) {
            this.f12018ta.get(i5).zn(vVar, i, list, vVar2);
        }
    }

    @Override // nd.n3, i3.v
    public void gv(RectF rectF, Matrix matrix, boolean z2) {
        super.gv(rectF, matrix, z2);
        for (int size = this.f12018ta.size() - 1; size >= 0; size--) {
            this.f12015d.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.f12018ta.get(size).gv(this.f12015d, this.f11969xc, true);
            rectF.union(this.f12015d);
        }
    }

    public void vl(boolean z2) {
        this.f12019ud = z2;
    }

    @Override // nd.n3
    public void z(Canvas canvas, Matrix matrix, int i) {
        boolean z2;
        boolean clipRect;
        yk.zn.y("CompositionLayer#draw");
        this.f12020z6.set(0.0f, 0.0f, this.f11959p.t(), this.f11959p.f());
        matrix.mapRect(this.f12020z6);
        if (this.f11966w.jz() && this.f12018ta.size() > 1 && i != 255) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            this.f12016ej.setAlpha(i);
            br.s.tl(canvas, this.f12020z6, this.f12016ej);
        } else {
            canvas.save();
        }
        if (z2) {
            i = 255;
        }
        for (int size = this.f12018ta.size() - 1; size >= 0; size--) {
            if ((this.f12019ud || !"__container".equals(this.f11959p.c5())) && !this.f12020z6.isEmpty()) {
                clipRect = canvas.clipRect(this.f12020z6);
            } else {
                clipRect = true;
            }
            if (clipRect) {
                this.f12018ta.get(size).fb(canvas, matrix, i);
            }
        }
        canvas.restore();
        yk.zn.n3("CompositionLayer#draw");
    }
}
