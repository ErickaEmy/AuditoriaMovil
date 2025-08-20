package s;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;
import hw.a;
import t.n3;
/* loaded from: classes.dex */
public class a extends Dialog implements zn {

    /* renamed from: v  reason: collision with root package name */
    public final a.y f13371v;
    public gv y;

    /* loaded from: classes.dex */
    public class y implements a.y {
        public y() {
        }

        @Override // hw.a.y
        public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
            return a.this.zn(keyEvent);
        }
    }

    public a(Context context, int i) {
        super(context, n3(context, i));
        this.f13371v = new y();
        gv y2 = y();
        y2.z6(n3(context, i));
        y2.co(null);
    }

    private static int n3(Context context, int i) {
        if (i == 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R$attr.f644n, typedValue, true);
            return typedValue.resourceId;
        }
        return i;
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        y().gv(view, layoutParams);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        y().z();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return hw.a.v(this.f13371v, getWindow().getDecorView(), this, keyEvent);
    }

    @Override // android.app.Dialog
    @Nullable
    public <T extends View> T findViewById(int i) {
        return (T) y().i9(i);
    }

    public boolean gv(int i) {
        return y().fh(i);
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        y().p();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        y().w();
        super.onCreate(bundle);
        y().co(bundle);
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
        y().n();
    }

    @Override // s.zn
    @Nullable
    public t.n3 onWindowStartingSupportActionMode(n3.y yVar) {
        return null;
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        y().rz(i);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        y().ej(charSequence);
    }

    public gv y() {
        if (this.y == null) {
            this.y = gv.s(this, this);
        }
        return this.y;
    }

    public boolean zn(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        y().mg(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        y().ta(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i) {
        super.setTitle(i);
        y().ej(getContext().getString(i));
    }

    @Override // s.zn
    public void onSupportActionModeFinished(t.n3 n3Var) {
    }

    @Override // s.zn
    public void onSupportActionModeStarted(t.n3 n3Var) {
    }
}
