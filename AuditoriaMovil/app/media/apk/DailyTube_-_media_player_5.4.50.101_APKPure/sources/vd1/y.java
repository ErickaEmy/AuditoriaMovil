package vd1;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class y<T> extends zn<T> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(td1.y<T> beanDefinition) {
        super(beanDefinition);
        Intrinsics.checkNotNullParameter(beanDefinition, "beanDefinition");
    }

    @Override // vd1.zn
    public T n3(n3 context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return y(context);
    }
}
