package tl;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class y implements ud.n3 {

    /* renamed from: a  reason: collision with root package name */
    public Intent f13975a;

    /* renamed from: c5  reason: collision with root package name */
    public char f13976c5;

    /* renamed from: co  reason: collision with root package name */
    public boolean f13977co;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f13978f;

    /* renamed from: fb  reason: collision with root package name */
    public char f13979fb;

    /* renamed from: gv  reason: collision with root package name */
    public CharSequence f13980gv;

    /* renamed from: mt  reason: collision with root package name */
    public boolean f13982mt;

    /* renamed from: n3  reason: collision with root package name */
    public final int f13983n3;

    /* renamed from: p  reason: collision with root package name */
    public PorterDuff.Mode f13984p;

    /* renamed from: t  reason: collision with root package name */
    public Context f13986t;

    /* renamed from: tl  reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f13987tl;

    /* renamed from: v  reason: collision with root package name */
    public CharSequence f13988v;

    /* renamed from: w  reason: collision with root package name */
    public ColorStateList f13989w;

    /* renamed from: wz  reason: collision with root package name */
    public CharSequence f13990wz;

    /* renamed from: xc  reason: collision with root package name */
    public CharSequence f13991xc;
    public final int y;

    /* renamed from: zn  reason: collision with root package name */
    public final int f13993zn;

    /* renamed from: s  reason: collision with root package name */
    public int f13985s = 4096;

    /* renamed from: i9  reason: collision with root package name */
    public int f13981i9 = 4096;

    /* renamed from: z  reason: collision with root package name */
    public int f13992z = 16;

    public y(Context context, int i, int i5, int i6, int i8, CharSequence charSequence) {
        this.f13986t = context;
        this.y = i5;
        this.f13983n3 = i;
        this.f13993zn = i8;
        this.f13980gv = charSequence;
    }

    @Override // ud.n3, android.view.MenuItem
    /* renamed from: a */
    public ud.n3 setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // ud.n3, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // ud.n3, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // ud.n3, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // ud.n3, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f13981i9;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f13976c5;
    }

    @Override // ud.n3, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f13990wz;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f13983n3;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f13978f;
    }

    @Override // ud.n3, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f13989w;
    }

    @Override // ud.n3, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f13984p;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f13975a;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.y;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // ud.n3, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f13985s;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f13979fb;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f13993zn;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f13980gv;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f13988v;
        if (charSequence == null) {
            return this.f13980gv;
        }
        return charSequence;
    }

    @Override // ud.n3, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f13991xc;
    }

    @Override // ud.n3, android.view.MenuItem
    /* renamed from: gv */
    public ud.n3 setActionView(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // ud.n3, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        if ((this.f13992z & 1) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        if ((this.f13992z & 2) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        if ((this.f13992z & 16) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        if ((this.f13992z & 8) == 0) {
            return true;
        }
        return false;
    }

    @Override // ud.n3
    public hw.n3 n3() {
        return null;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        this.f13976c5 = Character.toLowerCase(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z2) {
        this.f13992z = (z2 ? 1 : 0) | (this.f13992z & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z2) {
        int i;
        int i5 = this.f13992z & (-3);
        if (z2) {
            i = 2;
        } else {
            i = 0;
        }
        this.f13992z = i | i5;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z2) {
        int i;
        int i5 = this.f13992z & (-17);
        if (z2) {
            i = 16;
        } else {
            i = 0;
        }
        this.f13992z = i | i5;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f13978f = drawable;
        zn();
        return this;
    }

    @Override // ud.n3, android.view.MenuItem
    public MenuItem setIconTintList(@Nullable ColorStateList colorStateList) {
        this.f13989w = colorStateList;
        this.f13982mt = true;
        zn();
        return this;
    }

    @Override // ud.n3, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f13984p = mode;
        this.f13977co = true;
        zn();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f13975a = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        this.f13979fb = c2;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f13987tl = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c4) {
        this.f13979fb = c2;
        this.f13976c5 = Character.toLowerCase(c4);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f13980gv = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f13988v = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z2) {
        int i = 8;
        int i5 = this.f13992z & 8;
        if (z2) {
            i = 0;
        }
        this.f13992z = i5 | i;
        return this;
    }

    @Override // ud.n3, android.view.MenuItem
    /* renamed from: v */
    public ud.n3 setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // ud.n3
    public ud.n3 y(hw.n3 n3Var) {
        throw new UnsupportedOperationException();
    }

    public final void zn() {
        Drawable drawable = this.f13978f;
        if (drawable != null) {
            if (this.f13982mt || this.f13977co) {
                Drawable mt2 = ej.y.mt(drawable);
                this.f13978f = mt2;
                Drawable mutate = mt2.mutate();
                this.f13978f = mutate;
                if (this.f13982mt) {
                    ej.y.xc(mutate, this.f13989w);
                }
                if (this.f13977co) {
                    ej.y.w(this.f13978f, this.f13984p);
                }
            }
        }
    }

    @Override // ud.n3, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2, int i) {
        this.f13976c5 = Character.toLowerCase(c2);
        this.f13981i9 = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public ud.n3 setContentDescription(CharSequence charSequence) {
        this.f13990wz = charSequence;
        return this;
    }

    @Override // ud.n3, android.view.MenuItem
    public MenuItem setNumericShortcut(char c2, int i) {
        this.f13979fb = c2;
        this.f13985s = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        this.f13980gv = this.f13986t.getResources().getString(i);
        return this;
    }

    @Override // android.view.MenuItem
    public ud.n3 setTooltipText(CharSequence charSequence) {
        this.f13991xc = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.f13978f = mg.y.v(this.f13986t, i);
        zn();
        return this;
    }

    @Override // ud.n3, android.view.MenuItem
    public MenuItem setShortcut(char c2, char c4, int i, int i5) {
        this.f13979fb = c2;
        this.f13985s = KeyEvent.normalizeMetaState(i);
        this.f13976c5 = Character.toLowerCase(c4);
        this.f13981i9 = KeyEvent.normalizeMetaState(i5);
        return this;
    }

    @Override // ud.n3, android.view.MenuItem
    public void setShowAsAction(int i) {
    }
}
