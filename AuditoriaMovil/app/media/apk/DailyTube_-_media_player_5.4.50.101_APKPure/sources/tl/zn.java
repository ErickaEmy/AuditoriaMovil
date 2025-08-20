package tl;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import hw.n3;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class zn extends tl.n3 implements MenuItem {

    /* renamed from: gv  reason: collision with root package name */
    public final ud.n3 f13994gv;

    /* renamed from: v  reason: collision with root package name */
    public Method f13995v;

    /* loaded from: classes.dex */
    public class gv implements MenuItem.OnActionExpandListener {
        public final MenuItem.OnActionExpandListener y;

        public gv(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.y = onActionExpandListener;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.y.onMenuItemActionCollapse(zn.this.zn(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.y.onMenuItemActionExpand(zn.this.zn(menuItem));
        }
    }

    /* loaded from: classes.dex */
    public class n3 extends y implements ActionProvider.VisibilityListener {

        /* renamed from: a  reason: collision with root package name */
        public n3.InterfaceC0109n3 f13997a;

        public n3(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // hw.n3
        public boolean fb() {
            return this.f14000gv.overridesItemVisibility();
        }

        @Override // hw.n3
        public View gv(MenuItem menuItem) {
            return this.f14000gv.onCreateActionView(menuItem);
        }

        @Override // hw.n3
        public void i9(n3.InterfaceC0109n3 interfaceC0109n3) {
            n3 n3Var;
            this.f13997a = interfaceC0109n3;
            ActionProvider actionProvider = this.f14000gv;
            if (interfaceC0109n3 != null) {
                n3Var = this;
            } else {
                n3Var = null;
            }
            actionProvider.setVisibilityListener(n3Var);
        }

        @Override // hw.n3
        public boolean n3() {
            return this.f14000gv.isVisible();
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z2) {
            n3.InterfaceC0109n3 interfaceC0109n3 = this.f13997a;
            if (interfaceC0109n3 != null) {
                interfaceC0109n3.onActionProviderVisibilityChanged(z2);
            }
        }
    }

    /* loaded from: classes.dex */
    public class v implements MenuItem.OnMenuItemClickListener {
        public final MenuItem.OnMenuItemClickListener y;

        public v(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.y = onMenuItemClickListener;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.y.onMenuItemClick(zn.this.zn(menuItem));
        }
    }

    /* loaded from: classes.dex */
    public class y extends hw.n3 {

        /* renamed from: gv  reason: collision with root package name */
        public final ActionProvider f14000gv;

        public y(Context context, ActionProvider actionProvider) {
            super(context);
            this.f14000gv = actionProvider;
        }

        @Override // hw.n3
        public void a(SubMenu subMenu) {
            this.f14000gv.onPrepareSubMenu(zn.this.gv(subMenu));
        }

        @Override // hw.n3
        public boolean v() {
            return this.f14000gv.onPerformDefaultAction();
        }

        @Override // hw.n3
        public boolean y() {
            return this.f14000gv.hasSubMenu();
        }

        @Override // hw.n3
        public View zn() {
            return this.f14000gv.onCreateActionView();
        }
    }

    /* renamed from: tl.zn$zn  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0221zn extends FrameLayout implements t.zn {
        public final CollapsibleActionView y;

        public C0221zn(View view) {
            super(view.getContext());
            this.y = (CollapsibleActionView) view;
            addView(view);
        }

        @Override // t.zn
        public void a() {
            this.y.onActionViewCollapsed();
        }

        @Override // t.zn
        public void n3() {
            this.y.onActionViewExpanded();
        }

        public View y() {
            return (View) this.y;
        }
    }

    public zn(Context context, ud.n3 n3Var) {
        super(context);
        if (n3Var != null) {
            this.f13994gv = n3Var;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return this.f13994gv.collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return this.f13994gv.expandActionView();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        hw.n3 n32 = this.f13994gv.n3();
        if (n32 instanceof y) {
            return ((y) n32).f14000gv;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = this.f13994gv.getActionView();
        if (actionView instanceof C0221zn) {
            return ((C0221zn) actionView).y();
        }
        return actionView;
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f13994gv.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f13994gv.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f13994gv.getContentDescription();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f13994gv.getGroupId();
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f13994gv.getIcon();
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f13994gv.getIconTintList();
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f13994gv.getIconTintMode();
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f13994gv.getIntent();
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f13994gv.getItemId();
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f13994gv.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.f13994gv.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f13994gv.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f13994gv.getOrder();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return gv(this.f13994gv.getSubMenu());
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f13994gv.getTitle();
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.f13994gv.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f13994gv.getTooltipText();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f13994gv.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f13994gv.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return this.f13994gv.isCheckable();
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return this.f13994gv.isChecked();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.f13994gv.isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.f13994gv.isVisible();
    }

    public void s(boolean z2) {
        try {
            if (this.f13995v == null) {
                this.f13995v = this.f13994gv.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.f13995v.invoke(this.f13994gv, Boolean.valueOf(z2));
        } catch (Exception e2) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e2);
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        n3 n3Var = new n3(this.y, actionProvider);
        ud.n3 n3Var2 = this.f13994gv;
        if (actionProvider == null) {
            n3Var = null;
        }
        n3Var2.y(n3Var);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new C0221zn(view);
        }
        this.f13994gv.setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        this.f13994gv.setAlphabeticShortcut(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z2) {
        this.f13994gv.setCheckable(z2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z2) {
        this.f13994gv.setChecked(z2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f13994gv.setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z2) {
        this.f13994gv.setEnabled(z2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f13994gv.setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f13994gv.setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f13994gv.setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f13994gv.setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        this.f13994gv.setNumericShortcut(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        gv gvVar;
        ud.n3 n3Var = this.f13994gv;
        if (onActionExpandListener != null) {
            gvVar = new gv(onActionExpandListener);
        } else {
            gvVar = null;
        }
        n3Var.setOnActionExpandListener(gvVar);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        v vVar;
        ud.n3 n3Var = this.f13994gv;
        if (onMenuItemClickListener != null) {
            vVar = new v(onMenuItemClickListener);
        } else {
            vVar = null;
        }
        n3Var.setOnMenuItemClickListener(vVar);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c4) {
        this.f13994gv.setShortcut(c2, c4);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i) {
        this.f13994gv.setShowAsAction(i);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i) {
        this.f13994gv.setShowAsActionFlags(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f13994gv.setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f13994gv.setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f13994gv.setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z2) {
        return this.f13994gv.setVisible(z2);
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2, int i) {
        this.f13994gv.setAlphabeticShortcut(c2, i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.f13994gv.setIcon(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2, int i) {
        this.f13994gv.setNumericShortcut(c2, i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c4, int i, int i5) {
        this.f13994gv.setShortcut(c2, c4, i, i5);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        this.f13994gv.setTitle(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i) {
        this.f13994gv.setActionView(i);
        View actionView = this.f13994gv.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.f13994gv.setActionView(new C0221zn(actionView));
        }
        return this;
    }
}
