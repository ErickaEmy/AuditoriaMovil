package vc1;

import java.lang.reflect.Method;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class s {

    /* renamed from: gv  reason: collision with root package name */
    public static final y f14442gv = new y(null);

    /* renamed from: n3  reason: collision with root package name */
    public final Method f14443n3;
    public final Method y;

    /* renamed from: zn  reason: collision with root package name */
    public final Method f14444zn;

    /* loaded from: classes.dex */
    public static final class y {
        public y() {
        }

        public final s y() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", null);
                method2 = cls.getMethod("open", String.class);
                method = cls.getMethod("warnIfOpen", null);
                method3 = method4;
            } catch (Exception unused) {
                method = null;
                method2 = null;
            }
            return new s(method3, method2, method);
        }

        public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public s(Method method, Method method2, Method method3) {
        this.y = method;
        this.f14443n3 = method2;
        this.f14444zn = method3;
    }

    public final boolean n3(Object obj) {
        if (obj != null) {
            try {
                Method method = this.f14444zn;
                Intrinsics.checkNotNull(method);
                method.invoke(obj, null);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public final Object y(String closer) {
        Intrinsics.checkNotNullParameter(closer, "closer");
        Method method = this.y;
        if (method != null) {
            try {
                Object invoke = method.invoke(null, null);
                Method method2 = this.f14443n3;
                Intrinsics.checkNotNull(method2);
                method2.invoke(invoke, closer);
                return invoke;
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
