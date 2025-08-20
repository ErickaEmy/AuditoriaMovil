package org.fdroid.fdroid.views.appdetails;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.fdroid.database.App;
import org.fdroid.database.AppPrefs;
import org.fdroid.database.FDroidDatabase;
import org.fdroid.database.Repository;
import org.fdroid.fdroid.FDroidApp;
import org.fdroid.fdroid.data.DBHelper;
import org.fdroid.index.RepoManager;
/* compiled from: AppDetailsViewModel.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010(\u001a\u00020)J\u000e\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u001fJ\u0010\u0010,\u001a\u00020-2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u0016\u0010.\u001a\u00020-2\u0006\u0010\u001c\u001a\u00020\u001dH\u0082@¢\u0006\u0002\u0010/J\b\u00100\u001a\u00020-H\u0014J\u0010\u00101\u001a\u00020-2\u0006\u00102\u001a\u00020\u001fH\u0002J\u0010\u00103\u001a\u00020-2\u0006\u00102\u001a\u00020\u001fH\u0007J\u0010\u00104\u001a\u00020-2\u0006\u00102\u001a\u00020\u001fH\u0007J\u0006\u00105\u001a\u00020)J\b\u00106\u001a\u00020-H\u0002R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n \u0017*\u0004\u0018\u00010\u00160\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010 R\u0016\u0010!\u001a\n \u0017*\u0004\u0018\u00010\"0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\r¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u000fR\u001c\u0010'\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lorg/fdroid/fdroid/views/appdetails/AppDetailsViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_app", "Landroidx/lifecycle/MutableLiveData;", "Lorg/fdroid/database/App;", "_appData", "Lorg/fdroid/fdroid/views/appdetails/AppData;", "_versions", "", "Lorg/fdroid/database/AppVersion;", "Landroidx/lifecycle/LiveData;", "getApp", "()Landroidx/lifecycle/LiveData;", "appData", "getAppData", "appLiveData", "appPrefsLiveData", "Lorg/fdroid/database/AppPrefs;", "db", "Lorg/fdroid/database/FDroidDatabase;", "kotlin.jvm.PlatformType", "onAppChanged", "Landroidx/lifecycle/Observer;", "onAppPrefsChanged", "onVersionsChanged", "packageName", "", "preferredRepoId", "", "Ljava/lang/Long;", "repoManager", "Lorg/fdroid/index/RepoManager;", "repos", "Lorg/fdroid/database/Repository;", "versions", "getVersions", "versionsLiveData", "ignoreAllUpdates", "Lkotlinx/coroutines/Job;", "ignoreVersionCodeUpdate", "versionCode", "loadApp", "", "loadRepos", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCleared", "resetVersionsLiveData", "repoId", "selectRepo", "setPreferredRepo", "toggleBetaReleaseChannel", "tryToPublishAppData", "app_fullRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AppDetailsViewModel extends AndroidViewModel {
    public static final int $stable = 8;
    private final MutableLiveData _app;
    private final MutableLiveData _appData;
    private final MutableLiveData _versions;
    private final LiveData app;
    private final LiveData appData;
    private LiveData appLiveData;
    private LiveData appPrefsLiveData;
    private final FDroidDatabase db;
    private final Observer onAppChanged;
    private final Observer onAppPrefsChanged;
    private final Observer onVersionsChanged;
    private String packageName;
    private Long preferredRepoId;
    private final RepoManager repoManager;
    private List<Repository> repos;
    private final LiveData versions;
    private LiveData versionsLiveData;

    public final LiveData getApp() {
        return this.app;
    }

    public final LiveData getAppData() {
        return this.appData;
    }

    public final LiveData getVersions() {
        return this.versions;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppDetailsViewModel(Application app) {
        super(app);
        Intrinsics.checkNotNullParameter(app, "app");
        MutableLiveData mutableLiveData = new MutableLiveData();
        this._app = mutableLiveData;
        this.app = mutableLiveData;
        MutableLiveData mutableLiveData2 = new MutableLiveData();
        this._versions = mutableLiveData2;
        this.versions = mutableLiveData2;
        MutableLiveData mutableLiveData3 = new MutableLiveData();
        this._appData = mutableLiveData3;
        this.appData = mutableLiveData3;
        this.db = DBHelper.getDb(app.getApplicationContext());
        this.repoManager = FDroidApp.getRepoManager(app.getApplicationContext());
        this.onAppChanged = new Observer() { // from class: org.fdroid.fdroid.views.appdetails.AppDetailsViewModel$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AppDetailsViewModel.onAppChanged$lambda$2(AppDetailsViewModel.this, (App) obj);
            }
        };
        this.onAppPrefsChanged = new Observer() { // from class: org.fdroid.fdroid.views.appdetails.AppDetailsViewModel$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AppDetailsViewModel.onAppPrefsChanged$lambda$3(AppDetailsViewModel.this, (AppPrefs) obj);
            }
        };
        this.onVersionsChanged = new Observer() { // from class: org.fdroid.fdroid.views.appdetails.AppDetailsViewModel$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AppDetailsViewModel.onVersionsChanged$lambda$4(AppDetailsViewModel.this, (List) obj);
            }
        };
    }

    public final void loadApp(String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (Intrinsics.areEqual(this.packageName, packageName)) {
            return;
        }
        String str = this.packageName;
        if (str != null && !Intrinsics.areEqual(str, packageName)) {
            throw new IllegalStateException(new Function0() { // from class: org.fdroid.fdroid.views.appdetails.AppDetailsViewModel$loadApp$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Called loadApp() with different packageName.";
                }
            }.toString());
        }
        this.packageName = packageName;
        LiveData liveData = this.appLiveData;
        if (liveData != null) {
            liveData.removeObserver(this.onAppChanged);
        }
        LiveData app = this.db.getAppDao().getApp(packageName);
        app.observeForever(this.onAppChanged);
        this.appLiveData = app;
        if (this.repoManager.getRepositories().size() > 2) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AppDetailsViewModel$loadApp$3(this, packageName, null), 3, null);
        }
        LiveData appPrefs = this.db.getAppPrefsDao().getAppPrefs(packageName);
        appPrefs.observeForever(this.onAppPrefsChanged);
        this.appPrefsLiveData = appPrefs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        LiveData liveData = this.appLiveData;
        if (liveData != null) {
            liveData.removeObserver(this.onAppChanged);
        }
        LiveData liveData2 = this.appPrefsLiveData;
        if (liveData2 != null) {
            liveData2.removeObserver(this.onAppPrefsChanged);
        }
        LiveData liveData3 = this.versionsLiveData;
        if (liveData3 != null) {
            liveData3.removeObserver(this.onVersionsChanged);
        }
    }

    public final void selectRepo(long j) {
        LiveData liveData = this.appLiveData;
        if (liveData != null) {
            liveData.removeObserver(this.onAppChanged);
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AppDetailsViewModel$selectRepo$1(this, j, null), 2, null);
        tryToPublishAppData();
        resetVersionsLiveData(j);
    }

    public final void setPreferredRepo(long j) {
        RepoManager repoManager = this.repoManager;
        String str = this.packageName;
        if (str == null) {
            throw new IllegalStateException("".toString());
        }
        repoManager.setPreferredRepoId(str, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onAppChanged$lambda$2(AppDetailsViewModel this$0, App app) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0._app.getValue() == null && app != null) {
            this$0.preferredRepoId = Long.valueOf(app.getRepoId());
            this$0.resetVersionsLiveData(app.getRepoId());
            this$0.tryToPublishAppData();
        }
        this$0._app.setValue(app);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onAppPrefsChanged$lambda$3(AppDetailsViewModel this$0, AppPrefs appPrefs) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(appPrefs, "appPrefs");
        if (appPrefs.getPreferredRepoId() != null) {
            this$0.preferredRepoId = appPrefs.getPreferredRepoId();
        }
        this$0.tryToPublishAppData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onVersionsChanged$lambda$4(AppDetailsViewModel this$0, List versions) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(versions, "versions");
        this$0._versions.setValue(versions);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadRepos(String str, Continuation continuation) {
        Object coroutine_suspended;
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new AppDetailsViewModel$loadRepos$2(this, str, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return withContext == coroutine_suspended ? withContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tryToPublishAppData() {
        AppPrefs appPrefs;
        Long l;
        LiveData liveData = this.appPrefsLiveData;
        if (liveData == null || (appPrefs = (AppPrefs) liveData.getValue()) == null || (l = this.preferredRepoId) == null) {
            return;
        }
        long longValue = l.longValue();
        List<Repository> list = this.repos;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        this._appData.postValue(new AppData(appPrefs, longValue, list));
    }

    private final void resetVersionsLiveData(long j) {
        LiveData liveData = this.versionsLiveData;
        if (liveData != null) {
            liveData.removeObserver(this.onVersionsChanged);
        }
        String str = this.packageName;
        if (str == null) {
            throw new IllegalStateException("packageName not initialized".toString());
        }
        LiveData appVersions = this.db.getVersionDao().getAppVersions(j, str);
        appVersions.observeForever(this.onVersionsChanged);
        this.versionsLiveData = appVersions;
    }

    public final Job ignoreAllUpdates() {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AppDetailsViewModel$ignoreAllUpdates$1(this, null), 2, null);
        return launch$default;
    }

    public final Job ignoreVersionCodeUpdate(long j) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AppDetailsViewModel$ignoreVersionCodeUpdate$1(this, j, null), 2, null);
        return launch$default;
    }

    public final Job toggleBetaReleaseChannel() {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AppDetailsViewModel$toggleBetaReleaseChannel$1(this, null), 2, null);
        return launch$default;
    }
}
