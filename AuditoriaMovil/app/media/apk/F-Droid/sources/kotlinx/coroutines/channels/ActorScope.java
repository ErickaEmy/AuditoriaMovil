package kotlinx.coroutines.channels;

import kotlinx.coroutines.CoroutineScope;
/* compiled from: Actor.kt */
/* loaded from: classes2.dex */
public interface ActorScope extends CoroutineScope, ReceiveChannel {
    Channel getChannel();
}
