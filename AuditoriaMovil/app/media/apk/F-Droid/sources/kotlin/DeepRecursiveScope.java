package kotlin;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: DeepRecursive.kt */
/* loaded from: classes.dex */
public abstract class DeepRecursiveScope {
    public /* synthetic */ DeepRecursiveScope(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract Object callRecursive(Object obj, Continuation continuation);

    private DeepRecursiveScope() {
    }
}
