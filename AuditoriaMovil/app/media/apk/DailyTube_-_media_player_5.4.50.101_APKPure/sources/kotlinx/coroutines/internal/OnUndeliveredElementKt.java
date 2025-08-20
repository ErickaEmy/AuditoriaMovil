package kotlinx.coroutines.internal;

import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
/* loaded from: classes.dex */
public final class OnUndeliveredElementKt {
    public static final <E> Function1<Throwable, Unit> bindCancellationFun(final Function1<? super E, Unit> function1, final E e2, final CoroutineContext coroutineContext) {
        return new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.internal.OnUndeliveredElementKt$bindCancellationFun$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                OnUndeliveredElementKt.callUndeliveredElement(function1, e2, coroutineContext);
            }
        };
    }

    public static final <E> void callUndeliveredElement(Function1<? super E, Unit> function1, E e2, CoroutineContext coroutineContext) {
        UndeliveredElementException callUndeliveredElementCatchingException = callUndeliveredElementCatchingException(function1, e2, null);
        if (callUndeliveredElementCatchingException != null) {
            CoroutineExceptionHandlerKt.handleCoroutineException(coroutineContext, callUndeliveredElementCatchingException);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> UndeliveredElementException callUndeliveredElementCatchingException(Function1<? super E, Unit> function1, E e2, UndeliveredElementException undeliveredElementException) {
        try {
            function1.invoke(e2);
        } catch (Throwable th) {
            if (undeliveredElementException != null && undeliveredElementException.getCause() != th) {
                ExceptionsKt.addSuppressed(undeliveredElementException, th);
            } else {
                return new UndeliveredElementException("Exception in undelivered element handler for " + e2, th);
            }
        }
        return undeliveredElementException;
    }

    public static /* synthetic */ UndeliveredElementException callUndeliveredElementCatchingException$default(Function1 function1, Object obj, UndeliveredElementException undeliveredElementException, int i, Object obj2) {
        if ((i & 2) != 0) {
            undeliveredElementException = null;
        }
        return callUndeliveredElementCatchingException(function1, obj, undeliveredElementException);
    }
}
