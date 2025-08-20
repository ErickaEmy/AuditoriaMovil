package kotlin.reflect.full;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: exceptions.kt */
/* loaded from: classes.dex */
public final class IllegalCallableAccessException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IllegalCallableAccessException(IllegalAccessException cause) {
        super(cause);
        Intrinsics.checkNotNullParameter(cause, "cause");
    }
}
