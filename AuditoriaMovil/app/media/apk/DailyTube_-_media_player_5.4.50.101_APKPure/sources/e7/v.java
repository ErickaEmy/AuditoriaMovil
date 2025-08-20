package e7;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.Filterable;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.textfield.TextInputLayout;
import ur.i9;
import wz.rz;
/* loaded from: classes.dex */
public class v extends wz.gv {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final AccessibilityManager f7584f;
    @NonNull

    /* renamed from: s  reason: collision with root package name */
    public final rz f7585s;
    @NonNull

    /* renamed from: t  reason: collision with root package name */
    public final Rect f7586t;

    /* loaded from: classes.dex */
    public class y implements AdapterView.OnItemClickListener {
        public y() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j2) {
            Object item;
            if (i < 0) {
                item = v.this.f7585s.r();
            } else {
                item = v.this.getAdapter().getItem(i);
            }
            v.this.v(item);
            AdapterView.OnItemClickListener onItemClickListener = v.this.getOnItemClickListener();
            if (onItemClickListener != null) {
                if (view == null || i < 0) {
                    view = v.this.f7585s.f3();
                    i = v.this.f7585s.i4();
                    j2 = v.this.f7585s.x4();
                }
                onItemClickListener.onItemClick(v.this.f7585s.xc(), view, i, j2);
            }
            v.this.f7585s.dismiss();
        }
    }

    public v(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.f5084n3);
    }

    @Override // android.widget.TextView
    @Nullable
    public CharSequence getHint() {
        TextInputLayout zn2 = zn();
        if (zn2 != null && zn2.vl()) {
            return zn2.getHint();
        }
        return super.getHint();
    }

    public final int gv() {
        ListAdapter adapter = getAdapter();
        TextInputLayout zn2 = zn();
        int i = 0;
        if (adapter == null || zn2 == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int min = Math.min(adapter.getCount(), Math.max(0, this.f7585s.i4()) + 15);
        View view = null;
        int i5 = 0;
        for (int max = Math.max(0, min - 15); max < min; max++) {
            int itemViewType = adapter.getItemViewType(max);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = adapter.getView(max, view, zn2);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i5 = Math.max(i5, view.getMeasuredWidth());
        }
        Drawable fb2 = this.f7585s.fb();
        if (fb2 != null) {
            fb2.getPadding(this.f7586t);
            Rect rect = this.f7586t;
            i5 += rect.left + rect.right;
        }
        return i5 + zn2.getEndIconView().getMeasuredWidth();
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout zn2 = zn();
        if (zn2 != null && zn2.vl() && super.getHint() == null && ur.v.y()) {
            setHint("");
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i5) {
        super.onMeasure(i, i5);
        if (View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), gv()), View.MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(@Nullable T t2) {
        super.setAdapter(t2);
        this.f7585s.tl(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        AccessibilityManager accessibilityManager = this.f7584f;
        if (accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled()) {
            this.f7585s.show();
        } else {
            super.showDropDown();
        }
    }

    public final <T extends ListAdapter & Filterable> void v(Object obj) {
        setText(convertSelectionToString(obj), false);
    }

    @Nullable
    public final TextInputLayout zn() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    public v(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(c0.y.zn(context, attributeSet, i, 0), attributeSet, i);
        this.f7586t = new Rect();
        Context context2 = getContext();
        TypedArray s2 = i9.s(context2, attributeSet, R$styleable.jm, i, R$style.f5111v, new int[0]);
        int i5 = R$styleable.mq;
        if (s2.hasValue(i5) && s2.getInt(i5, 0) == 0) {
            setKeyListener(null);
        }
        this.f7584f = (AccessibilityManager) context2.getSystemService("accessibility");
        rz rzVar = new rz(context2);
        this.f7585s = rzVar;
        rzVar.ud(true);
        rzVar.rz(this);
        rzVar.ej(2);
        rzVar.tl(getAdapter());
        rzVar.x(new y());
        s2.recycle();
    }
}
