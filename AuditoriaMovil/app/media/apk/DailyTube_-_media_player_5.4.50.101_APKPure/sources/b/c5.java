package b;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes.dex */
public final class c5 {

    /* loaded from: classes.dex */
    public static class y {
        public static boolean n3(Handler handler, Runnable runnable, Object obj, long j2) {
            return handler.postDelayed(runnable, obj, j2);
        }

        public static Handler y(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    public static boolean n3(@NonNull Handler handler, @NonNull Runnable runnable, @Nullable Object obj, long j2) {
        if (Build.VERSION.SDK_INT >= 28) {
            return y.n3(handler, runnable, obj, j2);
        }
        Message obtain = Message.obtain(handler, runnable);
        obtain.obj = obj;
        return handler.sendMessageDelayed(obtain, j2);
    }

    @NonNull
    public static Handler y(@NonNull Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return y.y(looper);
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (IllegalAccessException e2) {
            e = e2;
            Log.w("HandlerCompat", "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
            return new Handler(looper);
        } catch (InstantiationException e3) {
            e = e3;
            Log.w("HandlerCompat", "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
            return new Handler(looper);
        } catch (NoSuchMethodException e5) {
            e = e5;
            Log.w("HandlerCompat", "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
            return new Handler(looper);
        } catch (InvocationTargetException e6) {
            Throwable cause = e6.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException(cause);
            }
            throw ((RuntimeException) cause);
        }
    }
}
