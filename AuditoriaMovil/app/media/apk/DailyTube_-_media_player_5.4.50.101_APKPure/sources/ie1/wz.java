package ie1;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Map;
import kc1.f3;
import kc1.fh;
/* loaded from: classes.dex */
public abstract class wz<T> {

    /* loaded from: classes.dex */
    public static final class a<T> extends wz<T> {

        /* renamed from: n3  reason: collision with root package name */
        public final ie1.a<T, String> f9273n3;
        public final String y;

        public a(String str, ie1.a<T, String> aVar) {
            this.y = (String) i4.n3(str, "name == null");
            this.f9273n3 = aVar;
        }

        @Override // ie1.wz
        public void y(ie1.w wVar, T t2) throws IOException {
            String convert;
            if (t2 == null || (convert = this.f9273n3.convert(t2)) == null) {
                return;
            }
            wVar.n3(this.y, convert);
        }
    }

    /* loaded from: classes.dex */
    public static final class c5<T> extends wz<T> {

        /* renamed from: gv  reason: collision with root package name */
        public final ie1.a<T, fh> f9274gv;

        /* renamed from: n3  reason: collision with root package name */
        public final int f9275n3;
        public final Method y;

        /* renamed from: zn  reason: collision with root package name */
        public final kc1.z f9276zn;

        public c5(Method method, int i, kc1.z zVar, ie1.a<T, fh> aVar) {
            this.y = method;
            this.f9275n3 = i;
            this.f9276zn = zVar;
            this.f9274gv = aVar;
        }

        @Override // ie1.wz
        public void y(ie1.w wVar, T t2) {
            if (t2 == null) {
                return;
            }
            try {
                wVar.gv(this.f9276zn, this.f9274gv.convert(t2));
            } catch (IOException e2) {
                Method method = this.y;
                int i = this.f9275n3;
                throw i4.w(method, i, "Unable to convert " + t2 + " to RequestBody", e2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class f<T> extends wz<T> {

        /* renamed from: gv  reason: collision with root package name */
        public final ie1.a<T, String> f9277gv;

        /* renamed from: n3  reason: collision with root package name */
        public final int f9278n3;

        /* renamed from: v  reason: collision with root package name */
        public final boolean f9279v;
        public final Method y;

        /* renamed from: zn  reason: collision with root package name */
        public final String f9280zn;

        public f(Method method, int i, String str, ie1.a<T, String> aVar, boolean z2) {
            this.y = method;
            this.f9278n3 = i;
            this.f9280zn = (String) i4.n3(str, "name == null");
            this.f9277gv = aVar;
            this.f9279v = z2;
        }

        @Override // ie1.wz
        public void y(ie1.w wVar, T t2) throws IOException {
            if (t2 != null) {
                wVar.a(this.f9280zn, this.f9277gv.convert(t2), this.f9279v);
                return;
            }
            Method method = this.y;
            int i = this.f9278n3;
            throw i4.w(method, i, "Path parameter \"" + this.f9280zn + "\" value must not be null.", new Object[0]);
        }
    }

    /* loaded from: classes.dex */
    public static final class fb<T> extends wz<Map<String, T>> {

        /* renamed from: n3  reason: collision with root package name */
        public final int f9281n3;
        public final Method y;

        /* renamed from: zn  reason: collision with root package name */
        public final ie1.a<T, String> f9282zn;

        public fb(Method method, int i, ie1.a<T, String> aVar) {
            this.y = method;
            this.f9281n3 = i;
            this.f9282zn = aVar;
        }

        @Override // ie1.wz
        /* renamed from: gv */
        public void y(ie1.w wVar, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value != null) {
                            wVar.n3(key, this.f9282zn.convert(value));
                        } else {
                            Method method = this.y;
                            int i = this.f9281n3;
                            throw i4.w(method, i, "Header map contained null value for key '" + key + "'.", new Object[0]);
                        }
                    } else {
                        throw i4.w(this.y, this.f9281n3, "Header map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw i4.w(this.y, this.f9281n3, "Header map was null.", new Object[0]);
        }
    }

    /* loaded from: classes.dex */
    public static final class gv<T> extends wz<T> {

        /* renamed from: n3  reason: collision with root package name */
        public final ie1.a<T, String> f9283n3;
        public final String y;

        /* renamed from: zn  reason: collision with root package name */
        public final boolean f9284zn;

        public gv(String str, ie1.a<T, String> aVar, boolean z2) {
            this.y = (String) i4.n3(str, "name == null");
            this.f9283n3 = aVar;
            this.f9284zn = z2;
        }

        @Override // ie1.wz
        public void y(ie1.w wVar, T t2) throws IOException {
            String convert;
            if (t2 == null || (convert = this.f9283n3.convert(t2)) == null) {
                return;
            }
            wVar.y(this.y, convert, this.f9284zn);
        }
    }

    /* loaded from: classes.dex */
    public static final class i9<T> extends wz<Map<String, T>> {

        /* renamed from: gv  reason: collision with root package name */
        public final String f9285gv;

        /* renamed from: n3  reason: collision with root package name */
        public final int f9286n3;
        public final Method y;

        /* renamed from: zn  reason: collision with root package name */
        public final ie1.a<T, fh> f9287zn;

        public i9(Method method, int i, ie1.a<T, fh> aVar, String str) {
            this.y = method;
            this.f9286n3 = i;
            this.f9287zn = aVar;
            this.f9285gv = str;
        }

        @Override // ie1.wz
        /* renamed from: gv */
        public void y(ie1.w wVar, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value != null) {
                            wVar.gv(kc1.z.a("Content-Disposition", "form-data; name=\"" + key + "\"", "Content-Transfer-Encoding", this.f9285gv), this.f9287zn.convert(value));
                        } else {
                            Method method = this.y;
                            int i = this.f9286n3;
                            throw i4.w(method, i, "Part map contained null value for key '" + key + "'.", new Object[0]);
                        }
                    } else {
                        throw i4.w(this.y, this.f9286n3, "Part map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw i4.w(this.y, this.f9286n3, "Part map was null.", new Object[0]);
        }
    }

    /* loaded from: classes.dex */
    public class n3 extends wz<Object> {
        public n3() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ie1.wz
        public void y(ie1.w wVar, Object obj) throws IOException {
            if (obj == null) {
                return;
            }
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                wz.this.y(wVar, Array.get(obj, i));
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class p<T> extends wz<T> {
        public final Class<T> y;

        public p(Class<T> cls) {
            this.y = cls;
        }

        @Override // ie1.wz
        public void y(ie1.w wVar, T t2) {
            wVar.s(this.y, t2);
        }
    }

    /* loaded from: classes.dex */
    public static final class s extends wz<kc1.z> {

        /* renamed from: n3  reason: collision with root package name */
        public final int f9288n3;
        public final Method y;

        public s(Method method, int i) {
            this.y = method;
            this.f9288n3 = i;
        }

        @Override // ie1.wz
        /* renamed from: gv */
        public void y(ie1.w wVar, kc1.z zVar) {
            if (zVar != null) {
                wVar.zn(zVar);
                return;
            }
            throw i4.w(this.y, this.f9288n3, "Headers parameter must not be null.", new Object[0]);
        }
    }

    /* loaded from: classes.dex */
    public static final class t<T> extends wz<T> {

        /* renamed from: n3  reason: collision with root package name */
        public final ie1.a<T, String> f9289n3;
        public final String y;

        /* renamed from: zn  reason: collision with root package name */
        public final boolean f9290zn;

        public t(String str, ie1.a<T, String> aVar, boolean z2) {
            this.y = (String) i4.n3(str, "name == null");
            this.f9289n3 = aVar;
            this.f9290zn = z2;
        }

        @Override // ie1.wz
        public void y(ie1.w wVar, T t2) throws IOException {
            String convert;
            if (t2 == null || (convert = this.f9289n3.convert(t2)) == null) {
                return;
            }
            wVar.fb(this.y, convert, this.f9290zn);
        }
    }

    /* loaded from: classes.dex */
    public static final class tl<T> extends wz<Map<String, T>> {

        /* renamed from: gv  reason: collision with root package name */
        public final boolean f9291gv;

        /* renamed from: n3  reason: collision with root package name */
        public final int f9292n3;
        public final Method y;

        /* renamed from: zn  reason: collision with root package name */
        public final ie1.a<T, String> f9293zn;

        public tl(Method method, int i, ie1.a<T, String> aVar, boolean z2) {
            this.y = method;
            this.f9292n3 = i;
            this.f9293zn = aVar;
            this.f9291gv = z2;
        }

        @Override // ie1.wz
        /* renamed from: gv */
        public void y(ie1.w wVar, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value != null) {
                            String convert = this.f9293zn.convert(value);
                            if (convert != null) {
                                wVar.fb(key, convert, this.f9291gv);
                            } else {
                                Method method = this.y;
                                int i = this.f9292n3;
                                throw i4.w(method, i, "Query map value '" + value + "' converted to null by " + this.f9293zn.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                            }
                        } else {
                            Method method2 = this.y;
                            int i5 = this.f9292n3;
                            throw i4.w(method2, i5, "Query map contained null value for key '" + key + "'.", new Object[0]);
                        }
                    } else {
                        throw i4.w(this.y, this.f9292n3, "Query map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw i4.w(this.y, this.f9292n3, "Query map was null", new Object[0]);
        }
    }

    /* loaded from: classes.dex */
    public static final class v<T> extends wz<Map<String, T>> {

        /* renamed from: gv  reason: collision with root package name */
        public final boolean f9294gv;

        /* renamed from: n3  reason: collision with root package name */
        public final int f9295n3;
        public final Method y;

        /* renamed from: zn  reason: collision with root package name */
        public final ie1.a<T, String> f9296zn;

        public v(Method method, int i, ie1.a<T, String> aVar, boolean z2) {
            this.y = method;
            this.f9295n3 = i;
            this.f9296zn = aVar;
            this.f9294gv = z2;
        }

        @Override // ie1.wz
        /* renamed from: gv */
        public void y(ie1.w wVar, Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value != null) {
                            String convert = this.f9296zn.convert(value);
                            if (convert != null) {
                                wVar.y(key, convert, this.f9294gv);
                            } else {
                                Method method = this.y;
                                int i = this.f9295n3;
                                throw i4.w(method, i, "Field map value '" + value + "' converted to null by " + this.f9296zn.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                            }
                        } else {
                            Method method2 = this.y;
                            int i5 = this.f9295n3;
                            throw i4.w(method2, i5, "Field map contained null value for key '" + key + "'.", new Object[0]);
                        }
                    } else {
                        throw i4.w(this.y, this.f9295n3, "Field map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw i4.w(this.y, this.f9295n3, "Field map was null.", new Object[0]);
        }
    }

    /* loaded from: classes.dex */
    public static final class w extends wz<Object> {

        /* renamed from: n3  reason: collision with root package name */
        public final int f9297n3;
        public final Method y;

        public w(Method method, int i) {
            this.y = method;
            this.f9297n3 = i;
        }

        @Override // ie1.wz
        public void y(ie1.w wVar, Object obj) {
            if (obj != null) {
                wVar.tl(obj);
                return;
            }
            throw i4.w(this.y, this.f9297n3, "@Url parameter is null.", new Object[0]);
        }
    }

    /* renamed from: ie1.wz$wz  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0120wz<T> extends wz<T> {

        /* renamed from: n3  reason: collision with root package name */
        public final boolean f9298n3;
        public final ie1.a<T, String> y;

        public C0120wz(ie1.a<T, String> aVar, boolean z2) {
            this.y = aVar;
            this.f9298n3 = z2;
        }

        @Override // ie1.wz
        public void y(ie1.w wVar, T t2) throws IOException {
            if (t2 == null) {
                return;
            }
            wVar.fb(this.y.convert(t2), null, this.f9298n3);
        }
    }

    /* loaded from: classes.dex */
    public static final class xc extends wz<f3.zn> {
        public static final xc y = new xc();

        @Override // ie1.wz
        /* renamed from: gv */
        public void y(ie1.w wVar, f3.zn znVar) {
            if (znVar != null) {
                wVar.v(znVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class y extends wz<Iterable<T>> {
        public y() {
        }

        @Override // ie1.wz
        /* renamed from: gv */
        public void y(ie1.w wVar, Iterable<T> iterable) throws IOException {
            if (iterable == null) {
                return;
            }
            for (T t2 : iterable) {
                wz.this.y(wVar, t2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class zn<T> extends wz<T> {

        /* renamed from: n3  reason: collision with root package name */
        public final int f9299n3;
        public final Method y;

        /* renamed from: zn  reason: collision with root package name */
        public final ie1.a<T, fh> f9300zn;

        public zn(Method method, int i, ie1.a<T, fh> aVar) {
            this.y = method;
            this.f9299n3 = i;
            this.f9300zn = aVar;
        }

        @Override // ie1.wz
        public void y(ie1.w wVar, T t2) {
            if (t2 != null) {
                try {
                    wVar.t(this.f9300zn.convert(t2));
                    return;
                } catch (IOException e2) {
                    Method method = this.y;
                    int i = this.f9299n3;
                    throw i4.p(method, e2, i, "Unable to convert " + t2 + " to RequestBody", new Object[0]);
                }
            }
            throw i4.w(this.y, this.f9299n3, "Body parameter value must not be null.", new Object[0]);
        }
    }

    public final wz<Object> n3() {
        return new n3();
    }

    public abstract void y(ie1.w wVar, T t2) throws IOException;

    public final wz<Iterable<T>> zn() {
        return new y();
    }
}
