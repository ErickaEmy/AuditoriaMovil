package org.acra.plugins;

import java.io.Serializable;
import java.util.List;
import org.acra.config.CoreConfiguration;
/* compiled from: PluginLoader.kt */
/* loaded from: classes2.dex */
public interface PluginLoader extends Serializable {
    List loadEnabled(CoreConfiguration coreConfiguration, Class cls);
}
