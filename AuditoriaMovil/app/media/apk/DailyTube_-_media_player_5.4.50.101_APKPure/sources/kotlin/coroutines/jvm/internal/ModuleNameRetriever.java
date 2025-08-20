package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ModuleNameRetriever {
    private static Cache cache;
    public static final ModuleNameRetriever INSTANCE = new ModuleNameRetriever();
    private static final Cache notOnJava9 = new Cache(null, null, null);

    /* loaded from: classes.dex */
    public static final class Cache {
        public final Method getDescriptorMethod;
        public final Method getModuleMethod;
        public final Method nameMethod;

        public Cache(Method method, Method method2, Method method3) {
            this.getModuleMethod = method;
            this.getDescriptorMethod = method2;
            this.nameMethod = method3;
        }
    }

    private ModuleNameRetriever() {
    }

    private final Cache buildCache(BaseContinuationImpl baseContinuationImpl) {
        try {
            Cache cache2 = new Cache(Class.class.getDeclaredMethod("getModule", null), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));
            cache = cache2;
            return cache2;
        } catch (Exception unused) {
            Cache cache3 = notOnJava9;
            cache = cache3;
            return cache3;
        }
    }

    public final String getModuleName(BaseContinuationImpl continuation) {
        Object obj;
        Object obj2;
        Object obj3;
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        Cache cache2 = cache;
        if (cache2 == null) {
            cache2 = buildCache(continuation);
        }
        if (cache2 == notOnJava9) {
            return null;
        }
        Method method = cache2.getModuleMethod;
        if (method != null) {
            obj = method.invoke(continuation.getClass(), null);
        } else {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        Method method2 = cache2.getDescriptorMethod;
        if (method2 != null) {
            obj2 = method2.invoke(obj, null);
        } else {
            obj2 = null;
        }
        if (obj2 == null) {
            return null;
        }
        Method method3 = cache2.nameMethod;
        if (method3 != null) {
            obj3 = method3.invoke(obj2, null);
        } else {
            obj3 = null;
        }
        if (!(obj3 instanceof String)) {
            return null;
        }
        return (String) obj3;
    }
}
