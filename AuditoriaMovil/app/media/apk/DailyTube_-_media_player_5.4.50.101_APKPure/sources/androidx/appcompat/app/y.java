package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.AlertController;
import s.a;
/* loaded from: classes.dex */
public class y extends a implements DialogInterface {

    /* renamed from: fb  reason: collision with root package name */
    public final AlertController f1033fb;

    /* renamed from: androidx.appcompat.app.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0011y {

        /* renamed from: n3  reason: collision with root package name */
        public final int f1034n3;
        public final AlertController.a y;

        public C0011y(@NonNull Context context) {
            this(context, y.a(context, 0));
        }

        public C0011y a(int i) {
            AlertController.a aVar = this.y;
            aVar.f1001s = aVar.y.getText(i);
            return this;
        }

        public C0011y c5(DialogInterface.OnCancelListener onCancelListener) {
            this.y.f982co = onCancelListener;
            return this;
        }

        @NonNull
        public y create() {
            y yVar = new y(this.y.y, this.f1034n3);
            this.y.y(yVar.f1033fb);
            yVar.setCancelable(this.y.f995mt);
            if (this.y.f995mt) {
                yVar.setCanceledOnTouchOutside(true);
            }
            yVar.setOnCancelListener(this.y.f982co);
            yVar.setOnDismissListener(this.y.f1014z);
            DialogInterface.OnKeyListener onKeyListener = this.y.f999r;
            if (onKeyListener != null) {
                yVar.setOnKeyListener(onKeyListener);
            }
            return yVar;
        }

        public C0011y f(DialogInterface.OnKeyListener onKeyListener) {
            this.y.f999r = onKeyListener;
            return this;
        }

        public C0011y fb(@Nullable CharSequence charSequence) {
            this.y.f1001s = charSequence;
            return this;
        }

        @NonNull
        public Context getContext() {
            return this.y.y;
        }

        public C0011y gv(int i) {
            this.y.f1016zn = i;
            return this;
        }

        public C0011y i9(DialogInterface.OnDismissListener onDismissListener) {
            this.y.f1014z = onDismissListener;
            return this;
        }

        public C0011y n3(boolean z2) {
            this.y.f995mt = z2;
            return this;
        }

        public C0011y s(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.y;
            aVar.f1012xc = aVar.y.getText(i);
            this.y.f998p = onClickListener;
            return this;
        }

        public C0011y setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.y;
            aVar.f1002t = aVar.y.getText(i);
            this.y.f1009wz = onClickListener;
            return this;
        }

        public C0011y setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.y;
            aVar.f981c5 = aVar.y.getText(i);
            this.y.f986f = onClickListener;
            return this;
        }

        public C0011y setTitle(@Nullable CharSequence charSequence) {
            this.y.f977a = charSequence;
            return this;
        }

        public C0011y setView(View view) {
            AlertController.a aVar = this.y;
            aVar.f980c = view;
            aVar.f996n = 0;
            aVar.f1003ta = false;
            return this;
        }

        public C0011y t(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.y;
            aVar.f981c5 = charSequence;
            aVar.f986f = onClickListener;
            return this;
        }

        public C0011y tl(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.y;
            aVar.f991i4 = listAdapter;
            aVar.f987f3 = onClickListener;
            aVar.f1005ud = i;
            aVar.f985ej = true;
            return this;
        }

        public C0011y v(@Nullable Drawable drawable) {
            this.y.f990gv = drawable;
            return this;
        }

        public C0011y wz(int i) {
            AlertController.a aVar = this.y;
            aVar.f977a = aVar.y.getText(i);
            return this;
        }

        public y xc() {
            y create = create();
            create.show();
            return create;
        }

        public C0011y y(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.y;
            aVar.f991i4 = listAdapter;
            aVar.f987f3 = onClickListener;
            return this;
        }

        public C0011y zn(@Nullable View view) {
            this.y.f988fb = view;
            return this;
        }

        public C0011y(@NonNull Context context, int i) {
            this.y = new AlertController.a(new ContextThemeWrapper(context, y.a(context, i)));
            this.f1034n3 = i;
        }
    }

    public y(@NonNull Context context, int i) {
        super(context, a(context, i));
        this.f1033fb = new AlertController(getContext(), this, getWindow());
    }

    public static int a(@NonNull Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.f660xc, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // s.a, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1033fb.v();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f1033fb.fb(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f1033fb.s(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // s.a, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f1033fb.p(charSequence);
    }

    public ListView v() {
        return this.f1033fb.gv();
    }
}
