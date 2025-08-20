package vn;

import androidx.annotation.Nullable;
import java.util.Collections;
import uo.zn;
/* loaded from: classes.dex */
public class p<K, A> extends y<K, A> {

    /* renamed from: c5  reason: collision with root package name */
    public final A f14457c5;

    public p(zn<A> znVar) {
        this(znVar, null);
    }

    @Override // vn.y
    public A c5(uo.y<K> yVar, float f4) {
        return s();
    }

    @Override // vn.y
    public void f() {
        if (this.f14478v != null) {
            super.f();
        }
    }

    @Override // vn.y
    public A s() {
        zn<A> znVar = this.f14478v;
        A a2 = this.f14457c5;
        return znVar.n3(0.0f, 0.0f, a2, a2, a(), a(), a());
    }

    @Override // vn.y
    public void tl(float f4) {
        this.f14475gv = f4;
    }

    @Override // vn.y
    public float zn() {
        return 1.0f;
    }

    public p(zn<A> znVar, @Nullable A a2) {
        super(Collections.emptyList());
        wz(znVar);
        this.f14457c5 = a2;
    }
}
