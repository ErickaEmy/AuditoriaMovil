package ie1;

import ie1.a;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import kc1.mg;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
@IgnoreJRERequirement
/* loaded from: classes.dex */
public final class tl extends a.y {
    public static final a.y y = new tl();

    @IgnoreJRERequirement
    /* loaded from: classes.dex */
    public static final class y<T> implements a<mg, Optional<T>> {
        public final a<mg, T> y;

        public y(a<mg, T> aVar) {
            this.y = aVar;
        }

        @Override // ie1.a
        /* renamed from: y */
        public Optional<T> convert(mg mgVar) throws IOException {
            return Optional.ofNullable(this.y.convert(mgVar));
        }
    }

    @Override // ie1.a.y
    public a<mg, ?> gv(Type type, Annotation[] annotationArr, co coVar) {
        if (a.y.n3(type) != Optional.class) {
            return null;
        }
        return new y(coVar.c5(a.y.y(0, (ParameterizedType) type), annotationArr));
    }
}
