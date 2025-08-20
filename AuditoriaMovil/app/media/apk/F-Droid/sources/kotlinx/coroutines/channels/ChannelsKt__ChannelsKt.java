package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.channels.ChannelResult;
/* compiled from: Channels.kt */
/* loaded from: classes2.dex */
abstract /* synthetic */ class ChannelsKt__ChannelsKt {
    public static final Object trySendBlocking(SendChannel sendChannel, Object obj) {
        Object runBlocking$default;
        Object mo2270trySendJP2dKIU = sendChannel.mo2270trySendJP2dKIU(obj);
        if (mo2270trySendJP2dKIU instanceof ChannelResult.Failed) {
            runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new ChannelsKt__ChannelsKt$trySendBlocking$2(sendChannel, obj, null), 1, null);
            return ((ChannelResult) runBlocking$default).m2280unboximpl();
        }
        Unit unit = (Unit) mo2270trySendJP2dKIU;
        return ChannelResult.Companion.m2283successJP2dKIU(Unit.INSTANCE);
    }
}
