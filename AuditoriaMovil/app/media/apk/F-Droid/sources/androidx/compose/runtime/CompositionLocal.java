package androidx.compose.runtime;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: CompositionLocal.kt */
/* loaded from: classes.dex */
public abstract class CompositionLocal {
    private final LazyValueHolder defaultValueHolder;

    public /* synthetic */ CompositionLocal(Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0);
    }

    public final LazyValueHolder getDefaultValueHolder$runtime_release() {
        return this.defaultValueHolder;
    }

    public abstract State provided$runtime_release(Object obj, Composer composer, int i);

    private CompositionLocal(Function0 function0) {
        this.defaultValueHolder = new LazyValueHolder(function0);
    }
}
