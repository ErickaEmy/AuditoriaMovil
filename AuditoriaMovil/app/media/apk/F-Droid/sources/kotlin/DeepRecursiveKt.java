package kotlin;

import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DeepRecursive.kt */
/* loaded from: classes.dex */
public abstract class DeepRecursiveKt {
    private static final Object UNDEFINED_RESULT;

    public static final Object invoke(DeepRecursiveFunction deepRecursiveFunction, Object obj) {
        Intrinsics.checkNotNullParameter(deepRecursiveFunction, "<this>");
        return new DeepRecursiveScopeImpl(deepRecursiveFunction.getBlock$kotlin_stdlib(), obj).runCallLoop();
    }

    static {
        Object coroutine_suspended;
        Result.Companion companion = Result.Companion;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        UNDEFINED_RESULT = Result.m2081constructorimpl(coroutine_suspended);
    }
}
