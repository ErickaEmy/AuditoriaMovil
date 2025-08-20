package kotlinx.serialization.modules;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
/* compiled from: SerializersModule.kt */
/* loaded from: classes2.dex */
public abstract class SerializersModule {
    private SerializersModule() {
    }

    public /* synthetic */ SerializersModule(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract void dumpTo(SerializersModuleCollector serializersModuleCollector);

    public abstract KSerializer getContextual(KClass kClass, List list);

    public abstract DeserializationStrategy getPolymorphic(KClass kClass, String str);

    public abstract SerializationStrategy getPolymorphic(KClass kClass, Object obj);

    public static /* synthetic */ KSerializer getContextual$default(SerializersModule serializersModule, KClass kClass, List list, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            return serializersModule.getContextual(kClass, list);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContextual");
    }
}
