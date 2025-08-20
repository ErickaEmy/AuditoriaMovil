package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.c5;
import androidx.appcompat.view.menu.i9;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class zn implements c5, AdapterView.OnItemClickListener {

    /* renamed from: co  reason: collision with root package name */
    public y f1225co;

    /* renamed from: f  reason: collision with root package name */
    public int f1226f;

    /* renamed from: fb  reason: collision with root package name */
    public v f1227fb;

    /* renamed from: p  reason: collision with root package name */
    public c5.y f1228p;

    /* renamed from: s  reason: collision with root package name */
    public ExpandedMenuView f1229s;

    /* renamed from: t  reason: collision with root package name */
    public int f1230t;

    /* renamed from: v  reason: collision with root package name */
    public LayoutInflater f1231v;

    /* renamed from: w  reason: collision with root package name */
    public int f1232w;
    public Context y;

    /* loaded from: classes.dex */
    public class y extends BaseAdapter {
        public int y = -1;

        public y() {
            y();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = zn.this.f1227fb.c().size() - zn.this.f1226f;
            if (this.y < 0) {
                return size;
            }
            return size - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                zn znVar = zn.this;
                view = znVar.f1231v.inflate(znVar.f1232w, viewGroup, false);
            }
            ((i9.y) view).zn(getItem(i), 0);
            return view;
        }

        @Override // android.widget.Adapter
        /* renamed from: n3 */
        public fb getItem(int i) {
            ArrayList<fb> c2 = zn.this.f1227fb.c();
            int i5 = i + zn.this.f1226f;
            int i6 = this.y;
            if (i6 >= 0 && i5 >= i6) {
                i5++;
            }
            return c2.get(i5);
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            y();
            super.notifyDataSetChanged();
        }

        public void y() {
            fb x42 = zn.this.f1227fb.x4();
            if (x42 != null) {
                ArrayList<fb> c2 = zn.this.f1227fb.c();
                int size = c2.size();
                for (int i = 0; i < size; i++) {
                    if (c2.get(i) == x42) {
                        this.y = i;
                        return;
                    }
                }
            }
            this.y = -1;
        }
    }

    public zn(Context context, int i) {
        this(i, 0);
        this.y = context;
        this.f1231v = LayoutInflater.from(context);
    }

    @Override // androidx.appcompat.view.menu.c5
    public void a(boolean z2) {
        y yVar = this.f1225co;
        if (yVar != null) {
            yVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.c5
    public void c5(Context context, v vVar) {
        if (this.f1230t != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.f1230t);
            this.y = contextThemeWrapper;
            this.f1231v = LayoutInflater.from(contextThemeWrapper);
        } else if (this.y != null) {
            this.y = context;
            if (this.f1231v == null) {
                this.f1231v = LayoutInflater.from(context);
            }
        }
        this.f1227fb = vVar;
        y yVar = this.f1225co;
        if (yVar != null) {
            yVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.c5
    public boolean fb() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.c5
    public void gv(c5.y yVar) {
        this.f1228p = yVar;
    }

    public i9 i9(ViewGroup viewGroup) {
        if (this.f1229s == null) {
            this.f1229s = (ExpandedMenuView) this.f1231v.inflate(R$layout.f775fb, viewGroup, false);
            if (this.f1225co == null) {
                this.f1225co = new y();
            }
            this.f1229s.setAdapter((ListAdapter) this.f1225co);
            this.f1229s.setOnItemClickListener(this);
        }
        return this.f1229s;
    }

    @Override // androidx.appcompat.view.menu.c5
    public void n3(v vVar, boolean z2) {
        c5.y yVar = this.f1228p;
        if (yVar != null) {
            yVar.n3(vVar, z2);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j2) {
        this.f1227fb.k5(this.f1225co.getItem(i), this, 0);
    }

    @Override // androidx.appcompat.view.menu.c5
    public boolean s(v vVar, fb fbVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.c5
    public boolean v(t tVar) {
        if (!tVar.hasVisibleItems()) {
            return false;
        }
        new a(tVar).gv(null);
        c5.y yVar = this.f1228p;
        if (yVar != null) {
            yVar.zn(tVar);
            return true;
        }
        return true;
    }

    public ListAdapter y() {
        if (this.f1225co == null) {
            this.f1225co = new y();
        }
        return this.f1225co;
    }

    @Override // androidx.appcompat.view.menu.c5
    public boolean zn(v vVar, fb fbVar) {
        return false;
    }

    public zn(int i, int i5) {
        this.f1232w = i;
        this.f1230t = i5;
    }
}
