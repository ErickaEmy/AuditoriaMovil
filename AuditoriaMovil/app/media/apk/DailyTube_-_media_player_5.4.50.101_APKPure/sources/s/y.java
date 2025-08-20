package s;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.R$styleable;
import t.n3;
/* loaded from: classes.dex */
public abstract class y {

    /* loaded from: classes.dex */
    public interface n3 {
        void y(boolean z2);
    }

    @Deprecated
    /* loaded from: classes.dex */
    public static abstract class zn {
        public abstract CharSequence gv();

        public abstract View n3();

        public abstract void v();

        public abstract CharSequence y();

        public abstract Drawable zn();
    }

    public boolean a() {
        return false;
    }

    public abstract int c5();

    public abstract void co(boolean z2);

    public boolean f() {
        return false;
    }

    public abstract boolean fb();

    public t.n3 i4(n3.y yVar) {
        return null;
    }

    public abstract Context i9();

    public abstract void mt(boolean z2);

    public abstract void p(boolean z2);

    public abstract void r(int i);

    public abstract void s(boolean z2);

    public boolean w() {
        return false;
    }

    public abstract boolean wz(int i, KeyEvent keyEvent);

    public abstract void x4(CharSequence charSequence);

    public boolean xc(KeyEvent keyEvent) {
        return false;
    }

    public abstract void z(int i);

    /* renamed from: s.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0211y extends ViewGroup.MarginLayoutParams {
        public int y;

        public C0211y(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f929z);
            this.y = obtainStyledAttributes.getInt(R$styleable.f889r, 0);
            obtainStyledAttributes.recycle();
        }

        public C0211y(int i, int i5) {
            super(i, i5);
            this.y = 8388627;
        }

        public C0211y(C0211y c0211y) {
            super((ViewGroup.MarginLayoutParams) c0211y);
            this.y = c0211y.y;
        }

        public C0211y(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public void tl() {
    }

    public void t(Configuration configuration) {
    }
}
