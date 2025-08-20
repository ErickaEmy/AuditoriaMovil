package org.acra.plugins;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;
import org.acra.config.CoreConfiguration;
import org.acra.log.ACRALog;
/* compiled from: ServicePluginLoader.kt */
/* loaded from: classes2.dex */
public final class ServicePluginLoader implements PluginLoader {
    @Override // org.acra.plugins.PluginLoader
    public List loadEnabled(final CoreConfiguration config, Class clazz) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return loadInternal(clazz, new Function1() { // from class: org.acra.plugins.ServicePluginLoader$loadEnabled$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Plugin it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.enabled(CoreConfiguration.this));
            }
        });
    }

    private final List loadInternal(Class cls, Function1 function1) {
        ArrayList arrayList = new ArrayList();
        ServiceLoader load = ServiceLoader.load(cls, ServicePluginLoader.class.getClassLoader());
        if (ACRA.DEV_LOGGING) {
            ACRALog aCRALog = ACRA.log;
            String str = ACRA.LOG_TAG;
            aCRALog.d(str, "ServicePluginLoader loading services from ServiceLoader : " + load);
        }
        Iterator it = load.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            try {
                try {
                    Plugin plugin = (Plugin) it.next();
                    if (((Boolean) function1.invoke(plugin)).booleanValue()) {
                        if (ACRA.DEV_LOGGING) {
                            ACRALog aCRALog2 = ACRA.log;
                            String str2 = ACRA.LOG_TAG;
                            String simpleName = cls.getSimpleName();
                            String name = plugin.getClass().getName();
                            aCRALog2.d(str2, "Loaded " + simpleName + " of type " + name);
                        }
                        arrayList.add(plugin);
                    } else if (ACRA.DEV_LOGGING) {
                        ACRALog aCRALog3 = ACRA.log;
                        String str3 = ACRA.LOG_TAG;
                        String simpleName2 = cls.getSimpleName();
                        String simpleName3 = plugin.getClass().getSimpleName();
                        aCRALog3.d(str3, "Ignoring disabled " + simpleName2 + " of type " + simpleName3);
                    }
                } catch (ServiceConfigurationError e) {
                    ACRALog aCRALog4 = ACRA.log;
                    String str4 = ACRA.LOG_TAG;
                    String simpleName4 = cls.getSimpleName();
                    aCRALog4.e(str4, "Unable to load " + simpleName4, e);
                }
            } catch (ServiceConfigurationError e2) {
                ACRALog aCRALog5 = ACRA.log;
                String str5 = ACRA.LOG_TAG;
                String simpleName5 = cls.getSimpleName();
                aCRALog5.e(str5, "Broken ServiceLoader for " + simpleName5, e2);
            }
        }
        return arrayList;
    }
}
