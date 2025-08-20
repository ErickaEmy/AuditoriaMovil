package gk;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.Display;
/* loaded from: classes.dex */
public final class gv implements SensorEventListener {

    /* renamed from: f  reason: collision with root package name */
    public final Display f8297f;

    /* renamed from: t  reason: collision with root package name */
    public final y[] f8300t;

    /* renamed from: w  reason: collision with root package name */
    public boolean f8302w;
    public final float[] y = new float[16];

    /* renamed from: v  reason: collision with root package name */
    public final float[] f8301v = new float[16];

    /* renamed from: fb  reason: collision with root package name */
    public final float[] f8298fb = new float[16];

    /* renamed from: s  reason: collision with root package name */
    public final float[] f8299s = new float[3];

    /* loaded from: classes.dex */
    public interface y {
        void y(float[] fArr, float f4);
    }

    public gv(Display display, y... yVarArr) {
        this.f8297f = display;
        this.f8300t = yVarArr;
    }

    public static void v(float[] fArr) {
        Matrix.rotateM(fArr, 0, 90.0f, 1.0f, 0.0f, 0.0f);
    }

    public final void gv(float[] fArr, int i) {
        if (i != 0) {
            int i5 = 129;
            int i6 = 1;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        i5 = 130;
                    } else {
                        throw new IllegalStateException();
                    }
                } else {
                    i6 = 130;
                }
            } else {
                i5 = 2;
                i6 = 129;
            }
            float[] fArr2 = this.f8301v;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            SensorManager.remapCoordinateSystem(this.f8301v, i5, i6, fArr);
        }
    }

    public final void n3(float[] fArr, float f4) {
        for (y yVar : this.f8300t) {
            yVar.y(fArr, f4);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        SensorManager.getRotationMatrixFromVector(this.y, sensorEvent.values);
        gv(this.y, this.f8297f.getRotation());
        float y2 = y(this.y);
        v(this.y);
        zn(this.y);
        n3(this.y, y2);
    }

    public final float y(float[] fArr) {
        SensorManager.remapCoordinateSystem(fArr, 1, 131, this.f8301v);
        SensorManager.getOrientation(this.f8301v, this.f8299s);
        return this.f8299s[2];
    }

    public final void zn(float[] fArr) {
        if (!this.f8302w) {
            zn.y(this.f8298fb, fArr);
            this.f8302w = true;
        }
        float[] fArr2 = this.f8301v;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        Matrix.multiplyMM(fArr, 0, this.f8301v, 0, this.f8298fb, 0);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}
