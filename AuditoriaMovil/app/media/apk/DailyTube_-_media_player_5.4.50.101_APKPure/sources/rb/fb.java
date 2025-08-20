package rb;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
/* loaded from: classes.dex */
public final class fb {
    public static final CoroutineDispatcher n3(i4 i4Var) {
        Intrinsics.checkNotNullParameter(i4Var, "<this>");
        Map<String, Object> backingFieldMap = i4Var.getBackingFieldMap();
        Object obj = backingFieldMap.get("TransactionDispatcher");
        if (obj == null) {
            obj = ExecutorsKt.from(i4Var.getTransactionExecutor());
            backingFieldMap.put("TransactionDispatcher", obj);
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
        return (CoroutineDispatcher) obj;
    }

    public static final CoroutineDispatcher y(i4 i4Var) {
        Intrinsics.checkNotNullParameter(i4Var, "<this>");
        Map<String, Object> backingFieldMap = i4Var.getBackingFieldMap();
        Object obj = backingFieldMap.get("QueryDispatcher");
        if (obj == null) {
            obj = ExecutorsKt.from(i4Var.getQueryExecutor());
            backingFieldMap.put("QueryDispatcher", obj);
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
        return (CoroutineDispatcher) obj;
    }
}
