package p7;

import androidx.annotation.Nullable;
import java.io.IOException;
import kx.j5;
import kx.p;
import m1.m;
import p7.fb;
/* loaded from: classes.dex */
public final class tl extends a {

    /* renamed from: f  reason: collision with root package name */
    public fb.n3 f12487f;

    /* renamed from: i9  reason: collision with root package name */
    public final fb f12488i9;

    /* renamed from: t  reason: collision with root package name */
    public long f12489t;

    /* renamed from: tl  reason: collision with root package name */
    public volatile boolean f12490tl;

    public tl(kx.tl tlVar, p pVar, m mVar, int i, @Nullable Object obj, fb fbVar) {
        super(tlVar, pVar, 2, mVar, i, obj, -9223372036854775807L, -9223372036854775807L);
        this.f12488i9 = fbVar;
    }

    public void a(fb.n3 n3Var) {
        this.f12487f = n3Var;
    }

    @Override // kx.ta.v
    public void load() throws IOException {
        if (this.f12489t == 0) {
            this.f12488i9.y(this.f12487f, -9223372036854775807L, -9223372036854775807L);
        }
        try {
            p v2 = this.f12445n3.v(this.f12489t);
            j5 j5Var = this.f12442c5;
            e4.a aVar = new e4.a(j5Var, v2.f10071fb, j5Var.y(v2));
            while (!this.f12490tl && this.f12488i9.n3(aVar)) {
            }
            this.f12489t = aVar.getPosition() - this.f12445n3.f10071fb;
        } finally {
            kx.w.y(this.f12442c5);
        }
    }

    @Override // kx.ta.v
    public void n3() {
        this.f12490tl = true;
    }
}
