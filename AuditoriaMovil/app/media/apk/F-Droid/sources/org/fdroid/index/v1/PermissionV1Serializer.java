package org.fdroid.index.v1;

import ch.qos.logback.core.joran.action.Action;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElementKt;
/* compiled from: PackageV1.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lorg/fdroid/index/v1/PermissionV1Serializer;", "Lkotlinx/serialization/KSerializer;", "Lorg/fdroid/index/v1/PermissionV1;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", Action.VALUE_ATTRIBUTE, "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PermissionV1Serializer implements KSerializer {
    private final SerialDescriptor descriptor = SerialDescriptorsKt.buildClassSerialDescriptor("PermissionV1", new SerialDescriptor[0], new Function1() { // from class: org.fdroid.index.v1.PermissionV1Serializer$descriptor$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ClassSerialDescriptorBuilder) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
            List emptyList;
            List emptyList2;
            Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            KSerializer serializer = SerializersKt.serializer(Reflection.typeOf(String.class));
            Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            buildClassSerialDescriptor.element("name", serializer.getDescriptor(), emptyList, false);
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            KSerializer serializer2 = SerializersKt.serializer(Reflection.nullableTypeOf(Integer.class));
            Intrinsics.checkNotNull(serializer2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            buildClassSerialDescriptor.element("maxSdk", serializer2.getDescriptor(), emptyList2, false);
        }
    });

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PermissionV1 deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonDecoder jsonDecoder = decoder instanceof JsonDecoder ? (JsonDecoder) decoder : null;
        if (jsonDecoder == null) {
            throw new IllegalStateException("Can be deserialized only by JSON".toString());
        }
        JsonArray jsonArray = JsonElementKt.getJsonArray(jsonDecoder.decodeJsonElement());
        if (jsonArray.size() < 2) {
            throw new IllegalArgumentException("Invalid array: " + jsonArray);
        }
        return new PermissionV1(JsonElementKt.getJsonPrimitive(jsonArray.get(0)).getContent(), JsonElementKt.getIntOrNull(JsonElementKt.getJsonPrimitive(jsonArray.get(1))));
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PermissionV1 value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor = JsonArray.Companion.serializer().getDescriptor();
        CompositeEncoder beginCollection = encoder.beginCollection(descriptor, 2);
        beginCollection.encodeStringElement(getDescriptor(), 0, value.getName());
        beginCollection.encodeNullableSerializableElement(getDescriptor(), 1, BuiltinSerializersKt.serializer(IntCompanionObject.INSTANCE), value.getMaxSdk());
        beginCollection.endStructure(descriptor);
    }
}
