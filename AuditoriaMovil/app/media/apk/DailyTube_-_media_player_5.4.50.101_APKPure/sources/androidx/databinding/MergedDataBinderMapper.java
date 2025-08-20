package androidx.databinding;

import android.util.Log;
import android.view.View;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public class MergedDataBinderMapper extends q9.n3 {
    public Set<Class<? extends q9.n3>> y = new HashSet();

    /* renamed from: n3  reason: collision with root package name */
    public List<q9.n3> f2377n3 = new CopyOnWriteArrayList();

    /* renamed from: zn  reason: collision with root package name */
    public List<String> f2378zn = new CopyOnWriteArrayList();

    public final boolean a() {
        boolean z2 = false;
        for (String str : this.f2378zn) {
            try {
                Class<?> cls = Class.forName(str);
                if (q9.n3.class.isAssignableFrom(cls)) {
                    v((q9.n3) cls.newInstance());
                    this.f2378zn.remove(str);
                    z2 = true;
                }
            } catch (ClassNotFoundException unused) {
            } catch (IllegalAccessException e2) {
                Log.e("MergedDataBinderMapper", "unable to add feature mapper for " + str, e2);
            } catch (InstantiationException e3) {
                Log.e("MergedDataBinderMapper", "unable to add feature mapper for " + str, e3);
            }
        }
        return z2;
    }

    @Override // q9.n3
    public int gv(String str) {
        for (q9.n3 n3Var : this.f2377n3) {
            int gv2 = n3Var.gv(str);
            if (gv2 != 0) {
                return gv2;
            }
        }
        if (a()) {
            return gv(str);
        }
        return 0;
    }

    @Override // q9.n3
    public ViewDataBinding n3(q9.zn znVar, View view, int i) {
        for (q9.n3 n3Var : this.f2377n3) {
            ViewDataBinding n32 = n3Var.n3(znVar, view, i);
            if (n32 != null) {
                return n32;
            }
        }
        if (a()) {
            return n3(znVar, view, i);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void v(q9.n3 n3Var) {
        if (this.y.add(n3Var.getClass())) {
            this.f2377n3.add(n3Var);
            for (q9.n3 n3Var2 : n3Var.y()) {
                v(n3Var2);
            }
        }
    }

    @Override // q9.n3
    public ViewDataBinding zn(q9.zn znVar, View[] viewArr, int i) {
        for (q9.n3 n3Var : this.f2377n3) {
            ViewDataBinding zn2 = n3Var.zn(znVar, viewArr, i);
            if (zn2 != null) {
                return zn2;
            }
        }
        if (a()) {
            return zn(znVar, viewArr, i);
        }
        return null;
    }
}
