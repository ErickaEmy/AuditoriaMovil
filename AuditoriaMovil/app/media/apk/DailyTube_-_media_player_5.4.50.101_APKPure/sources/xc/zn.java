package xc;

import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public abstract class zn {
    public abstract void gv(@NonNull Runnable runnable);

    public void n3(@NonNull Runnable runnable) {
        if (zn()) {
            runnable.run();
        } else {
            gv(runnable);
        }
    }

    public abstract void y(@NonNull Runnable runnable);

    public abstract boolean zn();
}
