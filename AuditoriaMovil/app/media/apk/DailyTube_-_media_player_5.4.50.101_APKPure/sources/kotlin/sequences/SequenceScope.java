package kotlin.sequences;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
/* loaded from: classes.dex */
public abstract class SequenceScope<T> {
    public abstract Object yield(T t2, Continuation<? super Unit> continuation);
}
