package wz;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.resources.R$drawable;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public final class z6 {

    /* renamed from: c5  reason: collision with root package name */
    public static z6 f14872c5;

    /* renamed from: a  reason: collision with root package name */
    public boolean f14875a;

    /* renamed from: fb  reason: collision with root package name */
    public a f14876fb;

    /* renamed from: gv  reason: collision with root package name */
    public final WeakHashMap<Context, z.v<WeakReference<Drawable.ConstantState>>> f14877gv = new WeakHashMap<>(0);

    /* renamed from: n3  reason: collision with root package name */
    public z.s<String, v> f14878n3;

    /* renamed from: v  reason: collision with root package name */
    public TypedValue f14879v;
    public WeakHashMap<Context, z.c5<ColorStateList>> y;

    /* renamed from: zn  reason: collision with root package name */
    public z.c5<String> f14880zn;

    /* renamed from: s  reason: collision with root package name */
    public static final PorterDuff.Mode f14874s = PorterDuff.Mode.SRC_IN;

    /* renamed from: i9  reason: collision with root package name */
    public static final zn f14873i9 = new zn(6);

    /* loaded from: classes.dex */
    public interface a {
        @Nullable
        PorterDuff.Mode gv(int i);

        @Nullable
        Drawable n3(@NonNull z6 z6Var, @NonNull Context context, int i);

        boolean v(@NonNull Context context, int i, @NonNull Drawable drawable);

        @Nullable
        ColorStateList y(@NonNull Context context, int i);

        boolean zn(@NonNull Context context, int i, @NonNull Drawable drawable);
    }

    /* loaded from: classes.dex */
    public static class fb implements v {
        @Override // wz.z6.v
        public Drawable y(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
            try {
                return o0.s.zn(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e2);
                return null;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class gv implements v {
        @Override // wz.z6.v
        public Drawable y(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
            String classAttribute = attributeSet.getClassAttribute();
            if (classAttribute != null) {
                try {
                    Drawable drawable = (Drawable) gv.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor(null).newInstance(null);
                    drawable.inflate(context.getResources(), xmlPullParser, attributeSet, theme);
                    return drawable;
                } catch (Exception e2) {
                    Log.e("DrawableDelegate", "Exception while inflating <drawable>", e2);
                }
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static class n3 implements v {
        @Override // wz.z6.v
        public Drawable y(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
            try {
                return o0.zn.y(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e2);
                return null;
            }
        }
    }

    /* loaded from: classes.dex */
    public interface v {
        Drawable y(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme);
    }

    /* loaded from: classes.dex */
    public static class y implements v {
        @Override // wz.z6.v
        public Drawable y(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
            try {
                return i9.y.tl(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e2);
                return null;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class zn extends z.a<Integer, PorterDuffColorFilter> {
        public zn(int i) {
            super(i);
        }

        public static int y(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }

        public PorterDuffColorFilter n3(int i, PorterDuff.Mode mode) {
            return get(Integer.valueOf(y(i, mode)));
        }

        public PorterDuffColorFilter zn(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return put(Integer.valueOf(y(i, mode)), porterDuffColorFilter);
        }
    }

    public static PorterDuffColorFilter fb(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList != null && mode != null) {
            return t(colorStateList.getColorForState(iArr, 0), mode);
        }
        return null;
    }

    public static void i4(Drawable drawable, yt ytVar, int[] iArr) {
        ColorStateList colorStateList;
        PorterDuff.Mode mode;
        if (n.y(drawable) && drawable.mutate() != drawable) {
            return;
        }
        boolean z2 = ytVar.f14851gv;
        if (!z2 && !ytVar.f14853zn) {
            drawable.clearColorFilter();
        } else {
            if (z2) {
                colorStateList = ytVar.y;
            } else {
                colorStateList = null;
            }
            if (ytVar.f14853zn) {
                mode = ytVar.f14852n3;
            } else {
                mode = f14874s;
            }
            drawable.setColorFilter(fb(colorStateList, mode, iArr));
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    public static boolean p(@NonNull Drawable drawable) {
        if (!(drawable instanceof o0.s) && !"android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            return false;
        }
        return true;
    }

    public static synchronized z6 s() {
        z6 z6Var;
        synchronized (z6.class) {
            try {
                if (f14872c5 == null) {
                    z6 z6Var2 = new z6();
                    f14872c5 = z6Var2;
                    w(z6Var2);
                }
                z6Var = f14872c5;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z6Var;
    }

    public static synchronized PorterDuffColorFilter t(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter n32;
        synchronized (z6.class) {
            zn znVar = f14873i9;
            n32 = znVar.n3(i, mode);
            if (n32 == null) {
                n32 = new PorterDuffColorFilter(i, mode);
                znVar.zn(i, mode, n32);
            }
        }
        return n32;
    }

    public static long v(TypedValue typedValue) {
        return (typedValue.assetCookie << 32) | typedValue.data;
    }

    public static void w(@NonNull z6 z6Var) {
        if (Build.VERSION.SDK_INT < 24) {
            z6Var.y("vector", new fb());
            z6Var.y("animated-vector", new n3());
            z6Var.y("animated-selector", new y());
            z6Var.y("drawable", new gv());
        }
    }

    public final Drawable a(@NonNull Context context, int i) {
        Drawable n32;
        if (this.f14879v == null) {
            this.f14879v = new TypedValue();
        }
        TypedValue typedValue = this.f14879v;
        context.getResources().getValue(i, typedValue, true);
        long v2 = v(typedValue);
        Drawable c52 = c5(context, v2);
        if (c52 != null) {
            return c52;
        }
        a aVar = this.f14876fb;
        if (aVar == null) {
            n32 = null;
        } else {
            n32 = aVar.n3(this, context, i);
        }
        if (n32 != null) {
            n32.setChangingConfigurations(typedValue.changingConfigurations);
            n3(context, v2, n32);
        }
        return n32;
    }

    public final synchronized Drawable c5(@NonNull Context context, long j2) {
        z.v<WeakReference<Drawable.ConstantState>> vVar = this.f14877gv.get(context);
        if (vVar == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> s2 = vVar.s(j2);
        if (s2 != null) {
            Drawable.ConstantState constantState = s2.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            vVar.wz(j2);
        }
        return null;
    }

    public synchronized void co(@NonNull Context context) {
        z.v<WeakReference<Drawable.ConstantState>> vVar = this.f14877gv.get(context);
        if (vVar != null) {
            vVar.zn();
        }
    }

    public synchronized Drawable f(@NonNull Context context, int i, boolean z2) {
        Drawable mt2;
        try {
            gv(context);
            mt2 = mt(context, i);
            if (mt2 == null) {
                mt2 = a(context, i);
            }
            if (mt2 == null) {
                mt2 = mg.y.v(context, i);
            }
            if (mt2 != null) {
                mt2 = x4(context, i, z2, mt2);
            }
            if (mt2 != null) {
                n.n3(mt2);
            }
        } catch (Throwable th) {
            throw th;
        }
        return mt2;
    }

    public boolean f3(@NonNull Context context, int i, @NonNull Drawable drawable) {
        a aVar = this.f14876fb;
        if (aVar != null && aVar.zn(context, i, drawable)) {
            return true;
        }
        return false;
    }

    public final void gv(@NonNull Context context) {
        if (this.f14875a) {
            return;
        }
        this.f14875a = true;
        Drawable i92 = i9(context, R$drawable.y);
        if (i92 != null && p(i92)) {
            return;
        }
        this.f14875a = false;
        throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
    }

    public synchronized Drawable i9(@NonNull Context context, int i) {
        return f(context, i, false);
    }

    public final Drawable mt(@NonNull Context context, int i) {
        int next;
        z.s<String, v> sVar = this.f14878n3;
        if (sVar == null || sVar.isEmpty()) {
            return null;
        }
        z.c5<String> c5Var = this.f14880zn;
        if (c5Var != null) {
            String fb2 = c5Var.fb(i);
            if ("appcompat_skip_skip".equals(fb2) || (fb2 != null && this.f14878n3.get(fb2) == null)) {
                return null;
            }
        } else {
            this.f14880zn = new z.c5<>();
        }
        if (this.f14879v == null) {
            this.f14879v = new TypedValue();
        }
        TypedValue typedValue = this.f14879v;
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        long v2 = v(typedValue);
        Drawable c52 = c5(context, v2);
        if (c52 != null) {
            return c52;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                while (true) {
                    next = xml.next();
                    if (next == 2 || next == 1) {
                        break;
                    }
                }
                if (next == 2) {
                    String name = xml.getName();
                    this.f14880zn.n3(i, name);
                    v vVar = this.f14878n3.get(name);
                    if (vVar != null) {
                        c52 = vVar.y(context, xml, asAttributeSet, context.getTheme());
                    }
                    if (c52 != null) {
                        c52.setChangingConfigurations(typedValue.changingConfigurations);
                        n3(context, v2, c52);
                    }
                } else {
                    throw new XmlPullParserException("No start tag found");
                }
            } catch (Exception e2) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e2);
            }
        }
        if (c52 == null) {
            this.f14880zn.n3(i, "appcompat_skip_skip");
        }
        return c52;
    }

    public final synchronized boolean n3(@NonNull Context context, long j2, @NonNull Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                z.v<WeakReference<Drawable.ConstantState>> vVar = this.f14877gv.get(context);
                if (vVar == null) {
                    vVar = new z.v<>();
                    this.f14877gv.put(context, vVar);
                }
                vVar.tl(j2, new WeakReference<>(constantState));
                return true;
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void r(a aVar) {
        this.f14876fb = aVar;
    }

    public synchronized ColorStateList tl(@NonNull Context context, int i) {
        ColorStateList wz2;
        wz2 = wz(context, i);
        if (wz2 == null) {
            a aVar = this.f14876fb;
            if (aVar == null) {
                wz2 = null;
            } else {
                wz2 = aVar.y(context, i);
            }
            if (wz2 != null) {
                zn(context, i, wz2);
            }
        }
        return wz2;
    }

    public final ColorStateList wz(@NonNull Context context, int i) {
        z.c5<ColorStateList> c5Var;
        WeakHashMap<Context, z.c5<ColorStateList>> weakHashMap = this.y;
        if (weakHashMap == null || (c5Var = weakHashMap.get(context)) == null) {
            return null;
        }
        return c5Var.fb(i);
    }

    public final Drawable x4(@NonNull Context context, int i, boolean z2, @NonNull Drawable drawable) {
        ColorStateList tl2 = tl(context, i);
        if (tl2 != null) {
            if (n.y(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable mt2 = ej.y.mt(drawable);
            ej.y.xc(mt2, tl2);
            PorterDuff.Mode xc2 = xc(i);
            if (xc2 != null) {
                ej.y.w(mt2, xc2);
                return mt2;
            }
            return mt2;
        }
        a aVar = this.f14876fb;
        if ((aVar == null || !aVar.v(context, i, drawable)) && !f3(context, i, drawable) && z2) {
            return null;
        }
        return drawable;
    }

    public PorterDuff.Mode xc(int i) {
        a aVar = this.f14876fb;
        if (aVar == null) {
            return null;
        }
        return aVar.gv(i);
    }

    public final void y(@NonNull String str, @NonNull v vVar) {
        if (this.f14878n3 == null) {
            this.f14878n3 = new z.s<>();
        }
        this.f14878n3.put(str, vVar);
    }

    public synchronized Drawable z(@NonNull Context context, @NonNull j jVar, int i) {
        try {
            Drawable mt2 = mt(context, i);
            if (mt2 == null) {
                mt2 = jVar.zn(i);
            }
            if (mt2 != null) {
                return x4(context, i, false, mt2);
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void zn(@NonNull Context context, int i, @NonNull ColorStateList colorStateList) {
        if (this.y == null) {
            this.y = new WeakHashMap<>();
        }
        z.c5<ColorStateList> c5Var = this.y.get(context);
        if (c5Var == null) {
            c5Var = new z.c5<>();
            this.y.put(context, c5Var);
        }
        c5Var.n3(i, colorStateList);
    }
}
