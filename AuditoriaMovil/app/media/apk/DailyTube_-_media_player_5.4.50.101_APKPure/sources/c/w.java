package c;

import n.gv;
import n.v;
/* loaded from: classes.dex */
public abstract class w implements gv {

    /* renamed from: gv  reason: collision with root package name */
    public v.n3 f3943gv;

    /* renamed from: n3  reason: collision with root package name */
    public n.v f3945n3;
    public int y;

    /* renamed from: zn  reason: collision with root package name */
    public tl f3948zn;

    /* renamed from: v  reason: collision with root package name */
    public fb f3947v = new fb(this);

    /* renamed from: a  reason: collision with root package name */
    public int f3940a = 0;

    /* renamed from: fb  reason: collision with root package name */
    public boolean f3942fb = false;

    /* renamed from: s  reason: collision with root package name */
    public a f3946s = new a(this);

    /* renamed from: c5  reason: collision with root package name */
    public a f3941c5 = new a(this);

    /* renamed from: i9  reason: collision with root package name */
    public n3 f3944i9 = n3.NONE;

    /* loaded from: classes.dex */
    public enum n3 {
        NONE,
        START,
        END,
        CENTER
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class y {
        public static final /* synthetic */ int[] y;

        static {
            int[] iArr = new int[gv.n3.values().length];
            y = iArr;
            try {
                iArr[gv.n3.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                y[gv.n3.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                y[gv.n3.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                y[gv.n3.BASELINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                y[gv.n3.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public w(n.v vVar) {
        this.f3945n3 = vVar;
    }

    public abstract void a();

    public final a c5(n.gv gvVar, int i) {
        w wVar;
        n.gv gvVar2 = gvVar.f11667a;
        if (gvVar2 == null) {
            return null;
        }
        n.v vVar = gvVar2.f11670gv;
        if (i == 0) {
            wVar = vVar.f11749v;
        } else {
            wVar = vVar.f11686a;
        }
        int i5 = y.y[gvVar2.f11673v.ordinal()];
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 != 3) {
                    if (i5 != 5) {
                        return null;
                    }
                }
            }
            return wVar.f3941c5;
        }
        return wVar.f3946s;
    }

    public boolean f() {
        return this.f3942fb;
    }

    public final int fb(int i, int i5) {
        int max;
        if (i5 == 0) {
            n.v vVar = this.f3945n3;
            int i6 = vVar.f11762z;
            max = Math.max(vVar.f11693co, i);
            if (i6 > 0) {
                max = Math.min(i6, i);
            }
            if (max == i) {
                return i;
            }
        } else {
            n.v vVar2 = this.f3945n3;
            int i8 = vVar2.f11711i4;
            max = Math.max(vVar2.f11754x4, i);
            if (i8 > 0) {
                max = Math.min(i8, i);
            }
            if (max == i) {
                return i;
            }
        }
        return max;
    }

    public abstract void gv();

    public long i9() {
        fb fbVar = this.f3947v;
        if (fbVar.f3896i9) {
            return fbVar.f3894fb;
        }
        return 0L;
    }

    public final void n3(a aVar, a aVar2, int i) {
        aVar.f3899t.add(aVar2);
        aVar.f3891a = i;
        aVar2.f3893f.add(aVar);
    }

    public final a s(n.gv gvVar) {
        n.gv gvVar2 = gvVar.f11667a;
        if (gvVar2 == null) {
            return null;
        }
        n.v vVar = gvVar2.f11670gv;
        int i = y.y[gvVar2.f11673v.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            return null;
                        }
                        return vVar.f11686a.f3941c5;
                    }
                    return vVar.f11686a.f3953f;
                }
                return vVar.f11686a.f3946s;
            }
            return vVar.f11749v.f3941c5;
        }
        return vVar.f11749v.f3946s;
    }

    public final void t(int i, int i5) {
        w wVar;
        float f4;
        int i6;
        int i8 = this.y;
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 == 3) {
                        n.v vVar = this.f3945n3;
                        w wVar2 = vVar.f11749v;
                        v.n3 n3Var = wVar2.f3943gv;
                        v.n3 n3Var2 = v.n3.MATCH_CONSTRAINT;
                        if (n3Var == n3Var2 && wVar2.y == 3) {
                            wz wzVar = vVar.f11686a;
                            if (wzVar.f3943gv == n3Var2 && wzVar.y == 3) {
                                return;
                            }
                        }
                        if (i == 0) {
                            wVar2 = vVar.f11686a;
                        }
                        if (wVar2.f3947v.f3896i9) {
                            float z2 = vVar.z();
                            if (i == 1) {
                                i6 = (int) ((wVar2.f3947v.f3894fb / z2) + 0.5f);
                            } else {
                                i6 = (int) ((z2 * wVar2.f3947v.f3894fb) + 0.5f);
                            }
                            this.f3947v.gv(i6);
                            return;
                        }
                        return;
                    }
                    return;
                }
                n.v ud2 = this.f3945n3.ud();
                if (ud2 != null) {
                    if (i == 0) {
                        wVar = ud2.f11749v;
                    } else {
                        wVar = ud2.f11686a;
                    }
                    fb fbVar = wVar.f3947v;
                    if (fbVar.f3896i9) {
                        n.v vVar2 = this.f3945n3;
                        if (i == 0) {
                            f4 = vVar2.f11734r;
                        } else {
                            f4 = vVar2.f11703f3;
                        }
                        this.f3947v.gv(fb((int) ((fbVar.f3894fb * f4) + 0.5f), i));
                        return;
                    }
                    return;
                }
                return;
            }
            this.f3947v.gv(Math.min(fb(this.f3947v.f3910tl, i), i5));
            return;
        }
        this.f3947v.gv(fb(i5, i));
    }

    public abstract boolean tl();

    public abstract void v();

    public void wz(gv gvVar, n.gv gvVar2, n.gv gvVar3, int i) {
        float k52;
        a s2 = s(gvVar2);
        a s3 = s(gvVar3);
        if (s2.f3896i9 && s3.f3896i9) {
            int v2 = s2.f3894fb + gvVar2.v();
            int v3 = s3.f3894fb - gvVar3.v();
            int i5 = v3 - v2;
            if (!this.f3947v.f3896i9 && this.f3943gv == v.n3.MATCH_CONSTRAINT) {
                t(i, i5);
            }
            fb fbVar = this.f3947v;
            if (!fbVar.f3896i9) {
                return;
            }
            if (fbVar.f3894fb == i5) {
                this.f3946s.gv(v2);
                this.f3941c5.gv(v3);
                return;
            }
            n.v vVar = this.f3945n3;
            if (i == 0) {
                k52 = vVar.i4();
            } else {
                k52 = vVar.k5();
            }
            if (s2 == s3) {
                v2 = s2.f3894fb;
                v3 = s3.f3894fb;
                k52 = 0.5f;
            }
            this.f3946s.gv((int) (v2 + 0.5f + (((v3 - v2) - this.f3947v.f3894fb) * k52)));
            this.f3941c5.gv(this.f3946s.f3894fb + this.f3947v.f3894fb);
        }
    }

    public final void zn(a aVar, a aVar2, int i, fb fbVar) {
        aVar.f3899t.add(aVar2);
        aVar.f3899t.add(this.f3947v);
        aVar.f3898s = i;
        aVar.f3892c5 = fbVar;
        aVar2.f3893f.add(aVar);
        fbVar.f3893f.add(aVar);
    }

    public void w(gv gvVar) {
    }

    public void xc(gv gvVar) {
    }

    @Override // c.gv
    public void y(gv gvVar) {
    }
}
