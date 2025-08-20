package q;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import vn.w;
import wm.zn;
import yk.mg;
import yk.s;
/* loaded from: classes.dex */
public class t implements zn {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final n3 f12693a;
    @Nullable

    /* renamed from: c5  reason: collision with root package name */
    public final n3 f12694c5;
    @Nullable

    /* renamed from: fb  reason: collision with root package name */
    public final n3 f12695fb;
    @Nullable

    /* renamed from: gv  reason: collision with root package name */
    public final n3 f12696gv;
    @Nullable

    /* renamed from: n3  reason: collision with root package name */
    public final tl<PointF, PointF> f12697n3;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    public final n3 f12698s;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public final gv f12699v;
    @Nullable
    public final v y;
    @Nullable

    /* renamed from: zn  reason: collision with root package name */
    public final fb f12700zn;

    public t() {
        this(null, null, null, null, null, null, null, null, null);
    }

    @Nullable
    public tl<PointF, PointF> a() {
        return this.f12697n3;
    }

    @Nullable
    public n3 c5() {
        return this.f12693a;
    }

    @Nullable
    public n3 f() {
        return this.f12698s;
    }

    @Nullable
    public n3 fb() {
        return this.f12696gv;
    }

    @Nullable
    public n3 gv() {
        return this.f12694c5;
    }

    @Nullable
    public n3 i9() {
        return this.f12695fb;
    }

    public w n3() {
        return new w(this);
    }

    @Nullable
    public fb s() {
        return this.f12700zn;
    }

    @Nullable
    public gv v() {
        return this.f12699v;
    }

    @Override // wm.zn
    @Nullable
    public i3.zn y(mg mgVar, s sVar, nd.n3 n3Var) {
        return null;
    }

    @Nullable
    public v zn() {
        return this.y;
    }

    public t(@Nullable v vVar, @Nullable tl<PointF, PointF> tlVar, @Nullable fb fbVar, @Nullable n3 n3Var, @Nullable gv gvVar, @Nullable n3 n3Var2, @Nullable n3 n3Var3, @Nullable n3 n3Var4, @Nullable n3 n3Var5) {
        this.y = vVar;
        this.f12697n3 = tlVar;
        this.f12700zn = fbVar;
        this.f12696gv = n3Var;
        this.f12699v = gvVar;
        this.f12698s = n3Var2;
        this.f12694c5 = n3Var3;
        this.f12693a = n3Var4;
        this.f12695fb = n3Var5;
    }
}
