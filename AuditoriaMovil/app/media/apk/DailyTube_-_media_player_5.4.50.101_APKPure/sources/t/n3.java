package t;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
/* loaded from: classes.dex */
public abstract class n3 {

    /* renamed from: v  reason: collision with root package name */
    public boolean f13905v;
    public Object y;

    /* loaded from: classes.dex */
    public interface y {
        boolean gv(n3 n3Var, MenuItem menuItem);

        boolean n3(n3 n3Var, Menu menu);

        boolean y(n3 n3Var, Menu menu);

        void zn(n3 n3Var);
    }

    public abstract MenuInflater a();

    public abstract CharSequence c5();

    public void co(boolean z2) {
        this.f13905v = z2;
    }

    public abstract void f();

    public abstract CharSequence fb();

    public abstract View gv();

    public boolean i9() {
        return this.f13905v;
    }

    public abstract void mt(CharSequence charSequence);

    public abstract void p(int i);

    public Object s() {
        return this.y;
    }

    public abstract boolean t();

    public abstract void tl(View view);

    public abstract Menu v();

    public void w(Object obj) {
        this.y = obj;
    }

    public abstract void wz(int i);

    public abstract void xc(CharSequence charSequence);

    public abstract void zn();
}
