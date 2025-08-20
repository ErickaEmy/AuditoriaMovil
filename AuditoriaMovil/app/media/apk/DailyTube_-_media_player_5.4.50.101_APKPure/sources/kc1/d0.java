package kc1;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kc1.z;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: a  reason: collision with root package name */
    public final Map<Class<?>, Object> f9730a;

    /* renamed from: gv  reason: collision with root package name */
    public final z f9731gv;

    /* renamed from: n3  reason: collision with root package name */
    public final r f9732n3;

    /* renamed from: v  reason: collision with root package name */
    public final fh f9733v;
    public gv y;

    /* renamed from: zn  reason: collision with root package name */
    public final String f9734zn;

    public d0(r url, String method, z headers, fh fhVar, Map<Class<?>, ? extends Object> tags) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(tags, "tags");
        this.f9732n3 = url;
        this.f9734zn = method;
        this.f9731gv = headers;
        this.f9733v = fhVar;
        this.f9730a = tags;
    }

    public final z a() {
        return this.f9731gv;
    }

    public final y c5() {
        return new y(this);
    }

    public final <T> T f(Class<? extends T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return type.cast(this.f9730a.get(type));
    }

    public final boolean fb() {
        return this.f9732n3.t();
    }

    public final String gv(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.f9731gv.y(name);
    }

    public final Object i9() {
        return f(Object.class);
    }

    public final gv n3() {
        gv gvVar = this.y;
        if (gvVar == null) {
            gv n32 = gv.f9766w.n3(this.f9731gv);
            this.y = n32;
            return n32;
        }
        return gvVar;
    }

    public final String s() {
        return this.f9734zn;
    }

    public final r t() {
        return this.f9732n3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.f9734zn);
        sb.append(", url=");
        sb.append(this.f9732n3);
        if (this.f9731gv.size() != 0) {
            sb.append(", headers=[");
            int i = 0;
            for (Pair<? extends String, ? extends String> pair : this.f9731gv) {
                int i5 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Pair<? extends String, ? extends String> pair2 = pair;
                String component1 = pair2.component1();
                String component2 = pair2.component2();
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(component1);
                sb.append(':');
                sb.append(component2);
                i = i5;
            }
            sb.append(']');
        }
        if (!this.f9730a.isEmpty()) {
            sb.append(", tags=");
            sb.append(this.f9730a);
        }
        sb.append('}');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final List<String> v(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.f9731gv.i9(name);
    }

    public final fh y() {
        return this.f9733v;
    }

    public final Map<Class<?>, Object> zn() {
        return this.f9730a;
    }

    /* loaded from: classes.dex */
    public static class y {

        /* renamed from: gv  reason: collision with root package name */
        public fh f9735gv;

        /* renamed from: n3  reason: collision with root package name */
        public String f9736n3;

        /* renamed from: v  reason: collision with root package name */
        public Map<Class<?>, Object> f9737v;
        public r y;

        /* renamed from: zn  reason: collision with root package name */
        public z.y f9738zn;

        public y() {
            this.f9737v = new LinkedHashMap();
            this.f9736n3 = "GET";
            this.f9738zn = new z.y();
        }

        public y a() {
            return c5("HEAD", null);
        }

        public y c5(String method, fh fhVar) {
            boolean z2;
            Intrinsics.checkNotNullParameter(method, "method");
            if (method.length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (fhVar == null) {
                    if (qc1.a.v(method)) {
                        throw new IllegalArgumentException(("method " + method + " must have a request body.").toString());
                    }
                } else if (!qc1.a.n3(method)) {
                    throw new IllegalArgumentException(("method " + method + " must not have a request body.").toString());
                }
                this.f9736n3 = method;
                this.f9735gv = fhVar;
                return this;
            }
            throw new IllegalArgumentException("method.isEmpty() == true");
        }

        public y f(fh body) {
            Intrinsics.checkNotNullParameter(body, "body");
            return c5("POST", body);
        }

        public y fb(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            this.f9738zn.i9(name, value);
            return this;
        }

        public y gv(fh fhVar) {
            return c5("DELETE", fhVar);
        }

        public y i9(fh body) {
            Intrinsics.checkNotNullParameter(body, "body");
            return c5("PATCH", body);
        }

        public d0 n3() {
            r rVar = this.y;
            if (rVar != null) {
                return new d0(rVar, this.f9736n3, this.f9738zn.a(), this.f9735gv, lc1.n3.qn(this.f9737v));
            }
            throw new IllegalStateException("url == null");
        }

        public y p(r url) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.y = url;
            return this;
        }

        public y s(z headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            this.f9738zn = headers.v();
            return this;
        }

        public y t(fh body) {
            Intrinsics.checkNotNullParameter(body, "body");
            return c5("PUT", body);
        }

        public y tl(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.f9738zn.c5(name);
            return this;
        }

        public y v() {
            return c5("GET", null);
        }

        public y w(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            if (StringsKt.startsWith(url, "ws:", true)) {
                StringBuilder sb = new StringBuilder();
                sb.append("http:");
                String substring = url.substring(3);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                sb.append(substring);
                url = sb.toString();
            } else if (StringsKt.startsWith(url, "wss:", true)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("https:");
                String substring2 = url.substring(4);
                Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.String).substring(startIndex)");
                sb2.append(substring2);
                url = sb2.toString();
            }
            return p(r.f9869t.gv(url));
        }

        public <T> y wz(Class<? super T> type, T t2) {
            Intrinsics.checkNotNullParameter(type, "type");
            if (t2 == null) {
                this.f9737v.remove(type);
            } else {
                if (this.f9737v.isEmpty()) {
                    this.f9737v = new LinkedHashMap();
                }
                Map<Class<?>, Object> map = this.f9737v;
                T cast = type.cast(t2);
                Intrinsics.checkNotNull(cast);
                map.put(type, cast);
            }
            return this;
        }

        public y xc(Object obj) {
            return wz(Object.class, obj);
        }

        public y y(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            this.f9738zn.y(name, value);
            return this;
        }

        public y zn(gv cacheControl) {
            Intrinsics.checkNotNullParameter(cacheControl, "cacheControl");
            String gvVar = cacheControl.toString();
            if (gvVar.length() == 0) {
                return tl("Cache-Control");
            }
            return fb("Cache-Control", gvVar);
        }

        public y(d0 request) {
            Map<Class<?>, Object> mutableMap;
            Intrinsics.checkNotNullParameter(request, "request");
            this.f9737v = new LinkedHashMap();
            this.y = request.t();
            this.f9736n3 = request.s();
            this.f9735gv = request.y();
            if (request.zn().isEmpty()) {
                mutableMap = new LinkedHashMap<>();
            } else {
                mutableMap = MapsKt.toMutableMap(request.zn());
            }
            this.f9737v = mutableMap;
            this.f9738zn = request.a().v();
        }
    }
}
