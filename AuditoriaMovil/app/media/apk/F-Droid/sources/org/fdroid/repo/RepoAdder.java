package org.fdroid.repo;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.UserManager;
import androidx.core.content.ContextCompat;
import ch.qos.logback.core.CoreConstants;
import java.net.Proxy;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import mu.KLogger;
import mu.KotlinLogging;
import org.fdroid.database.FDroidDatabase;
import org.fdroid.database.Mirror;
import org.fdroid.database.NewRepository;
import org.fdroid.database.Repository;
import org.fdroid.database.RepositoryDao;
import org.fdroid.database.RepositoryDaoInt;
import org.fdroid.download.DownloaderFactory;
import org.fdroid.download.HttpManager;
import org.fdroid.fdroid.nearby.peers.BonjourPeer;
import org.fdroid.index.IndexFormatVersion;
import org.fdroid.index.RepoUriBuilder;
import org.fdroid.index.TempFileProvider;
import org.fdroid.index.v2.FileV2;
import org.fdroid.repo.FetchResult;
/* compiled from: RepoAdder.kt */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\r\u0010\u001e\u001a\u00020\u001fH\u0000¢\u0006\u0002\b J&\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&H\u0081@¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u0004\u0018\u00010$H\u0001¢\u0006\u0002\b*JF\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u00100\u001a\u0004\u0018\u00010/2\b\u00101\u001a\u0004\u0018\u00010/2\u0006\u00102\u001a\u000203H\u0082@¢\u0006\u0002\u00104J\u001f\u00105\u001a\u00020\u001f2\u0006\u00106\u001a\u00020/2\b\u0010%\u001a\u0004\u0018\u00010&H\u0000¢\u0006\u0002\b7J$\u00108\u001a\u00020\u001f2\u0006\u00106\u001a\u00020/2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&H\u0081@¢\u0006\u0004\b9\u0010:J\u0018\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020/2\u0006\u0010>\u001a\u00020$H\u0002J,\u0010?\u001a\u00020$2\u0006\u0010,\u001a\u00020-2\u0006\u0010@\u001a\u00020A2\b\u00100\u001a\u0004\u0018\u00010/2\b\u00101\u001a\u0004\u0018\u00010/H\u0002J\u0010\u0010B\u001a\u00020C2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lorg/fdroid/repo/RepoAdder;", "", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "db", "Lorg/fdroid/database/FDroidDatabase;", "tempFileProvider", "Lorg/fdroid/index/TempFileProvider;", "downloaderFactory", "Lorg/fdroid/download/DownloaderFactory;", "httpManager", "Lorg/fdroid/download/HttpManager;", "repoUriGetter", "Lorg/fdroid/repo/RepoUriGetter;", "repoUriBuilder", "Lorg/fdroid/index/RepoUriBuilder;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroid/content/Context;Lorg/fdroid/database/FDroidDatabase;Lorg/fdroid/index/TempFileProvider;Lorg/fdroid/download/DownloaderFactory;Lorg/fdroid/download/HttpManager;Lorg/fdroid/repo/RepoUriGetter;Lorg/fdroid/index/RepoUriBuilder;Lkotlin/coroutines/CoroutineContext;)V", "addRepoState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lorg/fdroid/repo/AddRepoState;", "getAddRepoState$database_release", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "fetchJob", "Lkotlinx/coroutines/Job;", "log", "Lmu/KLogger;", "repositoryDao", "Lorg/fdroid/database/RepositoryDaoInt;", "abortAddingRepo", "", "abortAddingRepo$database_release", "addArchiveRepo", "", "repo", "Lorg/fdroid/database/Repository;", "proxy", "Ljava/net/Proxy;", "addArchiveRepo$database_release", "(Lorg/fdroid/database/Repository;Ljava/net/Proxy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addFetchedRepository", "addFetchedRepository$database_release", "fetchRepo", "uri", "Landroid/net/Uri;", BonjourPeer.FINGERPRINT, "", "username", "password", "receiver", "Lorg/fdroid/repo/RepoPreviewReceiver;", "(Landroid/net/Uri;Ljava/lang/String;Ljava/net/Proxy;Ljava/lang/String;Ljava/lang/String;Lorg/fdroid/repo/RepoPreviewReceiver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchRepository", "url", "fetchRepository$database_release", "fetchRepositoryInt", "fetchRepositoryInt$database_release", "(Ljava/lang/String;Ljava/net/Proxy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFetchResult", "Lorg/fdroid/repo/FetchResult;", "fetchUrlIn", "fetchedRepo", "getTempRepo", "indexFormatVersion", "Lorg/fdroid/index/IndexFormatVersion;", "hasDisallowInstallUnknownSources", "", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RepoAdder {
    private final MutableStateFlow addRepoState;
    private final Context context;
    private final CoroutineContext coroutineContext;
    private final FDroidDatabase db;
    private final DownloaderFactory downloaderFactory;
    private Job fetchJob;
    private final HttpManager httpManager;
    private final KLogger log;
    private final RepoUriBuilder repoUriBuilder;
    private final RepoUriGetter repoUriGetter;
    private final RepositoryDaoInt repositoryDao;
    private final TempFileProvider tempFileProvider;

    public final MutableStateFlow getAddRepoState$database_release() {
        return this.addRepoState;
    }

    public RepoAdder(Context context, FDroidDatabase db, TempFileProvider tempFileProvider, DownloaderFactory downloaderFactory, HttpManager httpManager, RepoUriGetter repoUriGetter, RepoUriBuilder repoUriBuilder, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(db, "db");
        Intrinsics.checkNotNullParameter(tempFileProvider, "tempFileProvider");
        Intrinsics.checkNotNullParameter(downloaderFactory, "downloaderFactory");
        Intrinsics.checkNotNullParameter(httpManager, "httpManager");
        Intrinsics.checkNotNullParameter(repoUriGetter, "repoUriGetter");
        Intrinsics.checkNotNullParameter(repoUriBuilder, "repoUriBuilder");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        this.context = context;
        this.db = db;
        this.tempFileProvider = tempFileProvider;
        this.downloaderFactory = downloaderFactory;
        this.httpManager = httpManager;
        this.repoUriGetter = repoUriGetter;
        this.repoUriBuilder = repoUriBuilder;
        this.coroutineContext = coroutineContext;
        this.log = KotlinLogging.INSTANCE.logger(new Function0() { // from class: org.fdroid.repo.RepoAdder$log$1
            /* renamed from: invoke  reason: collision with other method in class */
            public final void m2671invoke() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m2671invoke();
                return Unit.INSTANCE;
            }
        });
        RepositoryDao repositoryDao = db.getRepositoryDao();
        Intrinsics.checkNotNull(repositoryDao, "null cannot be cast to non-null type org.fdroid.database.RepositoryDaoInt");
        this.repositoryDao = (RepositoryDaoInt) repositoryDao;
        this.addRepoState = StateFlowKt.MutableStateFlow(None.INSTANCE);
    }

    public /* synthetic */ RepoAdder(Context context, FDroidDatabase fDroidDatabase, TempFileProvider tempFileProvider, DownloaderFactory downloaderFactory, HttpManager httpManager, RepoUriGetter repoUriGetter, RepoUriBuilder repoUriBuilder, CoroutineContext coroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, fDroidDatabase, tempFileProvider, downloaderFactory, httpManager, (i & 32) != 0 ? RepoUriGetter.INSTANCE : repoUriGetter, (i & 64) != 0 ? RepoAdderKt.getDefaultRepoUriBuilder() : repoUriBuilder, (i & 128) != 0 ? Dispatchers.getIO() : coroutineContext);
    }

    public final void fetchRepository$database_release(String url, Proxy proxy) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(url, "url");
        launch$default = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, this.coroutineContext, null, new RepoAdder$fetchRepository$1(this, url, proxy, null), 2, null);
        this.fetchJob = launch$default;
    }

    public static /* synthetic */ Object fetchRepositoryInt$database_release$default(RepoAdder repoAdder, String str, Proxy proxy, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            proxy = null;
        }
        return repoAdder.fetchRepositoryInt$database_release(str, proxy, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object fetchRepositoryInt$database_release(java.lang.String r23, java.net.Proxy r24, kotlin.coroutines.Continuation r25) {
        /*
            Method dump skipped, instructions count: 544
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.repo.RepoAdder.fetchRepositoryInt$database_release(java.lang.String, java.net.Proxy, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e8 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object fetchRepo(android.net.Uri r21, java.lang.String r22, java.net.Proxy r23, java.lang.String r24, java.lang.String r25, org.fdroid.repo.RepoPreviewReceiver r26, kotlin.coroutines.Continuation r27) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.repo.RepoAdder.fetchRepo(android.net.Uri, java.lang.String, java.net.Proxy, java.lang.String, java.lang.String, org.fdroid.repo.RepoPreviewReceiver, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FetchResult getFetchResult(String str, Repository repository) {
        String trimEnd;
        String trimEnd2;
        String trimEnd3;
        String trimEnd4;
        String trimEnd5;
        String certificate = repository.getCertificate();
        if (certificate == null) {
            throw new IllegalStateException("Certificate was null".toString());
        }
        Repository repository2 = this.repositoryDao.getRepository(certificate);
        trimEnd = StringsKt__StringsKt.trimEnd(str, '/');
        Object obj = null;
        if (repository2 == null) {
            trimEnd4 = StringsKt__StringsKt.trimEnd(repository.getAddress(), '/');
            boolean areEqual = Intrinsics.areEqual(trimEnd, trimEnd4);
            Iterator<T> it = repository.getMirrors$database_release().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                trimEnd5 = StringsKt__StringsKt.trimEnd(((Mirror) next).getUrl(), '/');
                if (Intrinsics.areEqual(trimEnd, trimEnd5)) {
                    obj = next;
                    break;
                }
            }
            boolean z = obj != null;
            if (!areEqual && !z) {
                return FetchResult.IsNewRepoAndNewMirror.INSTANCE;
            }
            return FetchResult.IsNewRepository.INSTANCE;
        }
        trimEnd2 = StringsKt__StringsKt.trimEnd(repository2.getAddress(), '/');
        if (Intrinsics.areEqual(trimEnd, trimEnd2)) {
            return new FetchResult.IsExistingRepository(repository2.getRepoId());
        }
        Iterator it2 = Repository.getAllMirrors$default(repository2, false, 1, null).iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            trimEnd3 = StringsKt__StringsKt.trimEnd(((org.fdroid.download.Mirror) next2).getUrl().toString(), '/');
            if (Intrinsics.areEqual(trimEnd, trimEnd3)) {
                obj = next2;
                break;
            }
        }
        if (obj == null) {
            return new FetchResult.IsNewMirror(repository2.getRepoId());
        }
        return new FetchResult.IsExistingMirror(repository2.getRepoId());
    }

    public final Repository addFetchedRepository$database_release() {
        Repository repository;
        MutableStateFlow mutableStateFlow = this.addRepoState;
        Adding adding = Adding.INSTANCE;
        if (mutableStateFlow.compareAndSet(adding, adding)) {
            return null;
        }
        Job job = this.fetchJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, null, 1, null);
        }
        Object value = this.addRepoState.getValue();
        final Fetching fetching = value instanceof Fetching ? (Fetching) value : null;
        if (fetching == null) {
            Object value2 = this.addRepoState.getValue();
            throw new IllegalStateException("Unexpected state: " + value2);
        }
        this.addRepoState.setValue(adding);
        Repository receivedRepo = fetching.getReceivedRepo();
        if (receivedRepo == null) {
            Object value3 = this.addRepoState.getValue();
            throw new IllegalStateException("No repo: " + value3);
        }
        final FetchResult fetchResult = fetching.getFetchResult();
        if (fetchResult == null) {
            Object value4 = this.addRepoState.getValue();
            throw new IllegalStateException("No fetchResult: " + value4);
        } else if (fetchResult instanceof FetchResult.IsExistingRepository) {
            throw new IllegalStateException(("Repo exists: " + fetchResult).toString());
        } else if (fetchResult instanceof FetchResult.IsExistingMirror) {
            throw new IllegalStateException(("Mirror exists: " + fetchResult).toString());
        } else {
            if ((fetchResult instanceof FetchResult.IsNewRepository) || (fetchResult instanceof FetchResult.IsNewRepoAndNewMirror)) {
                Map<String, String> name = receivedRepo.getRepository$database_release().getName();
                Map<String, FileV2> icon = receivedRepo.getRepository$database_release().getIcon();
                if (icon == null) {
                    icon = MapsKt__MapsKt.emptyMap();
                }
                Map<String, FileV2> map = icon;
                String address = receivedRepo.getAddress();
                IndexFormatVersion formatVersion = receivedRepo.getFormatVersion();
                String certificate = receivedRepo.getCertificate();
                if (certificate != null) {
                    final NewRepository newRepository = new NewRepository(name, map, address, formatVersion, certificate, receivedRepo.getUsername(), receivedRepo.getPassword());
                    repository = (Repository) this.db.runInTransaction(new Callable() { // from class: org.fdroid.repo.RepoAdder$$ExternalSyntheticLambda0
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            Repository addFetchedRepository$lambda$2;
                            addFetchedRepository$lambda$2 = RepoAdder.addFetchedRepository$lambda$2(RepoAdder.this, newRepository, fetchResult, fetching);
                            return addFetchedRepository$lambda$2;
                        }
                    });
                } else {
                    throw new IllegalStateException("Repo had no certificate".toString());
                }
            } else if (fetchResult instanceof FetchResult.IsNewMirror) {
                final long existingRepoId$database_release = ((FetchResult.IsNewMirror) fetchResult).getExistingRepoId$database_release();
                repository = (Repository) this.db.runInTransaction(new Callable() { // from class: org.fdroid.repo.RepoAdder$$ExternalSyntheticLambda1
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        Repository addFetchedRepository$lambda$4;
                        addFetchedRepository$lambda$4 = RepoAdder.addFetchedRepository$lambda$4(RepoAdder.this, existingRepoId$database_release, fetching);
                        return addFetchedRepository$lambda$4;
                    }
                });
            } else {
                throw new NoWhenBranchMatchedException();
            }
            this.addRepoState.setValue(new Added(repository));
            return repository;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Repository addFetchedRepository$lambda$2(RepoAdder this$0, NewRepository newRepo, FetchResult fetchResult, Fetching state) {
        List<String> listOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(newRepo, "$newRepo");
        Intrinsics.checkNotNullParameter(fetchResult, "$fetchResult");
        Intrinsics.checkNotNullParameter(state, "$state");
        long insert = this$0.repositoryDao.insert(newRepo);
        if (fetchResult instanceof FetchResult.IsNewRepoAndNewMirror) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(state.getFetchUrl());
            this$0.repositoryDao.updateUserMirrors(insert, listOf);
        }
        Repository repository = this$0.repositoryDao.getRepository(insert);
        if (repository != null) {
            return repository;
        }
        throw new IllegalStateException("New repository not found in DB".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Repository addFetchedRepository$lambda$4(RepoAdder this$0, long j, Fetching state) {
        List<String> mutableList;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(state, "$state");
        Repository repository = this$0.repositoryDao.getRepository(j);
        if (repository == null) {
            throw new IllegalStateException(("No repo with " + j).toString());
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) repository.getUserMirrors());
        mutableList.add(state.getFetchUrl());
        this$0.repositoryDao.updateUserMirrors(j, mutableList);
        return repository;
    }

    public final void abortAddingRepo$database_release() {
        this.addRepoState.setValue(None.INSTANCE);
        Job job = this.fetchJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, null, 1, null);
        }
    }

    public static /* synthetic */ Object addArchiveRepo$database_release$default(RepoAdder repoAdder, Repository repository, Proxy proxy, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            proxy = null;
        }
        return repoAdder.addArchiveRepo$database_release(repository, proxy, continuation);
    }

    public final Object addArchiveRepo$database_release(Repository repository, Proxy proxy, Continuation continuation) {
        return BuildersKt.withContext(this.coroutineContext, new RepoAdder$addArchiveRepo$2(repository, this, proxy, null), continuation);
    }

    private final boolean hasDisallowInstallUnknownSources(Context context) {
        UserManager userManager = (UserManager) ContextCompat.getSystemService(context, UserManager.class);
        if (userManager != null) {
            if (Build.VERSION.SDK_INT < 29) {
                return userManager.hasUserRestriction("no_install_unknown_sources");
            }
            return userManager.hasUserRestriction("no_install_unknown_sources") || userManager.hasUserRestriction("no_install_unknown_sources_globally");
        }
        throw new IllegalStateException("No UserManager available.".toString());
    }

    private final Repository getTempRepo(Uri uri, IndexFormatVersion indexFormatVersion, String str, String str2) {
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "toString(...)");
        return new Repository(0L, uri2, -1L, indexFormatVersion, "This is fake and will be replaced by real cert before saving in DB.", 0L, 0, -1L, str, str2);
    }
}
