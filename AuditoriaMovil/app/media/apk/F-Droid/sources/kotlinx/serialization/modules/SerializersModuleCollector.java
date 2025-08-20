package kotlinx.serialization.modules;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
/* compiled from: SerializersModuleCollector.kt */
/* loaded from: classes2.dex */
public interface SerializersModuleCollector {
    void polymorphic(KClass kClass, KClass kClass2, KSerializer kSerializer);

    void polymorphicDefaultDeserializer(KClass kClass, Function1 function1);

    void polymorphicDefaultSerializer(KClass kClass, Function1 function1);
}
