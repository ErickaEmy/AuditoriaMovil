package org.fdroid.index;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RepoManager.kt */
/* loaded from: classes2.dex */
public final class RepoManager$setArchiveRepoEnabled$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RepoManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RepoManager$setArchiveRepoEnabled$1(RepoManager repoManager, Continuation continuation) {
        super(continuation);
        this.this$0 = repoManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.setArchiveRepoEnabled(null, false, null, this);
    }
}
