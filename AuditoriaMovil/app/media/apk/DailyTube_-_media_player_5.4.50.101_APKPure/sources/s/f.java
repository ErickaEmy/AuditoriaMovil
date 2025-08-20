package s;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.appcompat.view.WindowCallbackWrapper;
import androidx.appcompat.view.menu.c5;
import androidx.appcompat.view.menu.v;
import androidx.appcompat.widget.Toolbar;
import hw.i4;
import java.util.ArrayList;
import s.y;
import wz.f3;
/* loaded from: classes.dex */
public class f extends s.y {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<y.n3> f13372a = new ArrayList<>();

    /* renamed from: fb  reason: collision with root package name */
    public final Runnable f13373fb = new y();

    /* renamed from: gv  reason: collision with root package name */
    public boolean f13374gv;

    /* renamed from: n3  reason: collision with root package name */
    public boolean f13375n3;

    /* renamed from: s  reason: collision with root package name */
    public final Toolbar.a f13376s;

    /* renamed from: v  reason: collision with root package name */
    public boolean f13377v;
    public f3 y;

    /* renamed from: zn  reason: collision with root package name */
    public Window.Callback f13378zn;

    /* loaded from: classes.dex */
    public final class gv implements v.y {
        public gv() {
        }

        @Override // androidx.appcompat.view.menu.v.y
        public void n3(@NonNull androidx.appcompat.view.menu.v vVar) {
            f fVar = f.this;
            if (fVar.f13378zn != null) {
                if (fVar.y.v()) {
                    f.this.f13378zn.onPanelClosed(108, vVar);
                } else if (f.this.f13378zn.onPreparePanel(0, null, vVar)) {
                    f.this.f13378zn.onMenuOpened(108, vVar);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.v.y
        public boolean y(@NonNull androidx.appcompat.view.menu.v vVar, @NonNull MenuItem menuItem) {
            return false;
        }
    }

    /* loaded from: classes.dex */
    public class n3 implements Toolbar.a {
        public n3() {
        }

        @Override // androidx.appcompat.widget.Toolbar.a
        public boolean onMenuItemClick(MenuItem menuItem) {
            return f.this.f13378zn.onMenuItemSelected(0, menuItem);
        }
    }

    /* loaded from: classes.dex */
    public class v extends WindowCallbackWrapper {
        public v(Window.Callback callback) {
            super(callback);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public View onCreatePanelView(int i) {
            if (i == 0) {
                return new View(f.this.y.getContext());
            }
            return super.onCreatePanelView(i);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (onPreparePanel) {
                f fVar = f.this;
                if (!fVar.f13375n3) {
                    fVar.y.a();
                    f.this.f13375n3 = true;
                }
            }
            return onPreparePanel;
        }
    }

    /* loaded from: classes.dex */
    public class y implements Runnable {
        public y() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.c();
        }
    }

    /* loaded from: classes.dex */
    public final class zn implements c5.y {
        public boolean y;

        public zn() {
        }

        @Override // androidx.appcompat.view.menu.c5.y
        public void n3(@NonNull androidx.appcompat.view.menu.v vVar, boolean z2) {
            if (this.y) {
                return;
            }
            this.y = true;
            f.this.y.mt();
            Window.Callback callback = f.this.f13378zn;
            if (callback != null) {
                callback.onPanelClosed(108, vVar);
            }
            this.y = false;
        }

        @Override // androidx.appcompat.view.menu.c5.y
        public boolean zn(@NonNull androidx.appcompat.view.menu.v vVar) {
            Window.Callback callback = f.this.f13378zn;
            if (callback != null) {
                callback.onMenuOpened(108, vVar);
                return true;
            }
            return false;
        }
    }

    public f(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        n3 n3Var = new n3();
        this.f13376s = n3Var;
        this.y = new androidx.appcompat.widget.zn(toolbar, false);
        v vVar = new v(callback);
        this.f13378zn = vVar;
        this.y.setWindowCallback(vVar);
        toolbar.setOnMenuItemClickListener(n3Var);
        this.y.setWindowTitle(charSequence);
    }

    @Override // s.y
    public boolean a() {
        return this.y.n3();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c() {
        /*
            r5 = this;
            android.view.Menu r0 = r5.f3()
            boolean r1 = r0 instanceof androidx.appcompat.view.menu.v
            r2 = 0
            if (r1 == 0) goto Ld
            r1 = r0
            androidx.appcompat.view.menu.v r1 = (androidx.appcompat.view.menu.v) r1
            goto Le
        Ld:
            r1 = r2
        Le:
            if (r1 == 0) goto L13
            r1.xg()
        L13:
            r0.clear()     // Catch: java.lang.Throwable -> L28
            android.view.Window$Callback r3 = r5.f13378zn     // Catch: java.lang.Throwable -> L28
            r4 = 0
            boolean r3 = r3.onCreatePanelMenu(r4, r0)     // Catch: java.lang.Throwable -> L28
            if (r3 == 0) goto L2a
            android.view.Window$Callback r3 = r5.f13378zn     // Catch: java.lang.Throwable -> L28
            boolean r2 = r3.onPreparePanel(r4, r2, r0)     // Catch: java.lang.Throwable -> L28
            if (r2 != 0) goto L2d
            goto L2a
        L28:
            r0 = move-exception
            goto L33
        L2a:
            r0.clear()     // Catch: java.lang.Throwable -> L28
        L2d:
            if (r1 == 0) goto L32
            r1.y5()
        L32:
            return
        L33:
            if (r1 == 0) goto L38
            r1.y5()
        L38:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: s.f.c():void");
    }

    @Override // s.y
    public int c5() {
        return this.y.x4();
    }

    public void d0(int i, int i5) {
        this.y.c5((i & i5) | ((~i5) & this.y.x4()));
    }

    @Override // s.y
    public boolean f() {
        this.y.wz().removeCallbacks(this.f13373fb);
        i4.nf(this.y.wz(), this.f13373fb);
        return true;
    }

    public final Menu f3() {
        if (!this.f13374gv) {
            this.y.r(new zn(), new gv());
            this.f13374gv = true;
        }
        return this.y.f();
    }

    @Override // s.y
    public boolean fb() {
        if (this.y.s()) {
            this.y.collapseActionView();
            return true;
        }
        return false;
    }

    @Override // s.y
    public Context i9() {
        return this.y.getContext();
    }

    @Override // s.y
    public void mt(boolean z2) {
        int i;
        if (z2) {
            i = 4;
        } else {
            i = 0;
        }
        d0(i, 4);
    }

    public Window.Callback n() {
        return this.f13378zn;
    }

    @Override // s.y
    public void r(int i) {
        CharSequence charSequence;
        f3 f3Var = this.y;
        if (i != 0) {
            charSequence = f3Var.getContext().getText(i);
        } else {
            charSequence = null;
        }
        f3Var.setTitle(charSequence);
    }

    @Override // s.y
    public void s(boolean z2) {
        if (z2 == this.f13377v) {
            return;
        }
        this.f13377v = z2;
        int size = this.f13372a.size();
        for (int i = 0; i < size; i++) {
            this.f13372a.get(i).y(z2);
        }
    }

    @Override // s.y
    public void t(Configuration configuration) {
        super.t(configuration);
    }

    @Override // s.y
    public void tl() {
        this.y.wz().removeCallbacks(this.f13373fb);
    }

    @Override // s.y
    public boolean w() {
        return this.y.zn();
    }

    @Override // s.y
    public boolean wz(int i, KeyEvent keyEvent) {
        int i5;
        Menu f32 = f3();
        if (f32 == null) {
            return false;
        }
        if (keyEvent != null) {
            i5 = keyEvent.getDeviceId();
        } else {
            i5 = -1;
        }
        boolean z2 = true;
        if (KeyCharacterMap.load(i5).getKeyboardType() == 1) {
            z2 = false;
        }
        f32.setQwertyMode(z2);
        return f32.performShortcut(i, keyEvent, 0);
    }

    @Override // s.y
    public void x4(CharSequence charSequence) {
        this.y.setWindowTitle(charSequence);
    }

    @Override // s.y
    public boolean xc(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            w();
        }
        return true;
    }

    @Override // s.y
    public void z(int i) {
        CharSequence charSequence;
        f3 f3Var = this.y;
        if (i != 0) {
            charSequence = f3Var.getContext().getText(i);
        } else {
            charSequence = null;
        }
        f3Var.i9(charSequence);
    }

    @Override // s.y
    public void co(boolean z2) {
    }

    @Override // s.y
    public void p(boolean z2) {
    }
}
