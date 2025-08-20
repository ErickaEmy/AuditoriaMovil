package io.ktor.utils.io;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
/* compiled from: Coroutines.kt */
/* loaded from: classes.dex */
public abstract class CoroutinesKt {
    public static /* synthetic */ WriterJob writer$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return writer(coroutineScope, coroutineContext, z, function2);
    }

    public static final WriterJob writer(CoroutineScope coroutineScope, CoroutineContext coroutineContext, boolean z, Function2 block) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(block, "block");
        return launchChannel(coroutineScope, coroutineContext, ByteChannelKt.ByteChannel(z), true, block);
    }

    private static final ChannelJob launchChannel(CoroutineScope coroutineScope, CoroutineContext coroutineContext, final ByteChannel byteChannel, boolean z, Function2 function2) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, coroutineContext, null, new CoroutinesKt$launchChannel$job$1(z, byteChannel, function2, (CoroutineDispatcher) coroutineScope.getCoroutineContext().get(CoroutineDispatcher.Key), null), 2, null);
        launch$default.invokeOnCompletion(new Function1() { // from class: io.ktor.utils.io.CoroutinesKt$launchChannel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable th) {
                ByteChannel.this.close(th);
            }
        });
        return new ChannelJob(launch$default, byteChannel);
    }
}
