package m0;

import java.util.concurrent.ThreadFactory;
/* loaded from: classes.dex */
public final class gv implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "SplitCompatBackgroundThread");
    }
}
