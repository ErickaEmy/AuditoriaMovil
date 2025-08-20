package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.i9;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class gv extends BaseAdapter {

    /* renamed from: f  reason: collision with root package name */
    public final LayoutInflater f1140f;

    /* renamed from: fb  reason: collision with root package name */
    public boolean f1141fb;

    /* renamed from: s  reason: collision with root package name */
    public final boolean f1142s;

    /* renamed from: t  reason: collision with root package name */
    public final int f1143t;

    /* renamed from: v  reason: collision with root package name */
    public int f1144v = -1;
    public v y;

    public gv(v vVar, LayoutInflater layoutInflater, boolean z2, int i) {
        this.f1142s = z2;
        this.f1140f = layoutInflater;
        this.y = vVar;
        this.f1143t = i;
        y();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<fb> ta2;
        if (this.f1142s) {
            ta2 = this.y.c();
        } else {
            ta2 = this.y.ta();
        }
        if (this.f1144v < 0) {
            return ta2.size();
        }
        return ta2.size() - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int i5;
        boolean z2;
        if (view == null) {
            view = this.f1140f.inflate(this.f1143t, viewGroup, false);
        }
        int groupId = getItem(i).getGroupId();
        int i6 = i - 1;
        if (i6 >= 0) {
            i5 = getItem(i6).getGroupId();
        } else {
            i5 = groupId;
        }
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (this.y.d() && groupId != i5) {
            z2 = true;
        } else {
            z2 = false;
        }
        listMenuItemView.setGroupDividerEnabled(z2);
        i9.y yVar = (i9.y) view;
        if (this.f1141fb) {
            listMenuItemView.setForceShowIcon(true);
        }
        yVar.zn(getItem(i), 0);
        return view;
    }

    public void gv(boolean z2) {
        this.f1141fb = z2;
    }

    public v n3() {
        return this.y;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        y();
        super.notifyDataSetChanged();
    }

    public void y() {
        fb x42 = this.y.x4();
        if (x42 != null) {
            ArrayList<fb> c2 = this.y.c();
            int size = c2.size();
            for (int i = 0; i < size; i++) {
                if (c2.get(i) == x42) {
                    this.f1144v = i;
                    return;
                }
            }
        }
        this.f1144v = -1;
    }

    @Override // android.widget.Adapter
    /* renamed from: zn */
    public fb getItem(int i) {
        ArrayList<fb> ta2;
        if (this.f1142s) {
            ta2 = this.y.c();
        } else {
            ta2 = this.y.ta();
        }
        int i5 = this.f1144v;
        if (i5 >= 0 && i >= i5) {
            i++;
        }
        return ta2.get(i);
    }
}
