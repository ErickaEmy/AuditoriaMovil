package tl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
/* loaded from: classes.dex */
public class fb extends v implements SubMenu {

    /* renamed from: v  reason: collision with root package name */
    public final ud.zn f13971v;

    public fb(Context context, ud.zn znVar) {
        super(context, znVar);
        this.f13971v = znVar;
    }

    @Override // android.view.SubMenu
    public void clearHeader() {
        this.f13971v.clearHeader();
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return zn(this.f13971v.getItem());
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i) {
        this.f13971v.setHeaderIcon(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i) {
        this.f13971v.setHeaderTitle(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        this.f13971v.setHeaderView(view);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i) {
        this.f13971v.setIcon(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        this.f13971v.setHeaderIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        this.f13971v.setHeaderTitle(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.f13971v.setIcon(drawable);
        return this;
    }
}
