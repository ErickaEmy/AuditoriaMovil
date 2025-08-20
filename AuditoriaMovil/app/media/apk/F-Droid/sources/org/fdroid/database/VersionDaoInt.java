package org.fdroid.database;

import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;
import ch.qos.logback.core.joran.action.Action;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import org.fdroid.fdroid.nearby.peers.BonjourPeer;
import org.fdroid.index.IndexParser;
import org.fdroid.index.v2.PackageVersionV2;
import org.fdroid.index.v2.PermissionV2;
import org.fdroid.index.v2.ReflectionDiffer;
/* compiled from: VersionDao.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\ba\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\b\u0010\u0004\u001a\u00020\u0003H'J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH'J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH'J \u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH'J(\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH'J,\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015H\u0002J(\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0002J$\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH'J\u001c\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001b2\u0006\u0010\t\u001a\u00020\nH'J\"\u0010\u001e\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH'J\u001e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u001c2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH'J&\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u001c2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH'J\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00110\u001c2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0\u001cH\u0016J\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00110\u001c2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0\u001cH'J0\u0010$\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0017H\u0017J@\u0010$\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020&0)2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00170\u0015H\u0017J\u0016\u0010$\u001a\u00020\u00062\f\u0010*\u001a\b\u0012\u0004\u0012\u00020 0\u001cH'J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H'JD\u0010+\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0016\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010)2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015H\u0016J\u0010\u0010+\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H'¨\u0006-"}, d2 = {"Lorg/fdroid/database/VersionDaoInt;", "Lorg/fdroid/database/VersionDao;", "countAppVersions", "", "countVersionedStrings", "deleteAppVersion", "", "repoId", "", "packageName", "", "versionId", "deleteVersionedStrings", BonjourPeer.TYPE, "Lorg/fdroid/database/VersionedStringType;", "diffVersion", "version", "Lorg/fdroid/database/Version;", "jsonObject", "Lkotlinx/serialization/json/JsonObject;", "checkIfCompatible", "Lkotlin/Function1;", "Lorg/fdroid/index/v2/PackageManifest;", "", "diffVersionedStrings", Action.KEY_ATTRIBUTE, "getAppVersions", "Landroidx/lifecycle/LiveData;", "", "Lorg/fdroid/database/AppVersion;", "getVersion", "getVersionedStrings", "Lorg/fdroid/database/VersionedString;", "getVersions", "packageNames", "getVersionsInternal", "insert", "packageVersion", "Lorg/fdroid/index/v2/PackageVersionV2;", "isCompatible", "packageVersions", "", "versionedString", "update", "versionsDiffMap", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface VersionDaoInt extends VersionDao {
    int countAppVersions();

    int countVersionedStrings();

    void deleteAppVersion(long j, String str);

    void deleteAppVersion(long j, String str, String str2);

    void deleteVersionedStrings(long j, String str, String str2);

    void deleteVersionedStrings(long j, String str, String str2, VersionedStringType versionedStringType);

    @Override // org.fdroid.database.VersionDao
    LiveData getAppVersions(long j, String str);

    @Override // org.fdroid.database.VersionDao
    LiveData getAppVersions(String str);

    Version getVersion(long j, String str, String str2);

    List<VersionedString> getVersionedStrings(long j, String str);

    List<VersionedString> getVersionedStrings(long j, String str, String str2);

    List<Version> getVersions(List<String> list);

    List<Version> getVersionsInternal(List<String> list);

    void insert(long j, String str, String str2, PackageVersionV2 packageVersionV2, boolean z);

    @Override // org.fdroid.database.VersionDao
    void insert(long j, String str, Map<String, PackageVersionV2> map, Function1 function1);

    void insert(List<VersionedString> list);

    void insert(Version version);

    void update(long j, String str, Map<String, JsonObject> map, Function1 function1);

    void update(Version version);

    /* compiled from: VersionDao.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static void insert(VersionDaoInt versionDaoInt, long j, String packageName, Map<String, PackageVersionV2> packageVersions, Function1 checkIfCompatible) {
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            Intrinsics.checkNotNullParameter(packageVersions, "packageVersions");
            Intrinsics.checkNotNullParameter(checkIfCompatible, "checkIfCompatible");
            for (Map.Entry<String, PackageVersionV2> entry : packageVersions.entrySet()) {
                PackageVersionV2 value = entry.getValue();
                versionDaoInt.insert(j, packageName, entry.getKey(), value, ((Boolean) checkIfCompatible.invoke(value)).booleanValue());
            }
        }

        public static void insert(VersionDaoInt versionDaoInt, long j, String packageName, String versionId, PackageVersionV2 packageVersion, boolean z) {
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            Intrinsics.checkNotNullParameter(versionId, "versionId");
            Intrinsics.checkNotNullParameter(packageVersion, "packageVersion");
            Version version = VersionKt.toVersion(packageVersion, j, packageName, versionId, z);
            versionDaoInt.insert(version);
            versionDaoInt.insert(VersionKt.getVersionedStrings(packageVersion.getManifest(), version));
        }

        public static void update(VersionDaoInt versionDaoInt, long j, String packageName, Map<String, JsonObject> map, Function1 checkIfCompatible) {
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            Intrinsics.checkNotNullParameter(checkIfCompatible, "checkIfCompatible");
            if (map == null) {
                versionDaoInt.deleteAppVersion(j, packageName);
                return;
            }
            for (Map.Entry<String, JsonObject> entry : map.entrySet()) {
                String key = entry.getKey();
                JsonObject value = entry.getValue();
                if (value == null) {
                    versionDaoInt.deleteAppVersion(j, packageName, key);
                } else {
                    Version version = versionDaoInt.getVersion(j, packageName, key);
                    if (version == null) {
                        Json json = IndexParser.getJson();
                        KSerializer serializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(PackageVersionV2.class));
                        Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                        PackageVersionV2 packageVersionV2 = (PackageVersionV2) json.decodeFromJsonElement(serializer, value);
                        versionDaoInt.insert(j, packageName, key, packageVersionV2, ((Boolean) checkIfCompatible.invoke(packageVersionV2.getPackageManifest())).booleanValue());
                    } else {
                        diffVersion(versionDaoInt, version, value, checkIfCompatible);
                    }
                }
            }
        }

        private static void diffVersion(VersionDaoInt versionDaoInt, Version version, JsonObject jsonObject, Function1 function1) {
            List<String> list;
            list = VersionDaoKt.DENY_LIST;
            for (String str : list) {
                if (jsonObject.containsKey((Object) str)) {
                    throw new SerializationException(str);
                }
            }
            Version version2 = (Version) ReflectionDiffer.INSTANCE.applyDiff(version, jsonObject);
            versionDaoInt.update(Version.copy$default(version2, 0L, null, null, 0L, null, null, null, null, null, null, ((Boolean) function1.invoke(version2.getPackageManifest())).booleanValue(), 1023, null));
            JsonElement jsonElement = (JsonElement) jsonObject.get("manifest");
            if (jsonElement instanceof JsonNull) {
                versionDaoInt.deleteVersionedStrings(version.getRepoId(), version.getPackageName(), version.getVersionId());
            } else if (jsonElement instanceof JsonObject) {
                JsonObject jsonObject2 = (JsonObject) jsonElement;
                diffVersionedStrings(versionDaoInt, version, jsonObject2, "usesPermission", VersionedStringType.PERMISSION);
                diffVersionedStrings(versionDaoInt, version, jsonObject2, "usesPermissionSdk23", VersionedStringType.PERMISSION_SDK_23);
            }
        }

        private static void diffVersionedStrings(final VersionDaoInt versionDaoInt, final Version version, JsonObject jsonObject, String str, final VersionedStringType versionedStringType) {
            DbDiffUtils.INSTANCE.diffAndUpdateListTable(jsonObject, str, new Function1() { // from class: org.fdroid.database.VersionDaoInt$diffVersionedStrings$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final List invoke(JsonArray permissionArray) {
                    Intrinsics.checkNotNullParameter(permissionArray, "permissionArray");
                    Json json = IndexParser.getJson();
                    KSerializer serializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(PermissionV2.class))));
                    Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                    return VersionKt.toVersionedString((List) json.decodeFromJsonElement(serializer, permissionArray), Version.this, versionedStringType);
                }
            }, new Function0() { // from class: org.fdroid.database.VersionDaoInt$diffVersionedStrings$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m2369invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: collision with other method in class */
                public final void m2369invoke() {
                    VersionDaoInt.this.deleteVersionedStrings(version.getRepoId(), version.getPackageName(), version.getVersionId(), versionedStringType);
                }
            }, new Function1() { // from class: org.fdroid.database.VersionDaoInt$diffVersionedStrings$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((List) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(List versionedStrings) {
                    Intrinsics.checkNotNullParameter(versionedStrings, "versionedStrings");
                    VersionDaoInt.this.insert(versionedStrings);
                }
            });
        }

        public static List<Version> getVersions(VersionDaoInt versionDaoInt, List<String> packageNames) {
            List<List<String>> chunked;
            Intrinsics.checkNotNullParameter(packageNames, "packageNames");
            if (packageNames.size() <= 999) {
                return versionDaoInt.getVersionsInternal(packageNames);
            }
            chunked = CollectionsKt___CollectionsKt.chunked(packageNames, RoomDatabase.MAX_BIND_PARAMETER_CNT);
            ArrayList arrayList = new ArrayList();
            for (List<String> list : chunked) {
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, versionDaoInt.getVersionsInternal(list));
            }
            return arrayList;
        }
    }
}
