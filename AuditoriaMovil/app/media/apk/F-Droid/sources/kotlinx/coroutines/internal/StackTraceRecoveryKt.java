package kotlinx.coroutines.internal;

import _COROUTINE.ArtificialStackFrames;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
/* compiled from: StackTraceRecovery.kt */
/* loaded from: classes2.dex */
public abstract class StackTraceRecoveryKt {
    private static final StackTraceElement ARTIFICIAL_FRAME = new ArtificialStackFrames().coroutineBoundary();
    private static final String baseContinuationImplClassName;
    private static final String stackTraceRecoveryClassName;

    public static final Throwable recoverStackTrace(Throwable th) {
        return th;
    }

    static {
        Object m2081constructorimpl;
        Object m2081constructorimpl2;
        try {
            Result.Companion companion = Result.Companion;
            m2081constructorimpl = Result.m2081constructorimpl(BaseContinuationImpl.class.getCanonicalName());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m2081constructorimpl = Result.m2081constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m2084exceptionOrNullimpl(m2081constructorimpl) != null) {
            m2081constructorimpl = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        baseContinuationImplClassName = (String) m2081constructorimpl;
        try {
            m2081constructorimpl2 = Result.m2081constructorimpl(StackTraceRecoveryKt.class.getCanonicalName());
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.Companion;
            m2081constructorimpl2 = Result.m2081constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m2084exceptionOrNullimpl(m2081constructorimpl2) != null) {
            m2081constructorimpl2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        stackTraceRecoveryClassName = (String) m2081constructorimpl2;
    }
}
