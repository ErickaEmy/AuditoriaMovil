package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.R$string;
import androidx.appcompat.view.menu.i9;
import hw.n3;
/* loaded from: classes.dex */
public final class fb implements ud.n3 {

    /* renamed from: a  reason: collision with root package name */
    public CharSequence f1110a;

    /* renamed from: c  reason: collision with root package name */
    public int f1111c;

    /* renamed from: co  reason: collision with root package name */
    public CharSequence f1113co;

    /* renamed from: d0  reason: collision with root package name */
    public View f1114d0;

    /* renamed from: f3  reason: collision with root package name */
    public boolean f1116f3;

    /* renamed from: fb  reason: collision with root package name */
    public Intent f1117fb;

    /* renamed from: fh  reason: collision with root package name */
    public hw.n3 f1118fh;

    /* renamed from: gv  reason: collision with root package name */
    public final int f1119gv;

    /* renamed from: i4  reason: collision with root package name */
    public boolean f1120i4;

    /* renamed from: i9  reason: collision with root package name */
    public char f1121i9;

    /* renamed from: mg  reason: collision with root package name */
    public boolean f1122mg;

    /* renamed from: mt  reason: collision with root package name */
    public CharSequence f1123mt;

    /* renamed from: n3  reason: collision with root package name */
    public final int f1125n3;

    /* renamed from: p  reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f1126p;

    /* renamed from: r  reason: collision with root package name */
    public PorterDuff.Mode f1127r;

    /* renamed from: rz  reason: collision with root package name */
    public MenuItem.OnActionExpandListener f1128rz;

    /* renamed from: s  reason: collision with root package name */
    public char f1129s;

    /* renamed from: t  reason: collision with root package name */
    public Drawable f1130t;

    /* renamed from: ta  reason: collision with root package name */
    public ContextMenu.ContextMenuInfo f1131ta;

    /* renamed from: tl  reason: collision with root package name */
    public int f1132tl;

    /* renamed from: v  reason: collision with root package name */
    public CharSequence f1133v;

    /* renamed from: w  reason: collision with root package name */
    public Runnable f1134w;

    /* renamed from: wz  reason: collision with root package name */
    public v f1135wz;

    /* renamed from: x4  reason: collision with root package name */
    public boolean f1136x4;

    /* renamed from: xc  reason: collision with root package name */
    public t f1137xc;
    public final int y;

    /* renamed from: z  reason: collision with root package name */
    public ColorStateList f1138z;

    /* renamed from: zn  reason: collision with root package name */
    public final int f1139zn;

    /* renamed from: c5  reason: collision with root package name */
    public int f1112c5 = 4096;

    /* renamed from: f  reason: collision with root package name */
    public int f1115f = 4096;

    /* renamed from: n  reason: collision with root package name */
    public int f1124n = 16;

    /* loaded from: classes.dex */
    public class y implements n3.InterfaceC0109n3 {
        public y() {
        }

        @Override // hw.n3.InterfaceC0109n3
        public void onActionProviderVisibilityChanged(boolean z2) {
            fb fbVar = fb.this;
            fbVar.f1135wz.a8(fbVar);
        }
    }

    public fb(v vVar, int i, int i5, int i6, int i8, CharSequence charSequence, int i10) {
        this.f1135wz = vVar;
        this.y = i5;
        this.f1125n3 = i;
        this.f1139zn = i6;
        this.f1119gv = i8;
        this.f1133v = charSequence;
        this.f1111c = i10;
    }

    public static void gv(StringBuilder sb, int i, int i5, String str) {
        if ((i & i5) == i5) {
            sb.append(str);
        }
    }

    public int a() {
        return this.f1119gv;
    }

    public boolean c() {
        return this.f1135wz.d0();
    }

    public CharSequence c5(i9.y yVar) {
        if (yVar != null && yVar.v()) {
            return getTitleCondensed();
        }
        return getTitle();
    }

    public void co(boolean z2) {
        int i;
        int i5 = this.f1124n;
        int i6 = i5 & (-3);
        if (z2) {
            i = 2;
        } else {
            i = 0;
        }
        int i8 = i | i6;
        this.f1124n = i8;
        if (i5 != i8) {
            this.f1135wz.x(false);
        }
    }

    @Override // ud.n3, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.f1111c & 8) == 0) {
            return false;
        }
        if (this.f1114d0 == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f1128rz;
        if (onActionExpandListener != null && !onActionExpandListener.onMenuItemActionCollapse(this)) {
            return false;
        }
        return this.f1135wz.a(this);
    }

    public boolean d0() {
        if (this.f1135wz.ej() && fb() != 0) {
            return true;
        }
        return false;
    }

    @Override // ud.n3, android.view.MenuItem
    public boolean expandActionView() {
        if (!i9()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f1128rz;
        if (onActionExpandListener != null && !onActionExpandListener.onMenuItemActionExpand(this)) {
            return false;
        }
        return this.f1135wz.f(this);
    }

    public boolean f() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f1126p;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        v vVar = this.f1135wz;
        if (vVar.s(vVar, this)) {
            return true;
        }
        Runnable runnable = this.f1134w;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f1117fb != null) {
            try {
                this.f1135wz.r().startActivity(this.f1117fb);
                return true;
            } catch (ActivityNotFoundException e2) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e2);
            }
        }
        hw.n3 n3Var = this.f1118fh;
        if (n3Var != null && n3Var.v()) {
            return true;
        }
        return false;
    }

    public void f3(t tVar) {
        this.f1137xc = tVar;
        tVar.setHeaderTitle(getTitle());
    }

    public char fb() {
        if (this.f1135wz.z6()) {
            return this.f1121i9;
        }
        return this.f1129s;
    }

    public boolean fh() {
        if ((this.f1111c & 4) == 4) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // ud.n3, android.view.MenuItem
    public View getActionView() {
        View view = this.f1114d0;
        if (view != null) {
            return view;
        }
        hw.n3 n3Var = this.f1118fh;
        if (n3Var != null) {
            View gv2 = n3Var.gv(this);
            this.f1114d0 = gv2;
            return gv2;
        }
        return null;
    }

    @Override // ud.n3, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f1115f;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f1121i9;
    }

    @Override // ud.n3, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f1123mt;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f1125n3;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.f1130t;
        if (drawable != null) {
            return v(drawable);
        }
        if (this.f1132tl != 0) {
            Drawable gv2 = c5.y.gv(this.f1135wz.r(), this.f1132tl);
            this.f1132tl = 0;
            this.f1130t = gv2;
            return v(gv2);
        }
        return null;
    }

    @Override // ud.n3, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f1138z;
    }

    @Override // ud.n3, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f1127r;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f1117fb;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.y;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f1131ta;
    }

    @Override // ud.n3, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f1112c5;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f1129s;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f1139zn;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f1137xc;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f1133v;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1110a;
        if (charSequence == null) {
            return this.f1133v;
        }
        return charSequence;
    }

    @Override // ud.n3, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f1113co;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        if (this.f1137xc != null) {
            return true;
        }
        return false;
    }

    @Override // ud.n3, android.view.MenuItem
    /* renamed from: i4 */
    public ud.n3 setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    public boolean i9() {
        hw.n3 n3Var;
        if ((this.f1111c & 8) == 0) {
            return false;
        }
        if (this.f1114d0 == null && (n3Var = this.f1118fh) != null) {
            this.f1114d0 = n3Var.gv(this);
        }
        if (this.f1114d0 == null) {
            return false;
        }
        return true;
    }

    @Override // ud.n3, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f1122mg;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        if ((this.f1124n & 1) == 1) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        if ((this.f1124n & 2) == 2) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        if ((this.f1124n & 16) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        hw.n3 n3Var = this.f1118fh;
        if (n3Var != null && n3Var.fb()) {
            if ((this.f1124n & 8) != 0 || !this.f1118fh.n3()) {
                return false;
            }
            return true;
        } else if ((this.f1124n & 8) != 0) {
            return false;
        } else {
            return true;
        }
    }

    public void mt(boolean z2) {
        this.f1122mg = z2;
        this.f1135wz.x(false);
    }

    public boolean n(boolean z2) {
        int i;
        int i5 = this.f1124n;
        int i6 = i5 & (-9);
        if (z2) {
            i = 0;
        } else {
            i = 8;
        }
        int i8 = i | i6;
        this.f1124n = i8;
        if (i5 == i8) {
            return false;
        }
        return true;
    }

    @Override // ud.n3
    public hw.n3 n3() {
        return this.f1118fh;
    }

    @Override // ud.n3, android.view.MenuItem
    /* renamed from: p */
    public ud.n3 setActionView(View view) {
        int i;
        this.f1114d0 = view;
        this.f1118fh = null;
        if (view != null && view.getId() == -1 && (i = this.y) > 0) {
            view.setId(i);
        }
        this.f1135wz.ud(this);
        return this;
    }

    public void r(boolean z2) {
        if (z2) {
            this.f1124n |= 32;
        } else {
            this.f1124n &= -33;
        }
    }

    public String s() {
        int i;
        char fb2 = fb();
        if (fb2 == 0) {
            return "";
        }
        Resources resources = this.f1135wz.r().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.f1135wz.r()).hasPermanentMenuKey()) {
            sb.append(resources.getString(R$string.f799tl));
        }
        if (this.f1135wz.z6()) {
            i = this.f1115f;
        } else {
            i = this.f1112c5;
        }
        gv(sb, i, 65536, resources.getString(R$string.f791c5));
        gv(sb, i, 4096, resources.getString(R$string.f800v));
        gv(sb, i, 2, resources.getString(R$string.f794gv));
        gv(sb, i, 1, resources.getString(R$string.f795i9));
        gv(sb, i, 4, resources.getString(R$string.f798t));
        gv(sb, i, 8, resources.getString(R$string.f797s));
        if (fb2 != '\b') {
            if (fb2 != '\n') {
                if (fb2 != ' ') {
                    sb.append(fb2);
                } else {
                    sb.append(resources.getString(R$string.f792f));
                }
            } else {
                sb.append(resources.getString(R$string.f793fb));
            }
        } else {
            sb.append(resources.getString(R$string.f790a));
        }
        return sb.toString();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        if (this.f1121i9 == c2) {
            return this;
        }
        this.f1121i9 = Character.toLowerCase(c2);
        this.f1135wz.x(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z2) {
        int i = this.f1124n;
        int i5 = (z2 ? 1 : 0) | (i & (-2));
        this.f1124n = i5;
        if (i != i5) {
            this.f1135wz.x(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z2) {
        if ((this.f1124n & 4) != 0) {
            this.f1135wz.j(this);
        } else {
            co(z2);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z2) {
        if (z2) {
            this.f1124n |= 16;
        } else {
            this.f1124n &= -17;
        }
        this.f1135wz.x(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f1132tl = 0;
        this.f1130t = drawable;
        this.f1116f3 = true;
        this.f1135wz.x(false);
        return this;
    }

    @Override // ud.n3, android.view.MenuItem
    public MenuItem setIconTintList(@Nullable ColorStateList colorStateList) {
        this.f1138z = colorStateList;
        this.f1136x4 = true;
        this.f1116f3 = true;
        this.f1135wz.x(false);
        return this;
    }

    @Override // ud.n3, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f1127r = mode;
        this.f1120i4 = true;
        this.f1116f3 = true;
        this.f1135wz.x(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f1117fb = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        if (this.f1129s == c2) {
            return this;
        }
        this.f1129s = c2;
        this.f1135wz.x(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f1128rz = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f1126p = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c4) {
        this.f1129s = c2;
        this.f1121i9 = Character.toLowerCase(c4);
        this.f1135wz.x(false);
        return this;
    }

    @Override // ud.n3, android.view.MenuItem
    public void setShowAsAction(int i) {
        int i5 = i & 3;
        if (i5 != 0 && i5 != 1 && i5 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f1111c = i;
        this.f1135wz.ud(this);
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f1133v = charSequence;
        this.f1135wz.x(false);
        t tVar = this.f1137xc;
        if (tVar != null) {
            tVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1110a = charSequence;
        this.f1135wz.x(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z2) {
        if (n(z2)) {
            this.f1135wz.a8(this);
        }
        return this;
    }

    public boolean t() {
        if ((this.f1124n & 32) == 32) {
            return true;
        }
        return false;
    }

    public boolean tl() {
        if ((this.f1124n & 4) != 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        CharSequence charSequence = this.f1133v;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public final Drawable v(Drawable drawable) {
        if (drawable != null && this.f1116f3 && (this.f1136x4 || this.f1120i4)) {
            drawable = ej.y.mt(drawable).mutate();
            if (this.f1136x4) {
                ej.y.xc(drawable, this.f1138z);
            }
            if (this.f1120i4) {
                ej.y.w(drawable, this.f1127r);
            }
            this.f1116f3 = false;
        }
        return drawable;
    }

    @Override // ud.n3, android.view.MenuItem
    /* renamed from: w */
    public ud.n3 setActionView(int i) {
        Context r2 = this.f1135wz.r();
        setActionView(LayoutInflater.from(r2).inflate(i, (ViewGroup) new LinearLayout(r2), false));
        return this;
    }

    public boolean wz() {
        if ((this.f1111c & 1) == 1) {
            return true;
        }
        return false;
    }

    public void x4(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.f1131ta = contextMenuInfo;
    }

    public boolean xc() {
        if ((this.f1111c & 2) == 2) {
            return true;
        }
        return false;
    }

    @Override // ud.n3
    public ud.n3 y(hw.n3 n3Var) {
        hw.n3 n3Var2 = this.f1118fh;
        if (n3Var2 != null) {
            n3Var2.s();
        }
        this.f1114d0 = null;
        this.f1118fh = n3Var;
        this.f1135wz.x(true);
        hw.n3 n3Var3 = this.f1118fh;
        if (n3Var3 != null) {
            n3Var3.i9(new y());
        }
        return this;
    }

    public void z(boolean z2) {
        int i;
        int i5 = this.f1124n & (-5);
        if (z2) {
            i = 4;
        } else {
            i = 0;
        }
        this.f1124n = i | i5;
    }

    public void zn() {
        this.f1135wz.ud(this);
    }

    @Override // android.view.MenuItem
    public ud.n3 setContentDescription(CharSequence charSequence) {
        this.f1123mt = charSequence;
        this.f1135wz.x(false);
        return this;
    }

    @Override // android.view.MenuItem
    public ud.n3 setTooltipText(CharSequence charSequence) {
        this.f1113co = charSequence;
        this.f1135wz.x(false);
        return this;
    }

    @Override // ud.n3, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2, int i) {
        if (this.f1121i9 == c2 && this.f1115f == i) {
            return this;
        }
        this.f1121i9 = Character.toLowerCase(c2);
        this.f1115f = KeyEvent.normalizeMetaState(i);
        this.f1135wz.x(false);
        return this;
    }

    @Override // ud.n3, android.view.MenuItem
    public MenuItem setNumericShortcut(char c2, int i) {
        if (this.f1129s == c2 && this.f1112c5 == i) {
            return this;
        }
        this.f1129s = c2;
        this.f1112c5 = KeyEvent.normalizeMetaState(i);
        this.f1135wz.x(false);
        return this;
    }

    @Override // ud.n3, android.view.MenuItem
    public MenuItem setShortcut(char c2, char c4, int i, int i5) {
        this.f1129s = c2;
        this.f1112c5 = KeyEvent.normalizeMetaState(i);
        this.f1121i9 = Character.toLowerCase(c4);
        this.f1115f = KeyEvent.normalizeMetaState(i5);
        this.f1135wz.x(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.f1130t = null;
        this.f1132tl = i;
        this.f1116f3 = true;
        this.f1135wz.x(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        return setTitle(this.f1135wz.r().getString(i));
    }
}
