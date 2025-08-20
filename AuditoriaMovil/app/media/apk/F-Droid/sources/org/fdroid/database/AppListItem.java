package org.fdroid.database;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import androidx.compose.foundation.ClickableElement$$ExternalSyntheticBackport0;
import androidx.core.os.LocaleListCompat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.ErrorBundle;
import org.fdroid.LocaleChooser;
import org.fdroid.fdroid.views.apps.AppListActivity;
import org.fdroid.index.v2.FileV2;
/* compiled from: App.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B}\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0012J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u0005HÀ\u0003¢\u0006\u0002\b4J\u0016\u00105\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÀ\u0003¢\u0006\u0002\b6J\t\u00107\u001a\u00020\u000eHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0090\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010:J\u0013\u0010;\u001a\u00020\u000e2\b\u0010<\u001a\u0004\u0018\u00010=HÖ\u0003J\u0018\u0010>\u001a\u0004\u0018\u00010\u00052\u0006\u0010?\u001a\u00020\u00052\u0006\u0010@\u001a\u00020AJ\u0012\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010@\u001a\u00020AH\u0016J\t\u0010D\u001a\u00020EHÖ\u0001J\t\u0010F\u001a\u00020\u0005HÖ\u0001R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R9\u0010\u0018\u001a \u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0019j\u0002`\u001a\u0018\u00010\u00198BX\u0083\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010#R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0000X\u0081\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0015R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0017R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0017R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010%R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0017¨\u0006G"}, d2 = {"Lorg/fdroid/database/AppListItem;", "Lorg/fdroid/database/MinimalApp;", "repoId", "", "packageName", "", "name", ErrorBundle.SUMMARY_ENTRY, AppListActivity.SortClause.LAST_UPDATED, "antiFeatures", "localizedIcon", "", "Lorg/fdroid/database/LocalizedIcon;", "isCompatible", "", "preferredSigner", "installedVersionName", "installedVersionCode", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/util/List;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "antiFeatureKeys", "getAntiFeatureKeys", "()Ljava/util/List;", "getAntiFeatures$database_release", "()Ljava/lang/String;", "antiFeaturesDecoded", "", "Lorg/fdroid/index/v2/LocalizedTextV2;", "getAntiFeaturesDecoded", "()Ljava/util/Map;", "antiFeaturesDecoded$delegate", "Lkotlin/Lazy;", "getInstalledVersionCode", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getInstalledVersionName", "()Z", "getLastUpdated", "()J", "getLocalizedIcon$database_release", "getName", "getPackageName", "getPreferredSigner", "getRepoId", "getSummary", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component6$database_release", "component7", "component7$database_release", "component8", "component9", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/util/List;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lorg/fdroid/database/AppListItem;", "equals", "other", "", "getAntiFeatureReason", "antiFeatureKey", "localeList", "Landroidx/core/os/LocaleListCompat;", "getIcon", "Lorg/fdroid/index/v2/FileV2;", "hashCode", "", "toString", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AppListItem implements MinimalApp {
    private final String antiFeatures;
    private final Lazy antiFeaturesDecoded$delegate;
    private final Long installedVersionCode;
    private final String installedVersionName;
    private final boolean isCompatible;
    private final long lastUpdated;
    private final List<LocalizedIcon> localizedIcon;
    private final String name;
    private final String packageName;
    private final String preferredSigner;
    private final long repoId;
    private final String summary;

    public final long component1() {
        return this.repoId;
    }

    public final String component10() {
        return this.installedVersionName;
    }

    public final Long component11() {
        return this.installedVersionCode;
    }

    public final String component2() {
        return this.packageName;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.summary;
    }

    public final long component5() {
        return this.lastUpdated;
    }

    public final String component6$database_release() {
        return this.antiFeatures;
    }

    public final List<LocalizedIcon> component7$database_release() {
        return this.localizedIcon;
    }

    public final boolean component8() {
        return this.isCompatible;
    }

    public final String component9() {
        return this.preferredSigner;
    }

    public final AppListItem copy(long j, String packageName, String str, String str2, long j2, String str3, List<LocalizedIcon> list, boolean z, String str4, String str5, Long l) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return new AppListItem(j, packageName, str, str2, j2, str3, list, z, str4, str5, l);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AppListItem) {
            AppListItem appListItem = (AppListItem) obj;
            return this.repoId == appListItem.repoId && Intrinsics.areEqual(this.packageName, appListItem.packageName) && Intrinsics.areEqual(this.name, appListItem.name) && Intrinsics.areEqual(this.summary, appListItem.summary) && this.lastUpdated == appListItem.lastUpdated && Intrinsics.areEqual(this.antiFeatures, appListItem.antiFeatures) && Intrinsics.areEqual(this.localizedIcon, appListItem.localizedIcon) && this.isCompatible == appListItem.isCompatible && Intrinsics.areEqual(this.preferredSigner, appListItem.preferredSigner) && Intrinsics.areEqual(this.installedVersionName, appListItem.installedVersionName) && Intrinsics.areEqual(this.installedVersionCode, appListItem.installedVersionCode);
        }
        return false;
    }

    public final String getAntiFeatures$database_release() {
        return this.antiFeatures;
    }

    public final Long getInstalledVersionCode() {
        return this.installedVersionCode;
    }

    public final String getInstalledVersionName() {
        return this.installedVersionName;
    }

    public final long getLastUpdated() {
        return this.lastUpdated;
    }

    public final List<LocalizedIcon> getLocalizedIcon$database_release() {
        return this.localizedIcon;
    }

    @Override // org.fdroid.database.MinimalApp
    public String getName() {
        return this.name;
    }

    @Override // org.fdroid.database.MinimalApp
    public String getPackageName() {
        return this.packageName;
    }

    public final String getPreferredSigner() {
        return this.preferredSigner;
    }

    @Override // org.fdroid.database.MinimalApp
    public long getRepoId() {
        return this.repoId;
    }

    @Override // org.fdroid.database.MinimalApp
    public String getSummary() {
        return this.summary;
    }

    public int hashCode() {
        int m = ((FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(this.repoId) * 31) + this.packageName.hashCode()) * 31;
        String str = this.name;
        int hashCode = (m + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.summary;
        int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(this.lastUpdated)) * 31;
        String str3 = this.antiFeatures;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<LocalizedIcon> list = this.localizedIcon;
        int hashCode4 = (((hashCode3 + (list == null ? 0 : list.hashCode())) * 31) + ClickableElement$$ExternalSyntheticBackport0.m(this.isCompatible)) * 31;
        String str4 = this.preferredSigner;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.installedVersionName;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Long l = this.installedVersionCode;
        return hashCode6 + (l != null ? l.hashCode() : 0);
    }

    public final boolean isCompatible() {
        return this.isCompatible;
    }

    public String toString() {
        long j = this.repoId;
        String str = this.packageName;
        String str2 = this.name;
        String str3 = this.summary;
        long j2 = this.lastUpdated;
        String str4 = this.antiFeatures;
        List<LocalizedIcon> list = this.localizedIcon;
        boolean z = this.isCompatible;
        String str5 = this.preferredSigner;
        String str6 = this.installedVersionName;
        Long l = this.installedVersionCode;
        return "AppListItem(repoId=" + j + ", packageName=" + str + ", name=" + str2 + ", summary=" + str3 + ", lastUpdated=" + j2 + ", antiFeatures=" + str4 + ", localizedIcon=" + list + ", isCompatible=" + z + ", preferredSigner=" + str5 + ", installedVersionName=" + str6 + ", installedVersionCode=" + l + ")";
    }

    public AppListItem(long j, String packageName, String str, String str2, long j2, String str3, List<LocalizedIcon> list, boolean z, String str4, String str5, Long l) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.repoId = j;
        this.packageName = packageName;
        this.name = str;
        this.summary = str2;
        this.lastUpdated = j2;
        this.antiFeatures = str3;
        this.localizedIcon = list;
        this.isCompatible = z;
        this.preferredSigner = str4;
        this.installedVersionName = str5;
        this.installedVersionCode = l;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: org.fdroid.database.AppListItem$antiFeaturesDecoded$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Map invoke() {
                return Converters.INSTANCE.fromStringToMapOfLocalizedTextV2(AppListItem.this.getAntiFeatures$database_release());
            }
        });
        this.antiFeaturesDecoded$delegate = lazy;
    }

    public /* synthetic */ AppListItem(long j, String str, String str2, String str3, long j2, String str4, List list, boolean z, String str5, String str6, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, j2, str4, list, z, (i & 256) != 0 ? null : str5, (i & 512) != 0 ? null : str6, (i & 1024) != 0 ? null : l);
    }

    private final Map<String, Map<String, String>> getAntiFeaturesDecoded() {
        return (Map) this.antiFeaturesDecoded$delegate.getValue();
    }

    @Override // org.fdroid.database.MinimalApp
    public FileV2 getIcon(LocaleListCompat localeList) {
        Map<String, FileV2> map;
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        LocaleChooser localeChooser = LocaleChooser.INSTANCE;
        List<LocalizedIcon> list = this.localizedIcon;
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((LocalizedIcon) obj).getRepoId() == getRepoId()) {
                    arrayList.add(obj);
                }
            }
            map = AppKt.toLocalizedFileV2(arrayList);
        } else {
            map = null;
        }
        return (FileV2) localeChooser.getBestLocale(map, localeList);
    }

    public final List<String> getAntiFeatureKeys() {
        List<String> emptyList;
        Map<String, Map<String, String>> antiFeaturesDecoded = getAntiFeaturesDecoded();
        if (antiFeaturesDecoded != null) {
            ArrayList arrayList = new ArrayList(antiFeaturesDecoded.size());
            for (Map.Entry<String, Map<String, String>> entry : antiFeaturesDecoded.entrySet()) {
                arrayList.add(entry.getKey());
            }
            return arrayList;
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    public final String getAntiFeatureReason(String antiFeatureKey, LocaleListCompat localeList) {
        Map<String, String> map;
        Intrinsics.checkNotNullParameter(antiFeatureKey, "antiFeatureKey");
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        Map<String, Map<String, String>> antiFeaturesDecoded = getAntiFeaturesDecoded();
        if (antiFeaturesDecoded == null || (map = antiFeaturesDecoded.get(antiFeatureKey)) == null) {
            return null;
        }
        return (String) LocaleChooser.INSTANCE.getBestLocale(map, localeList);
    }
}
