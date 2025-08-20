package wz;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class ta extends rz implements mg {

    /* renamed from: o4  reason: collision with root package name */
    public static Method f14808o4;

    /* renamed from: ct  reason: collision with root package name */
    public mg f14809ct;

    /* loaded from: classes.dex */
    public static class y extends c {

        /* renamed from: d  reason: collision with root package name */
        public mg f14810d;

        /* renamed from: d0  reason: collision with root package name */
        public final int f14811d0;

        /* renamed from: ej  reason: collision with root package name */
        public MenuItem f14812ej;

        /* renamed from: fh  reason: collision with root package name */
        public final int f14813fh;

        public y(Context context, boolean z2) {
            super(context, z2);
            if (1 == context.getResources().getConfiguration().getLayoutDirection()) {
                this.f14811d0 = 21;
                this.f14813fh = 22;
                return;
            }
            this.f14811d0 = 22;
            this.f14813fh = 21;
        }

        @Override // wz.c
        public /* bridge */ /* synthetic */ int gv(int i, int i5, int i6, int i8, int i10) {
            return super.gv(i, i5, i6, i8, i10);
        }

        @Override // wz.c, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // wz.c, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // wz.c, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // wz.c, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // wz.c, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            androidx.appcompat.view.menu.gv gvVar;
            int i;
            androidx.appcompat.view.menu.fb fbVar;
            int pointToPosition;
            int i5;
            if (this.f14810d != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i = headerViewListAdapter.getHeadersCount();
                    gvVar = (androidx.appcompat.view.menu.gv) headerViewListAdapter.getWrappedAdapter();
                } else {
                    gvVar = (androidx.appcompat.view.menu.gv) adapter;
                    i = 0;
                }
                if (motionEvent.getAction() != 10 && (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i5 = pointToPosition - i) >= 0 && i5 < gvVar.getCount()) {
                    fbVar = gvVar.getItem(i5);
                } else {
                    fbVar = null;
                }
                MenuItem menuItem = this.f14812ej;
                if (menuItem != fbVar) {
                    androidx.appcompat.view.menu.v n32 = gvVar.n3();
                    if (menuItem != null) {
                        this.f14810d.wz(n32, menuItem);
                    }
                    this.f14812ej = fbVar;
                    if (fbVar != null) {
                        this.f14810d.gv(n32, fbVar);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            androidx.appcompat.view.menu.gv gvVar;
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i == this.f14811d0) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView != null && i == this.f14813fh) {
                setSelection(-1);
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    gvVar = (androidx.appcompat.view.menu.gv) ((HeaderViewListAdapter) adapter).getWrappedAdapter();
                } else {
                    gvVar = (androidx.appcompat.view.menu.gv) adapter;
                }
                gvVar.n3().v(false);
                return true;
            } else {
                return super.onKeyDown(i, keyEvent);
            }
        }

        @Override // wz.c, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setHoverListener(mg mgVar) {
            this.f14810d = mgVar;
        }

        @Override // wz.c, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }

        @Override // wz.c
        public /* bridge */ /* synthetic */ boolean v(MotionEvent motionEvent, int i) {
            return super.v(motionEvent, i);
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                f14808o4 = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
        }
    }

    public ta(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i5) {
        super(context, attributeSet, i, i5);
    }

    @Override // wz.mg
    public void gv(@NonNull androidx.appcompat.view.menu.v vVar, @NonNull MenuItem menuItem) {
        mg mgVar = this.f14809ct;
        if (mgVar != null) {
            mgVar.gv(vVar, menuItem);
        }
    }

    public void j(boolean z2) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = f14808o4;
            if (method != null) {
                try {
                    method.invoke(this.f14795u, Boolean.valueOf(z2));
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            return;
        }
        this.f14795u.setTouchModal(z2);
    }

    public void j5(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f14795u.setEnterTransition((Transition) obj);
        }
    }

    @Override // wz.rz
    @NonNull
    public c mt(Context context, boolean z2) {
        y yVar = new y(context, z2);
        yVar.setHoverListener(this);
        return yVar;
    }

    public void o(mg mgVar) {
        this.f14809ct = mgVar;
    }

    public void qn(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f14795u.setExitTransition((Transition) obj);
        }
    }

    @Override // wz.mg
    public void wz(@NonNull androidx.appcompat.view.menu.v vVar, @NonNull MenuItem menuItem) {
        mg mgVar = this.f14809ct;
        if (mgVar != null) {
            mgVar.wz(vVar, menuItem);
        }
    }
}
