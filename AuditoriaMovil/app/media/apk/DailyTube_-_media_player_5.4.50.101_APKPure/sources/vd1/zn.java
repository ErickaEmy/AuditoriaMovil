package vd1;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public abstract class zn<T> {

    /* renamed from: n3  reason: collision with root package name */
    public static final y f14453n3 = new y(null);
    public final td1.y<T> y;

    /* loaded from: classes.dex */
    public static final class y {
        public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public y() {
        }
    }

    public zn(td1.y<T> beanDefinition) {
        Intrinsics.checkNotNullParameter(beanDefinition, "beanDefinition");
        this.y = beanDefinition;
    }

    public abstract T n3(n3 n3Var);

    public T y(n3 context) {
        Intrinsics.checkNotNullParameter(context, "context");
        qd1.y y2 = context.y();
        if (y2.zn().fb(wd1.n3.DEBUG)) {
            y2.zn().n3(Intrinsics.stringPlus("| create instance for ", this.y));
        }
        try {
            yd1.y n32 = context.n3();
            if (n32 == null) {
                n32 = yd1.n3.y();
            }
            return this.y.y().invoke(context.zn(), n32);
        } catch (Exception e2) {
            String zn2 = fe1.y.y.zn(e2);
            wd1.zn zn3 = y2.zn();
            zn3.gv("Instance creation error : could not create instance for " + this.y + ": " + zn2);
            throw new ud1.zn(Intrinsics.stringPlus("Could not create instance for ", this.y), e2);
        }
    }

    public final td1.y<T> zn() {
        return this.y;
    }
}
