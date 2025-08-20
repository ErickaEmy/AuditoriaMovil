package org.fdroid.index.v1;

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
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.bouncycastle.asn1.cmp.PKIFailureInfo;
/* compiled from: PackageV1.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"org/fdroid/index/v1/PackageV1.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lorg/fdroid/index/v1/PackageV1;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", Action.VALUE_ATTRIBUTE, "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PackageV1$$serializer implements GeneratedSerializer {
    public static final PackageV1$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    private PackageV1$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        PackageV1$$serializer packageV1$$serializer = new PackageV1$$serializer();
        INSTANCE = packageV1$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("org.fdroid.index.v1.PackageV1", packageV1$$serializer, 19);
        pluginGeneratedSerialDescriptor.addElement("added", true);
        pluginGeneratedSerialDescriptor.addElement("apkName", false);
        pluginGeneratedSerialDescriptor.addElement("hash", false);
        pluginGeneratedSerialDescriptor.addElement("hashType", false);
        pluginGeneratedSerialDescriptor.addElement("minSdkVersion", true);
        pluginGeneratedSerialDescriptor.addElement("maxSdkVersion", true);
        pluginGeneratedSerialDescriptor.addElement("targetSdkVersion", true);
        pluginGeneratedSerialDescriptor.addElement("packageName", false);
        pluginGeneratedSerialDescriptor.addElement("sig", true);
        pluginGeneratedSerialDescriptor.addElement("signer", true);
        pluginGeneratedSerialDescriptor.addElement("size", false);
        pluginGeneratedSerialDescriptor.addElement("srcname", true);
        pluginGeneratedSerialDescriptor.addElement("uses-permission", true);
        pluginGeneratedSerialDescriptor.addElement("uses-permission-sdk-23", true);
        pluginGeneratedSerialDescriptor.addElement("versionCode", true);
        pluginGeneratedSerialDescriptor.addElement("versionName", false);
        pluginGeneratedSerialDescriptor.addElement("nativecode", true);
        pluginGeneratedSerialDescriptor.addElement("features", true);
        pluginGeneratedSerialDescriptor.addElement("antiFeatures", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] childSerializers() {
        KSerializer[] kSerializerArr;
        kSerializerArr = PackageV1.$childSerializers;
        LongSerializer longSerializer = LongSerializer.INSTANCE;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(longSerializer), stringSerializer, stringSerializer, stringSerializer, BuiltinSerializersKt.getNullable(intSerializer), BuiltinSerializersKt.getNullable(intSerializer), BuiltinSerializersKt.getNullable(intSerializer), stringSerializer, BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), longSerializer, BuiltinSerializersKt.getNullable(stringSerializer), kSerializerArr[12], kSerializerArr[13], BuiltinSerializersKt.getNullable(longSerializer), stringSerializer, BuiltinSerializersKt.getNullable(kSerializerArr[16]), BuiltinSerializersKt.getNullable(kSerializerArr[17]), BuiltinSerializersKt.getNullable(kSerializerArr[18])};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PackageV1 deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        Long l;
        int i;
        List list;
        List list2;
        List list3;
        List list4;
        List list5;
        String str;
        String str2;
        Long l2;
        String str3;
        Integer num;
        String str4;
        String str5;
        Integer num2;
        String str6;
        Integer num3;
        String str7;
        String str8;
        long j;
        Integer num4;
        int i2;
        Integer num5;
        KSerializer[] kSerializerArr2;
        Integer num6;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        kSerializerArr = PackageV1.$childSerializers;
        List list6 = null;
        if (beginStructure.decodeSequentially()) {
            LongSerializer longSerializer = LongSerializer.INSTANCE;
            String decodeStringElement = beginStructure.decodeStringElement(descriptor2, 1);
            String decodeStringElement2 = beginStructure.decodeStringElement(descriptor2, 2);
            String decodeStringElement3 = beginStructure.decodeStringElement(descriptor2, 3);
            IntSerializer intSerializer = IntSerializer.INSTANCE;
            String decodeStringElement4 = beginStructure.decodeStringElement(descriptor2, 7);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            long decodeLongElement = beginStructure.decodeLongElement(descriptor2, 10);
            String str9 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 11, stringSerializer, null);
            List list7 = (List) beginStructure.decodeSerializableElement(descriptor2, 12, kSerializerArr[12], null);
            List list8 = (List) beginStructure.decodeSerializableElement(descriptor2, 13, kSerializerArr[13], null);
            Long l3 = (Long) beginStructure.decodeNullableSerializableElement(descriptor2, 14, longSerializer, null);
            String decodeStringElement5 = beginStructure.decodeStringElement(descriptor2, 15);
            List list9 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 16, kSerializerArr[16], null);
            l2 = l3;
            list = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 18, kSerializerArr[18], null);
            list2 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 17, kSerializerArr[17], null);
            i = 524287;
            l = (Long) beginStructure.decodeNullableSerializableElement(descriptor2, 0, longSerializer, null);
            num = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 6, intSerializer, null);
            str3 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 9, stringSerializer, null);
            str6 = decodeStringElement4;
            str7 = decodeStringElement5;
            num3 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 5, intSerializer, null);
            str5 = decodeStringElement3;
            str2 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 8, stringSerializer, null);
            num2 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 4, intSerializer, null);
            str4 = decodeStringElement2;
            list3 = list9;
            list4 = list8;
            list5 = list7;
            str = str9;
            str8 = decodeStringElement;
            j = decodeLongElement;
        } else {
            boolean z = true;
            int i3 = 0;
            Integer num7 = null;
            Integer num8 = null;
            List list10 = null;
            List list11 = null;
            List list12 = null;
            List list13 = null;
            String str10 = null;
            String str11 = null;
            Long l4 = null;
            String str12 = null;
            Integer num9 = null;
            String str13 = null;
            String str14 = null;
            String str15 = null;
            Long l5 = null;
            long j2 = 0;
            String str16 = null;
            String str17 = null;
            while (z) {
                Integer num10 = num8;
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        kSerializerArr = kSerializerArr;
                        num8 = num10;
                        break;
                    case 0:
                        num5 = num7;
                        l5 = (Long) beginStructure.decodeNullableSerializableElement(descriptor2, 0, LongSerializer.INSTANCE, l5);
                        i3 |= 1;
                        kSerializerArr = kSerializerArr;
                        num8 = num10;
                        num7 = num5;
                        break;
                    case 1:
                        kSerializerArr2 = kSerializerArr;
                        num5 = num7;
                        num6 = num10;
                        str15 = beginStructure.decodeStringElement(descriptor2, 1);
                        i3 |= 2;
                        num8 = num6;
                        kSerializerArr = kSerializerArr2;
                        num7 = num5;
                        break;
                    case 2:
                        kSerializerArr2 = kSerializerArr;
                        num5 = num7;
                        num6 = num10;
                        str16 = beginStructure.decodeStringElement(descriptor2, 2);
                        i3 |= 4;
                        num8 = num6;
                        kSerializerArr = kSerializerArr2;
                        num7 = num5;
                        break;
                    case 3:
                        kSerializerArr2 = kSerializerArr;
                        num5 = num7;
                        num6 = num10;
                        str17 = beginStructure.decodeStringElement(descriptor2, 3);
                        i3 |= 8;
                        num8 = num6;
                        kSerializerArr = kSerializerArr2;
                        num7 = num5;
                        break;
                    case 4:
                        kSerializerArr2 = kSerializerArr;
                        num5 = num7;
                        num6 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 4, IntSerializer.INSTANCE, num10);
                        i3 |= 16;
                        num8 = num6;
                        kSerializerArr = kSerializerArr2;
                        num7 = num5;
                        break;
                    case 5:
                        num7 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 5, IntSerializer.INSTANCE, num7);
                        i3 |= 32;
                        kSerializerArr = kSerializerArr;
                        num8 = num10;
                        break;
                    case 6:
                        num4 = num7;
                        num9 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 6, IntSerializer.INSTANCE, num9);
                        i3 |= 64;
                        num7 = num4;
                        num8 = num10;
                        break;
                    case 7:
                        num4 = num7;
                        str13 = beginStructure.decodeStringElement(descriptor2, 7);
                        i3 |= 128;
                        num7 = num4;
                        num8 = num10;
                        break;
                    case 8:
                        num4 = num7;
                        str11 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 8, StringSerializer.INSTANCE, str11);
                        i3 |= 256;
                        num7 = num4;
                        num8 = num10;
                        break;
                    case 9:
                        num4 = num7;
                        str12 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 9, StringSerializer.INSTANCE, str12);
                        i3 |= 512;
                        num7 = num4;
                        num8 = num10;
                        break;
                    case 10:
                        num4 = num7;
                        j2 = beginStructure.decodeLongElement(descriptor2, 10);
                        i3 |= 1024;
                        num7 = num4;
                        num8 = num10;
                        break;
                    case 11:
                        num4 = num7;
                        str10 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 11, StringSerializer.INSTANCE, str10);
                        i3 |= 2048;
                        num7 = num4;
                        num8 = num10;
                        break;
                    case 12:
                        num4 = num7;
                        list13 = (List) beginStructure.decodeSerializableElement(descriptor2, 12, kSerializerArr[12], list13);
                        i3 |= PKIFailureInfo.certConfirmed;
                        num7 = num4;
                        num8 = num10;
                        break;
                    case 13:
                        num4 = num7;
                        list12 = (List) beginStructure.decodeSerializableElement(descriptor2, 13, kSerializerArr[13], list12);
                        i3 |= 8192;
                        num7 = num4;
                        num8 = num10;
                        break;
                    case 14:
                        num4 = num7;
                        l4 = (Long) beginStructure.decodeNullableSerializableElement(descriptor2, 14, LongSerializer.INSTANCE, l4);
                        i3 |= 16384;
                        num7 = num4;
                        num8 = num10;
                        break;
                    case 15:
                        num4 = num7;
                        str14 = beginStructure.decodeStringElement(descriptor2, 15);
                        i3 |= 32768;
                        num7 = num4;
                        num8 = num10;
                        break;
                    case 16:
                        num4 = num7;
                        list11 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 16, kSerializerArr[16], list11);
                        i2 = PKIFailureInfo.notAuthorized;
                        i3 |= i2;
                        num7 = num4;
                        num8 = num10;
                        break;
                    case 17:
                        num4 = num7;
                        list10 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 17, kSerializerArr[17], list10);
                        i3 |= PKIFailureInfo.unsupportedVersion;
                        num7 = num4;
                        num8 = num10;
                        break;
                    case 18:
                        num4 = num7;
                        list6 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 18, kSerializerArr[18], list6);
                        i2 = PKIFailureInfo.transactionIdInUse;
                        i3 |= i2;
                        num7 = num4;
                        num8 = num10;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            l = l5;
            i = i3;
            list = list6;
            list2 = list10;
            list3 = list11;
            list4 = list12;
            list5 = list13;
            str = str10;
            str2 = str11;
            l2 = l4;
            str3 = str12;
            num = num9;
            str4 = str16;
            str5 = str17;
            num2 = num8;
            str6 = str13;
            num3 = num7;
            str7 = str14;
            str8 = str15;
            j = j2;
        }
        beginStructure.endStructure(descriptor2);
        return new PackageV1(i, l, str8, str4, str5, num2, num3, num, str6, str2, str3, j, str, list5, list4, l2, str7, list3, list2, list, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PackageV1 value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        PackageV1.write$Self$index_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
