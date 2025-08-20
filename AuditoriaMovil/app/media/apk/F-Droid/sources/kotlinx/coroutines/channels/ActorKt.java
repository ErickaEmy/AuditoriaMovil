package kotlinx.coroutines.channels;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
/* compiled from: Actor.kt */
/* loaded from: classes2.dex */
public abstract class ActorKt {
    public static /* synthetic */ SendChannel actor$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, int i, CoroutineStart coroutineStart, Function1 function1, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        if ((i2 & 2) != 0) {
            i = 0;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i2 & 8) != 0) {
            function1 = null;
        }
        return actor(coroutineScope, coroutineContext2, i3, coroutineStart2, function1, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [kotlinx.coroutines.AbstractCoroutine, kotlinx.coroutines.channels.SendChannel, kotlinx.coroutines.JobSupport, java.lang.Object] */
    public static final SendChannel actor(CoroutineScope coroutineScope, CoroutineContext coroutineContext, int i, CoroutineStart coroutineStart, Function1 function1, Function2 function2) {
        LazyActorCoroutine lazyActorCoroutine;
        CoroutineContext newCoroutineContext = CoroutineContextKt.newCoroutineContext(coroutineScope, coroutineContext);
        Channel Channel$default = ChannelKt.Channel$default(i, null, null, 6, null);
        if (coroutineStart.isLazy()) {
            lazyActorCoroutine = new LazyActorCoroutine(newCoroutineContext, Channel$default, function2);
        } else {
            lazyActorCoroutine = new ActorCoroutine(newCoroutineContext, Channel$default, true);
        }
        if (function1 != null) {
            lazyActorCoroutine.invokeOnCompletion(function1);
        }
        lazyActorCoroutine.start(coroutineStart, lazyActorCoroutine, function2);
        return lazyActorCoroutine;
    }
}
