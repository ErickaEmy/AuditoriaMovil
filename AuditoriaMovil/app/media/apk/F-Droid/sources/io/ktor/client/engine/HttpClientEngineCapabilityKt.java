package io.ktor.client.engine;

import io.ktor.client.plugins.HttpTimeout;
import io.ktor.util.AttributeKey;
import java.util.Set;
import kotlin.collections.SetsKt__SetsJVMKt;
/* compiled from: HttpClientEngineCapability.kt */
/* loaded from: classes.dex */
public abstract class HttpClientEngineCapabilityKt {
    private static final Set DEFAULT_CAPABILITIES;
    private static final AttributeKey ENGINE_CAPABILITIES_KEY = new AttributeKey("EngineCapabilities");

    public static final AttributeKey getENGINE_CAPABILITIES_KEY() {
        return ENGINE_CAPABILITIES_KEY;
    }

    static {
        Set of;
        of = SetsKt__SetsJVMKt.setOf(HttpTimeout.Plugin);
        DEFAULT_CAPABILITIES = of;
    }
}
