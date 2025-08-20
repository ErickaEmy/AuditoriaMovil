package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
/* loaded from: classes.dex */
public class gv extends ViewGroup {
    public zn y;

    public zn getConstraintSet() {
        if (this.y == null) {
            this.y = new zn();
        }
        this.y.s(this);
        return this.y;
    }

    @Override // android.view.ViewGroup
    /* renamed from: n3 */
    public y generateLayoutParams(AttributeSet attributeSet) {
        return new y(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i5, int i6, int i8) {
    }

    @Override // android.view.ViewGroup
    /* renamed from: y */
    public y generateDefaultLayoutParams() {
        return new y(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.n3(layoutParams);
    }

    /* loaded from: classes.dex */
    public static class y extends ConstraintLayout.n3 {

        /* renamed from: bk  reason: collision with root package name */
        public float f1901bk;

        /* renamed from: g  reason: collision with root package name */
        public float f1902g;

        /* renamed from: g3  reason: collision with root package name */
        public float f1903g3;

        /* renamed from: kp  reason: collision with root package name */
        public float f1904kp;

        /* renamed from: m  reason: collision with root package name */
        public float f1905m;

        /* renamed from: pq  reason: collision with root package name */
        public float f1906pq;

        /* renamed from: pz  reason: collision with root package name */
        public float f1907pz;

        /* renamed from: rb  reason: collision with root package name */
        public float f1908rb;

        /* renamed from: tg  reason: collision with root package name */
        public float f1909tg;

        /* renamed from: u0  reason: collision with root package name */
        public float f1910u0;

        /* renamed from: y4  reason: collision with root package name */
        public float f1911y4;

        /* renamed from: yc  reason: collision with root package name */
        public boolean f1912yc;

        /* renamed from: yg  reason: collision with root package name */
        public float f1913yg;

        public y(int i, int i5) {
            super(i, i5);
            this.f1913yg = 1.0f;
            this.f1902g = 1.0f;
            this.f1910u0 = 1.0f;
        }

        public y(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1913yg = 1.0f;
            this.f1902g = 1.0f;
            this.f1910u0 = 1.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.z8);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R$styleable.ih) {
                    this.f1913yg = obtainStyledAttributes.getFloat(index, this.f1913yg);
                } else if (index == R$styleable.cw) {
                    this.f1904kp = obtainStyledAttributes.getFloat(index, this.f1904kp);
                    this.f1912yc = true;
                } else if (index == R$styleable.t7) {
                    this.f1903g3 = obtainStyledAttributes.getFloat(index, this.f1903g3);
                } else if (index == R$styleable.p2) {
                    this.f1905m = obtainStyledAttributes.getFloat(index, this.f1905m);
                } else if (index == R$styleable.j4) {
                    this.f1908rb = obtainStyledAttributes.getFloat(index, this.f1908rb);
                } else if (index == R$styleable.ez) {
                    this.f1902g = obtainStyledAttributes.getFloat(index, this.f1902g);
                } else if (index == R$styleable.wb) {
                    this.f1910u0 = obtainStyledAttributes.getFloat(index, this.f1910u0);
                } else if (index == R$styleable.jm) {
                    this.f1901bk = obtainStyledAttributes.getFloat(index, this.f1901bk);
                } else if (index == R$styleable.mq) {
                    this.f1911y4 = obtainStyledAttributes.getFloat(index, this.f1911y4);
                } else if (index == R$styleable.x0) {
                    this.f1909tg = obtainStyledAttributes.getFloat(index, this.f1909tg);
                } else if (index == R$styleable.f1793mc) {
                    this.f1907pz = obtainStyledAttributes.getFloat(index, this.f1907pz);
                } else if (index == R$styleable.iu) {
                    this.f1906pq = obtainStyledAttributes.getFloat(index, this.f1906pq);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }
}
