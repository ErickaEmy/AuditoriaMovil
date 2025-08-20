package org.fdroid.index.v2;

import ch.qos.logback.core.joran.action.Action;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
/* compiled from: PackageV2.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"org/fdroid/index/v2/Screenshots.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lorg/fdroid/index/v2/Screenshots;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", Action.VALUE_ATTRIBUTE, "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Screenshots$$serializer implements GeneratedSerializer {
    public static final Screenshots$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    private Screenshots$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Screenshots$$serializer screenshots$$serializer = new Screenshots$$serializer();
        INSTANCE = screenshots$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("org.fdroid.index.v2.Screenshots", screenshots$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("phone", true);
        pluginGeneratedSerialDescriptor.addElement("sevenInch", true);
        pluginGeneratedSerialDescriptor.addElement("tenInch", true);
        pluginGeneratedSerialDescriptor.addElement("wear", true);
        pluginGeneratedSerialDescriptor.addElement("tv", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] childSerializers() {
        KSerializer[] kSerializerArr;
        kSerializerArr = Screenshots.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(kSerializerArr[0]), BuiltinSerializersKt.getNullable(kSerializerArr[1]), BuiltinSerializersKt.getNullable(kSerializerArr[2]), BuiltinSerializersKt.getNullable(kSerializerArr[3]), BuiltinSerializersKt.getNullable(kSerializerArr[4])};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Screenshots deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int i;
        Map map;
        Map map2;
        Map map3;
        Map map4;
        Map map5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        kSerializerArr = Screenshots.$childSerializers;
        Map map6 = null;
        if (beginStructure.decodeSequentially()) {
            map5 = (Map) beginStructure.decodeNullableSerializableElement(descriptor2, 4, kSerializerArr[4], null);
            map = (Map) beginStructure.decodeNullableSerializableElement(descriptor2, 0, kSerializerArr[0], null);
            map4 = (Map) beginStructure.decodeNullableSerializableElement(descriptor2, 3, kSerializerArr[3], null);
            i = 31;
            map3 = (Map) beginStructure.decodeNullableSerializableElement(descriptor2, 2, kSerializerArr[2], null);
            map2 = (Map) beginStructure.decodeNullableSerializableElement(descriptor2, 1, kSerializerArr[1], null);
        } else {
            boolean z = true;
            int i2 = 0;
            Map map7 = null;
            Map map8 = null;
            Map map9 = null;
            Map map10 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                if (decodeElementIndex == -1) {
                    z = false;
                } else if (decodeElementIndex == 0) {
                    map6 = (Map) beginStructure.decodeNullableSerializableElement(descriptor2, 0, kSerializerArr[0], map6);
                    i2 |= 1;
                } else if (decodeElementIndex == 1) {
                    map7 = (Map) beginStructure.decodeNullableSerializableElement(descriptor2, 1, kSerializerArr[1], map7);
                    i2 |= 2;
                } else if (decodeElementIndex == 2) {
                    map8 = (Map) beginStructure.decodeNullableSerializableElement(descriptor2, 2, kSerializerArr[2], map8);
                    i2 |= 4;
                } else if (decodeElementIndex == 3) {
                    map9 = (Map) beginStructure.decodeNullableSerializableElement(descriptor2, 3, kSerializerArr[3], map9);
                    i2 |= 8;
                } else if (decodeElementIndex != 4) {
                    throw new UnknownFieldException(decodeElementIndex);
                } else {
                    map10 = (Map) beginStructure.decodeNullableSerializableElement(descriptor2, 4, kSerializerArr[4], map10);
                    i2 |= 16;
                }
            }
            i = i2;
            map = map6;
            map2 = map7;
            map3 = map8;
            map4 = map9;
            map5 = map10;
        }
        beginStructure.endStructure(descriptor2);
        return new Screenshots(i, map, map2, map3, map4, map5, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Screenshots value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        Screenshots.write$Self$index_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
