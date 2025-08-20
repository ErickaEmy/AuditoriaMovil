package org.fdroid.index.v1;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.bouncycastle.asn1.cmp.PKIFailureInfo;
import org.bouncycastle.i18n.ErrorBundle;
/* compiled from: AppV1.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 E2\u00020\u0001:\u0002DEBÃ\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016BË\u0001\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0017J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u00102\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bHÆ\u0003J\u0011\u00103\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bHÆ\u0003J\u0011\u00104\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bHÆ\u0003J\u0011\u00105\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bHÆ\u0003JÏ\u0001\u00106\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020\u0003HÖ\u0001J\t\u0010;\u001a\u00020\u0005HÖ\u0001J&\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u00002\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BHÁ\u0001¢\u0006\u0002\bCR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0019\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019¨\u0006F"}, d2 = {"Lorg/fdroid/index/v1/Localized;", "", "seen1", "", "description", "", "name", "icon", "whatsNew", "video", "phoneScreenshots", "", "sevenInchScreenshots", "tenInchScreenshots", "wearScreenshots", "tvScreenshots", "featureGraphic", "promoGraphic", "tvBanner", ErrorBundle.SUMMARY_ENTRY, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getFeatureGraphic", "getIcon", "getName", "getPhoneScreenshots", "()Ljava/util/List;", "getPromoGraphic", "getSevenInchScreenshots", "getSummary", "getTenInchScreenshots", "getTvBanner", "getTvScreenshots", "getVideo", "getWearScreenshots", "getWhatsNew", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$index_release", "$serializer", "Companion", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final class Localized {
    private static final KSerializer[] $childSerializers;
    public static final Companion Companion = new Companion(null);
    private final String description;
    private final String featureGraphic;
    private final String icon;
    private final String name;
    private final List<String> phoneScreenshots;
    private final String promoGraphic;
    private final List<String> sevenInchScreenshots;
    private final String summary;
    private final List<String> tenInchScreenshots;
    private final String tvBanner;
    private final List<String> tvScreenshots;
    private final String video;
    private final List<String> wearScreenshots;
    private final String whatsNew;

    public Localized() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (List) null, (List) null, (List) null, (List) null, (String) null, (String) null, (String) null, (String) null, 16383, (DefaultConstructorMarker) null);
    }

    public final String component1() {
        return this.description;
    }

    public final List<String> component10() {
        return this.tvScreenshots;
    }

    public final String component11() {
        return this.featureGraphic;
    }

    public final String component12() {
        return this.promoGraphic;
    }

    public final String component13() {
        return this.tvBanner;
    }

    public final String component14() {
        return this.summary;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.icon;
    }

    public final String component4() {
        return this.whatsNew;
    }

    public final String component5() {
        return this.video;
    }

    public final List<String> component6() {
        return this.phoneScreenshots;
    }

    public final List<String> component7() {
        return this.sevenInchScreenshots;
    }

    public final List<String> component8() {
        return this.tenInchScreenshots;
    }

    public final List<String> component9() {
        return this.wearScreenshots;
    }

    public final Localized copy(String str, String str2, String str3, String str4, String str5, List<String> list, List<String> list2, List<String> list3, List<String> list4, List<String> list5, String str6, String str7, String str8, String str9) {
        return new Localized(str, str2, str3, str4, str5, list, list2, list3, list4, list5, str6, str7, str8, str9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Localized) {
            Localized localized = (Localized) obj;
            return Intrinsics.areEqual(this.description, localized.description) && Intrinsics.areEqual(this.name, localized.name) && Intrinsics.areEqual(this.icon, localized.icon) && Intrinsics.areEqual(this.whatsNew, localized.whatsNew) && Intrinsics.areEqual(this.video, localized.video) && Intrinsics.areEqual(this.phoneScreenshots, localized.phoneScreenshots) && Intrinsics.areEqual(this.sevenInchScreenshots, localized.sevenInchScreenshots) && Intrinsics.areEqual(this.tenInchScreenshots, localized.tenInchScreenshots) && Intrinsics.areEqual(this.wearScreenshots, localized.wearScreenshots) && Intrinsics.areEqual(this.tvScreenshots, localized.tvScreenshots) && Intrinsics.areEqual(this.featureGraphic, localized.featureGraphic) && Intrinsics.areEqual(this.promoGraphic, localized.promoGraphic) && Intrinsics.areEqual(this.tvBanner, localized.tvBanner) && Intrinsics.areEqual(this.summary, localized.summary);
        }
        return false;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getFeatureGraphic() {
        return this.featureGraphic;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getName() {
        return this.name;
    }

    public final List<String> getPhoneScreenshots() {
        return this.phoneScreenshots;
    }

    public final String getPromoGraphic() {
        return this.promoGraphic;
    }

    public final List<String> getSevenInchScreenshots() {
        return this.sevenInchScreenshots;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final List<String> getTenInchScreenshots() {
        return this.tenInchScreenshots;
    }

    public final String getTvBanner() {
        return this.tvBanner;
    }

    public final List<String> getTvScreenshots() {
        return this.tvScreenshots;
    }

    public final String getVideo() {
        return this.video;
    }

    public final List<String> getWearScreenshots() {
        return this.wearScreenshots;
    }

    public final String getWhatsNew() {
        return this.whatsNew;
    }

    public int hashCode() {
        String str = this.description;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.icon;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.whatsNew;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.video;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        List<String> list = this.phoneScreenshots;
        int hashCode6 = (hashCode5 + (list == null ? 0 : list.hashCode())) * 31;
        List<String> list2 = this.sevenInchScreenshots;
        int hashCode7 = (hashCode6 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<String> list3 = this.tenInchScreenshots;
        int hashCode8 = (hashCode7 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<String> list4 = this.wearScreenshots;
        int hashCode9 = (hashCode8 + (list4 == null ? 0 : list4.hashCode())) * 31;
        List<String> list5 = this.tvScreenshots;
        int hashCode10 = (hashCode9 + (list5 == null ? 0 : list5.hashCode())) * 31;
        String str6 = this.featureGraphic;
        int hashCode11 = (hashCode10 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.promoGraphic;
        int hashCode12 = (hashCode11 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.tvBanner;
        int hashCode13 = (hashCode12 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.summary;
        return hashCode13 + (str9 != null ? str9.hashCode() : 0);
    }

    public String toString() {
        String str = this.description;
        String str2 = this.name;
        String str3 = this.icon;
        String str4 = this.whatsNew;
        String str5 = this.video;
        List<String> list = this.phoneScreenshots;
        List<String> list2 = this.sevenInchScreenshots;
        List<String> list3 = this.tenInchScreenshots;
        List<String> list4 = this.wearScreenshots;
        List<String> list5 = this.tvScreenshots;
        String str6 = this.featureGraphic;
        String str7 = this.promoGraphic;
        String str8 = this.tvBanner;
        String str9 = this.summary;
        return "Localized(description=" + str + ", name=" + str2 + ", icon=" + str3 + ", whatsNew=" + str4 + ", video=" + str5 + ", phoneScreenshots=" + list + ", sevenInchScreenshots=" + list2 + ", tenInchScreenshots=" + list3 + ", wearScreenshots=" + list4 + ", tvScreenshots=" + list5 + ", featureGraphic=" + str6 + ", promoGraphic=" + str7 + ", tvBanner=" + str8 + ", summary=" + str9 + ")";
    }

    /* compiled from: AppV1.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lorg/fdroid/index/v1/Localized$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lorg/fdroid/index/v1/Localized;", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer serializer() {
            return Localized$$serializer.INSTANCE;
        }
    }

    static {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        $childSerializers = new KSerializer[]{null, null, null, null, null, new ArrayListSerializer(stringSerializer), new ArrayListSerializer(stringSerializer), new ArrayListSerializer(stringSerializer), new ArrayListSerializer(stringSerializer), new ArrayListSerializer(stringSerializer), null, null, null, null};
    }

    public /* synthetic */ Localized(int i, String str, String str2, String str3, String str4, String str5, List list, List list2, List list3, List list4, List list5, String str6, String str7, String str8, String str9, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.description = null;
        } else {
            this.description = str;
        }
        if ((i & 2) == 0) {
            this.name = null;
        } else {
            this.name = str2;
        }
        if ((i & 4) == 0) {
            this.icon = null;
        } else {
            this.icon = str3;
        }
        if ((i & 8) == 0) {
            this.whatsNew = null;
        } else {
            this.whatsNew = str4;
        }
        if ((i & 16) == 0) {
            this.video = null;
        } else {
            this.video = str5;
        }
        if ((i & 32) == 0) {
            this.phoneScreenshots = null;
        } else {
            this.phoneScreenshots = list;
        }
        if ((i & 64) == 0) {
            this.sevenInchScreenshots = null;
        } else {
            this.sevenInchScreenshots = list2;
        }
        if ((i & 128) == 0) {
            this.tenInchScreenshots = null;
        } else {
            this.tenInchScreenshots = list3;
        }
        if ((i & 256) == 0) {
            this.wearScreenshots = null;
        } else {
            this.wearScreenshots = list4;
        }
        if ((i & 512) == 0) {
            this.tvScreenshots = null;
        } else {
            this.tvScreenshots = list5;
        }
        if ((i & 1024) == 0) {
            this.featureGraphic = null;
        } else {
            this.featureGraphic = str6;
        }
        if ((i & 2048) == 0) {
            this.promoGraphic = null;
        } else {
            this.promoGraphic = str7;
        }
        if ((i & PKIFailureInfo.certConfirmed) == 0) {
            this.tvBanner = null;
        } else {
            this.tvBanner = str8;
        }
        if ((i & 8192) == 0) {
            this.summary = null;
        } else {
            this.summary = str9;
        }
    }

    public Localized(String str, String str2, String str3, String str4, String str5, List<String> list, List<String> list2, List<String> list3, List<String> list4, List<String> list5, String str6, String str7, String str8, String str9) {
        this.description = str;
        this.name = str2;
        this.icon = str3;
        this.whatsNew = str4;
        this.video = str5;
        this.phoneScreenshots = list;
        this.sevenInchScreenshots = list2;
        this.tenInchScreenshots = list3;
        this.wearScreenshots = list4;
        this.tvScreenshots = list5;
        this.featureGraphic = str6;
        this.promoGraphic = str7;
        this.tvBanner = str8;
        this.summary = str9;
    }

    public static final /* synthetic */ void write$Self$index_release(Localized localized, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer[] kSerializerArr = $childSerializers;
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) || localized.description != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, localized.description);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || localized.name != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, localized.name);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) || localized.icon != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, localized.icon);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 3) || localized.whatsNew != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, localized.whatsNew);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 4) || localized.video != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, localized.video);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 5) || localized.phoneScreenshots != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 5, kSerializerArr[5], localized.phoneScreenshots);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 6) || localized.sevenInchScreenshots != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 6, kSerializerArr[6], localized.sevenInchScreenshots);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 7) || localized.tenInchScreenshots != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 7, kSerializerArr[7], localized.tenInchScreenshots);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 8) || localized.wearScreenshots != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 8, kSerializerArr[8], localized.wearScreenshots);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 9) || localized.tvScreenshots != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 9, kSerializerArr[9], localized.tvScreenshots);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 10) || localized.featureGraphic != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, localized.featureGraphic);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 11) || localized.promoGraphic != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, localized.promoGraphic);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 12) || localized.tvBanner != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, localized.tvBanner);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 13) && localized.summary == null) {
            return;
        }
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, localized.summary);
    }

    public /* synthetic */ Localized(String str, String str2, String str3, String str4, String str5, List list, List list2, List list3, List list4, List list5, String str6, String str7, String str8, String str9, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : list, (i & 64) != 0 ? null : list2, (i & 128) != 0 ? null : list3, (i & 256) != 0 ? null : list4, (i & 512) != 0 ? null : list5, (i & 1024) != 0 ? null : str6, (i & 2048) != 0 ? null : str7, (i & PKIFailureInfo.certConfirmed) != 0 ? null : str8, (i & 8192) == 0 ? str9 : null);
    }
}
