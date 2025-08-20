package kotlinx.coroutines.selects;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
/* loaded from: classes.dex */
public interface SelectBuilder<R> {
    void invoke(SelectClause0 selectClause0, Function1<? super Continuation<? super R>, ? extends Object> function1);

    <Q> void invoke(SelectClause1<? extends Q> selectClause1, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2);
}
