package wz;
/* loaded from: classes.dex */
public class ud {

    /* renamed from: a  reason: collision with root package name */
    public int f14815a;

    /* renamed from: fb  reason: collision with root package name */
    public boolean f14816fb;

    /* renamed from: n3  reason: collision with root package name */
    public int f14818n3;

    /* renamed from: s  reason: collision with root package name */
    public boolean f14819s;

    /* renamed from: v  reason: collision with root package name */
    public int f14820v;
    public int y;

    /* renamed from: zn  reason: collision with root package name */
    public int f14821zn = Integer.MIN_VALUE;

    /* renamed from: gv  reason: collision with root package name */
    public int f14817gv = Integer.MIN_VALUE;

    public void a(boolean z2) {
        if (z2 == this.f14816fb) {
            return;
        }
        this.f14816fb = z2;
        if (this.f14819s) {
            if (z2) {
                int i = this.f14817gv;
                if (i == Integer.MIN_VALUE) {
                    i = this.f14820v;
                }
                this.y = i;
                int i5 = this.f14821zn;
                if (i5 == Integer.MIN_VALUE) {
                    i5 = this.f14815a;
                }
                this.f14818n3 = i5;
                return;
            }
            int i6 = this.f14821zn;
            if (i6 == Integer.MIN_VALUE) {
                i6 = this.f14820v;
            }
            this.y = i6;
            int i8 = this.f14817gv;
            if (i8 == Integer.MIN_VALUE) {
                i8 = this.f14815a;
            }
            this.f14818n3 = i8;
            return;
        }
        this.y = this.f14820v;
        this.f14818n3 = this.f14815a;
    }

    public void fb(int i, int i5) {
        this.f14821zn = i;
        this.f14817gv = i5;
        this.f14819s = true;
        if (this.f14816fb) {
            if (i5 != Integer.MIN_VALUE) {
                this.y = i5;
            }
            if (i != Integer.MIN_VALUE) {
                this.f14818n3 = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.y = i;
        }
        if (i5 != Integer.MIN_VALUE) {
            this.f14818n3 = i5;
        }
    }

    public int gv() {
        if (this.f14816fb) {
            return this.f14818n3;
        }
        return this.y;
    }

    public int n3() {
        return this.y;
    }

    public void v(int i, int i5) {
        this.f14819s = false;
        if (i != Integer.MIN_VALUE) {
            this.f14820v = i;
            this.y = i;
        }
        if (i5 != Integer.MIN_VALUE) {
            this.f14815a = i5;
            this.f14818n3 = i5;
        }
    }

    public int y() {
        if (this.f14816fb) {
            return this.y;
        }
        return this.f14818n3;
    }

    public int zn() {
        return this.f14818n3;
    }
}
