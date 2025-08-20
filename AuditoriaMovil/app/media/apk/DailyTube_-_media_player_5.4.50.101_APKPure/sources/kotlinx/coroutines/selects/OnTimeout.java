package kotlinx.coroutines.selects;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.DelayKt;
/* loaded from: classes.dex */
final class OnTimeout {
    private final long timeMillis;

    public OnTimeout(long j2) {
        this.timeMillis = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void register(final SelectInstance<?> selectInstance, Object obj) {
        if (this.timeMillis <= 0) {
            selectInstance.selectInRegistrationPhase(Unit.INSTANCE);
            return;
        }
        Runnable runnable = new Runnable() { // from class: kotlinx.coroutines.selects.OnTimeout$register$$inlined$Runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                SelectInstance.this.trySelect(this, Unit.INSTANCE);
            }
        };
        Intrinsics.checkNotNull(selectInstance, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        SelectImplementation selectImplementation = (SelectImplementation) selectInstance;
        CoroutineContext context = selectInstance.getContext();
        selectInstance.disposeOnCompletion(DelayKt.getDelay(context).invokeOnTimeout(this.timeMillis, runnable, context));
    }

    public final SelectClause0 getSelectClause() {
        OnTimeout$selectClause$1 onTimeout$selectClause$1 = OnTimeout$selectClause$1.INSTANCE;
        Intrinsics.checkNotNull(onTimeout$selectClause$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return new SelectClause0Impl(this, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(onTimeout$selectClause$1, 3), null, 4, null);
    }
}
