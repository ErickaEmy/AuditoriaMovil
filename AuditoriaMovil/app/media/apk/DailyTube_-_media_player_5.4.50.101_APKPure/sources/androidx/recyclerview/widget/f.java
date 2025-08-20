package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: n3  reason: collision with root package name */
    public int f3231n3;
    public final RecyclerView.w y;

    /* renamed from: zn  reason: collision with root package name */
    public final Rect f3232zn;

    /* loaded from: classes.dex */
    public class n3 extends f {
        public n3(RecyclerView.w wVar) {
            super(wVar, null);
        }

        @Override // androidx.recyclerview.widget.f
        public int a(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.y.xg(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.f
        public int c5() {
            return this.y.rs() - this.y.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.f
        public int f() {
            return this.y.eb();
        }

        @Override // androidx.recyclerview.widget.f
        public int fb(View view) {
            return this.y.ct(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).topMargin;
        }

        @Override // androidx.recyclerview.widget.f
        public int gv(View view) {
            return this.y.en(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.f
        public int i9() {
            return this.y.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.f
        public void mt(int i) {
            this.y.vp(i);
        }

        @Override // androidx.recyclerview.widget.f
        public int p(View view) {
            this.y.m(view, true, this.f3232zn);
            return this.f3232zn.top;
        }

        @Override // androidx.recyclerview.widget.f
        public int s() {
            return this.y.rs();
        }

        @Override // androidx.recyclerview.widget.f
        public int t() {
            return this.y.u0();
        }

        @Override // androidx.recyclerview.widget.f
        public int tl() {
            return this.y.getPaddingTop();
        }

        @Override // androidx.recyclerview.widget.f
        public int v(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.y.y5(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.f
        public int w(View view) {
            this.y.m(view, true, this.f3232zn);
            return this.f3232zn.bottom;
        }

        @Override // androidx.recyclerview.widget.f
        public int wz() {
            return (this.y.rs() - this.y.getPaddingTop()) - this.y.getPaddingBottom();
        }
    }

    /* loaded from: classes.dex */
    public class y extends f {
        public y(RecyclerView.w wVar) {
            super(wVar, null);
        }

        @Override // androidx.recyclerview.widget.f
        public int a(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.y.y5(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.f
        public int c5() {
            return this.y.g() - this.y.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.f
        public int f() {
            return this.y.u0();
        }

        @Override // androidx.recyclerview.widget.f
        public int fb(View view) {
            return this.y.u(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).leftMargin;
        }

        @Override // androidx.recyclerview.widget.f
        public int gv(View view) {
            return this.y.dm(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).rightMargin;
        }

        @Override // androidx.recyclerview.widget.f
        public int i9() {
            return this.y.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.f
        public void mt(int i) {
            this.y.gq(i);
        }

        @Override // androidx.recyclerview.widget.f
        public int p(View view) {
            this.y.m(view, true, this.f3232zn);
            return this.f3232zn.left;
        }

        @Override // androidx.recyclerview.widget.f
        public int s() {
            return this.y.g();
        }

        @Override // androidx.recyclerview.widget.f
        public int t() {
            return this.y.eb();
        }

        @Override // androidx.recyclerview.widget.f
        public int tl() {
            return this.y.getPaddingLeft();
        }

        @Override // androidx.recyclerview.widget.f
        public int v(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.y.xg(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.f
        public int w(View view) {
            this.y.m(view, true, this.f3232zn);
            return this.f3232zn.right;
        }

        @Override // androidx.recyclerview.widget.f
        public int wz() {
            return (this.y.g() - this.y.getPaddingLeft()) - this.y.getPaddingRight();
        }
    }

    public /* synthetic */ f(RecyclerView.w wVar, y yVar) {
        this(wVar);
    }

    public static f n3(RecyclerView.w wVar, int i) {
        if (i != 0) {
            if (i == 1) {
                return zn(wVar);
            }
            throw new IllegalArgumentException("invalid orientation");
        }
        return y(wVar);
    }

    public static f y(RecyclerView.w wVar) {
        return new y(wVar);
    }

    public static f zn(RecyclerView.w wVar) {
        return new n3(wVar);
    }

    public abstract int a(View view);

    public abstract int c5();

    public void co() {
        this.f3231n3 = wz();
    }

    public abstract int f();

    public abstract int fb(View view);

    public abstract int gv(View view);

    public abstract int i9();

    public abstract void mt(int i);

    public abstract int p(View view);

    public abstract int s();

    public abstract int t();

    public abstract int tl();

    public abstract int v(View view);

    public abstract int w(View view);

    public abstract int wz();

    public int xc() {
        if (Integer.MIN_VALUE == this.f3231n3) {
            return 0;
        }
        return wz() - this.f3231n3;
    }

    public f(RecyclerView.w wVar) {
        this.f3231n3 = Integer.MIN_VALUE;
        this.f3232zn = new Rect();
        this.y = wVar;
    }
}
