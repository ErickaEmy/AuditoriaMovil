package kotlinx.serialization.json;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
/* compiled from: JsonElementSerializers.kt */
/* loaded from: classes2.dex */
public final class JsonElementSerializer implements KSerializer {
    public static final JsonElementSerializer INSTANCE = new JsonElementSerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.buildSerialDescriptor("kotlinx.serialization.json.JsonElement", PolymorphicKind.SEALED.INSTANCE, new SerialDescriptor[0], new Function1() { // from class: kotlinx.serialization.json.JsonElementSerializer$descriptor$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ClassSerialDescriptorBuilder) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(ClassSerialDescriptorBuilder buildSerialDescriptor) {
            SerialDescriptor defer;
            SerialDescriptor defer2;
            SerialDescriptor defer3;
            SerialDescriptor defer4;
            SerialDescriptor defer5;
            Intrinsics.checkNotNullParameter(buildSerialDescriptor, "$this$buildSerialDescriptor");
            defer = JsonElementSerializersKt.defer(new Function0() { // from class: kotlinx.serialization.json.JsonElementSerializer$descriptor$1.1
                @Override // kotlin.jvm.functions.Function0
                public final SerialDescriptor invoke() {
                    return JsonPrimitiveSerializer.INSTANCE.getDescriptor();
                }
            });
            ClassSerialDescriptorBuilder.element$default(buildSerialDescriptor, "JsonPrimitive", defer, null, false, 12, null);
            defer2 = JsonElementSerializersKt.defer(new Function0() { // from class: kotlinx.serialization.json.JsonElementSerializer$descriptor$1.2
                @Override // kotlin.jvm.functions.Function0
                public final SerialDescriptor invoke() {
                    return JsonNullSerializer.INSTANCE.getDescriptor();
                }
            });
            ClassSerialDescriptorBuilder.element$default(buildSerialDescriptor, "JsonNull", defer2, null, false, 12, null);
            defer3 = JsonElementSerializersKt.defer(new Function0() { // from class: kotlinx.serialization.json.JsonElementSerializer$descriptor$1.3
                @Override // kotlin.jvm.functions.Function0
                public final SerialDescriptor invoke() {
                    return JsonLiteralSerializer.INSTANCE.getDescriptor();
                }
            });
            ClassSerialDescriptorBuilder.element$default(buildSerialDescriptor, "JsonLiteral", defer3, null, false, 12, null);
            defer4 = JsonElementSerializersKt.defer(new Function0() { // from class: kotlinx.serialization.json.JsonElementSerializer$descriptor$1.4
                @Override // kotlin.jvm.functions.Function0
                public final SerialDescriptor invoke() {
                    return JsonObjectSerializer.INSTANCE.getDescriptor();
                }
            });
            ClassSerialDescriptorBuilder.element$default(buildSerialDescriptor, "JsonObject", defer4, null, false, 12, null);
            defer5 = JsonElementSerializersKt.defer(new Function0() { // from class: kotlinx.serialization.json.JsonElementSerializer$descriptor$1.5
                @Override // kotlin.jvm.functions.Function0
                public final SerialDescriptor invoke() {
                    return JsonArraySerializer.INSTANCE.getDescriptor();
                }
            });
            ClassSerialDescriptorBuilder.element$default(buildSerialDescriptor, "JsonArray", defer5, null, false, 12, null);
        }
    });

    private JsonElementSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, JsonElement value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        JsonElementSerializersKt.verify(encoder);
        if (value instanceof JsonPrimitive) {
            encoder.encodeSerializableValue(JsonPrimitiveSerializer.INSTANCE, value);
        } else if (value instanceof JsonObject) {
            encoder.encodeSerializableValue(JsonObjectSerializer.INSTANCE, value);
        } else if (value instanceof JsonArray) {
            encoder.encodeSerializableValue(JsonArraySerializer.INSTANCE, value);
        }
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public JsonElement deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return JsonElementSerializersKt.asJsonDecoder(decoder).decodeJsonElement();
    }
}
