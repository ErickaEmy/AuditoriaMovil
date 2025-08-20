package kotlinx.coroutines.selects;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
/* loaded from: classes.dex */
public interface SelectClause {
    Object getClauseObject();

    Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> getOnCancellationConstructor();

    Function3<Object, Object, Object, Object> getProcessResFunc();

    Function3<Object, SelectInstance<?>, Object, Unit> getRegFunc();
}
