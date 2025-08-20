package tl;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.c5;
/* loaded from: classes.dex */
public abstract class gv implements a, c5, AdapterView.OnItemClickListener {
    public Rect y;

    public static androidx.appcompat.view.menu.gv f3(ListAdapter listAdapter) {
        if (listAdapter instanceof HeaderViewListAdapter) {
            return (androidx.appcompat.view.menu.gv) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        }
        return (androidx.appcompat.view.menu.gv) listAdapter;
    }

    public static boolean i4(androidx.appcompat.view.menu.v vVar) {
        int size = vVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = vVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    public static int tl(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        View view = null;
        int i5 = 0;
        int i6 = 0;
        for (int i8 = 0; i8 < count; i8++) {
            int itemViewType = listAdapter.getItemViewType(i8);
            if (itemViewType != i6) {
                view = null;
                i6 = itemViewType;
            }
            if (viewGroup == null) {
                viewGroup = new FrameLayout(context);
            }
            view = listAdapter.getView(i8, view, viewGroup);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i) {
                return i;
            }
            if (measuredWidth > i5) {
                i5 = measuredWidth;
            }
        }
        return i5;
    }

    public abstract void co(int i);

    public boolean f() {
        return true;
    }

    public abstract void i9(androidx.appcompat.view.menu.v vVar);

    public abstract void mt(int i);

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j2) {
        int i5;
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        androidx.appcompat.view.menu.v vVar = f3(listAdapter).y;
        MenuItem menuItem = (MenuItem) listAdapter.getItem(i);
        if (f()) {
            i5 = 0;
        } else {
            i5 = 4;
        }
        vVar.k5(menuItem, this, i5);
    }

    public abstract void p(boolean z2);

    public abstract void r(boolean z2);

    @Override // androidx.appcompat.view.menu.c5
    public boolean s(androidx.appcompat.view.menu.v vVar, androidx.appcompat.view.menu.fb fbVar) {
        return false;
    }

    public Rect t() {
        return this.y;
    }

    public void w(Rect rect) {
        this.y = rect;
    }

    public abstract void wz(View view);

    public abstract void x4(int i);

    public abstract void z(PopupWindow.OnDismissListener onDismissListener);

    @Override // androidx.appcompat.view.menu.c5
    public boolean zn(androidx.appcompat.view.menu.v vVar, androidx.appcompat.view.menu.fb fbVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.c5
    public void c5(@NonNull Context context, @Nullable androidx.appcompat.view.menu.v vVar) {
    }
}
