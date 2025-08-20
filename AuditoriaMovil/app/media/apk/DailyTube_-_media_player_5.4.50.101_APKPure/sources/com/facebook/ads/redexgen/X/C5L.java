package com.facebook.ads.redexgen.X;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.5L  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class C5L<T> implements InvocationHandler {
    public static byte[] A02;
    public static String[] A03 = {"HJBbstbFgkhP2Es2YC6tj0WPrL", "4IOUVAMDExjQBHSpAfoXSYCtPyIaCI88", "z5PEOWpVsYBM96D6", "SPmK69spxohqfCa0SsQ", "2TZuMIK", "01EkjjI8QhZqdiHuXsMGI", "efeA7FnPjHODjVcAjRmk7", "pSZyNCg"};
    public ClassLoader A00;
    public T A01;

    public static String A02(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i5);
        int i8 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A03[2].length() != 16) {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[6] = "7LVLxstLm7VGVuwpoPddR";
            strArr[5] = "O4Ajby3FQpCfAUdim7NmB";
            if (i8 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 40);
            i8++;
        }
    }

    public static void A03() {
        A02 = new byte[]{-20, -5, -12};
    }

    static {
        A03();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.5L != com.facebook.ads.internal.apiimp.AdApiProxy$ProxyInvocationHandler<T> */
    public C5L(T impl, ClassLoader classLoader) {
        this.A01 = impl;
        this.A00 = classLoader;
    }

    public static Object A00(final ClassLoader classLoader, Method method) {
        Class<?> returnType = method.getReturnType();
        Object result = Void.TYPE;
        if (returnType.equals(result)) {
            return null;
        }
        if (returnType.isPrimitive()) {
            Object result2 = Array.newInstance(method.getReturnType(), 1);
            return Array.get(result2, 0);
        } else if (returnType.equals(String.class)) {
            return A02(0, 0, 23);
        } else {
            if (!returnType.isInterface()) {
                return null;
            }
            return Proxy.newProxyInstance(classLoader, new Class[]{returnType}, new InvocationHandler() { // from class: com.facebook.ads.redexgen.X.5K
                @Override // java.lang.reflect.InvocationHandler
                public final Object invoke(Object obj, Method method2, Object[] objArr) {
                    Object A00;
                    A00 = C5L.A00(classLoader, method2);
                    return A00;
                }
            });
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.5L != com.facebook.ads.internal.apiimp.AdApiProxy$ProxyInvocationHandler<T> */
    public final T A04() {
        return this.A01;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.5L != com.facebook.ads.internal.apiimp.AdApiProxy$ProxyInvocationHandler<T> */
    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        try {
            return method.invoke(this.A01, objArr);
        } catch (Throwable t2) {
            if (t2 instanceof InvocationTargetException) {
                Throwable targetException = ((InvocationTargetException) t2).getTargetException();
                if (targetException instanceof AnonymousClass22) {
                    throw new IllegalStateException(targetException.getMessage());
                }
            }
            Object A00 = A00(this.A00, method);
            C1115Ym A002 = AbstractC04437e.A00();
            if (A002 != null) {
                A002.A07().A9a(A02(0, 3, 99), C8A.A0O, new C8B(t2));
                return A00;
            }
            return A00;
        }
    }
}
