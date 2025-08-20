package ix;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import cs.fb;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class n3 implements ix.y {
    public final fb y;

    /* renamed from: n3  reason: collision with root package name */
    public final Handler f9312n3 = new Handler(Looper.getMainLooper());

    /* renamed from: zn  reason: collision with root package name */
    public final Executor f9313zn = new y();

    /* loaded from: classes.dex */
    public class y implements Executor {
        public y() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            n3.this.zn(runnable);
        }
    }

    public n3(@NonNull Executor executor) {
        this.y = new fb(executor);
    }

    @Override // ix.y
    @NonNull
    public fb getBackgroundExecutor() {
        return this.y;
    }

    @Override // ix.y
    public void n3(Runnable runnable) {
        this.y.execute(runnable);
    }

    @Override // ix.y
    public Executor y() {
        return this.f9313zn;
    }

    public void zn(Runnable runnable) {
        this.f9312n3.post(runnable);
    }
}
