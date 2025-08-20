package gq;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import l.mt;
/* loaded from: classes.dex */
public class y implements mt {
    public final Handler y = b.c5.y(Looper.getMainLooper());

    @Override // l.mt
    public void n3(long j2, @NonNull Runnable runnable) {
        this.y.postDelayed(runnable, j2);
    }

    @Override // l.mt
    public void y(@NonNull Runnable runnable) {
        this.y.removeCallbacks(runnable);
    }
}
