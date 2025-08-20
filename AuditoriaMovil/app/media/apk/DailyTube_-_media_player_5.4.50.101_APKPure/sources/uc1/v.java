package uc1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kc1.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class v extends s {

    /* renamed from: c5  reason: collision with root package name */
    public static final n3 f14066c5 = new n3(null);

    /* renamed from: a  reason: collision with root package name */
    public final Method f14067a;

    /* renamed from: fb  reason: collision with root package name */
    public final Class<?> f14068fb;

    /* renamed from: gv  reason: collision with root package name */
    public final Method f14069gv;

    /* renamed from: s  reason: collision with root package name */
    public final Class<?> f14070s;

    /* renamed from: v  reason: collision with root package name */
    public final Method f14071v;

    /* loaded from: classes.dex */
    public static final class n3 {
        public n3() {
        }

        public final s y() {
            String jvmVersion = System.getProperty("java.specification.version", "unknown");
            try {
                Intrinsics.checkNotNullExpressionValue(jvmVersion, "jvmVersion");
                if (Integer.parseInt(jvmVersion) >= 9) {
                    return null;
                }
            } catch (NumberFormatException unused) {
            }
            try {
                Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                Class<?> clientProviderClass = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                Class<?> serverProviderClass = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                Method putMethod = cls.getMethod("put", SSLSocket.class, cls2);
                Method getMethod = cls.getMethod("get", SSLSocket.class);
                Method removeMethod = cls.getMethod("remove", SSLSocket.class);
                Intrinsics.checkNotNullExpressionValue(putMethod, "putMethod");
                Intrinsics.checkNotNullExpressionValue(getMethod, "getMethod");
                Intrinsics.checkNotNullExpressionValue(removeMethod, "removeMethod");
                Intrinsics.checkNotNullExpressionValue(clientProviderClass, "clientProviderClass");
                Intrinsics.checkNotNullExpressionValue(serverProviderClass, "serverProviderClass");
                return new v(putMethod, getMethod, removeMethod, clientProviderClass, serverProviderClass);
            } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                return null;
            }
        }

        public /* synthetic */ n3(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static final class y implements InvocationHandler {

        /* renamed from: n3  reason: collision with root package name */
        public String f14072n3;
        public boolean y;

        /* renamed from: zn  reason: collision with root package name */
        public final List<String> f14073zn;

        public y(List<String> protocols) {
            Intrinsics.checkNotNullParameter(protocols, "protocols");
            this.f14073zn = protocols;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object proxy, Method method, Object[] objArr) throws Throwable {
            Intrinsics.checkNotNullParameter(proxy, "proxy");
            Intrinsics.checkNotNullParameter(method, "method");
            if (objArr == null) {
                objArr = new Object[0];
            }
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (Intrinsics.areEqual(name, "supports") && Intrinsics.areEqual(Boolean.TYPE, returnType)) {
                return Boolean.TRUE;
            }
            if (Intrinsics.areEqual(name, "unsupported") && Intrinsics.areEqual(Void.TYPE, returnType)) {
                this.y = true;
                return null;
            } else if (Intrinsics.areEqual(name, "protocols") && objArr.length == 0) {
                return this.f14073zn;
            } else {
                if ((Intrinsics.areEqual(name, "selectProtocol") || Intrinsics.areEqual(name, "select")) && Intrinsics.areEqual(String.class, returnType) && objArr.length == 1) {
                    Object obj = objArr[0];
                    if (obj instanceof List) {
                        if (obj != null) {
                            List list = (List) obj;
                            int size = list.size();
                            if (size >= 0) {
                                int i = 0;
                                while (true) {
                                    Object obj2 = list.get(i);
                                    if (obj2 != null) {
                                        String str = (String) obj2;
                                        if (this.f14073zn.contains(str)) {
                                            this.f14072n3 = str;
                                            return str;
                                        } else if (i == size) {
                                            break;
                                        } else {
                                            i++;
                                        }
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                }
                            }
                            String str2 = this.f14073zn.get(0);
                            this.f14072n3 = str2;
                            return str2;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<*>");
                    }
                }
                if ((Intrinsics.areEqual(name, "protocolSelected") || Intrinsics.areEqual(name, "selected")) && objArr.length == 1) {
                    Object obj3 = objArr[0];
                    if (obj3 != null) {
                        this.f14072n3 = (String) obj3;
                        return null;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                return method.invoke(this, Arrays.copyOf(objArr, objArr.length));
            }
        }

        public final boolean n3() {
            return this.y;
        }

        public final String y() {
            return this.f14072n3;
        }
    }

    public v(Method putMethod, Method getMethod, Method removeMethod, Class<?> clientProviderClass, Class<?> serverProviderClass) {
        Intrinsics.checkNotNullParameter(putMethod, "putMethod");
        Intrinsics.checkNotNullParameter(getMethod, "getMethod");
        Intrinsics.checkNotNullParameter(removeMethod, "removeMethod");
        Intrinsics.checkNotNullParameter(clientProviderClass, "clientProviderClass");
        Intrinsics.checkNotNullParameter(serverProviderClass, "serverProviderClass");
        this.f14069gv = putMethod;
        this.f14071v = getMethod;
        this.f14067a = removeMethod;
        this.f14068fb = clientProviderClass;
        this.f14070s = serverProviderClass;
    }

    @Override // uc1.s
    public void n3(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        try {
            this.f14067a.invoke(null, sslSocket);
        } catch (IllegalAccessException e2) {
            throw new AssertionError("failed to remove ALPN", e2);
        } catch (InvocationTargetException e3) {
            throw new AssertionError("failed to remove ALPN", e3);
        }
    }

    @Override // uc1.s
    public String s(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        try {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.f14071v.invoke(null, sslSocket));
            if (invocationHandler != null) {
                y yVar = (y) invocationHandler;
                if (!yVar.n3() && yVar.y() == null) {
                    s.t(this, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 0, null, 6, null);
                    return null;
                } else if (yVar.n3()) {
                    return null;
                } else {
                    return yVar.y();
                }
            }
            throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
        } catch (IllegalAccessException e2) {
            throw new AssertionError("failed to get ALPN selected protocol", e2);
        } catch (InvocationTargetException e3) {
            throw new AssertionError("failed to get ALPN selected protocol", e3);
        }
    }

    @Override // uc1.s
    public void v(SSLSocket sslSocket, String str, List<? extends c> protocols) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        try {
            this.f14069gv.invoke(null, sslSocket, Proxy.newProxyInstance(s.class.getClassLoader(), new Class[]{this.f14068fb, this.f14070s}, new y(s.f14065zn.n3(protocols))));
        } catch (IllegalAccessException e2) {
            throw new AssertionError("failed to set ALPN", e2);
        } catch (InvocationTargetException e3) {
            throw new AssertionError("failed to set ALPN", e3);
        }
    }
}
