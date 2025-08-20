package org.fdroid.fdroid.views.appdetails;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.fdroid.database.AppPrefs;
import org.fdroid.database.Repository;
/* compiled from: AppDetailsViewModel.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lorg/fdroid/fdroid/views/appdetails/AppData;", "", "appPrefs", "Lorg/fdroid/database/AppPrefs;", "preferredRepoId", "", "repos", "", "Lorg/fdroid/database/Repository;", "(Lorg/fdroid/database/AppPrefs;JLjava/util/List;)V", "getAppPrefs", "()Lorg/fdroid/database/AppPrefs;", "getPreferredRepoId", "()J", "getRepos", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_fullRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AppData {
    public static final int $stable = 8;
    private final AppPrefs appPrefs;
    private final long preferredRepoId;
    private final List<Repository> repos;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppData copy$default(AppData appData, AppPrefs appPrefs, long j, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            appPrefs = appData.appPrefs;
        }
        if ((i & 2) != 0) {
            j = appData.preferredRepoId;
        }
        if ((i & 4) != 0) {
            list = appData.repos;
        }
        return appData.copy(appPrefs, j, list);
    }

    public final AppPrefs component1() {
        return this.appPrefs;
    }

    public final long component2() {
        return this.preferredRepoId;
    }

    public final List<Repository> component3() {
        return this.repos;
    }

    public final AppData copy(AppPrefs appPrefs, long j, List<Repository> repos) {
        Intrinsics.checkNotNullParameter(appPrefs, "appPrefs");
        Intrinsics.checkNotNullParameter(repos, "repos");
        return new AppData(appPrefs, j, repos);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AppData) {
            AppData appData = (AppData) obj;
            return Intrinsics.areEqual(this.appPrefs, appData.appPrefs) && this.preferredRepoId == appData.preferredRepoId && Intrinsics.areEqual(this.repos, appData.repos);
        }
        return false;
    }

    public final AppPrefs getAppPrefs() {
        return this.appPrefs;
    }

    public final long getPreferredRepoId() {
        return this.preferredRepoId;
    }

    public final List<Repository> getRepos() {
        return this.repos;
    }

    public int hashCode() {
        return (((this.appPrefs.hashCode() * 31) + FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(this.preferredRepoId)) * 31) + this.repos.hashCode();
    }

    public String toString() {
        AppPrefs appPrefs = this.appPrefs;
        long j = this.preferredRepoId;
        List<Repository> list = this.repos;
        return "AppData(appPrefs=" + appPrefs + ", preferredRepoId=" + j + ", repos=" + list + ")";
    }

    public AppData(AppPrefs appPrefs, long j, List<Repository> repos) {
        Intrinsics.checkNotNullParameter(appPrefs, "appPrefs");
        Intrinsics.checkNotNullParameter(repos, "repos");
        this.appPrefs = appPrefs;
        this.preferredRepoId = j;
        this.repos = repos;
    }
}
