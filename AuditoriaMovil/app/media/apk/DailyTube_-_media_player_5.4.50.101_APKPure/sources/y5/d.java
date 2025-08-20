package y5;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import y5.ud;
/* loaded from: classes.dex */
public final class d<T extends ud> extends androidx.lifecycle.y {

    /* renamed from: gv  reason: collision with root package name */
    public final be1.y f15284gv;

    /* renamed from: v  reason: collision with root package name */
    public final od1.n3<T> f15285v;

    /* loaded from: classes.dex */
    public static final class y extends Lambda implements Function0<yd1.y> {
        final /* synthetic */ yd1.y $definitionParameters;
        final /* synthetic */ ta $handle;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(yd1.y yVar, ta taVar) {
            super(0);
            this.$definitionParameters = yVar;
            this.$handle = taVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: y */
        public final yd1.y invoke() {
            return this.$definitionParameters.y(this.$handle);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public d(be1.y r3, od1.n3<T> r4) {
        /*
            r2 = this;
            java.lang.String r0 = "scope"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "parameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            g.y r0 = r4.gv()
            if (r0 == 0) goto L26
            kotlin.jvm.functions.Function0 r1 = r4.v()
            if (r1 != 0) goto L18
            r1 = 0
            goto L1e
        L18:
            java.lang.Object r1 = r1.invoke()
            android.os.Bundle r1 = (android.os.Bundle) r1
        L1e:
            r2.<init>(r0, r1)
            r2.f15284gv = r3
            r2.f15285v = r4
            return
        L26:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "Can't create SavedStateViewModelFactory without a proper stateRegistryOwner"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: y5.d.<init>(be1.y, od1.n3):void");
    }

    public final Function0<yd1.y> gv(ta taVar) {
        yd1.y invoke;
        Function0<yd1.y> n32 = this.f15285v.n3();
        if (n32 == null) {
            invoke = null;
        } else {
            invoke = n32.invoke();
        }
        if (invoke == null) {
            invoke = yd1.n3.y();
        }
        return new y(invoke, taVar);
    }

    @Override // androidx.lifecycle.y
    public <T extends ud> T zn(String key, Class<T> modelClass, ta handle) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(handle, "handle");
        return (T) this.f15284gv.zn(this.f15285v.y(), this.f15285v.zn(), gv(handle));
    }
}
