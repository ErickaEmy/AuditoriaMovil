package f1;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;
/* loaded from: classes.dex */
public interface zn<V> extends Future<V> {
    void addListener(Runnable runnable, Executor executor);
}
