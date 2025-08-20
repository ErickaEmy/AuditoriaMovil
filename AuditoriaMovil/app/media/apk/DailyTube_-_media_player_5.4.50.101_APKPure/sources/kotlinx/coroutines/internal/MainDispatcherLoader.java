package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.MainCoroutineDispatcher;
/* loaded from: classes.dex */
public final class MainDispatcherLoader {
    private static final boolean FAST_SERVICE_LOADER_ENABLED;
    public static final MainDispatcherLoader INSTANCE;
    public static final MainCoroutineDispatcher dispatcher;

    static {
        MainDispatcherLoader mainDispatcherLoader = new MainDispatcherLoader();
        INSTANCE = mainDispatcherLoader;
        FAST_SERVICE_LOADER_ENABLED = SystemPropsKt.systemProp("kotlinx.coroutines.fast.service.loader", true);
        dispatcher = mainDispatcherLoader.loadMainDispatcher();
    }

    private MainDispatcherLoader() {
    }

    private final MainCoroutineDispatcher loadMainDispatcher() {
        List<MainDispatcherFactory> list;
        Object next;
        MainCoroutineDispatcher tryCreateDispatcher;
        try {
            if (FAST_SERVICE_LOADER_ENABLED) {
                list = FastServiceLoader.INSTANCE.loadMainDispatcherFactory$kotlinx_coroutines_core();
            } else {
                list = SequencesKt.toList(SequencesKt.asSequence(ServiceLoader.load(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader()).iterator()));
            }
            Iterator<T> it = list.iterator();
            if (!it.hasNext()) {
                next = null;
            } else {
                next = it.next();
                if (it.hasNext()) {
                    int loadPriority = ((MainDispatcherFactory) next).getLoadPriority();
                    do {
                        Object next2 = it.next();
                        int loadPriority2 = ((MainDispatcherFactory) next2).getLoadPriority();
                        if (loadPriority < loadPriority2) {
                            next = next2;
                            loadPriority = loadPriority2;
                        }
                    } while (it.hasNext());
                }
            }
            MainDispatcherFactory mainDispatcherFactory = (MainDispatcherFactory) next;
            if (mainDispatcherFactory == null || (tryCreateDispatcher = MainDispatchersKt.tryCreateDispatcher(mainDispatcherFactory, list)) == null) {
                return MainDispatchersKt.createMissingDispatcher$default(null, null, 3, null);
            }
            return tryCreateDispatcher;
        } catch (Throwable th) {
            return MainDispatchersKt.createMissingDispatcher$default(th, null, 2, null);
        }
    }
}
