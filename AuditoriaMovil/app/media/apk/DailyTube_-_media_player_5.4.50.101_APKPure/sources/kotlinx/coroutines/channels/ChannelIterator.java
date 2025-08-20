package kotlinx.coroutines.channels;

import kotlin.coroutines.Continuation;
/* loaded from: classes.dex */
public interface ChannelIterator<E> {
    Object hasNext(Continuation<? super Boolean> continuation);

    E next();
}
