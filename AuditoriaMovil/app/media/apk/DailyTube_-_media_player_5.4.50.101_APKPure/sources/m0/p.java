package m0;

import android.util.Log;
/* loaded from: classes.dex */
public final class p implements Runnable {
    public final /* synthetic */ y y;

    public p(y yVar) {
        this.y = yVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a aVar;
        try {
            aVar = this.y.y;
            aVar.f();
        } catch (Exception e2) {
            Log.e("SplitCompat", "Failed to cleanup splitcompat storage", e2);
        }
    }
}
