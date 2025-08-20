package ie1;

import ie1.a;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kc1.fh;
import kc1.mg;
import kotlin.Unit;
/* loaded from: classes.dex */
public final class y extends a.y {
    public boolean y = true;

    /* loaded from: classes.dex */
    public static final class a implements ie1.a<mg, Void> {
        public static final a y = new a();

        @Override // ie1.a
        /* renamed from: y */
        public Void convert(mg mgVar) {
            mgVar.close();
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static final class gv implements ie1.a<Object, String> {
        public static final gv y = new gv();

        @Override // ie1.a
        /* renamed from: y */
        public String convert(Object obj) {
            return obj.toString();
        }
    }

    /* loaded from: classes.dex */
    public static final class v implements ie1.a<mg, Unit> {
        public static final v y = new v();

        @Override // ie1.a
        /* renamed from: y */
        public Unit convert(mg mgVar) {
            mgVar.close();
            return Unit.INSTANCE;
        }
    }

    /* renamed from: ie1.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0122y implements ie1.a<mg, mg> {
        public static final C0122y y = new C0122y();

        @Override // ie1.a
        /* renamed from: y */
        public mg convert(mg mgVar) throws IOException {
            try {
                return i4.y(mgVar);
            } finally {
                mgVar.close();
            }
        }
    }

    @Override // ie1.a.y
    public ie1.a<mg, ?> gv(Type type, Annotation[] annotationArr, co coVar) {
        if (type == mg.class) {
            if (i4.tl(annotationArr, ke1.i4.class)) {
                return zn.y;
            }
            return C0122y.y;
        } else if (type == Void.class) {
            return a.y;
        } else {
            if (this.y && type == Unit.class) {
                try {
                    return v.y;
                } catch (NoClassDefFoundError unused) {
                    this.y = false;
                    return null;
                }
            }
            return null;
        }
    }

    @Override // ie1.a.y
    public ie1.a<?, fh> zn(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, co coVar) {
        if (fh.class.isAssignableFrom(i4.c5(type))) {
            return n3.y;
        }
        return null;
    }

    /* loaded from: classes.dex */
    public static final class n3 implements ie1.a<fh, fh> {
        public static final n3 y = new n3();

        @Override // ie1.a
        /* renamed from: y */
        public fh convert(fh fhVar) {
            return fhVar;
        }
    }

    /* loaded from: classes.dex */
    public static final class zn implements ie1.a<mg, mg> {
        public static final zn y = new zn();

        @Override // ie1.a
        /* renamed from: y */
        public mg convert(mg mgVar) {
            return mgVar;
        }
    }
}
