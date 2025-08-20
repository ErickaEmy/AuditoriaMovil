package y5;

import androidx.lifecycle.LiveData;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class v {
    public static final <T> LiveData<T> y(CoroutineContext context, long j2, Function2<? super i4<T>, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        return new gv(context, j2, block);
    }
}
