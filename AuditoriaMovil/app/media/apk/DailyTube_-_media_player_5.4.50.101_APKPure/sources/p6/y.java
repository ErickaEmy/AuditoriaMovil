package p6;

import java.io.IOException;
import o6.a;
import o6.f;
import o6.w;
/* loaded from: classes.dex */
public final class y<T> extends a<T> {
    public final a<T> y;

    public y(a<T> aVar) {
        this.y = aVar;
    }

    @Override // o6.a
    public void a(w wVar, T t2) throws IOException {
        if (t2 == null) {
            wVar.r();
        } else {
            this.y.a(wVar, t2);
        }
    }

    @Override // o6.a
    public T n3(f fVar) throws IOException {
        if (fVar.yt() == f.n3.NULL) {
            return (T) fVar.ud();
        }
        return this.y.n3(fVar);
    }

    public String toString() {
        return this.y + ".nullSafe()";
    }
}
