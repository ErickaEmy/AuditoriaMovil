package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import s.fb;
/* loaded from: classes.dex */
public class n3 extends fb {

    /* renamed from: fb  reason: collision with root package name */
    public boolean f5500fb;

    /* renamed from: com.google.android.material.bottomsheet.n3$n3  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0057n3 extends BottomSheetBehavior.a {
        public C0057n3() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.a
        public void n3(@NonNull View view, int i) {
            if (i == 5) {
                n3.this.cp();
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.a
        public void y(@NonNull View view, float f4) {
        }
    }

    public final void cp() {
        if (this.f5500fb) {
            super.dismissAllowingStateLoss();
        } else {
            super.dismiss();
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        if (!ng(false)) {
            super.dismiss();
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismissAllowingStateLoss() {
        if (!ng(true)) {
            super.dismissAllowingStateLoss();
        }
    }

    public final void gd(@NonNull BottomSheetBehavior<?> bottomSheetBehavior, boolean z2) {
        this.f5500fb = z2;
        if (bottomSheetBehavior.f7() == 5) {
            cp();
            return;
        }
        if (getDialog() instanceof com.google.android.material.bottomsheet.y) {
            ((com.google.android.material.bottomsheet.y) getDialog()).s();
        }
        bottomSheetBehavior.k5(new C0057n3());
        bottomSheetBehavior.kp(5);
    }

    public final boolean ng(boolean z2) {
        Dialog dialog = getDialog();
        if (dialog instanceof com.google.android.material.bottomsheet.y) {
            com.google.android.material.bottomsheet.y yVar = (com.google.android.material.bottomsheet.y) dialog;
            BottomSheetBehavior<FrameLayout> a2 = yVar.a();
            if (a2.u() && yVar.fb()) {
                gd(a2, z2);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // s.fb, androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        return new com.google.android.material.bottomsheet.y(getContext(), getTheme());
    }
}
