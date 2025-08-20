package gk;

import android.opengl.GLES20;
import android.util.Log;
import androidx.annotation.Nullable;
import gk.v;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import v5.w;
import v5.xc;
/* loaded from: classes.dex */
public final class fb {

    /* renamed from: a  reason: collision with root package name */
    public int f8286a;

    /* renamed from: c5  reason: collision with root package name */
    public int f8287c5;

    /* renamed from: fb  reason: collision with root package name */
    public int f8288fb;

    /* renamed from: gv  reason: collision with root package name */
    public xc f8289gv;
    @Nullable

    /* renamed from: n3  reason: collision with root package name */
    public y f8290n3;

    /* renamed from: s  reason: collision with root package name */
    public int f8291s;

    /* renamed from: v  reason: collision with root package name */
    public int f8292v;
    public int y;
    @Nullable

    /* renamed from: zn  reason: collision with root package name */
    public y f8293zn;

    /* renamed from: i9  reason: collision with root package name */
    public static final float[] f8282i9 = {1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: f  reason: collision with root package name */
    public static final float[] f8281f = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: t  reason: collision with root package name */
    public static final float[] f8283t = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: tl  reason: collision with root package name */
    public static final float[] f8284tl = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: wz  reason: collision with root package name */
    public static final float[] f8285wz = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.5f, 1.0f, 1.0f};

    /* loaded from: classes.dex */
    public static class y {

        /* renamed from: gv  reason: collision with root package name */
        public final int f8294gv;

        /* renamed from: n3  reason: collision with root package name */
        public final FloatBuffer f8295n3;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final FloatBuffer f8296zn;

        public y(v.n3 n3Var) {
            this.y = n3Var.y();
            this.f8295n3 = w.v(n3Var.f8341zn);
            this.f8296zn = w.v(n3Var.f8339gv);
            int i = n3Var.f8340n3;
            if (i != 1) {
                if (i != 2) {
                    this.f8294gv = 4;
                    return;
                } else {
                    this.f8294gv = 6;
                    return;
                }
            }
            this.f8294gv = 5;
        }
    }

    public static boolean zn(v vVar) {
        v.y yVar = vVar.y;
        v.y yVar2 = vVar.f8337n3;
        if (yVar.n3() != 1 || yVar.y(0).y != 0 || yVar2.n3() != 1 || yVar2.y(0).y != 0) {
            return false;
        }
        return true;
    }

    public void gv(v vVar) {
        if (!zn(vVar)) {
            return;
        }
        this.y = vVar.f8338zn;
        y yVar = new y(vVar.y.y(0));
        this.f8290n3 = yVar;
        if (!vVar.f8336gv) {
            yVar = new y(vVar.f8337n3.y(0));
        }
        this.f8293zn = yVar;
    }

    public void n3() {
        try {
            xc xcVar = new xc("uniform mat4 uMvpMatrix;\nuniform mat3 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec2 aTexCoords;\nvarying vec2 vTexCoords;\n// Standard transformation.\nvoid main() {\n  gl_Position = uMvpMatrix * aPosition;\n  vTexCoords = (uTexMatrix * vec3(aTexCoords, 1)).xy;\n}\n", "// This is required since the texture data is GL_TEXTURE_EXTERNAL_OES.\n#extension GL_OES_EGL_image_external : require\nprecision mediump float;\n// Standard texture rendering shader.\nuniform samplerExternalOES uTexture;\nvarying vec2 vTexCoords;\nvoid main() {\n  gl_FragColor = texture2D(uTexture, vTexCoords);\n}\n");
            this.f8289gv = xcVar;
            this.f8292v = xcVar.i9("uMvpMatrix");
            this.f8286a = this.f8289gv.i9("uTexMatrix");
            this.f8288fb = this.f8289gv.v("aPosition");
            this.f8291s = this.f8289gv.v("aTexCoords");
            this.f8287c5 = this.f8289gv.i9("uTexture");
        } catch (w.y e2) {
            Log.e("ProjectionRenderer", "Failed to initialize the program", e2);
        }
    }

    public void y(int i, float[] fArr, boolean z2) {
        y yVar;
        float[] fArr2;
        if (z2) {
            yVar = this.f8293zn;
        } else {
            yVar = this.f8290n3;
        }
        if (yVar == null) {
            return;
        }
        int i5 = this.y;
        if (i5 == 1) {
            if (z2) {
                fArr2 = f8283t;
            } else {
                fArr2 = f8281f;
            }
        } else if (i5 == 2) {
            if (z2) {
                fArr2 = f8285wz;
            } else {
                fArr2 = f8284tl;
            }
        } else {
            fArr2 = f8282i9;
        }
        GLES20.glUniformMatrix3fv(this.f8286a, 1, false, fArr2, 0);
        GLES20.glUniformMatrix4fv(this.f8292v, 1, false, fArr, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i);
        GLES20.glUniform1i(this.f8287c5, 0);
        try {
            w.n3();
        } catch (w.y e2) {
            Log.e("ProjectionRenderer", "Failed to bind uniforms", e2);
        }
        GLES20.glVertexAttribPointer(this.f8288fb, 3, 5126, false, 12, (Buffer) yVar.f8295n3);
        try {
            w.n3();
        } catch (w.y e3) {
            Log.e("ProjectionRenderer", "Failed to load position data", e3);
        }
        GLES20.glVertexAttribPointer(this.f8291s, 2, 5126, false, 8, (Buffer) yVar.f8296zn);
        try {
            w.n3();
        } catch (w.y e5) {
            Log.e("ProjectionRenderer", "Failed to load texture data", e5);
        }
        GLES20.glDrawArrays(yVar.f8294gv, 0, yVar.y);
        try {
            w.n3();
        } catch (w.y e6) {
            Log.e("ProjectionRenderer", "Failed to render", e6);
        }
    }
}
