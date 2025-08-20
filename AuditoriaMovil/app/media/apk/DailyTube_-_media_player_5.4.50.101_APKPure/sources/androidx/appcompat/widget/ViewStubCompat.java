package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$styleable;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class ViewStubCompat extends View {

    /* renamed from: fb  reason: collision with root package name */
    public WeakReference<View> f1502fb;

    /* renamed from: s  reason: collision with root package name */
    public LayoutInflater f1503s;

    /* renamed from: v  reason: collision with root package name */
    public int f1504v;
    public int y;

    /* loaded from: classes.dex */
    public interface y {
    }

    public ViewStubCompat(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.f1504v;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f1503s;
    }

    public int getLayoutResource() {
        return this.y;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i5) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i) {
        this.f1504v = i;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f1503s = layoutInflater;
    }

    public void setLayoutResource(int i) {
        this.y = i;
    }

    public void setOnInflateListener(y yVar) {
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        WeakReference<View> weakReference = this.f1502fb;
        if (weakReference != null) {
            View view = weakReference.get();
            if (view != null) {
                view.setVisibility(i);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            y();
        }
    }

    public View y() {
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            if (this.y != 0) {
                ViewGroup viewGroup = (ViewGroup) parent;
                LayoutInflater layoutInflater = this.f1503s;
                if (layoutInflater == null) {
                    layoutInflater = LayoutInflater.from(getContext());
                }
                View inflate = layoutInflater.inflate(this.y, viewGroup, false);
                int i = this.f1504v;
                if (i != -1) {
                    inflate.setId(i);
                }
                int indexOfChild = viewGroup.indexOfChild(this);
                viewGroup.removeViewInLayout(this);
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams != null) {
                    viewGroup.addView(inflate, indexOfChild, layoutParams);
                } else {
                    viewGroup.addView(inflate, indexOfChild);
                }
                this.f1502fb = new WeakReference<>(inflate);
                return inflate;
            }
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
    }

    public ViewStubCompat(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f829e4, i, 0);
        this.f1504v = obtainStyledAttributes.getResourceId(R$styleable.f901tq, -1);
        this.y = obtainStyledAttributes.getResourceId(R$styleable.f832ek, 0);
        setId(obtainStyledAttributes.getResourceId(R$styleable.f858ku, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }
}
