package androidx.compose.runtime;

import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: ActualJvm.jvm.kt */
/* loaded from: classes.dex */
public final class AtomicInt {
    private final AtomicInteger delegate;

    public AtomicInt(int i) {
        this.delegate = new AtomicInteger(i);
    }

    public final int add(int i) {
        return this.delegate.addAndGet(i);
    }
}
