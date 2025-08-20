package org.fdroid.database;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import androidx.compose.foundation.ClickableElement$$ExternalSyntheticBackport0;
import androidx.core.os.LocaleListCompat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.ErrorBundle;
import org.fdroid.LocaleChooser;
import org.fdroid.index.v2.FileV2;
/* compiled from: App.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Ba\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f¢\u0006\u0002\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0016\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fHÀ\u0003¢\u0006\u0002\b(Jo\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fHÆ\u0001J\u0013\u0010*\u001a\u00020\n2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\u0012\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u000200H\u0016J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0013R\u001c\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0016\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u00064"}, d2 = {"Lorg/fdroid/database/UpdatableApp;", "Lorg/fdroid/database/MinimalApp;", "repoId", "", "packageName", "", "installedVersionCode", "update", "Lorg/fdroid/database/AppVersion;", "isFromPreferredRepo", "", "hasKnownVulnerability", "name", ErrorBundle.SUMMARY_ENTRY, "localizedIcon", "", "Lorg/fdroid/database/LocalizedIcon;", "(JLjava/lang/String;JLorg/fdroid/database/AppVersion;ZZLjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getHasKnownVulnerability", "()Z", "getInstalledVersionCode", "()J", "getLocalizedIcon$database_release", "()Ljava/util/List;", "getName", "()Ljava/lang/String;", "getPackageName", "getRepoId", "getSummary", "getUpdate", "()Lorg/fdroid/database/AppVersion;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component9$database_release", "copy", "equals", "other", "", "getIcon", "Lorg/fdroid/index/v2/FileV2;", "localeList", "Landroidx/core/os/LocaleListCompat;", "hashCode", "", "toString", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UpdatableApp implements MinimalApp {
    private final boolean hasKnownVulnerability;
    private final long installedVersionCode;
    private final boolean isFromPreferredRepo;
    private final List<LocalizedIcon> localizedIcon;
    private final String name;
    private final String packageName;
    private final long repoId;
    private final String summary;
    private final AppVersion update;

    public final long component1() {
        return this.repoId;
    }

    public final String component2() {
        return this.packageName;
    }

    public final long component3() {
        return this.installedVersionCode;
    }

    public final AppVersion component4() {
        return this.update;
    }

    public final boolean component5() {
        return this.isFromPreferredRepo;
    }

    public final boolean component6() {
        return this.hasKnownVulnerability;
    }

    public final String component7() {
        return this.name;
    }

    public final String component8() {
        return this.summary;
    }

    public final List<LocalizedIcon> component9$database_release() {
        return this.localizedIcon;
    }

    public final UpdatableApp copy(long j, String packageName, long j2, AppVersion update, boolean z, boolean z2, String str, String str2, List<LocalizedIcon> list) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(update, "update");
        return new UpdatableApp(j, packageName, j2, update, z, z2, str, str2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UpdatableApp) {
            UpdatableApp updatableApp = (UpdatableApp) obj;
            return this.repoId == updatableApp.repoId && Intrinsics.areEqual(this.packageName, updatableApp.packageName) && this.installedVersionCode == updatableApp.installedVersionCode && Intrinsics.areEqual(this.update, updatableApp.update) && this.isFromPreferredRepo == updatableApp.isFromPreferredRepo && this.hasKnownVulnerability == updatableApp.hasKnownVulnerability && Intrinsics.areEqual(this.name, updatableApp.name) && Intrinsics.areEqual(this.summary, updatableApp.summary) && Intrinsics.areEqual(this.localizedIcon, updatableApp.localizedIcon);
        }
        return false;
    }

    public final boolean getHasKnownVulnerability() {
        return this.hasKnownVulnerability;
    }

    public final long getInstalledVersionCode() {
        return this.installedVersionCode;
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

    public final AppVersion getUpdate() {
        return this.update;
    }

    public int hashCode() {
        int m = ((((((((((FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(this.repoId) * 31) + this.packageName.hashCode()) * 31) + FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(this.installedVersionCode)) * 31) + this.update.hashCode()) * 31) + ClickableElement$$ExternalSyntheticBackport0.m(this.isFromPreferredRepo)) * 31) + ClickableElement$$ExternalSyntheticBackport0.m(this.hasKnownVulnerability)) * 31;
        String str = this.name;
        int hashCode = (m + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.summary;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<LocalizedIcon> list = this.localizedIcon;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    public final boolean isFromPreferredRepo() {
        return this.isFromPreferredRepo;
    }

    public String toString() {
        long j = this.repoId;
        String str = this.packageName;
        long j2 = this.installedVersionCode;
        AppVersion appVersion = this.update;
        boolean z = this.isFromPreferredRepo;
        boolean z2 = this.hasKnownVulnerability;
        String str2 = this.name;
        String str3 = this.summary;
        List<LocalizedIcon> list = this.localizedIcon;
        return "UpdatableApp(repoId=" + j + ", packageName=" + str + ", installedVersionCode=" + j2 + ", update=" + appVersion + ", isFromPreferredRepo=" + z + ", hasKnownVulnerability=" + z2 + ", name=" + str2 + ", summary=" + str3 + ", localizedIcon=" + list + ")";
    }

    public UpdatableApp(long j, String packageName, long j2, AppVersion update, boolean z, boolean z2, String str, String str2, List<LocalizedIcon> list) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(update, "update");
        this.repoId = j;
        this.packageName = packageName;
        this.installedVersionCode = j2;
        this.update = update;
        this.isFromPreferredRepo = z;
        this.hasKnownVulnerability = z2;
        this.name = str;
        this.summary = str2;
        this.localizedIcon = list;
    }

    public /* synthetic */ UpdatableApp(long j, String str, long j2, AppVersion appVersion, boolean z, boolean z2, String str2, String str3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, j2, appVersion, z, z2, (i & 64) != 0 ? null : str2, (i & 128) != 0 ? null : str3, (i & 256) != 0 ? null : list);
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
                if (((LocalizedIcon) obj).getRepoId() == this.update.getRepoId()) {
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
