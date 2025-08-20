package m0;

import android.util.Log;
import java.util.Set;
/* loaded from: classes.dex */
public final class mt implements Runnable {

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ y f10557v;
    public final /* synthetic */ Set y;

    public mt(y yVar, Set set) {
        this.f10557v = yVar;
        this.y = set;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f10557v.c5(this.y);
        } catch (Exception e2) {
            Log.e("SplitCompat", "Failed to remove from splitcompat storage split that is already installed", e2);
        }
    }
}
