package org.fdroid.repo;

import android.net.Uri;
import java.net.Proxy;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.Regex;
import kotlinx.coroutines.CoroutineScope;
import org.fdroid.database.Repository;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RepoAdder.kt */
/* loaded from: classes2.dex */
public final class RepoAdder$addArchiveRepo$2 extends SuspendLambda implements Function2 {
    final /* synthetic */ Proxy $proxy;
    final /* synthetic */ Repository $repo;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RepoAdder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RepoAdder$addArchiveRepo$2(Repository repository, RepoAdder repoAdder, Proxy proxy, Continuation continuation) {
        super(2, continuation);
        this.$repo = repository;
        this.this$0 = repoAdder;
        this.$proxy = proxy;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        RepoAdder$addArchiveRepo$2 repoAdder$addArchiveRepo$2 = new RepoAdder$addArchiveRepo$2(this.$repo, this.this$0, this.$proxy, continuation);
        repoAdder$addArchiveRepo$2.L$0 = obj;
        return repoAdder$addArchiveRepo$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((RepoAdder$addArchiveRepo$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Object fetchRepo;
        Ref$ObjectRef ref$ObjectRef;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            if (this.$repo.isArchiveRepo()) {
                String address = this.$repo.getAddress();
                throw new IllegalStateException(("Repo " + address + " is already an archive repo.").toString());
            }
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            String replace = new Regex("repo/?$").replace(this.$repo.getAddress(), "archive");
            RepoAdder$addArchiveRepo$2$receiver$1 repoAdder$addArchiveRepo$2$receiver$1 = new RepoAdder$addArchiveRepo$2$receiver$1(this.this$0, coroutineScope, this.$repo, ref$ObjectRef2);
            Uri parse = Uri.parse(replace);
            RepoAdder repoAdder = this.this$0;
            Intrinsics.checkNotNull(parse);
            String fingerprint = this.$repo.getFingerprint();
            Proxy proxy = this.$proxy;
            String username = this.$repo.getUsername();
            String password = this.$repo.getPassword();
            this.L$0 = ref$ObjectRef2;
            this.label = 1;
            fetchRepo = repoAdder.fetchRepo(parse, fingerprint, proxy, username, password, repoAdder$addArchiveRepo$2$receiver$1, this);
            if (fetchRepo == coroutine_suspended) {
                return coroutine_suspended;
            }
            ref$ObjectRef = ref$ObjectRef2;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ref$ObjectRef = (Ref$ObjectRef) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return ref$ObjectRef.element;
    }
}
