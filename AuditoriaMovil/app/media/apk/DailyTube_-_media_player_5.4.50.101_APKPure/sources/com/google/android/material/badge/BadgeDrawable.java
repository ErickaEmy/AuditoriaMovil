package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$plurals;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import hw.i4;
import hx.fb;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import pv.gv;
import pv.zn;
import ur.i9;
import ur.s;
/* loaded from: classes.dex */
public class BadgeDrawable extends Drawable implements s.n3 {

    /* renamed from: d  reason: collision with root package name */
    public static final int f5367d = R$style.z7;

    /* renamed from: ej  reason: collision with root package name */
    public static final int f5368ej = R$attr.s3;

    /* renamed from: c  reason: collision with root package name */
    public float f5369c;

    /* renamed from: co  reason: collision with root package name */
    public float f5370co;
    @Nullable

    /* renamed from: d0  reason: collision with root package name */
    public WeakReference<View> f5371d0;

    /* renamed from: f  reason: collision with root package name */
    public final float f5372f;

    /* renamed from: f3  reason: collision with root package name */
    public float f5373f3;
    @NonNull

    /* renamed from: fb  reason: collision with root package name */
    public final s f5374fb;
    @Nullable

    /* renamed from: fh  reason: collision with root package name */
    public WeakReference<FrameLayout> f5375fh;

    /* renamed from: n  reason: collision with root package name */
    public float f5376n;
    @NonNull

    /* renamed from: p  reason: collision with root package name */
    public final SavedState f5377p;

    /* renamed from: r  reason: collision with root package name */
    public int f5378r;
    @NonNull

    /* renamed from: s  reason: collision with root package name */
    public final Rect f5379s;

    /* renamed from: t  reason: collision with root package name */
    public final float f5380t;
    @NonNull

    /* renamed from: v  reason: collision with root package name */
    public final fb f5381v;

    /* renamed from: w  reason: collision with root package name */
    public final float f5382w;
    @NonNull
    public final WeakReference<Context> y;

    /* renamed from: z  reason: collision with root package name */
    public float f5383z;

    /* loaded from: classes.dex */
    public class y implements Runnable {

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ FrameLayout f5396v;
        public final /* synthetic */ View y;

        public y(View view, FrameLayout frameLayout) {
            this.y = view;
            this.f5396v = frameLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            BadgeDrawable.this.n(this.y, this.f5396v);
        }
    }

    public BadgeDrawable(@NonNull Context context) {
        this.y = new WeakReference<>(context);
        i9.zn(context);
        Resources resources = context.getResources();
        this.f5379s = new Rect();
        this.f5381v = new fb();
        this.f5372f = resources.getDimensionPixelSize(R$dimen.c);
        this.f5382w = resources.getDimensionPixelSize(R$dimen.dz);
        this.f5380t = resources.getDimensionPixelSize(R$dimen.d0);
        s sVar = new s(this);
        this.f5374fb = sVar;
        sVar.v().setTextAlign(Paint.Align.CENTER);
        this.f5377p = new SavedState(context);
        r(R$style.l2);
    }

    public static void f3(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
    }

    @NonNull
    public static BadgeDrawable gv(@NonNull Context context, AttributeSet attributeSet, int i, int i5) {
        BadgeDrawable badgeDrawable = new BadgeDrawable(context);
        badgeDrawable.t(context, attributeSet, i, i5);
        return badgeDrawable;
    }

    private void r(int i) {
        Context context = this.y.get();
        if (context == null) {
            return;
        }
        z(new gv(context, i));
    }

    public static int tl(Context context, @NonNull TypedArray typedArray, int i) {
        return zn.y(context, typedArray, i).getDefaultColor();
    }

    private void z(@Nullable gv gvVar) {
        Context context;
        if (this.f5374fb.gv() == gvVar || (context = this.y.get()) == null) {
            return;
        }
        this.f5374fb.s(gvVar, context);
        c();
    }

    @NonNull
    public static BadgeDrawable zn(@NonNull Context context) {
        return gv(context, null, f5368ej, f5367d);
    }

    @NonNull
    public final String a() {
        if (i9() <= this.f5378r) {
            return NumberFormat.getInstance().format(i9());
        }
        Context context = this.y.get();
        if (context == null) {
            return "";
        }
        return context.getString(R$string.fly, Integer.valueOf(this.f5378r), "+");
    }

    public final void c() {
        View view;
        Context context = this.y.get();
        WeakReference<View> weakReference = this.f5371d0;
        FrameLayout frameLayout = null;
        if (weakReference != null) {
            view = weakReference.get();
        } else {
            view = null;
        }
        if (context != null && view != null) {
            Rect rect = new Rect();
            rect.set(this.f5379s);
            Rect rect2 = new Rect();
            view.getDrawingRect(rect2);
            WeakReference<FrameLayout> weakReference2 = this.f5375fh;
            if (weakReference2 != null) {
                frameLayout = weakReference2.get();
            }
            if (frameLayout != null || com.google.android.material.badge.y.y) {
                if (frameLayout == null) {
                    frameLayout = (ViewGroup) view.getParent();
                }
                frameLayout.offsetDescendantRectToMyCoords(view, rect2);
            }
            n3(context, rect2, view);
            com.google.android.material.badge.y.gv(this.f5379s, this.f5370co, this.f5383z, this.f5376n, this.f5369c);
            this.f5381v.oz(this.f5373f3);
            if (!rect.equals(this.f5379s)) {
                this.f5381v.setBounds(this.f5379s);
            }
        }
    }

    public int c5() {
        return this.f5377p.f5385f;
    }

    public void co(int i) {
        int max = Math.max(0, i);
        if (this.f5377p.f5390s != max) {
            this.f5377p.f5390s = max;
            this.f5374fb.c5(true);
            c();
            invalidateSelf();
        }
    }

    public final void d0() {
        this.f5378r = ((int) Math.pow(10.0d, c5() - 1.0d)) - 1;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (!getBounds().isEmpty() && getAlpha() != 0 && isVisible()) {
            this.f5381v.draw(canvas);
            if (f()) {
                v(canvas);
            }
        }
    }

    public boolean f() {
        if (this.f5377p.f5390s != -1) {
            return true;
        }
        return false;
    }

    @Nullable
    public CharSequence fb() {
        Context context;
        if (!isVisible()) {
            return null;
        }
        if (!f()) {
            return this.f5377p.f5391t;
        }
        if (this.f5377p.f5393w <= 0 || (context = this.y.get()) == null) {
            return null;
        }
        if (i9() <= this.f5378r) {
            return context.getResources().getQuantityString(this.f5377p.f5393w, i9(), Integer.valueOf(i9()));
        }
        return context.getString(this.f5377p.f5388p, Integer.valueOf(this.f5378r));
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f5377p.f5387fb;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f5379s.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f5379s.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public final void i4(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup == null || viewGroup.getId() != R$id.mtrl_anchor_parent) {
            WeakReference<FrameLayout> weakReference = this.f5375fh;
            if (weakReference != null && weakReference.get() == viewGroup) {
                return;
            }
            f3(view);
            FrameLayout frameLayout = new FrameLayout(view.getContext());
            frameLayout.setId(R$id.mtrl_anchor_parent);
            frameLayout.setClipChildren(false);
            frameLayout.setClipToPadding(false);
            frameLayout.setLayoutParams(view.getLayoutParams());
            frameLayout.setMinimumWidth(view.getWidth());
            frameLayout.setMinimumHeight(view.getHeight());
            int indexOfChild = viewGroup.indexOfChild(view);
            viewGroup.removeViewAt(indexOfChild);
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            frameLayout.addView(view);
            viewGroup.addView(frameLayout, indexOfChild);
            this.f5375fh = new WeakReference<>(frameLayout);
            frameLayout.post(new y(view, frameLayout));
        }
    }

    public int i9() {
        if (f()) {
            return this.f5377p.f5390s;
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    public void mt(int i) {
        if (this.f5377p.f5385f != i) {
            this.f5377p.f5385f = i;
            d0();
            this.f5374fb.c5(true);
            c();
            invalidateSelf();
        }
    }

    public void n(@NonNull View view, @Nullable FrameLayout frameLayout) {
        this.f5371d0 = new WeakReference<>(view);
        boolean z2 = com.google.android.material.badge.y.y;
        if (z2 && frameLayout == null) {
            i4(view);
        } else {
            this.f5375fh = new WeakReference<>(frameLayout);
        }
        if (!z2) {
            f3(view);
        }
        c();
        invalidateSelf();
    }

    public final void n3(@NonNull Context context, @NonNull Rect rect, @NonNull View view) {
        int i;
        float f4;
        float f6;
        float f9;
        int i5 = this.f5377p.f5384co;
        if (i5 != 8388691 && i5 != 8388693) {
            this.f5383z = rect.top + this.f5377p.f5386f3;
        } else {
            this.f5383z = rect.bottom - this.f5377p.f5386f3;
        }
        if (i9() <= 9) {
            if (!f()) {
                f9 = this.f5372f;
            } else {
                f9 = this.f5380t;
            }
            this.f5373f3 = f9;
            this.f5369c = f9;
            this.f5376n = f9;
        } else {
            float f10 = this.f5380t;
            this.f5373f3 = f10;
            this.f5369c = f10;
            this.f5376n = (this.f5374fb.a(a()) / 2.0f) + this.f5382w;
        }
        Resources resources = context.getResources();
        if (f()) {
            i = R$dimen.dw;
        } else {
            i = R$dimen.dp;
        }
        int dimensionPixelSize = resources.getDimensionPixelSize(i);
        int i6 = this.f5377p.f5384co;
        if (i6 != 8388659 && i6 != 8388691) {
            if (i4.ta(view) == 0) {
                f6 = ((rect.right + this.f5376n) - dimensionPixelSize) - this.f5377p.f5389r;
            } else {
                f6 = (rect.left - this.f5376n) + dimensionPixelSize + this.f5377p.f5389r;
            }
            this.f5370co = f6;
            return;
        }
        if (i4.ta(view) == 0) {
            f4 = (rect.left - this.f5376n) + dimensionPixelSize + this.f5377p.f5389r;
        } else {
            f4 = ((rect.right + this.f5376n) - dimensionPixelSize) - this.f5377p.f5389r;
        }
        this.f5370co = f4;
    }

    @Override // android.graphics.drawable.Drawable, ur.s.n3
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public void p(int i) {
        this.f5377p.f5389r = i;
        c();
    }

    @Nullable
    public FrameLayout s() {
        WeakReference<FrameLayout> weakReference = this.f5375fh;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f5377p.f5387fb = i;
        this.f5374fb.v().setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public final void t(Context context, AttributeSet attributeSet, int i, int i5) {
        TypedArray s2 = i9.s(context, attributeSet, R$styleable.f5268rz, i, i5, new int[0]);
        mt(s2.getInt(R$styleable.f5155ej, 4));
        int i6 = R$styleable.f5286ud;
        if (s2.hasValue(i6)) {
            co(s2.getInt(i6, 0));
        }
        wz(tl(context, s2, R$styleable.f5218mg));
        int i8 = R$styleable.f5137d;
        if (s2.hasValue(i8)) {
            w(tl(context, s2, i8));
        }
        xc(s2.getInt(R$styleable.f5275ta, 8388661));
        p(s2.getDimensionPixelOffset(R$styleable.f5324z6, 0));
        x4(s2.getDimensionPixelOffset(R$styleable.f5114a8, 0));
        s2.recycle();
    }

    public final void v(Canvas canvas) {
        Rect rect = new Rect();
        String a2 = a();
        this.f5374fb.v().getTextBounds(a2, 0, a2.length(), rect);
        canvas.drawText(a2, this.f5370co, this.f5383z + (rect.height() / 2), this.f5374fb.v());
    }

    public void w(int i) {
        this.f5377p.f5392v = i;
        if (this.f5374fb.v().getColor() != i) {
            this.f5374fb.v().setColor(i);
            invalidateSelf();
        }
    }

    public void wz(int i) {
        this.f5377p.y = i;
        ColorStateList valueOf = ColorStateList.valueOf(i);
        if (this.f5381v.f3() != valueOf) {
            this.f5381v.k(valueOf);
            invalidateSelf();
        }
    }

    public void x4(int i) {
        this.f5377p.f5386f3 = i;
        c();
    }

    public void xc(int i) {
        FrameLayout frameLayout;
        if (this.f5377p.f5384co != i) {
            this.f5377p.f5384co = i;
            WeakReference<View> weakReference = this.f5371d0;
            if (weakReference != null && weakReference.get() != null) {
                View view = this.f5371d0.get();
                WeakReference<FrameLayout> weakReference2 = this.f5375fh;
                if (weakReference2 != null) {
                    frameLayout = weakReference2.get();
                } else {
                    frameLayout = null;
                }
                n(view, frameLayout);
            }
        }
    }

    @Override // ur.s.n3
    public void y() {
        invalidateSelf();
    }

    /* loaded from: classes.dex */
    public static final class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new y();

        /* renamed from: co  reason: collision with root package name */
        public int f5384co;

        /* renamed from: f  reason: collision with root package name */
        public int f5385f;

        /* renamed from: f3  reason: collision with root package name */
        public int f5386f3;

        /* renamed from: fb  reason: collision with root package name */
        public int f5387fb;

        /* renamed from: p  reason: collision with root package name */
        public int f5388p;

        /* renamed from: r  reason: collision with root package name */
        public int f5389r;

        /* renamed from: s  reason: collision with root package name */
        public int f5390s;
        @Nullable

        /* renamed from: t  reason: collision with root package name */
        public CharSequence f5391t;

        /* renamed from: v  reason: collision with root package name */
        public int f5392v;

        /* renamed from: w  reason: collision with root package name */
        public int f5393w;
        public int y;

        /* renamed from: z  reason: collision with root package name */
        public boolean f5394z;

        /* loaded from: classes.dex */
        public static class y implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: n3 */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: y */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel);
            }
        }

        public SavedState(@NonNull Context context) {
            this.f5387fb = 255;
            this.f5390s = -1;
            this.f5392v = new gv(context, R$style.l2).y.getDefaultColor();
            this.f5391t = context.getString(R$string.flb);
            this.f5393w = R$plurals.b;
            this.f5388p = R$string.flj;
            this.f5394z = true;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            parcel.writeInt(this.y);
            parcel.writeInt(this.f5392v);
            parcel.writeInt(this.f5387fb);
            parcel.writeInt(this.f5390s);
            parcel.writeInt(this.f5385f);
            parcel.writeString(this.f5391t.toString());
            parcel.writeInt(this.f5393w);
            parcel.writeInt(this.f5384co);
            parcel.writeInt(this.f5389r);
            parcel.writeInt(this.f5386f3);
            parcel.writeInt(this.f5394z ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel) {
            this.f5387fb = 255;
            this.f5390s = -1;
            this.y = parcel.readInt();
            this.f5392v = parcel.readInt();
            this.f5387fb = parcel.readInt();
            this.f5390s = parcel.readInt();
            this.f5385f = parcel.readInt();
            this.f5391t = parcel.readString();
            this.f5393w = parcel.readInt();
            this.f5384co = parcel.readInt();
            this.f5389r = parcel.readInt();
            this.f5386f3 = parcel.readInt();
            this.f5394z = parcel.readInt() != 0;
        }
    }
}
