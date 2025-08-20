package z6;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d.v;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;
import k5.fb;
/* loaded from: classes.dex */
public class fb extends v {

    /* renamed from: c5  reason: collision with root package name */
    public final Method f15654c5;

    /* renamed from: f  reason: collision with root package name */
    public final Method f15655f;

    /* renamed from: fb  reason: collision with root package name */
    public final Class<?> f15656fb;

    /* renamed from: i9  reason: collision with root package name */
    public final Method f15657i9;

    /* renamed from: s  reason: collision with root package name */
    public final Constructor<?> f15658s;

    /* renamed from: t  reason: collision with root package name */
    public final Method f15659t;

    /* renamed from: tl  reason: collision with root package name */
    public final Method f15660tl;

    public fb() {
        Class<?> cls;
        Constructor<?> constructor;
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        try {
            cls = x4();
            constructor = i4(cls);
            method = co(cls);
            method2 = z(cls);
            method3 = f3(cls);
            method4 = mt(cls);
            method5 = r(cls);
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e2.getClass().getName(), e2);
            cls = null;
            constructor = null;
            method = null;
            method2 = null;
            method3 = null;
            method4 = null;
            method5 = null;
        }
        this.f15656fb = cls;
        this.f15658s = constructor;
        this.f15654c5 = method;
        this.f15657i9 = method2;
        this.f15655f = method3;
        this.f15659t = method4;
        this.f15660tl = method5;
    }

    @Nullable
    public Typeface c5(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f15656fb, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.f15660tl.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public Method co(Class<?> cls) throws NoSuchMethodException {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    public Method f3(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("freeze", null);
    }

    @Override // z6.i9
    @Nullable
    public Typeface gv(Context context, Resources resources, int i, String str, int i5) {
        if (!p()) {
            return super.gv(context, resources, i, str, i5);
        }
        Object t2 = t();
        if (t2 == null) {
            return null;
        }
        if (!wz(context, t2, str, 0, -1, -1, null)) {
            tl(t2);
            return null;
        } else if (!w(t2)) {
            return null;
        } else {
            return c5(t2);
        }
    }

    public Constructor<?> i4(Class<?> cls) throws NoSuchMethodException {
        return cls.getConstructor(null);
    }

    public Method mt(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("abortCreation", null);
    }

    @Override // z6.v, z6.i9
    @Nullable
    public Typeface n3(Context context, @Nullable CancellationSignal cancellationSignal, @NonNull fb.n3[] n3VarArr, int i) {
        Typeface c52;
        if (n3VarArr.length < 1) {
            return null;
        }
        if (!p()) {
            fb.n3 fb2 = fb(n3VarArr, i);
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(fb2.gv(), "r", cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(fb2.v()).setItalic(fb2.a()).build();
                openFileDescriptor.close();
                return build;
            } catch (IOException unused) {
                return null;
            }
        }
        Map<Uri, ByteBuffer> s2 = f.s(context, n3VarArr, cancellationSignal);
        Object t2 = t();
        if (t2 == null) {
            return null;
        }
        boolean z2 = false;
        for (fb.n3 n3Var : n3VarArr) {
            ByteBuffer byteBuffer = s2.get(n3Var.gv());
            if (byteBuffer != null) {
                if (!xc(t2, byteBuffer, n3Var.zn(), n3Var.v(), n3Var.a() ? 1 : 0)) {
                    tl(t2);
                    return null;
                }
                z2 = true;
            }
        }
        if (!z2) {
            tl(t2);
            return null;
        } else if (!w(t2) || (c52 = c5(t2)) == null) {
            return null;
        } else {
            return Typeface.create(c52, i);
        }
    }

    public final boolean p() {
        if (this.f15654c5 == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (this.f15654c5 != null) {
            return true;
        }
        return false;
    }

    public Method r(Class<?> cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    @Nullable
    public final Object t() {
        try {
            return this.f15658s.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    public final void tl(Object obj) {
        try {
            this.f15659t.invoke(obj, null);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    public final boolean w(Object obj) {
        try {
            return ((Boolean) this.f15655f.invoke(obj, null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean wz(Context context, Object obj, String str, int i, int i5, int i6, @Nullable FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f15654c5.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i), Integer.valueOf(i5), Integer.valueOf(i6), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Class<?> x4() throws ClassNotFoundException {
        return Class.forName("android.graphics.FontFamily");
    }

    public final boolean xc(Object obj, ByteBuffer byteBuffer, int i, int i5, int i6) {
        try {
            return ((Boolean) this.f15657i9.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i5), Integer.valueOf(i6))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    @Override // z6.v, z6.i9
    @Nullable
    public Typeface y(Context context, v.zn znVar, Resources resources, int i) {
        v.gv[] y;
        if (!p()) {
            return super.y(context, znVar, resources, i);
        }
        Object t2 = t();
        if (t2 == null) {
            return null;
        }
        for (v.gv gvVar : znVar.y()) {
            if (!wz(context, t2, gvVar.y(), gvVar.zn(), gvVar.v(), gvVar.a() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(gvVar.gv()))) {
                tl(t2);
                return null;
            }
        }
        if (!w(t2)) {
            return null;
        }
        return c5(t2);
    }

    public Method z(Class<?> cls) throws NoSuchMethodException {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
    }
}
