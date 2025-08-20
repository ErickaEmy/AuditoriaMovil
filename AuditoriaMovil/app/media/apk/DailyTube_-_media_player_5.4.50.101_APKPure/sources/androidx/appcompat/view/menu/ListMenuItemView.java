package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.i9;
import hw.i4;
import wz.hw;
/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements i9.y, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: c  reason: collision with root package name */
    public Drawable f1070c;

    /* renamed from: co  reason: collision with root package name */
    public LinearLayout f1071co;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1072d;

    /* renamed from: d0  reason: collision with root package name */
    public boolean f1073d0;

    /* renamed from: f  reason: collision with root package name */
    public CheckBox f1074f;

    /* renamed from: f3  reason: collision with root package name */
    public Context f1075f3;

    /* renamed from: fb  reason: collision with root package name */
    public RadioButton f1076fb;

    /* renamed from: fh  reason: collision with root package name */
    public LayoutInflater f1077fh;

    /* renamed from: n  reason: collision with root package name */
    public boolean f1078n;

    /* renamed from: p  reason: collision with root package name */
    public ImageView f1079p;

    /* renamed from: r  reason: collision with root package name */
    public int f1080r;

    /* renamed from: s  reason: collision with root package name */
    public TextView f1081s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f1082t;

    /* renamed from: v  reason: collision with root package name */
    public ImageView f1083v;

    /* renamed from: w  reason: collision with root package name */
    public ImageView f1084w;
    public fb y;

    /* renamed from: z  reason: collision with root package name */
    public Drawable f1085z;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.f648rz);
    }

    private LayoutInflater getInflater() {
        if (this.f1077fh == null) {
            this.f1077fh = LayoutInflater.from(getContext());
        }
        return this.f1077fh;
    }

    private void setSubMenuArrowVisible(boolean z2) {
        int i;
        ImageView imageView = this.f1084w;
        if (imageView != null) {
            if (z2) {
                i = 0;
            } else {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    public final void a() {
        ImageView imageView = (ImageView) getInflater().inflate(R$layout.f772c5, (ViewGroup) this, false);
        this.f1083v = imageView;
        n3(imageView, 0);
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f1079p;
        if (imageView != null && imageView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f1079p.getLayoutParams();
            rect.top += this.f1079p.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
        }
    }

    public final void fb() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(R$layout.f774f, (ViewGroup) this, false);
        this.f1076fb = radioButton;
        y(radioButton);
    }

    @Override // androidx.appcompat.view.menu.i9.y
    public fb getItemData() {
        return this.y;
    }

    public final void gv() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(R$layout.f781s, (ViewGroup) this, false);
        this.f1074f = checkBox;
        y(checkBox);
    }

    public final void n3(View view, int i) {
        LinearLayout linearLayout = this.f1071co;
        if (linearLayout != null) {
            linearLayout.addView(view, i);
        } else {
            addView(view, i);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        i4.u0(this, this.f1085z);
        TextView textView = (TextView) findViewById(R$id.f747k5);
        this.f1081s = textView;
        int i = this.f1080r;
        if (i != -1) {
            textView.setTextAppearance(this.f1075f3, i);
        }
        this.f1082t = (TextView) findViewById(R$id.f736d);
        ImageView imageView = (ImageView) findViewById(R$id.f759ud);
        this.f1084w = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f1070c);
        }
        this.f1079p = (ImageView) findViewById(R$id.f749mt);
        this.f1071co = (LinearLayout) findViewById(R$id.f756t);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i5) {
        if (this.f1083v != null && this.f1078n) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f1083v.getLayoutParams();
            int i6 = layoutParams.height;
            if (i6 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i6;
            }
        }
        super.onMeasure(i, i5);
    }

    public void s(boolean z2, char c2) {
        int i;
        if (z2 && this.y.d0()) {
            i = 0;
        } else {
            i = 8;
        }
        if (i == 0) {
            this.f1082t.setText(this.y.s());
        }
        if (this.f1082t.getVisibility() != i) {
            this.f1082t.setVisibility(i);
        }
    }

    public void setCheckable(boolean z2) {
        CompoundButton compoundButton;
        View view;
        if (!z2 && this.f1076fb == null && this.f1074f == null) {
            return;
        }
        if (this.y.tl()) {
            if (this.f1076fb == null) {
                fb();
            }
            compoundButton = this.f1076fb;
            view = this.f1074f;
        } else {
            if (this.f1074f == null) {
                gv();
            }
            compoundButton = this.f1074f;
            view = this.f1076fb;
        }
        if (z2) {
            compoundButton.setChecked(this.y.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view != null && view.getVisibility() != 8) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        CheckBox checkBox = this.f1074f;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.f1076fb;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    public void setChecked(boolean z2) {
        CompoundButton compoundButton;
        if (this.y.tl()) {
            if (this.f1076fb == null) {
                fb();
            }
            compoundButton = this.f1076fb;
        } else {
            if (this.f1074f == null) {
                gv();
            }
            compoundButton = this.f1074f;
        }
        compoundButton.setChecked(z2);
    }

    public void setForceShowIcon(boolean z2) {
        this.f1072d = z2;
        this.f1078n = z2;
    }

    public void setGroupDividerEnabled(boolean z2) {
        int i;
        ImageView imageView = this.f1079p;
        if (imageView != null) {
            if (!this.f1073d0 && z2) {
                i = 0;
            } else {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z2;
        if (!this.y.c() && !this.f1072d) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2 && !this.f1078n) {
            return;
        }
        ImageView imageView = this.f1083v;
        if (imageView == null && drawable == null && !this.f1078n) {
            return;
        }
        if (imageView == null) {
            a();
        }
        if (drawable == null && !this.f1078n) {
            this.f1083v.setVisibility(8);
            return;
        }
        ImageView imageView2 = this.f1083v;
        if (!z2) {
            drawable = null;
        }
        imageView2.setImageDrawable(drawable);
        if (this.f1083v.getVisibility() != 0) {
            this.f1083v.setVisibility(0);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f1081s.setText(charSequence);
            if (this.f1081s.getVisibility() != 0) {
                this.f1081s.setVisibility(0);
            }
        } else if (this.f1081s.getVisibility() != 8) {
            this.f1081s.setVisibility(8);
        }
    }

    @Override // androidx.appcompat.view.menu.i9.y
    public boolean v() {
        return false;
    }

    public final void y(View view) {
        n3(view, -1);
    }

    @Override // androidx.appcompat.view.menu.i9.y
    public void zn(fb fbVar, int i) {
        int i5;
        this.y = fbVar;
        if (fbVar.isVisible()) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        setVisibility(i5);
        setTitle(fbVar.c5(this));
        setCheckable(fbVar.isCheckable());
        s(fbVar.d0(), fbVar.fb());
        setIcon(fbVar.getIcon());
        setEnabled(fbVar.isEnabled());
        setSubMenuArrowVisible(fbVar.hasSubMenu());
        setContentDescription(fbVar.getContentDescription());
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        hw x42 = hw.x4(getContext(), attributeSet, R$styleable.ux, i, 0);
        this.f1085z = x42.fb(R$styleable.t5);
        this.f1080r = x42.wz(R$styleable.vd, -1);
        this.f1078n = x42.y(R$styleable.rt, false);
        this.f1075f3 = context;
        this.f1070c = x42.fb(R$styleable.ks);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{16843049}, R$attr.f628c, 0);
        this.f1073d0 = obtainStyledAttributes.hasValue(0);
        x42.i4();
        obtainStyledAttributes.recycle();
    }
}
