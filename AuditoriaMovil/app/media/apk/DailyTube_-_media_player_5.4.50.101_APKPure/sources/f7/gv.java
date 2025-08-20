package f7;

import f7.n3;
/* loaded from: classes.dex */
public final class gv extends n3<gv> {

    /* renamed from: d0  reason: collision with root package name */
    public v f7858d0;

    /* renamed from: fh  reason: collision with root package name */
    public float f7859fh;

    /* renamed from: rz  reason: collision with root package name */
    public boolean f7860rz;

    public <K> gv(K k2, zn<K> znVar) {
        super(k2, znVar);
        this.f7859fh = Float.MAX_VALUE;
    }

    @Override // f7.n3
    public void i9() {
        xc();
        this.f7858d0.fb(v());
        super.i9();
    }

    @Override // f7.n3
    public boolean t(long j2) {
        if (this.f7860rz) {
            float f4 = this.f7859fh;
            if (f4 != Float.MAX_VALUE) {
                this.f7858d0.v(f4);
                this.f7859fh = Float.MAX_VALUE;
            }
            this.f7881n3 = this.f7858d0.y();
            this.y = 0.0f;
            this.f7860rz = false;
            return true;
        }
        if (this.f7859fh != Float.MAX_VALUE) {
            this.f7858d0.y();
            long j4 = j2 / 2;
            n3.xc s2 = this.f7858d0.s(this.f7881n3, this.y, j4);
            this.f7858d0.v(this.f7859fh);
            this.f7859fh = Float.MAX_VALUE;
            n3.xc s3 = this.f7858d0.s(s2.y, s2.f7886n3, j4);
            this.f7881n3 = s3.y;
            this.y = s3.f7886n3;
        } else {
            n3.xc s4 = this.f7858d0.s(this.f7881n3, this.y, j2);
            this.f7881n3 = s4.y;
            this.y = s4.f7886n3;
        }
        float max = Math.max(this.f7881n3, this.f7882s);
        this.f7881n3 = max;
        float min = Math.min(max, this.f7878fb);
        this.f7881n3 = min;
        if (!wz(min, this.y)) {
            return false;
        }
        this.f7881n3 = this.f7858d0.y();
        this.y = 0.0f;
        return true;
    }

    public void tl(float f4) {
        if (a()) {
            this.f7859fh = f4;
            return;
        }
        if (this.f7858d0 == null) {
            this.f7858d0 = new v(f4);
        }
        this.f7858d0.v(f4);
        i9();
    }

    public gv w(v vVar) {
        this.f7858d0 = vVar;
        return this;
    }

    public boolean wz(float f4, float f6) {
        return this.f7858d0.zn(f4, f6);
    }

    public final void xc() {
        v vVar = this.f7858d0;
        if (vVar != null) {
            double y = vVar.y();
            if (y <= this.f7878fb) {
                if (y >= this.f7882s) {
                    return;
                }
                throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
            }
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
    }
}
