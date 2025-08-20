package ae1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import vd1.gv;
/* loaded from: classes.dex */
public final class y {

    /* renamed from: n3  reason: collision with root package name */
    public final Map<String, vd1.zn<?>> f102n3;
    public final qd1.y y;

    /* renamed from: zn  reason: collision with root package name */
    public final HashSet<gv<?>> f103zn;

    public y(qd1.y _koin) {
        Intrinsics.checkNotNullParameter(_koin, "_koin");
        this.y = _koin;
        this.f102n3 = fe1.y.y.gv();
        this.f103zn = new HashSet<>();
    }

    public static /* synthetic */ void c5(y yVar, boolean z2, String str, vd1.zn znVar, boolean z3, int i, Object obj) {
        if ((i & 8) != 0) {
            z3 = true;
        }
        yVar.s(z2, str, znVar, z3);
    }

    public final vd1.zn<?> a(KClass<?> clazz, zd1.y yVar, zd1.y scopeQualifier) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        return this.f102n3.get(td1.n3.y(clazz, yVar, scopeQualifier));
    }

    public final <T> T fb(zd1.y yVar, KClass<?> clazz, zd1.y scopeQualifier, vd1.n3 instanceContext) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        Intrinsics.checkNotNullParameter(instanceContext, "instanceContext");
        vd1.zn<?> a2 = a(clazz, yVar, scopeQualifier);
        if (a2 == null) {
            return null;
        }
        return (T) a2.n3(instanceContext);
    }

    public final void gv(xd1.y yVar, boolean z2) {
        for (Map.Entry<String, vd1.zn<?>> entry : yVar.zn().entrySet()) {
            c5(this, z2, entry.getKey(), entry.getValue(), false, 8, null);
        }
    }

    public final void n3(HashSet<gv<?>> hashSet) {
        if (!hashSet.isEmpty()) {
            if (this.y.zn().fb(wd1.n3.DEBUG)) {
                this.y.zn().n3("Creating eager instances ...");
            }
            qd1.y yVar = this.y;
            vd1.n3 n3Var = new vd1.n3(yVar, yVar.v().n3(), null, 4, null);
            Iterator<T> it = hashSet.iterator();
            while (it.hasNext()) {
                ((gv) it.next()).n3(n3Var);
            }
        }
    }

    public final void s(boolean z2, String mapping, vd1.zn<?> factory, boolean z3) {
        Intrinsics.checkNotNullParameter(mapping, "mapping");
        Intrinsics.checkNotNullParameter(factory, "factory");
        if (this.f102n3.containsKey(mapping)) {
            if (!z2) {
                xd1.n3.y(factory, mapping);
            } else if (z3) {
                wd1.zn zn2 = this.y.zn();
                zn2.a("Override Mapping '" + mapping + "' with " + factory.zn());
            }
        }
        if (this.y.zn().fb(wd1.n3.DEBUG) && z3) {
            wd1.zn zn3 = this.y.zn();
            zn3.n3("add mapping '" + mapping + "' for " + factory.zn());
        }
        this.f102n3.put(mapping, factory);
    }

    public final void v(List<xd1.y> modules, boolean z2) {
        Intrinsics.checkNotNullParameter(modules, "modules");
        for (xd1.y yVar : modules) {
            gv(yVar, z2);
            this.f103zn.addAll(yVar.n3());
        }
    }

    public final void y() {
        n3(this.f103zn);
        this.f103zn.clear();
    }

    public final <T> List<T> zn(KClass<?> clazz, vd1.n3 instanceContext) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(instanceContext, "instanceContext");
        ArrayList arrayList = new ArrayList();
        for (T t2 : this.f102n3.values()) {
            if (Intrinsics.areEqual(((vd1.zn) t2).zn().gv(), instanceContext.zn().fb())) {
                arrayList.add(t2);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (T t3 : arrayList) {
            vd1.zn znVar = (vd1.zn) t3;
            if (Intrinsics.areEqual(znVar.zn().n3(), clazz) || znVar.zn().v().contains(clazz)) {
                arrayList2.add(t3);
            }
        }
        List<vd1.zn> distinct = CollectionsKt.distinct(arrayList2);
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(distinct, 10));
        for (vd1.zn znVar2 : distinct) {
            arrayList3.add(znVar2.n3(instanceContext));
        }
        return arrayList3;
    }
}
