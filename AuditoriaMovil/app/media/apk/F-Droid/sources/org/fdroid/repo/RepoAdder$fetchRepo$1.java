package org.fdroid.repo;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RepoAdder.kt */
/* loaded from: classes2.dex */
public final class RepoAdder$fetchRepo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RepoAdder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RepoAdder$fetchRepo$1(RepoAdder repoAdder, Continuation continuation) {
        super(continuation);
        this.this$0 = repoAdder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object fetchRepo;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fetchRepo = this.this$0.fetchRepo(null, null, null, null, null, null, this);
        return fetchRepo;
    }
}
