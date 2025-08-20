package p7;

import androidx.annotation.Nullable;
import e4.ta;
import java.io.IOException;
import kx.p;
import m1.m;
/* loaded from: classes.dex */
public final class w extends y {

    /* renamed from: mt  reason: collision with root package name */
    public boolean f12507mt;

    /* renamed from: p  reason: collision with root package name */
    public long f12508p;

    /* renamed from: w  reason: collision with root package name */
    public final m f12509w;

    /* renamed from: xc  reason: collision with root package name */
    public final int f12510xc;

    public w(kx.tl tlVar, p pVar, m mVar, int i, @Nullable Object obj, long j2, long j4, long j6, int i5, m mVar2) {
        super(tlVar, pVar, mVar, i, obj, j2, j4, -9223372036854775807L, -9223372036854775807L, j6);
        this.f12510xc = i5;
        this.f12509w = mVar2;
    }

    @Override // p7.wz
    public boolean fb() {
        return this.f12507mt;
    }

    @Override // kx.ta.v
    public void load() throws IOException {
        zn c52 = c5();
        c52.n3(0L);
        ta a2 = c52.a(0, this.f12510xc);
        a2.v(this.f12509w);
        try {
            long y = this.f12442c5.y(this.f12445n3.v(this.f12508p));
            if (y != -1) {
                y += this.f12508p;
            }
            e4.a aVar = new e4.a(this.f12442c5, this.f12508p, y);
            for (int i = 0; i != -1; i = a2.n3(aVar, Integer.MAX_VALUE, true)) {
                this.f12508p += i;
            }
            a2.gv(this.f12443fb, 1, (int) this.f12508p, 0, null);
            kx.w.y(this.f12442c5);
            this.f12507mt = true;
        } catch (Throwable th) {
            kx.w.y(this.f12442c5);
            throw th;
        }
    }

    @Override // kx.ta.v
    public void n3() {
    }
}
