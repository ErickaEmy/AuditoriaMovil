package androidx.appcompat.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.v;
import wz.hw;
/* loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements v.n3, i9, AdapterView.OnItemClickListener {

    /* renamed from: fb  reason: collision with root package name */
    public static final int[] f1068fb = {16842964, 16843049};

    /* renamed from: v  reason: collision with root package name */
    public int f1069v;
    public v y;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public int getWindowAnimations() {
        return this.f1069v;
    }

    @Override // androidx.appcompat.view.menu.v.n3
    public boolean gv(fb fbVar) {
        return this.y.b(fbVar, 0);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j2) {
        gv((fb) getAdapter().getItem(i));
    }

    @Override // androidx.appcompat.view.menu.i9
    public void y(v vVar) {
        this.y = vVar;
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        hw x42 = hw.x4(context, attributeSet, f1068fb, i, 0);
        if (x42.co(0)) {
            setBackgroundDrawable(x42.fb(0));
        }
        if (x42.co(1)) {
            setDivider(x42.fb(1));
        }
        x42.i4();
    }
}
