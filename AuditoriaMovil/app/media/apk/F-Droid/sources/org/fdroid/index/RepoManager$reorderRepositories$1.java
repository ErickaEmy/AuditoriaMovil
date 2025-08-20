package org.fdroid.index;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.fdroid.database.Repository;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RepoManager.kt */
/* loaded from: classes2.dex */
public final class RepoManager$reorderRepositories$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ Repository $repoTarget;
    final /* synthetic */ Repository $repoToReorder;
    int label;
    final /* synthetic */ RepoManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RepoManager$reorderRepositories$1(RepoManager repoManager, Repository repository, Repository repository2, Continuation continuation) {
        super(2, continuation);
        this.this$0 = repoManager;
        this.$repoToReorder = repository;
        this.$repoTarget = repository2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new RepoManager$reorderRepositories$1(this.this$0, this.$repoToReorder, this.$repoTarget, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((RepoManager$reorderRepositories$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.repositoryDao.reorderRepositories(this.$repoToReorder, this.$repoTarget);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
