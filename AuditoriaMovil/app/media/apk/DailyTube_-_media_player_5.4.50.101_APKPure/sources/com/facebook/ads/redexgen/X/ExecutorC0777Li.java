package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
/* renamed from: com.facebook.ads.redexgen.X.Li  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class ExecutorC0777Li implements Executor {
    public static final ExecutorC0777Li A01 = new ExecutorC0777Li();
    public final Handler A00 = new Handler(Looper.getMainLooper());

    public static void A00(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            A01.execute(runnable);
        }
    }

    public final Handler A01() {
        return this.A00;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.A00.post(runnable);
    }
}
