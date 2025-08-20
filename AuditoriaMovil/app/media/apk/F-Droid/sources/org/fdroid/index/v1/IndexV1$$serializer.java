package org.fdroid.index.v1;

import ch.qos.logback.core.joran.action.Action;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
/* compiled from: IndexV1.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"org/fdroid/index/v1/IndexV1.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lorg/fdroid/index/v1/IndexV1;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", Action.VALUE_ATTRIBUTE, "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class IndexV1$$serializer implements GeneratedSerializer {
    public static final IndexV1$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    private IndexV1$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        IndexV1$$serializer indexV1$$serializer = new IndexV1$$serializer();
        INSTANCE = indexV1$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("org.fdroid.index.v1.IndexV1", indexV1$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("repo", false);
        pluginGeneratedSerialDescriptor.addElement("requests", true);
        pluginGeneratedSerialDescriptor.addElement("apps", true);
        pluginGeneratedSerialDescriptor.addElement("packages", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] childSerializers() {
        KSerializer[] kSerializerArr;
        kSerializerArr = IndexV1.$childSerializers;
        return new KSerializer[]{RepoV1$$serializer.INSTANCE, Requests$$serializer.INSTANCE, kSerializerArr[2], kSerializerArr[3]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public IndexV1 deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int i;
        RepoV1 repoV1;
        Requests requests;
        List list;
        Map map;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        kSerializerArr = IndexV1.$childSerializers;
        RepoV1 repoV12 = null;
        if (beginStructure.decodeSequentially()) {
            map = (Map) beginStructure.decodeSerializableElement(descriptor2, 3, kSerializerArr[3], null);
            repoV1 = (RepoV1) beginStructure.decodeSerializableElement(descriptor2, 0, RepoV1$$serializer.INSTANCE, null);
            i = 15;
            list = (List) beginStructure.decodeSerializableElement(descriptor2, 2, kSerializerArr[2], null);
            requests = (Requests) beginStructure.decodeSerializableElement(descriptor2, 1, Requests$$serializer.INSTANCE, null);
        } else {
            boolean z = true;
            int i2 = 0;
            Requests requests2 = null;
            List list2 = null;
            Map map2 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                if (decodeElementIndex == -1) {
                    z = false;
                } else if (decodeElementIndex == 0) {
                    repoV12 = (RepoV1) beginStructure.decodeSerializableElement(descriptor2, 0, RepoV1$$serializer.INSTANCE, repoV12);
                    i2 |= 1;
                } else if (decodeElementIndex == 1) {
                    requests2 = (Requests) beginStructure.decodeSerializableElement(descriptor2, 1, Requests$$serializer.INSTANCE, requests2);
                    i2 |= 2;
                } else if (decodeElementIndex == 2) {
                    list2 = (List) beginStructure.decodeSerializableElement(descriptor2, 2, kSerializerArr[2], list2);
                    i2 |= 4;
                } else if (decodeElementIndex != 3) {
                    throw new UnknownFieldException(decodeElementIndex);
                } else {
                    map2 = (Map) beginStructure.decodeSerializableElement(descriptor2, 3, kSerializerArr[3], map2);
                    i2 |= 8;
                }
            }
            i = i2;
            repoV1 = repoV12;
            requests = requests2;
            list = list2;
            map = map2;
        }
        beginStructure.endStructure(descriptor2);
        return new IndexV1(i, repoV1, requests, list, map, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, IndexV1 value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        IndexV1.write$Self$index_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
