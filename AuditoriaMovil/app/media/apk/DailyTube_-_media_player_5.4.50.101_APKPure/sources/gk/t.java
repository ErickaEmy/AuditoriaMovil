package gk;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import gk.gv;
import gk.tl;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import v5.j5;
import v5.w;
/* loaded from: classes.dex */
public final class t extends GLSurfaceView {

    /* renamed from: n  reason: collision with root package name */
    public static final /* synthetic */ int f8309n = 0;
    @Nullable

    /* renamed from: co  reason: collision with root package name */
    public Surface f8310co;

    /* renamed from: f  reason: collision with root package name */
    public final Handler f8311f;

    /* renamed from: f3  reason: collision with root package name */
    public boolean f8312f3;
    @Nullable

    /* renamed from: fb  reason: collision with root package name */
    public final Sensor f8313fb;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    public SurfaceTexture f8314p;

    /* renamed from: r  reason: collision with root package name */
    public boolean f8315r;

    /* renamed from: s  reason: collision with root package name */
    public final gv f8316s;

    /* renamed from: t  reason: collision with root package name */
    public final tl f8317t;

    /* renamed from: v  reason: collision with root package name */
    public final SensorManager f8318v;

    /* renamed from: w  reason: collision with root package name */
    public final c5 f8319w;
    public final CopyOnWriteArrayList<n3> y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f8320z;

    /* loaded from: classes.dex */
    public interface n3 {
        void p(Surface surface);

        void w(Surface surface);
    }

    /* loaded from: classes.dex */
    public final class y implements GLSurfaceView.Renderer, tl.y, gv.y {

        /* renamed from: f  reason: collision with root package name */
        public final float[] f8322f;

        /* renamed from: p  reason: collision with root package name */
        public float f8324p;

        /* renamed from: s  reason: collision with root package name */
        public final float[] f8326s;

        /* renamed from: t  reason: collision with root package name */
        public final float[] f8327t;

        /* renamed from: w  reason: collision with root package name */
        public float f8329w;
        public final c5 y;

        /* renamed from: v  reason: collision with root package name */
        public final float[] f8328v = new float[16];

        /* renamed from: fb  reason: collision with root package name */
        public final float[] f8323fb = new float[16];

        /* renamed from: co  reason: collision with root package name */
        public final float[] f8321co = new float[16];

        /* renamed from: z  reason: collision with root package name */
        public final float[] f8330z = new float[16];

        public y(c5 c5Var) {
            float[] fArr = new float[16];
            this.f8326s = fArr;
            float[] fArr2 = new float[16];
            this.f8322f = fArr2;
            float[] fArr3 = new float[16];
            this.f8327t = fArr3;
            this.y = c5Var;
            w.i9(fArr);
            w.i9(fArr2);
            w.i9(fArr3);
            this.f8324p = 3.1415927f;
        }

        public final void gv() {
            Matrix.setRotateM(this.f8322f, 0, -this.f8329w, (float) Math.cos(this.f8324p), (float) Math.sin(this.f8324p), 0.0f);
        }

        @Override // gk.tl.y
        public synchronized void n3(PointF pointF) {
            this.f8329w = pointF.y;
            gv();
            Matrix.setRotateM(this.f8327t, 0, -pointF.x, 0.0f, 1.0f, 0.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            synchronized (this) {
                Matrix.multiplyMM(this.f8330z, 0, this.f8326s, 0, this.f8327t, 0);
                Matrix.multiplyMM(this.f8321co, 0, this.f8322f, 0, this.f8330z, 0);
            }
            Matrix.multiplyMM(this.f8323fb, 0, this.f8328v, 0, this.f8321co, 0);
            this.y.gv(this.f8323fb, false);
        }

        @Override // gk.tl.y
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return t.this.performClick();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i5) {
            GLES20.glViewport(0, 0, i, i5);
            float f4 = i / i5;
            Matrix.perspectiveM(this.f8328v, 0, zn(f4), f4, 0.1f, 100.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            t.this.fb(this.y.a());
        }

        @Override // gk.gv.y
        public synchronized void y(float[] fArr, float f4) {
            float[] fArr2 = this.f8326s;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            this.f8324p = -f4;
            gv();
        }

        public final float zn(float f4) {
            if (f4 > 1.0f) {
                return (float) (Math.toDegrees(Math.atan(Math.tan(Math.toRadians(45.0d)) / f4)) * 2.0d);
            }
            return 90.0f;
        }
    }

    public t(Context context) {
        this(context, null);
    }

    public static void s(@Nullable SurfaceTexture surfaceTexture, @Nullable Surface surface) {
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        if (surface != null) {
            surface.release();
        }
    }

    public final /* synthetic */ void a(SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2 = this.f8314p;
        Surface surface = this.f8310co;
        Surface surface2 = new Surface(surfaceTexture);
        this.f8314p = surfaceTexture;
        this.f8310co = surface2;
        Iterator<n3> it = this.y.iterator();
        while (it.hasNext()) {
            it.next().p(surface2);
        }
        s(surfaceTexture2, surface);
    }

    public void c5(n3 n3Var) {
        this.y.remove(n3Var);
    }

    public final void fb(final SurfaceTexture surfaceTexture) {
        this.f8311f.post(new Runnable() { // from class: gk.i9
            @Override // java.lang.Runnable
            public final void run() {
                t.this.a(surfaceTexture);
            }
        });
    }

    public gk.y getCameraMotionListener() {
        return this.f8319w;
    }

    public wn.f getVideoFrameMetadataListener() {
        return this.f8319w;
    }

    @Nullable
    public Surface getVideoSurface() {
        return this.f8310co;
    }

    public void gv(n3 n3Var) {
        this.y.add(n3Var);
    }

    public final void i9() {
        boolean z2;
        if (this.f8320z && this.f8315r) {
            z2 = true;
        } else {
            z2 = false;
        }
        Sensor sensor = this.f8313fb;
        if (sensor != null && z2 != this.f8312f3) {
            if (z2) {
                this.f8318v.registerListener(this.f8316s, sensor, 0);
            } else {
                this.f8318v.unregisterListener(this.f8316s);
            }
            this.f8312f3 = z2;
        }
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f8311f.post(new Runnable() { // from class: gk.f
            @Override // java.lang.Runnable
            public final void run() {
                t.this.v();
            }
        });
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        this.f8315r = false;
        i9();
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        this.f8315r = true;
        i9();
    }

    public void setDefaultStereoMode(int i) {
        this.f8319w.s(i);
    }

    public void setUseSensorRotation(boolean z2) {
        this.f8320z = z2;
        i9();
    }

    public final /* synthetic */ void v() {
        Surface surface = this.f8310co;
        if (surface != null) {
            Iterator<n3> it = this.y.iterator();
            while (it.hasNext()) {
                it.next().w(surface);
            }
        }
        s(this.f8314p, surface);
        this.f8314p = null;
        this.f8310co = null;
    }

    public t(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.y = new CopyOnWriteArrayList<>();
        this.f8311f = new Handler(Looper.getMainLooper());
        SensorManager sensorManager = (SensorManager) v5.y.v(context.getSystemService("sensor"));
        this.f8318v = sensorManager;
        Sensor defaultSensor = j5.y >= 18 ? sensorManager.getDefaultSensor(15) : null;
        this.f8313fb = defaultSensor == null ? sensorManager.getDefaultSensor(11) : defaultSensor;
        c5 c5Var = new c5();
        this.f8319w = c5Var;
        y yVar = new y(c5Var);
        tl tlVar = new tl(context, yVar, 25.0f);
        this.f8317t = tlVar;
        this.f8316s = new gv(((WindowManager) v5.y.v((WindowManager) context.getSystemService("window"))).getDefaultDisplay(), tlVar, yVar);
        this.f8320z = true;
        setEGLContextClientVersion(2);
        setRenderer(yVar);
        setOnTouchListener(tlVar);
    }
}
