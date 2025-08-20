package org.fdroid.database;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import androidx.compose.foundation.ClickableElement$$ExternalSyntheticBackport0;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Repository.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001BQ\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\t\u0010%\u001a\u00020\fHÆ\u0003J\t\u0010&\u001a\u00020\u000eHÆ\u0003J_\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010(\u001a\u00020\f2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u000eHÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006,"}, d2 = {"Lorg/fdroid/database/InitialRepository;", "", "name", "", "address", "mirrors", "", "description", "certificate", "version", "", "enabled", "", "weight", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;JZI)V", "getAddress", "()Ljava/lang/String;", "getCertificate", "getDescription", "getEnabled", "()Z", "getMirrors", "()Ljava/util/List;", "getName", "getVersion", "()J", "getWeight$annotations", "()V", "getWeight", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class InitialRepository {
    private final String address;
    private final String certificate;
    private final String description;
    private final boolean enabled;
    private final List<String> mirrors;
    private final String name;
    private final long version;
    private final int weight;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InitialRepository(String name, String address, String description, String certificate, long j, boolean z) {
        this(name, address, null, description, certificate, j, z, 0, 132, null);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(certificate, "certificate");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InitialRepository(String name, String address, List<String> mirrors, String description, String certificate, long j, boolean z) {
        this(name, address, mirrors, description, certificate, j, z, 0, 128, null);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(mirrors, "mirrors");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(certificate, "certificate");
    }

    public static /* synthetic */ void getWeight$annotations() {
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.address;
    }

    public final List<String> component3() {
        return this.mirrors;
    }

    public final String component4() {
        return this.description;
    }

    public final String component5() {
        return this.certificate;
    }

    public final long component6() {
        return this.version;
    }

    public final boolean component7() {
        return this.enabled;
    }

    public final int component8() {
        return this.weight;
    }

    public final InitialRepository copy(String name, String address, List<String> mirrors, String description, String certificate, long j, boolean z, int i) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(mirrors, "mirrors");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(certificate, "certificate");
        return new InitialRepository(name, address, mirrors, description, certificate, j, z, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InitialRepository) {
            InitialRepository initialRepository = (InitialRepository) obj;
            return Intrinsics.areEqual(this.name, initialRepository.name) && Intrinsics.areEqual(this.address, initialRepository.address) && Intrinsics.areEqual(this.mirrors, initialRepository.mirrors) && Intrinsics.areEqual(this.description, initialRepository.description) && Intrinsics.areEqual(this.certificate, initialRepository.certificate) && this.version == initialRepository.version && this.enabled == initialRepository.enabled && this.weight == initialRepository.weight;
        }
        return false;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getCertificate() {
        return this.certificate;
    }

    public final String getDescription() {
        return this.description;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final List<String> getMirrors() {
        return this.mirrors;
    }

    public final String getName() {
        return this.name;
    }

    public final long getVersion() {
        return this.version;
    }

    public final int getWeight() {
        return this.weight;
    }

    public int hashCode() {
        return (((((((((((((this.name.hashCode() * 31) + this.address.hashCode()) * 31) + this.mirrors.hashCode()) * 31) + this.description.hashCode()) * 31) + this.certificate.hashCode()) * 31) + FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(this.version)) * 31) + ClickableElement$$ExternalSyntheticBackport0.m(this.enabled)) * 31) + this.weight;
    }

    public String toString() {
        String str = this.name;
        String str2 = this.address;
        List<String> list = this.mirrors;
        String str3 = this.description;
        String str4 = this.certificate;
        long j = this.version;
        boolean z = this.enabled;
        int i = this.weight;
        return "InitialRepository(name=" + str + ", address=" + str2 + ", mirrors=" + list + ", description=" + str3 + ", certificate=" + str4 + ", version=" + j + ", enabled=" + z + ", weight=" + i + ")";
    }

    public InitialRepository(String name, String address, List<String> mirrors, String description, String certificate, long j, boolean z, int i) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(mirrors, "mirrors");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(certificate, "certificate");
        this.name = name;
        this.address = address;
        this.mirrors = mirrors;
        this.description = description;
        this.certificate = certificate;
        this.version = j;
        this.enabled = z;
        this.weight = i;
        RepositoryKt.validateCertificate(certificate);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ InitialRepository(java.lang.String r13, java.lang.String r14, java.util.List r15, java.lang.String r16, java.lang.String r17, long r18, boolean r20, int r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
        /*
            r12 = this;
            r0 = r22
            r1 = r0 & 4
            if (r1 == 0) goto Lc
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            r5 = r1
            goto Ld
        Lc:
            r5 = r15
        Ld:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L14
            r0 = 0
            r11 = r0
            goto L16
        L14:
            r11 = r21
        L16:
            r2 = r12
            r3 = r13
            r4 = r14
            r6 = r16
            r7 = r17
            r8 = r18
            r10 = r20
            r2.<init>(r3, r4, r5, r6, r7, r8, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.database.InitialRepository.<init>(java.lang.String, java.lang.String, java.util.List, java.lang.String, java.lang.String, long, boolean, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
