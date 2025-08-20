package org.fdroid.index.v2;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import ch.qos.logback.core.joran.action.Action;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
/* compiled from: PackageV2.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 K2\u00020\u0001:\u0002JKB\u00ad\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012$\u0010\u000f\u001a \u0012\u0004\u0012\u00020\u000e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0010j\u0002`\u0011\u0018\u00010\u0010\u0012\u001a\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010\u001aBy\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012$\b\u0002\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0010j\u0002`\u00110\u0010\u0012\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0010j\u0002`\u0011¢\u0006\u0002\u0010\u001bJ\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0007HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u00105\u001a\u00020\u000bHÆ\u0003J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003J%\u00107\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0010j\u0002`\u00110\u0010HÆ\u0003J\u0019\u00108\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0010j\u0002`\u0011HÆ\u0003J\u0083\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2$\b\u0002\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0010j\u0002`\u00110\u00102\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0010j\u0002`\u0011HÆ\u0001J\u0013\u0010:\u001a\u00020#2\b\u0010;\u001a\u0004\u0018\u00010<HÖ\u0003J\t\u0010=\u001a\u00020\u0003HÖ\u0001J\t\u0010>\u001a\u00020\u000eHÖ\u0001J\u001c\u0010?\u001a\u00020@2\u0014\u0010A\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020@0BJ&\u0010C\u001a\u00020@2\u0006\u0010D\u001a\u00020\u00002\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020HHÁ\u0001¢\u0006\u0002\bIR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR-\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0010j\u0002`\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0014\u0010\u0013\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001dR!\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0010j\u0002`\u0011¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001f¨\u0006L"}, d2 = {"Lorg/fdroid/index/v2/PackageVersionV2;", "Lorg/fdroid/index/v2/PackageVersion;", "seen1", "", "added", "", Action.FILE_ATTRIBUTE, "Lorg/fdroid/index/v2/FileV1;", "src", "Lorg/fdroid/index/v2/FileV2;", "manifest", "Lorg/fdroid/index/v2/ManifestV2;", "releaseChannels", "", "", "antiFeatures", "", "Lorg/fdroid/index/v2/LocalizedTextV2;", "whatsNew", "versionCode", "signer", "Lorg/fdroid/index/v2/SignerV2;", "packageManifest", "Lorg/fdroid/index/v2/PackageManifest;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLorg/fdroid/index/v2/FileV1;Lorg/fdroid/index/v2/FileV2;Lorg/fdroid/index/v2/ManifestV2;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;JLorg/fdroid/index/v2/SignerV2;Lorg/fdroid/index/v2/PackageManifest;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(JLorg/fdroid/index/v2/FileV1;Lorg/fdroid/index/v2/FileV2;Lorg/fdroid/index/v2/ManifestV2;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;)V", "getAdded", "()J", "getAntiFeatures", "()Ljava/util/Map;", "getFile", "()Lorg/fdroid/index/v2/FileV1;", "hasKnownVulnerability", "", "getHasKnownVulnerability", "()Z", "getManifest", "()Lorg/fdroid/index/v2/ManifestV2;", "getPackageManifest", "()Lorg/fdroid/index/v2/PackageManifest;", "getReleaseChannels", "()Ljava/util/List;", "getSigner", "()Lorg/fdroid/index/v2/SignerV2;", "getSrc", "()Lorg/fdroid/index/v2/FileV2;", "getVersionCode", "getWhatsNew", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "toString", "walkFiles", "", "fileConsumer", "Lkotlin/Function1;", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$index_release", "$serializer", "Companion", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final class PackageVersionV2 implements PackageVersion {
    private static final KSerializer[] $childSerializers;
    public static final Companion Companion = new Companion(null);
    private final long added;
    private final Map<String, Map<String, String>> antiFeatures;
    private final FileV1 file;
    private final ManifestV2 manifest;
    private final PackageManifest packageManifest;
    private final List<String> releaseChannels;
    private final SignerV2 signer;
    private final FileV2 src;
    private final long versionCode;
    private final Map<String, String> whatsNew;

    public final long component1() {
        return this.added;
    }

    public final FileV1 component2() {
        return this.file;
    }

    public final FileV2 component3() {
        return this.src;
    }

    public final ManifestV2 component4() {
        return this.manifest;
    }

    public final List<String> component5() {
        return this.releaseChannels;
    }

    public final Map<String, Map<String, String>> component6() {
        return this.antiFeatures;
    }

    public final Map<String, String> component7() {
        return this.whatsNew;
    }

    public final PackageVersionV2 copy(long j, FileV1 file, FileV2 fileV2, ManifestV2 manifest, List<String> releaseChannels, Map<String, ? extends Map<String, String>> antiFeatures, Map<String, String> whatsNew) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(manifest, "manifest");
        Intrinsics.checkNotNullParameter(releaseChannels, "releaseChannels");
        Intrinsics.checkNotNullParameter(antiFeatures, "antiFeatures");
        Intrinsics.checkNotNullParameter(whatsNew, "whatsNew");
        return new PackageVersionV2(j, file, fileV2, manifest, releaseChannels, antiFeatures, whatsNew);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PackageVersionV2) {
            PackageVersionV2 packageVersionV2 = (PackageVersionV2) obj;
            return this.added == packageVersionV2.added && Intrinsics.areEqual(this.file, packageVersionV2.file) && Intrinsics.areEqual(this.src, packageVersionV2.src) && Intrinsics.areEqual(this.manifest, packageVersionV2.manifest) && Intrinsics.areEqual(this.releaseChannels, packageVersionV2.releaseChannels) && Intrinsics.areEqual(this.antiFeatures, packageVersionV2.antiFeatures) && Intrinsics.areEqual(this.whatsNew, packageVersionV2.whatsNew);
        }
        return false;
    }

    public final long getAdded() {
        return this.added;
    }

    public final Map<String, Map<String, String>> getAntiFeatures() {
        return this.antiFeatures;
    }

    public final FileV1 getFile() {
        return this.file;
    }

    public final ManifestV2 getManifest() {
        return this.manifest;
    }

    @Override // org.fdroid.index.v2.PackageVersion
    public PackageManifest getPackageManifest() {
        return this.packageManifest;
    }

    @Override // org.fdroid.index.v2.PackageVersion
    public List<String> getReleaseChannels() {
        return this.releaseChannels;
    }

    @Override // org.fdroid.index.v2.PackageVersion
    public SignerV2 getSigner() {
        return this.signer;
    }

    public final FileV2 getSrc() {
        return this.src;
    }

    @Override // org.fdroid.index.v2.PackageVersion
    public long getVersionCode() {
        return this.versionCode;
    }

    public final Map<String, String> getWhatsNew() {
        return this.whatsNew;
    }

    public int hashCode() {
        int m = ((FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(this.added) * 31) + this.file.hashCode()) * 31;
        FileV2 fileV2 = this.src;
        return ((((((((m + (fileV2 == null ? 0 : fileV2.hashCode())) * 31) + this.manifest.hashCode()) * 31) + this.releaseChannels.hashCode()) * 31) + this.antiFeatures.hashCode()) * 31) + this.whatsNew.hashCode();
    }

    public String toString() {
        long j = this.added;
        FileV1 fileV1 = this.file;
        FileV2 fileV2 = this.src;
        ManifestV2 manifestV2 = this.manifest;
        List<String> list = this.releaseChannels;
        Map<String, Map<String, String>> map = this.antiFeatures;
        Map<String, String> map2 = this.whatsNew;
        return "PackageVersionV2(added=" + j + ", file=" + fileV1 + ", src=" + fileV2 + ", manifest=" + manifestV2 + ", releaseChannels=" + list + ", antiFeatures=" + map + ", whatsNew=" + map2 + ")";
    }

    /* compiled from: PackageV2.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lorg/fdroid/index/v2/PackageVersionV2$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lorg/fdroid/index/v2/PackageVersionV2;", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer serializer() {
            return PackageVersionV2$$serializer.INSTANCE;
        }
    }

    static {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        $childSerializers = new KSerializer[]{null, null, null, null, new ArrayListSerializer(stringSerializer), new LinkedHashMapSerializer(stringSerializer, new LinkedHashMapSerializer(stringSerializer, stringSerializer)), new LinkedHashMapSerializer(stringSerializer, stringSerializer), null, null, new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(PackageManifest.class), new Annotation[0])};
    }

    public /* synthetic */ PackageVersionV2(int i, long j, FileV1 fileV1, FileV2 fileV2, ManifestV2 manifestV2, List list, Map map, Map map2, long j2, SignerV2 signerV2, PackageManifest packageManifest, SerializationConstructorMarker serializationConstructorMarker) {
        Map<String, String> emptyMap;
        Map<String, Map<String, String>> emptyMap2;
        List<String> emptyList;
        if (11 != (i & 11)) {
            PluginExceptionsKt.throwMissingFieldException(i, 11, PackageVersionV2$$serializer.INSTANCE.getDescriptor());
        }
        this.added = j;
        this.file = fileV1;
        if ((i & 4) == 0) {
            this.src = null;
        } else {
            this.src = fileV2;
        }
        this.manifest = manifestV2;
        if ((i & 16) == 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.releaseChannels = emptyList;
        } else {
            this.releaseChannels = list;
        }
        if ((i & 32) == 0) {
            emptyMap2 = MapsKt__MapsKt.emptyMap();
            this.antiFeatures = emptyMap2;
        } else {
            this.antiFeatures = map;
        }
        if ((i & 64) == 0) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            this.whatsNew = emptyMap;
        } else {
            this.whatsNew = map2;
        }
        if ((i & 128) == 0) {
            this.versionCode = manifestV2.getVersionCode();
        } else {
            this.versionCode = j2;
        }
        if ((i & 256) == 0) {
            this.signer = manifestV2.getSigner();
        } else {
            this.signer = signerV2;
        }
        if ((i & 512) == 0) {
            this.packageManifest = manifestV2;
        } else {
            this.packageManifest = packageManifest;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PackageVersionV2(long j, FileV1 file, FileV2 fileV2, ManifestV2 manifest, List<String> releaseChannels, Map<String, ? extends Map<String, String>> antiFeatures, Map<String, String> whatsNew) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(manifest, "manifest");
        Intrinsics.checkNotNullParameter(releaseChannels, "releaseChannels");
        Intrinsics.checkNotNullParameter(antiFeatures, "antiFeatures");
        Intrinsics.checkNotNullParameter(whatsNew, "whatsNew");
        this.added = j;
        this.file = file;
        this.src = fileV2;
        this.manifest = manifest;
        this.releaseChannels = releaseChannels;
        this.antiFeatures = antiFeatures;
        this.whatsNew = whatsNew;
        this.versionCode = manifest.getVersionCode();
        this.signer = manifest.getSigner();
        this.packageManifest = manifest;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003f, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r3) == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005c, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r3) == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0077, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r3) == false) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void write$Self$index_release(org.fdroid.index.v2.PackageVersionV2 r6, kotlinx.serialization.encoding.CompositeEncoder r7, kotlinx.serialization.descriptors.SerialDescriptor r8) {
        /*
            kotlinx.serialization.KSerializer[] r0 = org.fdroid.index.v2.PackageVersionV2.$childSerializers
            long r1 = r6.added
            r3 = 0
            r7.encodeLongElement(r8, r3, r1)
            org.fdroid.index.v2.FileV1$$serializer r1 = org.fdroid.index.v2.FileV1$$serializer.INSTANCE
            org.fdroid.index.v2.FileV1 r2 = r6.file
            r3 = 1
            r7.encodeSerializableElement(r8, r3, r1, r2)
            r1 = 2
            boolean r2 = r7.shouldEncodeElementDefault(r8, r1)
            if (r2 == 0) goto L18
            goto L1c
        L18:
            org.fdroid.index.v2.FileV2 r2 = r6.src
            if (r2 == 0) goto L23
        L1c:
            org.fdroid.index.v2.FileV2$$serializer r2 = org.fdroid.index.v2.FileV2$$serializer.INSTANCE
            org.fdroid.index.v2.FileV2 r3 = r6.src
            r7.encodeNullableSerializableElement(r8, r1, r2, r3)
        L23:
            org.fdroid.index.v2.ManifestV2$$serializer r1 = org.fdroid.index.v2.ManifestV2$$serializer.INSTANCE
            org.fdroid.index.v2.ManifestV2 r2 = r6.manifest
            r3 = 3
            r7.encodeSerializableElement(r8, r3, r1, r2)
            r1 = 4
            boolean r2 = r7.shouldEncodeElementDefault(r8, r1)
            if (r2 == 0) goto L33
            goto L41
        L33:
            java.util.List r2 = r6.getReleaseChannels()
            java.util.List r3 = kotlin.collections.CollectionsKt.emptyList()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            if (r2 != 0) goto L4a
        L41:
            r2 = r0[r1]
            java.util.List r3 = r6.getReleaseChannels()
            r7.encodeSerializableElement(r8, r1, r2, r3)
        L4a:
            r1 = 5
            boolean r2 = r7.shouldEncodeElementDefault(r8, r1)
            if (r2 == 0) goto L52
            goto L5e
        L52:
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> r2 = r6.antiFeatures
            java.util.Map r3 = kotlin.collections.MapsKt.emptyMap()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            if (r2 != 0) goto L65
        L5e:
            r2 = r0[r1]
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> r3 = r6.antiFeatures
            r7.encodeSerializableElement(r8, r1, r2, r3)
        L65:
            r1 = 6
            boolean r2 = r7.shouldEncodeElementDefault(r8, r1)
            if (r2 == 0) goto L6d
            goto L79
        L6d:
            java.util.Map<java.lang.String, java.lang.String> r2 = r6.whatsNew
            java.util.Map r3 = kotlin.collections.MapsKt.emptyMap()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            if (r2 != 0) goto L80
        L79:
            r2 = r0[r1]
            java.util.Map<java.lang.String, java.lang.String> r3 = r6.whatsNew
            r7.encodeSerializableElement(r8, r1, r2, r3)
        L80:
            r1 = 7
            boolean r2 = r7.shouldEncodeElementDefault(r8, r1)
            if (r2 == 0) goto L88
            goto L96
        L88:
            long r2 = r6.getVersionCode()
            org.fdroid.index.v2.ManifestV2 r4 = r6.manifest
            long r4 = r4.getVersionCode()
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L9d
        L96:
            long r2 = r6.getVersionCode()
            r7.encodeLongElement(r8, r1, r2)
        L9d:
            r1 = 8
            boolean r2 = r7.shouldEncodeElementDefault(r8, r1)
            if (r2 == 0) goto La6
            goto Lb6
        La6:
            org.fdroid.index.v2.SignerV2 r2 = r6.getSigner()
            org.fdroid.index.v2.ManifestV2 r3 = r6.manifest
            org.fdroid.index.v2.SignerV2 r3 = r3.getSigner()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            if (r2 != 0) goto Lbf
        Lb6:
            org.fdroid.index.v2.SignerV2$$serializer r2 = org.fdroid.index.v2.SignerV2$$serializer.INSTANCE
            org.fdroid.index.v2.SignerV2 r3 = r6.getSigner()
            r7.encodeNullableSerializableElement(r8, r1, r2, r3)
        Lbf:
            r1 = 9
            boolean r2 = r7.shouldEncodeElementDefault(r8, r1)
            if (r2 == 0) goto Lc8
            goto Ld4
        Lc8:
            org.fdroid.index.v2.PackageManifest r2 = r6.getPackageManifest()
            org.fdroid.index.v2.ManifestV2 r3 = r6.manifest
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            if (r2 != 0) goto Ldd
        Ld4:
            r0 = r0[r1]
            org.fdroid.index.v2.PackageManifest r6 = r6.getPackageManifest()
            r7.encodeSerializableElement(r8, r1, r0, r6)
        Ldd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.index.v2.PackageVersionV2.write$Self$index_release(org.fdroid.index.v2.PackageVersionV2, kotlinx.serialization.encoding.CompositeEncoder, kotlinx.serialization.descriptors.SerialDescriptor):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ PackageVersionV2(long r11, org.fdroid.index.v2.FileV1 r13, org.fdroid.index.v2.FileV2 r14, org.fdroid.index.v2.ManifestV2 r15, java.util.List r16, java.util.Map r17, java.util.Map r18, int r19, kotlin.jvm.internal.DefaultConstructorMarker r20) {
        /*
            r10 = this;
            r0 = r19 & 4
            if (r0 == 0) goto L7
            r0 = 0
            r5 = r0
            goto L8
        L7:
            r5 = r14
        L8:
            r0 = r19 & 16
            if (r0 == 0) goto L12
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            r7 = r0
            goto L14
        L12:
            r7 = r16
        L14:
            r0 = r19 & 32
            if (r0 == 0) goto L1e
            java.util.Map r0 = kotlin.collections.MapsKt.emptyMap()
            r8 = r0
            goto L20
        L1e:
            r8 = r17
        L20:
            r0 = r19 & 64
            if (r0 == 0) goto L2a
            java.util.Map r0 = kotlin.collections.MapsKt.emptyMap()
            r9 = r0
            goto L2c
        L2a:
            r9 = r18
        L2c:
            r1 = r10
            r2 = r11
            r4 = r13
            r6 = r15
            r1.<init>(r2, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.index.v2.PackageVersionV2.<init>(long, org.fdroid.index.v2.FileV1, org.fdroid.index.v2.FileV2, org.fdroid.index.v2.ManifestV2, java.util.List, java.util.Map, java.util.Map, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @Override // org.fdroid.index.v2.PackageVersion
    public boolean getHasKnownVulnerability() {
        return this.antiFeatures.containsKey(PackageV2Kt.ANTI_FEATURE_KNOWN_VULNERABILITY);
    }

    public final void walkFiles(Function1 fileConsumer) {
        Intrinsics.checkNotNullParameter(fileConsumer, "fileConsumer");
        fileConsumer.invoke(this.src);
    }
}
