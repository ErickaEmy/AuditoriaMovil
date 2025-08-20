package org.acra.config;

import android.content.Context;
import kotlin.Metadata;
import org.acra.plugins.Plugin;
/* compiled from: ConfigurationBuilderFactory.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lorg/acra/config/ConfigurationBuilderFactory;", "Lorg/acra/plugins/Plugin;", "create", "Lorg/acra/config/ConfigurationBuilder;", "annotatedContext", "Landroid/content/Context;", "acra-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ConfigurationBuilderFactory extends Plugin {

    /* compiled from: ConfigurationBuilderFactory.kt */
    /* renamed from: org.acra.config.ConfigurationBuilderFactory$-CC  reason: invalid class name */
    /* loaded from: classes2.dex */
    public abstract /* synthetic */ class CC {
    }

    ConfigurationBuilder create(Context context);

    @Override // org.acra.plugins.Plugin
    /* bridge */ /* synthetic */ boolean enabled(CoreConfiguration coreConfiguration);
}
