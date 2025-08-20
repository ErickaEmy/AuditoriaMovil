package o6;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import o6.a;
/* loaded from: classes.dex */
public abstract class gv<C extends Collection<T>, T> extends a<C> {

    /* renamed from: n3  reason: collision with root package name */
    public static final a.y f12172n3 = new y();
    public final a<T> y;

    /* loaded from: classes.dex */
    public class n3 extends gv<Collection<T>, T> {
        public n3(a aVar) {
            super(aVar, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // o6.a
        public /* bridge */ /* synthetic */ void a(w wVar, Object obj) throws IOException {
            super.t(wVar, (Collection) obj);
        }

        @Override // o6.gv
        public Collection<T> i9() {
            return new ArrayList();
        }

        @Override // o6.a
        public /* bridge */ /* synthetic */ Object n3(f fVar) throws IOException {
            return super.s(fVar);
        }
    }

    /* loaded from: classes.dex */
    public class y implements a.y {
        @Override // o6.a.y
        public a<?> y(Type type, Set<? extends Annotation> set, co coVar) {
            Class<?> fb2 = x4.fb(type);
            if (!set.isEmpty()) {
                return null;
            }
            if (fb2 != List.class && fb2 != Collection.class) {
                if (fb2 != Set.class) {
                    return null;
                }
                return gv.f(type, coVar).gv();
            }
            return gv.c5(type, coVar).gv();
        }
    }

    /* loaded from: classes.dex */
    public class zn extends gv<Set<T>, T> {
        public zn(a aVar) {
            super(aVar, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // o6.a
        public /* bridge */ /* synthetic */ void a(w wVar, Object obj) throws IOException {
            super.t(wVar, (Collection) obj);
        }

        @Override // o6.a
        public /* bridge */ /* synthetic */ Object n3(f fVar) throws IOException {
            return super.s(fVar);
        }

        @Override // o6.gv
        /* renamed from: tl */
        public Set<T> i9() {
            return new LinkedHashSet();
        }
    }

    public /* synthetic */ gv(a aVar, y yVar) {
        this(aVar);
    }

    public static <T> a<Collection<T>> c5(Type type, co coVar) {
        return new n3(coVar.gv(x4.zn(type, Collection.class)));
    }

    public static <T> a<Set<T>> f(Type type, co coVar) {
        return new zn(coVar.gv(x4.zn(type, Collection.class)));
    }

    public abstract C i9();

    public C s(f fVar) throws IOException {
        C i92 = i9();
        fVar.y();
        while (fVar.mt()) {
            i92.add(this.y.n3(fVar));
        }
        fVar.s();
        return i92;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void t(w wVar, C c2) throws IOException {
        wVar.y();
        for (Object obj : c2) {
            this.y.a(wVar, obj);
        }
        wVar.p();
    }

    public String toString() {
        return this.y + ".collection()";
    }

    public gv(a<T> aVar) {
        this.y = aVar;
    }
}
