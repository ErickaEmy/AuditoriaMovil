package org.fdroid.database;

import androidx.core.os.LocaleListCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.fdroid.LocaleChooser;
import org.fdroid.fdroid.nearby.peers.BonjourPeer;
import org.fdroid.fdroid.views.apps.AppListActivity;
import org.fdroid.index.IndexFormatVersion;
import org.fdroid.index.IndexUtils;
import org.fdroid.index.v2.FileV2;
/* compiled from: Repository.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b1\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B_\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0010BO\b\u0000\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0014\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0014\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0014\u0012\u0006\u0010\u001c\u001a\u00020\u001d¢\u0006\u0002\u0010\u001eJ\u000e\u0010J\u001a\u00020\u0012HÀ\u0003¢\u0006\u0002\bKJ\u0014\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014HÀ\u0003¢\u0006\u0002\bMJ\u0014\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00170\u0014HÀ\u0003¢\u0006\u0002\bOJ\u0014\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00190\u0014HÀ\u0003¢\u0006\u0002\bQJ\u0014\u0010R\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0014HÀ\u0003¢\u0006\u0002\bSJ\u000e\u0010T\u001a\u00020\u001dHÀ\u0003¢\u0006\u0002\bUJ]\u0010V\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00142\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00142\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00142\b\b\u0002\u0010\u001c\u001a\u00020\u001dHÆ\u0001J\u0013\u0010W\u001a\u00020(2\b\u0010X\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0018\u0010Y\u001a\b\u0012\u0004\u0012\u00020Z0\u00142\b\b\u0002\u0010[\u001a\u00020(H\u0007J\u0012\u0010\\\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00170]J\u0012\u0010^\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00190]J\u0010\u0010_\u001a\u0004\u0018\u00010\u00052\u0006\u0010`\u001a\u00020aJ\u0010\u0010b\u001a\u0004\u0018\u00010c2\u0006\u0010`\u001a\u00020aJ\f\u0010d\u001a\b\u0012\u0004\u0012\u00020Z0\u0014J\u0010\u0010e\u001a\u0004\u0018\u00010\u00052\u0006\u0010`\u001a\u00020aJ\u0012\u0010f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001b0]J\t\u0010g\u001a\u00020\fHÖ\u0001J\t\u0010h\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00148\u0000X\u0081\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00148\u0000X\u0081\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0011\u0010\t\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b$\u0010 R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\u00148F¢\u0006\u0006\u001a\u0004\b&\u0010\"R\u0011\u0010'\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\b)\u0010*R\u001d\u0010+\u001a\u0004\u0018\u00010\u00058FX\u0087\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b,\u0010 R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b/\u00100R\u0011\u00101\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\b1\u0010*R\u001c\u00102\u001a\u0004\u0018\u00010\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b3\u00104\u001a\u0004\b5\u0010 R\u0013\u0010\r\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b6\u00107R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0000X\u0081\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\"R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b9\u0010 R\u0016\u0010\u001c\u001a\u00020\u001d8\u0000X\u0081\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00148\u0000X\u0081\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\"R\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0016\u0010\u0011\u001a\u00020\u00128\u0000X\u0081\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0011\u0010\u0006\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bA\u0010>R\u0017\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00050\u00148F¢\u0006\u0006\u001a\u0004\bC\u0010\"R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\bD\u0010 R\u0011\u0010\n\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bE\u0010>R\u0013\u0010F\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\bG\u0010 R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\bH\u0010I¨\u0006i"}, d2 = {"Lorg/fdroid/database/Repository;", "", "repoId", "", "address", "", "timestamp", "formatVersion", "Lorg/fdroid/index/IndexFormatVersion;", "certificate", "version", "weight", "", AppListActivity.SortClause.LAST_UPDATED, "username", "password", "(JLjava/lang/String;JLorg/fdroid/index/IndexFormatVersion;Ljava/lang/String;JIJLjava/lang/String;Ljava/lang/String;)V", "repository", "Lorg/fdroid/database/CoreRepository;", "mirrors", "", "Lorg/fdroid/database/Mirror;", "antiFeatures", "Lorg/fdroid/database/AntiFeature;", "categories", "Lorg/fdroid/database/Category;", "releaseChannels", "Lorg/fdroid/database/ReleaseChannel;", "preferences", "Lorg/fdroid/database/RepositoryPreferences;", "(Lorg/fdroid/database/CoreRepository;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lorg/fdroid/database/RepositoryPreferences;)V", "getAddress", "()Ljava/lang/String;", "getAntiFeatures$database_release", "()Ljava/util/List;", "getCategories$database_release", "getCertificate", "disabledMirrors", "getDisabledMirrors", "enabled", "", "getEnabled", "()Z", BonjourPeer.FINGERPRINT, "getFingerprint", "fingerprint$delegate", "Lkotlin/Lazy;", "getFormatVersion", "()Lorg/fdroid/index/IndexFormatVersion;", "isArchiveRepo", "lastETag", "getLastETag$annotations", "()V", "getLastETag", "getLastUpdated", "()Ljava/lang/Long;", "getMirrors$database_release", "getPassword", "getPreferences$database_release", "()Lorg/fdroid/database/RepositoryPreferences;", "getReleaseChannels$database_release", "getRepoId", "()J", "getRepository$database_release", "()Lorg/fdroid/database/CoreRepository;", "getTimestamp", "userMirrors", "getUserMirrors", "getUsername", "getVersion", "webBaseUrl", "getWebBaseUrl", "getWeight", "()I", "component1", "component1$database_release", "component2", "component2$database_release", "component3", "component3$database_release", "component4", "component4$database_release", "component5", "component5$database_release", "component6", "component6$database_release", "copy", "equals", "other", "getAllMirrors", "Lorg/fdroid/download/Mirror;", "includeUserMirrors", "getAntiFeatures", "", "getCategories", "getDescription", "localeList", "Landroidx/core/os/LocaleListCompat;", "getIcon", "Lorg/fdroid/index/v2/FileV2;", "getMirrors", "getName", "getReleaseChannels", "hashCode", "toString", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Repository {
    private final List<AntiFeature> antiFeatures;
    private final List<Category> categories;
    private final Lazy fingerprint$delegate;
    private final List<Mirror> mirrors;
    private final RepositoryPreferences preferences;
    private final List<ReleaseChannel> releaseChannels;
    private final CoreRepository repository;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Repository(long j, String address, long j2, IndexFormatVersion formatVersion, String certificate, long j3, int i, long j4) {
        this(j, address, j2, formatVersion, certificate, j3, i, j4, null, null, 768, null);
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(formatVersion, "formatVersion");
        Intrinsics.checkNotNullParameter(certificate, "certificate");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Repository(long j, String address, long j2, IndexFormatVersion formatVersion, String certificate, long j3, int i, long j4, String str) {
        this(j, address, j2, formatVersion, certificate, j3, i, j4, str, null, 512, null);
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(formatVersion, "formatVersion");
        Intrinsics.checkNotNullParameter(certificate, "certificate");
    }

    public static /* synthetic */ Repository copy$default(Repository repository, CoreRepository coreRepository, List list, List list2, List list3, List list4, RepositoryPreferences repositoryPreferences, int i, Object obj) {
        if ((i & 1) != 0) {
            coreRepository = repository.repository;
        }
        List<Mirror> list5 = list;
        if ((i & 2) != 0) {
            list5 = repository.mirrors;
        }
        List list6 = list5;
        List<AntiFeature> list7 = list2;
        if ((i & 4) != 0) {
            list7 = repository.antiFeatures;
        }
        List list8 = list7;
        List<Category> list9 = list3;
        if ((i & 8) != 0) {
            list9 = repository.categories;
        }
        List list10 = list9;
        List<ReleaseChannel> list11 = list4;
        if ((i & 16) != 0) {
            list11 = repository.releaseChannels;
        }
        List list12 = list11;
        if ((i & 32) != 0) {
            repositoryPreferences = repository.preferences;
        }
        return repository.copy(coreRepository, list6, list8, list10, list12, repositoryPreferences);
    }

    public static /* synthetic */ void getLastETag$annotations() {
    }

    public final CoreRepository component1$database_release() {
        return this.repository;
    }

    public final List<Mirror> component2$database_release() {
        return this.mirrors;
    }

    public final List<AntiFeature> component3$database_release() {
        return this.antiFeatures;
    }

    public final List<Category> component4$database_release() {
        return this.categories;
    }

    public final List<ReleaseChannel> component5$database_release() {
        return this.releaseChannels;
    }

    public final RepositoryPreferences component6$database_release() {
        return this.preferences;
    }

    public final Repository copy(CoreRepository repository, List<Mirror> mirrors, List<AntiFeature> antiFeatures, List<Category> categories, List<ReleaseChannel> releaseChannels, RepositoryPreferences preferences) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(mirrors, "mirrors");
        Intrinsics.checkNotNullParameter(antiFeatures, "antiFeatures");
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(releaseChannels, "releaseChannels");
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        return new Repository(repository, mirrors, antiFeatures, categories, releaseChannels, preferences);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Repository) {
            Repository repository = (Repository) obj;
            return Intrinsics.areEqual(this.repository, repository.repository) && Intrinsics.areEqual(this.mirrors, repository.mirrors) && Intrinsics.areEqual(this.antiFeatures, repository.antiFeatures) && Intrinsics.areEqual(this.categories, repository.categories) && Intrinsics.areEqual(this.releaseChannels, repository.releaseChannels) && Intrinsics.areEqual(this.preferences, repository.preferences);
        }
        return false;
    }

    public final List<org.fdroid.download.Mirror> getAllMirrors() {
        return getAllMirrors$default(this, false, 1, null);
    }

    public final List<AntiFeature> getAntiFeatures$database_release() {
        return this.antiFeatures;
    }

    public final List<Category> getCategories$database_release() {
        return this.categories;
    }

    public final List<Mirror> getMirrors$database_release() {
        return this.mirrors;
    }

    public final RepositoryPreferences getPreferences$database_release() {
        return this.preferences;
    }

    public final List<ReleaseChannel> getReleaseChannels$database_release() {
        return this.releaseChannels;
    }

    public final CoreRepository getRepository$database_release() {
        return this.repository;
    }

    public int hashCode() {
        return (((((((((this.repository.hashCode() * 31) + this.mirrors.hashCode()) * 31) + this.antiFeatures.hashCode()) * 31) + this.categories.hashCode()) * 31) + this.releaseChannels.hashCode()) * 31) + this.preferences.hashCode();
    }

    public String toString() {
        CoreRepository coreRepository = this.repository;
        List<Mirror> list = this.mirrors;
        List<AntiFeature> list2 = this.antiFeatures;
        List<Category> list3 = this.categories;
        List<ReleaseChannel> list4 = this.releaseChannels;
        RepositoryPreferences repositoryPreferences = this.preferences;
        return "Repository(repository=" + coreRepository + ", mirrors=" + list + ", antiFeatures=" + list2 + ", categories=" + list3 + ", releaseChannels=" + list4 + ", preferences=" + repositoryPreferences + ")";
    }

    public Repository(CoreRepository repository, List<Mirror> mirrors, List<AntiFeature> antiFeatures, List<Category> categories, List<ReleaseChannel> releaseChannels, RepositoryPreferences preferences) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(mirrors, "mirrors");
        Intrinsics.checkNotNullParameter(antiFeatures, "antiFeatures");
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(releaseChannels, "releaseChannels");
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        this.repository = repository;
        this.mirrors = mirrors;
        this.antiFeatures = antiFeatures;
        this.categories = categories;
        this.releaseChannels = releaseChannels;
        this.preferences = preferences;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: org.fdroid.database.Repository$fingerprint$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String certificate = Repository.this.getCertificate();
                if (certificate != null) {
                    return IndexUtils.INSTANCE.getFingerprint(certificate);
                }
                return null;
            }
        });
        this.fingerprint$delegate = lazy;
    }

    public /* synthetic */ Repository(long j, String str, long j2, IndexFormatVersion indexFormatVersion, String str2, long j3, int i, long j4, String str3, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, j2, indexFormatVersion, str2, j3, i, j4, (i2 & 256) != 0 ? null : str3, (i2 & 512) != 0 ? null : str4);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Repository(long r20, java.lang.String r22, long r23, org.fdroid.index.IndexFormatVersion r25, java.lang.String r26, long r27, int r29, long r30, java.lang.String r32, java.lang.String r33) {
        /*
            r19 = this;
            java.lang.String r0 = "address"
            r6 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "formatVersion"
            r11 = r25
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "certificate"
            r14 = r26
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            org.fdroid.database.CoreRepository r0 = new org.fdroid.database.CoreRepository
            r4 = 0
            r5 = 0
            r7 = 0
            java.lang.Long r10 = java.lang.Long.valueOf(r27)
            r1 = 42
            java.lang.Integer r12 = java.lang.Integer.valueOf(r1)
            r13 = 0
            r15 = 530(0x212, float:7.43E-43)
            r16 = 0
            r1 = r0
            r2 = r20
            r8 = r23
            r1.<init>(r2, r4, r5, r6, r7, r8, r10, r11, r12, r13, r14, r15, r16)
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
            java.util.List r3 = kotlin.collections.CollectionsKt.emptyList()
            java.util.List r4 = kotlin.collections.CollectionsKt.emptyList()
            org.fdroid.database.RepositoryPreferences r18 = new org.fdroid.database.RepositoryPreferences
            r9 = 0
            java.lang.Long r10 = java.lang.Long.valueOf(r30)
            r11 = 0
            r12 = 0
            r16 = 116(0x74, float:1.63E-43)
            r17 = 0
            r5 = r18
            r6 = r20
            r8 = r29
            r14 = r32
            r15 = r33
            r5.<init>(r6, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r20 = r19
            r21 = r0
            r22 = r1
            r23 = r2
            r24 = r3
            r25 = r4
            r26 = r18
            r20.<init>(r21, r22, r23, r24, r25, r26)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.database.Repository.<init>(long, java.lang.String, long, org.fdroid.index.IndexFormatVersion, java.lang.String, long, int, long, java.lang.String, java.lang.String):void");
    }

    public final long getRepoId() {
        return this.repository.getRepoId();
    }

    public final String getAddress() {
        return this.repository.getAddress();
    }

    public final String getWebBaseUrl() {
        return this.repository.getWebBaseUrl();
    }

    public final long getTimestamp() {
        return this.repository.getTimestamp();
    }

    public final long getVersion() {
        Long version = this.repository.getVersion();
        if (version != null) {
            return version.longValue();
        }
        return 0L;
    }

    public final IndexFormatVersion getFormatVersion() {
        return this.repository.getFormatVersion();
    }

    public final String getCertificate() {
        return this.repository.getCertificate();
    }

    public final boolean isArchiveRepo() {
        String trimEnd;
        boolean endsWith$default;
        trimEnd = StringsKt__StringsKt.trimEnd(this.repository.getAddress(), '/');
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(trimEnd, "/archive", false, 2, null);
        return endsWith$default;
    }

    public final String getName(LocaleListCompat localeList) {
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        return (String) LocaleChooser.INSTANCE.getBestLocale(this.repository.getName(), localeList);
    }

    public final String getDescription(LocaleListCompat localeList) {
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        return (String) LocaleChooser.INSTANCE.getBestLocale(this.repository.getDescription(), localeList);
    }

    public final FileV2 getIcon(LocaleListCompat localeList) {
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        return (FileV2) LocaleChooser.INSTANCE.getBestLocale(this.repository.getIcon(), localeList);
    }

    public final int getWeight() {
        return this.preferences.getWeight();
    }

    public final boolean getEnabled() {
        return this.preferences.getEnabled();
    }

    public final Long getLastUpdated() {
        return this.preferences.getLastUpdated();
    }

    public final List<String> getUserMirrors() {
        List<String> emptyList;
        List<String> userMirrors = this.preferences.getUserMirrors();
        if (userMirrors == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return userMirrors;
    }

    public final List<String> getDisabledMirrors() {
        List<String> emptyList;
        List<String> disabledMirrors = this.preferences.getDisabledMirrors();
        if (disabledMirrors == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return disabledMirrors;
    }

    public final String getUsername() {
        return this.preferences.getUsername();
    }

    public final String getPassword() {
        return this.preferences.getPassword();
    }

    public final String getLastETag() {
        return this.preferences.getLastETag();
    }

    public final String getFingerprint() {
        return (String) this.fingerprint$delegate.getValue();
    }

    public final List<org.fdroid.download.Mirror> getMirrors() {
        List<org.fdroid.download.Mirror> listOf;
        List<org.fdroid.download.Mirror> allMirrors = getAllMirrors(true);
        ArrayList arrayList = new ArrayList();
        for (Object obj : allMirrors) {
            if (!getDisabledMirrors().contains(((org.fdroid.download.Mirror) obj).getBaseUrl())) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new org.fdroid.download.Mirror(getAddress(), null, false, 6, null));
            return listOf;
        }
        return arrayList;
    }

    public static /* synthetic */ List getAllMirrors$default(Repository repository, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return repository.getAllMirrors(z);
    }

    public final Map<String, AntiFeature> getAntiFeatures() {
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        List<AntiFeature> list = this.antiFeatures;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (Object obj : list) {
            linkedHashMap.put(((AntiFeature) obj).getId$database_release(), obj);
        }
        return linkedHashMap;
    }

    public final Map<String, Category> getCategories() {
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        List<Category> list = this.categories;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (Object obj : list) {
            linkedHashMap.put(((Category) obj).getId(), obj);
        }
        return linkedHashMap;
    }

    public final Map<String, ReleaseChannel> getReleaseChannels() {
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        List<ReleaseChannel> list = this.releaseChannels;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (Object obj : list) {
            linkedHashMap.put(((ReleaseChannel) obj).getId$database_release(), obj);
        }
        return linkedHashMap;
    }

    public final List<org.fdroid.download.Mirror> getAllMirrors(boolean z) {
        int collectionSizeOrDefault;
        Collection emptyList;
        List<org.fdroid.download.Mirror> plus;
        Object obj;
        List<org.fdroid.download.Mirror> mutableList;
        int collectionSizeOrDefault2;
        List<Mirror> list = this.mirrors;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Mirror mirror : list) {
            arrayList.add(mirror.toDownloadMirror());
        }
        if (z) {
            List<String> userMirrors = getUserMirrors();
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(userMirrors, 10);
            emptyList = new ArrayList(collectionSizeOrDefault2);
            for (String str : userMirrors) {
                emptyList.add(new org.fdroid.download.Mirror(str, null, false, 6, null));
            }
        } else {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        plus = CollectionsKt___CollectionsKt.plus((Collection) arrayList, (Iterable) emptyList);
        Iterator<T> it = plus.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((org.fdroid.download.Mirror) obj).getBaseUrl(), getAddress())) {
                break;
            }
        }
        if (obj != null) {
            return plus;
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) plus);
        mutableList.add(0, new org.fdroid.download.Mirror(getAddress(), null, false, 6, null));
        return mutableList;
    }
}
