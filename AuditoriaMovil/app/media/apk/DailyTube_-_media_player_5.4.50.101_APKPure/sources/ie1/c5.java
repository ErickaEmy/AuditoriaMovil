package ie1;

import ie1.i4;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kc1.mg;
import kc1.rz;
import kc1.v;
import kotlin.coroutines.Continuation;
/* loaded from: classes.dex */
public abstract class c5<ResponseT, ReturnT> extends z<ReturnT> {

    /* renamed from: n3  reason: collision with root package name */
    public final v.y f9177n3;
    public final p y;

    /* renamed from: zn  reason: collision with root package name */
    public final a<mg, ResponseT> f9178zn;

    /* loaded from: classes.dex */
    public static final class n3<ResponseT> extends c5<ResponseT, Object> {

        /* renamed from: gv  reason: collision with root package name */
        public final ie1.zn<ResponseT, ie1.n3<ResponseT>> f9179gv;

        /* renamed from: v  reason: collision with root package name */
        public final boolean f9180v;

        public n3(p pVar, v.y yVar, a<mg, ResponseT> aVar, ie1.zn<ResponseT, ie1.n3<ResponseT>> znVar, boolean z2) {
            super(pVar, yVar, aVar);
            this.f9179gv = znVar;
            this.f9180v = z2;
        }

        @Override // ie1.c5
        public Object zn(ie1.n3<ResponseT> n3Var, Object[] objArr) {
            ie1.n3<ResponseT> n32 = this.f9179gv.n3(n3Var);
            Continuation continuation = (Continuation) objArr[objArr.length - 1];
            try {
                if (this.f9180v) {
                    return f.n3(n32, continuation);
                }
                return f.y(n32, continuation);
            } catch (Exception e2) {
                return f.gv(e2, continuation);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class y<ResponseT, ReturnT> extends c5<ResponseT, ReturnT> {

        /* renamed from: gv  reason: collision with root package name */
        public final ie1.zn<ResponseT, ReturnT> f9181gv;

        public y(p pVar, v.y yVar, a<mg, ResponseT> aVar, ie1.zn<ResponseT, ReturnT> znVar) {
            super(pVar, yVar, aVar);
            this.f9181gv = znVar;
        }

        @Override // ie1.c5
        public ReturnT zn(ie1.n3<ResponseT> n3Var, Object[] objArr) {
            return this.f9181gv.n3(n3Var);
        }
    }

    /* loaded from: classes.dex */
    public static final class zn<ResponseT> extends c5<ResponseT, Object> {

        /* renamed from: gv  reason: collision with root package name */
        public final ie1.zn<ResponseT, ie1.n3<ResponseT>> f9182gv;

        public zn(p pVar, v.y yVar, a<mg, ResponseT> aVar, ie1.zn<ResponseT, ie1.n3<ResponseT>> znVar) {
            super(pVar, yVar, aVar);
            this.f9182gv = znVar;
        }

        @Override // ie1.c5
        public Object zn(ie1.n3<ResponseT> n3Var, Object[] objArr) {
            ie1.n3<ResponseT> n32 = this.f9182gv.n3(n3Var);
            Continuation continuation = (Continuation) objArr[objArr.length - 1];
            try {
                return f.zn(n32, continuation);
            } catch (Exception e2) {
                return f.gv(e2, continuation);
            }
        }
    }

    public c5(p pVar, v.y yVar, a<mg, ResponseT> aVar) {
        this.y = pVar;
        this.f9177n3 = yVar;
        this.f9178zn = aVar;
    }

    public static <ResponseT, ReturnT> c5<ResponseT, ReturnT> a(co coVar, Method method, p pVar) {
        Type genericReturnType;
        boolean z2;
        boolean z3 = pVar.f9213f;
        Annotation[] annotations = method.getAnnotations();
        if (z3) {
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            Type fb2 = i4.fb(0, (ParameterizedType) genericParameterTypes[genericParameterTypes.length - 1]);
            if (i4.c5(fb2) == mt.class && (fb2 instanceof ParameterizedType)) {
                fb2 = i4.s(0, (ParameterizedType) fb2);
                z2 = true;
            } else {
                z2 = false;
            }
            genericReturnType = new i4.n3(null, ie1.n3.class, fb2);
            annotations = x4.y(annotations);
        } else {
            genericReturnType = method.getGenericReturnType();
            z2 = false;
        }
        ie1.zn gv2 = gv(coVar, method, genericReturnType, annotations);
        Type y2 = gv2.y();
        if (y2 != rz.class) {
            if (y2 != mt.class) {
                if (pVar.f9220zn.equals("HEAD") && !Void.class.equals(y2)) {
                    throw i4.wz(method, "HEAD method must use Void as response type.", new Object[0]);
                }
                a v2 = v(coVar, method, y2);
                v.y yVar = coVar.f9186n3;
                if (!z3) {
                    return new y(pVar, yVar, v2, gv2);
                }
                if (z2) {
                    return new zn(pVar, yVar, v2, gv2);
                }
                return new n3(pVar, yVar, v2, gv2, false);
            }
            throw i4.wz(method, "Response must include generic type (e.g., Response<String>)", new Object[0]);
        }
        throw i4.wz(method, "'" + i4.c5(y2).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
    }

    public static <ResponseT, ReturnT> ie1.zn<ResponseT, ReturnT> gv(co coVar, Method method, Type type, Annotation[] annotationArr) {
        try {
            return (ie1.zn<ResponseT, ReturnT>) coVar.y(type, annotationArr);
        } catch (RuntimeException e2) {
            throw i4.xc(method, e2, "Unable to create call adapter for %s", type);
        }
    }

    public static <ResponseT> a<mg, ResponseT> v(co coVar, Method method, Type type) {
        try {
            return coVar.c5(type, method.getAnnotations());
        } catch (RuntimeException e2) {
            throw i4.xc(method, e2, "Unable to create converter for %s", type);
        }
    }

    @Override // ie1.z
    public final ReturnT y(Object[] objArr) {
        return zn(new t(this.y, objArr, this.f9177n3, this.f9178zn), objArr);
    }

    public abstract ReturnT zn(ie1.n3<ResponseT> n3Var, Object[] objArr);
}
