package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
/* compiled from: Deferred.kt */
/* loaded from: classes2.dex */
public interface Deferred extends Job {
    Object await(Continuation continuation);
}
