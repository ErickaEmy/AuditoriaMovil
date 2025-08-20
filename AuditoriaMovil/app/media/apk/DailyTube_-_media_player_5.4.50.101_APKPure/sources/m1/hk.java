package m1;

import android.annotation.SuppressLint;
import androidx.core.app.NotificationCompat;
/* loaded from: classes.dex */
public final /* synthetic */ class hk {
    @SuppressLint({"WrongConstant"})
    public static int a(int i) {
        return i & 7;
    }

    @SuppressLint({"WrongConstant"})
    public static int fb(int i) {
        return i & 64;
    }

    @SuppressLint({"WrongConstant"})
    public static int gv(int i) {
        return i & 24;
    }

    public static int n3(int i, int i5, int i6) {
        return zn(i, i5, i6, 0, NotificationCompat.FLAG_HIGH_PRIORITY);
    }

    @SuppressLint({"WrongConstant"})
    public static int s(int i) {
        return i & 32;
    }

    @SuppressLint({"WrongConstant"})
    public static int v(int i) {
        return i & 384;
    }

    public static int y(int i) {
        return n3(i, 0, 0);
    }

    @SuppressLint({"WrongConstant"})
    public static int zn(int i, int i5, int i6, int i8, int i10) {
        return i | i5 | i6 | i8 | i10;
    }
}
