package x5;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import le.w;
/* loaded from: classes.dex */
public abstract class zn<T> implements w2.y<T> {

    /* renamed from: gv  reason: collision with root package name */
    public y f14920gv;

    /* renamed from: n3  reason: collision with root package name */
    public T f14921n3;
    public final List<String> y = new ArrayList();

    /* renamed from: zn  reason: collision with root package name */
    public q5.gv<T> f14922zn;

    /* loaded from: classes.dex */
    public interface y {
        void n3(@NonNull List<String> list);

        void y(@NonNull List<String> list);
    }

    public zn(q5.gv<T> gvVar) {
        this.f14922zn = gvVar;
    }

    public void a() {
        if (!this.y.isEmpty()) {
            this.y.clear();
            this.f14922zn.zn(this);
        }
    }

    public void fb(@Nullable y yVar) {
        if (this.f14920gv != yVar) {
            this.f14920gv = yVar;
            s(yVar, this.f14921n3);
        }
    }

    public boolean gv(@NonNull String str) {
        T t2 = this.f14921n3;
        if (t2 != null && zn(t2) && this.y.contains(str)) {
            return true;
        }
        return false;
    }

    public abstract boolean n3(@NonNull w wVar);

    public final void s(@Nullable y yVar, @Nullable T t2) {
        if (!this.y.isEmpty() && yVar != null) {
            if (t2 != null && !zn(t2)) {
                yVar.y(this.y);
            } else {
                yVar.n3(this.y);
            }
        }
    }

    public void v(@NonNull Iterable<w> iterable) {
        this.y.clear();
        for (w wVar : iterable) {
            if (n3(wVar)) {
                this.y.add(wVar.y);
            }
        }
        if (this.y.isEmpty()) {
            this.f14922zn.zn(this);
        } else {
            this.f14922zn.y(this);
        }
        s(this.f14920gv, this.f14921n3);
    }

    @Override // w2.y
    public void y(@Nullable T t2) {
        this.f14921n3 = t2;
        s(this.f14920gv, t2);
    }

    public abstract boolean zn(@NonNull T t2);
}
