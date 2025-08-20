package org.fdroid.index;

import android.content.Context;
import android.net.Uri;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import ch.qos.logback.core.CoreConstants;
import java.io.File;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.fdroid.database.AppPrefsDao;
import org.fdroid.database.AppPrefsDaoInt;
import org.fdroid.database.FDroidDatabase;
import org.fdroid.database.Repository;
import org.fdroid.database.RepositoryDao;
import org.fdroid.database.RepositoryDaoInt;
import org.fdroid.download.DownloaderFactory;
import org.fdroid.download.HttpManager;
import org.fdroid.repo.RepoAdder;
import org.fdroid.repo.RepoUriGetter;
/* compiled from: RepoManager.kt */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B;\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u0010*\u001a\u00020+H\u0007J\b\u0010,\u001a\u00020+H\u0007J\u0010\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020/H\u0007J\u001c\u00100\u001a\u00020+2\u0006\u00101\u001a\u0002022\n\b\u0002\u00103\u001a\u0004\u0018\u000104H\u0007J\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u0010\u00106\u001a\u0004\u0018\u00010\u00122\u0006\u0010.\u001a\u00020/J\u0012\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:H\u0007J\u0018\u0010;\u001a\u00020+2\u0006\u0010<\u001a\u00020\u00122\u0006\u0010=\u001a\u00020\u0012H\u0007J,\u0010>\u001a\u0004\u0018\u00010/2\u0006\u0010?\u001a\u00020\u00122\u0006\u0010@\u001a\u0002082\n\b\u0002\u00103\u001a\u0004\u0018\u000104H\u0087@¢\u0006\u0002\u0010AJ\u0018\u0010B\u001a\u00020+2\u0006\u0010C\u001a\u0002022\u0006\u0010.\u001a\u00020/H\u0007J\u0018\u0010D\u001a\u00020+2\u0006\u0010.\u001a\u00020/2\u0006\u0010@\u001a\u000208H\u0007R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0014¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lorg/fdroid/index/RepoManager;", "", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "db", "Lorg/fdroid/database/FDroidDatabase;", "downloaderFactory", "Lorg/fdroid/download/DownloaderFactory;", "httpManager", "Lorg/fdroid/download/HttpManager;", "repoUriBuilder", "Lorg/fdroid/index/RepoUriBuilder;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroid/content/Context;Lorg/fdroid/database/FDroidDatabase;Lorg/fdroid/download/DownloaderFactory;Lorg/fdroid/download/HttpManager;Lorg/fdroid/index/RepoUriBuilder;Lkotlin/coroutines/CoroutineContext;)V", "_repositoriesState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lorg/fdroid/database/Repository;", "addRepoState", "Lkotlinx/coroutines/flow/StateFlow;", "Lorg/fdroid/repo/AddRepoState;", "getAddRepoState", "()Lkotlinx/coroutines/flow/StateFlow;", "appPrefsDao", "Lorg/fdroid/database/AppPrefsDaoInt;", "liveAddRepoState", "Landroidx/lifecycle/LiveData;", "getLiveAddRepoState", "()Landroidx/lifecycle/LiveData;", "liveRepositories", "getLiveRepositories", "repoAdder", "Lorg/fdroid/repo/RepoAdder;", "repoCountDownLatch", "Ljava/util/concurrent/CountDownLatch;", "repositoriesState", "getRepositoriesState", "repositoryDao", "Lorg/fdroid/database/RepositoryDaoInt;", "tempFileProvider", "Lorg/fdroid/index/TempFileProvider;", "abortAddingRepository", "", "addFetchedRepository", "deleteRepository", "repoId", "", "fetchRepositoryPreview", "url", "", "proxy", "Ljava/net/Proxy;", "getRepositories", "getRepository", "isSwapUri", "", "uri", "Landroid/net/Uri;", "reorderRepositories", "repoToReorder", "repoTarget", "setArchiveRepoEnabled", "repository", "enabled", "(Lorg/fdroid/database/Repository;ZLjava/net/Proxy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPreferredRepoId", "packageName", "setRepositoryEnabled", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RepoManager {
    private final MutableStateFlow _repositoriesState;
    private final StateFlow addRepoState;
    private final AppPrefsDaoInt appPrefsDao;
    private final CoroutineContext coroutineContext;
    private final FDroidDatabase db;
    private final LiveData liveAddRepoState;
    private final LiveData liveRepositories;
    private final RepoAdder repoAdder;
    private final CountDownLatch repoCountDownLatch;
    private final StateFlow repositoriesState;
    private final RepositoryDaoInt repositoryDao;
    private final TempFileProvider tempFileProvider;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RepoManager(Context context, FDroidDatabase db, DownloaderFactory downloaderFactory, HttpManager httpManager) {
        this(context, db, downloaderFactory, httpManager, null, null, 48, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(db, "db");
        Intrinsics.checkNotNullParameter(downloaderFactory, "downloaderFactory");
        Intrinsics.checkNotNullParameter(httpManager, "httpManager");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RepoManager(Context context, FDroidDatabase db, DownloaderFactory downloaderFactory, HttpManager httpManager, RepoUriBuilder repoUriBuilder) {
        this(context, db, downloaderFactory, httpManager, repoUriBuilder, null, 32, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(db, "db");
        Intrinsics.checkNotNullParameter(downloaderFactory, "downloaderFactory");
        Intrinsics.checkNotNullParameter(httpManager, "httpManager");
        Intrinsics.checkNotNullParameter(repoUriBuilder, "repoUriBuilder");
    }

    public final void fetchRepositoryPreview(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        fetchRepositoryPreview$default(this, url, null, 2, null);
    }

    public final StateFlow getAddRepoState() {
        return this.addRepoState;
    }

    public final LiveData getLiveAddRepoState() {
        return this.liveAddRepoState;
    }

    public final LiveData getLiveRepositories() {
        return this.liveRepositories;
    }

    public final StateFlow getRepositoriesState() {
        return this.repositoriesState;
    }

    public RepoManager(final Context context, FDroidDatabase db, DownloaderFactory downloaderFactory, HttpManager httpManager, RepoUriBuilder repoUriBuilder, CoroutineContext coroutineContext) {
        List emptyList;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(db, "db");
        Intrinsics.checkNotNullParameter(downloaderFactory, "downloaderFactory");
        Intrinsics.checkNotNullParameter(httpManager, "httpManager");
        Intrinsics.checkNotNullParameter(repoUriBuilder, "repoUriBuilder");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        this.db = db;
        this.coroutineContext = coroutineContext;
        RepositoryDao repositoryDao = db.getRepositoryDao();
        Intrinsics.checkNotNull(repositoryDao, "null cannot be cast to non-null type org.fdroid.database.RepositoryDaoInt");
        this.repositoryDao = (RepositoryDaoInt) repositoryDao;
        AppPrefsDao appPrefsDao = db.getAppPrefsDao();
        Intrinsics.checkNotNull(appPrefsDao, "null cannot be cast to non-null type org.fdroid.database.AppPrefsDaoInt");
        this.appPrefsDao = (AppPrefsDaoInt) appPrefsDao;
        TempFileProvider tempFileProvider = new TempFileProvider() { // from class: org.fdroid.index.RepoManager$$ExternalSyntheticLambda0
            @Override // org.fdroid.index.TempFileProvider
            public final File createTempFile() {
                File tempFileProvider$lambda$0;
                tempFileProvider$lambda$0 = RepoManager.tempFileProvider$lambda$0(context);
                return tempFileProvider$lambda$0;
            }
        };
        this.tempFileProvider = tempFileProvider;
        RepoAdder repoAdder = new RepoAdder(context, db, tempFileProvider, downloaderFactory, httpManager, null, repoUriBuilder, coroutineContext, 32, null);
        this.repoAdder = repoAdder;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(emptyList);
        this._repositoriesState = MutableStateFlow;
        this.repositoriesState = FlowKt.asStateFlow(MutableStateFlow);
        this.liveRepositories = FlowLiveDataConversions.asLiveData$default(MutableStateFlow, null, 0L, 3, null);
        this.addRepoState = FlowKt.asStateFlow(repoAdder.getAddRepoState$database_release());
        this.liveAddRepoState = FlowLiveDataConversions.asLiveData$default(repoAdder.getAddRepoState$database_release(), null, 0L, 3, null);
        this.repoCountDownLatch = new CountDownLatch(1);
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, coroutineContext, null, new AnonymousClass1(null), 2, null);
    }

    public /* synthetic */ RepoManager(Context context, FDroidDatabase fDroidDatabase, DownloaderFactory downloaderFactory, HttpManager httpManager, RepoUriBuilder repoUriBuilder, CoroutineContext coroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, fDroidDatabase, downloaderFactory, httpManager, (i & 16) != 0 ? IndexUpdaterKt.getDefaultRepoUriBuilder() : repoUriBuilder, (i & 32) != 0 ? Dispatchers.getIO() : coroutineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final File tempFileProvider$lambda$0(Context context) {
        Intrinsics.checkNotNullParameter(context, "$context");
        File createTempFile = File.createTempFile("dl-", "", context.getCacheDir());
        Intrinsics.checkNotNullExpressionValue(createTempFile, "createTempFile(...)");
        return createTempFile;
    }

    /* compiled from: RepoManager.kt */
    /* renamed from: org.fdroid.index.RepoManager$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                RepoManager.this._repositoriesState.setValue(RepoManager.this.repositoryDao.getRepositories());
                RepoManager.this.repoCountDownLatch.countDown();
                MainCoroutineDispatcher main = Dispatchers.getMain();
                C00411 c00411 = new C00411(RepoManager.this, null);
                this.label = 1;
                if (BuildersKt.withContext(main, c00411, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: RepoManager.kt */
        /* renamed from: org.fdroid.index.RepoManager$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C00411 extends SuspendLambda implements Function2 {
            int label;
            final /* synthetic */ RepoManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00411(RepoManager repoManager, Continuation continuation) {
                super(2, continuation);
                this.this$0 = repoManager;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new C00411(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((C00411) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    LiveData liveRepositories = this.this$0.db.getRepositoryDao().getLiveRepositories();
                    final RepoManager repoManager = this.this$0;
                    liveRepositories.observeForever(new RepoManager$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: org.fdroid.index.RepoManager.1.1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                            invoke((List) obj2);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(List list) {
                            MutableStateFlow mutableStateFlow = RepoManager.this._repositoriesState;
                            Intrinsics.checkNotNull(list);
                            mutableStateFlow.setValue(list);
                        }
                    }));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Repository getRepository(long j) {
        Object obj;
        this.repoCountDownLatch.await();
        Iterator it = ((Iterable) this.repositoriesState.getValue()).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((Repository) obj).getRepoId() == j) {
                break;
            }
        }
        return (Repository) obj;
    }

    public final List<Repository> getRepositories() {
        this.repoCountDownLatch.await();
        return (List) this.repositoriesState.getValue();
    }

    public final void setRepositoryEnabled(long j, boolean z) {
        this.repositoryDao.setRepositoryEnabled(j, z);
    }

    public final void deleteRepository(long j) {
        this.repositoryDao.deleteRepository(j);
        MutableStateFlow mutableStateFlow = this._repositoriesState;
        ArrayList arrayList = new ArrayList();
        for (Object obj : (Iterable) mutableStateFlow.getValue()) {
            if (((Repository) obj).getRepoId() == j) {
                arrayList.add(obj);
            }
        }
        mutableStateFlow.setValue(arrayList);
    }

    public static /* synthetic */ void fetchRepositoryPreview$default(RepoManager repoManager, String str, Proxy proxy, int i, Object obj) {
        if ((i & 2) != 0) {
            proxy = null;
        }
        repoManager.fetchRepositoryPreview(str, proxy);
    }

    public final void fetchRepositoryPreview(String url, Proxy proxy) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.repoAdder.fetchRepository$database_release(url, proxy);
    }

    public final void addFetchedRepository() {
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, this.coroutineContext, null, new RepoManager$addFetchedRepository$1(this, null), 2, null);
    }

    public final void abortAddingRepository() {
        this.repoAdder.abortAddingRepo$database_release();
    }

    public final void setPreferredRepoId(String packageName, long j) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, this.coroutineContext, null, new RepoManager$setPreferredRepoId$1(this, packageName, j, null), 2, null);
    }

    public final void reorderRepositories(Repository repoToReorder, Repository repoTarget) {
        Intrinsics.checkNotNullParameter(repoToReorder, "repoToReorder");
        Intrinsics.checkNotNullParameter(repoTarget, "repoTarget");
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, this.coroutineContext, null, new RepoManager$reorderRepositories$1(this, repoToReorder, repoTarget, null), 2, null);
    }

    public static /* synthetic */ Object setArchiveRepoEnabled$default(RepoManager repoManager, Repository repository, boolean z, Proxy proxy, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            proxy = null;
        }
        return repoManager.setArchiveRepoEnabled(repository, z, proxy, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object setArchiveRepoEnabled(org.fdroid.database.Repository r6, boolean r7, java.net.Proxy r8, kotlin.coroutines.Continuation r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof org.fdroid.index.RepoManager$setArchiveRepoEnabled$1
            if (r0 == 0) goto L13
            r0 = r9
            org.fdroid.index.RepoManager$setArchiveRepoEnabled$1 r0 = (org.fdroid.index.RepoManager$setArchiveRepoEnabled$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            org.fdroid.index.RepoManager$setArchiveRepoEnabled$1 r0 = new org.fdroid.index.RepoManager$setArchiveRepoEnabled$1
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r6 = r0.L$0
            java.lang.Long r6 = (java.lang.Long) r6
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.util.concurrent.CancellationException -> L2d
            goto L58
        L2d:
            r7 = move-exception
            goto L5d
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.String r9 = r6.getCertificate()
            org.fdroid.database.RepositoryDaoInt r2 = r5.repositoryDao
            java.lang.Long r9 = r2.getArchiveRepoId(r9)
            if (r7 == 0) goto L76
            if (r9 != 0) goto L6c
            org.fdroid.repo.RepoAdder r7 = r5.repoAdder     // Catch: java.util.concurrent.CancellationException -> L5b
            r0.L$0 = r9     // Catch: java.util.concurrent.CancellationException -> L5b
            r0.label = r3     // Catch: java.util.concurrent.CancellationException -> L5b
            java.lang.Object r6 = r7.addArchiveRepo$database_release(r6, r8, r0)     // Catch: java.util.concurrent.CancellationException -> L5b
            if (r6 != r1) goto L55
            return r1
        L55:
            r4 = r9
            r9 = r6
            r6 = r4
        L58:
            java.lang.Long r9 = (java.lang.Long) r9     // Catch: java.util.concurrent.CancellationException -> L2d
            goto L82
        L5b:
            r7 = move-exception
            r6 = r9
        L5d:
            java.lang.String r8 = r7.getMessage()
            java.lang.String r9 = "expected"
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r9)
            if (r8 == 0) goto L6b
            r9 = r6
            goto L82
        L6b:
            throw r7
        L6c:
            org.fdroid.database.RepositoryDaoInt r6 = r5.repositoryDao
            long r7 = r9.longValue()
            r6.setRepositoryEnabled(r7, r3)
            goto L82
        L76:
            if (r9 == 0) goto L82
            org.fdroid.database.RepositoryDaoInt r6 = r5.repositoryDao
            long r7 = r9.longValue()
            r0 = 0
            r6.setRepositoryEnabled(r7, r0)
        L82:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.index.RepoManager.setArchiveRepoEnabled(org.fdroid.database.Repository, boolean, java.net.Proxy, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean isSwapUri(Uri uri) {
        return uri != null && RepoUriGetter.INSTANCE.isSwapUri(uri);
    }
}
