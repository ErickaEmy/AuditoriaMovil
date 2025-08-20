package kotlinx.coroutines.channels;

import kotlinx.coroutines.CoroutineScope;
/* loaded from: classes.dex */
public interface ProducerScope<E> extends CoroutineScope, SendChannel<E> {
    SendChannel<E> getChannel();
}
