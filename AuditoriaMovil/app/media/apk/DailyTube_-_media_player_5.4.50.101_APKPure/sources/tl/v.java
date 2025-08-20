package tl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
/* loaded from: classes.dex */
public class v extends n3 implements Menu {

    /* renamed from: gv  reason: collision with root package name */
    public final ud.y f13974gv;

    public v(Context context, ud.y yVar) {
        super(context);
        if (yVar != null) {
            this.f13974gv = yVar;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return zn(this.f13974gv.add(charSequence));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i5, int i6, ComponentName componentName, Intent[] intentArr, Intent intent, int i8, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2;
        if (menuItemArr != null) {
            menuItemArr2 = new MenuItem[menuItemArr.length];
        } else {
            menuItemArr2 = null;
        }
        int addIntentOptions = this.f13974gv.addIntentOptions(i, i5, i6, componentName, intentArr, intent, i8, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i10 = 0; i10 < length; i10++) {
                menuItemArr[i10] = zn(menuItemArr2[i10]);
            }
        }
        return addIntentOptions;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return gv(this.f13974gv.addSubMenu(charSequence));
    }

    @Override // android.view.Menu
    public void clear() {
        v();
        this.f13974gv.clear();
    }

    @Override // android.view.Menu
    public void close() {
        this.f13974gv.close();
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        return zn(this.f13974gv.findItem(i));
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return zn(this.f13974gv.getItem(i));
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return this.f13974gv.hasVisibleItems();
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return this.f13974gv.isShortcutKey(i, keyEvent);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i5) {
        return this.f13974gv.performIdentifierAction(i, i5);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i5) {
        return this.f13974gv.performShortcut(i, keyEvent, i5);
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        a(i);
        this.f13974gv.removeGroup(i);
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        fb(i);
        this.f13974gv.removeItem(i);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z2, boolean z3) {
        this.f13974gv.setGroupCheckable(i, z2, z3);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z2) {
        this.f13974gv.setGroupEnabled(i, z2);
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z2) {
        this.f13974gv.setGroupVisible(i, z2);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z2) {
        this.f13974gv.setQwertyMode(z2);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f13974gv.size();
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return zn(this.f13974gv.add(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return gv(this.f13974gv.addSubMenu(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i5, int i6, CharSequence charSequence) {
        return zn(this.f13974gv.add(i, i5, i6, charSequence));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i5, int i6, CharSequence charSequence) {
        return gv(this.f13974gv.addSubMenu(i, i5, i6, charSequence));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i5, int i6, int i8) {
        return zn(this.f13974gv.add(i, i5, i6, i8));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i5, int i6, int i8) {
        return gv(this.f13974gv.addSubMenu(i, i5, i6, i8));
    }
}
