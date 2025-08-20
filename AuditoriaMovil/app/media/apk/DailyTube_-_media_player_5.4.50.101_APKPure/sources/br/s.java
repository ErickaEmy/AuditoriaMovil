package br;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import android.provider.Settings;
import androidx.annotation.Nullable;
import i3.r;
import java.io.Closeable;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import javax.net.ssl.SSLException;
import yk.zn;
/* loaded from: classes.dex */
public final class s {
    public static final ThreadLocal<PathMeasure> y = new y();

    /* renamed from: n3  reason: collision with root package name */
    public static final ThreadLocal<Path> f3869n3 = new n3();

    /* renamed from: zn  reason: collision with root package name */
    public static final ThreadLocal<Path> f3871zn = new zn();

    /* renamed from: gv  reason: collision with root package name */
    public static final ThreadLocal<float[]> f3868gv = new gv();

    /* renamed from: v  reason: collision with root package name */
    public static final float f3870v = (float) (Math.sqrt(2.0d) / 2.0d);

    public static float a(Context context) {
        return Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
    }

    public static int c5(float f4, float f6, float f9, float f10) {
        int i;
        if (f4 != 0.0f) {
            i = (int) (527 * f4);
        } else {
            i = 17;
        }
        if (f6 != 0.0f) {
            i = (int) (i * 31 * f6);
        }
        if (f9 != 0.0f) {
            i = (int) (i * 31 * f9);
        }
        if (f10 != 0.0f) {
            return (int) (i * 31 * f10);
        }
        return i;
    }

    public static boolean f(Throwable th) {
        if (!(th instanceof SocketException) && !(th instanceof ClosedChannelException) && !(th instanceof InterruptedIOException) && !(th instanceof ProtocolException) && !(th instanceof SSLException) && !(th instanceof UnknownHostException) && !(th instanceof UnknownServiceException)) {
            return false;
        }
        return true;
    }

    public static float fb(Matrix matrix) {
        float[] fArr = f3868gv.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f4 = f3870v;
        fArr[2] = f4;
        fArr[3] = f4;
        matrix.mapPoints(fArr);
        return (float) Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1]);
    }

    public static Path gv(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 != null && pointF4 != null && (pointF3.length() != 0.0f || pointF4.length() != 0.0f)) {
            float f4 = pointF.x;
            float f6 = pointF2.x;
            float f9 = pointF2.y;
            path.cubicTo(pointF3.x + f4, pointF.y + pointF3.y, f6 + pointF4.x, f9 + pointF4.y, f6, f9);
        } else {
            path.lineTo(pointF2.x, pointF2.y);
        }
        return path;
    }

    public static boolean i9(int i, int i5, int i6, int i8, int i10, int i11) {
        if (i < i8) {
            return false;
        }
        if (i > i8) {
            return true;
        }
        if (i5 < i10) {
            return false;
        }
        if (i5 <= i10 && i6 < i11) {
            return false;
        }
        return true;
    }

    public static void n3(Path path, @Nullable r rVar) {
        if (rVar != null && !rVar.f()) {
            y(path, ((vn.gv) rVar.c5()).w() / 100.0f, ((vn.gv) rVar.v()).w() / 100.0f, ((vn.gv) rVar.a()).w() / 360.0f);
        }
    }

    public static boolean s(Matrix matrix) {
        float[] fArr = f3868gv.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix.mapPoints(fArr);
        if (fArr[0] != fArr[2] && fArr[1] != fArr[3]) {
            return false;
        }
        return true;
    }

    public static Bitmap t(Bitmap bitmap, int i, int i5) {
        if (bitmap.getWidth() == i && bitmap.getHeight() == i5) {
            return bitmap;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i5, true);
        bitmap.recycle();
        return createScaledBitmap;
    }

    public static void tl(Canvas canvas, RectF rectF, Paint paint) {
        wz(canvas, rectF, paint, 31);
    }

    public static float v() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static void wz(Canvas canvas, RectF rectF, Paint paint, int i) {
        zn.y("Utils#saveLayer");
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, i);
        } else {
            canvas.saveLayer(rectF, paint);
        }
        zn.n3("Utils#saveLayer");
    }

    public static void y(Path path, float f4, float f6, float f9) {
        zn.y("applyTrimPathIfNeeded");
        PathMeasure pathMeasure = y.get();
        Path path2 = f3869n3.get();
        Path path3 = f3871zn.get();
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (f4 == 1.0f && f6 == 0.0f) {
            zn.n3("applyTrimPathIfNeeded");
        } else if (length >= 1.0f && Math.abs((f6 - f4) - 1.0f) >= 0.01d) {
            float f10 = f4 * length;
            float f11 = f6 * length;
            float f12 = f9 * length;
            float min = Math.min(f10, f11) + f12;
            float max = Math.max(f10, f11) + f12;
            if (min >= length && max >= length) {
                min = fb.a(min, length);
                max = fb.a(max, length);
            }
            if (min < 0.0f) {
                min = fb.a(min, length);
            }
            if (max < 0.0f) {
                max = fb.a(max, length);
            }
            int i = (min > max ? 1 : (min == max ? 0 : -1));
            if (i == 0) {
                path.reset();
                zn.n3("applyTrimPathIfNeeded");
                return;
            }
            if (i >= 0) {
                min -= length;
            }
            path2.reset();
            pathMeasure.getSegment(min, max, path2, true);
            if (max > length) {
                path3.reset();
                pathMeasure.getSegment(0.0f, max % length, path3, true);
                path2.addPath(path3);
            } else if (min < 0.0f) {
                path3.reset();
                pathMeasure.getSegment(min + length, length, path3, true);
                path2.addPath(path3);
            }
            path.set(path2);
            zn.n3("applyTrimPathIfNeeded");
        } else {
            zn.n3("applyTrimPathIfNeeded");
        }
    }

    public static void zn(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }
}
