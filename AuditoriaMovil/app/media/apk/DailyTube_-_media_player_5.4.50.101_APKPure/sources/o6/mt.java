package o6;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;
import o6.a;
/* loaded from: classes.dex */
public final class mt<K, V> extends a<Map<K, V>> {

    /* renamed from: zn  reason: collision with root package name */
    public static final a.y f12173zn = new y();

    /* renamed from: n3  reason: collision with root package name */
    public final a<V> f12174n3;
    public final a<K> y;

    /* loaded from: classes.dex */
    public class y implements a.y {
        @Override // o6.a.y
        public a<?> y(Type type, Set<? extends Annotation> set, co coVar) {
            Class<?> fb2;
            if (!set.isEmpty() || (fb2 = x4.fb(type)) != Map.class) {
                return null;
            }
            Type[] c52 = x4.c5(type, fb2);
            return new mt(coVar, c52[0], c52[1]).gv();
        }
    }

    public mt(co coVar, Type type, Type type2) {
        this.y = coVar.gv(type);
        this.f12174n3 = coVar.gv(type2);
    }

    @Override // o6.a
    /* renamed from: c5 */
    public void a(w wVar, Map<K, V> map) throws IOException {
        wVar.v();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                wVar.d();
                this.y.a(wVar, entry.getKey());
                this.f12174n3.a(wVar, entry.getValue());
            } else {
                throw new s("Map key is null at " + wVar.getPath());
            }
        }
        wVar.mt();
    }

    @Override // o6.a
    /* renamed from: s */
    public Map<K, V> n3(f fVar) throws IOException {
        p pVar = new p();
        fVar.v();
        while (fVar.mt()) {
            fVar.j5();
            K n32 = this.y.n3(fVar);
            V n33 = this.f12174n3.n3(fVar);
            Object put = pVar.put(n32, n33);
            if (put != null) {
                throw new s("Map key '" + n32 + "' has multiple values at path " + fVar.getPath() + ": " + put + " and " + n33);
            }
        }
        fVar.p();
        return pVar;
    }

    public String toString() {
        return "JsonAdapter(" + this.y + "=" + this.f12174n3 + ")";
    }
}
