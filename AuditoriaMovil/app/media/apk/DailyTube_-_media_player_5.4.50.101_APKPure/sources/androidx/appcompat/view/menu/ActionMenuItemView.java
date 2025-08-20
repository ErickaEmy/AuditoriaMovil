package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.i9;
import androidx.appcompat.view.menu.v;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import wz.fh;
import wz.j5;
/* loaded from: classes.dex */
public class ActionMenuItemView extends AppCompatTextView implements i9.y, View.OnClickListener, ActionMenuView.y {

    /* renamed from: c  reason: collision with root package name */
    public int f1056c;

    /* renamed from: co  reason: collision with root package name */
    public v.n3 f1057co;

    /* renamed from: d0  reason: collision with root package name */
    public int f1058d0;

    /* renamed from: f3  reason: collision with root package name */
    public boolean f1059f3;

    /* renamed from: fh  reason: collision with root package name */
    public int f1060fh;

    /* renamed from: n  reason: collision with root package name */
    public boolean f1061n;

    /* renamed from: p  reason: collision with root package name */
    public Drawable f1062p;

    /* renamed from: r  reason: collision with root package name */
    public n3 f1063r;

    /* renamed from: t  reason: collision with root package name */
    public fb f1064t;

    /* renamed from: w  reason: collision with root package name */
    public CharSequence f1065w;

    /* renamed from: z  reason: collision with root package name */
    public fh f1066z;

    /* loaded from: classes.dex */
    public static abstract class n3 {
        public abstract tl.a y();
    }

    /* loaded from: classes.dex */
    public class y extends fh {
        public y() {
            super(ActionMenuItemView.this);
        }

        @Override // wz.fh
        public tl.a n3() {
            n3 n3Var = ActionMenuItemView.this.f1063r;
            if (n3Var != null) {
                return n3Var.y();
            }
            return null;
        }

        @Override // wz.fh
        public boolean zn() {
            tl.a n32;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            v.n3 n3Var = actionMenuItemView.f1057co;
            if (n3Var == null || !n3Var.gv(actionMenuItemView.f1064t) || (n32 = n3()) == null || !n32.y()) {
                return false;
            }
            return true;
        }
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public boolean a() {
        return !TextUtils.isEmpty(getText());
    }

    public final boolean fb() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i5 = configuration.screenHeightDp;
        if (i < 480 && ((i < 640 || i5 < 480) && configuration.orientation != 2)) {
            return false;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.i9.y
    public fb getItemData() {
        return this.f1064t;
    }

    @Override // androidx.appcompat.widget.ActionMenuView.y
    public boolean n3() {
        if (a() && this.f1064t.getIcon() == null) {
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        v.n3 n3Var = this.f1057co;
        if (n3Var != null) {
            n3Var.gv(this.f1064t);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1059f3 = fb();
        s();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i, int i5) {
        int i6;
        int i8;
        boolean a2 = a();
        if (a2 && (i8 = this.f1058d0) >= 0) {
            super.setPadding(i8, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i5);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        if (mode == Integer.MIN_VALUE) {
            i6 = Math.min(size, this.f1056c);
        } else {
            i6 = this.f1056c;
        }
        if (mode != 1073741824 && this.f1056c > 0 && measuredWidth < i6) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(i6, 1073741824), i5);
        }
        if (!a2 && this.f1062p != null) {
            super.setPadding((getMeasuredWidth() - this.f1062p.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        fh fhVar;
        if (this.f1064t.hasSubMenu() && (fhVar = this.f1066z) != null && fhVar.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void s() {
        CharSequence charSequence;
        CharSequence title;
        boolean z2 = true;
        boolean z3 = !TextUtils.isEmpty(this.f1065w);
        if (this.f1062p != null && (!this.f1064t.fh() || (!this.f1059f3 && !this.f1061n))) {
            z2 = false;
        }
        boolean z4 = z3 & z2;
        CharSequence charSequence2 = null;
        if (z4) {
            charSequence = this.f1065w;
        } else {
            charSequence = null;
        }
        setText(charSequence);
        CharSequence contentDescription = this.f1064t.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            if (z4) {
                title = null;
            } else {
                title = this.f1064t.getTitle();
            }
            setContentDescription(title);
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f1064t.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            if (!z4) {
                charSequence2 = this.f1064t.getTitle();
            }
            j5.y(this, charSequence2);
            return;
        }
        j5.y(this, tooltipText);
    }

    public void setCheckable(boolean z2) {
    }

    public void setChecked(boolean z2) {
    }

    public void setExpandedFormat(boolean z2) {
        if (this.f1061n != z2) {
            this.f1061n = z2;
            fb fbVar = this.f1064t;
            if (fbVar != null) {
                fbVar.zn();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f1062p = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i = this.f1060fh;
            if (intrinsicWidth > i) {
                intrinsicHeight = (int) (intrinsicHeight * (i / intrinsicWidth));
                intrinsicWidth = i;
            }
            if (intrinsicHeight > i) {
                intrinsicWidth = (int) (intrinsicWidth * (i / intrinsicHeight));
            } else {
                i = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i);
        }
        setCompoundDrawables(drawable, null, null, null);
        s();
    }

    public void setItemInvoker(v.n3 n3Var) {
        this.f1057co = n3Var;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i, int i5, int i6, int i8) {
        this.f1058d0 = i;
        super.setPadding(i, i5, i6, i8);
    }

    public void setPopupCallback(n3 n3Var) {
        this.f1063r = n3Var;
    }

    public void setTitle(CharSequence charSequence) {
        this.f1065w = charSequence;
        s();
    }

    @Override // androidx.appcompat.view.menu.i9.y
    public boolean v() {
        return true;
    }

    @Override // androidx.appcompat.widget.ActionMenuView.y
    public boolean y() {
        return a();
    }

    @Override // androidx.appcompat.view.menu.i9.y
    public void zn(fb fbVar, int i) {
        int i5;
        this.f1064t = fbVar;
        setIcon(fbVar.getIcon());
        setTitle(fbVar.c5(this));
        setId(fbVar.getItemId());
        if (fbVar.isVisible()) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        setVisibility(i5);
        setEnabled(fbVar.isEnabled());
        if (fbVar.hasSubMenu() && this.f1066z == null) {
            this.f1066z = new y();
        }
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.f1059f3 = fb();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f918x4, i, 0);
        this.f1056c = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f848i4, 0);
        obtainStyledAttributes.recycle();
        this.f1060fh = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f1058d0 = -1;
        setSaveEnabled(false);
    }
}
