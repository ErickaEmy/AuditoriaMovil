package kotlinx.coroutines.selects;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
/* loaded from: classes.dex */
public final class OnTimeoutKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <R> void onTimeout(SelectBuilder<? super R> selectBuilder, long j2, Function1<? super Continuation<? super R>, ? extends Object> function1) {
        selectBuilder.invoke(new OnTimeout(j2).getSelectClause(), (Function1<? super Continuation<? super Object>, ? extends Object>) function1);
    }
}
