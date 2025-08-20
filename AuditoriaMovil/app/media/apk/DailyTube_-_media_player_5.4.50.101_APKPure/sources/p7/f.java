package p7;

import androidx.annotation.Nullable;
import java.io.IOException;
import kx.j5;
import kx.p;
import m1.m;
import p7.fb;
/* loaded from: classes.dex */
public class f extends y {

    /* renamed from: co  reason: collision with root package name */
    public volatile boolean f12475co;

    /* renamed from: mt  reason: collision with root package name */
    public long f12476mt;

    /* renamed from: p  reason: collision with root package name */
    public final fb f12477p;

    /* renamed from: w  reason: collision with root package name */
    public final long f12478w;

    /* renamed from: xc  reason: collision with root package name */
    public final int f12479xc;

    /* renamed from: z  reason: collision with root package name */
    public boolean f12480z;

    public f(kx.tl tlVar, p pVar, m mVar, int i, @Nullable Object obj, long j2, long j4, long j6, long j7, long j8, int i5, long j9, fb fbVar) {
        super(tlVar, pVar, mVar, i, obj, j2, j4, j6, j7, j8);
        this.f12479xc = i5;
        this.f12478w = j9;
        this.f12477p = fbVar;
    }

    @Override // p7.wz
    public long a() {
        return this.f12511i9 + this.f12479xc;
    }

    @Override // p7.wz
    public boolean fb() {
        return this.f12480z;
    }

    @Override // kx.ta.v
    public final void load() throws IOException {
        long j2;
        long j4;
        if (this.f12476mt == 0) {
            zn c52 = c5();
            c52.n3(this.f12478w);
            fb fbVar = this.f12477p;
            fb.n3 f4 = f(c52);
            long j6 = this.f12512f;
            if (j6 == -9223372036854775807L) {
                j2 = -9223372036854775807L;
            } else {
                j2 = j6 - this.f12478w;
            }
            long j7 = this.f12513t;
            if (j7 == -9223372036854775807L) {
                j4 = -9223372036854775807L;
            } else {
                j4 = j7 - this.f12478w;
            }
            fbVar.y(f4, j2, j4);
        }
        try {
            p v2 = this.f12445n3.v(this.f12476mt);
            j5 j5Var = this.f12442c5;
            e4.a aVar = new e4.a(j5Var, v2.f10071fb, j5Var.y(v2));
            while (!this.f12475co && this.f12477p.n3(aVar)) {
            }
            this.f12476mt = aVar.getPosition() - this.f12445n3.f10071fb;
            kx.w.y(this.f12442c5);
            this.f12480z = !this.f12475co;
        } catch (Throwable th) {
            kx.w.y(this.f12442c5);
            throw th;
        }
    }

    @Override // kx.ta.v
    public final void n3() {
        this.f12475co = true;
    }

    public fb.n3 f(zn znVar) {
        return znVar;
    }
}
