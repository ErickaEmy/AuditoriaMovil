package org.fdroid.fdroid.views.repos;

import android.util.Log;
import android.widget.Toast;
import info.guardianproject.netcipher.NetCipher;
import java.net.Proxy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.bouncycastle.asn1.eac.EACTags;
import org.fdroid.database.Repository;
import org.fdroid.fdroid.R;
import org.fdroid.fdroid.work.RepoUpdateWorker;
import org.fdroid.index.RepoManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RepoDetailsViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "org.fdroid.fdroid.views.repos.RepoDetailsViewModel$setArchiveRepoEnabled$1", f = "RepoDetailsViewModel.kt", l = {60, 62, EACTags.APPLICATION_IMAGE}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class RepoDetailsViewModel$setArchiveRepoEnabled$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Repository $repo;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RepoDetailsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RepoDetailsViewModel$setArchiveRepoEnabled$1(RepoDetailsViewModel repoDetailsViewModel, Repository repository, boolean z, Continuation continuation) {
        super(2, continuation);
        this.this$0 = repoDetailsViewModel;
        this.$repo = repository;
        this.$enabled = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        RepoDetailsViewModel$setArchiveRepoEnabled$1 repoDetailsViewModel$setArchiveRepoEnabled$1 = new RepoDetailsViewModel$setArchiveRepoEnabled$1(this.this$0, this.$repo, this.$enabled, continuation);
        repoDetailsViewModel$setArchiveRepoEnabled$1.L$0 = obj;
        return repoDetailsViewModel$setArchiveRepoEnabled$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((RepoDetailsViewModel$setArchiveRepoEnabled$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [int, java.lang.Object] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MutableStateFlow mutableStateFlow;
        MutableStateFlow mutableStateFlow2;
        RepoDetailsState repoDetailsState;
        boolean isArchiveEnabled;
        CoroutineScope coroutineScope;
        RepoManager repoManager;
        MutableStateFlow mutableStateFlow3;
        MutableStateFlow mutableStateFlow4;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r1 = this.label;
        try {
        } catch (Exception e) {
            Log.e(r1.getClass().getSimpleName(), "Error toggling archive repo: ", e);
            mutableStateFlow = this.this$0._state;
            mutableStateFlow2 = this.this$0._state;
            RepoDetailsState repoDetailsState2 = (RepoDetailsState) mutableStateFlow2.getValue();
            if (repoDetailsState2 != null) {
                isArchiveEnabled = this.this$0.isArchiveEnabled(this.$repo);
                repoDetailsState = RepoDetailsState.copy$default(repoDetailsState2, null, Boxing.boxBoolean(isArchiveEnabled), 1, null);
            } else {
                repoDetailsState = null;
            }
            mutableStateFlow.setValue(repoDetailsState);
            MainCoroutineDispatcher main = Dispatchers.getMain();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, null);
            this.L$0 = null;
            this.label = 3;
            if (BuildersKt.withContext(main, anonymousClass2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (r1 == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            repoManager = this.this$0.repoManager;
            Repository repository = this.$repo;
            boolean z = this.$enabled;
            Proxy proxy = NetCipher.getProxy();
            this.L$0 = coroutineScope;
            this.label = 1;
            obj = repoManager.setArchiveRepoEnabled(repository, z, proxy, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (r1 != 1) {
            if (r1 == 2) {
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else if (r1 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        } else {
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        Long l = (Long) obj;
        mutableStateFlow3 = this.this$0._state;
        mutableStateFlow4 = this.this$0._state;
        RepoDetailsState repoDetailsState3 = (RepoDetailsState) mutableStateFlow4.getValue();
        mutableStateFlow3.setValue(repoDetailsState3 != null ? RepoDetailsState.copy$default(repoDetailsState3, null, Boxing.boxBoolean(this.$enabled), 1, null) : null);
        if (this.$enabled && l != null) {
            MainCoroutineDispatcher main2 = Dispatchers.getMain();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, l, null);
            this.L$0 = coroutineScope;
            this.label = 2;
            if (BuildersKt.withContext(main2, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RepoDetailsViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "org.fdroid.fdroid.views.repos.RepoDetailsViewModel$setArchiveRepoEnabled$1$1", f = "RepoDetailsViewModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: org.fdroid.fdroid.views.repos.RepoDetailsViewModel$setArchiveRepoEnabled$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ Long $repoId;
        int label;
        final /* synthetic */ RepoDetailsViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(RepoDetailsViewModel repoDetailsViewModel, Long l, Continuation continuation) {
            super(2, continuation);
            this.this$0 = repoDetailsViewModel;
            this.$repoId = l;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.this$0, this.$repoId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                RepoUpdateWorker.Companion.updateNow(this.this$0.getApplication(), this.$repoId.longValue());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RepoDetailsViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "org.fdroid.fdroid.views.repos.RepoDetailsViewModel$setArchiveRepoEnabled$1$2", f = "RepoDetailsViewModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: org.fdroid.fdroid.views.repos.RepoDetailsViewModel$setArchiveRepoEnabled$1$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        int label;
        final /* synthetic */ RepoDetailsViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(RepoDetailsViewModel repoDetailsViewModel, Continuation continuation) {
            super(2, continuation);
            this.this$0 = repoDetailsViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Toast.makeText(this.this$0.getApplication(), R.string.repo_archive_failed, 0).show();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
