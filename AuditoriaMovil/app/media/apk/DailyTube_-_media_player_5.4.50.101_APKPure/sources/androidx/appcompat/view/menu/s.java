package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$dimen;
import androidx.appcompat.view.menu.c5;
import hw.i4;
/* loaded from: classes.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    public View f1177a;

    /* renamed from: c5  reason: collision with root package name */
    public c5.y f1178c5;

    /* renamed from: f  reason: collision with root package name */
    public PopupWindow.OnDismissListener f1179f;

    /* renamed from: fb  reason: collision with root package name */
    public int f1180fb;

    /* renamed from: gv  reason: collision with root package name */
    public final int f1181gv;

    /* renamed from: i9  reason: collision with root package name */
    public tl.gv f1182i9;

    /* renamed from: n3  reason: collision with root package name */
    public final v f1183n3;

    /* renamed from: s  reason: collision with root package name */
    public boolean f1184s;

    /* renamed from: t  reason: collision with root package name */
    public final PopupWindow.OnDismissListener f1185t;

    /* renamed from: v  reason: collision with root package name */
    public final int f1186v;
    public final Context y;

    /* renamed from: zn  reason: collision with root package name */
    public final boolean f1187zn;

    /* loaded from: classes.dex */
    public class y implements PopupWindow.OnDismissListener {
        public y() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            s.this.v();
        }
    }

    public s(@NonNull Context context, @NonNull v vVar, @NonNull View view, boolean z2, int i) {
        this(context, vVar, view, z2, i, 0);
    }

    public void a(@NonNull View view) {
        this.f1177a = view;
    }

    public void c5(@Nullable PopupWindow.OnDismissListener onDismissListener) {
        this.f1179f = onDismissListener;
    }

    public void f() {
        if (tl()) {
            return;
        }
        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }

    public void fb(boolean z2) {
        this.f1184s = z2;
        tl.gv gvVar = this.f1182i9;
        if (gvVar != null) {
            gvVar.p(z2);
        }
    }

    public boolean gv() {
        tl.gv gvVar = this.f1182i9;
        if (gvVar != null && gvVar.y()) {
            return true;
        }
        return false;
    }

    public void i9(@Nullable c5.y yVar) {
        this.f1178c5 = yVar;
        tl.gv gvVar = this.f1182i9;
        if (gvVar != null) {
            gvVar.gv(yVar);
        }
    }

    public void n3() {
        if (gv()) {
            this.f1182i9.dismiss();
        }
    }

    public void s(int i) {
        this.f1180fb = i;
    }

    public final void t(int i, int i5, boolean z2, boolean z3) {
        tl.gv zn2 = zn();
        zn2.r(z3);
        if (z2) {
            if ((hw.v.n3(this.f1180fb, i4.ta(this.f1177a)) & 7) == 5) {
                i -= this.f1177a.getWidth();
            }
            zn2.co(i);
            zn2.x4(i5);
            int i6 = (int) ((this.y.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            zn2.w(new Rect(i - i6, i5 - i6, i + i6, i5 + i6));
        }
        zn2.show();
    }

    public boolean tl() {
        if (gv()) {
            return true;
        }
        if (this.f1177a == null) {
            return false;
        }
        t(0, 0, false, false);
        return true;
    }

    public void v() {
        this.f1182i9 = null;
        PopupWindow.OnDismissListener onDismissListener = this.f1179f;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public boolean wz(int i, int i5) {
        if (gv()) {
            return true;
        }
        if (this.f1177a == null) {
            return false;
        }
        t(i, i5, true, true);
        return true;
    }

    @NonNull
    public final tl.gv y() {
        tl.gv fVar;
        Display defaultDisplay = ((WindowManager) this.y.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        if (Math.min(point.x, point.y) >= this.y.getResources().getDimensionPixelSize(R$dimen.f685zn)) {
            fVar = new n3(this.y, this.f1177a, this.f1181gv, this.f1186v, this.f1187zn);
        } else {
            fVar = new f(this.y, this.f1183n3, this.f1177a, this.f1181gv, this.f1186v, this.f1187zn);
        }
        fVar.i9(this.f1183n3);
        fVar.z(this.f1185t);
        fVar.wz(this.f1177a);
        fVar.gv(this.f1178c5);
        fVar.p(this.f1184s);
        fVar.mt(this.f1180fb);
        return fVar;
    }

    @NonNull
    public tl.gv zn() {
        if (this.f1182i9 == null) {
            this.f1182i9 = y();
        }
        return this.f1182i9;
    }

    public s(@NonNull Context context, @NonNull v vVar, @NonNull View view, boolean z2, int i, int i5) {
        this.f1180fb = 8388611;
        this.f1185t = new y();
        this.y = context;
        this.f1183n3 = vVar;
        this.f1177a = view;
        this.f1187zn = z2;
        this.f1181gv = i;
        this.f1186v = i5;
    }
}
