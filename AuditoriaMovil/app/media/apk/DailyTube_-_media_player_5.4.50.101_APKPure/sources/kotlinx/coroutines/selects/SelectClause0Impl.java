package kotlinx.coroutines.selects;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes.dex */
public final class SelectClause0Impl implements SelectClause0 {
    private final Object clauseObject;
    private final Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> onCancellationConstructor;
    private final Function3<Object, Object, Object, Object> processResFunc;
    private final Function3<Object, SelectInstance<?>, Object, Unit> regFunc;

    /* JADX WARN: Multi-variable type inference failed */
    public SelectClause0Impl(Object obj, Function3<Object, ? super SelectInstance<?>, Object, Unit> function3, Function3<? super SelectInstance<?>, Object, Object, ? extends Function1<? super Throwable, Unit>> function32) {
        Function3<Object, Object, Object, Object> function33;
        this.clauseObject = obj;
        this.regFunc = function3;
        this.onCancellationConstructor = function32;
        function33 = SelectKt.DUMMY_PROCESS_RESULT_FUNCTION;
        this.processResFunc = function33;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public Object getClauseObject() {
        return this.clauseObject;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> getOnCancellationConstructor() {
        return this.onCancellationConstructor;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public Function3<Object, Object, Object, Object> getProcessResFunc() {
        return this.processResFunc;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public Function3<Object, SelectInstance<?>, Object, Unit> getRegFunc() {
        return this.regFunc;
    }

    public /* synthetic */ SelectClause0Impl(Object obj, Function3 function3, Function3 function32, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, function3, (i & 4) != 0 ? null : function32);
    }
}
