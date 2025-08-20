package wn;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.Nullable;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import v5.w;
/* loaded from: classes.dex */
public final class c5 extends GLSurfaceView implements i9 {
    public final y y;

    /* loaded from: classes.dex */
    public static final class y implements GLSurfaceView.Renderer {

        /* renamed from: co  reason: collision with root package name */
        public int f14564co;

        /* renamed from: p  reason: collision with root package name */
        public v5.xc f14567p;
        public final GLSurfaceView y;

        /* renamed from: z  reason: collision with root package name */
        public a9.f f14572z;

        /* renamed from: r  reason: collision with root package name */
        public static final float[] f14563r = {1.164f, 1.164f, 1.164f, 0.0f, -0.392f, 2.017f, 1.596f, -0.813f, 0.0f};

        /* renamed from: f3  reason: collision with root package name */
        public static final float[] f14561f3 = {1.164f, 1.164f, 1.164f, 0.0f, -0.213f, 2.112f, 1.793f, -0.533f, 0.0f};

        /* renamed from: n  reason: collision with root package name */
        public static final float[] f14562n = {1.168f, 1.168f, 1.168f, 0.0f, -0.188f, 2.148f, 1.683f, -0.652f, 0.0f};

        /* renamed from: c  reason: collision with root package name */
        public static final String[] f14559c = {"y_tex", "u_tex", "v_tex"};

        /* renamed from: d0  reason: collision with root package name */
        public static final FloatBuffer f14560d0 = v5.w.v(new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f});

        /* renamed from: v  reason: collision with root package name */
        public final int[] f14570v = new int[3];

        /* renamed from: fb  reason: collision with root package name */
        public final int[] f14566fb = new int[3];

        /* renamed from: s  reason: collision with root package name */
        public final int[] f14568s = new int[3];

        /* renamed from: f  reason: collision with root package name */
        public final int[] f14565f = new int[3];

        /* renamed from: t  reason: collision with root package name */
        public final AtomicReference<a9.f> f14569t = new AtomicReference<>();

        /* renamed from: w  reason: collision with root package name */
        public final FloatBuffer[] f14571w = new FloatBuffer[3];

        public y(GLSurfaceView gLSurfaceView) {
            this.y = gLSurfaceView;
            for (int i = 0; i < 3; i++) {
                int[] iArr = this.f14568s;
                this.f14565f[i] = -1;
                iArr[i] = -1;
            }
        }

        public final void n3() {
            try {
                GLES20.glGenTextures(3, this.f14570v, 0);
                for (int i = 0; i < 3; i++) {
                    GLES20.glUniform1i(this.f14567p.i9(f14559c[i]), i);
                    GLES20.glActiveTexture(33984 + i);
                    v5.w.y(3553, this.f14570v[i]);
                }
                v5.w.n3();
            } catch (w.y e2) {
                Log.e("VideoDecoderGLSV", "Failed to set up the textures", e2);
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            boolean z2;
            a9.f andSet = this.f14569t.getAndSet(null);
            if (andSet == null && this.f14572z == null) {
                return;
            }
            if (andSet != null) {
                a9.f fVar = this.f14572z;
                if (fVar != null) {
                    fVar.p();
                }
                this.f14572z = andSet;
            }
            a9.f fVar2 = (a9.f) v5.y.v(this.f14572z);
            float[] fArr = f14561f3;
            int i = fVar2.f51p;
            if (i != 1) {
                if (i == 3) {
                    fArr = f14562n;
                }
            } else {
                fArr = f14563r;
            }
            GLES20.glUniformMatrix3fv(this.f14564co, 1, false, fArr, 0);
            int[] iArr = (int[]) v5.y.v(fVar2.f54w);
            ByteBuffer[] byteBufferArr = (ByteBuffer[]) v5.y.v(fVar2.f53t);
            for (int i5 = 0; i5 < 3; i5++) {
                int i6 = fVar2.f50f;
                if (i5 != 0) {
                    i6 = (i6 + 1) / 2;
                }
                int i8 = i6;
                GLES20.glActiveTexture(33984 + i5);
                GLES20.glBindTexture(3553, this.f14570v[i5]);
                GLES20.glPixelStorei(3317, 1);
                GLES20.glTexImage2D(3553, 0, 6409, iArr[i5], i8, 0, 6409, 5121, byteBufferArr[i5]);
            }
            int i10 = fVar2.f52s;
            int i11 = (i10 + 1) / 2;
            int[] iArr2 = {i10, i11, i11};
            for (int i12 = 0; i12 < 3; i12++) {
                if (this.f14568s[i12] != iArr2[i12] || this.f14565f[i12] != iArr[i12]) {
                    if (iArr[i12] != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    v5.y.fb(z2);
                    float f4 = iArr2[i12] / iArr[i12];
                    this.f14571w[i12] = v5.w.v(new float[]{0.0f, 0.0f, 0.0f, 1.0f, f4, 0.0f, f4, 1.0f});
                    GLES20.glVertexAttribPointer(this.f14566fb[i12], 2, 5126, false, 0, (Buffer) this.f14571w[i12]);
                    this.f14568s[i12] = iArr2[i12];
                    this.f14565f[i12] = iArr[i12];
                }
            }
            GLES20.glClear(16384);
            GLES20.glDrawArrays(5, 0, 4);
            try {
                v5.w.n3();
            } catch (w.y e2) {
                Log.e("VideoDecoderGLSV", "Failed to draw a frame", e2);
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i5) {
            GLES20.glViewport(0, 0, i, i5);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            try {
                v5.xc xcVar = new v5.xc("varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n", "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n");
                this.f14567p = xcVar;
                GLES20.glVertexAttribPointer(xcVar.v("in_pos"), 2, 5126, false, 0, (Buffer) f14560d0);
                this.f14566fb[0] = this.f14567p.v("in_tc_y");
                this.f14566fb[1] = this.f14567p.v("in_tc_u");
                this.f14566fb[2] = this.f14567p.v("in_tc_v");
                this.f14564co = this.f14567p.i9("mColorConversion");
                v5.w.n3();
                n3();
                v5.w.n3();
            } catch (w.y e2) {
                Log.e("VideoDecoderGLSV", "Failed to set up the textures and program", e2);
            }
        }

        public void y(a9.f fVar) {
            a9.f andSet = this.f14569t.getAndSet(fVar);
            if (andSet != null) {
                andSet.p();
            }
            this.y.requestRender();
        }
    }

    public c5(Context context) {
        this(context, null);
    }

    public void setOutputBuffer(a9.f fVar) {
        this.y.y(fVar);
    }

    public c5(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        y yVar = new y(this);
        this.y = yVar;
        setPreserveEGLContextOnPause(true);
        setEGLContextClientVersion(2);
        setRenderer(yVar);
        setRenderMode(0);
    }

    @Deprecated
    public i9 getVideoDecoderOutputBufferRenderer() {
        return this;
    }
}
