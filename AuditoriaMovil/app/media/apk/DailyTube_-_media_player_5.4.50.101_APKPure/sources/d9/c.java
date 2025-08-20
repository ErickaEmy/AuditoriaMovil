package d9;

import d9.fb;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes.dex */
public abstract class c implements fb {

    /* renamed from: a  reason: collision with root package name */
    public ByteBuffer f6980a;

    /* renamed from: fb  reason: collision with root package name */
    public ByteBuffer f6981fb;

    /* renamed from: gv  reason: collision with root package name */
    public fb.y f6982gv;

    /* renamed from: n3  reason: collision with root package name */
    public fb.y f6983n3;

    /* renamed from: s  reason: collision with root package name */
    public boolean f6984s;

    /* renamed from: v  reason: collision with root package name */
    public fb.y f6985v;

    /* renamed from: zn  reason: collision with root package name */
    public fb.y f6986zn;

    public c() {
        ByteBuffer byteBuffer = fb.y;
        this.f6980a = byteBuffer;
        this.f6981fb = byteBuffer;
        fb.y yVar = fb.y.f7036v;
        this.f6982gv = yVar;
        this.f6985v = yVar;
        this.f6983n3 = yVar;
        this.f6986zn = yVar;
    }

    @Override // d9.fb
    public boolean a() {
        if (this.f6984s && this.f6981fb == fb.y) {
            return true;
        }
        return false;
    }

    @Override // d9.fb
    public ByteBuffer fb() {
        ByteBuffer byteBuffer = this.f6981fb;
        this.f6981fb = fb.y;
        return byteBuffer;
    }

    @Override // d9.fb
    public final void flush() {
        this.f6981fb = fb.y;
        this.f6984s = false;
        this.f6983n3 = this.f6982gv;
        this.f6986zn = this.f6985v;
        gv();
    }

    @Override // d9.fb
    public final void i9() {
        this.f6984s = true;
        v();
    }

    @Override // d9.fb
    public boolean isActive() {
        if (this.f6985v != fb.y.f7036v) {
            return true;
        }
        return false;
    }

    public final boolean n3() {
        return this.f6981fb.hasRemaining();
    }

    @Override // d9.fb
    public final fb.y s(fb.y yVar) throws fb.n3 {
        this.f6982gv = yVar;
        this.f6985v = zn(yVar);
        if (isActive()) {
            return this.f6985v;
        }
        return fb.y.f7036v;
    }

    public final ByteBuffer t(int i) {
        if (this.f6980a.capacity() < i) {
            this.f6980a = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.f6980a.clear();
        }
        ByteBuffer byteBuffer = this.f6980a;
        this.f6981fb = byteBuffer;
        return byteBuffer;
    }

    @Override // d9.fb
    public final void y() {
        flush();
        this.f6980a = fb.y;
        fb.y yVar = fb.y.f7036v;
        this.f6982gv = yVar;
        this.f6985v = yVar;
        this.f6983n3 = yVar;
        this.f6986zn = yVar;
        f();
    }

    public fb.y zn(fb.y yVar) throws fb.n3 {
        return fb.y.f7036v;
    }

    public void f() {
    }

    public void gv() {
    }

    public void v() {
    }
}
