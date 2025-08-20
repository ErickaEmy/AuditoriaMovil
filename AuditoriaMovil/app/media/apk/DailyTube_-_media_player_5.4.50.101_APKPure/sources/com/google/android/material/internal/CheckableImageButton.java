package com.google.android.material.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import androidx.annotation.NonNull;
import androidx.appcompat.R$attr;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.customview.view.AbsSavedState;
import hw.i4;
import j5.zn;
/* loaded from: classes.dex */
public class CheckableImageButton extends AppCompatImageButton implements Checkable {

    /* renamed from: t  reason: collision with root package name */
    public static final int[] f5793t = {16842912};

    /* renamed from: f  reason: collision with root package name */
    public boolean f5794f;

    /* renamed from: fb  reason: collision with root package name */
    public boolean f5795fb;

    /* renamed from: s  reason: collision with root package name */
    public boolean f5796s;

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new y();

        /* renamed from: fb  reason: collision with root package name */
        public boolean f5797fb;

        /* loaded from: classes.dex */
        public static class y implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            /* renamed from: n3 */
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: y */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: zn */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void n3(@NonNull Parcel parcel) {
            boolean z2 = true;
            if (parcel.readInt() != 1) {
                z2 = false;
            }
            this.f5797fb = z2;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f5797fb ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            n3(parcel);
        }
    }

    /* loaded from: classes.dex */
    public class y extends hw.y {
        public y() {
        }

        @Override // hw.y
        public void a(View view, @NonNull AccessibilityEvent accessibilityEvent) {
            super.a(view, accessibilityEvent);
            accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
        }

        @Override // hw.y
        public void fb(View view, @NonNull zn znVar) {
            super.fb(view, znVar);
            znVar.nf(CheckableImageButton.this.y());
            znVar.ra(CheckableImageButton.this.isChecked());
        }
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.f637fh);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f5795fb;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i) {
        if (this.f5795fb) {
            int[] iArr = f5793t;
            return View.mergeDrawableStates(super.onCreateDrawableState(i + iArr.length), iArr);
        }
        return super.onCreateDrawableState(i);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.y());
        setChecked(savedState.f5797fb);
    }

    @Override // android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f5797fb = this.f5795fb;
        return savedState;
    }

    public void setCheckable(boolean z2) {
        if (this.f5796s != z2) {
            this.f5796s = z2;
            sendAccessibilityEvent(0);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z2) {
        if (this.f5796s && this.f5795fb != z2) {
            this.f5795fb = z2;
            refreshDrawableState();
            sendAccessibilityEvent(2048);
        }
    }

    public void setPressable(boolean z2) {
        this.f5794f = z2;
    }

    @Override // android.view.View
    public void setPressed(boolean z2) {
        if (this.f5794f) {
            super.setPressed(z2);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f5795fb);
    }

    public boolean y() {
        return this.f5796s;
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5796s = true;
        this.f5794f = true;
        i4.g3(this, new y());
    }
}
