package org.fdroid.index.v2;

import ch.qos.logback.core.joran.action.Action;
import java.util.List;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
/* compiled from: PackageV2.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"org/fdroid/index/v2/ManifestV2.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lorg/fdroid/index/v2/ManifestV2;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", Action.VALUE_ATTRIBUTE, "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ManifestV2$$serializer implements GeneratedSerializer {
    public static final ManifestV2$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    private ManifestV2$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ManifestV2$$serializer manifestV2$$serializer = new ManifestV2$$serializer();
        INSTANCE = manifestV2$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("org.fdroid.index.v2.ManifestV2", manifestV2$$serializer, 12);
        pluginGeneratedSerialDescriptor.addElement("versionName", false);
        pluginGeneratedSerialDescriptor.addElement("versionCode", false);
        pluginGeneratedSerialDescriptor.addElement("usesSdk", true);
        pluginGeneratedSerialDescriptor.addElement("maxSdkVersion", true);
        pluginGeneratedSerialDescriptor.addElement("signer", true);
        pluginGeneratedSerialDescriptor.addElement("usesPermission", true);
        pluginGeneratedSerialDescriptor.addElement("usesPermissionSdk23", true);
        pluginGeneratedSerialDescriptor.addElement("nativecode", true);
        pluginGeneratedSerialDescriptor.addElement("features", true);
        pluginGeneratedSerialDescriptor.addElement("minSdkVersion", true);
        pluginGeneratedSerialDescriptor.addElement("featureNames", true);
        pluginGeneratedSerialDescriptor.addElement("targetSdkVersion", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] childSerializers() {
        KSerializer[] kSerializerArr;
        kSerializerArr = ManifestV2.$childSerializers;
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        return new KSerializer[]{StringSerializer.INSTANCE, LongSerializer.INSTANCE, BuiltinSerializersKt.getNullable(UsesSdkV2$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(intSerializer), BuiltinSerializersKt.getNullable(SignerV2$$serializer.INSTANCE), kSerializerArr[5], kSerializerArr[6], kSerializerArr[7], kSerializerArr[8], BuiltinSerializersKt.getNullable(intSerializer), kSerializerArr[10], BuiltinSerializersKt.getNullable(intSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public ManifestV2 deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int i;
        UsesSdkV2 usesSdkV2;
        List list;
        List list2;
        List list3;
        Integer num;
        Integer num2;
        List list4;
        Integer num3;
        List list5;
        SignerV2 signerV2;
        long j;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        kSerializerArr = ManifestV2.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(descriptor2, 0);
            long decodeLongElement = beginStructure.decodeLongElement(descriptor2, 1);
            IntSerializer intSerializer = IntSerializer.INSTANCE;
            list4 = (List) beginStructure.decodeSerializableElement(descriptor2, 10, kSerializerArr[10], null);
            num2 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 11, intSerializer, null);
            i = 4095;
            signerV2 = (SignerV2) beginStructure.decodeNullableSerializableElement(descriptor2, 4, SignerV2$$serializer.INSTANCE, null);
            num = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 3, intSerializer, null);
            list5 = (List) beginStructure.decodeSerializableElement(descriptor2, 5, kSerializerArr[5], null);
            usesSdkV2 = (UsesSdkV2) beginStructure.decodeNullableSerializableElement(descriptor2, 2, UsesSdkV2$$serializer.INSTANCE, null);
            list = (List) beginStructure.decodeSerializableElement(descriptor2, 7, kSerializerArr[7], null);
            list3 = (List) beginStructure.decodeSerializableElement(descriptor2, 6, kSerializerArr[6], null);
            list2 = (List) beginStructure.decodeSerializableElement(descriptor2, 8, kSerializerArr[8], null);
            num3 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 9, intSerializer, null);
            j = decodeLongElement;
            str = decodeStringElement;
        } else {
            String str3 = null;
            UsesSdkV2 usesSdkV22 = null;
            List list6 = null;
            List list7 = null;
            List list8 = null;
            Integer num4 = null;
            Integer num5 = null;
            List list9 = null;
            Integer num6 = null;
            boolean z = true;
            long j2 = 0;
            List list10 = null;
            int i2 = 0;
            SignerV2 signerV22 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        str2 = str3;
                        z = false;
                        str3 = str2;
                        break;
                    case 0:
                        i2 |= 1;
                        str3 = beginStructure.decodeStringElement(descriptor2, 0);
                        break;
                    case 1:
                        str2 = str3;
                        j2 = beginStructure.decodeLongElement(descriptor2, 1);
                        i2 |= 2;
                        str3 = str2;
                        break;
                    case 2:
                        str2 = str3;
                        usesSdkV22 = (UsesSdkV2) beginStructure.decodeNullableSerializableElement(descriptor2, 2, UsesSdkV2$$serializer.INSTANCE, usesSdkV22);
                        i2 |= 4;
                        str3 = str2;
                        break;
                    case 3:
                        str2 = str3;
                        num4 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 3, IntSerializer.INSTANCE, num4);
                        i2 |= 8;
                        str3 = str2;
                        break;
                    case 4:
                        str2 = str3;
                        signerV22 = (SignerV2) beginStructure.decodeNullableSerializableElement(descriptor2, 4, SignerV2$$serializer.INSTANCE, signerV22);
                        i2 |= 16;
                        str3 = str2;
                        break;
                    case 5:
                        str2 = str3;
                        list10 = (List) beginStructure.decodeSerializableElement(descriptor2, 5, kSerializerArr[5], list10);
                        i2 |= 32;
                        str3 = str2;
                        break;
                    case 6:
                        str2 = str3;
                        list8 = (List) beginStructure.decodeSerializableElement(descriptor2, 6, kSerializerArr[6], list8);
                        i2 |= 64;
                        str3 = str2;
                        break;
                    case 7:
                        str2 = str3;
                        list6 = (List) beginStructure.decodeSerializableElement(descriptor2, 7, kSerializerArr[7], list6);
                        i2 |= 128;
                        str3 = str2;
                        break;
                    case 8:
                        list7 = (List) beginStructure.decodeSerializableElement(descriptor2, 8, kSerializerArr[8], list7);
                        i2 |= 256;
                        str3 = str3;
                        continue;
                    case 9:
                        str2 = str3;
                        num6 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 9, IntSerializer.INSTANCE, num6);
                        i2 |= 512;
                        str3 = str2;
                        break;
                    case 10:
                        str2 = str3;
                        list9 = (List) beginStructure.decodeSerializableElement(descriptor2, 10, kSerializerArr[10], list9);
                        i2 |= 1024;
                        str3 = str2;
                        break;
                    case 11:
                        str2 = str3;
                        num5 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 11, IntSerializer.INSTANCE, num5);
                        i2 |= 2048;
                        str3 = str2;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i = i2;
            usesSdkV2 = usesSdkV22;
            list = list6;
            list2 = list7;
            list3 = list8;
            num = num4;
            num2 = num5;
            list4 = list9;
            num3 = num6;
            list5 = list10;
            signerV2 = signerV22;
            j = j2;
            str = str3;
        }
        beginStructure.endStructure(descriptor2);
        return new ManifestV2(i, str, j, usesSdkV2, num, signerV2, list5, list3, list, list2, num3, list4, num2, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ManifestV2 value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        ManifestV2.write$Self$index_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
