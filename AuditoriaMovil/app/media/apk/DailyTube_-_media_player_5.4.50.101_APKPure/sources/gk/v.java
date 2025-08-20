package gk;
/* loaded from: classes.dex */
public final class v {

    /* renamed from: gv  reason: collision with root package name */
    public final boolean f8336gv;

    /* renamed from: n3  reason: collision with root package name */
    public final y f8337n3;
    public final y y;

    /* renamed from: zn  reason: collision with root package name */
    public final int f8338zn;

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: gv  reason: collision with root package name */
        public final float[] f8339gv;

        /* renamed from: n3  reason: collision with root package name */
        public final int f8340n3;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final float[] f8341zn;

        public n3(int i, float[] fArr, float[] fArr2, int i5) {
            boolean z2;
            this.y = i;
            if (fArr.length * 2 == fArr2.length * 3) {
                z2 = true;
            } else {
                z2 = false;
            }
            v5.y.y(z2);
            this.f8341zn = fArr;
            this.f8339gv = fArr2;
            this.f8340n3 = i5;
        }

        public int y() {
            return this.f8341zn.length / 3;
        }
    }

    /* loaded from: classes.dex */
    public static final class y {
        public final n3[] y;

        public y(n3... n3VarArr) {
            this.y = n3VarArr;
        }

        public int n3() {
            return this.y.length;
        }

        public n3 y(int i) {
            return this.y[i];
        }
    }

    public v(y yVar, int i) {
        this(yVar, yVar, i);
    }

    public static v n3(int i) {
        return y(50.0f, 36, 72, 180.0f, 360.0f, i);
    }

    public static v y(float f4, int i, int i5, float f6, float f9, int i6) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z7;
        float f10;
        float f11;
        int i8;
        int i10;
        int i11 = i;
        if (f4 > 0.0f) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.y(z2);
        if (i11 >= 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        v5.y.y(z3);
        if (i5 >= 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        v5.y.y(z4);
        if (f6 > 0.0f && f6 <= 180.0f) {
            z5 = true;
        } else {
            z5 = false;
        }
        v5.y.y(z5);
        if (f9 > 0.0f && f9 <= 360.0f) {
            z7 = true;
        } else {
            z7 = false;
        }
        v5.y.y(z7);
        float radians = (float) Math.toRadians(f6);
        float radians2 = (float) Math.toRadians(f9);
        float f12 = radians / i11;
        float f13 = radians2 / i5;
        int i12 = i5 + 1;
        int i13 = ((i12 * 2) + 2) * i11;
        float[] fArr = new float[i13 * 3];
        float[] fArr2 = new float[i13 * 2];
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        while (i14 < i11) {
            float f14 = radians / 2.0f;
            float f15 = (i14 * f12) - f14;
            int i17 = i14 + 1;
            float f16 = (i17 * f12) - f14;
            int i18 = 0;
            while (i18 < i12) {
                int i19 = i17;
                float f17 = f15;
                int i20 = i16;
                int i21 = 0;
                while (i21 < 2) {
                    if (i21 == 0) {
                        f10 = f17;
                        f11 = f16;
                    } else {
                        f10 = f16;
                        f11 = f10;
                    }
                    float f18 = i18 * f13;
                    float f19 = f13;
                    float f20 = radians;
                    double d2 = f4;
                    int i22 = i12;
                    double d3 = (f18 + 3.1415927f) - (radians2 / 2.0f);
                    int i23 = i18;
                    double d4 = f10;
                    float f21 = radians2;
                    int i24 = i21;
                    fArr[i15] = -((float) (Math.sin(d3) * d2 * Math.cos(d4)));
                    float f22 = f12;
                    fArr[i15 + 1] = (float) (d2 * Math.sin(d4));
                    int i25 = i15 + 3;
                    fArr[i15 + 2] = (float) (d2 * Math.cos(d3) * Math.cos(d4));
                    fArr2[i20] = f18 / f21;
                    int i26 = i20 + 2;
                    fArr2[i20 + 1] = ((i14 + i24) * f22) / f20;
                    if (i23 != 0 || i24 != 0) {
                        i8 = i23;
                        i10 = i24;
                        if (i8 != i5 || i10 != 1) {
                            i20 = i26;
                            i15 = i25;
                            i18 = i8;
                            f12 = f22;
                            i21 = i10 + 1;
                            f16 = f11;
                            f13 = f19;
                            radians = f20;
                            i12 = i22;
                            radians2 = f21;
                        }
                    } else {
                        i10 = i24;
                        i8 = i23;
                    }
                    System.arraycopy(fArr, i15, fArr, i25, 3);
                    i15 += 6;
                    System.arraycopy(fArr2, i20, fArr2, i26, 2);
                    i20 += 4;
                    i18 = i8;
                    f12 = f22;
                    i21 = i10 + 1;
                    f16 = f11;
                    f13 = f19;
                    radians = f20;
                    i12 = i22;
                    radians2 = f21;
                }
                i17 = i19;
                f15 = f17;
                i16 = i20;
                i18++;
                f16 = f16;
                radians = radians;
                radians2 = radians2;
            }
            i11 = i;
            i14 = i17;
        }
        return new v(new y(new n3(0, fArr, fArr2, 1)), i6);
    }

    public v(y yVar, y yVar2, int i) {
        this.y = yVar;
        this.f8337n3 = yVar2;
        this.f8338zn = i;
        this.f8336gv = yVar == yVar2;
    }
}
