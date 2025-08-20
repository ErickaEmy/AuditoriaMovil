package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public class v implements ud.y {

    /* renamed from: d0  reason: collision with root package name */
    public static final int[] f1190d0 = {1, 4, 5, 3, 2, 0};

    /* renamed from: c  reason: collision with root package name */
    public boolean f1192c;

    /* renamed from: co  reason: collision with root package name */
    public boolean f1194co;

    /* renamed from: f3  reason: collision with root package name */
    public fb f1196f3;

    /* renamed from: gv  reason: collision with root package name */
    public boolean f1198gv;

    /* renamed from: mt  reason: collision with root package name */
    public boolean f1201mt;

    /* renamed from: n3  reason: collision with root package name */
    public final Resources f1203n3;

    /* renamed from: p  reason: collision with root package name */
    public boolean f1204p;

    /* renamed from: r  reason: collision with root package name */
    public boolean f1205r;

    /* renamed from: t  reason: collision with root package name */
    public int f1207t;

    /* renamed from: tl  reason: collision with root package name */
    public ContextMenu.ContextMenuInfo f1208tl;

    /* renamed from: v  reason: collision with root package name */
    public y f1209v;

    /* renamed from: w  reason: collision with root package name */
    public View f1210w;

    /* renamed from: wz  reason: collision with root package name */
    public CharSequence f1211wz;

    /* renamed from: xc  reason: collision with root package name */
    public Drawable f1213xc;
    public final Context y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f1214z;

    /* renamed from: zn  reason: collision with root package name */
    public boolean f1215zn;

    /* renamed from: x4  reason: collision with root package name */
    public ArrayList<fb> f1212x4 = new ArrayList<>();

    /* renamed from: i4  reason: collision with root package name */
    public CopyOnWriteArrayList<WeakReference<c5>> f1199i4 = new CopyOnWriteArrayList<>();

    /* renamed from: n  reason: collision with root package name */
    public boolean f1202n = false;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<fb> f1191a = new ArrayList<>();

    /* renamed from: fb  reason: collision with root package name */
    public ArrayList<fb> f1197fb = new ArrayList<>();

    /* renamed from: s  reason: collision with root package name */
    public boolean f1206s = true;

    /* renamed from: c5  reason: collision with root package name */
    public ArrayList<fb> f1193c5 = new ArrayList<>();

    /* renamed from: i9  reason: collision with root package name */
    public ArrayList<fb> f1200i9 = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public boolean f1195f = true;

    /* loaded from: classes.dex */
    public interface n3 {
        boolean gv(fb fbVar);
    }

    /* loaded from: classes.dex */
    public interface y {
        void n3(@NonNull v vVar);

        boolean y(@NonNull v vVar, @NonNull MenuItem menuItem);
    }

    public v(Context context) {
        this.y = context;
        this.f1203n3 = context.getResources();
        u(true);
    }

    public static int fh(int i) {
        int i5 = ((-65536) & i) >> 16;
        if (i5 >= 0) {
            int[] iArr = f1190d0;
            if (i5 < iArr.length) {
                return (i & 65535) | (iArr[i5] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    public static int wz(ArrayList<fb> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).a() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    public boolean a(fb fbVar) {
        boolean z2 = false;
        if (!this.f1199i4.isEmpty() && this.f1196f3 == fbVar) {
            xg();
            Iterator<WeakReference<c5>> it = this.f1199i4.iterator();
            while (it.hasNext()) {
                WeakReference<c5> next = it.next();
                c5 c5Var = next.get();
                if (c5Var == null) {
                    this.f1199i4.remove(next);
                } else {
                    z2 = c5Var.s(this, fbVar);
                    if (z2) {
                        break;
                    }
                }
            }
            y5();
            if (z2) {
                this.f1196f3 = null;
            }
        }
        return z2;
    }

    public void a8(fb fbVar) {
        this.f1206s = true;
        x(true);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return y(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i5, int i6, ComponentName componentName, Intent[] intentArr, Intent intent, int i8, MenuItem[] menuItemArr) {
        int i10;
        Intent intent2;
        int i11;
        PackageManager packageManager = this.y.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        if (queryIntentActivityOptions != null) {
            i10 = queryIntentActivityOptions.size();
        } else {
            i10 = 0;
        }
        if ((i8 & 1) == 0) {
            removeGroup(i);
        }
        for (int i12 = 0; i12 < i10; i12++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i12);
            int i13 = resolveInfo.specificIndex;
            if (i13 < 0) {
                intent2 = intent;
            } else {
                intent2 = intentArr[i13];
            }
            Intent intent3 = new Intent(intent2);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent3.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent4 = add(i, i5, i6, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent3);
            if (menuItemArr != null && (i11 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i11] = intent4;
            }
        }
        return i10;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public boolean b(MenuItem menuItem, int i) {
        return k5(menuItem, null, i);
    }

    public ArrayList<fb> c() {
        mt();
        return this.f1200i9;
    }

    public final void c5(boolean z2) {
        if (this.f1199i4.isEmpty()) {
            return;
        }
        xg();
        Iterator<WeakReference<c5>> it = this.f1199i4.iterator();
        while (it.hasNext()) {
            WeakReference<c5> next = it.next();
            c5 c5Var = next.get();
            if (c5Var == null) {
                this.f1199i4.remove(next);
            } else {
                c5Var.a(z2);
            }
        }
        y5();
    }

    @Override // android.view.Menu
    public void clear() {
        fb fbVar = this.f1196f3;
        if (fbVar != null) {
            a(fbVar);
        }
        this.f1191a.clear();
        x(true);
    }

    public void clearHeader() {
        this.f1213xc = null;
        this.f1211wz = null;
        this.f1210w = null;
        x(false);
    }

    @Override // android.view.Menu
    public void close() {
        v(true);
    }

    public ArrayList<fb> co() {
        mt();
        return this.f1193c5;
    }

    public boolean d() {
        return this.f1202n;
    }

    public boolean d0() {
        return this.f1214z;
    }

    public boolean ej() {
        return this.f1198gv;
    }

    public v en(View view) {
        q9(0, null, 0, null, view);
        return this;
    }

    public boolean f(fb fbVar) {
        boolean z2 = false;
        if (this.f1199i4.isEmpty()) {
            return false;
        }
        xg();
        Iterator<WeakReference<c5>> it = this.f1199i4.iterator();
        while (it.hasNext()) {
            WeakReference<c5> next = it.next();
            c5 c5Var = next.get();
            if (c5Var == null) {
                this.f1199i4.remove(next);
            } else {
                z2 = c5Var.zn(this, fbVar);
                if (z2) {
                    break;
                }
            }
        }
        y5();
        if (z2) {
            this.f1196f3 = fbVar;
        }
        return z2;
    }

    public CharSequence f3() {
        return this.f1211wz;
    }

    public v f7(CharSequence charSequence) {
        q9(0, charSequence, 0, null, null);
        return this;
    }

    public final fb fb(int i, int i5, int i6, int i8, CharSequence charSequence, int i10) {
        return new fb(this, i, i5, i6, i8, charSequence, i10);
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        MenuItem findItem;
        int size = size();
        for (int i5 = 0; i5 < size; i5++) {
            fb fbVar = this.f1191a.get(i5);
            if (fbVar.getItemId() == i) {
                return fbVar;
            }
            if (fbVar.hasSubMenu() && (findItem = fbVar.getSubMenu().findItem(i)) != null) {
                return findItem;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return this.f1191a.get(i);
    }

    public void gv() {
        y yVar = this.f1209v;
        if (yVar != null) {
            yVar.n3(this);
        }
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.f1192c) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.f1191a.get(i).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public void hw(Bundle bundle) {
        MenuItem findItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(z());
        int size = size();
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((t) item.getSubMenu()).hw(bundle);
            }
        }
        int i5 = bundle.getInt("android:menu:expandedactionview");
        if (i5 > 0 && (findItem = findItem(i5)) != null) {
            findItem.expandActionView();
        }
    }

    public Drawable i4() {
        return this.f1213xc;
    }

    public final boolean i9(t tVar, c5 c5Var) {
        boolean z2 = false;
        if (this.f1199i4.isEmpty()) {
            return false;
        }
        if (c5Var != null) {
            z2 = c5Var.v(tVar);
        }
        Iterator<WeakReference<c5>> it = this.f1199i4.iterator();
        while (it.hasNext()) {
            WeakReference<c5> next = it.next();
            c5 c5Var2 = next.get();
            if (c5Var2 == null) {
                this.f1199i4.remove(next);
            } else if (!z2) {
                z2 = c5Var2.v(tVar);
            }
        }
        return z2;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        if (w(i, keyEvent) != null) {
            return true;
        }
        return false;
    }

    public void j(MenuItem menuItem) {
        boolean z2;
        int groupId = menuItem.getGroupId();
        int size = this.f1191a.size();
        xg();
        for (int i = 0; i < size; i++) {
            fb fbVar = this.f1191a.get(i);
            if (fbVar.getGroupId() == groupId && fbVar.tl() && fbVar.isCheckable()) {
                if (fbVar == menuItem) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                fbVar.co(z2);
            }
        }
        y5();
    }

    public void j5(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((t) item.getSubMenu()).j5(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(z(), sparseArray);
        }
    }

    public void jz(boolean z2) {
        this.f1192c = z2;
    }

    public v k(int i) {
        q9(i, null, 0, null, null);
        return this;
    }

    public boolean k5(MenuItem menuItem, c5 c5Var, int i) {
        boolean z2;
        fb fbVar = (fb) menuItem;
        if (fbVar == null || !fbVar.isEnabled()) {
            return false;
        }
        boolean f4 = fbVar.f();
        hw.n3 n32 = fbVar.n3();
        if (n32 != null && n32.y()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (fbVar.i9()) {
            f4 |= fbVar.expandActionView();
            if (f4) {
                v(true);
            }
        } else if (!fbVar.hasSubMenu() && !z2) {
            if ((i & 1) == 0) {
                v(true);
            }
        } else {
            if ((i & 4) == 0) {
                v(false);
            }
            if (!fbVar.hasSubMenu()) {
                fbVar.f3(new t(r(), this, fbVar));
            }
            t tVar = (t) fbVar.getSubMenu();
            if (z2) {
                n32.a(tVar);
            }
            f4 |= i9(tVar, c5Var);
            if (!f4) {
                v(true);
            }
        }
        return f4;
    }

    public v mg() {
        return this;
    }

    public void mt() {
        ArrayList<fb> ta2 = ta();
        if (!this.f1195f) {
            return;
        }
        Iterator<WeakReference<c5>> it = this.f1199i4.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            WeakReference<c5> next = it.next();
            c5 c5Var = next.get();
            if (c5Var == null) {
                this.f1199i4.remove(next);
            } else {
                z2 |= c5Var.fb();
            }
        }
        if (z2) {
            this.f1193c5.clear();
            this.f1200i9.clear();
            int size = ta2.size();
            for (int i = 0; i < size; i++) {
                fb fbVar = ta2.get(i);
                if (fbVar.t()) {
                    this.f1193c5.add(fbVar);
                } else {
                    this.f1200i9.add(fbVar);
                }
            }
        } else {
            this.f1193c5.clear();
            this.f1200i9.clear();
            this.f1200i9.addAll(ta());
        }
        this.f1195f = false;
    }

    public View n() {
        return this.f1210w;
    }

    public void n3(c5 c5Var) {
        zn(c5Var, this.y);
    }

    public v o(int i) {
        this.f1207t = i;
        return this;
    }

    public v oz(int i) {
        q9(0, null, i, null, null);
        return this;
    }

    public void p(List<fb> list, int i, KeyEvent keyEvent) {
        char numericShortcut;
        int numericModifiers;
        boolean z62 = z6();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (!keyEvent.getKeyData(keyData) && i != 67) {
            return;
        }
        int size = this.f1191a.size();
        for (int i5 = 0; i5 < size; i5++) {
            fb fbVar = this.f1191a.get(i5);
            if (fbVar.hasSubMenu()) {
                ((v) fbVar.getSubMenu()).p(list, i, keyEvent);
            }
            if (z62) {
                numericShortcut = fbVar.getAlphabeticShortcut();
            } else {
                numericShortcut = fbVar.getNumericShortcut();
            }
            if (z62) {
                numericModifiers = fbVar.getAlphabeticModifiers();
            } else {
                numericModifiers = fbVar.getNumericModifiers();
            }
            if ((modifiers & 69647) == (numericModifiers & 69647) && numericShortcut != 0) {
                char[] cArr = keyData.meta;
                if ((numericShortcut == cArr[0] || numericShortcut == cArr[2] || (z62 && numericShortcut == '\b' && i == 67)) && fbVar.isEnabled()) {
                    list.add(fbVar);
                }
            }
        }
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i5) {
        return b(findItem(i), i5);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i5) {
        boolean z2;
        fb w4 = w(i, keyEvent);
        if (w4 != null) {
            z2 = b(w4, i5);
        } else {
            z2 = false;
        }
        if ((i5 & 2) != 0) {
            v(true);
        }
        return z2;
    }

    public final void q9(int i, CharSequence charSequence, int i5, Drawable drawable, View view) {
        Resources rz2 = rz();
        if (view != null) {
            this.f1210w = view;
            this.f1211wz = null;
            this.f1213xc = null;
        } else {
            if (i > 0) {
                this.f1211wz = rz2.getText(i);
            } else if (charSequence != null) {
                this.f1211wz = charSequence;
            }
            if (i5 > 0) {
                this.f1213xc = mg.y.v(r(), i5);
            } else if (drawable != null) {
                this.f1213xc = drawable;
            }
            this.f1210w = null;
        }
        x(false);
    }

    public void qn(y yVar) {
        this.f1209v = yVar;
    }

    public Context r() {
        return this.y;
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        int t2 = t(i);
        if (t2 >= 0) {
            int size = this.f1191a.size() - t2;
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                if (i5 >= size || this.f1191a.get(t2).getGroupId() != i) {
                    break;
                }
                yt(t2, false);
                i5 = i6;
            }
            x(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        yt(xc(i), true);
    }

    public Resources rz() {
        return this.f1203n3;
    }

    public boolean s(@NonNull v vVar, @NonNull MenuItem menuItem) {
        y yVar = this.f1209v;
        if (yVar != null && yVar.y(vVar, menuItem)) {
            return true;
        }
        return false;
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z2, boolean z3) {
        int size = this.f1191a.size();
        for (int i5 = 0; i5 < size; i5++) {
            fb fbVar = this.f1191a.get(i5);
            if (fbVar.getGroupId() == i) {
                fbVar.z(z3);
                fbVar.setCheckable(z2);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z2) {
        this.f1202n = z2;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z2) {
        int size = this.f1191a.size();
        for (int i5 = 0; i5 < size; i5++) {
            fb fbVar = this.f1191a.get(i5);
            if (fbVar.getGroupId() == i) {
                fbVar.setEnabled(z2);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z2) {
        int size = this.f1191a.size();
        boolean z3 = false;
        for (int i5 = 0; i5 < size; i5++) {
            fb fbVar = this.f1191a.get(i5);
            if (fbVar.getGroupId() == i && fbVar.n(z2)) {
                z3 = true;
            }
        }
        if (z3) {
            x(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z2) {
        this.f1215zn = z2;
        x(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f1191a.size();
    }

    public int t(int i) {
        return tl(i, 0);
    }

    @NonNull
    public ArrayList<fb> ta() {
        if (!this.f1206s) {
            return this.f1197fb;
        }
        this.f1197fb.clear();
        int size = this.f1191a.size();
        for (int i = 0; i < size; i++) {
            fb fbVar = this.f1191a.get(i);
            if (fbVar.isVisible()) {
                this.f1197fb.add(fbVar);
            }
        }
        this.f1206s = false;
        this.f1195f = true;
        return this.f1197fb;
    }

    public int tl(int i, int i5) {
        int size = size();
        if (i5 < 0) {
            i5 = 0;
        }
        while (i5 < size) {
            if (this.f1191a.get(i5).getGroupId() == i) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0019, code lost:
        if (hw.n.a(android.view.ViewConfiguration.get(r2.y), r2.y) != false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u(boolean r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L1c
            android.content.res.Resources r3 = r2.f1203n3
            android.content.res.Configuration r3 = r3.getConfiguration()
            int r3 = r3.keyboard
            r0 = 1
            if (r3 == r0) goto L1c
            android.content.Context r3 = r2.y
            android.view.ViewConfiguration r3 = android.view.ViewConfiguration.get(r3)
            android.content.Context r1 = r2.y
            boolean r3 = hw.n.a(r3, r1)
            if (r3 == 0) goto L1c
            goto L1d
        L1c:
            r0 = 0
        L1d:
            r2.f1198gv = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.v.u(boolean):void");
    }

    public void ud(fb fbVar) {
        this.f1195f = true;
        x(true);
    }

    public v ut(Drawable drawable) {
        q9(0, null, 0, drawable, null);
        return this;
    }

    public final void v(boolean z2) {
        if (this.f1205r) {
            return;
        }
        this.f1205r = true;
        Iterator<WeakReference<c5>> it = this.f1199i4.iterator();
        while (it.hasNext()) {
            WeakReference<c5> next = it.next();
            c5 c5Var = next.get();
            if (c5Var == null) {
                this.f1199i4.remove(next);
            } else {
                c5Var.n3(this, z2);
            }
        }
        this.f1205r = false;
    }

    public void vl(c5 c5Var) {
        Iterator<WeakReference<c5>> it = this.f1199i4.iterator();
        while (it.hasNext()) {
            WeakReference<c5> next = it.next();
            c5 c5Var2 = next.get();
            if (c5Var2 == null || c5Var2 == c5Var) {
                this.f1199i4.remove(next);
            }
        }
    }

    public fb w(int i, KeyEvent keyEvent) {
        char numericShortcut;
        ArrayList<fb> arrayList = this.f1212x4;
        arrayList.clear();
        p(arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean z62 = z6();
        for (int i5 = 0; i5 < size; i5++) {
            fb fbVar = arrayList.get(i5);
            if (z62) {
                numericShortcut = fbVar.getAlphabeticShortcut();
            } else {
                numericShortcut = fbVar.getNumericShortcut();
            }
            char[] cArr = keyData.meta;
            if ((numericShortcut == cArr[0] && (metaState & 2) == 0) || ((numericShortcut == cArr[2] && (metaState & 2) != 0) || (z62 && numericShortcut == '\b' && i == 67))) {
                return fbVar;
            }
        }
        return null;
    }

    public void x(boolean z2) {
        if (!this.f1204p) {
            if (z2) {
                this.f1206s = true;
                this.f1195f = true;
            }
            c5(z2);
            return;
        }
        this.f1201mt = true;
        if (z2) {
            this.f1194co = true;
        }
    }

    public fb x4() {
        return this.f1196f3;
    }

    public int xc(int i) {
        int size = size();
        for (int i5 = 0; i5 < size; i5++) {
            if (this.f1191a.get(i5).getItemId() == i) {
                return i5;
            }
        }
        return -1;
    }

    public void xg() {
        if (!this.f1204p) {
            this.f1204p = true;
            this.f1201mt = false;
            this.f1194co = false;
        }
    }

    public MenuItem y(int i, int i5, int i6, CharSequence charSequence) {
        int fh2 = fh(i6);
        fb fb2 = fb(i, i5, i6, fh2, charSequence, this.f1207t);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.f1208tl;
        if (contextMenuInfo != null) {
            fb2.x4(contextMenuInfo);
        }
        ArrayList<fb> arrayList = this.f1191a;
        arrayList.add(wz(arrayList, fh2), fb2);
        x(true);
        return fb2;
    }

    public void y5() {
        this.f1204p = false;
        if (this.f1201mt) {
            this.f1201mt = false;
            x(this.f1194co);
        }
    }

    public final void yt(int i, boolean z2) {
        if (i >= 0 && i < this.f1191a.size()) {
            this.f1191a.remove(i);
            if (z2) {
                x(true);
            }
        }
    }

    public String z() {
        return "android:menu:actionviewstates";
    }

    public boolean z6() {
        return this.f1215zn;
    }

    public void zn(c5 c5Var, Context context) {
        this.f1199i4.add(new WeakReference<>(c5Var));
        c5Var.c5(context, this);
        this.f1195f = true;
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return y(0, 0, 0, this.f1203n3.getString(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f1203n3.getString(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i5, int i6, CharSequence charSequence) {
        return y(i, i5, i6, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i5, int i6, CharSequence charSequence) {
        fb fbVar = (fb) y(i, i5, i6, charSequence);
        t tVar = new t(this.y, this, fbVar);
        fbVar.f3(tVar);
        return tVar;
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i5, int i6, int i8) {
        return y(i, i5, i6, this.f1203n3.getString(i8));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i5, int i6, int i8) {
        return addSubMenu(i, i5, i6, this.f1203n3.getString(i8));
    }
}
