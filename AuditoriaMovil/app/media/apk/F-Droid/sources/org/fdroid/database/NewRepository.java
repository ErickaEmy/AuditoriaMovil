package org.fdroid.database;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.fdroid.index.IndexFormatVersion;
import org.fdroid.index.v2.FileV2;
/* compiled from: Repository.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003j\u0002`\b\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u000fJ\u0019\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005HÆ\u0003J\u0019\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003j\u0002`\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0004HÆ\u0003Ju\u0010!\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003j\u0002`\b2\b\b\u0002\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003j\u0002`\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011¨\u0006("}, d2 = {"Lorg/fdroid/database/NewRepository;", "", "name", "", "", "Lorg/fdroid/index/v2/LocalizedTextV2;", "icon", "Lorg/fdroid/index/v2/FileV2;", "Lorg/fdroid/index/v2/LocalizedFileV2;", "address", "formatVersion", "Lorg/fdroid/index/IndexFormatVersion;", "certificate", "username", "password", "(Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Lorg/fdroid/index/IndexFormatVersion;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "getCertificate", "getFormatVersion", "()Lorg/fdroid/index/IndexFormatVersion;", "getIcon", "()Ljava/util/Map;", "getName", "getPassword", "getUsername", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NewRepository {
    private final String address;
    private final String certificate;
    private final IndexFormatVersion formatVersion;
    private final Map<String, FileV2> icon;
    private final Map<String, String> name;
    private final String password;
    private final String username;

    public static /* synthetic */ NewRepository copy$default(NewRepository newRepository, Map map, Map map2, String str, IndexFormatVersion indexFormatVersion, String str2, String str3, String str4, int i, Object obj) {
        Map<String, String> map3 = map;
        if ((i & 1) != 0) {
            map3 = newRepository.name;
        }
        Map<String, FileV2> map4 = map2;
        if ((i & 2) != 0) {
            map4 = newRepository.icon;
        }
        Map map5 = map4;
        if ((i & 4) != 0) {
            str = newRepository.address;
        }
        String str5 = str;
        if ((i & 8) != 0) {
            indexFormatVersion = newRepository.formatVersion;
        }
        IndexFormatVersion indexFormatVersion2 = indexFormatVersion;
        if ((i & 16) != 0) {
            str2 = newRepository.certificate;
        }
        String str6 = str2;
        if ((i & 32) != 0) {
            str3 = newRepository.username;
        }
        String str7 = str3;
        if ((i & 64) != 0) {
            str4 = newRepository.password;
        }
        return newRepository.copy(map3, map5, str5, indexFormatVersion2, str6, str7, str4);
    }

    public final Map<String, String> component1() {
        return this.name;
    }

    public final Map<String, FileV2> component2() {
        return this.icon;
    }

    public final String component3() {
        return this.address;
    }

    public final IndexFormatVersion component4() {
        return this.formatVersion;
    }

    public final String component5() {
        return this.certificate;
    }

    public final String component6() {
        return this.username;
    }

    public final String component7() {
        return this.password;
    }

    public final NewRepository copy(Map<String, String> name, Map<String, FileV2> icon, String address, IndexFormatVersion indexFormatVersion, String certificate, String str, String str2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(certificate, "certificate");
        return new NewRepository(name, icon, address, indexFormatVersion, certificate, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NewRepository) {
            NewRepository newRepository = (NewRepository) obj;
            return Intrinsics.areEqual(this.name, newRepository.name) && Intrinsics.areEqual(this.icon, newRepository.icon) && Intrinsics.areEqual(this.address, newRepository.address) && this.formatVersion == newRepository.formatVersion && Intrinsics.areEqual(this.certificate, newRepository.certificate) && Intrinsics.areEqual(this.username, newRepository.username) && Intrinsics.areEqual(this.password, newRepository.password);
        }
        return false;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getCertificate() {
        return this.certificate;
    }

    public final IndexFormatVersion getFormatVersion() {
        return this.formatVersion;
    }

    public final Map<String, FileV2> getIcon() {
        return this.icon;
    }

    public final Map<String, String> getName() {
        return this.name;
    }

    public final String getPassword() {
        return this.password;
    }

    public final String getUsername() {
        return this.username;
    }

    public int hashCode() {
        int hashCode = ((((this.name.hashCode() * 31) + this.icon.hashCode()) * 31) + this.address.hashCode()) * 31;
        IndexFormatVersion indexFormatVersion = this.formatVersion;
        int hashCode2 = (((hashCode + (indexFormatVersion == null ? 0 : indexFormatVersion.hashCode())) * 31) + this.certificate.hashCode()) * 31;
        String str = this.username;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.password;
        return hashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        Map<String, String> map = this.name;
        Map<String, FileV2> map2 = this.icon;
        String str = this.address;
        IndexFormatVersion indexFormatVersion = this.formatVersion;
        String str2 = this.certificate;
        String str3 = this.username;
        String str4 = this.password;
        return "NewRepository(name=" + map + ", icon=" + map2 + ", address=" + str + ", formatVersion=" + indexFormatVersion + ", certificate=" + str2 + ", username=" + str3 + ", password=" + str4 + ")";
    }

    public NewRepository(Map<String, String> name, Map<String, FileV2> icon, String address, IndexFormatVersion indexFormatVersion, String certificate, String str, String str2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(certificate, "certificate");
        this.name = name;
        this.icon = icon;
        this.address = address;
        this.formatVersion = indexFormatVersion;
        this.certificate = certificate;
        this.username = str;
        this.password = str2;
    }

    public /* synthetic */ NewRepository(Map map, Map map2, String str, IndexFormatVersion indexFormatVersion, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, map2, str, indexFormatVersion, str2, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : str4);
    }
}
