package f7;

import f7.n3;
/* loaded from: classes.dex */
public final class v {

    /* renamed from: a  reason: collision with root package name */
    public double f7887a;

    /* renamed from: c5  reason: collision with root package name */
    public double f7888c5;

    /* renamed from: fb  reason: collision with root package name */
    public double f7889fb;

    /* renamed from: gv  reason: collision with root package name */
    public double f7890gv;

    /* renamed from: i9  reason: collision with root package name */
    public final n3.xc f7891i9;

    /* renamed from: n3  reason: collision with root package name */
    public double f7892n3;

    /* renamed from: s  reason: collision with root package name */
    public double f7893s;

    /* renamed from: v  reason: collision with root package name */
    public double f7894v;
    public double y;

    /* renamed from: zn  reason: collision with root package name */
    public boolean f7895zn;

    public v() {
        this.y = Math.sqrt(1500.0d);
        this.f7892n3 = 0.5d;
        this.f7895zn = false;
        this.f7888c5 = Double.MAX_VALUE;
        this.f7891i9 = new n3.xc();
    }

    public v a(float f4) {
        if (f4 > 0.0f) {
            this.y = Math.sqrt(f4);
            this.f7895zn = false;
            return this;
        }
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }

    public void fb(double d2) {
        double abs = Math.abs(d2);
        this.f7890gv = abs;
        this.f7894v = abs * 62.5d;
    }

    public v gv(float f4) {
        if (f4 >= 0.0f) {
            this.f7892n3 = f4;
            this.f7895zn = false;
            return this;
        }
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    }

    public final void n3() {
        if (this.f7895zn) {
            return;
        }
        if (this.f7888c5 != Double.MAX_VALUE) {
            double d2 = this.f7892n3;
            if (d2 > 1.0d) {
                double d3 = this.y;
                this.f7887a = ((-d2) * d3) + (d3 * Math.sqrt((d2 * d2) - 1.0d));
                double d4 = this.f7892n3;
                double d5 = this.y;
                this.f7889fb = ((-d4) * d5) - (d5 * Math.sqrt((d4 * d4) - 1.0d));
            } else if (d2 >= 0.0d && d2 < 1.0d) {
                this.f7893s = this.y * Math.sqrt(1.0d - (d2 * d2));
            }
            this.f7895zn = true;
            return;
        }
        throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
    }

    public n3.xc s(double d2, double d3, long j2) {
        double cos;
        double d4;
        n3();
        double d5 = j2 / 1000.0d;
        double d6 = d2 - this.f7888c5;
        double d7 = this.f7892n3;
        if (d7 > 1.0d) {
            double d8 = this.f7889fb;
            double d10 = this.f7887a;
            double d11 = d6 - (((d8 * d6) - d3) / (d8 - d10));
            double d12 = ((d6 * d8) - d3) / (d8 - d10);
            d4 = (Math.pow(2.718281828459045d, d8 * d5) * d11) + (Math.pow(2.718281828459045d, this.f7887a * d5) * d12);
            double d13 = this.f7889fb;
            double pow = d11 * d13 * Math.pow(2.718281828459045d, d13 * d5);
            double d14 = this.f7887a;
            cos = pow + (d12 * d14 * Math.pow(2.718281828459045d, d14 * d5));
        } else if (d7 == 1.0d) {
            double d15 = this.y;
            double d16 = d3 + (d15 * d6);
            double d17 = d6 + (d16 * d5);
            d4 = Math.pow(2.718281828459045d, (-d15) * d5) * d17;
            double pow2 = d17 * Math.pow(2.718281828459045d, (-this.y) * d5);
            double d18 = this.y;
            cos = (d16 * Math.pow(2.718281828459045d, (-d18) * d5)) + (pow2 * (-d18));
        } else {
            double d19 = 1.0d / this.f7893s;
            double d20 = this.y;
            double d21 = d19 * ((d7 * d20 * d6) + d3);
            double pow3 = Math.pow(2.718281828459045d, (-d7) * d20 * d5) * ((Math.cos(this.f7893s * d5) * d6) + (Math.sin(this.f7893s * d5) * d21));
            double d22 = this.y;
            double d23 = this.f7892n3;
            double d24 = (-d22) * pow3 * d23;
            double pow4 = Math.pow(2.718281828459045d, (-d23) * d22 * d5);
            double d25 = this.f7893s;
            double sin = (-d25) * d6 * Math.sin(d25 * d5);
            double d26 = this.f7893s;
            cos = d24 + (pow4 * (sin + (d21 * d26 * Math.cos(d26 * d5))));
            d4 = pow3;
        }
        n3.xc xcVar = this.f7891i9;
        xcVar.y = (float) (d4 + this.f7888c5);
        xcVar.f7886n3 = (float) cos;
        return xcVar;
    }

    public v v(float f4) {
        this.f7888c5 = f4;
        return this;
    }

    public float y() {
        return (float) this.f7888c5;
    }

    public boolean zn(float f4, float f6) {
        if (Math.abs(f6) < this.f7894v && Math.abs(f4 - y()) < this.f7890gv) {
            return true;
        }
        return false;
    }

    public v(float f4) {
        this.y = Math.sqrt(1500.0d);
        this.f7892n3 = 0.5d;
        this.f7895zn = false;
        this.f7888c5 = Double.MAX_VALUE;
        this.f7891i9 = new n3.xc();
        this.f7888c5 = f4;
    }
}
