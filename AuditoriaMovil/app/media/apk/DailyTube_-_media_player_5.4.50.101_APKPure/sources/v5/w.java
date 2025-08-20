package v5;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
/* loaded from: classes.dex */
public final class w {
    public static final int[] y = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344};

    /* renamed from: n3  reason: collision with root package name */
    public static final int[] f14400n3 = {12352, 4, 12324, 10, 12323, 10, 12322, 10, 12321, 2, 12325, 0, 12326, 0, 12344};

    /* renamed from: zn  reason: collision with root package name */
    public static final int[] f14401zn = {12344};

    /* loaded from: classes.dex */
    public static final class y extends Exception {
        public y(String str) {
            super(str);
        }
    }

    public static int a() throws y {
        int fb2 = fb();
        y(36197, fb2);
        return fb2;
    }

    public static boolean c5() {
        String eglQueryString;
        if (j5.y < 17 || (eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) == null || !eglQueryString.contains("EGL_KHR_surfaceless_context")) {
            return false;
        }
        return true;
    }

    public static int fb() throws y {
        zn(!j5.zn(EGL14.eglGetCurrentContext(), EGL14.EGL_NO_CONTEXT), "No current context");
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        n3();
        return iArr[0];
    }

    public static FloatBuffer gv(int i) {
        return ByteBuffer.allocateDirect(i * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }

    public static void i9(float[] fArr) {
        Matrix.setIdentityM(fArr, 0);
    }

    public static void n3() throws y {
        StringBuilder sb = new StringBuilder();
        boolean z2 = false;
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError == 0) {
                break;
            }
            if (z2) {
                sb.append('\n');
            }
            sb.append("glError: ");
            sb.append(GLU.gluErrorString(glGetError));
            z2 = true;
        }
        if (!z2) {
            return;
        }
        throw new y(sb.toString());
    }

    public static boolean s(Context context) {
        String eglQueryString;
        int i = j5.y;
        if (i < 24) {
            return false;
        }
        if (i < 26 && ("samsung".equals(j5.f14370zn) || "XT1650".equals(j5.f14361gv))) {
            return false;
        }
        if ((i < 26 && !context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) || (eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) == null || !eglQueryString.contains("EGL_EXT_protected_content")) {
            return false;
        }
        return true;
    }

    public static FloatBuffer v(float[] fArr) {
        return (FloatBuffer) gv(fArr.length).put(fArr).flip();
    }

    public static void y(int i, int i5) throws y {
        GLES20.glBindTexture(i, i5);
        n3();
        GLES20.glTexParameteri(i, 10240, 9729);
        n3();
        GLES20.glTexParameteri(i, 10241, 9729);
        n3();
        GLES20.glTexParameteri(i, 10242, 33071);
        n3();
        GLES20.glTexParameteri(i, 10243, 33071);
        n3();
    }

    public static void zn(boolean z2, String str) throws y {
        if (z2) {
            return;
        }
        throw new y(str);
    }
}
