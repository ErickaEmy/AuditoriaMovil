package vc1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kc1.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import vc1.f;
import vc1.i9;
/* loaded from: classes.dex */
public class a implements f {

    /* renamed from: a  reason: collision with root package name */
    public static final i9.y f14430a;

    /* renamed from: fb  reason: collision with root package name */
    public static final y f14431fb;

    /* renamed from: gv  reason: collision with root package name */
    public final Method f14432gv;

    /* renamed from: n3  reason: collision with root package name */
    public final Method f14433n3;

    /* renamed from: v  reason: collision with root package name */
    public final Class<? super SSLSocket> f14434v;
    public final Method y;

    /* renamed from: zn  reason: collision with root package name */
    public final Method f14435zn;

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: vc1.a$y$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0237y implements i9.y {
            public final /* synthetic */ String y;

            public C0237y(String str) {
                this.y = str;
            }

            @Override // vc1.i9.y
            public f n3(SSLSocket sslSocket) {
                Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
                return a.f14431fb.n3(sslSocket.getClass());
            }

            @Override // vc1.i9.y
            public boolean y(SSLSocket sslSocket) {
                Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
                String name = sslSocket.getClass().getName();
                Intrinsics.checkNotNullExpressionValue(name, "sslSocket.javaClass.name");
                return StringsKt.startsWith$default(name, this.y + '.', false, 2, (Object) null);
            }
        }

        public y() {
        }

        public final i9.y gv() {
            return a.f14430a;
        }

        public final a n3(Class<? super SSLSocket> cls) {
            Class<? super SSLSocket> cls2 = cls;
            while (cls2 != null && !Intrinsics.areEqual(cls2.getSimpleName(), "OpenSSLSocketImpl")) {
                cls2 = cls2.getSuperclass();
                if (cls2 == null) {
                    throw new AssertionError("No OpenSSLSocketImpl superclass of socket of type " + cls);
                }
            }
            Intrinsics.checkNotNull(cls2);
            return new a(cls2);
        }

        public final i9.y zn(String packageName) {
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            return new C0237y(packageName);
        }

        public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        y yVar = new y(null);
        f14431fb = yVar;
        f14430a = yVar.zn("com.google.android.gms.org.conscrypt");
    }

    public a(Class<? super SSLSocket> sslSocketClass) {
        Intrinsics.checkNotNullParameter(sslSocketClass, "sslSocketClass");
        this.f14434v = sslSocketClass;
        Method declaredMethod = sslSocketClass.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
        Intrinsics.checkNotNullExpressionValue(declaredMethod, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
        this.y = declaredMethod;
        this.f14433n3 = sslSocketClass.getMethod("setHostname", String.class);
        this.f14435zn = sslSocketClass.getMethod("getAlpnSelectedProtocol", null);
        this.f14432gv = sslSocketClass.getMethod("setAlpnProtocols", byte[].class);
    }

    @Override // vc1.f
    public void a(SSLSocket sslSocket, String str, List<? extends c> protocols) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        if (y(sslSocket)) {
            try {
                this.y.invoke(sslSocket, Boolean.TRUE);
                if (str != null) {
                    this.f14433n3.invoke(sslSocket, str);
                }
                this.f14432gv.invoke(sslSocket, uc1.s.f14065zn.zn(protocols));
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (InvocationTargetException e3) {
                throw new AssertionError(e3);
            }
        }
    }

    @Override // vc1.f
    public X509TrustManager gv(SSLSocketFactory sslSocketFactory) {
        Intrinsics.checkNotNullParameter(sslSocketFactory, "sslSocketFactory");
        return f.y.n3(this, sslSocketFactory);
    }

    @Override // vc1.f
    public String n3(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        if (!y(sslSocket)) {
            return null;
        }
        try {
            byte[] bArr = (byte[]) this.f14435zn.invoke(sslSocket, null);
            if (bArr == null) {
                return null;
            }
            Charset charset = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(charset, "StandardCharsets.UTF_8");
            return new String(bArr, charset);
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        } catch (NullPointerException e3) {
            if (Intrinsics.areEqual(e3.getMessage(), "ssl == null")) {
                return null;
            }
            throw e3;
        } catch (InvocationTargetException e5) {
            throw new AssertionError(e5);
        }
    }

    @Override // vc1.f
    public boolean v(SSLSocketFactory sslSocketFactory) {
        Intrinsics.checkNotNullParameter(sslSocketFactory, "sslSocketFactory");
        return f.y.y(this, sslSocketFactory);
    }

    @Override // vc1.f
    public boolean y(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        return this.f14434v.isInstance(sslSocket);
    }

    @Override // vc1.f
    public boolean zn() {
        return uc1.n3.f14060fb.n3();
    }
}
