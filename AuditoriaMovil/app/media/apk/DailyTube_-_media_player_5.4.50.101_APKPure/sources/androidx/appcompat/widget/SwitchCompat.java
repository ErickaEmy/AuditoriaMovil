package androidx.appcompat.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import com.uv.v7.R;
import hw.i4;
import j.tl;
import wz.hw;
import wz.n;
import wz.oz;
import wz.x;
import wz.z;
/* loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {

    /* renamed from: lc  reason: collision with root package name */
    public static final Property<SwitchCompat, Float> f1417lc = new y(Float.class, "thumbPos");

    /* renamed from: nf  reason: collision with root package name */
    public static final int[] f1418nf = {16842912};

    /* renamed from: b  reason: collision with root package name */
    public float f1419b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1420c;

    /* renamed from: co  reason: collision with root package name */
    public boolean f1421co;

    /* renamed from: ct  reason: collision with root package name */
    public TransformationMethod f1422ct;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1423d;

    /* renamed from: d0  reason: collision with root package name */
    public CharSequence f1424d0;

    /* renamed from: dm  reason: collision with root package name */
    public Layout f1425dm;

    /* renamed from: eb  reason: collision with root package name */
    public final Rect f1426eb;

    /* renamed from: ej  reason: collision with root package name */
    public int f1427ej;

    /* renamed from: en  reason: collision with root package name */
    public int f1428en;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1429f;

    /* renamed from: f3  reason: collision with root package name */
    public int f1430f3;

    /* renamed from: f7  reason: collision with root package name */
    public int f1431f7;

    /* renamed from: fb  reason: collision with root package name */
    public PorterDuff.Mode f1432fb;

    /* renamed from: fh  reason: collision with root package name */
    public CharSequence f1433fh;

    /* renamed from: j  reason: collision with root package name */
    public float f1434j;

    /* renamed from: j5  reason: collision with root package name */
    public float f1435j5;

    /* renamed from: jz  reason: collision with root package name */
    public int f1436jz;

    /* renamed from: k  reason: collision with root package name */
    public int f1437k;

    /* renamed from: n  reason: collision with root package name */
    public int f1438n;

    /* renamed from: o  reason: collision with root package name */
    public int f1439o;

    /* renamed from: o4  reason: collision with root package name */
    public ObjectAnimator f1440o4;

    /* renamed from: oz  reason: collision with root package name */
    public int f1441oz;

    /* renamed from: p  reason: collision with root package name */
    public PorterDuff.Mode f1442p;

    /* renamed from: q9  reason: collision with root package name */
    public int f1443q9;

    /* renamed from: qn  reason: collision with root package name */
    public VelocityTracker f1444qn;

    /* renamed from: r  reason: collision with root package name */
    public int f1445r;

    /* renamed from: rs  reason: collision with root package name */
    public final z f1446rs;

    /* renamed from: s  reason: collision with root package name */
    public boolean f1447s;

    /* renamed from: t  reason: collision with root package name */
    public Drawable f1448t;

    /* renamed from: u  reason: collision with root package name */
    public final TextPaint f1449u;

    /* renamed from: ut  reason: collision with root package name */
    public int f1450ut;

    /* renamed from: v  reason: collision with root package name */
    public ColorStateList f1451v;

    /* renamed from: w  reason: collision with root package name */
    public ColorStateList f1452w;

    /* renamed from: x  reason: collision with root package name */
    public int f1453x;

    /* renamed from: xg  reason: collision with root package name */
    public Layout f1454xg;
    public Drawable y;

    /* renamed from: y5  reason: collision with root package name */
    public ColorStateList f1455y5;

    /* renamed from: z  reason: collision with root package name */
    public boolean f1456z;

    /* loaded from: classes.dex */
    public class y extends Property<SwitchCompat, Float> {
        public y(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: n3 */
        public void set(SwitchCompat switchCompat, Float f4) {
            switchCompat.setThumbPosition(f4.floatValue());
        }

        @Override // android.util.Property
        /* renamed from: y */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.f1434j);
        }
    }

    public SwitchCompat(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.f627b);
    }

    public static float a(float f4, float f6, float f9) {
        return f4 < f6 ? f6 : f4 > f9 ? f9 : f4;
    }

    private boolean getTargetCheckedState() {
        if (this.f1434j > 0.5f) {
            return true;
        }
        return false;
    }

    private int getThumbOffset() {
        float f4;
        if (oz.n3(this)) {
            f4 = 1.0f - this.f1434j;
        } else {
            f4 = this.f1434j;
        }
        return (int) ((f4 * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Rect rect;
        Drawable drawable = this.f1448t;
        if (drawable != null) {
            Rect rect2 = this.f1426eb;
            drawable.getPadding(rect2);
            Drawable drawable2 = this.y;
            if (drawable2 != null) {
                rect = n.gv(drawable2);
            } else {
                rect = n.f14737zn;
            }
            return ((((this.f1441oz - this.f1443q9) - rect2.left) - rect2.right) - rect.left) - rect.right;
        }
        return 0;
    }

    public final void c5() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence charSequence = this.f1433fh;
            if (charSequence == null) {
                charSequence = getResources().getString(R$string.f796n3);
            }
            i4.l(this, charSequence);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Rect rect;
        int i;
        int i5;
        Rect rect2 = this.f1426eb;
        int i6 = this.f1437k;
        int i8 = this.f1431f7;
        int i10 = this.f1428en;
        int i11 = this.f1436jz;
        int thumbOffset = getThumbOffset() + i6;
        Drawable drawable = this.y;
        if (drawable != null) {
            rect = n.gv(drawable);
        } else {
            rect = n.f14737zn;
        }
        Drawable drawable2 = this.f1448t;
        if (drawable2 != null) {
            drawable2.getPadding(rect2);
            int i12 = rect2.left;
            thumbOffset += i12;
            if (rect != null) {
                int i13 = rect.left;
                if (i13 > i12) {
                    i6 += i13 - i12;
                }
                int i14 = rect.top;
                int i15 = rect2.top;
                if (i14 > i15) {
                    i = (i14 - i15) + i8;
                } else {
                    i = i8;
                }
                int i16 = rect.right;
                int i17 = rect2.right;
                if (i16 > i17) {
                    i10 -= i16 - i17;
                }
                int i18 = rect.bottom;
                int i19 = rect2.bottom;
                if (i18 > i19) {
                    i5 = i11 - (i18 - i19);
                    this.f1448t.setBounds(i6, i, i10, i5);
                }
            } else {
                i = i8;
            }
            i5 = i11;
            this.f1448t.setBounds(i6, i, i10, i5);
        }
        Drawable drawable3 = this.y;
        if (drawable3 != null) {
            drawable3.getPadding(rect2);
            int i20 = thumbOffset - rect2.left;
            int i21 = thumbOffset + this.f1443q9 + rect2.right;
            this.y.setBounds(i20, i8, i21, i11);
            Drawable background = getBackground();
            if (background != null) {
                ej.y.t(background, i20, i8, i21, i11);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f4, float f6) {
        super.drawableHotspotChanged(f4, f6);
        Drawable drawable = this.y;
        if (drawable != null) {
            ej.y.f(drawable, f4, f6);
        }
        Drawable drawable2 = this.f1448t;
        if (drawable2 != null) {
            ej.y.f(drawable2, f4, f6);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        boolean z2;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.y;
        if (drawable != null && drawable.isStateful()) {
            z2 = drawable.setState(drawableState);
        } else {
            z2 = false;
        }
        Drawable drawable2 = this.f1448t;
        if (drawable2 != null && drawable2.isStateful()) {
            z2 |= drawable2.setState(drawableState);
        }
        if (z2) {
            invalidate();
        }
    }

    public void f(Context context, int i) {
        hw z2 = hw.z(context, i, R$styleable.p4);
        ColorStateList zn2 = z2.zn(R$styleable.st);
        if (zn2 != null) {
            this.f1455y5 = zn2;
        } else {
            this.f1455y5 = getTextColors();
        }
        int a2 = z2.a(R$styleable.ik, 0);
        if (a2 != 0) {
            float f4 = a2;
            if (f4 != this.f1449u.getTextSize()) {
                this.f1449u.setTextSize(f4);
                requestLayout();
            }
        }
        tl(z2.f(R$styleable.ni, -1), z2.f(R$styleable.r3, -1));
        if (z2.y(R$styleable.xd, false)) {
            this.f1422ct = new f.y(getContext());
        } else {
            this.f1422ct = null;
        }
        z2.i4();
    }

    public final boolean fb(float f4, float f6) {
        if (this.y == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.y.getPadding(this.f1426eb);
        int i = this.f1431f7;
        int i5 = this.f1453x;
        int i6 = i - i5;
        int i8 = (this.f1437k + thumbOffset) - i5;
        Rect rect = this.f1426eb;
        int i10 = this.f1443q9 + i8 + rect.left + rect.right + i5;
        int i11 = this.f1436jz + i5;
        if (f4 <= i8 || f4 >= i10 || f6 <= i6 || f6 >= i11) {
            return false;
        }
        return true;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!oz.n3(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.f1441oz;
        if (!TextUtils.isEmpty(getText())) {
            return compoundPaddingLeft + this.f1438n;
        }
        return compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (oz.n3(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.f1441oz;
        if (!TextUtils.isEmpty(getText())) {
            return compoundPaddingRight + this.f1438n;
        }
        return compoundPaddingRight;
    }

    public boolean getShowText() {
        return this.f1423d;
    }

    public boolean getSplitTrack() {
        return this.f1420c;
    }

    public int getSwitchMinWidth() {
        return this.f1430f3;
    }

    public int getSwitchPadding() {
        return this.f1438n;
    }

    public CharSequence getTextOff() {
        return this.f1433fh;
    }

    public CharSequence getTextOn() {
        return this.f1424d0;
    }

    public Drawable getThumbDrawable() {
        return this.y;
    }

    public int getThumbTextPadding() {
        return this.f1445r;
    }

    @Nullable
    public ColorStateList getThumbTintList() {
        return this.f1451v;
    }

    @Nullable
    public PorterDuff.Mode getThumbTintMode() {
        return this.f1432fb;
    }

    public Drawable getTrackDrawable() {
        return this.f1448t;
    }

    @Nullable
    public ColorStateList getTrackTintList() {
        return this.f1452w;
    }

    @Nullable
    public PorterDuff.Mode getTrackTintMode() {
        return this.f1442p;
    }

    public final void gv() {
        ObjectAnimator objectAnimator = this.f1440o4;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public final void i9() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence charSequence = this.f1424d0;
            if (charSequence == null) {
                charSequence = getResources().getString(R$string.f802zn);
            }
            i4.l(this, charSequence);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.y;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f1448t;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.f1440o4;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            this.f1440o4.end();
            this.f1440o4 = null;
        }
    }

    public final void n3() {
        Drawable drawable = this.y;
        if (drawable != null) {
            if (this.f1447s || this.f1429f) {
                Drawable mutate = ej.y.mt(drawable).mutate();
                this.y = mutate;
                if (this.f1447s) {
                    ej.y.xc(mutate, this.f1451v);
                }
                if (this.f1429f) {
                    ej.y.w(this.y, this.f1432fb);
                }
                if (this.y.isStateful()) {
                    this.y.setState(getDrawableState());
                }
            }
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f1418nf);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Layout layout;
        int width;
        super.onDraw(canvas);
        Rect rect = this.f1426eb;
        Drawable drawable = this.f1448t;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i = this.f1431f7;
        int i5 = this.f1436jz;
        int i6 = i + rect.top;
        int i8 = i5 - rect.bottom;
        Drawable drawable2 = this.y;
        if (drawable != null) {
            if (this.f1420c && drawable2 != null) {
                Rect gv2 = n.gv(drawable2);
                drawable2.copyBounds(rect);
                rect.left += gv2.left;
                rect.right -= gv2.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            } else {
                drawable.draw(canvas);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        if (getTargetCheckedState()) {
            layout = this.f1454xg;
        } else {
            layout = this.f1425dm;
        }
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.f1455y5;
            if (colorStateList != null) {
                this.f1449u.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.f1449u.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (layout.getWidth() / 2), ((i6 + i8) / 2) - (layout.getHeight() / 2));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        CharSequence charSequence;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        if (Build.VERSION.SDK_INT < 30) {
            if (isChecked()) {
                charSequence = this.f1424d0;
            } else {
                charSequence = this.f1433fh;
            }
            if (!TextUtils.isEmpty(charSequence)) {
                CharSequence text = accessibilityNodeInfo.getText();
                if (TextUtils.isEmpty(text)) {
                    accessibilityNodeInfo.setText(charSequence);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(text);
                sb.append(' ');
                sb.append(charSequence);
                accessibilityNodeInfo.setText(sb);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z2, int i, int i5, int i6, int i8) {
        int i10;
        int width;
        int i11;
        int i12;
        int paddingTop;
        int i13;
        super.onLayout(z2, i, i5, i6, i8);
        int i14 = 0;
        if (this.y != null) {
            Rect rect = this.f1426eb;
            Drawable drawable = this.f1448t;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect gv2 = n.gv(this.y);
            i10 = Math.max(0, gv2.left - rect.left);
            i14 = Math.max(0, gv2.right - rect.right);
        } else {
            i10 = 0;
        }
        if (oz.n3(this)) {
            i11 = getPaddingLeft() + i10;
            width = ((this.f1441oz + i11) - i10) - i14;
        } else {
            width = (getWidth() - getPaddingRight()) - i14;
            i11 = (width - this.f1441oz) + i10 + i14;
        }
        int gravity = getGravity() & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle;
        if (gravity != 16) {
            if (gravity != 80) {
                paddingTop = getPaddingTop();
                i12 = this.f1450ut;
            } else {
                i13 = getHeight() - getPaddingBottom();
                paddingTop = i13 - this.f1450ut;
                this.f1437k = i11;
                this.f1431f7 = paddingTop;
                this.f1436jz = i13;
                this.f1428en = width;
            }
        } else {
            i12 = this.f1450ut;
            paddingTop = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (i12 / 2);
        }
        i13 = i12 + paddingTop;
        this.f1437k = i11;
        this.f1431f7 = paddingTop;
        this.f1436jz = i13;
        this.f1428en = width;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i5) {
        int i6;
        int i8;
        int i10;
        if (this.f1423d) {
            if (this.f1454xg == null) {
                this.f1454xg = s(this.f1424d0);
            }
            if (this.f1425dm == null) {
                this.f1425dm = s(this.f1433fh);
            }
        }
        Rect rect = this.f1426eb;
        Drawable drawable = this.y;
        int i11 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            i6 = (this.y.getIntrinsicWidth() - rect.left) - rect.right;
            i8 = this.y.getIntrinsicHeight();
        } else {
            i6 = 0;
            i8 = 0;
        }
        if (this.f1423d) {
            i10 = Math.max(this.f1454xg.getWidth(), this.f1425dm.getWidth()) + (this.f1445r * 2);
        } else {
            i10 = 0;
        }
        this.f1443q9 = Math.max(i10, i6);
        Drawable drawable2 = this.f1448t;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i11 = this.f1448t.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i12 = rect.left;
        int i13 = rect.right;
        Drawable drawable3 = this.y;
        if (drawable3 != null) {
            Rect gv2 = n.gv(drawable3);
            i12 = Math.max(i12, gv2.left);
            i13 = Math.max(i13, gv2.right);
        }
        int max = Math.max(this.f1430f3, (this.f1443q9 * 2) + i12 + i13);
        int max2 = Math.max(i11, i8);
        this.f1441oz = max;
        this.f1450ut = max2;
        super.onMeasure(i, i5);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(getMeasuredWidthAndState(), max2);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        CharSequence charSequence;
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        if (isChecked()) {
            charSequence = this.f1424d0;
        } else {
            charSequence = this.f1433fh;
        }
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0012, code lost:
        if (r0 != 3) goto L8;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            android.view.VelocityTracker r0 = r6.f1444qn
            r0.addMovement(r7)
            int r0 = r7.getActionMasked()
            r1 = 1
            if (r0 == 0) goto L9f
            r2 = 2
            if (r0 == r1) goto L8b
            if (r0 == r2) goto L16
            r3 = 3
            if (r0 == r3) goto L8b
            goto Lb9
        L16:
            int r0 = r6.f1427ej
            if (r0 == r1) goto L57
            if (r0 == r2) goto L1e
            goto Lb9
        L1e:
            float r7 = r7.getX()
            int r0 = r6.getThumbScrollRange()
            float r2 = r6.f1419b
            float r2 = r7 - r2
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            if (r0 == 0) goto L32
            float r0 = (float) r0
            float r2 = r2 / r0
            goto L3d
        L32:
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L39
            r2 = 1065353216(0x3f800000, float:1.0)
            goto L3d
        L39:
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
        L3d:
            boolean r0 = wz.oz.n3(r6)
            if (r0 == 0) goto L44
            float r2 = -r2
        L44:
            float r0 = r6.f1434j
            float r0 = r0 + r2
            float r0 = a(r0, r4, r3)
            float r2 = r6.f1434j
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L56
            r6.f1419b = r7
            r6.setThumbPosition(r0)
        L56:
            return r1
        L57:
            float r0 = r7.getX()
            float r3 = r7.getY()
            float r4 = r6.f1419b
            float r4 = r0 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.f1453x
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L7d
            float r4 = r6.f1435j5
            float r4 = r3 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.f1453x
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto Lb9
        L7d:
            r6.f1427ej = r2
            android.view.ViewParent r7 = r6.getParent()
            r7.requestDisallowInterceptTouchEvent(r1)
            r6.f1419b = r0
            r6.f1435j5 = r3
            return r1
        L8b:
            int r0 = r6.f1427ej
            if (r0 != r2) goto L96
            r6.wz(r7)
            super.onTouchEvent(r7)
            return r1
        L96:
            r0 = 0
            r6.f1427ej = r0
            android.view.VelocityTracker r0 = r6.f1444qn
            r0.clear()
            goto Lb9
        L9f:
            float r0 = r7.getX()
            float r2 = r7.getY()
            boolean r3 = r6.isEnabled()
            if (r3 == 0) goto Lb9
            boolean r3 = r6.fb(r0, r2)
            if (r3 == 0) goto Lb9
            r6.f1427ej = r1
            r6.f1419b = r0
            r6.f1435j5 = r2
        Lb9:
            boolean r7 = super.onTouchEvent(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final Layout s(CharSequence charSequence) {
        int i;
        TransformationMethod transformationMethod = this.f1422ct;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, this);
        }
        CharSequence charSequence2 = charSequence;
        TextPaint textPaint = this.f1449u;
        if (charSequence2 != null) {
            i = (int) Math.ceil(Layout.getDesiredWidth(charSequence2, textPaint));
        } else {
            i = 0;
        }
        return new StaticLayout(charSequence2, textPaint, i, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z2) {
        float f4;
        super.setChecked(z2);
        boolean isChecked = isChecked();
        if (isChecked) {
            i9();
        } else {
            c5();
        }
        if (getWindowToken() != null && i4.q9(this)) {
            y(isChecked);
            return;
        }
        gv();
        if (isChecked) {
            f4 = 1.0f;
        } else {
            f4 = 0.0f;
        }
        setThumbPosition(f4);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(tl.p(this, callback));
    }

    public void setShowText(boolean z2) {
        if (this.f1423d != z2) {
            this.f1423d = z2;
            requestLayout();
        }
    }

    public void setSplitTrack(boolean z2) {
        this.f1420c = z2;
        invalidate();
    }

    public void setSwitchMinWidth(int i) {
        this.f1430f3 = i;
        requestLayout();
    }

    public void setSwitchPadding(int i) {
        this.f1438n = i;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.f1449u.getTypeface() != null && !this.f1449u.getTypeface().equals(typeface)) || (this.f1449u.getTypeface() == null && typeface != null)) {
            this.f1449u.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setTextOff(CharSequence charSequence) {
        this.f1433fh = charSequence;
        requestLayout();
        if (!isChecked()) {
            c5();
        }
    }

    public void setTextOn(CharSequence charSequence) {
        this.f1424d0 = charSequence;
        requestLayout();
        if (isChecked()) {
            i9();
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.y;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.y = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbPosition(float f4) {
        this.f1434j = f4;
        invalidate();
    }

    public void setThumbResource(int i) {
        setThumbDrawable(c5.y.gv(getContext(), i));
    }

    public void setThumbTextPadding(int i) {
        this.f1445r = i;
        requestLayout();
    }

    public void setThumbTintList(@Nullable ColorStateList colorStateList) {
        this.f1451v = colorStateList;
        this.f1447s = true;
        n3();
    }

    public void setThumbTintMode(@Nullable PorterDuff.Mode mode) {
        this.f1432fb = mode;
        this.f1429f = true;
        n3();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f1448t;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1448t = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(c5.y.gv(getContext(), i));
    }

    public void setTrackTintList(@Nullable ColorStateList colorStateList) {
        this.f1452w = colorStateList;
        this.f1421co = true;
        zn();
    }

    public void setTrackTintMode(@Nullable PorterDuff.Mode mode) {
        this.f1442p = mode;
        this.f1456z = true;
        zn();
    }

    public void t(Typeface typeface, int i) {
        Typeface create;
        int i5;
        float f4 = 0.0f;
        boolean z2 = false;
        if (i > 0) {
            if (typeface == null) {
                create = Typeface.defaultFromStyle(i);
            } else {
                create = Typeface.create(typeface, i);
            }
            setSwitchTypeface(create);
            if (create != null) {
                i5 = create.getStyle();
            } else {
                i5 = 0;
            }
            int i6 = (~i5) & i;
            TextPaint textPaint = this.f1449u;
            if ((i6 & 1) != 0) {
                z2 = true;
            }
            textPaint.setFakeBoldText(z2);
            TextPaint textPaint2 = this.f1449u;
            if ((i6 & 2) != 0) {
                f4 = -0.25f;
            }
            textPaint2.setTextSkewX(f4);
            return;
        }
        this.f1449u.setFakeBoldText(false);
        this.f1449u.setTextSkewX(0.0f);
        setSwitchTypeface(typeface);
    }

    public final void tl(int i, int i5) {
        Typeface typeface;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    typeface = null;
                } else {
                    typeface = Typeface.MONOSPACE;
                }
            } else {
                typeface = Typeface.SERIF;
            }
        } else {
            typeface = Typeface.SANS_SERIF;
        }
        t(typeface, i5);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    public final void v(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.y && drawable != this.f1448t) {
            return false;
        }
        return true;
    }

    public final void wz(MotionEvent motionEvent) {
        boolean z2;
        this.f1427ej = 0;
        boolean z3 = true;
        if (motionEvent.getAction() == 1 && isEnabled()) {
            z2 = true;
        } else {
            z2 = false;
        }
        boolean isChecked = isChecked();
        if (z2) {
            this.f1444qn.computeCurrentVelocity(1000);
            float xVelocity = this.f1444qn.getXVelocity();
            if (Math.abs(xVelocity) > this.f1439o) {
                if (!oz.n3(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                    z3 = false;
                }
            } else {
                z3 = getTargetCheckedState();
            }
        } else {
            z3 = isChecked;
        }
        if (z3 != isChecked) {
            playSoundEffect(0);
        }
        setChecked(z3);
        v(motionEvent);
    }

    public final void y(boolean z2) {
        float f4;
        if (z2) {
            f4 = 1.0f;
        } else {
            f4 = 0.0f;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f1417lc, f4);
        this.f1440o4 = ofFloat;
        ofFloat.setDuration(250L);
        this.f1440o4.setAutoCancel(true);
        this.f1440o4.start();
    }

    public final void zn() {
        Drawable drawable = this.f1448t;
        if (drawable != null) {
            if (this.f1421co || this.f1456z) {
                Drawable mutate = ej.y.mt(drawable).mutate();
                this.f1448t = mutate;
                if (this.f1421co) {
                    ej.y.xc(mutate, this.f1452w);
                }
                if (this.f1456z) {
                    ej.y.w(this.f1448t, this.f1442p);
                }
                if (this.f1448t.isStateful()) {
                    this.f1448t.setState(getDrawableState());
                }
            }
        }
    }

    public SwitchCompat(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1444qn = VelocityTracker.obtain();
        this.f1426eb = new Rect();
        x.y(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.f1449u = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = R$styleable.ja;
        hw x42 = hw.x4(context, attributeSet, iArr, i, 0);
        i4.kp(this, context, iArr, attributeSet, x42.mt(), i, 0);
        Drawable fb2 = x42.fb(R$styleable.ng);
        this.y = fb2;
        if (fb2 != null) {
            fb2.setCallback(this);
        }
        Drawable fb3 = x42.fb(R$styleable.mf);
        this.f1448t = fb3;
        if (fb3 != null) {
            fb3.setCallback(this);
        }
        this.f1424d0 = x42.w(R$styleable.cp);
        this.f1433fh = x42.w(R$styleable.gd);
        this.f1423d = x42.y(R$styleable.y0, true);
        this.f1445r = x42.a(R$styleable.gm, 0);
        this.f1430f3 = x42.a(R$styleable.t3, 0);
        this.f1438n = x42.a(R$styleable.m5, 0);
        this.f1420c = x42.y(R$styleable.t6, false);
        ColorStateList zn2 = x42.zn(R$styleable.jf);
        if (zn2 != null) {
            this.f1451v = zn2;
            this.f1447s = true;
        }
        PorterDuff.Mode v2 = n.v(x42.f(R$styleable.x2, -1), null);
        if (this.f1432fb != v2) {
            this.f1432fb = v2;
            this.f1429f = true;
        }
        if (this.f1447s || this.f1429f) {
            n3();
        }
        ColorStateList zn3 = x42.zn(R$styleable.fm);
        if (zn3 != null) {
            this.f1452w = zn3;
            this.f1421co = true;
        }
        PorterDuff.Mode v3 = n.v(x42.f(R$styleable.w5, -1), null);
        if (this.f1442p != v3) {
            this.f1442p = v3;
            this.f1456z = true;
        }
        if (this.f1421co || this.f1456z) {
            zn();
        }
        int wz2 = x42.wz(R$styleable.op, 0);
        if (wz2 != 0) {
            f(context, wz2);
        }
        z zVar = new z(this);
        this.f1446rs = zVar;
        zVar.tl(attributeSet, i);
        x42.i4();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f1453x = viewConfiguration.getScaledTouchSlop();
        this.f1439o = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }
}
