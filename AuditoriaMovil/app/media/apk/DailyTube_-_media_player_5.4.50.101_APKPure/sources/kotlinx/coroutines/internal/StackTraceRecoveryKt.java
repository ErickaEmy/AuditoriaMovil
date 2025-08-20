package kotlinx.coroutines.internal;

import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DebugKt;
import y.n3;
import y.y;
/* loaded from: classes.dex */
public final class StackTraceRecoveryKt {
    private static final StackTraceElement ARTIFICIAL_FRAME = new y().y();
    private static final String baseContinuationImplClassName;
    private static final String stackTraceRecoveryClassName;

    static {
        Object m28constructorimpl;
        Object m28constructorimpl2;
        try {
            Result.Companion companion = Result.Companion;
            m28constructorimpl = Result.m28constructorimpl(BaseContinuationImpl.class.getCanonicalName());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m28constructorimpl = Result.m28constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m30exceptionOrNullimpl(m28constructorimpl) != null) {
            m28constructorimpl = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        baseContinuationImplClassName = (String) m28constructorimpl;
        try {
            m28constructorimpl2 = Result.m28constructorimpl(StackTraceRecoveryKt.class.getCanonicalName());
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.Companion;
            m28constructorimpl2 = Result.m28constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m30exceptionOrNullimpl(m28constructorimpl2) != null) {
            m28constructorimpl2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        stackTraceRecoveryClassName = (String) m28constructorimpl2;
    }

    private static final <E extends Throwable> Pair<E, StackTraceElement[]> causeAndStacktrace(E e2) {
        Throwable cause = e2.getCause();
        if (cause != null && Intrinsics.areEqual(cause.getClass(), e2.getClass())) {
            StackTraceElement[] stackTrace = e2.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (isArtificial(stackTraceElement)) {
                    return TuplesKt.to(cause, stackTrace);
                }
            }
            return TuplesKt.to(e2, new StackTraceElement[0]);
        }
        return TuplesKt.to(e2, new StackTraceElement[0]);
    }

    private static final <E extends Throwable> E createFinalException(E e2, E e3, ArrayDeque<StackTraceElement> arrayDeque) {
        arrayDeque.addFirst(ARTIFICIAL_FRAME);
        StackTraceElement[] stackTrace = e2.getStackTrace();
        int firstFrameIndex = firstFrameIndex(stackTrace, baseContinuationImplClassName);
        int i = 0;
        if (firstFrameIndex == -1) {
            e3.setStackTrace((StackTraceElement[]) arrayDeque.toArray(new StackTraceElement[0]));
            return e3;
        }
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[arrayDeque.size() + firstFrameIndex];
        for (int i5 = 0; i5 < firstFrameIndex; i5++) {
            stackTraceElementArr[i5] = stackTrace[i5];
        }
        Iterator<StackTraceElement> it = arrayDeque.iterator();
        while (it.hasNext()) {
            int i6 = i + 1;
            stackTraceElementArr[i + firstFrameIndex] = it.next();
            i = i6;
        }
        e3.setStackTrace(stackTraceElementArr);
        return e3;
    }

    private static final ArrayDeque<StackTraceElement> createStackTrace(CoroutineStackFrame coroutineStackFrame) {
        ArrayDeque<StackTraceElement> arrayDeque = new ArrayDeque<>();
        StackTraceElement stackTraceElement = coroutineStackFrame.getStackTraceElement();
        if (stackTraceElement != null) {
            arrayDeque.add(stackTraceElement);
        }
        while (true) {
            coroutineStackFrame = coroutineStackFrame.getCallerFrame();
            if (coroutineStackFrame == null) {
                return arrayDeque;
            }
            StackTraceElement stackTraceElement2 = coroutineStackFrame.getStackTraceElement();
            if (stackTraceElement2 != null) {
                arrayDeque.add(stackTraceElement2);
            }
        }
    }

    private static final boolean elementWiseEquals(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        if (stackTraceElement.getLineNumber() == stackTraceElement2.getLineNumber() && Intrinsics.areEqual(stackTraceElement.getMethodName(), stackTraceElement2.getMethodName()) && Intrinsics.areEqual(stackTraceElement.getFileName(), stackTraceElement2.getFileName()) && Intrinsics.areEqual(stackTraceElement.getClassName(), stackTraceElement2.getClassName())) {
            return true;
        }
        return false;
    }

    private static final int firstFrameIndex(StackTraceElement[] stackTraceElementArr, String str) {
        int length = stackTraceElementArr.length;
        for (int i = 0; i < length; i++) {
            if (Intrinsics.areEqual(str, stackTraceElementArr[i].getClassName())) {
                return i;
            }
        }
        return -1;
    }

    public static final boolean isArtificial(StackTraceElement stackTraceElement) {
        return StringsKt.startsWith$default(stackTraceElement.getClassName(), n3.zn(), false, 2, (Object) null);
    }

    private static final void mergeRecoveredTraces(StackTraceElement[] stackTraceElementArr, ArrayDeque<StackTraceElement> arrayDeque) {
        int length = stackTraceElementArr.length;
        int i = 0;
        while (true) {
            if (i < length) {
                if (isArtificial(stackTraceElementArr[i])) {
                    break;
                }
                i++;
            } else {
                i = -1;
                break;
            }
        }
        int i5 = i + 1;
        int length2 = stackTraceElementArr.length - 1;
        if (i5 > length2) {
            return;
        }
        while (true) {
            if (elementWiseEquals(stackTraceElementArr[length2], arrayDeque.getLast())) {
                arrayDeque.removeLast();
            }
            arrayDeque.addFirst(stackTraceElementArr[length2]);
            if (length2 != i5) {
                length2--;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <E extends Throwable> E recoverFromStackFrame(E e2, CoroutineStackFrame coroutineStackFrame) {
        Pair causeAndStacktrace = causeAndStacktrace(e2);
        Throwable th = (Throwable) causeAndStacktrace.component1();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) causeAndStacktrace.component2();
        Throwable tryCopyException = ExceptionsConstructorKt.tryCopyException(th);
        if (tryCopyException == null) {
            return e2;
        }
        ArrayDeque<StackTraceElement> createStackTrace = createStackTrace(coroutineStackFrame);
        if (createStackTrace.isEmpty()) {
            return e2;
        }
        if (th != e2) {
            mergeRecoveredTraces(stackTraceElementArr, createStackTrace);
        }
        return (E) createFinalException(th, tryCopyException, createStackTrace);
    }

    public static final <E extends Throwable> E recoverStackTrace(E e2) {
        if (!DebugKt.getRECOVER_STACK_TRACES()) {
            return e2;
        }
        Throwable tryCopyException = ExceptionsConstructorKt.tryCopyException(e2);
        if (tryCopyException == null) {
            return e2;
        }
        return (E) sanitizeStackTrace(tryCopyException);
    }

    private static final <E extends Throwable> E sanitizeStackTrace(E e2) {
        int i;
        StackTraceElement stackTraceElement;
        StackTraceElement[] stackTrace = e2.getStackTrace();
        int length = stackTrace.length;
        int length2 = stackTrace.length - 1;
        if (length2 >= 0) {
            while (true) {
                int i5 = length2 - 1;
                if (Intrinsics.areEqual(stackTraceRecoveryClassName, stackTrace[length2].getClassName())) {
                    break;
                } else if (i5 < 0) {
                    break;
                } else {
                    length2 = i5;
                }
            }
        }
        length2 = -1;
        int i6 = length2 + 1;
        int firstFrameIndex = firstFrameIndex(stackTrace, baseContinuationImplClassName);
        if (firstFrameIndex == -1) {
            i = 0;
        } else {
            i = length - firstFrameIndex;
        }
        int i8 = (length - length2) - i;
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[i8];
        for (int i10 = 0; i10 < i8; i10++) {
            if (i10 == 0) {
                stackTraceElement = ARTIFICIAL_FRAME;
            } else {
                stackTraceElement = stackTrace[(i6 + i10) - 1];
            }
            stackTraceElementArr[i10] = stackTraceElement;
        }
        e2.setStackTrace(stackTraceElementArr);
        return e2;
    }

    public static final <E extends Throwable> E unwrapImpl(E e2) {
        E e3 = (E) e2.getCause();
        if (e3 != null && Intrinsics.areEqual(e3.getClass(), e2.getClass())) {
            for (StackTraceElement stackTraceElement : e2.getStackTrace()) {
                if (isArtificial(stackTraceElement)) {
                    return e3;
                }
            }
        }
        return e2;
    }
}
