package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import hw.i4;
import s.a;
/* loaded from: classes.dex */
public class y extends a {
    @NonNull

    /* renamed from: co  reason: collision with root package name */
    public BottomSheetBehavior.a f5501co;

    /* renamed from: f  reason: collision with root package name */
    public boolean f5502f;

    /* renamed from: fb  reason: collision with root package name */
    public BottomSheetBehavior<FrameLayout> f5503fb;

    /* renamed from: p  reason: collision with root package name */
    public boolean f5504p;

    /* renamed from: s  reason: collision with root package name */
    public FrameLayout f5505s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f5506t;

    /* renamed from: w  reason: collision with root package name */
    public boolean f5507w;

    /* loaded from: classes.dex */
    public class gv extends BottomSheetBehavior.a {
        public gv() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.a
        public void n3(@NonNull View view, int i) {
            if (i == 5) {
                y.this.cancel();
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.a
        public void y(@NonNull View view, float f4) {
        }
    }

    /* loaded from: classes.dex */
    public class n3 extends hw.y {
        public n3() {
        }

        @Override // hw.y
        public void fb(View view, @NonNull j5.zn znVar) {
            super.fb(view, znVar);
            if (y.this.f5506t) {
                znVar.y(1048576);
                znVar.kp(true);
                return;
            }
            znVar.kp(false);
        }

        @Override // hw.y
        public boolean i9(View view, int i, Bundle bundle) {
            if (i == 1048576) {
                y yVar = y.this;
                if (yVar.f5506t) {
                    yVar.cancel();
                    return true;
                }
            }
            return super.i9(view, i, bundle);
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0058y implements View.OnClickListener {
        public View$OnClickListenerC0058y() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            y yVar = y.this;
            if (yVar.f5506t && yVar.isShowing() && y.this.c5()) {
                y.this.cancel();
            }
        }
    }

    /* loaded from: classes.dex */
    public class zn implements View.OnTouchListener {
        public zn() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public y(@NonNull Context context, int i) {
        super(context, n3(context, i));
        this.f5506t = true;
        this.f5507w = true;
        this.f5501co = new gv();
        gv(1);
    }

    public static int n3(@NonNull Context context, int i) {
        if (i == 0) {
            TypedValue typedValue = new TypedValue();
            if (context.getTheme().resolveAttribute(R$attr.bs, typedValue, true)) {
                return typedValue.resourceId;
            }
            return R$style.ts;
        }
        return i;
    }

    @NonNull
    public BottomSheetBehavior<FrameLayout> a() {
        if (this.f5503fb == null) {
            v();
        }
        return this.f5503fb;
    }

    public boolean c5() {
        if (!this.f5504p) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{16843611});
            this.f5507w = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
            this.f5504p = true;
        }
        return this.f5507w;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        BottomSheetBehavior<FrameLayout> a2 = a();
        if (this.f5502f && a2.f7() != 5) {
            a2.kp(5);
        } else {
            super.cancel();
        }
    }

    public boolean fb() {
        return this.f5502f;
    }

    public final View i9(int i, @Nullable View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        v();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f5505s.findViewById(R$id.coordinator);
        if (i != 0 && view == null) {
            view = getLayoutInflater().inflate(i, (ViewGroup) coordinatorLayout, false);
        }
        FrameLayout frameLayout = (FrameLayout) this.f5505s.findViewById(R$id.design_bottom_sheet);
        frameLayout.removeAllViews();
        if (layoutParams == null) {
            frameLayout.addView(view);
        } else {
            frameLayout.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R$id.touch_outside).setOnClickListener(new View$OnClickListenerC0058y());
        i4.g3(frameLayout, new n3());
        frameLayout.setOnTouchListener(new zn());
        return this.f5505s;
    }

    @Override // s.a, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f5503fb;
        if (bottomSheetBehavior != null && bottomSheetBehavior.f7() == 5) {
            this.f5503fb.kp(4);
        }
    }

    public void s() {
        this.f5503fb.y5(this.f5501co);
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z2) {
        super.setCancelable(z2);
        if (this.f5506t != z2) {
            this.f5506t = z2;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f5503fb;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.e(z2);
            }
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z2) {
        super.setCanceledOnTouchOutside(z2);
        if (z2 && !this.f5506t) {
            this.f5506t = true;
        }
        this.f5507w = z2;
        this.f5504p = true;
    }

    @Override // s.a, android.app.Dialog
    public void setContentView(int i) {
        super.setContentView(i9(i, null, null));
    }

    public final FrameLayout v() {
        if (this.f5505s == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R$layout.s1, null);
            this.f5505s = frameLayout;
            BottomSheetBehavior<FrameLayout> q92 = BottomSheetBehavior.q9((FrameLayout) frameLayout.findViewById(R$id.design_bottom_sheet));
            this.f5503fb = q92;
            q92.k5(this.f5501co);
            this.f5503fb.e(this.f5506t);
        }
        return this.f5505s;
    }

    @Override // s.a, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(i9(0, view, null));
    }

    @Override // s.a, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(i9(0, view, layoutParams));
    }
}
