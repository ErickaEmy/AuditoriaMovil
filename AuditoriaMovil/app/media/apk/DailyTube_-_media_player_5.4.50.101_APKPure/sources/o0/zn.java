package o0;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import d.f;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public class zn extends fb implements Animatable {

    /* renamed from: fb  reason: collision with root package name */
    public Context f12135fb;

    /* renamed from: s  reason: collision with root package name */
    public final Drawable.Callback f12136s;

    /* renamed from: v  reason: collision with root package name */
    public n3 f12137v;

    /* loaded from: classes.dex */
    public static class n3 extends Drawable.ConstantState {

        /* renamed from: gv  reason: collision with root package name */
        public ArrayList<Animator> f12138gv;

        /* renamed from: n3  reason: collision with root package name */
        public s f12139n3;

        /* renamed from: v  reason: collision with root package name */
        public z.y<Animator, String> f12140v;
        public int y;

        /* renamed from: zn  reason: collision with root package name */
        public AnimatorSet f12141zn;

        public n3(Context context, n3 n3Var, Drawable.Callback callback, Resources resources) {
            if (n3Var != null) {
                this.y = n3Var.y;
                s sVar = n3Var.f12139n3;
                if (sVar != null) {
                    Drawable.ConstantState constantState = sVar.getConstantState();
                    if (resources != null) {
                        this.f12139n3 = (s) constantState.newDrawable(resources);
                    } else {
                        this.f12139n3 = (s) constantState.newDrawable();
                    }
                    s sVar2 = (s) this.f12139n3.mutate();
                    this.f12139n3 = sVar2;
                    sVar2.setCallback(callback);
                    this.f12139n3.setBounds(n3Var.f12139n3.getBounds());
                    this.f12139n3.s(false);
                }
                ArrayList<Animator> arrayList = n3Var.f12138gv;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f12138gv = new ArrayList<>(size);
                    this.f12140v = new z.y<>(size);
                    for (int i = 0; i < size; i++) {
                        Animator animator = n3Var.f12138gv.get(i);
                        Animator clone = animator.clone();
                        String str = n3Var.f12140v.get(animator);
                        clone.setTarget(this.f12139n3.gv(str));
                        this.f12138gv.add(clone);
                        this.f12140v.put(clone, str);
                    }
                    y();
                }
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.y;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public void y() {
            if (this.f12141zn == null) {
                this.f12141zn = new AnimatorSet();
            }
            this.f12141zn.playTogether(this.f12138gv);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    /* loaded from: classes.dex */
    public class y implements Drawable.Callback {
        public y() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            zn.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
            zn.this.scheduleSelf(runnable, j2);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            zn.this.unscheduleSelf(runnable);
        }
    }

    public zn() {
        this(null, null, null);
    }

    public static zn y(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        zn znVar = new zn(context);
        znVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return znVar;
    }

    @Override // o0.fb, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.y;
        if (drawable != null) {
            ej.y.y(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.y;
        if (drawable != null) {
            return ej.y.n3(drawable);
        }
        return false;
    }

    @Override // o0.fb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.y;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f12137v.f12139n3.draw(canvas);
        if (this.f12137v.f12141zn.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.y;
        if (drawable != null) {
            return ej.y.gv(drawable);
        }
        return this.f12137v.f12139n3.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.y;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f12137v.y;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.y;
        if (drawable != null) {
            return ej.y.v(drawable);
        }
        return this.f12137v.f12139n3.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.y != null && Build.VERSION.SDK_INT >= 24) {
            return new C0172zn(this.y.getConstantState());
        }
        return null;
    }

    @Override // o0.fb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.y;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return this.f12137v.f12139n3.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.y;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return this.f12137v.f12139n3.getIntrinsicWidth();
    }

    @Override // o0.fb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // o0.fb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.y;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return this.f12137v.f12139n3.getOpacity();
    }

    @Override // o0.fb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // o0.fb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // o0.fb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.y;
        if (drawable != null) {
            ej.y.fb(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray f4 = f.f(resources, theme, attributeSet, o0.y.f12133v);
                    int resourceId = f4.getResourceId(0, 0);
                    if (resourceId != 0) {
                        s n32 = s.n3(resources, resourceId, theme);
                        n32.s(false);
                        n32.setCallback(this.f12136s);
                        s sVar = this.f12137v.f12139n3;
                        if (sVar != null) {
                            sVar.setCallback(null);
                        }
                        this.f12137v.f12139n3 = n32;
                    }
                    f4.recycle();
                } else if ("target".equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, o0.y.f12124a);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f12135fb;
                        if (context != null) {
                            n3(string, v.c5(context, resourceId2));
                        } else {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f12137v.y();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.y;
        if (drawable != null) {
            return ej.y.s(drawable);
        }
        return this.f12137v.f12139n3.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable = this.y;
        if (drawable != null) {
            return ((AnimatedVectorDrawable) drawable).isRunning();
        }
        return this.f12137v.f12141zn.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.y;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return this.f12137v.f12139n3.isStateful();
    }

    @Override // o0.fb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.y;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    public final void n3(String str, Animator animator) {
        animator.setTarget(this.f12137v.f12139n3.gv(str));
        n3 n3Var = this.f12137v;
        if (n3Var.f12138gv == null) {
            n3Var.f12138gv = new ArrayList<>();
            this.f12137v.f12140v = new z.y<>();
        }
        this.f12137v.f12138gv.add(animator);
        this.f12137v.f12140v.put(animator, str);
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.y;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f12137v.f12139n3.setBounds(rect);
        }
    }

    @Override // o0.fb, android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        Drawable drawable = this.y;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        return this.f12137v.f12139n3.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.y;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        return this.f12137v.f12139n3.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Drawable drawable = this.y;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else {
            this.f12137v.f12139n3.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z2) {
        Drawable drawable = this.y;
        if (drawable != null) {
            ej.y.i9(drawable, z2);
        } else {
            this.f12137v.f12139n3.setAutoMirrored(z2);
        }
    }

    @Override // o0.fb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    @Override // o0.fb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i, PorterDuff.Mode mode) {
        super.setColorFilter(i, mode);
    }

    @Override // o0.fb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z2) {
        super.setFilterBitmap(z2);
    }

    @Override // o0.fb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f4, float f6) {
        super.setHotspot(f4, f6);
    }

    @Override // o0.fb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i5, int i6, int i8) {
        super.setHotspotBounds(i, i5, i6, i8);
    }

    @Override // o0.fb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i) {
        Drawable drawable = this.y;
        if (drawable != null) {
            ej.y.wz(drawable, i);
        } else {
            this.f12137v.f12139n3.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.y;
        if (drawable != null) {
            ej.y.xc(drawable, colorStateList);
        } else {
            this.f12137v.f12139n3.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.y;
        if (drawable != null) {
            ej.y.w(drawable, mode);
        } else {
            this.f12137v.f12139n3.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        Drawable drawable = this.y;
        if (drawable != null) {
            return drawable.setVisible(z2, z3);
        }
        this.f12137v.f12139n3.setVisible(z2, z3);
        return super.setVisible(z2, z3);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.y;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else if (this.f12137v.f12141zn.isStarted()) {
        } else {
            this.f12137v.f12141zn.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.y;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f12137v.f12141zn.end();
        }
    }

    public zn(@Nullable Context context) {
        this(context, null, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.y;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f12137v.f12139n3.setColorFilter(colorFilter);
        }
    }

    /* renamed from: o0.zn$zn  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0172zn extends Drawable.ConstantState {
        public final Drawable.ConstantState y;

        public C0172zn(Drawable.ConstantState constantState) {
            this.y = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.y.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.y.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            zn znVar = new zn();
            Drawable newDrawable = this.y.newDrawable();
            znVar.y = newDrawable;
            newDrawable.setCallback(znVar.f12136s);
            return znVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            zn znVar = new zn();
            Drawable newDrawable = this.y.newDrawable(resources);
            znVar.y = newDrawable;
            newDrawable.setCallback(znVar.f12136s);
            return znVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            zn znVar = new zn();
            Drawable newDrawable = this.y.newDrawable(resources, theme);
            znVar.y = newDrawable;
            newDrawable.setCallback(znVar.f12136s);
            return znVar;
        }
    }

    public zn(@Nullable Context context, @Nullable n3 n3Var, @Nullable Resources resources) {
        y yVar = new y();
        this.f12136s = yVar;
        this.f12135fb = context;
        if (n3Var != null) {
            this.f12137v = n3Var;
        } else {
            this.f12137v = new n3(context, n3Var, yVar, resources);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
