package kotlinx.serialization.internal;

import kotlinx.serialization.KSerializer;
/* compiled from: PluginHelperInterfaces.kt */
/* loaded from: classes2.dex */
public interface GeneratedSerializer extends KSerializer {
    KSerializer[] childSerializers();

    KSerializer[] typeParametersSerializers();

    /* compiled from: PluginHelperInterfaces.kt */
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static KSerializer[] typeParametersSerializers(GeneratedSerializer generatedSerializer) {
            return PluginHelperInterfacesKt.EMPTY_SERIALIZER_ARRAY;
        }
    }
}
