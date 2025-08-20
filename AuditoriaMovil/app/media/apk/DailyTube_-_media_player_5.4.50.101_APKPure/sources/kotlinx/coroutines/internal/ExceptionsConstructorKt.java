package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CopyableThrowable;
/* loaded from: classes.dex */
public final class ExceptionsConstructorKt {
    private static final CtorCache ctorCache;
    private static final int throwableFields = fieldsCountOrDefault(Throwable.class, -1);

    static {
        CtorCache ctorCache2;
        try {
            if (FastServiceLoaderKt.getANDROID_DETECTED()) {
                ctorCache2 = WeakMapCtorCache.INSTANCE;
            } else {
                ctorCache2 = ClassValueCtorCache.INSTANCE;
            }
        } catch (Throwable unused) {
            ctorCache2 = WeakMapCtorCache.INSTANCE;
        }
        ctorCache = ctorCache2;
    }

    public static final /* synthetic */ Function1 access$createConstructor(Class cls) {
        return createConstructor(cls);
    }

    public static final <E extends Throwable> Function1<Throwable, Throwable> createConstructor(Class<E> cls) {
        Object obj;
        Function1<Throwable, Throwable> function1;
        Pair pair;
        ExceptionsConstructorKt$createConstructor$nullResult$1 exceptionsConstructorKt$createConstructor$nullResult$1 = new Function1() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createConstructor$nullResult$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(Throwable th) {
                return null;
            }
        };
        if (throwableFields != fieldsCountOrDefault(cls, 0)) {
            return exceptionsConstructorKt$createConstructor$nullResult$1;
        }
        Constructor<?>[] constructors = cls.getConstructors();
        ArrayList arrayList = new ArrayList(constructors.length);
        int length = constructors.length;
        int i = 0;
        while (true) {
            obj = null;
            if (i >= length) {
                break;
            }
            final Constructor<?> constructor = constructors[i];
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            int length2 = parameterTypes.length;
            if (length2 != 0) {
                if (length2 != 1) {
                    if (length2 != 2) {
                        pair = TuplesKt.to(null, -1);
                    } else if (Intrinsics.areEqual(parameterTypes[0], String.class) && Intrinsics.areEqual(parameterTypes[1], Throwable.class)) {
                        pair = TuplesKt.to(safeCtor(new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createConstructor$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Throwable invoke(Throwable th) {
                                Object newInstance = constructor.newInstance(th.getMessage(), th);
                                Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type kotlin.Throwable");
                                return (Throwable) newInstance;
                            }
                        }), 3);
                    } else {
                        pair = TuplesKt.to(null, -1);
                    }
                } else {
                    Class<?> cls2 = parameterTypes[0];
                    if (Intrinsics.areEqual(cls2, String.class)) {
                        pair = TuplesKt.to(safeCtor(new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createConstructor$1$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Throwable invoke(Throwable th) {
                                Object newInstance = constructor.newInstance(th.getMessage());
                                Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type kotlin.Throwable");
                                Throwable th2 = (Throwable) newInstance;
                                th2.initCause(th);
                                return th2;
                            }
                        }), 2);
                    } else if (Intrinsics.areEqual(cls2, Throwable.class)) {
                        pair = TuplesKt.to(safeCtor(new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createConstructor$1$3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Throwable invoke(Throwable th) {
                                Object newInstance = constructor.newInstance(th);
                                Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type kotlin.Throwable");
                                return (Throwable) newInstance;
                            }
                        }), 1);
                    } else {
                        pair = TuplesKt.to(null, -1);
                    }
                }
            } else {
                pair = TuplesKt.to(safeCtor(new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createConstructor$1$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Throwable invoke(Throwable th) {
                        Object newInstance = constructor.newInstance(null);
                        Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type kotlin.Throwable");
                        Throwable th2 = (Throwable) newInstance;
                        th2.initCause(th);
                        return th2;
                    }
                }), 0);
            }
            arrayList.add(pair);
            i++;
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            obj = it.next();
            if (it.hasNext()) {
                int intValue = ((Number) ((Pair) obj).getSecond()).intValue();
                do {
                    Object next = it.next();
                    int intValue2 = ((Number) ((Pair) next).getSecond()).intValue();
                    if (intValue < intValue2) {
                        obj = next;
                        intValue = intValue2;
                    }
                } while (it.hasNext());
            }
        }
        Pair pair2 = (Pair) obj;
        if (pair2 != null && (function1 = (Function1) pair2.getFirst()) != null) {
            return function1;
        }
        return exceptionsConstructorKt$createConstructor$nullResult$1;
    }

    private static final int fieldsCount(Class<?> cls, int i) {
        do {
            int i5 = 0;
            for (Field field : cls.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    i5++;
                }
            }
            i += i5;
            cls = cls.getSuperclass();
        } while (cls != null);
        return i;
    }

    public static /* synthetic */ int fieldsCount$default(Class cls, int i, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = 0;
        }
        return fieldsCount(cls, i);
    }

    private static final int fieldsCountOrDefault(Class<?> cls, int i) {
        Integer m28constructorimpl;
        JvmClassMappingKt.getKotlinClass(cls);
        try {
            Result.Companion companion = Result.Companion;
            m28constructorimpl = Result.m28constructorimpl(Integer.valueOf(fieldsCount$default(cls, 0, 1, null)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m28constructorimpl = Result.m28constructorimpl(ResultKt.createFailure(th));
        }
        Integer valueOf = Integer.valueOf(i);
        if (Result.m32isFailureimpl(m28constructorimpl)) {
            m28constructorimpl = valueOf;
        }
        return ((Number) m28constructorimpl).intValue();
    }

    private static final Function1<Throwable, Throwable> safeCtor(final Function1<? super Throwable, ? extends Throwable> function1) {
        return new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$safeCtor$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Throwable invoke(Throwable th) {
                Object m28constructorimpl;
                Function1<Throwable, Throwable> function12 = function1;
                try {
                    Result.Companion companion = Result.Companion;
                    Throwable invoke = function12.invoke(th);
                    if (!Intrinsics.areEqual(th.getMessage(), invoke.getMessage()) && !Intrinsics.areEqual(invoke.getMessage(), th.toString())) {
                        invoke = null;
                    }
                    m28constructorimpl = Result.m28constructorimpl(invoke);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    m28constructorimpl = Result.m28constructorimpl(ResultKt.createFailure(th2));
                }
                return Result.m32isFailureimpl(m28constructorimpl) ? null : m28constructorimpl;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E extends Throwable> E tryCopyException(E e2) {
        Object m28constructorimpl;
        if (e2 instanceof CopyableThrowable) {
            try {
                Result.Companion companion = Result.Companion;
                m28constructorimpl = Result.m28constructorimpl(((CopyableThrowable) e2).createCopy());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                m28constructorimpl = Result.m28constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m32isFailureimpl(m28constructorimpl)) {
                m28constructorimpl = null;
            }
            return (E) m28constructorimpl;
        }
        return (E) ctorCache.get(e2.getClass()).invoke(e2);
    }
}
