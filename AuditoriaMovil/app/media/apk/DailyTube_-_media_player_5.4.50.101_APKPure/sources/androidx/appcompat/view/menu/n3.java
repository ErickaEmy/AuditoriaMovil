package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.c5;
import hw.i4;
import java.util.ArrayList;
import java.util.List;
import wz.mg;
import wz.ta;
/* loaded from: classes.dex */
public final class n3 extends tl.gv implements c5, View.OnKeyListener, PopupWindow.OnDismissListener {

    /* renamed from: k  reason: collision with root package name */
    public static final int f1145k = R$layout.f784v;

    /* renamed from: b  reason: collision with root package name */
    public int f1146b;

    /* renamed from: d0  reason: collision with root package name */
    public View f1150d0;

    /* renamed from: ej  reason: collision with root package name */
    public boolean f1151ej;

    /* renamed from: f  reason: collision with root package name */
    public final int f1152f;

    /* renamed from: fb  reason: collision with root package name */
    public final int f1154fb;

    /* renamed from: fh  reason: collision with root package name */
    public View f1155fh;

    /* renamed from: j  reason: collision with root package name */
    public c5.y f1156j;

    /* renamed from: j5  reason: collision with root package name */
    public int f1157j5;

    /* renamed from: o  reason: collision with root package name */
    public boolean f1159o;

    /* renamed from: oz  reason: collision with root package name */
    public ViewTreeObserver f1160oz;

    /* renamed from: q9  reason: collision with root package name */
    public boolean f1162q9;

    /* renamed from: s  reason: collision with root package name */
    public final int f1165s;

    /* renamed from: t  reason: collision with root package name */
    public final boolean f1166t;

    /* renamed from: ut  reason: collision with root package name */
    public PopupWindow.OnDismissListener f1167ut;

    /* renamed from: v  reason: collision with root package name */
    public final Context f1168v;

    /* renamed from: w  reason: collision with root package name */
    public final Handler f1169w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f1170x;

    /* renamed from: p  reason: collision with root package name */
    public final List<v> f1161p = new ArrayList();

    /* renamed from: co  reason: collision with root package name */
    public final List<gv> f1148co = new ArrayList();

    /* renamed from: z  reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f1171z = new y();

    /* renamed from: r  reason: collision with root package name */
    public final View.OnAttachStateChangeListener f1164r = new View$OnAttachStateChangeListenerC0012n3();

    /* renamed from: f3  reason: collision with root package name */
    public final mg f1153f3 = new zn();

    /* renamed from: n  reason: collision with root package name */
    public int f1158n = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f1147c = 0;

    /* renamed from: qn  reason: collision with root package name */
    public boolean f1163qn = false;

    /* renamed from: d  reason: collision with root package name */
    public int f1149d = rz();

    /* loaded from: classes.dex */
    public static class gv {

        /* renamed from: n3  reason: collision with root package name */
        public final v f1172n3;
        public final ta y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f1173zn;

        public gv(@NonNull ta taVar, @NonNull v vVar, int i) {
            this.y = taVar;
            this.f1172n3 = vVar;
            this.f1173zn = i;
        }

        public ListView y() {
            return this.y.xc();
        }
    }

    /* renamed from: androidx.appcompat.view.menu.n3$n3  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnAttachStateChangeListenerC0012n3 implements View.OnAttachStateChangeListener {
        public View$OnAttachStateChangeListenerC0012n3() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = n3.this.f1160oz;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    n3.this.f1160oz = view.getViewTreeObserver();
                }
                n3 n3Var = n3.this;
                n3Var.f1160oz.removeGlobalOnLayoutListener(n3Var.f1171z);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* loaded from: classes.dex */
    public class y implements ViewTreeObserver.OnGlobalLayoutListener {
        public y() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (n3.this.y() && n3.this.f1148co.size() > 0 && !n3.this.f1148co.get(0).y.d0()) {
                View view = n3.this.f1155fh;
                if (view != null && view.isShown()) {
                    for (gv gvVar : n3.this.f1148co) {
                        gvVar.y.show();
                    }
                    return;
                }
                n3.this.dismiss();
            }
        }
    }

    /* loaded from: classes.dex */
    public class zn implements mg {

        /* loaded from: classes.dex */
        public class y implements Runnable {

            /* renamed from: fb  reason: collision with root package name */
            public final /* synthetic */ v f1174fb;

            /* renamed from: v  reason: collision with root package name */
            public final /* synthetic */ MenuItem f1176v;
            public final /* synthetic */ gv y;

            public y(gv gvVar, MenuItem menuItem, v vVar) {
                this.y = gvVar;
                this.f1176v = menuItem;
                this.f1174fb = vVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                gv gvVar = this.y;
                if (gvVar != null) {
                    n3.this.f1162q9 = true;
                    gvVar.f1172n3.v(false);
                    n3.this.f1162q9 = false;
                }
                if (this.f1176v.isEnabled() && this.f1176v.hasSubMenu()) {
                    this.f1174fb.b(this.f1176v, 4);
                }
            }
        }

        public zn() {
        }

        @Override // wz.mg
        public void gv(@NonNull v vVar, @NonNull MenuItem menuItem) {
            gv gvVar = null;
            n3.this.f1169w.removeCallbacksAndMessages(null);
            int size = n3.this.f1148co.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    if (vVar == n3.this.f1148co.get(i).f1172n3) {
                        break;
                    }
                    i++;
                } else {
                    i = -1;
                    break;
                }
            }
            if (i == -1) {
                return;
            }
            int i5 = i + 1;
            if (i5 < n3.this.f1148co.size()) {
                gvVar = n3.this.f1148co.get(i5);
            }
            n3.this.f1169w.postAtTime(new y(gvVar, menuItem, vVar), vVar, SystemClock.uptimeMillis() + 200);
        }

        @Override // wz.mg
        public void wz(@NonNull v vVar, @NonNull MenuItem menuItem) {
            n3.this.f1169w.removeCallbacksAndMessages(vVar);
        }
    }

    public n3(@NonNull Context context, @NonNull View view, int i, int i5, boolean z2) {
        this.f1168v = context;
        this.f1150d0 = view;
        this.f1165s = i;
        this.f1152f = i5;
        this.f1166t = z2;
        Resources resources = context.getResources();
        this.f1154fb = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.f676gv));
        this.f1169w = new Handler();
    }

    @Override // androidx.appcompat.view.menu.c5
    public void a(boolean z2) {
        for (gv gvVar : this.f1148co) {
            tl.gv.f3(gvVar.y().getAdapter()).notifyDataSetChanged();
        }
    }

    public final int c(@NonNull v vVar) {
        int size = this.f1148co.size();
        for (int i = 0; i < size; i++) {
            if (vVar == this.f1148co.get(i).f1172n3) {
                return i;
            }
        }
        return -1;
    }

    @Override // tl.gv
    public void co(int i) {
        this.f1151ej = true;
        this.f1146b = i;
    }

    public final MenuItem d0(@NonNull v vVar, @NonNull v vVar2) {
        int size = vVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = vVar.getItem(i);
            if (item.hasSubMenu() && vVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    @Override // tl.a
    public void dismiss() {
        int size = this.f1148co.size();
        if (size > 0) {
            gv[] gvVarArr = (gv[]) this.f1148co.toArray(new gv[size]);
            for (int i = size - 1; i >= 0; i--) {
                gv gvVar = gvVarArr[i];
                if (gvVar.y.y()) {
                    gvVar.y.dismiss();
                }
            }
        }
    }

    @Override // tl.gv
    public boolean f() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.c5
    public boolean fb() {
        return false;
    }

    @Nullable
    public final View fh(@NonNull gv gvVar, @NonNull v vVar) {
        androidx.appcompat.view.menu.gv gvVar2;
        int i;
        int firstVisiblePosition;
        MenuItem d02 = d0(gvVar.f1172n3, vVar);
        if (d02 == null) {
            return null;
        }
        ListView y2 = gvVar.y();
        ListAdapter adapter = y2.getAdapter();
        int i5 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i = headerViewListAdapter.getHeadersCount();
            gvVar2 = (androidx.appcompat.view.menu.gv) headerViewListAdapter.getWrappedAdapter();
        } else {
            gvVar2 = (androidx.appcompat.view.menu.gv) adapter;
            i = 0;
        }
        int count = gvVar2.getCount();
        while (true) {
            if (i5 < count) {
                if (d02 == gvVar2.getItem(i5)) {
                    break;
                }
                i5++;
            } else {
                i5 = -1;
                break;
            }
        }
        if (i5 == -1 || (firstVisiblePosition = (i5 + i) - y2.getFirstVisiblePosition()) < 0 || firstVisiblePosition >= y2.getChildCount()) {
            return null;
        }
        return y2.getChildAt(firstVisiblePosition);
    }

    @Override // androidx.appcompat.view.menu.c5
    public void gv(c5.y yVar) {
        this.f1156j = yVar;
    }

    @Override // tl.gv
    public void i9(v vVar) {
        vVar.zn(this, this.f1168v);
        if (y()) {
            ta(vVar);
        } else {
            this.f1161p.add(vVar);
        }
    }

    public final int mg(int i) {
        List<gv> list = this.f1148co;
        ListView y2 = list.get(list.size() - 1).y();
        int[] iArr = new int[2];
        y2.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f1155fh.getWindowVisibleDisplayFrame(rect);
        if (this.f1149d == 1) {
            if (iArr[0] + y2.getWidth() + i <= rect.right) {
                return 1;
            }
            return 0;
        } else if (iArr[0] - i < 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override // tl.gv
    public void mt(int i) {
        if (this.f1158n != i) {
            this.f1158n = i;
            this.f1147c = hw.v.n3(i, i4.ta(this.f1150d0));
        }
    }

    public final ta n() {
        ta taVar = new ta(this.f1168v, null, this.f1165s, this.f1152f);
        taVar.o(this.f1153f3);
        taVar.x(this);
        taVar.a8(this);
        taVar.rz(this.f1150d0);
        taVar.d(this.f1147c);
        taVar.ud(true);
        taVar.ej(2);
        return taVar;
    }

    @Override // androidx.appcompat.view.menu.c5
    public void n3(v vVar, boolean z2) {
        int c2 = c(vVar);
        if (c2 < 0) {
            return;
        }
        int i = c2 + 1;
        if (i < this.f1148co.size()) {
            this.f1148co.get(i).f1172n3.v(false);
        }
        gv remove = this.f1148co.remove(c2);
        remove.f1172n3.vl(this);
        if (this.f1162q9) {
            remove.y.qn(null);
            remove.y.mg(0);
        }
        remove.y.dismiss();
        int size = this.f1148co.size();
        if (size > 0) {
            this.f1149d = this.f1148co.get(size - 1).f1173zn;
        } else {
            this.f1149d = rz();
        }
        if (size == 0) {
            dismiss();
            c5.y yVar = this.f1156j;
            if (yVar != null) {
                yVar.n3(vVar, true);
            }
            ViewTreeObserver viewTreeObserver = this.f1160oz;
            if (viewTreeObserver != null) {
                if (viewTreeObserver.isAlive()) {
                    this.f1160oz.removeGlobalOnLayoutListener(this.f1171z);
                }
                this.f1160oz = null;
            }
            this.f1155fh.removeOnAttachStateChangeListener(this.f1164r);
            this.f1167ut.onDismiss();
        } else if (z2) {
            this.f1148co.get(0).f1172n3.v(false);
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        gv gvVar;
        int size = this.f1148co.size();
        int i = 0;
        while (true) {
            if (i < size) {
                gvVar = this.f1148co.get(i);
                if (!gvVar.y.y()) {
                    break;
                }
                i++;
            } else {
                gvVar = null;
                break;
            }
        }
        if (gvVar != null) {
            gvVar.f1172n3.v(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && i == 82) {
            dismiss();
            return true;
        }
        return false;
    }

    @Override // tl.gv
    public void p(boolean z2) {
        this.f1163qn = z2;
    }

    @Override // tl.gv
    public void r(boolean z2) {
        this.f1159o = z2;
    }

    public final int rz() {
        if (i4.ta(this.f1150d0) != 1) {
            return 1;
        }
        return 0;
    }

    @Override // tl.a
    public void show() {
        boolean z2;
        if (y()) {
            return;
        }
        for (v vVar : this.f1161p) {
            ta(vVar);
        }
        this.f1161p.clear();
        View view = this.f1150d0;
        this.f1155fh = view;
        if (view != null) {
            if (this.f1160oz == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.f1160oz = viewTreeObserver;
            if (z2) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f1171z);
            }
            this.f1155fh.addOnAttachStateChangeListener(this.f1164r);
        }
    }

    public final void ta(@NonNull v vVar) {
        gv gvVar;
        View view;
        boolean z2;
        int i;
        int i5;
        int i6;
        LayoutInflater from = LayoutInflater.from(this.f1168v);
        androidx.appcompat.view.menu.gv gvVar2 = new androidx.appcompat.view.menu.gv(vVar, from, this.f1166t, f1145k);
        if (!y() && this.f1163qn) {
            gvVar2.gv(true);
        } else if (y()) {
            gvVar2.gv(tl.gv.i4(vVar));
        }
        int tl2 = tl.gv.tl(gvVar2, null, this.f1168v, this.f1154fb);
        ta n2 = n();
        n2.tl(gvVar2);
        n2.ta(tl2);
        n2.d(this.f1147c);
        if (this.f1148co.size() > 0) {
            List<gv> list = this.f1148co;
            gvVar = list.get(list.size() - 1);
            view = fh(gvVar, vVar);
        } else {
            gvVar = null;
            view = null;
        }
        if (view != null) {
            n2.j(false);
            n2.j5(null);
            int mg2 = mg(tl2);
            if (mg2 == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f1149d = mg2;
            if (Build.VERSION.SDK_INT >= 26) {
                n2.rz(view);
                i5 = 0;
                i = 0;
            } else {
                int[] iArr = new int[2];
                this.f1150d0.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.f1147c & 7) == 5) {
                    iArr[0] = iArr[0] + this.f1150d0.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i = iArr2[0] - iArr[0];
                i5 = iArr2[1] - iArr[1];
            }
            if ((this.f1147c & 5) == 5) {
                if (!z2) {
                    tl2 = view.getWidth();
                    i6 = i - tl2;
                }
                i6 = i + tl2;
            } else {
                if (z2) {
                    tl2 = view.getWidth();
                    i6 = i + tl2;
                }
                i6 = i - tl2;
            }
            n2.v(i6);
            n2.b(true);
            n2.c5(i5);
        } else {
            if (this.f1151ej) {
                n2.v(this.f1146b);
            }
            if (this.f1170x) {
                n2.c5(this.f1157j5);
            }
            n2.z6(t());
        }
        this.f1148co.add(new gv(n2, vVar, this.f1149d));
        n2.show();
        ListView xc2 = n2.xc();
        xc2.setOnKeyListener(this);
        if (gvVar == null && this.f1159o && vVar.f3() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(R$layout.f782t, (ViewGroup) xc2, false);
            frameLayout.setEnabled(false);
            ((TextView) frameLayout.findViewById(16908310)).setText(vVar.f3());
            xc2.addHeaderView(frameLayout, null, false);
            n2.show();
        }
    }

    @Override // androidx.appcompat.view.menu.c5
    public boolean v(t tVar) {
        for (gv gvVar : this.f1148co) {
            if (tVar == gvVar.f1172n3) {
                gvVar.y().requestFocus();
                return true;
            }
        }
        if (tVar.hasVisibleItems()) {
            i9(tVar);
            c5.y yVar = this.f1156j;
            if (yVar != null) {
                yVar.zn(tVar);
            }
            return true;
        }
        return false;
    }

    @Override // tl.gv
    public void wz(@NonNull View view) {
        if (this.f1150d0 != view) {
            this.f1150d0 = view;
            this.f1147c = hw.v.n3(this.f1158n, i4.ta(view));
        }
    }

    @Override // tl.gv
    public void x4(int i) {
        this.f1170x = true;
        this.f1157j5 = i;
    }

    @Override // tl.a
    public ListView xc() {
        if (this.f1148co.isEmpty()) {
            return null;
        }
        List<gv> list = this.f1148co;
        return list.get(list.size() - 1).y();
    }

    @Override // tl.a
    public boolean y() {
        if (this.f1148co.size() <= 0 || !this.f1148co.get(0).y.y()) {
            return false;
        }
        return true;
    }

    @Override // tl.gv
    public void z(PopupWindow.OnDismissListener onDismissListener) {
        this.f1167ut = onDismissListener;
    }
}
