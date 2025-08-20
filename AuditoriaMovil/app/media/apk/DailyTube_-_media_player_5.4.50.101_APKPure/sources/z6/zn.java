package z6;

import android.graphics.Path;
import android.util.Log;
import androidx.annotation.Nullable;
import com.uv.v7.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class zn {

    /* loaded from: classes.dex */
    public static class y {

        /* renamed from: n3  reason: collision with root package name */
        public boolean f15672n3;
        public int y;
    }

    public static n3[] a(n3[] n3VarArr) {
        if (n3VarArr == null) {
            return null;
        }
        n3[] n3VarArr2 = new n3[n3VarArr.length];
        for (int i = 0; i < n3VarArr.length; i++) {
            n3VarArr2[i] = new n3(n3VarArr[i]);
        }
        return n3VarArr2;
    }

    public static int c5(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                return i;
            }
            i++;
        }
        return i;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0039 A[LOOP:0: B:3:0x0007->B:24:0x0039, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void fb(java.lang.String r8, int r9, z6.zn.y r10) {
        /*
            r0 = 0
            r10.f15672n3 = r0
            r1 = r9
            r2 = 0
            r3 = 0
            r4 = 0
        L7:
            int r5 = r8.length()
            if (r1 >= r5) goto L3c
            char r5 = r8.charAt(r1)
            r6 = 32
            r7 = 1
            if (r5 == r6) goto L29
            r6 = 69
            if (r5 == r6) goto L35
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L35
            switch(r5) {
                case 44: goto L29;
                case 45: goto L2c;
                case 46: goto L22;
                default: goto L21;
            }
        L21:
            goto L33
        L22:
            if (r3 != 0) goto L27
            r2 = 0
            r3 = 1
            goto L36
        L27:
            r10.f15672n3 = r7
        L29:
            r2 = 0
            r4 = 1
            goto L36
        L2c:
            if (r1 == r9) goto L33
            if (r2 != 0) goto L33
            r10.f15672n3 = r7
            goto L29
        L33:
            r2 = 0
            goto L36
        L35:
            r2 = 1
        L36:
            if (r4 == 0) goto L39
            goto L3c
        L39:
            int r1 = r1 + 1
            goto L7
        L3c:
            r10.y = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: z6.zn.fb(java.lang.String, int, z6.zn$y):void");
    }

    public static n3[] gv(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i5 = 0;
        while (i < str.length()) {
            int c52 = c5(str, i);
            String trim = str.substring(i5, c52).trim();
            if (trim.length() > 0) {
                y(arrayList, trim.charAt(0), s(trim));
            }
            i5 = c52;
            i = c52 + 1;
        }
        if (i - i5 == 1 && i5 < str.length()) {
            y(arrayList, str.charAt(i5), new float[0]);
        }
        return (n3[]) arrayList.toArray(new n3[arrayList.size()]);
    }

    public static void i9(n3[] n3VarArr, n3[] n3VarArr2) {
        for (int i = 0; i < n3VarArr2.length; i++) {
            n3VarArr[i].y = n3VarArr2[i].y;
            int i5 = 0;
            while (true) {
                float[] fArr = n3VarArr2[i].f15671n3;
                if (i5 < fArr.length) {
                    n3VarArr[i].f15671n3[i5] = fArr[i5];
                    i5++;
                }
            }
        }
    }

    public static boolean n3(@Nullable n3[] n3VarArr, @Nullable n3[] n3VarArr2) {
        if (n3VarArr == null || n3VarArr2 == null || n3VarArr.length != n3VarArr2.length) {
            return false;
        }
        for (int i = 0; i < n3VarArr.length; i++) {
            n3 n3Var = n3VarArr[i];
            char c2 = n3Var.y;
            n3 n3Var2 = n3VarArr2[i];
            if (c2 != n3Var2.y || n3Var.f15671n3.length != n3Var2.f15671n3.length) {
                return false;
            }
        }
        return true;
    }

    public static float[] s(String str) {
        if (str.charAt(0) != 'z' && str.charAt(0) != 'Z') {
            try {
                float[] fArr = new float[str.length()];
                y yVar = new y();
                int length = str.length();
                int i = 1;
                int i5 = 0;
                while (i < length) {
                    fb(str, i, yVar);
                    int i6 = yVar.y;
                    if (i < i6) {
                        fArr[i5] = Float.parseFloat(str.substring(i, i6));
                        i5++;
                    }
                    if (yVar.f15672n3) {
                        i = i6;
                    } else {
                        i = i6 + 1;
                    }
                }
                return zn(fArr, 0, i5);
            } catch (NumberFormatException e2) {
                throw new RuntimeException("error in parsing \"" + str + "\"", e2);
            }
        }
        return new float[0];
    }

    public static Path v(String str) {
        Path path = new Path();
        n3[] gv2 = gv(str);
        if (gv2 != null) {
            try {
                n3.v(gv2, path);
                return path;
            } catch (RuntimeException e2) {
                throw new RuntimeException("Error in parsing " + str, e2);
            }
        }
        return null;
    }

    public static void y(ArrayList<n3> arrayList, char c2, float[] fArr) {
        arrayList.add(new n3(c2, fArr));
    }

    public static float[] zn(float[] fArr, int i, int i5) {
        if (i <= i5) {
            int length = fArr.length;
            if (i >= 0 && i <= length) {
                int i6 = i5 - i;
                int min = Math.min(i6, length - i);
                float[] fArr2 = new float[i6];
                System.arraycopy(fArr, i, fArr2, 0, min);
                return fArr2;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        throw new IllegalArgumentException();
    }

    /* loaded from: classes.dex */
    public static class n3 {

        /* renamed from: n3  reason: collision with root package name */
        public float[] f15671n3;
        public char y;

        public n3(char c2, float[] fArr) {
            this.y = c2;
            this.f15671n3 = fArr;
        }

        public static void n3(Path path, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d10, double d11) {
            double d12 = d4;
            int ceil = (int) Math.ceil(Math.abs((d11 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d8);
            double sin = Math.sin(d8);
            double cos2 = Math.cos(d10);
            double sin2 = Math.sin(d10);
            double d13 = -d12;
            double d14 = d13 * cos;
            double d15 = d5 * sin;
            double d16 = (d14 * sin2) - (d15 * cos2);
            double d17 = d13 * sin;
            double d18 = d5 * cos;
            double d19 = (sin2 * d17) + (cos2 * d18);
            double d20 = d11 / ceil;
            double d21 = d10;
            double d22 = d19;
            double d23 = d16;
            int i = 0;
            double d24 = d6;
            double d25 = d7;
            while (i < ceil) {
                double d26 = d21 + d20;
                double sin3 = Math.sin(d26);
                double cos3 = Math.cos(d26);
                double d27 = (d2 + ((d12 * cos) * cos3)) - (d15 * sin3);
                double d28 = d3 + (d12 * sin * cos3) + (d18 * sin3);
                double d29 = (d14 * sin3) - (d15 * cos3);
                double d30 = (sin3 * d17) + (cos3 * d18);
                double d31 = d26 - d21;
                double tan = Math.tan(d31 / 2.0d);
                double sin4 = (Math.sin(d31) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                double d32 = d24 + (d23 * sin4);
                double d33 = cos;
                double d34 = sin;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) d32, (float) (d25 + (d22 * sin4)), (float) (d27 - (sin4 * d29)), (float) (d28 - (sin4 * d30)), (float) d27, (float) d28);
                i++;
                d20 = d20;
                sin = d34;
                d24 = d27;
                d17 = d17;
                cos = d33;
                d21 = d26;
                d22 = d30;
                d23 = d29;
                ceil = ceil;
                d25 = d28;
                d12 = d4;
            }
        }

        public static void v(n3[] n3VarArr, Path path) {
            float[] fArr = new float[6];
            char c2 = 'm';
            for (int i = 0; i < n3VarArr.length; i++) {
                n3 n3Var = n3VarArr[i];
                y(path, fArr, c2, n3Var.y, n3Var.f15671n3);
                c2 = n3VarArr[i].y;
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public static void y(Path path, float[] fArr, char c2, char c4, float[] fArr2) {
            int i;
            int i5;
            float f4;
            float f6;
            float f9;
            float f10;
            float f11;
            float f12;
            float f13;
            float f14;
            char c6 = c4;
            float f15 = fArr[0];
            float f16 = fArr[1];
            float f17 = fArr[2];
            float f18 = fArr[3];
            float f19 = fArr[4];
            float f20 = fArr[5];
            switch (c6) {
                case 'A':
                case 'a':
                    i = 7;
                    break;
                case 'C':
                case 'c':
                    i = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                default:
                    i = 2;
                    break;
                case 'Q':
                case 'S':
                case R.styleable.AppCompatTheme_toolbarStyle /* 113 */:
                case R.styleable.AppCompatTheme_tooltipFrameBackground /* 115 */:
                    i = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f19, f20);
                    f15 = f19;
                    f17 = f15;
                    f16 = f20;
                    f18 = f16;
                    i = 2;
                    break;
            }
            float f21 = f15;
            float f22 = f16;
            float f23 = f19;
            float f24 = f20;
            int i6 = 0;
            char c7 = c2;
            while (i6 < fArr2.length) {
                if (c6 != 'A') {
                    if (c6 == 'C') {
                        i5 = i6;
                        int i8 = i5 + 2;
                        int i10 = i5 + 3;
                        int i11 = i5 + 4;
                        int i12 = i5 + 5;
                        path.cubicTo(fArr2[i5], fArr2[i5 + 1], fArr2[i8], fArr2[i10], fArr2[i11], fArr2[i12]);
                        f21 = fArr2[i11];
                        float f25 = fArr2[i12];
                        float f26 = fArr2[i8];
                        float f27 = fArr2[i10];
                        f22 = f25;
                        f18 = f27;
                        f17 = f26;
                    } else if (c6 == 'H') {
                        i5 = i6;
                        path.lineTo(fArr2[i5], f22);
                        f21 = fArr2[i5];
                    } else if (c6 == 'Q') {
                        i5 = i6;
                        int i13 = i5 + 1;
                        int i14 = i5 + 2;
                        int i15 = i5 + 3;
                        path.quadTo(fArr2[i5], fArr2[i13], fArr2[i14], fArr2[i15]);
                        float f28 = fArr2[i5];
                        float f29 = fArr2[i13];
                        f21 = fArr2[i14];
                        f22 = fArr2[i15];
                        f17 = f28;
                        f18 = f29;
                    } else if (c6 == 'V') {
                        i5 = i6;
                        path.lineTo(f21, fArr2[i5]);
                        f22 = fArr2[i5];
                    } else if (c6 != 'a') {
                        if (c6 != 'c') {
                            if (c6 == 'h') {
                                path.rLineTo(fArr2[i6], 0.0f);
                                f21 += fArr2[i6];
                            } else if (c6 != 'q') {
                                if (c6 == 'v') {
                                    path.rLineTo(0.0f, fArr2[i6]);
                                    f10 = fArr2[i6];
                                } else if (c6 == 'L') {
                                    int i16 = i6 + 1;
                                    path.lineTo(fArr2[i6], fArr2[i16]);
                                    f21 = fArr2[i6];
                                    f22 = fArr2[i16];
                                } else if (c6 == 'M') {
                                    f21 = fArr2[i6];
                                    f22 = fArr2[i6 + 1];
                                    if (i6 > 0) {
                                        path.lineTo(f21, f22);
                                    } else {
                                        path.moveTo(f21, f22);
                                        i5 = i6;
                                        f24 = f22;
                                        f23 = f21;
                                    }
                                } else if (c6 == 'S') {
                                    if (c7 == 'c' || c7 == 's' || c7 == 'C' || c7 == 'S') {
                                        f21 = (f21 * 2.0f) - f17;
                                        f22 = (f22 * 2.0f) - f18;
                                    }
                                    float f30 = f22;
                                    float f31 = f21;
                                    int i17 = i6 + 1;
                                    int i18 = i6 + 2;
                                    int i19 = i6 + 3;
                                    path.cubicTo(f31, f30, fArr2[i6], fArr2[i17], fArr2[i18], fArr2[i19]);
                                    f4 = fArr2[i6];
                                    f6 = fArr2[i17];
                                    f21 = fArr2[i18];
                                    f22 = fArr2[i19];
                                    f17 = f4;
                                    f18 = f6;
                                } else if (c6 == 'T') {
                                    if (c7 == 'q' || c7 == 't' || c7 == 'Q' || c7 == 'T') {
                                        f21 = (f21 * 2.0f) - f17;
                                        f22 = (f22 * 2.0f) - f18;
                                    }
                                    int i20 = i6 + 1;
                                    path.quadTo(f21, f22, fArr2[i6], fArr2[i20]);
                                    i5 = i6;
                                    f18 = f22;
                                    f17 = f21;
                                    f21 = fArr2[i6];
                                    f22 = fArr2[i20];
                                } else if (c6 == 'l') {
                                    int i21 = i6 + 1;
                                    path.rLineTo(fArr2[i6], fArr2[i21]);
                                    f21 += fArr2[i6];
                                    f10 = fArr2[i21];
                                } else if (c6 == 'm') {
                                    float f32 = fArr2[i6];
                                    f21 += f32;
                                    float f33 = fArr2[i6 + 1];
                                    f22 += f33;
                                    if (i6 > 0) {
                                        path.rLineTo(f32, f33);
                                    } else {
                                        path.rMoveTo(f32, f33);
                                        i5 = i6;
                                        f24 = f22;
                                        f23 = f21;
                                    }
                                } else if (c6 == 's') {
                                    if (c7 == 'c' || c7 == 's' || c7 == 'C' || c7 == 'S') {
                                        float f34 = f21 - f17;
                                        f11 = f22 - f18;
                                        f12 = f34;
                                    } else {
                                        f12 = 0.0f;
                                        f11 = 0.0f;
                                    }
                                    int i22 = i6 + 1;
                                    int i23 = i6 + 2;
                                    int i24 = i6 + 3;
                                    path.rCubicTo(f12, f11, fArr2[i6], fArr2[i22], fArr2[i23], fArr2[i24]);
                                    f4 = fArr2[i6] + f21;
                                    f6 = fArr2[i22] + f22;
                                    f21 += fArr2[i23];
                                    f9 = fArr2[i24];
                                } else if (c6 == 't') {
                                    if (c7 == 'q' || c7 == 't' || c7 == 'Q' || c7 == 'T') {
                                        f13 = f21 - f17;
                                        f14 = f22 - f18;
                                    } else {
                                        f14 = 0.0f;
                                        f13 = 0.0f;
                                    }
                                    int i25 = i6 + 1;
                                    path.rQuadTo(f13, f14, fArr2[i6], fArr2[i25]);
                                    float f35 = f13 + f21;
                                    float f36 = f14 + f22;
                                    f21 += fArr2[i6];
                                    f22 += fArr2[i25];
                                    f18 = f36;
                                    f17 = f35;
                                }
                                f22 += f10;
                            } else {
                                int i26 = i6 + 1;
                                int i27 = i6 + 2;
                                int i28 = i6 + 3;
                                path.rQuadTo(fArr2[i6], fArr2[i26], fArr2[i27], fArr2[i28]);
                                f4 = fArr2[i6] + f21;
                                f6 = fArr2[i26] + f22;
                                f21 += fArr2[i27];
                                f9 = fArr2[i28];
                            }
                            i5 = i6;
                        } else {
                            int i29 = i6 + 2;
                            int i30 = i6 + 3;
                            int i31 = i6 + 4;
                            int i32 = i6 + 5;
                            path.rCubicTo(fArr2[i6], fArr2[i6 + 1], fArr2[i29], fArr2[i30], fArr2[i31], fArr2[i32]);
                            f4 = fArr2[i29] + f21;
                            f6 = fArr2[i30] + f22;
                            f21 += fArr2[i31];
                            f9 = fArr2[i32];
                        }
                        f22 += f9;
                        f17 = f4;
                        f18 = f6;
                        i5 = i6;
                    } else {
                        int i33 = i6 + 5;
                        int i34 = i6 + 6;
                        i5 = i6;
                        zn(path, f21, f22, fArr2[i33] + f21, fArr2[i34] + f22, fArr2[i6], fArr2[i6 + 1], fArr2[i6 + 2], fArr2[i6 + 3] != 0.0f, fArr2[i6 + 4] != 0.0f);
                        f21 += fArr2[i33];
                        f22 += fArr2[i34];
                    }
                    i6 = i5 + i;
                    c7 = c4;
                    c6 = c7;
                } else {
                    i5 = i6;
                    int i35 = i5 + 5;
                    int i36 = i5 + 6;
                    zn(path, f21, f22, fArr2[i35], fArr2[i36], fArr2[i5], fArr2[i5 + 1], fArr2[i5 + 2], fArr2[i5 + 3] != 0.0f, fArr2[i5 + 4] != 0.0f);
                    f21 = fArr2[i35];
                    f22 = fArr2[i36];
                }
                f18 = f22;
                f17 = f21;
                i6 = i5 + i;
                c7 = c4;
                c6 = c7;
            }
            fArr[0] = f21;
            fArr[1] = f22;
            fArr[2] = f17;
            fArr[3] = f18;
            fArr[4] = f23;
            fArr[5] = f24;
        }

        public static void zn(Path path, float f4, float f6, float f9, float f10, float f11, float f12, float f13, boolean z2, boolean z3) {
            double d2;
            double d3;
            boolean z4;
            double radians = Math.toRadians(f13);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d4 = f4;
            double d5 = d4 * cos;
            double d6 = f6;
            double d7 = f11;
            double d8 = (d5 + (d6 * sin)) / d7;
            double d10 = f12;
            double d11 = (((-f4) * sin) + (d6 * cos)) / d10;
            double d12 = f10;
            double d13 = ((f9 * cos) + (d12 * sin)) / d7;
            double d14 = (((-f9) * sin) + (d12 * cos)) / d10;
            double d15 = d8 - d13;
            double d16 = d11 - d14;
            double d17 = (d8 + d13) / 2.0d;
            double d18 = (d11 + d14) / 2.0d;
            double d19 = (d15 * d15) + (d16 * d16);
            if (d19 == 0.0d) {
                Log.w("PathParser", " Points are coincident");
                return;
            }
            double d20 = (1.0d / d19) - 0.25d;
            if (d20 < 0.0d) {
                Log.w("PathParser", "Points are too far apart " + d19);
                float sqrt = (float) (Math.sqrt(d19) / 1.99999d);
                zn(path, f4, f6, f9, f10, f11 * sqrt, f12 * sqrt, f13, z2, z3);
                return;
            }
            double sqrt2 = Math.sqrt(d20);
            double d21 = d15 * sqrt2;
            double d22 = sqrt2 * d16;
            if (z2 == z3) {
                d2 = d17 - d22;
                d3 = d18 + d21;
            } else {
                d2 = d17 + d22;
                d3 = d18 - d21;
            }
            double atan2 = Math.atan2(d11 - d3, d8 - d2);
            double atan22 = Math.atan2(d14 - d3, d13 - d2) - atan2;
            int i = (atan22 > 0.0d ? 1 : (atan22 == 0.0d ? 0 : -1));
            if (i >= 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z3 != z4) {
                if (i > 0) {
                    atan22 -= 6.283185307179586d;
                } else {
                    atan22 += 6.283185307179586d;
                }
            }
            double d23 = d2 * d7;
            double d24 = d3 * d10;
            n3(path, (d23 * cos) - (d24 * sin), (d23 * sin) + (d24 * cos), d7, d10, d4, d6, radians, atan2, atan22);
        }

        public void gv(n3 n3Var, n3 n3Var2, float f4) {
            this.y = n3Var.y;
            int i = 0;
            while (true) {
                float[] fArr = n3Var.f15671n3;
                if (i < fArr.length) {
                    this.f15671n3[i] = (fArr[i] * (1.0f - f4)) + (n3Var2.f15671n3[i] * f4);
                    i++;
                } else {
                    return;
                }
            }
        }

        public n3(n3 n3Var) {
            this.y = n3Var.y;
            float[] fArr = n3Var.f15671n3;
            this.f15671n3 = zn.zn(fArr, 0, fArr.length);
        }
    }
}
