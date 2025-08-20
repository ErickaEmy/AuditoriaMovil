package org.fdroid.database;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.fdroid.index.IndexFormatVersion;
import org.fdroid.index.v2.FileV2;
/* compiled from: Repository.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0081\b\u0018\u0000 ;2\u00020\u0001:\u0001;B¡\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u0007\u0012\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0004\u0018\u0001`\n\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0018\b\u0002\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0002\u0010\u0015J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u0019\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u0007HÆ\u0003J\t\u0010+\u001a\u00020\u0006HÆ\u0003J\u0019\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u0007HÆ\u0003J\u001d\u0010-\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0004\u0018\u0001`\nHÆ\u0003J\t\u0010.\u001a\u00020\u0006HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010&J\u000b\u00102\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010\u001fJ¸\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u00072\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0004\u0018\u0001`\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0018\b\u0002\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u00105J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\u0012HÖ\u0001J\t\u0010:\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0014\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R!\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR%\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0004\u0018\u0001`\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0017¨\u0006<"}, d2 = {"Lorg/fdroid/database/CoreRepository;", "", "repoId", "", "name", "", "", "Lorg/fdroid/index/v2/LocalizedTextV2;", "icon", "Lorg/fdroid/index/v2/FileV2;", "Lorg/fdroid/index/v2/LocalizedFileV2;", "address", "webBaseUrl", "timestamp", "version", "formatVersion", "Lorg/fdroid/index/IndexFormatVersion;", "maxAge", "", "description", "certificate", "(JLjava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;Lorg/fdroid/index/IndexFormatVersion;Ljava/lang/Integer;Ljava/util/Map;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "getCertificate", "getDescription", "()Ljava/util/Map;", "getFormatVersion", "()Lorg/fdroid/index/IndexFormatVersion;", "getIcon", "getMaxAge", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "getRepoId", "()J", "getTimestamp", "getVersion", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getWebBaseUrl", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JLjava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;Lorg/fdroid/index/IndexFormatVersion;Ljava/lang/Integer;Ljava/util/Map;Ljava/lang/String;)Lorg/fdroid/database/CoreRepository;", "equals", "", "other", "hashCode", "toString", "Companion", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CoreRepository {
    public static final Companion Companion = new Companion(null);
    public static final String TABLE = "CoreRepository";
    private final String address;
    private final String certificate;
    private final Map<String, String> description;
    private final IndexFormatVersion formatVersion;
    private final Map<String, FileV2> icon;
    private final Integer maxAge;
    private final Map<String, String> name;
    private final long repoId;
    private final long timestamp;
    private final Long version;
    private final String webBaseUrl;

    /* compiled from: Repository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lorg/fdroid/database/CoreRepository$Companion;", "", "()V", "TABLE", "", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final long component1() {
        return this.repoId;
    }

    public final Map<String, String> component10() {
        return this.description;
    }

    public final String component11() {
        return this.certificate;
    }

    public final Map<String, String> component2() {
        return this.name;
    }

    public final Map<String, FileV2> component3() {
        return this.icon;
    }

    public final String component4() {
        return this.address;
    }

    public final String component5() {
        return this.webBaseUrl;
    }

    public final long component6() {
        return this.timestamp;
    }

    public final Long component7() {
        return this.version;
    }

    public final IndexFormatVersion component8() {
        return this.formatVersion;
    }

    public final Integer component9() {
        return this.maxAge;
    }

    public final CoreRepository copy(long j, Map<String, String> name, Map<String, FileV2> map, String address, String str, long j2, Long l, IndexFormatVersion indexFormatVersion, Integer num, Map<String, String> description, String certificate) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(certificate, "certificate");
        return new CoreRepository(j, name, map, address, str, j2, l, indexFormatVersion, num, description, certificate);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CoreRepository) {
            CoreRepository coreRepository = (CoreRepository) obj;
            return this.repoId == coreRepository.repoId && Intrinsics.areEqual(this.name, coreRepository.name) && Intrinsics.areEqual(this.icon, coreRepository.icon) && Intrinsics.areEqual(this.address, coreRepository.address) && Intrinsics.areEqual(this.webBaseUrl, coreRepository.webBaseUrl) && this.timestamp == coreRepository.timestamp && Intrinsics.areEqual(this.version, coreRepository.version) && this.formatVersion == coreRepository.formatVersion && Intrinsics.areEqual(this.maxAge, coreRepository.maxAge) && Intrinsics.areEqual(this.description, coreRepository.description) && Intrinsics.areEqual(this.certificate, coreRepository.certificate);
        }
        return false;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getCertificate() {
        return this.certificate;
    }

    public final Map<String, String> getDescription() {
        return this.description;
    }

    public final IndexFormatVersion getFormatVersion() {
        return this.formatVersion;
    }

    public final Map<String, FileV2> getIcon() {
        return this.icon;
    }

    public final Integer getMaxAge() {
        return this.maxAge;
    }

    public final Map<String, String> getName() {
        return this.name;
    }

    public final long getRepoId() {
        return this.repoId;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final Long getVersion() {
        return this.version;
    }

    public final String getWebBaseUrl() {
        return this.webBaseUrl;
    }

    public int hashCode() {
        int m = ((FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(this.repoId) * 31) + this.name.hashCode()) * 31;
        Map<String, FileV2> map = this.icon;
        int hashCode = (((m + (map == null ? 0 : map.hashCode())) * 31) + this.address.hashCode()) * 31;
        String str = this.webBaseUrl;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(this.timestamp)) * 31;
        Long l = this.version;
        int hashCode3 = (hashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        IndexFormatVersion indexFormatVersion = this.formatVersion;
        int hashCode4 = (hashCode3 + (indexFormatVersion == null ? 0 : indexFormatVersion.hashCode())) * 31;
        Integer num = this.maxAge;
        return ((((hashCode4 + (num != null ? num.hashCode() : 0)) * 31) + this.description.hashCode()) * 31) + this.certificate.hashCode();
    }

    public String toString() {
        long j = this.repoId;
        Map<String, String> map = this.name;
        Map<String, FileV2> map2 = this.icon;
        String str = this.address;
        String str2 = this.webBaseUrl;
        long j2 = this.timestamp;
        Long l = this.version;
        IndexFormatVersion indexFormatVersion = this.formatVersion;
        Integer num = this.maxAge;
        Map<String, String> map3 = this.description;
        String str3 = this.certificate;
        return "CoreRepository(repoId=" + j + ", name=" + map + ", icon=" + map2 + ", address=" + str + ", webBaseUrl=" + str2 + ", timestamp=" + j2 + ", version=" + l + ", formatVersion=" + indexFormatVersion + ", maxAge=" + num + ", description=" + map3 + ", certificate=" + str3 + ")";
    }

    public CoreRepository(long j, Map<String, String> name, Map<String, FileV2> map, String address, String str, long j2, Long l, IndexFormatVersion indexFormatVersion, Integer num, Map<String, String> description, String certificate) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(certificate, "certificate");
        this.repoId = j;
        this.name = name;
        this.icon = map;
        this.address = address;
        this.webBaseUrl = str;
        this.timestamp = j2;
        this.version = l;
        this.formatVersion = indexFormatVersion;
        this.maxAge = num;
        this.description = description;
        this.certificate = certificate;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ CoreRepository(long r18, java.util.Map r20, java.util.Map r21, java.lang.String r22, java.lang.String r23, long r24, java.lang.Long r26, org.fdroid.index.IndexFormatVersion r27, java.lang.Integer r28, java.util.Map r29, java.lang.String r30, int r31, kotlin.jvm.internal.DefaultConstructorMarker r32) {
        /*
            r17 = this;
            r0 = r31
            r1 = r0 & 1
            if (r1 == 0) goto La
            r1 = 0
            r4 = r1
            goto Lc
        La:
            r4 = r18
        Lc:
            r1 = r0 & 2
            if (r1 == 0) goto L16
            java.util.Map r1 = kotlin.collections.MapsKt.emptyMap()
            r6 = r1
            goto L18
        L16:
            r6 = r20
        L18:
            r1 = r0 & 16
            if (r1 == 0) goto L1f
            r1 = 0
            r9 = r1
            goto L21
        L1f:
            r9 = r23
        L21:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L2b
            java.util.Map r0 = kotlin.collections.MapsKt.emptyMap()
            r15 = r0
            goto L2d
        L2b:
            r15 = r29
        L2d:
            r3 = r17
            r7 = r21
            r8 = r22
            r10 = r24
            r12 = r26
            r13 = r27
            r14 = r28
            r16 = r30
            r3.<init>(r4, r6, r7, r8, r9, r10, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.database.CoreRepository.<init>(long, java.util.Map, java.util.Map, java.lang.String, java.lang.String, long, java.lang.Long, org.fdroid.index.IndexFormatVersion, java.lang.Integer, java.util.Map, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
