package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.R$attr;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.badge.BadgeDrawable;
import hw.i4;
import hw.z;
import j.tl;
import j5.zn;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import ur.f;
import wz.j5;
@ViewPager.zn
/* loaded from: classes.dex */
public class TabLayout extends HorizontalScrollView {

    /* renamed from: e  reason: collision with root package name */
    public static final int f5877e = R$style.zp;

    /* renamed from: s8  reason: collision with root package name */
    public static final vl.v<fb> f5878s8 = new vl.fb(16);

    /* renamed from: b  reason: collision with root package name */
    public final int f5879b;

    /* renamed from: c  reason: collision with root package name */
    public PorterDuff.Mode f5880c;

    /* renamed from: co  reason: collision with root package name */
    public ColorStateList f5881co;
    @Nullable

    /* renamed from: ct  reason: collision with root package name */
    public ViewPager f5882ct;

    /* renamed from: d  reason: collision with root package name */
    public final int f5883d;

    /* renamed from: d0  reason: collision with root package name */
    public float f5884d0;

    /* renamed from: dm  reason: collision with root package name */
    public ValueAnimator f5885dm;

    /* renamed from: eb  reason: collision with root package name */
    public s f5886eb;

    /* renamed from: ej  reason: collision with root package name */
    public int f5887ej;

    /* renamed from: en  reason: collision with root package name */
    public boolean f5888en;

    /* renamed from: f  reason: collision with root package name */
    public int f5889f;
    @NonNull

    /* renamed from: f3  reason: collision with root package name */
    public Drawable f5890f3;

    /* renamed from: f7  reason: collision with root package name */
    public int f5891f7;
    @NonNull

    /* renamed from: fb  reason: collision with root package name */
    public final a f5892fb;

    /* renamed from: fh  reason: collision with root package name */
    public float f5893fh;

    /* renamed from: j  reason: collision with root package name */
    public int f5894j;

    /* renamed from: j5  reason: collision with root package name */
    public final int f5895j5;

    /* renamed from: jz  reason: collision with root package name */
    public com.google.android.material.tabs.y f5896jz;

    /* renamed from: k  reason: collision with root package name */
    public boolean f5897k;

    /* renamed from: lc  reason: collision with root package name */
    public n3 f5898lc;

    /* renamed from: n  reason: collision with root package name */
    public int f5899n;

    /* renamed from: nf  reason: collision with root package name */
    public boolean f5900nf;

    /* renamed from: o  reason: collision with root package name */
    public int f5901o;
    @Nullable

    /* renamed from: o4  reason: collision with root package name */
    public PagerAdapter f5902o4;

    /* renamed from: oz  reason: collision with root package name */
    public int f5903oz;

    /* renamed from: p  reason: collision with root package name */
    public int f5904p;

    /* renamed from: q9  reason: collision with root package name */
    public boolean f5905q9;

    /* renamed from: qn  reason: collision with root package name */
    public int f5906qn;

    /* renamed from: r  reason: collision with root package name */
    public ColorStateList f5907r;

    /* renamed from: ra  reason: collision with root package name */
    public final vl.v<c5> f5908ra;

    /* renamed from: rs  reason: collision with root package name */
    public DataSetObserver f5909rs;

    /* renamed from: s  reason: collision with root package name */
    public int f5910s;

    /* renamed from: t  reason: collision with root package name */
    public int f5911t;
    @Nullable

    /* renamed from: u  reason: collision with root package name */
    public zn f5912u;

    /* renamed from: ut  reason: collision with root package name */
    public int f5913ut;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public fb f5914v;

    /* renamed from: w  reason: collision with root package name */
    public int f5915w;

    /* renamed from: x  reason: collision with root package name */
    public final int f5916x;
    @Nullable

    /* renamed from: xg  reason: collision with root package name */
    public zn f5917xg;
    public final ArrayList<fb> y;

    /* renamed from: y5  reason: collision with root package name */
    public final ArrayList<zn> f5918y5;

    /* renamed from: z  reason: collision with root package name */
    public ColorStateList f5919z;

    /* loaded from: classes.dex */
    public class a extends LinearLayout {

        /* renamed from: fb  reason: collision with root package name */
        public float f5921fb;

        /* renamed from: s  reason: collision with root package name */
        public int f5922s;

        /* renamed from: v  reason: collision with root package name */
        public int f5923v;
        public ValueAnimator y;

        /* loaded from: classes.dex */
        public class n3 extends AnimatorListenerAdapter {
            public final /* synthetic */ int y;

            public n3(int i) {
                this.y = i;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.f5923v = this.y;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                a.this.f5923v = this.y;
            }
        }

        /* loaded from: classes.dex */
        public class y implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: n3  reason: collision with root package name */
            public final /* synthetic */ View f5925n3;
            public final /* synthetic */ View y;

            public y(View view, View view2) {
                this.y = view;
                this.f5925n3 = view2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                a.this.fb(this.y, this.f5925n3, valueAnimator.getAnimatedFraction());
            }
        }

        public a(Context context) {
            super(context);
            this.f5923v = -1;
            this.f5922s = -1;
            setWillNotDraw(false);
        }

        public void a(int i) {
            Rect bounds = TabLayout.this.f5890f3.getBounds();
            TabLayout.this.f5890f3.setBounds(bounds.left, 0, bounds.right, i);
            requestLayout();
        }

        @Override // android.view.View
        public void draw(@NonNull Canvas canvas) {
            int height;
            int height2 = TabLayout.this.f5890f3.getBounds().height();
            if (height2 < 0) {
                height2 = TabLayout.this.f5890f3.getIntrinsicHeight();
            }
            int i = TabLayout.this.f5903oz;
            if (i != 0) {
                if (i != 1) {
                    height = 0;
                    if (i != 2) {
                        if (i != 3) {
                            height2 = 0;
                        } else {
                            height2 = getHeight();
                        }
                    }
                } else {
                    height = (getHeight() - height2) / 2;
                    height2 = (getHeight() + height2) / 2;
                }
            } else {
                height = getHeight() - height2;
                height2 = getHeight();
            }
            if (TabLayout.this.f5890f3.getBounds().width() > 0) {
                Rect bounds = TabLayout.this.f5890f3.getBounds();
                TabLayout.this.f5890f3.setBounds(bounds.left, height, bounds.right, height2);
                TabLayout tabLayout = TabLayout.this;
                Drawable drawable = tabLayout.f5890f3;
                if (tabLayout.f5899n != 0) {
                    drawable = ej.y.mt(drawable);
                    if (Build.VERSION.SDK_INT == 21) {
                        drawable.setColorFilter(TabLayout.this.f5899n, PorterDuff.Mode.SRC_IN);
                    } else {
                        ej.y.wz(drawable, TabLayout.this.f5899n);
                    }
                }
                drawable.draw(canvas);
            }
            super.draw(canvas);
        }

        public final void fb(View view, View view2, float f4) {
            if (view != null && view.getWidth() > 0) {
                com.google.android.material.tabs.y yVar = TabLayout.this.f5896jz;
                TabLayout tabLayout = TabLayout.this;
                yVar.zn(tabLayout, view, view2, f4, tabLayout.f5890f3);
            } else {
                Drawable drawable = TabLayout.this.f5890f3;
                drawable.setBounds(-1, drawable.getBounds().top, -1, TabLayout.this.f5890f3.getBounds().bottom);
            }
            i4.lc(this);
        }

        public final void gv() {
            View childAt = getChildAt(this.f5923v);
            com.google.android.material.tabs.y yVar = TabLayout.this.f5896jz;
            TabLayout tabLayout = TabLayout.this;
            yVar.gv(tabLayout, childAt, tabLayout.f5890f3);
        }

        public void n3(int i, int i5) {
            ValueAnimator valueAnimator = this.y;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.y.cancel();
            }
            s(true, i, i5);
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z2, int i, int i5, int i6, int i8) {
            super.onLayout(z2, i, i5, i6, i8);
            ValueAnimator valueAnimator = this.y;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                s(false, this.f5923v, -1);
            } else {
                gv();
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i5) {
            super.onMeasure(i, i5);
            if (View.MeasureSpec.getMode(i) != 1073741824) {
                return;
            }
            TabLayout tabLayout = TabLayout.this;
            boolean z2 = true;
            if (tabLayout.f5901o == 1 || tabLayout.f5913ut == 2) {
                int childCount = getChildCount();
                int i6 = 0;
                for (int i8 = 0; i8 < childCount; i8++) {
                    View childAt = getChildAt(i8);
                    if (childAt.getVisibility() == 0) {
                        i6 = Math.max(i6, childAt.getMeasuredWidth());
                    }
                }
                if (i6 <= 0) {
                    return;
                }
                if (i6 * childCount <= getMeasuredWidth() - (((int) f.n3(getContext(), 16)) * 2)) {
                    boolean z3 = false;
                    for (int i10 = 0; i10 < childCount; i10++) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i10).getLayoutParams();
                        if (layoutParams.width != i6 || layoutParams.weight != 0.0f) {
                            layoutParams.width = i6;
                            layoutParams.weight = 0.0f;
                            z3 = true;
                        }
                    }
                    z2 = z3;
                } else {
                    TabLayout tabLayout2 = TabLayout.this;
                    tabLayout2.f5901o = 0;
                    tabLayout2.hw(false);
                }
                if (z2) {
                    super.onMeasure(i, i5);
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i) {
            super.onRtlPropertiesChanged(i);
            if (Build.VERSION.SDK_INT < 23 && this.f5922s != i) {
                requestLayout();
                this.f5922s = i;
            }
        }

        public final void s(boolean z2, int i, int i5) {
            View childAt = getChildAt(this.f5923v);
            View childAt2 = getChildAt(i);
            if (childAt2 == null) {
                gv();
                return;
            }
            y yVar = new y(childAt, childAt2);
            if (z2) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.y = valueAnimator;
                valueAnimator.setInterpolator(y6.y.f15325n3);
                valueAnimator.setDuration(i5);
                valueAnimator.setFloatValues(0.0f, 1.0f);
                valueAnimator.addUpdateListener(yVar);
                valueAnimator.addListener(new n3(i));
                valueAnimator.start();
                return;
            }
            this.y.removeAllUpdateListeners();
            this.y.addUpdateListener(yVar);
        }

        public void v(int i, float f4) {
            ValueAnimator valueAnimator = this.y;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.y.cancel();
            }
            this.f5923v = i;
            this.f5921fb = f4;
            fb(getChildAt(i), getChildAt(this.f5923v + 1), this.f5921fb);
        }

        public boolean zn() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public final class c5 extends LinearLayout {
        @Nullable

        /* renamed from: co  reason: collision with root package name */
        public Drawable f5927co;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        public BadgeDrawable f5928f;

        /* renamed from: fb  reason: collision with root package name */
        public ImageView f5929fb;
        @Nullable

        /* renamed from: p  reason: collision with root package name */
        public ImageView f5930p;
        @Nullable

        /* renamed from: s  reason: collision with root package name */
        public View f5932s;
        @Nullable

        /* renamed from: t  reason: collision with root package name */
        public View f5933t;

        /* renamed from: v  reason: collision with root package name */
        public TextView f5934v;
        @Nullable

        /* renamed from: w  reason: collision with root package name */
        public TextView f5935w;
        public fb y;

        /* renamed from: z  reason: collision with root package name */
        public int f5936z;

        /* loaded from: classes.dex */
        public class y implements View.OnLayoutChangeListener {
            public final /* synthetic */ View y;

            public y(View view) {
                this.y = view;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i5, int i6, int i8, int i10, int i11, int i12, int i13) {
                if (this.y.getVisibility() == 0) {
                    c5.this.co(this.y);
                }
            }
        }

        public c5(@NonNull Context context) {
            super(context);
            this.f5936z = 2;
            r(context);
            i4.cy(this, TabLayout.this.f5910s, TabLayout.this.f5889f, TabLayout.this.f5911t, TabLayout.this.f5915w);
            setGravity(17);
            setOrientation(!TabLayout.this.f5905q9 ? 1 : 0);
            setClickable(true);
            i4.qk(this, z.n3(getContext(), 1002));
        }

        @Nullable
        private BadgeDrawable getBadge() {
            return this.f5928f;
        }

        @NonNull
        private BadgeDrawable getOrCreateBadge() {
            if (this.f5928f == null) {
                this.f5928f = BadgeDrawable.zn(getContext());
            }
            mt();
            BadgeDrawable badgeDrawable = this.f5928f;
            if (badgeDrawable != null) {
                return badgeDrawable;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        public final void a(@Nullable View view) {
            if (view == null) {
                return;
            }
            view.addOnLayoutChangeListener(new y(view));
        }

        @NonNull
        public final FrameLayout c5() {
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return frameLayout;
        }

        public final void co(@NonNull View view) {
            if (t() && view == this.f5932s) {
                com.google.android.material.badge.y.zn(this.f5928f, view, f(view));
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public void drawableStateChanged() {
            boolean z2;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.f5927co;
            if (drawable != null && drawable.isStateful()) {
                z2 = this.f5927co.setState(drawableState);
            } else {
                z2 = false;
            }
            if (z2) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        @Nullable
        public final FrameLayout f(@NonNull View view) {
            if ((view != this.f5929fb && view != this.f5934v) || !com.google.android.material.badge.y.y) {
                return null;
            }
            return (FrameLayout) view.getParent();
        }

        public final float fb(@NonNull Layout layout, int i, float f4) {
            return layout.getLineWidth(i) * (f4 / layout.getPaint().getTextSize());
        }

        public int getContentHeight() {
            View[] viewArr = {this.f5934v, this.f5929fb, this.f5933t};
            int i = 0;
            int i5 = 0;
            boolean z2 = false;
            for (int i6 = 0; i6 < 3; i6++) {
                View view = viewArr[i6];
                if (view != null && view.getVisibility() == 0) {
                    if (z2) {
                        i5 = Math.min(i5, view.getTop());
                    } else {
                        i5 = view.getTop();
                    }
                    if (z2) {
                        i = Math.max(i, view.getBottom());
                    } else {
                        i = view.getBottom();
                    }
                    z2 = true;
                }
            }
            return i - i5;
        }

        public int getContentWidth() {
            View[] viewArr = {this.f5934v, this.f5929fb, this.f5933t};
            int i = 0;
            int i5 = 0;
            boolean z2 = false;
            for (int i6 = 0; i6 < 3; i6++) {
                View view = viewArr[i6];
                if (view != null && view.getVisibility() == 0) {
                    if (z2) {
                        i5 = Math.min(i5, view.getLeft());
                    } else {
                        i5 = view.getLeft();
                    }
                    if (z2) {
                        i = Math.max(i, view.getRight());
                    } else {
                        i = view.getRight();
                    }
                    z2 = true;
                }
            }
            return i - i5;
        }

        @Nullable
        public fb getTab() {
            return this.y;
        }

        public final void i4(@Nullable TextView textView, @Nullable ImageView imageView) {
            Drawable drawable;
            CharSequence charSequence;
            int i;
            fb fbVar = this.y;
            CharSequence charSequence2 = null;
            if (fbVar != null && fbVar.a() != null) {
                drawable = ej.y.mt(this.y.a()).mutate();
            } else {
                drawable = null;
            }
            fb fbVar2 = this.y;
            if (fbVar2 != null) {
                charSequence = fbVar2.i9();
            } else {
                charSequence = null;
            }
            if (imageView != null) {
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean isEmpty = TextUtils.isEmpty(charSequence);
            if (textView != null) {
                if (!isEmpty) {
                    textView.setText(charSequence);
                    if (this.y.f5940fb == 1) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                if (!isEmpty && imageView.getVisibility() == 0) {
                    i = (int) f.n3(getContext(), 8);
                } else {
                    i = 0;
                }
                if (TabLayout.this.f5905q9) {
                    if (i != hw.s.y(marginLayoutParams)) {
                        hw.s.zn(marginLayoutParams, i);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (i != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = i;
                    hw.s.zn(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            fb fbVar3 = this.y;
            if (fbVar3 != null) {
                charSequence2 = fbVar3.f5941gv;
            }
            if (isEmpty) {
                charSequence = charSequence2;
            }
            j5.y(this, charSequence);
        }

        public final void i9(@NonNull Canvas canvas) {
            Drawable drawable = this.f5927co;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.f5927co.draw(canvas);
            }
        }

        public final void mt() {
            fb fbVar;
            fb fbVar2;
            if (!t()) {
                return;
            }
            if (this.f5933t != null) {
                p();
            } else if (this.f5929fb != null && (fbVar2 = this.y) != null && fbVar2.a() != null) {
                View view = this.f5932s;
                ImageView imageView = this.f5929fb;
                if (view != imageView) {
                    p();
                    w(this.f5929fb);
                    return;
                }
                co(imageView);
            } else if (this.f5934v != null && (fbVar = this.y) != null && fbVar.s() == 1) {
                View view2 = this.f5932s;
                TextView textView = this.f5934v;
                if (view2 != textView) {
                    p();
                    w(this.f5934v);
                    return;
                }
                co(textView);
            } else {
                p();
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            BadgeDrawable badgeDrawable = this.f5928f;
            if (badgeDrawable != null && badgeDrawable.isVisible()) {
                CharSequence contentDescription = getContentDescription();
                accessibilityNodeInfo.setContentDescription(((Object) contentDescription) + ", " + ((Object) this.f5928f.fb()));
            }
            j5.zn w22 = j5.zn.w2(accessibilityNodeInfo);
            w22.yg(zn.fb.y(0, 1, this.y.fb(), 1, false, isSelected()));
            if (isSelected()) {
                w22.s8(false);
                w22.dm(zn.y.f9381c5);
            }
            w22.o0(getResources().getString(R$string.faq));
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i5) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i = View.MeasureSpec.makeMeasureSpec(TabLayout.this.f5887ej, Integer.MIN_VALUE);
            }
            super.onMeasure(i, i5);
            if (this.f5934v != null) {
                float f4 = TabLayout.this.f5884d0;
                int i6 = this.f5936z;
                ImageView imageView = this.f5929fb;
                if (imageView != null && imageView.getVisibility() == 0) {
                    i6 = 1;
                } else {
                    TextView textView = this.f5934v;
                    if (textView != null && textView.getLineCount() > 1) {
                        f4 = TabLayout.this.f5893fh;
                    }
                }
                float textSize = this.f5934v.getTextSize();
                int lineCount = this.f5934v.getLineCount();
                int gv2 = tl.gv(this.f5934v);
                int i8 = (f4 > textSize ? 1 : (f4 == textSize ? 0 : -1));
                if (i8 != 0 || (gv2 >= 0 && i6 != gv2)) {
                    if (TabLayout.this.f5913ut != 1 || i8 <= 0 || lineCount != 1 || ((layout = this.f5934v.getLayout()) != null && fb(layout, 0, f4) <= (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        this.f5934v.setTextSize(0, f4);
                        this.f5934v.setMaxLines(i6);
                        super.onMeasure(i, i5);
                    }
                }
            }
        }

        public final void p() {
            if (!t()) {
                return;
            }
            s(true);
            View view = this.f5932s;
            if (view != null) {
                com.google.android.material.badge.y.n3(this.f5928f, view);
                this.f5932s = null;
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.y != null) {
                if (!performClick) {
                    playSoundEffect(0);
                }
                this.y.tl();
                return true;
            }
            return performClick;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0, types: [android.graphics.drawable.RippleDrawable] */
        public final void r(Context context) {
            int i = TabLayout.this.f5883d;
            GradientDrawable gradientDrawable = null;
            if (i != 0) {
                Drawable gv2 = c5.y.gv(context, i);
                this.f5927co = gv2;
                if (gv2 != null && gv2.isStateful()) {
                    this.f5927co.setState(getDrawableState());
                }
            } else {
                this.f5927co = null;
            }
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(0);
            if (TabLayout.this.f5907r != null) {
                GradientDrawable gradientDrawable3 = new GradientDrawable();
                gradientDrawable3.setCornerRadius(1.0E-5f);
                gradientDrawable3.setColor(-1);
                ColorStateList y2 = nr.n3.y(TabLayout.this.f5907r);
                boolean z2 = TabLayout.this.f5888en;
                if (z2) {
                    gradientDrawable2 = null;
                }
                if (!z2) {
                    gradientDrawable = gradientDrawable3;
                }
                gradientDrawable2 = new RippleDrawable(y2, gradientDrawable2, gradientDrawable);
            }
            i4.u0(this, gradientDrawable2);
            TabLayout.this.invalidate();
        }

        public final void s(boolean z2) {
            setClipChildren(z2);
            setClipToPadding(z2);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(z2);
                viewGroup.setClipToPadding(z2);
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z2) {
            isSelected();
            super.setSelected(z2);
            TextView textView = this.f5934v;
            if (textView != null) {
                textView.setSelected(z2);
            }
            ImageView imageView = this.f5929fb;
            if (imageView != null) {
                imageView.setSelected(z2);
            }
            View view = this.f5933t;
            if (view != null) {
                view.setSelected(z2);
            }
        }

        public void setTab(@Nullable fb fbVar) {
            if (fbVar != this.y) {
                this.y = fbVar;
                z();
            }
        }

        public final boolean t() {
            if (this.f5928f != null) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void tl() {
            FrameLayout frameLayout;
            if (com.google.android.material.badge.y.y) {
                frameLayout = c5();
                addView(frameLayout, 0);
            } else {
                frameLayout = this;
            }
            ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R$layout.s4, (ViewGroup) frameLayout, false);
            this.f5929fb = imageView;
            frameLayout.addView(imageView, 0);
        }

        public final void w(@Nullable View view) {
            if (t() && view != null) {
                s(false);
                com.google.android.material.badge.y.y(this.f5928f, view, f(view));
                this.f5932s = view;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void wz() {
            FrameLayout frameLayout;
            if (com.google.android.material.badge.y.y) {
                frameLayout = c5();
                addView(frameLayout);
            } else {
                frameLayout = this;
            }
            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R$layout.s5, (ViewGroup) frameLayout, false);
            this.f5934v = textView;
            frameLayout.addView(textView);
        }

        public final void x4() {
            setOrientation(!TabLayout.this.f5905q9 ? 1 : 0);
            TextView textView = this.f5935w;
            if (textView == null && this.f5930p == null) {
                i4(this.f5934v, this.f5929fb);
            } else {
                i4(textView, this.f5930p);
            }
        }

        public void xc() {
            setTab(null);
            setSelected(false);
        }

        public final void z() {
            View view;
            boolean z2;
            fb fbVar = this.y;
            Drawable drawable = null;
            if (fbVar != null) {
                view = fbVar.v();
            } else {
                view = null;
            }
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(view);
                    }
                    addView(view);
                }
                this.f5933t = view;
                TextView textView = this.f5934v;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f5929fb;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f5929fb.setImageDrawable(null);
                }
                TextView textView2 = (TextView) view.findViewById(16908308);
                this.f5935w = textView2;
                if (textView2 != null) {
                    this.f5936z = tl.gv(textView2);
                }
                this.f5930p = (ImageView) view.findViewById(16908294);
            } else {
                View view2 = this.f5933t;
                if (view2 != null) {
                    removeView(view2);
                    this.f5933t = null;
                }
                this.f5935w = null;
                this.f5930p = null;
            }
            if (this.f5933t == null) {
                if (this.f5929fb == null) {
                    tl();
                }
                if (fbVar != null && fbVar.a() != null) {
                    drawable = ej.y.mt(fbVar.a()).mutate();
                }
                if (drawable != null) {
                    ej.y.xc(drawable, TabLayout.this.f5919z);
                    PorterDuff.Mode mode = TabLayout.this.f5880c;
                    if (mode != null) {
                        ej.y.w(drawable, mode);
                    }
                }
                if (this.f5934v == null) {
                    wz();
                    this.f5936z = tl.gv(this.f5934v);
                }
                tl.xc(this.f5934v, TabLayout.this.f5904p);
                ColorStateList colorStateList = TabLayout.this.f5881co;
                if (colorStateList != null) {
                    this.f5934v.setTextColor(colorStateList);
                }
                i4(this.f5934v, this.f5929fb);
                mt();
                a(this.f5929fb);
                a(this.f5934v);
            } else {
                TextView textView3 = this.f5935w;
                if (textView3 != null || this.f5930p != null) {
                    i4(textView3, this.f5930p);
                }
            }
            if (fbVar != null && !TextUtils.isEmpty(fbVar.f5941gv)) {
                setContentDescription(fbVar.f5941gv);
            }
            if (fbVar != null && fbVar.f()) {
                z2 = true;
            } else {
                z2 = false;
            }
            setSelected(z2);
        }
    }

    /* loaded from: classes.dex */
    public static class fb {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public View f5938a;
        @NonNull

        /* renamed from: c5  reason: collision with root package name */
        public c5 f5939c5;
        @Nullable

        /* renamed from: gv  reason: collision with root package name */
        public CharSequence f5941gv;
        @Nullable

        /* renamed from: n3  reason: collision with root package name */
        public Drawable f5943n3;
        @Nullable

        /* renamed from: s  reason: collision with root package name */
        public TabLayout f5944s;
        @Nullable
        public Object y;
        @Nullable

        /* renamed from: zn  reason: collision with root package name */
        public CharSequence f5946zn;

        /* renamed from: v  reason: collision with root package name */
        public int f5945v = -1;

        /* renamed from: fb  reason: collision with root package name */
        public int f5940fb = 1;

        /* renamed from: i9  reason: collision with root package name */
        public int f5942i9 = -1;

        @Nullable
        public Drawable a() {
            return this.f5943n3;
        }

        @Nullable
        public Object c5() {
            return this.y;
        }

        @NonNull
        public fb co(@Nullable Object obj) {
            this.y = obj;
            return this;
        }

        public boolean f() {
            TabLayout tabLayout = this.f5944s;
            if (tabLayout != null) {
                if (tabLayout.getSelectedTabPosition() == this.f5945v) {
                    return true;
                }
                return false;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public int fb() {
            return this.f5945v;
        }

        @Nullable
        public CharSequence i9() {
            return this.f5946zn;
        }

        public void mt(int i) {
            this.f5945v = i;
        }

        @NonNull
        public fb p(@Nullable Drawable drawable) {
            this.f5943n3 = drawable;
            TabLayout tabLayout = this.f5944s;
            if (tabLayout.f5901o == 1 || tabLayout.f5913ut == 2) {
                tabLayout.hw(true);
            }
            r();
            if (com.google.android.material.badge.y.y && this.f5939c5.t() && this.f5939c5.f5928f.isVisible()) {
                this.f5939c5.invalidate();
            }
            return this;
        }

        public void r() {
            c5 c5Var = this.f5939c5;
            if (c5Var != null) {
                c5Var.z();
            }
        }

        public int s() {
            return this.f5940fb;
        }

        public void t() {
            this.f5944s = null;
            this.f5939c5 = null;
            this.y = null;
            this.f5943n3 = null;
            this.f5942i9 = -1;
            this.f5946zn = null;
            this.f5941gv = null;
            this.f5945v = -1;
            this.f5938a = null;
        }

        public void tl() {
            TabLayout tabLayout = this.f5944s;
            if (tabLayout != null) {
                tabLayout.z6(this);
                return;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @Nullable
        public View v() {
            return this.f5938a;
        }

        @NonNull
        public fb w(@Nullable View view) {
            this.f5938a = view;
            r();
            return this;
        }

        @NonNull
        public fb wz(@Nullable CharSequence charSequence) {
            this.f5941gv = charSequence;
            r();
            return this;
        }

        @NonNull
        public fb xc(int i) {
            return w(LayoutInflater.from(this.f5939c5.getContext()).inflate(i, (ViewGroup) this.f5939c5, false));
        }

        @NonNull
        public fb z(@Nullable CharSequence charSequence) {
            if (TextUtils.isEmpty(this.f5941gv) && !TextUtils.isEmpty(charSequence)) {
                this.f5939c5.setContentDescription(charSequence);
            }
            this.f5946zn = charSequence;
            r();
            return this;
        }
    }

    /* loaded from: classes.dex */
    public interface gv extends zn<fb> {
    }

    /* loaded from: classes.dex */
    public static class i9 implements gv {
        public final ViewPager y;

        public i9(ViewPager viewPager) {
            this.y = viewPager;
        }

        @Override // com.google.android.material.tabs.TabLayout.zn
        public void n3(fb fbVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.zn
        public void y(@NonNull fb fbVar) {
            this.y.setCurrentItem(fbVar.fb());
        }

        @Override // com.google.android.material.tabs.TabLayout.zn
        public void zn(fb fbVar) {
        }
    }

    /* loaded from: classes.dex */
    public class n3 implements ViewPager.a {
        public boolean y;

        public n3() {
        }

        public void n3(boolean z2) {
            this.y = z2;
        }

        @Override // androidx.viewpager.widget.ViewPager.a
        public void y(@NonNull ViewPager viewPager, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.f5882ct == viewPager) {
                tabLayout.ud(pagerAdapter2, this.y);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class s implements ViewPager.fb {

        /* renamed from: n3  reason: collision with root package name */
        public int f5948n3;
        @NonNull
        public final WeakReference<TabLayout> y;

        /* renamed from: zn  reason: collision with root package name */
        public int f5949zn;

        public s(TabLayout tabLayout) {
            this.y = new WeakReference<>(tabLayout);
        }

        public void gv() {
            this.f5949zn = 0;
            this.f5948n3 = 0;
        }

        @Override // androidx.viewpager.widget.ViewPager.fb
        public void n3(int i) {
            this.f5948n3 = this.f5949zn;
            this.f5949zn = i;
        }

        @Override // androidx.viewpager.widget.ViewPager.fb
        public void y(int i, float f4, int i5) {
            boolean z2;
            TabLayout tabLayout = this.y.get();
            if (tabLayout != null) {
                int i6 = this.f5949zn;
                boolean z3 = false;
                if (i6 == 2 && this.f5948n3 != 1) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                tabLayout.x(i, f4, z2, (i6 == 2 && this.f5948n3 == 0) ? true : true);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.fb
        public void zn(int i) {
            boolean z2;
            TabLayout tabLayout = this.y.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i && i < tabLayout.getTabCount()) {
                int i5 = this.f5949zn;
                if (i5 != 0 && (i5 != 2 || this.f5948n3 != 0)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                tabLayout.ej(tabLayout.n(i), z2);
            }
        }
    }

    /* loaded from: classes.dex */
    public class v extends DataSetObserver {
        public v() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            TabLayout.this.fh();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TabLayout.this.fh();
        }
    }

    /* loaded from: classes.dex */
    public class y implements ValueAnimator.AnimatorUpdateListener {
        public y() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    @Deprecated
    /* loaded from: classes.dex */
    public interface zn<T extends fb> {
        void n3(T t2);

        void y(T t2);

        void zn(T t2);
    }

    public TabLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.fxp);
    }

    private int getDefaultHeight() {
        int size = this.y.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            fb fbVar = this.y.get(i);
            if (fbVar != null && fbVar.a() != null && !TextUtils.isEmpty(fbVar.i9())) {
                if (!this.f5905q9) {
                    return 72;
                }
            } else {
                i++;
            }
        }
        return 48;
    }

    private int getTabMinWidth() {
        int i = this.f5916x;
        if (i != -1) {
            return i;
        }
        int i5 = this.f5913ut;
        if (i5 != 0 && i5 != 2) {
            return 0;
        }
        return this.f5895j5;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f5892fb.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    @NonNull
    public static ColorStateList p(int i, int i5) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i5, i});
    }

    private void setSelectedTabView(int i) {
        boolean z2;
        int childCount = this.f5892fb.getChildCount();
        if (i < childCount) {
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = this.f5892fb.getChildAt(i5);
                boolean z3 = true;
                if (i5 == i) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                childAt.setSelected(z2);
                if (i5 != i) {
                    z3 = false;
                }
                childAt.setActivated(z3);
            }
        }
    }

    public void a(@NonNull fb fbVar, int i, boolean z2) {
        if (fbVar.f5944s == this) {
            w(fbVar, i);
            c5(fbVar);
            if (z2) {
                fbVar.tl();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public void a8(int i, float f4, boolean z2) {
        x(i, f4, z2, true);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        i9(view);
    }

    public void b(@Nullable ViewPager viewPager, boolean z2) {
        k5(viewPager, z2, false);
    }

    public boolean c() {
        return this.f5897k;
    }

    public final void c5(@NonNull fb fbVar) {
        c5 c5Var = fbVar.f5939c5;
        c5Var.setSelected(false);
        c5Var.setActivated(false);
        this.f5892fb.addView(c5Var, fbVar.fb(), mt());
    }

    public fb co() {
        fb n32 = f5878s8.n3();
        if (n32 == null) {
            return new fb();
        }
        return n32;
    }

    public final void d(int i) {
        c5 c5Var = (c5) this.f5892fb.getChildAt(i);
        this.f5892fb.removeViewAt(i);
        if (c5Var != null) {
            c5Var.xc();
            this.f5908ra.y(c5Var);
        }
        requestLayout();
    }

    @NonNull
    public fb d0() {
        fb co2 = co();
        co2.f5944s = this;
        co2.f5939c5 = z(co2);
        if (co2.f5942i9 != -1) {
            co2.f5939c5.setId(co2.f5942i9);
        }
        return co2;
    }

    public void ej(@Nullable fb fbVar, boolean z2) {
        int i;
        fb fbVar2 = this.f5914v;
        if (fbVar2 == fbVar) {
            if (fbVar2 != null) {
                r(fbVar);
                f(fbVar.fb());
                return;
            }
            return;
        }
        if (fbVar != null) {
            i = fbVar.fb();
        } else {
            i = -1;
        }
        if (z2) {
            if ((fbVar2 == null || fbVar2.fb() == -1) && i != -1) {
                a8(i, 0.0f, true);
            } else {
                f(i);
            }
            if (i != -1) {
                setSelectedTabView(i);
            }
        }
        this.f5914v = fbVar;
        if (fbVar2 != null) {
            i4(fbVar2);
        }
        if (fbVar != null) {
            x4(fbVar);
        }
    }

    public final void f(int i) {
        if (i == -1) {
            return;
        }
        if (getWindowToken() != null && i4.q9(this) && !this.f5892fb.zn()) {
            int scrollX = getScrollX();
            int wz2 = wz(i, 0.0f);
            if (scrollX != wz2) {
                f3();
                this.f5885dm.setIntValues(scrollX, wz2);
                this.f5885dm.start();
            }
            this.f5892fb.n3(i, this.f5894j);
            return;
        }
        a8(i, 0.0f, true);
    }

    public final void f3() {
        if (this.f5885dm == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f5885dm = valueAnimator;
            valueAnimator.setInterpolator(y6.y.f15325n3);
            this.f5885dm.setDuration(this.f5894j);
            this.f5885dm.addUpdateListener(new y());
        }
    }

    public void fb(@NonNull fb fbVar, boolean z2) {
        a(fbVar, this.y.size(), z2);
    }

    public void fh() {
        int currentItem;
        mg();
        PagerAdapter pagerAdapter = this.f5902o4;
        if (pagerAdapter != null) {
            int count = pagerAdapter.getCount();
            for (int i = 0; i < count; i++) {
                fb(d0().z(this.f5902o4.getPageTitle(i)), false);
            }
            ViewPager viewPager = this.f5882ct;
            if (viewPager != null && count > 0 && (currentItem = viewPager.getCurrentItem()) != getSelectedTabPosition() && currentItem < getTabCount()) {
                z6(n(currentItem));
            }
        }
    }

    public int getSelectedTabPosition() {
        fb fbVar = this.f5914v;
        if (fbVar != null) {
            return fbVar.fb();
        }
        return -1;
    }

    public int getTabCount() {
        return this.y.size();
    }

    public int getTabGravity() {
        return this.f5901o;
    }

    @Nullable
    public ColorStateList getTabIconTint() {
        return this.f5919z;
    }

    public int getTabIndicatorAnimationMode() {
        return this.f5891f7;
    }

    public int getTabIndicatorGravity() {
        return this.f5903oz;
    }

    public int getTabMaxWidth() {
        return this.f5887ej;
    }

    public int getTabMode() {
        return this.f5913ut;
    }

    @Nullable
    public ColorStateList getTabRippleColor() {
        return this.f5907r;
    }

    @NonNull
    public Drawable getTabSelectedIndicator() {
        return this.f5890f3;
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        return this.f5881co;
    }

    public void gv(@NonNull gv gvVar) {
        zn(gvVar);
    }

    public void hw(boolean z2) {
        for (int i = 0; i < this.f5892fb.getChildCount(); i++) {
            View childAt = this.f5892fb.getChildAt(i);
            childAt.setMinimumWidth(getTabMinWidth());
            vl((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z2) {
                childAt.requestLayout();
            }
        }
    }

    public final void i4(@NonNull fb fbVar) {
        for (int size = this.f5918y5.size() - 1; size >= 0; size--) {
            this.f5918y5.get(size).n3(fbVar);
        }
    }

    public final void i9(View view) {
        if (view instanceof bm.n3) {
            s((bm.n3) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    public final void k5(@Nullable ViewPager viewPager, boolean z2, boolean z3) {
        ViewPager viewPager2 = this.f5882ct;
        if (viewPager2 != null) {
            s sVar = this.f5886eb;
            if (sVar != null) {
                viewPager2.ej(sVar);
            }
            n3 n3Var = this.f5898lc;
            if (n3Var != null) {
                this.f5882ct.z6(n3Var);
            }
        }
        zn znVar = this.f5917xg;
        if (znVar != null) {
            ta(znVar);
            this.f5917xg = null;
        }
        if (viewPager != null) {
            this.f5882ct = viewPager;
            if (this.f5886eb == null) {
                this.f5886eb = new s(this);
            }
            this.f5886eb.gv();
            viewPager.zn(this.f5886eb);
            i9 i9Var = new i9(viewPager);
            this.f5917xg = i9Var;
            zn(i9Var);
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                ud(adapter, z2);
            }
            if (this.f5898lc == null) {
                this.f5898lc = new n3();
            }
            this.f5898lc.n3(z2);
            viewPager.n3(this.f5898lc);
            a8(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.f5882ct = null;
            ud(null, false);
        }
        this.f5900nf = z3;
    }

    public void mg() {
        for (int childCount = this.f5892fb.getChildCount() - 1; childCount >= 0; childCount--) {
            d(childCount);
        }
        Iterator<fb> it = this.y.iterator();
        while (it.hasNext()) {
            fb next = it.next();
            it.remove();
            next.t();
            rz(next);
        }
        this.f5914v = null;
    }

    @NonNull
    public final LinearLayout.LayoutParams mt() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        vl(layoutParams);
        return layoutParams;
    }

    @Nullable
    public fb n(int i) {
        if (i >= 0 && i < getTabCount()) {
            return this.y.get(i);
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        hx.s.v(this);
        if (this.f5882ct == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                k5((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f5900nf) {
            setupWithViewPager(null);
            this.f5900nf = false;
        }
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        for (int i = 0; i < this.f5892fb.getChildCount(); i++) {
            View childAt = this.f5892fb.getChildAt(i);
            if (childAt instanceof c5) {
                ((c5) childAt).i9(canvas);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        j5.zn.w2(accessibilityNodeInfo).ap(zn.a.y(1, getTabCount(), false, 1));
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i5) {
        int round = Math.round(f.n3(getContext(), getDefaultHeight()));
        int mode = View.MeasureSpec.getMode(i5);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                i5 = View.MeasureSpec.makeMeasureSpec(round + getPaddingTop() + getPaddingBottom(), 1073741824);
            }
        } else if (getChildCount() == 1 && View.MeasureSpec.getSize(i5) >= round) {
            getChildAt(0).setMinimumHeight(round);
        }
        int size = View.MeasureSpec.getSize(i);
        if (View.MeasureSpec.getMode(i) != 0) {
            int i6 = this.f5879b;
            if (i6 <= 0) {
                i6 = (int) (size - f.n3(getContext(), 56));
            }
            this.f5887ej = i6;
        }
        super.onMeasure(i, i5);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            int i8 = this.f5913ut;
            if (i8 != 0) {
                if (i8 != 1) {
                    if (i8 != 2) {
                        return;
                    }
                } else {
                    if (childAt.getMeasuredWidth() == getMeasuredWidth()) {
                        return;
                    }
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), ViewGroup.getChildMeasureSpec(i5, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
                }
            }
            if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                return;
            }
            childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), ViewGroup.getChildMeasureSpec(i5, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
        }
    }

    public final void r(@NonNull fb fbVar) {
        for (int size = this.f5918y5.size() - 1; size >= 0; size--) {
            this.f5918y5.get(size).zn(fbVar);
        }
    }

    public boolean rz(fb fbVar) {
        return f5878s8.y(fbVar);
    }

    public final void s(@NonNull bm.n3 n3Var) {
        fb d02 = d0();
        CharSequence charSequence = n3Var.y;
        if (charSequence != null) {
            d02.z(charSequence);
        }
        Drawable drawable = n3Var.f3866v;
        if (drawable != null) {
            d02.p(drawable);
        }
        int i = n3Var.f3865fb;
        if (i != 0) {
            d02.xc(i);
        }
        if (!TextUtils.isEmpty(n3Var.getContentDescription())) {
            d02.wz(n3Var.getContentDescription());
        }
        v(d02);
    }

    @Override // android.view.View
    public void setElevation(float f4) {
        super.setElevation(f4);
        hx.s.gv(this, f4);
    }

    public void setInlineLabel(boolean z2) {
        if (this.f5905q9 != z2) {
            this.f5905q9 = z2;
            for (int i = 0; i < this.f5892fb.getChildCount(); i++) {
                View childAt = this.f5892fb.getChildAt(i);
                if (childAt instanceof c5) {
                    ((c5) childAt).x4();
                }
            }
            tl();
        }
    }

    public void setInlineLabelResource(int i) {
        setInlineLabel(getResources().getBoolean(i));
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable gv gvVar) {
        setOnTabSelectedListener((zn) gvVar);
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        f3();
        this.f5885dm.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(@Nullable Drawable drawable) {
        if (this.f5890f3 != drawable) {
            if (drawable == null) {
                drawable = new GradientDrawable();
            }
            this.f5890f3 = drawable;
        }
    }

    public void setSelectedTabIndicatorColor(int i) {
        this.f5899n = i;
    }

    public void setSelectedTabIndicatorGravity(int i) {
        if (this.f5903oz != i) {
            this.f5903oz = i;
            i4.lc(this.f5892fb);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i) {
        this.f5892fb.a(i);
    }

    public void setTabGravity(int i) {
        if (this.f5901o != i) {
            this.f5901o = i;
            tl();
        }
    }

    public void setTabIconTint(@Nullable ColorStateList colorStateList) {
        if (this.f5919z != colorStateList) {
            this.f5919z = colorStateList;
            yt();
        }
    }

    public void setTabIconTintResource(int i) {
        setTabIconTint(c5.y.zn(getContext(), i));
    }

    public void setTabIndicatorAnimationMode(int i) {
        this.f5891f7 = i;
        if (i != 0) {
            if (i == 1) {
                this.f5896jz = new bm.y();
                return;
            }
            throw new IllegalArgumentException(i + " is not a valid TabIndicatorAnimationMode");
        }
        this.f5896jz = new com.google.android.material.tabs.y();
    }

    public void setTabIndicatorFullWidth(boolean z2) {
        this.f5897k = z2;
        i4.lc(this.f5892fb);
    }

    public void setTabMode(int i) {
        if (i != this.f5913ut) {
            this.f5913ut = i;
            tl();
        }
    }

    public void setTabRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.f5907r != colorStateList) {
            this.f5907r = colorStateList;
            for (int i = 0; i < this.f5892fb.getChildCount(); i++) {
                View childAt = this.f5892fb.getChildAt(i);
                if (childAt instanceof c5) {
                    ((c5) childAt).r(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(int i) {
        setTabRippleColor(c5.y.zn(getContext(), i));
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        if (this.f5881co != colorStateList) {
            this.f5881co = colorStateList;
            yt();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter pagerAdapter) {
        ud(pagerAdapter, false);
    }

    public void setUnboundedRipple(boolean z2) {
        if (this.f5888en != z2) {
            this.f5888en = z2;
            for (int i = 0; i < this.f5892fb.getChildCount(); i++) {
                View childAt = this.f5892fb.getChildAt(i);
                if (childAt instanceof c5) {
                    ((c5) childAt).r(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(int i) {
        setUnboundedRipple(getResources().getBoolean(i));
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager) {
        b(viewPager, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        if (getTabScrollRange() > 0) {
            return true;
        }
        return false;
    }

    public final void t(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return;
                }
            } else {
                this.f5892fb.setGravity(1);
                return;
            }
        } else {
            Log.w("TabLayout", "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
        }
        this.f5892fb.setGravity(8388611);
    }

    @Deprecated
    public void ta(@Nullable zn znVar) {
        this.f5918y5.remove(znVar);
    }

    public final void tl() {
        int max;
        int i = this.f5913ut;
        if (i != 0 && i != 2) {
            max = 0;
        } else {
            max = Math.max(0, this.f5906qn - this.f5910s);
        }
        i4.cy(this.f5892fb, max, 0, 0, 0);
        int i5 = this.f5913ut;
        if (i5 != 0) {
            if (i5 == 1 || i5 == 2) {
                if (this.f5901o == 2) {
                    Log.w("TabLayout", "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
                }
                this.f5892fb.setGravity(1);
            }
        } else {
            t(this.f5901o);
        }
        hw(true);
    }

    public void ud(@Nullable PagerAdapter pagerAdapter, boolean z2) {
        DataSetObserver dataSetObserver;
        PagerAdapter pagerAdapter2 = this.f5902o4;
        if (pagerAdapter2 != null && (dataSetObserver = this.f5909rs) != null) {
            pagerAdapter2.unregisterDataSetObserver(dataSetObserver);
        }
        this.f5902o4 = pagerAdapter;
        if (z2 && pagerAdapter != null) {
            if (this.f5909rs == null) {
                this.f5909rs = new v();
            }
            pagerAdapter.registerDataSetObserver(this.f5909rs);
        }
        fh();
    }

    public void v(@NonNull fb fbVar) {
        fb(fbVar, this.y.isEmpty());
    }

    public final void vl(@NonNull LinearLayout.LayoutParams layoutParams) {
        if (this.f5913ut == 1 && this.f5901o == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    public final void w(@NonNull fb fbVar, int i) {
        fbVar.mt(i);
        this.y.add(i, fbVar);
        int size = this.y.size();
        while (true) {
            i++;
            if (i < size) {
                this.y.get(i).mt(i);
            } else {
                return;
            }
        }
    }

    public final int wz(int i, float f4) {
        View view;
        int i5;
        int i6 = this.f5913ut;
        int i8 = 0;
        if (i6 != 0 && i6 != 2) {
            return 0;
        }
        View childAt = this.f5892fb.getChildAt(i);
        int i10 = i + 1;
        if (i10 < this.f5892fb.getChildCount()) {
            view = this.f5892fb.getChildAt(i10);
        } else {
            view = null;
        }
        if (childAt != null) {
            i5 = childAt.getWidth();
        } else {
            i5 = 0;
        }
        if (view != null) {
            i8 = view.getWidth();
        }
        int left = (childAt.getLeft() + (i5 / 2)) - (getWidth() / 2);
        int i11 = (int) ((i5 + i8) * 0.5f * f4);
        if (i4.ta(this) == 0) {
            return left + i11;
        }
        return left - i11;
    }

    public void x(int i, float f4, boolean z2, boolean z3) {
        int round = Math.round(i + f4);
        if (round >= 0 && round < this.f5892fb.getChildCount()) {
            if (z3) {
                this.f5892fb.v(i, f4);
            }
            ValueAnimator valueAnimator = this.f5885dm;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f5885dm.cancel();
            }
            scrollTo(wz(i, f4), 0);
            if (z2) {
                setSelectedTabView(round);
            }
        }
    }

    public final void x4(@NonNull fb fbVar) {
        for (int size = this.f5918y5.size() - 1; size >= 0; size--) {
            this.f5918y5.get(size).y(fbVar);
        }
    }

    public void xc() {
        this.f5918y5.clear();
    }

    public final void yt() {
        int size = this.y.size();
        for (int i = 0; i < size; i++) {
            this.y.get(i).r();
        }
    }

    @NonNull
    public final c5 z(@NonNull fb fbVar) {
        c5 c5Var;
        vl.v<c5> vVar = this.f5908ra;
        if (vVar != null) {
            c5Var = vVar.n3();
        } else {
            c5Var = null;
        }
        if (c5Var == null) {
            c5Var = new c5(getContext());
        }
        c5Var.setTab(fbVar);
        c5Var.setFocusable(true);
        c5Var.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(fbVar.f5941gv)) {
            c5Var.setContentDescription(fbVar.f5946zn);
        } else {
            c5Var.setContentDescription(fbVar.f5941gv);
        }
        return c5Var;
    }

    public void z6(@Nullable fb fbVar) {
        ej(fbVar, true);
    }

    @Deprecated
    public void zn(@Nullable zn znVar) {
        if (!this.f5918y5.contains(znVar)) {
            this.f5918y5.add(znVar);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public TabLayout(@androidx.annotation.NonNull android.content.Context r11, @androidx.annotation.Nullable android.util.AttributeSet r12, int r13) {
        /*
            Method dump skipped, instructions count: 444
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i) {
        i9(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable zn znVar) {
        zn znVar2 = this.f5912u;
        if (znVar2 != null) {
            ta(znVar2);
        }
        this.f5912u = znVar;
        if (znVar != null) {
            zn(znVar);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        i9(view);
    }

    public void setSelectedTabIndicator(int i) {
        if (i != 0) {
            setSelectedTabIndicator(c5.y.gv(getContext(), i));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        i9(view);
    }
}
