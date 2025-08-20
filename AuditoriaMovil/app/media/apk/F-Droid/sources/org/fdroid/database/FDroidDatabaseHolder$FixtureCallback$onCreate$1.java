package org.fdroid.database;

import android.util.Log;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import org.fdroid.database.FDroidDatabaseHolder;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FDroidDatabaseHolder.kt */
/* loaded from: classes2.dex */
public final class FDroidDatabaseHolder$FixtureCallback$onCreate$1 extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ FDroidDatabaseHolder.FixtureCallback this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FDroidDatabaseHolder$FixtureCallback$onCreate$1(FDroidDatabaseHolder.FixtureCallback fixtureCallback, Continuation continuation) {
        super(2, continuation);
        this.this$0 = fixtureCallback;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new FDroidDatabaseHolder$FixtureCallback$onCreate$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((FDroidDatabaseHolder$FixtureCallback$onCreate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        FDroidDatabaseInt fDroidDatabaseInt;
        FDroidFixture fDroidFixture;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            obj2 = FDroidDatabaseHolder.lock;
            synchronized (obj2) {
                fDroidDatabaseInt = FDroidDatabaseHolder.INSTANCE$1;
                if (fDroidDatabaseInt == null) {
                    throw new IllegalStateException("DB not yet initialized".toString());
                }
                ref$ObjectRef.element = fDroidDatabaseInt;
                Unit unit = Unit.INSTANCE;
            }
            fDroidFixture = this.this$0.fixture;
            fDroidFixture.prePopulateDb((FDroidDatabase) ref$ObjectRef.element);
            Log.d(FDroidDatabaseHolder.INSTANCE.getTAG$database_release(), "Loaded fixtures");
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
