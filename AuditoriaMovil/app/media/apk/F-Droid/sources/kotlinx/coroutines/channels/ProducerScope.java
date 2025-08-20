package kotlinx.coroutines.channels;

import kotlinx.coroutines.CoroutineScope;
/* compiled from: Produce.kt */
/* loaded from: classes2.dex */
public interface ProducerScope extends CoroutineScope, SendChannel {
    SendChannel getChannel();
}
