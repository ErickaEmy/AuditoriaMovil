package kotlinx.coroutines.sync;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
/* loaded from: classes.dex */
public interface Mutex {

    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object lock$default(Mutex mutex, Object obj, Continuation continuation, int i, Object obj2) {
            if (obj2 == null) {
                if ((i & 1) != 0) {
                    obj = null;
                }
                return mutex.lock(obj, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lock");
        }

        public static /* synthetic */ void unlock$default(Mutex mutex, Object obj, int i, Object obj2) {
            if (obj2 == null) {
                if ((i & 1) != 0) {
                    obj = null;
                }
                mutex.unlock(obj);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unlock");
        }
    }

    boolean isLocked();

    Object lock(Object obj, Continuation<? super Unit> continuation);

    void unlock(Object obj);
}
