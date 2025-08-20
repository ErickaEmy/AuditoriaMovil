package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import hw.i4;
/* loaded from: classes.dex */
class TimePickerView extends ConstraintLayout {

    /* renamed from: f7  reason: collision with root package name */
    public final View.OnClickListener f6120f7;

    /* renamed from: j  reason: collision with root package name */
    public final Chip f6121j;

    /* renamed from: k  reason: collision with root package name */
    public final MaterialButtonToggleGroup f6122k;

    /* renamed from: oz  reason: collision with root package name */
    public final Chip f6123oz;

    /* renamed from: q9  reason: collision with root package name */
    public final ClockFaceView f6124q9;

    /* renamed from: ut  reason: collision with root package name */
    public final ClockHandView f6125ut;

    /* loaded from: classes.dex */
    public interface a {
    }

    /* loaded from: classes.dex */
    public interface fb {
    }

    /* loaded from: classes.dex */
    public class gv implements View.OnTouchListener {
        public final /* synthetic */ GestureDetector y;

        public gv(GestureDetector gestureDetector) {
            this.y = gestureDetector;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (((Checkable) view).isChecked()) {
                return this.y.onTouchEvent(motionEvent);
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public class n3 implements MaterialButtonToggleGroup.v {
        public n3() {
        }

        @Override // com.google.android.material.button.MaterialButtonToggleGroup.v
        public void y(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z2) {
            TimePickerView.x4(TimePickerView.this);
        }
    }

    /* loaded from: classes.dex */
    public interface v {
    }

    /* loaded from: classes.dex */
    public class y implements View.OnClickListener {
        public y() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TimePickerView.r(TimePickerView.this);
        }
    }

    /* loaded from: classes.dex */
    public class zn extends GestureDetector.SimpleOnGestureListener {
        public zn() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            boolean onDoubleTap = super.onDoubleTap(motionEvent);
            TimePickerView.i4(TimePickerView.this);
            return onDoubleTap;
        }
    }

    public TimePickerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static /* synthetic */ v i4(TimePickerView timePickerView) {
        timePickerView.getClass();
        return null;
    }

    public static /* synthetic */ fb r(TimePickerView timePickerView) {
        timePickerView.getClass();
        return null;
    }

    public static /* synthetic */ a x4(TimePickerView timePickerView) {
        timePickerView.getClass();
        return null;
    }

    public final void c() {
        int i;
        if (this.f6122k.getVisibility() == 0) {
            androidx.constraintlayout.widget.zn znVar = new androidx.constraintlayout.widget.zn();
            znVar.fb(this);
            if (i4.ta(this) == 0) {
                i = 2;
            } else {
                i = 1;
            }
            znVar.v(R$id.material_clock_display, i);
            znVar.zn(this);
        }
    }

    public final void f3() {
        Chip chip = this.f6121j;
        int i = R$id.selection_type;
        chip.setTag(i, 12);
        this.f6123oz.setTag(i, 10);
        this.f6121j.setOnClickListener(this.f6120f7);
        this.f6123oz.setOnClickListener(this.f6120f7);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void n() {
        gv gvVar = new gv(new GestureDetector(getContext(), new zn()));
        this.f6121j.setOnTouchListener(gvVar);
        this.f6123oz.setOnTouchListener(gvVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        if (view == this && i == 0) {
            c();
        }
    }

    public TimePickerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6120f7 = new y();
        LayoutInflater.from(context).inflate(R$layout.oy, this);
        this.f6124q9 = (ClockFaceView) findViewById(R$id.material_clock_face);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(R$id.material_clock_period_toggle);
        this.f6122k = materialButtonToggleGroup;
        materialButtonToggleGroup.fb(new n3());
        this.f6121j = (Chip) findViewById(R$id.material_minute_tv);
        this.f6123oz = (Chip) findViewById(R$id.material_hour_tv);
        this.f6125ut = (ClockHandView) findViewById(R$id.material_clock_hand);
        n();
        f3();
    }
}
