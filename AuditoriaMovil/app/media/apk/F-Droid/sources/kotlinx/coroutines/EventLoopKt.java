package kotlinx.coroutines;

import org.fdroid.fdroid.Preferences;
/* compiled from: EventLoop.kt */
/* loaded from: classes2.dex */
public abstract class EventLoopKt {
    public static final EventLoop createEventLoop() {
        return new BlockingEventLoop(Thread.currentThread());
    }

    public static final long processNextEventInCurrentThread() {
        EventLoop currentOrNull$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.currentOrNull$kotlinx_coroutines_core();
        return currentOrNull$kotlinx_coroutines_core != null ? currentOrNull$kotlinx_coroutines_core.processNextEvent() : Preferences.UPDATE_INTERVAL_DISABLED;
    }
}
