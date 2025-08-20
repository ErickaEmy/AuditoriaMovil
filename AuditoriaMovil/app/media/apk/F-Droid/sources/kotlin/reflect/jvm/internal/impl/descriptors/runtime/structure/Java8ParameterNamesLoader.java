package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReflectJavaMember.kt */
/* loaded from: classes2.dex */
public final class Java8ParameterNamesLoader {
    public static final Java8ParameterNamesLoader INSTANCE = new Java8ParameterNamesLoader();
    private static Cache cache;

    private Java8ParameterNamesLoader() {
    }

    /* compiled from: ReflectJavaMember.kt */
    /* loaded from: classes2.dex */
    public static final class Cache {
        private final Method getName;
        private final Method getParameters;

        public final Method getGetName() {
            return this.getName;
        }

        public final Method getGetParameters() {
            return this.getParameters;
        }

        public Cache(Method method, Method method2) {
            this.getParameters = method;
            this.getName = method2;
        }
    }

    public final Cache buildCache(Member member) {
        Intrinsics.checkNotNullParameter(member, "member");
        Class<?> cls = member.getClass();
        try {
            return new Cache(cls.getMethod("getParameters", new Class[0]), ReflectClassUtilKt.getSafeClassLoader(cls).loadClass("java.lang.reflect.Parameter").getMethod("getName", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return new Cache(null, null);
        }
    }

    public final List loadParameterNames(Member member) {
        Method getName;
        Intrinsics.checkNotNullParameter(member, "member");
        Cache cache2 = cache;
        if (cache2 == null) {
            synchronized (this) {
                cache2 = cache;
                if (cache2 == null) {
                    cache2 = INSTANCE.buildCache(member);
                    cache = cache2;
                }
            }
        }
        Method getParameters = cache2.getGetParameters();
        if (getParameters == null || (getName = cache2.getGetName()) == null) {
            return null;
        }
        Object invoke = getParameters.invoke(member, new Object[0]);
        Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] objArr = (Object[]) invoke;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            Object invoke2 = getName.invoke(obj, new Object[0]);
            Intrinsics.checkNotNull(invoke2, "null cannot be cast to non-null type kotlin.String");
            arrayList.add((String) invoke2);
        }
        return arrayList;
    }
}
