package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.selects.SelectClause1;
/* loaded from: classes.dex */
public interface ReceiveChannel<E> {
    void cancel(CancellationException cancellationException);

    SelectClause1<ChannelResult<E>> getOnReceiveCatching();

    ChannelIterator<E> iterator();

    /* renamed from: receiveCatching-JP2dKIU */
    Object mo83receiveCatchingJP2dKIU(Continuation<? super ChannelResult<? extends E>> continuation);

    /* renamed from: tryReceive-PtdJZtk */
    Object mo84tryReceivePtdJZtk();
}
