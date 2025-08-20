package e0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.zn;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$styleable;
import hw.i4;
import hx.c5;
import hx.fb;
/* loaded from: classes.dex */
public class n3 extends ConstraintLayout {

    /* renamed from: j  reason: collision with root package name */
    public final Runnable f7446j;

    /* renamed from: oz  reason: collision with root package name */
    public int f7447oz;

    /* renamed from: ut  reason: collision with root package name */
    public fb f7448ut;

    /* loaded from: classes.dex */
    public class y implements Runnable {
        public y() {
        }

        @Override // java.lang.Runnable
        public void run() {
            n3.this.n();
        }
    }

    public n3(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static boolean f3(View view) {
        return "skip".equals(view.getTag());
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (view.getId() == -1) {
            view.setId(i4.tl());
        }
        c();
    }

    public final void c() {
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.f7446j);
            handler.post(this.f7446j);
        }
    }

    public void i4(int i) {
        this.f7447oz = i;
        n();
    }

    public void n() {
        int childCount = getChildCount();
        int i = 1;
        for (int i5 = 0; i5 < childCount; i5++) {
            if (f3(getChildAt(i5))) {
                i++;
            }
        }
        zn znVar = new zn();
        znVar.fb(this);
        float f4 = 0.0f;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            int id = childAt.getId();
            int i8 = R$id.circle_center;
            if (id != i8 && !f3(childAt)) {
                znVar.i9(childAt.getId(), i8, this.f7447oz, f4);
                f4 += 360.0f / (childCount - i);
            }
        }
        znVar.zn(this);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        n();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        c();
    }

    public final Drawable r() {
        fb fbVar = new fb();
        this.f7448ut = fbVar;
        fbVar.ut(new c5(0.5f));
        this.f7448ut.k(ColorStateList.valueOf(-1));
        return this.f7448ut;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.f7448ut.k(ColorStateList.valueOf(i));
    }

    public int x4() {
        return this.f7447oz;
    }

    public n3(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R$layout.oa, this);
        i4.u0(this, r());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f5212ls, i, 0);
        this.f7447oz = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f5151e4, 0);
        this.f7446j = new y();
        obtainStyledAttributes.recycle();
    }
}
