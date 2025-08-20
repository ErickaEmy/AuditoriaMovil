package org.fdroid.fdroid.views.repos;

import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import org.bouncycastle.asn1.eac.EACTags;
import org.fdroid.fdroid.views.apps.AppListActivity;
import org.fdroid.fdroid.work.RepoUpdateWorker;
import org.fdroid.index.RepoManager;
import org.fdroid.repo.AddRepoState;
import org.fdroid.repo.Added;
/* compiled from: AddRepoActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "org.fdroid.fdroid.views.repos.AddRepoActivity$onCreate$1", f = "AddRepoActivity.kt", l = {EACTags.INTERCHANGE_PROFILE}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class AddRepoActivity$onCreate$1 extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ AddRepoActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddRepoActivity$onCreate$1(AddRepoActivity addRepoActivity, Continuation continuation) {
        super(2, continuation);
        this.this$0 = addRepoActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AddRepoActivity$onCreate$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AddRepoActivity$onCreate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AddRepoActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "org.fdroid.fdroid.views.repos.AddRepoActivity$onCreate$1$1", f = "AddRepoActivity.kt", l = {EACTags.CURRENCY_CODE}, m = "invokeSuspend")
    /* renamed from: org.fdroid.fdroid.views.repos.AddRepoActivity$onCreate$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        int label;
        final /* synthetic */ AddRepoActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AddRepoActivity addRepoActivity, Continuation continuation) {
            super(2, continuation);
            this.this$0 = addRepoActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            RepoManager repoManager;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                repoManager = this.this$0.getRepoManager();
                StateFlow addRepoState = repoManager.getAddRepoState();
                final AddRepoActivity addRepoActivity = this.this$0;
                FlowCollector flowCollector = new FlowCollector() { // from class: org.fdroid.fdroid.views.repos.AddRepoActivity.onCreate.1.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(AddRepoState addRepoState2, Continuation continuation) {
                        if (addRepoState2 instanceof Added) {
                            RepoUpdateWorker.Companion companion = RepoUpdateWorker.Companion;
                            Context applicationContext = AddRepoActivity.this.getApplicationContext();
                            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                            Added added = (Added) addRepoState2;
                            companion.updateNow(applicationContext, added.getRepo().getRepoId());
                            Intent intent = new Intent(AddRepoActivity.this, AppListActivity.class);
                            intent.putExtra(AppListActivity.EXTRA_REPO_ID, added.getRepo().getRepoId());
                            AddRepoActivity.this.startActivity(intent);
                            AddRepoActivity.this.finish();
                        }
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (addRepoState.collect(flowCollector, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AddRepoActivity addRepoActivity = this.this$0;
            Lifecycle.State state = Lifecycle.State.STARTED;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(addRepoActivity, null);
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(addRepoActivity, state, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
