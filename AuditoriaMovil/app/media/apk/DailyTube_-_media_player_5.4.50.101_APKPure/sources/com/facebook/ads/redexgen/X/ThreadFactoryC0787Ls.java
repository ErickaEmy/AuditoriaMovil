package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* renamed from: com.facebook.ads.redexgen.X.Ls  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class ThreadFactoryC0787Ls implements ThreadFactory {
    public static byte[] A03;
    public final AtomicInteger A00 = new AtomicInteger(1);
    public final /* synthetic */ ExecutorC0788Lt A01;
    public final /* synthetic */ String A02;

    static {
        A01();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 41);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{96, 103, 104, 28, 3, 85, 6, 5, 3, 66};
    }

    public ThreadFactoryC0787Ls(ExecutorC0788Lt executorC0788Lt, String str) {
        this.A01 = executorC0788Lt;
        this.A02 = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, String.format(Locale.US, A00(0, 10, 15), this.A02, Integer.valueOf(this.A00.getAndIncrement())));
    }
}
