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
/* compiled from: PackageV2.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"org/fdroid/index/v2/PackageVersionV2.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lorg/fdroid/index/v2/PackageVersionV2;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", Action.VALUE_ATTRIBUTE, "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PackageVersionV2$$serializer implements GeneratedSerializer {
    public static final PackageVersionV2$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    private PackageVersionV2$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        PackageVersionV2$$serializer packageVersionV2$$serializer = new PackageVersionV2$$serializer();
        INSTANCE = packageVersionV2$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("org.fdroid.index.v2.PackageVersionV2", packageVersionV2$$serializer, 10);
        pluginGeneratedSerialDescriptor.addElement("added", false);
        pluginGeneratedSerialDescriptor.addElement(Action.FILE_ATTRIBUTE, false);
        pluginGeneratedSerialDescriptor.addElement("src", true);
        pluginGeneratedSerialDescriptor.addElement("manifest", false);
        pluginGeneratedSerialDescriptor.addElement("releaseChannels", true);
        pluginGeneratedSerialDescriptor.addElement("antiFeatures", true);
        pluginGeneratedSerialDescriptor.addElement("whatsNew", true);
        pluginGeneratedSerialDescriptor.addElement("versionCode", true);
        pluginGeneratedSerialDescriptor.addElement("signer", true);
        pluginGeneratedSerialDescriptor.addElement("packageManifest", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] childSerializers() {
        KSerializer[] kSerializerArr;
        kSerializerArr = PackageVersionV2.$childSerializers;
        LongSerializer longSerializer = LongSerializer.INSTANCE;
        return new KSerializer[]{longSerializer, FileV1$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(FileV2$$serializer.INSTANCE), ManifestV2$$serializer.INSTANCE, kSerializerArr[4], kSerializerArr[5], kSerializerArr[6], longSerializer, BuiltinSerializersKt.getNullable(SignerV2$$serializer.INSTANCE), kSerializerArr[9]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PackageVersionV2 deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int i;
        Map map;
        List list;
        PackageManifest packageManifest;
        SignerV2 signerV2;
        Map map2;
        ManifestV2 manifestV2;
        FileV2 fileV2;
        FileV1 fileV1;
        long j;
        long j2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        kSerializerArr = PackageVersionV2.$childSerializers;
        int i2 = 8;
        FileV1 fileV12 = null;
        if (beginStructure.decodeSequentially()) {
            long decodeLongElement = beginStructure.decodeLongElement(descriptor2, 0);
            long decodeLongElement2 = beginStructure.decodeLongElement(descriptor2, 7);
            packageManifest = (PackageManifest) beginStructure.decodeSerializableElement(descriptor2, 9, kSerializerArr[9], null);
            fileV1 = (FileV1) beginStructure.decodeSerializableElement(descriptor2, 1, FileV1$$serializer.INSTANCE, null);
            signerV2 = (SignerV2) beginStructure.decodeNullableSerializableElement(descriptor2, 8, SignerV2$$serializer.INSTANCE, null);
            manifestV2 = (ManifestV2) beginStructure.decodeSerializableElement(descriptor2, 3, ManifestV2$$serializer.INSTANCE, null);
            i = 1023;
            fileV2 = (FileV2) beginStructure.decodeNullableSerializableElement(descriptor2, 2, FileV2$$serializer.INSTANCE, null);
            map2 = (Map) beginStructure.decodeSerializableElement(descriptor2, 6, kSerializerArr[6], null);
            map = (Map) beginStructure.decodeSerializableElement(descriptor2, 5, kSerializerArr[5], null);
            list = (List) beginStructure.decodeSerializableElement(descriptor2, 4, kSerializerArr[4], null);
            j = decodeLongElement2;
            j2 = decodeLongElement;
        } else {
            long j3 = 0;
            boolean z = true;
            int i3 = 0;
            Map map3 = null;
            List list2 = null;
            PackageManifest packageManifest2 = null;
            SignerV2 signerV22 = null;
            Map map4 = null;
            ManifestV2 manifestV22 = null;
            FileV2 fileV22 = null;
            long j4 = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 8;
                        break;
                    case 0:
                        j4 = beginStructure.decodeLongElement(descriptor2, 0);
                        i3 |= 1;
                        i2 = 8;
                        break;
                    case 1:
                        fileV12 = (FileV1) beginStructure.decodeSerializableElement(descriptor2, 1, FileV1$$serializer.INSTANCE, fileV12);
                        i3 |= 2;
                        i2 = 8;
                        break;
                    case 2:
                        fileV22 = (FileV2) beginStructure.decodeNullableSerializableElement(descriptor2, 2, FileV2$$serializer.INSTANCE, fileV22);
                        i3 |= 4;
                        i2 = 8;
                        break;
                    case 3:
                        manifestV22 = (ManifestV2) beginStructure.decodeSerializableElement(descriptor2, 3, ManifestV2$$serializer.INSTANCE, manifestV22);
                        i3 |= 8;
                        i2 = 8;
                        break;
                    case 4:
                        list2 = (List) beginStructure.decodeSerializableElement(descriptor2, 4, kSerializerArr[4], list2);
                        i3 |= 16;
                        i2 = 8;
                        break;
                    case 5:
                        map3 = (Map) beginStructure.decodeSerializableElement(descriptor2, 5, kSerializerArr[5], map3);
                        i3 |= 32;
                        i2 = 8;
                        break;
                    case 6:
                        map4 = (Map) beginStructure.decodeSerializableElement(descriptor2, 6, kSerializerArr[6], map4);
                        i3 |= 64;
                        i2 = 8;
                        break;
                    case 7:
                        j3 = beginStructure.decodeLongElement(descriptor2, 7);
                        i3 |= 128;
                        break;
                    case 8:
                        signerV22 = (SignerV2) beginStructure.decodeNullableSerializableElement(descriptor2, i2, SignerV2$$serializer.INSTANCE, signerV22);
                        i3 |= 256;
                        break;
                    case 9:
                        packageManifest2 = (PackageManifest) beginStructure.decodeSerializableElement(descriptor2, 9, kSerializerArr[9], packageManifest2);
                        i3 |= 512;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i = i3;
            map = map3;
            list = list2;
            packageManifest = packageManifest2;
            signerV2 = signerV22;
            map2 = map4;
            manifestV2 = manifestV22;
            fileV2 = fileV22;
            fileV1 = fileV12;
            j = j3;
            j2 = j4;
        }
        beginStructure.endStructure(descriptor2);
        return new PackageVersionV2(i, j2, fileV1, fileV2, manifestV2, list, map, map2, j, signerV2, packageManifest, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PackageVersionV2 value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        PackageVersionV2.write$Self$index_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
