package org.acra.collector;

import android.content.Context;
import ch.qos.logback.core.CoreConstants;
import kotlin.Metadata;
import org.acra.config.CoreConfiguration;
/* compiled from: ApplicationStartupCollector.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Lorg/acra/collector/ApplicationStartupCollector;", "Lorg/acra/collector/Collector;", "collectApplicationStartUp", "", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "config", "Lorg/acra/config/CoreConfiguration;", "acra-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ApplicationStartupCollector extends Collector {

    /* compiled from: ApplicationStartupCollector.kt */
    /* renamed from: org.acra.collector.ApplicationStartupCollector$-CC  reason: invalid class name */
    /* loaded from: classes2.dex */
    public abstract /* synthetic */ class CC {
    }

    void collectApplicationStartUp(Context context, CoreConfiguration coreConfiguration);

    @Override // org.acra.collector.Collector, org.acra.plugins.Plugin
    /* bridge */ /* synthetic */ boolean enabled(CoreConfiguration coreConfiguration);
}
