package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.c5;
import androidx.appcompat.view.menu.i9;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class y implements c5 {

    /* renamed from: co  reason: collision with root package name */
    public i9 f1216co;

    /* renamed from: f  reason: collision with root package name */
    public LayoutInflater f1217f;

    /* renamed from: fb  reason: collision with root package name */
    public v f1218fb;

    /* renamed from: p  reason: collision with root package name */
    public int f1219p;

    /* renamed from: s  reason: collision with root package name */
    public LayoutInflater f1220s;

    /* renamed from: t  reason: collision with root package name */
    public c5.y f1221t;

    /* renamed from: v  reason: collision with root package name */
    public Context f1222v;

    /* renamed from: w  reason: collision with root package name */
    public int f1223w;
    public Context y;

    /* renamed from: z  reason: collision with root package name */
    public int f1224z;

    public y(Context context, int i, int i5) {
        this.y = context;
        this.f1220s = LayoutInflater.from(context);
        this.f1223w = i;
        this.f1219p = i5;
    }

    @Override // androidx.appcompat.view.menu.c5
    public void a(boolean z2) {
        fb fbVar;
        ViewGroup viewGroup = (ViewGroup) this.f1216co;
        if (viewGroup == null) {
            return;
        }
        v vVar = this.f1218fb;
        int i = 0;
        if (vVar != null) {
            vVar.mt();
            ArrayList<fb> ta2 = this.f1218fb.ta();
            int size = ta2.size();
            int i5 = 0;
            for (int i6 = 0; i6 < size; i6++) {
                fb fbVar2 = ta2.get(i6);
                if (p(i5, fbVar2)) {
                    View childAt = viewGroup.getChildAt(i5);
                    if (childAt instanceof i9.y) {
                        fbVar = ((i9.y) childAt).getItemData();
                    } else {
                        fbVar = null;
                    }
                    View wz2 = wz(fbVar2, childAt, viewGroup);
                    if (fbVar2 != fbVar) {
                        wz2.setPressed(false);
                        wz2.jumpDrawablesToCurrentState();
                    }
                    if (wz2 != childAt) {
                        y(wz2, i5);
                    }
                    i5++;
                }
            }
            i = i5;
        }
        while (i < viewGroup.getChildCount()) {
            if (!t(viewGroup, i)) {
                i++;
            }
        }
    }

    @Override // androidx.appcompat.view.menu.c5
    public void c5(Context context, v vVar) {
        this.f1222v = context;
        this.f1217f = LayoutInflater.from(context);
        this.f1218fb = vVar;
    }

    public i9.y f(ViewGroup viewGroup) {
        return (i9.y) this.f1220s.inflate(this.f1219p, viewGroup, false);
    }

    @Override // androidx.appcompat.view.menu.c5
    public void gv(c5.y yVar) {
        this.f1221t = yVar;
    }

    public abstract void i9(fb fbVar, i9.y yVar);

    @Override // androidx.appcompat.view.menu.c5
    public void n3(v vVar, boolean z2) {
        c5.y yVar = this.f1221t;
        if (yVar != null) {
            yVar.n3(vVar, z2);
        }
    }

    public abstract boolean p(int i, fb fbVar);

    @Override // androidx.appcompat.view.menu.c5
    public boolean s(v vVar, fb fbVar) {
        return false;
    }

    public boolean t(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public c5.y tl() {
        return this.f1221t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.appcompat.view.menu.v] */
    @Override // androidx.appcompat.view.menu.c5
    public boolean v(t tVar) {
        c5.y yVar = this.f1221t;
        t tVar2 = tVar;
        if (yVar != null) {
            if (tVar == null) {
                tVar2 = this.f1218fb;
            }
            return yVar.zn(tVar2);
        }
        return false;
    }

    public void w(int i) {
        this.f1224z = i;
    }

    public View wz(fb fbVar, View view, ViewGroup viewGroup) {
        i9.y f4;
        if (view instanceof i9.y) {
            f4 = (i9.y) view;
        } else {
            f4 = f(viewGroup);
        }
        i9(fbVar, f4);
        return (View) f4;
    }

    public i9 xc(ViewGroup viewGroup) {
        if (this.f1216co == null) {
            i9 i9Var = (i9) this.f1220s.inflate(this.f1223w, viewGroup, false);
            this.f1216co = i9Var;
            i9Var.y(this.f1218fb);
            a(true);
        }
        return this.f1216co;
    }

    public void y(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f1216co).addView(view, i);
    }

    @Override // androidx.appcompat.view.menu.c5
    public boolean zn(v vVar, fb fbVar) {
        return false;
    }
}
