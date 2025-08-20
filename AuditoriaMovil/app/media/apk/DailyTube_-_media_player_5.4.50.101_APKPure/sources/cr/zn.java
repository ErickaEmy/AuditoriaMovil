package cr;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;
/* loaded from: classes.dex */
public class zn extends cr.f {

    /* renamed from: ct  reason: collision with root package name */
    public boolean f6827ct;

    /* renamed from: dm  reason: collision with root package name */
    public int[] f6828dm = new int[2];

    /* renamed from: o4  reason: collision with root package name */
    public boolean f6829o4;

    /* renamed from: rs  reason: collision with root package name */
    public static final String[] f6825rs = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* renamed from: eb  reason: collision with root package name */
    public static final Property<Drawable, PointF> f6821eb = new n3(PointF.class, "boundsOrigin");

    /* renamed from: lc  reason: collision with root package name */
    public static final Property<f, PointF> f6822lc = new C0074zn(PointF.class, "topLeft");

    /* renamed from: nf  reason: collision with root package name */
    public static final Property<f, PointF> f6823nf = new gv(PointF.class, "bottomRight");

    /* renamed from: ra  reason: collision with root package name */
    public static final Property<View, PointF> f6824ra = new v(PointF.class, "bottomRight");

    /* renamed from: e  reason: collision with root package name */
    public static final Property<View, PointF> f6820e = new a(PointF.class, "topLeft");

    /* renamed from: s8  reason: collision with root package name */
    public static final Property<View, PointF> f6826s8 = new fb(PointF.class, "position");

    /* renamed from: ap  reason: collision with root package name */
    public static cr.c5 f6819ap = new cr.c5();

    /* loaded from: classes.dex */
    public class a extends Property<View, PointF> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: n3 */
        public void set(View view, PointF pointF) {
            f3.a(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }

        @Override // android.util.Property
        /* renamed from: y */
        public PointF get(View view) {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public class c5 extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f6830a;

        /* renamed from: fb  reason: collision with root package name */
        public final /* synthetic */ int f6831fb;

        /* renamed from: gv  reason: collision with root package name */
        public final /* synthetic */ int f6832gv;

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ View f6833n3;

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ int f6835v;
        public boolean y;

        /* renamed from: zn  reason: collision with root package name */
        public final /* synthetic */ Rect f6836zn;

        public c5(View view, Rect rect, int i, int i5, int i6, int i8) {
            this.f6833n3 = view;
            this.f6836zn = rect;
            this.f6832gv = i;
            this.f6835v = i5;
            this.f6830a = i6;
            this.f6831fb = i8;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.y = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.y) {
                hw.i4.tg(this.f6833n3, this.f6836zn);
                f3.a(this.f6833n3, this.f6832gv, this.f6835v, this.f6830a, this.f6831fb);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public int f6837a;

        /* renamed from: fb  reason: collision with root package name */
        public int f6838fb;

        /* renamed from: gv  reason: collision with root package name */
        public int f6839gv;

        /* renamed from: n3  reason: collision with root package name */
        public int f6840n3;

        /* renamed from: v  reason: collision with root package name */
        public View f6841v;
        public int y;

        /* renamed from: zn  reason: collision with root package name */
        public int f6842zn;

        public f(View view) {
            this.f6841v = view;
        }

        public final void n3() {
            f3.a(this.f6841v, this.y, this.f6840n3, this.f6842zn, this.f6839gv);
            this.f6837a = 0;
            this.f6838fb = 0;
        }

        public void y(PointF pointF) {
            this.f6842zn = Math.round(pointF.x);
            this.f6839gv = Math.round(pointF.y);
            int i = this.f6838fb + 1;
            this.f6838fb = i;
            if (this.f6837a == i) {
                n3();
            }
        }

        public void zn(PointF pointF) {
            this.y = Math.round(pointF.x);
            this.f6840n3 = Math.round(pointF.y);
            int i = this.f6837a + 1;
            this.f6837a = i;
            if (i == this.f6838fb) {
                n3();
            }
        }
    }

    /* loaded from: classes.dex */
    public class fb extends Property<View, PointF> {
        public fb(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: n3 */
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            f3.a(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }

        @Override // android.util.Property
        /* renamed from: y */
        public PointF get(View view) {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public class gv extends Property<f, PointF> {
        public gv(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: n3 */
        public void set(f fVar, PointF pointF) {
            fVar.y(pointF);
        }

        @Override // android.util.Property
        /* renamed from: y */
        public PointF get(f fVar) {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public class i9 extends t {

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f6843n3;
        public boolean y;

        public i9(ViewGroup viewGroup) {
            this.f6843n3 = viewGroup;
        }

        @Override // cr.t, cr.f.fb
        public void n3(@NonNull cr.f fVar) {
            r.zn(this.f6843n3, false);
            this.y = true;
        }

        @Override // cr.t, cr.f.fb
        public void v(@NonNull cr.f fVar) {
            r.zn(this.f6843n3, false);
        }

        @Override // cr.t, cr.f.fb
        public void y(@NonNull cr.f fVar) {
            r.zn(this.f6843n3, true);
        }

        @Override // cr.f.fb
        public void zn(@NonNull cr.f fVar) {
            if (!this.y) {
                r.zn(this.f6843n3, false);
            }
            fVar.j(this);
        }
    }

    /* loaded from: classes.dex */
    public class n3 extends Property<Drawable, PointF> {
        public Rect y;

        public n3(Class cls, String str) {
            super(cls, str);
            this.y = new Rect();
        }

        @Override // android.util.Property
        /* renamed from: n3 */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.y);
            this.y.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.y);
        }

        @Override // android.util.Property
        /* renamed from: y */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.y);
            Rect rect = this.y;
            return new PointF(rect.left, rect.top);
        }
    }

    /* loaded from: classes.dex */
    public class s extends AnimatorListenerAdapter {
        private f mViewBounds;
        public final /* synthetic */ f y;

        public s(f fVar) {
            this.y = fVar;
            this.mViewBounds = fVar;
        }
    }

    /* loaded from: classes.dex */
    public class v extends Property<View, PointF> {
        public v(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: n3 */
        public void set(View view, PointF pointF) {
            f3.a(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }

        @Override // android.util.Property
        /* renamed from: y */
        public PointF get(View view) {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public class y extends AnimatorListenerAdapter {

        /* renamed from: gv  reason: collision with root package name */
        public final /* synthetic */ float f6846gv;

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ BitmapDrawable f6847n3;
        public final /* synthetic */ ViewGroup y;

        /* renamed from: zn  reason: collision with root package name */
        public final /* synthetic */ View f6849zn;

        public y(ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f4) {
            this.y = viewGroup;
            this.f6847n3 = bitmapDrawable;
            this.f6849zn = view;
            this.f6846gv = f4;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f3.n3(this.y).n3(this.f6847n3);
            f3.fb(this.f6849zn, this.f6846gv);
        }
    }

    /* renamed from: cr.zn$zn  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0074zn extends Property<f, PointF> {
        public C0074zn(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: n3 */
        public void set(f fVar, PointF pointF) {
            fVar.zn(pointF);
        }

        @Override // android.util.Property
        /* renamed from: y */
        public PointF get(f fVar) {
            return null;
        }
    }

    @Override // cr.f
    @NonNull
    public String[] ej() {
        return f6825rs;
    }

    @Override // cr.f
    public void f(@NonNull p pVar) {
        o4(pVar);
    }

    public final void o4(p pVar) {
        View view = pVar.f6778n3;
        if (hw.i4.q9(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            pVar.y.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            pVar.y.put("android:changeBounds:parent", pVar.f6778n3.getParent());
            if (this.f6829o4) {
                pVar.f6778n3.getLocationInWindow(this.f6828dm);
                pVar.y.put("android:changeBounds:windowX", Integer.valueOf(this.f6828dm[0]));
                pVar.y.put("android:changeBounds:windowY", Integer.valueOf(this.f6828dm[1]));
            }
            if (this.f6827ct) {
                pVar.y.put("android:changeBounds:clip", hw.i4.i4(view));
            }
        }
    }

    public final boolean rs(View view, View view2) {
        if (!this.f6829o4) {
            return true;
        }
        p f32 = f3(view, true);
        if (f32 == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == f32.f6778n3) {
            return true;
        }
        return false;
    }

    @Override // cr.f
    public void s(@NonNull p pVar) {
        o4(pVar);
    }

    @Override // cr.f
    @Nullable
    public Animator xc(@NonNull ViewGroup viewGroup, @Nullable p pVar, @Nullable p pVar2) {
        int i;
        View view;
        ObjectAnimator y2;
        int i5;
        Rect rect;
        ObjectAnimator objectAnimator;
        Animator zn2;
        if (pVar == null || pVar2 == null) {
            return null;
        }
        Map<String, Object> map = pVar.y;
        Map<String, Object> map2 = pVar2.y;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = pVar2.f6778n3;
        if (rs(viewGroup2, viewGroup3)) {
            Rect rect2 = (Rect) pVar.y.get("android:changeBounds:bounds");
            Rect rect3 = (Rect) pVar2.y.get("android:changeBounds:bounds");
            int i6 = rect2.left;
            int i8 = rect3.left;
            int i10 = rect2.top;
            int i11 = rect3.top;
            int i12 = rect2.right;
            int i13 = rect3.right;
            int i14 = rect2.bottom;
            int i15 = rect3.bottom;
            int i16 = i12 - i6;
            int i17 = i14 - i10;
            int i18 = i13 - i8;
            int i19 = i15 - i11;
            Rect rect4 = (Rect) pVar.y.get("android:changeBounds:clip");
            Rect rect5 = (Rect) pVar2.y.get("android:changeBounds:clip");
            if ((i16 != 0 && i17 != 0) || (i18 != 0 && i19 != 0)) {
                if (i6 == i8 && i10 == i11) {
                    i = 0;
                } else {
                    i = 1;
                }
                if (i12 != i13 || i14 != i15) {
                    i++;
                }
            } else {
                i = 0;
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                i++;
            }
            if (i > 0) {
                if (!this.f6827ct) {
                    view = view2;
                    f3.a(view, i6, i10, i12, i14);
                    if (i == 2) {
                        if (i16 == i18 && i17 == i19) {
                            zn2 = cr.a.y(view, f6826s8, c().y(i6, i10, i8, i11));
                        } else {
                            f fVar = new f(view);
                            ObjectAnimator y7 = cr.a.y(fVar, f6822lc, c().y(i6, i10, i8, i11));
                            ObjectAnimator y8 = cr.a.y(fVar, f6823nf, c().y(i12, i14, i13, i15));
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.playTogether(y7, y8);
                            animatorSet.addListener(new s(fVar));
                            zn2 = animatorSet;
                        }
                    } else if (i6 == i8 && i10 == i11) {
                        zn2 = cr.a.y(view, f6824ra, c().y(i12, i14, i13, i15));
                    } else {
                        zn2 = cr.a.y(view, f6820e, c().y(i6, i10, i8, i11));
                    }
                } else {
                    view = view2;
                    f3.a(view, i6, i10, Math.max(i16, i18) + i6, Math.max(i17, i19) + i10);
                    if (i6 == i8 && i10 == i11) {
                        y2 = null;
                    } else {
                        y2 = cr.a.y(view, f6826s8, c().y(i6, i10, i8, i11));
                    }
                    if (rect4 == null) {
                        i5 = 0;
                        rect4 = new Rect(0, 0, i16, i17);
                    } else {
                        i5 = 0;
                    }
                    if (rect5 == null) {
                        rect = new Rect(i5, i5, i18, i19);
                    } else {
                        rect = rect5;
                    }
                    if (!rect4.equals(rect)) {
                        hw.i4.tg(view, rect4);
                        cr.c5 c5Var = f6819ap;
                        Object[] objArr = new Object[2];
                        objArr[i5] = rect4;
                        objArr[1] = rect;
                        ObjectAnimator ofObject = ObjectAnimator.ofObject(view, "clipBounds", c5Var, objArr);
                        ofObject.addListener(new c5(view, rect5, i8, i11, i13, i15));
                        objectAnimator = ofObject;
                    } else {
                        objectAnimator = null;
                    }
                    zn2 = w.zn(y2, objectAnimator);
                }
                if (view.getParent() instanceof ViewGroup) {
                    ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                    r.zn(viewGroup4, true);
                    n3(new i9(viewGroup4));
                }
                return zn2;
            }
            return null;
        }
        int intValue = ((Integer) pVar.y.get("android:changeBounds:windowX")).intValue();
        int intValue2 = ((Integer) pVar.y.get("android:changeBounds:windowY")).intValue();
        int intValue3 = ((Integer) pVar2.y.get("android:changeBounds:windowX")).intValue();
        int intValue4 = ((Integer) pVar2.y.get("android:changeBounds:windowY")).intValue();
        if (intValue == intValue3 && intValue2 == intValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.f6828dm);
        Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(createBitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        float zn3 = f3.zn(view2);
        f3.fb(view2, 0.0f);
        f3.n3(viewGroup).y(bitmapDrawable);
        cr.fb c2 = c();
        int[] iArr = this.f6828dm;
        int i20 = iArr[0];
        int i21 = iArr[1];
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, cr.s.y(f6821eb, c2.y(intValue - i20, intValue2 - i21, intValue3 - i20, intValue4 - i21)));
        ofPropertyValuesHolder.addListener(new y(viewGroup, bitmapDrawable, view2, zn3));
        return ofPropertyValuesHolder;
    }
}
