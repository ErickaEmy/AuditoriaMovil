package org.fdroid.database;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import androidx.compose.foundation.ClickableElement$$ExternalSyntheticBackport0;
import androidx.core.os.LocaleListCompat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.ErrorBundle;
import org.fdroid.LocaleChooser;
import org.fdroid.fdroid.views.apps.AppListActivity;
import org.fdroid.index.v2.FileV2;
/* compiled from: App.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0081\u0001\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012&\b\u0002\u0010\n\u001a \u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bj\u0002`\f\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J,\u0010(\u001a \u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bj\u0002`\f\u0018\u00010\u000bHÀ\u0003¢\u0006\u0002\b)J\u0016\u0010*\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÀ\u0003¢\u0006\u0002\b+J\t\u0010,\u001a\u00020\u0011HÆ\u0003J\u008d\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052&\b\u0002\u0010\n\u001a \u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bj\u0002`\f\u0018\u00010\u000b2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001J\u0013\u0010.\u001a\u00020\u00112\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\u0012\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u000204H\u0016J\t\u00105\u001a\u000206HÖ\u0001J\t\u00107\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R2\u0010\n\u001a \u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bj\u0002`\f\u0018\u00010\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0000X\u0081\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001e¨\u00068"}, d2 = {"Lorg/fdroid/database/AppOverviewItem;", "Lorg/fdroid/database/MinimalApp;", "repoId", "", "packageName", "", "added", AppListActivity.SortClause.LAST_UPDATED, "name", ErrorBundle.SUMMARY_ENTRY, "antiFeatures", "", "Lorg/fdroid/index/v2/LocalizedTextV2;", "localizedIcon", "", "Lorg/fdroid/database/LocalizedIcon;", "isCompatible", "", "(JLjava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Z)V", "getAdded", "()J", "antiFeatureKeys", "getAntiFeatureKeys", "()Ljava/util/List;", "getAntiFeatures$database_release", "()Ljava/util/Map;", "()Z", "getLastUpdated", "getLocalizedIcon$database_release", "getName", "()Ljava/lang/String;", "getPackageName", "getRepoId", "getSummary", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component7$database_release", "component8", "component8$database_release", "component9", "copy", "equals", "other", "", "getIcon", "Lorg/fdroid/index/v2/FileV2;", "localeList", "Landroidx/core/os/LocaleListCompat;", "hashCode", "", "toString", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AppOverviewItem implements MinimalApp {
    private final long added;
    private final Map<String, Map<String, String>> antiFeatures;
    private final boolean isCompatible;
    private final long lastUpdated;
    private final List<LocalizedIcon> localizedIcon;
    private final String name;
    private final String packageName;
    private final long repoId;
    private final String summary;

    public final long component1() {
        return this.repoId;
    }

    public final String component2() {
        return this.packageName;
    }

    public final long component3() {
        return this.added;
    }

    public final long component4() {
        return this.lastUpdated;
    }

    public final String component5() {
        return this.name;
    }

    public final String component6() {
        return this.summary;
    }

    public final Map<String, Map<String, String>> component7$database_release() {
        return this.antiFeatures;
    }

    public final List<LocalizedIcon> component8$database_release() {
        return this.localizedIcon;
    }

    public final boolean component9() {
        return this.isCompatible;
    }

    public final AppOverviewItem copy(long j, String packageName, long j2, long j3, String str, String str2, Map<String, ? extends Map<String, String>> map, List<LocalizedIcon> list, boolean z) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return new AppOverviewItem(j, packageName, j2, j3, str, str2, map, list, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AppOverviewItem) {
            AppOverviewItem appOverviewItem = (AppOverviewItem) obj;
            return this.repoId == appOverviewItem.repoId && Intrinsics.areEqual(this.packageName, appOverviewItem.packageName) && this.added == appOverviewItem.added && this.lastUpdated == appOverviewItem.lastUpdated && Intrinsics.areEqual(this.name, appOverviewItem.name) && Intrinsics.areEqual(this.summary, appOverviewItem.summary) && Intrinsics.areEqual(this.antiFeatures, appOverviewItem.antiFeatures) && Intrinsics.areEqual(this.localizedIcon, appOverviewItem.localizedIcon) && this.isCompatible == appOverviewItem.isCompatible;
        }
        return false;
    }

    public final long getAdded() {
        return this.added;
    }

    public final Map<String, Map<String, String>> getAntiFeatures$database_release() {
        return this.antiFeatures;
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

    @Override // org.fdroid.database.MinimalApp
    public long getRepoId() {
        return this.repoId;
    }

    @Override // org.fdroid.database.MinimalApp
    public String getSummary() {
        return this.summary;
    }

    public int hashCode() {
        int m = ((((((FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(this.repoId) * 31) + this.packageName.hashCode()) * 31) + FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(this.added)) * 31) + FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(this.lastUpdated)) * 31;
        String str = this.name;
        int hashCode = (m + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.summary;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Map<String, Map<String, String>> map = this.antiFeatures;
        int hashCode3 = (hashCode2 + (map == null ? 0 : map.hashCode())) * 31;
        List<LocalizedIcon> list = this.localizedIcon;
        return ((hashCode3 + (list != null ? list.hashCode() : 0)) * 31) + ClickableElement$$ExternalSyntheticBackport0.m(this.isCompatible);
    }

    public final boolean isCompatible() {
        return this.isCompatible;
    }

    public String toString() {
        long j = this.repoId;
        String str = this.packageName;
        long j2 = this.added;
        long j3 = this.lastUpdated;
        String str2 = this.name;
        String str3 = this.summary;
        Map<String, Map<String, String>> map = this.antiFeatures;
        List<LocalizedIcon> list = this.localizedIcon;
        boolean z = this.isCompatible;
        return "AppOverviewItem(repoId=" + j + ", packageName=" + str + ", added=" + j2 + ", lastUpdated=" + j3 + ", name=" + str2 + ", summary=" + str3 + ", antiFeatures=" + map + ", localizedIcon=" + list + ", isCompatible=" + z + ")";
    }

    public final List<String> getAntiFeatureKeys() {
        List<String> emptyList;
        Map<String, Map<String, String>> map = this.antiFeatures;
        if (map != null) {
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry<String, Map<String, String>> entry : map.entrySet()) {
                arrayList.add(entry.getKey());
            }
            return arrayList;
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AppOverviewItem(long j, String packageName, long j2, long j3, String str, String str2, Map<String, ? extends Map<String, String>> map, List<LocalizedIcon> list, boolean z) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.repoId = j;
        this.packageName = packageName;
        this.added = j2;
        this.lastUpdated = j3;
        this.name = str;
        this.summary = str2;
        this.antiFeatures = map;
        this.localizedIcon = list;
        this.isCompatible = z;
    }

    public /* synthetic */ AppOverviewItem(long j, String str, long j2, long j3, String str2, String str3, Map map, List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, j2, j3, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : map, (i & 128) != 0 ? null : list, z);
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
}
