package wz;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;
import androidx.appcompat.view.menu.v;
/* loaded from: classes.dex */
public class d {

    /* renamed from: gv  reason: collision with root package name */
    public final androidx.appcompat.view.menu.s f14705gv;

    /* renamed from: n3  reason: collision with root package name */
    public final androidx.appcompat.view.menu.v f14706n3;

    /* renamed from: v  reason: collision with root package name */
    public zn f14707v;
    public final Context y;

    /* renamed from: zn  reason: collision with root package name */
    public final View f14708zn;

    /* loaded from: classes.dex */
    public class n3 implements PopupWindow.OnDismissListener {
        public n3() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            d.this.getClass();
        }
    }

    /* loaded from: classes.dex */
    public interface zn {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public d(@NonNull Context context, @NonNull View view) {
        this(context, view, 0);
    }

    public void gv(@Nullable zn znVar) {
        this.f14707v = znVar;
    }

    @NonNull
    public MenuInflater n3() {
        return new t.fb(this.y);
    }

    public void v() {
        this.f14705gv.f();
    }

    public void y() {
        this.f14705gv.n3();
    }

    public void zn(int i) {
        n3().inflate(i, this.f14706n3);
    }

    public d(@NonNull Context context, @NonNull View view, int i) {
        this(context, view, i, R$attr.f631d, 0);
    }

    public d(@NonNull Context context, @NonNull View view, int i, int i5, int i6) {
        this.y = context;
        this.f14708zn = view;
        androidx.appcompat.view.menu.v vVar = new androidx.appcompat.view.menu.v(context);
        this.f14706n3 = vVar;
        vVar.qn(new y());
        androidx.appcompat.view.menu.s sVar = new androidx.appcompat.view.menu.s(context, vVar, view, false, i5, i6);
        this.f14705gv = sVar;
        sVar.s(i);
        sVar.c5(new n3());
    }

    /* loaded from: classes.dex */
    public class y implements v.y {
        public y() {
        }

        @Override // androidx.appcompat.view.menu.v.y
        public boolean y(@NonNull androidx.appcompat.view.menu.v vVar, @NonNull MenuItem menuItem) {
            zn znVar = d.this.f14707v;
            if (znVar != null) {
                return znVar.onMenuItemClick(menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.v.y
        public void n3(@NonNull androidx.appcompat.view.menu.v vVar) {
        }
    }
}
