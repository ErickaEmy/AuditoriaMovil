package b;

import android.os.OutcomeReceiver;
import kotlin.coroutines.Continuation;
/* loaded from: classes.dex */
public final class wz {
    public static final <R, E extends Throwable> OutcomeReceiver<R, E> y(Continuation<? super R> continuation) {
        return new s(continuation);
    }
}
