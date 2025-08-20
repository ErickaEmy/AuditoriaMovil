package t;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;
import t.n3;
/* loaded from: classes.dex */
public class a extends ActionMode {

    /* renamed from: n3  reason: collision with root package name */
    public final n3 f13859n3;
    public final Context y;

    /* loaded from: classes.dex */
    public static class y implements n3.y {

        /* renamed from: n3  reason: collision with root package name */
        public final Context f13861n3;
        public final ActionMode.Callback y;

        /* renamed from: zn  reason: collision with root package name */
        public final ArrayList<a> f13862zn = new ArrayList<>();

        /* renamed from: gv  reason: collision with root package name */
        public final z.s<Menu, Menu> f13860gv = new z.s<>();

        public y(Context context, ActionMode.Callback callback) {
            this.f13861n3 = context;
            this.y = callback;
        }

        public final Menu a(Menu menu) {
            Menu menu2 = this.f13860gv.get(menu);
            if (menu2 == null) {
                tl.v vVar = new tl.v(this.f13861n3, (ud.y) menu);
                this.f13860gv.put(menu, vVar);
                return vVar;
            }
            return menu2;
        }

        @Override // t.n3.y
        public boolean gv(n3 n3Var, MenuItem menuItem) {
            return this.y.onActionItemClicked(v(n3Var), new tl.zn(this.f13861n3, (ud.n3) menuItem));
        }

        @Override // t.n3.y
        public boolean n3(n3 n3Var, Menu menu) {
            return this.y.onCreateActionMode(v(n3Var), a(menu));
        }

        public ActionMode v(n3 n3Var) {
            int size = this.f13862zn.size();
            for (int i = 0; i < size; i++) {
                a aVar = this.f13862zn.get(i);
                if (aVar != null && aVar.f13859n3 == n3Var) {
                    return aVar;
                }
            }
            a aVar2 = new a(this.f13861n3, n3Var);
            this.f13862zn.add(aVar2);
            return aVar2;
        }

        @Override // t.n3.y
        public boolean y(n3 n3Var, Menu menu) {
            return this.y.onPrepareActionMode(v(n3Var), a(menu));
        }

        @Override // t.n3.y
        public void zn(n3 n3Var) {
            this.y.onDestroyActionMode(v(n3Var));
        }
    }

    public a(Context context, n3 n3Var) {
        this.y = context;
        this.f13859n3 = n3Var;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f13859n3.zn();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f13859n3.gv();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new tl.v(this.y, (ud.y) this.f13859n3.v());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f13859n3.a();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f13859n3.fb();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f13859n3.s();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f13859n3.c5();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f13859n3.i9();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f13859n3.f();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f13859n3.t();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f13859n3.tl(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f13859n3.xc(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f13859n3.w(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f13859n3.mt(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z2) {
        this.f13859n3.co(z2);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i) {
        this.f13859n3.wz(i);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i) {
        this.f13859n3.p(i);
    }
}
