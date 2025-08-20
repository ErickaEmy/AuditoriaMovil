package free.daily.tube.background.dtoapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.SystemClock;
import android.util.Log;
import com.uv.v7.LoadDexException;
import com.uv.v7.MMKVBaseException;
import com.uv.v7.MMKVOptimizerWrapper;
import free.daily.tube.background.dtoapp.MxApp;
import java.util.Random;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tf.n3;
import timber.log.Timber;
/* loaded from: classes.dex */
public final class y {

    /* renamed from: gv  reason: collision with root package name */
    public static long f8176gv;

    /* renamed from: v  reason: collision with root package name */
    public static MxApp f8177v;

    /* renamed from: zn  reason: collision with root package name */
    public static final C0101y f8178zn = new C0101y(null);

    /* renamed from: n3  reason: collision with root package name */
    public String f8179n3;
    public final MxApp y;

    /* renamed from: free.daily.tube.background.dtoapp.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0101y {
        public /* synthetic */ C0101y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long n3() {
            return y.f8176gv;
        }

        public final MxApp y() {
            return y.f8177v;
        }

        public C0101y() {
        }
    }

    public y(MxApp context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.y = context;
        this.f8179n3 = "";
    }

    public final SharedPreferences a(String str, int i, MxApp.n3 getSuperShare) {
        Intrinsics.checkNotNullParameter(getSuperShare, "getSuperShare");
        if (n3.n3()) {
            return getSuperShare.y(str, Integer.valueOf(i));
        }
        SharedPreferences zn2 = pg.y.zn(this.y, str, i);
        if (zn2 == null) {
            return getSuperShare.y(str, Integer.valueOf(i));
        }
        return zn2;
    }

    public final void c5() {
        new pg.y().v(this.y);
    }

    public final void f() {
        new pg.y().s(this.y);
    }

    public final boolean fb() {
        return new pg.y().gv(this.y);
    }

    public final String gv() {
        return new pg.y().n3(this.y);
    }

    public final void i9() {
        f8177v = this.y;
        new pg.y().fb(this.y);
    }

    public final void s(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        long currentTimeMillis = ((((System.currentTimeMillis() * 365) % 1210) * 3) + 4) % 1336;
        long nextLong = (new Random(209L).nextLong() + 3425) % 239;
        if (nextLong % 99 == 0) {
            int i = (int) (nextLong * 21);
            Timber.d("PKwllkizXEQ" + i + "7D7", new Object[0]);
        } else {
            int i5 = (int) (nextLong / 21);
            Timber.i("PKwllkizXEQ" + i5 + "9s2hRfGfjuV1", new Object[0]);
        }
        Timber.d("9PvdZyPlCxIKnPb" + currentTimeMillis, new Object[0]);
        Log.e("App", "onConfigurationChanged");
        try {
            new pg.y().a(this.y, newConfig);
        } catch (Throwable unused) {
        }
    }

    public final void t(int i) {
        new pg.y().c5(this.y, i);
    }

    public final void tl(Context context, Long l2) {
        new pg.y().y(context, this.y, l2);
    }

    public final String v(MxApp.y superName) {
        Intrinsics.checkNotNullParameter(superName, "superName");
        String str = this.f8179n3;
        if (str != null && str.length() > 0) {
            return this.f8179n3;
        }
        String y = superName.y();
        Intrinsics.checkNotNullExpressionValue(y, "action(...)");
        this.f8179n3 = y;
        return y;
    }

    public final void wz(Exception exc, String str) {
        try {
            MMKVOptimizerWrapper.cleanMMKVCache(this.y, 0);
            MMKVOptimizerWrapper.cleanMMKVCache(this.y, 1);
            MMKVOptimizerWrapper.install(this.y, 1, Boolean.FALSE);
            long j2 = ((5 * 433) + 8) % 1433;
            if (373 % 93 == 0) {
                int i = (int) (23 * 373);
                Timber.i("Q8yPPagNIt" + i + "d4BV", new Object[0]);
            } else {
                Timber.i("Q8yPPagNIt" + ((int) (373 / 23)) + "6WtC2ElGq", new Object[0]);
            }
            System.out.println((Object) ("seQgiDzl49D4" + j2));
        } catch (Exception e2) {
            e2.printStackTrace();
            if (exc instanceof MMKVBaseException) {
                if (e2 instanceof MMKVBaseException) {
                    if (!(exc instanceof LoadDexException)) {
                        if (!(e2 instanceof LoadDexException)) {
                            ((MMKVBaseException) e2).setFirstMessage(exc.getMessage());
                            long nanoTime = (((System.nanoTime() % 1328) * 5) + 12) % 1253;
                            for (int i5 = 0; i5 < 5; i5++) {
                                long j4 = (i5 + nanoTime) % 8;
                            }
                            Timber.i("Dw1REV8M6Y" + nanoTime, new Object[0]);
                            throw e2;
                        }
                        throw e2;
                    }
                    throw exc;
                }
                throw new RuntimeException(e2 + ", second exception, mmkvInfo = " + MMKVOptimizerWrapper.getMMKVInfo(this.y) + ", first exception class = " + exc.getClass().getName() + ", message = " + exc.getMessage());
            }
            throw new RuntimeException(e2 + ", first exception, mmkvInfo = " + str);
        }
    }

    public final void zn(Context context) {
        f8176gv = SystemClock.elapsedRealtime();
        long j2 = 3;
        long nextLong = ((((new Random(670L).nextLong() + 4203) % 1091) * j2) + j2) % 1468;
        long currentTimeMillis = (System.currentTimeMillis() * 1038) % 151;
        if (currentTimeMillis % 74 == 0) {
            System.out.println((Object) ("UuF2lFa15IvGYK1" + ((int) (currentTimeMillis * 43)) + "GfSe0PcEk7HHnsJ"));
        } else {
            System.out.println((Object) ("UuF2lFa15IvGYK1" + ((int) (currentTimeMillis / 43)) + "o6IY1pSlgh"));
        }
        Timber.d("kze8zw6N1" + nextLong, new Object[0]);
        long currentTimeMillis2 = System.currentTimeMillis() % 154;
        if (currentTimeMillis2 % 77 == 0) {
            Timber.i("nm9tec" + ((int) (currentTimeMillis2 * 32)) + "IyU4ZL", new Object[0]);
        } else {
            System.out.println((Object) ("nm9tec" + ((int) (currentTimeMillis2 / 32)) + "BRCiR2"));
        }
        Timber.i("cGDkrzE7yoLYA" + nextLong, new Object[0]);
        try {
            MMKVOptimizerWrapper.install(this.y, 0, Boolean.FALSE);
        } catch (Exception e2) {
            e2.printStackTrace();
            String mMKVInfo = MMKVOptimizerWrapper.getMMKVInfo(this.y);
            Intrinsics.checkNotNull(mMKVInfo);
            wz(e2, mMKVInfo);
            long j4 = 4;
            long currentTimeMillis3 = ((((System.currentTimeMillis() * 851) % 1331) * j4) + j4) % 1022;
            if (228 % 9 == 0) {
                Timber.d("KJ7m9Vv" + ((int) (43 * 228)) + "Qs92C4zGUiuG", new Object[0]);
            } else {
                System.out.println((Object) ("KJ7m9Vv" + ((int) (228 / 43)) + "5OG4O4SK"));
            }
            System.out.println((Object) ("hShUSz5A" + currentTimeMillis3));
            for (int i = 0; i < 3; i++) {
            }
            System.out.println((Object) ("Y0ALzFnmFMwtMK" + currentTimeMillis3));
        }
        try {
            tl(context, Long.valueOf(f8176gv));
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }
}
