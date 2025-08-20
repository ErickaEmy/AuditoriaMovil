package kotlin.reflect;

import kotlin.Function;
/* compiled from: KFunction.kt */
/* loaded from: classes.dex */
public interface KFunction extends KCallable, Function {
    boolean isExternal();

    boolean isInfix();

    boolean isInline();

    boolean isOperator();

    @Override // 
    boolean isSuspend();
}
