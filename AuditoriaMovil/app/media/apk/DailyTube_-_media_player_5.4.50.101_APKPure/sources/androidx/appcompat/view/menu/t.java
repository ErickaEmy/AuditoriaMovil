package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.v;
/* loaded from: classes.dex */
public class t extends v implements SubMenu {

    /* renamed from: fh  reason: collision with root package name */
    public v f1188fh;

    /* renamed from: rz  reason: collision with root package name */
    public fb f1189rz;

    public t(Context context, v vVar, fb fbVar) {
        super(context);
        this.f1188fh = vVar;
        this.f1189rz = fbVar;
    }

    @Override // androidx.appcompat.view.menu.v
    public boolean a(fb fbVar) {
        return this.f1188fh.a(fbVar);
    }

    @Override // androidx.appcompat.view.menu.v
    public boolean d() {
        return this.f1188fh.d();
    }

    public Menu dm() {
        return this.f1188fh;
    }

    @Override // androidx.appcompat.view.menu.v
    public boolean ej() {
        return this.f1188fh.ej();
    }

    @Override // androidx.appcompat.view.menu.v
    public boolean f(fb fbVar) {
        return this.f1188fh.f(fbVar);
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.f1189rz;
    }

    @Override // androidx.appcompat.view.menu.v
    public v mg() {
        return this.f1188fh.mg();
    }

    @Override // androidx.appcompat.view.menu.v
    public void qn(v.y yVar) {
        this.f1188fh.qn(yVar);
    }

    @Override // androidx.appcompat.view.menu.v
    public boolean s(@NonNull v vVar, @NonNull MenuItem menuItem) {
        if (!super.s(vVar, menuItem) && !this.f1188fh.s(vVar, menuItem)) {
            return false;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.v, android.view.Menu
    public void setGroupDividerEnabled(boolean z2) {
        this.f1188fh.setGroupDividerEnabled(z2);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.ut(drawable);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.f7(charSequence);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.en(view);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.f1189rz.setIcon(drawable);
        return this;
    }

    @Override // androidx.appcompat.view.menu.v, android.view.Menu
    public void setQwertyMode(boolean z2) {
        this.f1188fh.setQwertyMode(z2);
    }

    @Override // androidx.appcompat.view.menu.v
    public String z() {
        int i;
        fb fbVar = this.f1189rz;
        if (fbVar != null) {
            i = fbVar.getItemId();
        } else {
            i = 0;
        }
        if (i == 0) {
            return null;
        }
        return super.z() + ":" + i;
    }

    @Override // androidx.appcompat.view.menu.v
    public boolean z6() {
        return this.f1188fh.z6();
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i) {
        return (SubMenu) super.oz(i);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i) {
        return (SubMenu) super.k(i);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i) {
        this.f1189rz.setIcon(i);
        return this;
    }
}
