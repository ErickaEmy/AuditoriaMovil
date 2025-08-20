package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.appcompat.R$layout;
import androidx.appcompat.app.y;
import androidx.appcompat.view.menu.c5;
/* loaded from: classes.dex */
public class a implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, c5.y {

    /* renamed from: fb  reason: collision with root package name */
    public zn f1086fb;

    /* renamed from: s  reason: collision with root package name */
    public c5.y f1087s;

    /* renamed from: v  reason: collision with root package name */
    public androidx.appcompat.app.y f1088v;
    public v y;

    public a(v vVar) {
        this.y = vVar;
    }

    public void gv(IBinder iBinder) {
        v vVar = this.y;
        y.C0011y c0011y = new y.C0011y(vVar.r());
        zn znVar = new zn(c0011y.getContext(), R$layout.f777i9);
        this.f1086fb = znVar;
        znVar.gv(this);
        this.y.n3(this.f1086fb);
        c0011y.y(this.f1086fb.y(), this);
        View n2 = vVar.n();
        if (n2 != null) {
            c0011y.zn(n2);
        } else {
            c0011y.v(vVar.i4()).setTitle(vVar.f3());
        }
        c0011y.f(this);
        androidx.appcompat.app.y create = c0011y.create();
        this.f1088v = create;
        create.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f1088v.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f1088v.show();
    }

    @Override // androidx.appcompat.view.menu.c5.y
    public void n3(@NonNull v vVar, boolean z2) {
        if (z2 || vVar == this.y) {
            y();
        }
        c5.y yVar = this.f1087s;
        if (yVar != null) {
            yVar.n3(vVar, z2);
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.y.b((fb) this.f1086fb.y().getItem(i), 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f1086fb.n3(this.y, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f1088v.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f1088v.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.y.v(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.y.performShortcut(i, keyEvent, 0);
    }

    public void y() {
        androidx.appcompat.app.y yVar = this.f1088v;
        if (yVar != null) {
            yVar.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.c5.y
    public boolean zn(@NonNull v vVar) {
        c5.y yVar = this.f1087s;
        if (yVar != null) {
            return yVar.zn(vVar);
        }
        return false;
    }
}
