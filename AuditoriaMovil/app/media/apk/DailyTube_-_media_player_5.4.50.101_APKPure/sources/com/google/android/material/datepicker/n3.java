package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.internal.CheckableImageButton;
import hw.i4;
import hx.fb;
import java.util.Iterator;
import java.util.LinkedHashSet;
import qg.a;
import qg.s;
/* loaded from: classes.dex */
public final class n3<S> extends DialogFragment {

    /* renamed from: ct  reason: collision with root package name */
    public static final Object f5651ct = "CONFIRM_BUTTON_TAG";

    /* renamed from: o4  reason: collision with root package name */
    public static final Object f5652o4 = "CANCEL_BUTTON_TAG";

    /* renamed from: rs  reason: collision with root package name */
    public static final Object f5653rs = "TOGGLE_BUTTON_TAG";

    /* renamed from: dm  reason: collision with root package name */
    public Button f5656dm;
    @Nullable

    /* renamed from: ej  reason: collision with root package name */
    public DateSelector<S> f5657ej;

    /* renamed from: en  reason: collision with root package name */
    public int f5658en;

    /* renamed from: f7  reason: collision with root package name */
    public boolean f5660f7;

    /* renamed from: fh  reason: collision with root package name */
    public int f5662fh;

    /* renamed from: j5  reason: collision with root package name */
    public s<S> f5663j5;

    /* renamed from: jz  reason: collision with root package name */
    public TextView f5664jz;

    /* renamed from: oz  reason: collision with root package name */
    public com.google.android.material.datepicker.y<S> f5665oz;

    /* renamed from: q9  reason: collision with root package name */
    public CharSequence f5666q9;
    @Nullable

    /* renamed from: qn  reason: collision with root package name */
    public CalendarConstraints f5667qn;

    /* renamed from: ut  reason: collision with root package name */
    public int f5668ut;
    @Nullable

    /* renamed from: xg  reason: collision with root package name */
    public fb f5669xg;

    /* renamed from: y5  reason: collision with root package name */
    public CheckableImageButton f5670y5;

    /* renamed from: fb  reason: collision with root package name */
    public final LinkedHashSet<qg.v<? super S>> f5661fb = new LinkedHashSet<>();

    /* renamed from: co  reason: collision with root package name */
    public final LinkedHashSet<View.OnClickListener> f5654co = new LinkedHashSet<>();

    /* renamed from: f3  reason: collision with root package name */
    public final LinkedHashSet<DialogInterface.OnCancelListener> f5659f3 = new LinkedHashSet<>();

    /* renamed from: d0  reason: collision with root package name */
    public final LinkedHashSet<DialogInterface.OnDismissListener> f5655d0 = new LinkedHashSet<>();

    /* loaded from: classes.dex */
    public class gv implements View.OnClickListener {
        public gv() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            n3.this.f5656dm.setEnabled(n3.this.f5657ej.pq());
            n3.this.f5670y5.toggle();
            n3 n3Var = n3.this;
            n3Var.ky(n3Var.f5670y5);
            n3.this.el();
        }
    }

    /* renamed from: com.google.android.material.datepicker.n3$n3  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0060n3 implements View.OnClickListener {
        public View$OnClickListenerC0060n3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = n3.this.f5654co.iterator();
            while (it.hasNext()) {
                ((View.OnClickListener) it.next()).onClick(view);
            }
            n3.this.dismiss();
        }
    }

    /* loaded from: classes.dex */
    public class y implements View.OnClickListener {
        public y() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = n3.this.f5661fb.iterator();
            while (it.hasNext()) {
                ((qg.v) it.next()).y(n3.this.w5());
            }
            n3.this.dismiss();
        }
    }

    /* loaded from: classes.dex */
    public class zn extends qg.fb<S> {
        public zn() {
        }

        @Override // qg.fb
        public void y(S s2) {
            n3.this.g6();
            n3.this.f5656dm.setEnabled(n3.this.f5657ej.pq());
        }
    }

    public static int fm(@NonNull Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R$dimen.ln);
        int i = Month.gv().f5641s;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(R$dimen.l4) * i) + ((i - 1) * resources.getDimensionPixelOffset(R$dimen.iu));
    }

    @NonNull
    public static Drawable gm(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842912}, c5.y.gv(context, R$drawable.fuq));
        stateListDrawable.addState(new int[0], c5.y.gv(context, R$drawable.fuz));
        return stateListDrawable;
    }

    public static int jf(@NonNull Context context) {
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.ix) + resources.getDimensionPixelOffset(R$dimen.id) + resources.getDimensionPixelOffset(R$dimen.ih);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R$dimen.l5);
        int i = com.google.android.material.datepicker.zn.f5699t;
        return dimensionPixelSize + dimensionPixelSize2 + (resources.getDimensionPixelSize(R$dimen.l0) * i) + ((i - 1) * resources.getDimensionPixelOffset(R$dimen.ig)) + resources.getDimensionPixelOffset(R$dimen.mg);
    }

    public static boolean ni(@NonNull Context context) {
        return st(context, 16843277);
    }

    public static boolean r3(@NonNull Context context) {
        return st(context, R$attr.fai);
    }

    public static boolean st(@NonNull Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(pv.n3.zn(context, R$attr.frv, com.google.android.material.datepicker.y.class.getCanonicalName()), new int[]{i});
        boolean z2 = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z2;
    }

    public final void el() {
        s<S> sVar;
        int p4 = p4(requireContext());
        this.f5665oz = com.google.android.material.datepicker.y.st(this.f5657ej, p4, this.f5667qn);
        if (this.f5670y5.isChecked()) {
            sVar = a.gd(this.f5657ej, p4, this.f5667qn);
        } else {
            sVar = this.f5665oz;
        }
        this.f5663j5 = sVar;
        g6();
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.replace(R$id.mtrl_calendar_frame, this.f5663j5);
        beginTransaction.commitNow();
        this.f5663j5.ja(new zn());
    }

    public final void g6() {
        String x2 = x2();
        this.f5664jz.setContentDescription(String.format(getString(R$string.flh), x2));
        this.f5664jz.setText(x2);
    }

    public final void ik(Context context) {
        boolean z2;
        this.f5670y5.setTag(f5653rs);
        this.f5670y5.setImageDrawable(gm(context));
        CheckableImageButton checkableImageButton = this.f5670y5;
        if (this.f5658en != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        checkableImageButton.setChecked(z2);
        i4.g3(this.f5670y5, null);
        ky(this.f5670y5);
        this.f5670y5.setOnClickListener(new gv());
    }

    public final void ky(@NonNull CheckableImageButton checkableImageButton) {
        String string;
        if (this.f5670y5.isChecked()) {
            string = checkableImageButton.getContext().getString(R$string.fl9);
        } else {
            string = checkableImageButton.getContext().getString(R$string.fir);
        }
        this.f5670y5.setContentDescription(string);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.f5659f3.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f5662fh = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.f5657ej = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f5667qn = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f5668ut = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.f5666q9 = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.f5658en = bundle.getInt("INPUT_MODE_KEY");
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public final Dialog onCreateDialog(@Nullable Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), p4(requireContext()));
        Context context = dialog.getContext();
        this.f5660f7 = ni(context);
        int zn2 = pv.n3.zn(context, R$attr.uh, n3.class.getCanonicalName());
        fb fbVar = new fb(context, null, R$attr.frv, R$style.wa);
        this.f5669xg = fbVar;
        fbVar.k5(context);
        this.f5669xg.k(ColorStateList.valueOf(zn2));
        this.f5669xg.q9(i4.n(dialog.getWindow().getDecorView()));
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int i;
        if (this.f5660f7) {
            i = R$layout.wc;
        } else {
            i = R$layout.wm;
        }
        View inflate = layoutInflater.inflate(i, viewGroup);
        Context context = inflate.getContext();
        if (this.f5660f7) {
            inflate.findViewById(R$id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(fm(context), -2));
        } else {
            View findViewById = inflate.findViewById(R$id.mtrl_calendar_main_pane);
            View findViewById2 = inflate.findViewById(R$id.mtrl_calendar_frame);
            findViewById.setLayoutParams(new LinearLayout.LayoutParams(fm(context), -1));
            findViewById2.setMinimumHeight(jf(requireContext()));
        }
        TextView textView = (TextView) inflate.findViewById(R$id.mtrl_picker_header_selection_text);
        this.f5664jz = textView;
        i4.g(textView, 1);
        this.f5670y5 = (CheckableImageButton) inflate.findViewById(R$id.mtrl_picker_header_toggle);
        TextView textView2 = (TextView) inflate.findViewById(R$id.mtrl_picker_title_text);
        CharSequence charSequence = this.f5666q9;
        if (charSequence != null) {
            textView2.setText(charSequence);
        } else {
            textView2.setText(this.f5668ut);
        }
        ik(context);
        this.f5656dm = (Button) inflate.findViewById(R$id.confirm_button);
        if (this.f5657ej.pq()) {
            this.f5656dm.setEnabled(true);
        } else {
            this.f5656dm.setEnabled(false);
        }
        this.f5656dm.setTag(f5651ct);
        this.f5656dm.setOnClickListener(new y());
        Button button = (Button) inflate.findViewById(R$id.cancel_button);
        button.setTag(f5652o4);
        button.setOnClickListener(new View$OnClickListenerC0060n3());
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.f5655d0.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.f5662fh);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f5657ej);
        CalendarConstraints.n3 n3Var = new CalendarConstraints.n3(this.f5667qn);
        if (this.f5665oz.p4() != null) {
            n3Var.n3(this.f5665oz.p4().f5642t);
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", n3Var.y());
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.f5668ut);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.f5666q9);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.f5660f7) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.f5669xg);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.l6);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.f5669xg, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new ok.y(requireDialog(), rect));
        }
        el();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        this.f5663j5.cp();
        super.onStop();
    }

    public final int p4(Context context) {
        int i = this.f5662fh;
        if (i != 0) {
            return i;
        }
        return this.f5657ej.k5(context);
    }

    @Nullable
    public final S w5() {
        return this.f5657ej.qj();
    }

    public String x2() {
        return this.f5657ej.dm(getContext());
    }
}
