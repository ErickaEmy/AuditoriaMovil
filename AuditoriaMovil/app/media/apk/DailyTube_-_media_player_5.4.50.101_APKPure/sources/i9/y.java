package i9;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.resources.R$styleable;
import d.f;
import i9.gv;
import i9.n3;
import java.io.IOException;
import o0.s;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import wz.z6;
import z.c5;
@SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
public class y extends i9.gv implements ej.a {

    /* renamed from: d  reason: collision with root package name */
    public int f9167d;

    /* renamed from: d0  reason: collision with root package name */
    public zn f9168d0;

    /* renamed from: ej  reason: collision with root package name */
    public int f9169ej;

    /* renamed from: fh  reason: collision with root package name */
    public fb f9170fh;

    /* renamed from: x  reason: collision with root package name */
    public boolean f9171x;

    /* loaded from: classes.dex */
    public static class a implements TimeInterpolator {

        /* renamed from: n3  reason: collision with root package name */
        public int f9172n3;
        public int[] y;

        /* renamed from: zn  reason: collision with root package name */
        public int f9173zn;

        public a(AnimationDrawable animationDrawable, boolean z2) {
            n3(animationDrawable, z2);
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            float f6;
            int i = (int) ((f4 * this.f9173zn) + 0.5f);
            int i5 = this.f9172n3;
            int[] iArr = this.y;
            int i6 = 0;
            while (i6 < i5) {
                int i8 = iArr[i6];
                if (i < i8) {
                    break;
                }
                i -= i8;
                i6++;
            }
            if (i6 < i5) {
                f6 = i / this.f9173zn;
            } else {
                f6 = 0.0f;
            }
            return (i6 / i5) + f6;
        }

        public int n3(AnimationDrawable animationDrawable, boolean z2) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f9172n3 = numberOfFrames;
            int[] iArr = this.y;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.y = new int[numberOfFrames];
            }
            int[] iArr2 = this.y;
            int i = 0;
            for (int i5 = 0; i5 < numberOfFrames; i5++) {
                int duration = animationDrawable.getDuration(z2 ? (numberOfFrames - i5) - 1 : i5);
                iArr2[i5] = duration;
                i += duration;
            }
            this.f9173zn = i;
            return i;
        }

        public int y() {
            return this.f9173zn;
        }
    }

    /* loaded from: classes.dex */
    public static class gv extends fb {
        public final o0.zn y;

        public gv(o0.zn znVar) {
            super();
            this.y = znVar;
        }

        @Override // i9.y.fb
        public void gv() {
            this.y.stop();
        }

        @Override // i9.y.fb
        public void zn() {
            this.y.start();
        }
    }

    /* loaded from: classes.dex */
    public static class n3 extends fb {
        public final Animatable y;

        public n3(Animatable animatable) {
            super();
            this.y = animatable;
        }

        @Override // i9.y.fb
        public void gv() {
            this.y.stop();
        }

        @Override // i9.y.fb
        public void zn() {
            this.y.start();
        }
    }

    /* loaded from: classes.dex */
    public static class v extends fb {

        /* renamed from: n3  reason: collision with root package name */
        public final boolean f9174n3;
        public final ObjectAnimator y;

        public v(AnimationDrawable animationDrawable, boolean z2, boolean z3) {
            super();
            int i;
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            if (z2) {
                i = numberOfFrames - 1;
            } else {
                i = 0;
            }
            int i5 = z2 ? 0 : numberOfFrames - 1;
            a aVar = new a(animationDrawable, z2);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i, i5);
            ofInt.setAutoCancel(true);
            ofInt.setDuration(aVar.y());
            ofInt.setInterpolator(aVar);
            this.f9174n3 = z3;
            this.y = ofInt;
        }

        @Override // i9.y.fb
        public void gv() {
            this.y.cancel();
        }

        @Override // i9.y.fb
        public void n3() {
            this.y.reverse();
        }

        @Override // i9.y.fb
        public boolean y() {
            return this.f9174n3;
        }

        @Override // i9.y.fb
        public void zn() {
            this.y.start();
        }
    }

    /* loaded from: classes.dex */
    public static class zn extends gv.y {

        /* renamed from: b  reason: collision with root package name */
        public c5<Integer> f9175b;

        /* renamed from: x  reason: collision with root package name */
        public z.v<Long> f9176x;

        public zn(@Nullable zn znVar, @NonNull y yVar, @Nullable Resources resources) {
            super(znVar, yVar, resources);
            if (znVar != null) {
                this.f9176x = znVar.f9176x;
                this.f9175b = znVar.f9175b;
                return;
            }
            this.f9176x = new z.v<>();
            this.f9175b = new c5<>();
        }

        public static long mg(int i, int i5) {
            return i5 | (i << 32);
        }

        public int d(@NonNull int[] iArr) {
            int d02 = super.d0(iArr);
            if (d02 >= 0) {
                return d02;
            }
            return super.d0(StateSet.WILD_CARD);
        }

        public boolean ej(int i, int i5) {
            if ((this.f9176x.c5(mg(i, i5), -1L).longValue() & 4294967296L) != 0) {
                return true;
            }
            return false;
        }

        public int fh(@NonNull int[] iArr, @NonNull Drawable drawable, int i) {
            int c2 = super.c(iArr, drawable);
            this.f9175b.f(c2, Integer.valueOf(i));
            return c2;
        }

        @Override // i9.gv.y, i9.n3.gv
        public void mt() {
            this.f9176x = this.f9176x.clone();
            this.f9175b = this.f9175b.clone();
        }

        @Override // i9.gv.y, android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new y(this, null);
        }

        public int rz(int i, int i5, @NonNull Drawable drawable, boolean z2) {
            long j2;
            int y = super.y(drawable);
            long mg2 = mg(i, i5);
            if (z2) {
                j2 = 8589934592L;
            } else {
                j2 = 0;
            }
            long j4 = y;
            this.f9176x.n3(mg2, Long.valueOf(j4 | j2));
            if (z2) {
                this.f9176x.n3(mg(i5, i), Long.valueOf(4294967296L | j4 | j2));
            }
            return y;
        }

        public int ta(int i) {
            if (i < 0) {
                return 0;
            }
            return this.f9175b.s(i, 0).intValue();
        }

        public boolean ud(int i, int i5) {
            if ((this.f9176x.c5(mg(i, i5), -1L).longValue() & 8589934592L) != 0) {
                return true;
            }
            return false;
        }

        public int z6(int i, int i5) {
            return (int) this.f9176x.c5(mg(i, i5), -1L).longValue();
        }

        @Override // i9.gv.y, android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new y(this, resources);
        }
    }

    public y() {
        this(null, null);
    }

    public static y tl(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws IOException, XmlPullParserException {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            y yVar = new y();
            yVar.wz(context, resources, xmlPullParser, attributeSet, theme);
            return yVar;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    @Override // i9.gv, i9.n3, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(@NonNull Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // i9.n3, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean canApplyTheme() {
        return super.canApplyTheme();
    }

    public final boolean co(int i) {
        int zn2;
        int z62;
        fb n3Var;
        fb fbVar = this.f9170fh;
        if (fbVar != null) {
            if (i == this.f9167d) {
                return true;
            }
            if (i == this.f9169ej && fbVar.y()) {
                fbVar.n3();
                this.f9167d = this.f9169ej;
                this.f9169ej = i;
                return true;
            }
            zn2 = this.f9167d;
            fbVar.gv();
        } else {
            zn2 = zn();
        }
        this.f9170fh = null;
        this.f9169ej = -1;
        this.f9167d = -1;
        zn znVar = this.f9168d0;
        int ta2 = znVar.ta(zn2);
        int ta3 = znVar.ta(i);
        if (ta3 == 0 || ta2 == 0 || (z62 = znVar.z6(ta2, ta3)) < 0) {
            return false;
        }
        boolean ud2 = znVar.ud(ta2, ta3);
        fb(z62);
        Drawable current = getCurrent();
        if (current instanceof AnimationDrawable) {
            n3Var = new v((AnimationDrawable) current, znVar.ej(ta2, ta3), ud2);
        } else if (current instanceof o0.zn) {
            n3Var = new gv((o0.zn) current);
        } else {
            if (current instanceof Animatable) {
                n3Var = new n3((Animatable) current);
            }
            return false;
        }
        n3Var.zn();
        this.f9170fh = n3Var;
        this.f9169ej = zn2;
        this.f9167d = i;
        return true;
    }

    @Override // i9.n3, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
    }

    @Override // i9.n3, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // i9.n3, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    @Override // i9.n3, android.graphics.drawable.Drawable
    @NonNull
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // i9.n3, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getHotspotBounds(@NonNull Rect rect) {
        super.getHotspotBounds(rect);
    }

    @Override // i9.n3, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }

    @Override // i9.n3, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
        return super.getIntrinsicWidth();
    }

    @Override // i9.n3, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // i9.n3, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // i9.n3, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // i9.n3, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getOutline(@NonNull Outline outline) {
        super.getOutline(outline);
    }

    @Override // i9.n3, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(@NonNull Rect rect) {
        return super.getPadding(rect);
    }

    @Override // i9.n3, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void invalidateDrawable(@NonNull Drawable drawable) {
        super.invalidateDrawable(drawable);
    }

    @Override // i9.n3, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    @Override // i9.gv, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // i9.n3, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        fb fbVar = this.f9170fh;
        if (fbVar != null) {
            fbVar.gv();
            this.f9170fh = null;
            fb(this.f9167d);
            this.f9167d = -1;
            this.f9169ej = -1;
        }
    }

    public final int mt(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable;
        int next;
        TypedArray f4 = f.f(resources, theme, attributeSet, R$styleable.f1038f);
        int resourceId = f4.getResourceId(R$styleable.f1051wz, -1);
        int resourceId2 = f4.getResourceId(R$styleable.f1048tl, -1);
        int resourceId3 = f4.getResourceId(R$styleable.f1047t, -1);
        if (resourceId3 > 0) {
            drawable = z6.s().i9(context, resourceId3);
        } else {
            drawable = null;
        }
        boolean z2 = f4.getBoolean(R$styleable.f1053xc, false);
        f4.recycle();
        if (drawable == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next == 2) {
                if (xmlPullParser.getName().equals("animated-vector")) {
                    drawable = o0.zn.y(context, resources, xmlPullParser, attributeSet, theme);
                } else {
                    drawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                }
            } else {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
        }
        if (drawable != null) {
            if (resourceId != -1 && resourceId2 != -1) {
                return this.f9168d0.rz(resourceId, resourceId2, drawable, z2);
            }
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
    }

    @Override // i9.gv, i9.n3, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f9171x && super.mutate() == this) {
            this.f9168d0.mt();
            this.f9171x = true;
        }
        return this;
    }

    @Override // i9.n3, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean onLayoutDirectionChanged(int i) {
        return super.onLayoutDirectionChanged(i);
    }

    @Override // i9.gv, i9.n3, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z2;
        int d2 = this.f9168d0.d(iArr);
        if (d2 != zn() && (co(d2) || fb(d2))) {
            z2 = true;
        } else {
            z2 = false;
        }
        Drawable current = getCurrent();
        if (current != null) {
            return z2 | current.setState(iArr);
        }
        return z2;
    }

    public final int p(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable;
        int next;
        TypedArray f4 = f.f(resources, theme, attributeSet, R$styleable.f1046s);
        int resourceId = f4.getResourceId(R$styleable.f1036c5, 0);
        int resourceId2 = f4.getResourceId(R$styleable.f1041i9, -1);
        if (resourceId2 > 0) {
            drawable = z6.s().i9(context, resourceId2);
        } else {
            drawable = null;
        }
        f4.recycle();
        int[] f6 = f(attributeSet);
        if (drawable == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next == 2) {
                if (xmlPullParser.getName().equals("vector")) {
                    drawable = s.zn(resources, xmlPullParser, attributeSet, theme);
                } else {
                    drawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                }
            } else {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
        }
        if (drawable != null) {
            return this.f9168d0.fh(f6, drawable, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    }

    @Override // i9.gv, i9.n3
    public void s(@NonNull n3.gv gvVar) {
        super.s(gvVar);
        if (gvVar instanceof zn) {
            this.f9168d0 = (zn) gvVar;
        }
    }

    @Override // i9.n3, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j2) {
        super.scheduleDrawable(drawable, runnable, j2);
    }

    @Override // i9.n3, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    @Override // i9.n3, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z2) {
        super.setAutoMirrored(z2);
    }

    @Override // i9.n3, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // i9.n3, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setDither(boolean z2) {
        super.setDither(z2);
    }

    @Override // i9.n3, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f4, float f6) {
        super.setHotspot(f4, f6);
    }

    @Override // i9.n3, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i5, int i6, int i8) {
        super.setHotspotBounds(i, i5, i6, i8);
    }

    @Override // i9.n3, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
    }

    @Override // i9.n3, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setTintMode(@NonNull PorterDuff.Mode mode) {
        super.setTintMode(mode);
    }

    @Override // i9.n3, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        boolean visible = super.setVisible(z2, z3);
        fb fbVar = this.f9170fh;
        if (fbVar != null && (visible || z3)) {
            if (z2) {
                fbVar.zn();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    @Override // i9.gv, i9.n3
    /* renamed from: t */
    public zn n3() {
        return new zn(this.f9168d0, this, null);
    }

    @Override // i9.n3, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        super.unscheduleDrawable(drawable, runnable);
    }

    public final void w() {
        onStateChange(getState());
    }

    public void wz(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray f4 = f.f(resources, theme, attributeSet, R$styleable.y);
        setVisible(f4.getBoolean(R$styleable.f1055zn, true), true);
        z(f4);
        c5(resources);
        f4.recycle();
        xc(context, resources, xmlPullParser, attributeSet, theme);
        w();
    }

    public final void xc(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 >= depth || next != 3) {
                    if (next == 2 && depth2 <= depth) {
                        if (xmlPullParser.getName().equals("item")) {
                            p(context, resources, xmlPullParser, attributeSet, theme);
                        } else if (xmlPullParser.getName().equals("transition")) {
                            mt(context, resources, xmlPullParser, attributeSet, theme);
                        }
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final void z(TypedArray typedArray) {
        zn znVar = this.f9168d0;
        znVar.f9144gv |= typedArray.getChangingConfigurations();
        znVar.f3(typedArray.getBoolean(R$styleable.f1040gv, znVar.f9135c5));
        znVar.z(typedArray.getBoolean(R$styleable.f1049v, znVar.f9155t));
        znVar.r(typedArray.getInt(R$styleable.f1035a, znVar.f9138d0));
        znVar.x4(typedArray.getInt(R$styleable.f1039fb, znVar.f9143fh));
        setDither(typedArray.getBoolean(R$styleable.f1043n3, znVar.f9141f3));
    }

    public y(@Nullable zn znVar, @Nullable Resources resources) {
        super(null);
        this.f9167d = -1;
        this.f9169ej = -1;
        s(new zn(znVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    /* loaded from: classes.dex */
    public static abstract class fb {
        public fb() {
        }

        public abstract void gv();

        public boolean y() {
            return false;
        }

        public abstract void zn();

        public void n3() {
        }
    }
}
