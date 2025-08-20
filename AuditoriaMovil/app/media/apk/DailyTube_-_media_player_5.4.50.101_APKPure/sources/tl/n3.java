package tl;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import z.s;
/* loaded from: classes.dex */
public abstract class n3 {

    /* renamed from: n3  reason: collision with root package name */
    public s<ud.n3, MenuItem> f13972n3;
    public final Context y;

    /* renamed from: zn  reason: collision with root package name */
    public s<ud.zn, SubMenu> f13973zn;

    public n3(Context context) {
        this.y = context;
    }

    public final void a(int i) {
        if (this.f13972n3 == null) {
            return;
        }
        int i5 = 0;
        while (i5 < this.f13972n3.size()) {
            if (this.f13972n3.f(i5).getGroupId() == i) {
                this.f13972n3.tl(i5);
                i5--;
            }
            i5++;
        }
    }

    public final void fb(int i) {
        if (this.f13972n3 == null) {
            return;
        }
        for (int i5 = 0; i5 < this.f13972n3.size(); i5++) {
            if (this.f13972n3.f(i5).getItemId() == i) {
                this.f13972n3.tl(i5);
                return;
            }
        }
    }

    public final SubMenu gv(SubMenu subMenu) {
        if (subMenu instanceof ud.zn) {
            ud.zn znVar = (ud.zn) subMenu;
            if (this.f13973zn == null) {
                this.f13973zn = new s<>();
            }
            SubMenu subMenu2 = this.f13973zn.get(znVar);
            if (subMenu2 == null) {
                fb fbVar = new fb(this.y, znVar);
                this.f13973zn.put(znVar, fbVar);
                return fbVar;
            }
            return subMenu2;
        }
        return subMenu;
    }

    public final void v() {
        s<ud.n3, MenuItem> sVar = this.f13972n3;
        if (sVar != null) {
            sVar.clear();
        }
        s<ud.zn, SubMenu> sVar2 = this.f13973zn;
        if (sVar2 != null) {
            sVar2.clear();
        }
    }

    public final MenuItem zn(MenuItem menuItem) {
        if (menuItem instanceof ud.n3) {
            ud.n3 n3Var = (ud.n3) menuItem;
            if (this.f13972n3 == null) {
                this.f13972n3 = new s<>();
            }
            MenuItem menuItem2 = this.f13972n3.get(menuItem);
            if (menuItem2 == null) {
                zn znVar = new zn(this.y, n3Var);
                this.f13972n3.put(n3Var, znVar);
                return znVar;
            }
            return menuItem2;
        }
        return menuItem;
    }
}
