package ie1;

import ie1.a;
import ie1.y;
import ie1.zn;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import kc1.fh;
import kc1.mg;
import kc1.n;
import kc1.v;
/* loaded from: classes.dex */
public final class co {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f9183a;

    /* renamed from: fb  reason: collision with root package name */
    public final boolean f9184fb;

    /* renamed from: gv  reason: collision with root package name */
    public final List<a.y> f9185gv;

    /* renamed from: n3  reason: collision with root package name */
    public final v.y f9186n3;

    /* renamed from: v  reason: collision with root package name */
    public final List<zn.y> f9187v;
    public final Map<Method, z<?>> y = new ConcurrentHashMap();

    /* renamed from: zn  reason: collision with root package name */
    public final kc1.r f9188zn;

    /* loaded from: classes.dex */
    public class y implements InvocationHandler {

        /* renamed from: zn  reason: collision with root package name */
        public final /* synthetic */ Class f9197zn;
        public final xc y = xc.a();

        /* renamed from: n3  reason: collision with root package name */
        public final Object[] f9196n3 = new Object[0];

        public y(Class cls) {
            this.f9197zn = cls;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (method.getDeclaringClass() == Object.class) {
                return method.invoke(this, objArr);
            }
            if (this.y.s(method)) {
                return this.y.fb(method, this.f9197zn, obj, objArr);
            }
            z<?> gv2 = co.this.gv(method);
            if (objArr == null) {
                objArr = this.f9196n3;
            }
            return gv2.y(objArr);
        }
    }

    public co(v.y yVar, kc1.r rVar, List<a.y> list, List<zn.y> list2, Executor executor, boolean z2) {
        this.f9186n3 = yVar;
        this.f9188zn = rVar;
        this.f9185gv = list;
        this.f9187v = list2;
        this.f9183a = executor;
        this.f9184fb = z2;
    }

    public <T> a<T, fh> a(a.y yVar, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        i4.n3(type, "type == null");
        i4.n3(annotationArr, "parameterAnnotations == null");
        i4.n3(annotationArr2, "methodAnnotations == null");
        int indexOf = this.f9185gv.indexOf(yVar) + 1;
        int size = this.f9185gv.size();
        for (int i = indexOf; i < size; i++) {
            a<T, fh> aVar = (a<T, fh>) this.f9185gv.get(i).zn(type, annotationArr, annotationArr2, this);
            if (aVar != null) {
                return aVar;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate RequestBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (yVar != null) {
            sb.append("  Skipped:");
            for (int i5 = 0; i5 < indexOf; i5++) {
                sb.append("\n   * ");
                sb.append(this.f9185gv.get(i5).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f9185gv.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f9185gv.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> a<mg, T> c5(Type type, Annotation[] annotationArr) {
        return fb(null, type, annotationArr);
    }

    public <T> a<mg, T> fb(a.y yVar, Type type, Annotation[] annotationArr) {
        i4.n3(type, "type == null");
        i4.n3(annotationArr, "annotations == null");
        int indexOf = this.f9185gv.indexOf(yVar) + 1;
        int size = this.f9185gv.size();
        for (int i = indexOf; i < size; i++) {
            a<mg, T> aVar = (a<mg, T>) this.f9185gv.get(i).gv(type, annotationArr, this);
            if (aVar != null) {
                return aVar;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate ResponseBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (yVar != null) {
            sb.append("  Skipped:");
            for (int i5 = 0; i5 < indexOf; i5++) {
                sb.append("\n   * ");
                sb.append(this.f9185gv.get(i5).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f9185gv.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f9185gv.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public z<?> gv(Method method) {
        z<?> zVar;
        z<?> zVar2 = this.y.get(method);
        if (zVar2 != null) {
            return zVar2;
        }
        synchronized (this.y) {
            try {
                zVar = this.y.get(method);
                if (zVar == null) {
                    zVar = z.n3(this, method);
                    this.y.put(method, zVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zVar;
    }

    public <T> a<T, String> i9(Type type, Annotation[] annotationArr) {
        i4.n3(type, "type == null");
        i4.n3(annotationArr, "annotations == null");
        int size = this.f9185gv.size();
        for (int i = 0; i < size; i++) {
            a<T, String> aVar = (a<T, String>) this.f9185gv.get(i).v(type, annotationArr, this);
            if (aVar != null) {
                return aVar;
            }
        }
        return y.gv.y;
    }

    public <T> T n3(Class<T> cls) {
        i4.x4(cls);
        if (this.f9184fb) {
            zn(cls);
        }
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new y(cls));
    }

    public <T> a<T, fh> s(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        return a(null, type, annotationArr, annotationArr2);
    }

    public zn<?, ?> v(zn.y yVar, Type type, Annotation[] annotationArr) {
        i4.n3(type, "returnType == null");
        i4.n3(annotationArr, "annotations == null");
        int indexOf = this.f9187v.indexOf(yVar) + 1;
        int size = this.f9187v.size();
        for (int i = indexOf; i < size; i++) {
            zn<?, ?> y2 = this.f9187v.get(i).y(type, annotationArr, this);
            if (y2 != null) {
                return y2;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate call adapter for ");
        sb.append(type);
        sb.append(".\n");
        if (yVar != null) {
            sb.append("  Skipped:");
            for (int i5 = 0; i5 < indexOf; i5++) {
                sb.append("\n   * ");
                sb.append(this.f9187v.get(i5).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f9187v.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f9187v.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public zn<?, ?> y(Type type, Annotation[] annotationArr) {
        return v(null, type, annotationArr);
    }

    public final void zn(Class<?> cls) {
        Method[] declaredMethods;
        xc a2 = xc.a();
        for (Method method : cls.getDeclaredMethods()) {
            if (!a2.s(method) && !Modifier.isStatic(method.getModifiers())) {
                gv(method);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: a  reason: collision with root package name */
        public Executor f9189a;

        /* renamed from: fb  reason: collision with root package name */
        public boolean f9190fb;

        /* renamed from: gv  reason: collision with root package name */
        public final List<a.y> f9191gv;

        /* renamed from: n3  reason: collision with root package name */
        public v.y f9192n3;

        /* renamed from: v  reason: collision with root package name */
        public final List<zn.y> f9193v;
        public final xc y;

        /* renamed from: zn  reason: collision with root package name */
        public kc1.r f9194zn;

        public n3(xc xcVar) {
            this.f9191gv = new ArrayList();
            this.f9193v = new ArrayList();
            this.y = xcVar;
        }

        public n3 a(n nVar) {
            return v((v.y) i4.n3(nVar, "client == null"));
        }

        public co gv() {
            if (this.f9194zn != null) {
                v.y yVar = this.f9192n3;
                if (yVar == null) {
                    yVar = new n();
                }
                v.y yVar2 = yVar;
                Executor executor = this.f9189a;
                if (executor == null) {
                    executor = this.y.n3();
                }
                Executor executor2 = executor;
                ArrayList arrayList = new ArrayList(this.f9193v);
                arrayList.addAll(this.y.y(executor2));
                ArrayList arrayList2 = new ArrayList(this.f9191gv.size() + 1 + this.y.gv());
                arrayList2.add(new ie1.y());
                arrayList2.addAll(this.f9191gv);
                arrayList2.addAll(this.y.zn());
                return new co(yVar2, this.f9194zn, Collections.unmodifiableList(arrayList2), Collections.unmodifiableList(arrayList), executor2, this.f9190fb);
            }
            throw new IllegalStateException("Base URL required.");
        }

        public n3 n3(String str) {
            i4.n3(str, "baseUrl == null");
            return zn(kc1.r.i9(str));
        }

        public n3 v(v.y yVar) {
            this.f9192n3 = (v.y) i4.n3(yVar, "factory == null");
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public n3 y(a.y yVar) {
            this.f9191gv.add(i4.n3(yVar, "factory == null"));
            return this;
        }

        public n3 zn(kc1.r rVar) {
            i4.n3(rVar, "baseUrl == null");
            List<String> w4 = rVar.w();
            if ("".equals(w4.get(w4.size() - 1))) {
                this.f9194zn = rVar;
                return this;
            }
            throw new IllegalArgumentException("baseUrl must end in /: " + rVar);
        }

        public n3() {
            this(xc.a());
        }
    }
}
