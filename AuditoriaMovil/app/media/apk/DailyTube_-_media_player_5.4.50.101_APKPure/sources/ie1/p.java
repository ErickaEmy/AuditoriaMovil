package ie1;

import ie1.wz;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kc1.d0;
import kc1.f3;
import kc1.z;
import ke1.n;
import kotlin.coroutines.Continuation;
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public final kc1.i4 f9211a;

    /* renamed from: c5  reason: collision with root package name */
    public final boolean f9212c5;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f9213f;

    /* renamed from: fb  reason: collision with root package name */
    public final boolean f9214fb;

    /* renamed from: gv  reason: collision with root package name */
    public final String f9215gv;

    /* renamed from: i9  reason: collision with root package name */
    public final wz<?>[] f9216i9;

    /* renamed from: n3  reason: collision with root package name */
    public final kc1.r f9217n3;

    /* renamed from: s  reason: collision with root package name */
    public final boolean f9218s;

    /* renamed from: v  reason: collision with root package name */
    public final kc1.z f9219v;
    public final Method y;

    /* renamed from: zn  reason: collision with root package name */
    public final String f9220zn;

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: f3  reason: collision with root package name */
        public static final Pattern f9221f3 = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");

        /* renamed from: n  reason: collision with root package name */
        public static final Pattern f9222n = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");

        /* renamed from: a  reason: collision with root package name */
        public boolean f9223a;

        /* renamed from: c5  reason: collision with root package name */
        public boolean f9224c5;

        /* renamed from: co  reason: collision with root package name */
        public kc1.z f9225co;

        /* renamed from: f  reason: collision with root package name */
        public boolean f9226f;

        /* renamed from: fb  reason: collision with root package name */
        public boolean f9227fb;

        /* renamed from: gv  reason: collision with root package name */
        public final Annotation[][] f9228gv;

        /* renamed from: i4  reason: collision with root package name */
        public boolean f9229i4;

        /* renamed from: i9  reason: collision with root package name */
        public boolean f9230i9;

        /* renamed from: mt  reason: collision with root package name */
        public String f9231mt;

        /* renamed from: n3  reason: collision with root package name */
        public final Method f9232n3;

        /* renamed from: p  reason: collision with root package name */
        public boolean f9233p;

        /* renamed from: r  reason: collision with root package name */
        public Set<String> f9234r;

        /* renamed from: s  reason: collision with root package name */
        public boolean f9235s;

        /* renamed from: t  reason: collision with root package name */
        public boolean f9236t;

        /* renamed from: tl  reason: collision with root package name */
        public boolean f9237tl;

        /* renamed from: v  reason: collision with root package name */
        public final Type[] f9238v;

        /* renamed from: w  reason: collision with root package name */
        public boolean f9239w;

        /* renamed from: wz  reason: collision with root package name */
        public String f9240wz;

        /* renamed from: x4  reason: collision with root package name */
        public wz<?>[] f9241x4;

        /* renamed from: xc  reason: collision with root package name */
        public boolean f9242xc;
        public final co y;

        /* renamed from: z  reason: collision with root package name */
        public kc1.i4 f9243z;

        /* renamed from: zn  reason: collision with root package name */
        public final Annotation[] f9244zn;

        public y(co coVar, Method method) {
            this.y = coVar;
            this.f9232n3 = method;
            this.f9244zn = method.getAnnotations();
            this.f9238v = method.getGenericParameterTypes();
            this.f9228gv = method.getParameterAnnotations();
        }

        public static Set<String> s(String str) {
            Matcher matcher = f9221f3.matcher(str);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (matcher.find()) {
                linkedHashSet.add(matcher.group(1));
            }
            return linkedHashSet;
        }

        public static Class<?> y(Class<?> cls) {
            if (Boolean.TYPE == cls) {
                return Boolean.class;
            }
            if (Byte.TYPE == cls) {
                return Byte.class;
            }
            if (Character.TYPE == cls) {
                return Character.class;
            }
            if (Double.TYPE == cls) {
                return Double.class;
            }
            if (Float.TYPE == cls) {
                return Float.class;
            }
            if (Integer.TYPE == cls) {
                return Integer.class;
            }
            if (Long.TYPE == cls) {
                return Long.class;
            }
            if (Short.TYPE == cls) {
                return Short.class;
            }
            return cls;
        }

        public final wz<?> a(int i, Type type, Annotation[] annotationArr, boolean z2) {
            wz<?> wzVar;
            if (annotationArr != null) {
                wzVar = null;
                for (Annotation annotation : annotationArr) {
                    wz<?> fb2 = fb(i, type, annotationArr, annotation);
                    if (fb2 != null) {
                        if (wzVar == null) {
                            wzVar = fb2;
                        } else {
                            throw i4.w(this.f9232n3, i, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                        }
                    }
                }
            } else {
                wzVar = null;
            }
            if (wzVar == null) {
                if (z2) {
                    try {
                        if (i4.c5(type) == Continuation.class) {
                            this.f9229i4 = true;
                            return null;
                        }
                    } catch (NoClassDefFoundError unused) {
                    }
                }
                throw i4.w(this.f9232n3, i, "No Retrofit annotation found.", new Object[0]);
            }
            return wzVar;
        }

        public final void c5(int i, String str) {
            if (f9222n.matcher(str).matches()) {
                if (this.f9234r.contains(str)) {
                    return;
                }
                throw i4.w(this.f9232n3, i, "URL \"%s\" does not contain \"{%s}\".", this.f9231mt, str);
            }
            throw i4.w(this.f9232n3, i, "@Path parameter name must match %s. Found: %s", f9221f3.pattern(), str);
        }

        public final wz<?> fb(int i, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (annotation instanceof n) {
                i9(i, type);
                if (!this.f9237tl) {
                    if (!this.f9224c5) {
                        if (!this.f9230i9) {
                            if (!this.f9226f) {
                                if (!this.f9236t) {
                                    if (this.f9231mt == null) {
                                        this.f9237tl = true;
                                        if (type != kc1.r.class && type != String.class && type != URI.class && (!(type instanceof Class) || !"android.net.Uri".equals(((Class) type).getName()))) {
                                            throw i4.w(this.f9232n3, i, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
                                        }
                                        return new wz.w(this.f9232n3, i);
                                    }
                                    throw i4.w(this.f9232n3, i, "@Url cannot be used with @%s URL", this.f9240wz);
                                }
                                throw i4.w(this.f9232n3, i, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
                            }
                            throw i4.w(this.f9232n3, i, "A @Url parameter must not come after a @QueryName.", new Object[0]);
                        }
                        throw i4.w(this.f9232n3, i, "A @Url parameter must not come after a @Query.", new Object[0]);
                    }
                    throw i4.w(this.f9232n3, i, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                throw i4.w(this.f9232n3, i, "Multiple @Url method annotations found.", new Object[0]);
            } else if (annotation instanceof ke1.co) {
                i9(i, type);
                if (!this.f9230i9) {
                    if (!this.f9226f) {
                        if (!this.f9236t) {
                            if (!this.f9237tl) {
                                if (this.f9231mt != null) {
                                    this.f9224c5 = true;
                                    ke1.co coVar = (ke1.co) annotation;
                                    String value = coVar.value();
                                    c5(i, value);
                                    return new wz.f(this.f9232n3, i, value, this.y.i9(type, annotationArr), coVar.encoded());
                                }
                                throw i4.w(this.f9232n3, i, "@Path can only be used with relative url on @%s", this.f9240wz);
                            }
                            throw i4.w(this.f9232n3, i, "@Path parameters may not be used with @Url.", new Object[0]);
                        }
                        throw i4.w(this.f9232n3, i, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
                    }
                    throw i4.w(this.f9232n3, i, "A @Path parameter must not come after a @QueryName.", new Object[0]);
                }
                throw i4.w(this.f9232n3, i, "A @Path parameter must not come after a @Query.", new Object[0]);
            } else if (annotation instanceof ke1.z) {
                i9(i, type);
                ke1.z zVar = (ke1.z) annotation;
                String value2 = zVar.value();
                boolean encoded = zVar.encoded();
                Class<?> c52 = i4.c5(type);
                this.f9230i9 = true;
                if (Iterable.class.isAssignableFrom(c52)) {
                    if (type instanceof ParameterizedType) {
                        return new wz.t(value2, this.y.i9(i4.s(0, (ParameterizedType) type), annotationArr), encoded).zn();
                    }
                    throw i4.w(this.f9232n3, i, c52.getSimpleName() + " must include generic type (e.g., " + c52.getSimpleName() + "<String>)", new Object[0]);
                } else if (c52.isArray()) {
                    return new wz.t(value2, this.y.i9(y(c52.getComponentType()), annotationArr), encoded).n3();
                } else {
                    return new wz.t(value2, this.y.i9(type, annotationArr), encoded);
                }
            } else if (annotation instanceof ke1.x4) {
                i9(i, type);
                boolean encoded2 = ((ke1.x4) annotation).encoded();
                Class<?> c53 = i4.c5(type);
                this.f9226f = true;
                if (Iterable.class.isAssignableFrom(c53)) {
                    if (type instanceof ParameterizedType) {
                        return new wz.C0120wz(this.y.i9(i4.s(0, (ParameterizedType) type), annotationArr), encoded2).zn();
                    }
                    throw i4.w(this.f9232n3, i, c53.getSimpleName() + " must include generic type (e.g., " + c53.getSimpleName() + "<String>)", new Object[0]);
                } else if (c53.isArray()) {
                    return new wz.C0120wz(this.y.i9(y(c53.getComponentType()), annotationArr), encoded2).n3();
                } else {
                    return new wz.C0120wz(this.y.i9(type, annotationArr), encoded2);
                }
            } else if (annotation instanceof ke1.r) {
                i9(i, type);
                Class<?> c54 = i4.c5(type);
                this.f9236t = true;
                if (Map.class.isAssignableFrom(c54)) {
                    Type i92 = i4.i9(type, c54, Map.class);
                    if (i92 instanceof ParameterizedType) {
                        ParameterizedType parameterizedType = (ParameterizedType) i92;
                        Type s2 = i4.s(0, parameterizedType);
                        if (String.class == s2) {
                            return new wz.tl(this.f9232n3, i, this.y.i9(i4.s(1, parameterizedType), annotationArr), ((ke1.r) annotation).encoded());
                        }
                        throw i4.w(this.f9232n3, i, "@QueryMap keys must be of type String: " + s2, new Object[0]);
                    }
                    throw i4.w(this.f9232n3, i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                throw i4.w(this.f9232n3, i, "@QueryMap parameter type must be Map.", new Object[0]);
            } else if (annotation instanceof ke1.c5) {
                i9(i, type);
                String value3 = ((ke1.c5) annotation).value();
                Class<?> c55 = i4.c5(type);
                if (Iterable.class.isAssignableFrom(c55)) {
                    if (type instanceof ParameterizedType) {
                        return new wz.a(value3, this.y.i9(i4.s(0, (ParameterizedType) type), annotationArr)).zn();
                    }
                    throw i4.w(this.f9232n3, i, c55.getSimpleName() + " must include generic type (e.g., " + c55.getSimpleName() + "<String>)", new Object[0]);
                } else if (c55.isArray()) {
                    return new wz.a(value3, this.y.i9(y(c55.getComponentType()), annotationArr)).n3();
                } else {
                    return new wz.a(value3, this.y.i9(type, annotationArr));
                }
            } else if (annotation instanceof ke1.i9) {
                if (type == kc1.z.class) {
                    return new wz.s(this.f9232n3, i);
                }
                i9(i, type);
                Class<?> c56 = i4.c5(type);
                if (Map.class.isAssignableFrom(c56)) {
                    Type i93 = i4.i9(type, c56, Map.class);
                    if (i93 instanceof ParameterizedType) {
                        ParameterizedType parameterizedType2 = (ParameterizedType) i93;
                        Type s3 = i4.s(0, parameterizedType2);
                        if (String.class == s3) {
                            return new wz.fb(this.f9232n3, i, this.y.i9(i4.s(1, parameterizedType2), annotationArr));
                        }
                        throw i4.w(this.f9232n3, i, "@HeaderMap keys must be of type String: " + s3, new Object[0]);
                    }
                    throw i4.w(this.f9232n3, i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                throw i4.w(this.f9232n3, i, "@HeaderMap parameter type must be Map.", new Object[0]);
            } else if (annotation instanceof ke1.zn) {
                i9(i, type);
                if (this.f9239w) {
                    ke1.zn znVar = (ke1.zn) annotation;
                    String value4 = znVar.value();
                    boolean encoded3 = znVar.encoded();
                    this.f9223a = true;
                    Class<?> c57 = i4.c5(type);
                    if (Iterable.class.isAssignableFrom(c57)) {
                        if (type instanceof ParameterizedType) {
                            return new wz.gv(value4, this.y.i9(i4.s(0, (ParameterizedType) type), annotationArr), encoded3).zn();
                        }
                        throw i4.w(this.f9232n3, i, c57.getSimpleName() + " must include generic type (e.g., " + c57.getSimpleName() + "<String>)", new Object[0]);
                    } else if (c57.isArray()) {
                        return new wz.gv(value4, this.y.i9(y(c57.getComponentType()), annotationArr), encoded3).n3();
                    } else {
                        return new wz.gv(value4, this.y.i9(type, annotationArr), encoded3);
                    }
                }
                throw i4.w(this.f9232n3, i, "@Field parameters can only be used with form encoding.", new Object[0]);
            } else if (annotation instanceof ke1.gv) {
                i9(i, type);
                if (this.f9239w) {
                    Class<?> c58 = i4.c5(type);
                    if (Map.class.isAssignableFrom(c58)) {
                        Type i94 = i4.i9(type, c58, Map.class);
                        if (i94 instanceof ParameterizedType) {
                            ParameterizedType parameterizedType3 = (ParameterizedType) i94;
                            Type s4 = i4.s(0, parameterizedType3);
                            if (String.class == s4) {
                                a i95 = this.y.i9(i4.s(1, parameterizedType3), annotationArr);
                                this.f9223a = true;
                                return new wz.v(this.f9232n3, i, i95, ((ke1.gv) annotation).encoded());
                            }
                            throw i4.w(this.f9232n3, i, "@FieldMap keys must be of type String: " + s4, new Object[0]);
                        }
                        throw i4.w(this.f9232n3, i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    throw i4.w(this.f9232n3, i, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                throw i4.w(this.f9232n3, i, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
            } else if (annotation instanceof ke1.p) {
                i9(i, type);
                if (this.f9233p) {
                    ke1.p pVar = (ke1.p) annotation;
                    this.f9227fb = true;
                    String value5 = pVar.value();
                    Class<?> c59 = i4.c5(type);
                    if (value5.isEmpty()) {
                        if (Iterable.class.isAssignableFrom(c59)) {
                            if (type instanceof ParameterizedType) {
                                if (f3.zn.class.isAssignableFrom(i4.c5(i4.s(0, (ParameterizedType) type)))) {
                                    return wz.xc.y.zn();
                                }
                                throw i4.w(this.f9232n3, i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                            }
                            throw i4.w(this.f9232n3, i, c59.getSimpleName() + " must include generic type (e.g., " + c59.getSimpleName() + "<String>)", new Object[0]);
                        } else if (c59.isArray()) {
                            if (f3.zn.class.isAssignableFrom(c59.getComponentType())) {
                                return wz.xc.y.n3();
                            }
                            throw i4.w(this.f9232n3, i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        } else if (f3.zn.class.isAssignableFrom(c59)) {
                            return wz.xc.y;
                        } else {
                            throw i4.w(this.f9232n3, i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        }
                    }
                    kc1.z a2 = kc1.z.a("Content-Disposition", "form-data; name=\"" + value5 + "\"", "Content-Transfer-Encoding", pVar.encoding());
                    if (Iterable.class.isAssignableFrom(c59)) {
                        if (type instanceof ParameterizedType) {
                            Type s5 = i4.s(0, (ParameterizedType) type);
                            if (!f3.zn.class.isAssignableFrom(i4.c5(s5))) {
                                return new wz.c5(this.f9232n3, i, a2, this.y.s(s5, annotationArr, this.f9244zn)).zn();
                            }
                            throw i4.w(this.f9232n3, i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                        }
                        throw i4.w(this.f9232n3, i, c59.getSimpleName() + " must include generic type (e.g., " + c59.getSimpleName() + "<String>)", new Object[0]);
                    } else if (c59.isArray()) {
                        Class<?> y = y(c59.getComponentType());
                        if (!f3.zn.class.isAssignableFrom(y)) {
                            return new wz.c5(this.f9232n3, i, a2, this.y.s(y, annotationArr, this.f9244zn)).n3();
                        }
                        throw i4.w(this.f9232n3, i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    } else if (!f3.zn.class.isAssignableFrom(c59)) {
                        return new wz.c5(this.f9232n3, i, a2, this.y.s(type, annotationArr, this.f9244zn));
                    } else {
                        throw i4.w(this.f9232n3, i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                }
                throw i4.w(this.f9232n3, i, "@Part parameters can only be used with multipart encoding.", new Object[0]);
            } else if (annotation instanceof ke1.mt) {
                i9(i, type);
                if (this.f9233p) {
                    this.f9227fb = true;
                    Class<?> c510 = i4.c5(type);
                    if (Map.class.isAssignableFrom(c510)) {
                        Type i96 = i4.i9(type, c510, Map.class);
                        if (i96 instanceof ParameterizedType) {
                            ParameterizedType parameterizedType4 = (ParameterizedType) i96;
                            Type s7 = i4.s(0, parameterizedType4);
                            if (String.class == s7) {
                                Type s9 = i4.s(1, parameterizedType4);
                                if (!f3.zn.class.isAssignableFrom(i4.c5(s9))) {
                                    return new wz.i9(this.f9232n3, i, this.y.s(s9, annotationArr, this.f9244zn), ((ke1.mt) annotation).encoding());
                                }
                                throw i4.w(this.f9232n3, i, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                            }
                            throw i4.w(this.f9232n3, i, "@PartMap keys must be of type String: " + s7, new Object[0]);
                        }
                        throw i4.w(this.f9232n3, i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    throw i4.w(this.f9232n3, i, "@PartMap parameter type must be Map.", new Object[0]);
                }
                throw i4.w(this.f9232n3, i, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
            } else if (annotation instanceof ke1.y) {
                i9(i, type);
                if (!this.f9239w && !this.f9233p) {
                    if (!this.f9235s) {
                        try {
                            a s10 = this.y.s(type, annotationArr, this.f9244zn);
                            this.f9235s = true;
                            return new wz.zn(this.f9232n3, i, s10);
                        } catch (RuntimeException e2) {
                            throw i4.p(this.f9232n3, e2, i, "Unable to create @Body converter for %s", type);
                        }
                    }
                    throw i4.w(this.f9232n3, i, "Multiple @Body method annotations found.", new Object[0]);
                }
                throw i4.w(this.f9232n3, i, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
            } else if (annotation instanceof ke1.f3) {
                i9(i, type);
                Class<?> c511 = i4.c5(type);
                for (int i5 = i - 1; i5 >= 0; i5--) {
                    wz<?> wzVar = this.f9241x4[i5];
                    if ((wzVar instanceof wz.p) && ((wz.p) wzVar).y.equals(c511)) {
                        throw i4.w(this.f9232n3, i, "@Tag type " + c511.getName() + " is duplicate of parameter #" + (i5 + 1) + " and would always overwrite its value.", new Object[0]);
                    }
                }
                return new wz.p(c511);
            } else {
                return null;
            }
        }

        public final void gv(String str, String str2, boolean z2) {
            String str3 = this.f9240wz;
            if (str3 == null) {
                this.f9240wz = str;
                this.f9242xc = z2;
                if (str2.isEmpty()) {
                    return;
                }
                int indexOf = str2.indexOf(63);
                if (indexOf != -1 && indexOf < str2.length() - 1) {
                    String substring = str2.substring(indexOf + 1);
                    if (f9221f3.matcher(substring).find()) {
                        throw i4.wz(this.f9232n3, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", substring);
                    }
                }
                this.f9231mt = str2;
                this.f9234r = s(str2);
                return;
            }
            throw i4.wz(this.f9232n3, "Only one HTTP method is allowed. Found: %s and %s.", str3, str);
        }

        public final void i9(int i, Type type) {
            if (!i4.f(type)) {
                return;
            }
            throw i4.w(this.f9232n3, i, "Parameter type must not include a type variable or wildcard: %s", type);
        }

        public p n3() {
            boolean z2;
            for (Annotation annotation : this.f9244zn) {
                v(annotation);
            }
            if (this.f9240wz != null) {
                if (!this.f9242xc) {
                    if (!this.f9233p) {
                        if (this.f9239w) {
                            throw i4.wz(this.f9232n3, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                        }
                    } else {
                        throw i4.wz(this.f9232n3, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    }
                }
                int length = this.f9228gv.length;
                this.f9241x4 = new wz[length];
                int i = length - 1;
                for (int i5 = 0; i5 < length; i5++) {
                    wz<?>[] wzVarArr = this.f9241x4;
                    Type type = this.f9238v[i5];
                    Annotation[] annotationArr = this.f9228gv[i5];
                    if (i5 == i) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    wzVarArr[i5] = a(i5, type, annotationArr, z2);
                }
                if (this.f9231mt == null && !this.f9237tl) {
                    throw i4.wz(this.f9232n3, "Missing either @%s URL or @Url parameter.", this.f9240wz);
                }
                boolean z3 = this.f9239w;
                if (!z3 && !this.f9233p && !this.f9242xc && this.f9235s) {
                    throw i4.wz(this.f9232n3, "Non-body HTTP method cannot contain @Body.", new Object[0]);
                }
                if (z3 && !this.f9223a) {
                    throw i4.wz(this.f9232n3, "Form-encoded method must contain at least one @Field.", new Object[0]);
                }
                if (this.f9233p && !this.f9227fb) {
                    throw i4.wz(this.f9232n3, "Multipart method must contain at least one @Part.", new Object[0]);
                }
                return new p(this);
            }
            throw i4.wz(this.f9232n3, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
        }

        public final void v(Annotation annotation) {
            if (annotation instanceof ke1.n3) {
                gv("DELETE", ((ke1.n3) annotation).value(), false);
            } else if (annotation instanceof ke1.a) {
                gv("GET", ((ke1.a) annotation).value(), false);
            } else if (annotation instanceof ke1.fb) {
                gv("HEAD", ((ke1.fb) annotation).value(), false);
            } else if (annotation instanceof ke1.wz) {
                gv("PATCH", ((ke1.wz) annotation).value(), true);
            } else if (annotation instanceof ke1.xc) {
                gv("POST", ((ke1.xc) annotation).value(), true);
            } else if (annotation instanceof ke1.w) {
                gv("PUT", ((ke1.w) annotation).value(), true);
            } else if (annotation instanceof ke1.tl) {
                gv("OPTIONS", ((ke1.tl) annotation).value(), false);
            } else if (annotation instanceof ke1.s) {
                ke1.s sVar = (ke1.s) annotation;
                gv(sVar.method(), sVar.path(), sVar.hasBody());
            } else if (annotation instanceof ke1.f) {
                String[] value = ((ke1.f) annotation).value();
                if (value.length != 0) {
                    this.f9225co = zn(value);
                    return;
                }
                throw i4.wz(this.f9232n3, "@Headers annotation is empty.", new Object[0]);
            } else if (annotation instanceof ke1.t) {
                if (!this.f9239w) {
                    this.f9233p = true;
                    return;
                }
                throw i4.wz(this.f9232n3, "Only one encoding annotation is allowed.", new Object[0]);
            } else if (annotation instanceof ke1.v) {
                if (!this.f9233p) {
                    this.f9239w = true;
                    return;
                }
                throw i4.wz(this.f9232n3, "Only one encoding annotation is allowed.", new Object[0]);
            }
        }

        public final kc1.z zn(String[] strArr) {
            z.y yVar = new z.y();
            for (String str : strArr) {
                int indexOf = str.indexOf(58);
                if (indexOf != -1 && indexOf != 0 && indexOf != str.length() - 1) {
                    String substring = str.substring(0, indexOf);
                    String trim = str.substring(indexOf + 1).trim();
                    if ("Content-Type".equalsIgnoreCase(substring)) {
                        try {
                            this.f9243z = kc1.i4.v(trim);
                        } catch (IllegalArgumentException e2) {
                            throw i4.xc(this.f9232n3, e2, "Malformed content type: %s", trim);
                        }
                    } else {
                        yVar.y(substring, trim);
                    }
                } else {
                    throw i4.wz(this.f9232n3, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
            }
            return yVar.a();
        }
    }

    public p(y yVar) {
        this.y = yVar.f9232n3;
        this.f9217n3 = yVar.y.f9188zn;
        this.f9220zn = yVar.f9240wz;
        this.f9215gv = yVar.f9231mt;
        this.f9219v = yVar.f9225co;
        this.f9211a = yVar.f9243z;
        this.f9214fb = yVar.f9242xc;
        this.f9218s = yVar.f9239w;
        this.f9212c5 = yVar.f9233p;
        this.f9216i9 = yVar.f9241x4;
        this.f9213f = yVar.f9229i4;
    }

    public static p n3(co coVar, Method method) {
        return new y(coVar, method).n3();
    }

    public d0 y(Object[] objArr) throws IOException {
        wz<?>[] wzVarArr = this.f9216i9;
        int length = objArr.length;
        if (length == wzVarArr.length) {
            w wVar = new w(this.f9220zn, this.f9217n3, this.f9215gv, this.f9219v, this.f9211a, this.f9214fb, this.f9218s, this.f9212c5);
            if (this.f9213f) {
                length--;
            }
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(objArr[i]);
                wzVarArr[i].y(wVar, objArr[i]);
            }
            return wVar.f().wz(i9.class, new i9(this.y, arrayList)).n3();
        }
        throw new IllegalArgumentException("Argument count (" + length + ") doesn't match expected count (" + wzVarArr.length + ")");
    }
}
