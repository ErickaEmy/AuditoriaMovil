package org.fdroid.database;

import androidx.core.os.LocaleListCompat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.ErrorBundle;
import org.fdroid.LocaleChooser;
import org.fdroid.fdroid.nearby.peers.BonjourPeer;
import org.fdroid.index.v2.FileV2;
import org.fdroid.index.v2.Screenshots;
/* compiled from: App.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÂ\u0003J\u0011\u0010*\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005HÂ\u0003J7\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005HÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\f2\u0006\u00101\u001a\u000202J\u0010\u00103\u001a\u0004\u0018\u00010\r2\u0006\u00101\u001a\u000202J\u0012\u00104\u001a\u0004\u0018\u00010\r2\u0006\u00101\u001a\u000202H\u0016J$\u00105\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bj\u0004\u0018\u0001`\u000e2\u0006\u00106\u001a\u00020\fH\u0002J*\u00107\u001a\u001c\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0005\u0018\u00010\u000bj\u0004\u0018\u0001`82\u0006\u00106\u001a\u00020\fH\u0002J\u0014\u00109\u001a\b\u0012\u0004\u0012\u00020\r0\u00052\u0006\u00101\u001a\u000202J\u0010\u0010:\u001a\u0004\u0018\u00010\r2\u0006\u00101\u001a\u000202J\u0014\u0010;\u001a\b\u0012\u0004\u0012\u00020\r0\u00052\u0006\u00101\u001a\u000202J\u0014\u0010<\u001a\b\u0012\u0004\u0012\u00020\r0\u00052\u0006\u00101\u001a\u000202J\u0010\u0010=\u001a\u0004\u0018\u00010\r2\u0006\u00101\u001a\u000202J\u0014\u0010>\u001a\b\u0012\u0004\u0012\u00020\r0\u00052\u0006\u00101\u001a\u000202J\u0010\u0010?\u001a\u0004\u0018\u00010\f2\u0006\u00101\u001a\u000202J\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020\r0\u00052\u0006\u00101\u001a\u000202J\t\u0010A\u001a\u00020BHÖ\u0001J\t\u0010C\u001a\u00020\fHÖ\u0001R(\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bj\u0004\u0018\u0001`\u000e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R(\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bj\u0004\u0018\u0001`\u000e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R(\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bj\u0004\u0018\u0001`\u000e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0010R\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u0004\u0018\u00010!8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0016\u0010$\u001a\u0004\u0018\u00010\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0017R(\u0010&\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bj\u0004\u0018\u0001`\u000e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0010¨\u0006D"}, d2 = {"Lorg/fdroid/database/App;", "Lorg/fdroid/database/MinimalApp;", "metadata", "Lorg/fdroid/database/AppMetadata;", "localizedFiles", "", "Lorg/fdroid/database/LocalizedFile;", "localizedFileLists", "Lorg/fdroid/database/LocalizedFileList;", "(Lorg/fdroid/database/AppMetadata;Ljava/util/List;Ljava/util/List;)V", "featureGraphic", "", "", "Lorg/fdroid/index/v2/FileV2;", "Lorg/fdroid/index/v2/LocalizedFileV2;", "getFeatureGraphic$database_release", "()Ljava/util/Map;", "icon", "getIcon$database_release", "getMetadata", "()Lorg/fdroid/database/AppMetadata;", "name", "getName", "()Ljava/lang/String;", "packageName", "getPackageName", "promoGraphic", "getPromoGraphic$database_release", "repoId", "", "getRepoId", "()J", "screenshots", "Lorg/fdroid/index/v2/Screenshots;", "getScreenshots$database_release", "()Lorg/fdroid/index/v2/Screenshots;", ErrorBundle.SUMMARY_ENTRY, "getSummary", "tvBanner", "getTvBanner$database_release", "component1", "component2", "component3", "copy", "equals", "", "other", "", "getDescription", "localeList", "Landroidx/core/os/LocaleListCompat;", "getFeatureGraphic", "getIcon", "getLocalizedFile", BonjourPeer.TYPE, "getLocalizedFileList", "Lorg/fdroid/index/v2/LocalizedFileListV2;", "getPhoneScreenshots", "getPromoGraphic", "getSevenInchScreenshots", "getTenInchScreenshots", "getTvBanner", "getTvScreenshots", "getVideo", "getWearScreenshots", "hashCode", "", "toString", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class App implements MinimalApp {
    private final List<LocalizedFileList> localizedFileLists;
    private final List<LocalizedFile> localizedFiles;
    private final AppMetadata metadata;

    private final List<LocalizedFile> component2() {
        return this.localizedFiles;
    }

    private final List<LocalizedFileList> component3() {
        return this.localizedFileLists;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ App copy$default(App app, AppMetadata appMetadata, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            appMetadata = app.metadata;
        }
        if ((i & 2) != 0) {
            list = app.localizedFiles;
        }
        if ((i & 4) != 0) {
            list2 = app.localizedFileLists;
        }
        return app.copy(appMetadata, list, list2);
    }

    public final AppMetadata component1() {
        return this.metadata;
    }

    public final App copy(AppMetadata metadata, List<LocalizedFile> list, List<LocalizedFileList> list2) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        return new App(metadata, list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof App) {
            App app = (App) obj;
            return Intrinsics.areEqual(this.metadata, app.metadata) && Intrinsics.areEqual(this.localizedFiles, app.localizedFiles) && Intrinsics.areEqual(this.localizedFileLists, app.localizedFileLists);
        }
        return false;
    }

    public final AppMetadata getMetadata() {
        return this.metadata;
    }

    public int hashCode() {
        int hashCode = this.metadata.hashCode() * 31;
        List<LocalizedFile> list = this.localizedFiles;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<LocalizedFileList> list2 = this.localizedFileLists;
        return hashCode2 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        AppMetadata appMetadata = this.metadata;
        List<LocalizedFile> list = this.localizedFiles;
        List<LocalizedFileList> list2 = this.localizedFileLists;
        return "App(metadata=" + appMetadata + ", localizedFiles=" + list + ", localizedFileLists=" + list2 + ")";
    }

    public App(AppMetadata metadata, List<LocalizedFile> list, List<LocalizedFileList> list2) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.metadata = metadata;
        this.localizedFiles = list;
        this.localizedFileLists = list2;
    }

    public /* synthetic */ App(AppMetadata appMetadata, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appMetadata, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : list2);
    }

    @Override // org.fdroid.database.MinimalApp
    public long getRepoId() {
        return this.metadata.getRepoId();
    }

    @Override // org.fdroid.database.MinimalApp
    public String getPackageName() {
        return this.metadata.getPackageName();
    }

    public final Map<String, FileV2> getIcon$database_release() {
        return getLocalizedFile("icon");
    }

    public final Map<String, FileV2> getFeatureGraphic$database_release() {
        return getLocalizedFile("featureGraphic");
    }

    public final Map<String, FileV2> getPromoGraphic$database_release() {
        return getLocalizedFile("promoGraphic");
    }

    public final Map<String, FileV2> getTvBanner$database_release() {
        return getLocalizedFile("tvBanner");
    }

    public final Screenshots getScreenshots$database_release() {
        List<LocalizedFileList> list = this.localizedFileLists;
        if (list == null || list.isEmpty()) {
            return null;
        }
        Screenshots screenshots = new Screenshots(getLocalizedFileList("phone"), getLocalizedFileList("sevenInch"), getLocalizedFileList("tenInch"), getLocalizedFileList("wear"), getLocalizedFileList("tv"));
        if (!screenshots.isNull()) {
            return screenshots;
        }
        return null;
    }

    private final Map<String, List<FileV2>> getLocalizedFileList(String str) {
        HashMap hashMap = new HashMap();
        List<LocalizedFileList> list = this.localizedFileLists;
        if (list != null && (r1 = list.iterator()) != null) {
            for (LocalizedFileList localizedFileList : list) {
                if (localizedFileList.getRepoId() == this.metadata.getRepoId() && Intrinsics.areEqual(localizedFileList.getType(), str)) {
                    String locale = localizedFileList.getLocale();
                    Object obj = hashMap.get(locale);
                    if (obj == null) {
                        obj = new ArrayList();
                        hashMap.put(locale, obj);
                    }
                    ((ArrayList) obj).add(new FileV2(localizedFileList.getName(), localizedFileList.getSha256(), localizedFileList.getSize(), localizedFileList.getIpfsCidV1()));
                }
            }
        }
        if (hashMap.isEmpty()) {
            return null;
        }
        return hashMap;
    }

    @Override // org.fdroid.database.MinimalApp
    public String getName() {
        return this.metadata.getLocalizedName();
    }

    @Override // org.fdroid.database.MinimalApp
    public String getSummary() {
        return this.metadata.getLocalizedSummary();
    }

    public final String getDescription(LocaleListCompat localeList) {
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        return (String) LocaleChooser.INSTANCE.getBestLocale(this.metadata.getDescription(), localeList);
    }

    public final String getVideo(LocaleListCompat localeList) {
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        return (String) LocaleChooser.INSTANCE.getBestLocale(this.metadata.getVideo(), localeList);
    }

    @Override // org.fdroid.database.MinimalApp
    public FileV2 getIcon(LocaleListCompat localeList) {
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        return (FileV2) LocaleChooser.INSTANCE.getBestLocale(getIcon$database_release(), localeList);
    }

    public final FileV2 getFeatureGraphic(LocaleListCompat localeList) {
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        return (FileV2) LocaleChooser.INSTANCE.getBestLocale(getFeatureGraphic$database_release(), localeList);
    }

    public final FileV2 getPromoGraphic(LocaleListCompat localeList) {
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        return (FileV2) LocaleChooser.INSTANCE.getBestLocale(getPromoGraphic$database_release(), localeList);
    }

    public final FileV2 getTvBanner(LocaleListCompat localeList) {
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        return (FileV2) LocaleChooser.INSTANCE.getBestLocale(getTvBanner$database_release(), localeList);
    }

    public final List<FileV2> getPhoneScreenshots(LocaleListCompat localeList) {
        List<FileV2> emptyList;
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        LocaleChooser localeChooser = LocaleChooser.INSTANCE;
        Screenshots screenshots$database_release = getScreenshots$database_release();
        List<FileV2> list = (List) localeChooser.getBestLocale(screenshots$database_release != null ? screenshots$database_release.getPhone() : null, localeList);
        if (list == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return list;
    }

    public final List<FileV2> getSevenInchScreenshots(LocaleListCompat localeList) {
        List<FileV2> emptyList;
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        LocaleChooser localeChooser = LocaleChooser.INSTANCE;
        Screenshots screenshots$database_release = getScreenshots$database_release();
        List<FileV2> list = (List) localeChooser.getBestLocale(screenshots$database_release != null ? screenshots$database_release.getSevenInch() : null, localeList);
        if (list == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return list;
    }

    public final List<FileV2> getTenInchScreenshots(LocaleListCompat localeList) {
        List<FileV2> emptyList;
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        LocaleChooser localeChooser = LocaleChooser.INSTANCE;
        Screenshots screenshots$database_release = getScreenshots$database_release();
        List<FileV2> list = (List) localeChooser.getBestLocale(screenshots$database_release != null ? screenshots$database_release.getTenInch() : null, localeList);
        if (list == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return list;
    }

    public final List<FileV2> getTvScreenshots(LocaleListCompat localeList) {
        List<FileV2> emptyList;
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        LocaleChooser localeChooser = LocaleChooser.INSTANCE;
        Screenshots screenshots$database_release = getScreenshots$database_release();
        List<FileV2> list = (List) localeChooser.getBestLocale(screenshots$database_release != null ? screenshots$database_release.getTv() : null, localeList);
        if (list == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return list;
    }

    public final List<FileV2> getWearScreenshots(LocaleListCompat localeList) {
        List<FileV2> emptyList;
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        LocaleChooser localeChooser = LocaleChooser.INSTANCE;
        Screenshots screenshots$database_release = getScreenshots$database_release();
        List<FileV2> list = (List) localeChooser.getBestLocale(screenshots$database_release != null ? screenshots$database_release.getWear() : null, localeList);
        if (list == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return list;
    }

    private final Map<String, FileV2> getLocalizedFile(String str) {
        List<LocalizedFile> list = this.localizedFiles;
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                LocalizedFile localizedFile = (LocalizedFile) obj;
                if (localizedFile.getRepoId() == this.metadata.getRepoId() && Intrinsics.areEqual(localizedFile.getType(), str)) {
                    arrayList.add(obj);
                }
            }
            return AppKt.toLocalizedFileV2(arrayList);
        }
        return null;
    }
}
