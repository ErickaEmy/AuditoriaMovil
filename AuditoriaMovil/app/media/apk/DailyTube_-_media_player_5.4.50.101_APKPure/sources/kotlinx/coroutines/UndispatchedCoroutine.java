package kotlinx.coroutines;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;
/* loaded from: classes.dex */
public final class UndispatchedCoroutine<T> extends ScopeCoroutine<T> {
    private volatile boolean threadLocalIsSet;
    private final ThreadLocal<Pair<CoroutineContext, Object>> threadStateToRecover;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public UndispatchedCoroutine(kotlin.coroutines.CoroutineContext r3, kotlin.coroutines.Continuation<? super T> r4) {
        /*
            r2 = this;
            kotlinx.coroutines.UndispatchedMarker r0 = kotlinx.coroutines.UndispatchedMarker.INSTANCE
            kotlin.coroutines.CoroutineContext$Element r1 = r3.get(r0)
            if (r1 != 0) goto Ld
            kotlin.coroutines.CoroutineContext r0 = r3.plus(r0)
            goto Le
        Ld:
            r0 = r3
        Le:
            r2.<init>(r0, r4)
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            r2.threadStateToRecover = r0
            kotlin.coroutines.CoroutineContext r4 = r4.getContext()
            kotlin.coroutines.ContinuationInterceptor$Key r0 = kotlin.coroutines.ContinuationInterceptor.Key
            kotlin.coroutines.CoroutineContext$Element r4 = r4.get(r0)
            boolean r4 = r4 instanceof kotlinx.coroutines.CoroutineDispatcher
            if (r4 != 0) goto L31
            r4 = 0
            java.lang.Object r4 = kotlinx.coroutines.internal.ThreadContextKt.updateThreadContext(r3, r4)
            kotlinx.coroutines.internal.ThreadContextKt.restoreThreadContext(r3, r4)
            r2.saveThreadContext(r3, r4)
        L31:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.UndispatchedCoroutine.<init>(kotlin.coroutines.CoroutineContext, kotlin.coroutines.Continuation):void");
    }

    @Override // kotlinx.coroutines.internal.ScopeCoroutine, kotlinx.coroutines.AbstractCoroutine
    public void afterResume(Object obj) {
        if (this.threadLocalIsSet) {
            Pair<CoroutineContext, Object> pair = this.threadStateToRecover.get();
            if (pair != null) {
                ThreadContextKt.restoreThreadContext(pair.component1(), pair.component2());
            }
            this.threadStateToRecover.remove();
        }
        Object recoverResult = CompletionStateKt.recoverResult(obj, this.uCont);
        Continuation<T> continuation = this.uCont;
        CoroutineContext context = continuation.getContext();
        UndispatchedCoroutine<?> undispatchedCoroutine = null;
        Object updateThreadContext = ThreadContextKt.updateThreadContext(context, null);
        if (updateThreadContext != ThreadContextKt.NO_THREAD_ELEMENTS) {
            undispatchedCoroutine = CoroutineContextKt.updateUndispatchedCompletion(continuation, context, updateThreadContext);
        }
        try {
            this.uCont.resumeWith(recoverResult);
            Unit unit = Unit.INSTANCE;
        } finally {
            if (undispatchedCoroutine == null || undispatchedCoroutine.clearThreadContext()) {
                ThreadContextKt.restoreThreadContext(context, updateThreadContext);
            }
        }
    }

    public final boolean clearThreadContext() {
        boolean z2;
        if (this.threadLocalIsSet && this.threadStateToRecover.get() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.threadStateToRecover.remove();
        return !z2;
    }

    public final void saveThreadContext(CoroutineContext coroutineContext, Object obj) {
        this.threadLocalIsSet = true;
        this.threadStateToRecover.set(TuplesKt.to(coroutineContext, obj));
    }
}
