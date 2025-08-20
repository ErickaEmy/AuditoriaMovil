package o6;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Set;
import o6.f;
/* loaded from: classes.dex */
public abstract class a<T> {

    /* loaded from: classes.dex */
    public interface y {
        a<?> y(Type type, Set<? extends Annotation> set, co coVar);
    }

    public abstract void a(w wVar, T t2) throws IOException;

    public final void fb(zc1.a aVar, T t2) throws IOException {
        a(w.x4(aVar), t2);
    }

    public final a<T> gv() {
        if (this instanceof p6.y) {
            return this;
        }
        return new p6.y(this);
    }

    public abstract T n3(f fVar) throws IOException;

    public final String v(T t2) {
        zc1.v vVar = new zc1.v();
        try {
            fb(vVar, t2);
            return vVar.wf();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public final T y(String str) throws IOException {
        f k52 = f.k5(new zc1.v().ne(str));
        T n32 = n3(k52);
        if (!zn() && k52.yt() != f.n3.END_DOCUMENT) {
            throw new s("JSON document was not fully consumed.");
        }
        return n32;
    }

    public boolean zn() {
        return false;
    }
}
