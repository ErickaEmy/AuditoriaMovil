package org.fdroid.repo;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RepoV2Fetcher.kt */
/* loaded from: classes2.dex */
public final class RepoV2Fetcher$fetchRepo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RepoV2Fetcher this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RepoV2Fetcher$fetchRepo$1(RepoV2Fetcher repoV2Fetcher, Continuation continuation) {
        super(continuation);
        this.this$0 = repoV2Fetcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetchRepo(null, null, null, null, this);
    }
}
