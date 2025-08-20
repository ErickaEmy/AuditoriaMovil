package org.fdroid.fdroid.views.appdetails;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.fdroid.database.AppDao;
import org.fdroid.database.FDroidDatabase;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppDetailsViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "org.fdroid.fdroid.views.appdetails.AppDetailsViewModel$selectRepo$1", f = "AppDetailsViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class AppDetailsViewModel$selectRepo$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ long $repoId;
    int label;
    final /* synthetic */ AppDetailsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppDetailsViewModel$selectRepo$1(AppDetailsViewModel appDetailsViewModel, long j, Continuation continuation) {
        super(2, continuation);
        this.this$0 = appDetailsViewModel;
        this.$repoId = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AppDetailsViewModel$selectRepo$1(this.this$0, this.$repoId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AppDetailsViewModel$selectRepo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableLiveData mutableLiveData;
        FDroidDatabase fDroidDatabase;
        String str;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            mutableLiveData = this.this$0._app;
            fDroidDatabase = this.this$0.db;
            AppDao appDao = fDroidDatabase.getAppDao();
            long j = this.$repoId;
            str = this.this$0.packageName;
            if (str == null) {
                throw new IllegalStateException("".toString());
            }
            mutableLiveData.postValue(appDao.getApp(j, str));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
