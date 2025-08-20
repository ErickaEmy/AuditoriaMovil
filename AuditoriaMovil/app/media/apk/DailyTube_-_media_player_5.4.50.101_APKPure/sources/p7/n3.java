package p7;

import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public abstract class n3 implements xc {

    /* renamed from: gv  reason: collision with root package name */
    public long f12481gv;

    /* renamed from: n3  reason: collision with root package name */
    public final long f12482n3;

    /* renamed from: zn  reason: collision with root package name */
    public final long f12483zn;

    public n3(long j2, long j4) {
        this.f12482n3 = j2;
        this.f12483zn = j4;
        a();
    }

    public void a() {
        this.f12481gv = this.f12482n3 - 1;
    }

    public final long gv() {
        return this.f12481gv;
    }

    @Override // p7.xc
    public boolean next() {
        this.f12481gv++;
        return !v();
    }

    public boolean v() {
        if (this.f12481gv > this.f12483zn) {
            return true;
        }
        return false;
    }

    public final void zn() {
        long j2 = this.f12481gv;
        if (j2 >= this.f12482n3 && j2 <= this.f12483zn) {
            return;
        }
        throw new NoSuchElementException();
    }
}
