package kotlinx.coroutines.channels;

import kotlin.coroutines.Continuation;
/* compiled from: Channel.kt */
/* loaded from: classes2.dex */
public interface ChannelIterator {
    Object hasNext(Continuation continuation);

    Object next();
}
