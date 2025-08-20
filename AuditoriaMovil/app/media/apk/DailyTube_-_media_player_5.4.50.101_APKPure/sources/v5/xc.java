package v5;

import android.opengl.GLES20;
import java.util.HashMap;
import java.util.Map;
import v5.w;
/* loaded from: classes.dex */
public final class xc {

    /* renamed from: gv  reason: collision with root package name */
    public final Map<String, y> f14406gv;

    /* renamed from: n3  reason: collision with root package name */
    public final y[] f14407n3;

    /* renamed from: v  reason: collision with root package name */
    public final Map<String, n3> f14408v;
    public final int y;

    /* renamed from: zn  reason: collision with root package name */
    public final n3[] f14409zn;

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: gv  reason: collision with root package name */
        public final float[] f14410gv = new float[16];

        /* renamed from: n3  reason: collision with root package name */
        public final int f14411n3;
        public final String y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f14412zn;

        public n3(String str, int i, int i5) {
            this.y = str;
            this.f14411n3 = i;
            this.f14412zn = i5;
        }

        public static n3 y(int i, int i5) {
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(i, 35719, iArr, 0);
            int[] iArr2 = new int[1];
            int i6 = iArr[0];
            byte[] bArr = new byte[i6];
            GLES20.glGetActiveUniform(i, i5, i6, new int[1], 0, new int[1], 0, iArr2, 0, bArr, 0);
            String str = new String(bArr, 0, xc.s(bArr));
            return new n3(str, xc.c5(i, str), iArr2[0]);
        }
    }

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: n3  reason: collision with root package name */
        public final int f14413n3;
        public final String y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f14414zn;

        public y(String str, int i, int i5) {
            this.y = str;
            this.f14413n3 = i;
            this.f14414zn = i5;
        }

        public static y y(int i, int i5) {
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(i, 35722, iArr, 0);
            int i6 = iArr[0];
            byte[] bArr = new byte[i6];
            GLES20.glGetActiveAttrib(i, i5, i6, new int[1], 0, new int[1], 0, new int[1], 0, bArr, 0);
            String str = new String(bArr, 0, xc.s(bArr));
            return new y(str, i5, xc.a(i, str));
        }
    }

    public xc(String str, String str2) throws w.y {
        boolean z2;
        int glCreateProgram = GLES20.glCreateProgram();
        this.y = glCreateProgram;
        w.n3();
        gv(glCreateProgram, 35633, str);
        gv(glCreateProgram, 35632, str2);
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = {0};
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        w.zn(z2, "Unable to link shader program: \n" + GLES20.glGetProgramInfoLog(glCreateProgram));
        GLES20.glUseProgram(glCreateProgram);
        this.f14406gv = new HashMap();
        int[] iArr2 = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35721, iArr2, 0);
        this.f14407n3 = new y[iArr2[0]];
        for (int i = 0; i < iArr2[0]; i++) {
            y y2 = y.y(this.y, i);
            this.f14407n3[i] = y2;
            this.f14406gv.put(y2.y, y2);
        }
        this.f14408v = new HashMap();
        int[] iArr3 = new int[1];
        GLES20.glGetProgramiv(this.y, 35718, iArr3, 0);
        this.f14409zn = new n3[iArr3[0]];
        for (int i5 = 0; i5 < iArr3[0]; i5++) {
            n3 y7 = n3.y(this.y, i5);
            this.f14409zn[i5] = y7;
            this.f14408v.put(y7.y, y7);
        }
        w.n3();
    }

    public static int a(int i, String str) {
        return GLES20.glGetAttribLocation(i, str);
    }

    public static int c5(int i, String str) {
        return GLES20.glGetUniformLocation(i, str);
    }

    public static void gv(int i, int i5, String str) throws w.y {
        int glCreateShader = GLES20.glCreateShader(i5);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        boolean z2 = false;
        int[] iArr = {0};
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 1) {
            z2 = true;
        }
        w.zn(z2, GLES20.glGetShaderInfoLog(glCreateShader) + ", source: " + str);
        GLES20.glAttachShader(i, glCreateShader);
        GLES20.glDeleteShader(glCreateShader);
        w.n3();
    }

    public static int s(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] == 0) {
                return i;
            }
        }
        return bArr.length;
    }

    public final int fb(String str) {
        return a(this.y, str);
    }

    public int i9(String str) {
        return c5(this.y, str);
    }

    public int v(String str) throws w.y {
        int fb2 = fb(str);
        GLES20.glEnableVertexAttribArray(fb2);
        w.n3();
        return fb2;
    }
}
