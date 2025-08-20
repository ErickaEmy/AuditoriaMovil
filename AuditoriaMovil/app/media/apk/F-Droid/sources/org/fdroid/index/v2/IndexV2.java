package org.fdroid.index.v2;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
/* compiled from: IndexV2.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002&'B9\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0010\rJ\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0003J)\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\bHÖ\u0001J\u001c\u0010\u001a\u001a\u00020\u001b2\u0014\u0010\u001c\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0012\u0004\u0012\u00020\u001b0\u001dJ&\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$HÁ\u0001¢\u0006\u0002\b%R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006("}, d2 = {"Lorg/fdroid/index/v2/IndexV2;", "", "seen1", "", "repo", "Lorg/fdroid/index/v2/RepoV2;", "packages", "", "", "Lorg/fdroid/index/v2/PackageV2;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILorg/fdroid/index/v2/RepoV2;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lorg/fdroid/index/v2/RepoV2;Ljava/util/Map;)V", "getPackages", "()Ljava/util/Map;", "getRepo", "()Lorg/fdroid/index/v2/RepoV2;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "walkFiles", "", "fileConsumer", "Lkotlin/Function1;", "Lorg/fdroid/index/v2/FileV2;", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$index_release", "$serializer", "Companion", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final class IndexV2 {
    private final Map<String, PackageV2> packages;
    private final RepoV2 repo;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer[] $childSerializers = {null, new LinkedHashMapSerializer(StringSerializer.INSTANCE, PackageV2$$serializer.INSTANCE)};

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IndexV2 copy$default(IndexV2 indexV2, RepoV2 repoV2, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            repoV2 = indexV2.repo;
        }
        if ((i & 2) != 0) {
            map = indexV2.packages;
        }
        return indexV2.copy(repoV2, map);
    }

    public final RepoV2 component1() {
        return this.repo;
    }

    public final Map<String, PackageV2> component2() {
        return this.packages;
    }

    public final IndexV2 copy(RepoV2 repo, Map<String, PackageV2> packages) {
        Intrinsics.checkNotNullParameter(repo, "repo");
        Intrinsics.checkNotNullParameter(packages, "packages");
        return new IndexV2(repo, packages);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IndexV2) {
            IndexV2 indexV2 = (IndexV2) obj;
            return Intrinsics.areEqual(this.repo, indexV2.repo) && Intrinsics.areEqual(this.packages, indexV2.packages);
        }
        return false;
    }

    public final Map<String, PackageV2> getPackages() {
        return this.packages;
    }

    public final RepoV2 getRepo() {
        return this.repo;
    }

    public int hashCode() {
        return (this.repo.hashCode() * 31) + this.packages.hashCode();
    }

    public String toString() {
        RepoV2 repoV2 = this.repo;
        Map<String, PackageV2> map = this.packages;
        return "IndexV2(repo=" + repoV2 + ", packages=" + map + ")";
    }

    /* compiled from: IndexV2.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lorg/fdroid/index/v2/IndexV2$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lorg/fdroid/index/v2/IndexV2;", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer serializer() {
            return IndexV2$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ IndexV2(int i, RepoV2 repoV2, Map map, SerializationConstructorMarker serializationConstructorMarker) {
        Map<String, PackageV2> emptyMap;
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, IndexV2$$serializer.INSTANCE.getDescriptor());
        }
        this.repo = repoV2;
        if ((i & 2) != 0) {
            this.packages = map;
            return;
        }
        emptyMap = MapsKt__MapsKt.emptyMap();
        this.packages = emptyMap;
    }

    public IndexV2(RepoV2 repo, Map<String, PackageV2> packages) {
        Intrinsics.checkNotNullParameter(repo, "repo");
        Intrinsics.checkNotNullParameter(packages, "packages");
        this.repo = repo;
        this.packages = packages;
    }

    public static final /* synthetic */ void write$Self$index_release(IndexV2 indexV2, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        Map emptyMap;
        KSerializer[] kSerializerArr = $childSerializers;
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, RepoV2$$serializer.INSTANCE, indexV2.repo);
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1)) {
            Map<String, PackageV2> map = indexV2.packages;
            emptyMap = MapsKt__MapsKt.emptyMap();
            if (Intrinsics.areEqual(map, emptyMap)) {
                return;
            }
        }
        compositeEncoder.encodeSerializableElement(serialDescriptor, 1, kSerializerArr[1], indexV2.packages);
    }

    public /* synthetic */ IndexV2(RepoV2 repoV2, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(repoV2, (i & 2) != 0 ? MapsKt__MapsKt.emptyMap() : map);
    }

    public final void walkFiles(Function1 fileConsumer) {
        Intrinsics.checkNotNullParameter(fileConsumer, "fileConsumer");
        this.repo.walkFiles(fileConsumer);
        for (PackageV2 packageV2 : this.packages.values()) {
            packageV2.walkFiles(fileConsumer);
        }
    }
}
