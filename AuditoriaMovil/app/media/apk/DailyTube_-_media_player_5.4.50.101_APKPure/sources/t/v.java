package t;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.v;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;
import t.n3;
/* loaded from: classes.dex */
public class v extends n3 implements v.y {

    /* renamed from: co  reason: collision with root package name */
    public androidx.appcompat.view.menu.v f13913co;

    /* renamed from: f  reason: collision with root package name */
    public n3.y f13914f;

    /* renamed from: fb  reason: collision with root package name */
    public Context f13915fb;

    /* renamed from: p  reason: collision with root package name */
    public boolean f13916p;

    /* renamed from: s  reason: collision with root package name */
    public ActionBarContextView f13917s;

    /* renamed from: t  reason: collision with root package name */
    public WeakReference<View> f13918t;

    /* renamed from: w  reason: collision with root package name */
    public boolean f13919w;

    public v(Context context, ActionBarContextView actionBarContextView, n3.y yVar, boolean z2) {
        this.f13915fb = context;
        this.f13917s = actionBarContextView;
        this.f13914f = yVar;
        androidx.appcompat.view.menu.v o2 = new androidx.appcompat.view.menu.v(actionBarContextView.getContext()).o(1);
        this.f13913co = o2;
        o2.qn(this);
        this.f13916p = z2;
    }

    @Override // t.n3
    public MenuInflater a() {
        return new fb(this.f13917s.getContext());
    }

    @Override // t.n3
    public CharSequence c5() {
        return this.f13917s.getTitle();
    }

    @Override // t.n3
    public void co(boolean z2) {
        super.co(z2);
        this.f13917s.setTitleOptional(z2);
    }

    @Override // t.n3
    public void f() {
        this.f13914f.y(this, this.f13913co);
    }

    @Override // t.n3
    public CharSequence fb() {
        return this.f13917s.getSubtitle();
    }

    @Override // t.n3
    public View gv() {
        WeakReference<View> weakReference = this.f13918t;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // t.n3
    public void mt(CharSequence charSequence) {
        this.f13917s.setTitle(charSequence);
    }

    @Override // androidx.appcompat.view.menu.v.y
    public void n3(@NonNull androidx.appcompat.view.menu.v vVar) {
        f();
        this.f13917s.t();
    }

    @Override // t.n3
    public void p(int i) {
        mt(this.f13915fb.getString(i));
    }

    @Override // t.n3
    public boolean t() {
        return this.f13917s.i9();
    }

    @Override // t.n3
    public void tl(View view) {
        WeakReference<View> weakReference;
        this.f13917s.setCustomView(view);
        if (view != null) {
            weakReference = new WeakReference<>(view);
        } else {
            weakReference = null;
        }
        this.f13918t = weakReference;
    }

    @Override // t.n3
    public Menu v() {
        return this.f13913co;
    }

    @Override // t.n3
    public void wz(int i) {
        xc(this.f13915fb.getString(i));
    }

    @Override // t.n3
    public void xc(CharSequence charSequence) {
        this.f13917s.setSubtitle(charSequence);
    }

    @Override // androidx.appcompat.view.menu.v.y
    public boolean y(@NonNull androidx.appcompat.view.menu.v vVar, @NonNull MenuItem menuItem) {
        return this.f13914f.gv(this, menuItem);
    }

    @Override // t.n3
    public void zn() {
        if (this.f13919w) {
            return;
        }
        this.f13919w = true;
        this.f13917s.sendAccessibilityEvent(32);
        this.f13914f.zn(this);
    }
}
