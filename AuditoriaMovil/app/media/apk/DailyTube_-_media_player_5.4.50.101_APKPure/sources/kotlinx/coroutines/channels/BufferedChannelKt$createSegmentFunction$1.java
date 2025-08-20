package kotlinx.coroutines.channels;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* JADX INFO: Add missing generic type declarations: [E] */
/* loaded from: classes.dex */
public /* synthetic */ class BufferedChannelKt$createSegmentFunction$1<E> extends FunctionReferenceImpl implements Function2<Long, ChannelSegment<E>, ChannelSegment<E>> {
    public static final BufferedChannelKt$createSegmentFunction$1 INSTANCE = new BufferedChannelKt$createSegmentFunction$1();

    public BufferedChannelKt$createSegmentFunction$1() {
        super(2, BufferedChannelKt.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Long l2, Object obj) {
        return invoke(l2.longValue(), (ChannelSegment) obj);
    }

    public final ChannelSegment<E> invoke(long j2, ChannelSegment<E> channelSegment) {
        ChannelSegment<E> createSegment;
        createSegment = BufferedChannelKt.createSegment(j2, channelSegment);
        return createSegment;
    }
}
