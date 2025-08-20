package androidx.appcompat.widget;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.widget.LinearLayoutCompat;
import s.y;
import wz.j5;
/* loaded from: classes.dex */
public class n3 extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: z  reason: collision with root package name */
    public static final Interpolator f1505z = new DecelerateInterpolator();

    /* renamed from: co  reason: collision with root package name */
    public int f1506co;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1507f;

    /* renamed from: fb  reason: collision with root package name */
    public LinearLayoutCompat f1508fb;

    /* renamed from: p  reason: collision with root package name */
    public int f1509p;

    /* renamed from: s  reason: collision with root package name */
    public Spinner f1510s;

    /* renamed from: t  reason: collision with root package name */
    public int f1511t;

    /* renamed from: v  reason: collision with root package name */
    public zn f1512v;

    /* renamed from: w  reason: collision with root package name */
    public int f1513w;
    public Runnable y;

    /* loaded from: classes.dex */
    public class gv extends LinearLayout {

        /* renamed from: f  reason: collision with root package name */
        public View f1514f;

        /* renamed from: fb  reason: collision with root package name */
        public TextView f1515fb;

        /* renamed from: s  reason: collision with root package name */
        public ImageView f1516s;

        /* renamed from: v  reason: collision with root package name */
        public y.zn f1518v;
        public final int[] y;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public gv(android.content.Context r4, s.y.zn r5, boolean r6) {
            /*
                r2 = this;
                androidx.appcompat.widget.n3.this = r3
                int r3 = androidx.appcompat.R$attr.f638gv
                r0 = 0
                r2.<init>(r4, r0, r3)
                r1 = 16842964(0x10100d4, float:2.3694152E-38)
                int[] r1 = new int[]{r1}
                r2.y = r1
                r2.f1518v = r5
                r5 = 0
                wz.hw r3 = wz.hw.x4(r4, r0, r1, r3, r5)
                boolean r4 = r3.co(r5)
                if (r4 == 0) goto L25
                android.graphics.drawable.Drawable r4 = r3.fb(r5)
                r2.setBackgroundDrawable(r4)
            L25:
                r3.i4()
                if (r6 == 0) goto L30
                r3 = 8388627(0x800013, float:1.175497E-38)
                r2.setGravity(r3)
            L30:
                r2.zn()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.n3.gv.<init>(androidx.appcompat.widget.n3, android.content.Context, s.y$zn, boolean):void");
        }

        public y.zn n3() {
            return this.f1518v;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i5) {
            super.onMeasure(i, i5);
            if (n3.this.f1511t > 0) {
                int measuredWidth = getMeasuredWidth();
                int i6 = n3.this.f1511t;
                if (measuredWidth > i6) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i6, 1073741824), i5);
                }
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z2) {
            boolean z3;
            if (isSelected() != z2) {
                z3 = true;
            } else {
                z3 = false;
            }
            super.setSelected(z2);
            if (z3 && z2) {
                sendAccessibilityEvent(4);
            }
        }

        public void y(y.zn znVar) {
            this.f1518v = znVar;
            zn();
        }

        public void zn() {
            y.zn znVar = this.f1518v;
            View n32 = znVar.n3();
            CharSequence charSequence = null;
            if (n32 != null) {
                ViewParent parent = n32.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(n32);
                    }
                    addView(n32);
                }
                this.f1514f = n32;
                TextView textView = this.f1515fb;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f1516s;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f1516s.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.f1514f;
            if (view != null) {
                removeView(view);
                this.f1514f = null;
            }
            Drawable zn2 = znVar.zn();
            CharSequence gv2 = znVar.gv();
            if (zn2 != null) {
                if (this.f1516s == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.f1516s = appCompatImageView;
                }
                this.f1516s.setImageDrawable(zn2);
                this.f1516s.setVisibility(0);
            } else {
                ImageView imageView2 = this.f1516s;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f1516s.setImageDrawable(null);
                }
            }
            boolean isEmpty = TextUtils.isEmpty(gv2);
            if (!isEmpty) {
                if (this.f1515fb == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null, R$attr.f654v);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.f1515fb = appCompatTextView;
                }
                this.f1515fb.setText(gv2);
                this.f1515fb.setVisibility(0);
            } else {
                TextView textView2 = this.f1515fb;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f1515fb.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.f1516s;
            if (imageView3 != null) {
                imageView3.setContentDescription(znVar.y());
            }
            if (isEmpty) {
                charSequence = znVar.y();
            }
            j5.y(this, charSequence);
        }
    }

    /* renamed from: androidx.appcompat.widget.n3$n3  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0013n3 extends BaseAdapter {
        public C0013n3() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return n3.this.f1508fb.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return ((gv) n3.this.f1508fb.getChildAt(i)).n3();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return n3.this.zn((y.zn) getItem(i), true);
            }
            ((gv) view).y((y.zn) getItem(i));
            return view;
        }
    }

    /* loaded from: classes.dex */
    public class y implements Runnable {
        public final /* synthetic */ View y;

        public y(View view) {
            this.y = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            n3.this.smoothScrollTo(this.y.getLeft() - ((n3.this.getWidth() - this.y.getWidth()) / 2), 0);
            n3.this.y = null;
        }
    }

    /* loaded from: classes.dex */
    public class zn implements View.OnClickListener {
        public zn() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z2;
            ((gv) view).n3().v();
            int childCount = n3.this.f1508fb.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = n3.this.f1508fb.getChildAt(i);
                if (childAt == view) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                childAt.setSelected(z2);
            }
        }
    }

    public final boolean a() {
        if (!gv()) {
            return false;
        }
        removeView(this.f1510s);
        addView(this.f1508fb, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f1510s.getSelectedItemPosition());
        return false;
    }

    public final boolean gv() {
        Spinner spinner = this.f1510s;
        if (spinner != null && spinner.getParent() == this) {
            return true;
        }
        return false;
    }

    public final Spinner n3() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), null, R$attr.f649s);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.y(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.y;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        t.y n32 = t.y.n3(getContext());
        setContentHeight(n32.a());
        this.f1513w = n32.v();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.y;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j2) {
        ((gv) view).n3().v();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i5) {
        boolean z2;
        int mode = View.MeasureSpec.getMode(i);
        if (mode == 1073741824) {
            z2 = true;
        } else {
            z2 = false;
        }
        setFillViewport(z2);
        int childCount = this.f1508fb.getChildCount();
        if (childCount > 1 && (mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            if (childCount > 2) {
                this.f1511t = (int) (View.MeasureSpec.getSize(i) * 0.4f);
            } else {
                this.f1511t = View.MeasureSpec.getSize(i) / 2;
            }
            this.f1511t = Math.min(this.f1511t, this.f1513w);
        } else {
            this.f1511t = -1;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f1509p, 1073741824);
        if (!z2 && this.f1507f) {
            this.f1508fb.measure(0, makeMeasureSpec);
            if (this.f1508fb.getMeasuredWidth() > View.MeasureSpec.getSize(i)) {
                v();
            } else {
                a();
            }
        } else {
            a();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (z2 && measuredWidth != measuredWidth2) {
            setTabSelected(this.f1506co);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z2) {
        this.f1507f = z2;
    }

    public void setContentHeight(int i) {
        this.f1509p = i;
        requestLayout();
    }

    public void setTabSelected(int i) {
        boolean z2;
        this.f1506co = i;
        int childCount = this.f1508fb.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = this.f1508fb.getChildAt(i5);
            if (i5 == i) {
                z2 = true;
            } else {
                z2 = false;
            }
            childAt.setSelected(z2);
            if (z2) {
                y(i);
            }
        }
        Spinner spinner = this.f1510s;
        if (spinner != null && i >= 0) {
            spinner.setSelection(i);
        }
    }

    public final void v() {
        if (gv()) {
            return;
        }
        if (this.f1510s == null) {
            this.f1510s = n3();
        }
        removeView(this.f1508fb);
        addView(this.f1510s, new ViewGroup.LayoutParams(-2, -1));
        if (this.f1510s.getAdapter() == null) {
            this.f1510s.setAdapter((SpinnerAdapter) new C0013n3());
        }
        Runnable runnable = this.y;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.y = null;
        }
        this.f1510s.setSelection(this.f1506co);
    }

    public void y(int i) {
        View childAt = this.f1508fb.getChildAt(i);
        Runnable runnable = this.y;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        y yVar = new y(childAt);
        this.y = yVar;
        post(yVar);
    }

    public gv zn(y.zn znVar, boolean z2) {
        gv gvVar = new gv(getContext(), znVar, z2);
        if (z2) {
            gvVar.setBackgroundDrawable(null);
            gvVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.f1509p));
        } else {
            gvVar.setFocusable(true);
            if (this.f1512v == null) {
                this.f1512v = new zn();
            }
            gvVar.setOnClickListener(this.f1512v);
        }
        return gvVar;
    }
}
