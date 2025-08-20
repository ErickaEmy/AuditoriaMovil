package je1;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ie1.a;
import ie1.co;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kc1.fh;
import kc1.mg;
/* loaded from: classes.dex */
public final class y extends a.y {
    public final Gson y;

    public y(Gson gson) {
        this.y = gson;
    }

    public static y a() {
        return fb(new Gson());
    }

    public static y fb(Gson gson) {
        if (gson != null) {
            return new y(gson);
        }
        throw new NullPointerException("gson == null");
    }

    @Override // ie1.a.y
    public a<mg, ?> gv(Type type, Annotation[] annotationArr, co coVar) {
        return new zn(this.y, this.y.getAdapter(TypeToken.get(type)));
    }

    @Override // ie1.a.y
    public a<?, fh> zn(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, co coVar) {
        return new n3(this.y, this.y.getAdapter(TypeToken.get(type)));
    }
}
