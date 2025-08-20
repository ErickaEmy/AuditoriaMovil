package l;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
/* loaded from: classes.dex */
public abstract class i4 {
    public static final String y = f.a("WorkerFactory");

    /* loaded from: classes.dex */
    public class y extends i4 {
        @Override // l.i4
        @Nullable
        public ListenableWorker y(@NonNull Context context, @NonNull String str, @NonNull WorkerParameters workerParameters) {
            return null;
        }
    }

    @NonNull
    public static i4 zn() {
        return new y();
    }

    @Nullable
    public final ListenableWorker n3(@NonNull Context context, @NonNull String str, @NonNull WorkerParameters workerParameters) {
        Class cls;
        ListenableWorker y2 = y(context, str, workerParameters);
        if (y2 == null) {
            try {
                cls = Class.forName(str).asSubclass(ListenableWorker.class);
            } catch (Throwable th) {
                f zn2 = f.zn();
                String str2 = y;
                zn2.n3(str2, "Invalid class: " + str, th);
                cls = null;
            }
            if (cls != null) {
                try {
                    y2 = (ListenableWorker) cls.getDeclaredConstructor(Context.class, WorkerParameters.class).newInstance(context, workerParameters);
                } catch (Throwable th2) {
                    f zn3 = f.zn();
                    String str3 = y;
                    zn3.n3(str3, "Could not instantiate " + str, th2);
                }
            }
        }
        if (y2 != null && y2.isUsed()) {
            throw new IllegalStateException(String.format("WorkerFactory (%s) returned an instance of a ListenableWorker (%s) which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.", getClass().getName(), str));
        }
        return y2;
    }

    @Nullable
    public abstract ListenableWorker y(@NonNull Context context, @NonNull String str, @NonNull WorkerParameters workerParameters);
}
