package org.fdroid.fdroid.views.repos;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import org.fdroid.database.Repository;
/* compiled from: RepoDetailsViewModel.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"Lorg/fdroid/fdroid/views/repos/RepoDetailsState;", "s", "", "Lorg/fdroid/database/Repository;", "reposState", "<anonymous>"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "org.fdroid.fdroid.views.repos.RepoDetailsViewModel$repoLiveData$1", f = "RepoDetailsViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class RepoDetailsViewModel$repoLiveData$1 extends SuspendLambda implements Function3 {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RepoDetailsViewModel$repoLiveData$1(Continuation continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(RepoDetailsState repoDetailsState, List<Repository> list, Continuation continuation) {
        RepoDetailsViewModel$repoLiveData$1 repoDetailsViewModel$repoLiveData$1 = new RepoDetailsViewModel$repoLiveData$1(continuation);
        repoDetailsViewModel$repoLiveData$1.L$0 = repoDetailsState;
        repoDetailsViewModel$repoLiveData$1.L$1 = list;
        return repoDetailsViewModel$repoLiveData$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            RepoDetailsState repoDetailsState = (RepoDetailsState) this.L$0;
            List list = (List) this.L$1;
            Object obj2 = null;
            if ((repoDetailsState != null ? repoDetailsState.getRepo() : null) == null) {
                return null;
            }
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((Repository) next).getRepoId() == repoDetailsState.getRepo().getRepoId()) {
                    obj2 = next;
                    break;
                }
            }
            return (Repository) obj2;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
