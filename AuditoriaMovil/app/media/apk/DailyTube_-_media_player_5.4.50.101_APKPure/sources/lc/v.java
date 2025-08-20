package lc;

import android.os.Bundle;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.TypeCastException;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import lc.gv;
/* loaded from: classes.dex */
public final class v<Args extends gv> implements Lazy<Args> {

    /* renamed from: fb  reason: collision with root package name */
    public final Function0<Bundle> f10297fb;

    /* renamed from: v  reason: collision with root package name */
    public final KClass<Args> f10298v;
    public Args y;

    public v(KClass<Args> navArgsClass, Function0<Bundle> argumentProducer) {
        Intrinsics.checkParameterIsNotNull(navArgsClass, "navArgsClass");
        Intrinsics.checkParameterIsNotNull(argumentProducer, "argumentProducer");
        this.f10298v = navArgsClass;
        this.f10297fb = argumentProducer;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        if (this.y != null) {
            return true;
        }
        return false;
    }

    @Override // kotlin.Lazy
    /* renamed from: y */
    public Args getValue() {
        Args args = this.y;
        if (args == null) {
            Bundle invoke = this.f10297fb.invoke();
            Method method = a.y().get(this.f10298v);
            if (method == null) {
                Class javaClass = JvmClassMappingKt.getJavaClass(this.f10298v);
                Class<Bundle>[] n32 = a.n3();
                method = javaClass.getMethod("fromBundle", (Class[]) Arrays.copyOf(n32, n32.length));
                a.y().put(this.f10298v, method);
                Intrinsics.checkExpressionValueIsNotNull(method, "navArgsClass.java.getMet…hod\n                    }");
            }
            Object invoke2 = method.invoke(null, invoke);
            if (invoke2 != null) {
                Args args2 = (Args) invoke2;
                this.y = args2;
                return args2;
            }
            throw new TypeCastException("null cannot be cast to non-null type Args");
        }
        return args;
    }
}
