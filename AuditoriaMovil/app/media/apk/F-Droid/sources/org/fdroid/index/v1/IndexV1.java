package org.fdroid.index.v1;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
/* compiled from: IndexV1.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002-.BY\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t\u0018\u00010\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011BC\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\f¢\u0006\u0002\u0010\u0012J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u001b\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\fHÆ\u0003JI\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\fHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\rHÖ\u0001J&\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+HÁ\u0001¢\u0006\u0002\b,R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R#\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\t0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006/"}, d2 = {"Lorg/fdroid/index/v1/IndexV1;", "", "seen1", "", "repo", "Lorg/fdroid/index/v1/RepoV1;", "requests", "Lorg/fdroid/index/v1/Requests;", "apps", "", "Lorg/fdroid/index/v1/AppV1;", "packages", "", "", "Lorg/fdroid/index/v1/PackageV1;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILorg/fdroid/index/v1/RepoV1;Lorg/fdroid/index/v1/Requests;Ljava/util/List;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lorg/fdroid/index/v1/RepoV1;Lorg/fdroid/index/v1/Requests;Ljava/util/List;Ljava/util/Map;)V", "getApps", "()Ljava/util/List;", "getPackages", "()Ljava/util/Map;", "getRepo", "()Lorg/fdroid/index/v1/RepoV1;", "getRequests", "()Lorg/fdroid/index/v1/Requests;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$index_release", "$serializer", "Companion", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final class IndexV1 {
    private final List<AppV1> apps;
    private final Map<String, List<PackageV1>> packages;
    private final RepoV1 repo;
    private final Requests requests;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer[] $childSerializers = {null, null, new ArrayListSerializer(AppV1$$serializer.INSTANCE), new LinkedHashMapSerializer(StringSerializer.INSTANCE, new ArrayListSerializer(PackageV1$$serializer.INSTANCE))};

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IndexV1 copy$default(IndexV1 indexV1, RepoV1 repoV1, Requests requests, List list, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            repoV1 = indexV1.repo;
        }
        if ((i & 2) != 0) {
            requests = indexV1.requests;
        }
        if ((i & 4) != 0) {
            list = indexV1.apps;
        }
        if ((i & 8) != 0) {
            map = indexV1.packages;
        }
        return indexV1.copy(repoV1, requests, list, map);
    }

    public final RepoV1 component1() {
        return this.repo;
    }

    public final Requests component2() {
        return this.requests;
    }

    public final List<AppV1> component3() {
        return this.apps;
    }

    public final Map<String, List<PackageV1>> component4() {
        return this.packages;
    }

    public final IndexV1 copy(RepoV1 repo, Requests requests, List<AppV1> apps, Map<String, ? extends List<PackageV1>> packages) {
        Intrinsics.checkNotNullParameter(repo, "repo");
        Intrinsics.checkNotNullParameter(requests, "requests");
        Intrinsics.checkNotNullParameter(apps, "apps");
        Intrinsics.checkNotNullParameter(packages, "packages");
        return new IndexV1(repo, requests, apps, packages);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IndexV1) {
            IndexV1 indexV1 = (IndexV1) obj;
            return Intrinsics.areEqual(this.repo, indexV1.repo) && Intrinsics.areEqual(this.requests, indexV1.requests) && Intrinsics.areEqual(this.apps, indexV1.apps) && Intrinsics.areEqual(this.packages, indexV1.packages);
        }
        return false;
    }

    public final List<AppV1> getApps() {
        return this.apps;
    }

    public final Map<String, List<PackageV1>> getPackages() {
        return this.packages;
    }

    public final RepoV1 getRepo() {
        return this.repo;
    }

    public final Requests getRequests() {
        return this.requests;
    }

    public int hashCode() {
        return (((((this.repo.hashCode() * 31) + this.requests.hashCode()) * 31) + this.apps.hashCode()) * 31) + this.packages.hashCode();
    }

    public String toString() {
        RepoV1 repoV1 = this.repo;
        Requests requests = this.requests;
        List<AppV1> list = this.apps;
        Map<String, List<PackageV1>> map = this.packages;
        return "IndexV1(repo=" + repoV1 + ", requests=" + requests + ", apps=" + list + ", packages=" + map + ")";
    }

    /* compiled from: IndexV1.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lorg/fdroid/index/v1/IndexV1$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lorg/fdroid/index/v1/IndexV1;", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer serializer() {
            return IndexV1$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ IndexV1(int i, RepoV1 repoV1, Requests requests, List list, Map map, SerializationConstructorMarker serializationConstructorMarker) {
        Map<String, List<PackageV1>> emptyMap;
        List<AppV1> emptyList;
        List emptyList2;
        List emptyList3;
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, IndexV1$$serializer.INSTANCE.getDescriptor());
        }
        this.repo = repoV1;
        if ((i & 2) == 0) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            emptyList3 = CollectionsKt__CollectionsKt.emptyList();
            this.requests = new Requests(emptyList2, emptyList3);
        } else {
            this.requests = requests;
        }
        if ((i & 4) == 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.apps = emptyList;
        } else {
            this.apps = list;
        }
        if ((i & 8) != 0) {
            this.packages = map;
            return;
        }
        emptyMap = MapsKt__MapsKt.emptyMap();
        this.packages = emptyMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public IndexV1(RepoV1 repo, Requests requests, List<AppV1> apps, Map<String, ? extends List<PackageV1>> packages) {
        Intrinsics.checkNotNullParameter(repo, "repo");
        Intrinsics.checkNotNullParameter(requests, "requests");
        Intrinsics.checkNotNullParameter(apps, "apps");
        Intrinsics.checkNotNullParameter(packages, "packages");
        this.repo = repo;
        this.requests = requests;
        this.apps = apps;
        this.packages = packages;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0040, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r3) == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0025, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, new org.fdroid.index.v1.Requests(r4, r5)) == false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void write$Self$index_release(org.fdroid.index.v1.IndexV1 r6, kotlinx.serialization.encoding.CompositeEncoder r7, kotlinx.serialization.descriptors.SerialDescriptor r8) {
        /*
            kotlinx.serialization.KSerializer[] r0 = org.fdroid.index.v1.IndexV1.$childSerializers
            org.fdroid.index.v1.RepoV1$$serializer r1 = org.fdroid.index.v1.RepoV1$$serializer.INSTANCE
            org.fdroid.index.v1.RepoV1 r2 = r6.repo
            r3 = 0
            r7.encodeSerializableElement(r8, r3, r1, r2)
            r1 = 1
            boolean r2 = r7.shouldEncodeElementDefault(r8, r1)
            if (r2 == 0) goto L12
            goto L27
        L12:
            org.fdroid.index.v1.Requests r2 = r6.requests
            org.fdroid.index.v1.Requests r3 = new org.fdroid.index.v1.Requests
            java.util.List r4 = kotlin.collections.CollectionsKt.emptyList()
            java.util.List r5 = kotlin.collections.CollectionsKt.emptyList()
            r3.<init>(r4, r5)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            if (r2 != 0) goto L2e
        L27:
            org.fdroid.index.v1.Requests$$serializer r2 = org.fdroid.index.v1.Requests$$serializer.INSTANCE
            org.fdroid.index.v1.Requests r3 = r6.requests
            r7.encodeSerializableElement(r8, r1, r2, r3)
        L2e:
            r1 = 2
            boolean r2 = r7.shouldEncodeElementDefault(r8, r1)
            if (r2 == 0) goto L36
            goto L42
        L36:
            java.util.List<org.fdroid.index.v1.AppV1> r2 = r6.apps
            java.util.List r3 = kotlin.collections.CollectionsKt.emptyList()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            if (r2 != 0) goto L49
        L42:
            r2 = r0[r1]
            java.util.List<org.fdroid.index.v1.AppV1> r3 = r6.apps
            r7.encodeSerializableElement(r8, r1, r2, r3)
        L49:
            r1 = 3
            boolean r2 = r7.shouldEncodeElementDefault(r8, r1)
            if (r2 == 0) goto L51
            goto L5d
        L51:
            java.util.Map<java.lang.String, java.util.List<org.fdroid.index.v1.PackageV1>> r2 = r6.packages
            java.util.Map r3 = kotlin.collections.MapsKt.emptyMap()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            if (r2 != 0) goto L64
        L5d:
            r0 = r0[r1]
            java.util.Map<java.lang.String, java.util.List<org.fdroid.index.v1.PackageV1>> r6 = r6.packages
            r7.encodeSerializableElement(r8, r1, r0, r6)
        L64:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.index.v1.IndexV1.write$Self$index_release(org.fdroid.index.v1.IndexV1, kotlinx.serialization.encoding.CompositeEncoder, kotlinx.serialization.descriptors.SerialDescriptor):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ IndexV1(org.fdroid.index.v1.RepoV1 r2, org.fdroid.index.v1.Requests r3, java.util.List r4, java.util.Map r5, int r6, kotlin.jvm.internal.DefaultConstructorMarker r7) {
        /*
            r1 = this;
            r7 = r6 & 2
            if (r7 == 0) goto L11
            org.fdroid.index.v1.Requests r3 = new org.fdroid.index.v1.Requests
            java.util.List r7 = kotlin.collections.CollectionsKt.emptyList()
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            r3.<init>(r7, r0)
        L11:
            r7 = r6 & 4
            if (r7 == 0) goto L19
            java.util.List r4 = kotlin.collections.CollectionsKt.emptyList()
        L19:
            r6 = r6 & 8
            if (r6 == 0) goto L21
            java.util.Map r5 = kotlin.collections.MapsKt.emptyMap()
        L21:
            r1.<init>(r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.index.v1.IndexV1.<init>(org.fdroid.index.v1.RepoV1, org.fdroid.index.v1.Requests, java.util.List, java.util.Map, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
