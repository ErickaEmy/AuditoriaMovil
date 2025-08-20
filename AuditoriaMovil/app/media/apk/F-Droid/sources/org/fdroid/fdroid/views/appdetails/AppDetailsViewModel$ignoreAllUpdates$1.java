package org.fdroid.fdroid.views.appdetails;

import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.fdroid.database.AppPrefs;
import org.fdroid.database.FDroidDatabase;
import org.fdroid.fdroid.AppUpdateStatusManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppDetailsViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "org.fdroid.fdroid.views.appdetails.AppDetailsViewModel$ignoreAllUpdates$1", f = "AppDetailsViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class AppDetailsViewModel$ignoreAllUpdates$1 extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ AppDetailsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppDetailsViewModel$ignoreAllUpdates$1(AppDetailsViewModel appDetailsViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = appDetailsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AppDetailsViewModel$ignoreAllUpdates$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AppDetailsViewModel$ignoreAllUpdates$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        LiveData liveData;
        AppPrefs appPrefs;
        FDroidDatabase fDroidDatabase;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            liveData = this.this$0.appPrefsLiveData;
            if (liveData != null && (appPrefs = (AppPrefs) liveData.getValue()) != null) {
                fDroidDatabase = this.this$0.db;
                fDroidDatabase.getAppPrefsDao().update(appPrefs.toggleIgnoreAllUpdates());
                AppUpdateStatusManager.getInstance(this.this$0.getApplication()).checkForUpdates();
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
