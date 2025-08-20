package org.fdroid.database;

import androidx.lifecycle.LiveData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonObject;
import org.fdroid.index.IndexConverterKt;
import org.fdroid.index.IndexFormatVersion;
import org.fdroid.index.IndexParser;
import org.fdroid.index.v2.MirrorV2;
import org.fdroid.index.v2.ReflectionDiffer;
import org.fdroid.index.v2.RepoV2;
/* compiled from: RepositoryDao.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\b\u0010\u0006\u001a\u00020\u0003H\u0017J\b\u0010\u0007\u001a\u00020\bH'J\b\u0010\t\u001a\u00020\bH'J\b\u0010\n\u001a\u00020\bH'J\b\u0010\u000b\u001a\u00020\bH'J\b\u0010\f\u001a\u00020\u0003H'J\b\u0010\r\u001a\u00020\u0003H'J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H'J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H'J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H'J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0017\u0010\u001a\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001b\u001a\u00020\u0010H'¢\u0006\u0002\u0010\u001cJ\u0014\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001eH'J\u0014\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u001f0\u001eH'J\b\u0010#\u001a\u00020\bH'J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\u001fH'J\u0012\u0010%\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0012\u0010%\u001a\u0004\u0018\u00010\"2\u0006\u0010&\u001a\u00020\u0010H'J\u0012\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020+H\u0017J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010,\u001a\u00020-H\u0017J\u0010\u0010)\u001a\u00020\u00032\u0006\u0010.\u001a\u00020(H'J\u0016\u0010/\u001a\u00020\u00032\f\u00100\u001a\b\u0012\u0004\u0012\u0002010\u001fH'J\u0016\u00102\u001a\u00020\u00032\f\u00100\u001a\b\u0012\u0004\u0012\u00020 0\u001fH'J2\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u00102\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010&\u001a\u00020\u0010H\u0017J\u0016\u00107\u001a\u00020\u00032\f\u00108\u001a\b\u0012\u0004\u0012\u0002090\u001fH'J\u0010\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020<H'J\u001a\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020\u0005H\u0017J\u0016\u0010?\u001a\u00020\u00032\f\u00100\u001a\b\u0012\u0004\u0012\u00020@0\u001fH'J\u0018\u0010A\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010;\u001a\u00020=H\u0002J\u0018\u0010B\u001a\u00020\u00032\u0006\u0010C\u001a\u00020\"2\u0006\u0010D\u001a\u00020\"H\u0017J\b\u0010E\u001a\u00020\u0003H'J\u0010\u0010F\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\b\u0010G\u001a\u00020\u0003H'J\u0018\u0010H\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010I\u001a\u00020JH\u0017J\u0018\u0010K\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010I\u001a\u00020JH'J\u0018\u0010L\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010M\u001a\u00020\bH'J \u0010N\u001a\u00020\u00032\u0006\u0010O\u001a\u00020\b2\u0006\u0010P\u001a\u00020\b2\u0006\u0010Q\u001a\u00020\bH'J(\u0010R\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010;\u001a\u00020=2\u0006\u0010>\u001a\u00020\u00052\u0006\u0010S\u001a\u00020TH\u0017J\u0010\u0010R\u001a\u00020\u00032\u0006\u0010;\u001a\u00020<H'J\u001e\u0010U\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00100\u001fH'J \u0010W\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u00052\u0006\u0010X\u001a\u00020YH\u0017J\u0010\u0010W\u001a\u00020\b2\u0006\u0010Z\u001a\u00020<H'J\u0010\u0010[\u001a\u00020\u00032\u0006\u0010\\\u001a\u00020(H'J\u001e\u0010]\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00100\u001fH'J$\u0010^\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u00105\u001a\u0004\u0018\u00010\u00102\b\u00106\u001a\u0004\u0018\u00010\u0010H'¨\u0006_"}, d2 = {"Lorg/fdroid/database/RepositoryDaoInt;", "Lorg/fdroid/database/RepositoryDao;", "clear", "", "repoId", "", "clearAll", "countAntiFeatures", "", "countCategories", "countMirrors", "countReleaseChannels", "deleteAllCoreRepositories", "deleteAllRepositoryPreferences", "deleteAntiFeature", "id", "", "deleteAntiFeatures", "deleteCategories", "deleteCategory", "deleteCoreRepository", "deleteMirrors", "deleteReleaseChannel", "deleteReleaseChannels", "deleteRepository", "deleteRepositoryPreferences", "getArchiveRepoId", "cert", "(Ljava/lang/String;)Ljava/lang/Long;", "getLiveCategories", "Landroidx/lifecycle/LiveData;", "", "Lorg/fdroid/database/Category;", "getLiveRepositories", "Lorg/fdroid/database/Repository;", "getMinRepositoryWeight", "getRepositories", "getRepository", "certificate", "getRepositoryPreferences", "Lorg/fdroid/database/RepositoryPreferences;", "insert", "initialRepo", "Lorg/fdroid/database/InitialRepository;", "newRepository", "Lorg/fdroid/database/NewRepository;", "repositoryPreferences", "insertAntiFeatures", "repoFeature", "Lorg/fdroid/database/AntiFeature;", "insertCategories", "insertEmptyRepo", "address", "username", "password", "insertMirrors", "mirrors", "Lorg/fdroid/database/Mirror;", "insertOrReplace", "repository", "Lorg/fdroid/database/CoreRepository;", "Lorg/fdroid/index/v2/RepoV2;", "version", "insertReleaseChannels", "Lorg/fdroid/database/ReleaseChannel;", "insertRepoTables", "reorderRepositories", "repoToReorder", "repoTarget", "resetETags", "resetPreferredRepoInAppPrefs", "resetTimestamps", "setRepositoryEnabled", "enabled", "", "setRepositoryEnabledInternal", "setWeight", "weight", "shiftRepoWeights", "weightFrom", "weightTo", "offset", "update", "formatVersion", "Lorg/fdroid/index/IndexFormatVersion;", "updateDisabledMirrors", "disabledMirrors", "updateRepository", "jsonObject", "Lkotlinx/serialization/json/JsonObject;", "repo", "updateRepositoryPreferences", "preferences", "updateUserMirrors", "updateUsernameAndPassword", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface RepositoryDaoInt extends RepositoryDao {
    void clear(long j);

    @Override // org.fdroid.database.RepositoryDao
    void clearAll();

    int countAntiFeatures();

    int countCategories();

    int countMirrors();

    int countReleaseChannels();

    void deleteAllCoreRepositories();

    void deleteAllRepositoryPreferences();

    void deleteAntiFeature(long j, String str);

    void deleteAntiFeatures(long j);

    void deleteCategories(long j);

    void deleteCategory(long j, String str);

    void deleteCoreRepository(long j);

    void deleteMirrors(long j);

    void deleteReleaseChannel(long j, String str);

    void deleteReleaseChannels(long j);

    @Override // org.fdroid.database.RepositoryDao
    void deleteRepository(long j);

    void deleteRepositoryPreferences(long j);

    Long getArchiveRepoId(String str);

    @Override // org.fdroid.database.RepositoryDao
    LiveData getLiveCategories();

    @Override // org.fdroid.database.RepositoryDao
    LiveData getLiveRepositories();

    int getMinRepositoryWeight();

    @Override // org.fdroid.database.RepositoryDao
    List<Repository> getRepositories();

    @Override // org.fdroid.database.RepositoryDao
    Repository getRepository(long j);

    Repository getRepository(String str);

    RepositoryPreferences getRepositoryPreferences(long j);

    @Override // org.fdroid.database.RepositoryDao
    long insert(InitialRepository initialRepository);

    @Override // org.fdroid.database.RepositoryDao
    long insert(NewRepository newRepository);

    void insert(RepositoryPreferences repositoryPreferences);

    void insertAntiFeatures(List<AntiFeature> list);

    void insertCategories(List<Category> list);

    long insertEmptyRepo(String str, String str2, String str3, String str4);

    void insertMirrors(List<Mirror> list);

    long insertOrReplace(CoreRepository coreRepository);

    long insertOrReplace(RepoV2 repoV2, long j);

    void insertReleaseChannels(List<ReleaseChannel> list);

    void reorderRepositories(Repository repository, Repository repository2);

    void resetETags();

    void resetPreferredRepoInAppPrefs(long j);

    void resetTimestamps();

    @Override // org.fdroid.database.RepositoryDao
    void setRepositoryEnabled(long j, boolean z);

    void setRepositoryEnabledInternal(long j, boolean z);

    void setWeight(long j, int i);

    void shiftRepoWeights(int i, int i2, int i3);

    void update(long j, RepoV2 repoV2, long j2, IndexFormatVersion indexFormatVersion);

    void update(CoreRepository coreRepository);

    @Override // org.fdroid.database.RepositoryDao
    void updateDisabledMirrors(long j, List<String> list);

    int updateRepository(CoreRepository coreRepository);

    void updateRepository(long j, long j2, JsonObject jsonObject);

    void updateRepositoryPreferences(RepositoryPreferences repositoryPreferences);

    @Override // org.fdroid.database.RepositoryDao
    void updateUserMirrors(long j, List<String> list);

    @Override // org.fdroid.database.RepositoryDao
    void updateUsernameAndPassword(long j, String str, String str2);

    /* compiled from: RepositoryDao.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static long insert(RepositoryDaoInt repositoryDaoInt, InitialRepository initialRepo) {
            Map mapOf;
            Map mapOf2;
            int collectionSizeOrDefault;
            Intrinsics.checkNotNullParameter(initialRepo, "initialRepo");
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(IndexConverterKt.DEFAULT_LOCALE, initialRepo.getName()));
            String address = initialRepo.getAddress();
            long version = initialRepo.getVersion();
            mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(IndexConverterKt.DEFAULT_LOCALE, initialRepo.getDescription()));
            long insertOrReplace = repositoryDaoInt.insertOrReplace(new CoreRepository(0L, mapOf, null, address, null, -1L, Long.valueOf(version), null, null, mapOf2, initialRepo.getCertificate(), 17, null));
            repositoryDaoInt.insert(new RepositoryPreferences(insertOrReplace, repositoryDaoInt.getMinRepositoryWeight() - 2, initialRepo.getEnabled(), null, null, null, null, null, null, 496, null));
            List<String> mirrors = initialRepo.getMirrors();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(mirrors, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (String str : mirrors) {
                arrayList.add(new Mirror(insertOrReplace, str, null));
            }
            repositoryDaoInt.insertMirrors(arrayList);
            return insertOrReplace;
        }

        public static long insert(RepositoryDaoInt repositoryDaoInt, NewRepository newRepository) {
            Intrinsics.checkNotNullParameter(newRepository, "newRepository");
            long insertOrReplace = repositoryDaoInt.insertOrReplace(new CoreRepository(0L, newRepository.getName(), newRepository.getIcon(), newRepository.getAddress(), null, -1L, null, newRepository.getFormatVersion(), null, null, newRepository.getCertificate(), 529, null));
            repositoryDaoInt.insert(new RepositoryPreferences(insertOrReplace, repositoryDaoInt.getMinRepositoryWeight() - 2, false, null, null, null, null, newRepository.getUsername(), newRepository.getPassword(), 116, null));
            return insertOrReplace;
        }

        public static /* synthetic */ long insertEmptyRepo$default(RepositoryDaoInt repositoryDaoInt, String str, String str2, String str3, String str4, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = null;
                }
                if ((i & 4) != 0) {
                    str3 = null;
                }
                if ((i & 8) != 0) {
                    str4 = "6789";
                }
                return repositoryDaoInt.insertEmptyRepo(str, str2, str3, str4);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: insertEmptyRepo");
        }

        public static long insertEmptyRepo(RepositoryDaoInt repositoryDaoInt, String address, String str, String str2, String certificate) {
            Map mapOf;
            Intrinsics.checkNotNullParameter(address, "address");
            Intrinsics.checkNotNullParameter(certificate, "certificate");
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(IndexConverterKt.DEFAULT_LOCALE, address));
            long insertOrReplace = repositoryDaoInt.insertOrReplace(new CoreRepository(0L, mapOf, null, address, null, -1L, null, null, null, null, certificate, 529, null));
            repositoryDaoInt.insert(new RepositoryPreferences(insertOrReplace, repositoryDaoInt.getMinRepositoryWeight() - 2, false, null, null, null, null, str, str2, 116, null));
            return insertOrReplace;
        }

        public static /* synthetic */ long insertOrReplace$default(RepositoryDaoInt repositoryDaoInt, RepoV2 repoV2, long j, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    j = 0;
                }
                return repositoryDaoInt.insertOrReplace(repoV2, j);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: insertOrReplace");
        }

        public static long insertOrReplace(RepositoryDaoInt repositoryDaoInt, RepoV2 repository, long j) {
            Intrinsics.checkNotNullParameter(repository, "repository");
            long insertOrReplace = repositoryDaoInt.insertOrReplace(RepositoryKt.toCoreRepository$default(repository, 0L, j, null, "0123", 5, null));
            repositoryDaoInt.insert(new RepositoryPreferences(insertOrReplace, repositoryDaoInt.getMinRepositoryWeight() - 2, false, null, null, null, null, null, null, 508, null));
            insertRepoTables(repositoryDaoInt, insertOrReplace, repository);
            return insertOrReplace;
        }

        public static void update(RepositoryDaoInt repositoryDaoInt, long j, RepoV2 repository, long j2, IndexFormatVersion formatVersion) {
            Intrinsics.checkNotNullParameter(repository, "repository");
            Intrinsics.checkNotNullParameter(formatVersion, "formatVersion");
            Repository repository2 = repositoryDaoInt.getRepository(j);
            if (repository2 == null) {
                throw new IllegalStateException(("Repo with id " + j + " did not exist").toString());
            }
            repositoryDaoInt.update(RepositoryKt.toCoreRepository(repository, j, j2, formatVersion, repository2.getCertificate()));
            insertRepoTables(repositoryDaoInt, j, repository);
        }

        private static void insertRepoTables(RepositoryDaoInt repositoryDaoInt, long j, RepoV2 repoV2) {
            int collectionSizeOrDefault;
            List<MirrorV2> mirrors = repoV2.getMirrors();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(mirrors, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (MirrorV2 mirrorV2 : mirrors) {
                arrayList.add(RepositoryKt.toMirror(mirrorV2, j));
            }
            repositoryDaoInt.insertMirrors(arrayList);
            repositoryDaoInt.insertAntiFeatures(RepositoryKt.toRepoAntiFeatures(repoV2.getAntiFeatures(), j));
            repositoryDaoInt.insertCategories(RepositoryKt.toRepoCategories(repoV2.getCategories(), j));
            repositoryDaoInt.insertReleaseChannels(RepositoryKt.toRepoReleaseChannel(repoV2.getReleaseChannels(), j));
        }

        public static void updateRepository(final RepositoryDaoInt repositoryDaoInt, final long j, long j2, JsonObject jsonObject) {
            CoreRepository copy;
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            Repository repository = repositoryDaoInt.getRepository(j);
            if (repository == null) {
                throw new IllegalStateException(("Repo " + j + " does not exist").toString());
            }
            copy = r17.copy((r28 & 1) != 0 ? r17.repoId : 0L, (r28 & 2) != 0 ? r17.name : null, (r28 & 4) != 0 ? r17.icon : null, (r28 & 8) != 0 ? r17.address : null, (r28 & 16) != 0 ? r17.webBaseUrl : null, (r28 & 32) != 0 ? r17.timestamp : 0L, (r28 & 64) != 0 ? r17.version : Long.valueOf(j2), (r28 & 128) != 0 ? r17.formatVersion : null, (r28 & 256) != 0 ? r17.maxAge : null, (r28 & 512) != 0 ? r17.description : null, (r28 & 1024) != 0 ? ((CoreRepository) ReflectionDiffer.INSTANCE.applyDiff(repository.getRepository$database_release(), jsonObject)).certificate : null);
            repositoryDaoInt.updateRepository(copy);
            DbDiffUtils dbDiffUtils = DbDiffUtils.INSTANCE;
            dbDiffUtils.diffAndUpdateListTable(jsonObject, "mirrors", new Function1() { // from class: org.fdroid.database.RepositoryDaoInt$updateRepository$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final List invoke(JsonArray mirrorArray) {
                    int collectionSizeOrDefault;
                    Intrinsics.checkNotNullParameter(mirrorArray, "mirrorArray");
                    Json json = IndexParser.getJson();
                    KSerializer serializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(MirrorV2.class))));
                    Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    Iterable<MirrorV2> iterable = (Iterable) json.decodeFromJsonElement(serializer, mirrorArray);
                    long j3 = j;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    for (MirrorV2 mirrorV2 : iterable) {
                        arrayList.add(RepositoryKt.toMirror(mirrorV2, j3));
                    }
                    return arrayList;
                }
            }, new Function0() { // from class: org.fdroid.database.RepositoryDaoInt$updateRepository$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m2358invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: collision with other method in class */
                public final void m2358invoke() {
                    RepositoryDaoInt.this.deleteMirrors(j);
                }
            }, new Function1() { // from class: org.fdroid.database.RepositoryDaoInt$updateRepository$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((List) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(List mirrors) {
                    Intrinsics.checkNotNullParameter(mirrors, "mirrors");
                    RepositoryDaoInt.this.insertMirrors(mirrors);
                }
            });
            DbDiffUtils.diffAndUpdateTable$default(dbDiffUtils, jsonObject, "antiFeatures", repository.getAntiFeatures$database_release(), new Function2() { // from class: org.fdroid.database.RepositoryDaoInt$updateRepository$4
                @Override // kotlin.jvm.functions.Function2
                public final Boolean invoke(String key, AntiFeature item) {
                    Intrinsics.checkNotNullParameter(key, "key");
                    Intrinsics.checkNotNullParameter(item, "item");
                    return Boolean.valueOf(Intrinsics.areEqual(item.getId$database_release(), key));
                }
            }, new Function1() { // from class: org.fdroid.database.RepositoryDaoInt$updateRepository$5
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final AntiFeature invoke(String key) {
                    Map emptyMap;
                    Map emptyMap2;
                    Map emptyMap3;
                    Intrinsics.checkNotNullParameter(key, "key");
                    long j3 = j;
                    emptyMap = MapsKt__MapsKt.emptyMap();
                    emptyMap2 = MapsKt__MapsKt.emptyMap();
                    emptyMap3 = MapsKt__MapsKt.emptyMap();
                    return new AntiFeature(j3, key, emptyMap, emptyMap2, emptyMap3);
                }
            }, new Function0() { // from class: org.fdroid.database.RepositoryDaoInt$updateRepository$6
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m2359invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: collision with other method in class */
                public final void m2359invoke() {
                    RepositoryDaoInt.this.deleteAntiFeatures(j);
                }
            }, new Function1() { // from class: org.fdroid.database.RepositoryDaoInt$updateRepository$7
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(String key) {
                    Intrinsics.checkNotNullParameter(key, "key");
                    RepositoryDaoInt.this.deleteAntiFeature(j, key);
                }
            }, new Function1() { // from class: org.fdroid.database.RepositoryDaoInt$updateRepository$8
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((List) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(List list) {
                    Intrinsics.checkNotNullParameter(list, "list");
                    RepositoryDaoInt.this.insertAntiFeatures(list);
                }
            }, null, null, 768, null);
            DbDiffUtils.diffAndUpdateTable$default(dbDiffUtils, jsonObject, "categories", repository.getCategories$database_release(), new Function2() { // from class: org.fdroid.database.RepositoryDaoInt$updateRepository$9
                @Override // kotlin.jvm.functions.Function2
                public final Boolean invoke(String key, Category item) {
                    Intrinsics.checkNotNullParameter(key, "key");
                    Intrinsics.checkNotNullParameter(item, "item");
                    return Boolean.valueOf(Intrinsics.areEqual(item.getId(), key));
                }
            }, new Function1() { // from class: org.fdroid.database.RepositoryDaoInt$updateRepository$10
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Category invoke(String key) {
                    Map emptyMap;
                    Map emptyMap2;
                    Map emptyMap3;
                    Intrinsics.checkNotNullParameter(key, "key");
                    long j3 = j;
                    emptyMap = MapsKt__MapsKt.emptyMap();
                    emptyMap2 = MapsKt__MapsKt.emptyMap();
                    emptyMap3 = MapsKt__MapsKt.emptyMap();
                    return new Category(j3, key, emptyMap, emptyMap2, emptyMap3);
                }
            }, new Function0() { // from class: org.fdroid.database.RepositoryDaoInt$updateRepository$11
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m2356invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: collision with other method in class */
                public final void m2356invoke() {
                    RepositoryDaoInt.this.deleteCategories(j);
                }
            }, new Function1() { // from class: org.fdroid.database.RepositoryDaoInt$updateRepository$12
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(String key) {
                    Intrinsics.checkNotNullParameter(key, "key");
                    RepositoryDaoInt.this.deleteCategory(j, key);
                }
            }, new Function1() { // from class: org.fdroid.database.RepositoryDaoInt$updateRepository$13
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((List) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(List list) {
                    Intrinsics.checkNotNullParameter(list, "list");
                    RepositoryDaoInt.this.insertCategories(list);
                }
            }, null, null, 768, null);
            DbDiffUtils.diffAndUpdateTable$default(dbDiffUtils, jsonObject, "releaseChannels", repository.getReleaseChannels$database_release(), new Function2() { // from class: org.fdroid.database.RepositoryDaoInt$updateRepository$14
                @Override // kotlin.jvm.functions.Function2
                public final Boolean invoke(String key, ReleaseChannel item) {
                    Intrinsics.checkNotNullParameter(key, "key");
                    Intrinsics.checkNotNullParameter(item, "item");
                    return Boolean.valueOf(Intrinsics.areEqual(item.getId$database_release(), key));
                }
            }, new Function1() { // from class: org.fdroid.database.RepositoryDaoInt$updateRepository$15
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final ReleaseChannel invoke(String key) {
                    Map emptyMap;
                    Map emptyMap2;
                    Map emptyMap3;
                    Intrinsics.checkNotNullParameter(key, "key");
                    long j3 = j;
                    emptyMap = MapsKt__MapsKt.emptyMap();
                    emptyMap2 = MapsKt__MapsKt.emptyMap();
                    emptyMap3 = MapsKt__MapsKt.emptyMap();
                    return new ReleaseChannel(j3, key, emptyMap, emptyMap2, emptyMap3);
                }
            }, new Function0() { // from class: org.fdroid.database.RepositoryDaoInt$updateRepository$16
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m2357invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: collision with other method in class */
                public final void m2357invoke() {
                    RepositoryDaoInt.this.deleteReleaseChannels(j);
                }
            }, new Function1() { // from class: org.fdroid.database.RepositoryDaoInt$updateRepository$17
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(String key) {
                    Intrinsics.checkNotNullParameter(key, "key");
                    RepositoryDaoInt.this.deleteReleaseChannel(j, key);
                }
            }, new Function1() { // from class: org.fdroid.database.RepositoryDaoInt$updateRepository$18
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((List) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(List list) {
                    Intrinsics.checkNotNullParameter(list, "list");
                    RepositoryDaoInt.this.insertReleaseChannels(list);
                }
            }, null, null, 768, null);
        }

        public static void setRepositoryEnabled(RepositoryDaoInt repositoryDaoInt, long j, boolean z) {
            if (!z) {
                repositoryDaoInt.resetPreferredRepoInAppPrefs(j);
            }
            repositoryDaoInt.setRepositoryEnabledInternal(j, z);
        }

        public static void reorderRepositories(RepositoryDaoInt repositoryDaoInt, Repository repoToReorder, Repository repoTarget) {
            Intrinsics.checkNotNullParameter(repoToReorder, "repoToReorder");
            Intrinsics.checkNotNullParameter(repoTarget, "repoTarget");
            if (repoToReorder.isArchiveRepo() || repoTarget.isArchiveRepo()) {
                throw new IllegalArgumentException("Re-ordering of archive repos is not supported".toString());
            }
            if (repoToReorder.getWeight() > repoTarget.getWeight()) {
                repositoryDaoInt.shiftRepoWeights(repoTarget.getWeight(), repoToReorder.getWeight() - 2, 2);
            } else if (repoToReorder.getWeight() >= repoTarget.getWeight()) {
                return;
            } else {
                repositoryDaoInt.shiftRepoWeights(repoToReorder.getWeight() + 1, repoTarget.getWeight(), -2);
            }
            repositoryDaoInt.setWeight(repoToReorder.getRepoId(), repoTarget.getWeight());
            Long archiveRepoId = repositoryDaoInt.getArchiveRepoId(repoToReorder.getCertificate());
            if (archiveRepoId != null) {
                repositoryDaoInt.setWeight(archiveRepoId.longValue(), repoTarget.getWeight() - 1);
            }
        }

        public static void deleteRepository(RepositoryDaoInt repositoryDaoInt, long j) {
            repositoryDaoInt.deleteCoreRepository(j);
            repositoryDaoInt.deleteRepositoryPreferences(j);
            repositoryDaoInt.resetPreferredRepoInAppPrefs(j);
        }

        public static void clear(RepositoryDaoInt repositoryDaoInt, long j) {
            Repository repository = repositoryDaoInt.getRepository(j);
            if (repository == null) {
                throw new IllegalStateException(("repo with id " + j + " does not exist").toString());
            }
            repositoryDaoInt.insertOrReplace(repository.getRepository$database_release());
        }

        public static void clearAll(RepositoryDaoInt repositoryDaoInt) {
            repositoryDaoInt.deleteAllCoreRepositories();
            repositoryDaoInt.deleteAllRepositoryPreferences();
        }
    }
}
