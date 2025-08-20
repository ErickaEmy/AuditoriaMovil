package org.acra.plugins;

import kotlin.jvm.internal.Intrinsics;
import org.acra.config.CoreConfiguration;
/* compiled from: Plugin.kt */
/* loaded from: classes2.dex */
public interface Plugin {

    /* compiled from: Plugin.kt */
    /* renamed from: org.acra.plugins.Plugin$-CC  reason: invalid class name */
    /* loaded from: classes2.dex */
    public abstract /* synthetic */ class CC {
        public static boolean $default$enabled(Plugin plugin, CoreConfiguration config) {
            Intrinsics.checkNotNullParameter(config, "config");
            return true;
        }
    }

    boolean enabled(CoreConfiguration coreConfiguration);
}
