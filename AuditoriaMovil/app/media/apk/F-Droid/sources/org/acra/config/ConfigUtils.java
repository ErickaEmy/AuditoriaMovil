package org.acra.config;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;
import org.acra.log.ACRALog;
/* compiled from: ConfigUtils.kt */
/* loaded from: classes2.dex */
public abstract class ConfigUtils {
    public static final Configuration findPluginConfiguration(CoreConfiguration coreConfiguration, Class c) {
        Intrinsics.checkNotNullParameter(coreConfiguration, "<this>");
        Intrinsics.checkNotNullParameter(c, "c");
        if (ACRA.DEV_LOGGING) {
            ACRALog aCRALog = ACRA.log;
            String str = ACRA.LOG_TAG;
            List pluginConfigurations = coreConfiguration.getPluginConfigurations();
            aCRALog.d(str, "Checking plugin Configurations : " + pluginConfigurations + " for class : " + c);
        }
        for (Configuration configuration : coreConfiguration.getPluginConfigurations()) {
            if (ACRA.DEV_LOGGING) {
                ACRALog aCRALog2 = ACRA.log;
                String str2 = ACRA.LOG_TAG;
                aCRALog2.d(str2, "Checking plugin Configuration : " + configuration + " against plugin class : " + c);
            }
            if (c.isAssignableFrom(configuration.getClass())) {
                Intrinsics.checkNotNull(configuration, "null cannot be cast to non-null type T of org.acra.config.ConfigUtils.findPluginConfiguration");
                return configuration;
            }
        }
        return null;
    }

    public static final Configuration getPluginConfiguration(CoreConfiguration coreConfiguration, Class c) {
        Intrinsics.checkNotNullParameter(coreConfiguration, "<this>");
        Intrinsics.checkNotNullParameter(c, "c");
        Configuration findPluginConfiguration = findPluginConfiguration(coreConfiguration, c);
        if (findPluginConfiguration != null) {
            return findPluginConfiguration;
        }
        String name = c.getName();
        throw new IllegalArgumentException(name + " is no registered configuration");
    }
}
