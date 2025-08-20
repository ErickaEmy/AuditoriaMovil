package org.fdroid.index;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.fdroid.database.AppPrefs;
import org.fdroid.database.AppPrefsDaoInt;
import org.fdroid.database.FDroidDatabase;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RepoManager.kt */
/* loaded from: classes2.dex */
public final class RepoManager$setPreferredRepoId$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ String $packageName;
    final /* synthetic */ long $repoId;
    int label;
    final /* synthetic */ RepoManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RepoManager$setPreferredRepoId$1(RepoManager repoManager, String str, long j, Continuation continuation) {
        super(2, continuation);
        this.this$0 = repoManager;
        this.$packageName = str;
        this.$repoId = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new RepoManager$setPreferredRepoId$1(this.this$0, this.$packageName, this.$repoId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((RepoManager$setPreferredRepoId$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            FDroidDatabase fDroidDatabase = this.this$0.db;
            final RepoManager repoManager = this.this$0;
            final String str = this.$packageName;
            final long j = this.$repoId;
            fDroidDatabase.runInTransaction(new Runnable() { // from class: org.fdroid.index.RepoManager$setPreferredRepoId$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    RepoManager$setPreferredRepoId$1.invokeSuspend$lambda$0(RepoManager.this, str, j);
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(RepoManager repoManager, String str, long j) {
        AppPrefsDaoInt appPrefsDaoInt;
        AppPrefsDaoInt appPrefsDaoInt2;
        appPrefsDaoInt = repoManager.appPrefsDao;
        AppPrefs appPrefsOrNull = appPrefsDaoInt.getAppPrefsOrNull(str);
        if (appPrefsOrNull == null) {
            appPrefsOrNull = new AppPrefs(str, 0L, null, null, 14, null);
        }
        AppPrefs appPrefs = appPrefsOrNull;
        appPrefsDaoInt2 = repoManager.appPrefsDao;
        appPrefsDaoInt2.update(AppPrefs.copy$default(appPrefs, null, 0L, Long.valueOf(j), null, 11, null));
    }
}
