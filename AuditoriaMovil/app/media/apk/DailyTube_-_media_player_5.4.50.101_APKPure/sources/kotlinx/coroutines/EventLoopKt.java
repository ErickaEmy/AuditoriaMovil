package kotlinx.coroutines;
/* loaded from: classes.dex */
public final class EventLoopKt {
    public static final EventLoop createEventLoop() {
        return new BlockingEventLoop(Thread.currentThread());
    }
}
