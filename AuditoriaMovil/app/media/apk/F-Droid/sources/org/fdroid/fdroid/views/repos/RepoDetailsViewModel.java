package org.fdroid.fdroid.views.repos;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.fdroid.database.Repository;
import org.fdroid.fdroid.FDroidApp;
import org.fdroid.index.RepoManager;
/* compiled from: RepoDetailsViewModel.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dJ\f\u0010\u001e\u001a\u00020\u001d*\u00020\rH\u0002R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001f"}, d2 = {"Lorg/fdroid/fdroid/views/repos/RepoDetailsViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lorg/fdroid/fdroid/views/repos/RepoDetailsState;", "liveData", "Landroidx/lifecycle/LiveData;", "getLiveData", "()Landroidx/lifecycle/LiveData;", "repoLiveData", "Lorg/fdroid/database/Repository;", "getRepoLiveData", "repoManager", "Lorg/fdroid/index/RepoManager;", "kotlin.jvm.PlatformType", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "initRepo", "", "repoId", "", "setArchiveRepoEnabled", "repo", "enabled", "", "isArchiveEnabled", "app_fullRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RepoDetailsViewModel extends AndroidViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow _state;
    private final LiveData liveData;
    private final LiveData repoLiveData;
    private final RepoManager repoManager;
    private final StateFlow state;

    public final LiveData getLiveData() {
        return this.liveData;
    }

    public final LiveData getRepoLiveData() {
        return this.repoLiveData;
    }

    public final StateFlow getState() {
        return this.state;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RepoDetailsViewModel(Application app) {
        super(app);
        Intrinsics.checkNotNullParameter(app, "app");
        RepoManager repoManager = FDroidApp.getRepoManager(app);
        this.repoManager = repoManager;
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._state = MutableStateFlow;
        this.state = FlowKt.asStateFlow(MutableStateFlow);
        this.liveData = FlowLiveDataConversions.asLiveData$default(MutableStateFlow, null, 0L, 3, null);
        this.repoLiveData = FlowLiveDataConversions.asLiveData$default(FlowKt.distinctUntilChanged(FlowKt.combine(MutableStateFlow, repoManager.getRepositoriesState(), new RepoDetailsViewModel$repoLiveData$1(null))), null, 0L, 3, null);
    }

    public final void initRepo(long j) {
        Repository repository = this.repoManager.getRepository(j);
        if (repository == null) {
            this._state.setValue(new RepoDetailsState(null, null, 2, null));
        } else {
            this._state.setValue(new RepoDetailsState(repository, Boolean.valueOf(isArchiveEnabled(repository))));
        }
    }

    public final void setArchiveRepoEnabled(Repository repo, boolean z) {
        Intrinsics.checkNotNullParameter(repo, "repo");
        MutableStateFlow mutableStateFlow = this._state;
        RepoDetailsState repoDetailsState = (RepoDetailsState) mutableStateFlow.getValue();
        mutableStateFlow.setValue(repoDetailsState != null ? RepoDetailsState.copy$default(repoDetailsState, null, null, 1, null) : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new RepoDetailsViewModel$setArchiveRepoEnabled$1(this, repo, z, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isArchiveEnabled(Repository repository) {
        Object obj;
        Iterator<T> it = this.repoManager.getRepositories().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Repository repository2 = (Repository) obj;
            if (repository2.isArchiveRepo() && Intrinsics.areEqual(repository2.getCertificate(), repository.getCertificate())) {
                break;
            }
        }
        Repository repository3 = (Repository) obj;
        if (repository3 != null) {
            return repository3.getEnabled();
        }
        return false;
    }
}
