package org.fdroid.index.v2;

import ch.qos.logback.core.joran.action.Action;
import java.util.List;
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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
/* compiled from: IndexV2.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"org/fdroid/index/v2/RepoV2.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lorg/fdroid/index/v2/RepoV2;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", Action.VALUE_ATTRIBUTE, "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RepoV2$$serializer implements GeneratedSerializer {
    public static final RepoV2$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    private RepoV2$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        RepoV2$$serializer repoV2$$serializer = new RepoV2$$serializer();
        INSTANCE = repoV2$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("org.fdroid.index.v2.RepoV2", repoV2$$serializer, 10);
        pluginGeneratedSerialDescriptor.addElement("name", true);
        pluginGeneratedSerialDescriptor.addElement("icon", true);
        pluginGeneratedSerialDescriptor.addElement("address", false);
        pluginGeneratedSerialDescriptor.addElement("webBaseUrl", true);
        pluginGeneratedSerialDescriptor.addElement("description", true);
        pluginGeneratedSerialDescriptor.addElement("mirrors", true);
        pluginGeneratedSerialDescriptor.addElement("timestamp", false);
        pluginGeneratedSerialDescriptor.addElement("antiFeatures", true);
        pluginGeneratedSerialDescriptor.addElement("categories", true);
        pluginGeneratedSerialDescriptor.addElement("releaseChannels", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] childSerializers() {
        KSerializer[] kSerializerArr;
        kSerializerArr = RepoV2.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{kSerializerArr[0], kSerializerArr[1], stringSerializer, BuiltinSerializersKt.getNullable(stringSerializer), kSerializerArr[4], kSerializerArr[5], LongSerializer.INSTANCE, kSerializerArr[7], kSerializerArr[8], kSerializerArr[9]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public RepoV2 deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int i;
        Map map;
        List list;
        Map map2;
        Map map3;
        Map map4;
        String str;
        Map map5;
        Map map6;
        String str2;
        long j;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        kSerializerArr = RepoV2.$childSerializers;
        int i2 = 9;
        Map map7 = null;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(descriptor2, 2);
            long decodeLongElement = beginStructure.decodeLongElement(descriptor2, 6);
            map2 = (Map) beginStructure.decodeSerializableElement(descriptor2, 9, kSerializerArr[9], null);
            map5 = (Map) beginStructure.decodeSerializableElement(descriptor2, 0, kSerializerArr[0], null);
            map = (Map) beginStructure.decodeSerializableElement(descriptor2, 7, kSerializerArr[7], null);
            str = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, null);
            str2 = decodeStringElement;
            i = 1023;
            map3 = (Map) beginStructure.decodeSerializableElement(descriptor2, 8, kSerializerArr[8], null);
            list = (List) beginStructure.decodeSerializableElement(descriptor2, 5, kSerializerArr[5], null);
            map4 = (Map) beginStructure.decodeSerializableElement(descriptor2, 4, kSerializerArr[4], null);
            map6 = (Map) beginStructure.decodeSerializableElement(descriptor2, 1, kSerializerArr[1], null);
            j = decodeLongElement;
        } else {
            boolean z = true;
            int i3 = 0;
            Map map8 = null;
            List list2 = null;
            Map map9 = null;
            Map map10 = null;
            Map map11 = null;
            String str3 = null;
            long j2 = 0;
            Map map12 = null;
            String str4 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 9;
                        break;
                    case 0:
                        map7 = (Map) beginStructure.decodeSerializableElement(descriptor2, 0, kSerializerArr[0], map7);
                        i3 |= 1;
                        i2 = 9;
                        break;
                    case 1:
                        map12 = (Map) beginStructure.decodeSerializableElement(descriptor2, 1, kSerializerArr[1], map12);
                        i3 |= 2;
                        i2 = 9;
                        break;
                    case 2:
                        str4 = beginStructure.decodeStringElement(descriptor2, 2);
                        i3 |= 4;
                        i2 = 9;
                        break;
                    case 3:
                        str3 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, str3);
                        i3 |= 8;
                        i2 = 9;
                        break;
                    case 4:
                        map11 = (Map) beginStructure.decodeSerializableElement(descriptor2, 4, kSerializerArr[4], map11);
                        i3 |= 16;
                        i2 = 9;
                        break;
                    case 5:
                        list2 = (List) beginStructure.decodeSerializableElement(descriptor2, 5, kSerializerArr[5], list2);
                        i3 |= 32;
                        i2 = 9;
                        break;
                    case 6:
                        j2 = beginStructure.decodeLongElement(descriptor2, 6);
                        i3 |= 64;
                        break;
                    case 7:
                        map8 = (Map) beginStructure.decodeSerializableElement(descriptor2, 7, kSerializerArr[7], map8);
                        i3 |= 128;
                        break;
                    case 8:
                        map10 = (Map) beginStructure.decodeSerializableElement(descriptor2, 8, kSerializerArr[8], map10);
                        i3 |= 256;
                        break;
                    case 9:
                        map9 = (Map) beginStructure.decodeSerializableElement(descriptor2, i2, kSerializerArr[i2], map9);
                        i3 |= 512;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i = i3;
            map = map8;
            list = list2;
            map2 = map9;
            map3 = map10;
            map4 = map11;
            str = str3;
            map5 = map7;
            map6 = map12;
            str2 = str4;
            j = j2;
        }
        beginStructure.endStructure(descriptor2);
        return new RepoV2(i, map5, map6, str2, str, map4, list, j, map, map3, map2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, RepoV2 value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        RepoV2.write$Self$index_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
