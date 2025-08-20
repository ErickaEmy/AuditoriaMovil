package wz;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class rz implements tl.a {

    /* renamed from: dm  reason: collision with root package name */
    public static Method f14767dm;

    /* renamed from: xg  reason: collision with root package name */
    public static Method f14768xg;

    /* renamed from: y5  reason: collision with root package name */
    public static Method f14769y5;

    /* renamed from: b  reason: collision with root package name */
    public Drawable f14770b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f14771c;

    /* renamed from: co  reason: collision with root package name */
    public boolean f14772co;

    /* renamed from: d  reason: collision with root package name */
    public int f14773d;

    /* renamed from: d0  reason: collision with root package name */
    public int f14774d0;

    /* renamed from: ej  reason: collision with root package name */
    public DataSetObserver f14775ej;

    /* renamed from: en  reason: collision with root package name */
    public Rect f14776en;

    /* renamed from: f  reason: collision with root package name */
    public int f14777f;

    /* renamed from: f3  reason: collision with root package name */
    public int f14778f3;

    /* renamed from: f7  reason: collision with root package name */
    public final Rect f14779f7;

    /* renamed from: fb  reason: collision with root package name */
    public c f14780fb;

    /* renamed from: fh  reason: collision with root package name */
    public View f14781fh;

    /* renamed from: j  reason: collision with root package name */
    public final a f14782j;

    /* renamed from: j5  reason: collision with root package name */
    public AdapterView.OnItemClickListener f14783j5;

    /* renamed from: jz  reason: collision with root package name */
    public boolean f14784jz;

    /* renamed from: k  reason: collision with root package name */
    public final Handler f14785k;

    /* renamed from: n  reason: collision with root package name */
    public boolean f14786n;

    /* renamed from: o  reason: collision with root package name */
    public final fb f14787o;

    /* renamed from: oz  reason: collision with root package name */
    public final v f14788oz;

    /* renamed from: p  reason: collision with root package name */
    public int f14789p;

    /* renamed from: q9  reason: collision with root package name */
    public Runnable f14790q9;

    /* renamed from: qn  reason: collision with root package name */
    public AdapterView.OnItemSelectedListener f14791qn;

    /* renamed from: r  reason: collision with root package name */
    public boolean f14792r;

    /* renamed from: s  reason: collision with root package name */
    public int f14793s;

    /* renamed from: t  reason: collision with root package name */
    public int f14794t;

    /* renamed from: u  reason: collision with root package name */
    public PopupWindow f14795u;

    /* renamed from: ut  reason: collision with root package name */
    public final zn f14796ut;

    /* renamed from: v  reason: collision with root package name */
    public ListAdapter f14797v;

    /* renamed from: w  reason: collision with root package name */
    public int f14798w;

    /* renamed from: x  reason: collision with root package name */
    public View f14799x;
    public Context y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f14800z;

    /* loaded from: classes.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x2 = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = rz.this.f14795u) != null && popupWindow.isShowing() && x2 >= 0 && x2 < rz.this.f14795u.getWidth() && y >= 0 && y < rz.this.f14795u.getHeight()) {
                rz rzVar = rz.this;
                rzVar.f14785k.postDelayed(rzVar.f14787o, 250L);
                return false;
            } else if (action == 1) {
                rz rzVar2 = rz.this;
                rzVar2.f14785k.removeCallbacks(rzVar2.f14787o);
                return false;
            } else {
                return false;
            }
        }
    }

    /* loaded from: classes.dex */
    public class fb implements Runnable {
        public fb() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = rz.this.f14780fb;
            if (cVar != null && hw.i4.ut(cVar) && rz.this.f14780fb.getCount() > rz.this.f14780fb.getChildCount()) {
                int childCount = rz.this.f14780fb.getChildCount();
                rz rzVar = rz.this;
                if (childCount <= rzVar.f14774d0) {
                    rzVar.f14795u.setInputMethodMode(2);
                    rz.this.show();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class gv extends DataSetObserver {
        public gv() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (rz.this.y()) {
                rz.this.show();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            rz.this.dismiss();
        }
    }

    /* loaded from: classes.dex */
    public class y implements Runnable {
        public y() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View co2 = rz.this.co();
            if (co2 != null && co2.getWindowToken() != null) {
                rz.this.show();
            }
        }
    }

    /* loaded from: classes.dex */
    public class zn implements Runnable {
        public zn() {
        }

        @Override // java.lang.Runnable
        public void run() {
            rz.this.p();
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                f14769y5 = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
            }
            try {
                f14767dm = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                f14768xg = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
            }
        }
    }

    public rz(@NonNull Context context) {
        this(context, null, R$attr.f642mg);
    }

    public void a8(@Nullable PopupWindow.OnDismissListener onDismissListener) {
        this.f14795u.setOnDismissListener(onDismissListener);
    }

    public void b(boolean z2) {
        this.f14792r = true;
        this.f14800z = z2;
    }

    public boolean c() {
        if (this.f14795u.getInputMethodMode() == 2) {
            return true;
        }
        return false;
    }

    public void c5(int i) {
        this.f14798w = i;
        this.f14772co = true;
    }

    @Nullable
    public View co() {
        return this.f14799x;
    }

    public void d(int i) {
        this.f14778f3 = i;
    }

    public boolean d0() {
        return this.f14784jz;
    }

    @Override // tl.a
    public void dismiss() {
        this.f14795u.dismiss();
        fh();
        this.f14795u.setContentView(null);
        this.f14780fb = null;
        this.f14785k.removeCallbacks(this.f14787o);
    }

    public void ej(int i) {
        this.f14795u.setInputMethodMode(i);
    }

    @Nullable
    public View f3() {
        if (!y()) {
            return null;
        }
        return this.f14780fb.getSelectedView();
    }

    @Nullable
    public Drawable fb() {
        return this.f14795u.getBackground();
    }

    public final void fh() {
        View view = this.f14781fh;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f14781fh);
            }
        }
    }

    public void hw(int i) {
        this.f14777f = i;
    }

    public int i4() {
        if (!y()) {
            return -1;
        }
        return this.f14780fb.getSelectedItemPosition();
    }

    public final void k5(boolean z2) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = f14769y5;
            if (method != null) {
                try {
                    method.invoke(this.f14795u, Boolean.valueOf(z2));
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            return;
        }
        this.f14795u.setIsClippedToScreen(z2);
    }

    public void mg(int i) {
        this.f14795u.setAnimationStyle(i);
    }

    @NonNull
    public c mt(Context context, boolean z2) {
        return new c(context, z2);
    }

    public int n() {
        return this.f14777f;
    }

    public void n3(@Nullable Drawable drawable) {
        this.f14795u.setBackgroundDrawable(drawable);
    }

    public void p() {
        c cVar = this.f14780fb;
        if (cVar != null) {
            cVar.setListSelectionHidden(true);
            cVar.requestLayout();
        }
    }

    @Nullable
    public Object r() {
        if (!y()) {
            return null;
        }
        return this.f14780fb.getSelectedItem();
    }

    public void rz(@Nullable View view) {
        this.f14799x = view;
    }

    @Override // tl.a
    public void show() {
        boolean z2;
        int i;
        int i5;
        int i6;
        int i8;
        int w4 = w();
        boolean c2 = c();
        j.t.n3(this.f14795u, this.f14789p);
        boolean z3 = true;
        if (this.f14795u.isShowing()) {
            if (!hw.i4.ut(co())) {
                return;
            }
            int i10 = this.f14777f;
            if (i10 == -1) {
                i10 = -1;
            } else if (i10 == -2) {
                i10 = co().getWidth();
            }
            int i11 = this.f14793s;
            if (i11 == -1) {
                if (!c2) {
                    w4 = -1;
                }
                if (c2) {
                    PopupWindow popupWindow = this.f14795u;
                    if (this.f14777f == -1) {
                        i8 = -1;
                    } else {
                        i8 = 0;
                    }
                    popupWindow.setWidth(i8);
                    this.f14795u.setHeight(0);
                } else {
                    PopupWindow popupWindow2 = this.f14795u;
                    if (this.f14777f == -1) {
                        i6 = -1;
                    } else {
                        i6 = 0;
                    }
                    popupWindow2.setWidth(i6);
                    this.f14795u.setHeight(-1);
                }
            } else if (i11 != -2) {
                w4 = i11;
            }
            this.f14795u.setOutsideTouchable((this.f14771c || this.f14786n) ? false : false);
            PopupWindow popupWindow3 = this.f14795u;
            View co2 = co();
            int i12 = this.f14794t;
            int i13 = this.f14798w;
            if (i10 < 0) {
                i = -1;
            } else {
                i = i10;
            }
            if (w4 < 0) {
                i5 = -1;
            } else {
                i5 = w4;
            }
            popupWindow3.update(co2, i12, i13, i, i5);
            return;
        }
        int i14 = this.f14777f;
        if (i14 == -1) {
            i14 = -1;
        } else if (i14 == -2) {
            i14 = co().getWidth();
        }
        int i15 = this.f14793s;
        if (i15 == -1) {
            w4 = -1;
        } else if (i15 != -2) {
            w4 = i15;
        }
        this.f14795u.setWidth(i14);
        this.f14795u.setHeight(w4);
        k5(true);
        PopupWindow popupWindow4 = this.f14795u;
        if (!this.f14771c && !this.f14786n) {
            z2 = true;
        } else {
            z2 = false;
        }
        popupWindow4.setOutsideTouchable(z2);
        this.f14795u.setTouchInterceptor(this.f14782j);
        if (this.f14792r) {
            j.t.y(this.f14795u, this.f14800z);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = f14767dm;
            if (method != null) {
                try {
                    method.invoke(this.f14795u, this.f14776en);
                } catch (Exception e2) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
                }
            }
        } else {
            this.f14795u.setEpicenterBounds(this.f14776en);
        }
        j.t.zn(this.f14795u, co(), this.f14794t, this.f14798w, this.f14778f3);
        this.f14780fb.setSelection(-1);
        if (!this.f14784jz || this.f14780fb.isInTouchMode()) {
            p();
        }
        if (!this.f14784jz) {
            this.f14785k.post(this.f14796ut);
        }
    }

    public int t() {
        if (!this.f14772co) {
            return 0;
        }
        return this.f14798w;
    }

    public void ta(int i) {
        Drawable background = this.f14795u.getBackground();
        if (background != null) {
            background.getPadding(this.f14779f7);
            Rect rect = this.f14779f7;
            this.f14777f = rect.left + rect.right + i;
            return;
        }
        hw(i);
    }

    public void tl(@Nullable ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f14775ej;
        if (dataSetObserver == null) {
            this.f14775ej = new gv();
        } else {
            ListAdapter listAdapter2 = this.f14797v;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f14797v = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f14775ej);
        }
        c cVar = this.f14780fb;
        if (cVar != null) {
            cVar.setAdapter(this.f14797v);
        }
    }

    public void ud(boolean z2) {
        this.f14784jz = z2;
        this.f14795u.setFocusable(z2);
    }

    public void v(int i) {
        this.f14794t = i;
    }

    public void vl(int i) {
        c cVar = this.f14780fb;
        if (y() && cVar != null) {
            cVar.setListSelectionHidden(false);
            cVar.setSelection(i);
            if (cVar.getChoiceMode() != 0) {
                cVar.setItemChecked(i, true);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int w() {
        int i;
        int i5;
        int makeMeasureSpec;
        int i6;
        boolean z2 = true;
        if (this.f14780fb == null) {
            Context context = this.y;
            this.f14790q9 = new y();
            c mt2 = mt(context, !this.f14784jz);
            this.f14780fb = mt2;
            Drawable drawable = this.f14770b;
            if (drawable != null) {
                mt2.setSelector(drawable);
            }
            this.f14780fb.setAdapter(this.f14797v);
            this.f14780fb.setOnItemClickListener(this.f14783j5);
            this.f14780fb.setFocusable(true);
            this.f14780fb.setFocusableInTouchMode(true);
            this.f14780fb.setOnItemSelectedListener(new n3());
            this.f14780fb.setOnScrollListener(this.f14788oz);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f14791qn;
            if (onItemSelectedListener != null) {
                this.f14780fb.setOnItemSelectedListener(onItemSelectedListener);
            }
            c cVar = this.f14780fb;
            View view = this.f14781fh;
            if (view != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i8 = this.f14773d;
                if (i8 != 0) {
                    if (i8 != 1) {
                        Log.e("ListPopupWindow", "Invalid hint position " + this.f14773d);
                    } else {
                        linearLayout.addView(cVar, layoutParams);
                        linearLayout.addView(view);
                    }
                } else {
                    linearLayout.addView(view);
                    linearLayout.addView(cVar, layoutParams);
                }
                int i10 = this.f14777f;
                if (i10 >= 0) {
                    i6 = Integer.MIN_VALUE;
                } else {
                    i10 = 0;
                    i6 = 0;
                }
                view.measure(View.MeasureSpec.makeMeasureSpec(i10, i6), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view.getLayoutParams();
                i = view.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                cVar = linearLayout;
            } else {
                i = 0;
            }
            this.f14795u.setContentView(cVar);
        } else {
            ViewGroup viewGroup = (ViewGroup) this.f14795u.getContentView();
            View view2 = this.f14781fh;
            if (view2 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                i = view2.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                i = 0;
            }
        }
        Drawable background = this.f14795u.getBackground();
        if (background != null) {
            background.getPadding(this.f14779f7);
            Rect rect = this.f14779f7;
            int i11 = rect.top;
            i5 = rect.bottom + i11;
            if (!this.f14772co) {
                this.f14798w = -i11;
            }
        } else {
            this.f14779f7.setEmpty();
            i5 = 0;
        }
        if (this.f14795u.getInputMethodMode() != 2) {
            z2 = false;
        }
        int z3 = z(co(), this.f14798w, z2);
        if (!this.f14786n && this.f14793s != -1) {
            int i12 = this.f14777f;
            if (i12 != -2) {
                if (i12 != -1) {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
                } else {
                    int i13 = this.y.getResources().getDisplayMetrics().widthPixels;
                    Rect rect2 = this.f14779f7;
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i13 - (rect2.left + rect2.right), 1073741824);
                }
            } else {
                int i14 = this.y.getResources().getDisplayMetrics().widthPixels;
                Rect rect3 = this.f14779f7;
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i14 - (rect3.left + rect3.right), Integer.MIN_VALUE);
            }
            int gv2 = this.f14780fb.gv(makeMeasureSpec, 0, -1, z3 - i, -1);
            if (gv2 > 0) {
                i += i5 + this.f14780fb.getPaddingTop() + this.f14780fb.getPaddingBottom();
            }
            return gv2 + i;
        }
        return z3 + i5;
    }

    public void x(@Nullable AdapterView.OnItemClickListener onItemClickListener) {
        this.f14783j5 = onItemClickListener;
    }

    public long x4() {
        if (!y()) {
            return Long.MIN_VALUE;
        }
        return this.f14780fb.getSelectedItemId();
    }

    @Override // tl.a
    @Nullable
    public ListView xc() {
        return this.f14780fb;
    }

    @Override // tl.a
    public boolean y() {
        return this.f14795u.isShowing();
    }

    public void yt(int i) {
        this.f14773d = i;
    }

    public final int z(View view, int i, boolean z2) {
        if (Build.VERSION.SDK_INT <= 23) {
            Method method = f14768xg;
            if (method != null) {
                try {
                    return ((Integer) method.invoke(this.f14795u, view, Integer.valueOf(i), Boolean.valueOf(z2))).intValue();
                } catch (Exception unused) {
                }
            }
            return this.f14795u.getMaxAvailableHeight(view, i);
        }
        return this.f14795u.getMaxAvailableHeight(view, i, z2);
    }

    public void z6(@Nullable Rect rect) {
        Rect rect2;
        if (rect != null) {
            rect2 = new Rect(rect);
        } else {
            rect2 = null;
        }
        this.f14776en = rect2;
    }

    public int zn() {
        return this.f14794t;
    }

    public rz(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public rz(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i5) {
        this.f14793s = -2;
        this.f14777f = -2;
        this.f14789p = 1002;
        this.f14774d0 = Integer.MAX_VALUE;
        this.f14787o = new fb();
        this.f14782j = new a();
        this.f14788oz = new v();
        this.f14796ut = new zn();
        this.f14779f7 = new Rect();
        this.y = context;
        this.f14785k = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.c8, i, i5);
        this.f14794t = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.h, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.ia, 0);
        this.f14798w = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f14772co = true;
        }
        obtainStyledAttributes.recycle();
        tl tlVar = new tl(context, attributeSet, i, i5);
        this.f14795u = tlVar;
        tlVar.setInputMethodMode(1);
    }

    /* loaded from: classes.dex */
    public class n3 implements AdapterView.OnItemSelectedListener {
        public n3() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j2) {
            c cVar;
            if (i != -1 && (cVar = rz.this.f14780fb) != null) {
                cVar.setListSelectionHidden(false);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* loaded from: classes.dex */
    public class v implements AbsListView.OnScrollListener {
        public v() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !rz.this.c() && rz.this.f14795u.getContentView() != null) {
                rz rzVar = rz.this;
                rzVar.f14785k.removeCallbacks(rzVar.f14787o);
                rz.this.f14787o.run();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i5, int i6) {
        }
    }
}
