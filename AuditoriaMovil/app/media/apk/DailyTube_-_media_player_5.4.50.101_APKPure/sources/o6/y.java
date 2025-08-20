package o6;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Set;
import o6.a;
/* loaded from: classes.dex */
public final class y extends a<Object> {

    /* renamed from: zn  reason: collision with root package name */
    public static final a.y f12234zn = new C0174y();

    /* renamed from: n3  reason: collision with root package name */
    public final a<Object> f12235n3;
    public final Class<?> y;

    /* renamed from: o6.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0174y implements a.y {
        @Override // o6.a.y
        public a<?> y(Type type, Set<? extends Annotation> set, co coVar) {
            Type y = x4.y(type);
            if (y == null || !set.isEmpty()) {
                return null;
            }
            return new y(x4.fb(y), coVar.gv(y)).gv();
        }
    }

    public y(Class<?> cls, a<Object> aVar) {
        this.y = cls;
        this.f12235n3 = aVar;
    }

    @Override // o6.a
    public void a(w wVar, Object obj) throws IOException {
        wVar.y();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.f12235n3.a(wVar, Array.get(obj, i));
        }
        wVar.p();
    }

    @Override // o6.a
    public Object n3(f fVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        fVar.y();
        while (fVar.mt()) {
            arrayList.add(this.f12235n3.n3(fVar));
        }
        fVar.s();
        Object newInstance = Array.newInstance(this.y, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }

    public String toString() {
        return this.f12235n3 + ".array()";
    }
}
