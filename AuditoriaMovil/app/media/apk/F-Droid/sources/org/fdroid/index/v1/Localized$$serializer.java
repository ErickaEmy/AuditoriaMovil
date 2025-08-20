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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.bouncycastle.asn1.cmp.PKIFailureInfo;
import org.bouncycastle.i18n.ErrorBundle;
/* compiled from: AppV1.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"org/fdroid/index/v1/Localized.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lorg/fdroid/index/v1/Localized;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", Action.VALUE_ATTRIBUTE, "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Localized$$serializer implements GeneratedSerializer {
    public static final Localized$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    private Localized$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Localized$$serializer localized$$serializer = new Localized$$serializer();
        INSTANCE = localized$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("org.fdroid.index.v1.Localized", localized$$serializer, 14);
        pluginGeneratedSerialDescriptor.addElement("description", true);
        pluginGeneratedSerialDescriptor.addElement("name", true);
        pluginGeneratedSerialDescriptor.addElement("icon", true);
        pluginGeneratedSerialDescriptor.addElement("whatsNew", true);
        pluginGeneratedSerialDescriptor.addElement("video", true);
        pluginGeneratedSerialDescriptor.addElement("phoneScreenshots", true);
        pluginGeneratedSerialDescriptor.addElement("sevenInchScreenshots", true);
        pluginGeneratedSerialDescriptor.addElement("tenInchScreenshots", true);
        pluginGeneratedSerialDescriptor.addElement("wearScreenshots", true);
        pluginGeneratedSerialDescriptor.addElement("tvScreenshots", true);
        pluginGeneratedSerialDescriptor.addElement("featureGraphic", true);
        pluginGeneratedSerialDescriptor.addElement("promoGraphic", true);
        pluginGeneratedSerialDescriptor.addElement("tvBanner", true);
        pluginGeneratedSerialDescriptor.addElement(ErrorBundle.SUMMARY_ENTRY, true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] childSerializers() {
        KSerializer[] kSerializerArr;
        kSerializerArr = Localized.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(kSerializerArr[5]), BuiltinSerializersKt.getNullable(kSerializerArr[6]), BuiltinSerializersKt.getNullable(kSerializerArr[7]), BuiltinSerializersKt.getNullable(kSerializerArr[8]), BuiltinSerializersKt.getNullable(kSerializerArr[9]), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Localized deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        String str;
        int i;
        String str2;
        String str3;
        List list;
        List list2;
        String str4;
        String str5;
        List list3;
        List list4;
        List list5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        KSerializer[] kSerializerArr2;
        String str11;
        String str12;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        kSerializerArr = Localized.$childSerializers;
        String str13 = null;
        if (beginStructure.decodeSequentially()) {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            List list6 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 9, kSerializerArr[9], null);
            String str14 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 12, stringSerializer, null);
            str3 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 13, stringSerializer, null);
            i = 16383;
            str7 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 1, stringSerializer, null);
            str = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 0, stringSerializer, null);
            list = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 5, kSerializerArr[5], null);
            str9 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 3, stringSerializer, null);
            str4 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 4, stringSerializer, null);
            str8 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 2, stringSerializer, null);
            str6 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 10, stringSerializer, null);
            list5 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 7, kSerializerArr[7], null);
            list2 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 6, kSerializerArr[6], null);
            list4 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 8, kSerializerArr[8], null);
            str5 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 11, stringSerializer, null);
            str2 = str14;
            list3 = list6;
        } else {
            boolean z = true;
            int i2 = 0;
            String str15 = null;
            String str16 = null;
            String str17 = null;
            List list7 = null;
            List list8 = null;
            String str18 = null;
            String str19 = null;
            List list9 = null;
            List list10 = null;
            List list11 = null;
            String str20 = null;
            String str21 = null;
            String str22 = null;
            while (z) {
                String str23 = str16;
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        kSerializerArr2 = kSerializerArr;
                        z = false;
                        str16 = str23;
                        kSerializerArr = kSerializerArr2;
                        break;
                    case 0:
                        kSerializerArr2 = kSerializerArr;
                        str11 = str15;
                        str12 = str23;
                        str21 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, str21);
                        i2 |= 1;
                        str22 = str22;
                        str16 = str12;
                        str15 = str11;
                        kSerializerArr = kSerializerArr2;
                        break;
                    case 1:
                        kSerializerArr2 = kSerializerArr;
                        str11 = str15;
                        str12 = str23;
                        str22 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, str22);
                        i2 |= 2;
                        str16 = str12;
                        str15 = str11;
                        kSerializerArr = kSerializerArr2;
                        break;
                    case 2:
                        kSerializerArr2 = kSerializerArr;
                        str11 = str15;
                        i2 |= 4;
                        str16 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, str23);
                        str15 = str11;
                        kSerializerArr = kSerializerArr2;
                        break;
                    case 3:
                        str15 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, str15);
                        i2 |= 8;
                        kSerializerArr = kSerializerArr;
                        str16 = str23;
                        break;
                    case 4:
                        str10 = str15;
                        str18 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, str18);
                        i2 |= 16;
                        str16 = str23;
                        str15 = str10;
                        break;
                    case 5:
                        str10 = str15;
                        list7 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 5, kSerializerArr[5], list7);
                        i2 |= 32;
                        str16 = str23;
                        str15 = str10;
                        break;
                    case 6:
                        str10 = str15;
                        list8 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 6, kSerializerArr[6], list8);
                        i2 |= 64;
                        str16 = str23;
                        str15 = str10;
                        break;
                    case 7:
                        str10 = str15;
                        list11 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 7, kSerializerArr[7], list11);
                        i2 |= 128;
                        str16 = str23;
                        str15 = str10;
                        break;
                    case 8:
                        str10 = str15;
                        list10 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 8, kSerializerArr[8], list10);
                        i2 |= 256;
                        str16 = str23;
                        str15 = str10;
                        break;
                    case 9:
                        str10 = str15;
                        list9 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 9, kSerializerArr[9], list9);
                        i2 |= 512;
                        str16 = str23;
                        str15 = str10;
                        break;
                    case 10:
                        str10 = str15;
                        str20 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 10, StringSerializer.INSTANCE, str20);
                        i2 |= 1024;
                        str16 = str23;
                        str15 = str10;
                        break;
                    case 11:
                        str10 = str15;
                        str19 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 11, StringSerializer.INSTANCE, str19);
                        i2 |= 2048;
                        str16 = str23;
                        str15 = str10;
                        break;
                    case 12:
                        str10 = str15;
                        str13 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 12, StringSerializer.INSTANCE, str13);
                        i2 |= PKIFailureInfo.certConfirmed;
                        str16 = str23;
                        str15 = str10;
                        break;
                    case 13:
                        str10 = str15;
                        str17 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 13, StringSerializer.INSTANCE, str17);
                        i2 |= 8192;
                        str16 = str23;
                        str15 = str10;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str = str21;
            i = i2;
            str2 = str13;
            str3 = str17;
            list = list7;
            list2 = list8;
            str4 = str18;
            str5 = str19;
            list3 = list9;
            list4 = list10;
            list5 = list11;
            str6 = str20;
            str7 = str22;
            str8 = str16;
            str9 = str15;
        }
        beginStructure.endStructure(descriptor2);
        return new Localized(i, str, str7, str8, str9, str4, list, list2, list5, list4, list3, str6, str5, str2, str3, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Localized value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        Localized.write$Self$index_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
